pipeline {

  agent any

  environment {
    APP_NAME      = "kundli-service"
    IMAGE_REPO    = "sheknar83/my-app"
    GITOPS_REPO   = "https://github.com/your-org/gitops-repo.git"
    GITOPS_BRANCH = "main"
    ENV           = "dev"
    SONAR_PROJECT = "kundli-service"
  }

  options {
    timestamps()
    disableConcurrentBuilds()
  }

  stages {

    stage('Checkout Source') {
      steps {
        checkout scm
      }
    }

    stage('Build & Unit Test') {
      steps {
        sh 'mvn clean verify'
      }
    }

    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv('sonarqube-server') {
          sh """
            mvn sonar:sonar \
              -Dsonar.projectKey=${SONAR_PROJECT} \
              -Dsonar.projectName=${SONAR_PROJECT}
          """
        }
      }
    }

    stage('Quality Gate') {
      steps {
        timeout(time: 2, unit: 'MINUTES') {
          waitForQualityGate abortPipeline: true
        }
      }
    }

    stage('Build & Push Image (Jib)') {
      steps {
        withCredentials([usernamePassword(
            credentialsId: 'dockerhub-creds',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
          sh """
            mvn compile jib:build \
              -Djib.to.image=${IMAGE_REPO} \
              -Djib.to.auth.username=${DOCKER_USER} \
              -Djib.to.auth.password=${DOCKER_PASS} \
              -Djib.to.tags=${BUILD_NUMBER},${GIT_COMMIT}
          """
        }
      }
    }

    stage('Trivy Image Scan') {
      steps {
        sh """
          trivy image --exit-code 1 --severity HIGH,CRITICAL \
          ${IMAGE_REPO}:${BUILD_NUMBER}
        """
      }
    }

    stage('Update GitOps Repo') {
      steps {
        withCredentials([string(credentialsId: 'git-token', variable: 'GIT_TOKEN')]) {
          sh """
            rm -rf gitops
            git clone ${GITOPS_REPO} gitops
            cd gitops

            git config --global url."https://${GIT_TOKEN}@github.com/".insteadOf "https://github.com/"

            sed -i 's/tag:.*/tag: "${BUILD_NUMBER}"/' helm/kundli-service/values-${ENV}.yaml

            if [ -z "\$(git status --porcelain)" ]; then
              echo "No GitOps changes detected"
              exit 0
            fi

            git config user.email "jenkins@company.com"
            git config user.name "jenkins"

            git add .
            git commit -m "Update ${APP_NAME} image to ${BUILD_NUMBER}"
            git push origin ${GITOPS_BRANCH}
          """
        }
      }
    }
  }

  post {
    success {
      echo "✅ CI pipeline completed successfully"
      slackSend channel: '#ci-cd',
                message: "✅ ${APP_NAME} build #${BUILD_NUMBER} SUCCESS"
    }
    failure {
      echo "❌ CI pipeline failed"
      slackSend channel: '#ci-cd',
                message: "❌ ${APP_NAME} build #${BUILD_NUMBER} FAILED"
    }
  }
}

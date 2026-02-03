pipeline {

  agent any

  environment {
    APP_NAME      = "order-service"
    IMAGE_REPO    = "myrepo/order-service"
    GITOPS_REPO   = "https://github.com/your-org/gitops-repo.git"
    GITOPS_BRANCH = "main"
    ENV           = "dev"
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

    stage('Unit Tests') {
      steps {
        sh 'mvn clean test'
      }
    }

    stage('Build JAR') {
      steps {
        sh 'mvn clean package -DskipTests'
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
              -Djib.to.tags=${BUILD_NUMBER}
          """
        }
      }
    }

    stage('Update GitOps Repo') {
      steps {
        withCredentials([string(credentialsId: 'git-token', variable: 'GIT_TOKEN')]) {
          sh """
            rm -rf gitops
            git clone https://${GIT_TOKEN}@github.com/your-org/gitops-repo.git gitops
            cd gitops

            sed -i 's/tag:.*/tag: "${BUILD_NUMBER}"/' helm/order-service/values-${ENV}.yaml

            git config user.email "jenkins@company.com"
            git config user.name "jenkins"

            git commit -am "Update ${APP_NAME} image to ${BUILD_NUMBER}"
            git push origin ${GITOPS_BRANCH}
          """
        }
      }
    }
  }

  post {
    success {
      echo "✅ CI pipeline completed successfully"
    }
    failure {
      echo "❌ CI pipeline failed"
    }
  }
}

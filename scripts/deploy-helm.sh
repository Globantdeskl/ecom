#!/bin/bash

# Script deploy helm chart
#Prerequisite: you need to have authenticated to kubernetes cluster.
#For GKE use gcloud container clusters get-credentials <cluster-name> --region <region> --project <project>
# Usage: ./deploy-helm.sh --namespace=<NS> --app=APP> --env=<ENV> --tag=<TAG> (--atomic) (--dry-run) (--timeout 120s)
# Example: ./deploy-helm-ci.sh --namespace=qa --app=fulfillment-bridge --env=qa --tag=0.0.1-SNAPSHOT --atomic

set -o pipefail

usage(){
	echo "
Prerequisite: you need to have authenticated to kubernetes cluster.
For GKE use gcloud container clusters get-credentials <cluster-name> --region <region> --project <project>
Usage: $0 --namespace=<NS> --app=<APP> --env=<ENV> --tag=<TAG> (--atomic) (--dry-run) (--timeout 120s)
Example: ./deploy-helm.sh --namespace=qa --app=fulfillment-bridge --env=qa --tag=0.0.1-SNAPSHOT --atomic
Available applications:

$AVAILABLE_HELMS
"
	exit 1
}
HELM_BASE_LOCATION="./kubernetes/helm"
AVAILABLE_HELMS=$(find $HELM_BASE_LOCATION -type d -maxdepth 1 -exec basename {} \; | grep -v 'helm') || echo "Using $CI_HELM_BASE_LOCATION as HELM_BASE_LOCATION"
while [ "$#" -gt 0 ]; do
  case "$1" in
    --namespace=*) NS="${1#*=}"; shift 1;;
    --app=*) APP="${1#*=}"; shift 1;;
    --env=*) ENV="${1#*=}"; shift 1;;
    --tag=*) TAG="${1#*=}"; shift 1;;
    --kube-context=*) CONTEXT="${1#*=}"; shift 1;;
    --timeout=*) TIMEOUT=${"--timeout ${1#*=}"}; shift 1;;
    --wait) WAIT="--wait"; shift 1;;
    --atomic) ATOMIC="--atomic"; shift 1;;
    --dry-run) DRY_RUN="true"; shift 1;;
    --namespace|--app|--env|--tag|--timeout) echo "$1 requires an argument" >&2; exit 1;;
    *) echo "unknown option: $1" >&2; exit 1;;
  esac
done

[[ -z "${NS}" ]] && { echo "APP was not specified" >&2; usage && exit 1; }
[[ -z "${APP}" ]] && { echo "APP was not specified" >&2; usage && exit 1; }
[[ -z "${ENV}" ]] && { echo "ENV was not specified" >&2; usage && exit 1; }
[[ -z "${TAG}" ]] && { echo "TAG was not specified" >&2; usage && exit 1; }

# case $ENV in
#         qa|dev|sit|perf|prod)
#                 echo "Going to deploy $ENV env"
#                 ;;
#         *)
#                 echo "Invalid ENV. Available options: qa, dev, sit, perf, prod" >&2
#                 exit 1
#                 ;;
# esac

KUBECTL_BIN=$(which kubectl) || CI_KUBECTL_BIN="/usr/local/bin/kubectl"
HELM_BIN=$(which helm) || CI_HELM_BIN="/usr/local/bin/helm"

CI_HELM_BASE_LOCATION="."
ENVCONFIGS_BASE_LOCATION="./kubernetes/envconfigs/${APP}"
CI_ENVCONFIGS_BASE_LOCATION="./envconfigs"
TIMEOUT="--timeout 300s"
HELM_RELEASE="$APP-$ENV"
PATH=$PATH:/usr/local/bin
export PATH

if [[ ! -f "${KUBECTL_BIN}" ]]; then
        if [ -f "${CI_KUBECTL_BIN}" ]; then
                KUBECTL_BIN="${CI_KUBECTL_BIN}"
        else
                echo "kubectl binary was not found" >&2
                exit 1
        fi
fi

if [[ ! -f "${HELM_BIN}" ]]; then
        if [ -f "${CI_HELM_BIN}" ]; then
                HELM_BIN="${CI_HELM_BIN}"
        else
                echo "helm binary was not found" >&2
                exit 1
        fi
fi

if [[ ! -d "${HELM_BASE_LOCATION}/${APP}" ]]; then
        if [ -d "${CI_HELM_BASE_LOCATION}/${APP}" ]; then
                HELM_BASE_LOCATION="${CI_HELM_BASE_LOCATION}"
        else
                echo "helm location was not found" >&2
                exit 1
        fi
fi

if [[ ! -d "${ENVCONFIGS_BASE_LOCATION}" ]]; then
        if [ -d "${CI_ENVCONFIGS_BASE_LOCATION}" ]; then
                ENVCONFIGS_BASE_LOCATION="${CI_ENVCONFIGS_BASE_LOCATION}"
        else
                echo "envconfigs location was not found" >&2
                exit 1
        fi
fi

HELM_LOCATION="$HELM_BASE_LOCATION/${APP}"
VALUE_FILE_LOCATION="${ENVCONFIGS_BASE_LOCATION}/${ENV}.yaml"

# if [ -n "${ATOMIC}" ]; then
#                 ATOMIC="--atomic"
#        else
#                 WAIT="--wait"
# fi

if [[ ${DRY_RUN} == 'true' ]]; then
    ${HELM_BIN} template --namespace=${NS} ${HELM_RELEASE} ${HELM_LOCATION} -f ${VALUE_FILE_LOCATION} --set image.tag=${TAG}
else
    echo "About to execute:"
    echo "${HELM_BIN} upgrade --install --namespace=${NS} ${HELM_RELEASE} ${HELM_LOCATION} -f ${VALUE_FILE_LOCATION} --set image.tag=${TAG} --set env=${ENV} --kube-context=${CONTEXT} ${ATOMIC} ${WAIT} ${TIMEOUT}"
    helm upgrade --install --namespace=${NS} ${HELM_RELEASE} ${HELM_LOCATION} -f ${VALUE_FILE_LOCATION} --set image.tag=${TAG} --set env=${ENV} --kube-context=${CONTEXT} ${ATOMIC} ${WAIT} ${TIMEOUT}
    if [ "$?" -ne 0 ]; then
        if [ -n "${ATOMIC}" ]; then
                helm history -n ${NS} ${HELM_RELEASE} | tail -2
                echo "Update failed, check the Rollback status above"
                exit 1
        else
                echo "DEPLOYMENT STATUS"
                ${KUBECTL_BIN} describe deployment ${HELM_RELEASE} -n ${NS}
                RECENTLY_CREATED_POD=`${KUBECTL_BIN} get pods --sort-by=.metadata.creationTimestamp -n ${NS} -o jsonpath='{.items[-1].metadata.name}' -l=app=$APP`
                echo "APPLICATION LOGS"
                ${KUBECTL_BIN} logs ${RECENTLY_CREATED_POD} -n ${NS}
                ${KUBECTL_BIN} logs ${RECENTLY_CREATED_POD} -n ${NS} -c ${APP}
                exit 1
        fi
    fi
fi

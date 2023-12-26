#!/bin/bash

# Script to rollback helm chart
#Prerequisite: you need to have authenticated to kubernetes cluster.
#For GKE use gcloud container clusters get-credentials <cluster-name> --region <region> --project <project>
# Usage: ./deploy-helm.sh <APP> <ENV> <TAG>
# Example: ./deploy-helm.sh fulfillment-dlq-reprocessor qa 0.0.1-SNAPSHOT

set -eo pipefail
usage(){
	echo "
Prerequisite: you need to have authenticated to kubernetes cluster.
For GKE use gcloud container clusters get-credentials <cluster-name> --region <region> --project <project>
Usage: $0 <APP> <ENV>
Example: ./rollback-helm.sh fulfillment-dlq-reprocessor qa"
	exit 1
}

DIRECTORY=$(dirname $0)
cd $DIRECTORY

test -n "${1}" && APP="${1}"
test -n "${2}" && ENV="${2}"
[[ "${APP}" == "" ]] && { echo "APP was not specified" >&2; usage && exit 1; }
[[ "${ENV}" == "" ]] && { echo "ENV was not specified" >&2; usage && exit 1; }

case $ENV in
        qa)
                echo "Going to deploy QA env"
                ;;
        dev)
                echo "Going to deploy DEV env"
                ;;
        *)
                echo "Invalid ENV. Available options: qa, dev" >&2
                exit 1
                ;;
esac

HELM_RELEASE="$APP-$ENV"

echo "About to execute:"
echo "helm rollback --namespace=${ENV} ${HELM_RELEASE}"
helm rollback --namespace=${ENV} ${HELM_RELEASE}

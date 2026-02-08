#!/bin/bash
# Script to provision routing for Cloud Environments. Ignores routings and mappings that already exist within the environments

if [[ -z "$1" ]] || [[ -z "$2" ]]; then
   echo "Empty passed variables environment:$1 app_name:$2"
   exit 1
fi

environment=$1
app_name=$2

# source this app's network policy functions
source ./$app_name-policies.sh $environment

echo "targeting $environment"
cf target -s $environment

echo "deleting orphan routes $environment"
cf delete-orphaned-routes -f

exit

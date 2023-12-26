#!/bin/bash
# Script to provision routing for Cloud Environments. Ignores routings and mappings that already exist within the environments

if [[ -z "$1" ]]; then
   echo "Empty passed variables environment:$1"
   exit 1
fi

public_domain=dummy
private_domain=apps.internal
ordereditor_app=pcs-order-editor
fulfillment_org=ecomm-services
checkout_org=checkout-services

if [ $1 = "dev" -o $1 = "qa" -o $1 = "sit" ]
then
    public_domain=apps.non-prod.ae-cf.io
elif [ $1 = "perf" -o $1 = "prod" ]
then
    public_domain=apps.gcp-prod.ae-cf.io
else
    echo "$1 is not a known env, failing script"
    exit 2
fi
echo "public domain for $1: $public_domain"

routing_dev_qa_sit_perf() {

	local new_app_name=$2
   	local app_name=$3
   	local hostname=$4
	
	echo "Begin $1 routing for $new_app_name"
	
   cf map-route $new_app_name $public_domain --hostname $hostname
   cf map-route $new_app_name $private_domain --hostname $hostname
   echo "mapped $new_app_name app to $hostname host, traffic from pcs-order-editor app should go to $new_app_name app"
   cf unmap-route $app_name $private_domain --hostname $hostname
   cf unmap-route $app_name $public_domain --hostname $hostname
   echo "un-mapped $app_name app from $hostname, traffic from pcs-order-editor app should not go to $app_name app"
	
	echo "Completed $1 routing for $new_app_name"
}

network_dev_qa_sit_perf() {

   	local $new_app_name=$2
   	local $app_name=$3

	echo "Creating network policy from $new_app_name to pcs-order-editor"
	cf target -o $fulfillment_org -s $1
	cf add-network-policy $ordereditor_app --destination-app $new_app_name -s $1 -o $checkout_org --protocol tcp --port 8080
	cf target -o $checkout_org -s $1
	echo "Completed $1 network policies for $app_name"
}

routing_prod() {
	local new_app_name=$2
   	local app_name=$3
   	local hostname=$4
	
	echo "Begin $1 routing for $new_app_name"
	
   cf map-route $new_app_name $public_domain --hostname $hostname
   cf map-route $new_app_name $private_domain --hostname $hostname
   echo "mapped $new_app_name app to $hostname host, traffic from pcs-order-editor app should go to $new_app_name app"
   cf unmap-route $app_name $private_domain --hostname $hostname
   cf unmap-route $app_name $public_domain --hostname $hostname
   echo "un-mapped $app_name app from $hostname, traffic from pcs-order-editor app should not go to $app_name app"
	
	echo "Completed $1 routing for $new_app_name"
}

network_prod() {

   	local $new_app_name=$2
   	local $app_name=$3

	echo "Creating network policy from $new_app_name to pcs-order-editor"
	cf target -o $fulfillment_org -s $1
	cf add-network-policy $ordereditor_app --destination-app $new_app_name -s $1 -o $checkout_org --protocol tcp --port 8080
	cf target -o $checkout_org -s $1
	echo "Completed $1 network policies for $app_name"
}

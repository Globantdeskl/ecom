#!/bin/bash
# Script to perform blue-green deploy. Ignores services that already exist within the environments

if [[ -z "$1" ]] || [[ -z "$2" ]]; then
   echo "Empty passed variables environment:$1 app_name:$2"
   exit 1
fi

environment=$1
app_name=$2

new_app_name=$app_name-$environment-new
old_app_name=$app_name-old
hostname=$app_name-$environment

# source this app's network policy functions
source ./$app_name-policies.sh $environment

cf target -o checkout-services -s $environment
echo "You are currently targeting: $environment"

if [[ $(cf apps | grep $new_app_name) ]]
then
  cf stop $new_app_name
  cf delete $new_app_name -r -f
  echo "deleted $new_app_name and its routes"
else
 echo " $new_app_name app doesn't exits, so can't delete it"
fi

if [[ $(cf apps | grep $old_app_name) ]]
then
  cf delete $old_app_name -r -f
  echo "deleted $old_app_name and its routes"
else
 echo " $old_app_name app doesn't exits, script could be running for first time, so can't delete it"
fi

echo "Pushing $new_app_name with vars-$environment.yml"
cf push --vars-file vars-$environment.yml

#check the health before mapping the routes
echo "checking health on https://$new_app_name.$public_domain/actuator/health"

if curl -sk "https://$new_app_name.$public_domain/actuator/health" | grep '"ping":{"status":"UP"}'
then
   echo "App is up and bindings work, adding network policies"

#start nested if   
if [ $environment = "dev" -o $environment = "qa" -o $environment = "sit" -o $environment = "perf" ]
then
	network_dev_qa_sit_perf $environment $new_app_name $app_name
	routing_dev_qa_sit_perf $environment $new_app_name $app_name $hostname
elif [ $environment = "prod" ]
then
    network_prod $environment $new_app_name $app_name
    routing_prod $environment $new_app_name $app_name $hostname
fi
#end nested if
   
# start nested if
if [[ $(cf apps | grep $app_name) ]]
then
  #rename apps
  cf rename $app_name $old_app_name
  echo "renamed $app_name to $old_app_name"
  
  cf rename $new_app_name $app_name
  echo "renamed $new_app_name to $app_name"
  
  #stop old
  cf scale $old_app_name -i 1
  cf stop $old_app_name
  cf delete-route $public_domain --hostname $new_app_name -f
  cf delete-route $private_domain --hostname $new_app_name -f
  echo "deleted routes $new_app_name.$public_domain and $new_app_name.$private_domain"
else
  cf rename $new_app_name $app_name
  echo "renamed $new_app_name to $app_name"
  cf delete-route $public_domain --hostname $new_app_name -f
  cf delete-route $private_domain --hostname $new_app_name -f
  echo "deleted routes $new_app_name.$public_domain and $new_app_name.$private_domain"
fi
# end nested if

else
    echo "app health failed, stopping script"
    cf stop $new_app_name
    cf delete $new_app_name -r -f
    cf delete-orphaned-routes -f
    # want to clean up routes, etc... here
    exit 2
fi

exit

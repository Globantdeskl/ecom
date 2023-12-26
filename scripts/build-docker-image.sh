#!/bin/bash
set -e
DEFAULT_PROJECTS=""
DEFAULT_DOCKER_REGISTRY_TARGET="local"
DEFAULT_GRADLE_OPTS=""

test -n "${1}" && PROJECT="${1}"
test -n "${2}" && VERSION="${2}"

PROJECTS="${PROJECT:-$DEFAULT_PROJECTS}"
DOCKER_REGISTRY_TARGET="${DOCKER_REGISTRY_TARGET:-$DEFAULT_DOCKER_REGISTRY_TARGET}"
GRADLE_OPTS="${GRADLE_OPTS:-$DEFAULT_GRADLE_OPTS}"
echo "Working with projects: $PROJECTS"
[[ "${VERSION}" == "" ]] || VERSION="-Pversion=${VERSION}"

case $DOCKER_REGISTRY_TARGET in
        local)
                echo "Docker registy target is local docker"
                BUILD_CMD="./gradlew jibDockerBuild ${VERSION} ${GRADLE_OPTS}"
                ;;
        gcr)
                echo "Docker registry target is Google Container Registry"
                BUILD_CMD="./gradlew jib ${VERSION} ${GRADLE_OPTS}"
                ;;
        *)
                echo "Invalid DOCKER_REGISTY_TARGET. Available options: gcr, local. Default: local" >&2
                exit 1
                ;;
esac

for p in ${PROJECTS}; do
        pushd "${p}"
        eval "${BUILD_CMD}"
        popd
done

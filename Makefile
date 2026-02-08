.DEFAULT_GOAL := help
help:
	echo "no target specified" >&2

build-image:
	$(shell) scripts/build-docker-image.sh

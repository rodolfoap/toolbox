#!/bin/bash

# Run the build pipeline, everytime it is required.
# The following files are not anymore required:
#
# * Dockerfile
# * pipeline.bash
# * build.bash
#
docker run -ti --rm \
	-w /app \
	-v $(pwd):/app \
	-v "$HOME/.m2":/root/.m2 \
	maven:3.6.0-jdk-11-slim mvn clean install

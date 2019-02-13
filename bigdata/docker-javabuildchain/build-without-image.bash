#!/bin/bash

# Run the build pipeline, everytime it is required.
docker run -ti --rm \
	-w /app \
	-v $(pwd):/app \
	-v "$HOME/.m2":/root/.m2 \
	maven:3.6.0-jdk-11-slim ./pipeline.bash

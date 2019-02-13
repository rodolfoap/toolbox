#!/bin/bash

# Create the build image, runs only if image does not exist.
docker inspect --type=image javabuildchain &>/dev/null||docker build -t javabuildchain .

# Run the build pipeline, everytime it is required.
docker run -ti --rm \
	-v $(pwd):/app \
	-v "$HOME/.m2":/root/.m2 \
	javabuildchain ./pipeline.bash

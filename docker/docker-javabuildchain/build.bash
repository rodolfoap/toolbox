#!/bin/bash

# Run the build pipeline, everytime it is required.
docker run -t --rm \
	-w /app \
	-v $(pwd):/app \
	-v "$HOME/.m2":/root/.m2 \
	maven:3.6.0-jdk-11-slim ./pipeline.bash

# At this point, generated files are:
#
# target/
# ├── javabuildchain-0.0.1.jar
# └── lib
#     └── junit-3.8.1.jar
#

docker build -t javabuildchain . -f - << EOF
	FROM anapsix/alpine-java as BUILDER
	MAINTAINER rodolfoap@gmail.com
	COPY target/javabuildchain-0.0.1.jar 	/usr/local
	COPY target/lib/			/usr/local/lib/
	COPY entrypoint.bash			/usr/local/bin
	ENTRYPOINT ["/usr/local/bin/entrypoint.bash"]
EOF


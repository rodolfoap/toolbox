FROM ubuntu:latest as BUILDER
RUN apt-get update && apt-get install -y g++ cmake

WORKDIR '/tmp/app'
COPY . .
RUN ./build_app.bash

FROM debian:latest
COPY --from=BUILDER /tmp/app/build/src/hello /usr/local/bin/
COPY entrypoint.bash /usr/local/bin/

ENTRYPOINT ["/usr/local/bin/entrypoint.bash"]

# Java Build Chain

This example uses a docker container to build a mavenized java application. This means we don't need to have maven or java installed in the host system. Just docker is required.

## Build stage

The image is build within a JDK container. Building is as simple as...


```
docker run -ti --rm \
	-w /app \
	-v $(pwd):/app \
	-v "$HOME/.m2":/root/.m2 \
	maven:3.6.0-jdk-11-slim mvn clean install
```
See the `build.bash` script.

## Packaging stage

After building has been performed, the results are packaged into a lightweight JRE image.

```
docker build -t javabuildchain . -f - << EOF
	FROM anapsix/alpine-java as BUILDER
	MAINTAINER rodolfoap@gmail.com
	COPY target/javabuildchain-0.0.1.jar 	/usr/local
	COPY target/lib/			/usr/local/lib/
	COPY entrypoint.bash			/usr/local/bin
	ENTRYPOINT ["/usr/local/bin/entrypoint.bash"]
EOF
```
## Execution

The execution is straightforward. See the `start.bash` file.


```
$ ./start.bash 
ydor.org.javabuildchain.Main.main(Main.java:9)
ydor.org.javabuildchain.Greeter.<init>(Greeter.java:17)
ydor.org.javabuildchain.Greeter.sayHello(Greeter.java:25)
Hello, World!

```

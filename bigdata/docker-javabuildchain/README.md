# Java Build Chain

This example uses a docker container to build a mavenized java application. This means we don't need to have maven or java installed in the host system. Just docker is required.

# Usage
Only once, the image will be built:
```
$ ./build.bash

Sending build context to Docker daemon  181.2kB
Step 1/2 : FROM maven:3.6.0-jdk-11-slim as BUILDER
 ---> 7c74752bacfc
Step 2/2 : WORKDIR '/app'
 ---> Running in e389e8958e0b
Removing intermediate container e389e8958e0b
 ---> 55aa6c96a1be
Successfully built 55aa6c96a1be
Successfully tagged javabuildchain:latest
...
```
Since then, the execution is just...

```
$ ./build.bash

Running pipeline...
[INFO] Scanning for projects...
[WARNING]
[WARNING] Some problems were encountered while building the effective model for ydor.org:javabuildchain:jar:0.0.1
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 19, column 12
[WARNING]
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING]
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING]
[INFO]
[INFO] ----------------------< ydor.org:javabuildchain >-----------------------
[INFO] Building javabuildchain 0.0.1
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ javabuildchain ---
[INFO] Deleting /app/target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ javabuildchain ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /app/src/main/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ javabuildchain ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /app/target/classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ javabuildchain ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /app/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ javabuildchain ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /app/target/test-classes
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ javabuildchain ---
[INFO] Surefire report directory: /app/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running ydor.org.javabuildchain.GreeterTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.03 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ javabuildchain ---
[INFO] Building jar: /app/target/javabuildchain-0.0.1.jar
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ javabuildchain ---
[INFO] Installing /app/target/javabuildchain-0.0.1.jar to /root/.m2/repository/ydor/org/javabuildchain/0.0.1/javabuildchain-0.0.1.jar
[INFO] Installing /app/pom.xml to /root/.m2/repository/ydor/org/javabuildchain/0.0.1/javabuildchain-0.0.1.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.101 s
[INFO] Finished at: 2019-02-13T05:10:13Z
[INFO] ------------------------------------------------------------------------
Done.
```
## Avoiding Images

As this is just an example to show how to build inside Docker, the right build wouldn't in fact need a Dockerfile or a pipeline file. The build can be simple as...

```
docker run -ti --rm \
	-w /app \
	-v $(pwd):/app \
	-v "$HOME/.m2":/root/.m2 \
	maven:3.6.0-jdk-11-slim mvn clean install
```

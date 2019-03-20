# Maven dependencies in Docker

The example https://medium.com/@nieldw/caching-maven-dependencies-in-a-docker-build-dca6ca7ad612 suggests this Dockerfile:

```
# Step : Test and package
FROM maven:3.5.3-jdk-8-alpine as target
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn package

# Step : Package image
FROM openjdk:8-jre-alpine
COPY --from=target /build/target/*jar-with-dependencies.jar /app/my-app.jar

CMD exec java $JAVA_OPTS -jar /app/my-app.jar
```

What this example does is to copy the pom.xml into the container and download all dependencies using `mvn dependency:go-offline`. For a simple unique project, this works fine.

The problem with this is that the M2 repository is inside the container (`/root/.m2/repository`) and all the dependencies should be available on the Internet. But what if there are more dependencies on the `~/.m2/repository` of the host (outside docker, in the environment of the developer)? What if we have other internal Nexus servers? How can we reference them?

The solution is to centralize all dependencies in an M2 repository and copy them to the container. This can be performed in this way:

### Have all dependencies ready

Before creating the container, build all other dependencies. All the content will be stored in `~/.m2/repository`. Now, there are dependencies a) On the maven internet servers, b) On the `~/.m2/repository`, c) and eventually on our company's Nexus servers.

### Centralize the dependencies in a new M2-shaped-directory.

Go to the project that needs to be dockerized.

If we do a `mvn dependency:go-offline`, all the dependencies will copy to `~/.m2/repository` (which already has a lot of garbage, and we don't want to put that into the docker image).

If we do a `mvn dependency:go-offline -Dmaven.repo.local=./target/m2`, all the dependencies of the current project will be downloaded, but we're not going to find the dependencies created in (1).

The solution is to add this to the pom.xml:

```
...
		<repository>
			<id>home</id>
			<url>file://${user.home}/.m2/repository</url>
			<snapshots><enabled>true</enabled></snapshots>
		</repository>
		<!--repository>
			<NEXUS COMPANY REPOSITORIES>
		</repository-->
	</repositories>
</project>
```

Now, we have the possibility of using a new _localRepository_. So, if we do a `mvn dependency:go-offline -Dmaven.repo.local=./target/m2`, all the dependencies from a) the Internet and b) `~/.m2/repository` will be put into `./target/m2`


```
mvn -Dmaven.repo.local=./target/m2 dependency:go-offline

```

### Build the container

Now, the rest is easy, we just need to copy the new M2 repository into the container:


```
FROM maven:3.6.0-jdk-8-slim as build
WORKDIR /app

COPY target/m2 /root/.m2/repository
...

```

Now, the container can be built, having a clean set of dependencies, correctly organized and excluding all garbage.
```
docker build ...
```

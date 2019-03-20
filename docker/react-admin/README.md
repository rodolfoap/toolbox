# React-admin

A container to develop a React-admin (https://github.com/marmelab/react-admin) application.

## Usage

First, build the container of your own, because it depends on your user id:

```
# ./build

++ id -u
+ docker build -t nodereactadmin --build-arg UID=1000 .
Sending build context to Docker daemon  24.06kB
Step 1/10 : FROM	node
 ---> 2698faaff1ee
Step 2/10 : ARG	UID
 ---> Using cache
 ---> a8c01ef27306
Step 3/10 : RUN	npm install -g create-react-app
 ---> Using cache
 ---> 79abf344b20e
Step 4/10 : RUN	chmod 777 /usr/src
 ---> Using cache
 ---> 39a1309522d2
Step 5/10 : EXPOSE	3000
 ---> Using cache
 ---> da5fff9d2bfc
Step 6/10 : USER	$UID
 ---> Using cache
 ---> 42624302296b
Step 7/10 : RUN	cd /usr/src/ && 	create-react-app template && 	cd template && 	yarn add react-admin ra-data-json-server prop-types
 ---> Using cache
 ---> 0830b735b42e
Step 8/10 : WORKDIR	/app
 ---> Using cache
 ---> 68a5f61ba09d
Step 9/10 : COPY	entrypoint /usr/bin/
 ---> Using cache
 ---> e7c110d59578
Step 10/10 : CMD	/usr/bin/entrypoint
 ---> Using cache
 ---> e590f6c9cc7f
Successfully built e590f6c9cc7f
Successfully tagged nodereactadmin:latest
```

Then, start the application. The `start` script searches for the application inside the `./app` directory. If it does not exist, it will copy the template that has been saved in the image (you can easily modify the `Dockerfile` and the `entrypoint` in order for the application to be created automatically 

$ ./start

Setting up container...
Application wasn't found. Creating application from template...
Done.
Starting up yarn...
yarn run v1.15.2
$ react-scripts start



bash-cli
build
Dockerfile
entrypoint
README.md
start
yarn-build

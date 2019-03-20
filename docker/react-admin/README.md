# React-admin

A container to develop a React-admin (https://github.com/marmelab/react-admin) application.

## Usage

First, build the container of your own, because it depends on your user id:

```
# ./build
...
```

Then, start the application. The `start` script searches for the application inside the `./app` directory. If it does not exist, it will copy the template that has been saved in the image (you can easily modify the `Dockerfile` to include a template). If a template has not included in the image, it will just create one.

```
$ ./start

```
### More

* The `bash-cli` file runs a bash command inside the container.
* The `yarn-build` command is an example of how to run yarn commands inside the container.
* If permission issues are present in the `/app` directory, just restart the container. The permissions will be corrected.

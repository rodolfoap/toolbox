# React-admin

A container to develop a React-admin (https://github.com/marmelab/react-admin) application.

An issue to address in development containers is permissions. In this case, the container's user UID:GID are 1000:1000. Then, the user external to the container should have the same UID and GID. The simplest way to solve the issue is to change the internal UID and GID. That is done in the Dockerfile.

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
Now, the container would have initialized an application in the `./app` directory.

## Usage with GIT

By default, the app directory is not saved in git:

IMPORTANT: If you use git, REMOVE THE `app/` ENTRY FROM THE `.gitignore` FILE!

Your application will be saved on git. In order to rebuild the cache directories (i.e. if you clone the repository, the application will not just run as it is; it need the cache files), just run the `npm-install` script.

### More

* The `bash-cli` file runs a bash command inside the container.
* The `npm-install` rebuilds the cache contents.
* If permission issues are present in the `/app` directory, just restart the container. The permissions will be corrected.

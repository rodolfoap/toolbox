# HOWTO

* See https://github.com/tensorflow/models/blob/master/research/object_detection/g3doc/installation.md

```
./cli.bash

	________                               _______________
	___  __/__________________________________  ____/__  /________      __
	__  /  _  _ \_  __ \_  ___/  __ \_  ___/_  /_   __  /_  __ \_ | /| / /
	_  /   /  __/  / / /(__  )/ /_/ /  /   _  __/   _  / / /_/ /_ |/ |/ /
	/_/    \___//_/ /_//____/ \____//_/    /_/      /_/  \____/____/|__/


	WARNING: You are running this container as root, which can cause new files in
	mounted volumes to be created as the root user on your host machine.

	To avoid this, run the container by specifying your user's userid:

	$ docker run -u $(id -u):$(id -g) args...

protoc object_detection/protos/*.proto --python_out=.

python object_detection/builders/model_builder_test.py

	WARNING: The TensorFlow contrib module will not be included in TensorFlow 2.0.
	For more information, please see:
	  * https://github.com/tensorflow/community/blob/master/rfcs/20180907-contrib-sunset.md
	  * https://github.com/tensorflow/addons
	If you depend on functionality not listed there, please file an issue.

	............s...
	----------------------------------------------------------------------
	Ran 16 tests in 0.061s

	OK (skipped=1)
```
* See also the http://0.0.0.0:8888/notebooks/models/research/object_detection/object_detection_tutorial.ipynb

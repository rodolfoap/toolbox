#!/bin/bash
#exec &>/home/rodolfoap/log

rm -f server
[ -d build ] || {
	mkdir build && pushd $_ &>/dev/null
	cmake ..
} && {
	pushd build &>/dev/null
}
make -j && cp -v default_api_server ../server
popd &>/dev/null
echo Running server...
./server

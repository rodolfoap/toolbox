rm --interactive=never -rf build/;
mkdir build && pushd build &>/dev/null
cmake .. && make
popd &>/dev/null

build/src/main

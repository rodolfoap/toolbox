vi -p CMakeLists.txt main.c
rm -rf build/
mkdir build && pushd build &>/dev/null
cmake .. && make
popd &>/dev/null

build/helloWorld

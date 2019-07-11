vi -p CMakeLists.txt src/main.cpp include/main.h
rm -rf build/
mkdir build && pushd build &>/dev/null
cmake .. && make
popd &>/dev/null

build/helloWorld

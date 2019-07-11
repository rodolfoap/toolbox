vi -p CMakeLists.txt src/main.c
[ -d build ] && rm -r build/
mkdir build && pushd build &>/dev/null
cmake .. && make
popd &>/dev/null

build/mytest

vi -p CMakeLists.txt .x

rm --interactive=never -rf build/;
mkdir build && pushd build &>/dev/null
cmake .. -Wdev && make -j8
popd &>/dev/null

[ -f build/helloJar.jar ] && [ -f build/libhello.so ] && java -cp build/helloJar.jar -Djava.library.path=build/ HelloJNI

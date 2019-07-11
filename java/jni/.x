rm --interactive=never -rf build/;
mkdir build && pushd build &>/dev/null
cmake .. -Wdev
make -j8
popd &>/dev/null

[ -f HelloJNI.class ] && java -Djava.library.path=. HelloJNI
# LD_LIBRARY_PATH=$LD_LIBRARY_PATH:build/ java -Djava.library.path=./build/helloClass.jar HelloJNI

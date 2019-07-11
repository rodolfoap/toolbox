rm --interactive=never -rf build/;
mkdir build && pushd build &>/dev/null
cmake .. -Wdev
make -j8
popd &>/dev/null

[ -f HelloJNI.class ] && java -Djava.library.path=. HelloJNI

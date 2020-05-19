execute(){
	./calib annotated_points.jpg
}
build(){
	mkdir build;
	pushd build &> /dev/null;
	[ -f Makefile ] || cmake .. -Wdev;
	make -j8; STATUS=$?
	popd &> /dev/null;
}
case "$1" in
	"")
		build;
		execute
	;;
	e)
		vi -p calib.cpp test_dist.cpp test_calib.cpp CMakeLists.txt
		build;
		execute;
	;;
esac

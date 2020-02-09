execute(){
	echo REPLACE THIS WITH EXECUTION COMMAND
}
buildall(){
	rm -rf build;
	mkdir build;
	pushd build &> /dev/null;
	cmake ..;
	make;
	popd &> /dev/null;
}
build(){
	pushd build &> /dev/null;
	make -j;
	popd &> /dev/null;
}
case "$1" in
	a|all|buildall)
		buildall
	;;
	b|build)
		build
	;;
	x|execute)
		execute
	;;
	""|*)
		build
	;;
esac

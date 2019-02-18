execute(){
	mvn clean package jetty:run
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
		execute
	;;
esac

execute(){
	./server.py 
}
build(){
	popd
}
case "$1" in
	e) vi -p server.py html/index.html
	;;
	"") execute
	;;
esac

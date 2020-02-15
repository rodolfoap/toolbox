gencppapp(){
	cp -rv 000-Model/ $1/
	cd $1
}

case "$1" in
'')
	echo "  Usage: x [xxx-ProjectName]"
	echo "Example: x 005-CustomExceptions"
;;
*)
	gencppapp $1
	e
;;
esac

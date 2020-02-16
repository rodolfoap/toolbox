gencppapp(){
	FILE=$(ls vid/${1}*|sed 's:^vid/::;s/.mp4$//')
	cp -rvd 000-Model/ $FILE
	cd $FILE
}

case "$1" in
'')
	echo "  Usage: x [NNN]"
	echo "Example: x 005 # Will use 005-CustomExceptions"
;;
*)
	gencppapp $1
#	e
;;
esac

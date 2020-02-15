gencppapp(){
	cp -rv 000-Model $1
}

case "$1" in
'')
	echo "Usage: $0 [project]"
;;
*)
	gencppapp $1
	e
;;
esac

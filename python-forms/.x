APPLICATION=optlist.py
APPLICATION=model.py
case "$1" in
	e)
		vi -O ./${APPLICATION}
		./${APPLICATION}
	;;
	""|*)
		./${APPLICATION}
	;;
esac

APPLICATION=optlist.py
case "$1" in
	e)
		vi ./${APPLICATION}
		./${APPLICATION}
	;;
	""|*)
		./${APPLICATION}
	;;
esac

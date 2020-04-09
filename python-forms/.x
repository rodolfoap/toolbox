APPLICATION=optlist.py
case "$1" in
	e)
		vi -O ./${APPLICATION} forms.py
		./${APPLICATION}
	;;
	""|*)
		./${APPLICATION}
	;;
esac

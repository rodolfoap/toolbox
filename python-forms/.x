APPLICATION=model.py
case "$1" in
	e)
		vi ./${APPLICATION}
		./${APPLICATION}
	;;
	""|*)
		./${APPLICATION}
	;;
esac

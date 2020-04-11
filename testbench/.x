APPLICATION=model.py
case "$1" in
	e)
		vi -p ./${APPLICATION} mainform.py
		./${APPLICATION}
	;;
	""|*)
		./${APPLICATION}
	;;
esac

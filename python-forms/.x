APPLICATION=optlist.py
APPLICATION=model.py
case "$1" in
	e)
		vi -O ./${APPLICATION}
		./${APPLICATION}
		#cat data.yaml
	;;
	""|*)
		./${APPLICATION}
		#cat data.yaml
	;;
esac

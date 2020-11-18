execute(){
	./csvtranspose.py ./grades.csv ./grades2socsec.json
}
case "$1" in
	e)
		vi -O ./csvtranspose.py
		execute
	;;
	"")
		execute
	;;
esac

execute(){
	docker-compose up
}
case "$1" in
	e)
		vi -p app.py test.py
	;;
	"")
		execute
	;;
esac

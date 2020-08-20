execute(){
	#docker-compose up
	#docker run -ti --rm --name adminbackend -p 80:80 -v $(pwd)/:/app/ jazzdd/alpine-flask
	sudo python3 app.py
}
case "$1" in
	e)
		vi -p app.py test.py
	;;
	"")
		execute
	;;
esac

all:	app

app: app.cob
	cobc -C app.cob
	cobc -o app -x app.cob
	ls -lhFtr app*
	./app
edit:
	vi app.cob
	cobc -C app.cob
	cobc -o app -x app.cob
	ls -lhFtr app*
	./app

clean:
	rm -rf app{,.c,.c.h}
	rm -rf app app.c app.c.h app.c.l.h app.so
	ls -lhFtr

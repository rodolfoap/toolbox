CC=gcc
CLIBS=-lm -lmicrohttpd
CFLAGS=-g

default: all

all: app

edit:
	@echo ">>> Making: $@"
	vim app.c
	$(CC) $(CFLAGS) $(CLIBS) -o app app.c
	./app 8080

app: app.c
	@echo ">>> Making: $@"
	$(CC) $(CFLAGS) $(CLIBS) -o app app.c
	./app 8080

debug: app.c
	@echo ">>> Making: $@"
	$(CC) $(CFLAGS) $(CLIBS) -o app app.c
	gdb -x app.dbg ./app 8080

clean:
	@echo ">>> Making: $@"
	rm -rf app

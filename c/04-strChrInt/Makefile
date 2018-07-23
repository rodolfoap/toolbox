CC=gcc
CLIBS=-lm -std=gnu99
CFLAGS=-g

default: all

all: app

edit:
	vim app.c
	$(CC) $(CFLAGS) $(CLIBS) -o app app.c
	./app

app: app.c
	$(CC) $(CFLAGS) $(CLIBS) -o app app.c
	./app

debug: app.c
	$(CC) $(CFLAGS) $(CLIBS) -o app app.c
	gdb -x app.dbg ./app

clean:
	rm -rf app

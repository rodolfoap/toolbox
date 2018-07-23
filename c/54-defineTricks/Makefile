CC=gcc
CLIBS=-lm
CFLAGS=-g

default: all

all: fnvargs

edit:
	vim fnvargs.c
	$(CC) $(CFLAGS) $(CLIBS) -o fnvargs fnvargs.c
	./fnvargs

fnvargs: fnvargs.c
	$(CC) $(CFLAGS) $(CLIBS) -o fnvargs fnvargs.c
	./fnvargs

debug: fnvargs.c
	$(CC) $(CFLAGS) $(CLIBS) -o fnvargs fnvargs.c
	gdb -x fnvargs.dbg ./fnvargs

clean:
	rm -rf fnvargs

CC=gcc
CLIBS=-lm
CFLAGS=-g

default: all

all: korn

edit:
	vim korn.c
	$(CC) $(CFLAGS) $(CLIBS) -o korn korn.c
	./korn

korn: korn.c
	$(CC) $(CFLAGS) $(CLIBS) -o korn korn.c
	./korn

debug: korn.c
	$(CC) $(CFLAGS) $(CLIBS) -o korn korn.c
	gdb -x korn.dbg ./korn

clean:
	rm -rf korn

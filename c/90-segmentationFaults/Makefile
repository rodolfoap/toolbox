CC=gcc
CLIBS=-lm
CFLAGS=-g

default: all

all: damn

edit:
	vim damn.c
	$(CC) $(CFLAGS) $(CLIBS) -o damn damn.c
	./damn

damn: damn.c
	$(CC) $(CFLAGS) $(CLIBS) -o damn damn.c
	./damn

debug: damn.c
	$(CC) $(CFLAGS) $(CLIBS) -o damn damn.c
	gdb -x damn.dbg ./damn

clean:
	rm -rf damn

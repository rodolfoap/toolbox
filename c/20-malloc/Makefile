CC=gcc
CLIBS=-lm
CFLAGS=-g

default: all

all: prg

edit:
	vim prg.c
	$(CC) $(CFLAGS) $(CLIBS) -o prg prg.c
	./prg

prg: prg.c
	$(CC) $(CFLAGS) $(CLIBS) -o prg prg.c
	./prg

debug: prg.c
	$(CC) $(CFLAGS) $(CLIBS) -o prg prg.c
	gdb -x prg.dbg ./prg

clean:
	rm -rf prg

CC=gcc
CLIBS=-lm
CFLAGS=-g

default: all

all: wfile

edit:
	vim wfile.c
	$(CC) $(CFLAGS) $(CLIBS) -o wfile wfile.c
	./wfile
	ls -l *.data

wfile: wfile.c
	$(CC) $(CFLAGS) $(CLIBS) -o wfile wfile.c
	./wfile
	ls -l *.data

debug: wfile.c
	$(CC) $(CFLAGS) $(CLIBS) -o wfile wfile.c
	gdb -x wfile.dbg ./wfile

clean:
	rm -rf wfile file.data

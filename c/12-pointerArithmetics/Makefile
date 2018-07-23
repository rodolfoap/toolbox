CC=gcc
CLIBS=-lm
CFLAGS=-g

default: all

all: pointers

edit:
	vim pointers.c
	$(CC) $(CFLAGS) $(CLIBS) -o pointers pointers.c
	./pointers

pointers: pointers.c
	$(CC) $(CFLAGS) $(CLIBS) -o pointers pointers.c
	./pointers

debug: pointers.c
	$(CC) $(CFLAGS) $(CLIBS) -o pointers pointers.c
	gdb -x pointers.dbg ./pointers

clean:
	rm -rf pointers

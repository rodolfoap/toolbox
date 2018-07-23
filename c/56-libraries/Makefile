CC=gcc
CLIBS=-lrap
CFLAGS=-g -I . -L .

default: all

all: client

edit:	librap client.c
	vim -O client.c librap.c librap.h
	@echo ">>> Making: $@"
	$(CC) $(CFLAGS) -o client client.c $(CLIBS)
	./client

client: librap client.c
	@echo ">>> Making: $@"
	$(CC) $(CFLAGS) -o client client.c $(CLIBS)
	./client

librap: librap.c
	@echo ">>> Making: $@"
	$(CC) $(CFLAGS) -c librap.c
	ar rs librap.a librap.o

clean:
	rm -rf client *.o *.a

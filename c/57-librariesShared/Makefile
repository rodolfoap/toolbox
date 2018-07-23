CC=gcc
CLIBS=-lrap
CFLAGS=-Wall -Werror -g -I . -L . -Wl,-rpath=$(PWD)
CFLAGX=-Wall -Werror -g -I . -L .

default: all

all: 	main

edit:	librap.c librap.h main.c
	vim -O main.c librap.c librap.h
	@echo ">>> Making: $@"
	$(MAKE) librap
	$(CC) $(CFLAGS) -o main main.c $(CLIBS)
	./main

main: 	librap main.c
	@echo ">>> Making: $@"
	$(CC) $(CFLAGS) -o main main.c $(CLIBS)
	./main

debug: 	librap main.c
	@echo ">>> Making: $@"
	$(CC) $(CFLAGS) -o main main.c $(CLIBS)
	gdb -x main.dbg ./main

librap: librap.h librap.c
	@echo ">>> Making: $@"
	$(CC) $(CFLAGS) -fpic -c librap.c
	gcc -shared -o librap.so librap.o

clean:
	@echo ">>> Making: $@"
	rm -rf main *.o *.a *.so

install: librap.so
	@echo ">>> Making: $@"
	install -d /usr/lib/
	install -m 755 librap.so /usr/lib/
	ldconfig
	ldconfig -p|grep librap.so
	$(CC) -lrap -o main main.c

PREFIX=/usr/local
LIBYDER_LOCATION=lib/yder/src
ULFIUS_LOCATION=lib/ulfius
LIBS=-L$(LIBYDER_LOCATION) -lc -lulfius -lyder -lorcania -L$(ULFIUS_LOCATION)

CC=gcc
CLIBS=-lm
CFLAGS=-g -c -Wall -I$(LIBYDER_LOCATION) -D_REENTRANT $(ADDITIONALFLAGS)

default: all

all: app

libulfius.so:
	@echo ">>> Making: $@"
	cd $(ULFIUS_LOCATION) && $(MAKE) debug CURLFLAG=-DU_DISABLE_CURL WEBSOCKETFLAG=-DU_DISABLE_WEBSOCKET

app.o: app.c
	@echo ">>> Making: $@"
	$(CC) $(CFLAGS) app.c -DDEBUG -g -O0

app: libulfius.so app.o
	@echo ">>> Making: $@"
	$(CC) -o app app.o $(LIBS)
	./app

edit:
	@echo ">>> Making: $@"
	vim app.c
	$(CC) $(CFLAGS) $(CLIBS) -o app app.c
	./app

debug: app.c
	@echo ">>> Making: $@"
	$(CC) $(CFLAGS) $(CLIBS) -o app app.c
	gdb -x app.dbg ./app

clean:
	@echo ">>> Making: $@"
	rm -rf app *.o *.so

test: app
	@echo ">>> Making: $@"
	LD_LIBRARY_PATH=$(ULFIUS_LOCATION):${LD_LIBRARY_PATH} ./app

static: app.o
	@echo ">>> Making: $@"
	$(CC) -o app app.o $(PREFIX)/lib/liborcania.a $(PREFIX)/lib/libyder.a $(PREFIX)/lib/libulfius.a -ljansson -lmicrohttpd -lpthread -lgnutls

all: parser

OBJS = parser.o  \
       codegen.o \
       main.o    \
       tokens.o  \
       corefn.o  \

CPPFLAGS = `llvm-config-3.1 --cppflags`
LDFLAGS = `llvm-config-3.1 --ldflags`
LIBS = `llvm-config-3.1 --libs`

clean:
	$(RM) -rf parser.cpp parser.hpp parser tokens.cpp $(OBJS)

parser.cpp: parser.y
	bison -d -o $@ $^
	
parser.hpp: parser.cpp

tokens.cpp: tokens.l parser.hpp
	flex -o $@ $^

%.o: %.cpp
	g++ -c $(CPPFLAGS) -o $@ $<


parser: $(OBJS)
	g++ -o $@ $(OBJS) $(LIBS) $(LDFLAGS)

run:
	echo 'int do_math(int a) { int x = a * 5 + 3 } do_math(10)' | ./parser


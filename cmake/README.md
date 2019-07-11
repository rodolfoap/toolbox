CMake Stages:
* **Configure**: CMakeLists.txt file is read in. CMake builds up an internal representation of the project during this stage: CMakeCache.txt.
	* execute_process() is executed during configure time.
* **Generation**: Project files are written out based on that internal representation.
* **Build**: Execution of the build tool (e.g. make).
	* add_custom_command() and...
	* add_custom_target() are executed during Build time.

Tips
====

* Show message after target has been executed:
```
add_executable(prog main.c ${PROGSRC})
add_custom_command(TARGET prog POST_BUILD COMMENT "-----> main has been generated.")
```


#########################################################################################################
# Comparison Cmake - Make
# See: https://github.com/rhoelzel/make_cmake
#########################################################################################################
# Makefile

CC = gcc
CPP = g++
RANLIB = ar rcs
RELEASE = -c -O3
DEBUG = -c -g -D_DEBUG
INCDIR = -I./stuff/include
LIBDIR = -L./stuff/lib -L.
LIBS = -lstuff -lmystatlib -lmydynlib
CFLAGS = $(RELEASE)

PROGOBJS = prog1.o prog2.o prog3.o

prog: main.o $(PROGOBJS) mystatlib mydynlib
	$(CC) main.o $(PROGOBJS) $(LIBDIR) $(LIBS) -o prog
debug: CFLAGS=$(DEBUG)
debug: prog

mystatlib: mystatlib.o
	$(RANLIB) libmystatlib.a mystatlib.o
mydynlib: mydynlib.o
	$(CPP) -shared mydynlib.o -o libmydynlib.so

%.o: %.c
	$(CC) $(CFLAGS) $(INCDIR) $< -o $@
%.o: %.cpp
	$(CPP) $(CFLAGS) $(INCDIR) -fPIC  $< -o $@

#########################################################################################################
# CMakeLists.txt

cmake_minimum_required(VERSION 2.8)			# stuff not directly related to building
project(example)					# stuff not directly related to building

include_directories(${CMAKE_SOURCE_DIR}/stuff/include)	# -I flags for compiler
link_directories(${CMAKE_SOURCE_DIR}/stuff/lib)		# -L flags for linker

set(PROGSRC prog1.c prog2.c prog3.c)			# define variable

add_executable(prog main.c ${PROGSRC})			# define executable target prog, specify sources
target_link_libraries(prog mystatlib mydynlib stuff)	# -l flags for linking prog target

add_library(mystatlib STATIC mystatlib.c)		# define static library target mystatlib, specify sources

add_library(mydynlib SHARED mydynlib.cpp)		# define shared library target mydynlib, specify sources

							# extra flags for linking mydynlib: -fPIC
set_target_properties(mydynlib PROPERTIES POSITION_INDEPENDENT_CODE TRUE)
							# or:
set_target_properties(mydynlib PROPERTIES COMPILE_FLAGS "-fPIC")

#########################################################################################################

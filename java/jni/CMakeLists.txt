cmake_minimum_required(VERSION 3.7)
project (HelloWorld NONE)

find_package(Java REQUIRED)
include(UseJava)
set(CMAKE_JAVA_COMPILE_FLAGS "-source" "1.8" "-target" "1.8")
add_jar(HelloJNI HelloJNI.java)
execute_process (COMMAND bash -c "cp ${_classDir}/HelloJNI.class .." OUTPUT_VARIABLE outVar)
message(STATUS "STATUS: ${_classDir}")
message(STATUS "STATUS: ${outVar}")



#
#add_executable(main main.cpp)
#target_include_directories(main PRIVATE include)
#
#target_link_libraries(main factorial)
#add_library(factorial SHARED factorial.cpp)
#target_include_directories(factorial PUBLIC include)











#export JAVA_INC=/usr/lib/jvm/java-8-openjdk-amd64/include
# step 1: compile the .class file with invocation to a native method
#
# javac HelloJNI.java
#
# step 2: auto-generate a .h header file from said Java source
#
# javah HelloJNI
#
# step 3: make the shared library with the name linked in said Java source, and implementing said native method
#
# g++ -std=c++11 -shared -fPIC -I$JAVA_INC -I$JAVA_INC/linux HelloJNIImpl.cpp -o libhello.so
#
# step 4: run JVM with java.library.path set to include said shared library
#
# java -Djava.library.path=. HelloJNI
#

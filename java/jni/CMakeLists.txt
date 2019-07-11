cmake_minimum_required(VERSION 3.7)
project (HelloWorld)

find_package(Java REQUIRED)
include(UseJava)
set(CMAKE_JAVA_COMPILE_FLAGS "-source" "1.8" "-target" "1.8")

add_jar(HelloJNI HelloJNI.java)
get_target_property(_jarFile HelloJNI JAR_FILE)
get_target_property(_classDir HelloJNI CLASSDIR)
add_custom_command(TARGET HelloJNI POST_BUILD COMMENT "-----> HelloJNI has finished.")

add_custom_target(classCopy ALL
	COMMENT "COPYING: ${_classDir}/HelloJNI.class -> ../"
	COMMAND bash -c "cp ${_classDir}/HelloJNI.class .."
	DEPENDS HelloJNI
)
add_custom_command(TARGET classCopy POST_BUILD COMMENT "-----> classCopy has finished.")

create_javah(TARGET javahHeader
	CLASSES HelloJNI
	CLASSPATH ${_classDir}
	DEPENDS classCopy
)
add_custom_command(TARGET javahHeader POST_BUILD COMMENT "-----> javahHeader has finished.")

add_custom_target(headerCopy ALL
	COMMENT "COPYING: HelloJNI.h -> ../"
	COMMAND bash -c "cp HelloJNI.h .."
	DEPENDS javahHeader
)
add_custom_command(TARGET headerCopy POST_BUILD COMMENT "-----> headerCopy has finished.")
include_directories(
	/usr/lib/jvm/java-8-openjdk-amd64/include
	/usr/lib/jvm/java-8-openjdk-amd64/include/linux
)
add_library(hello SHARED HelloJNIImpl.cpp )
set_target_properties(hello PROPERTIES POSITION_INDEPENDENT_CODE TRUE)
add_dependencies(hello javahHeader)

add_custom_target(libCopy ALL
	COMMENT "COPYING: libhello.so -> ../"
	COMMAND bash -c "cp libhello.so .."
	DEPENDS hello 
)
add_custom_command(TARGET libCopy POST_BUILD COMMENT "-----> libCopy has finished.")


#add_executable(main main.cpp)
#target_include_directories(main PRIVATE include)
#
#target_link_libraries(main factorial)
#target_include_directories(factorial PUBLIC include)

#export JAVA_INC=/usr/lib/jvm/java-8-openjdk-amd64/include
# step 1: compile the .class file with invocation to a native method
# javac HelloJNI.java
# step 2: auto-generate a .h header file from said Java source
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

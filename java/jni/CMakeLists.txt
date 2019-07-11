cmake_minimum_required(VERSION 3.7)
project (HelloJNI)

# Cmake will deal with java
#
find_package(Java REQUIRED)
include(UseJava)
set(CMAKE_JAVA_COMPILE_FLAGS "-source" "1.8" "-target" "1.8")

# Generate JAR and CLASS files:
# build/CMakeFiles/HelloJNI.dir/HelloJNI.class
# build/HelloJNI.jar
#
add_jar(helloClass HelloJNI.java)
get_target_property(_jarFile  helloClass JAR_FILE)
get_target_property(_classDir helloClass CLASSDIR)
add_custom_command(TARGET helloClass POST_BUILD COMMENT "-----> CLASSDIR: ${_classDir}")
add_custom_command(TARGET helloClass POST_BUILD COMMENT "-----> JAR_FILE: ${_jarFile}" )

# Generate HEADER for CLASS file:
# build/HelloJNI.h
#
create_javah(TARGET javaHeader
	CLASSES HelloJNI
	CLASSPATH ${_classDir}
	DEPENDS helloClass
)

# Generate LIBRARY file:
# build/libhello.so
#
include_directories(
# 	-I/usr/lib/jvm/java-8-openjdk-amd64/include
# 	-I/usr/lib/jvm/java-8-openjdk-amd64/include/linux
	/usr/lib/jvm/java-8-openjdk-amd64/include
	/usr/lib/jvm/java-8-openjdk-amd64/include/linux
	${CMAKE_BINARY_DIR}
)
add_library(hello SHARED HelloJNIImpl.cpp )
set_target_properties(hello PROPERTIES POSITION_INDEPENDENT_CODE TRUE) # -fPIC
add_dependencies(hello javaHeader) # the HelloJNI.h must exist first

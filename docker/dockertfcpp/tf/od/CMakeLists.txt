cmake_minimum_required(VERSION 3.10)
project(app)

# Force C++14
set(CMAKE_CXX_STANDARD 14)
set(CMAKE_CXX_STANDARD_REQUIRED True)

# Tensorflow
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -D_GLIBCXX_USE_CXX11_ABI=${TensorFlow_ABI}")
set(CMAKE_EXE_LINKER_FLAGS  "${CMAKE_EXE_LINKER_FLAGS} -D_GLIBCXX_USE_CXX11_ABI=${TensorFlow_ABI}" )

# Equivalent to (CFLAGS) -g
set(CMAKE_BUILD_TYPE Debug)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
set(CMAKE_PREFIX_PATH /usr/share/lib/cmake)
#/usr/local/lib/cmake
#/usr/local/lib/cmake/TensorflowCC
#/usr/share/doc/cmake
#/tensorflow_cc/tensorflow_cc/cmake
list(APPEND CMAKE_PREFIX_PATH /usr/local/lib/cmake/TensorflowCC)


message(STATUS "Binary app will go to: ${CMAKE_RUNTIME_OUTPUT_DIRECTORY}")
message(STATUS "CMakeLists.txt contents:")
execute_process(COMMAND sed "s/^/\t/" CMakeLists.txt
	WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}
	RESULT_VARIABLE CMD_ERROR)

# Equivalent to (CFLAGS) -g
set(CMAKE_C_FLAGS "-g")

#find_package(SFML 2.5 COMPONENTS graphics audio REQUIRED)
#set(SFML_STATIC_LIBRARIES TRUE)
find_package(TensorflowCC REQUIRED)
#TensorFlow_REQUIRE_C_LIBRARY()
#TensorFlow_REQUIRE_SOURCE()



#target_link_libraries(app sfml-graphics sfml-window sfml-system sfml-audio)





add_executable(app app.cpp)
target_include_directories(app PRIVATE TensorFlow_DEP)
target_link_libraries(app PRIVATE TensorFlow_DEP)

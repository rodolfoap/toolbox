cmake_minimum_required(VERSION 3.10)
project(app)

# Force C++11
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)

# Equivalent to (CFLAGS) -g
set(CMAKE_BUILD_TYPE Debug)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
message(STATUS "Binary app will go to: ${CMAKE_RUNTIME_OUTPUT_DIRECTORY}")

# Equivalent to (CFLAGS) -g
set(CMAKE_C_FLAGS "-g")

# OPENCV ####################################
find_package(OpenCV REQUIRED)
include_directories(${OpenCV_INCLUDE_DIRS})

add_executable(calib calib.cpp)
add_executable(test_calib test_calib.cpp)
add_executable(test_dist test_dist.cpp)

target_link_libraries(calib ${OpenCV_LIBS})
target_link_libraries(test_calib ${OpenCV_LIBS})
target_link_libraries(test_dist ${OpenCV_LIBS})

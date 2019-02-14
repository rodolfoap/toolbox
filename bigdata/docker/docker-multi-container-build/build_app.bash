#!/bin/bash

# This first section is a classical build

rm -rf build && mkdir build && cd build

cmake -j8 .. && make

cd ..

# Here, just some user information:

echo ============================================
echo PWD IS: $(pwd)
echo FIND /tmp/app GIVES:
find /tmp/app|sed "s/^/\t/"
echo ============================================

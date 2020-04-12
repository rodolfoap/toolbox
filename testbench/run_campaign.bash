#!/bin/bash
rm -rf results; mkdir results
for CASE in cases/*; do
	./run_test.bash $CASE
done

#!/bin/bash

# MANDATORY: TESTS SHOULD RUN IN ITS DIRECTORY
cd $(cd $(dirname ${BASH_SOURCE[0]}) >/dev/null 2>&1 && pwd)

# All test STDOUT/STDERR output will be saved on a single file
for x in {1..5}; do python3 -c 'import lorem; print(lorem.paragraph())'; sleep 0.5; done

# Rule: Tests should print VAR=VALUE pairs to stdout
echo VARIABLE1=0
echo VARIABLE2=This is a test

# Rule: Tests should report the PASS/FAIL status using the EXIT VALUE
true

#!/usr/bin/env python3
import sys, os
sys.path.append(os.path.dirname(os.path.realpath(__file__))+'/../lib')
import configparser
from status import Status

keyval=Status(sys.argv[1])
print()
for key, value in keyval.getValues().items():
	print('K,V: ', key, value)
print()
print('*** Test Result is: ', keyval.getValue('test_status'), '***')
print()

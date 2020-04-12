#!/usr/bin/env python3
import sys
sys.path.append('lib/')
import configparser
from status import Status

keyval=Status(sys.argv[1])
print('Test Result is: ', keyval.getValue('test_status'))

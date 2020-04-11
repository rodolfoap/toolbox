#!/usr/bin/env python3

# Run as: $0 directory 'Window Title'

import npyscreen as nps
import yaml
import re
import sys
from os import listdir

class Servc(nps.NPSAppManaged):
	def main(self):
		self.existing_tests=listdir(sys.argv[1])
		self.nfiles=len(self.existing_tests)
		self.existing_tests.sort()
		self.existing_tests.append('Create new definition:')
		self.form=nps.Form(name=sys.argv[2])
		self.test=self.form.add(nps.TitleSelectOne, max_height=4, name="Select:",
				values=self.existing_tests, value=0, scroll_exit=True)
		self.newt=self.form.add(nps.TitleText, name=" ", rely=len(self.existing_tests)+2, relx=7, value=0)
		self.form.edit()

if __name__=='__main__':
	s=Servc()
	s.run()
	if s.test.value[0]==s.nfiles:
		print(s.newt.value)
	else:
		print(s.existing_tests[s.test.value[0]])


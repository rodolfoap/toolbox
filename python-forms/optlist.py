#!/usr/bin/env python3
import npyscreen as nps
from forms import Form, EntryForm

class Tests(nps.OptionList):
	def __init__(self):
		super(Tests, self).__init__()
		self.options.append(nps.OptionDate('Date Created'))
		self.options.append(nps.OptionFreeText('Short Description', value='Description', documentation="."))
		self.options.append(nps.OptionMultiFreeText('Long description', value=''))
		self.options.append(nps.OptionMultiChoice('Test Type', 
			choices=['Unitary test', 'Integration test', 'Model test']))
		self.options.append(nps.OptionFilename('Test filename',))
		self.options.append(nps.OptionMultiFreeList('Test cases'))

if __name__=="__main__":
	app=EntryForm()
	app.setContent("Test Definition", Tests(), 'tests/test1.py')
	app.run()

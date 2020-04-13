#!/usr/bin/env python3
import sys, config
sys.path.append(config.apppath+'/lib/')
import npyscreen as nps
from entry_form import Entry_Form
from os import listdir

class Servc(nps.NPSAppManaged):
	def onStart(self):

		f=Entry_Form(name='Test Case Definition', file_name=sys.argv[1])
		test_types=listdir('test_types'); test_types.sort()
		test_rqmts=listdir('requirements'); test_rqmts.sort()

		f.add_field('TestId', nps.TitleText, name="Test Id")
		f.add_field('TestDate', nps.TitleDateCombo, name="Date")

		f.add_field('skip1', nps.FixedText, value="Description")
		f.add_field('TestDescription', nps.MultiLineEdit, max_height=6, relx=4)

		f.add_field('skip2', nps.FixedText, value="Validation Criteria")
		f.add_field('TestValidationCriteria', nps.MultiLineEdit, max_height=6, relx=4)
		f.add_field('TestType', nps.TitleMultiSelect, max_height=6,
				name="Test Type", values=test_types, scroll_exit=True)
		f.add_field('TestReqList', nps.TitleMultiSelect, max_height=6,
				name="Applicable Requirements", values=test_rqmts, scroll_exit=True)
		f.add_field('TestLauncherFilename', nps.TitleFilenameCombo, name="Test Launcher")
		f.add_field('TestValidatorFilename', nps.TitleFilenameCombo, name="Check Script")

		self.registerForm('MAIN', f)

if __name__=='__main__':
	Servc().run()

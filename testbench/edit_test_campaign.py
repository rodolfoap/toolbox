#!/usr/bin/env python3
import npyscreen as nps
import sys
from entry_form import Entry_Form

class Servc(nps.NPSAppManaged):
	def onStart(self):

		test_types=["Unit Test", "Integration Test", "Validation Test", "Model Test"]
		f=Entry_Form(name='Test Campaing', file_name=sys.argv[1])

		f.add_field('Id', nps.TitleText, name="Campaing Id")
		f.add_field('Name', nps.TitleText, name="Campaing Name")
		f.add_field('Responsible', nps.TitleText, name="Responsible")
		f.add_field('Date', nps.TitleDateCombo, name="Date")
		f.add_field('skip1', nps.FixedText, value="Description")
		f.add_field('Description', nps.MultiLineEdit, max_height=8, relx=4)
		f.add_field('Types', nps.TitleMultiSelect, max_height=4, name="Include Types            ",
				values=test_types, scroll_exit=True)

		self.registerForm('MAIN', f)

if __name__=='__main__':
	Servc().run()

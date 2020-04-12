#!/usr/bin/env python3
import npyscreen as nps
import sys
import yaml
from entry_form import Entry_Form
from os import listdir

class Servc(nps.NPSAppManaged):
	def onStart(self):

		self.form=Entry_Form(name='Test Campaing', file_name=sys.argv[1])
		self.test_types=listdir('test_types'); self.test_types.sort()

		self.form.add_field('Id', nps.TitleText, name="Campaing Id")
		self.form.add_field('Name', nps.TitleText, name="Campaing Name")
		self.form.add_field('Responsible', nps.TitleText, name="Responsible")
		self.form.add_field('Date', nps.TitleDateCombo, name="Date")
		self.form.add_field('skip1', nps.FixedText, value="Description")
		self.form.add_field('Description', nps.MultiLineEdit, max_height=6, relx=4)
		self.form.add_field('Types', nps.TitleMultiSelect, max_height=6, name="Include Types",
				values=self.test_types, scroll_exit=True)

		self.registerForm('MAIN', self.form)

if __name__=='__main__':
	s=Servc()
	s.run()
	tests_to_run=[]
	for case in listdir('cases'):
		with open('cases/'+case, 'r') as yamlfile:
			values=yaml.load(yamlfile)
			if(len([value for value in s.form.fields['Types'].value if value in values['TestType']])>0):
				tests_to_run.append(case)
	print('TESTS TO RUN: ', tests_to_run);
	with open('.runnable.list', 'w') as filehandle:
		filehandle.writelines("%s\n" % place for place in tests_to_run)


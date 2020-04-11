#!/usr/bin/env python3
import npyscreen as nps
import yaml
import re
from os import listdir
from menu_form import Menu_Form

class Menu_Form(nps.Form):
	def __init__(self, name):
		self.fields={}
		super(Menu_Form, self).__init__(name)

	def create(self):
		for tag in self.fields:
			self.fields[tag].value=self.values[tag]

	def add_field(self, tag, widgetClass, w_id=None, max_height=None, rely=None, relx=None, *args, **keywords):
		self.fields[tag]=self.add(widgetClass, w_id, max_height, rely, relx, *args, **keywords)

	def afterEditing(self):
		self.parentApp.setNextForm(None)

class Servc(nps.NPSAppManaged):
	def onStart(self):
		self.existing_tests=listdir('test_cases')
		self.existing_tests.sort()
		self.existing_tests.append('New Test:')
		self.form=Menu_Form(name='Select Option')
		self.form.add_field('TestFile', nps.TitleSelectOne, max_height=4, name="Test:",
				values=self.existing_tests, value=0, scroll_exit=True)
		self.form.add_field('TestName', nps.TitleText, name=" ", rely=len(self.existing_tests)+2, relx=7, value=0)
		self.registerForm('MAIN', self.form)

if __name__=='__main__':
	s=Servc()
	s.run()
	print(s.existing_tests[s.form.fields['TestFile'].value[0]])



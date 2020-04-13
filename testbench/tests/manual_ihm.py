#!/usr/bin/env python3
import sys, os
sys.path.append(os.path.dirname(os.path.realpath(__file__))+'/../lib')
import npyscreen as nps
from entry_form import Entry_Form

class Servc(nps.NPSAppManaged):
	def onStart(self):
		yn=['No', 'Yes']
		self.form=Entry_Form(name='IHM Test', file_name='results/mtest001.yaml')

		self.form.add_field('Functions', nps.TitleMultiSelect, max_height=6, name="Available functions", values=[
			'Screen X is present',
			'Screen Y is present',
			'Screen Z is present',
			], scroll_exit=True)
		self.form.add_field('Alerts', nps.TitleSelectOne, max_height=6, name="Alerts are reported to the operator console:",
				values=yn, value=0, scroll_exit=True)
		self.form.add_field('TEST_STATUS', nps.TitleSelectOne, max_height=6, name="Does the test PASS:",
				values=yn, value=0, scroll_exit=True)

		self.registerForm('MAIN', self.form)

if __name__=='__main__':
	Servc().run()

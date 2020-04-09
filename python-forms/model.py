#!/usr/bin/env python3
import npyscreen as nps

def wrapper(*args):
	print(text)

class MainForm(nps.Form):
	def create(self):
		self.text=self.add(nps.TitleText, name="Name:", value="Hellow World!")
		self.dept=self.add(nps.TitleSelectOne, scroll_exit=True, max_height=3, name='Department:', values = ['Department 1', 'Department 2', 'Department 3'])
		self.date=self.add(nps.TitleDateCombo, name='Date Employed:')

	def afterEditing(self):
		self.parentApp.setNextForm(None)


class Servc(nps.NPSAppManaged):
	def onStart(self):
		#self.registerForm("MAIN", MainForm())
		self.addForm('MAIN', MainForm, name='New Employee')

if __name__=='__main__':
	TA=Servc()
	TA.run()

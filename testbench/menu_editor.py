#!/usr/bin/env python3
import npyscreen as nps
from menu_form import Menu_Form

class Servc(nps.NPSAppManaged):
	def onStart(self):

		f=Menu_Form(name='Select Option')

		f.add_field('TestFile', nps.TitleSelectOne, max_height=4, name="Test:",
				values=['test1', 'test2', 'New Test:'], scroll_exit=True)
		f.add_field('TestName', nps.TitleText, name=" ", rely=5, relx=7, value=0)

		self.registerForm('MAIN', f)

if __name__=='__main__':
	Servc().run()

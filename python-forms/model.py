#!/usr/bin/env python3
import npyscreen as nps
from mainform import MainForm

class Servc(nps.NPSAppManaged):
	def onStart(self):
		f=MainForm(name='Example', file_name='data.yaml')
		f.add_field('Titulo', nps.TitleText, name="Text:")
		f.add_field('TitleText', nps.TitleText, name="Text:")
		f.add_field('TitleFilename', nps.TitleFilename, name="Filename:")
		f.add_field('TitleFilenameCombo', nps.TitleFilenameCombo, name="Filename2:")
		f.add_field('TitleDateCombo', nps.TitleDateCombo, name="Date:")
		f.add_field('TitleSliderPercent', nps.TitleSliderPercent, accuracy=0, out_of=12, name="Slider")
		f.add_field('MultiLineEdit', nps.MultiLineEdit, max_height=5, rely=9)
		f.add_field('TitleSelectOne', nps.TitleSelectOne, max_height=4, name="Pick One", values=["Option1", "Option2", "Option3"], scroll_exit=True)
		f.add_field('TitleMultiSelect', nps.TitleMultiSelect, max_height=-2, name="Pick Several", values=["Option1", "Option2", "Option3"], scroll_exit=True)
		self.registerForm('MAIN', f)

if __name__=='__main__':
	Servc().run()

#!/usr/bin/env python3
import npyscreen as nps
import yaml

class MainForm(nps.Form):
	def create(self):
		self.values={}
		with open('data.yaml', 'r') as yamlfile:
			self.values=yaml.load(yamlfile)
		self.a = self.add(nps.TitleText, name="Text:", value=self.values['Test']['Name'])
		self.b = self.add(nps.TitleFilename, name="Filename:", value=self.values['Test']['Filename'])
		self.c = self.add(nps.TitleFilenameCombo, name="Filename2:", value=self.values['Test']['Filename2'])
		self.d = self.add(nps.TitleDateCombo, name="Date:", value=self.values['Test']['Date'])
		self.e = self.add(nps.TitleSliderPercent, accuracy=0, out_of=12, name="Slider", value=self.values['Test']['Slider'])
		self.f = self.add(nps.MultiLineEdit, max_height=5, rely=9, value=self.values['Test']['Multiline'])
		self.g = self.add(nps.TitleSelectOne, max_height=4, name="Pick One", values=["Option1", "Option2", "Option3"], scroll_exit=True, value=self.values['Test']['SelectOne'])
		self.h = self.add(nps.TitleMultiSelect, max_height=-2, name="Pick Several", values=["Option1", "Option2", "Option3"], scroll_exit=True, value=self.values['Test']['Multiselect'])

	def afterEditing(self):
		values={'Test': {
			'Name': self.a.value,
			'Filename': self.b.value,
			'Filename2': self.c.value,
			'Date': self.d.value,
			'Slider': self.e.value,
			'Multiline': self.f.value,
			'SelectOne': self.g.value,
			'Multiselect': self.h.value,
		}}
		with open('data.yaml', 'w') as yamlfile:
			yaml.dump(values, yamlfile, default_flow_style=False)
		self.parentApp.setNextForm(None)

class Servc(nps.NPSAppManaged):
	def onStart(self):
		self.addForm('MAIN', MainForm, name='New Employee')

if __name__=='__main__':
	Servc().run()

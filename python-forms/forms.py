#!/usr/bin/env python3
import npyscreen as nps

class Form(nps.Form):
	def __init__(self, aName, fields, filename):
		super(Form, self).__init__(name=aName)
		try:
			fields.reload_from_file(filename)
		except FileNotFoundError:
			pass
		ms=self.add(nps.OptionListDisplay, name="Option List",
			values=fields.options, scroll_exit=True, max_height=None)
		self.edit()
		fields.write_to_file(filename)

class EntryForm(nps.NPSAppManaged):
	def setContent(self, aName, aClazz, aFilename):
		self.name=aName
		self.clazz=aClazz
		self.file=aFilename
	def main(self):
		form=Form(self.name, self.clazz, self.file)

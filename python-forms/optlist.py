#!/usr/bin/env python3
import npyscreen as nps

class Tests(nps.OptionList):
	def __init__(self):
		super(Tests, self).__init__()
		self.options.append(nps.OptionFreeText('FreeText', value='', documentation="This is some documentation."))
		self.options.append(nps.OptionMultiChoice('Multichoice', choices=['Choice 1', 'Choice 2', 'Choice 3']))
		self.options.append(nps.OptionFilename('Filename',))
		self.options.append(nps.OptionDate('Date',))
		self.options.append(nps.OptionMultiFreeText('Multiline Text', value=''))
		self.options.append(nps.OptionMultiFreeList('Multiline List'))
	def load(self):
		try:
			self.reload_from_file('/tmp/test')
		except FileNotFoundError:
			pass
	def save(self):
		self.write_to_file('/tmp/test')

class Form(nps.Form):
	def __init__(self, aName, fields):
		super(Form, self).__init__(name=aName)
		fields.load()
		ms=self.add(nps.OptionListDisplay, name="Option List", values=fields.options, scroll_exit=True, max_height=None)
		self.edit()
		fields.save()

class EntryForm(nps.NPSApp):
	def main(self):
		form=Form("Test Definition", Tests())

if __name__=="__main__":
	app=EntryForm()
	app.run()

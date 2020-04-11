import npyscreen as nps
import yaml
import re

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

import npyscreen as nps
import yaml

class MainForm(nps.Form):
	def __init__(self, name, file_name):
		self.fields={}
		self.values={}
		self.file_name=file_name
		try:
			with open(self.file_name, 'r') as yamlfile:
				self.values=yaml.load(yamlfile)
		except FileNotFoundError:
			pass
		super(MainForm, self).__init__(name)

	def create(self):
		for tag in self.fields:
			self.fields[tag].value=self.values[tag]

	def add_field(self, tag, widgetClass, w_id=None, max_height=None, rely=None, relx=None, *args, **keywords):
		if tag in self.values: keywords['value']=self.values[tag]
		self.fields[tag]=self.add(widgetClass, w_id, max_height, rely, relx, *args, **keywords)

	def afterEditing(self):
		values={}
		for tag in self.fields:
			values[tag]=self.fields[tag].value
		with open(self.file_name, 'w') as yamlfile:
			yaml.dump(values, yamlfile, default_flow_style=False)
		self.parentApp.setNextForm(None)

import configparser

class Status():
	def __init__(self, filename):
		with open(filename, 'r') as f:
			config_string='[data]\n' + f.read()
		config=configparser.ConfigParser()
		config.read_string(config_string)
		self.variables=config['data']
		#for key, val in config['data'].items(): print(key, val)

	def getValue(self, key):
		return self.variables[key]

	def getValues(self):
		return self.variables

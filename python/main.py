#!/usr/bin/python

# Comment
class World:
	def __init__(self, number):
		self.message = "Hello, world of "
		self.number=number
	def ask(self):
		self.name=raw_input("Name: ")
	def getMessage(self):
		return("Hello, world of " + self.name)
	def verify(self):
		if(self.name=="ro"):
			print("It's the boss")
		else:
			print("It's anyone else")
	def heredoc(self):
		print """
		This is a heredoc
		heredoc, I said.
		"""
	def greet(self):
		for count in range(self.number):
			print("Hello, world of " + self.name)

earth=World(4)
earth.ask()
earth.verify()
earth.heredoc()
print(earth.getMessage())
earth.greet()

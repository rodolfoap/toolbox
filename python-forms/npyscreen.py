#!/usr/bin/env python3
import npyscreen
import time
class TestApp(npyscreen.NPSApp):
	def main(self):
		self.form=npyscreen.Form(				name="Willkommen")
		self.title=self.form.add(npyscreen.TitleText, 		name="Text", value="Title")
		self.file1=self.form.add(npyscreen.TitleFilename,	name="Filename")
		self.file2=self.form.add(npyscreen.TitleFilenameCombo,	name="Filename")
		self.datec=self.form.add(npyscreen.TitleDateCombo, 	name="Date")
		self.slidr=self.form.add(npyscreen.TitleSliderPercent, 	name="Slider", accuracy=0, out_of=12)
		self.mltln=self.form.add(npyscreen.MultiLineEdit, 	name="Multis", max_height=5, rely=9)
		self.mltsl=self.form.add(npyscreen.TitleSelectOne, 	max_height=4, value=[1,],
				name="Pick One", values=["Option1", "Option2", "Option3"], scroll_exit=True)
		self.tmtsl=self.form.add(npyscreen.TitleMultiSelect, 	max_height=-2, value=[1,], name="Pick Several",
				values=["Option1","Option2","Option3"], scroll_exit=True)
		self.form.edit()
	def render(self):
		print("TITLE="+self.title.value)
		print("FILE1="+self.file1.value)
		print("FILE2="+self.file2.value)
		print("DATEC="+self.datec.value.strftime("%Y/%m/%d-%H:%M:%S"))

if __name__=="__main__":
	app=TestApp()
	app.run()
	app.render()

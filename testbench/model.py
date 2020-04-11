#!/usr/bin/env python3
import npyscreen as nps
from mainform import MainForm

class Servc(nps.NPSAppManaged):
	def onStart(self):

		test_types=["Unit Test", "Integration Test", "Validation Test", "Model Test"]
		test_rqmts=["Req1", "Req2", "Req3"]
		f=MainForm(name='Example', file_name='data.yaml')
		f.add_field('TestId', nps.TitleText, name="Test Id")
		f.add_field('TestDate', nps.TitleDateCombo, name="Date")

		f.add_field('skip1', nps.FixedText, value="Description")
		f.add_field('TestDescription', nps.MultiLineEdit, max_height=8, relx=4)

		f.add_field('skip2', nps.FixedText, value="Validation Criteria")
		f.add_field('TestValidationCriteria', nps.MultiLineEdit, max_height=8, relx=4)
		f.add_field('TestLauncherFilename', nps.TitleFilenameCombo, name="Test Launcher")
		f.add_field('TestType', nps.TitleMultiSelect, max_height=4, name="Test Type            ", values=test_types, scroll_exit=True)
		f.add_field('TestReqList', nps.TitleMultiSelect, max_height=4, name="Applicable Requirements", values=test_rqmts, scroll_exit=True)

		# Do not erase, examples:
		#.add_field('TitleFilename', nps.TitleFilename, name="Filename:")
		#.add_field('TitleSliderPercent', nps.TitleSliderPercent, accuracy=0, out_of=12, name="Slider")
		#.add_field('TitleSelectOne', nps.TitleSelectOne, max_height=4, name="Pick One", values=["Option1", "Option2", "Option3"], scroll_exit=True)
		#.add_field('TitleMultiSelect', nps.TitleMultiSelect, max_height=-2, name="Pick Several", values=["Option1", "Option2", "Option3"], scroll_exit=True)

		self.registerForm('MAIN', f)

if __name__=='__main__':
	Servc().run()

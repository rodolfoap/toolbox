#!/usr/bin/python
import wx
class bucky(wx.Frame):
	def __init__(self, parent, id):
		wx.Frame.__init__(self, parent, id, "Title", size=(300,200))

	# Button:
		panel=wx.Panel(self)
		button=wx.Button(panel, label="Exit", pos=(120, 10), size=(60, 30))
		self.Bind(wx.EVT_BUTTON, self.closebutton, button)
		self.Bind(wx.EVT_CLOSE, self.closewindow)

	# Text
		box=wx.TextEntryDialog(None, "Name", "Ttitle", "Default text")
		if box.ShowModal()==wx.ID_OK:
			answer=box.GetValue()

	def closebutton(self, event):
		self.Close(True)

	def closewindow(self, event):
		self.Destroy()

if __name__=='__main__':
	app=wx.PySimpleApp()
	frame=bucky(parent=None, id=-1)
	frame.Show()
	app.MainLoop()

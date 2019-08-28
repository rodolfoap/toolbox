#!/bin/python3

import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk

def setLabel(Label, text):
	Label.set_text(text)

class SigHandler:

	def defaultLog (self, button):
		setLabel(builder.get_object("HelloWorldLabel"), "Hello, World!")

	def customLog (self, button):
		customLogInput = builder.get_object("CustomLogInput").get_text()
		setLabel(builder.get_object("HelloWorldLabel"), customLogInput)

	def sigDestroy(self, window):
		Gtk.main_quit()

if __name__ == "__main__":
	builder = Gtk.Builder()
	builder.add_from_file("main.glade")
	window = builder.get_object("window1")
	window.show_all()
	builder.connect_signals(SigHandler())
	Gtk.main()

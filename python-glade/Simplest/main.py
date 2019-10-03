#!/bin/python3

import subprocess
import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk

class SigHandler:

	def defaultLog (self, button):
		builder.get_object("HelloWorldLabel").set_text("Hello, Mundo!")

	def customLog (self, button):
		customLogInput = builder.get_object("CustomLogInput").get_text()
		builder.get_object("HelloWorldLabel").set_text(customLogInput)
		if(customLogInput=="shutdown"):
			subprocess.call(["sudo", "shutdown", "-h", "now"])

	def sigDestroy(self, window):
		Gtk.main_quit()

if __name__ == "__main__":
	builder=Gtk.Builder()
	builder.add_from_file("main.glade")
	builder.get_object("window1").show_all()
	builder.connect_signals(SigHandler())
	Gtk.main()

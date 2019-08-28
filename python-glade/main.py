import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk

def setLabel(Label, text):
	try:
		Label.set_text(text)
	except:
		Gtk.main_quit()

class SignalMaster:

	def defaultLog (self, button):
		setLabel(builder.get_object("HelloWorldLabel"), "Hello, World!")

	def customLog (self, button):
		customLogInput = builder.get_object("CustomLogInput").get_text()
		setLabel(builder.get_object("HelloWorldLabel"), customLogInput)

if __name__ == "__main__":
	builder = Gtk.Builder()
	builder.add_from_file("HelloWorld.glade")
	window = builder.get_object("window1")
	window.show_all()
	builder.connect_signals(SignalMaster())
	Gtk.main()

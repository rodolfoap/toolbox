#!/usr/bin/python3
import glob
import json
import sys
import os.path
import sys
import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk, Gdk

class Form:
        def __init__(self):
                dic={"click_ok"   : self.click_ok,
                     "click_exit" : self.click_exit,
                     "sig_exit"   : self.click_exit}
                self.builder=Gtk.Builder()
                self.builder.add_from_file('Form.ui')
                self.builder.connect_signals(dic)
                self.window=self.builder.get_object("window1")
                self.window.show_all()
                Gtk.main()

        def print(self, id):
                print(id+'='+self.builder.get_object(id).get_text())

        def click_ok(self, widget):
                self.print('data_1')
                self.print('data_2')
                self.print('data_3')
                self.print('data_4')
                self.print('data_5')
                sys.exit(0)

        def click_exit(self, widget):
                sys.exit(0)

# -----------------------------------------------------------------------------
Form()

#!/usr/bin/perl -w

use Glib qw(TRUE FALSE);
use Gtk2;
use Gtk2::GladeXML;

use strict;
use vars qw($main_window);

sub ok_button_clicked {
	my (undef, undef) = @_;  # widget, data are unused
	print "Thanks for trying out my program.\n";

	Gtk2->main_quit;
}

sub on_button1_clicked {
	my (undef, undef) = @_;  # widget, data are unused
	Gtk2->main_quit;
	print "Ok.\n";

}

# No predefined helper functions exist--all must be manually declared.
sub gtk_main_quit {
	Gtk2->main_quit;
	return TRUE;
}

# Init is automatically called
Gtk2->init;

# load the interface
$main_window = Gtk2::GladeXML->new('example-1.glade');

# connect the signals in the interface; since we didn't declare what
# package we were in, perl defaults to 'main'...
$main_window->signal_autoconnect_from_package('main');

# start the event loop
Gtk2->main;


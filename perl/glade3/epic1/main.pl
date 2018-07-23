#!/usr/bin/perl
use strict;
use warnings;
use feature ':5.10';
use Gtk3 '-init';
use Glib qw/TRUE FALSE/;

use subs qw{main on_window_destroy};

my $builder;
my $window;

main();
exit(0);

# -----------------------------------------------------------------
sub main {
	$builder = Gtk3::Builder->new();
	$builder->add_from_file('main.glade');
	$window = $builder->get_object('window1');
	$builder->connect_signals(undef);
	$window->show();
	Gtk3->main();
}

# -----------------------------------------------------------------
sub on_window1_destroy {
	Gtk3->main_quit();
}

# -----------------------------------------------------------------
sub on_button1_clicked {
	my $text1 = $builder->get_object("text1");
	$text1->set_text("Churungo");
}

# -----------------------------------------------------------------
sub on_button2_clicked {
	my $text1 = $builder->get_object("text1");
	print($text1->get_text());
	print("\n");
}

# -----------------------------------------------------------------
sub on_button3_clicked {
	Gtk3->main_quit();
}

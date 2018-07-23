#!/usr/bin/env perl
use strict;
use warnings;
use feature ':5.10';
use Gtk3 '-init';
use Glib qw/TRUE FALSE/;

#use strict;
#use warnings;
#use utf8;
#use Glib qw{ TRUE FALSE };
#use Gtk3 '-init';

use subs qw{ main on_window_destroy };


main();

exit( 0 );


# Subroutines/callbacks
sub
main
{
   my $builder;
   my $window;

   $builder = Gtk3::Builder->new();
   $builder->add_from_file('example1.glade' );

   $window = $builder->get_object( 'window1' );
   $builder->connect_signals( undef );

   $window->show();
   Gtk3->main();
}

sub
on_window_destroy
{
   Gtk3->main_quit();
}


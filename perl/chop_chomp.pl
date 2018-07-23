#!/usr/bin/perl

# Chop: remove last character
# Chomp: remove last character only if is a CR
print "Name: ";
chomp($name=<STDIN>);
print "Hello $name!\n";

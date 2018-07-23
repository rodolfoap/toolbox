#!/usr/bin/perl

print "Name: ";
chomp($name=<STDIN>);
$enam="";
for($x=0; $x<length($name); $x++) {
	        $enam=substr($name, $x, 1).$enam;
}
print "Hello $enam!\n";

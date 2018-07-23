#!/usr/bin/perl -w

print "Introduzca su nombre: ";
$name = <STDIN>;
chomp $name;
print "Hola, $name!\n";
$enam="";
for($x=0; $x<length($name); $x++) {
	$enam=substr($name, $x, 1).$enam;
}
print "Halo, $enam!\n";

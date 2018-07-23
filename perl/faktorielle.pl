#!/usr/bin/perl -w

print "Nummer: ";
chomp($nummer=<STDIN>);

print "$nummer!=";
print "$nummer!=".Fakultaet($nummer)."\n";

sub Fakultaet {
	if($_[0]>1) 	{ 
		print $_[0]." * ";
		return $_[0]*Fakultaet($_[0]-1); 
	}
	else {
		print "1\n";
		return 1; 
	}
}

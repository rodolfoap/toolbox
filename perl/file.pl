#!/usr/bin/perl

open(FILE, $ARGV[0]);
@lines=<FILE>;
close(FILE);

foreach $line (@lines) {
	chomp($line);
	$line =~ s/  +/ /g;
	$line =~ s/\t+/ /g;
	print "$line\n";
}

# ($a, $b, $c)=split(/\|/, $line);
# if ($string =~ m/regex/) print 'match'; else print 'no match';
# $string =~  m/Bill Clinton/;
# $string =~ tr/Bill Clinton/Al Gore/;
# $string =~  m/Bill Clinton/;
# $string =~ tr/Bill Clinton/Al Gore/;
# $string =~  m/Bill Clinton/;
# $string =~   /Bill Clinton/;
# $string =~  m/^Bil Clinton/;
# $string =~  m/Bill Clinton$/;
# $string =~  m/Bill Clinton/i;

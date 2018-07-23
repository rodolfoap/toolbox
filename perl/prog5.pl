#!/usr/bin/perl -w

print "Insert a number to calculate factorial: ";
##$num = substr(<STDIN>, 0, -1);
$num =<STDIN>;
chomp($num);

print "El factorial de $num es ".Factorial($num)."\n";

sub Factorial{
	my $num=$_[0];
	if($num>1) {
		$ret=$num*Factorial($num-1);
	}
	else {
		$ret=1;
	}
	return $ret;
}

#!/usr/bin/perl -w

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

for($num=0; $num<=10; $num++) {
	print "El factorial de $num es ".Factorial($num)."\n";
}

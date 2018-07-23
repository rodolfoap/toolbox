#!/usr/bin/perl

sub maximum {
	if ($_[0] > $_[1]) {
		$_[0];
	}
	else {
		$_[1];
	}
}
$biggest=&maximum(37, 24);
print "Biggest: $biggest\n";

#---------------------------------------------------

sub inside {
	local($a, $b);
	($a, $b)=($_[0], $_[1]);
	$a=~ s/ //g;
	$b=~ s/ //g;			
	($a=~ /$b/ || $b =~ /$a/);
}

$inside=&inside("lemon", "dole money") ? "True" : "False";
print "Inside: $inside\n";

#---------------------------------------------------

sub printargs {
	print "Called with arguments: @_\n";
}
&printargs("perly", "king");
&printargs("frog", "and", "toad");

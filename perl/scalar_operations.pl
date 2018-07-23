#!/usr/bin/perl

# Basic operations

$a=1+2;		# Add 1 and 2 and store in $a
$a=3-4;		# Subtract 4 from 3 and store in $a
$a=5*6;		# Multiply 5 and 6
$a=7/8;		# Divide 7 by 8 to give 0.875
$a=9**10;	# Nine to the power of 10
$a=5%2;		# Remainder of 5 divided by 2
++$a;		# Increment $a and then return it
$a++;		# Return $a and then increment it
--$a;		# Decrement $a and then return it
$a--;		# Return $a and then decrement it

# And for strings Perl has the following among others

$a=$b . $c;	# Concatenate $b and $c
$a=$b x $c;	# $b repeated $c times

# To assign values Perl includes

$a=$b;		# Assign $b to $a
$a+=$b;		# Add $b to $a
$a-=$b;		# Subtract $b from $a
$a.=$b;		# Append $b onto $a

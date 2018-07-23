#!/usr/bin/perl
#http://www.sthomas.net/roberts-perl-tutorial.htm
#Perl Motto: "There is More Than One Way to Do It" or TIMTOWTDI. Pronounced 'Tim-Toady'. 

print "Hola musgo!\n";
$string="PERL";
$num=20;
$num2=10.75;
print "The string is $string, number 1 is $num and number 2 is $num2\n";
print "Doubles: The string is $string and the number is $num\n";
print 'Singles: The string is $string and the number is $num\n';
print "\n";

$num++;
print "\$num is $num\n";

$num--;
print "\$num is $num\n";

$num+=3;
print "\$num is $num\n";

print "a doublequoted string ", $string, ' that was a variable called var ', $num," and a newline \n";

print "Two \$nums are ", $num * 2," and adding one to \$string makes ", ++$string,"\n";

#subrutingas

$num=10;		# sets $num to 10
&print_results;		# prints variable $num

$num++;
&print_results;

$num*=3;
&print_results;

$num/=3;
&print_results;

sub print_results {
        print "\$num is $num\n";
}


$day="sunday";

if ($day eq "sunday") {
        print "Zzzzz....\n";
}


&isit;                   # $test1 is at this moment undefined

$test1="hello";         # a string, not equal to "" or "0"
&isit;

$test1=0.0;             # $test1 is now a number, effectively 0
&isit;

$test1="0.0";           # $test1 is a string, but NOT effectively 0 !
&isit;

sub isit {
        if ($test1) {                           # tests $test1 for truth or not
                print "$test1 is true\n";
        } else {                                # else statement if it is not true
                print "$test1 is false\n";
        }
}

$x=5;
$y=5;

if ($x - $y) {
        print '$x - $y is ',$x-$y," which is true\n";
} else {
        print '$x - $y is ',$x-$y," which is false\n";
}

$lucky=15;
$drawnum=15;

if ($lucky == $drawnum) {
        print "Congratulations!\n";
} else {
        print "Guess who hasn't won!\n";
}
   
$name	 = 'Mark';

$goodguy = 'Tony';

if ($name == $goodguy) {
        print "Hello, Sir.\n";
} else {
        print "Begone, evil peon!\n";
}
#	Comparison  			Numeric  	String
#	Equal 				== 		eq
#	Not equal 			!= 		ne
#	Greater than 			> 		gt
#	Less than 			< 		lt
#	Greater than or equal to 	>= 		ge
#	Less than or equal to 		<= 		le 

$age=25;
$max=30;
$min=18;

if ($age > $max) {
        print "Too old !\n";
} elsif ($age < $min) { 
        print "Too young !\n"; 
} else { 
        print "Just right !\n"; 
}
print "Too old\n" if     $age > $max;
print "Too old\n" unless $age < $max;

# Chop: remove last character
# Chomp: remove last character only if is a CR
print "Please tell me your name: ";
chomp($name=<STDIN>);
print "Thanks for making me happy, $name !\n";


@names=("Muriel","Gavin","Susanne","Sarah","Anna");

print "The elements of \@names are @names\n";
print "The first element is $names[0] \n";
print "The third element is $names[2] \n";
print 'There are ',scalar(@names)," elements in the array\n";

@names=("Muriel","Gavin","Susanne","Sarah","Anna","Paul","Trish","Simon");

print @names;
print "\n";
print "@names";



#!/usr/bin/perl

@colors = ("red", "green", "blue", "cyan", "magenta", "black", "yellow");

$elt=pop(@colors);	# returns "yellow", the last value of the array.
$elt=shift(@colors);	# returns "red", the first value of the array.
$elt=unshift(@colors, "rot");	# inserts "rot" as first value of the array.
push(@colors,"orange"); # adds "orange" to the end of the @colors array

@morecolors=("purple", "teal", "azure");
push(@colors,@morecolors); # appends the values in @morecolors to the end of @colors
pop(@colors); 		# extracts array's last value 
sort(@colors)		# sorts the values of @colors alphabetically

@sortedlist=sort(@colors);
reverse(@colors) 	# inverts the @colors array

$#colors 		# length-1 of the @colors array, or the last index of the array
scalar(@colors); 	# the actual length of the array

join(", ",@colors)	# joins @colors into a single string separated by the expression ", "

@names=("Muriel", "Gavin", "Susanne", "Sarah", "Anna");
print "The elements of \@names are @names\n";
print "The first element is $names[0] \n";
print "The third element is $names[2] \n";
print 'There are ',scalar(@names)," elements in the array\n";

@names=("Muriel","Gavin","Susanne","Sarah","Anna","Paul","Trish","Simon");
print @names."\n";
print "@names";

splice(array, index, length, array2)
	# removes the section of the array defined by index and length, and replaces that section with the elements 
	# from array2. If array2 is omitted, splice() simply deletes. For example, to delete the element 
	# at index $i from an array, use splice(@array, $i, 1).

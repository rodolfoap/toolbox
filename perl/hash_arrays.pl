#!/usr/bin/perl

%pages=	(	"fred", "http://www.cgi101.com/~fred/",
		"beth", "http://www.cgi101.com/~beth/",
		"john", "http://www.cgi101.com/~john/" 
	);

%pages=	(	fred => "http://www.cgi101.com/~fred/",
		beth => "http://www.cgi101.com/~beth/",
		john => "http://www.cgi101.com/~john/" 
	);

print $pages{'fred'}."\n";

foreach $key (keys %pages) {
	print "${key}'s page: $pages{$key}\n"; 
}

foreach $key ("fred", "beth", "john") {
	print "${key}'s page: $pages{$key}\n"; 
}

delete $hash{$key}	# deletes the specified key/value pair, and returns the deleted value
exists $hash{$key}      # returns true if the specified key exists in the hash.
keys %hash              # returns a list of keys for that hash
values %hash            # returns a list of values for that hash
scalar %hash            # returns true if the hash has elements defined (e.g. it's not an empty hash)

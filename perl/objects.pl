#!/usr/bin/perl

package Person;	######################################################################

sub new {
	my $class = shift;
	my $self = {
		_firstName => shift,
		_lastName  => shift,
		_phone       => shift,
	};

	print "First Name is $self->{_firstName}\n";
	print "Last Name is $self->{_lastName}\n";
	print "Phone is $self->{_phone}\n";
	bless $self, $class;
	return $self;
}

sub setFirstName {
	my ($self, $firstName) = @_;
	$self->{_firstName}=$firstName if defined($firstName);
	return $self->{_firstName};
}

sub getFirstName {
	my($self) = @_;
	return $self->{_firstName};
}

package main; ########################################################################

$object=new Person("Bodolfo", "Alkazar", 70656800);
$firstName = $object->getFirstName();
print "Before Setting First Name is : $firstName\n";
$object->setFirstName("Rodolfo");
$firstName = $object->getFirstName();
print "Before Setting First Name is : $firstName\n";

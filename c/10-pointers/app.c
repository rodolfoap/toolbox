#include <stdio.h>

void change(int* p) {
	printf ("Received p == %p \n", p);
	printf ("Received contents of p == %d \n", *p);
	printf ("Changing contents of p to 15.\n");
	*p = 15;
}

void message(char* text){
	printf("%s\n", text);
}

void printFirst(char* text[]) {
	printf("text[0] = %s\n", text[0]); // StringA
}

int main(int argc, char *argv[]) {

	int x=10;

	// This is the first misunderstanding on pointers:
	int *p=&x;	// <-- this (not DEREFERENCING)
	     p=&x;	// has the same meaning as this!
	// Pointer declarations start with an asterisk, but doesn't imply dereferencing
	// That's why sometimes is better to declare:
	// int* p=...

	// General pointer rules:
	// int* p=&x 	declaration of p
	// p=&x		assignation of p
	// x		has  a value,   e.g. 10
	// &x		is  an address, e.g. 0x7fff30f86d34
	// p		has an address, e.g. 0x7fff30f86d34
	// *p		has  a value,   e.g. 10

	// x=10; p=0x7ffcdea0884c
	printf ("x=%d; p=%p \n", x, p);

	// So, this is WRONG (will raise a WARNING)
	*p=&x;	// RAISES A WARNING: puts the address of x into the address pointed by p; in other words, since p=&x, the value of x becomes the address of x
	printf ("WRONG x=%d; x=%p \n", x, x);

	// Some tricks:
	x=10; // We fix the variable x
	printf ("x == %d == %d == %d \n", x, *p, *(&x) ); 	// Several ways to refer to the value of x
	printf ("p == %p == %p \n", p, &x ); 			// Several ways to refer to the value of p

	change (&x);
	printf ("Returned (changed) x=%d \n", x, p);		// x has changed

	// Define a char variable
	char*  chArray1="Hello, World!"; 	// Variable on the Code Segment: CANNOT be modified
	char chArray2[]="Hello, Venus!"; 	// Variable on the Heap: can be modified

	// Use char functions
	message(chArray1);
	message(chArray2);

	// Define a char array
	char* sArray1[3] = {"StringA", "StringB", "StringC"};

	// Use array function
	printFirst(sArray1);

	return 0;
}


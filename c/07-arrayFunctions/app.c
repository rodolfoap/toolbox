#include <stdio.h>

void printArrays(char *text[]);

void printArrays(char *text[]) {
	printf("text[0] = %s\n", text[0]); // StringA
	printf("text[1] = %s\n", text[1]); // StringB
	printf("text[2] = %s\n", text[2]); // StringC
}

int main(int argc, char *argv[]) {

	// Define array aString
	char *aString[3] = {"StringA", "StringB", "StringC"};

	// Print it
	printArrays(aString);

	// Print arguments
	printArrays(argv);

	return 0;
}

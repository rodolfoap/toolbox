#include <stdio.h>
#include <stdlib.h>

typedef struct rec {
	int i;
	float PI;
	char A;
} RECORD;

// Main call
int main(int argc, char *argv[]) {

	RECORD *ptr_one;
	ptr_one=(RECORD *)malloc(sizeof(RECORD));

	(*ptr_one).i =10;
	(*ptr_one).PI=3.14;
	(*ptr_one).A ='a';

	printf("Value 1: %d\n", (*ptr_one).i);
	printf("Value 2: %f\n", (*ptr_one).PI);
	printf("Value 3: %c\n", (*ptr_one).A);

	free(ptr_one);

	return 0;
}

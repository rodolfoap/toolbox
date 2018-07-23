#include <stdio.h>
#define SIZE 5

int main() {
	int x, array[SIZE];

	for(x=0; x<5; x++)
		array[x]=x*10;

	for(x=0; x<5; x++)
		printf ("array[%i]=%i\n", x, array[x]);

	for(x=0; x<5; x++)
		printf ("&array[%i]=%p\n", x, &array[x]);

	for(x=0; x<5; x++)
		printf ("*(&array[%i])=%i\n", x, *(&array[x]));

	for(x=0; x<5; x++)
		printf ("array+%i=%p\n", x, array+x);

	for(x=0; x<5; x++)
		printf ("*(array+%i)=%i\n", x, *(array+x));

	return 0;
}


#include <stdio.h>
int main() {
	int *ptr;
	int array[]={66,55,44,33,22,11,0};
	ptr=&array[0];

	printf ("\n");

	// Address of the first member == array address == ptr
	printf ("&array[0]=%p \n", &array[0]);	// 0x7fff404dbd10
	printf ("array=%p \n", array);		// 0x7fff404dbd10
	printf ("ptr=%p \n", ptr);		// 0x7fff404dbd10

	printf ("\n");

	// Value of first member == array contents == pointer contents
	printf ("array[0]=%i \n", array[0]);	// 55
	printf ("*array=%i \n", *array);	// 55
	printf ("*ptr=%i \n", *ptr);		// 55

	printf ("\n");

	// Value of second member == array+1 contents == pointer[1] contents == pointer+1 contents
	printf ("array[1]=%i \n", array[1]);	// 66
	printf ("*(array+1)=%i\n", *(array+1));	// 66
	printf ("ptr[1]=%i \n", ptr[1]);	// 66
	printf ("*(ptr+1)=%i \n", *(ptr+1));	// 66

	return 0;
}

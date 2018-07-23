#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
	// Will allocate ABC on the heap
	char a[4]="ABC";

	// This is OK
	char *pa=a;
	pa[0]='X';

	// Will allocate ABC on the heap
	char *b;
	b =(char *)malloc(4);
	strncpy(b, "ABC", 4);

	// This is OK
	char *pb=b;
	pb[0]='X';

	// Will keep ABC on the code segment
	char *c="ABC";

	// This will cause a segmentation fault
	char *pc=c;
	pc[0]='X';
}

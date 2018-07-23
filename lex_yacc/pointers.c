#include <stdio.h>
#include <stdlib.h>

int main(){
	// val is the contents of an address
	int val = 313;
	printf("VAL: ADDR:%p; CONTENT:[%d]\n", &val, val);

	// pnt contains an address, *pnt is val
	int *pnt = &val;
	(*pnt)++;
	printf("PNT: ADDR:%p; CONTENT:[%d]\n", pnt, *pnt);

	// foo[] is a pointer with additional functions (add \0, frees memory after use, etc.)
	char foo[]="Croco";
	printf("FOO: ADDR:%p; CONTENT:[%s]\n", *foo, foo);

	// bar is a pointer with no management
	char* bar=malloc(6*sizeof(char));
	bar[0]='P';
	bar[1]='t';
	bar[2]='e';
	bar[3]='r';
	bar[4]='i';
	bar[5]='\0';
	printf("BAR: ADDR:%p; CONTENT:[%s]\n", *bar, bar);

	// Copying the pointer
	char *pba=bar;
	printf("PBA: ADDR:%p; CONTENT:[%s]\n", *pba, pba);

	free(bar);
	return 0;
}


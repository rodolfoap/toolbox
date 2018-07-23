#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
	char *str="Aallo, World!";
	printf("String: %s; Address: %u\n", str, str);

	for(int i=0; i<13; i++) printf("str[%i]\t==\t%c (%x)\n", i, str[i], str[i]);

	return(0);
}

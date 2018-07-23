#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
	char *str;
	str=(char *) malloc(4); // includes \0

	strcpy(str, "abc");
	printf("String: %s; Address: %u\n", str, str);

	free(str);

	return(0);
}

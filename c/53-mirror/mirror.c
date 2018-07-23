#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *mirror(char *text) {

	int  x;
	char *buffer;
	buffer=(char*) malloc(sizeof(text));

	for(x=0; x<strlen(text); x++) { // strlen(text) == 13
		buffer[strlen(text)-1-x]=text[x];
	}
	buffer[strlen(text)]='\0';	// define b[13]

	return (char *)buffer;
}

int main(int argc, char *argv[]) {

	char *droW=mirror("Hello, World!");
	printf("%s\n", droW);
	return 0;
}

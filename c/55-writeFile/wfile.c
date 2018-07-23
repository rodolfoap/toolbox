#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

FILE *fopena(char *name) {
	FILE *stream;
	errno = 0;
	stream = fopen(name, "a+");
	if (stream == NULL) {
		fprintf(stderr, "%s: Couldn't open file %s; %s\n", "fopen", name, strerror(errno));
		exit(EXIT_FAILURE);
	} 
	return stream;
}

int main(int argc, char **argv) {
	FILE *fp=fopena("file.data");
	fprintf(fp, "Hello, World!\n");
	fclose(fp);
}

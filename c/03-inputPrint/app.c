#include <stdio.h>

#define LOG fprintf(stderr, ">>> %s:%d:%s \n", __FILE__, __LINE__, __func__);


// Main call
int main(int argc, char *argv[]) {
	LOG
	char name[128];

	printf("Name: ");
	scanf("%s", name);

	printf("Hello, %s!\n", name);
	return 0;
}

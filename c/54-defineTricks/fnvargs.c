#include <stdio.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>
#include <sys/wait.h>

#define LOG 		fprintf(stderr, ">>> %s:%d:%s \n", __FILE__, __LINE__, __func__);
#define FAIL(msg)	{ fprintf (stderr, "%s: " msg "() failed: %s\n", argv[0], \
			  strerror (errno)); return 1; }
#define printop(var)	printf("%s = %d\n", #var, var);
#define funcSafe(l...)	{l *v = { l }; _func(l, sizeof(v) / sizeof(*v));}

int func(int* values) {
	int x=0;
	while(*values) {
		printf("x = %i; ", x);
		x+= *values++;
		printf("x = %i\n", x);
	}
	printf("%i\n", x);
	LOG
	return x;
}


int main(int argc, char *argv[]) {
	LOG
	funcSafe(3, 2, 1, 4, 5, 0);
	LOG
	printop(1+2);
	FAIL("Error message")
	return 0;
}

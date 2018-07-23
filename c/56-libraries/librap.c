#include <stdio.h>
#define LOG fprintf(stderr, ">>> %s:%d:%s \n", __FILE__, __LINE__, __func__);

int ext_function(char *t) {
	LOG
	printf("%s\n",t);
}

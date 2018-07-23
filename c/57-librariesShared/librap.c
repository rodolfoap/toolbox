#include <stdio.h>
#define LOG fprintf(stderr, ">>> %s:%d:%s \n", __FILE__, __LINE__, __func__);

void foo(void) {
	LOG
}

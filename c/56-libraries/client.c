#include <stdio.h>
#define LOG fprintf(stderr, ">>> %s:%d:%s \n", __FILE__, __LINE__, __func__);

// Main call
int main(int argc, char *argv[]) {
	LOG
	ext_function("Calling librap.c:ext_function() ");
	return 0;
}

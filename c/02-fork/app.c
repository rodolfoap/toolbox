#include <stdio.h>
int main() {
	int pid=fork();
	if(pid==0) {
		printf ("Hello, world %d! (CHILD PID == 0)\n", pid);
	} else {
		printf ("Hello, world %d! (PARENT PID != 0)\n", pid);
	}
	return 0;
}

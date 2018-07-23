#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Always returns an answer of 128
char *ask(char *prompt){
	static char s[128];
	printf("%s: ", prompt);
    	scanf("%s", s);
	return s;
}

// Returns an answer of adequate length
char *ask2(char *prompt){
	char s[128];
	printf("%s: ", prompt);
    	scanf("%s", s);

	char *p=(char *)malloc(strlen(s)+1);
	memcpy (p, s, strlen(s));
  	p[strlen(s)] = '\0';
	return (char *)p;
}

// Just prints a message
void answer(char *text){
	printf("%s[%d]\n", text, strlen(text)+1);
}

int main(int argc, char *argv[]) {
	static char s[128];

	// Can't do s=ask("String");
	strncpy(s, ask("Question"), 128);
	answer(s);

	// Using second question
	answer(ask2("Question2"));
	return 0;
}

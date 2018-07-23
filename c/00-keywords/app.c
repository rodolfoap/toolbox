/*
 * Some generic C features
 * */
#include <stdio.h>
#include <string.h>

/*
 * Types
 */
static int dummy1;
const volatile dummy2;

int i;
char alphabet;

float number2;
double longNumber;

short int smallInteger;		// short    int         -32768          to      32767
long int bigInteger;		// long     int         -2147483648     to      214743648
signed int normalInteger;	// signed   int         -32768          to      32767
unsigned int positiveInteger;	// unsigned int         0               to      65535

const int a = 5;

typedef float animal;
animal bear, tiger;

struct sStudent {
	char name[80];
	float marks;
	int age;
} s1, s2;

union uStudent {
	char name[80];
	float marks;
	int age;
};

enum suit  { hearts, spades, clubs, diamonds }; // By default, hearts=0, spades=1 ...
enum state { Working = 1, Failed = 0 };		// Other form

int main()
{

	char buffer[128]="World";
	enum suit card;
	card=spades;

	printf("Hello, %s!\n", buffer);		// Example string usage
	printf("Card=%d\n", card);		// Will print 1

	//sizeof
	printf("%u bytes.\n", sizeof(buffer));

	for (i = 1; i < 9; ++i) {
		if (i == 3) continue;
		if (i == 17) break;
		printf("%d\n", i);
		if (i == 9) goto noerror;
	}
	goto noerror;
	printf("Error\n");

	noerror:
	printf("No Error\n");
	printf("%d\n", i);

	switch (1) {
	case '1':
		printf("Switch 1\n");
		break;
	case '5':
		printf("Switch 5\n");
		break;

	default:
		//some statements to execute when default;
		printf("Default\n");
	}

	i=88; do {
		printf("%d\n", i++);
	} while (i < 100);

	return 0;
}

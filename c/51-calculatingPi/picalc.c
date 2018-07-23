/* Compilar con gcc -lm pi.c -o pi.out */
#include <stdio.h>
#include <math.h>
#include <fenv.h>
#define ITERATIONS 10000000

double pi1(unsigned long int i);
double pi2(unsigned long int i);
double pi3(unsigned long int i);

int main() {
	double pi;

	printf("\nCalculating pi(%i iterations) with Leibniz method... \n", ITERATIONS);
	pi=pi1(ITERATIONS);
	printf ("Pi=%82.80f\n", pi);

	printf("\nCalculating pi(%i iterations) with Wallis method... \n", ITERATIONS);
	pi=pi2(ITERATIONS);
	printf ("Pi=%82.80f\n", pi);

	printf("\nCalculating pi(%i iterations) with Machin method... \n", ITERATIONS);
	pi=pi3(ITERATIONS);
	printf ("Pi=%82.80f\n", pi);

	return 0;
}

double pi1(unsigned long int i) {
	unsigned long int n;
	double pi=0.0;
	for(n=0; n<i; n++) 
		pi=pi+4.0/(double)(4.0*(long)n+1.0)-4.0/(double)(4.0*(long)n+3.0);
	return pi;
}

double pi2(unsigned long int i) {
	unsigned long int n;
	double pi=1.0;
	for(n=0; n<i; n++) 
		pi=pi * ( (2*(double)n+2) / (2*(double)n+1) * (2*(double)n+2) / (2*(double)n+3) );
	return 2*pi;
}

double pi3(unsigned long int i) {
	unsigned long int k;
	double pi=0;
	for(k=0; k<i; k++) 
		pi=pi + 4 * pow(-1.0, (double)k) / (2*k+1) / pow(5.0, (2*(double)k+1)) - pow(-1.0, (double)k) / (2*k+1) / pow(239.0, (2*(double)k+1));
	return 4*pi;
}

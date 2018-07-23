/**** Declarations ***************************/
/* .. Name character-class ................. */

digit 	[0-9]
letter 	[A-Za-z]

/* .. C Declarations ....................... */

%{
	int count;
	int coutn;
	int cerrs;
%}

%% /* Token Rules ****************************/

{digit}+			{ printf("NUMBR[%d]:\t", ++coutn); ECHO; }

{letter}+			{ printf("LL-ID[%d]:\t", ++count); ECHO; }

{letter}({letter}|{digit})*	{ printf("LD-ID[%d]:\t", ++count); ECHO; }

{digit}{letter}+		{ printf("ERROR[%d]:\t", ++cerrs); ECHO; }

%% /* Auxiliar Procedures ********************/

int main(void) {
	yylex();
	printf("Total IDs=\t%d\n", count);
	printf("Total Nums=\t%d\n", coutn);
	printf("Total Errs=\t%d\n", cerrs);
	return 0;
}


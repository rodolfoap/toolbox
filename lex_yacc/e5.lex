/**** Declarations ***************************/
/* .. Name character-class ................. */

PRINT		print
WORD		[A-Za-z_][A-Za-z0-9_]*
NUMBER		[0-9]+
SYMBOL		[+=]
SPACE		[\t ]+
CR		[\n]+
EOL		[;]
OTHER		.

/* .. C Declarations ....................... */

%{
%}

%% /* Token Rules ****************************/

{EOL}				{ printf("\n#"); }

{PRINT}				{ printf("\necho MESSAGE: "); }

{WORD}				{ ECHO; }

{NUMBER}			{ ECHO; }

{SYMBOL}			{ ECHO; }

{SPACE}				{ printf(" "); }

{CR}

{OTHER}				{ ECHO; }

%% /* Auxiliar Procedures ********************/

int main(void) {
	printf("#!/bin/bash\n\n# This generates a simple bash echo printing script\n\n#");
	yylex();
	printf("\n");
	return 0;
}


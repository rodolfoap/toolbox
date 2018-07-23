/**** Declarations ***************************/
/* .. Name character-class ................. */
/* .. C Declarations ....................... */

%{
		int nchar, nword, nline;
%}

%% /* Token Rules ****************************/

^\n		{ nline++; printf("|\n"); } 

^[\t ]+\n	{ nline++; printf("%d[", yyleng-1); fwrite(yytext, yyleng-1, 1, yyout); printf("]|\n"); }

\n		{ nline++; nword++; printf("|\n"); }

[ \t]		{ nword++; printf("_"); }

[a-zA-Z]	{ nchar++; printf("["); ECHO; printf("]"); }

%% /* Auxiliar Procedures ********************/

int main(void) {
	yylex();
	printf("Chars=%d\tWords=%d\tLines=%d\n", nchar, nword, nline);
	return 0;
}

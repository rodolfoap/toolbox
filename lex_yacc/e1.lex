/**** Declarations ***************************/
/* .. Name character-class ................. */
/* .. C Declarations ....................... */

%{
	int yylineno;
%}

%% /* Token Rules ****************************/

^(.*)\n	printf("%4d\t%s", yylineno++, yytext);

%% /* Auxiliar Procedures ********************/

int main(int argc, char *argv[]) {
	// Why is this here?
	// yyin = fopen(argv[1], "r");

	yylex();

	// fclose(yyin);
}

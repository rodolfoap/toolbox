/**** Declarations ***************************/
/* .. Name character-class ................. */
/* .. C Declarations ....................... */

%% /* Token Rules ****************************/

	/* match a */
a	printf("A");

	/* match r */
r	ECHO;

[ ]	printf("_");

	/* the same meaning as ECHO */
.	fwrite(yytext, yyleng, 1, yyout);

	/* match newline */
\n	printf("[ENTER]");

%% /* Auxiliar Procedures ********************/

int yywrap(void) {
	return 1;
}
int main(void) {
	yylex();
	printf("\n");
	return 0;
}

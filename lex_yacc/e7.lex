/**** Declarations: Name character-class *******/

id	[a-zA-Z][_a-zA-Z0-9]*
int	[1-9][0-9]*
wspc	[ \t\n]

/**** Declarations: C Declarations *************/

%{
	#include "e7.h"
%}

%option nounput yylineno

%% /* Token Rules ******************************/

:		return COLON;
"db_type"	return VTYPE;
"db_name"	return VNAME;
"db_prfx"	return VPRFX;
"db_port"	return VPORT;
{id}		return IDENT;
{int}		return INTEG;
{wspc}		;
.		printf("PARSE: Unexpected: [%s]\n", yytext);

%% /* Auxiliar Procedures **********************/

int yywrap(void)
{
	return 1;
}

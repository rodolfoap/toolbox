%{
	#include <stdio.h>
	int toknum = 0;
%}
%token	ID 1 NUM 2 PLUS 3 MULT 4 LPAREN 5 RPAREN 6

%start s

%%

s :	e ;

e :	e PLUS t
  |	t ;

t :	t MULT f
  |	f ;

f :	ID
  |	NUM
  |	LPAREN e RPAREN ;

%%
	#include "lexyy.c"
	void main ()
	{
		if (!yyparse())	printf (" success!\n");
		else printf (" failure\n");
	}

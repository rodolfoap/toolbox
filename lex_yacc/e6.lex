/**** Declarations: Name character-class *******/

A	[A-Za-z]
D	[0-9]

/**** Declarations: C Declarations *************/

%{
	#include "e6.h"
	int toknum;
%}

%% /* Token Rules ******************************/

{A}({A}|{D})*	{ toknum++; return (ID); 	}
{D}+		{ toknum++; return (NUM);	}
"+"		{ toknum++; return (PLUS);	}
"*"		{ toknum++; return (MULT);	}
")"		{ toknum++; return (RPAREN);	}
"("		{ toknum++; return (LPAREN);	}
.		;

%% /* Auxiliar Procedures **********************/

//int main(void) {
//	printf("#!/bin/bash\n\n# This generates a simple bash echo printing script\n\n#");
//	yylex();
//	printf("\n");
//	return 0;
//}

int yyerror ()
{
	printf("ERROR@Token[%d]\n", toknum);
	return(1);
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "e7.h"

extern int yylex();
extern int yylineno;
// FLEX uses char*
extern char* yytext;
// LEX uses char[]
// extern char yytext[];

char *var[] = {NULL, NULL, "db_type", "db_name", "db_prfx", "db_port"};

int main(void) 
{

	int lnNumber, lftToken, midToken, rgtToken;
	char *lftTx, *midTx, *rgtTx;
	lftTx=malloc(32*sizeof(char));
	midTx=malloc(32*sizeof(char));
	rgtTx=malloc(32*sizeof(char));
	
	lftToken = yylex();		// GETS LEFT TOKEN 	db_name : db1
	while(lftToken) {		//			=======
		strcpy(lftTx, yytext);	//
		midToken = yylex();	// GETS MIDDLE TOKEN 	db_name : db1
		strcpy(midTx, yytext);	//				=
					//
		rgtToken = yylex();	// GETS RIGHT TOKEN 	db_name : db1
		strcpy(rgtTx, yytext);	//				  ===
					//
		lnNumber = yylineno;	// GETS LINENUMBER

		printf("%d:[%d|%d|%d]", lnNumber, lftToken ,midToken, rgtToken);
		printf("==[%s|%s|%s]",  lftTx, midTx, rgtTx);
		printf("V[%d]=[%s]\t",  lftToken, var[lftToken]);

		// Processing ===============================================
		
		if(midToken!=COLON) { printf("\nERROR [%d]: Expected[:], found[%s]. Aborting.\n", yylineno, midTx); return 1; }
		switch (lftToken) {
		case VTYPE:
		case VNAME:
		case VPRFX:
			if(rgtToken!=IDENT)  { printf("\nERROR [%d]: Expected[ID], found[%s]. Aborting.\n", yylineno, rgtTx); return 1; }
			printf("OK: [%s]==[%s]\n", var[lftToken], yytext);
			break;
		case VPORT:
			if(rgtToken!=INTEG) { printf("\nERROR [%d]: Expected[INT], found[%s]. Aborting.\n", yylineno, rgtTx); return 1; }
			printf("OK: [%s]==[%s]\n", var[lftToken], yytext);
			break;
		default:
			printf("\nERROR LN[%d]. Aborting.\n", yylineno); 
			return 1;
		}
		lftToken = yylex();	// GETS LEFT TOKEN      db_name : db1
	}				//			=======
	return 0;
}

package uk.ac.ucl.comp2010.bestgroup;

import java_cup.runtime.*;
import java.io.IOException;

import uk.ac.ucl.comp2010.bestgroup.QSym;
import static uk.ac.ucl.comp2010.bestgroup.QSym.*;

%%

%class QLex

%unicode
%line
%column

%public
%final
// %abstract

%cupsym uk.ac.ucl.comp2010.bestgroup.QSym
%cup
// %cupdebug

%init{
	// TODO: code that goes to constructor
%init}

%{
	private Symbol sym(int type)
	{
		return sym(type, yytext());
	}

	private Symbol sym(int type, Object value)
	{
		return new Symbol(type, yyline, yycolumn, value);
	}

	private void error()
	throws IOException
	{
		throw new IOException("illegal text at line = "+yyline+", column = "+yycolumn+", text = '"+yytext()+"'");
	}
%}


WHITESPACE			=	[ \t\r\n\f\v]*

DIGIT				= 	[0-9]
INT					=	-?{DIGIT}+
FLOAT				=	-?{DIGIT}+\.{DIGIT}+
CHAR				=	\' [a-zA-Z0-9,!@#$%&\^\*\(\)] \' 
BOOL				=	true|false
STRING				=	\"{char}+\"
COMPARISON			= 	<|<=|>|>=|==|!=
ID					=	[a-z] [:jletterdigit:]*
TYPE				= 	bool|int|float|char|string|list|tuple

LINECOMMENT			=	"//"[^\r\n]*[\r\n]
MULTILINECOMMENT	=	"/*".+"*/"

COMMENT				=	{LINECOMMENT} | {MULTILINECOMMENT} 

%%

"!"					{	return sym(NOT);	 			}
"||"				{ 	return sym(OR); 	 			}
"&&"				{	return sym(AND);	 			}
"+"					{	return sym(PLUS);	 			}
"-"					{ 	return sym(MINUS); 				}
"*"					{	return sym(TIMES); 				}
"/"					{	return sym(DIVIDE);				}
"^"					{	return sym(POWER); 				}
"<"					{	return sym(LESS);  				}
">"					{	return sym(GREATER);			}
"<="				{	return sym(LESSEQUALS);			}
"=<" 				{ 	return sym(GREATEREQUALS);		}
"=="				{	return sym(EQUALSCOMPARISON);	}
"!="				{	return sym(NOT);				}
"in"				{	return sym(IN);					}
"="					{	return sym(EQUALS);				}
";"					{	return sym(SEMICOLON);			}
":"					{	return sym(COLON);				}
","					{	return sym(COMMA);				}
"("					{	return sym(BRACKETOPEN);		}	
")"					{	return sym(BRACKETCLOSE);		}
"["					{	return sym(SQUAREBRACKETOPEN);	}
"]"					{	return sym(SQUAREBRACKETCLOSE);	}
"{"					{	return sym(CURLYBRACKETOPEN);	}
"}"					{	return sym(CURLYBRACKETCLOSE);	}
"[|"				{	return sym(TUPLELEFT);			}
"|]"				{	return sym(TUPLERIGHT);			}
"if"				{	return sym(IF);					}
"else"				{ 	return sym(ELSE);				}
"return"			{	return sym(RETURN);				}
"while"				{	return sym(WHILE);				}
"do"				{	return sym(DO);					}
"repeat"			{	return sym(REPEAT);				}
"until"				{	return sym(UNTIL);				}
"tdef"				{	return sym(TDEF);				}
"fdef"				{	return sym(FDEF);				}
{TYPE}				{	return sym(TYPE);				}
{BOOL}				{	return sym(BOOL); 				}
{CHAR}				{ 	return sym(CHAR); 				}
{FLOAT}				{	return sym(FLOAT);				}
{INT}				{	return sym(INT);				}
{ID}				{	return sym(ID);					}


{WHITESPACE}		{ /* ignore whitespace*/ }

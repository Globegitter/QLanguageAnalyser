package uk.ac.ucl.comp2010.bestgroup;

import java_cup.runtime.*;
import java.io.IOException;

import uk.ac.ucl.comp2010.bestgroup.QSym;
import static uk.ac.ucl.comp2010.bestgroup.QSym.*;
import java.util.LinkedList;

%%

%class QLex

%unicode
%line
%column

%public
%final

%cupsym uk.ac.ucl.comp2010.bestgroup.QSym
%cup
%cupdebug

%init{
	
%init}

%{
	public String section = "Declarations";
	
	private LinkedList<String> extraTypes = new LinkedList<String>();
	private LinkedList<String> extraFunctions = new LinkedList<String>();
	
	public boolean addType(String type) {
		if(isType(type))
			return false;
		extraTypes.add(type);
		return true;
	}
	
	public boolean isType(String type) {
		if(extraTypes.indexOf(type)==-1)
			return false;
		return true;
	}
		
	private Symbol sym(int type)
	{
		return sym(type, yytext());
	}

	private Symbol sym(int type, Object value)
	{
		return new Symbol(type, yyline, yycolumn, value);
	}
%}


WHITESPACE			=	[ \t\r\n\f\v]*

DIGIT				= 	[0-9]
INT					=	-?{DIGIT}+
FLOAT				=	-?{DIGIT}+\.{DIGIT}+
CHARACTER			= 	[ a-zA-Z0-9,!@#$%_&+\-\^\*\(\)]
CHAR				=	\' {CHARACTER} \' | \" {CHARACTER} \"
TRUE				=	true
FALSE				=	false
STRING				=	\"{CHARACTER}*\"
ID					=	[a-zA-Z] [:jletterdigit:]*
TYPE				= 	bool|int|float|char|string|list|tuple

LINECOMMENT			=	"//"[^\r\n]*[\r\n]

ANY					=	.|[ \t\r\n\f\v]

%state COMMENT


%%


<YYINITIAL> {

	"!"					{	return sym(NOT);	 			}
	"||"				{ 	return sym(OR); 	 			}
	"&&"				{	return sym(AND);	 			}
	"+"					{	return sym(PLUS);	 			}
	"-"					{ 	return sym(MINUS); 				}
	"*"					{	return sym(TIMES); 				}
	"/"					{	return sym(DIVIDE);				}
	"^"					{	return sym(POWER); 				}
	"<="				{	return sym(LESSEQUALS);			}
	">=" 				{ 	return sym(GREATEREQUALS);		}
	"<"					{	return sym(LESS);  				}
	">"					{	return sym(GREATER);			}
	"=="				{	return sym(EQUALSCOMPARISON);	}
	"!="				{	return sym(NOT);				}
	"in"				{	return sym(IN);					}
	"="					{	return sym(EQUALS);				}
	";"					{	return sym(SEMICOLON);			}
	"::"				{	return sym(CONCAT);				}
	":"					{	return sym(COLON);				}
	","					{	return sym(COMMA);				}
	"."					{	return sym(DOT);				}
	"("					{	return sym(BRACKETOPEN);		}	
	")"					{	return sym(BRACKETCLOSE);		}
	"[|"				{	return sym(TUPLELEFT);			}
	"|]"				{	return sym(TUPLERIGHT);			}
	"["					{	return sym(SQUAREBRACKETOPEN);	}
	"]"					{	return sym(SQUAREBRACKETCLOSE);	}
	"{"					{	return sym(CURLYBRACKETOPEN);	}
	"}"					{	return sym(CURLYBRACKETCLOSE);	}
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
	{TRUE}				{	return sym(BOOL, true);			}
	{FALSE}				{	return sym(BOOL, false);		}
	{CHAR}				{   char[] chars = yytext().toCharArray(); return sym(CHAR, chars[1]); 	}
	{STRING}			{ 	return sym(STRING, yytext().substring(1, yytext().length()-1));		}
	{FLOAT}				{	return sym(FLOAT, Float.parseFloat(yytext()));						}
	{INT}				{	return sym(INT, Integer.parseInt(yytext()));						}
	{ID}				{	if(isType(yytext())) {
								return sym(CUSTOMTYPE);				
							} else {
								return sym(ID);
							}
						}
						
	"/*"				{ 	yybegin(COMMENT);}						
	{WHITESPACE}		{ /* ignore whitespace*/ }
	{LINECOMMENT}		{ /* ignore comments*/ }
	{ANY}				{	System.err.println("Could not interpret character '" + yytext() + "' at line " + yyline + " (" + section + ")"); }   


}


<COMMENT> {
	"*/"				{	yybegin(YYINITIAL);				}
	{ANY}				{									}
}	
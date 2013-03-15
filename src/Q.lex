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

DIGIT				= 	[0-9]
INT					=	-?{DIGIT}+
FLOAT				=	-?{DIGIT}+.{[1-9]}+
CHAR				=	\' {DIGIT} | [a-zA-Z] | [\p{P}] \' 
BOOL				=	true|false
SEQUENCE			=	
COMPARISON			=	

SEQUENCEID			=	
ID					=

COMMENT				=	

TDEF				=	tdef
FDEF				=	fdef
VOID				=	void
RETURN				=	return
VAR					=	var
IF					=	if
ELSE				=	else
WHILE				=	while
DO					=	do
REPEAT				=	repeat
UNTIL				=	until
BRACKETOPEN			=	(
BRACKETCLOSE		=	)
CURLYBRACKETOPEN	=	{
CURLYBRACKETCLOSE	=	}

WHITESPACE			=	[ \t\r\n\f]*

%%

{FDEF}				{	return sym(FDEF); }
{ANY}				{	return sym(ANY); }
{WHITESPACE}		{ /* ignore whitespace*/ }

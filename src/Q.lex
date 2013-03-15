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

ANY				=	[^ \t\r\n]*
FDEF			=	fdef
WHITESPACE		=	[ \t\r\n]*

%%

{FDEF}				{	return sym(FDEF); }
{ANY}				{	return sym(ANY); }
{WHITESPACE}		{ /* ignore whitespace*/ }
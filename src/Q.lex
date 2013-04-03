package uk.ac.ucl.comp2010.bestgroup;

%%

%class QLex
%cupsym uk.ac.ucl.comp2010.bestgroup.QSym

%unicode
%cup
%line
%column
%states INCOMMENT


%{
	QHelper h;
	public int getLine() { return yyline; }
	public int getCol() {return yycolumn; }
	private StringBuilder badinput = null;
%}

%init{
	h = new QHelper(this);
%init}


/* Macros */

Whitespace = [\ \t\n\r]+
NewLine = \r|\n|\r\n

LineComment = "//".*{NewLine}

Identifier = [:jletter:] [:jletterdigit:]*
BooleanLiteral = "true" | "false"
IntegerLiteral = ("-")?[:digit:]+
FloatLiteral = ("-")?[:digit:]+\.[:digit:]+
StringLiteral = "\"" ~"\"" 
CharLiteral = "'"[:letter:]"'"

%states ERROR

%%

<YYINITIAL> {

{Whitespace} {}
{LineComment} {}

// Types
"bool"				{return h.sym(QSym.BOOL); }
"int"				  {return h.sym(QSym.INT); }
"char"				{return h.sym(QSym.CHAR); }
"float"				{return h.sym(QSym.FLOAT); }
"string"			{return h.sym(QSym.STRING); }
"list"				{return h.sym(QSym.LIST); }
"void"				{return h.sym(QSym.VOID);}

// Declarations
"fdef"				{return h.sym(QSym.FDEF);}
"tdef"				{return h.sym(QSym.TDEF);}

// Operators

// Logical Operators
"\!"				{return h.sym(QSym.NOT); }
"||"				{return h.sym(QSym.OR); }
"&&"				{return h.sym(QSym.AND); }

// Numerical Operators
"\+"				{return h.sym(QSym.PLUS); }
"-"					{return h.sym(QSym.MINUS); }
"\*"				{return h.sym(QSym.MULTIPLY); }
"/"					{return h.sym(QSym.DIVIDE); }
"\^"				{return h.sym(QSym.POWER); }

// Sequence Operators
"::"				{return h.sym(QSym.CONCAT);}
"in"				{return h.sym(QSym.IN); }
"len"				{return h.sym(QSym.LENGTH); }

// Comparison Operators
"<"					{return h.sym(QSym.LESSTHAN); }
"<="				{return h.sym(QSym.LESSTHANEQUAL); }
">"					{return h.sym(QSym.GREATERTHAN); }
">="				{return h.sym(QSym.GREATERTHANEQUAL); }
"=="				{return h.sym(QSym.EQUAL); }
"!="				{return h.sym(QSym.NOTEQUAL); }

// Expression Operators
"."					{return h.sym(QSym.DOT); }
"="					{return h.sym(QSym.ASSIGN); }

// Structural Tokens
"{"					{return h.sym(QSym.LEFTBRACE); }
"}"					{return h.sym(QSym.RIGHTBRACE); }
"["					{return h.sym(QSym.LEFTBRACKET); }
"]"					{return h.sym(QSym.RIGHTBRACKET); }
"[|"				{return h.sym(QSym.LEFTTBRACKET); }
"|]"				{return h.sym(QSym.RIGHTTBRACKET); }
";"					{return h.sym(QSym.SEMICOLON); }
":"					{return h.sym(QSym.COLON); }
"("					{return h.sym(QSym.LEFTPAREN); }
")"					{return h.sym(QSym.RIGHTPAREN); }
","					{return h.sym(QSym.COMMA); }

// Literals
{CharLiteral}	    {return h.parseChar(yytext());}
{BooleanLiteral}	{return h.parseBool(yytext());}
{FloatLiteral}		{return h.parseFloat(yytext());}
{IntegerLiteral}	{return h.parseInteger(yytext());}
{StringLiteral}		{return h.parseString(yytext());}

// Control Flow
"if"  				{return h.sym(QSym.IF);}
"else"				{return h.sym(QSym.ELSE);}
"repeat"			{return h.sym(QSym.REPEAT);}
"while"				{return h.sym(QSym.WHILE);}
"do"  				{return h.sym(QSym.DO); }
"until"				{return h.sym(QSym.UNTIL); }
"return"			{return h.sym(QSym.RETURN); }

// Identifier
{Identifier}		{return h.sym(QSym.ID, yytext());}

// Multiline Comment
"/*"       { yybegin(INCOMMENT); }

// Error Handling
.					{ 
						yybegin(ERROR);
       			badinput = new StringBuilder(yytext()); 
       		}
}

<INCOMMENT> {
"*/"      { yybegin(YYINITIAL); }
[^*\n]+   {} // eat comment in chunks
"*"       {} // eat the lone star
"\n"      {} 
}


<ERROR> {
[\{\}\(\);] | {Whitespace}
					{
						yypushback(1);
						yybegin(YYINITIAL);
						System.err.println("Error: unknown input " + badinput + " found at line " + yyline + ", character " + yycolumn);
					}
. 					{badinput.append(yytext());}
}

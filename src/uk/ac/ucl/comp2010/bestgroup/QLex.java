/* The following code was generated by JFlex 1.4.3 on 3/15/13 3:54 PM */

package uk.ac.ucl.comp2010.bestgroup;

import java_cup.runtime.*;
import java.io.IOException;

import uk.ac.ucl.comp2010.bestgroup.QSym;
import static uk.ac.ucl.comp2010.bestgroup.QSym.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/15/13 3:54 PM from the specification file
 * <tt>C:/Users/Markus/EclipseWorkspace/Java/Year2/QLanguageAnalyser/src/Q.lex</tt>
 */
public final class QLex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\1\1\0\1\1\1\1\16\0\4\0\1\1\1\25"+
    "\1\0\1\0\1\0\1\0\1\27\1\0\2\0\1\24\1\30\1\34"+
    "\1\2\1\0\1\23\12\0\1\33\1\32\1\13\1\14\1\15\1\0"+
    "\1\0\32\0\3\0\1\31\1\0\1\0\1\10\1\0\1\0\1\36"+
    "\1\6\1\7\1\0\1\21\1\17\2\0\1\11\1\0\1\20\1\16"+
    "\1\22\1\0\1\4\1\12\1\3\1\5\1\1\1\35\3\0\1\0"+
    "\1\26\2\0\41\0\2\0\4\0\4\0\1\0\2\0\1\0\7\0"+
    "\1\0\4\0\1\0\5\0\27\0\1\0\37\0\1\0\u01ca\0\4\0"+
    "\14\0\16\0\5\0\7\0\1\0\1\0\1\0\21\0\165\0\1\0"+
    "\2\0\2\0\4\0\10\0\1\0\1\0\3\0\1\0\1\0\1\0"+
    "\24\0\1\0\123\0\1\0\213\0\1\0\5\0\2\0\236\0\11\0"+
    "\46\0\2\0\1\0\7\0\47\0\11\0\55\0\1\0\1\0\1\0"+
    "\2\0\1\0\2\0\1\0\1\0\10\0\33\0\5\0\3\0\15\0"+
    "\4\0\7\0\1\0\4\0\13\0\5\0\112\0\4\0\146\0\1\0"+
    "\11\0\1\0\12\0\1\0\23\0\2\0\1\0\17\0\74\0\2\0"+
    "\145\0\16\0\66\0\4\0\1\0\5\0\56\0\22\0\34\0\244\0"+
    "\144\0\2\0\12\0\1\0\7\0\1\0\7\0\1\0\3\0\1\0"+
    "\10\0\2\0\2\0\2\0\26\0\1\0\7\0\1\0\1\0\3\0"+
    "\4\0\2\0\11\0\2\0\2\0\2\0\4\0\10\0\1\0\4\0"+
    "\2\0\1\0\5\0\2\0\16\0\7\0\1\0\5\0\3\0\1\0"+
    "\6\0\4\0\2\0\2\0\26\0\1\0\7\0\1\0\2\0\1\0"+
    "\2\0\1\0\2\0\2\0\1\0\1\0\5\0\4\0\2\0\2\0"+
    "\3\0\3\0\1\0\7\0\4\0\1\0\1\0\7\0\20\0\13\0"+
    "\3\0\1\0\11\0\1\0\3\0\1\0\26\0\1\0\7\0\1\0"+
    "\2\0\1\0\5\0\2\0\12\0\1\0\3\0\1\0\3\0\2\0"+
    "\1\0\17\0\4\0\2\0\12\0\1\0\1\0\17\0\3\0\1\0"+
    "\10\0\2\0\2\0\2\0\26\0\1\0\7\0\1\0\2\0\1\0"+
    "\5\0\2\0\11\0\2\0\2\0\2\0\3\0\10\0\2\0\4\0"+
    "\2\0\1\0\5\0\2\0\12\0\1\0\1\0\20\0\2\0\1\0"+
    "\6\0\3\0\3\0\1\0\4\0\3\0\2\0\1\0\1\0\1\0"+
    "\2\0\3\0\2\0\3\0\3\0\3\0\14\0\4\0\5\0\3\0"+
    "\3\0\1\0\4\0\2\0\1\0\6\0\1\0\16\0\12\0\11\0"+
    "\1\0\7\0\3\0\1\0\10\0\1\0\3\0\1\0\27\0\1\0"+
    "\12\0\1\0\5\0\3\0\10\0\1\0\3\0\1\0\4\0\7\0"+
    "\2\0\1\0\2\0\6\0\4\0\2\0\12\0\22\0\2\0\1\0"+
    "\10\0\1\0\3\0\1\0\27\0\1\0\12\0\1\0\5\0\2\0"+
    "\11\0\1\0\3\0\1\0\4\0\7\0\2\0\7\0\1\0\1\0"+
    "\4\0\2\0\12\0\1\0\2\0\17\0\2\0\1\0\10\0\1\0"+
    "\3\0\1\0\51\0\2\0\10\0\1\0\3\0\1\0\5\0\10\0"+
    "\1\0\10\0\4\0\2\0\12\0\12\0\6\0\2\0\2\0\1\0"+
    "\22\0\3\0\30\0\1\0\11\0\1\0\1\0\2\0\7\0\3\0"+
    "\1\0\4\0\6\0\1\0\1\0\1\0\10\0\22\0\2\0\15\0"+
    "\72\0\4\0\20\0\1\0\12\0\47\0\2\0\1\0\1\0\2\0"+
    "\2\0\1\0\1\0\2\0\1\0\6\0\4\0\1\0\7\0\1\0"+
    "\3\0\1\0\1\0\1\0\1\0\2\0\2\0\1\0\15\0\1\0"+
    "\3\0\2\0\5\0\1\0\1\0\1\0\6\0\2\0\12\0\2\0"+
    "\2\0\42\0\1\0\27\0\2\0\6\0\12\0\13\0\1\0\1\0"+
    "\1\0\1\0\1\0\4\0\12\0\1\0\44\0\4\0\24\0\1\0"+
    "\22\0\1\0\44\0\11\0\1\0\71\0\112\0\6\0\116\0\2\0"+
    "\46\0\12\0\53\0\1\0\1\0\3\0\u0149\0\1\0\4\0\2\0"+
    "\7\0\1\0\1\0\1\0\4\0\2\0\51\0\1\0\4\0\2\0"+
    "\41\0\1\0\4\0\2\0\7\0\1\0\1\0\1\0\4\0\2\0"+
    "\17\0\1\0\71\0\1\0\4\0\2\0\103\0\2\0\3\0\40\0"+
    "\20\0\20\0\125\0\14\0\u026c\0\2\0\21\0\1\0\32\0\5\0"+
    "\113\0\3\0\3\0\17\0\15\0\1\0\7\0\13\0\25\0\13\0"+
    "\24\0\14\0\15\0\1\0\3\0\1\0\2\0\14\0\124\0\3\0"+
    "\1\0\3\0\3\0\2\0\12\0\41\0\3\0\2\0\12\0\6\0"+
    "\130\0\10\0\53\0\5\0\106\0\12\0\35\0\3\0\14\0\4\0"+
    "\14\0\12\0\50\0\2\0\5\0\13\0\54\0\4\0\32\0\6\0"+
    "\12\0\46\0\34\0\4\0\77\0\1\0\35\0\2\0\13\0\6\0"+
    "\12\0\15\0\1\0\130\0\114\0\4\0\12\0\21\0\11\0\14\0"+
    "\53\0\3\0\14\0\6\0\64\0\14\0\70\0\10\0\12\0\3\0"+
    "\61\0\122\0\3\0\1\0\37\0\15\0\347\0\25\0\u011a\0\2\0"+
    "\6\0\2\0\46\0\2\0\6\0\2\0\10\0\1\0\1\0\1\0"+
    "\1\0\1\0\1\0\1\0\37\0\2\0\65\0\1\0\7\0\1\0"+
    "\1\0\3\0\3\0\1\0\7\0\3\0\4\0\2\0\6\0\4\0"+
    "\15\0\5\0\3\0\1\0\7\0\16\0\5\0\32\0\5\0\20\0"+
    "\2\0\23\0\1\0\13\0\5\0\5\0\6\0\1\0\1\0\15\0"+
    "\1\0\20\0\15\0\3\0\32\0\26\0\15\0\4\0\1\0\3\0"+
    "\14\0\21\0\1\0\4\0\1\0\2\0\12\0\1\0\1\0\3\0"+
    "\5\0\6\0\1\0\1\0\1\0\1\0\1\0\1\0\4\0\1\0"+
    "\13\0\2\0\4\0\5\0\5\0\4\0\1\0\21\0\51\0\u0a77\0"+
    "\57\0\1\0\57\0\1\0\205\0\6\0\7\0\16\0\46\0\12\0"+
    "\66\0\11\0\1\0\17\0\30\0\11\0\7\0\1\0\7\0\1\0"+
    "\7\0\1\0\7\0\1\0\7\0\1\0\7\0\1\0\7\0\1\0"+
    "\7\0\1\0\40\0\57\0\1\0\u01d5\0\3\0\31\0\17\0\1\0"+
    "\5\0\2\0\5\0\4\0\126\0\2\0\2\0\2\0\3\0\1\0"+
    "\132\0\1\0\4\0\5\0\51\0\3\0\136\0\21\0\33\0\65\0"+
    "\20\0\u0200\0\u19b6\0\112\0\u51cc\0\64\0\u048d\0\103\0\56\0\2\0"+
    "\u010d\0\3\0\34\0\24\0\60\0\14\0\2\0\1\0\31\0\10\0"+
    "\122\0\45\0\11\0\2\0\147\0\2\0\4\0\1\0\2\0\16\0"+
    "\12\0\120\0\56\0\20\0\1\0\7\0\64\0\14\0\105\0\13\0"+
    "\12\0\6\0\30\0\3\0\1\0\4\0\56\0\2\0\44\0\14\0"+
    "\35\0\3\0\101\0\16\0\13\0\46\0\67\0\11\0\16\0\2\0"+
    "\12\0\6\0\27\0\3\0\2\0\4\0\103\0\30\0\3\0\43\0"+
    "\6\0\2\0\6\0\2\0\6\0\11\0\7\0\1\0\7\0\221\0"+
    "\53\0\1\0\2\0\2\0\12\0\6\0\u2ba4\0\14\0\27\0\4\0"+
    "\61\0\u2104\0\u012e\0\2\0\76\0\2\0\152\0\46\0\7\0\14\0"+
    "\5\0\5\0\14\0\1\0\15\0\1\0\5\0\1\0\1\0\1\0"+
    "\2\0\1\0\2\0\1\0\154\0\41\0\u016b\0\22\0\100\0\2\0"+
    "\66\0\50\0\15\0\3\0\20\0\20\0\7\0\14\0\2\0\30\0"+
    "\3\0\31\0\1\0\6\0\5\0\1\0\207\0\2\0\1\0\4\0"+
    "\1\0\13\0\12\0\7\0\32\0\4\0\1\0\1\0\32\0\13\0"+
    "\131\0\3\0\6\0\2\0\6\0\2\0\6\0\2\0\3\0\3\0"+
    "\2\0\3\0\2\0\22\0\3\0\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\1\1\2\5\0\1\3\1\4\1\5\1\0\1\6"+
    "\1\7\1\10\2\0\1\11\1\12\1\13\1\14\1\15"+
    "\7\0\1\16\1\17\1\20\1\21\1\22\1\10\1\23"+
    "\1\24\1\0\1\25\7\0\1\26\3\0\1\27\1\30"+
    "\3\0\1\31\1\32\1\33\1\34";

  private static int [] zzUnpackAction() {
    int [] result = new int[59];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\37\0\76\0\135\0\174\0\233\0\272\0\331"+
    "\0\370\0\u0117\0\76\0\u0136\0\76\0\76\0\u0155\0\u0174"+
    "\0\u0193\0\76\0\76\0\76\0\76\0\76\0\u01b2\0\u01d1"+
    "\0\u01f0\0\u020f\0\u022e\0\u024d\0\u026c\0\76\0\76\0\76"+
    "\0\76\0\76\0\76\0\76\0\76\0\u028b\0\76\0\u02aa"+
    "\0\u02c9\0\u02e8\0\u0307\0\u0326\0\u0345\0\u0364\0\76\0\u0383"+
    "\0\u03a2\0\u03c1\0\76\0\76\0\u03e0\0\u03ff\0\u041e\0\76"+
    "\0\76\0\76\0\76";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[59];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\0\1\2\1\3\1\4\1\5\1\6\1\7\1\10"+
    "\3\0\1\11\1\12\1\13\1\0\1\14\3\0\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\0\1\2\132\0\1\31\6\0"+
    "\1\32\50\0\1\33\27\0\1\34\63\0\1\35\14\0"+
    "\1\36\35\0\1\37\1\40\31\0\1\41\10\0\1\42"+
    "\32\0\1\43\50\0\1\44\37\0\1\45\30\0\1\46"+
    "\33\0\1\47\26\0\1\50\33\0\1\51\16\0\1\52"+
    "\17\0\1\53\45\0\1\54\32\0\1\55\47\0\1\56"+
    "\26\0\1\57\34\0\1\60\37\0\1\61\47\0\1\62"+
    "\25\0\1\63\37\0\1\64\40\0\1\65\31\0\1\66"+
    "\42\0\1\67\37\0\1\70\33\0\1\71\50\0\1\72"+
    "\21\0\1\73\33\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1085];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\1\1\11\5\0\2\1\1\11\1\0\2\11\1\1"+
    "\2\0\5\11\7\0\10\11\1\0\1\11\7\0\1\11"+
    "\3\0\2\11\3\0\4\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[59];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
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


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public QLex(java.io.Reader in) {
  	// TODO: code that goes to constructor
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public QLex(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1892) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 25: 
          { return sym("UNTIL");
          }
        case 29: break;
        case 19: 
          { return sym("OR");
          }
        case 30: break;
        case 16: 
          { return sym("EQUALSCOMPARISON");
          }
        case 31: break;
        case 8: 
          { return sym("NOT");
          }
        case 32: break;
        case 11: 
          { return sym("SEMICOLON");
          }
        case 33: break;
        case 23: 
          { return sym("ELSE");
          }
        case 34: break;
        case 5: 
          { return sym("GREATER");
          }
        case 35: break;
        case 9: 
          { return sym("PLUS");
          }
        case 36: break;
        case 26: 
          { return sym("WHILE");
          }
        case 37: break;
        case 6: 
          { return sym("DIVIDE");
          }
        case 38: break;
        case 28: 
          { return sym("REPEAT");
          }
        case 39: break;
        case 20: 
          { return sym("AND");
          }
        case 40: break;
        case 3: 
          { return sym("LESS");
          }
        case 41: break;
        case 7: 
          { return sym("TIMES");
          }
        case 42: break;
        case 17: 
          { return sym("IF");
          }
        case 43: break;
        case 2: 
          { return sym("MINUS");
          }
        case 44: break;
        case 1: 
          { /* ignore whitespace*/
          }
        case 45: break;
        case 15: 
          { return sym("GREATEREQUALS");
          }
        case 46: break;
        case 24: 
          { return sym("FDEF");
          }
        case 47: break;
        case 14: 
          { return sym("LESSEQUALS");
          }
        case 48: break;
        case 18: 
          { return sym("IN");
          }
        case 49: break;
        case 27: 
          { return sym("RETURN");
          }
        case 50: break;
        case 22: 
          { return sym("TDEF");
          }
        case 51: break;
        case 21: 
          { return sym("DO");
          }
        case 52: break;
        case 10: 
          { return sym("POWER");
          }
        case 53: break;
        case 13: 
          { return sym("COMMA");
          }
        case 54: break;
        case 4: 
          { return sym("EQUALS");
          }
        case 55: break;
        case 12: 
          { return sym("COLON");
          }
        case 56: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(uk.ac.ucl.comp2010.bestgroup.QSym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}

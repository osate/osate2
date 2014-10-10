// Generated from AadlBa.g by ANTLR 4.4

/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
 
 package org.osate.ba.parser ;
 
 import org.osate.ba.texteditor.AadlBaHighlighter ;
 import org.osate.ba.texteditor.DefaultAadlBaHighlighter ;
 import org.osate.annexsupport.AnnexHighlighterPositionAcceptor ;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AadlBaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ABS=1, AND=2, ANY=3, BINDING=4, COMPLETE=5, COMPUTATION=6, COUNT=7, DISPATCH=8, 
		DO=9, ELSE=10, ELSIF=11, END=12, FALSE=13, FINAL=14, FOR=15, FORALL=16, 
		FRESH=17, FROZEN=18, IF=19, IN=20, INITIAL=21, LOWER_BOUND=22, MOD=23, 
		NOT=24, ON=25, OR=26, OTHERWISE=27, VARIABLES=28, REM=29, STATE=30, STATES=31, 
		STOP=32, TIMEOUT=33, TRANSITIONS=34, TRUE=35, UNTIL=36, UPPER_BOUND=37, 
		WHILE=38, XOR=39, LBRACK=40, RBRACK=41, COMMA=42, LTRANS=43, RTRANS=44, 
		LPAREN=45, RPAREN=46, CONCAT=47, LCURLY=48, RCURLY=49, COLON=50, ASSIGN=51, 
		EXCLAM=52, INTERROG=53, GGREATER=54, EXCLLESS=55, EXCLGREATER=56, DOT=57, 
		TICK=58, EQUAL=59, NOTEQUAL=60, LESSTHAN=61, LESSOREQUAL=62, GREATERTHAN=63, 
		GREATEROREQUAL=64, PLUS=65, MINUS=66, STAR=67, DIVIDE=68, STARSTAR=69, 
		DOTDOT=70, SEMICOLON=71, DOUBLECOLON=72, HASH=73, ERR_EQUALEQUAL=74, ERR_END=75, 
		ERR_ELSIF=76, IDENT=77, STRING_LITERAL=78, REAL_LIT=79, INTEGER_LIT=80, 
		WS=81, SL_COMMENT=82;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'", 
		"'<'", "'='", "'>'", "'?'", "'@'", "'A'", "'B'", "'C'", "'D'", "'E'", 
		"'F'", "'G'", "'H'", "'I'", "'J'", "'K'", "'L'", "'M'", "'N'", "'O'", 
		"'P'", "'Q'", "'R'"
	};
	public static final String[] ruleNames = {
		"ABS", "AND", "ANY", "BINDING", "COMPLETE", "COMPUTATION", "COUNT", "DISPATCH", 
		"DO", "ELSE", "ELSIF", "END", "FALSE", "FINAL", "FOR", "FORALL", "FRESH", 
		"FROZEN", "IF", "IN", "INITIAL", "LOWER_BOUND", "MOD", "NOT", "ON", "OR", 
		"OTHERWISE", "VARIABLES", "REM", "STATE", "STATES", "STOP", "TIMEOUT", 
		"TRANSITIONS", "TRUE", "UNTIL", "UPPER_BOUND", "WHILE", "XOR", "LBRACK", 
		"RBRACK", "COMMA", "LTRANS", "RTRANS", "LPAREN", "RPAREN", "CONCAT", "LCURLY", 
		"RCURLY", "COLON", "ASSIGN", "EXCLAM", "INTERROG", "GGREATER", "EXCLLESS", 
		"EXCLGREATER", "DOT", "TICK", "EQUAL", "NOTEQUAL", "LESSTHAN", "LESSOREQUAL", 
		"GREATERTHAN", "GREATEROREQUAL", "PLUS", "MINUS", "STAR", "DIVIDE", "STARSTAR", 
		"DOTDOT", "SEMICOLON", "DOUBLECOLON", "HASH", "ERR_EQUALEQUAL", "ERR_END", 
		"ERR_ELSIF", "IDENT", "LETTER", "STRING_LITERAL", "REAL_LIT", "INTEGER_LIT", 
		"DIGIT", "EXPONENT", "INT_EXPONENT", "EXTENDED_DIGIT", "BASED_INTEGER", 
		"BASE", "HEX_DIGIT", "WS", "SL_COMMENT", "ESC"
	};


	  public static final short KEYWORD_MAX_ID = 36 ;
	  public static final short PUNCTUATION_MAX_ID = 70 ;
	  public static final short EOF_ID = 0 ;
	  public static final short ERR_MAX_ID = 73 ;
	  
	  protected int _annexOffset = 0 ;
	  
	  // Default highlighter does nothing.
	  protected AadlBaHighlighter _ht = new DefaultAadlBaHighlighter() ;
	  
	  public void setHighlighter(AadlBaHighlighter ht)
	  {
	    _ht = ht ;
	  }
	  
	  @Override
	  public void emit(Token token)
	  {
	    super.emit(token) ;
	    
	    int type = token.getType() ;
	    
	    if(type != EOF_ID && type != IDENT)
	    {
	      if (type <= KEYWORD_MAX_ID) // Select only keyword. 
	      {
	        _ht.addToHighlighting(_annexOffset, token,
	                              AnnexHighlighterPositionAcceptor.KEYWORD_ID);
	      }
	      else if(type <= PUNCTUATION_MAX_ID)
	      {
	        _ht.addToHighlighting(_annexOffset, token,
	                              AnnexHighlighterPositionAcceptor.PUNCTUATION_ID);
	      }
	      else if(type <= ERR_MAX_ID)
	      {
	        _ht.addToHighlighting(_annexOffset, token,
	                              AnnexHighlighterPositionAcceptor.INVALID_TOKEN_ID);
	      }
	      else
	      {
	        switch (type)
	        {
	          case STRING_LITERAL :
	          {
	            _ht.addToHighlighting(_annexOffset, token,
	                                  AnnexHighlighterPositionAcceptor.STRING_ID) ;
	            break ;
	          }
	                  
	          case INTEGER_LIT :
	          case REAL_LIT :
	          {
	            _ht.addToHighlighting(_annexOffset, token,
	                                  AnnexHighlighterPositionAcceptor.NUMBER_ID) ;
	            break ;
	          }
	                  
	          case SL_COMMENT :
	          {
	            _ht.addToHighlighting(_annexOffset, token,
	                                  AnnexHighlighterPositionAcceptor.COMMENT_ID) ;
	            break ;
	          }
	        }
	      }
	    }
	  }
	  
	  public void setAnnexOffset(int offset)
	  {
	   _annexOffset = offset;
	  }


	public AadlBaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AadlBa.g"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2T\u02bb\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,"+
		"\3,\3-\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3"+
		"\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\39\3:"+
		"\3:\3;\3;\3<\3<\3=\3=\3=\3>\3>\3?\3?\3?\3@\3@\3A\3A\3A\3B\3B\3C\3C\3D"+
		"\3D\3E\3E\3F\3F\3F\3G\3G\3G\3H\3H\3I\3I\3I\3J\3J\3K\3K\3K\3L\3L\3L\3L"+
		"\3L\3L\3M\3M\3M\3M\3M\3N\3N\5N\u0210\nN\3N\3N\5N\u0214\nN\7N\u0216\nN"+
		"\fN\16N\u0219\13N\3O\3O\3P\3P\3P\3P\3P\7P\u0222\nP\fP\16P\u0225\13P\3"+
		"P\3P\3Q\6Q\u022a\nQ\rQ\16Q\u022b\3Q\3Q\6Q\u0230\nQ\rQ\16Q\u0231\7Q\u0234"+
		"\nQ\fQ\16Q\u0237\13Q\3Q\3Q\6Q\u023b\nQ\rQ\16Q\u023c\3Q\3Q\6Q\u0241\nQ"+
		"\rQ\16Q\u0242\7Q\u0245\nQ\fQ\16Q\u0248\13Q\3Q\5Q\u024b\nQ\3R\6R\u024e"+
		"\nR\rR\16R\u024f\3R\3R\6R\u0254\nR\rR\16R\u0255\7R\u0258\nR\fR\16R\u025b"+
		"\13R\3R\3R\3R\3R\5R\u0261\nR\3R\5R\u0264\nR\5R\u0266\nR\3S\3S\3T\3T\5"+
		"T\u026c\nT\3T\6T\u026f\nT\rT\16T\u0270\3U\3U\5U\u0275\nU\3U\6U\u0278\n"+
		"U\rU\16U\u0279\3V\3V\5V\u027e\nV\3W\3W\5W\u0282\nW\3W\7W\u0285\nW\fW\16"+
		"W\u0288\13W\3X\3X\5X\u028c\nX\3Y\3Y\3Z\3Z\3Z\3Z\5Z\u0294\nZ\3Z\3Z\3[\3"+
		"[\3[\3[\7[\u029c\n[\f[\16[\u029f\13[\3[\3[\3\\\3\\\3\\\6\\\u02a6\n\\\r"+
		"\\\16\\\u02a7\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\5\\\u02b2\n\\\5\\\u02b4"+
		"\n\\\3\\\3\\\5\\\u02b8\n\\\5\\\u02ba\n\\\2\2]\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S"+
		"+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081"+
		"B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095"+
		"L\u0097M\u0099N\u009bO\u009d\2\u009fP\u00a1Q\u00a3R\u00a5\2\u00a7\2\u00a9"+
		"\2\u00ab\2\u00ad\2\u00af\2\u00b1\2\u00b3S\u00b5T\u00b7\2\3\2\b\4\2$$^"+
		"^\4\2--//\4\2\62;ch\4\2\13\f\17\17\4\2\f\f\17\17\n\2$$))^^ddhhppttvv\u02d6"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2"+
		"\2\2\u00a3\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\3\u00b9\3\2\2\2\5\u00bd"+
		"\3\2\2\2\7\u00c1\3\2\2\2\t\u00c5\3\2\2\2\13\u00cd\3\2\2\2\r\u00d6\3\2"+
		"\2\2\17\u00e2\3\2\2\2\21\u00e8\3\2\2\2\23\u00f1\3\2\2\2\25\u00f4\3\2\2"+
		"\2\27\u00f9\3\2\2\2\31\u00ff\3\2\2\2\33\u0103\3\2\2\2\35\u0109\3\2\2\2"+
		"\37\u010f\3\2\2\2!\u0113\3\2\2\2#\u011a\3\2\2\2%\u0120\3\2\2\2\'\u0127"+
		"\3\2\2\2)\u012a\3\2\2\2+\u012d\3\2\2\2-\u0135\3\2\2\2/\u0141\3\2\2\2\61"+
		"\u0145\3\2\2\2\63\u0149\3\2\2\2\65\u014c\3\2\2\2\67\u014f\3\2\2\29\u0159"+
		"\3\2\2\2;\u0163\3\2\2\2=\u0167\3\2\2\2?\u016d\3\2\2\2A\u0174\3\2\2\2C"+
		"\u0179\3\2\2\2E\u0181\3\2\2\2G\u018d\3\2\2\2I\u0192\3\2\2\2K\u0198\3\2"+
		"\2\2M\u01a4\3\2\2\2O\u01aa\3\2\2\2Q\u01ae\3\2\2\2S\u01b0\3\2\2\2U\u01b2"+
		"\3\2\2\2W\u01b4\3\2\2\2Y\u01b7\3\2\2\2[\u01bb\3\2\2\2]\u01bd\3\2\2\2_"+
		"\u01bf\3\2\2\2a\u01c1\3\2\2\2c\u01c3\3\2\2\2e\u01c5\3\2\2\2g\u01c7\3\2"+
		"\2\2i\u01ca\3\2\2\2k\u01cc\3\2\2\2m\u01ce\3\2\2\2o\u01d1\3\2\2\2q\u01d4"+
		"\3\2\2\2s\u01d7\3\2\2\2u\u01d9\3\2\2\2w\u01db\3\2\2\2y\u01dd\3\2\2\2{"+
		"\u01e0\3\2\2\2}\u01e2\3\2\2\2\177\u01e5\3\2\2\2\u0081\u01e7\3\2\2\2\u0083"+
		"\u01ea\3\2\2\2\u0085\u01ec\3\2\2\2\u0087\u01ee\3\2\2\2\u0089\u01f0\3\2"+
		"\2\2\u008b\u01f2\3\2\2\2\u008d\u01f5\3\2\2\2\u008f\u01f8\3\2\2\2\u0091"+
		"\u01fa\3\2\2\2\u0093\u01fd\3\2\2\2\u0095\u01ff\3\2\2\2\u0097\u0202\3\2"+
		"\2\2\u0099\u0208\3\2\2\2\u009b\u020d\3\2\2\2\u009d\u021a\3\2\2\2\u009f"+
		"\u021c\3\2\2\2\u00a1\u0229\3\2\2\2\u00a3\u024d\3\2\2\2\u00a5\u0267\3\2"+
		"\2\2\u00a7\u0269\3\2\2\2\u00a9\u0272\3\2\2\2\u00ab\u027d\3\2\2\2\u00ad"+
		"\u027f\3\2\2\2\u00af\u0289\3\2\2\2\u00b1\u028d\3\2\2\2\u00b3\u0293\3\2"+
		"\2\2\u00b5\u0297\3\2\2\2\u00b7\u02a2\3\2\2\2\u00b9\u00ba\7c\2\2\u00ba"+
		"\u00bb\7d\2\2\u00bb\u00bc\7u\2\2\u00bc\4\3\2\2\2\u00bd\u00be\7c\2\2\u00be"+
		"\u00bf\7p\2\2\u00bf\u00c0\7f\2\2\u00c0\6\3\2\2\2\u00c1\u00c2\7c\2\2\u00c2"+
		"\u00c3\7p\2\2\u00c3\u00c4\7{\2\2\u00c4\b\3\2\2\2\u00c5\u00c6\7d\2\2\u00c6"+
		"\u00c7\7k\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7f\2\2\u00c9\u00ca\7k\2\2"+
		"\u00ca\u00cb\7p\2\2\u00cb\u00cc\7i\2\2\u00cc\n\3\2\2\2\u00cd\u00ce\7e"+
		"\2\2\u00ce\u00cf\7q\2\2\u00cf\u00d0\7o\2\2\u00d0\u00d1\7r\2\2\u00d1\u00d2"+
		"\7n\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5\7g\2\2\u00d5"+
		"\f\3\2\2\2\u00d6\u00d7\7e\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9\7o\2\2\u00d9"+
		"\u00da\7r\2\2\u00da\u00db\7w\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7c\2\2"+
		"\u00dd\u00de\7v\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1"+
		"\7p\2\2\u00e1\16\3\2\2\2\u00e2\u00e3\7e\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5"+
		"\7w\2\2\u00e5\u00e6\7p\2\2\u00e6\u00e7\7v\2\2\u00e7\20\3\2\2\2\u00e8\u00e9"+
		"\7f\2\2\u00e9\u00ea\7k\2\2\u00ea\u00eb\7u\2\2\u00eb\u00ec\7r\2\2\u00ec"+
		"\u00ed\7c\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7e\2\2\u00ef\u00f0\7j\2\2"+
		"\u00f0\22\3\2\2\2\u00f1\u00f2\7f\2\2\u00f2\u00f3\7q\2\2\u00f3\24\3\2\2"+
		"\2\u00f4\u00f5\7g\2\2\u00f5\u00f6\7n\2\2\u00f6\u00f7\7u\2\2\u00f7\u00f8"+
		"\7g\2\2\u00f8\26\3\2\2\2\u00f9\u00fa\7g\2\2\u00fa\u00fb\7n\2\2\u00fb\u00fc"+
		"\7u\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7h\2\2\u00fe\30\3\2\2\2\u00ff\u0100"+
		"\7g\2\2\u0100\u0101\7p\2\2\u0101\u0102\7f\2\2\u0102\32\3\2\2\2\u0103\u0104"+
		"\7h\2\2\u0104\u0105\7c\2\2\u0105\u0106\7n\2\2\u0106\u0107\7u\2\2\u0107"+
		"\u0108\7g\2\2\u0108\34\3\2\2\2\u0109\u010a\7h\2\2\u010a\u010b\7k\2\2\u010b"+
		"\u010c\7p\2\2\u010c\u010d\7c\2\2\u010d\u010e\7n\2\2\u010e\36\3\2\2\2\u010f"+
		"\u0110\7h\2\2\u0110\u0111\7q\2\2\u0111\u0112\7t\2\2\u0112 \3\2\2\2\u0113"+
		"\u0114\7h\2\2\u0114\u0115\7q\2\2\u0115\u0116\7t\2\2\u0116\u0117\7c\2\2"+
		"\u0117\u0118\7n\2\2\u0118\u0119\7n\2\2\u0119\"\3\2\2\2\u011a\u011b\7h"+
		"\2\2\u011b\u011c\7t\2\2\u011c\u011d\7g\2\2\u011d\u011e\7u\2\2\u011e\u011f"+
		"\7j\2\2\u011f$\3\2\2\2\u0120\u0121\7h\2\2\u0121\u0122\7t\2\2\u0122\u0123"+
		"\7q\2\2\u0123\u0124\7|\2\2\u0124\u0125\7g\2\2\u0125\u0126\7p\2\2\u0126"+
		"&\3\2\2\2\u0127\u0128\7k\2\2\u0128\u0129\7h\2\2\u0129(\3\2\2\2\u012a\u012b"+
		"\7k\2\2\u012b\u012c\7p\2\2\u012c*\3\2\2\2\u012d\u012e\7k\2\2\u012e\u012f"+
		"\7p\2\2\u012f\u0130\7k\2\2\u0130\u0131\7v\2\2\u0131\u0132\7k\2\2\u0132"+
		"\u0133\7c\2\2\u0133\u0134\7n\2\2\u0134,\3\2\2\2\u0135\u0136\7n\2\2\u0136"+
		"\u0137\7q\2\2\u0137\u0138\7y\2\2\u0138\u0139\7g\2\2\u0139\u013a\7t\2\2"+
		"\u013a\u013b\7a\2\2\u013b\u013c\7d\2\2\u013c\u013d\7q\2\2\u013d\u013e"+
		"\7w\2\2\u013e\u013f\7p\2\2\u013f\u0140\7f\2\2\u0140.\3\2\2\2\u0141\u0142"+
		"\7o\2\2\u0142\u0143\7q\2\2\u0143\u0144\7f\2\2\u0144\60\3\2\2\2\u0145\u0146"+
		"\7p\2\2\u0146\u0147\7q\2\2\u0147\u0148\7v\2\2\u0148\62\3\2\2\2\u0149\u014a"+
		"\7q\2\2\u014a\u014b\7p\2\2\u014b\64\3\2\2\2\u014c\u014d\7q\2\2\u014d\u014e"+
		"\7t\2\2\u014e\66\3\2\2\2\u014f\u0150\7q\2\2\u0150\u0151\7v\2\2\u0151\u0152"+
		"\7j\2\2\u0152\u0153\7g\2\2\u0153\u0154\7t\2\2\u0154\u0155\7y\2\2\u0155"+
		"\u0156\7k\2\2\u0156\u0157\7u\2\2\u0157\u0158\7g\2\2\u01588\3\2\2\2\u0159"+
		"\u015a\7x\2\2\u015a\u015b\7c\2\2\u015b\u015c\7t\2\2\u015c\u015d\7k\2\2"+
		"\u015d\u015e\7c\2\2\u015e\u015f\7d\2\2\u015f\u0160\7n\2\2\u0160\u0161"+
		"\7g\2\2\u0161\u0162\7u\2\2\u0162:\3\2\2\2\u0163\u0164\7t\2\2\u0164\u0165"+
		"\7g\2\2\u0165\u0166\7o\2\2\u0166<\3\2\2\2\u0167\u0168\7u\2\2\u0168\u0169"+
		"\7v\2\2\u0169\u016a\7c\2\2\u016a\u016b\7v\2\2\u016b\u016c\7g\2\2\u016c"+
		">\3\2\2\2\u016d\u016e\7u\2\2\u016e\u016f\7v\2\2\u016f\u0170\7c\2\2\u0170"+
		"\u0171\7v\2\2\u0171\u0172\7g\2\2\u0172\u0173\7u\2\2\u0173@\3\2\2\2\u0174"+
		"\u0175\7u\2\2\u0175\u0176\7v\2\2\u0176\u0177\7q\2\2\u0177\u0178\7r\2\2"+
		"\u0178B\3\2\2\2\u0179\u017a\7v\2\2\u017a\u017b\7k\2\2\u017b\u017c\7o\2"+
		"\2\u017c\u017d\7g\2\2\u017d\u017e\7q\2\2\u017e\u017f\7w\2\2\u017f\u0180"+
		"\7v\2\2\u0180D\3\2\2\2\u0181\u0182\7v\2\2\u0182\u0183\7t\2\2\u0183\u0184"+
		"\7c\2\2\u0184\u0185\7p\2\2\u0185\u0186\7u\2\2\u0186\u0187\7k\2\2\u0187"+
		"\u0188\7v\2\2\u0188\u0189\7k\2\2\u0189\u018a\7q\2\2\u018a\u018b\7p\2\2"+
		"\u018b\u018c\7u\2\2\u018cF\3\2\2\2\u018d\u018e\7v\2\2\u018e\u018f\7t\2"+
		"\2\u018f\u0190\7w\2\2\u0190\u0191\7g\2\2\u0191H\3\2\2\2\u0192\u0193\7"+
		"w\2\2\u0193\u0194\7p\2\2\u0194\u0195\7v\2\2\u0195\u0196\7k\2\2\u0196\u0197"+
		"\7n\2\2\u0197J\3\2\2\2\u0198\u0199\7w\2\2\u0199\u019a\7r\2\2\u019a\u019b"+
		"\7r\2\2\u019b\u019c\7g\2\2\u019c\u019d\7t\2\2\u019d\u019e\7a\2\2\u019e"+
		"\u019f\7d\2\2\u019f\u01a0\7q\2\2\u01a0\u01a1\7w\2\2\u01a1\u01a2\7p\2\2"+
		"\u01a2\u01a3\7f\2\2\u01a3L\3\2\2\2\u01a4\u01a5\7y\2\2\u01a5\u01a6\7j\2"+
		"\2\u01a6\u01a7\7k\2\2\u01a7\u01a8\7n\2\2\u01a8\u01a9\7g\2\2\u01a9N\3\2"+
		"\2\2\u01aa\u01ab\7z\2\2\u01ab\u01ac\7q\2\2\u01ac\u01ad\7t\2\2\u01adP\3"+
		"\2\2\2\u01ae\u01af\7]\2\2\u01afR\3\2\2\2\u01b0\u01b1\7_\2\2\u01b1T\3\2"+
		"\2\2\u01b2\u01b3\7.\2\2\u01b3V\3\2\2\2\u01b4\u01b5\7/\2\2\u01b5\u01b6"+
		"\7]\2\2\u01b6X\3\2\2\2\u01b7\u01b8\7_\2\2\u01b8\u01b9\7/\2\2\u01b9\u01ba"+
		"\7@\2\2\u01baZ\3\2\2\2\u01bb\u01bc\7*\2\2\u01bc\\\3\2\2\2\u01bd\u01be"+
		"\7+\2\2\u01be^\3\2\2\2\u01bf\u01c0\7(\2\2\u01c0`\3\2\2\2\u01c1\u01c2\7"+
		"}\2\2\u01c2b\3\2\2\2\u01c3\u01c4\7\177\2\2\u01c4d\3\2\2\2\u01c5\u01c6"+
		"\7<\2\2\u01c6f\3\2\2\2\u01c7\u01c8\7<\2\2\u01c8\u01c9\7?\2\2\u01c9h\3"+
		"\2\2\2\u01ca\u01cb\7#\2\2\u01cbj\3\2\2\2\u01cc\u01cd\7A\2\2\u01cdl\3\2"+
		"\2\2\u01ce\u01cf\7@\2\2\u01cf\u01d0\7@\2\2\u01d0n\3\2\2\2\u01d1\u01d2"+
		"\7#\2\2\u01d2\u01d3\7>\2\2\u01d3p\3\2\2\2\u01d4\u01d5\7#\2\2\u01d5\u01d6"+
		"\7@\2\2\u01d6r\3\2\2\2\u01d7\u01d8\7\60\2\2\u01d8t\3\2\2\2\u01d9\u01da"+
		"\7)\2\2\u01dav\3\2\2\2\u01db\u01dc\7?\2\2\u01dcx\3\2\2\2\u01dd\u01de\7"+
		"#\2\2\u01de\u01df\7?\2\2\u01dfz\3\2\2\2\u01e0\u01e1\7>\2\2\u01e1|\3\2"+
		"\2\2\u01e2\u01e3\7>\2\2\u01e3\u01e4\7?\2\2\u01e4~\3\2\2\2\u01e5\u01e6"+
		"\7@\2\2\u01e6\u0080\3\2\2\2\u01e7\u01e8\7@\2\2\u01e8\u01e9\7?\2\2\u01e9"+
		"\u0082\3\2\2\2\u01ea\u01eb\7-\2\2\u01eb\u0084\3\2\2\2\u01ec\u01ed\7/\2"+
		"\2\u01ed\u0086\3\2\2\2\u01ee\u01ef\7,\2\2\u01ef\u0088\3\2\2\2\u01f0\u01f1"+
		"\7\61\2\2\u01f1\u008a\3\2\2\2\u01f2\u01f3\7,\2\2\u01f3\u01f4\7,\2\2\u01f4"+
		"\u008c\3\2\2\2\u01f5\u01f6\7\60\2\2\u01f6\u01f7\7\60\2\2\u01f7\u008e\3"+
		"\2\2\2\u01f8\u01f9\7=\2\2\u01f9\u0090\3\2\2\2\u01fa\u01fb\7<\2\2\u01fb"+
		"\u01fc\7<\2\2\u01fc\u0092\3\2\2\2\u01fd\u01fe\7%\2\2\u01fe\u0094\3\2\2"+
		"\2\u01ff\u0200\7?\2\2\u0200\u0201\7?\2\2\u0201\u0096\3\2\2\2\u0202\u0203"+
		"\7g\2\2\u0203\u0204\7p\2\2\u0204\u0205\7f\2\2\u0205\u0206\7k\2\2\u0206"+
		"\u0207\7h\2\2\u0207\u0098\3\2\2\2\u0208\u0209\7g\2\2\u0209\u020a\7n\2"+
		"\2\u020a\u020b\7k\2\2\u020b\u020c\7h\2\2\u020c\u009a\3\2\2\2\u020d\u0217"+
		"\5\u009dO\2\u020e\u0210\7a\2\2\u020f\u020e\3\2\2\2\u020f\u0210\3\2\2\2"+
		"\u0210\u0213\3\2\2\2\u0211\u0214\5\u009dO\2\u0212\u0214\4\62;\2\u0213"+
		"\u0211\3\2\2\2\u0213\u0212\3\2\2\2\u0214\u0216\3\2\2\2\u0215\u020f\3\2"+
		"\2\2\u0216\u0219\3\2\2\2\u0217\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218"+
		"\u009c\3\2\2\2\u0219\u0217\3\2\2\2\u021a\u021b\4c|\2\u021b\u009e\3\2\2"+
		"\2\u021c\u0223\7$\2\2\u021d\u021e\7$\2\2\u021e\u0222\7$\2\2\u021f\u0222"+
		"\5\u00b7\\\2\u0220\u0222\n\2\2\2\u0221\u021d\3\2\2\2\u0221\u021f\3\2\2"+
		"\2\u0221\u0220\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2\2\2\u0223\u0224"+
		"\3\2\2\2\u0224\u0226\3\2\2\2\u0225\u0223\3\2\2\2\u0226\u0227\7$\2\2\u0227"+
		"\u00a0\3\2\2\2\u0228\u022a\5\u00a5S\2\u0229\u0228\3\2\2\2\u022a\u022b"+
		"\3\2\2\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u0235\3\2\2\2\u022d"+
		"\u022f\7a\2\2\u022e\u0230\5\u00a5S\2\u022f\u022e\3\2\2\2\u0230\u0231\3"+
		"\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0234\3\2\2\2\u0233"+
		"\u022d\3\2\2\2\u0234\u0237\3\2\2\2\u0235\u0233\3\2\2\2\u0235\u0236\3\2"+
		"\2\2\u0236\u0238\3\2\2\2\u0237\u0235\3\2\2\2\u0238\u023a\7\60\2\2\u0239"+
		"\u023b\5\u00a5S\2\u023a\u0239\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023a"+
		"\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u0246\3\2\2\2\u023e\u0240\7a\2\2\u023f"+
		"\u0241\5\u00a5S\2\u0240\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0240"+
		"\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0245\3\2\2\2\u0244\u023e\3\2\2\2\u0245"+
		"\u0248\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u024a\3\2"+
		"\2\2\u0248\u0246\3\2\2\2\u0249\u024b\5\u00a7T\2\u024a\u0249\3\2\2\2\u024a"+
		"\u024b\3\2\2\2\u024b\u00a2\3\2\2\2\u024c\u024e\5\u00a5S\2\u024d\u024c"+
		"\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u024d\3\2\2\2\u024f\u0250\3\2\2\2\u0250"+
		"\u0259\3\2\2\2\u0251\u0253\7a\2\2\u0252\u0254\5\u00a5S\2\u0253\u0252\3"+
		"\2\2\2\u0254\u0255\3\2\2\2\u0255\u0253\3\2\2\2\u0255\u0256\3\2\2\2\u0256"+
		"\u0258\3\2\2\2\u0257\u0251\3\2\2\2\u0258\u025b\3\2\2\2\u0259\u0257\3\2"+
		"\2\2\u0259\u025a\3\2\2\2\u025a\u0265\3\2\2\2\u025b\u0259\3\2\2\2\u025c"+
		"\u025d\7%\2\2\u025d\u025e\5\u00adW\2\u025e\u0260\7%\2\2\u025f\u0261\5"+
		"\u00a9U\2\u0260\u025f\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0266\3\2\2\2"+
		"\u0262\u0264\5\u00a9U\2\u0263\u0262\3\2\2\2\u0263\u0264\3\2\2\2\u0264"+
		"\u0266\3\2\2\2\u0265\u025c\3\2\2\2\u0265\u0263\3\2\2\2\u0266\u00a4\3\2"+
		"\2\2\u0267\u0268\4\62;\2\u0268\u00a6\3\2\2\2\u0269\u026b\7g\2\2\u026a"+
		"\u026c\t\3\2\2\u026b\u026a\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026e\3\2"+
		"\2\2\u026d\u026f\5\u00a5S\2\u026e\u026d\3\2\2\2\u026f\u0270\3\2\2\2\u0270"+
		"\u026e\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u00a8\3\2\2\2\u0272\u0274\7g"+
		"\2\2\u0273\u0275\7-\2\2\u0274\u0273\3\2\2\2\u0274\u0275\3\2\2\2\u0275"+
		"\u0277\3\2\2\2\u0276\u0278\5\u00a5S\2\u0277\u0276\3\2\2\2\u0278\u0279"+
		"\3\2\2\2\u0279\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u00aa\3\2\2\2\u027b"+
		"\u027e\5\u00a5S\2\u027c\u027e\4ch\2\u027d\u027b\3\2\2\2\u027d\u027c\3"+
		"\2\2\2\u027e\u00ac\3\2\2\2\u027f\u0286\5\u00abV\2\u0280\u0282\7a\2\2\u0281"+
		"\u0280\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0285\5\u00ab"+
		"V\2\u0284\u0281\3\2\2\2\u0285\u0288\3\2\2\2\u0286\u0284\3\2\2\2\u0286"+
		"\u0287\3\2\2\2\u0287\u00ae\3\2\2\2\u0288\u0286\3\2\2\2\u0289\u028b\5\u00a5"+
		"S\2\u028a\u028c\5\u00a5S\2\u028b\u028a\3\2\2\2\u028b\u028c\3\2\2\2\u028c"+
		"\u00b0\3\2\2\2\u028d\u028e\t\4\2\2\u028e\u00b2\3\2\2\2\u028f\u0294\7\""+
		"\2\2\u0290\u0291\7\17\2\2\u0291\u0294\7\f\2\2\u0292\u0294\t\5\2\2\u0293"+
		"\u028f\3\2\2\2\u0293\u0290\3\2\2\2\u0293\u0292\3\2\2\2\u0294\u0295\3\2"+
		"\2\2\u0295\u0296\bZ\2\2\u0296\u00b4\3\2\2\2\u0297\u0298\7/\2\2\u0298\u0299"+
		"\7/\2\2\u0299\u029d\3\2\2\2\u029a\u029c\n\6\2\2\u029b\u029a\3\2\2\2\u029c"+
		"\u029f\3\2\2\2\u029d\u029b\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u02a0\3\2"+
		"\2\2\u029f\u029d\3\2\2\2\u02a0\u02a1\b[\3\2\u02a1\u00b6\3\2\2\2\u02a2"+
		"\u02b9\7^\2\2\u02a3\u02ba\t\7\2\2\u02a4\u02a6\7w\2\2\u02a5\u02a4\3\2\2"+
		"\2\u02a6\u02a7\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a9"+
		"\3\2\2\2\u02a9\u02aa\5\u00b1Y\2\u02aa\u02ab\5\u00b1Y\2\u02ab\u02ac\5\u00b1"+
		"Y\2\u02ac\u02ad\5\u00b1Y\2\u02ad\u02ba\3\2\2\2\u02ae\u02b3\4\62\65\2\u02af"+
		"\u02b1\4\629\2\u02b0\u02b2\4\629\2\u02b1\u02b0\3\2\2\2\u02b1\u02b2\3\2"+
		"\2\2\u02b2\u02b4\3\2\2\2\u02b3\u02af\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4"+
		"\u02ba\3\2\2\2\u02b5\u02b7\4\669\2\u02b6\u02b8\4\629\2\u02b7\u02b6\3\2"+
		"\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02ba\3\2\2\2\u02b9\u02a3\3\2\2\2\u02b9"+
		"\u02a5\3\2\2\2\u02b9\u02ae\3\2\2\2\u02b9\u02b5\3\2\2\2\u02ba\u00b8\3\2"+
		"\2\2$\2\u020f\u0213\u0217\u0221\u0223\u022b\u0231\u0235\u023c\u0242\u0246"+
		"\u024a\u024f\u0255\u0259\u0260\u0263\u0265\u026b\u0270\u0274\u0279\u027d"+
		"\u0281\u0286\u028b\u0293\u029d\u02a7\u02b1\u02b3\u02b7\u02b9\4\b\2\2\2"+
		"\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
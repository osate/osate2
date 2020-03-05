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
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
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
		ABS=1, AND=2, ANY=3, BINDING=4, CLASSIFIER=5, COMPLETE=6, COMPUTATION=7, 
		COUNT=8, DISPATCH=9, DO=10, ELSE=11, ELSIF=12, END=13, FALSE=14, FINAL=15, 
		FOR=16, FORALL=17, FRESH=18, FROZEN=19, IF=20, IN=21, INITIAL=22, LOWER_BOUND=23, 
		MOD=24, NOT=25, ON=26, OR=27, OTHERWISE=28, REFERENCE=29, VARIABLES=30, 
		REM=31, STATE=32, STATES=33, STOP=34, TIMEOUT=35, TRANSITIONS=36, TRUE=37, 
		UNTIL=38, UPPER_BOUND=39, WHILE=40, XOR=41, LBRACK=42, RBRACK=43, COMMA=44, 
		LTRANS=45, RTRANS=46, LPAREN=47, RPAREN=48, CONCAT=49, LCURLY=50, RCURLY=51, 
		COLON=52, ASSIGN=53, PROPERTYASSIGN=54, EXCLAM=55, INTERROG=56, GGREATER=57, 
		EXCLLESS=58, EXCLGREATER=59, DOT=60, TICK=61, EQUAL=62, NOTEQUAL=63, LESSTHAN=64, 
		LESSOREQUAL=65, GREATERTHAN=66, GREATEROREQUAL=67, PLUS=68, MINUS=69, 
		STAR=70, DIVIDE=71, STARSTAR=72, DOTDOT=73, SEMICOLON=74, DOUBLECOLON=75, 
		HASH=76, ERR_EQUALEQUAL=77, ERR_END=78, ERR_ELSIF=79, IDENT=80, STRING_LITERAL=81, 
		REAL_LIT=82, INTEGER_LIT=83, WS=84, SL_COMMENT=85;
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
		"'P'", "'Q'", "'R'", "'S'", "'T'", "'U'"
	};
	public static final String[] ruleNames = {
		"ABS", "AND", "ANY", "BINDING", "CLASSIFIER", "COMPLETE", "COMPUTATION", 
		"COUNT", "DISPATCH", "DO", "ELSE", "ELSIF", "END", "FALSE", "FINAL", "FOR", 
		"FORALL", "FRESH", "FROZEN", "IF", "IN", "INITIAL", "LOWER_BOUND", "MOD", 
		"NOT", "ON", "OR", "OTHERWISE", "REFERENCE", "VARIABLES", "REM", "STATE", 
		"STATES", "STOP", "TIMEOUT", "TRANSITIONS", "TRUE", "UNTIL", "UPPER_BOUND", 
		"WHILE", "XOR", "LBRACK", "RBRACK", "COMMA", "LTRANS", "RTRANS", "LPAREN", 
		"RPAREN", "CONCAT", "LCURLY", "RCURLY", "COLON", "ASSIGN", "PROPERTYASSIGN", 
		"EXCLAM", "INTERROG", "GGREATER", "EXCLLESS", "EXCLGREATER", "DOT", "TICK", 
		"EQUAL", "NOTEQUAL", "LESSTHAN", "LESSOREQUAL", "GREATERTHAN", "GREATEROREQUAL", 
		"PLUS", "MINUS", "STAR", "DIVIDE", "STARSTAR", "DOTDOT", "SEMICOLON", 
		"DOUBLECOLON", "HASH", "ERR_EQUALEQUAL", "ERR_END", "ERR_ELSIF", "IDENT", 
		"LETTER", "STRING_LITERAL", "REAL_LIT", "INTEGER_LIT", "DIGIT", "EXPONENT", 
		"INT_EXPONENT", "EXTENDED_DIGIT", "BASED_INTEGER", "BASE", "HEX_DIGIT", 
		"WS", "SL_COMMENT", "ESC"
	};


	  public static final short KEYWORD_MAX_ID = 40 ;
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2W\u02d9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+"+
		"\3+\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63"+
		"\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\39\39\3"+
		":\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3@\3A\3A\3B\3B\3B\3"+
		"C\3C\3D\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3I\3J\3J\3J\3K\3K\3L\3L\3"+
		"L\3M\3M\3N\3N\3N\3O\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\3Q\3Q\5Q\u022e\nQ\3"+
		"Q\3Q\5Q\u0232\nQ\7Q\u0234\nQ\fQ\16Q\u0237\13Q\3R\3R\3S\3S\3S\3S\3S\7S"+
		"\u0240\nS\fS\16S\u0243\13S\3S\3S\3T\6T\u0248\nT\rT\16T\u0249\3T\3T\6T"+
		"\u024e\nT\rT\16T\u024f\7T\u0252\nT\fT\16T\u0255\13T\3T\3T\6T\u0259\nT"+
		"\rT\16T\u025a\3T\3T\6T\u025f\nT\rT\16T\u0260\7T\u0263\nT\fT\16T\u0266"+
		"\13T\3T\5T\u0269\nT\3U\6U\u026c\nU\rU\16U\u026d\3U\3U\6U\u0272\nU\rU\16"+
		"U\u0273\7U\u0276\nU\fU\16U\u0279\13U\3U\3U\3U\3U\5U\u027f\nU\3U\5U\u0282"+
		"\nU\5U\u0284\nU\3V\3V\3W\3W\5W\u028a\nW\3W\6W\u028d\nW\rW\16W\u028e\3"+
		"X\3X\5X\u0293\nX\3X\6X\u0296\nX\rX\16X\u0297\3Y\3Y\5Y\u029c\nY\3Z\3Z\5"+
		"Z\u02a0\nZ\3Z\7Z\u02a3\nZ\fZ\16Z\u02a6\13Z\3[\3[\5[\u02aa\n[\3\\\3\\\3"+
		"]\3]\3]\3]\5]\u02b2\n]\3]\3]\3^\3^\3^\3^\7^\u02ba\n^\f^\16^\u02bd\13^"+
		"\3^\3^\3_\3_\3_\6_\u02c4\n_\r_\16_\u02c5\3_\3_\3_\3_\3_\3_\3_\3_\5_\u02d0"+
		"\n_\5_\u02d2\n_\3_\3_\5_\u02d6\n_\5_\u02d8\n_\2\2`\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177"+
		"A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093"+
		"K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1R\u00a3\2\u00a5S\u00a7"+
		"T\u00a9U\u00ab\2\u00ad\2\u00af\2\u00b1\2\u00b3\2\u00b5\2\u00b7\2\u00b9"+
		"V\u00bbW\u00bd\2\3\2\b\4\2$$^^\4\2--//\4\2\62;ch\4\2\13\f\17\17\4\2\f"+
		"\f\17\17\n\2$$))^^ddhhppttvv\u02f4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2"+
		"\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2"+
		"u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2"+
		"\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2"+
		"\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b"+
		"\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a5\3\2\2"+
		"\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\3\u00bf"+
		"\3\2\2\2\5\u00c3\3\2\2\2\7\u00c7\3\2\2\2\t\u00cb\3\2\2\2\13\u00d3\3\2"+
		"\2\2\r\u00de\3\2\2\2\17\u00e7\3\2\2\2\21\u00f3\3\2\2\2\23\u00f9\3\2\2"+
		"\2\25\u0102\3\2\2\2\27\u0105\3\2\2\2\31\u010a\3\2\2\2\33\u0110\3\2\2\2"+
		"\35\u0114\3\2\2\2\37\u011a\3\2\2\2!\u0120\3\2\2\2#\u0124\3\2\2\2%\u012b"+
		"\3\2\2\2\'\u0131\3\2\2\2)\u0138\3\2\2\2+\u013b\3\2\2\2-\u013e\3\2\2\2"+
		"/\u0146\3\2\2\2\61\u0152\3\2\2\2\63\u0156\3\2\2\2\65\u015a\3\2\2\2\67"+
		"\u015d\3\2\2\29\u0160\3\2\2\2;\u016a\3\2\2\2=\u0174\3\2\2\2?\u017e\3\2"+
		"\2\2A\u0182\3\2\2\2C\u0188\3\2\2\2E\u018f\3\2\2\2G\u0194\3\2\2\2I\u019c"+
		"\3\2\2\2K\u01a8\3\2\2\2M\u01ad\3\2\2\2O\u01b3\3\2\2\2Q\u01bf\3\2\2\2S"+
		"\u01c5\3\2\2\2U\u01c9\3\2\2\2W\u01cb\3\2\2\2Y\u01cd\3\2\2\2[\u01cf\3\2"+
		"\2\2]\u01d2\3\2\2\2_\u01d6\3\2\2\2a\u01d8\3\2\2\2c\u01da\3\2\2\2e\u01dc"+
		"\3\2\2\2g\u01de\3\2\2\2i\u01e0\3\2\2\2k\u01e2\3\2\2\2m\u01e5\3\2\2\2o"+
		"\u01e8\3\2\2\2q\u01ea\3\2\2\2s\u01ec\3\2\2\2u\u01ef\3\2\2\2w\u01f2\3\2"+
		"\2\2y\u01f5\3\2\2\2{\u01f7\3\2\2\2}\u01f9\3\2\2\2\177\u01fb\3\2\2\2\u0081"+
		"\u01fe\3\2\2\2\u0083\u0200\3\2\2\2\u0085\u0203\3\2\2\2\u0087\u0205\3\2"+
		"\2\2\u0089\u0208\3\2\2\2\u008b\u020a\3\2\2\2\u008d\u020c\3\2\2\2\u008f"+
		"\u020e\3\2\2\2\u0091\u0210\3\2\2\2\u0093\u0213\3\2\2\2\u0095\u0216\3\2"+
		"\2\2\u0097\u0218\3\2\2\2\u0099\u021b\3\2\2\2\u009b\u021d\3\2\2\2\u009d"+
		"\u0220\3\2\2\2\u009f\u0226\3\2\2\2\u00a1\u022b\3\2\2\2\u00a3\u0238\3\2"+
		"\2\2\u00a5\u023a\3\2\2\2\u00a7\u0247\3\2\2\2\u00a9\u026b\3\2\2\2\u00ab"+
		"\u0285\3\2\2\2\u00ad\u0287\3\2\2\2\u00af\u0290\3\2\2\2\u00b1\u029b\3\2"+
		"\2\2\u00b3\u029d\3\2\2\2\u00b5\u02a7\3\2\2\2\u00b7\u02ab\3\2\2\2\u00b9"+
		"\u02b1\3\2\2\2\u00bb\u02b5\3\2\2\2\u00bd\u02c0\3\2\2\2\u00bf\u00c0\7c"+
		"\2\2\u00c0\u00c1\7d\2\2\u00c1\u00c2\7u\2\2\u00c2\4\3\2\2\2\u00c3\u00c4"+
		"\7c\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7f\2\2\u00c6\6\3\2\2\2\u00c7\u00c8"+
		"\7c\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca\7{\2\2\u00ca\b\3\2\2\2\u00cb\u00cc"+
		"\7d\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf\7f\2\2\u00cf"+
		"\u00d0\7k\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7i\2\2\u00d2\n\3\2\2\2\u00d3"+
		"\u00d4\7e\2\2\u00d4\u00d5\7n\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7u\2\2"+
		"\u00d7\u00d8\7u\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7h\2\2\u00da\u00db"+
		"\7k\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7t\2\2\u00dd\f\3\2\2\2\u00de\u00df"+
		"\7e\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1\7o\2\2\u00e1\u00e2\7r\2\2\u00e2"+
		"\u00e3\7n\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7g\2\2"+
		"\u00e6\16\3\2\2\2\u00e7\u00e8\7e\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7"+
		"o\2\2\u00ea\u00eb\7r\2\2\u00eb\u00ec\7w\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee"+
		"\7c\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7q\2\2\u00f1"+
		"\u00f2\7p\2\2\u00f2\20\3\2\2\2\u00f3\u00f4\7e\2\2\u00f4\u00f5\7q\2\2\u00f5"+
		"\u00f6\7w\2\2\u00f6\u00f7\7p\2\2\u00f7\u00f8\7v\2\2\u00f8\22\3\2\2\2\u00f9"+
		"\u00fa\7f\2\2\u00fa\u00fb\7k\2\2\u00fb\u00fc\7u\2\2\u00fc\u00fd\7r\2\2"+
		"\u00fd\u00fe\7c\2\2\u00fe\u00ff\7v\2\2\u00ff\u0100\7e\2\2\u0100\u0101"+
		"\7j\2\2\u0101\24\3\2\2\2\u0102\u0103\7f\2\2\u0103\u0104\7q\2\2\u0104\26"+
		"\3\2\2\2\u0105\u0106\7g\2\2\u0106\u0107\7n\2\2\u0107\u0108\7u\2\2\u0108"+
		"\u0109\7g\2\2\u0109\30\3\2\2\2\u010a\u010b\7g\2\2\u010b\u010c\7n\2\2\u010c"+
		"\u010d\7u\2\2\u010d\u010e\7k\2\2\u010e\u010f\7h\2\2\u010f\32\3\2\2\2\u0110"+
		"\u0111\7g\2\2\u0111\u0112\7p\2\2\u0112\u0113\7f\2\2\u0113\34\3\2\2\2\u0114"+
		"\u0115\7h\2\2\u0115\u0116\7c\2\2\u0116\u0117\7n\2\2\u0117\u0118\7u\2\2"+
		"\u0118\u0119\7g\2\2\u0119\36\3\2\2\2\u011a\u011b\7h\2\2\u011b\u011c\7"+
		"k\2\2\u011c\u011d\7p\2\2\u011d\u011e\7c\2\2\u011e\u011f\7n\2\2\u011f "+
		"\3\2\2\2\u0120\u0121\7h\2\2\u0121\u0122\7q\2\2\u0122\u0123\7t\2\2\u0123"+
		"\"\3\2\2\2\u0124\u0125\7h\2\2\u0125\u0126\7q\2\2\u0126\u0127\7t\2\2\u0127"+
		"\u0128\7c\2\2\u0128\u0129\7n\2\2\u0129\u012a\7n\2\2\u012a$\3\2\2\2\u012b"+
		"\u012c\7h\2\2\u012c\u012d\7t\2\2\u012d\u012e\7g\2\2\u012e\u012f\7u\2\2"+
		"\u012f\u0130\7j\2\2\u0130&\3\2\2\2\u0131\u0132\7h\2\2\u0132\u0133\7t\2"+
		"\2\u0133\u0134\7q\2\2\u0134\u0135\7|\2\2\u0135\u0136\7g\2\2\u0136\u0137"+
		"\7p\2\2\u0137(\3\2\2\2\u0138\u0139\7k\2\2\u0139\u013a\7h\2\2\u013a*\3"+
		"\2\2\2\u013b\u013c\7k\2\2\u013c\u013d\7p\2\2\u013d,\3\2\2\2\u013e\u013f"+
		"\7k\2\2\u013f\u0140\7p\2\2\u0140\u0141\7k\2\2\u0141\u0142\7v\2\2\u0142"+
		"\u0143\7k\2\2\u0143\u0144\7c\2\2\u0144\u0145\7n\2\2\u0145.\3\2\2\2\u0146"+
		"\u0147\7n\2\2\u0147\u0148\7q\2\2\u0148\u0149\7y\2\2\u0149\u014a\7g\2\2"+
		"\u014a\u014b\7t\2\2\u014b\u014c\7a\2\2\u014c\u014d\7d\2\2\u014d\u014e"+
		"\7q\2\2\u014e\u014f\7w\2\2\u014f\u0150\7p\2\2\u0150\u0151\7f\2\2\u0151"+
		"\60\3\2\2\2\u0152\u0153\7o\2\2\u0153\u0154\7q\2\2\u0154\u0155\7f\2\2\u0155"+
		"\62\3\2\2\2\u0156\u0157\7p\2\2\u0157\u0158\7q\2\2\u0158\u0159\7v\2\2\u0159"+
		"\64\3\2\2\2\u015a\u015b\7q\2\2\u015b\u015c\7p\2\2\u015c\66\3\2\2\2\u015d"+
		"\u015e\7q\2\2\u015e\u015f\7t\2\2\u015f8\3\2\2\2\u0160\u0161\7q\2\2\u0161"+
		"\u0162\7v\2\2\u0162\u0163\7j\2\2\u0163\u0164\7g\2\2\u0164\u0165\7t\2\2"+
		"\u0165\u0166\7y\2\2\u0166\u0167\7k\2\2\u0167\u0168\7u\2\2\u0168\u0169"+
		"\7g\2\2\u0169:\3\2\2\2\u016a\u016b\7t\2\2\u016b\u016c\7g\2\2\u016c\u016d"+
		"\7h\2\2\u016d\u016e\7g\2\2\u016e\u016f\7t\2\2\u016f\u0170\7g\2\2\u0170"+
		"\u0171\7p\2\2\u0171\u0172\7e\2\2\u0172\u0173\7g\2\2\u0173<\3\2\2\2\u0174"+
		"\u0175\7x\2\2\u0175\u0176\7c\2\2\u0176\u0177\7t\2\2\u0177\u0178\7k\2\2"+
		"\u0178\u0179\7c\2\2\u0179\u017a\7d\2\2\u017a\u017b\7n\2\2\u017b\u017c"+
		"\7g\2\2\u017c\u017d\7u\2\2\u017d>\3\2\2\2\u017e\u017f\7t\2\2\u017f\u0180"+
		"\7g\2\2\u0180\u0181\7o\2\2\u0181@\3\2\2\2\u0182\u0183\7u\2\2\u0183\u0184"+
		"\7v\2\2\u0184\u0185\7c\2\2\u0185\u0186\7v\2\2\u0186\u0187\7g\2\2\u0187"+
		"B\3\2\2\2\u0188\u0189\7u\2\2\u0189\u018a\7v\2\2\u018a\u018b\7c\2\2\u018b"+
		"\u018c\7v\2\2\u018c\u018d\7g\2\2\u018d\u018e\7u\2\2\u018eD\3\2\2\2\u018f"+
		"\u0190\7u\2\2\u0190\u0191\7v\2\2\u0191\u0192\7q\2\2\u0192\u0193\7r\2\2"+
		"\u0193F\3\2\2\2\u0194\u0195\7v\2\2\u0195\u0196\7k\2\2\u0196\u0197\7o\2"+
		"\2\u0197\u0198\7g\2\2\u0198\u0199\7q\2\2\u0199\u019a\7w\2\2\u019a\u019b"+
		"\7v\2\2\u019bH\3\2\2\2\u019c\u019d\7v\2\2\u019d\u019e\7t\2\2\u019e\u019f"+
		"\7c\2\2\u019f\u01a0\7p\2\2\u01a0\u01a1\7u\2\2\u01a1\u01a2\7k\2\2\u01a2"+
		"\u01a3\7v\2\2\u01a3\u01a4\7k\2\2\u01a4\u01a5\7q\2\2\u01a5\u01a6\7p\2\2"+
		"\u01a6\u01a7\7u\2\2\u01a7J\3\2\2\2\u01a8\u01a9\7v\2\2\u01a9\u01aa\7t\2"+
		"\2\u01aa\u01ab\7w\2\2\u01ab\u01ac\7g\2\2\u01acL\3\2\2\2\u01ad\u01ae\7"+
		"w\2\2\u01ae\u01af\7p\2\2\u01af\u01b0\7v\2\2\u01b0\u01b1\7k\2\2\u01b1\u01b2"+
		"\7n\2\2\u01b2N\3\2\2\2\u01b3\u01b4\7w\2\2\u01b4\u01b5\7r\2\2\u01b5\u01b6"+
		"\7r\2\2\u01b6\u01b7\7g\2\2\u01b7\u01b8\7t\2\2\u01b8\u01b9\7a\2\2\u01b9"+
		"\u01ba\7d\2\2\u01ba\u01bb\7q\2\2\u01bb\u01bc\7w\2\2\u01bc\u01bd\7p\2\2"+
		"\u01bd\u01be\7f\2\2\u01beP\3\2\2\2\u01bf\u01c0\7y\2\2\u01c0\u01c1\7j\2"+
		"\2\u01c1\u01c2\7k\2\2\u01c2\u01c3\7n\2\2\u01c3\u01c4\7g\2\2\u01c4R\3\2"+
		"\2\2\u01c5\u01c6\7z\2\2\u01c6\u01c7\7q\2\2\u01c7\u01c8\7t\2\2\u01c8T\3"+
		"\2\2\2\u01c9\u01ca\7]\2\2\u01caV\3\2\2\2\u01cb\u01cc\7_\2\2\u01ccX\3\2"+
		"\2\2\u01cd\u01ce\7.\2\2\u01ceZ\3\2\2\2\u01cf\u01d0\7/\2\2\u01d0\u01d1"+
		"\7]\2\2\u01d1\\\3\2\2\2\u01d2\u01d3\7_\2\2\u01d3\u01d4\7/\2\2\u01d4\u01d5"+
		"\7@\2\2\u01d5^\3\2\2\2\u01d6\u01d7\7*\2\2\u01d7`\3\2\2\2\u01d8\u01d9\7"+
		"+\2\2\u01d9b\3\2\2\2\u01da\u01db\7(\2\2\u01dbd\3\2\2\2\u01dc\u01dd\7}"+
		"\2\2\u01ddf\3\2\2\2\u01de\u01df\7\177\2\2\u01dfh\3\2\2\2\u01e0\u01e1\7"+
		"<\2\2\u01e1j\3\2\2\2\u01e2\u01e3\7<\2\2\u01e3\u01e4\7?\2\2\u01e4l\3\2"+
		"\2\2\u01e5\u01e6\7?\2\2\u01e6\u01e7\7@\2\2\u01e7n\3\2\2\2\u01e8\u01e9"+
		"\7#\2\2\u01e9p\3\2\2\2\u01ea\u01eb\7A\2\2\u01ebr\3\2\2\2\u01ec\u01ed\7"+
		"@\2\2\u01ed\u01ee\7@\2\2\u01eet\3\2\2\2\u01ef\u01f0\7#\2\2\u01f0\u01f1"+
		"\7>\2\2\u01f1v\3\2\2\2\u01f2\u01f3\7#\2\2\u01f3\u01f4\7@\2\2\u01f4x\3"+
		"\2\2\2\u01f5\u01f6\7\60\2\2\u01f6z\3\2\2\2\u01f7\u01f8\7)\2\2\u01f8|\3"+
		"\2\2\2\u01f9\u01fa\7?\2\2\u01fa~\3\2\2\2\u01fb\u01fc\7#\2\2\u01fc\u01fd"+
		"\7?\2\2\u01fd\u0080\3\2\2\2\u01fe\u01ff\7>\2\2\u01ff\u0082\3\2\2\2\u0200"+
		"\u0201\7>\2\2\u0201\u0202\7?\2\2\u0202\u0084\3\2\2\2\u0203\u0204\7@\2"+
		"\2\u0204\u0086\3\2\2\2\u0205\u0206\7@\2\2\u0206\u0207\7?\2\2\u0207\u0088"+
		"\3\2\2\2\u0208\u0209\7-\2\2\u0209\u008a\3\2\2\2\u020a\u020b\7/\2\2\u020b"+
		"\u008c\3\2\2\2\u020c\u020d\7,\2\2\u020d\u008e\3\2\2\2\u020e\u020f\7\61"+
		"\2\2\u020f\u0090\3\2\2\2\u0210\u0211\7,\2\2\u0211\u0212\7,\2\2\u0212\u0092"+
		"\3\2\2\2\u0213\u0214\7\60\2\2\u0214\u0215\7\60\2\2\u0215\u0094\3\2\2\2"+
		"\u0216\u0217\7=\2\2\u0217\u0096\3\2\2\2\u0218\u0219\7<\2\2\u0219\u021a"+
		"\7<\2\2\u021a\u0098\3\2\2\2\u021b\u021c\7%\2\2\u021c\u009a\3\2\2\2\u021d"+
		"\u021e\7?\2\2\u021e\u021f\7?\2\2\u021f\u009c\3\2\2\2\u0220\u0221\7g\2"+
		"\2\u0221\u0222\7p\2\2\u0222\u0223\7f\2\2\u0223\u0224\7k\2\2\u0224\u0225"+
		"\7h\2\2\u0225\u009e\3\2\2\2\u0226\u0227\7g\2\2\u0227\u0228\7n\2\2\u0228"+
		"\u0229\7k\2\2\u0229\u022a\7h\2\2\u022a\u00a0\3\2\2\2\u022b\u0235\5\u00a3"+
		"R\2\u022c\u022e\7a\2\2\u022d\u022c\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0231"+
		"\3\2\2\2\u022f\u0232\5\u00a3R\2\u0230\u0232\4\62;\2\u0231\u022f\3\2\2"+
		"\2\u0231\u0230\3\2\2\2\u0232\u0234\3\2\2\2\u0233\u022d\3\2\2\2\u0234\u0237"+
		"\3\2\2\2\u0235\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u00a2\3\2\2\2\u0237"+
		"\u0235\3\2\2\2\u0238\u0239\4c|\2\u0239\u00a4\3\2\2\2\u023a\u0241\7$\2"+
		"\2\u023b\u023c\7$\2\2\u023c\u0240\7$\2\2\u023d\u0240\5\u00bd_\2\u023e"+
		"\u0240\n\2\2\2\u023f\u023b\3\2\2\2\u023f\u023d\3\2\2\2\u023f\u023e\3\2"+
		"\2\2\u0240\u0243\3\2\2\2\u0241\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242"+
		"\u0244\3\2\2\2\u0243\u0241\3\2\2\2\u0244\u0245\7$\2\2\u0245\u00a6\3\2"+
		"\2\2\u0246\u0248\5\u00abV\2\u0247\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249"+
		"\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u0253\3\2\2\2\u024b\u024d\7a"+
		"\2\2\u024c\u024e\5\u00abV\2\u024d\u024c\3\2\2\2\u024e\u024f\3\2\2\2\u024f"+
		"\u024d\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0252\3\2\2\2\u0251\u024b\3\2"+
		"\2\2\u0252\u0255\3\2\2\2\u0253\u0251\3\2\2\2\u0253\u0254\3\2\2\2\u0254"+
		"\u0256\3\2\2\2\u0255\u0253\3\2\2\2\u0256\u0258\7\60\2\2\u0257\u0259\5"+
		"\u00abV\2\u0258\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u0258\3\2\2\2"+
		"\u025a\u025b\3\2\2\2\u025b\u0264\3\2\2\2\u025c\u025e\7a\2\2\u025d\u025f"+
		"\5\u00abV\2\u025e\u025d\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u025e\3\2\2"+
		"\2\u0260\u0261\3\2\2\2\u0261\u0263\3\2\2\2\u0262\u025c\3\2\2\2\u0263\u0266"+
		"\3\2\2\2\u0264\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u0268\3\2\2\2\u0266"+
		"\u0264\3\2\2\2\u0267\u0269\5\u00adW\2\u0268\u0267\3\2\2\2\u0268\u0269"+
		"\3\2\2\2\u0269\u00a8\3\2\2\2\u026a\u026c\5\u00abV\2\u026b\u026a\3\2\2"+
		"\2\u026c\u026d\3\2\2\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0277"+
		"\3\2\2\2\u026f\u0271\7a\2\2\u0270\u0272\5\u00abV\2\u0271\u0270\3\2\2\2"+
		"\u0272\u0273\3\2\2\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0276"+
		"\3\2\2\2\u0275\u026f\3\2\2\2\u0276\u0279\3\2\2\2\u0277\u0275\3\2\2\2\u0277"+
		"\u0278\3\2\2\2\u0278\u0283\3\2\2\2\u0279\u0277\3\2\2\2\u027a\u027b\7%"+
		"\2\2\u027b\u027c\5\u00b3Z\2\u027c\u027e\7%\2\2\u027d\u027f\5\u00afX\2"+
		"\u027e\u027d\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0284\3\2\2\2\u0280\u0282"+
		"\5\u00afX\2\u0281\u0280\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0284\3\2\2"+
		"\2\u0283\u027a\3\2\2\2\u0283\u0281\3\2\2\2\u0284\u00aa\3\2\2\2\u0285\u0286"+
		"\4\62;\2\u0286\u00ac\3\2\2\2\u0287\u0289\7g\2\2\u0288\u028a\t\3\2\2\u0289"+
		"\u0288\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028c\3\2\2\2\u028b\u028d\5\u00ab"+
		"V\2\u028c\u028b\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u028c\3\2\2\2\u028e"+
		"\u028f\3\2\2\2\u028f\u00ae\3\2\2\2\u0290\u0292\7g\2\2\u0291\u0293\7-\2"+
		"\2\u0292\u0291\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0295\3\2\2\2\u0294\u0296"+
		"\5\u00abV\2\u0295\u0294\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u0295\3\2\2"+
		"\2\u0297\u0298\3\2\2\2\u0298\u00b0\3\2\2\2\u0299\u029c\5\u00abV\2\u029a"+
		"\u029c\4ch\2\u029b\u0299\3\2\2\2\u029b\u029a\3\2\2\2\u029c\u00b2\3\2\2"+
		"\2\u029d\u02a4\5\u00b1Y\2\u029e\u02a0\7a\2\2\u029f\u029e\3\2\2\2\u029f"+
		"\u02a0\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a3\5\u00b1Y\2\u02a2\u029f"+
		"\3\2\2\2\u02a3\u02a6\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5"+
		"\u00b4\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a7\u02a9\5\u00abV\2\u02a8\u02aa"+
		"\5\u00abV\2\u02a9\u02a8\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u00b6\3\2\2"+
		"\2\u02ab\u02ac\t\4\2\2\u02ac\u00b8\3\2\2\2\u02ad\u02b2\7\"\2\2\u02ae\u02af"+
		"\7\17\2\2\u02af\u02b2\7\f\2\2\u02b0\u02b2\t\5\2\2\u02b1\u02ad\3\2\2\2"+
		"\u02b1\u02ae\3\2\2\2\u02b1\u02b0\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b4"+
		"\b]\2\2\u02b4\u00ba\3\2\2\2\u02b5\u02b6\7/\2\2\u02b6\u02b7\7/\2\2\u02b7"+
		"\u02bb\3\2\2\2\u02b8\u02ba\n\6\2\2\u02b9\u02b8\3\2\2\2\u02ba\u02bd\3\2"+
		"\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02be\3\2\2\2\u02bd"+
		"\u02bb\3\2\2\2\u02be\u02bf\b^\3\2\u02bf\u00bc\3\2\2\2\u02c0\u02d7\7^\2"+
		"\2\u02c1\u02d8\t\7\2\2\u02c2\u02c4\7w\2\2\u02c3\u02c2\3\2\2\2\u02c4\u02c5"+
		"\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7"+
		"\u02c8\5\u00b7\\\2\u02c8\u02c9\5\u00b7\\\2\u02c9\u02ca\5\u00b7\\\2\u02ca"+
		"\u02cb\5\u00b7\\\2\u02cb\u02d8\3\2\2\2\u02cc\u02d1\4\62\65\2\u02cd\u02cf"+
		"\4\629\2\u02ce\u02d0\4\629\2\u02cf\u02ce\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0"+
		"\u02d2\3\2\2\2\u02d1\u02cd\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d8\3\2"+
		"\2\2\u02d3\u02d5\4\669\2\u02d4\u02d6\4\629\2\u02d5\u02d4\3\2\2\2\u02d5"+
		"\u02d6\3\2\2\2\u02d6\u02d8\3\2\2\2\u02d7\u02c1\3\2\2\2\u02d7\u02c3\3\2"+
		"\2\2\u02d7\u02cc\3\2\2\2\u02d7\u02d3\3\2\2\2\u02d8\u00be\3\2\2\2$\2\u022d"+
		"\u0231\u0235\u023f\u0241\u0249\u024f\u0253\u025a\u0260\u0264\u0268\u026d"+
		"\u0273\u0277\u027e\u0281\u0283\u0289\u028e\u0292\u0297\u029b\u029f\u02a4"+
		"\u02a9\u02b1\u02bb\u02c5\u02cf\u02d1\u02d5\u02d7\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
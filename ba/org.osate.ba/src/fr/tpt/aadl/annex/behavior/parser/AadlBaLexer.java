// Generated from AadlBa.g by ANTLR 4.1

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
 
 package fr.tpt.aadl.annex.behavior.parser ;
 
 import fr.tpt.aadl.annex.behavior.texteditor.AadlBaHighlighter ;
 import fr.tpt.aadl.annex.behavior.texteditor.DefaultAadlBaHighlighter ;
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
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ABS=1, AND=2, ANY=3, COMPLETE=4, COMPUTATION=5, COUNT=6, DISPATCH=7, DO=8, 
		ELSE=9, ELSIF=10, END=11, FALSE=12, FINAL=13, FOR=14, FORALL=15, FRESH=16, 
		FROZEN=17, IF=18, IN=19, INITIAL=20, MOD=21, NOT=22, ON=23, OR=24, OTHERWISE=25, 
		VARIABLES=26, REM=27, STATE=28, STATES=29, STOP=30, TIMEOUT=31, TRANSITIONS=32, 
		TRUE=33, UNTIL=34, WHILE=35, XOR=36, LBRACK=37, RBRACK=38, COMMA=39, LTRANS=40, 
		RTRANS=41, LPAREN=42, RPAREN=43, CONCAT=44, LCURLY=45, RCURLY=46, COLON=47, 
		ASSIGN=48, EXCLAM=49, INTERROG=50, GGREATER=51, EXCLLESS=52, EXCLGREATER=53, 
		DOT=54, TICK=55, EQUAL=56, NOTEQUAL=57, LESSTHAN=58, LESSOREQUAL=59, GREATERTHAN=60, 
		GREATEROREQUAL=61, PLUS=62, MINUS=63, STAR=64, DIVIDE=65, STARSTAR=66, 
		DOTDOT=67, SEMICOLON=68, DOUBLECOLON=69, HASH=70, ERR_EQUALEQUAL=71, ERR_END=72, 
		ERR_ELSIF=73, IDENT=74, STRING_LITERAL=75, REAL_LIT=76, INTEGER_LIT=77, 
		WS=78, SL_COMMENT=79;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'abs'", "'and'", "'any'", "'complete'", "'computation'", "'count'", "'dispatch'", 
		"'do'", "'else'", "'elsif'", "'end'", "'false'", "'final'", "'for'", "'forall'", 
		"'fresh'", "'frozen'", "'if'", "'in'", "'initial'", "'mod'", "'not'", 
		"'on'", "'or'", "'otherwise'", "'variables'", "'rem'", "'state'", "'states'", 
		"'stop'", "'timeout'", "'transitions'", "'true'", "'until'", "'while'", 
		"'xor'", "'['", "']'", "','", "'-['", "']->'", "'('", "')'", "'&'", "'{'", 
		"'}'", "':'", "':='", "'!'", "'?'", "'>>'", "'!<'", "'!>'", "'.'", "'''", 
		"'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", 
		"'**'", "'..'", "';'", "'::'", "'#'", "'=='", "'endif'", "'elif'", "IDENT", 
		"STRING_LITERAL", "REAL_LIT", "INTEGER_LIT", "WS", "SL_COMMENT"
	};
	public static final String[] ruleNames = {
		"ABS", "AND", "ANY", "COMPLETE", "COMPUTATION", "COUNT", "DISPATCH", "DO", 
		"ELSE", "ELSIF", "END", "FALSE", "FINAL", "FOR", "FORALL", "FRESH", "FROZEN", 
		"IF", "IN", "INITIAL", "MOD", "NOT", "ON", "OR", "OTHERWISE", "VARIABLES", 
		"REM", "STATE", "STATES", "STOP", "TIMEOUT", "TRANSITIONS", "TRUE", "UNTIL", 
		"WHILE", "XOR", "LBRACK", "RBRACK", "COMMA", "LTRANS", "RTRANS", "LPAREN", 
		"RPAREN", "CONCAT", "LCURLY", "RCURLY", "COLON", "ASSIGN", "EXCLAM", "INTERROG", 
		"GGREATER", "EXCLLESS", "EXCLGREATER", "DOT", "TICK", "EQUAL", "NOTEQUAL", 
		"LESSTHAN", "LESSOREQUAL", "GREATERTHAN", "GREATEROREQUAL", "PLUS", "MINUS", 
		"STAR", "DIVIDE", "STARSTAR", "DOTDOT", "SEMICOLON", "DOUBLECOLON", "HASH", 
		"ERR_EQUALEQUAL", "ERR_END", "ERR_ELSIF", "IDENT", "LETTER", "STRING_LITERAL", 
		"REAL_LIT", "INTEGER_LIT", "DIGIT", "EXPONENT", "INT_EXPONENT", "EXTENDED_DIGIT", 
		"BASED_INTEGER", "BASE", "HEX_DIGIT", "WS", "SL_COMMENT", "ESC"
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 85: WS_action((RuleContext)_localctx, actionIndex); break;

		case 86: SL_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void SL_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2Q\u0295\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#"+
		"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3"+
		")\3)\3*\3*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67"+
		"\3\67\38\38\39\39\3:\3:\3:\3;\3;\3<\3<\3<\3=\3=\3>\3>\3>\3?\3?\3@\3@\3"+
		"A\3A\3B\3B\3C\3C\3C\3D\3D\3D\3E\3E\3F\3F\3F\3G\3G\3H\3H\3H\3I\3I\3I\3"+
		"I\3I\3I\3J\3J\3J\3J\3J\3K\3K\5K\u01ea\nK\3K\3K\5K\u01ee\nK\7K\u01f0\n"+
		"K\fK\16K\u01f3\13K\3L\3L\3M\3M\3M\3M\3M\7M\u01fc\nM\fM\16M\u01ff\13M\3"+
		"M\3M\3N\6N\u0204\nN\rN\16N\u0205\3N\3N\6N\u020a\nN\rN\16N\u020b\7N\u020e"+
		"\nN\fN\16N\u0211\13N\3N\3N\6N\u0215\nN\rN\16N\u0216\3N\3N\6N\u021b\nN"+
		"\rN\16N\u021c\7N\u021f\nN\fN\16N\u0222\13N\3N\5N\u0225\nN\3O\6O\u0228"+
		"\nO\rO\16O\u0229\3O\3O\6O\u022e\nO\rO\16O\u022f\7O\u0232\nO\fO\16O\u0235"+
		"\13O\3O\3O\3O\3O\5O\u023b\nO\3O\5O\u023e\nO\5O\u0240\nO\3P\3P\3Q\3Q\5"+
		"Q\u0246\nQ\3Q\6Q\u0249\nQ\rQ\16Q\u024a\3R\3R\5R\u024f\nR\3R\6R\u0252\n"+
		"R\rR\16R\u0253\3S\3S\5S\u0258\nS\3T\3T\5T\u025c\nT\3T\7T\u025f\nT\fT\16"+
		"T\u0262\13T\3U\3U\5U\u0266\nU\3V\3V\3W\3W\3W\3W\5W\u026e\nW\3W\3W\3X\3"+
		"X\3X\3X\7X\u0276\nX\fX\16X\u0279\13X\3X\3X\3Y\3Y\3Y\6Y\u0280\nY\rY\16"+
		"Y\u0281\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u028c\nY\5Y\u028e\nY\3Y\3Y\5Y\u0292"+
		"\nY\5Y\u0294\nY\2Z\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1"+
		"\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24"+
		"\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36"+
		"\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1"+
		"[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s;\1u"+
		"<\1w=\1y>\1{?\1}@\1\177A\1\u0081B\1\u0083C\1\u0085D\1\u0087E\1\u0089F"+
		"\1\u008bG\1\u008dH\1\u008fI\1\u0091J\1\u0093K\1\u0095L\1\u0097\2\1\u0099"+
		"M\1\u009bN\1\u009dO\1\u009f\2\1\u00a1\2\1\u00a3\2\1\u00a5\2\1\u00a7\2"+
		"\1\u00a9\2\1\u00ab\2\1\u00adP\2\u00afQ\3\u00b1\2\1\3\2\b\4\2$$^^\4\2-"+
		"-//\4\2\62;ch\4\2\13\f\17\17\4\2\f\f\17\17\n\2$$))^^ddhhppttvv\u02b0\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2"+
		"\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{"+
		"\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0099"+
		"\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2"+
		"\2\3\u00b3\3\2\2\2\5\u00b7\3\2\2\2\7\u00bb\3\2\2\2\t\u00bf\3\2\2\2\13"+
		"\u00c8\3\2\2\2\r\u00d4\3\2\2\2\17\u00da\3\2\2\2\21\u00e3\3\2\2\2\23\u00e6"+
		"\3\2\2\2\25\u00eb\3\2\2\2\27\u00f1\3\2\2\2\31\u00f5\3\2\2\2\33\u00fb\3"+
		"\2\2\2\35\u0101\3\2\2\2\37\u0105\3\2\2\2!\u010c\3\2\2\2#\u0112\3\2\2\2"+
		"%\u0119\3\2\2\2\'\u011c\3\2\2\2)\u011f\3\2\2\2+\u0127\3\2\2\2-\u012b\3"+
		"\2\2\2/\u012f\3\2\2\2\61\u0132\3\2\2\2\63\u0135\3\2\2\2\65\u013f\3\2\2"+
		"\2\67\u0149\3\2\2\29\u014d\3\2\2\2;\u0153\3\2\2\2=\u015a\3\2\2\2?\u015f"+
		"\3\2\2\2A\u0167\3\2\2\2C\u0173\3\2\2\2E\u0178\3\2\2\2G\u017e\3\2\2\2I"+
		"\u0184\3\2\2\2K\u0188\3\2\2\2M\u018a\3\2\2\2O\u018c\3\2\2\2Q\u018e\3\2"+
		"\2\2S\u0191\3\2\2\2U\u0195\3\2\2\2W\u0197\3\2\2\2Y\u0199\3\2\2\2[\u019b"+
		"\3\2\2\2]\u019d\3\2\2\2_\u019f\3\2\2\2a\u01a1\3\2\2\2c\u01a4\3\2\2\2e"+
		"\u01a6\3\2\2\2g\u01a8\3\2\2\2i\u01ab\3\2\2\2k\u01ae\3\2\2\2m\u01b1\3\2"+
		"\2\2o\u01b3\3\2\2\2q\u01b5\3\2\2\2s\u01b7\3\2\2\2u\u01ba\3\2\2\2w\u01bc"+
		"\3\2\2\2y\u01bf\3\2\2\2{\u01c1\3\2\2\2}\u01c4\3\2\2\2\177\u01c6\3\2\2"+
		"\2\u0081\u01c8\3\2\2\2\u0083\u01ca\3\2\2\2\u0085\u01cc\3\2\2\2\u0087\u01cf"+
		"\3\2\2\2\u0089\u01d2\3\2\2\2\u008b\u01d4\3\2\2\2\u008d\u01d7\3\2\2\2\u008f"+
		"\u01d9\3\2\2\2\u0091\u01dc\3\2\2\2\u0093\u01e2\3\2\2\2\u0095\u01e7\3\2"+
		"\2\2\u0097\u01f4\3\2\2\2\u0099\u01f6\3\2\2\2\u009b\u0203\3\2\2\2\u009d"+
		"\u0227\3\2\2\2\u009f\u0241\3\2\2\2\u00a1\u0243\3\2\2\2\u00a3\u024c\3\2"+
		"\2\2\u00a5\u0257\3\2\2\2\u00a7\u0259\3\2\2\2\u00a9\u0263\3\2\2\2\u00ab"+
		"\u0267\3\2\2\2\u00ad\u026d\3\2\2\2\u00af\u0271\3\2\2\2\u00b1\u027c\3\2"+
		"\2\2\u00b3\u00b4\7c\2\2\u00b4\u00b5\7d\2\2\u00b5\u00b6\7u\2\2\u00b6\4"+
		"\3\2\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7f\2\2\u00ba"+
		"\6\3\2\2\2\u00bb\u00bc\7c\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7{\2\2\u00be"+
		"\b\3\2\2\2\u00bf\u00c0\7e\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c2\7o\2\2\u00c2"+
		"\u00c3\7r\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7v\2\2"+
		"\u00c6\u00c7\7g\2\2\u00c7\n\3\2\2\2\u00c8\u00c9\7e\2\2\u00c9\u00ca\7q"+
		"\2\2\u00ca\u00cb\7o\2\2\u00cb\u00cc\7r\2\2\u00cc\u00cd\7w\2\2\u00cd\u00ce"+
		"\7v\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7k\2\2\u00d1"+
		"\u00d2\7q\2\2\u00d2\u00d3\7p\2\2\u00d3\f\3\2\2\2\u00d4\u00d5\7e\2\2\u00d5"+
		"\u00d6\7q\2\2\u00d6\u00d7\7w\2\2\u00d7\u00d8\7p\2\2\u00d8\u00d9\7v\2\2"+
		"\u00d9\16\3\2\2\2\u00da\u00db\7f\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7"+
		"u\2\2\u00dd\u00de\7r\2\2\u00de\u00df\7c\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1"+
		"\7e\2\2\u00e1\u00e2\7j\2\2\u00e2\20\3\2\2\2\u00e3\u00e4\7f\2\2\u00e4\u00e5"+
		"\7q\2\2\u00e5\22\3\2\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8\7n\2\2\u00e8\u00e9"+
		"\7u\2\2\u00e9\u00ea\7g\2\2\u00ea\24\3\2\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed"+
		"\7n\2\2\u00ed\u00ee\7u\2\2\u00ee\u00ef\7k\2\2\u00ef\u00f0\7h\2\2\u00f0"+
		"\26\3\2\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7f\2\2\u00f4"+
		"\30\3\2\2\2\u00f5\u00f6\7h\2\2\u00f6\u00f7\7c\2\2\u00f7\u00f8\7n\2\2\u00f8"+
		"\u00f9\7u\2\2\u00f9\u00fa\7g\2\2\u00fa\32\3\2\2\2\u00fb\u00fc\7h\2\2\u00fc"+
		"\u00fd\7k\2\2\u00fd\u00fe\7p\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100\7n\2\2"+
		"\u0100\34\3\2\2\2\u0101\u0102\7h\2\2\u0102\u0103\7q\2\2\u0103\u0104\7"+
		"t\2\2\u0104\36\3\2\2\2\u0105\u0106\7h\2\2\u0106\u0107\7q\2\2\u0107\u0108"+
		"\7t\2\2\u0108\u0109\7c\2\2\u0109\u010a\7n\2\2\u010a\u010b\7n\2\2\u010b"+
		" \3\2\2\2\u010c\u010d\7h\2\2\u010d\u010e\7t\2\2\u010e\u010f\7g\2\2\u010f"+
		"\u0110\7u\2\2\u0110\u0111\7j\2\2\u0111\"\3\2\2\2\u0112\u0113\7h\2\2\u0113"+
		"\u0114\7t\2\2\u0114\u0115\7q\2\2\u0115\u0116\7|\2\2\u0116\u0117\7g\2\2"+
		"\u0117\u0118\7p\2\2\u0118$\3\2\2\2\u0119\u011a\7k\2\2\u011a\u011b\7h\2"+
		"\2\u011b&\3\2\2\2\u011c\u011d\7k\2\2\u011d\u011e\7p\2\2\u011e(\3\2\2\2"+
		"\u011f\u0120\7k\2\2\u0120\u0121\7p\2\2\u0121\u0122\7k\2\2\u0122\u0123"+
		"\7v\2\2\u0123\u0124\7k\2\2\u0124\u0125\7c\2\2\u0125\u0126\7n\2\2\u0126"+
		"*\3\2\2\2\u0127\u0128\7o\2\2\u0128\u0129\7q\2\2\u0129\u012a\7f\2\2\u012a"+
		",\3\2\2\2\u012b\u012c\7p\2\2\u012c\u012d\7q\2\2\u012d\u012e\7v\2\2\u012e"+
		".\3\2\2\2\u012f\u0130\7q\2\2\u0130\u0131\7p\2\2\u0131\60\3\2\2\2\u0132"+
		"\u0133\7q\2\2\u0133\u0134\7t\2\2\u0134\62\3\2\2\2\u0135\u0136\7q\2\2\u0136"+
		"\u0137\7v\2\2\u0137\u0138\7j\2\2\u0138\u0139\7g\2\2\u0139\u013a\7t\2\2"+
		"\u013a\u013b\7y\2\2\u013b\u013c\7k\2\2\u013c\u013d\7u\2\2\u013d\u013e"+
		"\7g\2\2\u013e\64\3\2\2\2\u013f\u0140\7x\2\2\u0140\u0141\7c\2\2\u0141\u0142"+
		"\7t\2\2\u0142\u0143\7k\2\2\u0143\u0144\7c\2\2\u0144\u0145\7d\2\2\u0145"+
		"\u0146\7n\2\2\u0146\u0147\7g\2\2\u0147\u0148\7u\2\2\u0148\66\3\2\2\2\u0149"+
		"\u014a\7t\2\2\u014a\u014b\7g\2\2\u014b\u014c\7o\2\2\u014c8\3\2\2\2\u014d"+
		"\u014e\7u\2\2\u014e\u014f\7v\2\2\u014f\u0150\7c\2\2\u0150\u0151\7v\2\2"+
		"\u0151\u0152\7g\2\2\u0152:\3\2\2\2\u0153\u0154\7u\2\2\u0154\u0155\7v\2"+
		"\2\u0155\u0156\7c\2\2\u0156\u0157\7v\2\2\u0157\u0158\7g\2\2\u0158\u0159"+
		"\7u\2\2\u0159<\3\2\2\2\u015a\u015b\7u\2\2\u015b\u015c\7v\2\2\u015c\u015d"+
		"\7q\2\2\u015d\u015e\7r\2\2\u015e>\3\2\2\2\u015f\u0160\7v\2\2\u0160\u0161"+
		"\7k\2\2\u0161\u0162\7o\2\2\u0162\u0163\7g\2\2\u0163\u0164\7q\2\2\u0164"+
		"\u0165\7w\2\2\u0165\u0166\7v\2\2\u0166@\3\2\2\2\u0167\u0168\7v\2\2\u0168"+
		"\u0169\7t\2\2\u0169\u016a\7c\2\2\u016a\u016b\7p\2\2\u016b\u016c\7u\2\2"+
		"\u016c\u016d\7k\2\2\u016d\u016e\7v\2\2\u016e\u016f\7k\2\2\u016f\u0170"+
		"\7q\2\2\u0170\u0171\7p\2\2\u0171\u0172\7u\2\2\u0172B\3\2\2\2\u0173\u0174"+
		"\7v\2\2\u0174\u0175\7t\2\2\u0175\u0176\7w\2\2\u0176\u0177\7g\2\2\u0177"+
		"D\3\2\2\2\u0178\u0179\7w\2\2\u0179\u017a\7p\2\2\u017a\u017b\7v\2\2\u017b"+
		"\u017c\7k\2\2\u017c\u017d\7n\2\2\u017dF\3\2\2\2\u017e\u017f\7y\2\2\u017f"+
		"\u0180\7j\2\2\u0180\u0181\7k\2\2\u0181\u0182\7n\2\2\u0182\u0183\7g\2\2"+
		"\u0183H\3\2\2\2\u0184\u0185\7z\2\2\u0185\u0186\7q\2\2\u0186\u0187\7t\2"+
		"\2\u0187J\3\2\2\2\u0188\u0189\7]\2\2\u0189L\3\2\2\2\u018a\u018b\7_\2\2"+
		"\u018bN\3\2\2\2\u018c\u018d\7.\2\2\u018dP\3\2\2\2\u018e\u018f\7/\2\2\u018f"+
		"\u0190\7]\2\2\u0190R\3\2\2\2\u0191\u0192\7_\2\2\u0192\u0193\7/\2\2\u0193"+
		"\u0194\7@\2\2\u0194T\3\2\2\2\u0195\u0196\7*\2\2\u0196V\3\2\2\2\u0197\u0198"+
		"\7+\2\2\u0198X\3\2\2\2\u0199\u019a\7(\2\2\u019aZ\3\2\2\2\u019b\u019c\7"+
		"}\2\2\u019c\\\3\2\2\2\u019d\u019e\7\177\2\2\u019e^\3\2\2\2\u019f\u01a0"+
		"\7<\2\2\u01a0`\3\2\2\2\u01a1\u01a2\7<\2\2\u01a2\u01a3\7?\2\2\u01a3b\3"+
		"\2\2\2\u01a4\u01a5\7#\2\2\u01a5d\3\2\2\2\u01a6\u01a7\7A\2\2\u01a7f\3\2"+
		"\2\2\u01a8\u01a9\7@\2\2\u01a9\u01aa\7@\2\2\u01aah\3\2\2\2\u01ab\u01ac"+
		"\7#\2\2\u01ac\u01ad\7>\2\2\u01adj\3\2\2\2\u01ae\u01af\7#\2\2\u01af\u01b0"+
		"\7@\2\2\u01b0l\3\2\2\2\u01b1\u01b2\7\60\2\2\u01b2n\3\2\2\2\u01b3\u01b4"+
		"\7)\2\2\u01b4p\3\2\2\2\u01b5\u01b6\7?\2\2\u01b6r\3\2\2\2\u01b7\u01b8\7"+
		"#\2\2\u01b8\u01b9\7?\2\2\u01b9t\3\2\2\2\u01ba\u01bb\7>\2\2\u01bbv\3\2"+
		"\2\2\u01bc\u01bd\7>\2\2\u01bd\u01be\7?\2\2\u01bex\3\2\2\2\u01bf\u01c0"+
		"\7@\2\2\u01c0z\3\2\2\2\u01c1\u01c2\7@\2\2\u01c2\u01c3\7?\2\2\u01c3|\3"+
		"\2\2\2\u01c4\u01c5\7-\2\2\u01c5~\3\2\2\2\u01c6\u01c7\7/\2\2\u01c7\u0080"+
		"\3\2\2\2\u01c8\u01c9\7,\2\2\u01c9\u0082\3\2\2\2\u01ca\u01cb\7\61\2\2\u01cb"+
		"\u0084\3\2\2\2\u01cc\u01cd\7,\2\2\u01cd\u01ce\7,\2\2\u01ce\u0086\3\2\2"+
		"\2\u01cf\u01d0\7\60\2\2\u01d0\u01d1\7\60\2\2\u01d1\u0088\3\2\2\2\u01d2"+
		"\u01d3\7=\2\2\u01d3\u008a\3\2\2\2\u01d4\u01d5\7<\2\2\u01d5\u01d6\7<\2"+
		"\2\u01d6\u008c\3\2\2\2\u01d7\u01d8\7%\2\2\u01d8\u008e\3\2\2\2\u01d9\u01da"+
		"\7?\2\2\u01da\u01db\7?\2\2\u01db\u0090\3\2\2\2\u01dc\u01dd\7g\2\2\u01dd"+
		"\u01de\7p\2\2\u01de\u01df\7f\2\2\u01df\u01e0\7k\2\2\u01e0\u01e1\7h\2\2"+
		"\u01e1\u0092\3\2\2\2\u01e2\u01e3\7g\2\2\u01e3\u01e4\7n\2\2\u01e4\u01e5"+
		"\7k\2\2\u01e5\u01e6\7h\2\2\u01e6\u0094\3\2\2\2\u01e7\u01f1\5\u0097L\2"+
		"\u01e8\u01ea\7a\2\2\u01e9\u01e8\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ed"+
		"\3\2\2\2\u01eb\u01ee\5\u0097L\2\u01ec\u01ee\4\62;\2\u01ed\u01eb\3\2\2"+
		"\2\u01ed\u01ec\3\2\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01e9\3\2\2\2\u01f0\u01f3"+
		"\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u0096\3\2\2\2\u01f3"+
		"\u01f1\3\2\2\2\u01f4\u01f5\4c|\2\u01f5\u0098\3\2\2\2\u01f6\u01fd\7$\2"+
		"\2\u01f7\u01f8\7$\2\2\u01f8\u01fc\7$\2\2\u01f9\u01fc\5\u00b1Y\2\u01fa"+
		"\u01fc\n\2\2\2\u01fb\u01f7\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fa\3\2"+
		"\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe"+
		"\u0200\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0201\7$\2\2\u0201\u009a\3\2"+
		"\2\2\u0202\u0204\5\u009fP\2\u0203\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u020f\3\2\2\2\u0207\u0209\7a"+
		"\2\2\u0208\u020a\5\u009fP\2\u0209\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b"+
		"\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020e\3\2\2\2\u020d\u0207\3\2"+
		"\2\2\u020e\u0211\3\2\2\2\u020f\u020d\3\2\2\2\u020f\u0210\3\2\2\2\u0210"+
		"\u0212\3\2\2\2\u0211\u020f\3\2\2\2\u0212\u0214\7\60\2\2\u0213\u0215\5"+
		"\u009fP\2\u0214\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0214\3\2\2\2"+
		"\u0216\u0217\3\2\2\2\u0217\u0220\3\2\2\2\u0218\u021a\7a\2\2\u0219\u021b"+
		"\5\u009fP\2\u021a\u0219\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u021a\3\2\2"+
		"\2\u021c\u021d\3\2\2\2\u021d\u021f\3\2\2\2\u021e\u0218\3\2\2\2\u021f\u0222"+
		"\3\2\2\2\u0220\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0224\3\2\2\2\u0222"+
		"\u0220\3\2\2\2\u0223\u0225\5\u00a1Q\2\u0224\u0223\3\2\2\2\u0224\u0225"+
		"\3\2\2\2\u0225\u009c\3\2\2\2\u0226\u0228\5\u009fP\2\u0227\u0226\3\2\2"+
		"\2\u0228\u0229\3\2\2\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u0233"+
		"\3\2\2\2\u022b\u022d\7a\2\2\u022c\u022e\5\u009fP\2\u022d\u022c\3\2\2\2"+
		"\u022e\u022f\3\2\2\2\u022f\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0232"+
		"\3\2\2\2\u0231\u022b\3\2\2\2\u0232\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0233"+
		"\u0234\3\2\2\2\u0234\u023f\3\2\2\2\u0235\u0233\3\2\2\2\u0236\u0237\7%"+
		"\2\2\u0237\u0238\5\u00a7T\2\u0238\u023a\7%\2\2\u0239\u023b\5\u00a3R\2"+
		"\u023a\u0239\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u0240\3\2\2\2\u023c\u023e"+
		"\5\u00a3R\2\u023d\u023c\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0240\3\2\2"+
		"\2\u023f\u0236\3\2\2\2\u023f\u023d\3\2\2\2\u0240\u009e\3\2\2\2\u0241\u0242"+
		"\4\62;\2\u0242\u00a0\3\2\2\2\u0243\u0245\7g\2\2\u0244\u0246\t\3\2\2\u0245"+
		"\u0244\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0248\3\2\2\2\u0247\u0249\5\u009f"+
		"P\2\u0248\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u0248\3\2\2\2\u024a"+
		"\u024b\3\2\2\2\u024b\u00a2\3\2\2\2\u024c\u024e\7g\2\2\u024d\u024f\7-\2"+
		"\2\u024e\u024d\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0251\3\2\2\2\u0250\u0252"+
		"\5\u009fP\2\u0251\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0251\3\2\2"+
		"\2\u0253\u0254\3\2\2\2\u0254\u00a4\3\2\2\2\u0255\u0258\5\u009fP\2\u0256"+
		"\u0258\4ch\2\u0257\u0255\3\2\2\2\u0257\u0256\3\2\2\2\u0258\u00a6\3\2\2"+
		"\2\u0259\u0260\5\u00a5S\2\u025a\u025c\7a\2\2\u025b\u025a\3\2\2\2\u025b"+
		"\u025c\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025f\5\u00a5S\2\u025e\u025b"+
		"\3\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261"+
		"\u00a8\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u0265\5\u009fP\2\u0264\u0266"+
		"\5\u009fP\2\u0265\u0264\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u00aa\3\2\2"+
		"\2\u0267\u0268\t\4\2\2\u0268\u00ac\3\2\2\2\u0269\u026e\7\"\2\2\u026a\u026b"+
		"\7\17\2\2\u026b\u026e\7\f\2\2\u026c\u026e\t\5\2\2\u026d\u0269\3\2\2\2"+
		"\u026d\u026a\3\2\2\2\u026d\u026c\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0270"+
		"\bW\2\2\u0270\u00ae\3\2\2\2\u0271\u0272\7/\2\2\u0272\u0273\7/\2\2\u0273"+
		"\u0277\3\2\2\2\u0274\u0276\n\6\2\2\u0275\u0274\3\2\2\2\u0276\u0279\3\2"+
		"\2\2\u0277\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u027a\3\2\2\2\u0279"+
		"\u0277\3\2\2\2\u027a\u027b\bX\3\2\u027b\u00b0\3\2\2\2\u027c\u0293\7^\2"+
		"\2\u027d\u0294\t\7\2\2\u027e\u0280\7w\2\2\u027f\u027e\3\2\2\2\u0280\u0281"+
		"\3\2\2\2\u0281\u027f\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0283\3\2\2\2\u0283"+
		"\u0284\5\u00abV\2\u0284\u0285\5\u00abV\2\u0285\u0286\5\u00abV\2\u0286"+
		"\u0287\5\u00abV\2\u0287\u0294\3\2\2\2\u0288\u028d\4\62\65\2\u0289\u028b"+
		"\4\629\2\u028a\u028c\4\629\2\u028b\u028a\3\2\2\2\u028b\u028c\3\2\2\2\u028c"+
		"\u028e\3\2\2\2\u028d\u0289\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u0294\3\2"+
		"\2\2\u028f\u0291\4\669\2\u0290\u0292\4\629\2\u0291\u0290\3\2\2\2\u0291"+
		"\u0292\3\2\2\2\u0292\u0294\3\2\2\2\u0293\u027d\3\2\2\2\u0293\u027f\3\2"+
		"\2\2\u0293\u0288\3\2\2\2\u0293\u028f\3\2\2\2\u0294\u00b2\3\2\2\2$\2\u01e9"+
		"\u01ed\u01f1\u01fb\u01fd\u0205\u020b\u020f\u0216\u021c\u0220\u0224\u0229"+
		"\u022f\u0233\u023a\u023d\u023f\u0245\u024a\u024e\u0253\u0257\u025b\u0260"+
		"\u0265\u026d\u0277\u0281\u028b\u028d\u0291\u0293";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// $ANTLR 3.4 AadlBa.g 2012-07-27 12:00:47

  /**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
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
  
  package fr.tpt.aadl.annex.behavior.parser;
  
  import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AadlBaLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ABS=4;
    public static final int AND=5;
    public static final int ANY=6;
    public static final int ASSIGN=7;
    public static final int BASE=8;
    public static final int BASED_INTEGER=9;
    public static final int COLON=10;
    public static final int COMMA=11;
    public static final int COMPLETE=12;
    public static final int COMPUTATION=13;
    public static final int CONCAT=14;
    public static final int COUNT=15;
    public static final int DIGIT=16;
    public static final int DISPATCH=17;
    public static final int DIVIDE=18;
    public static final int DO=19;
    public static final int DOT=20;
    public static final int DOTDOT=21;
    public static final int DOUBLECOLON=22;
    public static final int ELSE=23;
    public static final int ELSIF=24;
    public static final int END=25;
    public static final int ENUMERATOR=26;
    public static final int EQUAL=27;
    public static final int ESC=28;
    public static final int EXCLAM=29;
    public static final int EXCLGREATER=30;
    public static final int EXCLLESS=31;
    public static final int EXPONENT=32;
    public static final int EXTENDED_DIGIT=33;
    public static final int FALSE=34;
    public static final int FINAL=35;
    public static final int FOR=36;
    public static final int FORALL=37;
    public static final int FRESH=38;
    public static final int FROZEN=39;
    public static final int GGREATER=40;
    public static final int GREATEROREQUAL=41;
    public static final int GREATERTHAN=42;
    public static final int HASH=43;
    public static final int HEX_DIGIT=44;
    public static final int IDENT=45;
    public static final int IF=46;
    public static final int IN=47;
    public static final int INITIAL=48;
    public static final int INTEGER_LIT=49;
    public static final int INTERROG=50;
    public static final int INT_EXPONENT=51;
    public static final int LBRACK=52;
    public static final int LCURLY=53;
    public static final int LESSOREQUAL=54;
    public static final int LESSTHAN=55;
    public static final int LETTER=56;
    public static final int LPAREN=57;
    public static final int LTRANS=58;
    public static final int MINUS=59;
    public static final int MOD=60;
    public static final int NOT=61;
    public static final int NOTEQUAL=62;
    public static final int ON=63;
    public static final int OR=64;
    public static final int OTHERWISE=65;
    public static final int PLUS=66;
    public static final int RBRACK=67;
    public static final int RCURLY=68;
    public static final int REAL_LIT=69;
    public static final int REM=70;
    public static final int RPAREN=71;
    public static final int RTRANS=72;
    public static final int SEMICOLON=73;
    public static final int SL_COMMENT=74;
    public static final int STAR=75;
    public static final int STARSTAR=76;
    public static final int STATE=77;
    public static final int STATES=78;
    public static final int STOP=79;
    public static final int STRING_LITERAL=80;
    public static final int TICK=81;
    public static final int TIMEOUT=82;
    public static final int TRANSITIONS=83;
    public static final int TRUE=84;
    public static final int UNTIL=85;
    public static final int VARIABLES=86;
    public static final int WHILE=87;
    public static final int WS=88;
    public static final int XOR=89;

      public static final int COMMENT_CHANNEL=10;
      
      protected String filename=null;
      
      public void setFilename(String n){
       filename=n;
      }
      
      /**
       * the current resource being parsed
       */
      protected ParseErrorReporter errReporter = null;
      
      /**
       * Set the Parse Error Reporter with which to produce error messages.
       */
      public void setParseErrorReporter(final ParseErrorReporter reporter) {
          errReporter = reporter;
      }
          
      /**
       * Report lexer error
       * @param e  antlr error exception 
       */
      public  void reportError(RecognitionException e) {
            String description=null;
            if (e instanceof MismatchedTokenException){
              MismatchedTokenException mte = (MismatchedTokenException) e;
                String found = (mte.token != null ) ? mte.token.getText() : "null";
                String expecting = (mte.expecting < AadlBaParser.tokenNames.length && mte.expecting >=0) ? 
                    AadlBaParser.tokenNames[mte.expecting] : "null";
                description = "Expecting: "+expecting+", found: "+found;
            } else if (e instanceof MismatchedTreeNodeException){
              description = "Unexpected Tree Node Exception";
            } else if (e instanceof NoViableAltException){
              NoViableAltException nva = (NoViableAltException) e;
              description = "No viable alternative: "+nva.grammarDecisionDescription;
            } else if (e instanceof EarlyExitException){
              EarlyExitException ee = (EarlyExitException) e;
              description = "Early Exit";
            } else if (e instanceof FailedPredicateException){
              FailedPredicateException fp = (FailedPredicateException)e;
              description = "Semantic error: "+fp.predicateText;
            } else if (e instanceof MismatchedRangeException){
              MismatchedRangeException mr = (MismatchedRangeException)e;
              description = "Mismatched range: ";
            } else if (e instanceof MismatchedSetException){
              MismatchedSetException ms = (MismatchedSetException)e;
              description = "Mismatched set";
            } else if (e instanceof MismatchedNotSetException){
              description="Mismatched of inverse of a set";
            } 
            description += " at line " + e.line + " col " + e.charPositionInLine ;
            errReporter.error(this.getFilename(), e.line, description);
      }
      
      public String getFilename(){
        return filename;
      }
      


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public AadlBaLexer() {} 
    public AadlBaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AadlBaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "AadlBa.g"; }

    // $ANTLR start "ABS"
    public final void mABS() throws RecognitionException {
        try {
            int _type = ABS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:285:16: ( 'abs' )
            // AadlBa.g:285:18: 'abs'
            {
            match("abs"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ABS"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:286:16: ( 'and' )
            // AadlBa.g:286:18: 'and'
            {
            match("and"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "ANY"
    public final void mANY() throws RecognitionException {
        try {
            int _type = ANY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:287:16: ( 'any' )
            // AadlBa.g:287:18: 'any'
            {
            match("any"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ANY"

    // $ANTLR start "COMPLETE"
    public final void mCOMPLETE() throws RecognitionException {
        try {
            int _type = COMPLETE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:288:16: ( 'complete' )
            // AadlBa.g:288:18: 'complete'
            {
            match("complete"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMPLETE"

    // $ANTLR start "COMPUTATION"
    public final void mCOMPUTATION() throws RecognitionException {
        try {
            int _type = COMPUTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:289:16: ( 'computation' )
            // AadlBa.g:289:18: 'computation'
            {
            match("computation"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMPUTATION"

    // $ANTLR start "COUNT"
    public final void mCOUNT() throws RecognitionException {
        try {
            int _type = COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:290:16: ( 'count' )
            // AadlBa.g:290:18: 'count'
            {
            match("count"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COUNT"

    // $ANTLR start "DISPATCH"
    public final void mDISPATCH() throws RecognitionException {
        try {
            int _type = DISPATCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:291:16: ( 'dispatch' )
            // AadlBa.g:291:18: 'dispatch'
            {
            match("dispatch"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DISPATCH"

    // $ANTLR start "DO"
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:292:16: ( 'do' )
            // AadlBa.g:292:18: 'do'
            {
            match("do"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DO"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:293:16: ( 'else' )
            // AadlBa.g:293:18: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "ELSIF"
    public final void mELSIF() throws RecognitionException {
        try {
            int _type = ELSIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:294:16: ( 'elsif' )
            // AadlBa.g:294:18: 'elsif'
            {
            match("elsif"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSIF"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:295:16: ( 'end' )
            // AadlBa.g:295:18: 'end'
            {
            match("end"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:296:16: ( 'false' )
            // AadlBa.g:296:18: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "FINAL"
    public final void mFINAL() throws RecognitionException {
        try {
            int _type = FINAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:297:16: ( 'final' )
            // AadlBa.g:297:18: 'final'
            {
            match("final"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FINAL"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:298:16: ( 'for' )
            // AadlBa.g:298:18: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "FORALL"
    public final void mFORALL() throws RecognitionException {
        try {
            int _type = FORALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:299:16: ( 'forall' )
            // AadlBa.g:299:18: 'forall'
            {
            match("forall"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FORALL"

    // $ANTLR start "FRESH"
    public final void mFRESH() throws RecognitionException {
        try {
            int _type = FRESH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:300:16: ( 'fresh' )
            // AadlBa.g:300:18: 'fresh'
            {
            match("fresh"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FRESH"

    // $ANTLR start "FROZEN"
    public final void mFROZEN() throws RecognitionException {
        try {
            int _type = FROZEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:301:16: ( 'frozen' )
            // AadlBa.g:301:18: 'frozen'
            {
            match("frozen"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FROZEN"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:302:16: ( 'if' )
            // AadlBa.g:302:18: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:303:16: ( 'in' )
            // AadlBa.g:303:18: 'in'
            {
            match("in"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "INITIAL"
    public final void mINITIAL() throws RecognitionException {
        try {
            int _type = INITIAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:304:16: ( 'initial' )
            // AadlBa.g:304:18: 'initial'
            {
            match("initial"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INITIAL"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:305:16: ( 'mod' )
            // AadlBa.g:305:18: 'mod'
            {
            match("mod"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:306:16: ( 'not' )
            // AadlBa.g:306:18: 'not'
            {
            match("not"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "ON"
    public final void mON() throws RecognitionException {
        try {
            int _type = ON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:307:16: ( 'on' )
            // AadlBa.g:307:18: 'on'
            {
            match("on"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ON"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:308:16: ( 'or' )
            // AadlBa.g:308:18: 'or'
            {
            match("or"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "OTHERWISE"
    public final void mOTHERWISE() throws RecognitionException {
        try {
            int _type = OTHERWISE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:309:16: ( 'otherwise' )
            // AadlBa.g:309:18: 'otherwise'
            {
            match("otherwise"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OTHERWISE"

    // $ANTLR start "VARIABLES"
    public final void mVARIABLES() throws RecognitionException {
        try {
            int _type = VARIABLES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:310:16: ( 'variables' )
            // AadlBa.g:310:18: 'variables'
            {
            match("variables"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VARIABLES"

    // $ANTLR start "REM"
    public final void mREM() throws RecognitionException {
        try {
            int _type = REM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:311:16: ( 'rem' )
            // AadlBa.g:311:18: 'rem'
            {
            match("rem"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REM"

    // $ANTLR start "STATE"
    public final void mSTATE() throws RecognitionException {
        try {
            int _type = STATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:312:16: ( 'state' )
            // AadlBa.g:312:18: 'state'
            {
            match("state"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STATE"

    // $ANTLR start "STATES"
    public final void mSTATES() throws RecognitionException {
        try {
            int _type = STATES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:313:16: ( 'states' )
            // AadlBa.g:313:18: 'states'
            {
            match("states"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STATES"

    // $ANTLR start "STOP"
    public final void mSTOP() throws RecognitionException {
        try {
            int _type = STOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:314:16: ( 'stop' )
            // AadlBa.g:314:18: 'stop'
            {
            match("stop"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STOP"

    // $ANTLR start "TIMEOUT"
    public final void mTIMEOUT() throws RecognitionException {
        try {
            int _type = TIMEOUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:315:16: ( 'timeout' )
            // AadlBa.g:315:18: 'timeout'
            {
            match("timeout"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TIMEOUT"

    // $ANTLR start "TRANSITIONS"
    public final void mTRANSITIONS() throws RecognitionException {
        try {
            int _type = TRANSITIONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:316:16: ( 'transitions' )
            // AadlBa.g:316:18: 'transitions'
            {
            match("transitions"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRANSITIONS"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:317:16: ( 'true' )
            // AadlBa.g:317:18: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "UNTIL"
    public final void mUNTIL() throws RecognitionException {
        try {
            int _type = UNTIL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:318:16: ( 'until' )
            // AadlBa.g:318:18: 'until'
            {
            match("until"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNTIL"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:319:16: ( 'while' )
            // AadlBa.g:319:18: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "XOR"
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:320:16: ( 'xor' )
            // AadlBa.g:320:18: 'xor'
            {
            match("xor"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "XOR"

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:324:16: ( '[' )
            // AadlBa.g:324:18: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:325:16: ( ']' )
            // AadlBa.g:325:18: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:326:16: ( ',' )
            // AadlBa.g:326:18: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "LTRANS"
    public final void mLTRANS() throws RecognitionException {
        try {
            int _type = LTRANS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:327:16: ( '-[' )
            // AadlBa.g:327:18: '-['
            {
            match("-["); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LTRANS"

    // $ANTLR start "RTRANS"
    public final void mRTRANS() throws RecognitionException {
        try {
            int _type = RTRANS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:328:16: ( ']->' )
            // AadlBa.g:328:18: ']->'
            {
            match("]->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RTRANS"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:329:16: ( '(' )
            // AadlBa.g:329:18: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:330:16: ( ')' )
            // AadlBa.g:330:18: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "CONCAT"
    public final void mCONCAT() throws RecognitionException {
        try {
            int _type = CONCAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:331:16: ( '&' )
            // AadlBa.g:331:18: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONCAT"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:332:16: ( '{' )
            // AadlBa.g:332:18: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:333:16: ( '}' )
            // AadlBa.g:333:18: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:334:16: ( ':' )
            // AadlBa.g:334:18: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:335:16: ( ':=' )
            // AadlBa.g:335:18: ':='
            {
            match(":="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "EXCLAM"
    public final void mEXCLAM() throws RecognitionException {
        try {
            int _type = EXCLAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:336:16: ( '!' )
            // AadlBa.g:336:18: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXCLAM"

    // $ANTLR start "INTERROG"
    public final void mINTERROG() throws RecognitionException {
        try {
            int _type = INTERROG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:337:16: ( '?' )
            // AadlBa.g:337:18: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTERROG"

    // $ANTLR start "GGREATER"
    public final void mGGREATER() throws RecognitionException {
        try {
            int _type = GGREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:338:16: ( '>>' )
            // AadlBa.g:338:18: '>>'
            {
            match(">>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GGREATER"

    // $ANTLR start "EXCLLESS"
    public final void mEXCLLESS() throws RecognitionException {
        try {
            int _type = EXCLLESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:339:16: ( '!<' )
            // AadlBa.g:339:18: '!<'
            {
            match("!<"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXCLLESS"

    // $ANTLR start "EXCLGREATER"
    public final void mEXCLGREATER() throws RecognitionException {
        try {
            int _type = EXCLGREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:340:16: ( '!>' )
            // AadlBa.g:340:18: '!>'
            {
            match("!>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXCLGREATER"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:341:16: ( '.' )
            // AadlBa.g:341:18: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "TICK"
    public final void mTICK() throws RecognitionException {
        try {
            int _type = TICK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:342:16: ( '\\'' )
            // AadlBa.g:342:18: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TICK"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:343:16: ( '=' )
            // AadlBa.g:343:18: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "NOTEQUAL"
    public final void mNOTEQUAL() throws RecognitionException {
        try {
            int _type = NOTEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:344:16: ( '!=' )
            // AadlBa.g:344:18: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOTEQUAL"

    // $ANTLR start "LESSTHAN"
    public final void mLESSTHAN() throws RecognitionException {
        try {
            int _type = LESSTHAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:345:16: ( '<' )
            // AadlBa.g:345:18: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LESSTHAN"

    // $ANTLR start "LESSOREQUAL"
    public final void mLESSOREQUAL() throws RecognitionException {
        try {
            int _type = LESSOREQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:346:16: ( '<=' )
            // AadlBa.g:346:18: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LESSOREQUAL"

    // $ANTLR start "GREATERTHAN"
    public final void mGREATERTHAN() throws RecognitionException {
        try {
            int _type = GREATERTHAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:347:16: ( '>' )
            // AadlBa.g:347:18: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GREATERTHAN"

    // $ANTLR start "GREATEROREQUAL"
    public final void mGREATEROREQUAL() throws RecognitionException {
        try {
            int _type = GREATEROREQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:348:16: ( '>=' )
            // AadlBa.g:348:18: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GREATEROREQUAL"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:349:16: ( '+' )
            // AadlBa.g:349:18: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:350:16: ( '-' )
            // AadlBa.g:350:18: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:351:16: ( '*' )
            // AadlBa.g:351:18: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "DIVIDE"
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:352:16: ( '/' )
            // AadlBa.g:352:18: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIVIDE"

    // $ANTLR start "STARSTAR"
    public final void mSTARSTAR() throws RecognitionException {
        try {
            int _type = STARSTAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:353:16: ( '**' )
            // AadlBa.g:353:18: '**'
            {
            match("**"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STARSTAR"

    // $ANTLR start "DOTDOT"
    public final void mDOTDOT() throws RecognitionException {
        try {
            int _type = DOTDOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:354:16: ( '..' )
            // AadlBa.g:354:18: '..'
            {
            match(".."); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOTDOT"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:355:16: ( ';' )
            // AadlBa.g:355:18: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "DOUBLECOLON"
    public final void mDOUBLECOLON() throws RecognitionException {
        try {
            int _type = DOUBLECOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:357:16: ( '::' )
            // AadlBa.g:357:18: '::'
            {
            match("::"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLECOLON"

    // $ANTLR start "HASH"
    public final void mHASH() throws RecognitionException {
        try {
            int _type = HASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:358:16: ( '#' )
            // AadlBa.g:358:18: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HASH"

    // $ANTLR start "ENUMERATOR"
    public final void mENUMERATOR() throws RecognitionException {
        try {
            int _type = ENUMERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:360:16: ( 'enumerators' )
            // AadlBa.g:360:18: 'enumerators'
            {
            match("enumerators"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ENUMERATOR"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:2332:7: ( LETTER ( ( '_' )? ( LETTER | '0' .. '9' ) )* )
            // AadlBa.g:2332:9: LETTER ( ( '_' )? ( LETTER | '0' .. '9' ) )*
            {
            mLETTER(); 


            // AadlBa.g:2333:7: ( ( '_' )? ( LETTER | '0' .. '9' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // AadlBa.g:2334:9: ( '_' )? ( LETTER | '0' .. '9' )
            	    {
            	    // AadlBa.g:2334:9: ( '_' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0=='_') ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // AadlBa.g:2334:10: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // AadlBa.g:2341:8: ( ( 'a' .. 'z' ) )
            // AadlBa.g:
            {
            if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:2342:15: ( '\"' ( '\"\"' | ESC |~ ( '\"' | '\\\\' ) )* '\"' )
            // AadlBa.g:2342:16: '\"' ( '\"\"' | ESC |~ ( '\"' | '\\\\' ) )* '\"'
            {
            match('\"'); 

            // AadlBa.g:2342:20: ( '\"\"' | ESC |~ ( '\"' | '\\\\' ) )*
            loop3:
            do {
                int alt3=4;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\"') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='\"') ) {
                        alt3=1;
                    }


                }
                else if ( (LA3_0=='\\') ) {
                    alt3=2;
                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
                    alt3=3;
                }


                switch (alt3) {
            	case 1 :
            	    // AadlBa.g:2342:21: '\"\"'
            	    {
            	    match("\"\""); 



            	    }
            	    break;
            	case 2 :
            	    // AadlBa.g:2342:27: ESC
            	    {
            	    mESC(); 


            	    }
            	    break;
            	case 3 :
            	    // AadlBa.g:2342:31: ~ ( '\"' | '\\\\' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "REAL_LIT"
    public final void mREAL_LIT() throws RecognitionException {
        try {
            int _type = REAL_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:2344:10: ( ( DIGIT )+ ( '_' ( DIGIT )+ )* ( ( '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )? ) ) )
            // AadlBa.g:2344:13: ( DIGIT )+ ( '_' ( DIGIT )+ )* ( ( '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )? ) )
            {
            // AadlBa.g:2344:13: ( DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // AadlBa.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            // AadlBa.g:2344:21: ( '_' ( DIGIT )+ )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='_') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // AadlBa.g:2344:22: '_' ( DIGIT )+
            	    {
            	    match('_'); 

            	    // AadlBa.g:2344:26: ( DIGIT )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // AadlBa.g:
            	    	    {
            	    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	    	        input.consume();
            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;
            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt5 >= 1 ) break loop5;
            	                EarlyExitException eee =
            	                    new EarlyExitException(5, input);
            	                throw eee;
            	        }
            	        cnt5++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            // AadlBa.g:2345:5: ( ( '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )? ) )
            // AadlBa.g:2346:7: ( '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )? )
            {
            // AadlBa.g:2346:7: ( '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )? )
            // AadlBa.g:2346:9: '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )?
            {
            match('.'); 

            // AadlBa.g:2346:13: ( DIGIT )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // AadlBa.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            // AadlBa.g:2346:21: ( '_' ( DIGIT )+ )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='_') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // AadlBa.g:2346:22: '_' ( DIGIT )+
            	    {
            	    match('_'); 

            	    // AadlBa.g:2346:26: ( DIGIT )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // AadlBa.g:
            	    	    {
            	    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	    	        input.consume();
            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;
            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt8 >= 1 ) break loop8;
            	                EarlyExitException eee =
            	                    new EarlyExitException(8, input);
            	                throw eee;
            	        }
            	        cnt8++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            // AadlBa.g:2346:37: ( EXPONENT )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='e') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // AadlBa.g:2346:39: EXPONENT
                    {
                    mEXPONENT(); 


                    }
                    break;

            }


            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REAL_LIT"

    // $ANTLR start "INTEGER_LIT"
    public final void mINTEGER_LIT() throws RecognitionException {
        try {
            int _type = INTEGER_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:2350:13: ( ( DIGIT )+ ( '_' ( DIGIT )+ )* ( ( '#' BASED_INTEGER '#' ( INT_EXPONENT )? ) | ( INT_EXPONENT )? ) )
            // AadlBa.g:2351:5: ( DIGIT )+ ( '_' ( DIGIT )+ )* ( ( '#' BASED_INTEGER '#' ( INT_EXPONENT )? ) | ( INT_EXPONENT )? )
            {
            // AadlBa.g:2351:5: ( DIGIT )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // AadlBa.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            // AadlBa.g:2351:13: ( '_' ( DIGIT )+ )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='_') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // AadlBa.g:2351:14: '_' ( DIGIT )+
            	    {
            	    match('_'); 

            	    // AadlBa.g:2351:18: ( DIGIT )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        int LA12_0 = input.LA(1);

            	        if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
            	            alt12=1;
            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // AadlBa.g:
            	    	    {
            	    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	    	        input.consume();
            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;
            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt12 >= 1 ) break loop12;
            	                EarlyExitException eee =
            	                    new EarlyExitException(12, input);
            	                throw eee;
            	        }
            	        cnt12++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            // AadlBa.g:2352:5: ( ( '#' BASED_INTEGER '#' ( INT_EXPONENT )? ) | ( INT_EXPONENT )? )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='#') ) {
                alt16=1;
            }
            else {
                alt16=2;
            }
            switch (alt16) {
                case 1 :
                    // AadlBa.g:2353:7: ( '#' BASED_INTEGER '#' ( INT_EXPONENT )? )
                    {
                    // AadlBa.g:2353:7: ( '#' BASED_INTEGER '#' ( INT_EXPONENT )? )
                    // AadlBa.g:2353:9: '#' BASED_INTEGER '#' ( INT_EXPONENT )?
                    {
                    match('#'); 

                    mBASED_INTEGER(); 


                    match('#'); 

                    // AadlBa.g:2353:32: ( INT_EXPONENT )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='e') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // AadlBa.g:2353:34: INT_EXPONENT
                            {
                            mINT_EXPONENT(); 


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // AadlBa.g:2354:9: ( INT_EXPONENT )?
                    {
                    // AadlBa.g:2354:9: ( INT_EXPONENT )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // AadlBa.g:2354:10: INT_EXPONENT
                            {
                            mINT_EXPONENT(); 


                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER_LIT"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // AadlBa.g:2360:7: ( ( '0' .. '9' ) )
            // AadlBa.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // AadlBa.g:2363:10: ( ( 'e' ) ( '+' | '-' )? ( DIGIT )+ )
            // AadlBa.g:2363:12: ( 'e' ) ( '+' | '-' )? ( DIGIT )+
            {
            // AadlBa.g:2363:12: ( 'e' )
            // AadlBa.g:2363:13: 'e'
            {
            match('e'); 

            }


            // AadlBa.g:2363:18: ( '+' | '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='+'||LA17_0=='-') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // AadlBa.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // AadlBa.g:2363:29: ( DIGIT )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= '0' && LA18_0 <= '9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // AadlBa.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "INT_EXPONENT"
    public final void mINT_EXPONENT() throws RecognitionException {
        try {
            // AadlBa.g:2366:14: ( ( 'e' ) ( '+' )? ( DIGIT )+ )
            // AadlBa.g:2366:16: ( 'e' ) ( '+' )? ( DIGIT )+
            {
            // AadlBa.g:2366:16: ( 'e' )
            // AadlBa.g:2366:17: 'e'
            {
            match('e'); 

            }


            // AadlBa.g:2366:22: ( '+' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='+') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // AadlBa.g:2366:23: '+'
                    {
                    match('+'); 

                    }
                    break;

            }


            // AadlBa.g:2366:29: ( DIGIT )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0 >= '0' && LA20_0 <= '9')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // AadlBa.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT_EXPONENT"

    // $ANTLR start "EXTENDED_DIGIT"
    public final void mEXTENDED_DIGIT() throws RecognitionException {
        try {
            // AadlBa.g:2369:16: ( ( DIGIT | 'a' .. 'f' ) )
            // AadlBa.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXTENDED_DIGIT"

    // $ANTLR start "BASED_INTEGER"
    public final void mBASED_INTEGER() throws RecognitionException {
        try {
            // AadlBa.g:2372:15: ( ( EXTENDED_DIGIT ) ( ( '_' )? EXTENDED_DIGIT )* )
            // AadlBa.g:2372:17: ( EXTENDED_DIGIT ) ( ( '_' )? EXTENDED_DIGIT )*
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // AadlBa.g:2372:36: ( ( '_' )? EXTENDED_DIGIT )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0 >= '0' && LA22_0 <= '9')||LA22_0=='_'||(LA22_0 >= 'a' && LA22_0 <= 'f')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // AadlBa.g:2372:38: ( '_' )? EXTENDED_DIGIT
            	    {
            	    // AadlBa.g:2372:38: ( '_' )?
            	    int alt21=2;
            	    int LA21_0 = input.LA(1);

            	    if ( (LA21_0=='_') ) {
            	        alt21=1;
            	    }
            	    switch (alt21) {
            	        case 1 :
            	            // AadlBa.g:2372:39: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }


            	    mEXTENDED_DIGIT(); 


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BASED_INTEGER"

    // $ANTLR start "BASE"
    public final void mBASE() throws RecognitionException {
        try {
            // AadlBa.g:2375:6: ( DIGIT ( DIGIT )? )
            // AadlBa.g:2375:8: DIGIT ( DIGIT )?
            {
            mDIGIT(); 


            // AadlBa.g:2375:14: ( DIGIT )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0 >= '0' && LA23_0 <= '9')) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // AadlBa.g:
                    {
                    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BASE"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // AadlBa.g:2379:11: ( ( '0' .. '9' | 'a' .. 'f' ) )
            // AadlBa.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:2382:4: ( ( ' ' | '\\r' '\\n' | '\\r' | '\\n' | '\\t' ) )
            // AadlBa.g:2382:6: ( ' ' | '\\r' '\\n' | '\\r' | '\\n' | '\\t' )
            {
            // AadlBa.g:2382:6: ( ' ' | '\\r' '\\n' | '\\r' | '\\n' | '\\t' )
            int alt24=5;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt24=1;
                }
                break;
            case '\r':
                {
                int LA24_2 = input.LA(2);

                if ( (LA24_2=='\n') ) {
                    alt24=2;
                }
                else {
                    alt24=3;
                }
                }
                break;
            case '\n':
                {
                alt24=4;
                }
                break;
            case '\t':
                {
                alt24=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // AadlBa.g:2382:8: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // AadlBa.g:2383:8: '\\r' '\\n'
                    {
                    match('\r'); 

                    match('\n'); 

                    }
                    break;
                case 3 :
                    // AadlBa.g:2384:8: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // AadlBa.g:2385:8: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 5 :
                    // AadlBa.g:2386:8: '\\t'
                    {
                    match('\t'); 

                    }
                    break;

            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // AadlBa.g:2393:3: ( '--' (~ ( '\\n' | '\\r' ) )* )
            // AadlBa.g:2393:5: '--' (~ ( '\\n' | '\\r' ) )*
            {
            match("--"); 



            // AadlBa.g:2394:2: (~ ( '\\n' | '\\r' ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0 >= '\u0000' && LA25_0 <= '\t')||(LA25_0 >= '\u000B' && LA25_0 <= '\f')||(LA25_0 >= '\u000E' && LA25_0 <= '\uFFFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // AadlBa.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            _channel=COMMENT_CHANNEL;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // AadlBa.g:2408:3: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( 'u' )+ HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT | '0' .. '3' ( '0' .. '7' ( '0' .. '7' )? )? | '4' .. '7' ( '0' .. '7' )? ) )
            // AadlBa.g:2408:5: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( 'u' )+ HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT | '0' .. '3' ( '0' .. '7' ( '0' .. '7' )? )? | '4' .. '7' ( '0' .. '7' )? )
            {
            match('\\'); 

            // AadlBa.g:2409:5: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( 'u' )+ HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT | '0' .. '3' ( '0' .. '7' ( '0' .. '7' )? )? | '4' .. '7' ( '0' .. '7' )? )
            int alt30=11;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt30=1;
                }
                break;
            case 'r':
                {
                alt30=2;
                }
                break;
            case 't':
                {
                alt30=3;
                }
                break;
            case 'b':
                {
                alt30=4;
                }
                break;
            case 'f':
                {
                alt30=5;
                }
                break;
            case '\"':
                {
                alt30=6;
                }
                break;
            case '\'':
                {
                alt30=7;
                }
                break;
            case '\\':
                {
                alt30=8;
                }
                break;
            case 'u':
                {
                alt30=9;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
                {
                alt30=10;
                }
                break;
            case '4':
            case '5':
            case '6':
            case '7':
                {
                alt30=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }

            switch (alt30) {
                case 1 :
                    // AadlBa.g:2409:7: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // AadlBa.g:2410:7: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // AadlBa.g:2411:7: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // AadlBa.g:2412:7: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // AadlBa.g:2413:7: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // AadlBa.g:2414:7: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // AadlBa.g:2415:7: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // AadlBa.g:2416:7: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // AadlBa.g:2417:7: ( 'u' )+ HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
                    {
                    // AadlBa.g:2417:7: ( 'u' )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0=='u') ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // AadlBa.g:2417:8: 'u'
                    	    {
                    	    match('u'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);


                    mHEX_DIGIT(); 


                    mHEX_DIGIT(); 


                    mHEX_DIGIT(); 


                    mHEX_DIGIT(); 


                    }
                    break;
                case 10 :
                    // AadlBa.g:2418:7: '0' .. '3' ( '0' .. '7' ( '0' .. '7' )? )?
                    {
                    matchRange('0','3'); 

                    // AadlBa.g:2419:7: ( '0' .. '7' ( '0' .. '7' )? )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( ((LA28_0 >= '0' && LA28_0 <= '7')) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // AadlBa.g:2423:9: '0' .. '7' ( '0' .. '7' )?
                            {
                            matchRange('0','7'); 

                            // AadlBa.g:2424:9: ( '0' .. '7' )?
                            int alt27=2;
                            int LA27_0 = input.LA(1);

                            if ( ((LA27_0 >= '0' && LA27_0 <= '7')) ) {
                                alt27=1;
                            }
                            switch (alt27) {
                                case 1 :
                                    // AadlBa.g:
                                    {
                                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                                        input.consume();
                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;
                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 11 :
                    // AadlBa.g:2431:7: '4' .. '7' ( '0' .. '7' )?
                    {
                    matchRange('4','7'); 

                    // AadlBa.g:2432:7: ( '0' .. '7' )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0 >= '0' && LA29_0 <= '7')) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // AadlBa.g:
                            {
                            if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC"

    public void mTokens() throws RecognitionException {
        // AadlBa.g:1:8: ( ABS | AND | ANY | COMPLETE | COMPUTATION | COUNT | DISPATCH | DO | ELSE | ELSIF | END | FALSE | FINAL | FOR | FORALL | FRESH | FROZEN | IF | IN | INITIAL | MOD | NOT | ON | OR | OTHERWISE | VARIABLES | REM | STATE | STATES | STOP | TIMEOUT | TRANSITIONS | TRUE | UNTIL | WHILE | XOR | LBRACK | RBRACK | COMMA | LTRANS | RTRANS | LPAREN | RPAREN | CONCAT | LCURLY | RCURLY | COLON | ASSIGN | EXCLAM | INTERROG | GGREATER | EXCLLESS | EXCLGREATER | DOT | TICK | EQUAL | NOTEQUAL | LESSTHAN | LESSOREQUAL | GREATERTHAN | GREATEROREQUAL | PLUS | MINUS | STAR | DIVIDE | STARSTAR | DOTDOT | SEMICOLON | DOUBLECOLON | HASH | ENUMERATOR | IDENT | STRING_LITERAL | REAL_LIT | INTEGER_LIT | WS | SL_COMMENT )
        int alt31=77;
        alt31 = dfa31.predict(input);
        switch (alt31) {
            case 1 :
                // AadlBa.g:1:10: ABS
                {
                mABS(); 


                }
                break;
            case 2 :
                // AadlBa.g:1:14: AND
                {
                mAND(); 


                }
                break;
            case 3 :
                // AadlBa.g:1:18: ANY
                {
                mANY(); 


                }
                break;
            case 4 :
                // AadlBa.g:1:22: COMPLETE
                {
                mCOMPLETE(); 


                }
                break;
            case 5 :
                // AadlBa.g:1:31: COMPUTATION
                {
                mCOMPUTATION(); 


                }
                break;
            case 6 :
                // AadlBa.g:1:43: COUNT
                {
                mCOUNT(); 


                }
                break;
            case 7 :
                // AadlBa.g:1:49: DISPATCH
                {
                mDISPATCH(); 


                }
                break;
            case 8 :
                // AadlBa.g:1:58: DO
                {
                mDO(); 


                }
                break;
            case 9 :
                // AadlBa.g:1:61: ELSE
                {
                mELSE(); 


                }
                break;
            case 10 :
                // AadlBa.g:1:66: ELSIF
                {
                mELSIF(); 


                }
                break;
            case 11 :
                // AadlBa.g:1:72: END
                {
                mEND(); 


                }
                break;
            case 12 :
                // AadlBa.g:1:76: FALSE
                {
                mFALSE(); 


                }
                break;
            case 13 :
                // AadlBa.g:1:82: FINAL
                {
                mFINAL(); 


                }
                break;
            case 14 :
                // AadlBa.g:1:88: FOR
                {
                mFOR(); 


                }
                break;
            case 15 :
                // AadlBa.g:1:92: FORALL
                {
                mFORALL(); 


                }
                break;
            case 16 :
                // AadlBa.g:1:99: FRESH
                {
                mFRESH(); 


                }
                break;
            case 17 :
                // AadlBa.g:1:105: FROZEN
                {
                mFROZEN(); 


                }
                break;
            case 18 :
                // AadlBa.g:1:112: IF
                {
                mIF(); 


                }
                break;
            case 19 :
                // AadlBa.g:1:115: IN
                {
                mIN(); 


                }
                break;
            case 20 :
                // AadlBa.g:1:118: INITIAL
                {
                mINITIAL(); 


                }
                break;
            case 21 :
                // AadlBa.g:1:126: MOD
                {
                mMOD(); 


                }
                break;
            case 22 :
                // AadlBa.g:1:130: NOT
                {
                mNOT(); 


                }
                break;
            case 23 :
                // AadlBa.g:1:134: ON
                {
                mON(); 


                }
                break;
            case 24 :
                // AadlBa.g:1:137: OR
                {
                mOR(); 


                }
                break;
            case 25 :
                // AadlBa.g:1:140: OTHERWISE
                {
                mOTHERWISE(); 


                }
                break;
            case 26 :
                // AadlBa.g:1:150: VARIABLES
                {
                mVARIABLES(); 


                }
                break;
            case 27 :
                // AadlBa.g:1:160: REM
                {
                mREM(); 


                }
                break;
            case 28 :
                // AadlBa.g:1:164: STATE
                {
                mSTATE(); 


                }
                break;
            case 29 :
                // AadlBa.g:1:170: STATES
                {
                mSTATES(); 


                }
                break;
            case 30 :
                // AadlBa.g:1:177: STOP
                {
                mSTOP(); 


                }
                break;
            case 31 :
                // AadlBa.g:1:182: TIMEOUT
                {
                mTIMEOUT(); 


                }
                break;
            case 32 :
                // AadlBa.g:1:190: TRANSITIONS
                {
                mTRANSITIONS(); 


                }
                break;
            case 33 :
                // AadlBa.g:1:202: TRUE
                {
                mTRUE(); 


                }
                break;
            case 34 :
                // AadlBa.g:1:207: UNTIL
                {
                mUNTIL(); 


                }
                break;
            case 35 :
                // AadlBa.g:1:213: WHILE
                {
                mWHILE(); 


                }
                break;
            case 36 :
                // AadlBa.g:1:219: XOR
                {
                mXOR(); 


                }
                break;
            case 37 :
                // AadlBa.g:1:223: LBRACK
                {
                mLBRACK(); 


                }
                break;
            case 38 :
                // AadlBa.g:1:230: RBRACK
                {
                mRBRACK(); 


                }
                break;
            case 39 :
                // AadlBa.g:1:237: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 40 :
                // AadlBa.g:1:243: LTRANS
                {
                mLTRANS(); 


                }
                break;
            case 41 :
                // AadlBa.g:1:250: RTRANS
                {
                mRTRANS(); 


                }
                break;
            case 42 :
                // AadlBa.g:1:257: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 43 :
                // AadlBa.g:1:264: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 44 :
                // AadlBa.g:1:271: CONCAT
                {
                mCONCAT(); 


                }
                break;
            case 45 :
                // AadlBa.g:1:278: LCURLY
                {
                mLCURLY(); 


                }
                break;
            case 46 :
                // AadlBa.g:1:285: RCURLY
                {
                mRCURLY(); 


                }
                break;
            case 47 :
                // AadlBa.g:1:292: COLON
                {
                mCOLON(); 


                }
                break;
            case 48 :
                // AadlBa.g:1:298: ASSIGN
                {
                mASSIGN(); 


                }
                break;
            case 49 :
                // AadlBa.g:1:305: EXCLAM
                {
                mEXCLAM(); 


                }
                break;
            case 50 :
                // AadlBa.g:1:312: INTERROG
                {
                mINTERROG(); 


                }
                break;
            case 51 :
                // AadlBa.g:1:321: GGREATER
                {
                mGGREATER(); 


                }
                break;
            case 52 :
                // AadlBa.g:1:330: EXCLLESS
                {
                mEXCLLESS(); 


                }
                break;
            case 53 :
                // AadlBa.g:1:339: EXCLGREATER
                {
                mEXCLGREATER(); 


                }
                break;
            case 54 :
                // AadlBa.g:1:351: DOT
                {
                mDOT(); 


                }
                break;
            case 55 :
                // AadlBa.g:1:355: TICK
                {
                mTICK(); 


                }
                break;
            case 56 :
                // AadlBa.g:1:360: EQUAL
                {
                mEQUAL(); 


                }
                break;
            case 57 :
                // AadlBa.g:1:366: NOTEQUAL
                {
                mNOTEQUAL(); 


                }
                break;
            case 58 :
                // AadlBa.g:1:375: LESSTHAN
                {
                mLESSTHAN(); 


                }
                break;
            case 59 :
                // AadlBa.g:1:384: LESSOREQUAL
                {
                mLESSOREQUAL(); 


                }
                break;
            case 60 :
                // AadlBa.g:1:396: GREATERTHAN
                {
                mGREATERTHAN(); 


                }
                break;
            case 61 :
                // AadlBa.g:1:408: GREATEROREQUAL
                {
                mGREATEROREQUAL(); 


                }
                break;
            case 62 :
                // AadlBa.g:1:423: PLUS
                {
                mPLUS(); 


                }
                break;
            case 63 :
                // AadlBa.g:1:428: MINUS
                {
                mMINUS(); 


                }
                break;
            case 64 :
                // AadlBa.g:1:434: STAR
                {
                mSTAR(); 


                }
                break;
            case 65 :
                // AadlBa.g:1:439: DIVIDE
                {
                mDIVIDE(); 


                }
                break;
            case 66 :
                // AadlBa.g:1:446: STARSTAR
                {
                mSTARSTAR(); 


                }
                break;
            case 67 :
                // AadlBa.g:1:455: DOTDOT
                {
                mDOTDOT(); 


                }
                break;
            case 68 :
                // AadlBa.g:1:462: SEMICOLON
                {
                mSEMICOLON(); 


                }
                break;
            case 69 :
                // AadlBa.g:1:472: DOUBLECOLON
                {
                mDOUBLECOLON(); 


                }
                break;
            case 70 :
                // AadlBa.g:1:484: HASH
                {
                mHASH(); 


                }
                break;
            case 71 :
                // AadlBa.g:1:489: ENUMERATOR
                {
                mENUMERATOR(); 


                }
                break;
            case 72 :
                // AadlBa.g:1:500: IDENT
                {
                mIDENT(); 


                }
                break;
            case 73 :
                // AadlBa.g:1:506: STRING_LITERAL
                {
                mSTRING_LITERAL(); 


                }
                break;
            case 74 :
                // AadlBa.g:1:521: REAL_LIT
                {
                mREAL_LIT(); 


                }
                break;
            case 75 :
                // AadlBa.g:1:530: INTEGER_LIT
                {
                mINTEGER_LIT(); 


                }
                break;
            case 76 :
                // AadlBa.g:1:542: WS
                {
                mWS(); 


                }
                break;
            case 77 :
                // AadlBa.g:1:545: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;

        }

    }


    protected DFA31 dfa31 = new DFA31(this);
    static final String DFA31_eotS =
        "\1\uffff\20\47\1\uffff\1\106\1\uffff\1\111\5\uffff\1\114\1\120\1"+
        "\uffff\1\123\1\125\2\uffff\1\127\1\uffff\1\131\5\uffff\1\134\1\uffff"+
        "\4\47\1\143\6\47\1\154\1\156\2\47\1\161\1\162\11\47\30\uffff\1\177"+
        "\1\u0080\1\u0081\3\47\1\uffff\1\47\1\u0087\3\47\1\u008c\2\47\1\uffff"+
        "\1\47\1\uffff\1\u0090\1\u0091\2\uffff\2\47\1\u0094\7\47\1\u009c"+
        "\1\134\3\uffff\3\47\1\u00a1\1\47\1\uffff\4\47\1\uffff\3\47\2\uffff"+
        "\2\47\1\uffff\1\47\1\u00ad\2\47\1\u00b0\2\47\1\uffff\2\47\1\u00b5"+
        "\1\47\1\uffff\1\u00b7\1\47\1\u00b9\1\u00ba\1\47\1\u00bc\4\47\1\u00c2"+
        "\1\uffff\2\47\1\uffff\1\u00c5\1\u00c6\2\47\1\uffff\1\47\1\uffff"+
        "\1\47\2\uffff\1\u00cb\1\uffff\1\u00cc\3\47\1\u00d0\1\uffff\2\47"+
        "\2\uffff\4\47\2\uffff\1\u00d7\2\47\1\uffff\1\u00da\1\47\1\u00dc"+
        "\1\47\1\u00de\1\47\1\uffff\2\47\1\uffff\1\47\1\uffff\1\47\1\uffff"+
        "\1\47\1\u00e5\1\u00e6\3\47\2\uffff\1\47\1\u00eb\1\u00ec\1\u00ed"+
        "\3\uffff";
    static final String DFA31_eofS =
        "\u00ee\uffff";
    static final String DFA31_minS =
        "\1\11\1\142\1\157\1\151\1\154\1\141\1\146\2\157\1\156\1\141\1\145"+
        "\1\164\1\151\1\156\1\150\1\157\1\uffff\1\55\1\uffff\1\55\5\uffff"+
        "\1\72\1\74\1\uffff\1\75\1\56\2\uffff\1\75\1\uffff\1\52\5\uffff\1"+
        "\56\1\uffff\1\163\1\144\1\155\1\163\1\60\1\163\1\144\1\154\1\156"+
        "\1\162\1\145\2\60\1\144\1\164\2\60\1\150\1\162\1\155\1\141\1\155"+
        "\1\141\1\164\1\151\1\162\25\uffff\1\60\2\uffff\3\60\1\160\1\156"+
        "\1\160\1\uffff\1\145\1\60\1\155\1\163\1\141\1\60\1\163\1\172\1\uffff"+
        "\1\164\1\uffff\2\60\2\uffff\1\145\1\151\1\60\1\164\1\160\1\145\1"+
        "\156\1\145\1\151\1\154\1\60\1\56\3\uffff\1\154\1\164\1\141\1\60"+
        "\1\146\1\uffff\2\145\2\154\1\uffff\1\150\1\145\1\151\2\uffff\1\162"+
        "\1\141\1\uffff\1\145\1\60\1\157\1\163\1\60\1\154\1\145\1\uffff\1"+
        "\145\1\164\1\60\1\164\1\uffff\1\60\1\162\2\60\1\154\1\60\1\156\1"+
        "\141\1\167\1\142\1\60\1\uffff\1\165\1\151\1\uffff\2\60\1\164\1\141"+
        "\1\uffff\1\143\1\uffff\1\141\2\uffff\1\60\1\uffff\1\60\1\154\1\151"+
        "\1\154\1\60\1\uffff\2\164\2\uffff\1\145\1\164\1\150\1\164\2\uffff"+
        "\1\60\1\163\1\145\1\uffff\1\60\1\151\1\60\1\151\1\60\1\157\1\uffff"+
        "\1\145\1\163\1\uffff\1\157\1\uffff\1\157\1\uffff\1\162\2\60\2\156"+
        "\1\163\2\uffff\1\163\3\60\3\uffff";
    static final String DFA31_maxS =
        "\1\175\1\156\2\157\1\156\1\162\1\156\2\157\1\164\1\141\1\145\1\164"+
        "\1\162\1\156\1\150\1\157\1\uffff\1\55\1\uffff\1\133\5\uffff\1\75"+
        "\1\76\1\uffff\1\76\1\56\2\uffff\1\75\1\uffff\1\52\5\uffff\1\137"+
        "\1\uffff\1\163\1\171\1\165\1\163\1\172\1\163\1\165\1\154\1\156\1"+
        "\162\1\157\2\172\1\144\1\164\2\172\1\150\1\162\1\155\1\157\1\155"+
        "\1\165\1\164\1\151\1\162\25\uffff\1\71\2\uffff\3\172\1\160\1\156"+
        "\1\160\1\uffff\1\151\1\172\1\155\1\163\1\141\1\172\1\163\1\172\1"+
        "\uffff\1\164\1\uffff\2\172\2\uffff\1\145\1\151\1\172\1\164\1\160"+
        "\1\145\1\156\1\145\1\151\1\154\1\172\1\137\3\uffff\1\165\1\164\1"+
        "\141\1\172\1\146\1\uffff\2\145\2\154\1\uffff\1\150\1\145\1\151\2"+
        "\uffff\1\162\1\141\1\uffff\1\145\1\172\1\157\1\163\1\172\1\154\1"+
        "\145\1\uffff\1\145\1\164\1\172\1\164\1\uffff\1\172\1\162\2\172\1"+
        "\154\1\172\1\156\1\141\1\167\1\142\1\172\1\uffff\1\165\1\151\1\uffff"+
        "\2\172\1\164\1\141\1\uffff\1\143\1\uffff\1\141\2\uffff\1\172\1\uffff"+
        "\1\172\1\154\1\151\1\154\1\172\1\uffff\2\164\2\uffff\1\145\1\164"+
        "\1\150\1\164\2\uffff\1\172\1\163\1\145\1\uffff\1\172\1\151\1\172"+
        "\1\151\1\172\1\157\1\uffff\1\145\1\163\1\uffff\1\157\1\uffff\1\157"+
        "\1\uffff\1\162\2\172\2\156\1\163\2\uffff\1\163\3\172\3\uffff";
    static final String DFA31_acceptS =
        "\21\uffff\1\45\1\uffff\1\47\1\uffff\1\52\1\53\1\54\1\55\1\56\2\uffff"+
        "\1\62\2\uffff\1\67\1\70\1\uffff\1\76\1\uffff\1\101\1\104\1\106\1"+
        "\110\1\111\1\uffff\1\114\32\uffff\1\51\1\46\1\50\1\115\1\77\1\60"+
        "\1\105\1\57\1\64\1\65\1\71\1\61\1\63\1\75\1\74\1\103\1\66\1\73\1"+
        "\72\1\102\1\100\1\uffff\1\112\1\113\6\uffff\1\10\10\uffff\1\22\1"+
        "\uffff\1\23\2\uffff\1\27\1\30\14\uffff\1\1\1\2\1\3\5\uffff\1\13"+
        "\4\uffff\1\16\3\uffff\1\25\1\26\2\uffff\1\33\7\uffff\1\44\4\uffff"+
        "\1\11\13\uffff\1\36\2\uffff\1\41\4\uffff\1\6\1\uffff\1\12\1\uffff"+
        "\1\14\1\15\1\uffff\1\20\5\uffff\1\34\2\uffff\1\42\1\43\4\uffff\1"+
        "\17\1\21\3\uffff\1\35\6\uffff\1\24\2\uffff\1\37\1\uffff\1\4\1\uffff"+
        "\1\7\6\uffff\1\31\1\32\4\uffff\1\5\1\107\1\40";
    static final String DFA31_specialS =
        "\u00ee\uffff}>";
    static final String[] DFA31_transitionS = {
            "\2\52\2\uffff\1\52\22\uffff\1\52\1\33\1\50\1\46\2\uffff\1\27"+
            "\1\37\1\25\1\26\1\43\1\42\1\23\1\24\1\36\1\44\12\51\1\32\1\45"+
            "\1\41\1\40\1\35\1\34\33\uffff\1\21\1\uffff\1\22\3\uffff\1\1"+
            "\1\47\1\2\1\3\1\4\1\5\2\47\1\6\3\47\1\7\1\10\1\11\2\47\1\13"+
            "\1\14\1\15\1\16\1\12\1\17\1\20\2\47\1\30\1\uffff\1\31",
            "\1\53\13\uffff\1\54",
            "\1\55",
            "\1\56\5\uffff\1\57",
            "\1\60\1\uffff\1\61",
            "\1\62\7\uffff\1\63\5\uffff\1\64\2\uffff\1\65",
            "\1\66\7\uffff\1\67",
            "\1\70",
            "\1\71",
            "\1\72\3\uffff\1\73\1\uffff\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100\10\uffff\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "",
            "\1\105",
            "",
            "\1\110\55\uffff\1\107",
            "",
            "",
            "",
            "",
            "",
            "\1\113\2\uffff\1\112",
            "\1\115\1\117\1\116",
            "",
            "\1\122\1\121",
            "\1\124",
            "",
            "",
            "\1\126",
            "",
            "\1\130",
            "",
            "",
            "",
            "",
            "",
            "\1\133\1\uffff\12\51\45\uffff\1\132",
            "",
            "\1\135",
            "\1\136\24\uffff\1\137",
            "\1\140\7\uffff\1\141",
            "\1\142",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\144",
            "\1\145\20\uffff\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152\11\uffff\1\153",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\12\47\45\uffff\1\47\1\uffff\10\47\1\155\21\47",
            "\1\157",
            "\1\160",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166\15\uffff\1\167",
            "\1\170",
            "\1\171\23\uffff\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\176",
            "",
            "",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "",
            "\1\u0085\3\uffff\1\u0086",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\12\47\45\uffff\1\47\1\uffff\1\u008b\31\47",
            "\1\u008d",
            "\1\u008e",
            "",
            "\1\u008f",
            "",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\1\u0092",
            "\1\u0093",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\133\1\uffff\12\176\45\uffff\1\132",
            "",
            "",
            "",
            "\1\u009d\10\uffff\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00a2",
            "",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "",
            "",
            "\1\u00aa",
            "\1\u00ab",
            "",
            "\1\u00ac",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00ae",
            "\1\u00af",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00b1",
            "\1\u00b2",
            "",
            "\1\u00b3",
            "\1\u00b4",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00b6",
            "",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00b8",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00bb",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\12\47\45\uffff\1\47\1\uffff\22\47\1\u00c1\7\47",
            "",
            "\1\u00c3",
            "\1\u00c4",
            "",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00c7",
            "\1\u00c8",
            "",
            "\1\u00c9",
            "",
            "\1\u00ca",
            "",
            "",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u00d1",
            "\1\u00d2",
            "",
            "",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "",
            "",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00db",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00dd",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00df",
            "",
            "\1\u00e0",
            "\1\u00e1",
            "",
            "\1\u00e2",
            "",
            "\1\u00e3",
            "",
            "\1\u00e4",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "",
            "",
            "\1\u00ea",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "\12\47\45\uffff\1\47\1\uffff\32\47",
            "",
            "",
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ABS | AND | ANY | COMPLETE | COMPUTATION | COUNT | DISPATCH | DO | ELSE | ELSIF | END | FALSE | FINAL | FOR | FORALL | FRESH | FROZEN | IF | IN | INITIAL | MOD | NOT | ON | OR | OTHERWISE | VARIABLES | REM | STATE | STATES | STOP | TIMEOUT | TRANSITIONS | TRUE | UNTIL | WHILE | XOR | LBRACK | RBRACK | COMMA | LTRANS | RTRANS | LPAREN | RPAREN | CONCAT | LCURLY | RCURLY | COLON | ASSIGN | EXCLAM | INTERROG | GGREATER | EXCLLESS | EXCLGREATER | DOT | TICK | EQUAL | NOTEQUAL | LESSTHAN | LESSOREQUAL | GREATERTHAN | GREATEROREQUAL | PLUS | MINUS | STAR | DIVIDE | STARSTAR | DOTDOT | SEMICOLON | DOUBLECOLON | HASH | ENUMERATOR | IDENT | STRING_LITERAL | REAL_LIT | INTEGER_LIT | WS | SL_COMMENT );";
        }
    }
 

}
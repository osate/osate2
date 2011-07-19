// $ANTLR 3.3 Nov 30, 2010 12:45:30 /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g 2011-06-17 15:16:20

	package org.osate.aadl2.parser;
	
	import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
	import org.eclipse.core.resources.IResource; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Aadl2Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int WITH=4;
    public static final int COMMA=5;
    public static final int SEMI=6;
    public static final int IDENT=7;
    public static final int RENAMES=8;
    public static final int PACKAGE=9;
    public static final int DOUBLECOLON=10;
    public static final int FEATURE=11;
    public static final int GROUP=12;
    public static final int ALL=13;
    public static final int PROPERTIES=14;
    public static final int END=15;
    public static final int PUBLIC=16;
    public static final int PRIVATE=17;
    public static final int EXTENDS=18;
    public static final int LPAREN=19;
    public static final int RPAREN=20;
    public static final int PROTOTYPES=21;
    public static final int MODES=22;
    public static final int ABSTRACT=23;
    public static final int IMPLEMENTATION=24;
    public static final int DOT=25;
    public static final int SUBCOMPONENTS=26;
    public static final int CALLS=27;
    public static final int CONNECTIONS=28;
    public static final int FLOWS=29;
    public static final int BUS=30;
    public static final int DATA=31;
    public static final int DEVICE=32;
    public static final int MEMORY=33;
    public static final int PROCESS=34;
    public static final int PROCESSOR=35;
    public static final int SUBPROGRAM=36;
    public static final int SYSTEM=37;
    public static final int THREAD=38;
    public static final int VIRTUAL=39;
    public static final int LCURLY=40;
    public static final int RCURLY=41;
    public static final int COLON=42;
    public static final int REFINED=43;
    public static final int TO=44;
    public static final int LBRACK=45;
    public static final int RBRACK=46;
    public static final int IN=47;
    public static final int OUT=48;
    public static final int NONE=49;
    public static final int INVERSE=50;
    public static final int OF=51;
    public static final int EVENT=52;
    public static final int PORT=53;
    public static final int REQUIRES=54;
    public static final int PROVIDES=55;
    public static final int ACCESS=56;
    public static final int ASSIGN=57;
    public static final int FEATURES=58;
    public static final int ANNEX=59;
    public static final int ANNEX_TEXT=60;
    public static final int PROPERTY=61;
    public static final int SET=62;
    public static final int IS=63;
    public static final int INHERIT=64;
    public static final int LIST=65;
    public static final int APPLIES=66;
    public static final int TYPE=67;
    public static final int RECORD=68;
    public static final int REFERENCE=69;
    public static final int BOOLEAN=70;
    public static final int STRING=71;
    public static final int ENUMERATION=72;
    public static final int UNITS=73;
    public static final int STAR=74;
    public static final int REAL=75;
    public static final int INTEGER=76;
    public static final int PLUS=77;
    public static final int MINUS=78;
    public static final int DOTDOT=79;
    public static final int REAL_LIT=80;
    public static final int INTEGER_LIT=81;
    public static final int RANGE=82;
    public static final int CLASSIFIER=83;
    public static final int AND=84;
    public static final int BINDING=85;
    public static final int CONSTANT=86;
    public static final int DELTA=87;
    public static final int FALSE=88;
    public static final int FLOW=89;
    public static final int INITIAL=90;
    public static final int MODE=91;
    public static final int NOT=92;
    public static final int OR=93;
    public static final int PARAMETER=94;
    public static final int PATH=95;
    public static final int PROTOTYPE=96;
    public static final int REFINES=97;
    public static final int SERVER=98;
    public static final int SINK=99;
    public static final int SOURCE=100;
    public static final int TRANSITIONS=101;
    public static final int TRUE=102;
    public static final int VALUE=103;
    public static final int COMPUTE=104;
    public static final int STARSTAR=105;
    public static final int STRING_LITERAL=106;
    public static final int ASSIGNPLUS=107;
    public static final int LTRANS=108;
    public static final int RTRANS=109;
    public static final int SELF=110;
    public static final int ARROW=111;
    public static final int BARROW=112;
    public static final int DARROW=113;
    public static final int DHARROW=114;
    public static final int HASH=115;
    public static final int LETTER=116;
    public static final int ESC=117;
    public static final int DIGIT=118;
    public static final int EXPONENT=119;
    public static final int BASED_INTEGER=120;
    public static final int INT_EXPONENT=121;
    public static final int EXTENDED_DIGIT=122;
    public static final int BASE=123;
    public static final int HEX_DIGIT=124;
    public static final int WS=125;
    public static final int SL_COMMENT=126;

    	
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
           			String expecting = (mte.expecting < Aadl2Parser.tokenNames.length && mte.expecting >=0) ? 
           					Aadl2Parser.tokenNames[mte.expecting] : "null";
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
    		  errReporter.error(filename, e.line, description);
    	}
    	
    	/**
    	 * Dummy method
    	 * see http://www.antlr.org:8080/pipermail/antlr-interest/2005-August/013323.html and replies
    	 */
    	 void recover (RecognitionException e, BitSet b) {
    	 }


    // delegates
    // delegators

    public Aadl2Lexer() {;} 
    public Aadl2Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Aadl2Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g"; }

    // $ANTLR start "ABSTRACT"
    public final void mABSTRACT() throws RecognitionException {
        try {
            int _type = ABSTRACT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15360:9: ( 'abstract' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15360:10: 'abstract'
            {
            match("abstract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ABSTRACT"

    // $ANTLR start "ACCESS"
    public final void mACCESS() throws RecognitionException {
        try {
            int _type = ACCESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15361:7: ( 'access' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15361:8: 'access'
            {
            match("access"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ACCESS"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15362:4: ( 'and' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15362:5: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "ALL"
    public final void mALL() throws RecognitionException {
        try {
            int _type = ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15363:4: ( 'all' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15363:5: 'all'
            {
            match("all"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALL"

    // $ANTLR start "ANNEX"
    public final void mANNEX() throws RecognitionException {
        try {
            int _type = ANNEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15364:6: ( 'annex' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15364:7: 'annex'
            {
            match("annex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANNEX"

    // $ANTLR start "APPLIES"
    public final void mAPPLIES() throws RecognitionException {
        try {
            int _type = APPLIES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15365:8: ( 'applies' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15365:9: 'applies'
            {
            match("applies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "APPLIES"

    // $ANTLR start "BINDING"
    public final void mBINDING() throws RecognitionException {
        try {
            int _type = BINDING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15366:8: ( 'binding' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15366:9: 'binding'
            {
            match("binding"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BINDING"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15367:8: ( 'aadlboolean' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15367:9: 'aadlboolean'
            {
            match("aadlboolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "BUS"
    public final void mBUS() throws RecognitionException {
        try {
            int _type = BUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15368:4: ( 'bus' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15368:5: 'bus'
            {
            match("bus"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BUS"

    // $ANTLR start "CALLS"
    public final void mCALLS() throws RecognitionException {
        try {
            int _type = CALLS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15369:6: ( 'calls' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15369:7: 'calls'
            {
            match("calls"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CALLS"

    // $ANTLR start "CLASSIFIER"
    public final void mCLASSIFIER() throws RecognitionException {
        try {
            int _type = CLASSIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15370:11: ( 'classifier' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15370:12: 'classifier'
            {
            match("classifier"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLASSIFIER"

    // $ANTLR start "REFERENCE"
    public final void mREFERENCE() throws RecognitionException {
        try {
            int _type = REFERENCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15371:10: ( 'reference' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15371:11: 'reference'
            {
            match("reference"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REFERENCE"

    // $ANTLR start "COMPUTE"
    public final void mCOMPUTE() throws RecognitionException {
        try {
            int _type = COMPUTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15372:8: ( 'compute' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15372:9: 'compute'
            {
            match("compute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMPUTE"

    // $ANTLR start "CONNECTIONS"
    public final void mCONNECTIONS() throws RecognitionException {
        try {
            int _type = CONNECTIONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15373:12: ( 'connections' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15373:13: 'connections'
            {
            match("connections"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONNECTIONS"

    // $ANTLR start "CONSTANT"
    public final void mCONSTANT() throws RecognitionException {
        try {
            int _type = CONSTANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15374:9: ( 'constant' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15374:10: 'constant'
            {
            match("constant"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONSTANT"

    // $ANTLR start "DATA"
    public final void mDATA() throws RecognitionException {
        try {
            int _type = DATA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15375:5: ( 'data' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15375:6: 'data'
            {
            match("data"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DATA"

    // $ANTLR start "DELTA"
    public final void mDELTA() throws RecognitionException {
        try {
            int _type = DELTA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15376:6: ( 'delta' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15376:7: 'delta'
            {
            match("delta"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DELTA"

    // $ANTLR start "DEVICE"
    public final void mDEVICE() throws RecognitionException {
        try {
            int _type = DEVICE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15377:7: ( 'device' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15377:8: 'device'
            {
            match("device"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEVICE"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15378:4: ( 'end' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15378:5: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "ENUMERATION"
    public final void mENUMERATION() throws RecognitionException {
        try {
            int _type = ENUMERATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15379:12: ( 'enumeration' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15379:13: 'enumeration'
            {
            match("enumeration"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENUMERATION"

    // $ANTLR start "EVENT"
    public final void mEVENT() throws RecognitionException {
        try {
            int _type = EVENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15380:6: ( 'event' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15380:7: 'event'
            {
            match("event"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EVENT"

    // $ANTLR start "EXTENDS"
    public final void mEXTENDS() throws RecognitionException {
        try {
            int _type = EXTENDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15381:8: ( 'extends' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15381:9: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXTENDS"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15382:6: ( 'false' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15382:7: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "FEATURE"
    public final void mFEATURE() throws RecognitionException {
        try {
            int _type = FEATURE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15383:8: ( 'feature' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15383:9: 'feature'
            {
            match("feature"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FEATURE"

    // $ANTLR start "FEATURES"
    public final void mFEATURES() throws RecognitionException {
        try {
            int _type = FEATURES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15384:9: ( 'features' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15384:10: 'features'
            {
            match("features"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FEATURES"

    // $ANTLR start "FLOW"
    public final void mFLOW() throws RecognitionException {
        try {
            int _type = FLOW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15385:5: ( 'flow' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15385:6: 'flow'
            {
            match("flow"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOW"

    // $ANTLR start "FLOWS"
    public final void mFLOWS() throws RecognitionException {
        try {
            int _type = FLOWS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15386:6: ( 'flows' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15386:7: 'flows'
            {
            match("flows"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOWS"

    // $ANTLR start "GROUP"
    public final void mGROUP() throws RecognitionException {
        try {
            int _type = GROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15387:6: ( 'group' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15387:7: 'group'
            {
            match("group"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GROUP"

    // $ANTLR start "IMPLEMENTATION"
    public final void mIMPLEMENTATION() throws RecognitionException {
        try {
            int _type = IMPLEMENTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15389:15: ( 'implementation' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15389:16: 'implementation'
            {
            match("implementation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMPLEMENTATION"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15390:3: ( 'in' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15390:4: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "INHERIT"
    public final void mINHERIT() throws RecognitionException {
        try {
            int _type = INHERIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15391:8: ( 'inherit' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15391:9: 'inherit'
            {
            match("inherit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INHERIT"

    // $ANTLR start "INITIAL"
    public final void mINITIAL() throws RecognitionException {
        try {
            int _type = INITIAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15392:8: ( 'initial' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15392:9: 'initial'
            {
            match("initial"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INITIAL"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15393:8: ( 'aadlinteger' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15393:9: 'aadlinteger'
            {
            match("aadlinteger"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "INVERSE"
    public final void mINVERSE() throws RecognitionException {
        try {
            int _type = INVERSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15394:8: ( 'inverse' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15394:9: 'inverse'
            {
            match("inverse"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INVERSE"

    // $ANTLR start "IS"
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15395:3: ( 'is' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15395:4: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IS"

    // $ANTLR start "LIST"
    public final void mLIST() throws RecognitionException {
        try {
            int _type = LIST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15396:5: ( 'list' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15396:6: 'list'
            {
            match("list"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIST"

    // $ANTLR start "MEMORY"
    public final void mMEMORY() throws RecognitionException {
        try {
            int _type = MEMORY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15397:7: ( 'memory' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15397:8: 'memory'
            {
            match("memory"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MEMORY"

    // $ANTLR start "MODE"
    public final void mMODE() throws RecognitionException {
        try {
            int _type = MODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15398:5: ( 'mode' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15398:6: 'mode'
            {
            match("mode"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MODE"

    // $ANTLR start "MODES"
    public final void mMODES() throws RecognitionException {
        try {
            int _type = MODES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15399:6: ( 'modes' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15399:7: 'modes'
            {
            match("modes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MODES"

    // $ANTLR start "NONE"
    public final void mNONE() throws RecognitionException {
        try {
            int _type = NONE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15400:6: ( 'none' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15400:8: 'none'
            {
            match("none"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NONE"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15401:4: ( 'not' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15401:5: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "OF"
    public final void mOF() throws RecognitionException {
        try {
            int _type = OF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15402:3: ( 'of' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15402:4: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OF"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15403:3: ( 'or' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15403:4: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "OUT"
    public final void mOUT() throws RecognitionException {
        try {
            int _type = OUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15404:4: ( 'out' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15404:5: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUT"

    // $ANTLR start "PACKAGE"
    public final void mPACKAGE() throws RecognitionException {
        try {
            int _type = PACKAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15405:8: ( 'package' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15405:9: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PACKAGE"

    // $ANTLR start "PARAMETER"
    public final void mPARAMETER() throws RecognitionException {
        try {
            int _type = PARAMETER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15406:10: ( 'parameter' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15406:11: 'parameter'
            {
            match("parameter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PARAMETER"

    // $ANTLR start "PATH"
    public final void mPATH() throws RecognitionException {
        try {
            int _type = PATH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15407:5: ( 'path' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15407:6: 'path'
            {
            match("path"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PATH"

    // $ANTLR start "PORT"
    public final void mPORT() throws RecognitionException {
        try {
            int _type = PORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15408:5: ( 'port' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15408:6: 'port'
            {
            match("port"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PORT"

    // $ANTLR start "PRIVATE"
    public final void mPRIVATE() throws RecognitionException {
        try {
            int _type = PRIVATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15409:8: ( 'private' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15409:9: 'private'
            {
            match("private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRIVATE"

    // $ANTLR start "PROCESS"
    public final void mPROCESS() throws RecognitionException {
        try {
            int _type = PROCESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15410:8: ( 'process' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15410:9: 'process'
            {
            match("process"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROCESS"

    // $ANTLR start "PROCESSOR"
    public final void mPROCESSOR() throws RecognitionException {
        try {
            int _type = PROCESSOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15411:10: ( 'processor' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15411:11: 'processor'
            {
            match("processor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROCESSOR"

    // $ANTLR start "PROPERTIES"
    public final void mPROPERTIES() throws RecognitionException {
        try {
            int _type = PROPERTIES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15412:11: ( 'properties' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15412:12: 'properties'
            {
            match("properties"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROPERTIES"

    // $ANTLR start "PROPERTY"
    public final void mPROPERTY() throws RecognitionException {
        try {
            int _type = PROPERTY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15413:9: ( 'property' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15413:10: 'property'
            {
            match("property"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROPERTY"

    // $ANTLR start "PROTOTYPE"
    public final void mPROTOTYPE() throws RecognitionException {
        try {
            int _type = PROTOTYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15414:10: ( 'prototype' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15414:11: 'prototype'
            {
            match("prototype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROTOTYPE"

    // $ANTLR start "PROTOTYPES"
    public final void mPROTOTYPES() throws RecognitionException {
        try {
            int _type = PROTOTYPES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15415:11: ( 'prototypes' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15415:12: 'prototypes'
            {
            match("prototypes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROTOTYPES"

    // $ANTLR start "PROVIDES"
    public final void mPROVIDES() throws RecognitionException {
        try {
            int _type = PROVIDES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15416:9: ( 'provides' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15416:10: 'provides'
            {
            match("provides"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROVIDES"

    // $ANTLR start "PUBLIC"
    public final void mPUBLIC() throws RecognitionException {
        try {
            int _type = PUBLIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15417:7: ( 'public' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15417:8: 'public'
            {
            match("public"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PUBLIC"

    // $ANTLR start "RANGE"
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15418:6: ( 'range' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15418:7: 'range'
            {
            match("range"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15419:5: ( 'aadlreal' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15419:6: 'aadlreal'
            {
            match("aadlreal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "RECORD"
    public final void mRECORD() throws RecognitionException {
        try {
            int _type = RECORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15420:7: ( 'record' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15420:9: 'record'
            {
            match("record"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RECORD"

    // $ANTLR start "REFINED"
    public final void mREFINED() throws RecognitionException {
        try {
            int _type = REFINED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15421:8: ( 'refined' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15421:9: 'refined'
            {
            match("refined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REFINED"

    // $ANTLR start "REFINES"
    public final void mREFINES() throws RecognitionException {
        try {
            int _type = REFINES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15422:8: ( 'refines' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15422:9: 'refines'
            {
            match("refines"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REFINES"

    // $ANTLR start "RENAMES"
    public final void mRENAMES() throws RecognitionException {
        try {
            int _type = RENAMES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15423:8: ( 'renames' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15423:9: 'renames'
            {
            match("renames"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RENAMES"

    // $ANTLR start "REQUIRES"
    public final void mREQUIRES() throws RecognitionException {
        try {
            int _type = REQUIRES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15424:10: ( 'requires' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15424:12: 'requires'
            {
            match("requires"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REQUIRES"

    // $ANTLR start "SELF"
    public final void mSELF() throws RecognitionException {
        try {
            int _type = SELF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15425:6: ( 'self' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15425:8: 'self'
            {
            match("self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SELF"

    // $ANTLR start "SERVER"
    public final void mSERVER() throws RecognitionException {
        try {
            int _type = SERVER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15426:7: ( 'server' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15426:8: 'server'
            {
            match("server"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SERVER"

    // $ANTLR start "SET"
    public final void mSET() throws RecognitionException {
        try {
            int _type = SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15427:5: ( 'set' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15427:7: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET"

    // $ANTLR start "SINK"
    public final void mSINK() throws RecognitionException {
        try {
            int _type = SINK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15428:5: ( 'sink' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15428:6: 'sink'
            {
            match("sink"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINK"

    // $ANTLR start "SOURCE"
    public final void mSOURCE() throws RecognitionException {
        try {
            int _type = SOURCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15429:7: ( 'source' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15429:8: 'source'
            {
            match("source"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SOURCE"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15430:7: ( 'aadlstring' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15430:8: 'aadlstring'
            {
            match("aadlstring"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "SUBCOMPONENTS"
    public final void mSUBCOMPONENTS() throws RecognitionException {
        try {
            int _type = SUBCOMPONENTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15431:14: ( 'subcomponents' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15431:15: 'subcomponents'
            {
            match("subcomponents"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBCOMPONENTS"

    // $ANTLR start "SUBPROGRAM"
    public final void mSUBPROGRAM() throws RecognitionException {
        try {
            int _type = SUBPROGRAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15432:11: ( 'subprogram' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15432:12: 'subprogram'
            {
            match("subprogram"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBPROGRAM"

    // $ANTLR start "SYSTEM"
    public final void mSYSTEM() throws RecognitionException {
        try {
            int _type = SYSTEM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15433:7: ( 'system' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15433:8: 'system'
            {
            match("system"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SYSTEM"

    // $ANTLR start "THREAD"
    public final void mTHREAD() throws RecognitionException {
        try {
            int _type = THREAD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15434:7: ( 'thread' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15434:8: 'thread'
            {
            match("thread"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THREAD"

    // $ANTLR start "TO"
    public final void mTO() throws RecognitionException {
        try {
            int _type = TO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15435:3: ( 'to' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15435:4: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TO"

    // $ANTLR start "TRANSITIONS"
    public final void mTRANSITIONS() throws RecognitionException {
        try {
            int _type = TRANSITIONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15436:12: ( 'transitions' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15436:13: 'transitions'
            {
            match("transitions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRANSITIONS"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15437:5: ( 'true' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15437:6: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15438:5: ( 'type' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15438:6: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "UNITS"
    public final void mUNITS() throws RecognitionException {
        try {
            int _type = UNITS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15439:6: ( 'units' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15439:7: 'units'
            {
            match("units"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNITS"

    // $ANTLR start "VALUE"
    public final void mVALUE() throws RecognitionException {
        try {
            int _type = VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15440:6: ( 'value' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15440:7: 'value'
            {
            match("value"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VALUE"

    // $ANTLR start "VIRTUAL"
    public final void mVIRTUAL() throws RecognitionException {
        try {
            int _type = VIRTUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15441:8: ( 'virtual' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15441:9: 'virtual'
            {
            match("virtual"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VIRTUAL"

    // $ANTLR start "WITH"
    public final void mWITH() throws RecognitionException {
        try {
            int _type = WITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15442:5: ( 'with' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15442:7: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WITH"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15445:7: ( '(' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15445:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15446:7: ( ')' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15446:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15447:7: ( '{' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15447:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15448:7: ( '}' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15448:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15449:6: ( ':' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15449:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15450:7: ( '+' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15450:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15451:7: ( '-' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15451:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15452:7: ( '*' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15452:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "STARSTAR"
    public final void mSTARSTAR() throws RecognitionException {
        try {
            int _type = STARSTAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15454:2: ( '**' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15454:4: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STARSTAR"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15455:7: ( ';' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15455:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15456:7: ( ',' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15456:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15457:7: ( '.' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15457:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "DOTDOT"
    public final void mDOTDOT() throws RecognitionException {
        try {
            int _type = DOTDOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15458:8: ( '..' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15458:10: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOTDOT"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15459:8: ( '=>' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15459:10: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "ASSIGNPLUS"
    public final void mASSIGNPLUS() throws RecognitionException {
        try {
            int _type = ASSIGNPLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15460:12: ( '+=>' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15460:14: '+=>'
            {
            match("+=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGNPLUS"

    // $ANTLR start "DOUBLECOLON"
    public final void mDOUBLECOLON() throws RecognitionException {
        try {
            int _type = DOUBLECOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15461:12: ( '::' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15461:14: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLECOLON"

    // $ANTLR start "LTRANS"
    public final void mLTRANS() throws RecognitionException {
        try {
            int _type = LTRANS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15462:8: ( '-[' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15462:10: '-['
            {
            match("-["); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LTRANS"

    // $ANTLR start "RTRANS"
    public final void mRTRANS() throws RecognitionException {
        try {
            int _type = RTRANS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15463:8: ( ']->' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15463:10: ']->'
            {
            match("]->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RTRANS"

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15464:8: ( '[' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15464:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15465:8: ( ']' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15465:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "ARROW"
    public final void mARROW() throws RecognitionException {
        try {
            int _type = ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15466:7: ( '->' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15466:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ARROW"

    // $ANTLR start "BARROW"
    public final void mBARROW() throws RecognitionException {
        try {
            int _type = BARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15467:7: ( '<->' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15467:9: '<->'
            {
            match("<->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BARROW"

    // $ANTLR start "DARROW"
    public final void mDARROW() throws RecognitionException {
        try {
            int _type = DARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15468:7: ( '->>' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15468:9: '->>'
            {
            match("->>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DARROW"

    // $ANTLR start "DHARROW"
    public final void mDHARROW() throws RecognitionException {
        try {
            int _type = DHARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15469:8: ( '>->' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15469:10: '>->'
            {
            match(">->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DHARROW"

    // $ANTLR start "HASH"
    public final void mHASH() throws RecognitionException {
        try {
            int _type = HASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15470:5: ( '#' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15470:7: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HASH"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15472:6: ( LETTER ( ( '_' )? ( LETTER | '0' .. '9' ) )* )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15472:8: LETTER ( ( '_' )? ( LETTER | '0' .. '9' ) )*
            {
            mLETTER(); 
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15473:6: ( ( '_' )? ( LETTER | '0' .. '9' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15474:7: ( '_' )? ( LETTER | '0' .. '9' )
            	    {
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15474:7: ( '_' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0=='_') ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15474:8: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15475:7: ( LETTER | '0' .. '9' )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( ((LA2_0>='a' && LA2_0<='z')) ) {
            	        alt2=1;
            	    }
            	    else if ( ((LA2_0>='0' && LA2_0<='9')) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15475:8: LETTER
            	            {
            	            mLETTER(); 

            	            }
            	            break;
            	        case 2 :
            	            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15475:15: '0' .. '9'
            	            {
            	            matchRange('0','9'); 

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15488:8: ( ( 'a' .. 'z' ) )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15488:9: ( 'a' .. 'z' )
            {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15488:9: ( 'a' .. 'z' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15488:10: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15491:15: ( '\"' ( '\"\"' | ESC | ~ ( '\"' | '\\\\' ) )* '\"' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15493:2: '\"' ( '\"\"' | ESC | ~ ( '\"' | '\\\\' ) )* '\"'
            {
            match('\"'); 
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15493:6: ( '\"\"' | ESC | ~ ( '\"' | '\\\\' ) )*
            loop4:
            do {
                int alt4=4;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\"') ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1=='\"') ) {
                        alt4=1;
                    }


                }
                else if ( (LA4_0=='\\') ) {
                    alt4=2;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                    alt4=3;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15493:7: '\"\"'
            	    {
            	    match("\"\""); 


            	    }
            	    break;
            	case 2 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15493:13: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 3 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15493:17: ~ ( '\"' | '\\\\' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "REAL_LIT"
    public final void mREAL_LIT() throws RecognitionException {
        try {
            int _type = REAL_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15496:10: ( ( DIGIT )+ ( '_' ( DIGIT )+ )* ( ( '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )? ) ) )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15496:13: ( DIGIT )+ ( '_' ( DIGIT )+ )* ( ( '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )? ) )
            {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15496:13: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15496:14: DIGIT
            	    {
            	    mDIGIT(); 

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

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15496:21: ( '_' ( DIGIT )+ )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='_') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15496:22: '_' ( DIGIT )+
            	    {
            	    match('_'); 
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15496:26: ( DIGIT )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15496:27: DIGIT
            	    	    {
            	    	    mDIGIT(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt6 >= 1 ) break loop6;
            	                EarlyExitException eee =
            	                    new EarlyExitException(6, input);
            	                throw eee;
            	        }
            	        cnt6++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15497:3: ( ( '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )? ) )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15500:4: ( '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )? )
            {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15500:4: ( '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )? )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15500:6: '.' ( DIGIT )+ ( '_' ( DIGIT )+ )* ( EXPONENT )?
            {
            match('.'); 
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15500:10: ( DIGIT )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15500:11: DIGIT
            	    {
            	    mDIGIT(); 

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

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15500:18: ( '_' ( DIGIT )+ )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='_') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15500:19: '_' ( DIGIT )+
            	    {
            	    match('_'); 
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15500:23: ( DIGIT )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15500:24: DIGIT
            	    	    {
            	    	    mDIGIT(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15500:34: ( EXPONENT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='e') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15500:36: EXPONENT
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
        }
    }
    // $ANTLR end "REAL_LIT"

    // $ANTLR start "INTEGER_LIT"
    public final void mINTEGER_LIT() throws RecognitionException {
        try {
            int _type = INTEGER_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15504:13: ( ( DIGIT )+ ( '_' ( DIGIT )+ )* ( ( '#' BASED_INTEGER '#' ( INT_EXPONENT )? ) | ( INT_EXPONENT )? ) )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15505:3: ( DIGIT )+ ( '_' ( DIGIT )+ )* ( ( '#' BASED_INTEGER '#' ( INT_EXPONENT )? ) | ( INT_EXPONENT )? )
            {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15505:3: ( DIGIT )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15505:4: DIGIT
            	    {
            	    mDIGIT(); 

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

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15505:11: ( '_' ( DIGIT )+ )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='_') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15505:12: '_' ( DIGIT )+
            	    {
            	    match('_'); 
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15505:16: ( DIGIT )+
            	    int cnt13=0;
            	    loop13:
            	    do {
            	        int alt13=2;
            	        int LA13_0 = input.LA(1);

            	        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
            	            alt13=1;
            	        }


            	        switch (alt13) {
            	    	case 1 :
            	    	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15505:17: DIGIT
            	    	    {
            	    	    mDIGIT(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt13 >= 1 ) break loop13;
            	                EarlyExitException eee =
            	                    new EarlyExitException(13, input);
            	                throw eee;
            	        }
            	        cnt13++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15506:3: ( ( '#' BASED_INTEGER '#' ( INT_EXPONENT )? ) | ( INT_EXPONENT )? )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='#') ) {
                alt17=1;
            }
            else {
                alt17=2;}
            switch (alt17) {
                case 1 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15507:4: ( '#' BASED_INTEGER '#' ( INT_EXPONENT )? )
                    {
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15507:4: ( '#' BASED_INTEGER '#' ( INT_EXPONENT )? )
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15507:6: '#' BASED_INTEGER '#' ( INT_EXPONENT )?
                    {
                    match('#'); 
                    mBASED_INTEGER(); 
                    match('#'); 
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15507:29: ( INT_EXPONENT )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15507:31: INT_EXPONENT
                            {
                            mINT_EXPONENT(); 

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15508:6: ( INT_EXPONENT )?
                    {
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15508:6: ( INT_EXPONENT )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='e') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15508:7: INT_EXPONENT
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
        }
    }
    // $ANTLR end "INTEGER_LIT"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15539:9: ( ( '0' .. '9' ) )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15539:12: ( '0' .. '9' )
            {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15539:12: ( '0' .. '9' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15539:14: '0' .. '9'
            {
            matchRange('0','9'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15542:20: ( ( 'e' ) ( '+' | '-' )? ( DIGIT )+ )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15542:23: ( 'e' ) ( '+' | '-' )? ( DIGIT )+
            {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15542:23: ( 'e' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15542:24: 'e'
            {
            match('e'); 

            }

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15542:29: ( '+' | '-' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='+'||LA18_0=='-') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15542:40: ( DIGIT )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='0' && LA19_0<='9')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15542:42: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "INT_EXPONENT"
    public final void mINT_EXPONENT() throws RecognitionException {
        try {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15545:24: ( ( 'e' ) ( '+' )? ( DIGIT )+ )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15545:27: ( 'e' ) ( '+' )? ( DIGIT )+
            {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15545:27: ( 'e' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15545:28: 'e'
            {
            match('e'); 

            }

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15545:33: ( '+' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='+') ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15545:34: '+'
                    {
                    match('+'); 

                    }
                    break;

            }

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15545:40: ( DIGIT )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='0' && LA21_0<='9')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15545:42: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "INT_EXPONENT"

    // $ANTLR start "EXTENDED_DIGIT"
    public final void mEXTENDED_DIGIT() throws RecognitionException {
        try {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15556:20: ( ( DIGIT | 'a' .. 'f' ) )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15556:23: ( DIGIT | 'a' .. 'f' )
            {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15556:23: ( DIGIT | 'a' .. 'f' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>='0' && LA22_0<='9')) ) {
                alt22=1;
            }
            else if ( ((LA22_0>='a' && LA22_0<='f')) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15556:25: DIGIT
                    {
                    mDIGIT(); 

                    }
                    break;
                case 2 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15556:33: 'a' .. 'f'
                    {
                    matchRange('a','f'); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXTENDED_DIGIT"

    // $ANTLR start "BASED_INTEGER"
    public final void mBASED_INTEGER() throws RecognitionException {
        try {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15559:20: ( ( EXTENDED_DIGIT ) ( ( '_' )? EXTENDED_DIGIT )* )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15559:23: ( EXTENDED_DIGIT ) ( ( '_' )? EXTENDED_DIGIT )*
            {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15559:23: ( EXTENDED_DIGIT )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15559:25: EXTENDED_DIGIT
            {
            mEXTENDED_DIGIT(); 

            }

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15559:42: ( ( '_' )? EXTENDED_DIGIT )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='0' && LA24_0<='9')||LA24_0=='_'||(LA24_0>='a' && LA24_0<='f')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15559:44: ( '_' )? EXTENDED_DIGIT
            	    {
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15559:44: ( '_' )?
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0=='_') ) {
            	        alt23=1;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15559:45: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    mEXTENDED_DIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "BASED_INTEGER"

    // $ANTLR start "BASE"
    public final void mBASE() throws RecognitionException {
        try {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15562:9: ( DIGIT ( DIGIT )? )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15562:11: DIGIT ( DIGIT )?
            {
            mDIGIT(); 
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15562:17: ( DIGIT )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>='0' && LA25_0<='9')) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15562:19: DIGIT
                    {
                    mDIGIT(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "BASE"

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15575:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( 'u' )+ HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT | '0' .. '3' ( '0' .. '7' ( '0' .. '7' )? )? | '4' .. '7' ( '0' .. '7' )? ) )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15575:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( 'u' )+ HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT | '0' .. '3' ( '0' .. '7' ( '0' .. '7' )? )? | '4' .. '7' ( '0' .. '7' )? )
            {
            match('\\'); 
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15576:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( 'u' )+ HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT | '0' .. '3' ( '0' .. '7' ( '0' .. '7' )? )? | '4' .. '7' ( '0' .. '7' )? )
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
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15576:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15577:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15578:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15579:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15580:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15581:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15582:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15583:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15584:5: ( 'u' )+ HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
                    {
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15584:5: ( 'u' )+
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
                    	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15584:6: 'u'
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
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15585:5: '0' .. '3' ( '0' .. '7' ( '0' .. '7' )? )?
                    {
                    matchRange('0','3'); 
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15586:4: ( '0' .. '7' ( '0' .. '7' )? )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( ((LA28_0>='0' && LA28_0<='7')) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15590:5: '0' .. '7' ( '0' .. '7' )?
                            {
                            matchRange('0','7'); 
                            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15591:5: ( '0' .. '7' )?
                            int alt27=2;
                            int LA27_0 = input.LA(1);

                            if ( ((LA27_0>='0' && LA27_0<='7')) ) {
                                alt27=1;
                            }
                            switch (alt27) {
                                case 1 :
                                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15595:6: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 11 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15598:5: '4' .. '7' ( '0' .. '7' )?
                    {
                    matchRange('4','7'); 
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15599:4: ( '0' .. '7' )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>='0' && LA29_0<='7')) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15603:5: '0' .. '7'
                            {
                            matchRange('0','7'); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "ESC"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15612:2: ( ( '0' .. '9' | 'a' .. 'f' ) )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15612:4: ( '0' .. '9' | 'a' .. 'f' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15617:7: ( ( ' ' | '\\r' '\\n' | '\\r' | '\\n' | '\\t' ) )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15617:9: ( ' ' | '\\r' '\\n' | '\\r' | '\\n' | '\\t' )
            {
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15617:9: ( ' ' | '\\r' '\\n' | '\\r' | '\\n' | '\\t' )
            int alt31=5;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt31=1;
                }
                break;
            case '\r':
                {
                int LA31_2 = input.LA(2);

                if ( (LA31_2=='\n') ) {
                    alt31=2;
                }
                else {
                    alt31=3;}
                }
                break;
            case '\n':
                {
                alt31=4;
                }
                break;
            case '\t':
                {
                alt31=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15617:11: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15618:11: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 3 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15619:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15620:11: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 5 :
                    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15621:11: '\\t'
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
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "ANNEX_TEXT"
    public final void mANNEX_TEXT() throws RecognitionException {
        try {
            int _type = ANNEX_TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15654:2: ( '{**' ({...}? => '*' | '\\r' | '\\n' | (~ ( '*' | '\\n' | '\\r' ) ) )* '**}' )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15655:2: '{**' ({...}? => '*' | '\\r' | '\\n' | (~ ( '*' | '\\n' | '\\r' ) ) )* '**}'
            {
            match("{**"); 

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15656:3: ({...}? => '*' | '\\r' | '\\n' | (~ ( '*' | '\\n' | '\\r' ) ) )*
            loop32:
            do {
                int alt32=5;
                int LA32_0 = input.LA(1);

                if ( (LA32_0=='*') ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1=='*') ) {
                        int LA32_5 = input.LA(3);

                        if ( (LA32_5=='}') ) {
                            int LA32_7 = input.LA(4);

                            if ( ((LA32_7>='\u0000' && LA32_7<='\uFFFF')) && (( input.LA(2)!='*' || input.LA(3) != '}' ))) {
                                alt32=1;
                            }


                        }
                        else if ( ((LA32_5>='\u0000' && LA32_5<='|')||(LA32_5>='~' && LA32_5<='\uFFFF')) && (( input.LA(2)!='*' || input.LA(3) != '}' ))) {
                            alt32=1;
                        }


                    }
                    else if ( ((LA32_1>='\u0000' && LA32_1<=')')||(LA32_1>='+' && LA32_1<='\uFFFF')) && (( input.LA(2)!='*' || input.LA(3) != '}' ))) {
                        alt32=1;
                    }


                }
                else if ( (LA32_0=='\r') ) {
                    alt32=2;
                }
                else if ( (LA32_0=='\n') ) {
                    alt32=3;
                }
                else if ( ((LA32_0>='\u0000' && LA32_0<='\t')||(LA32_0>='\u000B' && LA32_0<='\f')||(LA32_0>='\u000E' && LA32_0<=')')||(LA32_0>='+' && LA32_0<='\uFFFF')) ) {
                    alt32=4;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15667:4: {...}? => '*'
            	    {
            	    if ( !(( input.LA(2)!='*' || input.LA(3) != '}' )) ) {
            	        throw new FailedPredicateException(input, "ANNEX_TEXT", " input.LA(2)!='*' || input.LA(3) != '}' ");
            	    }
            	    match('*'); 

            	    }
            	    break;
            	case 2 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15668:5: '\\r'
            	    {
            	    match('\r'); 

            	    }
            	    break;
            	case 3 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15669:5: '\\n'
            	    {
            	    match('\n'); 

            	    }
            	    break;
            	case 4 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15670:5: (~ ( '*' | '\\n' | '\\r' ) )
            	    {
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15670:5: (~ ( '*' | '\\n' | '\\r' ) )
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15670:6: ~ ( '*' | '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<=')')||(input.LA(1)>='+' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            match("**}"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANNEX_TEXT"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15677:2: ( '--' (~ ( '\\n' | '\\r' ) )* )
            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15677:4: '--' (~ ( '\\n' | '\\r' ) )*
            {
            match("--"); 

            // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15678:1: (~ ( '\\n' | '\\r' ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>='\u0000' && LA33_0<='\t')||(LA33_0>='\u000B' && LA33_0<='\f')||(LA33_0>='\u000E' && LA33_0<='\uFFFF')) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:15678:2: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            _channel=COMMENT_CHANNEL;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SL_COMMENT"

    public void mTokens() throws RecognitionException {
        // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:8: ( ABSTRACT | ACCESS | AND | ALL | ANNEX | APPLIES | BINDING | BOOLEAN | BUS | CALLS | CLASSIFIER | REFERENCE | COMPUTE | CONNECTIONS | CONSTANT | DATA | DELTA | DEVICE | END | ENUMERATION | EVENT | EXTENDS | FALSE | FEATURE | FEATURES | FLOW | FLOWS | GROUP | IMPLEMENTATION | IN | INHERIT | INITIAL | INTEGER | INVERSE | IS | LIST | MEMORY | MODE | MODES | NONE | NOT | OF | OR | OUT | PACKAGE | PARAMETER | PATH | PORT | PRIVATE | PROCESS | PROCESSOR | PROPERTIES | PROPERTY | PROTOTYPE | PROTOTYPES | PROVIDES | PUBLIC | RANGE | REAL | RECORD | REFINED | REFINES | RENAMES | REQUIRES | SELF | SERVER | SET | SINK | SOURCE | STRING | SUBCOMPONENTS | SUBPROGRAM | SYSTEM | THREAD | TO | TRANSITIONS | TRUE | TYPE | UNITS | VALUE | VIRTUAL | WITH | LPAREN | RPAREN | LCURLY | RCURLY | COLON | PLUS | MINUS | STAR | STARSTAR | SEMI | COMMA | DOT | DOTDOT | ASSIGN | ASSIGNPLUS | DOUBLECOLON | LTRANS | RTRANS | LBRACK | RBRACK | ARROW | BARROW | DARROW | DHARROW | HASH | IDENT | STRING_LITERAL | REAL_LIT | INTEGER_LIT | WS | ANNEX_TEXT | SL_COMMENT )
        int alt34=114;
        alt34 = dfa34.predict(input);
        switch (alt34) {
            case 1 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:10: ABSTRACT
                {
                mABSTRACT(); 

                }
                break;
            case 2 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:19: ACCESS
                {
                mACCESS(); 

                }
                break;
            case 3 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:26: AND
                {
                mAND(); 

                }
                break;
            case 4 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:30: ALL
                {
                mALL(); 

                }
                break;
            case 5 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:34: ANNEX
                {
                mANNEX(); 

                }
                break;
            case 6 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:40: APPLIES
                {
                mAPPLIES(); 

                }
                break;
            case 7 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:48: BINDING
                {
                mBINDING(); 

                }
                break;
            case 8 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:56: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 9 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:64: BUS
                {
                mBUS(); 

                }
                break;
            case 10 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:68: CALLS
                {
                mCALLS(); 

                }
                break;
            case 11 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:74: CLASSIFIER
                {
                mCLASSIFIER(); 

                }
                break;
            case 12 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:85: REFERENCE
                {
                mREFERENCE(); 

                }
                break;
            case 13 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:95: COMPUTE
                {
                mCOMPUTE(); 

                }
                break;
            case 14 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:103: CONNECTIONS
                {
                mCONNECTIONS(); 

                }
                break;
            case 15 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:115: CONSTANT
                {
                mCONSTANT(); 

                }
                break;
            case 16 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:124: DATA
                {
                mDATA(); 

                }
                break;
            case 17 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:129: DELTA
                {
                mDELTA(); 

                }
                break;
            case 18 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:135: DEVICE
                {
                mDEVICE(); 

                }
                break;
            case 19 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:142: END
                {
                mEND(); 

                }
                break;
            case 20 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:146: ENUMERATION
                {
                mENUMERATION(); 

                }
                break;
            case 21 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:158: EVENT
                {
                mEVENT(); 

                }
                break;
            case 22 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:164: EXTENDS
                {
                mEXTENDS(); 

                }
                break;
            case 23 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:172: FALSE
                {
                mFALSE(); 

                }
                break;
            case 24 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:178: FEATURE
                {
                mFEATURE(); 

                }
                break;
            case 25 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:186: FEATURES
                {
                mFEATURES(); 

                }
                break;
            case 26 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:195: FLOW
                {
                mFLOW(); 

                }
                break;
            case 27 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:200: FLOWS
                {
                mFLOWS(); 

                }
                break;
            case 28 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:206: GROUP
                {
                mGROUP(); 

                }
                break;
            case 29 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:212: IMPLEMENTATION
                {
                mIMPLEMENTATION(); 

                }
                break;
            case 30 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:227: IN
                {
                mIN(); 

                }
                break;
            case 31 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:230: INHERIT
                {
                mINHERIT(); 

                }
                break;
            case 32 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:238: INITIAL
                {
                mINITIAL(); 

                }
                break;
            case 33 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:246: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 34 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:254: INVERSE
                {
                mINVERSE(); 

                }
                break;
            case 35 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:262: IS
                {
                mIS(); 

                }
                break;
            case 36 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:265: LIST
                {
                mLIST(); 

                }
                break;
            case 37 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:270: MEMORY
                {
                mMEMORY(); 

                }
                break;
            case 38 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:277: MODE
                {
                mMODE(); 

                }
                break;
            case 39 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:282: MODES
                {
                mMODES(); 

                }
                break;
            case 40 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:288: NONE
                {
                mNONE(); 

                }
                break;
            case 41 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:293: NOT
                {
                mNOT(); 

                }
                break;
            case 42 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:297: OF
                {
                mOF(); 

                }
                break;
            case 43 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:300: OR
                {
                mOR(); 

                }
                break;
            case 44 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:303: OUT
                {
                mOUT(); 

                }
                break;
            case 45 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:307: PACKAGE
                {
                mPACKAGE(); 

                }
                break;
            case 46 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:315: PARAMETER
                {
                mPARAMETER(); 

                }
                break;
            case 47 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:325: PATH
                {
                mPATH(); 

                }
                break;
            case 48 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:330: PORT
                {
                mPORT(); 

                }
                break;
            case 49 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:335: PRIVATE
                {
                mPRIVATE(); 

                }
                break;
            case 50 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:343: PROCESS
                {
                mPROCESS(); 

                }
                break;
            case 51 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:351: PROCESSOR
                {
                mPROCESSOR(); 

                }
                break;
            case 52 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:361: PROPERTIES
                {
                mPROPERTIES(); 

                }
                break;
            case 53 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:372: PROPERTY
                {
                mPROPERTY(); 

                }
                break;
            case 54 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:381: PROTOTYPE
                {
                mPROTOTYPE(); 

                }
                break;
            case 55 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:391: PROTOTYPES
                {
                mPROTOTYPES(); 

                }
                break;
            case 56 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:402: PROVIDES
                {
                mPROVIDES(); 

                }
                break;
            case 57 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:411: PUBLIC
                {
                mPUBLIC(); 

                }
                break;
            case 58 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:418: RANGE
                {
                mRANGE(); 

                }
                break;
            case 59 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:424: REAL
                {
                mREAL(); 

                }
                break;
            case 60 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:429: RECORD
                {
                mRECORD(); 

                }
                break;
            case 61 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:436: REFINED
                {
                mREFINED(); 

                }
                break;
            case 62 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:444: REFINES
                {
                mREFINES(); 

                }
                break;
            case 63 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:452: RENAMES
                {
                mRENAMES(); 

                }
                break;
            case 64 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:460: REQUIRES
                {
                mREQUIRES(); 

                }
                break;
            case 65 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:469: SELF
                {
                mSELF(); 

                }
                break;
            case 66 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:474: SERVER
                {
                mSERVER(); 

                }
                break;
            case 67 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:481: SET
                {
                mSET(); 

                }
                break;
            case 68 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:485: SINK
                {
                mSINK(); 

                }
                break;
            case 69 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:490: SOURCE
                {
                mSOURCE(); 

                }
                break;
            case 70 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:497: STRING
                {
                mSTRING(); 

                }
                break;
            case 71 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:504: SUBCOMPONENTS
                {
                mSUBCOMPONENTS(); 

                }
                break;
            case 72 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:518: SUBPROGRAM
                {
                mSUBPROGRAM(); 

                }
                break;
            case 73 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:529: SYSTEM
                {
                mSYSTEM(); 

                }
                break;
            case 74 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:536: THREAD
                {
                mTHREAD(); 

                }
                break;
            case 75 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:543: TO
                {
                mTO(); 

                }
                break;
            case 76 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:546: TRANSITIONS
                {
                mTRANSITIONS(); 

                }
                break;
            case 77 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:558: TRUE
                {
                mTRUE(); 

                }
                break;
            case 78 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:563: TYPE
                {
                mTYPE(); 

                }
                break;
            case 79 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:568: UNITS
                {
                mUNITS(); 

                }
                break;
            case 80 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:574: VALUE
                {
                mVALUE(); 

                }
                break;
            case 81 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:580: VIRTUAL
                {
                mVIRTUAL(); 

                }
                break;
            case 82 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:588: WITH
                {
                mWITH(); 

                }
                break;
            case 83 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:593: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 84 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:600: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 85 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:607: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 86 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:614: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 87 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:621: COLON
                {
                mCOLON(); 

                }
                break;
            case 88 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:627: PLUS
                {
                mPLUS(); 

                }
                break;
            case 89 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:632: MINUS
                {
                mMINUS(); 

                }
                break;
            case 90 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:638: STAR
                {
                mSTAR(); 

                }
                break;
            case 91 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:643: STARSTAR
                {
                mSTARSTAR(); 

                }
                break;
            case 92 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:652: SEMI
                {
                mSEMI(); 

                }
                break;
            case 93 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:657: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 94 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:663: DOT
                {
                mDOT(); 

                }
                break;
            case 95 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:667: DOTDOT
                {
                mDOTDOT(); 

                }
                break;
            case 96 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:674: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 97 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:681: ASSIGNPLUS
                {
                mASSIGNPLUS(); 

                }
                break;
            case 98 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:692: DOUBLECOLON
                {
                mDOUBLECOLON(); 

                }
                break;
            case 99 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:704: LTRANS
                {
                mLTRANS(); 

                }
                break;
            case 100 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:711: RTRANS
                {
                mRTRANS(); 

                }
                break;
            case 101 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:718: LBRACK
                {
                mLBRACK(); 

                }
                break;
            case 102 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:725: RBRACK
                {
                mRBRACK(); 

                }
                break;
            case 103 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:732: ARROW
                {
                mARROW(); 

                }
                break;
            case 104 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:738: BARROW
                {
                mBARROW(); 

                }
                break;
            case 105 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:745: DARROW
                {
                mDARROW(); 

                }
                break;
            case 106 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:752: DHARROW
                {
                mDHARROW(); 

                }
                break;
            case 107 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:760: HASH
                {
                mHASH(); 

                }
                break;
            case 108 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:765: IDENT
                {
                mIDENT(); 

                }
                break;
            case 109 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:771: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 110 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:786: REAL_LIT
                {
                mREAL_LIT(); 

                }
                break;
            case 111 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:795: INTEGER_LIT
                {
                mINTEGER_LIT(); 

                }
                break;
            case 112 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:807: WS
                {
                mWS(); 

                }
                break;
            case 113 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:810: ANNEX_TEXT
                {
                mANNEX_TEXT(); 

                }
                break;
            case 114 :
                // /home/lw/projects/osate2-dev-ws/core/org.osate.aadl2.parser/src/org/osate/aadl2/parser/Aadl2.g:1:821: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;

        }

    }


    protected DFA34 dfa34 = new DFA34(this);
    static final String DFA34_eotS =
        "\1\uffff\23\45\2\uffff\1\133\1\uffff\1\135\1\137\1\143\1\145\2\uffff"+
        "\1\147\1\uffff\1\151\6\uffff\1\152\1\uffff\27\45\1\u008e\1\u008f"+
        "\4\45\1\u0095\1\u0096\13\45\1\u00a7\6\45\7\uffff\1\u00b0\13\uffff"+
        "\2\45\1\u00b4\1\45\1\u00b6\3\45\1\u00ba\14\45\1\u00c9\13\45\2\uffff"+
        "\4\45\1\u00d9\2\uffff\1\u00da\11\45\1\u00e7\5\45\1\uffff\7\45\2"+
        "\uffff\1\152\2\45\1\uffff\1\45\1\uffff\3\45\1\uffff\13\45\1\u0109"+
        "\2\45\1\uffff\5\45\1\u0112\5\45\1\u0118\1\45\1\u011b\1\u011c\2\uffff"+
        "\2\45\1\u011f\1\u0120\6\45\1\u0127\1\45\1\uffff\1\u0129\6\45\1\u0130"+
        "\1\u0131\3\45\1\u0135\2\45\1\u0138\6\45\1\u013f\11\45\1\u0149\1"+
        "\uffff\1\u014a\2\45\1\u014d\1\45\1\u014f\1\45\1\u0151\1\uffff\1"+
        "\u0152\4\45\1\uffff\1\45\1\u0158\2\uffff\2\45\2\uffff\6\45\1\uffff"+
        "\1\45\1\uffff\6\45\2\uffff\1\u0168\1\u0169\1\45\1\uffff\1\45\1\u016c"+
        "\1\uffff\6\45\1\uffff\6\45\1\u017a\2\45\2\uffff\1\u017d\1\45\1\uffff"+
        "\1\45\1\uffff\1\45\2\uffff\4\45\1\u0185\1\uffff\7\45\1\u018d\1\u018e"+
        "\1\u018f\2\45\1\u0192\1\u0193\1\45\2\uffff\2\45\1\uffff\1\u0197"+
        "\4\45\1\u019c\1\45\1\u019e\3\45\1\u01a2\1\u01a3\1\uffff\1\u01a4"+
        "\1\45\1\uffff\1\45\1\u01a7\1\u01a9\1\45\1\u01ab\1\u01ac\1\u01ad"+
        "\1\uffff\1\u01ae\1\45\1\u01b0\1\u01b2\3\45\3\uffff\2\45\2\uffff"+
        "\1\45\1\u01ba\1\u01bb\1\uffff\2\45\1\u01be\1\45\1\uffff\1\45\1\uffff"+
        "\1\45\1\u01c2\1\45\3\uffff\1\u01c4\1\45\1\uffff\1\u01c6\1\uffff"+
        "\1\45\4\uffff\1\45\1\uffff\1\45\1\uffff\1\45\1\u01cb\1\45\1\u01cd"+
        "\3\45\2\uffff\2\45\1\uffff\3\45\1\uffff\1\u01d6\1\uffff\1\45\1\uffff"+
        "\1\45\1\u01d9\1\u01da\1\45\1\uffff\1\u01dd\1\uffff\5\45\1\u01e3"+
        "\1\u01e4\1\45\1\uffff\2\45\2\uffff\1\u01e8\1\u01e9\1\uffff\1\45"+
        "\1\u01eb\1\45\1\u01ed\1\u01ee\2\uffff\1\u01ef\1\u01f0\1\45\2\uffff"+
        "\1\45\1\uffff\1\u01f3\4\uffff\2\45\1\uffff\1\45\1\u01f7\1\u01f8"+
        "\2\uffff";
    static final String DFA34_eofS =
        "\u01f9\uffff";
    static final String DFA34_minS =
        "\1\11\1\141\1\151\3\141\1\156\1\141\1\162\1\155\1\151\1\145\1\157"+
        "\1\146\1\141\1\145\1\150\1\156\1\141\1\151\2\uffff\1\52\1\uffff"+
        "\1\72\1\75\1\55\1\52\2\uffff\1\56\1\uffff\1\55\6\uffff\1\56\1\uffff"+
        "\1\163\1\143\1\144\1\154\1\160\1\144\1\156\1\163\1\154\1\141\1\155"+
        "\1\143\1\156\1\164\1\154\1\144\1\145\1\164\1\154\1\141\2\157\1\160"+
        "\2\60\1\163\1\155\1\144\1\156\2\60\1\164\1\143\1\162\1\151\1\142"+
        "\1\154\1\156\1\165\1\142\1\163\1\162\1\60\1\141\1\160\1\151\1\154"+
        "\1\162\1\164\7\uffff\1\76\11\uffff\1\60\1\uffff\1\164\1\145\1\60"+
        "\1\145\1\60\2\154\1\144\1\60\1\154\1\163\1\160\1\156\1\145\1\157"+
        "\1\141\1\165\1\147\1\141\1\164\1\151\1\60\1\155\1\156\1\145\1\163"+
        "\1\164\1\167\1\165\1\154\1\145\1\164\1\145\2\uffff\1\164\1\157\2"+
        "\145\1\60\2\uffff\1\60\1\153\1\141\1\150\1\164\1\166\1\143\1\154"+
        "\1\146\1\166\1\60\1\153\1\162\1\143\1\164\1\145\1\uffff\1\156\2"+
        "\145\1\164\1\165\1\164\1\150\2\uffff\1\56\1\162\1\163\1\uffff\1"+
        "\170\1\uffff\1\151\1\142\1\151\1\uffff\2\163\1\165\1\145\1\164\1"+
        "\162\1\156\1\162\1\155\1\151\1\145\1\60\1\141\1\143\1\uffff\1\145"+
        "\1\164\1\156\1\145\1\165\1\60\1\160\1\145\1\162\1\151\1\162\1\60"+
        "\1\162\2\60\2\uffff\1\141\1\155\2\60\1\141\2\145\1\157\2\151\1\60"+
        "\1\145\1\uffff\1\60\1\143\1\157\1\162\1\145\1\141\1\163\2\60\1\163"+
        "\1\145\1\165\1\60\1\141\1\163\1\60\1\145\1\157\1\156\1\145\1\164"+
        "\1\156\1\60\1\151\1\164\1\143\1\141\2\145\1\144\1\145\1\162\1\60"+
        "\1\uffff\1\60\1\145\1\162\1\60\1\144\1\60\1\162\1\60\1\uffff\1\60"+
        "\1\155\1\151\1\141\1\163\1\uffff\1\171\1\60\2\uffff\1\147\1\145"+
        "\2\uffff\1\164\1\163\1\162\1\164\1\144\1\143\1\uffff\1\162\1\uffff"+
        "\1\145\1\155\1\157\1\155\1\144\1\151\2\uffff\2\60\1\141\1\uffff"+
        "\1\143\1\60\1\uffff\1\163\1\157\1\164\1\141\1\162\1\147\1\uffff"+
        "\1\146\1\145\1\164\2\156\1\144\1\60\1\163\1\145\2\uffff\1\60\1\141"+
        "\1\uffff\1\163\1\uffff\1\145\2\uffff\1\145\1\164\1\154\1\145\1\60"+
        "\1\uffff\1\145\1\164\1\145\1\163\1\164\1\171\1\145\3\60\1\160\1"+
        "\147\2\60\1\164\2\uffff\1\154\1\164\1\uffff\1\60\1\154\1\145\1\154"+
        "\1\151\1\60\1\151\1\60\1\151\1\164\1\143\2\60\1\uffff\1\60\1\163"+
        "\1\uffff\1\164\2\60\1\156\3\60\1\uffff\1\60\1\145\2\60\1\151\1\160"+
        "\1\163\3\uffff\1\157\1\162\2\uffff\1\151\2\60\1\uffff\1\145\1\147"+
        "\1\60\1\156\1\uffff\1\145\1\uffff\1\157\1\60\1\145\3\uffff\1\60"+
        "\1\151\1\uffff\1\60\1\uffff\1\164\4\uffff\1\162\1\uffff\1\162\1"+
        "\uffff\1\145\1\60\1\145\1\60\1\156\1\141\1\157\2\uffff\1\141\1\145"+
        "\1\uffff\1\147\1\162\1\156\1\uffff\1\60\1\uffff\1\157\1\uffff\1"+
        "\141\2\60\1\163\1\uffff\1\60\1\uffff\1\145\1\155\2\156\1\162\2\60"+
        "\1\163\1\uffff\1\156\1\164\2\uffff\2\60\1\uffff\1\156\1\60\1\163"+
        "\2\60\2\uffff\2\60\1\151\2\uffff\1\164\1\uffff\1\60\4\uffff\1\157"+
        "\1\163\1\uffff\1\156\2\60\2\uffff";
    static final String DFA34_maxS =
        "\1\175\1\160\1\165\1\157\2\145\1\170\1\154\1\162\1\163\1\151\2\157"+
        "\2\165\2\171\1\156\2\151\2\uffff\1\52\1\uffff\1\72\1\75\1\133\1"+
        "\52\2\uffff\1\56\1\uffff\1\55\6\uffff\1\137\1\uffff\1\163\1\143"+
        "\1\156\1\154\1\160\1\144\1\156\1\163\1\154\1\141\1\156\1\161\1\156"+
        "\1\164\1\166\1\165\1\145\1\164\1\154\1\141\2\157\1\160\2\172\1\163"+
        "\1\155\1\144\1\164\2\172\2\164\1\162\1\157\1\142\1\164\1\156\1\165"+
        "\1\142\1\163\1\162\1\172\1\165\1\160\1\151\1\154\1\162\1\164\7\uffff"+
        "\1\76\11\uffff\1\71\1\uffff\1\164\1\145\1\172\1\145\1\172\2\154"+
        "\1\144\1\172\1\154\1\163\1\160\1\163\1\151\1\157\1\141\1\165\1\147"+
        "\1\141\1\164\1\151\1\172\1\155\1\156\1\145\1\163\1\164\1\167\1\165"+
        "\1\154\1\145\1\164\1\145\2\uffff\1\164\1\157\2\145\1\172\2\uffff"+
        "\1\172\1\153\1\141\1\150\1\164\2\166\1\154\1\146\1\166\1\172\1\153"+
        "\1\162\1\160\1\164\1\145\1\uffff\1\156\2\145\1\164\1\165\1\164\1"+
        "\150\2\uffff\1\137\1\162\1\163\1\uffff\1\170\1\uffff\1\151\1\163"+
        "\1\151\1\uffff\2\163\1\165\1\145\1\164\1\162\1\156\1\162\1\155\1"+
        "\151\1\145\1\172\1\141\1\143\1\uffff\1\145\1\164\1\156\1\145\1\165"+
        "\1\172\1\160\1\145\1\162\1\151\1\162\1\172\1\162\2\172\2\uffff\1"+
        "\141\1\155\2\172\1\141\2\145\1\157\2\151\1\172\1\145\1\uffff\1\172"+
        "\1\143\1\157\1\162\1\145\1\141\1\163\2\172\1\163\1\145\1\165\1\172"+
        "\1\141\1\163\1\172\1\145\1\157\1\156\1\145\1\164\1\156\1\172\1\151"+
        "\1\164\1\143\1\141\2\145\1\144\1\145\1\162\1\172\1\uffff\1\172\1"+
        "\145\1\162\1\172\1\144\1\172\1\162\1\172\1\uffff\1\172\1\155\1\151"+
        "\1\141\1\163\1\uffff\1\171\1\172\2\uffff\1\147\1\145\2\uffff\1\164"+
        "\1\163\1\162\1\164\1\144\1\143\1\uffff\1\162\1\uffff\1\145\1\155"+
        "\1\157\1\155\1\144\1\151\2\uffff\2\172\1\141\1\uffff\1\143\1\172"+
        "\1\uffff\1\163\1\157\1\164\1\141\1\162\1\147\1\uffff\1\146\1\145"+
        "\1\164\2\156\1\163\1\172\1\163\1\145\2\uffff\1\172\1\141\1\uffff"+
        "\1\163\1\uffff\1\145\2\uffff\1\145\1\164\1\154\1\145\1\172\1\uffff"+
        "\1\145\1\164\1\145\1\163\1\164\1\171\1\145\3\172\1\160\1\147\2\172"+
        "\1\164\2\uffff\1\154\1\164\1\uffff\1\172\1\154\1\145\1\154\1\151"+
        "\1\172\1\151\1\172\1\151\1\164\1\143\2\172\1\uffff\1\172\1\163\1"+
        "\uffff\1\164\2\172\1\156\3\172\1\uffff\1\172\1\145\2\172\1\171\1"+
        "\160\1\163\3\uffff\1\157\1\162\2\uffff\1\151\2\172\1\uffff\1\145"+
        "\1\147\1\172\1\156\1\uffff\1\145\1\uffff\1\157\1\172\1\145\3\uffff"+
        "\1\172\1\151\1\uffff\1\172\1\uffff\1\164\4\uffff\1\162\1\uffff\1"+
        "\162\1\uffff\1\145\1\172\1\145\1\172\1\156\1\141\1\157\2\uffff\1"+
        "\141\1\145\1\uffff\1\147\1\162\1\156\1\uffff\1\172\1\uffff\1\157"+
        "\1\uffff\1\141\2\172\1\163\1\uffff\1\172\1\uffff\1\145\1\155\2\156"+
        "\1\162\2\172\1\163\1\uffff\1\156\1\164\2\uffff\2\172\1\uffff\1\156"+
        "\1\172\1\163\2\172\2\uffff\2\172\1\151\2\uffff\1\164\1\uffff\1\172"+
        "\4\uffff\1\157\1\163\1\uffff\1\156\2\172\2\uffff";
    static final String DFA34_acceptS =
        "\24\uffff\1\123\1\124\1\uffff\1\126\4\uffff\1\134\1\135\1\uffff"+
        "\1\140\1\uffff\1\145\1\150\1\152\1\153\1\154\1\155\1\uffff\1\160"+
        "\61\uffff\1\161\1\125\1\142\1\127\1\141\1\130\1\143\1\uffff\1\162"+
        "\1\131\1\133\1\132\1\137\1\136\1\144\1\146\1\157\1\uffff\1\156\41"+
        "\uffff\1\36\1\43\5\uffff\1\52\1\53\20\uffff\1\113\7\uffff\1\151"+
        "\1\147\3\uffff\1\3\1\uffff\1\4\3\uffff\1\11\16\uffff\1\23\17\uffff"+
        "\1\51\1\54\14\uffff\1\103\41\uffff\1\20\10\uffff\1\32\5\uffff\1"+
        "\44\2\uffff\1\46\1\50\2\uffff\1\57\1\60\6\uffff\1\101\1\uffff\1"+
        "\104\6\uffff\1\115\1\116\3\uffff\1\122\2\uffff\1\5\6\uffff\1\12"+
        "\11\uffff\1\72\1\21\2\uffff\1\25\1\uffff\1\27\1\uffff\1\33\1\34"+
        "\5\uffff\1\47\17\uffff\1\117\1\120\2\uffff\1\2\15\uffff\1\74\2\uffff"+
        "\1\22\7\uffff\1\45\7\uffff\1\71\1\102\1\105\2\uffff\1\111\1\112"+
        "\3\uffff\1\6\4\uffff\1\7\1\uffff\1\15\3\uffff\1\75\1\76\1\77\2\uffff"+
        "\1\26\1\uffff\1\30\1\uffff\1\37\1\40\1\42\1\55\1\uffff\1\61\1\uffff"+
        "\1\62\7\uffff\1\121\1\1\2\uffff\1\73\3\uffff\1\17\1\uffff\1\100"+
        "\1\uffff\1\31\4\uffff\1\65\1\uffff\1\70\10\uffff\1\14\2\uffff\1"+
        "\56\1\63\2\uffff\1\66\5\uffff\1\106\1\13\3\uffff\1\64\1\67\1\uffff"+
        "\1\110\1\uffff\1\10\1\41\1\16\1\24\2\uffff\1\114\3\uffff\1\107\1"+
        "\35";
    static final String DFA34_specialS =
        "\u01f9\uffff}>";
    static final String[] DFA34_transitionS = {
            "\2\50\2\uffff\1\50\22\uffff\1\50\1\uffff\1\46\1\44\4\uffff\1"+
            "\24\1\25\1\33\1\31\1\35\1\32\1\36\1\uffff\12\47\1\30\1\34\1"+
            "\42\1\37\1\43\34\uffff\1\41\1\uffff\1\40\3\uffff\1\1\1\2\1\3"+
            "\1\5\1\6\1\7\1\10\1\45\1\11\2\45\1\12\1\13\1\14\1\15\1\16\1"+
            "\45\1\4\1\17\1\20\1\21\1\22\1\23\3\45\1\26\1\uffff\1\27",
            "\1\56\1\51\1\52\10\uffff\1\54\1\uffff\1\53\1\uffff\1\55",
            "\1\57\13\uffff\1\60",
            "\1\61\12\uffff\1\62\2\uffff\1\63",
            "\1\65\3\uffff\1\64",
            "\1\66\3\uffff\1\67",
            "\1\70\7\uffff\1\71\1\uffff\1\72",
            "\1\73\3\uffff\1\74\6\uffff\1\75",
            "\1\76",
            "\1\77\1\100\4\uffff\1\101",
            "\1\102",
            "\1\103\11\uffff\1\104",
            "\1\105",
            "\1\106\13\uffff\1\107\2\uffff\1\110",
            "\1\111\15\uffff\1\112\2\uffff\1\113\2\uffff\1\114",
            "\1\115\3\uffff\1\116\5\uffff\1\117\5\uffff\1\120\3\uffff\1"+
            "\121",
            "\1\122\6\uffff\1\123\2\uffff\1\124\6\uffff\1\125",
            "\1\126",
            "\1\127\7\uffff\1\130",
            "\1\131",
            "",
            "",
            "\1\132",
            "",
            "\1\134",
            "\1\136",
            "\1\142\20\uffff\1\141\34\uffff\1\140",
            "\1\144",
            "",
            "",
            "\1\146",
            "",
            "\1\150",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\154\1\uffff\12\47\45\uffff\1\153",
            "",
            "\1\155",
            "\1\156",
            "\1\157\11\uffff\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170\1\171",
            "\1\173\2\uffff\1\172\7\uffff\1\174\2\uffff\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080\11\uffff\1\u0081",
            "\1\u0082\20\uffff\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\12\45\45\uffff\1\45\1\uffff\7\45\1\u008b\1\u008c\14\45\1\u008d"+
            "\4\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093\5\uffff\1\u0094",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0097",
            "\1\u0098\16\uffff\1\u0099\1\uffff\1\u009a",
            "\1\u009b",
            "\1\u009c\5\uffff\1\u009d",
            "\1\u009e",
            "\1\u009f\5\uffff\1\u00a0\1\uffff\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u00a8\23\uffff\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00af",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\u00b1",
            "",
            "\1\u00b2",
            "\1\u00b3",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u00b5",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be\4\uffff\1\u00bf",
            "\1\u00c0\3\uffff\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "",
            "",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0\14\uffff\1\u00e1\3\uffff\1\u00e2\1\uffff\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea\14\uffff\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "",
            "",
            "\1\154\1\uffff\12\u00b1\45\uffff\1\153",
            "\1\u00f5",
            "\1\u00f6",
            "",
            "\1\u00f7",
            "",
            "\1\u00f8",
            "\1\u00f9\6\uffff\1\u00fa\10\uffff\1\u00fb\1\u00fc",
            "\1\u00fd",
            "",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u010a",
            "\1\u010b",
            "",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\12\45\45\uffff\1\45\1\uffff\22\45\1\u0111\7\45",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0119",
            "\12\45\45\uffff\1\45\1\uffff\22\45\1\u011a\7\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "\1\u011d",
            "\1\u011e",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0128",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0136",
            "\1\u0137",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u014b",
            "\1\u014c",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u014e",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0150",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "",
            "\1\u0157",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "\1\u0159",
            "\1\u015a",
            "",
            "",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "",
            "\1\u0161",
            "",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u016a",
            "",
            "\1\u016b",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "\1\u0170",
            "\1\u0171",
            "\1\u0172",
            "",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178\16\uffff\1\u0179",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u017b",
            "\1\u017c",
            "",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u017e",
            "",
            "\1\u017f",
            "",
            "\1\u0180",
            "",
            "",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188",
            "\1\u0189",
            "\1\u018a",
            "\1\u018b",
            "\1\u018c",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0190",
            "\1\u0191",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0194",
            "",
            "",
            "\1\u0195",
            "\1\u0196",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "\1\u019b",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u019d",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u019f",
            "\1\u01a0",
            "\1\u01a1",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u01a5",
            "",
            "\1\u01a6",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\22\45\1\u01a8\7\45",
            "\1\u01aa",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u01af",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\16\45\1\u01b1\13\45",
            "\1\u01b3\17\uffff\1\u01b4",
            "\1\u01b5",
            "\1\u01b6",
            "",
            "",
            "",
            "\1\u01b7",
            "\1\u01b8",
            "",
            "",
            "\1\u01b9",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u01bc",
            "\1\u01bd",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u01bf",
            "",
            "\1\u01c0",
            "",
            "\1\u01c1",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u01c3",
            "",
            "",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u01c5",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u01c7",
            "",
            "",
            "",
            "",
            "\1\u01c8",
            "",
            "\1\u01c9",
            "",
            "\1\u01ca",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u01cc",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u01ce",
            "\1\u01cf",
            "\1\u01d0",
            "",
            "",
            "\1\u01d1",
            "\1\u01d2",
            "",
            "\1\u01d3",
            "\1\u01d4",
            "\1\u01d5",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u01d7",
            "",
            "\1\u01d8",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u01db",
            "",
            "\12\45\45\uffff\1\45\1\uffff\22\45\1\u01dc\7\45",
            "",
            "\1\u01de",
            "\1\u01df",
            "\1\u01e0",
            "\1\u01e1",
            "\1\u01e2",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u01e5",
            "",
            "\1\u01e6",
            "\1\u01e7",
            "",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u01ea",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u01ec",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\1\u01f1",
            "",
            "",
            "\1\u01f2",
            "",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "",
            "",
            "\1\u01f4",
            "\1\u01f5",
            "",
            "\1\u01f6",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "\12\45\45\uffff\1\45\1\uffff\32\45",
            "",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ABSTRACT | ACCESS | AND | ALL | ANNEX | APPLIES | BINDING | BOOLEAN | BUS | CALLS | CLASSIFIER | REFERENCE | COMPUTE | CONNECTIONS | CONSTANT | DATA | DELTA | DEVICE | END | ENUMERATION | EVENT | EXTENDS | FALSE | FEATURE | FEATURES | FLOW | FLOWS | GROUP | IMPLEMENTATION | IN | INHERIT | INITIAL | INTEGER | INVERSE | IS | LIST | MEMORY | MODE | MODES | NONE | NOT | OF | OR | OUT | PACKAGE | PARAMETER | PATH | PORT | PRIVATE | PROCESS | PROCESSOR | PROPERTIES | PROPERTY | PROTOTYPE | PROTOTYPES | PROVIDES | PUBLIC | RANGE | REAL | RECORD | REFINED | REFINES | RENAMES | REQUIRES | SELF | SERVER | SET | SINK | SOURCE | STRING | SUBCOMPONENTS | SUBPROGRAM | SYSTEM | THREAD | TO | TRANSITIONS | TRUE | TYPE | UNITS | VALUE | VIRTUAL | WITH | LPAREN | RPAREN | LCURLY | RCURLY | COLON | PLUS | MINUS | STAR | STARSTAR | SEMI | COMMA | DOT | DOTDOT | ASSIGN | ASSIGNPLUS | DOUBLECOLON | LTRANS | RTRANS | LBRACK | RBRACK | ARROW | BARROW | DARROW | DHARROW | HASH | IDENT | STRING_LITERAL | REAL_LIT | INTEGER_LIT | WS | ANNEX_TEXT | SL_COMMENT );";
        }
    }
 

}
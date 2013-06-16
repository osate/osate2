// $ANTLR 3.3 Nov 30, 2010 12:50:56 Lute.g 2013-01-30 10:24:42

  package org.osate.analysis.lute.language;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class LuteLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int ID=4;
    public static final int INT=5;
    public static final int STRING=6;
    public static final int LETTER=7;
    public static final int DIGIT=8;
    public static final int SPECIAL=9;
    public static final int WS=10;
    public static final int COMMENT=11;
    public static final int ERROR=12;

      protected void ignore(Stack<Void> stack, List<Void> list, ArrayList<Void> arraylist) {}


    // delegates
    // delegators

    public LuteLexer() {;} 
    public LuteLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LuteLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Lute.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:14:7: ( 'theorem' )
            // Lute.g:14:9: 'theorem'
            {
            match("theorem"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:15:7: ( 'end' )
            // Lute.g:15:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:16:7: ( ';' )
            // Lute.g:16:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:17:7: ( ':=' )
            // Lute.g:17:9: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:18:7: ( '(' )
            // Lute.g:18:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:19:7: ( ',' )
            // Lute.g:19:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:20:7: ( ')' )
            // Lute.g:20:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:21:7: ( 'foreach' )
            // Lute.g:21:9: 'foreach'
            {
            match("foreach"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:22:7: ( 'in' )
            // Lute.g:22:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:23:7: ( 'do' )
            // Lute.g:23:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:24:7: ( 'check' )
            // Lute.g:24:9: 'check'
            {
            match("check"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:25:7: ( 'when' )
            // Lute.g:25:9: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:26:7: ( 'print' )
            // Lute.g:26:9: 'print'
            {
            match("print"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:27:7: ( 'if' )
            // Lute.g:27:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:28:7: ( 'then' )
            // Lute.g:28:9: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:29:7: ( 'else' )
            // Lute.g:29:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:30:7: ( 'and' )
            // Lute.g:30:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:31:7: ( 'or' )
            // Lute.g:31:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:32:7: ( 'not' )
            // Lute.g:32:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:33:7: ( '=' )
            // Lute.g:33:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:34:7: ( '>' )
            // Lute.g:34:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:35:7: ( '<' )
            // Lute.g:35:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:36:7: ( '>=' )
            // Lute.g:36:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:37:7: ( '<=' )
            // Lute.g:37:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:38:7: ( '!=' )
            // Lute.g:38:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:39:7: ( '+' )
            // Lute.g:39:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:40:7: ( '-' )
            // Lute.g:40:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:41:7: ( '*' )
            // Lute.g:41:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:42:7: ( '{' )
            // Lute.g:42:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:43:7: ( 'for' )
            // Lute.g:43:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:44:7: ( '|' )
            // Lute.g:44:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:45:7: ( '}' )
            // Lute.g:45:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:46:7: ( 'true' )
            // Lute.g:46:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:47:7: ( 'false' )
            // Lute.g:47:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // Lute.g:156:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // Lute.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // Lute.g:157:15: ( '0' .. '9' )
            // Lute.g:157:17: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "SPECIAL"
    public final void mSPECIAL() throws RecognitionException {
        try {
            // Lute.g:158:17: ( '_' | '.' | '::' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case '_':
                {
                alt1=1;
                }
                break;
            case '.':
                {
                alt1=2;
                }
                break;
            case ':':
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // Lute.g:158:19: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 2 :
                    // Lute.g:158:25: '.'
                    {
                    match('.'); 

                    }
                    break;
                case 3 :
                    // Lute.g:158:31: '::'
                    {
                    match("::"); 


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "SPECIAL"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:159:4: ( ( '-' )? ( DIGIT )+ )
            // Lute.g:159:6: ( '-' )? ( DIGIT )+
            {
            // Lute.g:159:6: ( '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Lute.g:159:6: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // Lute.g:159:11: ( DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Lute.g:159:11: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:160:3: ( LETTER ( LETTER | DIGIT | SPECIAL )* )
            // Lute.g:160:5: LETTER ( LETTER | DIGIT | SPECIAL )*
            {
            mLETTER(); 
            // Lute.g:160:12: ( LETTER | DIGIT | SPECIAL )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt4=1;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt4=2;
                    }
                    break;
                case '.':
                case ':':
                case '_':
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // Lute.g:160:13: LETTER
            	    {
            	    mLETTER(); 

            	    }
            	    break;
            	case 2 :
            	    // Lute.g:160:22: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;
            	case 3 :
            	    // Lute.g:160:30: SPECIAL
            	    {
            	    mSPECIAL(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:161:7: ( '\"' (~ '\"' )* '\"' )
            // Lute.g:161:9: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // Lute.g:161:13: (~ '\"' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Lute.g:161:14: ~ '\"'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "STRING"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:162:3: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // Lute.g:162:5: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // Lute.g:162:5: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||(LA6_0>='\f' && LA6_0<='\r')||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Lute.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:163:8: ( '--' (~ ( '\\n' | '\\r' ) )* )
            // Lute.g:163:10: '--' (~ ( '\\n' | '\\r' ) )*
            {
            match("--"); 

            // Lute.g:163:15: (~ ( '\\n' | '\\r' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Lute.g:163:16: ~ ( '\\n' | '\\r' )
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
            	    break loop7;
                }
            } while (true);

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "ERROR"
    public final void mERROR() throws RecognitionException {
        try {
            int _type = ERROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:164:6: ( '.' )
            // Lute.g:164:8: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ERROR"

    public void mTokens() throws RecognitionException {
        // Lute.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | INT | ID | STRING | WS | COMMENT | ERROR )
        int alt8=40;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // Lute.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // Lute.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // Lute.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // Lute.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // Lute.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // Lute.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // Lute.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // Lute.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // Lute.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // Lute.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // Lute.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // Lute.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // Lute.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // Lute.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // Lute.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // Lute.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // Lute.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // Lute.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // Lute.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // Lute.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // Lute.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // Lute.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // Lute.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // Lute.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // Lute.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // Lute.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // Lute.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // Lute.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // Lute.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // Lute.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // Lute.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // Lute.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // Lute.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // Lute.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // Lute.g:1:214: INT
                {
                mINT(); 

                }
                break;
            case 36 :
                // Lute.g:1:218: ID
                {
                mID(); 

                }
                break;
            case 37 :
                // Lute.g:1:221: STRING
                {
                mSTRING(); 

                }
                break;
            case 38 :
                // Lute.g:1:228: WS
                {
                mWS(); 

                }
                break;
            case 39 :
                // Lute.g:1:231: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 40 :
                // Lute.g:1:239: ERROR
                {
                mERROR(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\2\34\5\uffff\11\34\1\uffff\1\60\1\62\2\uffff\1\64\11\uffff"+
        "\6\34\1\73\1\74\1\75\4\34\1\102\1\34\6\uffff\2\34\1\107\1\34\1\112"+
        "\1\34\3\uffff\3\34\1\117\1\uffff\1\120\1\34\1\122\1\123\1\uffff"+
        "\1\124\1\34\1\uffff\2\34\1\130\1\34\2\uffff\1\34\3\uffff\1\34\1"+
        "\134\1\135\1\uffff\1\136\2\34\3\uffff\1\141\1\142\2\uffff";
    static final String DFA8_eofS =
        "\143\uffff";
    static final String DFA8_minS =
        "\1\11\1\150\1\154\5\uffff\1\141\1\146\1\157\2\150\1\162\1\156\1"+
        "\162\1\157\1\uffff\2\75\2\uffff\1\55\11\uffff\1\145\1\165\1\144"+
        "\1\163\1\162\1\154\3\56\2\145\1\151\1\144\1\56\1\164\6\uffff\1\156"+
        "\1\145\1\56\1\145\1\56\1\163\3\uffff\1\143\2\156\1\56\1\uffff\1"+
        "\56\1\162\2\56\1\uffff\1\56\1\141\1\uffff\1\145\1\153\1\56\1\164"+
        "\2\uffff\1\145\3\uffff\1\143\2\56\1\uffff\1\56\1\155\1\150\3\uffff"+
        "\2\56\2\uffff";
    static final String DFA8_maxS =
        "\1\175\1\162\1\156\5\uffff\1\157\1\156\1\157\2\150\1\162\1\156"+
        "\1\162\1\157\1\uffff\2\75\2\uffff\1\71\11\uffff\1\145\1\165\1\144"+
        "\1\163\1\162\1\154\3\172\2\145\1\151\1\144\1\172\1\164\6\uffff\1"+
        "\157\1\145\1\172\1\145\1\172\1\163\3\uffff\1\143\2\156\1\172\1\uffff"+
        "\1\172\1\162\2\172\1\uffff\1\172\1\141\1\uffff\1\145\1\153\1\172"+
        "\1\164\2\uffff\1\145\3\uffff\1\143\2\172\1\uffff\1\172\1\155\1\150"+
        "\3\uffff\2\172\2\uffff";
    static final String DFA8_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\7\11\uffff\1\24\2\uffff\1\31\1\32\1"+
        "\uffff\1\34\1\35\1\37\1\40\1\43\1\44\1\45\1\46\1\50\17\uffff\1\27"+
        "\1\25\1\30\1\26\1\47\1\33\6\uffff\1\11\1\16\1\12\4\uffff\1\22\4"+
        "\uffff\1\2\2\uffff\1\36\4\uffff\1\21\1\23\1\uffff\1\17\1\41\1\20"+
        "\3\uffff\1\14\3\uffff\1\42\1\13\1\15\2\uffff\1\1\1\10";
    static final String DFA8_specialS =
        "\143\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\36\1\uffff\2\36\22\uffff\1\36\1\24\1\35\5\uffff\1\5\1\7"+
            "\1\27\1\25\1\6\1\26\1\37\1\uffff\12\33\1\4\1\3\1\23\1\21\1\22"+
            "\2\uffff\32\34\6\uffff\1\16\1\34\1\13\1\12\1\2\1\10\2\34\1\11"+
            "\4\34\1\20\1\17\1\15\3\34\1\1\2\34\1\14\3\34\1\30\1\31\1\32",
            "\1\40\11\uffff\1\41",
            "\1\43\1\uffff\1\42",
            "",
            "",
            "",
            "",
            "",
            "\1\45\15\uffff\1\44",
            "\1\47\7\uffff\1\46",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "",
            "\1\57",
            "\1\61",
            "",
            "",
            "\1\63\2\uffff\12\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\103",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\105\1\104",
            "\1\106",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\110",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\4\34"+
            "\1\111\25\34",
            "\1\113",
            "",
            "",
            "",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\121",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\125",
            "",
            "\1\126",
            "\1\127",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\131",
            "",
            "",
            "\1\132",
            "",
            "",
            "",
            "\1\133",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\137",
            "\1\140",
            "",
            "",
            "",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "\1\34\1\uffff\13\34\6\uffff\32\34\4\uffff\1\34\1\uffff\32"+
            "\34",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | INT | ID | STRING | WS | COMMENT | ERROR );";
        }
    }
 

}
// $ANTLR 3.3 Nov 30, 2010 12:50:56 Lute.g 2012-04-27 09:31:42

  package org.osate.validation.lute;
  
  

import org.antlr.runtime.*;
import org.osate.validation.Logger;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LuteLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__12=12;
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
    public static final int ID=4;
    public static final int INT=5;
    public static final int STRING=6;
    public static final int LETTER=7;
    public static final int DIGIT=8;
    public static final int SPECIAL=9;
    public static final int WS=10;
    public static final int COMMENT=11;

      private Logger log;
      
      public LuteLexer(CharStream input, Logger log) {
        this(input);
        this.log = log;
      }
      
      @Override
      public void emitErrorMessage(String msg) {
        if (log != null) {
          log.error(msg);
        } else {
          super.emitErrorMessage(msg);
        }
      }

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

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:32:7: ( 'theorem' )
            // Lute.g:32:9: 'theorem'
            {
            match("theorem"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lute.g:33:7: ( 'end' )
            // Lute.g:33:9: 'end'
            {
            match("end"); 


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
            // Lute.g:34:7: ( ';' )
            // Lute.g:34:9: ';'
            {
            match(';'); 

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
            // Lute.g:35:7: ( ':=' )
            // Lute.g:35:9: ':='
            {
            match(":="); 


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
            // Lute.g:36:7: ( '(' )
            // Lute.g:36:9: '('
            {
            match('('); 

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
            // Lute.g:37:7: ( ',' )
            // Lute.g:37:9: ','
            {
            match(','); 

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
            // Lute.g:38:7: ( ')' )
            // Lute.g:38:9: ')'
            {
            match(')'); 

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
            // Lute.g:39:7: ( 'foreach' )
            // Lute.g:39:9: 'foreach'
            {
            match("foreach"); 


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
            // Lute.g:40:7: ( 'in' )
            // Lute.g:40:9: 'in'
            {
            match("in"); 


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
            // Lute.g:41:7: ( 'do' )
            // Lute.g:41:9: 'do'
            {
            match("do"); 


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
            // Lute.g:42:7: ( 'check' )
            // Lute.g:42:9: 'check'
            {
            match("check"); 


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
            // Lute.g:43:7: ( 'print' )
            // Lute.g:43:9: 'print'
            {
            match("print"); 


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
            // Lute.g:44:7: ( 'if' )
            // Lute.g:44:9: 'if'
            {
            match("if"); 


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
            // Lute.g:45:7: ( 'then' )
            // Lute.g:45:9: 'then'
            {
            match("then"); 


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
            // Lute.g:46:7: ( 'else' )
            // Lute.g:46:9: 'else'
            {
            match("else"); 


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
            // Lute.g:47:7: ( 'and' )
            // Lute.g:47:9: 'and'
            {
            match("and"); 


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
            // Lute.g:48:7: ( 'or' )
            // Lute.g:48:9: 'or'
            {
            match("or"); 


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
            // Lute.g:49:7: ( 'not' )
            // Lute.g:49:9: 'not'
            {
            match("not"); 


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
            // Lute.g:50:7: ( '=' )
            // Lute.g:50:9: '='
            {
            match('='); 

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
            // Lute.g:51:7: ( '>' )
            // Lute.g:51:9: '>'
            {
            match('>'); 

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
            // Lute.g:52:7: ( '<' )
            // Lute.g:52:9: '<'
            {
            match('<'); 

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
            // Lute.g:53:7: ( '>=' )
            // Lute.g:53:9: '>='
            {
            match(">="); 


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
            // Lute.g:54:7: ( '<=' )
            // Lute.g:54:9: '<='
            {
            match("<="); 


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
            // Lute.g:55:7: ( '!=' )
            // Lute.g:55:9: '!='
            {
            match("!="); 


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
            // Lute.g:56:7: ( '+' )
            // Lute.g:56:9: '+'
            {
            match('+'); 

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
            // Lute.g:57:7: ( '-' )
            // Lute.g:57:9: '-'
            {
            match('-'); 

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
            // Lute.g:58:7: ( '*' )
            // Lute.g:58:9: '*'
            {
            match('*'); 

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
            // Lute.g:59:7: ( '{' )
            // Lute.g:59:9: '{'
            {
            match('{'); 

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
            // Lute.g:60:7: ( 'for' )
            // Lute.g:60:9: 'for'
            {
            match("for"); 


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
            // Lute.g:61:7: ( '|' )
            // Lute.g:61:9: '|'
            {
            match('|'); 

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
            // Lute.g:62:7: ( '}' )
            // Lute.g:62:9: '}'
            {
            match('}'); 

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
            // Lute.g:63:7: ( 'true' )
            // Lute.g:63:9: 'true'
            {
            match("true"); 


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
            // Lute.g:64:7: ( 'false' )
            // Lute.g:64:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // Lute.g:171:16: ( 'a' .. 'z' | 'A' .. 'Z' )
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
            // Lute.g:172:15: ( '0' .. '9' )
            // Lute.g:172:17: '0' .. '9'
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
            // Lute.g:173:17: ( '_' | '.' | '::' )
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
                    // Lute.g:173:19: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 2 :
                    // Lute.g:173:25: '.'
                    {
                    match('.'); 

                    }
                    break;
                case 3 :
                    // Lute.g:173:31: '::'
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
            // Lute.g:174:4: ( ( '-' )? ( DIGIT )+ )
            // Lute.g:174:6: ( '-' )? ( DIGIT )+
            {
            // Lute.g:174:6: ( '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Lute.g:174:6: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // Lute.g:174:11: ( DIGIT )+
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
            	    // Lute.g:174:11: DIGIT
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
            // Lute.g:175:3: ( LETTER ( LETTER | DIGIT | SPECIAL )* )
            // Lute.g:175:5: LETTER ( LETTER | DIGIT | SPECIAL )*
            {
            mLETTER(); 
            // Lute.g:175:12: ( LETTER | DIGIT | SPECIAL )*
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
            	    // Lute.g:175:13: LETTER
            	    {
            	    mLETTER(); 

            	    }
            	    break;
            	case 2 :
            	    // Lute.g:175:22: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;
            	case 3 :
            	    // Lute.g:175:30: SPECIAL
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
            // Lute.g:176:7: ( '\"' (~ '\"' )* '\"' )
            // Lute.g:176:9: '\"' (~ '\"' )* '\"'
            {
            match('\"'); 
            // Lute.g:176:13: (~ '\"' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Lute.g:176:14: ~ '\"'
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
            // Lute.g:177:3: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // Lute.g:177:5: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // Lute.g:177:5: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
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
            // Lute.g:178:8: ( '--' (~ ( '\\n' | '\\r' ) )* )
            // Lute.g:178:10: '--' (~ ( '\\n' | '\\r' ) )*
            {
            match("--"); 

            // Lute.g:178:15: (~ ( '\\n' | '\\r' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Lute.g:178:16: ~ ( '\\n' | '\\r' )
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

    public void mTokens() throws RecognitionException {
        // Lute.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | INT | ID | STRING | WS | COMMENT )
        int alt8=38;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // Lute.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // Lute.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // Lute.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // Lute.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // Lute.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // Lute.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // Lute.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // Lute.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // Lute.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // Lute.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // Lute.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // Lute.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // Lute.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // Lute.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // Lute.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // Lute.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // Lute.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // Lute.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // Lute.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // Lute.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // Lute.g:1:130: T__32
                {
                mT__32(); 

                }
                break;
            case 22 :
                // Lute.g:1:136: T__33
                {
                mT__33(); 

                }
                break;
            case 23 :
                // Lute.g:1:142: T__34
                {
                mT__34(); 

                }
                break;
            case 24 :
                // Lute.g:1:148: T__35
                {
                mT__35(); 

                }
                break;
            case 25 :
                // Lute.g:1:154: T__36
                {
                mT__36(); 

                }
                break;
            case 26 :
                // Lute.g:1:160: T__37
                {
                mT__37(); 

                }
                break;
            case 27 :
                // Lute.g:1:166: T__38
                {
                mT__38(); 

                }
                break;
            case 28 :
                // Lute.g:1:172: T__39
                {
                mT__39(); 

                }
                break;
            case 29 :
                // Lute.g:1:178: T__40
                {
                mT__40(); 

                }
                break;
            case 30 :
                // Lute.g:1:184: T__41
                {
                mT__41(); 

                }
                break;
            case 31 :
                // Lute.g:1:190: T__42
                {
                mT__42(); 

                }
                break;
            case 32 :
                // Lute.g:1:196: T__43
                {
                mT__43(); 

                }
                break;
            case 33 :
                // Lute.g:1:202: T__44
                {
                mT__44(); 

                }
                break;
            case 34 :
                // Lute.g:1:208: INT
                {
                mINT(); 

                }
                break;
            case 35 :
                // Lute.g:1:212: ID
                {
                mID(); 

                }
                break;
            case 36 :
                // Lute.g:1:215: STRING
                {
                mSTRING(); 

                }
                break;
            case 37 :
                // Lute.g:1:222: WS
                {
                mWS(); 

                }
                break;
            case 38 :
                // Lute.g:1:225: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\2\33\5\uffff\10\33\1\uffff\1\55\1\57\2\uffff\1\61\10\uffff"+
        "\6\33\1\70\1\71\1\72\3\33\1\76\1\33\6\uffff\2\33\1\103\1\33\1\106"+
        "\1\33\3\uffff\2\33\1\112\1\uffff\1\113\1\33\1\115\1\116\1\uffff"+
        "\1\117\1\33\1\uffff\3\33\2\uffff\1\33\3\uffff\1\33\1\126\1\127\1"+
        "\130\2\33\3\uffff\1\133\1\134\2\uffff";
    static final String DFA8_eofS =
        "\135\uffff";
    static final String DFA8_minS =
        "\1\11\1\150\1\154\5\uffff\1\141\1\146\1\157\1\150\1\162\1\156\1"+
        "\162\1\157\1\uffff\2\75\2\uffff\1\55\10\uffff\1\145\1\165\1\144"+
        "\1\163\1\162\1\154\3\56\1\145\1\151\1\144\1\56\1\164\6\uffff\1\156"+
        "\1\145\1\56\1\145\1\56\1\163\3\uffff\1\143\1\156\1\56\1\uffff\1"+
        "\56\1\162\2\56\1\uffff\1\56\1\141\1\uffff\1\145\1\153\1\164\2\uffff"+
        "\1\145\3\uffff\1\143\3\56\1\155\1\150\3\uffff\2\56\2\uffff";
    static final String DFA8_maxS =
        "\1\175\1\162\1\156\5\uffff\1\157\1\156\1\157\1\150\1\162\1\156"+
        "\1\162\1\157\1\uffff\2\75\2\uffff\1\71\10\uffff\1\145\1\165\1\144"+
        "\1\163\1\162\1\154\3\172\1\145\1\151\1\144\1\172\1\164\6\uffff\1"+
        "\157\1\145\1\172\1\145\1\172\1\163\3\uffff\1\143\1\156\1\172\1\uffff"+
        "\1\172\1\162\2\172\1\uffff\1\172\1\141\1\uffff\1\145\1\153\1\164"+
        "\2\uffff\1\145\3\uffff\1\143\3\172\1\155\1\150\3\uffff\2\172\2\uffff";
    static final String DFA8_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\7\10\uffff\1\23\2\uffff\1\30\1\31\1"+
        "\uffff\1\33\1\34\1\36\1\37\1\42\1\43\1\44\1\45\16\uffff\1\26\1\24"+
        "\1\27\1\25\1\46\1\32\6\uffff\1\11\1\15\1\12\3\uffff\1\21\4\uffff"+
        "\1\2\2\uffff\1\35\3\uffff\1\20\1\22\1\uffff\1\16\1\40\1\17\6\uffff"+
        "\1\41\1\13\1\14\2\uffff\1\1\1\10";
    static final String DFA8_specialS =
        "\135\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\35\1\uffff\2\35\22\uffff\1\35\1\23\1\34\5\uffff\1\5\1\7"+
            "\1\26\1\24\1\6\1\25\2\uffff\12\32\1\4\1\3\1\22\1\20\1\21\2\uffff"+
            "\32\33\6\uffff\1\15\1\33\1\13\1\12\1\2\1\10\2\33\1\11\4\33\1"+
            "\17\1\16\1\14\3\33\1\1\6\33\1\27\1\30\1\31",
            "\1\36\11\uffff\1\37",
            "\1\41\1\uffff\1\40",
            "",
            "",
            "",
            "",
            "",
            "\1\43\15\uffff\1\42",
            "\1\45\7\uffff\1\44",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "",
            "\1\54",
            "\1\56",
            "",
            "",
            "\1\60\2\uffff\12\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\77",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\101\1\100",
            "\1\102",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\104",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\4\33"+
            "\1\105\25\33",
            "\1\107",
            "",
            "",
            "",
            "\1\110",
            "\1\111",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\114",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\120",
            "",
            "\1\121",
            "\1\122",
            "\1\123",
            "",
            "",
            "\1\124",
            "",
            "",
            "",
            "\1\125",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\131",
            "\1\132",
            "",
            "",
            "",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
            "\1\33\1\uffff\13\33\6\uffff\32\33\4\uffff\1\33\1\uffff\32"+
            "\33",
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
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | INT | ID | STRING | WS | COMMENT );";
        }
    }
 

}
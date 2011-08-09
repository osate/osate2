package org.osate.xtext.aadl2.sandbox.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSandboxLexer extends Lexer {
    public static final int RULE_ID=12;
    public static final int RULE_STRING=14;
    public static final int RULE_ANY_OTHER=18;
    public static final int KEYWORD_6=6;
    public static final int KEYWORD_7=5;
    public static final int KEYWORD_8=4;
    public static final int KEYWORD_1=10;
    public static final int RULE_INT=13;
    public static final int KEYWORD_5=7;
    public static final int KEYWORD_4=9;
    public static final int KEYWORD_3=8;
    public static final int KEYWORD_2=11;
    public static final int RULE_WS=17;
    public static final int RULE_SL_COMMENT=16;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=15;

    // delegates
    // delegators

    public InternalSandboxLexer() {;} 
    public InternalSandboxLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalSandboxLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g"; }

    // $ANTLR start "KEYWORD_8"
    public final void mKEYWORD_8() throws RecognitionException {
        try {
            int _type = KEYWORD_8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:19:11: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:19:13: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_8"

    // $ANTLR start "KEYWORD_7"
    public final void mKEYWORD_7() throws RecognitionException {
        try {
            int _type = KEYWORD_7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:21:11: ( ( 'S' | 's' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'X' | 'x' ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:21:13: ( 'S' | 's' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'X' | 'x' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_7"

    // $ANTLR start "KEYWORD_6"
    public final void mKEYWORD_6() throws RecognitionException {
        try {
            int _type = KEYWORD_6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:23:11: ( ( 'S' | 's' ) ( 'Y' | 'y' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'M' | 'm' ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:23:13: ( 'S' | 's' ) ( 'Y' | 'y' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'M' | 'm' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_6"

    // $ANTLR start "KEYWORD_5"
    public final void mKEYWORD_5() throws RecognitionException {
        try {
            int _type = KEYWORD_5;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:25:11: ( ( 'F' | 'f' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'M' | 'm' ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:25:13: ( 'F' | 'f' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'M' | 'm' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_5"

    // $ANTLR start "KEYWORD_3"
    public final void mKEYWORD_3() throws RecognitionException {
        try {
            int _type = KEYWORD_3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:27:11: ( ':' ':' )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:27:13: ':' ':'
            {
            match(':'); 
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_3"

    // $ANTLR start "KEYWORD_4"
    public final void mKEYWORD_4() throws RecognitionException {
        try {
            int _type = KEYWORD_4;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:29:11: ( ( 'T' | 't' ) ( 'O' | 'o' ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:29:13: ( 'T' | 't' ) ( 'O' | 'o' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_4"

    // $ANTLR start "KEYWORD_1"
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:31:11: ( '.' )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:31:13: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_1"

    // $ANTLR start "KEYWORD_2"
    public final void mKEYWORD_2() throws RecognitionException {
        try {
            int _type = KEYWORD_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:33:11: ( ';' )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:33:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_2"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:39:10: ( ( '0' .. '9' )+ )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:39:12: ( '0' .. '9' )+
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:39:12: ( '0' .. '9' )+
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
            	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:39:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:66: ~ ( ( '\\\\' | '\"' ) )
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
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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

                    match('\''); 

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
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:43:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:43:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:43:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:43:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:45:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:45:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:45:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:45:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop8;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:45:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:45:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:45:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:45:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

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
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:47:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:47:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:47:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:49:16: ( . )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:49:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:8: ( KEYWORD_8 | KEYWORD_7 | KEYWORD_6 | KEYWORD_5 | KEYWORD_3 | KEYWORD_4 | KEYWORD_1 | KEYWORD_2 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=15;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:10: KEYWORD_8
                {
                mKEYWORD_8(); 

                }
                break;
            case 2 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:20: KEYWORD_7
                {
                mKEYWORD_7(); 

                }
                break;
            case 3 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:30: KEYWORD_6
                {
                mKEYWORD_6(); 

                }
                break;
            case 4 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:40: KEYWORD_5
                {
                mKEYWORD_5(); 

                }
                break;
            case 5 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:50: KEYWORD_3
                {
                mKEYWORD_3(); 

                }
                break;
            case 6 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:60: KEYWORD_4
                {
                mKEYWORD_4(); 

                }
                break;
            case 7 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:70: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 8 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:80: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 9 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:90: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 10 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:98: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 11 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:107: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 12 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:119: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 13 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:135: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 14 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:151: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 15 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:159: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\3\21\1\17\1\21\2\uffff\1\17\2\uffff\3\17\2\uffff\1\21"+
        "\1\uffff\3\21\1\uffff\1\42\7\uffff\4\21\1\uffff\3\21\1\52\3\21\1"+
        "\uffff\2\21\1\60\1\21\1\62\1\uffff\1\63\2\uffff";
    static final String DFA12_eofS =
        "\64\uffff";
    static final String DFA12_minS =
        "\1\0\1\116\1\101\1\122\1\72\1\117\2\uffff\1\101\2\uffff\2\0\1\52"+
        "\2\uffff\1\123\1\uffff\1\116\1\123\1\117\1\uffff\1\60\7\uffff\1"+
        "\124\1\104\1\124\1\115\1\uffff\1\101\1\102\1\105\1\60\1\116\1\117"+
        "\1\115\1\uffff\1\103\1\130\1\60\1\105\1\60\1\uffff\1\60\2\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\156\1\171\1\162\1\72\1\157\2\uffff\1\172\2\uffff\2\uffff"+
        "\1\57\2\uffff\1\163\1\uffff\1\156\1\163\1\157\1\uffff\1\172\7\uffff"+
        "\1\164\1\144\1\164\1\155\1\uffff\1\141\1\142\1\145\1\172\1\156\1"+
        "\157\1\155\1\uffff\1\143\1\170\1\172\1\145\1\172\1\uffff\1\172\2"+
        "\uffff";
    static final String DFA12_acceptS =
        "\6\uffff\1\7\1\10\1\uffff\1\11\1\12\3\uffff\1\16\1\17\1\uffff\1"+
        "\11\3\uffff\1\5\1\uffff\1\7\1\10\1\12\1\13\1\14\1\15\1\16\4\uffff"+
        "\1\6\7\uffff\1\4\5\uffff\1\3\1\uffff\1\2\1\1";
    static final String DFA12_specialS =
        "\1\0\12\uffff\1\1\1\2\47\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\17\2\16\2\17\1\16\22\17\1\16\1\17\1\13\4\17\1\14\6\17\1"+
            "\6\1\15\12\12\1\4\1\7\5\17\5\11\1\3\2\11\1\1\11\11\1\2\1\5\6"+
            "\11\3\17\1\10\1\11\1\17\5\11\1\3\2\11\1\1\11\11\1\2\1\5\6\11"+
            "\uff85\17",
            "\1\20\37\uffff\1\20",
            "\1\22\27\uffff\1\23\7\uffff\1\22\27\uffff\1\23",
            "\1\24\37\uffff\1\24",
            "\1\25",
            "\1\26\37\uffff\1\26",
            "",
            "",
            "\32\21\4\uffff\1\21\1\uffff\32\21",
            "",
            "",
            "\0\32",
            "\0\32",
            "\1\33\4\uffff\1\34",
            "",
            "",
            "\1\36\37\uffff\1\36",
            "",
            "\1\37\37\uffff\1\37",
            "\1\40\37\uffff\1\40",
            "\1\41\37\uffff\1\41",
            "",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\43\37\uffff\1\43",
            "\1\44\37\uffff\1\44",
            "\1\45\37\uffff\1\45",
            "\1\46\37\uffff\1\46",
            "",
            "\1\47\37\uffff\1\47",
            "\1\50\37\uffff\1\50",
            "\1\51\37\uffff\1\51",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "\1\53\37\uffff\1\53",
            "\1\54\37\uffff\1\54",
            "\1\55\37\uffff\1\55",
            "",
            "\1\56\37\uffff\1\56",
            "\1\57\37\uffff\1\57",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "\1\61\37\uffff\1\61",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "",
            "\12\21\7\uffff\32\21\4\uffff\1\21\1\uffff\32\21",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( KEYWORD_8 | KEYWORD_7 | KEYWORD_6 | KEYWORD_5 | KEYWORD_3 | KEYWORD_4 | KEYWORD_1 | KEYWORD_2 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='I'||LA12_0=='i') ) {s = 1;}

                        else if ( (LA12_0=='S'||LA12_0=='s') ) {s = 2;}

                        else if ( (LA12_0=='F'||LA12_0=='f') ) {s = 3;}

                        else if ( (LA12_0==':') ) {s = 4;}

                        else if ( (LA12_0=='T'||LA12_0=='t') ) {s = 5;}

                        else if ( (LA12_0=='.') ) {s = 6;}

                        else if ( (LA12_0==';') ) {s = 7;}

                        else if ( (LA12_0=='^') ) {s = 8;}

                        else if ( ((LA12_0>='A' && LA12_0<='E')||(LA12_0>='G' && LA12_0<='H')||(LA12_0>='J' && LA12_0<='R')||(LA12_0>='U' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='e')||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='r')||(LA12_0>='u' && LA12_0<='z')) ) {s = 9;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 10;}

                        else if ( (LA12_0=='\"') ) {s = 11;}

                        else if ( (LA12_0=='\'') ) {s = 12;}

                        else if ( (LA12_0=='/') ) {s = 13;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 14;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='-')||(LA12_0>='<' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 15;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_11 = input.LA(1);

                        s = -1;
                        if ( ((LA12_11>='\u0000' && LA12_11<='\uFFFF')) ) {s = 26;}

                        else s = 15;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_12 = input.LA(1);

                        s = -1;
                        if ( ((LA12_12>='\u0000' && LA12_12<='\uFFFF')) ) {s = 26;}

                        else s = 15;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
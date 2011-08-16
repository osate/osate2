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
    public static final int RULE_ID=10;
    public static final int RULE_STRING=12;
    public static final int RULE_ANY_OTHER=16;
    public static final int KEYWORD_6=4;
    public static final int KEYWORD_1=9;
    public static final int RULE_INT=11;
    public static final int KEYWORD_5=5;
    public static final int KEYWORD_4=6;
    public static final int KEYWORD_3=7;
    public static final int KEYWORD_2=8;
    public static final int RULE_WS=15;
    public static final int RULE_SL_COMMENT=14;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=13;

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

    // $ANTLR start "KEYWORD_6"
    public final void mKEYWORD_6() throws RecognitionException {
        try {
            int _type = KEYWORD_6;
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
    // $ANTLR end "KEYWORD_6"

    // $ANTLR start "KEYWORD_5"
    public final void mKEYWORD_5() throws RecognitionException {
        try {
            int _type = KEYWORD_5;
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
    // $ANTLR end "KEYWORD_5"

    // $ANTLR start "KEYWORD_4"
    public final void mKEYWORD_4() throws RecognitionException {
        try {
            int _type = KEYWORD_4;
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
    // $ANTLR end "KEYWORD_4"

    // $ANTLR start "KEYWORD_3"
    public final void mKEYWORD_3() throws RecognitionException {
        try {
            int _type = KEYWORD_3;
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
    // $ANTLR end "KEYWORD_3"

    // $ANTLR start "KEYWORD_2"
    public final void mKEYWORD_2() throws RecognitionException {
        try {
            int _type = KEYWORD_2;
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
    // $ANTLR end "KEYWORD_2"

    // $ANTLR start "KEYWORD_1"
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:29:11: ( '.' )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:29:13: '.'
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

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:33:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:33:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:33:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:33:11: '^'
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

            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:33:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:35:10: ( ( '0' .. '9' )+ )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:35:12: ( '0' .. '9' )+
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:35:12: ( '0' .. '9' )+
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
            	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:35:13: '0' .. '9'
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
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:66: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:37:137: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:39:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:39:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:39:24: ( options {greedy=false; } : . )*
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
            	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:39:52: .
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
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:41:41: '\\r'
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
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:43:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:43:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:43:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:45:16: ( . )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:45:18: .
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
        // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:8: ( KEYWORD_6 | KEYWORD_5 | KEYWORD_4 | KEYWORD_3 | KEYWORD_2 | KEYWORD_1 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=13;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:10: KEYWORD_6
                {
                mKEYWORD_6(); 

                }
                break;
            case 2 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:20: KEYWORD_5
                {
                mKEYWORD_5(); 

                }
                break;
            case 3 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:30: KEYWORD_4
                {
                mKEYWORD_4(); 

                }
                break;
            case 4 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:40: KEYWORD_3
                {
                mKEYWORD_3(); 

                }
                break;
            case 5 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:50: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 6 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:60: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 7 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:70: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 8 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:78: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 9 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:87: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 10 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:99: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 11 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:115: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 12 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:131: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 13 :
                // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/lexer/InternalSandboxLexer.g:1:139: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\3\17\1\15\1\uffff\1\15\2\uffff\3\15\2\uffff\1\17\1\uffff"+
        "\3\17\7\uffff\7\17\1\45\3\17\1\uffff\2\17\1\53\1\17\1\55\1\uffff"+
        "\1\56\2\uffff";
    static final String DFA12_eofS =
        "\57\uffff";
    static final String DFA12_minS =
        "\1\0\1\116\1\101\1\122\1\72\1\uffff\1\101\2\uffff\2\0\1\52\2\uffff"+
        "\1\123\1\uffff\1\116\1\123\1\117\7\uffff\1\124\1\104\1\124\1\115"+
        "\1\101\1\102\1\105\1\60\1\116\1\117\1\115\1\uffff\1\103\1\130\1"+
        "\60\1\105\1\60\1\uffff\1\60\2\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\156\1\171\1\162\1\72\1\uffff\1\172\2\uffff\2\uffff\1"+
        "\57\2\uffff\1\163\1\uffff\1\156\1\163\1\157\7\uffff\1\164\1\144"+
        "\1\164\1\155\1\141\1\142\1\145\1\172\1\156\1\157\1\155\1\uffff\1"+
        "\143\1\170\1\172\1\145\1\172\1\uffff\1\172\2\uffff";
    static final String DFA12_acceptS =
        "\5\uffff\1\6\1\uffff\1\7\1\10\3\uffff\1\14\1\15\1\uffff\1\7\3\uffff"+
        "\1\5\1\6\1\10\1\11\1\12\1\13\1\14\13\uffff\1\4\5\uffff\1\3\1\uffff"+
        "\1\2\1\1";
    static final String DFA12_specialS =
        "\1\0\10\uffff\1\2\1\1\44\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\15\2\14\2\15\1\14\22\15\1\14\1\15\1\11\4\15\1\12\6\15\1"+
            "\5\1\13\12\10\1\4\6\15\5\7\1\3\2\7\1\1\11\7\1\2\7\7\3\15\1\6"+
            "\1\7\1\15\5\7\1\3\2\7\1\1\11\7\1\2\7\7\uff85\15",
            "\1\16\37\uffff\1\16",
            "\1\20\27\uffff\1\21\7\uffff\1\20\27\uffff\1\21",
            "\1\22\37\uffff\1\22",
            "\1\23",
            "",
            "\32\17\4\uffff\1\17\1\uffff\32\17",
            "",
            "",
            "\0\26",
            "\0\26",
            "\1\27\4\uffff\1\30",
            "",
            "",
            "\1\32\37\uffff\1\32",
            "",
            "\1\33\37\uffff\1\33",
            "\1\34\37\uffff\1\34",
            "\1\35\37\uffff\1\35",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36\37\uffff\1\36",
            "\1\37\37\uffff\1\37",
            "\1\40\37\uffff\1\40",
            "\1\41\37\uffff\1\41",
            "\1\42\37\uffff\1\42",
            "\1\43\37\uffff\1\43",
            "\1\44\37\uffff\1\44",
            "\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            "\1\46\37\uffff\1\46",
            "\1\47\37\uffff\1\47",
            "\1\50\37\uffff\1\50",
            "",
            "\1\51\37\uffff\1\51",
            "\1\52\37\uffff\1\52",
            "\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            "\1\54\37\uffff\1\54",
            "\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            "",
            "\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
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
            return "1:1: Tokens : ( KEYWORD_6 | KEYWORD_5 | KEYWORD_4 | KEYWORD_3 | KEYWORD_2 | KEYWORD_1 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
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

                        else if ( (LA12_0=='.') ) {s = 5;}

                        else if ( (LA12_0=='^') ) {s = 6;}

                        else if ( ((LA12_0>='A' && LA12_0<='E')||(LA12_0>='G' && LA12_0<='H')||(LA12_0>='J' && LA12_0<='R')||(LA12_0>='T' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='e')||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='r')||(LA12_0>='t' && LA12_0<='z')) ) {s = 7;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 8;}

                        else if ( (LA12_0=='\"') ) {s = 9;}

                        else if ( (LA12_0=='\'') ) {s = 10;}

                        else if ( (LA12_0=='/') ) {s = 11;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 12;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='-')||(LA12_0>=';' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 13;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_10 = input.LA(1);

                        s = -1;
                        if ( ((LA12_10>='\u0000' && LA12_10<='\uFFFF')) ) {s = 22;}

                        else s = 13;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_9 = input.LA(1);

                        s = -1;
                        if ( ((LA12_9>='\u0000' && LA12_9<='\uFFFF')) ) {s = 22;}

                        else s = 13;

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
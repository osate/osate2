package org.osate.categories.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCategoriesLexer extends Lexer {
    public static final int RULE_ID=12;
    public static final int Categories=6;
    public static final int RULE_WS=17;
    public static final int Selection=7;
    public static final int LeftCurlyBracket=10;
    public static final int Verification=4;
    public static final int RULE_STRING=14;
    public static final int RULE_ANY_OTHER=18;
    public static final int RULE_SL_COMMENT=16;
    public static final int Requirement=5;
    public static final int RULE_INT=13;
    public static final int RULE_ML_COMMENT=15;
    public static final int LeftSquareBracket=8;
    public static final int RightCurlyBracket=11;
    public static final int EOF=-1;
    public static final int RightSquareBracket=9;

    // delegates
    // delegators

    public InternalCategoriesLexer() {;} 
    public InternalCategoriesLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCategoriesLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g"; }

    // $ANTLR start "Verification"
    public final void mVerification() throws RecognitionException {
        try {
            int _type = Verification;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:19:14: ( ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:19:16: ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
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

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
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

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "Verification"

    // $ANTLR start "Requirement"
    public final void mRequirement() throws RecognitionException {
        try {
            int _type = Requirement;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:21:13: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:21:15: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
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

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "Requirement"

    // $ANTLR start "Categories"
    public final void mCategories() throws RecognitionException {
        try {
            int _type = Categories;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:23:12: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:23:14: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
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

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
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

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "Categories"

    // $ANTLR start "Selection"
    public final void mSelection() throws RecognitionException {
        try {
            int _type = Selection;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:25:11: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:25:13: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
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

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "Selection"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:27:19: ( '[' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:27:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:29:20: ( ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:29:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:31:18: ( '{' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:31:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:33:19: ( '}' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:33:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:37:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:37:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:37:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:37:11: '^'
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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:37:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:39:10: ( ( '0' .. '9' )+ )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:39:12: ( '0' .. '9' )+
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:39:12: ( '0' .. '9' )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:39:13: '0' .. '9'
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:43:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:43:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:43:24: ( options {greedy=false; } : . )*
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:43:52: .
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:45:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:45:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:45:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:45:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:45:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:45:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:45:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:45:41: '\\r'
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:47:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:47:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:47:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:49:16: ( . )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:49:18: .
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
        // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:8: ( Verification | Requirement | Categories | Selection | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=15;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:10: Verification
                {
                mVerification(); 

                }
                break;
            case 2 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:23: Requirement
                {
                mRequirement(); 

                }
                break;
            case 3 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:35: Categories
                {
                mCategories(); 

                }
                break;
            case 4 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:46: Selection
                {
                mSelection(); 

                }
                break;
            case 5 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:56: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 6 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:74: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 7 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:93: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 8 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:110: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 9 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:128: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 10 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:136: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 11 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:145: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 12 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:157: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 13 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:173: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 14 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:189: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 15 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:197: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\4\22\4\uffff\1\20\2\uffff\3\20\2\uffff\1\22\1\uffff\3"+
        "\22\11\uffff\33\22\1\76\2\22\1\101\1\uffff\1\22\1\103\1\uffff\1"+
        "\104\2\uffff";
    static final String DFA12_eofS =
        "\105\uffff";
    static final String DFA12_minS =
        "\1\0\2\105\1\101\1\105\4\uffff\1\101\2\uffff\2\0\1\52\2\uffff\1"+
        "\122\1\uffff\1\121\1\124\1\114\11\uffff\1\111\1\125\2\105\1\106"+
        "\1\111\1\107\1\103\1\111\1\122\1\117\1\124\1\103\1\105\1\122\1\111"+
        "\1\101\1\115\1\111\1\117\1\124\2\105\1\116\1\111\1\116\1\123\1\60"+
        "\1\117\1\124\1\60\1\uffff\1\116\1\60\1\uffff\1\60\2\uffff";
    static final String DFA12_maxS =
        "\1\uffff\2\145\1\141\1\145\4\uffff\1\172\2\uffff\2\uffff\1\57\2"+
        "\uffff\1\162\1\uffff\1\161\1\164\1\154\11\uffff\1\151\1\165\2\145"+
        "\1\146\1\151\1\147\1\143\1\151\1\162\1\157\1\164\1\143\1\145\1\162"+
        "\1\151\1\141\1\155\1\151\1\157\1\164\2\145\1\156\1\151\1\156\1\163"+
        "\1\172\1\157\1\164\1\172\1\uffff\1\156\1\172\1\uffff\1\172\2\uffff";
    static final String DFA12_acceptS =
        "\5\uffff\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12\3\uffff\1\16\1\17\1"+
        "\uffff\1\11\3\uffff\1\5\1\6\1\7\1\10\1\12\1\13\1\14\1\15\1\16\37"+
        "\uffff\1\4\2\uffff\1\3\1\uffff\1\2\1\1";
    static final String DFA12_specialS =
        "\1\2\13\uffff\1\0\1\1\67\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\20\2\17\2\20\1\17\22\20\1\17\1\20\1\14\4\20\1\15\7\20\1"+
            "\16\12\13\7\20\2\12\1\3\16\12\1\2\1\4\2\12\1\1\4\12\1\5\1\20"+
            "\1\6\1\11\1\12\1\20\2\12\1\3\16\12\1\2\1\4\2\12\1\1\4\12\1\7"+
            "\1\20\1\10\uff82\20",
            "\1\21\37\uffff\1\21",
            "\1\23\37\uffff\1\23",
            "\1\24\37\uffff\1\24",
            "\1\25\37\uffff\1\25",
            "",
            "",
            "",
            "",
            "\32\22\4\uffff\1\22\1\uffff\32\22",
            "",
            "",
            "\0\33",
            "\0\33",
            "\1\34\4\uffff\1\35",
            "",
            "",
            "\1\37\37\uffff\1\37",
            "",
            "\1\40\37\uffff\1\40",
            "\1\41\37\uffff\1\41",
            "\1\42\37\uffff\1\42",
            "",
            "",
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
            "\1\47\37\uffff\1\47",
            "\1\50\37\uffff\1\50",
            "\1\51\37\uffff\1\51",
            "\1\52\37\uffff\1\52",
            "\1\53\37\uffff\1\53",
            "\1\54\37\uffff\1\54",
            "\1\55\37\uffff\1\55",
            "\1\56\37\uffff\1\56",
            "\1\57\37\uffff\1\57",
            "\1\60\37\uffff\1\60",
            "\1\61\37\uffff\1\61",
            "\1\62\37\uffff\1\62",
            "\1\63\37\uffff\1\63",
            "\1\64\37\uffff\1\64",
            "\1\65\37\uffff\1\65",
            "\1\66\37\uffff\1\66",
            "\1\67\37\uffff\1\67",
            "\1\70\37\uffff\1\70",
            "\1\71\37\uffff\1\71",
            "\1\72\37\uffff\1\72",
            "\1\73\37\uffff\1\73",
            "\1\74\37\uffff\1\74",
            "\1\75\37\uffff\1\75",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "\1\77\37\uffff\1\77",
            "\1\100\37\uffff\1\100",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "",
            "\1\102\37\uffff\1\102",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
            "",
            "\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
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
            return "1:1: Tokens : ( Verification | Requirement | Categories | Selection | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_12 = input.LA(1);

                        s = -1;
                        if ( ((LA12_12>='\u0000' && LA12_12<='\uFFFF')) ) {s = 27;}

                        else s = 16;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_13 = input.LA(1);

                        s = -1;
                        if ( ((LA12_13>='\u0000' && LA12_13<='\uFFFF')) ) {s = 27;}

                        else s = 16;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='V'||LA12_0=='v') ) {s = 1;}

                        else if ( (LA12_0=='R'||LA12_0=='r') ) {s = 2;}

                        else if ( (LA12_0=='C'||LA12_0=='c') ) {s = 3;}

                        else if ( (LA12_0=='S'||LA12_0=='s') ) {s = 4;}

                        else if ( (LA12_0=='[') ) {s = 5;}

                        else if ( (LA12_0==']') ) {s = 6;}

                        else if ( (LA12_0=='{') ) {s = 7;}

                        else if ( (LA12_0=='}') ) {s = 8;}

                        else if ( (LA12_0=='^') ) {s = 9;}

                        else if ( ((LA12_0>='A' && LA12_0<='B')||(LA12_0>='D' && LA12_0<='Q')||(LA12_0>='T' && LA12_0<='U')||(LA12_0>='W' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='b')||(LA12_0>='d' && LA12_0<='q')||(LA12_0>='t' && LA12_0<='u')||(LA12_0>='w' && LA12_0<='z')) ) {s = 10;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 11;}

                        else if ( (LA12_0=='\"') ) {s = 12;}

                        else if ( (LA12_0=='\'') ) {s = 13;}

                        else if ( (LA12_0=='/') ) {s = 14;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 15;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 16;}

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
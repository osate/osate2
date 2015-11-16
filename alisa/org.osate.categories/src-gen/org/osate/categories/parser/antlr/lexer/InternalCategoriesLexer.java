package org.osate.categories.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
@SuppressWarnings("all")
public class InternalCategoriesLexer extends Lexer {
    public static final int Category=8;
    public static final int Phase=12;
    public static final int Selection=7;
    public static final int RULE_STRING=19;
    public static final int RULE_SL_COMMENT=21;
    public static final int Filters=9;
    public static final int Quality=10;
    public static final int RightCurlyBracket=16;
    public static final int Component=6;
    public static final int EOF=-1;
    public static final int RightSquareBracket=14;
    public static final int RULE_ID=17;
    public static final int Categories=5;
    public static final int RULE_WS=22;
    public static final int LeftCurlyBracket=15;
    public static final int Method=11;
    public static final int RULE_ANY_OTHER=23;
    public static final int Requirement=4;
    public static final int RULE_INT=18;
    public static final int RULE_ML_COMMENT=20;
    public static final int LeftSquareBracket=13;

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

    // $ANTLR start "Requirement"
    public final void mRequirement() throws RecognitionException {
        try {
            int _type = Requirement;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:31:13: ( 'requirement' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:31:15: 'requirement'
            {
            match("requirement"); 


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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:33:12: ( 'categories' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:33:14: 'categories'
            {
            match("categories"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Categories"

    // $ANTLR start "Component"
    public final void mComponent() throws RecognitionException {
        try {
            int _type = Component;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:35:11: ( 'component' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:35:13: 'component'
            {
            match("component"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Component"

    // $ANTLR start "Selection"
    public final void mSelection() throws RecognitionException {
        try {
            int _type = Selection;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:37:11: ( 'selection' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:37:13: 'selection'
            {
            match("selection"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Selection"

    // $ANTLR start "Category"
    public final void mCategory() throws RecognitionException {
        try {
            int _type = Category;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:39:10: ( 'category' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:39:12: 'category'
            {
            match("category"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Category"

    // $ANTLR start "Filters"
    public final void mFilters() throws RecognitionException {
        try {
            int _type = Filters;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:9: ( 'filters' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:41:11: 'filters'
            {
            match("filters"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Filters"

    // $ANTLR start "Quality"
    public final void mQuality() throws RecognitionException {
        try {
            int _type = Quality;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:43:9: ( 'quality' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:43:11: 'quality'
            {
            match("quality"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Quality"

    // $ANTLR start "Method"
    public final void mMethod() throws RecognitionException {
        try {
            int _type = Method;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:45:8: ( 'method' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:45:10: 'method'
            {
            match("method"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Method"

    // $ANTLR start "Phase"
    public final void mPhase() throws RecognitionException {
        try {
            int _type = Phase;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:47:7: ( 'phase' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:47:9: 'phase'
            {
            match("phase"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Phase"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:49:19: ( '[' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:49:21: '['
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:51:20: ( ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:51:22: ']'
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:53:18: ( '{' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:53:20: '{'
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:55:19: ( '}' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:55:21: '}'
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:59:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:59:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:59:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:59:11: '^'
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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:59:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:61:10: ( ( '0' .. '9' )+ )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:61:12: ( '0' .. '9' )+
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:61:12: ( '0' .. '9' )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:61:13: '0' .. '9'
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:63:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:63:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:63:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:63:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:63:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:63:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:63:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:63:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:63:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:63:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:63:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:65:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:65:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:65:24: ( options {greedy=false; } : . )*
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:65:52: .
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:67:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:67:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:67:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:67:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:67:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:67:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:67:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:67:41: '\\r'
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:69:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:69:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:69:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:71:16: ( . )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:71:18: .
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
        // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:8: ( Requirement | Categories | Component | Selection | Category | Filters | Quality | Method | Phase | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=20;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:10: Requirement
                {
                mRequirement(); 

                }
                break;
            case 2 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:22: Categories
                {
                mCategories(); 

                }
                break;
            case 3 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:33: Component
                {
                mComponent(); 

                }
                break;
            case 4 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:43: Selection
                {
                mSelection(); 

                }
                break;
            case 5 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:53: Category
                {
                mCategory(); 

                }
                break;
            case 6 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:62: Filters
                {
                mFilters(); 

                }
                break;
            case 7 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:70: Quality
                {
                mQuality(); 

                }
                break;
            case 8 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:78: Method
                {
                mMethod(); 

                }
                break;
            case 9 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:85: Phase
                {
                mPhase(); 

                }
                break;
            case 10 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:91: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 11 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:109: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 12 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:128: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 13 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:145: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 14 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:163: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 15 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:171: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 16 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:180: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 17 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:192: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 18 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:208: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 19 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:224: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 20 :
                // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/lexer/InternalCategoriesLexer.g:1:232: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\7\25\4\uffff\1\23\2\uffff\3\23\2\uffff\1\25\1\uffff\7\25\11\uffff\27\25\1\105\6\25\1\114\1\uffff\4\25\1\122\1\123\1\uffff\2\25\1\126\2\25\2\uffff\2\25\1\uffff\1\133\1\134\1\25\1\136\2\uffff\1\137\2\uffff";
    static final String DFA12_eofS =
        "\140\uffff";
    static final String DFA12_minS =
        "\1\0\1\145\1\141\1\145\1\151\1\165\1\145\1\150\4\uffff\1\101\2\uffff\2\0\1\52\2\uffff\1\161\1\uffff\1\164\1\155\2\154\1\141\1\164\1\141\11\uffff\1\165\1\145\1\160\1\145\1\164\1\154\1\150\1\163\1\151\1\147\1\157\1\143\1\145\1\151\1\157\1\145\1\162\1\157\1\156\1\164\1\162\1\164\1\144\1\60\1\145\1\162\1\145\1\151\1\163\1\171\1\60\1\uffff\1\155\1\151\1\156\1\157\2\60\1\uffff\2\145\1\60\1\164\1\156\2\uffff\1\156\1\163\1\uffff\2\60\1\164\1\60\2\uffff\1\60\2\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\145\1\157\1\145\1\151\1\165\1\145\1\150\4\uffff\1\172\2\uffff\2\uffff\1\57\2\uffff\1\161\1\uffff\1\164\1\155\2\154\1\141\1\164\1\141\11\uffff\1\165\1\145\1\160\1\145\1\164\1\154\1\150\1\163\1\151\1\147\1\157\1\143\1\145\1\151\1\157\1\145\1\162\1\157\1\156\1\164\1\162\1\164\1\144\1\172\1\145\1\162\1\145\1\151\1\163\1\171\1\172\1\uffff\1\155\1\171\1\156\1\157\2\172\1\uffff\2\145\1\172\1\164\1\156\2\uffff\1\156\1\163\1\uffff\2\172\1\164\1\172\2\uffff\1\172\2\uffff";
    static final String DFA12_acceptS =
        "\10\uffff\1\12\1\13\1\14\1\15\1\uffff\1\16\1\17\3\uffff\1\23\1\24\1\uffff\1\16\7\uffff\1\12\1\13\1\14\1\15\1\17\1\20\1\21\1\22\1\23\37\uffff\1\11\6\uffff\1\10\5\uffff\1\6\1\7\2\uffff\1\5\4\uffff\1\3\1\4\1\uffff\1\2\1\1";
    static final String DFA12_specialS =
        "\1\1\16\uffff\1\2\1\0\117\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\23\2\22\2\23\1\22\22\23\1\22\1\23\1\17\4\23\1\20\7\23\1\21\12\16\7\23\32\15\1\10\1\23\1\11\1\14\1\15\1\23\2\15\1\2\2\15\1\4\6\15\1\6\2\15\1\7\1\5\1\1\1\3\7\15\1\12\1\23\1\13\uff82\23",
            "\1\24",
            "\1\26\15\uffff\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "",
            "",
            "",
            "",
            "\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "\0\42",
            "\0\42",
            "\1\43\4\uffff\1\44",
            "",
            "",
            "\1\46",
            "",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\115",
            "\1\116\17\uffff\1\117",
            "\1\120",
            "\1\121",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\124",
            "\1\125",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\127",
            "\1\130",
            "",
            "",
            "\1\131",
            "\1\132",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\135",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
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
            return "1:1: Tokens : ( Requirement | Categories | Component | Selection | Category | Filters | Quality | Method | Phase | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_16 = input.LA(1);

                        s = -1;
                        if ( ((LA12_16>='\u0000' && LA12_16<='\uFFFF')) ) {s = 34;}

                        else s = 19;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='r') ) {s = 1;}

                        else if ( (LA12_0=='c') ) {s = 2;}

                        else if ( (LA12_0=='s') ) {s = 3;}

                        else if ( (LA12_0=='f') ) {s = 4;}

                        else if ( (LA12_0=='q') ) {s = 5;}

                        else if ( (LA12_0=='m') ) {s = 6;}

                        else if ( (LA12_0=='p') ) {s = 7;}

                        else if ( (LA12_0=='[') ) {s = 8;}

                        else if ( (LA12_0==']') ) {s = 9;}

                        else if ( (LA12_0=='{') ) {s = 10;}

                        else if ( (LA12_0=='}') ) {s = 11;}

                        else if ( (LA12_0=='^') ) {s = 12;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='b')||(LA12_0>='d' && LA12_0<='e')||(LA12_0>='g' && LA12_0<='l')||(LA12_0>='n' && LA12_0<='o')||(LA12_0>='t' && LA12_0<='z')) ) {s = 13;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 14;}

                        else if ( (LA12_0=='\"') ) {s = 15;}

                        else if ( (LA12_0=='\'') ) {s = 16;}

                        else if ( (LA12_0=='/') ) {s = 17;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 18;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 19;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_15 = input.LA(1);

                        s = -1;
                        if ( ((LA12_15>='\u0000' && LA12_15<='\uFFFF')) ) {s = 34;}

                        else s = 19;

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
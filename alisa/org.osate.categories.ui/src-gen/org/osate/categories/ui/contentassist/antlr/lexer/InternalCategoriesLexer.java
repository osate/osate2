package org.osate.categories.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


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
    public static final int Category=4;
    public static final int Phase=6;
    public static final int RULE_ID=10;
    public static final int RULE_WS=15;
    public static final int RULE_STRING=12;
    public static final int RULE_ANY_OTHER=16;
    public static final int Any=7;
    public static final int RULE_SL_COMMENT=14;
    public static final int Quality=5;
    public static final int RULE_INT=11;
    public static final int RULE_ML_COMMENT=13;
    public static final int LeftSquareBracket=8;
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
    public String getGrammarFileName() { return "../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g"; }

    // $ANTLR start "Category"
    public final void mCategory() throws RecognitionException {
        try {
            int _type = Category;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:31:10: ( 'category' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:31:12: 'category'
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

    // $ANTLR start "Quality"
    public final void mQuality() throws RecognitionException {
        try {
            int _type = Quality;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:33:9: ( 'quality' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:33:11: 'quality'
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

    // $ANTLR start "Phase"
    public final void mPhase() throws RecognitionException {
        try {
            int _type = Phase;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:35:7: ( 'phase' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:35:9: 'phase'
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

    // $ANTLR start "Any"
    public final void mAny() throws RecognitionException {
        try {
            int _type = Any;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:37:5: ( 'any' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:37:7: 'any'
            {
            match("any"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Any"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:39:19: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:39:21: '['
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:41:20: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:41:22: ']'
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

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:45:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:45:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:45:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:45:11: '^'
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

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:45:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:47:10: ( ( '0' .. '9' )+ )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:47:12: ( '0' .. '9' )+
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:47:12: ( '0' .. '9' )+
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
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:47:13: '0' .. '9'
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:51:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:51:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:51:24: ( options {greedy=false; } : . )*
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
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:51:52: .
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:53:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:53:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:53:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:53:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:53:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:53:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:53:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:53:41: '\\r'
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:55:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:55:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:55:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:57:16: ( . )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:57:18: .
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
        // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:8: ( Category | Quality | Phase | Any | LeftSquareBracket | RightSquareBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=13;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:10: Category
                {
                mCategory(); 

                }
                break;
            case 2 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:19: Quality
                {
                mQuality(); 

                }
                break;
            case 3 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:27: Phase
                {
                mPhase(); 

                }
                break;
            case 4 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:33: Any
                {
                mAny(); 

                }
                break;
            case 5 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:37: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 6 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:55: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 7 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:74: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 8 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:82: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 9 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:91: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 10 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:103: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 11 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:119: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 12 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:135: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 13 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:143: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\4\20\2\uffff\1\16\2\uffff\3\16\2\uffff\1\20\1\uffff\3"+
        "\20\7\uffff\3\20\1\42\3\20\1\uffff\2\20\1\50\2\20\1\uffff\1\20\1"+
        "\54\1\55\2\uffff";
    static final String DFA12_eofS =
        "\56\uffff";
    static final String DFA12_minS =
        "\1\0\1\141\1\165\1\150\1\156\2\uffff\1\101\2\uffff\2\0\1\52\2\uffff"+
        "\1\164\1\uffff\2\141\1\171\7\uffff\1\145\1\154\1\163\1\60\1\147"+
        "\1\151\1\145\1\uffff\1\157\1\164\1\60\1\162\1\171\1\uffff\1\171"+
        "\2\60\2\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\141\1\165\1\150\1\156\2\uffff\1\172\2\uffff\2\uffff"+
        "\1\57\2\uffff\1\164\1\uffff\2\141\1\171\7\uffff\1\145\1\154\1\163"+
        "\1\172\1\147\1\151\1\145\1\uffff\1\157\1\164\1\172\1\162\1\171\1"+
        "\uffff\1\171\2\172\2\uffff";
    static final String DFA12_acceptS =
        "\5\uffff\1\5\1\6\1\uffff\1\7\1\10\3\uffff\1\14\1\15\1\uffff\1\7"+
        "\3\uffff\1\5\1\6\1\10\1\11\1\12\1\13\1\14\7\uffff\1\4\5\uffff\1"+
        "\3\3\uffff\1\2\1\1";
    static final String DFA12_specialS =
        "\1\0\11\uffff\1\2\1\1\42\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\16\2\15\2\16\1\15\22\16\1\15\1\16\1\12\4\16\1\13\7\16\1"+
            "\14\12\11\7\16\32\10\1\5\1\16\1\6\1\7\1\10\1\16\1\4\1\10\1\1"+
            "\14\10\1\3\1\2\11\10\uff85\16",
            "\1\17",
            "\1\21",
            "\1\22",
            "\1\23",
            "",
            "",
            "\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "",
            "\0\27",
            "\0\27",
            "\1\30\4\uffff\1\31",
            "",
            "",
            "\1\33",
            "",
            "\1\34",
            "\1\35",
            "\1\36",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\37",
            "\1\40",
            "\1\41",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\43",
            "\1\44",
            "\1\45",
            "",
            "\1\46",
            "\1\47",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\51",
            "\1\52",
            "",
            "\1\53",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
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
            return "1:1: Tokens : ( Category | Quality | Phase | Any | LeftSquareBracket | RightSquareBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='c') ) {s = 1;}

                        else if ( (LA12_0=='q') ) {s = 2;}

                        else if ( (LA12_0=='p') ) {s = 3;}

                        else if ( (LA12_0=='a') ) {s = 4;}

                        else if ( (LA12_0=='[') ) {s = 5;}

                        else if ( (LA12_0==']') ) {s = 6;}

                        else if ( (LA12_0=='^') ) {s = 7;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||(LA12_0>='d' && LA12_0<='o')||(LA12_0>='r' && LA12_0<='z')) ) {s = 8;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 9;}

                        else if ( (LA12_0=='\"') ) {s = 10;}

                        else if ( (LA12_0=='\'') ) {s = 11;}

                        else if ( (LA12_0=='/') ) {s = 12;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 13;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 14;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_11 = input.LA(1);

                        s = -1;
                        if ( ((LA12_11>='\u0000' && LA12_11<='\uFFFF')) ) {s = 23;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_10 = input.LA(1);

                        s = -1;
                        if ( ((LA12_10>='\u0000' && LA12_10<='\uFFFF')) ) {s = 23;}

                        else s = 14;

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
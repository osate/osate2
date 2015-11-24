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
    public static final int Phase=10;
    public static final int User=12;
    public static final int Attribute=6;
    public static final int Selection=7;
    public static final int RULE_STRING=18;
    public static final int Any=13;
    public static final int RULE_SL_COMMENT=20;
    public static final int Quality=8;
    public static final int Development=4;
    public static final int EOF=-1;
    public static final int RightSquareBracket=15;
    public static final int RULE_ID=16;
    public static final int RULE_WS=21;
    public static final int Method=9;
    public static final int RULE_ANY_OTHER=22;
    public static final int Requirement=5;
    public static final int Type=11;
    public static final int RULE_INT=17;
    public static final int RULE_ML_COMMENT=19;
    public static final int LeftSquareBracket=14;

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

    // $ANTLR start "Development"
    public final void mDevelopment() throws RecognitionException {
        try {
            int _type = Development;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:31:13: ( 'development' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:31:15: 'development'
            {
            match("development"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Development"

    // $ANTLR start "Requirement"
    public final void mRequirement() throws RecognitionException {
        try {
            int _type = Requirement;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:33:13: ( 'requirement' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:33:15: 'requirement'
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

    // $ANTLR start "Attribute"
    public final void mAttribute() throws RecognitionException {
        try {
            int _type = Attribute;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:35:11: ( 'attribute' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:35:13: 'attribute'
            {
            match("attribute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Attribute"

    // $ANTLR start "Selection"
    public final void mSelection() throws RecognitionException {
        try {
            int _type = Selection;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:37:11: ( 'selection' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:37:13: 'selection'
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

    // $ANTLR start "Quality"
    public final void mQuality() throws RecognitionException {
        try {
            int _type = Quality;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:39:9: ( 'quality' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:39:11: 'quality'
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:41:8: ( 'method' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:41:10: 'method'
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:43:7: ( 'phase' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:43:9: 'phase'
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

    // $ANTLR start "Type"
    public final void mType() throws RecognitionException {
        try {
            int _type = Type;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:45:6: ( 'type' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:45:8: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Type"

    // $ANTLR start "User"
    public final void mUser() throws RecognitionException {
        try {
            int _type = User;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:47:6: ( 'user' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:47:8: 'user'
            {
            match("user"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "User"

    // $ANTLR start "Any"
    public final void mAny() throws RecognitionException {
        try {
            int _type = Any;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:5: ( 'any' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:49:7: 'any'
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:51:19: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:51:21: '['
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:53:20: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:53:22: ']'
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:57:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:57:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:57:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:57:11: '^'
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

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:57:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:59:10: ( ( '0' .. '9' )+ )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:59:12: ( '0' .. '9' )+
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:59:12: ( '0' .. '9' )+
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
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:59:13: '0' .. '9'
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:61:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:61:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:61:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:61:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:61:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:61:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:61:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:61:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:61:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:61:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:61:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:63:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:63:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:63:24: ( options {greedy=false; } : . )*
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
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:63:52: .
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:65:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:65:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:65:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:65:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:65:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:65:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:65:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:65:41: '\\r'
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:67:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:67:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:67:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:69:16: ( . )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:69:18: .
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
        // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:8: ( Development | Requirement | Attribute | Selection | Quality | Method | Phase | Type | User | Any | LeftSquareBracket | RightSquareBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=19;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:10: Development
                {
                mDevelopment(); 

                }
                break;
            case 2 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:22: Requirement
                {
                mRequirement(); 

                }
                break;
            case 3 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:34: Attribute
                {
                mAttribute(); 

                }
                break;
            case 4 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:44: Selection
                {
                mSelection(); 

                }
                break;
            case 5 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:54: Quality
                {
                mQuality(); 

                }
                break;
            case 6 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:62: Method
                {
                mMethod(); 

                }
                break;
            case 7 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:69: Phase
                {
                mPhase(); 

                }
                break;
            case 8 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:75: Type
                {
                mType(); 

                }
                break;
            case 9 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:80: User
                {
                mUser(); 

                }
                break;
            case 10 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:85: Any
                {
                mAny(); 

                }
                break;
            case 11 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:89: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 12 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:107: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 13 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:126: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 14 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:134: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 15 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:143: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 16 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:155: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 17 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:171: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 18 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:187: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 19 :
                // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/lexer/InternalCategoriesLexer.g:1:195: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\11\25\2\uffff\1\23\2\uffff\3\23\2\uffff\1\25\1\uffff\11"+
        "\25\7\uffff\3\25\1\63\11\25\1\uffff\4\25\1\101\1\102\6\25\1\111"+
        "\2\uffff\5\25\1\117\1\uffff\4\25\1\124\1\uffff\4\25\1\uffff\2\25"+
        "\1\133\1\134\2\25\2\uffff\1\137\1\140\2\uffff";
    static final String DFA12_eofS =
        "\141\uffff";
    static final String DFA12_minS =
        "\1\0\2\145\1\156\1\145\1\165\1\145\1\150\1\171\1\163\2\uffff\1"+
        "\101\2\uffff\2\0\1\52\2\uffff\1\166\1\uffff\1\161\1\164\1\171\1"+
        "\154\1\141\1\164\1\141\1\160\1\145\7\uffff\1\145\1\165\1\162\1\60"+
        "\1\145\1\154\1\150\1\163\1\145\1\162\1\154\2\151\1\uffff\1\143\1"+
        "\151\1\157\1\145\2\60\1\157\1\162\1\142\2\164\1\144\1\60\2\uffff"+
        "\1\160\1\145\1\165\1\151\1\171\1\60\1\uffff\2\155\1\164\1\157\1"+
        "\60\1\uffff\3\145\1\156\1\uffff\2\156\2\60\2\164\2\uffff\2\60\2"+
        "\uffff";
    static final String DFA12_maxS =
        "\1\uffff\2\145\1\164\1\145\1\165\1\145\1\150\1\171\1\163\2\uffff"+
        "\1\172\2\uffff\2\uffff\1\57\2\uffff\1\166\1\uffff\1\161\1\164\1"+
        "\171\1\154\1\141\1\164\1\141\1\160\1\145\7\uffff\1\145\1\165\1\162"+
        "\1\172\1\145\1\154\1\150\1\163\1\145\1\162\1\154\2\151\1\uffff\1"+
        "\143\1\151\1\157\1\145\2\172\1\157\1\162\1\142\2\164\1\144\1\172"+
        "\2\uffff\1\160\1\145\1\165\1\151\1\171\1\172\1\uffff\2\155\1\164"+
        "\1\157\1\172\1\uffff\3\145\1\156\1\uffff\2\156\2\172\2\164\2\uffff"+
        "\2\172\2\uffff";
    static final String DFA12_acceptS =
        "\12\uffff\1\13\1\14\1\uffff\1\15\1\16\3\uffff\1\22\1\23\1\uffff"+
        "\1\15\11\uffff\1\13\1\14\1\16\1\17\1\20\1\21\1\22\15\uffff\1\12"+
        "\15\uffff\1\10\1\11\6\uffff\1\7\5\uffff\1\6\4\uffff\1\5\6\uffff"+
        "\1\3\1\4\2\uffff\1\1\1\2";
    static final String DFA12_specialS =
        "\1\1\16\uffff\1\2\1\0\120\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\23\2\22\2\23\1\22\22\23\1\22\1\23\1\17\4\23\1\20\7\23\1"+
            "\21\12\16\7\23\32\15\1\12\1\23\1\13\1\14\1\15\1\23\1\3\2\15"+
            "\1\1\10\15\1\6\2\15\1\7\1\5\1\2\1\4\1\10\1\11\5\15\uff85\23",
            "\1\24",
            "\1\26",
            "\1\30\5\uffff\1\27",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
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
            "\1\56",
            "\1\57",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "",
            "\1\131",
            "\1\132",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\135",
            "\1\136",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
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
            return "1:1: Tokens : ( Development | Requirement | Attribute | Selection | Quality | Method | Phase | Type | User | Any | LeftSquareBracket | RightSquareBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
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
                        if ( (LA12_0=='d') ) {s = 1;}

                        else if ( (LA12_0=='r') ) {s = 2;}

                        else if ( (LA12_0=='a') ) {s = 3;}

                        else if ( (LA12_0=='s') ) {s = 4;}

                        else if ( (LA12_0=='q') ) {s = 5;}

                        else if ( (LA12_0=='m') ) {s = 6;}

                        else if ( (LA12_0=='p') ) {s = 7;}

                        else if ( (LA12_0=='t') ) {s = 8;}

                        else if ( (LA12_0=='u') ) {s = 9;}

                        else if ( (LA12_0=='[') ) {s = 10;}

                        else if ( (LA12_0==']') ) {s = 11;}

                        else if ( (LA12_0=='^') ) {s = 12;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='b' && LA12_0<='c')||(LA12_0>='e' && LA12_0<='l')||(LA12_0>='n' && LA12_0<='o')||(LA12_0>='v' && LA12_0<='z')) ) {s = 13;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 14;}

                        else if ( (LA12_0=='\"') ) {s = 15;}

                        else if ( (LA12_0=='\'') ) {s = 16;}

                        else if ( (LA12_0=='/') ) {s = 17;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 18;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 19;}

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
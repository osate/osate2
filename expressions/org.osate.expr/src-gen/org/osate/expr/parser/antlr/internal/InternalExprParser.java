package org.osate.expr.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.expr.services.ExprGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
@SuppressWarnings("all")
public class InternalExprParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Classifier", "Connection", "Subprogram", "Component", "Processor", "Reference", "Subclause", "Abstract", "Constant", "Property", "Applies", "Binding", "Compute", "Element", "Feature", "Library", "Process", "Virtual", "Assert", "Device", "Memory", "Record", "String", "KW_System", "Thread", "Delta", "Endif", "False", "Group", "Modes", "Range", "Tuple", "Union", "Bool", "Data", "Else", "Enum", "Flow", "Java", "List", "Mode", "Real", "Root", "Then", "True", "Type", "PlusSignEqualsSignGreaterThanSign", "And", "Bag", "Bus", "Def", "Div", "Int", "Map", "Mod", "Not", "Set", "Val", "Var", "ExclamationMarkEqualsSign", "AmpersandAmpersand", "HyphenMinusGreaterThanSign", "FullStopFullStop", "ColonColon", "LessThanSignEqualsSign", "EqualsSignEqualsSign", "EqualsSignGreaterThanSign", "GreaterThanSignLessThanSign", "GreaterThanSignEqualsSign", "If", "In", "Of", "Or", "To", "VerticalLineVerticalLine", "NumberSign", "PercentSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "CircumflexAccent", "LeftCurlyBracket", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int Enum=40;
    public static final int Val=61;
    public static final int Or=76;
    public static final int EqualsSignGreaterThanSign=70;
    public static final int Memory=24;
    public static final int KW_System=27;
    public static final int Var=62;
    public static final int String=26;
    public static final int False=31;
    public static final int Feature=18;
    public static final int LessThanSign=91;
    public static final int Assert=22;
    public static final int PlusSignEqualsSignGreaterThanSign=50;
    public static final int LeftParenthesis=81;
    public static final int Bool=37;
    public static final int Then=47;
    public static final int GreaterThanSign=93;
    public static final int Root=46;
    public static final int RULE_ID=108;
    public static final int RULE_DIGIT=100;
    public static final int GreaterThanSignEqualsSign=72;
    public static final int ColonColon=67;
    public static final int EqualsSignEqualsSign=69;
    public static final int PlusSign=84;
    public static final int LeftSquareBracket=94;
    public static final int Map=57;
    public static final int If=73;
    public static final int Group=32;
    public static final int Processor=8;
    public static final int Set=60;
    public static final int In=74;
    public static final int VerticalLineVerticalLine=78;
    public static final int RULE_REAL_LIT=103;
    public static final int Classifier=4;
    public static final int GreaterThanSignLessThanSign=71;
    public static final int Union=36;
    public static final int Comma=85;
    public static final int HyphenMinus=86;
    public static final int LessThanSignEqualsSign=68;
    public static final int Solidus=88;
    public static final int RightCurlyBracket=98;
    public static final int Property=13;
    public static final int Modes=33;
    public static final int Java=42;
    public static final int Bus=53;
    public static final int FullStop=87;
    public static final int Reference=9;
    public static final int Abstract=11;
    public static final int Connection=5;
    public static final int Thread=28;
    public static final int Flow=41;
    public static final int Div=55;
    public static final int Semicolon=90;
    public static final int Type=49;
    public static final int RULE_EXPONENT=101;
    public static final int Delta=29;
    public static final int Else=39;
    public static final int RULE_EXTENDED_DIGIT=106;
    public static final int ExclamationMarkEqualsSign=63;
    public static final int HyphenMinusGreaterThanSign=65;
    public static final int Tuple=35;
    public static final int True=48;
    public static final int Process=20;
    public static final int RULE_INT_EXPONENT=102;
    public static final int PercentSign=80;
    public static final int FullStopFullStop=66;
    public static final int Real=45;
    public static final int List=43;
    public static final int To=77;
    public static final int Applies=14;
    public static final int RULE_BASED_INTEGER=104;
    public static final int RightSquareBracket=95;
    public static final int Binding=15;
    public static final int Device=23;
    public static final int RightParenthesis=82;
    public static final int Range=34;
    public static final int Not=59;
    public static final int And=51;
    public static final int NumberSign=79;
    public static final int Library=19;
    public static final int Subprogram=6;
    public static final int RULE_INTEGER_LIT=105;
    public static final int Subclause=10;
    public static final int Constant=12;
    public static final int Element=17;
    public static final int RULE_STRING=107;
    public static final int Int=56;
    public static final int RULE_SL_COMMENT=99;
    public static final int EqualsSign=92;
    public static final int AmpersandAmpersand=64;
    public static final int Record=25;
    public static final int Colon=89;
    public static final int Component=7;
    public static final int EOF=-1;
    public static final int Asterisk=83;
    public static final int Mod=58;
    public static final int Def=54;
    public static final int RULE_WS=109;
    public static final int Endif=30;
    public static final int Mode=44;
    public static final int LeftCurlyBracket=97;
    public static final int Bag=52;
    public static final int Virtual=21;
    public static final int Data=38;
    public static final int CircumflexAccent=96;
    public static final int Compute=16;
    public static final int Of=75;

    // delegates
    // delegators


        public InternalExprParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExprParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExprParser.tokenNames; }
    public String getGrammarFileName() { return "InternalExprParser.g"; }



     	private ExprGrammarAccess grammarAccess;

        public InternalExprParser(TokenStream input, ExprGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ExprModel";
       	}

       	@Override
       	protected ExprGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleExprModel"
    // InternalExprParser.g:78:1: entryRuleExprModel returns [EObject current=null] : iv_ruleExprModel= ruleExprModel EOF ;
    public final EObject entryRuleExprModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExprModel = null;


        try {
            // InternalExprParser.g:78:50: (iv_ruleExprModel= ruleExprModel EOF )
            // InternalExprParser.g:79:2: iv_ruleExprModel= ruleExprModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExprModel=ruleExprModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExprModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExprModel"


    // $ANTLR start "ruleExprModel"
    // InternalExprParser.g:85:1: ruleExprModel returns [EObject current=null] : ( (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) ) | (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) ) ) ;
    public final EObject ruleExprModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_annex_1_0 = null;

        EObject lv_annex_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:91:2: ( ( (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) ) | (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) ) ) )
            // InternalExprParser.g:92:2: ( (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) ) | (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) ) )
            {
            // InternalExprParser.g:92:2: ( (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) ) | (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Library) ) {
                alt1=1;
            }
            else if ( (LA1_0==Subclause) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalExprParser.g:93:3: (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) )
                    {
                    // InternalExprParser.g:93:3: (otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) ) )
                    // InternalExprParser.g:94:4: otherlv_0= Library ( (lv_annex_1_0= ruleExprLibrary ) )
                    {
                    otherlv_0=(Token)match(input,Library,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getExprModelAccess().getLibraryKeyword_0_0());
                      			
                    }
                    // InternalExprParser.g:98:4: ( (lv_annex_1_0= ruleExprLibrary ) )
                    // InternalExprParser.g:99:5: (lv_annex_1_0= ruleExprLibrary )
                    {
                    // InternalExprParser.g:99:5: (lv_annex_1_0= ruleExprLibrary )
                    // InternalExprParser.g:100:6: lv_annex_1_0= ruleExprLibrary
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExprModelAccess().getAnnexExprLibraryParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_annex_1_0=ruleExprLibrary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExprModelRule());
                      						}
                      						set(
                      							current,
                      							"annex",
                      							lv_annex_1_0,
                      							"org.osate.expr.Expr.ExprLibrary");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:119:3: (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) )
                    {
                    // InternalExprParser.g:119:3: (otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) ) )
                    // InternalExprParser.g:120:4: otherlv_2= Subclause ( (lv_annex_3_0= ruleExprSubclause ) )
                    {
                    otherlv_2=(Token)match(input,Subclause,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getExprModelAccess().getSubclauseKeyword_1_0());
                      			
                    }
                    // InternalExprParser.g:124:4: ( (lv_annex_3_0= ruleExprSubclause ) )
                    // InternalExprParser.g:125:5: (lv_annex_3_0= ruleExprSubclause )
                    {
                    // InternalExprParser.g:125:5: (lv_annex_3_0= ruleExprSubclause )
                    // InternalExprParser.g:126:6: lv_annex_3_0= ruleExprSubclause
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExprModelAccess().getAnnexExprSubclauseParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_annex_3_0=ruleExprSubclause();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExprModelRule());
                      						}
                      						set(
                      							current,
                      							"annex",
                      							lv_annex_3_0,
                      							"org.osate.expr.Expr.ExprSubclause");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExprModel"


    // $ANTLR start "entryRuleExprLibrary"
    // InternalExprParser.g:148:1: entryRuleExprLibrary returns [EObject current=null] : iv_ruleExprLibrary= ruleExprLibrary EOF ;
    public final EObject entryRuleExprLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExprLibrary = null;


        try {
            // InternalExprParser.g:148:52: (iv_ruleExprLibrary= ruleExprLibrary EOF )
            // InternalExprParser.g:149:2: iv_ruleExprLibrary= ruleExprLibrary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprLibraryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExprLibrary=ruleExprLibrary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExprLibrary; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExprLibrary"


    // $ANTLR start "ruleExprLibrary"
    // InternalExprParser.g:155:1: ruleExprLibrary returns [EObject current=null] : ( () (this_Declarations_1= ruleDeclarations[$current] )? ) ;
    public final EObject ruleExprLibrary() throws RecognitionException {
        EObject current = null;

        EObject this_Declarations_1 = null;



        	enterRule();

        try {
            // InternalExprParser.g:161:2: ( ( () (this_Declarations_1= ruleDeclarations[$current] )? ) )
            // InternalExprParser.g:162:2: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            {
            // InternalExprParser.g:162:2: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            // InternalExprParser.g:163:3: () (this_Declarations_1= ruleDeclarations[$current] )?
            {
            // InternalExprParser.g:163:3: ()
            // InternalExprParser.g:164:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExprLibraryAccess().getExprLibraryAction_0(),
              					current);
              			
            }

            }

            // InternalExprParser.g:170:3: (this_Declarations_1= ruleDeclarations[$current] )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Assert||LA2_0==Type||LA2_0==Def||(LA2_0>=Val && LA2_0<=Var)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalExprParser.g:171:4: this_Declarations_1= ruleDeclarations[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getExprLibraryRule());
                      				}
                      				newCompositeNode(grammarAccess.getExprLibraryAccess().getDeclarationsParserRuleCall_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Declarations_1=ruleDeclarations(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Declarations_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExprLibrary"


    // $ANTLR start "entryRuleExprSubclause"
    // InternalExprParser.g:187:1: entryRuleExprSubclause returns [EObject current=null] : iv_ruleExprSubclause= ruleExprSubclause EOF ;
    public final EObject entryRuleExprSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExprSubclause = null;


        try {
            // InternalExprParser.g:187:54: (iv_ruleExprSubclause= ruleExprSubclause EOF )
            // InternalExprParser.g:188:2: iv_ruleExprSubclause= ruleExprSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprSubclauseRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExprSubclause=ruleExprSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExprSubclause; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExprSubclause"


    // $ANTLR start "ruleExprSubclause"
    // InternalExprParser.g:194:1: ruleExprSubclause returns [EObject current=null] : ( () (this_Declarations_1= ruleDeclarations[$current] )? ) ;
    public final EObject ruleExprSubclause() throws RecognitionException {
        EObject current = null;

        EObject this_Declarations_1 = null;



        	enterRule();

        try {
            // InternalExprParser.g:200:2: ( ( () (this_Declarations_1= ruleDeclarations[$current] )? ) )
            // InternalExprParser.g:201:2: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            {
            // InternalExprParser.g:201:2: ( () (this_Declarations_1= ruleDeclarations[$current] )? )
            // InternalExprParser.g:202:3: () (this_Declarations_1= ruleDeclarations[$current] )?
            {
            // InternalExprParser.g:202:3: ()
            // InternalExprParser.g:203:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExprSubclauseAccess().getExprSubclauseAction_0(),
              					current);
              			
            }

            }

            // InternalExprParser.g:209:3: (this_Declarations_1= ruleDeclarations[$current] )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Assert||LA3_0==Type||LA3_0==Def||(LA3_0>=Val && LA3_0<=Var)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalExprParser.g:210:4: this_Declarations_1= ruleDeclarations[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getExprSubclauseRule());
                      				}
                      				newCompositeNode(grammarAccess.getExprSubclauseAccess().getDeclarationsParserRuleCall_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Declarations_1=ruleDeclarations(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Declarations_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExprSubclause"


    // $ANTLR start "ruleDeclarations"
    // InternalExprParser.g:227:1: ruleDeclarations[EObject in_current] returns [EObject current=in_current] : ( ( (lv_decls_0_0= ruleEDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )* (otherlv_3= Semicolon )? ) ;
    public final EObject ruleDeclarations(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decls_0_0 = null;

        EObject lv_decls_2_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:233:2: ( ( ( (lv_decls_0_0= ruleEDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )* (otherlv_3= Semicolon )? ) )
            // InternalExprParser.g:234:2: ( ( (lv_decls_0_0= ruleEDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )* (otherlv_3= Semicolon )? )
            {
            // InternalExprParser.g:234:2: ( ( (lv_decls_0_0= ruleEDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )* (otherlv_3= Semicolon )? )
            // InternalExprParser.g:235:3: ( (lv_decls_0_0= ruleEDeclaration ) ) (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )* (otherlv_3= Semicolon )?
            {
            // InternalExprParser.g:235:3: ( (lv_decls_0_0= ruleEDeclaration ) )
            // InternalExprParser.g:236:4: (lv_decls_0_0= ruleEDeclaration )
            {
            // InternalExprParser.g:236:4: (lv_decls_0_0= ruleEDeclaration )
            // InternalExprParser.g:237:5: lv_decls_0_0= ruleEDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclarationsAccess().getDeclsEDeclarationParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_4);
            lv_decls_0_0=ruleEDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeclarationsRule());
              					}
              					add(
              						current,
              						"decls",
              						lv_decls_0_0,
              						"org.osate.expr.Expr.EDeclaration");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:254:3: (otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Semicolon) ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1==Assert||LA4_1==Type||LA4_1==Def||(LA4_1>=Val && LA4_1<=Var)) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // InternalExprParser.g:255:4: otherlv_1= Semicolon ( (lv_decls_2_0= ruleEDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,Semicolon,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getDeclarationsAccess().getSemicolonKeyword_1_0());
            	      			
            	    }
            	    // InternalExprParser.g:259:4: ( (lv_decls_2_0= ruleEDeclaration ) )
            	    // InternalExprParser.g:260:5: (lv_decls_2_0= ruleEDeclaration )
            	    {
            	    // InternalExprParser.g:260:5: (lv_decls_2_0= ruleEDeclaration )
            	    // InternalExprParser.g:261:6: lv_decls_2_0= ruleEDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDeclarationsAccess().getDeclsEDeclarationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_decls_2_0=ruleEDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getDeclarationsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"decls",
            	      							lv_decls_2_0,
            	      							"org.osate.expr.Expr.EDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalExprParser.g:279:3: (otherlv_3= Semicolon )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Semicolon) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalExprParser.g:280:4: otherlv_3= Semicolon
                    {
                    otherlv_3=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDeclarationsAccess().getSemicolonKeyword_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclarations"


    // $ANTLR start "entryRuleEDeclaration"
    // InternalExprParser.g:289:1: entryRuleEDeclaration returns [EObject current=null] : iv_ruleEDeclaration= ruleEDeclaration EOF ;
    public final EObject entryRuleEDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEDeclaration = null;


        try {
            // InternalExprParser.g:289:53: (iv_ruleEDeclaration= ruleEDeclaration EOF )
            // InternalExprParser.g:290:2: iv_ruleEDeclaration= ruleEDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEDeclarationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEDeclaration=ruleEDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEDeclaration; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEDeclaration"


    // $ANTLR start "ruleEDeclaration"
    // InternalExprParser.g:296:1: ruleEDeclaration returns [EObject current=null] : (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl | this_Assertion_3= ruleAssertion ) ;
    public final EObject ruleEDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_TypeDecl_0 = null;

        EObject this_VarDecl_1 = null;

        EObject this_FunDecl_2 = null;

        EObject this_Assertion_3 = null;



        	enterRule();

        try {
            // InternalExprParser.g:302:2: ( (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl | this_Assertion_3= ruleAssertion ) )
            // InternalExprParser.g:303:2: (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl | this_Assertion_3= ruleAssertion )
            {
            // InternalExprParser.g:303:2: (this_TypeDecl_0= ruleTypeDecl | this_VarDecl_1= ruleVarDecl | this_FunDecl_2= ruleFunDecl | this_Assertion_3= ruleAssertion )
            int alt6=4;
            switch ( input.LA(1) ) {
            case Type:
                {
                alt6=1;
                }
                break;
            case Val:
            case Var:
                {
                alt6=2;
                }
                break;
            case Def:
                {
                alt6=3;
                }
                break;
            case Assert:
                {
                alt6=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalExprParser.g:304:3: this_TypeDecl_0= ruleTypeDecl
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEDeclarationAccess().getTypeDeclParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeDecl_0=ruleTypeDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeDecl_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:313:3: this_VarDecl_1= ruleVarDecl
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEDeclarationAccess().getVarDeclParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_VarDecl_1=ruleVarDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VarDecl_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:322:3: this_FunDecl_2= ruleFunDecl
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEDeclarationAccess().getFunDeclParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FunDecl_2=ruleFunDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunDecl_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:331:3: this_Assertion_3= ruleAssertion
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEDeclarationAccess().getAssertionParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Assertion_3=ruleAssertion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Assertion_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEDeclaration"


    // $ANTLR start "entryRuleTypeDecl"
    // InternalExprParser.g:343:1: entryRuleTypeDecl returns [EObject current=null] : iv_ruleTypeDecl= ruleTypeDecl EOF ;
    public final EObject entryRuleTypeDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDecl = null;


        try {
            // InternalExprParser.g:343:49: (iv_ruleTypeDecl= ruleTypeDecl EOF )
            // InternalExprParser.g:344:2: iv_ruleTypeDecl= ruleTypeDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDeclRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeDecl=ruleTypeDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDecl; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeDecl"


    // $ANTLR start "ruleTypeDecl"
    // InternalExprParser.g:350:1: ruleTypeDecl returns [EObject current=null] : (otherlv_0= Type ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) (otherlv_4= LeftCurlyBracket ( (lv_ownedPropertyAssociations_5_0= rulePropertyAssociation ) ) (otherlv_6= Semicolon ( (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation ) ) )* otherlv_8= RightCurlyBracket )? ) ;
    public final EObject ruleTypeDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_type_3_0 = null;

        EObject lv_ownedPropertyAssociations_5_0 = null;

        EObject lv_ownedPropertyAssociations_7_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:356:2: ( (otherlv_0= Type ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) (otherlv_4= LeftCurlyBracket ( (lv_ownedPropertyAssociations_5_0= rulePropertyAssociation ) ) (otherlv_6= Semicolon ( (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation ) ) )* otherlv_8= RightCurlyBracket )? ) )
            // InternalExprParser.g:357:2: (otherlv_0= Type ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) (otherlv_4= LeftCurlyBracket ( (lv_ownedPropertyAssociations_5_0= rulePropertyAssociation ) ) (otherlv_6= Semicolon ( (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation ) ) )* otherlv_8= RightCurlyBracket )? )
            {
            // InternalExprParser.g:357:2: (otherlv_0= Type ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) (otherlv_4= LeftCurlyBracket ( (lv_ownedPropertyAssociations_5_0= rulePropertyAssociation ) ) (otherlv_6= Semicolon ( (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation ) ) )* otherlv_8= RightCurlyBracket )? )
            // InternalExprParser.g:358:3: otherlv_0= Type ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) (otherlv_4= LeftCurlyBracket ( (lv_ownedPropertyAssociations_5_0= rulePropertyAssociation ) ) (otherlv_6= Semicolon ( (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation ) ) )* otherlv_8= RightCurlyBracket )?
            {
            otherlv_0=(Token)match(input,Type,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeDeclAccess().getTypeKeyword_0());
              		
            }
            // InternalExprParser.g:362:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExprParser.g:363:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExprParser.g:363:4: (lv_name_1_0= RULE_ID )
            // InternalExprParser.g:364:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getTypeDeclAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTypeDeclRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getTypeDeclAccess().getColonKeyword_2());
              		
            }
            // InternalExprParser.g:384:3: ( (lv_type_3_0= ruleType ) )
            // InternalExprParser.g:385:4: (lv_type_3_0= ruleType )
            {
            // InternalExprParser.g:385:4: (lv_type_3_0= ruleType )
            // InternalExprParser.g:386:5: lv_type_3_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeDeclAccess().getTypeTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_8);
            lv_type_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypeDeclRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_3_0,
              						"org.osate.expr.Expr.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:403:3: (otherlv_4= LeftCurlyBracket ( (lv_ownedPropertyAssociations_5_0= rulePropertyAssociation ) ) (otherlv_6= Semicolon ( (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation ) ) )* otherlv_8= RightCurlyBracket )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LeftCurlyBracket) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalExprParser.g:404:4: otherlv_4= LeftCurlyBracket ( (lv_ownedPropertyAssociations_5_0= rulePropertyAssociation ) ) (otherlv_6= Semicolon ( (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation ) ) )* otherlv_8= RightCurlyBracket
                    {
                    otherlv_4=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getTypeDeclAccess().getLeftCurlyBracketKeyword_4_0());
                      			
                    }
                    // InternalExprParser.g:408:4: ( (lv_ownedPropertyAssociations_5_0= rulePropertyAssociation ) )
                    // InternalExprParser.g:409:5: (lv_ownedPropertyAssociations_5_0= rulePropertyAssociation )
                    {
                    // InternalExprParser.g:409:5: (lv_ownedPropertyAssociations_5_0= rulePropertyAssociation )
                    // InternalExprParser.g:410:6: lv_ownedPropertyAssociations_5_0= rulePropertyAssociation
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeDeclAccess().getOwnedPropertyAssociationsPropertyAssociationParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_ownedPropertyAssociations_5_0=rulePropertyAssociation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTypeDeclRule());
                      						}
                      						add(
                      							current,
                      							"ownedPropertyAssociations",
                      							lv_ownedPropertyAssociations_5_0,
                      							"org.osate.xtext.aadl2.properties.Properties.PropertyAssociation");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExprParser.g:427:4: (otherlv_6= Semicolon ( (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==Semicolon) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalExprParser.g:428:5: otherlv_6= Semicolon ( (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation ) )
                    	    {
                    	    otherlv_6=(Token)match(input,Semicolon,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getTypeDeclAccess().getSemicolonKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalExprParser.g:432:5: ( (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation ) )
                    	    // InternalExprParser.g:433:6: (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation )
                    	    {
                    	    // InternalExprParser.g:433:6: (lv_ownedPropertyAssociations_7_0= rulePropertyAssociation )
                    	    // InternalExprParser.g:434:7: lv_ownedPropertyAssociations_7_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getTypeDeclAccess().getOwnedPropertyAssociationsPropertyAssociationParserRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_9);
                    	    lv_ownedPropertyAssociations_7_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getTypeDeclRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"ownedPropertyAssociations",
                    	      								lv_ownedPropertyAssociations_7_0,
                    	      								"org.osate.xtext.aadl2.properties.Properties.PropertyAssociation");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getTypeDeclAccess().getRightCurlyBracketKeyword_4_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeDecl"


    // $ANTLR start "entryRuleVarDecl"
    // InternalExprParser.g:461:1: entryRuleVarDecl returns [EObject current=null] : iv_ruleVarDecl= ruleVarDecl EOF ;
    public final EObject entryRuleVarDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDecl = null;


        try {
            // InternalExprParser.g:461:48: (iv_ruleVarDecl= ruleVarDecl EOF )
            // InternalExprParser.g:462:2: iv_ruleVarDecl= ruleVarDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarDeclRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVarDecl=ruleVarDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarDecl; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDecl"


    // $ANTLR start "ruleVarDecl"
    // InternalExprParser.g:468:1: ruleVarDecl returns [EObject current=null] : ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVarDecl() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_declType_4_0 = null;

        EObject lv_value_6_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:474:2: ( ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? ) )
            // InternalExprParser.g:475:2: ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? )
            {
            // InternalExprParser.g:475:2: ( ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )? )
            // InternalExprParser.g:476:3: ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )? (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )?
            {
            // InternalExprParser.g:476:3: ( ( (lv_const_0_0= Val ) ) | otherlv_1= Var )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Val) ) {
                alt9=1;
            }
            else if ( (LA9_0==Var) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalExprParser.g:477:4: ( (lv_const_0_0= Val ) )
                    {
                    // InternalExprParser.g:477:4: ( (lv_const_0_0= Val ) )
                    // InternalExprParser.g:478:5: (lv_const_0_0= Val )
                    {
                    // InternalExprParser.g:478:5: (lv_const_0_0= Val )
                    // InternalExprParser.g:479:6: lv_const_0_0= Val
                    {
                    lv_const_0_0=(Token)match(input,Val,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_const_0_0, grammarAccess.getVarDeclAccess().getConstValKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVarDeclRule());
                      						}
                      						setWithLastConsumed(current, "const", true, "val");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:492:4: otherlv_1= Var
                    {
                    otherlv_1=(Token)match(input,Var,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getVarDeclAccess().getVarKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalExprParser.g:497:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalExprParser.g:498:4: (lv_name_2_0= RULE_ID )
            {
            // InternalExprParser.g:498:4: (lv_name_2_0= RULE_ID )
            // InternalExprParser.g:499:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVarDeclRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            // InternalExprParser.g:515:3: (otherlv_3= Colon ( (lv_declType_4_0= ruleType ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Colon) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalExprParser.g:516:4: otherlv_3= Colon ( (lv_declType_4_0= ruleType ) )
                    {
                    otherlv_3=(Token)match(input,Colon,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVarDeclAccess().getColonKeyword_2_0());
                      			
                    }
                    // InternalExprParser.g:520:4: ( (lv_declType_4_0= ruleType ) )
                    // InternalExprParser.g:521:5: (lv_declType_4_0= ruleType )
                    {
                    // InternalExprParser.g:521:5: (lv_declType_4_0= ruleType )
                    // InternalExprParser.g:522:6: lv_declType_4_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarDeclAccess().getDeclTypeTypeParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    lv_declType_4_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVarDeclRule());
                      						}
                      						set(
                      							current,
                      							"declType",
                      							lv_declType_4_0,
                      							"org.osate.expr.Expr.Type");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalExprParser.g:540:3: (otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==EqualsSign) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalExprParser.g:541:4: otherlv_5= EqualsSign ( (lv_value_6_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getVarDeclAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalExprParser.g:545:4: ( (lv_value_6_0= ruleExpression ) )
                    // InternalExprParser.g:546:5: (lv_value_6_0= ruleExpression )
                    {
                    // InternalExprParser.g:546:5: (lv_value_6_0= ruleExpression )
                    // InternalExprParser.g:547:6: lv_value_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarDeclAccess().getValueExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVarDeclRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_6_0,
                      							"org.osate.expr.Expr.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarDecl"


    // $ANTLR start "entryRuleFunDecl"
    // InternalExprParser.g:569:1: entryRuleFunDecl returns [EObject current=null] : iv_ruleFunDecl= ruleFunDecl EOF ;
    public final EObject entryRuleFunDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunDecl = null;


        try {
            // InternalExprParser.g:569:48: (iv_ruleFunDecl= ruleFunDecl EOF )
            // InternalExprParser.g:570:2: iv_ruleFunDecl= ruleFunDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunDeclRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFunDecl=ruleFunDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunDecl; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunDecl"


    // $ANTLR start "ruleFunDecl"
    // InternalExprParser.g:576:1: ruleFunDecl returns [EObject current=null] : (otherlv_0= Def ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis this_Args_3= ruleArgs[$current] otherlv_4= RightParenthesis otherlv_5= Colon ( (lv_resultType_6_0= ruleType ) ) (otherlv_7= EqualsSign ( ( ( (lv_java_8_0= Java ) ) otherlv_9= Colon ( (lv_fqn_10_0= ruleJavaFQN ) ) ) | ( (lv_exp_11_0= ruleExpression ) ) ) )? ) ;
    public final EObject ruleFunDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_java_8_0=null;
        Token otherlv_9=null;
        EObject this_Args_3 = null;

        EObject lv_resultType_6_0 = null;

        AntlrDatatypeRuleToken lv_fqn_10_0 = null;

        EObject lv_exp_11_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:582:2: ( (otherlv_0= Def ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis this_Args_3= ruleArgs[$current] otherlv_4= RightParenthesis otherlv_5= Colon ( (lv_resultType_6_0= ruleType ) ) (otherlv_7= EqualsSign ( ( ( (lv_java_8_0= Java ) ) otherlv_9= Colon ( (lv_fqn_10_0= ruleJavaFQN ) ) ) | ( (lv_exp_11_0= ruleExpression ) ) ) )? ) )
            // InternalExprParser.g:583:2: (otherlv_0= Def ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis this_Args_3= ruleArgs[$current] otherlv_4= RightParenthesis otherlv_5= Colon ( (lv_resultType_6_0= ruleType ) ) (otherlv_7= EqualsSign ( ( ( (lv_java_8_0= Java ) ) otherlv_9= Colon ( (lv_fqn_10_0= ruleJavaFQN ) ) ) | ( (lv_exp_11_0= ruleExpression ) ) ) )? )
            {
            // InternalExprParser.g:583:2: (otherlv_0= Def ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis this_Args_3= ruleArgs[$current] otherlv_4= RightParenthesis otherlv_5= Colon ( (lv_resultType_6_0= ruleType ) ) (otherlv_7= EqualsSign ( ( ( (lv_java_8_0= Java ) ) otherlv_9= Colon ( (lv_fqn_10_0= ruleJavaFQN ) ) ) | ( (lv_exp_11_0= ruleExpression ) ) ) )? )
            // InternalExprParser.g:584:3: otherlv_0= Def ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis this_Args_3= ruleArgs[$current] otherlv_4= RightParenthesis otherlv_5= Colon ( (lv_resultType_6_0= ruleType ) ) (otherlv_7= EqualsSign ( ( ( (lv_java_8_0= Java ) ) otherlv_9= Colon ( (lv_fqn_10_0= ruleJavaFQN ) ) ) | ( (lv_exp_11_0= ruleExpression ) ) ) )?
            {
            otherlv_0=(Token)match(input,Def,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFunDeclAccess().getDefKeyword_0());
              		
            }
            // InternalExprParser.g:588:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExprParser.g:589:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExprParser.g:589:4: (lv_name_1_0= RULE_ID )
            // InternalExprParser.g:590:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getFunDeclAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunDeclRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunDeclAccess().getLeftParenthesisKeyword_2());
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getFunDeclRule());
              			}
              			newCompositeNode(grammarAccess.getFunDeclAccess().getArgsParserRuleCall_3());
              		
            }
            pushFollow(FollowSets000.FOLLOW_15);
            this_Args_3=ruleArgs(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Args_3;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_4=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getFunDeclAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,Colon,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFunDeclAccess().getColonKeyword_5());
              		
            }
            // InternalExprParser.g:629:3: ( (lv_resultType_6_0= ruleType ) )
            // InternalExprParser.g:630:4: (lv_resultType_6_0= ruleType )
            {
            // InternalExprParser.g:630:4: (lv_resultType_6_0= ruleType )
            // InternalExprParser.g:631:5: lv_resultType_6_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunDeclAccess().getResultTypeTypeParserRuleCall_6_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_11);
            lv_resultType_6_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunDeclRule());
              					}
              					set(
              						current,
              						"resultType",
              						lv_resultType_6_0,
              						"org.osate.expr.Expr.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:648:3: (otherlv_7= EqualsSign ( ( ( (lv_java_8_0= Java ) ) otherlv_9= Colon ( (lv_fqn_10_0= ruleJavaFQN ) ) ) | ( (lv_exp_11_0= ruleExpression ) ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==EqualsSign) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalExprParser.g:649:4: otherlv_7= EqualsSign ( ( ( (lv_java_8_0= Java ) ) otherlv_9= Colon ( (lv_fqn_10_0= ruleJavaFQN ) ) ) | ( (lv_exp_11_0= ruleExpression ) ) )
                    {
                    otherlv_7=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getFunDeclAccess().getEqualsSignKeyword_7_0());
                      			
                    }
                    // InternalExprParser.g:653:4: ( ( ( (lv_java_8_0= Java ) ) otherlv_9= Colon ( (lv_fqn_10_0= ruleJavaFQN ) ) ) | ( (lv_exp_11_0= ruleExpression ) ) )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==Java) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==Record||LA12_0==False||(LA12_0>=Tuple && LA12_0<=Union)||LA12_0==List||LA12_0==True||LA12_0==Bag||LA12_0==Map||(LA12_0>=Not && LA12_0<=Set)||LA12_0==If||LA12_0==LeftParenthesis||LA12_0==PlusSign||LA12_0==HyphenMinus||LA12_0==LeftSquareBracket||(LA12_0>=CircumflexAccent && LA12_0<=LeftCurlyBracket)||LA12_0==RULE_REAL_LIT||LA12_0==RULE_INTEGER_LIT||(LA12_0>=RULE_STRING && LA12_0<=RULE_ID)) ) {
                        alt12=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalExprParser.g:654:5: ( ( (lv_java_8_0= Java ) ) otherlv_9= Colon ( (lv_fqn_10_0= ruleJavaFQN ) ) )
                            {
                            // InternalExprParser.g:654:5: ( ( (lv_java_8_0= Java ) ) otherlv_9= Colon ( (lv_fqn_10_0= ruleJavaFQN ) ) )
                            // InternalExprParser.g:655:6: ( (lv_java_8_0= Java ) ) otherlv_9= Colon ( (lv_fqn_10_0= ruleJavaFQN ) )
                            {
                            // InternalExprParser.g:655:6: ( (lv_java_8_0= Java ) )
                            // InternalExprParser.g:656:7: (lv_java_8_0= Java )
                            {
                            // InternalExprParser.g:656:7: (lv_java_8_0= Java )
                            // InternalExprParser.g:657:8: lv_java_8_0= Java
                            {
                            lv_java_8_0=(Token)match(input,Java,FollowSets000.FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_java_8_0, grammarAccess.getFunDeclAccess().getJavaJavaKeyword_7_1_0_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getFunDeclRule());
                              								}
                              								setWithLastConsumed(current, "java", true, "java");
                              							
                            }

                            }


                            }

                            otherlv_9=(Token)match(input,Colon,FollowSets000.FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_9, grammarAccess.getFunDeclAccess().getColonKeyword_7_1_0_1());
                              					
                            }
                            // InternalExprParser.g:673:6: ( (lv_fqn_10_0= ruleJavaFQN ) )
                            // InternalExprParser.g:674:7: (lv_fqn_10_0= ruleJavaFQN )
                            {
                            // InternalExprParser.g:674:7: (lv_fqn_10_0= ruleJavaFQN )
                            // InternalExprParser.g:675:8: lv_fqn_10_0= ruleJavaFQN
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getFunDeclAccess().getFqnJavaFQNParserRuleCall_7_1_0_2_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_fqn_10_0=ruleJavaFQN();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getFunDeclRule());
                              								}
                              								set(
                              									current,
                              									"fqn",
                              									lv_fqn_10_0,
                              									"org.osate.expr.Expr.JavaFQN");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalExprParser.g:694:5: ( (lv_exp_11_0= ruleExpression ) )
                            {
                            // InternalExprParser.g:694:5: ( (lv_exp_11_0= ruleExpression ) )
                            // InternalExprParser.g:695:6: (lv_exp_11_0= ruleExpression )
                            {
                            // InternalExprParser.g:695:6: (lv_exp_11_0= ruleExpression )
                            // InternalExprParser.g:696:7: lv_exp_11_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getFunDeclAccess().getExpExpressionParserRuleCall_7_1_1_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_exp_11_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getFunDeclRule());
                              							}
                              							set(
                              								current,
                              								"exp",
                              								lv_exp_11_0,
                              								"org.osate.expr.Expr.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunDecl"


    // $ANTLR start "entryRuleJavaFQN"
    // InternalExprParser.g:719:1: entryRuleJavaFQN returns [String current=null] : iv_ruleJavaFQN= ruleJavaFQN EOF ;
    public final String entryRuleJavaFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleJavaFQN = null;


        try {
            // InternalExprParser.g:719:47: (iv_ruleJavaFQN= ruleJavaFQN EOF )
            // InternalExprParser.g:720:2: iv_ruleJavaFQN= ruleJavaFQN EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaFQNRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleJavaFQN=ruleJavaFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaFQN.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJavaFQN"


    // $ANTLR start "ruleJavaFQN"
    // InternalExprParser.g:726:1: ruleJavaFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleJavaFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalExprParser.g:732:2: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // InternalExprParser.g:733:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // InternalExprParser.g:733:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // InternalExprParser.g:734:3: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getJavaFQNAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalExprParser.g:741:3: (kw= FullStop this_ID_2= RULE_ID )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==FullStop) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalExprParser.g:742:4: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getJavaFQNAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getJavaFQNAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJavaFQN"


    // $ANTLR start "ruleArgs"
    // InternalExprParser.g:760:1: ruleArgs[EObject in_current] returns [EObject current=in_current] : ( ( (lv_args_0_0= ruleArgument ) ) (otherlv_1= Comma ( (lv_args_2_0= ruleArgument ) ) )* )? ;
    public final EObject ruleArgs(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_args_0_0 = null;

        EObject lv_args_2_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:766:2: ( ( ( (lv_args_0_0= ruleArgument ) ) (otherlv_1= Comma ( (lv_args_2_0= ruleArgument ) ) )* )? )
            // InternalExprParser.g:767:2: ( ( (lv_args_0_0= ruleArgument ) ) (otherlv_1= Comma ( (lv_args_2_0= ruleArgument ) ) )* )?
            {
            // InternalExprParser.g:767:2: ( ( (lv_args_0_0= ruleArgument ) ) (otherlv_1= Comma ( (lv_args_2_0= ruleArgument ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalExprParser.g:768:3: ( (lv_args_0_0= ruleArgument ) ) (otherlv_1= Comma ( (lv_args_2_0= ruleArgument ) ) )*
                    {
                    // InternalExprParser.g:768:3: ( (lv_args_0_0= ruleArgument ) )
                    // InternalExprParser.g:769:4: (lv_args_0_0= ruleArgument )
                    {
                    // InternalExprParser.g:769:4: (lv_args_0_0= ruleArgument )
                    // InternalExprParser.g:770:5: lv_args_0_0= ruleArgument
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getArgsAccess().getArgsArgumentParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_18);
                    lv_args_0_0=ruleArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getArgsRule());
                      					}
                      					add(
                      						current,
                      						"args",
                      						lv_args_0_0,
                      						"org.osate.expr.Expr.Argument");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }

                    // InternalExprParser.g:787:3: (otherlv_1= Comma ( (lv_args_2_0= ruleArgument ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==Comma) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalExprParser.g:788:4: otherlv_1= Comma ( (lv_args_2_0= ruleArgument ) )
                    	    {
                    	    otherlv_1=(Token)match(input,Comma,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      				newLeafNode(otherlv_1, grammarAccess.getArgsAccess().getCommaKeyword_1_0());
                    	      			
                    	    }
                    	    // InternalExprParser.g:792:4: ( (lv_args_2_0= ruleArgument ) )
                    	    // InternalExprParser.g:793:5: (lv_args_2_0= ruleArgument )
                    	    {
                    	    // InternalExprParser.g:793:5: (lv_args_2_0= ruleArgument )
                    	    // InternalExprParser.g:794:6: lv_args_2_0= ruleArgument
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getArgsAccess().getArgsArgumentParserRuleCall_1_1_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_18);
                    	    lv_args_2_0=ruleArgument();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getArgsRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"args",
                    	      							lv_args_2_0,
                    	      							"org.osate.expr.Expr.Argument");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgs"


    // $ANTLR start "entryRuleArgument"
    // InternalExprParser.g:816:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalExprParser.g:816:49: (iv_ruleArgument= ruleArgument EOF )
            // InternalExprParser.g:817:2: iv_ruleArgument= ruleArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleArgument=ruleArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgument; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArgument"


    // $ANTLR start "ruleArgument"
    // InternalExprParser.g:823:1: ruleArgument returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:829:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) ) )
            // InternalExprParser.g:830:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) )
            {
            // InternalExprParser.g:830:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) )
            // InternalExprParser.g:831:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) )
            {
            // InternalExprParser.g:831:3: ()
            // InternalExprParser.g:832:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getArgumentAccess().getArgumentAction_0(),
              					current);
              			
            }

            }

            // InternalExprParser.g:838:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExprParser.g:839:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExprParser.g:839:4: (lv_name_1_0= RULE_ID )
            // InternalExprParser.g:840:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getArgumentRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getArgumentAccess().getColonKeyword_2());
              		
            }
            // InternalExprParser.g:860:3: ( (lv_type_3_0= ruleType ) )
            // InternalExprParser.g:861:4: (lv_type_3_0= ruleType )
            {
            // InternalExprParser.g:861:4: (lv_type_3_0= ruleType )
            // InternalExprParser.g:862:5: lv_type_3_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArgumentAccess().getTypeTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArgumentRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_3_0,
              						"org.osate.expr.Expr.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleAssertion"
    // InternalExprParser.g:883:1: entryRuleAssertion returns [EObject current=null] : iv_ruleAssertion= ruleAssertion EOF ;
    public final EObject entryRuleAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssertion = null;


        try {
            // InternalExprParser.g:883:50: (iv_ruleAssertion= ruleAssertion EOF )
            // InternalExprParser.g:884:2: iv_ruleAssertion= ruleAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssertion=ruleAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssertion"


    // $ANTLR start "ruleAssertion"
    // InternalExprParser.g:890:1: ruleAssertion returns [EObject current=null] : (otherlv_0= Assert ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_assert_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_assert_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:896:2: ( (otherlv_0= Assert ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_assert_3_0= ruleExpression ) ) ) )
            // InternalExprParser.g:897:2: (otherlv_0= Assert ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_assert_3_0= ruleExpression ) ) )
            {
            // InternalExprParser.g:897:2: (otherlv_0= Assert ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_assert_3_0= ruleExpression ) ) )
            // InternalExprParser.g:898:3: otherlv_0= Assert ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_assert_3_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,Assert,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAssertionAccess().getAssertKeyword_0());
              		
            }
            // InternalExprParser.g:902:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExprParser.g:903:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExprParser.g:903:4: (lv_name_1_0= RULE_ID )
            // InternalExprParser.g:904:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getAssertionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAssertionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAssertionAccess().getColonKeyword_2());
              		
            }
            // InternalExprParser.g:924:3: ( (lv_assert_3_0= ruleExpression ) )
            // InternalExprParser.g:925:4: (lv_assert_3_0= ruleExpression )
            {
            // InternalExprParser.g:925:4: (lv_assert_3_0= ruleExpression )
            // InternalExprParser.g:926:5: lv_assert_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssertionAccess().getAssertExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_assert_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssertionRule());
              					}
              					set(
              						current,
              						"assert",
              						lv_assert_3_0,
              						"org.osate.expr.Expr.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssertion"


    // $ANTLR start "entryRuleType"
    // InternalExprParser.g:947:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalExprParser.g:947:45: (iv_ruleType= ruleType EOF )
            // InternalExprParser.g:948:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalExprParser.g:954:1: ruleType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_RangeType_1= ruleRangeType | this_Category_2= ruleCategory | this_MetaClass_3= ruleMetaClass | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_EnumType_11= ruleEnumType | this_TypeRef_12= ruleTypeRef ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_RangeType_1 = null;

        EObject this_Category_2 = null;

        EObject this_MetaClass_3 = null;

        EObject this_RecordType_4 = null;

        EObject this_UnionType_5 = null;

        EObject this_TupleType_6 = null;

        EObject this_ListType_7 = null;

        EObject this_SetType_8 = null;

        EObject this_BagType_9 = null;

        EObject this_MapType_10 = null;

        EObject this_EnumType_11 = null;

        EObject this_TypeRef_12 = null;



        	enterRule();

        try {
            // InternalExprParser.g:960:2: ( (this_PrimitiveType_0= rulePrimitiveType | this_RangeType_1= ruleRangeType | this_Category_2= ruleCategory | this_MetaClass_3= ruleMetaClass | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_EnumType_11= ruleEnumType | this_TypeRef_12= ruleTypeRef ) )
            // InternalExprParser.g:961:2: (this_PrimitiveType_0= rulePrimitiveType | this_RangeType_1= ruleRangeType | this_Category_2= ruleCategory | this_MetaClass_3= ruleMetaClass | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_EnumType_11= ruleEnumType | this_TypeRef_12= ruleTypeRef )
            {
            // InternalExprParser.g:961:2: (this_PrimitiveType_0= rulePrimitiveType | this_RangeType_1= ruleRangeType | this_Category_2= ruleCategory | this_MetaClass_3= ruleMetaClass | this_RecordType_4= ruleRecordType | this_UnionType_5= ruleUnionType | this_TupleType_6= ruleTupleType | this_ListType_7= ruleListType | this_SetType_8= ruleSetType | this_BagType_9= ruleBagType | this_MapType_10= ruleMapType | this_EnumType_11= ruleEnumType | this_TypeRef_12= ruleTypeRef )
            int alt17=13;
            switch ( input.LA(1) ) {
            case String:
            case Bool:
            case Real:
            case Int:
                {
                alt17=1;
                }
                break;
            case Range:
                {
                alt17=2;
                }
                break;
            case Subprogram:
            case Processor:
            case Abstract:
            case Process:
            case Virtual:
            case Device:
            case Memory:
            case KW_System:
            case Thread:
            case Data:
            case Bus:
                {
                alt17=3;
                }
                break;
            case Connection:
            case Component:
            case Property:
            case Feature:
            case Flow:
            case Mode:
                {
                alt17=4;
                }
                break;
            case Record:
                {
                alt17=5;
                }
                break;
            case Union:
                {
                alt17=6;
                }
                break;
            case Tuple:
                {
                alt17=7;
                }
                break;
            case List:
                {
                alt17=8;
                }
                break;
            case Set:
                {
                alt17=9;
                }
                break;
            case Bag:
                {
                alt17=10;
                }
                break;
            case Map:
                {
                alt17=11;
                }
                break;
            case Enum:
                {
                alt17=12;
                }
                break;
            case RULE_ID:
                {
                alt17=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalExprParser.g:962:3: this_PrimitiveType_0= rulePrimitiveType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrimitiveType_0=rulePrimitiveType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PrimitiveType_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:971:3: this_RangeType_1= ruleRangeType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getRangeTypeParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RangeType_1=ruleRangeType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RangeType_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:980:3: this_Category_2= ruleCategory
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getCategoryParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Category_2=ruleCategory();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Category_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:989:3: this_MetaClass_3= ruleMetaClass
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getMetaClassParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MetaClass_3=ruleMetaClass();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_MetaClass_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:998:3: this_RecordType_4= ruleRecordType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getRecordTypeParserRuleCall_4());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RecordType_4=ruleRecordType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RecordType_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExprParser.g:1007:3: this_UnionType_5= ruleUnionType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getUnionTypeParserRuleCall_5());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UnionType_5=ruleUnionType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnionType_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalExprParser.g:1016:3: this_TupleType_6= ruleTupleType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getTupleTypeParserRuleCall_6());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TupleType_6=ruleTupleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TupleType_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalExprParser.g:1025:3: this_ListType_7= ruleListType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getListTypeParserRuleCall_7());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ListType_7=ruleListType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ListType_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalExprParser.g:1034:3: this_SetType_8= ruleSetType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getSetTypeParserRuleCall_8());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SetType_8=ruleSetType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SetType_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalExprParser.g:1043:3: this_BagType_9= ruleBagType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getBagTypeParserRuleCall_9());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BagType_9=ruleBagType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BagType_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalExprParser.g:1052:3: this_MapType_10= ruleMapType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getMapTypeParserRuleCall_10());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MapType_10=ruleMapType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_MapType_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalExprParser.g:1061:3: this_EnumType_11= ruleEnumType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getEnumTypeParserRuleCall_11());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EnumType_11=ruleEnumType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EnumType_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalExprParser.g:1070:3: this_TypeRef_12= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeAccess().getTypeRefParserRuleCall_12());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeRef_12=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeRef_12;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRulePrimitiveType"
    // InternalExprParser.g:1082:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // InternalExprParser.g:1082:54: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // InternalExprParser.g:1083:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // InternalExprParser.g:1089:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= Bool ) | this_ENumberType_2= ruleENumberType | ( () otherlv_4= String ) ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_ENumberType_2 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1095:2: ( ( ( () otherlv_1= Bool ) | this_ENumberType_2= ruleENumberType | ( () otherlv_4= String ) ) )
            // InternalExprParser.g:1096:2: ( ( () otherlv_1= Bool ) | this_ENumberType_2= ruleENumberType | ( () otherlv_4= String ) )
            {
            // InternalExprParser.g:1096:2: ( ( () otherlv_1= Bool ) | this_ENumberType_2= ruleENumberType | ( () otherlv_4= String ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case Bool:
                {
                alt18=1;
                }
                break;
            case Real:
            case Int:
                {
                alt18=2;
                }
                break;
            case String:
                {
                alt18=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalExprParser.g:1097:3: ( () otherlv_1= Bool )
                    {
                    // InternalExprParser.g:1097:3: ( () otherlv_1= Bool )
                    // InternalExprParser.g:1098:4: () otherlv_1= Bool
                    {
                    // InternalExprParser.g:1098:4: ()
                    // InternalExprParser.g:1099:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimitiveTypeAccess().getEBooleanAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,Bool,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBoolKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1111:3: this_ENumberType_2= ruleENumberType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getENumberTypeParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ENumberType_2=ruleENumberType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ENumberType_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:1120:3: ( () otherlv_4= String )
                    {
                    // InternalExprParser.g:1120:3: ( () otherlv_4= String )
                    // InternalExprParser.g:1121:4: () otherlv_4= String
                    {
                    // InternalExprParser.g:1121:4: ()
                    // InternalExprParser.g:1122:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimitiveTypeAccess().getEStringAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_4=(Token)match(input,String,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleENumberType"
    // InternalExprParser.g:1137:1: entryRuleENumberType returns [EObject current=null] : iv_ruleENumberType= ruleENumberType EOF ;
    public final EObject entryRuleENumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleENumberType = null;


        try {
            // InternalExprParser.g:1137:52: (iv_ruleENumberType= ruleENumberType EOF )
            // InternalExprParser.g:1138:2: iv_ruleENumberType= ruleENumberType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getENumberTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleENumberType=ruleENumberType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleENumberType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleENumberType"


    // $ANTLR start "ruleENumberType"
    // InternalExprParser.g:1144:1: ruleENumberType returns [EObject current=null] : (this_EInteger_0= ruleEInteger | this_EReal_1= ruleEReal ) ;
    public final EObject ruleENumberType() throws RecognitionException {
        EObject current = null;

        EObject this_EInteger_0 = null;

        EObject this_EReal_1 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1150:2: ( (this_EInteger_0= ruleEInteger | this_EReal_1= ruleEReal ) )
            // InternalExprParser.g:1151:2: (this_EInteger_0= ruleEInteger | this_EReal_1= ruleEReal )
            {
            // InternalExprParser.g:1151:2: (this_EInteger_0= ruleEInteger | this_EReal_1= ruleEReal )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Int) ) {
                alt19=1;
            }
            else if ( (LA19_0==Real) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalExprParser.g:1152:3: this_EInteger_0= ruleEInteger
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getENumberTypeAccess().getEIntegerParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EInteger_0=ruleEInteger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EInteger_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1161:3: this_EReal_1= ruleEReal
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getENumberTypeAccess().getERealParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EReal_1=ruleEReal();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EReal_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleENumberType"


    // $ANTLR start "entryRuleEInteger"
    // InternalExprParser.g:1173:1: entryRuleEInteger returns [EObject current=null] : iv_ruleEInteger= ruleEInteger EOF ;
    public final EObject entryRuleEInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEInteger = null;


        try {
            // InternalExprParser.g:1173:49: (iv_ruleEInteger= ruleEInteger EOF )
            // InternalExprParser.g:1174:2: iv_ruleEInteger= ruleEInteger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEIntegerRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEInteger=ruleEInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEInteger; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInteger"


    // $ANTLR start "ruleEInteger"
    // InternalExprParser.g:1180:1: ruleEInteger returns [EObject current=null] : ( () otherlv_1= Int ) ;
    public final EObject ruleEInteger() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalExprParser.g:1186:2: ( ( () otherlv_1= Int ) )
            // InternalExprParser.g:1187:2: ( () otherlv_1= Int )
            {
            // InternalExprParser.g:1187:2: ( () otherlv_1= Int )
            // InternalExprParser.g:1188:3: () otherlv_1= Int
            {
            // InternalExprParser.g:1188:3: ()
            // InternalExprParser.g:1189:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getEIntegerAccess().getEIntegerAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEIntegerAccess().getIntKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInteger"


    // $ANTLR start "entryRuleEReal"
    // InternalExprParser.g:1203:1: entryRuleEReal returns [EObject current=null] : iv_ruleEReal= ruleEReal EOF ;
    public final EObject entryRuleEReal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEReal = null;


        try {
            // InternalExprParser.g:1203:46: (iv_ruleEReal= ruleEReal EOF )
            // InternalExprParser.g:1204:2: iv_ruleEReal= ruleEReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getERealRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEReal=ruleEReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEReal; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEReal"


    // $ANTLR start "ruleEReal"
    // InternalExprParser.g:1210:1: ruleEReal returns [EObject current=null] : ( () otherlv_1= Real ) ;
    public final EObject ruleEReal() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalExprParser.g:1216:2: ( ( () otherlv_1= Real ) )
            // InternalExprParser.g:1217:2: ( () otherlv_1= Real )
            {
            // InternalExprParser.g:1217:2: ( () otherlv_1= Real )
            // InternalExprParser.g:1218:3: () otherlv_1= Real
            {
            // InternalExprParser.g:1218:3: ()
            // InternalExprParser.g:1219:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getERealAccess().getERealAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Real,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getERealAccess().getRealKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEReal"


    // $ANTLR start "entryRuleRangeType"
    // InternalExprParser.g:1233:1: entryRuleRangeType returns [EObject current=null] : iv_ruleRangeType= ruleRangeType EOF ;
    public final EObject entryRuleRangeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeType = null;


        try {
            // InternalExprParser.g:1233:50: (iv_ruleRangeType= ruleRangeType EOF )
            // InternalExprParser.g:1234:2: iv_ruleRangeType= ruleRangeType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRangeType=ruleRangeType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeType"


    // $ANTLR start "ruleRangeType"
    // InternalExprParser.g:1240:1: ruleRangeType returns [EObject current=null] : (otherlv_0= Range otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleRangeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1246:2: ( (otherlv_0= Range otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1247:2: (otherlv_0= Range otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1247:2: (otherlv_0= Range otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1248:3: otherlv_0= Range otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Range,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRangeTypeAccess().getRangeKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,Of,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRangeTypeAccess().getOfKeyword_1());
              		
            }
            // InternalExprParser.g:1256:3: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1257:4: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1257:4: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1258:5: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRangeTypeAccess().getTypeTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRangeTypeRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_2_0,
              						"org.osate.expr.Expr.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRangeType"


    // $ANTLR start "entryRuleCategory"
    // InternalExprParser.g:1279:1: entryRuleCategory returns [EObject current=null] : iv_ruleCategory= ruleCategory EOF ;
    public final EObject entryRuleCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategory = null;


        try {
            // InternalExprParser.g:1279:49: (iv_ruleCategory= ruleCategory EOF )
            // InternalExprParser.g:1280:2: iv_ruleCategory= ruleCategory EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCategoryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCategory=ruleCategory();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCategory; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCategory"


    // $ANTLR start "ruleCategory"
    // InternalExprParser.g:1286:1: ruleCategory returns [EObject current=null] : ( (lv_category_0_0= ruleComponentCategory ) ) ;
    public final EObject ruleCategory() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_category_0_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1292:2: ( ( (lv_category_0_0= ruleComponentCategory ) ) )
            // InternalExprParser.g:1293:2: ( (lv_category_0_0= ruleComponentCategory ) )
            {
            // InternalExprParser.g:1293:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // InternalExprParser.g:1294:3: (lv_category_0_0= ruleComponentCategory )
            {
            // InternalExprParser.g:1294:3: (lv_category_0_0= ruleComponentCategory )
            // InternalExprParser.g:1295:4: lv_category_0_0= ruleComponentCategory
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getCategoryAccess().getCategoryComponentCategoryParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_category_0_0=ruleComponentCategory();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getCategoryRule());
              				}
              				set(
              					current,
              					"category",
              					lv_category_0_0,
              					"org.osate.expr.Expr.ComponentCategory");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCategory"


    // $ANTLR start "entryRuleComponentCategory"
    // InternalExprParser.g:1315:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // InternalExprParser.g:1315:57: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // InternalExprParser.g:1316:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentCategory.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentCategory"


    // $ANTLR start "ruleComponentCategory"
    // InternalExprParser.g:1322:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:1328:2: ( (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) ) )
            // InternalExprParser.g:1329:2: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )
            {
            // InternalExprParser.g:1329:2: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )
            int alt20=14;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalExprParser.g:1330:3: kw= Abstract
                    {
                    kw=(Token)match(input,Abstract,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:1336:3: kw= Bus
                    {
                    kw=(Token)match(input,Bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:1342:3: kw= Data
                    {
                    kw=(Token)match(input,Data,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:1348:3: kw= Device
                    {
                    kw=(Token)match(input,Device,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:1354:3: kw= Memory
                    {
                    kw=(Token)match(input,Memory,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExprParser.g:1360:3: kw= Process
                    {
                    kw=(Token)match(input,Process,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalExprParser.g:1366:3: kw= Processor
                    {
                    kw=(Token)match(input,Processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalExprParser.g:1372:3: kw= Subprogram
                    {
                    kw=(Token)match(input,Subprogram,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalExprParser.g:1378:3: (kw= Subprogram kw= Group )
                    {
                    // InternalExprParser.g:1378:3: (kw= Subprogram kw= Group )
                    // InternalExprParser.g:1379:4: kw= Subprogram kw= Group
                    {
                    kw=(Token)match(input,Subprogram,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0());
                      			
                    }
                    kw=(Token)match(input,Group,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalExprParser.g:1391:3: kw= KW_System
                    {
                    kw=(Token)match(input,KW_System,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalExprParser.g:1397:3: (kw= Thread kw= Group )
                    {
                    // InternalExprParser.g:1397:3: (kw= Thread kw= Group )
                    // InternalExprParser.g:1398:4: kw= Thread kw= Group
                    {
                    kw=(Token)match(input,Thread,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0());
                      			
                    }
                    kw=(Token)match(input,Group,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalExprParser.g:1410:3: kw= Thread
                    {
                    kw=(Token)match(input,Thread,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalExprParser.g:1416:3: (kw= Virtual kw= Bus )
                    {
                    // InternalExprParser.g:1416:3: (kw= Virtual kw= Bus )
                    // InternalExprParser.g:1417:4: kw= Virtual kw= Bus
                    {
                    kw=(Token)match(input,Virtual,FollowSets000.FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0());
                      			
                    }
                    kw=(Token)match(input,Bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalExprParser.g:1429:3: (kw= Virtual kw= Processor )
                    {
                    // InternalExprParser.g:1429:3: (kw= Virtual kw= Processor )
                    // InternalExprParser.g:1430:4: kw= Virtual kw= Processor
                    {
                    kw=(Token)match(input,Virtual,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0());
                      			
                    }
                    kw=(Token)match(input,Processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentCategory"


    // $ANTLR start "entryRuleMetaClass"
    // InternalExprParser.g:1445:1: entryRuleMetaClass returns [EObject current=null] : iv_ruleMetaClass= ruleMetaClass EOF ;
    public final EObject entryRuleMetaClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetaClass = null;


        try {
            // InternalExprParser.g:1445:50: (iv_ruleMetaClass= ruleMetaClass EOF )
            // InternalExprParser.g:1446:2: iv_ruleMetaClass= ruleMetaClass EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMetaClassRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMetaClass=ruleMetaClass();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMetaClass; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetaClass"


    // $ANTLR start "ruleMetaClass"
    // InternalExprParser.g:1452:1: ruleMetaClass returns [EObject current=null] : ( (lv_class_0_0= ruleMetaClassEnum ) ) ;
    public final EObject ruleMetaClass() throws RecognitionException {
        EObject current = null;

        Enumerator lv_class_0_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1458:2: ( ( (lv_class_0_0= ruleMetaClassEnum ) ) )
            // InternalExprParser.g:1459:2: ( (lv_class_0_0= ruleMetaClassEnum ) )
            {
            // InternalExprParser.g:1459:2: ( (lv_class_0_0= ruleMetaClassEnum ) )
            // InternalExprParser.g:1460:3: (lv_class_0_0= ruleMetaClassEnum )
            {
            // InternalExprParser.g:1460:3: (lv_class_0_0= ruleMetaClassEnum )
            // InternalExprParser.g:1461:4: lv_class_0_0= ruleMetaClassEnum
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getMetaClassAccess().getClassMetaClassEnumEnumRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_class_0_0=ruleMetaClassEnum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getMetaClassRule());
              				}
              				set(
              					current,
              					"class",
              					lv_class_0_0,
              					"org.osate.expr.Expr.MetaClassEnum");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetaClass"


    // $ANTLR start "entryRuleRecordType"
    // InternalExprParser.g:1481:1: entryRuleRecordType returns [EObject current=null] : iv_ruleRecordType= ruleRecordType EOF ;
    public final EObject entryRuleRecordType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordType = null;


        try {
            // InternalExprParser.g:1481:51: (iv_ruleRecordType= ruleRecordType EOF )
            // InternalExprParser.g:1482:2: iv_ruleRecordType= ruleRecordType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRecordType=ruleRecordType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordType"


    // $ANTLR start "ruleRecordType"
    // InternalExprParser.g:1488:1: ruleRecordType returns [EObject current=null] : ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleRecordType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_fields_3_0 = null;

        EObject lv_fields_5_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1494:2: ( ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalExprParser.g:1495:2: ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalExprParser.g:1495:2: ( () otherlv_1= Record otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalExprParser.g:1496:3: () otherlv_1= Record otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalExprParser.g:1496:3: ()
            // InternalExprParser.g:1497:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRecordTypeAccess().getRecordTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Record,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRecordTypeAccess().getRecordKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRecordTypeAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalExprParser.g:1511:3: ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalExprParser.g:1512:4: ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )*
                    {
                    // InternalExprParser.g:1512:4: ( (lv_fields_3_0= ruleField ) )
                    // InternalExprParser.g:1513:5: (lv_fields_3_0= ruleField )
                    {
                    // InternalExprParser.g:1513:5: (lv_fields_3_0= ruleField )
                    // InternalExprParser.g:1514:6: lv_fields_3_0= ruleField
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRecordTypeAccess().getFieldsFieldParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
                    lv_fields_3_0=ruleField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRecordTypeRule());
                      						}
                      						add(
                      							current,
                      							"fields",
                      							lv_fields_3_0,
                      							"org.osate.expr.Expr.Field");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExprParser.g:1531:4: (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==Comma) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalExprParser.g:1532:5: otherlv_4= Comma ( (lv_fields_5_0= ruleField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getRecordTypeAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalExprParser.g:1536:5: ( (lv_fields_5_0= ruleField ) )
                    	    // InternalExprParser.g:1537:6: (lv_fields_5_0= ruleField )
                    	    {
                    	    // InternalExprParser.g:1537:6: (lv_fields_5_0= ruleField )
                    	    // InternalExprParser.g:1538:7: lv_fields_5_0= ruleField
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRecordTypeAccess().getFieldsFieldParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    lv_fields_5_0=ruleField();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getRecordTypeRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"fields",
                    	      								lv_fields_5_0,
                    	      								"org.osate.expr.Expr.Field");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getRecordTypeAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordType"


    // $ANTLR start "entryRuleField"
    // InternalExprParser.g:1565:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalExprParser.g:1565:46: (iv_ruleField= ruleField EOF )
            // InternalExprParser.g:1566:2: iv_ruleField= ruleField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleField; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalExprParser.g:1572:1: ruleField returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1578:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) ) )
            // InternalExprParser.g:1579:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) )
            {
            // InternalExprParser.g:1579:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) ) )
            // InternalExprParser.g:1580:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleType ) )
            {
            // InternalExprParser.g:1580:3: ()
            // InternalExprParser.g:1581:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFieldAccess().getFieldAction_0(),
              					current);
              			
            }

            }

            // InternalExprParser.g:1587:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExprParser.g:1588:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExprParser.g:1588:4: (lv_name_1_0= RULE_ID )
            // InternalExprParser.g:1589:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFieldRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFieldAccess().getColonKeyword_2());
              		
            }
            // InternalExprParser.g:1609:3: ( (lv_type_3_0= ruleType ) )
            // InternalExprParser.g:1610:4: (lv_type_3_0= ruleType )
            {
            // InternalExprParser.g:1610:4: (lv_type_3_0= ruleType )
            // InternalExprParser.g:1611:5: lv_type_3_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFieldRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_3_0,
              						"org.osate.expr.Expr.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleUnionType"
    // InternalExprParser.g:1632:1: entryRuleUnionType returns [EObject current=null] : iv_ruleUnionType= ruleUnionType EOF ;
    public final EObject entryRuleUnionType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnionType = null;


        try {
            // InternalExprParser.g:1632:50: (iv_ruleUnionType= ruleUnionType EOF )
            // InternalExprParser.g:1633:2: iv_ruleUnionType= ruleUnionType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnionTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnionType=ruleUnionType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnionType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnionType"


    // $ANTLR start "ruleUnionType"
    // InternalExprParser.g:1639:1: ruleUnionType returns [EObject current=null] : ( () otherlv_1= Union otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleUnionType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_fields_3_0 = null;

        EObject lv_fields_5_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1645:2: ( ( () otherlv_1= Union otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalExprParser.g:1646:2: ( () otherlv_1= Union otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalExprParser.g:1646:2: ( () otherlv_1= Union otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalExprParser.g:1647:3: () otherlv_1= Union otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalExprParser.g:1647:3: ()
            // InternalExprParser.g:1648:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUnionTypeAccess().getUnionTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Union,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUnionTypeAccess().getUnionKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getUnionTypeAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalExprParser.g:1662:3: ( ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalExprParser.g:1663:4: ( (lv_fields_3_0= ruleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )*
                    {
                    // InternalExprParser.g:1663:4: ( (lv_fields_3_0= ruleField ) )
                    // InternalExprParser.g:1664:5: (lv_fields_3_0= ruleField )
                    {
                    // InternalExprParser.g:1664:5: (lv_fields_3_0= ruleField )
                    // InternalExprParser.g:1665:6: lv_fields_3_0= ruleField
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnionTypeAccess().getFieldsFieldParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
                    lv_fields_3_0=ruleField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnionTypeRule());
                      						}
                      						add(
                      							current,
                      							"fields",
                      							lv_fields_3_0,
                      							"org.osate.expr.Expr.Field");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExprParser.g:1682:4: (otherlv_4= Comma ( (lv_fields_5_0= ruleField ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==Comma) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalExprParser.g:1683:5: otherlv_4= Comma ( (lv_fields_5_0= ruleField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getUnionTypeAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalExprParser.g:1687:5: ( (lv_fields_5_0= ruleField ) )
                    	    // InternalExprParser.g:1688:6: (lv_fields_5_0= ruleField )
                    	    {
                    	    // InternalExprParser.g:1688:6: (lv_fields_5_0= ruleField )
                    	    // InternalExprParser.g:1689:7: lv_fields_5_0= ruleField
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getUnionTypeAccess().getFieldsFieldParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    lv_fields_5_0=ruleField();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getUnionTypeRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"fields",
                    	      								lv_fields_5_0,
                    	      								"org.osate.expr.Expr.Field");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getUnionTypeAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnionType"


    // $ANTLR start "entryRuleTupleType"
    // InternalExprParser.g:1716:1: entryRuleTupleType returns [EObject current=null] : iv_ruleTupleType= ruleTupleType EOF ;
    public final EObject entryRuleTupleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleType = null;


        try {
            // InternalExprParser.g:1716:50: (iv_ruleTupleType= ruleTupleType EOF )
            // InternalExprParser.g:1717:2: iv_ruleTupleType= ruleTupleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleType=ruleTupleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleType"


    // $ANTLR start "ruleTupleType"
    // InternalExprParser.g:1723:1: ruleTupleType returns [EObject current=null] : ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleTupleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_fields_3_0 = null;

        EObject lv_fields_5_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1729:2: ( ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalExprParser.g:1730:2: ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalExprParser.g:1730:2: ( () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalExprParser.g:1731:3: () otherlv_1= Tuple otherlv_2= LeftCurlyBracket ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalExprParser.g:1731:3: ()
            // InternalExprParser.g:1732:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTupleTypeAccess().getTupleTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Tuple,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTupleTypeAccess().getTupleKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getTupleTypeAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalExprParser.g:1746:3: ( ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=Connection && LA26_0<=Processor)||LA26_0==Abstract||LA26_0==Property||LA26_0==Feature||(LA26_0>=Process && LA26_0<=Virtual)||(LA26_0>=Device && LA26_0<=Thread)||(LA26_0>=Range && LA26_0<=Data)||(LA26_0>=Enum && LA26_0<=Flow)||(LA26_0>=List && LA26_0<=Real)||(LA26_0>=Bag && LA26_0<=Bus)||(LA26_0>=Int && LA26_0<=Map)||LA26_0==Set||LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalExprParser.g:1747:4: ( (lv_fields_3_0= ruleTupleField ) ) (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )*
                    {
                    // InternalExprParser.g:1747:4: ( (lv_fields_3_0= ruleTupleField ) )
                    // InternalExprParser.g:1748:5: (lv_fields_3_0= ruleTupleField )
                    {
                    // InternalExprParser.g:1748:5: (lv_fields_3_0= ruleTupleField )
                    // InternalExprParser.g:1749:6: lv_fields_3_0= ruleTupleField
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTupleTypeAccess().getFieldsTupleFieldParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
                    lv_fields_3_0=ruleTupleField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTupleTypeRule());
                      						}
                      						add(
                      							current,
                      							"fields",
                      							lv_fields_3_0,
                      							"org.osate.expr.Expr.TupleField");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExprParser.g:1766:4: (otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==Comma) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalExprParser.g:1767:5: otherlv_4= Comma ( (lv_fields_5_0= ruleTupleField ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getTupleTypeAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalExprParser.g:1771:5: ( (lv_fields_5_0= ruleTupleField ) )
                    	    // InternalExprParser.g:1772:6: (lv_fields_5_0= ruleTupleField )
                    	    {
                    	    // InternalExprParser.g:1772:6: (lv_fields_5_0= ruleTupleField )
                    	    // InternalExprParser.g:1773:7: lv_fields_5_0= ruleTupleField
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getTupleTypeAccess().getFieldsTupleFieldParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    lv_fields_5_0=ruleTupleField();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getTupleTypeRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"fields",
                    	      								lv_fields_5_0,
                    	      								"org.osate.expr.Expr.TupleField");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getTupleTypeAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleType"


    // $ANTLR start "entryRuleTupleField"
    // InternalExprParser.g:1800:1: entryRuleTupleField returns [EObject current=null] : iv_ruleTupleField= ruleTupleField EOF ;
    public final EObject entryRuleTupleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleField = null;


        try {
            // InternalExprParser.g:1800:51: (iv_ruleTupleField= ruleTupleField EOF )
            // InternalExprParser.g:1801:2: iv_ruleTupleField= ruleTupleField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleFieldRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleField=ruleTupleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleField; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleField"


    // $ANTLR start "ruleTupleField"
    // InternalExprParser.g:1807:1: ruleTupleField returns [EObject current=null] : ( (lv_type_0_0= ruleType ) ) ;
    public final EObject ruleTupleField() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1813:2: ( ( (lv_type_0_0= ruleType ) ) )
            // InternalExprParser.g:1814:2: ( (lv_type_0_0= ruleType ) )
            {
            // InternalExprParser.g:1814:2: ( (lv_type_0_0= ruleType ) )
            // InternalExprParser.g:1815:3: (lv_type_0_0= ruleType )
            {
            // InternalExprParser.g:1815:3: (lv_type_0_0= ruleType )
            // InternalExprParser.g:1816:4: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getTupleFieldAccess().getTypeTypeParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getTupleFieldRule());
              				}
              				set(
              					current,
              					"type",
              					lv_type_0_0,
              					"org.osate.expr.Expr.Type");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleField"


    // $ANTLR start "entryRuleListType"
    // InternalExprParser.g:1836:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalExprParser.g:1836:49: (iv_ruleListType= ruleListType EOF )
            // InternalExprParser.g:1837:2: iv_ruleListType= ruleListType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleListType=ruleListType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListType"


    // $ANTLR start "ruleListType"
    // InternalExprParser.g:1843:1: ruleListType returns [EObject current=null] : (otherlv_0= List otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1849:2: ( (otherlv_0= List otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1850:2: (otherlv_0= List otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1850:2: (otherlv_0= List otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1851:3: otherlv_0= List otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,List,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,Of,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getListTypeAccess().getOfKeyword_1());
              		
            }
            // InternalExprParser.g:1859:3: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1860:4: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1860:4: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1861:5: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getListTypeAccess().getTypeTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getListTypeRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_2_0,
              						"org.osate.expr.Expr.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListType"


    // $ANTLR start "entryRuleSetType"
    // InternalExprParser.g:1882:1: entryRuleSetType returns [EObject current=null] : iv_ruleSetType= ruleSetType EOF ;
    public final EObject entryRuleSetType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetType = null;


        try {
            // InternalExprParser.g:1882:48: (iv_ruleSetType= ruleSetType EOF )
            // InternalExprParser.g:1883:2: iv_ruleSetType= ruleSetType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSetType=ruleSetType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetType"


    // $ANTLR start "ruleSetType"
    // InternalExprParser.g:1889:1: ruleSetType returns [EObject current=null] : (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleSetType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1895:2: ( (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1896:2: (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1896:2: (otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1897:3: otherlv_0= Set otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Set,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSetTypeAccess().getSetKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,Of,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSetTypeAccess().getOfKeyword_1());
              		
            }
            // InternalExprParser.g:1905:3: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1906:4: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1906:4: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1907:5: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSetTypeAccess().getTypeTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSetTypeRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_2_0,
              						"org.osate.expr.Expr.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetType"


    // $ANTLR start "entryRuleBagType"
    // InternalExprParser.g:1928:1: entryRuleBagType returns [EObject current=null] : iv_ruleBagType= ruleBagType EOF ;
    public final EObject entryRuleBagType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBagType = null;


        try {
            // InternalExprParser.g:1928:48: (iv_ruleBagType= ruleBagType EOF )
            // InternalExprParser.g:1929:2: iv_ruleBagType= ruleBagType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBagTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBagType=ruleBagType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBagType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBagType"


    // $ANTLR start "ruleBagType"
    // InternalExprParser.g:1935:1: ruleBagType returns [EObject current=null] : (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleBagType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1941:2: ( (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) ) )
            // InternalExprParser.g:1942:2: (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            {
            // InternalExprParser.g:1942:2: (otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) ) )
            // InternalExprParser.g:1943:3: otherlv_0= Bag otherlv_1= Of ( (lv_type_2_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Bag,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBagTypeAccess().getBagKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,Of,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBagTypeAccess().getOfKeyword_1());
              		
            }
            // InternalExprParser.g:1951:3: ( (lv_type_2_0= ruleType ) )
            // InternalExprParser.g:1952:4: (lv_type_2_0= ruleType )
            {
            // InternalExprParser.g:1952:4: (lv_type_2_0= ruleType )
            // InternalExprParser.g:1953:5: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBagTypeAccess().getTypeTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBagTypeRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_2_0,
              						"org.osate.expr.Expr.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBagType"


    // $ANTLR start "entryRuleMapType"
    // InternalExprParser.g:1974:1: entryRuleMapType returns [EObject current=null] : iv_ruleMapType= ruleMapType EOF ;
    public final EObject entryRuleMapType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapType = null;


        try {
            // InternalExprParser.g:1974:48: (iv_ruleMapType= ruleMapType EOF )
            // InternalExprParser.g:1975:2: iv_ruleMapType= ruleMapType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMapType=ruleMapType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapType"


    // $ANTLR start "ruleMapType"
    // InternalExprParser.g:1981:1: ruleMapType returns [EObject current=null] : (otherlv_0= Map ( (lv_domain_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_image_3_0= ruleType ) ) ) ;
    public final EObject ruleMapType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_domain_1_0 = null;

        EObject lv_image_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:1987:2: ( (otherlv_0= Map ( (lv_domain_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_image_3_0= ruleType ) ) ) )
            // InternalExprParser.g:1988:2: (otherlv_0= Map ( (lv_domain_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_image_3_0= ruleType ) ) )
            {
            // InternalExprParser.g:1988:2: (otherlv_0= Map ( (lv_domain_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_image_3_0= ruleType ) ) )
            // InternalExprParser.g:1989:3: otherlv_0= Map ( (lv_domain_1_0= ruleType ) ) otherlv_2= HyphenMinusGreaterThanSign ( (lv_image_3_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,Map,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMapTypeAccess().getMapKeyword_0());
              		
            }
            // InternalExprParser.g:1993:3: ( (lv_domain_1_0= ruleType ) )
            // InternalExprParser.g:1994:4: (lv_domain_1_0= ruleType )
            {
            // InternalExprParser.g:1994:4: (lv_domain_1_0= ruleType )
            // InternalExprParser.g:1995:5: lv_domain_1_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMapTypeAccess().getDomainTypeParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_27);
            lv_domain_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMapTypeRule());
              					}
              					set(
              						current,
              						"domain",
              						lv_domain_1_0,
              						"org.osate.expr.Expr.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,HyphenMinusGreaterThanSign,FollowSets000.FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getMapTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
              		
            }
            // InternalExprParser.g:2016:3: ( (lv_image_3_0= ruleType ) )
            // InternalExprParser.g:2017:4: (lv_image_3_0= ruleType )
            {
            // InternalExprParser.g:2017:4: (lv_image_3_0= ruleType )
            // InternalExprParser.g:2018:5: lv_image_3_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMapTypeAccess().getImageTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_image_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMapTypeRule());
              					}
              					set(
              						current,
              						"image",
              						lv_image_3_0,
              						"org.osate.expr.Expr.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapType"


    // $ANTLR start "entryRuleEnumType"
    // InternalExprParser.g:2039:1: entryRuleEnumType returns [EObject current=null] : iv_ruleEnumType= ruleEnumType EOF ;
    public final EObject entryRuleEnumType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumType = null;


        try {
            // InternalExprParser.g:2039:49: (iv_ruleEnumType= ruleEnumType EOF )
            // InternalExprParser.g:2040:2: iv_ruleEnumType= ruleEnumType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumType=ruleEnumType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumType"


    // $ANTLR start "ruleEnumType"
    // InternalExprParser.g:2046:1: ruleEnumType returns [EObject current=null] : ( () otherlv_1= Enum otherlv_2= LeftCurlyBracket ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleEnumType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_literals_3_0 = null;

        EObject lv_literals_5_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:2052:2: ( ( () otherlv_1= Enum otherlv_2= LeftCurlyBracket ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalExprParser.g:2053:2: ( () otherlv_1= Enum otherlv_2= LeftCurlyBracket ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalExprParser.g:2053:2: ( () otherlv_1= Enum otherlv_2= LeftCurlyBracket ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalExprParser.g:2054:3: () otherlv_1= Enum otherlv_2= LeftCurlyBracket ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalExprParser.g:2054:3: ()
            // InternalExprParser.g:2055:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getEnumTypeAccess().getEnumTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Enum,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEnumTypeAccess().getEnumKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEnumTypeAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalExprParser.g:2069:3: ( ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalExprParser.g:2070:4: ( (lv_literals_3_0= ruleEnumLiteral ) ) (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )*
                    {
                    // InternalExprParser.g:2070:4: ( (lv_literals_3_0= ruleEnumLiteral ) )
                    // InternalExprParser.g:2071:5: (lv_literals_3_0= ruleEnumLiteral )
                    {
                    // InternalExprParser.g:2071:5: (lv_literals_3_0= ruleEnumLiteral )
                    // InternalExprParser.g:2072:6: lv_literals_3_0= ruleEnumLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEnumTypeAccess().getLiteralsEnumLiteralParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
                    lv_literals_3_0=ruleEnumLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEnumTypeRule());
                      						}
                      						add(
                      							current,
                      							"literals",
                      							lv_literals_3_0,
                      							"org.osate.expr.Expr.EnumLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExprParser.g:2089:4: (otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==Comma) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalExprParser.g:2090:5: otherlv_4= Comma ( (lv_literals_5_0= ruleEnumLiteral ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getEnumTypeAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalExprParser.g:2094:5: ( (lv_literals_5_0= ruleEnumLiteral ) )
                    	    // InternalExprParser.g:2095:6: (lv_literals_5_0= ruleEnumLiteral )
                    	    {
                    	    // InternalExprParser.g:2095:6: (lv_literals_5_0= ruleEnumLiteral )
                    	    // InternalExprParser.g:2096:7: lv_literals_5_0= ruleEnumLiteral
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getEnumTypeAccess().getLiteralsEnumLiteralParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    lv_literals_5_0=ruleEnumLiteral();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getEnumTypeRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"literals",
                    	      								lv_literals_5_0,
                    	      								"org.osate.expr.Expr.EnumLiteral");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEnumTypeAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumType"


    // $ANTLR start "entryRuleEnumLiteral"
    // InternalExprParser.g:2123:1: entryRuleEnumLiteral returns [EObject current=null] : iv_ruleEnumLiteral= ruleEnumLiteral EOF ;
    public final EObject entryRuleEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteral = null;


        try {
            // InternalExprParser.g:2123:52: (iv_ruleEnumLiteral= ruleEnumLiteral EOF )
            // InternalExprParser.g:2124:2: iv_ruleEnumLiteral= ruleEnumLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEnumLiteral=ruleEnumLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumLiteral"


    // $ANTLR start "ruleEnumLiteral"
    // InternalExprParser.g:2130:1: ruleEnumLiteral returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalExprParser.g:2136:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalExprParser.g:2137:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalExprParser.g:2137:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalExprParser.g:2138:3: (lv_name_0_0= RULE_ID )
            {
            // InternalExprParser.g:2138:3: (lv_name_0_0= RULE_ID )
            // InternalExprParser.g:2139:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_name_0_0, grammarAccess.getEnumLiteralAccess().getNameIDTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getEnumLiteralRule());
              				}
              				setWithLastConsumed(
              					current,
              					"name",
              					lv_name_0_0,
              					"org.osate.xtext.aadl2.properties.Properties.ID");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumLiteral"


    // $ANTLR start "entryRuleTypeRef"
    // InternalExprParser.g:2158:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // InternalExprParser.g:2158:48: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalExprParser.g:2159:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalExprParser.g:2165:1: ruleTypeRef returns [EObject current=null] : ( ( ruleQCREF ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalExprParser.g:2171:2: ( ( ( ruleQCREF ) ) )
            // InternalExprParser.g:2172:2: ( ( ruleQCREF ) )
            {
            // InternalExprParser.g:2172:2: ( ( ruleQCREF ) )
            // InternalExprParser.g:2173:3: ( ruleQCREF )
            {
            // InternalExprParser.g:2173:3: ( ruleQCREF )
            // InternalExprParser.g:2174:4: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getTypeRefRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getTypeRefAccess().getRefNamedElementCrossReference_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleExpression"
    // InternalExprParser.g:2191:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalExprParser.g:2191:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalExprParser.g:2192:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalExprParser.g:2198:1: ruleExpression returns [EObject current=null] : (this_OrExpression_0= ruleOrExpression | this_BlockExpression_1= ruleBlockExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;

        EObject this_BlockExpression_1 = null;



        	enterRule();

        try {
            // InternalExprParser.g:2204:2: ( (this_OrExpression_0= ruleOrExpression | this_BlockExpression_1= ruleBlockExpression ) )
            // InternalExprParser.g:2205:2: (this_OrExpression_0= ruleOrExpression | this_BlockExpression_1= ruleBlockExpression )
            {
            // InternalExprParser.g:2205:2: (this_OrExpression_0= ruleOrExpression | this_BlockExpression_1= ruleBlockExpression )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==Record||LA29_0==False||(LA29_0>=Tuple && LA29_0<=Union)||LA29_0==List||LA29_0==True||LA29_0==Bag||LA29_0==Map||(LA29_0>=Not && LA29_0<=Set)||LA29_0==If||LA29_0==LeftParenthesis||LA29_0==PlusSign||LA29_0==HyphenMinus||LA29_0==LeftSquareBracket||LA29_0==CircumflexAccent||LA29_0==RULE_REAL_LIT||LA29_0==RULE_INTEGER_LIT||(LA29_0>=RULE_STRING && LA29_0<=RULE_ID)) ) {
                alt29=1;
            }
            else if ( (LA29_0==LeftCurlyBracket) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalExprParser.g:2206:3: this_OrExpression_0= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getOrExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OrExpression_0=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_OrExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2215:3: this_BlockExpression_1= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getBlockExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BlockExpression_1=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleBlockExpression"
    // InternalExprParser.g:2227:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockExpression = null;


        try {
            // InternalExprParser.g:2227:56: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // InternalExprParser.g:2228:2: iv_ruleBlockExpression= ruleBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBlockExpression=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockExpression"


    // $ANTLR start "ruleBlockExpression"
    // InternalExprParser.g:2234:1: ruleBlockExpression returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( ( (lv_decls_2_0= ruleVarDecl ) ) otherlv_3= Semicolon )* ( (lv_result_4_0= ruleExpression ) ) otherlv_5= RightCurlyBracket ) ;
    public final EObject ruleBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_decls_2_0 = null;

        EObject lv_result_4_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:2240:2: ( ( () otherlv_1= LeftCurlyBracket ( ( (lv_decls_2_0= ruleVarDecl ) ) otherlv_3= Semicolon )* ( (lv_result_4_0= ruleExpression ) ) otherlv_5= RightCurlyBracket ) )
            // InternalExprParser.g:2241:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_decls_2_0= ruleVarDecl ) ) otherlv_3= Semicolon )* ( (lv_result_4_0= ruleExpression ) ) otherlv_5= RightCurlyBracket )
            {
            // InternalExprParser.g:2241:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_decls_2_0= ruleVarDecl ) ) otherlv_3= Semicolon )* ( (lv_result_4_0= ruleExpression ) ) otherlv_5= RightCurlyBracket )
            // InternalExprParser.g:2242:3: () otherlv_1= LeftCurlyBracket ( ( (lv_decls_2_0= ruleVarDecl ) ) otherlv_3= Semicolon )* ( (lv_result_4_0= ruleExpression ) ) otherlv_5= RightCurlyBracket
            {
            // InternalExprParser.g:2242:3: ()
            // InternalExprParser.g:2243:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockExpressionAccess().getBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalExprParser.g:2253:3: ( ( (lv_decls_2_0= ruleVarDecl ) ) otherlv_3= Semicolon )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=Val && LA30_0<=Var)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalExprParser.g:2254:4: ( (lv_decls_2_0= ruleVarDecl ) ) otherlv_3= Semicolon
            	    {
            	    // InternalExprParser.g:2254:4: ( (lv_decls_2_0= ruleVarDecl ) )
            	    // InternalExprParser.g:2255:5: (lv_decls_2_0= ruleVarDecl )
            	    {
            	    // InternalExprParser.g:2255:5: (lv_decls_2_0= ruleVarDecl )
            	    // InternalExprParser.g:2256:6: lv_decls_2_0= ruleVarDecl
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBlockExpressionAccess().getDeclsVarDeclParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_29);
            	    lv_decls_2_0=ruleVarDecl();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBlockExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"decls",
            	      							lv_decls_2_0,
            	      							"org.osate.expr.Expr.VarDecl");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,Semicolon,FollowSets000.FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getBlockExpressionAccess().getSemicolonKeyword_2_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            // InternalExprParser.g:2278:3: ( (lv_result_4_0= ruleExpression ) )
            // InternalExprParser.g:2279:4: (lv_result_4_0= ruleExpression )
            {
            // InternalExprParser.g:2279:4: (lv_result_4_0= ruleExpression )
            // InternalExprParser.g:2280:5: lv_result_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBlockExpressionAccess().getResultExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_30);
            lv_result_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBlockExpressionRule());
              					}
              					set(
              						current,
              						"result",
              						lv_result_4_0,
              						"org.osate.expr.Expr.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getBlockExpressionAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlockExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalExprParser.g:2305:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalExprParser.g:2305:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalExprParser.g:2306:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalExprParser.g:2312:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:2318:2: ( (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalExprParser.g:2319:2: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalExprParser.g:2319:2: (this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalExprParser.g:2320:3: this_AndExpression_0= ruleAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_31);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExprParser.g:2328:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==Or) && (synpred1_InternalExprParser())) {
                    alt31=1;
                }
                else if ( (LA31_0==VerticalLineVerticalLine) && (synpred1_InternalExprParser())) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalExprParser.g:2329:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalExprParser.g:2329:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) )
            	    // InternalExprParser.g:2330:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    {
            	    // InternalExprParser.g:2340:5: ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    // InternalExprParser.g:2341:6: () ( (lv_operator_2_0= ruleOpOr ) )
            	    {
            	    // InternalExprParser.g:2341:6: ()
            	    // InternalExprParser.g:2342:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalExprParser.g:2348:6: ( (lv_operator_2_0= ruleOpOr ) )
            	    // InternalExprParser.g:2349:7: (lv_operator_2_0= ruleOpOr )
            	    {
            	    // InternalExprParser.g:2349:7: (lv_operator_2_0= ruleOpOr )
            	    // InternalExprParser.g:2350:8: lv_operator_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FollowSets000.FOLLOW_32);
            	    lv_operator_2_0=ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.expr.Expr.OpOr");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:2369:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalExprParser.g:2370:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalExprParser.g:2370:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalExprParser.g:2371:6: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_31);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.expr.Expr.AndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // InternalExprParser.g:2393:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalExprParser.g:2393:44: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalExprParser.g:2394:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // InternalExprParser.g:2400:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Or | kw= VerticalLineVerticalLine ) ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:2406:2: ( (kw= Or | kw= VerticalLineVerticalLine ) )
            // InternalExprParser.g:2407:2: (kw= Or | kw= VerticalLineVerticalLine )
            {
            // InternalExprParser.g:2407:2: (kw= Or | kw= VerticalLineVerticalLine )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==Or) ) {
                alt32=1;
            }
            else if ( (LA32_0==VerticalLineVerticalLine) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalExprParser.g:2408:3: kw= Or
                    {
                    kw=(Token)match(input,Or,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2414:3: kw= VerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLine,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleAndExpression"
    // InternalExprParser.g:2423:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalExprParser.g:2423:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalExprParser.g:2424:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalExprParser.g:2430:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:2436:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalExprParser.g:2437:2: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalExprParser.g:2437:2: (this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalExprParser.g:2438:3: this_EqualityExpression_0= ruleEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_33);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExprParser.g:2446:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==And) && (synpred2_InternalExprParser())) {
                    alt33=1;
                }
                else if ( (LA33_0==AmpersandAmpersand) && (synpred2_InternalExprParser())) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalExprParser.g:2447:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalExprParser.g:2447:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) )
            	    // InternalExprParser.g:2448:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    {
            	    // InternalExprParser.g:2458:5: ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    // InternalExprParser.g:2459:6: () ( (lv_operator_2_0= ruleOpAnd ) )
            	    {
            	    // InternalExprParser.g:2459:6: ()
            	    // InternalExprParser.g:2460:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalExprParser.g:2466:6: ( (lv_operator_2_0= ruleOpAnd ) )
            	    // InternalExprParser.g:2467:7: (lv_operator_2_0= ruleOpAnd )
            	    {
            	    // InternalExprParser.g:2467:7: (lv_operator_2_0= ruleOpAnd )
            	    // InternalExprParser.g:2468:8: lv_operator_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FollowSets000.FOLLOW_32);
            	    lv_operator_2_0=ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.expr.Expr.OpAnd");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:2487:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalExprParser.g:2488:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalExprParser.g:2488:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalExprParser.g:2489:6: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_33);
            	    lv_right_3_0=ruleEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.expr.Expr.EqualityExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // InternalExprParser.g:2511:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalExprParser.g:2511:45: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalExprParser.g:2512:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // InternalExprParser.g:2518:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= And | kw= AmpersandAmpersand ) ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:2524:2: ( (kw= And | kw= AmpersandAmpersand ) )
            // InternalExprParser.g:2525:2: (kw= And | kw= AmpersandAmpersand )
            {
            // InternalExprParser.g:2525:2: (kw= And | kw= AmpersandAmpersand )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==And) ) {
                alt34=1;
            }
            else if ( (LA34_0==AmpersandAmpersand) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalExprParser.g:2526:3: kw= And
                    {
                    kw=(Token)match(input,And,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2532:3: kw= AmpersandAmpersand
                    {
                    kw=(Token)match(input,AmpersandAmpersand,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalExprParser.g:2541:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalExprParser.g:2541:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalExprParser.g:2542:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalExprParser.g:2548:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:2554:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalExprParser.g:2555:2: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalExprParser.g:2555:2: (this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // InternalExprParser.g:2556:3: this_RelationalExpression_0= ruleRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_34);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExprParser.g:2564:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==EqualsSignEqualsSign) && (synpred3_InternalExprParser())) {
                    alt35=1;
                }
                else if ( (LA35_0==ExclamationMarkEqualsSign) && (synpred3_InternalExprParser())) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalExprParser.g:2565:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
            	    {
            	    // InternalExprParser.g:2565:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) )
            	    // InternalExprParser.g:2566:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    {
            	    // InternalExprParser.g:2576:5: ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    // InternalExprParser.g:2577:6: () ( (lv_operator_2_0= ruleOpEquality ) )
            	    {
            	    // InternalExprParser.g:2577:6: ()
            	    // InternalExprParser.g:2578:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalExprParser.g:2584:6: ( (lv_operator_2_0= ruleOpEquality ) )
            	    // InternalExprParser.g:2585:7: (lv_operator_2_0= ruleOpEquality )
            	    {
            	    // InternalExprParser.g:2585:7: (lv_operator_2_0= ruleOpEquality )
            	    // InternalExprParser.g:2586:8: lv_operator_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FollowSets000.FOLLOW_32);
            	    lv_operator_2_0=ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.expr.Expr.OpEquality");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:2605:4: ( (lv_right_3_0= ruleRelationalExpression ) )
            	    // InternalExprParser.g:2606:5: (lv_right_3_0= ruleRelationalExpression )
            	    {
            	    // InternalExprParser.g:2606:5: (lv_right_3_0= ruleRelationalExpression )
            	    // InternalExprParser.g:2607:6: lv_right_3_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_34);
            	    lv_right_3_0=ruleRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.expr.Expr.RelationalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // InternalExprParser.g:2629:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalExprParser.g:2629:50: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalExprParser.g:2630:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // InternalExprParser.g:2636:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:2642:2: ( (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign ) )
            // InternalExprParser.g:2643:2: (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign )
            {
            // InternalExprParser.g:2643:2: (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==EqualsSignEqualsSign) ) {
                alt36=1;
            }
            else if ( (LA36_0==ExclamationMarkEqualsSign) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalExprParser.g:2644:3: kw= EqualsSignEqualsSign
                    {
                    kw=(Token)match(input,EqualsSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2650:3: kw= ExclamationMarkEqualsSign
                    {
                    kw=(Token)match(input,ExclamationMarkEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalExprParser.g:2659:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalExprParser.g:2659:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalExprParser.g:2660:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalExprParser.g:2666:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:2672:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalExprParser.g:2673:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalExprParser.g:2673:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalExprParser.g:2674:3: this_AdditiveExpression_0= ruleAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_35);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExprParser.g:2682:3: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==GreaterThanSignEqualsSign) && (synpred4_InternalExprParser())) {
                    alt37=1;
                }
                else if ( (LA37_0==LessThanSignEqualsSign) && (synpred4_InternalExprParser())) {
                    alt37=1;
                }
                else if ( (LA37_0==GreaterThanSign) && (synpred4_InternalExprParser())) {
                    alt37=1;
                }
                else if ( (LA37_0==LessThanSign) && (synpred4_InternalExprParser())) {
                    alt37=1;
                }
                else if ( (LA37_0==GreaterThanSignLessThanSign) && (synpred4_InternalExprParser())) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalExprParser.g:2683:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalExprParser.g:2683:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) )
            	    // InternalExprParser.g:2684:5: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    {
            	    // InternalExprParser.g:2694:5: ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    // InternalExprParser.g:2695:6: () ( (lv_operator_2_0= ruleOpCompare ) )
            	    {
            	    // InternalExprParser.g:2695:6: ()
            	    // InternalExprParser.g:2696:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalExprParser.g:2702:6: ( (lv_operator_2_0= ruleOpCompare ) )
            	    // InternalExprParser.g:2703:7: (lv_operator_2_0= ruleOpCompare )
            	    {
            	    // InternalExprParser.g:2703:7: (lv_operator_2_0= ruleOpCompare )
            	    // InternalExprParser.g:2704:8: lv_operator_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FollowSets000.FOLLOW_32);
            	    lv_operator_2_0=ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.expr.Expr.OpCompare");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:2723:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalExprParser.g:2724:5: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalExprParser.g:2724:5: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalExprParser.g:2725:6: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_35);
            	    lv_right_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.expr.Expr.AdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // InternalExprParser.g:2747:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalExprParser.g:2747:49: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalExprParser.g:2748:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // InternalExprParser.g:2754:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:2760:2: ( (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign ) )
            // InternalExprParser.g:2761:2: (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign )
            {
            // InternalExprParser.g:2761:2: (kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign | kw= GreaterThanSignLessThanSign )
            int alt38=5;
            switch ( input.LA(1) ) {
            case GreaterThanSignEqualsSign:
                {
                alt38=1;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt38=2;
                }
                break;
            case GreaterThanSign:
                {
                alt38=3;
                }
                break;
            case LessThanSign:
                {
                alt38=4;
                }
                break;
            case GreaterThanSignLessThanSign:
                {
                alt38=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalExprParser.g:2762:3: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2768:3: kw= LessThanSignEqualsSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:2774:3: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:2780:3: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:2786:3: kw= GreaterThanSignLessThanSign
                    {
                    kw=(Token)match(input,GreaterThanSignLessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalExprParser.g:2795:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalExprParser.g:2795:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalExprParser.g:2796:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalExprParser.g:2802:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:2808:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalExprParser.g:2809:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalExprParser.g:2809:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalExprParser.g:2810:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_36);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExprParser.g:2818:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==PlusSign) && (synpred5_InternalExprParser())) {
                    alt39=1;
                }
                else if ( (LA39_0==HyphenMinus) && (synpred5_InternalExprParser())) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalExprParser.g:2819:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalExprParser.g:2819:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) )
            	    // InternalExprParser.g:2820:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    {
            	    // InternalExprParser.g:2830:5: ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    // InternalExprParser.g:2831:6: () ( (lv_operator_2_0= ruleOpAdd ) )
            	    {
            	    // InternalExprParser.g:2831:6: ()
            	    // InternalExprParser.g:2832:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalExprParser.g:2838:6: ( (lv_operator_2_0= ruleOpAdd ) )
            	    // InternalExprParser.g:2839:7: (lv_operator_2_0= ruleOpAdd )
            	    {
            	    // InternalExprParser.g:2839:7: (lv_operator_2_0= ruleOpAdd )
            	    // InternalExprParser.g:2840:8: lv_operator_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FollowSets000.FOLLOW_32);
            	    lv_operator_2_0=ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.expr.Expr.OpAdd");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:2859:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    // InternalExprParser.g:2860:5: (lv_right_3_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalExprParser.g:2860:5: (lv_right_3_0= ruleMultiplicativeExpression )
            	    // InternalExprParser.g:2861:6: lv_right_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_36);
            	    lv_right_3_0=ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.expr.Expr.MultiplicativeExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // InternalExprParser.g:2883:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalExprParser.g:2883:45: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalExprParser.g:2884:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // InternalExprParser.g:2890:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:2896:2: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalExprParser.g:2897:2: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalExprParser.g:2897:2: (kw= PlusSign | kw= HyphenMinus )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==PlusSign) ) {
                alt40=1;
            }
            else if ( (LA40_0==HyphenMinus) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalExprParser.g:2898:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:2904:3: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalExprParser.g:2913:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalExprParser.g:2913:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalExprParser.g:2914:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalExprParser.g:2920:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:2926:2: ( (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* ) )
            // InternalExprParser.g:2927:2: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            {
            // InternalExprParser.g:2927:2: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )* )
            // InternalExprParser.g:2928:3: this_UnaryOperation_0= ruleUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getUnaryOperationParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_37);
            this_UnaryOperation_0=ruleUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_UnaryOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExprParser.g:2936:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==Asterisk) && (synpred6_InternalExprParser())) {
                    alt41=1;
                }
                else if ( (LA41_0==Solidus) && (synpred6_InternalExprParser())) {
                    alt41=1;
                }
                else if ( (LA41_0==Div) && (synpred6_InternalExprParser())) {
                    alt41=1;
                }
                else if ( (LA41_0==Mod) && (synpred6_InternalExprParser())) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalExprParser.g:2937:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleUnaryOperation ) )
            	    {
            	    // InternalExprParser.g:2937:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) )
            	    // InternalExprParser.g:2938:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    {
            	    // InternalExprParser.g:2948:5: ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    // InternalExprParser.g:2949:6: () ( (lv_operator_2_0= ruleOpMulti ) )
            	    {
            	    // InternalExprParser.g:2949:6: ()
            	    // InternalExprParser.g:2950:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalExprParser.g:2956:6: ( (lv_operator_2_0= ruleOpMulti ) )
            	    // InternalExprParser.g:2957:7: (lv_operator_2_0= ruleOpMulti )
            	    {
            	    // InternalExprParser.g:2957:7: (lv_operator_2_0= ruleOpMulti )
            	    // InternalExprParser.g:2958:8: lv_operator_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FollowSets000.FOLLOW_32);
            	    lv_operator_2_0=ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.expr.Expr.OpMulti");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalExprParser.g:2977:4: ( (lv_right_3_0= ruleUnaryOperation ) )
            	    // InternalExprParser.g:2978:5: (lv_right_3_0= ruleUnaryOperation )
            	    {
            	    // InternalExprParser.g:2978:5: (lv_right_3_0= ruleUnaryOperation )
            	    // InternalExprParser.g:2979:6: lv_right_3_0= ruleUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightUnaryOperationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_37);
            	    lv_right_3_0=ruleUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.expr.Expr.UnaryOperation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // InternalExprParser.g:3001:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalExprParser.g:3001:47: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalExprParser.g:3002:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // InternalExprParser.g:3008:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:3014:2: ( (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod ) )
            // InternalExprParser.g:3015:2: (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod )
            {
            // InternalExprParser.g:3015:2: (kw= Asterisk | kw= Solidus | kw= Div | kw= Mod )
            int alt42=4;
            switch ( input.LA(1) ) {
            case Asterisk:
                {
                alt42=1;
                }
                break;
            case Solidus:
                {
                alt42=2;
                }
                break;
            case Div:
                {
                alt42=3;
                }
                break;
            case Mod:
                {
                alt42=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalExprParser.g:3016:3: kw= Asterisk
                    {
                    kw=(Token)match(input,Asterisk,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:3022:3: kw= Solidus
                    {
                    kw=(Token)match(input,Solidus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:3028:3: kw= Div
                    {
                    kw=(Token)match(input,Div,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:3034:3: kw= Mod
                    {
                    kw=(Token)match(input,Mod,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getModKeyword_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleUnaryOperation"
    // InternalExprParser.g:3043:1: entryRuleUnaryOperation returns [EObject current=null] : iv_ruleUnaryOperation= ruleUnaryOperation EOF ;
    public final EObject entryRuleUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperation = null;


        try {
            // InternalExprParser.g:3043:55: (iv_ruleUnaryOperation= ruleUnaryOperation EOF )
            // InternalExprParser.g:3044:2: iv_ruleUnaryOperation= ruleUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnaryOperation=ruleUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperation"


    // $ANTLR start "ruleUnaryOperation"
    // InternalExprParser.g:3050:1: ruleUnaryOperation returns [EObject current=null] : ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression ) ;
    public final EObject ruleUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_UnitExpression_3 = null;



        	enterRule();

        try {
            // InternalExprParser.g:3056:2: ( ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression ) )
            // InternalExprParser.g:3057:2: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression )
            {
            // InternalExprParser.g:3057:2: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) ) | this_UnitExpression_3= ruleUnitExpression )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==Not||LA43_0==PlusSign||LA43_0==HyphenMinus) ) {
                alt43=1;
            }
            else if ( (LA43_0==Record||LA43_0==False||(LA43_0>=Tuple && LA43_0<=Union)||LA43_0==List||LA43_0==True||LA43_0==Bag||LA43_0==Map||LA43_0==Set||LA43_0==If||LA43_0==LeftParenthesis||LA43_0==LeftSquareBracket||LA43_0==CircumflexAccent||LA43_0==RULE_REAL_LIT||LA43_0==RULE_INTEGER_LIT||(LA43_0>=RULE_STRING && LA43_0<=RULE_ID)) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalExprParser.g:3058:3: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) )
                    {
                    // InternalExprParser.g:3058:3: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) ) )
                    // InternalExprParser.g:3059:4: () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleUnitExpression ) )
                    {
                    // InternalExprParser.g:3059:4: ()
                    // InternalExprParser.g:3060:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalExprParser.g:3066:4: ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) )
                    // InternalExprParser.g:3067:5: ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary )
                    {
                    // InternalExprParser.g:3071:5: (lv_operator_1_0= ruleOpUnary )
                    // InternalExprParser.g:3072:6: lv_operator_1_0= ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_32);
                    lv_operator_1_0=ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryOperationRule());
                      						}
                      						set(
                      							current,
                      							"operator",
                      							lv_operator_1_0,
                      							"org.osate.expr.Expr.OpUnary");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExprParser.g:3089:4: ( (lv_operand_2_0= ruleUnitExpression ) )
                    // InternalExprParser.g:3090:5: (lv_operand_2_0= ruleUnitExpression )
                    {
                    // InternalExprParser.g:3090:5: (lv_operand_2_0= ruleUnitExpression )
                    // InternalExprParser.g:3091:6: lv_operand_2_0= ruleUnitExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryOperationAccess().getOperandUnitExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_operand_2_0=ruleUnitExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryOperationRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.osate.expr.Expr.UnitExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:3110:3: this_UnitExpression_3= ruleUnitExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryOperationAccess().getUnitExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UnitExpression_3=ruleUnitExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnitExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // InternalExprParser.g:3122:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalExprParser.g:3122:47: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalExprParser.g:3123:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // InternalExprParser.g:3129:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Not | kw= HyphenMinus | kw= PlusSign ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:3135:2: ( (kw= Not | kw= HyphenMinus | kw= PlusSign ) )
            // InternalExprParser.g:3136:2: (kw= Not | kw= HyphenMinus | kw= PlusSign )
            {
            // InternalExprParser.g:3136:2: (kw= Not | kw= HyphenMinus | kw= PlusSign )
            int alt44=3;
            switch ( input.LA(1) ) {
            case Not:
                {
                alt44=1;
                }
                break;
            case HyphenMinus:
                {
                alt44=2;
                }
                break;
            case PlusSign:
                {
                alt44=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalExprParser.g:3137:3: kw= Not
                    {
                    kw=(Token)match(input,Not,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:3143:3: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:3149:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleUnitExpression"
    // InternalExprParser.g:3158:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // InternalExprParser.g:3158:55: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // InternalExprParser.g:3159:2: iv_ruleUnitExpression= ruleUnitExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnitExpression=ruleUnitExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitExpression"


    // $ANTLR start "ruleUnitExpression"
    // InternalExprParser.g:3165:1: ruleUnitExpression returns [EObject current=null] : (this_PropertyExpression_0= rulePropertyExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        Token lv_convert_2_0=null;
        Token lv_drop_3_0=null;
        Token otherlv_4=null;
        EObject this_PropertyExpression_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:3171:2: ( (this_PropertyExpression_0= rulePropertyExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalExprParser.g:3172:2: (this_PropertyExpression_0= rulePropertyExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalExprParser.g:3172:2: (this_PropertyExpression_0= rulePropertyExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            // InternalExprParser.g:3173:3: this_PropertyExpression_0= rulePropertyExpression ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getUnitExpressionAccess().getPropertyExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_38);
            this_PropertyExpression_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PropertyExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExprParser.g:3181:3: ( () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==In||LA46_0==PercentSign||LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalExprParser.g:3182:4: () ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )? ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalExprParser.g:3182:4: ()
                    // InternalExprParser.g:3183:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getUnitExpressionAccess().getUnitExpressionExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalExprParser.g:3189:4: ( ( (lv_convert_2_0= PercentSign ) ) | ( (lv_drop_3_0= In ) ) )?
                    int alt45=3;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==PercentSign) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==In) ) {
                        alt45=2;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalExprParser.g:3190:5: ( (lv_convert_2_0= PercentSign ) )
                            {
                            // InternalExprParser.g:3190:5: ( (lv_convert_2_0= PercentSign ) )
                            // InternalExprParser.g:3191:6: (lv_convert_2_0= PercentSign )
                            {
                            // InternalExprParser.g:3191:6: (lv_convert_2_0= PercentSign )
                            // InternalExprParser.g:3192:7: lv_convert_2_0= PercentSign
                            {
                            lv_convert_2_0=(Token)match(input,PercentSign,FollowSets000.FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_convert_2_0, grammarAccess.getUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getUnitExpressionRule());
                              							}
                              							setWithLastConsumed(current, "convert", true, "%");
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalExprParser.g:3205:5: ( (lv_drop_3_0= In ) )
                            {
                            // InternalExprParser.g:3205:5: ( (lv_drop_3_0= In ) )
                            // InternalExprParser.g:3206:6: (lv_drop_3_0= In )
                            {
                            // InternalExprParser.g:3206:6: (lv_drop_3_0= In )
                            // InternalExprParser.g:3207:7: lv_drop_3_0= In
                            {
                            lv_drop_3_0=(Token)match(input,In,FollowSets000.FOLLOW_5); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_drop_3_0, grammarAccess.getUnitExpressionAccess().getDropInKeyword_1_1_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getUnitExpressionRule());
                              							}
                              							setWithLastConsumed(current, "drop", true, "in");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalExprParser.g:3220:4: ( (otherlv_4= RULE_ID ) )
                    // InternalExprParser.g:3221:5: (otherlv_4= RULE_ID )
                    {
                    // InternalExprParser.g:3221:5: (otherlv_4= RULE_ID )
                    // InternalExprParser.g:3222:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnitExpressionRule());
                      						}
                      					
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_4, grammarAccess.getUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnitExpression"


    // $ANTLR start "entryRulePropertyExpression"
    // InternalExprParser.g:3238:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalExprParser.g:3238:59: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalExprParser.g:3239:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyExpression"


    // $ANTLR start "rulePropertyExpression"
    // InternalExprParser.g:3245:1: rulePropertyExpression returns [EObject current=null] : (this_SelectExpression_0= ruleSelectExpression ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_SelectExpression_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:3251:2: ( (this_SelectExpression_0= ruleSelectExpression ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? ) )
            // InternalExprParser.g:3252:2: (this_SelectExpression_0= ruleSelectExpression ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? )
            {
            // InternalExprParser.g:3252:2: (this_SelectExpression_0= ruleSelectExpression ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )? )
            // InternalExprParser.g:3253:3: this_SelectExpression_0= ruleSelectExpression ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getSelectExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_39);
            this_SelectExpression_0=ruleSelectExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_SelectExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExprParser.g:3261:3: ( ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==NumberSign) && (synpred8_InternalExprParser())) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalExprParser.g:3262:4: ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) ) ( ( ruleQPREF ) )
                    {
                    // InternalExprParser.g:3262:4: ( ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign ) )
                    // InternalExprParser.g:3263:5: ( ( () NumberSign ) )=> ( () otherlv_2= NumberSign )
                    {
                    // InternalExprParser.g:3269:5: ( () otherlv_2= NumberSign )
                    // InternalExprParser.g:3270:6: () otherlv_2= NumberSign
                    {
                    // InternalExprParser.g:3270:6: ()
                    // InternalExprParser.g:3271:7: 
                    {
                    if ( state.backtracking==0 ) {

                      							current = forceCreateModelElementAndSet(
                      								grammarAccess.getPropertyExpressionAccess().getPropertyExpressionModelElementAction_1_0_0_0(),
                      								current);
                      						
                    }

                    }

                    otherlv_2=(Token)match(input,NumberSign,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_2, grammarAccess.getPropertyExpressionAccess().getNumberSignKeyword_1_0_0_1());
                      					
                    }

                    }


                    }

                    // InternalExprParser.g:3283:4: ( ( ruleQPREF ) )
                    // InternalExprParser.g:3284:5: ( ruleQPREF )
                    {
                    // InternalExprParser.g:3284:5: ( ruleQPREF )
                    // InternalExprParser.g:3285:6: ruleQPREF
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPropertyExpressionRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPropertyExpressionAccess().getPropertyAbstractNamedValueCrossReference_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQPREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyExpression"


    // $ANTLR start "entryRuleSelectExpression"
    // InternalExprParser.g:3304:1: entryRuleSelectExpression returns [EObject current=null] : iv_ruleSelectExpression= ruleSelectExpression EOF ;
    public final EObject entryRuleSelectExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectExpression = null;


        try {
            // InternalExprParser.g:3304:57: (iv_ruleSelectExpression= ruleSelectExpression EOF )
            // InternalExprParser.g:3305:2: iv_ruleSelectExpression= ruleSelectExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelectExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSelectExpression=ruleSelectExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelectExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectExpression"


    // $ANTLR start "ruleSelectExpression"
    // InternalExprParser.g:3311:1: ruleSelectExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () FullStop ( ( ruleQCREF ) ) ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )? ) )=> ( () otherlv_2= FullStop ( ( ruleQCREF ) ) (otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= RightParenthesis )? ) )* ) ;
    public final EObject ruleSelectExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_args_5_0 = null;

        EObject lv_args_7_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:3317:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () FullStop ( ( ruleQCREF ) ) ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )? ) )=> ( () otherlv_2= FullStop ( ( ruleQCREF ) ) (otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= RightParenthesis )? ) )* ) )
            // InternalExprParser.g:3318:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () FullStop ( ( ruleQCREF ) ) ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )? ) )=> ( () otherlv_2= FullStop ( ( ruleQCREF ) ) (otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= RightParenthesis )? ) )* )
            {
            // InternalExprParser.g:3318:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () FullStop ( ( ruleQCREF ) ) ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )? ) )=> ( () otherlv_2= FullStop ( ( ruleQCREF ) ) (otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= RightParenthesis )? ) )* )
            // InternalExprParser.g:3319:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () FullStop ( ( ruleQCREF ) ) ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )? ) )=> ( () otherlv_2= FullStop ( ( ruleQCREF ) ) (otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= RightParenthesis )? ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSelectExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_17);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExprParser.g:3327:3: ( ( ( () FullStop ( ( ruleQCREF ) ) ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )? ) )=> ( () otherlv_2= FullStop ( ( ruleQCREF ) ) (otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= RightParenthesis )? ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==FullStop) && (synpred9_InternalExprParser())) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalExprParser.g:3328:4: ( ( () FullStop ( ( ruleQCREF ) ) ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )? ) )=> ( () otherlv_2= FullStop ( ( ruleQCREF ) ) (otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= RightParenthesis )? )
            	    {
            	    // InternalExprParser.g:3358:4: ( () otherlv_2= FullStop ( ( ruleQCREF ) ) (otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= RightParenthesis )? )
            	    // InternalExprParser.g:3359:5: () otherlv_2= FullStop ( ( ruleQCREF ) ) (otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= RightParenthesis )?
            	    {
            	    // InternalExprParser.g:3359:5: ()
            	    // InternalExprParser.g:3360:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getSelectExpressionAccess().getSelectionReceiverAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_2=(Token)match(input,FullStop,FollowSets000.FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getSelectExpressionAccess().getFullStopKeyword_1_0_1());
            	      				
            	    }
            	    // InternalExprParser.g:3370:5: ( ( ruleQCREF ) )
            	    // InternalExprParser.g:3371:6: ( ruleQCREF )
            	    {
            	    // InternalExprParser.g:3371:6: ( ruleQCREF )
            	    // InternalExprParser.g:3372:7: ruleQCREF
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getSelectExpressionRule());
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getSelectExpressionAccess().getRefNamedElementCrossReference_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_40);
            	    ruleQCREF();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalExprParser.g:3386:5: (otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= RightParenthesis )?
            	    int alt50=2;
            	    int LA50_0 = input.LA(1);

            	    if ( (LA50_0==LeftParenthesis) ) {
            	        alt50=1;
            	    }
            	    switch (alt50) {
            	        case 1 :
            	            // InternalExprParser.g:3387:6: otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= RightParenthesis
            	            {
            	            otherlv_4=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_41); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_4, grammarAccess.getSelectExpressionAccess().getLeftParenthesisKeyword_1_0_3_0());
            	              					
            	            }
            	            // InternalExprParser.g:3391:6: ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )* )?
            	            int alt49=2;
            	            int LA49_0 = input.LA(1);

            	            if ( (LA49_0==Record||LA49_0==False||(LA49_0>=Tuple && LA49_0<=Union)||LA49_0==List||LA49_0==True||LA49_0==Bag||LA49_0==Map||(LA49_0>=Not && LA49_0<=Set)||LA49_0==If||LA49_0==LeftParenthesis||LA49_0==PlusSign||LA49_0==HyphenMinus||LA49_0==LeftSquareBracket||(LA49_0>=CircumflexAccent && LA49_0<=LeftCurlyBracket)||LA49_0==RULE_REAL_LIT||LA49_0==RULE_INTEGER_LIT||(LA49_0>=RULE_STRING && LA49_0<=RULE_ID)) ) {
            	                alt49=1;
            	            }
            	            switch (alt49) {
            	                case 1 :
            	                    // InternalExprParser.g:3392:7: ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )*
            	                    {
            	                    // InternalExprParser.g:3392:7: ( (lv_args_5_0= ruleExpression ) )
            	                    // InternalExprParser.g:3393:8: (lv_args_5_0= ruleExpression )
            	                    {
            	                    // InternalExprParser.g:3393:8: (lv_args_5_0= ruleExpression )
            	                    // InternalExprParser.g:3394:9: lv_args_5_0= ruleExpression
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      									newCompositeNode(grammarAccess.getSelectExpressionAccess().getArgsExpressionParserRuleCall_1_0_3_1_0_0());
            	                      								
            	                    }
            	                    pushFollow(FollowSets000.FOLLOW_42);
            	                    lv_args_5_0=ruleExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      									if (current==null) {
            	                      										current = createModelElementForParent(grammarAccess.getSelectExpressionRule());
            	                      									}
            	                      									add(
            	                      										current,
            	                      										"args",
            	                      										lv_args_5_0,
            	                      										"org.osate.expr.Expr.Expression");
            	                      									afterParserOrEnumRuleCall();
            	                      								
            	                    }

            	                    }


            	                    }

            	                    // InternalExprParser.g:3411:7: (otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) ) )*
            	                    loop48:
            	                    do {
            	                        int alt48=2;
            	                        int LA48_0 = input.LA(1);

            	                        if ( (LA48_0==Comma) ) {
            	                            alt48=1;
            	                        }


            	                        switch (alt48) {
            	                    	case 1 :
            	                    	    // InternalExprParser.g:3412:8: otherlv_6= Comma ( (lv_args_7_0= ruleExpression ) )
            	                    	    {
            	                    	    otherlv_6=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      								newLeafNode(otherlv_6, grammarAccess.getSelectExpressionAccess().getCommaKeyword_1_0_3_1_1_0());
            	                    	      							
            	                    	    }
            	                    	    // InternalExprParser.g:3416:8: ( (lv_args_7_0= ruleExpression ) )
            	                    	    // InternalExprParser.g:3417:9: (lv_args_7_0= ruleExpression )
            	                    	    {
            	                    	    // InternalExprParser.g:3417:9: (lv_args_7_0= ruleExpression )
            	                    	    // InternalExprParser.g:3418:10: lv_args_7_0= ruleExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      										newCompositeNode(grammarAccess.getSelectExpressionAccess().getArgsExpressionParserRuleCall_1_0_3_1_1_1_0());
            	                    	      									
            	                    	    }
            	                    	    pushFollow(FollowSets000.FOLLOW_42);
            	                    	    lv_args_7_0=ruleExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      										if (current==null) {
            	                    	      											current = createModelElementForParent(grammarAccess.getSelectExpressionRule());
            	                    	      										}
            	                    	      										add(
            	                    	      											current,
            	                    	      											"args",
            	                    	      											lv_args_7_0,
            	                    	      											"org.osate.expr.Expr.Expression");
            	                    	      										afterParserOrEnumRuleCall();
            	                    	      									
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop48;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            otherlv_8=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_17); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_8, grammarAccess.getSelectExpressionAccess().getRightParenthesisKeyword_1_0_3_2());
            	              					
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalExprParser.g:3448:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalExprParser.g:3448:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalExprParser.g:3449:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalExprParser.g:3455:1: rulePrimaryExpression returns [EObject current=null] : (this_NamedElementRef_0= ruleNamedElementRef | this_RangeExpression_1= ruleRangeExpression | this_IfExpression_2= ruleIfExpression | this_Literal_3= ruleLiteral | (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_NamedElementRef_0 = null;

        EObject this_RangeExpression_1 = null;

        EObject this_IfExpression_2 = null;

        EObject this_Literal_3 = null;

        EObject this_Expression_5 = null;



        	enterRule();

        try {
            // InternalExprParser.g:3461:2: ( (this_NamedElementRef_0= ruleNamedElementRef | this_RangeExpression_1= ruleRangeExpression | this_IfExpression_2= ruleIfExpression | this_Literal_3= ruleLiteral | (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis ) ) )
            // InternalExprParser.g:3462:2: (this_NamedElementRef_0= ruleNamedElementRef | this_RangeExpression_1= ruleRangeExpression | this_IfExpression_2= ruleIfExpression | this_Literal_3= ruleLiteral | (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis ) )
            {
            // InternalExprParser.g:3462:2: (this_NamedElementRef_0= ruleNamedElementRef | this_RangeExpression_1= ruleRangeExpression | this_IfExpression_2= ruleIfExpression | this_Literal_3= ruleLiteral | (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis ) )
            int alt52=5;
            switch ( input.LA(1) ) {
            case CircumflexAccent:
            case RULE_ID:
                {
                alt52=1;
                }
                break;
            case LeftSquareBracket:
                {
                alt52=2;
                }
                break;
            case If:
                {
                alt52=3;
                }
                break;
            case Record:
            case False:
            case Tuple:
            case Union:
            case List:
            case True:
            case Bag:
            case Map:
            case Set:
            case RULE_REAL_LIT:
            case RULE_INTEGER_LIT:
            case RULE_STRING:
                {
                alt52=4;
                }
                break;
            case LeftParenthesis:
                {
                alt52=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalExprParser.g:3463:3: this_NamedElementRef_0= ruleNamedElementRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNamedElementRefParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NamedElementRef_0=ruleNamedElementRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NamedElementRef_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:3472:3: this_RangeExpression_1= ruleRangeExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRangeExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RangeExpression_1=ruleRangeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RangeExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:3481:3: this_IfExpression_2= ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_IfExpression_2=ruleIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:3490:3: this_Literal_3= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Literal_3=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Literal_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:3499:3: (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis )
                    {
                    // InternalExprParser.g:3499:3: (otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis )
                    // InternalExprParser.g:3500:4: otherlv_4= LeftParenthesis this_Expression_5= ruleExpression otherlv_6= RightParenthesis
                    {
                    otherlv_4=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_4_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_4_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_15);
                    this_Expression_5=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expression_5;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_4_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleNamedElementRef"
    // InternalExprParser.g:3521:1: entryRuleNamedElementRef returns [EObject current=null] : iv_ruleNamedElementRef= ruleNamedElementRef EOF ;
    public final EObject entryRuleNamedElementRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedElementRef = null;


        try {
            // InternalExprParser.g:3521:56: (iv_ruleNamedElementRef= ruleNamedElementRef EOF )
            // InternalExprParser.g:3522:2: iv_ruleNamedElementRef= ruleNamedElementRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedElementRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamedElementRef=ruleNamedElementRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedElementRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedElementRef"


    // $ANTLR start "ruleNamedElementRef"
    // InternalExprParser.g:3528:1: ruleNamedElementRef returns [EObject current=null] : ( ( (lv_core_0_0= CircumflexAccent ) )? ( ( ruleQCREF ) ) (otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )? ) ;
    public final EObject ruleNamedElementRef() throws RecognitionException {
        EObject current = null;

        Token lv_core_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:3534:2: ( ( ( (lv_core_0_0= CircumflexAccent ) )? ( ( ruleQCREF ) ) (otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )? ) )
            // InternalExprParser.g:3535:2: ( ( (lv_core_0_0= CircumflexAccent ) )? ( ( ruleQCREF ) ) (otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )? )
            {
            // InternalExprParser.g:3535:2: ( ( (lv_core_0_0= CircumflexAccent ) )? ( ( ruleQCREF ) ) (otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )? )
            // InternalExprParser.g:3536:3: ( (lv_core_0_0= CircumflexAccent ) )? ( ( ruleQCREF ) ) (otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )?
            {
            // InternalExprParser.g:3536:3: ( (lv_core_0_0= CircumflexAccent ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==CircumflexAccent) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalExprParser.g:3537:4: (lv_core_0_0= CircumflexAccent )
                    {
                    // InternalExprParser.g:3537:4: (lv_core_0_0= CircumflexAccent )
                    // InternalExprParser.g:3538:5: lv_core_0_0= CircumflexAccent
                    {
                    lv_core_0_0=(Token)match(input,CircumflexAccent,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_core_0_0, grammarAccess.getNamedElementRefAccess().getCoreCircumflexAccentKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getNamedElementRefRule());
                      					}
                      					setWithLastConsumed(current, "core", true, "^");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalExprParser.g:3550:3: ( ( ruleQCREF ) )
            // InternalExprParser.g:3551:4: ( ruleQCREF )
            {
            // InternalExprParser.g:3551:4: ( ruleQCREF )
            // InternalExprParser.g:3552:5: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getNamedElementRefRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNamedElementRefAccess().getRefNamedElementCrossReference_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_43);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:3566:3: (otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==LeftParenthesis) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalExprParser.g:3567:4: otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis
                    {
                    otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getNamedElementRefAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalExprParser.g:3571:4: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleExpression ) ) )* )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==Record||LA55_0==False||(LA55_0>=Tuple && LA55_0<=Union)||LA55_0==List||LA55_0==True||LA55_0==Bag||LA55_0==Map||(LA55_0>=Not && LA55_0<=Set)||LA55_0==If||LA55_0==LeftParenthesis||LA55_0==PlusSign||LA55_0==HyphenMinus||LA55_0==LeftSquareBracket||(LA55_0>=CircumflexAccent && LA55_0<=LeftCurlyBracket)||LA55_0==RULE_REAL_LIT||LA55_0==RULE_INTEGER_LIT||(LA55_0>=RULE_STRING && LA55_0<=RULE_ID)) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // InternalExprParser.g:3572:5: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleExpression ) ) )*
                            {
                            // InternalExprParser.g:3572:5: ( (lv_args_3_0= ruleExpression ) )
                            // InternalExprParser.g:3573:6: (lv_args_3_0= ruleExpression )
                            {
                            // InternalExprParser.g:3573:6: (lv_args_3_0= ruleExpression )
                            // InternalExprParser.g:3574:7: lv_args_3_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getNamedElementRefAccess().getArgsExpressionParserRuleCall_2_1_0_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_42);
                            lv_args_3_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getNamedElementRefRule());
                              							}
                              							add(
                              								current,
                              								"args",
                              								lv_args_3_0,
                              								"org.osate.expr.Expr.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalExprParser.g:3591:5: (otherlv_4= Comma ( (lv_args_5_0= ruleExpression ) ) )*
                            loop54:
                            do {
                                int alt54=2;
                                int LA54_0 = input.LA(1);

                                if ( (LA54_0==Comma) ) {
                                    alt54=1;
                                }


                                switch (alt54) {
                            	case 1 :
                            	    // InternalExprParser.g:3592:6: otherlv_4= Comma ( (lv_args_5_0= ruleExpression ) )
                            	    {
                            	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_4, grammarAccess.getNamedElementRefAccess().getCommaKeyword_2_1_1_0());
                            	      					
                            	    }
                            	    // InternalExprParser.g:3596:6: ( (lv_args_5_0= ruleExpression ) )
                            	    // InternalExprParser.g:3597:7: (lv_args_5_0= ruleExpression )
                            	    {
                            	    // InternalExprParser.g:3597:7: (lv_args_5_0= ruleExpression )
                            	    // InternalExprParser.g:3598:8: lv_args_5_0= ruleExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getNamedElementRefAccess().getArgsExpressionParserRuleCall_2_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_42);
                            	    lv_args_5_0=ruleExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getNamedElementRefRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"args",
                            	      									lv_args_5_0,
                            	      									"org.osate.expr.Expr.Expression");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop54;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getNamedElementRefAccess().getRightParenthesisKeyword_2_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamedElementRef"


    // $ANTLR start "entryRuleRangeExpression"
    // InternalExprParser.g:3626:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // InternalExprParser.g:3626:56: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // InternalExprParser.g:3627:2: iv_ruleRangeExpression= ruleRangeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRangeExpression=ruleRangeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeExpression"


    // $ANTLR start "ruleRangeExpression"
    // InternalExprParser.g:3633:1: ruleRangeExpression returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket ) ;
    public final EObject ruleRangeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_minimum_2_0 = null;

        EObject lv_maximum_4_0 = null;

        EObject lv_delta_6_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:3639:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket ) )
            // InternalExprParser.g:3640:2: ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket )
            {
            // InternalExprParser.g:3640:2: ( () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket )
            // InternalExprParser.g:3641:3: () otherlv_1= LeftSquareBracket ( (lv_minimum_2_0= ruleExpression ) ) otherlv_3= FullStopFullStop ( (lv_maximum_4_0= ruleExpression ) ) ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )? otherlv_7= RightSquareBracket
            {
            // InternalExprParser.g:3641:3: ()
            // InternalExprParser.g:3642:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRangeExpressionAccess().getRangeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRangeExpressionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalExprParser.g:3652:3: ( (lv_minimum_2_0= ruleExpression ) )
            // InternalExprParser.g:3653:4: (lv_minimum_2_0= ruleExpression )
            {
            // InternalExprParser.g:3653:4: (lv_minimum_2_0= ruleExpression )
            // InternalExprParser.g:3654:5: lv_minimum_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRangeExpressionAccess().getMinimumExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_44);
            lv_minimum_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
              					}
              					set(
              						current,
              						"minimum",
              						lv_minimum_2_0,
              						"org.osate.expr.Expr.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRangeExpressionAccess().getFullStopFullStopKeyword_3());
              		
            }
            // InternalExprParser.g:3675:3: ( (lv_maximum_4_0= ruleExpression ) )
            // InternalExprParser.g:3676:4: (lv_maximum_4_0= ruleExpression )
            {
            // InternalExprParser.g:3676:4: (lv_maximum_4_0= ruleExpression )
            // InternalExprParser.g:3677:5: lv_maximum_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRangeExpressionAccess().getMaximumExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_45);
            lv_maximum_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
              					}
              					set(
              						current,
              						"maximum",
              						lv_maximum_4_0,
              						"org.osate.expr.Expr.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:3694:3: ( ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==Delta) && (synpred10_InternalExprParser())) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalExprParser.g:3695:4: ( ( Delta )=>otherlv_5= Delta ) ( (lv_delta_6_0= ruleExpression ) )
                    {
                    // InternalExprParser.g:3695:4: ( ( Delta )=>otherlv_5= Delta )
                    // InternalExprParser.g:3696:5: ( Delta )=>otherlv_5= Delta
                    {
                    otherlv_5=(Token)match(input,Delta,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getRangeExpressionAccess().getDeltaKeyword_5_0());
                      				
                    }

                    }

                    // InternalExprParser.g:3702:4: ( (lv_delta_6_0= ruleExpression ) )
                    // InternalExprParser.g:3703:5: (lv_delta_6_0= ruleExpression )
                    {
                    // InternalExprParser.g:3703:5: (lv_delta_6_0= ruleExpression )
                    // InternalExprParser.g:3704:6: lv_delta_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRangeExpressionAccess().getDeltaExpressionParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_46);
                    lv_delta_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
                      						}
                      						set(
                      							current,
                      							"delta",
                      							lv_delta_6_0,
                      							"org.osate.expr.Expr.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getRangeExpressionAccess().getRightSquareBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRangeExpression"


    // $ANTLR start "entryRuleIfExpression"
    // InternalExprParser.g:3730:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalExprParser.g:3730:53: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalExprParser.g:3731:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // InternalExprParser.g:3737:1: ruleIfExpression returns [EObject current=null] : ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_if_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:3743:2: ( ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif ) )
            // InternalExprParser.g:3744:2: ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif )
            {
            // InternalExprParser.g:3744:2: ( () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif )
            // InternalExprParser.g:3745:3: () otherlv_1= If ( (lv_if_2_0= ruleExpression ) ) otherlv_3= Then ( (lv_then_4_0= ruleExpression ) ) (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )? otherlv_7= Endif
            {
            // InternalExprParser.g:3745:3: ()
            // InternalExprParser.g:3746:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIfExpressionAccess().getConditionalAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,If,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfExpressionAccess().getIfKeyword_1());
              		
            }
            // InternalExprParser.g:3756:3: ( (lv_if_2_0= ruleExpression ) )
            // InternalExprParser.g:3757:4: (lv_if_2_0= ruleExpression )
            {
            // InternalExprParser.g:3757:4: (lv_if_2_0= ruleExpression )
            // InternalExprParser.g:3758:5: lv_if_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfExpressionAccess().getIfExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_47);
            lv_if_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              					}
              					set(
              						current,
              						"if",
              						lv_if_2_0,
              						"org.osate.expr.Expr.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Then,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfExpressionAccess().getThenKeyword_3());
              		
            }
            // InternalExprParser.g:3779:3: ( (lv_then_4_0= ruleExpression ) )
            // InternalExprParser.g:3780:4: (lv_then_4_0= ruleExpression )
            {
            // InternalExprParser.g:3780:4: (lv_then_4_0= ruleExpression )
            // InternalExprParser.g:3781:5: lv_then_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_48);
            lv_then_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_4_0,
              						"org.osate.expr.Expr.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:3798:3: (otherlv_5= Else ( (lv_else_6_0= ruleExpression ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==Else) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalExprParser.g:3799:4: otherlv_5= Else ( (lv_else_6_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,Else,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getIfExpressionAccess().getElseKeyword_5_0());
                      			
                    }
                    // InternalExprParser.g:3803:4: ( (lv_else_6_0= ruleExpression ) )
                    // InternalExprParser.g:3804:5: (lv_else_6_0= ruleExpression )
                    {
                    // InternalExprParser.g:3804:5: (lv_else_6_0= ruleExpression )
                    // InternalExprParser.g:3805:6: lv_else_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_49);
                    lv_else_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfExpressionRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_6_0,
                      							"org.osate.expr.Expr.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,Endif,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getIfExpressionAccess().getEndifKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleLiteral"
    // InternalExprParser.g:3831:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalExprParser.g:3831:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalExprParser.g:3832:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalExprParser.g:3838:1: ruleLiteral returns [EObject current=null] : (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_EStringLiteral_2= ruleEStringLiteral | this_ListLiteral_3= ruleListLiteral | this_SetLiteral_4= ruleSetLiteral | this_RecordLiteral_5= ruleRecordLiteral | this_UnionLiteral_6= ruleUnionLiteral | this_TupleLiteral_7= ruleTupleLiteral | this_BagLiteral_8= ruleBagLiteral | this_MapLiteral_9= ruleMapLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_EBooleanLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_EStringLiteral_2 = null;

        EObject this_ListLiteral_3 = null;

        EObject this_SetLiteral_4 = null;

        EObject this_RecordLiteral_5 = null;

        EObject this_UnionLiteral_6 = null;

        EObject this_TupleLiteral_7 = null;

        EObject this_BagLiteral_8 = null;

        EObject this_MapLiteral_9 = null;



        	enterRule();

        try {
            // InternalExprParser.g:3844:2: ( (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_EStringLiteral_2= ruleEStringLiteral | this_ListLiteral_3= ruleListLiteral | this_SetLiteral_4= ruleSetLiteral | this_RecordLiteral_5= ruleRecordLiteral | this_UnionLiteral_6= ruleUnionLiteral | this_TupleLiteral_7= ruleTupleLiteral | this_BagLiteral_8= ruleBagLiteral | this_MapLiteral_9= ruleMapLiteral ) )
            // InternalExprParser.g:3845:2: (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_EStringLiteral_2= ruleEStringLiteral | this_ListLiteral_3= ruleListLiteral | this_SetLiteral_4= ruleSetLiteral | this_RecordLiteral_5= ruleRecordLiteral | this_UnionLiteral_6= ruleUnionLiteral | this_TupleLiteral_7= ruleTupleLiteral | this_BagLiteral_8= ruleBagLiteral | this_MapLiteral_9= ruleMapLiteral )
            {
            // InternalExprParser.g:3845:2: (this_EBooleanLiteral_0= ruleEBooleanLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_EStringLiteral_2= ruleEStringLiteral | this_ListLiteral_3= ruleListLiteral | this_SetLiteral_4= ruleSetLiteral | this_RecordLiteral_5= ruleRecordLiteral | this_UnionLiteral_6= ruleUnionLiteral | this_TupleLiteral_7= ruleTupleLiteral | this_BagLiteral_8= ruleBagLiteral | this_MapLiteral_9= ruleMapLiteral )
            int alt59=10;
            switch ( input.LA(1) ) {
            case False:
            case True:
                {
                alt59=1;
                }
                break;
            case RULE_REAL_LIT:
            case RULE_INTEGER_LIT:
                {
                alt59=2;
                }
                break;
            case RULE_STRING:
                {
                alt59=3;
                }
                break;
            case List:
                {
                alt59=4;
                }
                break;
            case Set:
                {
                alt59=5;
                }
                break;
            case Record:
                {
                alt59=6;
                }
                break;
            case Union:
                {
                alt59=7;
                }
                break;
            case Tuple:
                {
                alt59=8;
                }
                break;
            case Bag:
                {
                alt59=9;
                }
                break;
            case Map:
                {
                alt59=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalExprParser.g:3846:3: this_EBooleanLiteral_0= ruleEBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getEBooleanLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EBooleanLiteral_0=ruleEBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EBooleanLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:3855:3: this_NumberLiteral_1= ruleNumberLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NumberLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:3864:3: this_EStringLiteral_2= ruleEStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getEStringLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EStringLiteral_2=ruleEStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EStringLiteral_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:3873:3: this_ListLiteral_3= ruleListLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getListLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ListLiteral_3=ruleListLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ListLiteral_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExprParser.g:3882:3: this_SetLiteral_4= ruleSetLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getSetLiteralParserRuleCall_4());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SetLiteral_4=ruleSetLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SetLiteral_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExprParser.g:3891:3: this_RecordLiteral_5= ruleRecordLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getRecordLiteralParserRuleCall_5());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RecordLiteral_5=ruleRecordLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RecordLiteral_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalExprParser.g:3900:3: this_UnionLiteral_6= ruleUnionLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getUnionLiteralParserRuleCall_6());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UnionLiteral_6=ruleUnionLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnionLiteral_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalExprParser.g:3909:3: this_TupleLiteral_7= ruleTupleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getTupleLiteralParserRuleCall_7());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TupleLiteral_7=ruleTupleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TupleLiteral_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalExprParser.g:3918:3: this_BagLiteral_8= ruleBagLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getBagLiteralParserRuleCall_8());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BagLiteral_8=ruleBagLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BagLiteral_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalExprParser.g:3927:3: this_MapLiteral_9= ruleMapLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getMapLiteralParserRuleCall_9());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MapLiteral_9=ruleMapLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_MapLiteral_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleWrappedNamedElement"
    // InternalExprParser.g:3939:1: entryRuleWrappedNamedElement returns [EObject current=null] : iv_ruleWrappedNamedElement= ruleWrappedNamedElement EOF ;
    public final EObject entryRuleWrappedNamedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWrappedNamedElement = null;


        try {
            // InternalExprParser.g:3939:60: (iv_ruleWrappedNamedElement= ruleWrappedNamedElement EOF )
            // InternalExprParser.g:3940:2: iv_ruleWrappedNamedElement= ruleWrappedNamedElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWrappedNamedElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWrappedNamedElement=ruleWrappedNamedElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWrappedNamedElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWrappedNamedElement"


    // $ANTLR start "ruleWrappedNamedElement"
    // InternalExprParser.g:3946:1: ruleWrappedNamedElement returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleWrappedNamedElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalExprParser.g:3952:2: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // InternalExprParser.g:3953:2: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalExprParser.g:3953:2: ( () ( (otherlv_1= RULE_ID ) ) )
            // InternalExprParser.g:3954:3: () ( (otherlv_1= RULE_ID ) )
            {
            // InternalExprParser.g:3954:3: ()
            // InternalExprParser.g:3955:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getWrappedNamedElementAccess().getWrappedNamedElementAction_0(),
              					current);
              			
            }

            }

            // InternalExprParser.g:3961:3: ( (otherlv_1= RULE_ID ) )
            // InternalExprParser.g:3962:4: (otherlv_1= RULE_ID )
            {
            // InternalExprParser.g:3962:4: (otherlv_1= RULE_ID )
            // InternalExprParser.g:3963:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getWrappedNamedElementRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getWrappedNamedElementAccess().getElemNamedElementCrossReference_1_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWrappedNamedElement"


    // $ANTLR start "entryRuleEBooleanLiteral"
    // InternalExprParser.g:3978:1: entryRuleEBooleanLiteral returns [EObject current=null] : iv_ruleEBooleanLiteral= ruleEBooleanLiteral EOF ;
    public final EObject entryRuleEBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEBooleanLiteral = null;


        try {
            // InternalExprParser.g:3978:56: (iv_ruleEBooleanLiteral= ruleEBooleanLiteral EOF )
            // InternalExprParser.g:3979:2: iv_ruleEBooleanLiteral= ruleEBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEBooleanLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEBooleanLiteral=ruleEBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEBooleanLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEBooleanLiteral"


    // $ANTLR start "ruleEBooleanLiteral"
    // InternalExprParser.g:3985:1: ruleEBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleEBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalExprParser.g:3991:2: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalExprParser.g:3992:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalExprParser.g:3992:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalExprParser.g:3993:3: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalExprParser.g:3993:3: ()
            // InternalExprParser.g:3994:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getEBooleanLiteralAccess().getEBooleanLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalExprParser.g:4000:3: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==True) ) {
                alt60=1;
            }
            else if ( (LA60_0==False) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalExprParser.g:4001:4: ( (lv_value_1_0= True ) )
                    {
                    // InternalExprParser.g:4001:4: ( (lv_value_1_0= True ) )
                    // InternalExprParser.g:4002:5: (lv_value_1_0= True )
                    {
                    // InternalExprParser.g:4002:5: (lv_value_1_0= True )
                    // InternalExprParser.g:4003:6: lv_value_1_0= True
                    {
                    lv_value_1_0=(Token)match(input,True,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getEBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getEBooleanLiteralRule());
                      						}
                      						setWithLastConsumed(current, "value", true, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:4016:4: otherlv_2= False
                    {
                    otherlv_2=(Token)match(input,False,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getEBooleanLiteralAccess().getFalseKeyword_1_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEBooleanLiteral"


    // $ANTLR start "entryRuleNumberLiteral"
    // InternalExprParser.g:4025:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalExprParser.g:4025:54: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalExprParser.g:4026:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // InternalExprParser.g:4032:1: ruleNumberLiteral returns [EObject current=null] : (this_EIntegerLiteral_0= ruleEIntegerLiteral | this_ERealLiteral_1= ruleERealLiteral ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_EIntegerLiteral_0 = null;

        EObject this_ERealLiteral_1 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4038:2: ( (this_EIntegerLiteral_0= ruleEIntegerLiteral | this_ERealLiteral_1= ruleERealLiteral ) )
            // InternalExprParser.g:4039:2: (this_EIntegerLiteral_0= ruleEIntegerLiteral | this_ERealLiteral_1= ruleERealLiteral )
            {
            // InternalExprParser.g:4039:2: (this_EIntegerLiteral_0= ruleEIntegerLiteral | this_ERealLiteral_1= ruleERealLiteral )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_INTEGER_LIT) ) {
                alt61=1;
            }
            else if ( (LA61_0==RULE_REAL_LIT) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalExprParser.g:4040:3: this_EIntegerLiteral_0= ruleEIntegerLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumberLiteralAccess().getEIntegerLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EIntegerLiteral_0=ruleEIntegerLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EIntegerLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:4049:3: this_ERealLiteral_1= ruleERealLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumberLiteralAccess().getERealLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ERealLiteral_1=ruleERealLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ERealLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleEIntegerLiteral"
    // InternalExprParser.g:4061:1: entryRuleEIntegerLiteral returns [EObject current=null] : iv_ruleEIntegerLiteral= ruleEIntegerLiteral EOF ;
    public final EObject entryRuleEIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEIntegerLiteral = null;


        try {
            // InternalExprParser.g:4061:56: (iv_ruleEIntegerLiteral= ruleEIntegerLiteral EOF )
            // InternalExprParser.g:4062:2: iv_ruleEIntegerLiteral= ruleEIntegerLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEIntegerLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEIntegerLiteral=ruleEIntegerLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEIntegerLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEIntegerLiteral"


    // $ANTLR start "ruleEIntegerLiteral"
    // InternalExprParser.g:4068:1: ruleEIntegerLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleINTVALUE ) ) ) ;
    public final EObject ruleEIntegerLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4074:2: ( ( () ( (lv_value_1_0= ruleINTVALUE ) ) ) )
            // InternalExprParser.g:4075:2: ( () ( (lv_value_1_0= ruleINTVALUE ) ) )
            {
            // InternalExprParser.g:4075:2: ( () ( (lv_value_1_0= ruleINTVALUE ) ) )
            // InternalExprParser.g:4076:3: () ( (lv_value_1_0= ruleINTVALUE ) )
            {
            // InternalExprParser.g:4076:3: ()
            // InternalExprParser.g:4077:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getEIntegerLiteralAccess().getEIntegerLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalExprParser.g:4083:3: ( (lv_value_1_0= ruleINTVALUE ) )
            // InternalExprParser.g:4084:4: (lv_value_1_0= ruleINTVALUE )
            {
            // InternalExprParser.g:4084:4: (lv_value_1_0= ruleINTVALUE )
            // InternalExprParser.g:4085:5: lv_value_1_0= ruleINTVALUE
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEIntegerLiteralAccess().getValueINTVALUEParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_1_0=ruleINTVALUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEIntegerLiteralRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEIntegerLiteral"


    // $ANTLR start "entryRuleERealLiteral"
    // InternalExprParser.g:4106:1: entryRuleERealLiteral returns [EObject current=null] : iv_ruleERealLiteral= ruleERealLiteral EOF ;
    public final EObject entryRuleERealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleERealLiteral = null;


        try {
            // InternalExprParser.g:4106:53: (iv_ruleERealLiteral= ruleERealLiteral EOF )
            // InternalExprParser.g:4107:2: iv_ruleERealLiteral= ruleERealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getERealLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleERealLiteral=ruleERealLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleERealLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleERealLiteral"


    // $ANTLR start "ruleERealLiteral"
    // InternalExprParser.g:4113:1: ruleERealLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleSignedReal ) ) ) ;
    public final EObject ruleERealLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4119:2: ( ( () ( (lv_value_1_0= ruleSignedReal ) ) ) )
            // InternalExprParser.g:4120:2: ( () ( (lv_value_1_0= ruleSignedReal ) ) )
            {
            // InternalExprParser.g:4120:2: ( () ( (lv_value_1_0= ruleSignedReal ) ) )
            // InternalExprParser.g:4121:3: () ( (lv_value_1_0= ruleSignedReal ) )
            {
            // InternalExprParser.g:4121:3: ()
            // InternalExprParser.g:4122:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getERealLiteralAccess().getERealLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalExprParser.g:4128:3: ( (lv_value_1_0= ruleSignedReal ) )
            // InternalExprParser.g:4129:4: (lv_value_1_0= ruleSignedReal )
            {
            // InternalExprParser.g:4129:4: (lv_value_1_0= ruleSignedReal )
            // InternalExprParser.g:4130:5: lv_value_1_0= ruleSignedReal
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getERealLiteralAccess().getValueSignedRealParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_1_0=ruleSignedReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getERealLiteralRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.osate.expr.Expr.SignedReal");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleERealLiteral"


    // $ANTLR start "entryRuleSignedReal"
    // InternalExprParser.g:4151:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // InternalExprParser.g:4151:50: (iv_ruleSignedReal= ruleSignedReal EOF )
            // InternalExprParser.g:4152:2: iv_ruleSignedReal= ruleSignedReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedRealRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSignedReal=ruleSignedReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedReal.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedReal"


    // $ANTLR start "ruleSignedReal"
    // InternalExprParser.g:4158:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;


        	enterRule();

        try {
            // InternalExprParser.g:4164:2: (this_REAL_LIT_0= RULE_REAL_LIT )
            // InternalExprParser.g:4165:2: this_REAL_LIT_0= RULE_REAL_LIT
            {
            this_REAL_LIT_0=(Token)match(input,RULE_REAL_LIT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_REAL_LIT_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_REAL_LIT_0, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedReal"


    // $ANTLR start "entryRuleEStringLiteral"
    // InternalExprParser.g:4175:1: entryRuleEStringLiteral returns [EObject current=null] : iv_ruleEStringLiteral= ruleEStringLiteral EOF ;
    public final EObject entryRuleEStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEStringLiteral = null;


        try {
            // InternalExprParser.g:4175:55: (iv_ruleEStringLiteral= ruleEStringLiteral EOF )
            // InternalExprParser.g:4176:2: iv_ruleEStringLiteral= ruleEStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEStringLiteral=ruleEStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEStringLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEStringLiteral"


    // $ANTLR start "ruleEStringLiteral"
    // InternalExprParser.g:4182:1: ruleEStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNoQuoteString ) ) ) ;
    public final EObject ruleEStringLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4188:2: ( ( () ( (lv_value_1_0= ruleNoQuoteString ) ) ) )
            // InternalExprParser.g:4189:2: ( () ( (lv_value_1_0= ruleNoQuoteString ) ) )
            {
            // InternalExprParser.g:4189:2: ( () ( (lv_value_1_0= ruleNoQuoteString ) ) )
            // InternalExprParser.g:4190:3: () ( (lv_value_1_0= ruleNoQuoteString ) )
            {
            // InternalExprParser.g:4190:3: ()
            // InternalExprParser.g:4191:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getEStringLiteralAccess().getEStringLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalExprParser.g:4197:3: ( (lv_value_1_0= ruleNoQuoteString ) )
            // InternalExprParser.g:4198:4: (lv_value_1_0= ruleNoQuoteString )
            {
            // InternalExprParser.g:4198:4: (lv_value_1_0= ruleNoQuoteString )
            // InternalExprParser.g:4199:5: lv_value_1_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEStringLiteralAccess().getValueNoQuoteStringParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_1_0=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEStringLiteralRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEStringLiteral"


    // $ANTLR start "ruleExpressionList"
    // InternalExprParser.g:4221:1: ruleExpressionList[EObject in_current] returns [EObject current=in_current] : (otherlv_0= LeftParenthesis ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )? otherlv_4= RightParenthesis ) ;
    public final EObject ruleExpressionList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4227:2: ( (otherlv_0= LeftParenthesis ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )? otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:4228:2: (otherlv_0= LeftParenthesis ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )? otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:4228:2: (otherlv_0= LeftParenthesis ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )? otherlv_4= RightParenthesis )
            // InternalExprParser.g:4229:3: otherlv_0= LeftParenthesis ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )? otherlv_4= RightParenthesis
            {
            otherlv_0=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExpressionListAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalExprParser.g:4233:3: ( ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )* )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==Record||LA63_0==False||(LA63_0>=Tuple && LA63_0<=Union)||LA63_0==List||LA63_0==True||LA63_0==Bag||LA63_0==Map||(LA63_0>=Not && LA63_0<=Set)||LA63_0==If||LA63_0==LeftParenthesis||LA63_0==PlusSign||LA63_0==HyphenMinus||LA63_0==LeftSquareBracket||(LA63_0>=CircumflexAccent && LA63_0<=LeftCurlyBracket)||LA63_0==RULE_REAL_LIT||LA63_0==RULE_INTEGER_LIT||(LA63_0>=RULE_STRING && LA63_0<=RULE_ID)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalExprParser.g:4234:4: ( (lv_elements_1_0= ruleExpression ) ) (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )*
                    {
                    // InternalExprParser.g:4234:4: ( (lv_elements_1_0= ruleExpression ) )
                    // InternalExprParser.g:4235:5: (lv_elements_1_0= ruleExpression )
                    {
                    // InternalExprParser.g:4235:5: (lv_elements_1_0= ruleExpression )
                    // InternalExprParser.g:4236:6: lv_elements_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionListAccess().getElementsExpressionParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_42);
                    lv_elements_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExpressionListRule());
                      						}
                      						add(
                      							current,
                      							"elements",
                      							lv_elements_1_0,
                      							"org.osate.expr.Expr.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExprParser.g:4253:4: (otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==Comma) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalExprParser.g:4254:5: otherlv_2= Comma ( (lv_elements_3_0= ruleExpression ) )
                    	    {
                    	    otherlv_2=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_2, grammarAccess.getExpressionListAccess().getCommaKeyword_1_1_0());
                    	      				
                    	    }
                    	    // InternalExprParser.g:4258:5: ( (lv_elements_3_0= ruleExpression ) )
                    	    // InternalExprParser.g:4259:6: (lv_elements_3_0= ruleExpression )
                    	    {
                    	    // InternalExprParser.g:4259:6: (lv_elements_3_0= ruleExpression )
                    	    // InternalExprParser.g:4260:7: lv_elements_3_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getExpressionListAccess().getElementsExpressionParserRuleCall_1_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_42);
                    	    lv_elements_3_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getExpressionListRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"elements",
                    	      								lv_elements_3_0,
                    	      								"org.osate.expr.Expr.Expression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getExpressionListAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionList"


    // $ANTLR start "entryRuleListLiteral"
    // InternalExprParser.g:4287:1: entryRuleListLiteral returns [EObject current=null] : iv_ruleListLiteral= ruleListLiteral EOF ;
    public final EObject entryRuleListLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListLiteral = null;


        try {
            // InternalExprParser.g:4287:52: (iv_ruleListLiteral= ruleListLiteral EOF )
            // InternalExprParser.g:4288:2: iv_ruleListLiteral= ruleListLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleListLiteral=ruleListLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListLiteral"


    // $ANTLR start "ruleListLiteral"
    // InternalExprParser.g:4294:1: ruleListLiteral returns [EObject current=null] : ( () otherlv_1= List this_ExpressionList_2= ruleExpressionList[$current] ) ;
    public final EObject ruleListLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionList_2 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4300:2: ( ( () otherlv_1= List this_ExpressionList_2= ruleExpressionList[$current] ) )
            // InternalExprParser.g:4301:2: ( () otherlv_1= List this_ExpressionList_2= ruleExpressionList[$current] )
            {
            // InternalExprParser.g:4301:2: ( () otherlv_1= List this_ExpressionList_2= ruleExpressionList[$current] )
            // InternalExprParser.g:4302:3: () otherlv_1= List this_ExpressionList_2= ruleExpressionList[$current]
            {
            // InternalExprParser.g:4302:3: ()
            // InternalExprParser.g:4303:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getListLiteralAccess().getListLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,List,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getListLiteralAccess().getListKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getListLiteralRule());
              			}
              			newCompositeNode(grammarAccess.getListLiteralAccess().getExpressionListParserRuleCall_2());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ExpressionList_2=ruleExpressionList(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExpressionList_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListLiteral"


    // $ANTLR start "entryRuleSetLiteral"
    // InternalExprParser.g:4328:1: entryRuleSetLiteral returns [EObject current=null] : iv_ruleSetLiteral= ruleSetLiteral EOF ;
    public final EObject entryRuleSetLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetLiteral = null;


        try {
            // InternalExprParser.g:4328:51: (iv_ruleSetLiteral= ruleSetLiteral EOF )
            // InternalExprParser.g:4329:2: iv_ruleSetLiteral= ruleSetLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSetLiteral=ruleSetLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetLiteral"


    // $ANTLR start "ruleSetLiteral"
    // InternalExprParser.g:4335:1: ruleSetLiteral returns [EObject current=null] : ( () otherlv_1= Set this_ExpressionList_2= ruleExpressionList[$current] ) ;
    public final EObject ruleSetLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionList_2 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4341:2: ( ( () otherlv_1= Set this_ExpressionList_2= ruleExpressionList[$current] ) )
            // InternalExprParser.g:4342:2: ( () otherlv_1= Set this_ExpressionList_2= ruleExpressionList[$current] )
            {
            // InternalExprParser.g:4342:2: ( () otherlv_1= Set this_ExpressionList_2= ruleExpressionList[$current] )
            // InternalExprParser.g:4343:3: () otherlv_1= Set this_ExpressionList_2= ruleExpressionList[$current]
            {
            // InternalExprParser.g:4343:3: ()
            // InternalExprParser.g:4344:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetLiteralAccess().getSetLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Set,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSetLiteralAccess().getSetKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getSetLiteralRule());
              			}
              			newCompositeNode(grammarAccess.getSetLiteralAccess().getExpressionListParserRuleCall_2());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ExpressionList_2=ruleExpressionList(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExpressionList_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetLiteral"


    // $ANTLR start "entryRuleRecordLiteral"
    // InternalExprParser.g:4369:1: entryRuleRecordLiteral returns [EObject current=null] : iv_ruleRecordLiteral= ruleRecordLiteral EOF ;
    public final EObject entryRuleRecordLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordLiteral = null;


        try {
            // InternalExprParser.g:4369:54: (iv_ruleRecordLiteral= ruleRecordLiteral EOF )
            // InternalExprParser.g:4370:2: iv_ruleRecordLiteral= ruleRecordLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRecordLiteral=ruleRecordLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordLiteral"


    // $ANTLR start "ruleRecordLiteral"
    // InternalExprParser.g:4376:1: ruleRecordLiteral returns [EObject current=null] : ( () otherlv_1= Record otherlv_2= LeftParenthesis ( ( (lv_fieldValues_3_0= ruleFieldValue ) ) (otherlv_4= Comma ( (lv_fieldValues_5_0= ruleFieldValue ) ) )* )? otherlv_6= RightParenthesis ) ;
    public final EObject ruleRecordLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_fieldValues_3_0 = null;

        EObject lv_fieldValues_5_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4382:2: ( ( () otherlv_1= Record otherlv_2= LeftParenthesis ( ( (lv_fieldValues_3_0= ruleFieldValue ) ) (otherlv_4= Comma ( (lv_fieldValues_5_0= ruleFieldValue ) ) )* )? otherlv_6= RightParenthesis ) )
            // InternalExprParser.g:4383:2: ( () otherlv_1= Record otherlv_2= LeftParenthesis ( ( (lv_fieldValues_3_0= ruleFieldValue ) ) (otherlv_4= Comma ( (lv_fieldValues_5_0= ruleFieldValue ) ) )* )? otherlv_6= RightParenthesis )
            {
            // InternalExprParser.g:4383:2: ( () otherlv_1= Record otherlv_2= LeftParenthesis ( ( (lv_fieldValues_3_0= ruleFieldValue ) ) (otherlv_4= Comma ( (lv_fieldValues_5_0= ruleFieldValue ) ) )* )? otherlv_6= RightParenthesis )
            // InternalExprParser.g:4384:3: () otherlv_1= Record otherlv_2= LeftParenthesis ( ( (lv_fieldValues_3_0= ruleFieldValue ) ) (otherlv_4= Comma ( (lv_fieldValues_5_0= ruleFieldValue ) ) )* )? otherlv_6= RightParenthesis
            {
            // InternalExprParser.g:4384:3: ()
            // InternalExprParser.g:4385:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRecordLiteralAccess().getRecordLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Record,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRecordLiteralAccess().getRecordKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRecordLiteralAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalExprParser.g:4399:3: ( ( (lv_fieldValues_3_0= ruleFieldValue ) ) (otherlv_4= Comma ( (lv_fieldValues_5_0= ruleFieldValue ) ) )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalExprParser.g:4400:4: ( (lv_fieldValues_3_0= ruleFieldValue ) ) (otherlv_4= Comma ( (lv_fieldValues_5_0= ruleFieldValue ) ) )*
                    {
                    // InternalExprParser.g:4400:4: ( (lv_fieldValues_3_0= ruleFieldValue ) )
                    // InternalExprParser.g:4401:5: (lv_fieldValues_3_0= ruleFieldValue )
                    {
                    // InternalExprParser.g:4401:5: (lv_fieldValues_3_0= ruleFieldValue )
                    // InternalExprParser.g:4402:6: lv_fieldValues_3_0= ruleFieldValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRecordLiteralAccess().getFieldValuesFieldValueParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_42);
                    lv_fieldValues_3_0=ruleFieldValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRecordLiteralRule());
                      						}
                      						add(
                      							current,
                      							"fieldValues",
                      							lv_fieldValues_3_0,
                      							"org.osate.expr.Expr.FieldValue");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExprParser.g:4419:4: (otherlv_4= Comma ( (lv_fieldValues_5_0= ruleFieldValue ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==Comma) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalExprParser.g:4420:5: otherlv_4= Comma ( (lv_fieldValues_5_0= ruleFieldValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getRecordLiteralAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalExprParser.g:4424:5: ( (lv_fieldValues_5_0= ruleFieldValue ) )
                    	    // InternalExprParser.g:4425:6: (lv_fieldValues_5_0= ruleFieldValue )
                    	    {
                    	    // InternalExprParser.g:4425:6: (lv_fieldValues_5_0= ruleFieldValue )
                    	    // InternalExprParser.g:4426:7: lv_fieldValues_5_0= ruleFieldValue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRecordLiteralAccess().getFieldValuesFieldValueParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_42);
                    	    lv_fieldValues_5_0=ruleFieldValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getRecordLiteralRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"fieldValues",
                    	      								lv_fieldValues_5_0,
                    	      								"org.osate.expr.Expr.FieldValue");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getRecordLiteralAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordLiteral"


    // $ANTLR start "entryRuleFieldValue"
    // InternalExprParser.g:4453:1: entryRuleFieldValue returns [EObject current=null] : iv_ruleFieldValue= ruleFieldValue EOF ;
    public final EObject entryRuleFieldValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldValue = null;


        try {
            // InternalExprParser.g:4453:51: (iv_ruleFieldValue= ruleFieldValue EOF )
            // InternalExprParser.g:4454:2: iv_ruleFieldValue= ruleFieldValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFieldValue=ruleFieldValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFieldValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldValue"


    // $ANTLR start "ruleFieldValue"
    // InternalExprParser.g:4460:1: ruleFieldValue returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleFieldValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4466:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_value_2_0= ruleExpression ) ) ) )
            // InternalExprParser.g:4467:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_value_2_0= ruleExpression ) ) )
            {
            // InternalExprParser.g:4467:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_value_2_0= ruleExpression ) ) )
            // InternalExprParser.g:4468:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_value_2_0= ruleExpression ) )
            {
            // InternalExprParser.g:4468:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalExprParser.g:4469:4: (lv_name_0_0= RULE_ID )
            {
            // InternalExprParser.g:4469:4: (lv_name_0_0= RULE_ID )
            // InternalExprParser.g:4470:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getFieldValueAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFieldValueRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFieldValueAccess().getColonKeyword_1());
              		
            }
            // InternalExprParser.g:4490:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalExprParser.g:4491:4: (lv_value_2_0= ruleExpression )
            {
            // InternalExprParser.g:4491:4: (lv_value_2_0= ruleExpression )
            // InternalExprParser.g:4492:5: lv_value_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFieldValueAccess().getValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFieldValueRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"org.osate.expr.Expr.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldValue"


    // $ANTLR start "entryRuleUnionLiteral"
    // InternalExprParser.g:4513:1: entryRuleUnionLiteral returns [EObject current=null] : iv_ruleUnionLiteral= ruleUnionLiteral EOF ;
    public final EObject entryRuleUnionLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnionLiteral = null;


        try {
            // InternalExprParser.g:4513:53: (iv_ruleUnionLiteral= ruleUnionLiteral EOF )
            // InternalExprParser.g:4514:2: iv_ruleUnionLiteral= ruleUnionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnionLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnionLiteral=ruleUnionLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnionLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnionLiteral"


    // $ANTLR start "ruleUnionLiteral"
    // InternalExprParser.g:4520:1: ruleUnionLiteral returns [EObject current=null] : ( () otherlv_1= Union otherlv_2= LeftParenthesis ( (lv_fieldValue_3_0= ruleFieldValue ) ) otherlv_4= RightParenthesis ) ;
    public final EObject ruleUnionLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_fieldValue_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4526:2: ( ( () otherlv_1= Union otherlv_2= LeftParenthesis ( (lv_fieldValue_3_0= ruleFieldValue ) ) otherlv_4= RightParenthesis ) )
            // InternalExprParser.g:4527:2: ( () otherlv_1= Union otherlv_2= LeftParenthesis ( (lv_fieldValue_3_0= ruleFieldValue ) ) otherlv_4= RightParenthesis )
            {
            // InternalExprParser.g:4527:2: ( () otherlv_1= Union otherlv_2= LeftParenthesis ( (lv_fieldValue_3_0= ruleFieldValue ) ) otherlv_4= RightParenthesis )
            // InternalExprParser.g:4528:3: () otherlv_1= Union otherlv_2= LeftParenthesis ( (lv_fieldValue_3_0= ruleFieldValue ) ) otherlv_4= RightParenthesis
            {
            // InternalExprParser.g:4528:3: ()
            // InternalExprParser.g:4529:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUnionLiteralAccess().getUnionLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Union,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUnionLiteralAccess().getUnionKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getUnionLiteralAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalExprParser.g:4543:3: ( (lv_fieldValue_3_0= ruleFieldValue ) )
            // InternalExprParser.g:4544:4: (lv_fieldValue_3_0= ruleFieldValue )
            {
            // InternalExprParser.g:4544:4: (lv_fieldValue_3_0= ruleFieldValue )
            // InternalExprParser.g:4545:5: lv_fieldValue_3_0= ruleFieldValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnionLiteralAccess().getFieldValueFieldValueParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_15);
            lv_fieldValue_3_0=ruleFieldValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnionLiteralRule());
              					}
              					set(
              						current,
              						"fieldValue",
              						lv_fieldValue_3_0,
              						"org.osate.expr.Expr.FieldValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getUnionLiteralAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnionLiteral"


    // $ANTLR start "entryRuleTupleLiteral"
    // InternalExprParser.g:4570:1: entryRuleTupleLiteral returns [EObject current=null] : iv_ruleTupleLiteral= ruleTupleLiteral EOF ;
    public final EObject entryRuleTupleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteral = null;


        try {
            // InternalExprParser.g:4570:53: (iv_ruleTupleLiteral= ruleTupleLiteral EOF )
            // InternalExprParser.g:4571:2: iv_ruleTupleLiteral= ruleTupleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTupleLiteral=ruleTupleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleLiteral"


    // $ANTLR start "ruleTupleLiteral"
    // InternalExprParser.g:4577:1: ruleTupleLiteral returns [EObject current=null] : ( () otherlv_1= Tuple this_ExpressionList_2= ruleExpressionList[$current] ) ;
    public final EObject ruleTupleLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionList_2 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4583:2: ( ( () otherlv_1= Tuple this_ExpressionList_2= ruleExpressionList[$current] ) )
            // InternalExprParser.g:4584:2: ( () otherlv_1= Tuple this_ExpressionList_2= ruleExpressionList[$current] )
            {
            // InternalExprParser.g:4584:2: ( () otherlv_1= Tuple this_ExpressionList_2= ruleExpressionList[$current] )
            // InternalExprParser.g:4585:3: () otherlv_1= Tuple this_ExpressionList_2= ruleExpressionList[$current]
            {
            // InternalExprParser.g:4585:3: ()
            // InternalExprParser.g:4586:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTupleLiteralAccess().getTupleLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Tuple,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTupleLiteralAccess().getTupleKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getTupleLiteralRule());
              			}
              			newCompositeNode(grammarAccess.getTupleLiteralAccess().getExpressionListParserRuleCall_2());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ExpressionList_2=ruleExpressionList(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExpressionList_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleLiteral"


    // $ANTLR start "entryRuleBagLiteral"
    // InternalExprParser.g:4611:1: entryRuleBagLiteral returns [EObject current=null] : iv_ruleBagLiteral= ruleBagLiteral EOF ;
    public final EObject entryRuleBagLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBagLiteral = null;


        try {
            // InternalExprParser.g:4611:51: (iv_ruleBagLiteral= ruleBagLiteral EOF )
            // InternalExprParser.g:4612:2: iv_ruleBagLiteral= ruleBagLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBagLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBagLiteral=ruleBagLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBagLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBagLiteral"


    // $ANTLR start "ruleBagLiteral"
    // InternalExprParser.g:4618:1: ruleBagLiteral returns [EObject current=null] : ( () otherlv_1= Bag this_ExpressionList_2= ruleExpressionList[$current] ) ;
    public final EObject ruleBagLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ExpressionList_2 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4624:2: ( ( () otherlv_1= Bag this_ExpressionList_2= ruleExpressionList[$current] ) )
            // InternalExprParser.g:4625:2: ( () otherlv_1= Bag this_ExpressionList_2= ruleExpressionList[$current] )
            {
            // InternalExprParser.g:4625:2: ( () otherlv_1= Bag this_ExpressionList_2= ruleExpressionList[$current] )
            // InternalExprParser.g:4626:3: () otherlv_1= Bag this_ExpressionList_2= ruleExpressionList[$current]
            {
            // InternalExprParser.g:4626:3: ()
            // InternalExprParser.g:4627:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBagLiteralAccess().getBagLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Bag,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBagLiteralAccess().getBagKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getBagLiteralRule());
              			}
              			newCompositeNode(grammarAccess.getBagLiteralAccess().getExpressionListParserRuleCall_2());
              		
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ExpressionList_2=ruleExpressionList(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExpressionList_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBagLiteral"


    // $ANTLR start "entryRuleMapLiteral"
    // InternalExprParser.g:4652:1: entryRuleMapLiteral returns [EObject current=null] : iv_ruleMapLiteral= ruleMapLiteral EOF ;
    public final EObject entryRuleMapLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteral = null;


        try {
            // InternalExprParser.g:4652:51: (iv_ruleMapLiteral= ruleMapLiteral EOF )
            // InternalExprParser.g:4653:2: iv_ruleMapLiteral= ruleMapLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMapLiteral=ruleMapLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapLiteral"


    // $ANTLR start "ruleMapLiteral"
    // InternalExprParser.g:4659:1: ruleMapLiteral returns [EObject current=null] : ( () otherlv_1= Map ) ;
    public final EObject ruleMapLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalExprParser.g:4665:2: ( ( () otherlv_1= Map ) )
            // InternalExprParser.g:4666:2: ( () otherlv_1= Map )
            {
            // InternalExprParser.g:4666:2: ( () otherlv_1= Map )
            // InternalExprParser.g:4667:3: () otherlv_1= Map
            {
            // InternalExprParser.g:4667:3: ()
            // InternalExprParser.g:4668:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMapLiteralAccess().getMapLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Map,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMapLiteralAccess().getMapKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapLiteral"


    // $ANTLR start "entryRuleQCREF"
    // InternalExprParser.g:4682:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalExprParser.g:4682:45: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalExprParser.g:4683:2: iv_ruleQCREF= ruleQCREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQCREFRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQCREF.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQCREF"


    // $ANTLR start "ruleQCREF"
    // InternalExprParser.g:4689:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= Colon this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;


        	enterRule();

        try {
            // InternalExprParser.g:4695:2: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= Colon this_ID_4= RULE_ID )? ) )
            // InternalExprParser.g:4696:2: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= Colon this_ID_4= RULE_ID )? )
            {
            // InternalExprParser.g:4696:2: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= Colon this_ID_4= RULE_ID )? )
            // InternalExprParser.g:4697:3: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= Colon this_ID_4= RULE_ID )?
            {
            // InternalExprParser.g:4697:3: (this_ID_0= RULE_ID kw= ColonColon )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==RULE_ID) ) {
                    int LA66_1 = input.LA(2);

                    if ( (LA66_1==ColonColon) ) {
                        alt66=1;
                    }


                }


                switch (alt66) {
            	case 1 :
            	    // InternalExprParser.g:4698:4: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_50); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_0);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0());
            	      			
            	    }
            	    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_2);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1());
              		
            }
            // InternalExprParser.g:4718:3: (kw= Colon this_ID_4= RULE_ID )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==Colon) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalExprParser.g:4719:4: kw= Colon this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,Colon,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getQCREFAccess().getColonKeyword_2_0());
                      			
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_4);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQCREF"


    // $ANTLR start "entryRuleContainedPropertyAssociation"
    // InternalExprParser.g:4736:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalExprParser.g:4736:69: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalExprParser.g:4737:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainedPropertyAssociation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainedPropertyAssociation"


    // $ANTLR start "ruleContainedPropertyAssociation"
    // InternalExprParser.g:4743:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) ;
    public final EObject ruleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_append_2_0=null;
        Token lv_constant_3_0=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        EObject lv_ownedValue_4_0 = null;

        EObject lv_ownedValue_6_0 = null;

        EObject lv_appliesTo_8_0 = null;

        EObject lv_appliesTo_10_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4749:2: ( ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) )
            // InternalExprParser.g:4750:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            {
            // InternalExprParser.g:4750:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            // InternalExprParser.g:4751:3: ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon
            {
            // InternalExprParser.g:4751:3: ( ( ruleQPREF ) )
            // InternalExprParser.g:4752:4: ( ruleQPREF )
            {
            // InternalExprParser.g:4752:4: ( ruleQPREF )
            // InternalExprParser.g:4753:5: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_52);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:4767:3: (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==EqualsSignGreaterThanSign) ) {
                alt68=1;
            }
            else if ( (LA68_0==PlusSignEqualsSignGreaterThanSign) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalExprParser.g:4768:4: otherlv_1= EqualsSignGreaterThanSign
                    {
                    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:4773:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    {
                    // InternalExprParser.g:4773:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    // InternalExprParser.g:4774:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    {
                    // InternalExprParser.g:4774:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    // InternalExprParser.g:4775:6: lv_append_2_0= PlusSignEqualsSignGreaterThanSign
                    {
                    lv_append_2_0=(Token)match(input,PlusSignEqualsSignGreaterThanSign,FollowSets000.FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      						}
                      						setWithLastConsumed(current, "append", true, "+=>");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalExprParser.g:4788:3: ( (lv_constant_3_0= Constant ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==Constant) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalExprParser.g:4789:4: (lv_constant_3_0= Constant )
                    {
                    // InternalExprParser.g:4789:4: (lv_constant_3_0= Constant )
                    // InternalExprParser.g:4790:5: lv_constant_3_0= Constant
                    {
                    lv_constant_3_0=(Token)match(input,Constant,FollowSets000.FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      					}
                      					setWithLastConsumed(current, "constant", true, "constant");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalExprParser.g:4802:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalExprParser.g:4803:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalExprParser.g:4803:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalExprParser.g:4804:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalExprParser.g:4804:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalExprParser.g:4805:6: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());
              					
            }
            pushFollow(FollowSets000.FOLLOW_54);
            lv_ownedValue_4_0=ruleOptionalModalPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
              						}
              						add(
              							current,
              							"ownedValue",
              							lv_ownedValue_4_0,
              							"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            // InternalExprParser.g:4822:4: (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==Comma) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalExprParser.g:4823:5: otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_53); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	      				
            	    }
            	    // InternalExprParser.g:4827:5: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalExprParser.g:4828:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalExprParser.g:4828:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalExprParser.g:4829:7: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_54);
            	    lv_ownedValue_6_0=ruleOptionalModalPropertyValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
            	      							}
            	      							add(
            	      								current,
            	      								"ownedValue",
            	      								lv_ownedValue_6_0,
            	      								"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            }

            // InternalExprParser.g:4848:3: ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==Applies) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalExprParser.g:4849:4: ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
                    ruleAppliesToKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalExprParser.g:4856:4: ( (lv_appliesTo_8_0= ruleContainmentPath ) )
                    // InternalExprParser.g:4857:5: (lv_appliesTo_8_0= ruleContainmentPath )
                    {
                    // InternalExprParser.g:4857:5: (lv_appliesTo_8_0= ruleContainmentPath )
                    // InternalExprParser.g:4858:6: lv_appliesTo_8_0= ruleContainmentPath
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_55);
                    lv_appliesTo_8_0=ruleContainmentPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                      						}
                      						add(
                      							current,
                      							"appliesTo",
                      							lv_appliesTo_8_0,
                      							"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExprParser.g:4875:4: (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==Comma) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // InternalExprParser.g:4876:5: otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalExprParser.g:4880:5: ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    // InternalExprParser.g:4881:6: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    {
                    	    // InternalExprParser.g:4881:6: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    // InternalExprParser.g:4882:7: lv_appliesTo_10_0= ruleContainmentPath
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_55);
                    	    lv_appliesTo_10_0=ruleContainmentPath();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"appliesTo",
                    	      								lv_appliesTo_10_0,
                    	      								"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalExprParser.g:4901:3: ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==In) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalExprParser.g:4902:4: ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_13);
                    ruleInBindingKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_12=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1());
                      			
                    }
                    // InternalExprParser.g:4913:4: ( ( ruleQCREF ) )
                    // InternalExprParser.g:4914:5: ( ruleQCREF )
                    {
                    // InternalExprParser.g:4914:5: ( ruleQCREF )
                    // InternalExprParser.g:4915:6: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_15);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_14=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_15=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_15, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainedPropertyAssociation"


    // $ANTLR start "entryRulePropertyAssociation"
    // InternalExprParser.g:4942:1: entryRulePropertyAssociation returns [EObject current=null] : iv_rulePropertyAssociation= rulePropertyAssociation EOF ;
    public final EObject entryRulePropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssociation = null;


        try {
            // InternalExprParser.g:4942:60: (iv_rulePropertyAssociation= rulePropertyAssociation EOF )
            // InternalExprParser.g:4943:2: iv_rulePropertyAssociation= rulePropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyAssociationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyAssociation=rulePropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyAssociation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyAssociation"


    // $ANTLR start "rulePropertyAssociation"
    // InternalExprParser.g:4949:1: rulePropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleInBindingKeywords otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) otherlv_10= RightParenthesis )? otherlv_11= Semicolon ) ;
    public final EObject rulePropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_append_2_0=null;
        Token lv_constant_3_0=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_ownedValue_4_0 = null;

        EObject lv_ownedValue_6_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:4955:2: ( ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleInBindingKeywords otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) otherlv_10= RightParenthesis )? otherlv_11= Semicolon ) )
            // InternalExprParser.g:4956:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleInBindingKeywords otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) otherlv_10= RightParenthesis )? otherlv_11= Semicolon )
            {
            // InternalExprParser.g:4956:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleInBindingKeywords otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) otherlv_10= RightParenthesis )? otherlv_11= Semicolon )
            // InternalExprParser.g:4957:3: ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleInBindingKeywords otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) otherlv_10= RightParenthesis )? otherlv_11= Semicolon
            {
            // InternalExprParser.g:4957:3: ( ( ruleQPREF ) )
            // InternalExprParser.g:4958:4: ( ruleQPREF )
            {
            // InternalExprParser.g:4958:4: ( ruleQPREF )
            // InternalExprParser.g:4959:5: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPropertyAssociationRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_52);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:4973:3: (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==EqualsSignGreaterThanSign) ) {
                alt74=1;
            }
            else if ( (LA74_0==PlusSignEqualsSignGreaterThanSign) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalExprParser.g:4974:4: otherlv_1= EqualsSignGreaterThanSign
                    {
                    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:4979:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    {
                    // InternalExprParser.g:4979:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    // InternalExprParser.g:4980:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    {
                    // InternalExprParser.g:4980:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    // InternalExprParser.g:4981:6: lv_append_2_0= PlusSignEqualsSignGreaterThanSign
                    {
                    lv_append_2_0=(Token)match(input,PlusSignEqualsSignGreaterThanSign,FollowSets000.FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_append_2_0, grammarAccess.getPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPropertyAssociationRule());
                      						}
                      						setWithLastConsumed(current, "append", true, "+=>");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalExprParser.g:4994:3: ( (lv_constant_3_0= Constant ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==Constant) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalExprParser.g:4995:4: (lv_constant_3_0= Constant )
                    {
                    // InternalExprParser.g:4995:4: (lv_constant_3_0= Constant )
                    // InternalExprParser.g:4996:5: lv_constant_3_0= Constant
                    {
                    lv_constant_3_0=(Token)match(input,Constant,FollowSets000.FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_constant_3_0, grammarAccess.getPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPropertyAssociationRule());
                      					}
                      					setWithLastConsumed(current, "constant", true, "constant");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalExprParser.g:5008:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalExprParser.g:5009:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalExprParser.g:5009:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalExprParser.g:5010:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalExprParser.g:5010:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalExprParser.g:5011:6: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());
              					
            }
            pushFollow(FollowSets000.FOLLOW_55);
            lv_ownedValue_4_0=ruleOptionalModalPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getPropertyAssociationRule());
              						}
              						add(
              							current,
              							"ownedValue",
              							lv_ownedValue_4_0,
              							"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            // InternalExprParser.g:5028:4: (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==Comma) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalExprParser.g:5029:5: otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_53); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_5, grammarAccess.getPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	      				
            	    }
            	    // InternalExprParser.g:5033:5: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalExprParser.g:5034:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalExprParser.g:5034:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalExprParser.g:5035:7: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_55);
            	    lv_ownedValue_6_0=ruleOptionalModalPropertyValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getPropertyAssociationRule());
            	      							}
            	      							add(
            	      								current,
            	      								"ownedValue",
            	      								lv_ownedValue_6_0,
            	      								"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            }

            // InternalExprParser.g:5054:3: ( ruleInBindingKeywords otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) otherlv_10= RightParenthesis )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==In) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalExprParser.g:5055:4: ruleInBindingKeywords otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) otherlv_10= RightParenthesis
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_4_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_13);
                    ruleInBindingKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_8=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getPropertyAssociationAccess().getLeftParenthesisKeyword_4_1());
                      			
                    }
                    // InternalExprParser.g:5066:4: ( ( ruleQCREF ) )
                    // InternalExprParser.g:5067:5: ( ruleQCREF )
                    {
                    // InternalExprParser.g:5067:5: ( ruleQCREF )
                    // InternalExprParser.g:5068:6: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPropertyAssociationRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPropertyAssociationAccess().getInBindingClassifierCrossReference_4_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_15);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getPropertyAssociationAccess().getRightParenthesisKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_11=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getPropertyAssociationAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyAssociation"


    // $ANTLR start "entryRuleContainmentPath"
    // InternalExprParser.g:5095:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalExprParser.g:5095:56: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalExprParser.g:5096:2: iv_ruleContainmentPath= ruleContainmentPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainmentPath=ruleContainmentPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPath; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPath"


    // $ANTLR start "ruleContainmentPath"
    // InternalExprParser.g:5102:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:5108:2: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalExprParser.g:5109:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalExprParser.g:5109:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalExprParser.g:5110:3: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalExprParser.g:5110:3: (lv_path_0_0= ruleContainmentPathElement )
            // InternalExprParser.g:5111:4: lv_path_0_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_path_0_0=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getContainmentPathRule());
              				}
              				set(
              					current,
              					"path",
              					lv_path_0_0,
              					"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainmentPath"


    // $ANTLR start "entryRuleOptionalModalPropertyValue"
    // InternalExprParser.g:5131:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalExprParser.g:5131:67: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalExprParser.g:5132:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptionalModalPropertyValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptionalModalPropertyValue"


    // $ANTLR start "ruleOptionalModalPropertyValue"
    // InternalExprParser.g:5138:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) ;
    public final EObject ruleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_ownedValue_0_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:5144:2: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) )
            // InternalExprParser.g:5145:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            {
            // InternalExprParser.g:5145:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            // InternalExprParser.g:5146:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            {
            // InternalExprParser.g:5146:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalExprParser.g:5147:4: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalExprParser.g:5147:4: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalExprParser.g:5148:5: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_56);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
              					}
              					set(
              						current,
              						"ownedValue",
              						lv_ownedValue_0_0,
              						"org.osate.expr.Expr.PropertyExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:5165:3: ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==In) ) {
                int LA79_1 = input.LA(2);

                if ( (LA79_1==Modes) ) {
                    alt79=1;
                }
            }
            switch (alt79) {
                case 1 :
                    // InternalExprParser.g:5166:4: ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_13);
                    ruleInModesKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1());
                      			
                    }
                    // InternalExprParser.g:5177:4: ( (otherlv_3= RULE_ID ) )
                    // InternalExprParser.g:5178:5: (otherlv_3= RULE_ID )
                    {
                    // InternalExprParser.g:5178:5: (otherlv_3= RULE_ID )
                    // InternalExprParser.g:5179:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0());
                      					
                    }

                    }


                    }

                    // InternalExprParser.g:5190:4: (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==Comma) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // InternalExprParser.g:5191:5: otherlv_4= Comma ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0());
                    	      				
                    	    }
                    	    // InternalExprParser.g:5195:5: ( (otherlv_5= RULE_ID ) )
                    	    // InternalExprParser.g:5196:6: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalExprParser.g:5196:6: (otherlv_5= RULE_ID )
                    	    // InternalExprParser.g:5197:7: otherlv_5= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_42); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_4());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptionalModalPropertyValue"


    // $ANTLR start "entryRulePropertyValue"
    // InternalExprParser.g:5218:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalExprParser.g:5218:54: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalExprParser.g:5219:2: iv_rulePropertyValue= rulePropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyValue=rulePropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyValue"


    // $ANTLR start "rulePropertyValue"
    // InternalExprParser.g:5225:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:5231:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalExprParser.g:5232:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalExprParser.g:5232:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalExprParser.g:5233:3: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalExprParser.g:5233:3: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalExprParser.g:5234:4: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getPropertyValueRule());
              				}
              				set(
              					current,
              					"ownedValue",
              					lv_ownedValue_0_0,
              					"org.osate.expr.Expr.PropertyExpression");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyValue"


    // $ANTLR start "entryRuleConstantValue"
    // InternalExprParser.g:5254:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalExprParser.g:5254:54: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalExprParser.g:5255:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantValue"


    // $ANTLR start "ruleConstantValue"
    // InternalExprParser.g:5261:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalExprParser.g:5267:2: ( ( ( ruleQPREF ) ) )
            // InternalExprParser.g:5268:2: ( ( ruleQPREF ) )
            {
            // InternalExprParser.g:5268:2: ( ( ruleQPREF ) )
            // InternalExprParser.g:5269:3: ( ruleQPREF )
            {
            // InternalExprParser.g:5269:3: ( ruleQPREF )
            // InternalExprParser.g:5270:4: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getConstantValueRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleFieldPropertyAssociation"
    // InternalExprParser.g:5287:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalExprParser.g:5287:65: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalExprParser.g:5288:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFieldPropertyAssociation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldPropertyAssociation"


    // $ANTLR start "ruleFieldPropertyAssociation"
    // InternalExprParser.g:5294:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:5300:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) )
            // InternalExprParser.g:5301:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            {
            // InternalExprParser.g:5301:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            // InternalExprParser.g:5302:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon
            {
            // InternalExprParser.g:5302:3: ( (otherlv_0= RULE_ID ) )
            // InternalExprParser.g:5303:4: (otherlv_0= RULE_ID )
            {
            // InternalExprParser.g:5303:4: (otherlv_0= RULE_ID )
            // InternalExprParser.g:5304:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
              		
            }
            // InternalExprParser.g:5319:3: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalExprParser.g:5320:4: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalExprParser.g:5320:4: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalExprParser.g:5321:5: lv_ownedValue_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_29);
            lv_ownedValue_2_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
              					}
              					set(
              						current,
              						"ownedValue",
              						lv_ownedValue_2_0,
              						"org.osate.expr.Expr.PropertyExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPathElement"
    // InternalExprParser.g:5346:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalExprParser.g:5346:63: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalExprParser.g:5347:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPathElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPathElement"


    // $ANTLR start "ruleContainmentPathElement"
    // InternalExprParser.g:5353:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:5359:2: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalExprParser.g:5360:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalExprParser.g:5360:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalExprParser.g:5361:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalExprParser.g:5361:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* )
            // InternalExprParser.g:5362:4: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            {
            // InternalExprParser.g:5362:4: ( (otherlv_0= RULE_ID ) )
            // InternalExprParser.g:5363:5: (otherlv_0= RULE_ID )
            {
            // InternalExprParser.g:5363:5: (otherlv_0= RULE_ID )
            // InternalExprParser.g:5364:6: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getContainmentPathElementRule());
              						}
              					
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0());
              					
            }

            }


            }

            // InternalExprParser.g:5375:4: ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==LeftSquareBracket) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalExprParser.g:5376:5: (lv_arrayRange_1_0= ruleArrayRange )
            	    {
            	    // InternalExprParser.g:5376:5: (lv_arrayRange_1_0= ruleArrayRange )
            	    // InternalExprParser.g:5377:6: lv_arrayRange_1_0= ruleArrayRange
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_58);
            	    lv_arrayRange_1_0=ruleArrayRange();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
            	      						}
            	      						add(
            	      							current,
            	      							"arrayRange",
            	      							lv_arrayRange_1_0,
            	      							"org.osate.xtext.aadl2.properties.Properties.ArrayRange");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);


            }

            // InternalExprParser.g:5395:3: (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==FullStop) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalExprParser.g:5396:4: otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,FullStop,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
                      			
                    }
                    // InternalExprParser.g:5400:4: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalExprParser.g:5401:5: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalExprParser.g:5401:5: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalExprParser.g:5402:6: lv_path_3_0= ruleContainmentPathElement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_path_3_0=ruleContainmentPathElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
                      						}
                      						set(
                      							current,
                      							"path",
                      							lv_path_3_0,
                      							"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainmentPathElement"


    // $ANTLR start "entryRulePlusMinus"
    // InternalExprParser.g:5424:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalExprParser.g:5424:49: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalExprParser.g:5425:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusMinusRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusMinus.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusMinus"


    // $ANTLR start "rulePlusMinus"
    // InternalExprParser.g:5431:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:5437:2: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalExprParser.g:5438:2: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalExprParser.g:5438:2: (kw= PlusSign | kw= HyphenMinus )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==PlusSign) ) {
                alt82=1;
            }
            else if ( (LA82_0==HyphenMinus) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // InternalExprParser.g:5439:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:5445:3: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusMinus"


    // $ANTLR start "entryRuleNoQuoteString"
    // InternalExprParser.g:5454:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalExprParser.g:5454:53: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalExprParser.g:5455:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNoQuoteString"


    // $ANTLR start "ruleNoQuoteString"
    // InternalExprParser.g:5461:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalExprParser.g:5467:2: (this_STRING_0= RULE_STRING )
            // InternalExprParser.g:5468:2: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNoQuoteString"


    // $ANTLR start "entryRuleArrayRange"
    // InternalExprParser.g:5478:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalExprParser.g:5478:51: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalExprParser.g:5479:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayRangeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayRange; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayRange"


    // $ANTLR start "ruleArrayRange"
    // InternalExprParser.g:5485:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:5491:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) )
            // InternalExprParser.g:5492:2: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            {
            // InternalExprParser.g:5492:2: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            // InternalExprParser.g:5493:3: () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket
            {
            // InternalExprParser.g:5493:3: ()
            // InternalExprParser.g:5494:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalExprParser.g:5504:3: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalExprParser.g:5505:4: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalExprParser.g:5505:4: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalExprParser.g:5506:5: lv_lowerBound_2_0= ruleINTVALUE
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_60);
            lv_lowerBound_2_0=ruleINTVALUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArrayRangeRule());
              					}
              					set(
              						current,
              						"lowerBound",
              						lv_lowerBound_2_0,
              						"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:5523:3: (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==FullStopFullStop) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalExprParser.g:5524:4: otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                      			
                    }
                    // InternalExprParser.g:5528:4: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalExprParser.g:5529:5: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalExprParser.g:5529:5: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalExprParser.g:5530:6: lv_upperBound_4_0= ruleINTVALUE
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_46);
                    lv_upperBound_4_0=ruleINTVALUE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getArrayRangeRule());
                      						}
                      						set(
                      							current,
                      							"upperBound",
                      							lv_upperBound_4_0,
                      							"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayRange"


    // $ANTLR start "entryRuleSignedConstant"
    // InternalExprParser.g:5556:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalExprParser.g:5556:55: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalExprParser.g:5557:2: iv_ruleSignedConstant= ruleSignedConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedConstantRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSignedConstant=ruleSignedConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedConstant; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedConstant"


    // $ANTLR start "ruleSignedConstant"
    // InternalExprParser.g:5563:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:5569:2: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalExprParser.g:5570:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalExprParser.g:5570:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalExprParser.g:5571:3: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalExprParser.g:5571:3: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalExprParser.g:5572:4: (lv_op_0_0= rulePlusMinus )
            {
            // InternalExprParser.g:5572:4: (lv_op_0_0= rulePlusMinus )
            // InternalExprParser.g:5573:5: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_5);
            lv_op_0_0=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSignedConstantRule());
              					}
              					set(
              						current,
              						"op",
              						lv_op_0_0,
              						"org.osate.xtext.aadl2.properties.Properties.PlusMinus");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:5590:3: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalExprParser.g:5591:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalExprParser.g:5591:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalExprParser.g:5592:5: lv_ownedPropertyExpression_1_0= ruleConstantValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedPropertyExpression_1_0=ruleConstantValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSignedConstantRule());
              					}
              					add(
              						current,
              						"ownedPropertyExpression",
              						lv_ownedPropertyExpression_1_0,
              						"org.osate.xtext.aadl2.properties.Properties.ConstantValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedConstant"


    // $ANTLR start "entryRuleIntegerTerm"
    // InternalExprParser.g:5613:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalExprParser.g:5613:52: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalExprParser.g:5614:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerTerm"


    // $ANTLR start "ruleIntegerTerm"
    // InternalExprParser.g:5620:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:5626:2: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalExprParser.g:5627:2: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalExprParser.g:5627:2: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalExprParser.g:5628:3: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalExprParser.g:5628:3: ( (lv_value_0_0= ruleSignedInt ) )
            // InternalExprParser.g:5629:4: (lv_value_0_0= ruleSignedInt )
            {
            // InternalExprParser.g:5629:4: (lv_value_0_0= ruleSignedInt )
            // InternalExprParser.g:5630:5: lv_value_0_0= ruleSignedInt
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_61);
            lv_value_0_0=ruleSignedInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIntegerTermRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_0_0,
              						"org.osate.xtext.aadl2.properties.Properties.SignedInt");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:5647:3: ( (otherlv_1= RULE_ID ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==RULE_ID) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalExprParser.g:5648:4: (otherlv_1= RULE_ID )
                    {
                    // InternalExprParser.g:5648:4: (otherlv_1= RULE_ID )
                    // InternalExprParser.g:5649:5: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getIntegerTermRule());
                      					}
                      				
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerTerm"


    // $ANTLR start "entryRuleSignedInt"
    // InternalExprParser.g:5664:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // InternalExprParser.g:5664:49: (iv_ruleSignedInt= ruleSignedInt EOF )
            // InternalExprParser.g:5665:2: iv_ruleSignedInt= ruleSignedInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedIntRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSignedInt=ruleSignedInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedInt.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedInt"


    // $ANTLR start "ruleSignedInt"
    // InternalExprParser.g:5671:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;


        	enterRule();

        try {
            // InternalExprParser.g:5677:2: ( ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalExprParser.g:5678:2: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalExprParser.g:5678:2: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalExprParser.g:5679:3: (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // InternalExprParser.g:5679:3: (kw= PlusSign | kw= HyphenMinus )?
            int alt85=3;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==PlusSign) ) {
                alt85=1;
            }
            else if ( (LA85_0==HyphenMinus) ) {
                alt85=2;
            }
            switch (alt85) {
                case 1 :
                    // InternalExprParser.g:5680:4: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:5686:4: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_INTEGER_LIT_2);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedInt"


    // $ANTLR start "entryRuleRealTerm"
    // InternalExprParser.g:5703:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalExprParser.g:5703:49: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalExprParser.g:5704:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealTerm"


    // $ANTLR start "ruleRealTerm"
    // InternalExprParser.g:5710:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalExprParser.g:5716:2: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalExprParser.g:5717:2: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalExprParser.g:5717:2: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalExprParser.g:5718:3: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalExprParser.g:5718:3: ( (lv_value_0_0= ruleSignedReal ) )
            // InternalExprParser.g:5719:4: (lv_value_0_0= ruleSignedReal )
            {
            // InternalExprParser.g:5719:4: (lv_value_0_0= ruleSignedReal )
            // InternalExprParser.g:5720:5: lv_value_0_0= ruleSignedReal
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_61);
            lv_value_0_0=ruleSignedReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRealTermRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_0_0,
              						"org.osate.expr.Expr.SignedReal");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExprParser.g:5737:3: ( (otherlv_1= RULE_ID ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_ID) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalExprParser.g:5738:4: (otherlv_1= RULE_ID )
                    {
                    // InternalExprParser.g:5738:4: (otherlv_1= RULE_ID )
                    // InternalExprParser.g:5739:5: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getRealTermRule());
                      					}
                      				
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealTerm"


    // $ANTLR start "entryRuleNumAlt"
    // InternalExprParser.g:5754:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalExprParser.g:5754:47: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalExprParser.g:5755:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumAltRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumAlt; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumAlt"


    // $ANTLR start "ruleNumAlt"
    // InternalExprParser.g:5761:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;



        	enterRule();

        try {
            // InternalExprParser.g:5767:2: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalExprParser.g:5768:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalExprParser.g:5768:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt87=4;
            switch ( input.LA(1) ) {
            case RULE_REAL_LIT:
                {
                alt87=1;
                }
                break;
            case PlusSign:
                {
                int LA87_2 = input.LA(2);

                if ( (LA87_2==RULE_INTEGER_LIT) ) {
                    alt87=2;
                }
                else if ( (LA87_2==RULE_ID) ) {
                    alt87=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 2, input);

                    throw nvae;
                }
                }
                break;
            case HyphenMinus:
                {
                int LA87_3 = input.LA(2);

                if ( (LA87_3==RULE_INTEGER_LIT) ) {
                    alt87=2;
                }
                else if ( (LA87_3==RULE_ID) ) {
                    alt87=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt87=2;
                }
                break;
            case RULE_ID:
                {
                alt87=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // InternalExprParser.g:5769:3: this_RealTerm_0= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RealTerm_0=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RealTerm_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExprParser.g:5778:3: this_IntegerTerm_1= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_IntegerTerm_1=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntegerTerm_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExprParser.g:5787:3: this_SignedConstant_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SignedConstant_2=ruleSignedConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SignedConstant_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExprParser.g:5796:3: this_ConstantValue_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ConstantValue_3=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConstantValue_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumAlt"


    // $ANTLR start "entryRuleAppliesToKeywords"
    // InternalExprParser.g:5808:1: entryRuleAppliesToKeywords returns [String current=null] : iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF ;
    public final String entryRuleAppliesToKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAppliesToKeywords = null;


        try {
            // InternalExprParser.g:5808:57: (iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF )
            // InternalExprParser.g:5809:2: iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAppliesToKeywordsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAppliesToKeywords=ruleAppliesToKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAppliesToKeywords.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAppliesToKeywords"


    // $ANTLR start "ruleAppliesToKeywords"
    // InternalExprParser.g:5815:1: ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Applies kw= To ) ;
    public final AntlrDatatypeRuleToken ruleAppliesToKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:5821:2: ( (kw= Applies kw= To ) )
            // InternalExprParser.g:5822:2: (kw= Applies kw= To )
            {
            // InternalExprParser.g:5822:2: (kw= Applies kw= To )
            // InternalExprParser.g:5823:3: kw= Applies kw= To
            {
            kw=(Token)match(input,Applies,FollowSets000.FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0());
              		
            }
            kw=(Token)match(input,To,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAppliesToKeywords"


    // $ANTLR start "entryRuleInBindingKeywords"
    // InternalExprParser.g:5837:1: entryRuleInBindingKeywords returns [String current=null] : iv_ruleInBindingKeywords= ruleInBindingKeywords EOF ;
    public final String entryRuleInBindingKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInBindingKeywords = null;


        try {
            // InternalExprParser.g:5837:57: (iv_ruleInBindingKeywords= ruleInBindingKeywords EOF )
            // InternalExprParser.g:5838:2: iv_ruleInBindingKeywords= ruleInBindingKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInBindingKeywordsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInBindingKeywords=ruleInBindingKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInBindingKeywords.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInBindingKeywords"


    // $ANTLR start "ruleInBindingKeywords"
    // InternalExprParser.g:5844:1: ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Binding ) ;
    public final AntlrDatatypeRuleToken ruleInBindingKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:5850:2: ( (kw= In kw= Binding ) )
            // InternalExprParser.g:5851:2: (kw= In kw= Binding )
            {
            // InternalExprParser.g:5851:2: (kw= In kw= Binding )
            // InternalExprParser.g:5852:3: kw= In kw= Binding
            {
            kw=(Token)match(input,In,FollowSets000.FOLLOW_63); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getInKeyword_0());
              		
            }
            kw=(Token)match(input,Binding,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInBindingKeywords"


    // $ANTLR start "entryRuleInModesKeywords"
    // InternalExprParser.g:5866:1: entryRuleInModesKeywords returns [String current=null] : iv_ruleInModesKeywords= ruleInModesKeywords EOF ;
    public final String entryRuleInModesKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInModesKeywords = null;


        try {
            // InternalExprParser.g:5866:55: (iv_ruleInModesKeywords= ruleInModesKeywords EOF )
            // InternalExprParser.g:5867:2: iv_ruleInModesKeywords= ruleInModesKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInModesKeywordsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInModesKeywords=ruleInModesKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInModesKeywords.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInModesKeywords"


    // $ANTLR start "ruleInModesKeywords"
    // InternalExprParser.g:5873:1: ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Modes ) ;
    public final AntlrDatatypeRuleToken ruleInModesKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:5879:2: ( (kw= In kw= Modes ) )
            // InternalExprParser.g:5880:2: (kw= In kw= Modes )
            {
            // InternalExprParser.g:5880:2: (kw= In kw= Modes )
            // InternalExprParser.g:5881:3: kw= In kw= Modes
            {
            kw=(Token)match(input,In,FollowSets000.FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getInKeyword_0());
              		
            }
            kw=(Token)match(input,Modes,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getModesKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInModesKeywords"


    // $ANTLR start "entryRuleINTVALUE"
    // InternalExprParser.g:5895:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalExprParser.g:5895:48: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalExprParser.g:5896:2: iv_ruleINTVALUE= ruleINTVALUE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTVALUERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleINTVALUE=ruleINTVALUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINTVALUE.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINTVALUE"


    // $ANTLR start "ruleINTVALUE"
    // InternalExprParser.g:5902:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;


        	enterRule();

        try {
            // InternalExprParser.g:5908:2: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalExprParser.g:5909:2: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INTEGER_LIT_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleINTVALUE"


    // $ANTLR start "entryRuleQPREF"
    // InternalExprParser.g:5919:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalExprParser.g:5919:45: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalExprParser.g:5920:2: iv_ruleQPREF= ruleQPREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQPREFRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQPREF=ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQPREF.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQPREF"


    // $ANTLR start "ruleQPREF"
    // InternalExprParser.g:5926:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalExprParser.g:5932:2: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) )
            // InternalExprParser.g:5933:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            {
            // InternalExprParser.g:5933:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            // InternalExprParser.g:5934:3: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalExprParser.g:5941:3: (kw= ColonColon this_ID_2= RULE_ID )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==ColonColon) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalExprParser.g:5942:4: kw= ColonColon this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0());
                      			
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQPREF"


    // $ANTLR start "entryRuleSTAR"
    // InternalExprParser.g:5959:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalExprParser.g:5959:44: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalExprParser.g:5960:2: iv_ruleSTAR= ruleSTAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTARRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSTAR=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTAR.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTAR"


    // $ANTLR start "ruleSTAR"
    // InternalExprParser.g:5966:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Asterisk ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExprParser.g:5972:2: (kw= Asterisk )
            // InternalExprParser.g:5973:2: kw= Asterisk
            {
            kw=(Token)match(input,Asterisk,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTAR"


    // $ANTLR start "ruleMetaClassEnum"
    // InternalExprParser.g:5981:1: ruleMetaClassEnum returns [Enumerator current=null] : ( (enumLiteral_0= Component ) | (enumLiteral_1= Feature ) | (enumLiteral_2= Connection ) | (enumLiteral_3= Flow ) | (enumLiteral_4= Mode ) | (enumLiteral_5= Property ) ) ;
    public final Enumerator ruleMetaClassEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalExprParser.g:5987:2: ( ( (enumLiteral_0= Component ) | (enumLiteral_1= Feature ) | (enumLiteral_2= Connection ) | (enumLiteral_3= Flow ) | (enumLiteral_4= Mode ) | (enumLiteral_5= Property ) ) )
            // InternalExprParser.g:5988:2: ( (enumLiteral_0= Component ) | (enumLiteral_1= Feature ) | (enumLiteral_2= Connection ) | (enumLiteral_3= Flow ) | (enumLiteral_4= Mode ) | (enumLiteral_5= Property ) )
            {
            // InternalExprParser.g:5988:2: ( (enumLiteral_0= Component ) | (enumLiteral_1= Feature ) | (enumLiteral_2= Connection ) | (enumLiteral_3= Flow ) | (enumLiteral_4= Mode ) | (enumLiteral_5= Property ) )
            int alt89=6;
            switch ( input.LA(1) ) {
            case Component:
                {
                alt89=1;
                }
                break;
            case Feature:
                {
                alt89=2;
                }
                break;
            case Connection:
                {
                alt89=3;
                }
                break;
            case Flow:
                {
                alt89=4;
                }
                break;
            case Mode:
                {
                alt89=5;
                }
                break;
            case Property:
                {
                alt89=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalExprParser.g:5989:3: (enumLiteral_0= Component )
                    {
                    // InternalExprParser.g:5989:3: (enumLiteral_0= Component )
                    // InternalExprParser.g:5990:4: enumLiteral_0= Component
                    {
                    enumLiteral_0=(Token)match(input,Component,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMetaClassEnumAccess().getCOMPONENTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMetaClassEnumAccess().getCOMPONENTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExprParser.g:5997:3: (enumLiteral_1= Feature )
                    {
                    // InternalExprParser.g:5997:3: (enumLiteral_1= Feature )
                    // InternalExprParser.g:5998:4: enumLiteral_1= Feature
                    {
                    enumLiteral_1=(Token)match(input,Feature,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExprParser.g:6005:3: (enumLiteral_2= Connection )
                    {
                    // InternalExprParser.g:6005:3: (enumLiteral_2= Connection )
                    // InternalExprParser.g:6006:4: enumLiteral_2= Connection
                    {
                    enumLiteral_2=(Token)match(input,Connection,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExprParser.g:6013:3: (enumLiteral_3= Flow )
                    {
                    // InternalExprParser.g:6013:3: (enumLiteral_3= Flow )
                    // InternalExprParser.g:6014:4: enumLiteral_3= Flow
                    {
                    enumLiteral_3=(Token)match(input,Flow,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExprParser.g:6021:3: (enumLiteral_4= Mode )
                    {
                    // InternalExprParser.g:6021:3: (enumLiteral_4= Mode )
                    // InternalExprParser.g:6022:4: enumLiteral_4= Mode
                    {
                    enumLiteral_4=(Token)match(input,Mode,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalExprParser.g:6029:3: (enumLiteral_5= Property )
                    {
                    // InternalExprParser.g:6029:3: (enumLiteral_5= Property )
                    // InternalExprParser.g:6030:4: enumLiteral_5= Property
                    {
                    enumLiteral_5=(Token)match(input,Property,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMetaClassEnumAccess().getPROPERTYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getMetaClassEnumAccess().getPROPERTYEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetaClassEnum"

    // $ANTLR start synpred1_InternalExprParser
    public final void synpred1_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:2330:5: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalExprParser.g:2330:6: ( () ( ( ruleOpOr ) ) )
        {
        // InternalExprParser.g:2330:6: ( () ( ( ruleOpOr ) ) )
        // InternalExprParser.g:2331:6: () ( ( ruleOpOr ) )
        {
        // InternalExprParser.g:2331:6: ()
        // InternalExprParser.g:2332:6: 
        {
        }

        // InternalExprParser.g:2333:6: ( ( ruleOpOr ) )
        // InternalExprParser.g:2334:7: ( ruleOpOr )
        {
        // InternalExprParser.g:2334:7: ( ruleOpOr )
        // InternalExprParser.g:2335:8: ruleOpOr
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalExprParser

    // $ANTLR start synpred2_InternalExprParser
    public final void synpred2_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:2448:5: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalExprParser.g:2448:6: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalExprParser.g:2448:6: ( () ( ( ruleOpAnd ) ) )
        // InternalExprParser.g:2449:6: () ( ( ruleOpAnd ) )
        {
        // InternalExprParser.g:2449:6: ()
        // InternalExprParser.g:2450:6: 
        {
        }

        // InternalExprParser.g:2451:6: ( ( ruleOpAnd ) )
        // InternalExprParser.g:2452:7: ( ruleOpAnd )
        {
        // InternalExprParser.g:2452:7: ( ruleOpAnd )
        // InternalExprParser.g:2453:8: ruleOpAnd
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalExprParser

    // $ANTLR start synpred3_InternalExprParser
    public final void synpred3_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:2566:5: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalExprParser.g:2566:6: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalExprParser.g:2566:6: ( () ( ( ruleOpEquality ) ) )
        // InternalExprParser.g:2567:6: () ( ( ruleOpEquality ) )
        {
        // InternalExprParser.g:2567:6: ()
        // InternalExprParser.g:2568:6: 
        {
        }

        // InternalExprParser.g:2569:6: ( ( ruleOpEquality ) )
        // InternalExprParser.g:2570:7: ( ruleOpEquality )
        {
        // InternalExprParser.g:2570:7: ( ruleOpEquality )
        // InternalExprParser.g:2571:8: ruleOpEquality
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalExprParser

    // $ANTLR start synpred4_InternalExprParser
    public final void synpred4_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:2684:5: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalExprParser.g:2684:6: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalExprParser.g:2684:6: ( () ( ( ruleOpCompare ) ) )
        // InternalExprParser.g:2685:6: () ( ( ruleOpCompare ) )
        {
        // InternalExprParser.g:2685:6: ()
        // InternalExprParser.g:2686:6: 
        {
        }

        // InternalExprParser.g:2687:6: ( ( ruleOpCompare ) )
        // InternalExprParser.g:2688:7: ( ruleOpCompare )
        {
        // InternalExprParser.g:2688:7: ( ruleOpCompare )
        // InternalExprParser.g:2689:8: ruleOpCompare
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalExprParser

    // $ANTLR start synpred5_InternalExprParser
    public final void synpred5_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:2820:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalExprParser.g:2820:6: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalExprParser.g:2820:6: ( () ( ( ruleOpAdd ) ) )
        // InternalExprParser.g:2821:6: () ( ( ruleOpAdd ) )
        {
        // InternalExprParser.g:2821:6: ()
        // InternalExprParser.g:2822:6: 
        {
        }

        // InternalExprParser.g:2823:6: ( ( ruleOpAdd ) )
        // InternalExprParser.g:2824:7: ( ruleOpAdd )
        {
        // InternalExprParser.g:2824:7: ( ruleOpAdd )
        // InternalExprParser.g:2825:8: ruleOpAdd
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalExprParser

    // $ANTLR start synpred6_InternalExprParser
    public final void synpred6_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:2938:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalExprParser.g:2938:6: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalExprParser.g:2938:6: ( () ( ( ruleOpMulti ) ) )
        // InternalExprParser.g:2939:6: () ( ( ruleOpMulti ) )
        {
        // InternalExprParser.g:2939:6: ()
        // InternalExprParser.g:2940:6: 
        {
        }

        // InternalExprParser.g:2941:6: ( ( ruleOpMulti ) )
        // InternalExprParser.g:2942:7: ( ruleOpMulti )
        {
        // InternalExprParser.g:2942:7: ( ruleOpMulti )
        // InternalExprParser.g:2943:8: ruleOpMulti
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalExprParser

    // $ANTLR start synpred8_InternalExprParser
    public final void synpred8_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:3263:5: ( ( () NumberSign ) )
        // InternalExprParser.g:3263:6: ( () NumberSign )
        {
        // InternalExprParser.g:3263:6: ( () NumberSign )
        // InternalExprParser.g:3264:6: () NumberSign
        {
        // InternalExprParser.g:3264:6: ()
        // InternalExprParser.g:3265:6: 
        {
        }

        match(input,NumberSign,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalExprParser

    // $ANTLR start synpred9_InternalExprParser
    public final void synpred9_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:3328:4: ( ( () FullStop ( ( ruleQCREF ) ) ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )? ) )
        // InternalExprParser.g:3328:5: ( () FullStop ( ( ruleQCREF ) ) ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )? )
        {
        // InternalExprParser.g:3328:5: ( () FullStop ( ( ruleQCREF ) ) ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )? )
        // InternalExprParser.g:3329:5: () FullStop ( ( ruleQCREF ) ) ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )?
        {
        // InternalExprParser.g:3329:5: ()
        // InternalExprParser.g:3330:5: 
        {
        }

        match(input,FullStop,FollowSets000.FOLLOW_7); if (state.failed) return ;
        // InternalExprParser.g:3332:5: ( ( ruleQCREF ) )
        // InternalExprParser.g:3333:6: ( ruleQCREF )
        {
        // InternalExprParser.g:3333:6: ( ruleQCREF )
        // InternalExprParser.g:3334:7: ruleQCREF
        {
        pushFollow(FollowSets000.FOLLOW_43);
        ruleQCREF();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalExprParser.g:3337:5: ( LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis )?
        int alt92=2;
        int LA92_0 = input.LA(1);

        if ( (LA92_0==LeftParenthesis) ) {
            alt92=1;
        }
        switch (alt92) {
            case 1 :
                // InternalExprParser.g:3338:6: LeftParenthesis ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )? RightParenthesis
                {
                match(input,LeftParenthesis,FollowSets000.FOLLOW_41); if (state.failed) return ;
                // InternalExprParser.g:3339:6: ( ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )* )?
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==Record||LA91_0==False||(LA91_0>=Tuple && LA91_0<=Union)||LA91_0==List||LA91_0==True||LA91_0==Bag||LA91_0==Map||(LA91_0>=Not && LA91_0<=Set)||LA91_0==If||LA91_0==LeftParenthesis||LA91_0==PlusSign||LA91_0==HyphenMinus||LA91_0==LeftSquareBracket||(LA91_0>=CircumflexAccent && LA91_0<=LeftCurlyBracket)||LA91_0==RULE_REAL_LIT||LA91_0==RULE_INTEGER_LIT||(LA91_0>=RULE_STRING && LA91_0<=RULE_ID)) ) {
                    alt91=1;
                }
                switch (alt91) {
                    case 1 :
                        // InternalExprParser.g:3340:7: ( ( ruleExpression ) ) ( Comma ( ( ruleExpression ) ) )*
                        {
                        // InternalExprParser.g:3340:7: ( ( ruleExpression ) )
                        // InternalExprParser.g:3341:8: ( ruleExpression )
                        {
                        // InternalExprParser.g:3341:8: ( ruleExpression )
                        // InternalExprParser.g:3342:9: ruleExpression
                        {
                        pushFollow(FollowSets000.FOLLOW_42);
                        ruleExpression();

                        state._fsp--;
                        if (state.failed) return ;

                        }


                        }

                        // InternalExprParser.g:3345:7: ( Comma ( ( ruleExpression ) ) )*
                        loop90:
                        do {
                            int alt90=2;
                            int LA90_0 = input.LA(1);

                            if ( (LA90_0==Comma) ) {
                                alt90=1;
                            }


                            switch (alt90) {
                        	case 1 :
                        	    // InternalExprParser.g:3346:8: Comma ( ( ruleExpression ) )
                        	    {
                        	    match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return ;
                        	    // InternalExprParser.g:3347:8: ( ( ruleExpression ) )
                        	    // InternalExprParser.g:3348:9: ( ruleExpression )
                        	    {
                        	    // InternalExprParser.g:3348:9: ( ruleExpression )
                        	    // InternalExprParser.g:3349:10: ruleExpression
                        	    {
                        	    pushFollow(FollowSets000.FOLLOW_42);
                        	    ruleExpression();

                        	    state._fsp--;
                        	    if (state.failed) return ;

                        	    }


                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop90;
                            }
                        } while (true);


                        }
                        break;

                }

                match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred9_InternalExprParser

    // $ANTLR start synpred10_InternalExprParser
    public final void synpred10_InternalExprParser_fragment() throws RecognitionException {   
        // InternalExprParser.g:3696:5: ( Delta )
        // InternalExprParser.g:3696:6: Delta
        {
        match(input,Delta,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalExprParser

    // Delegated rules

    public final boolean synpred2_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalExprParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalExprParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA20 dfa20 = new DFA20(this);
    static final String dfa_1s = "\22\uffff";
    static final String dfa_2s = "\10\uffff\1\14\1\uffff\1\16\7\uffff";
    static final String dfa_3s = "\1\6\7\uffff\1\40\1\uffff\1\40\1\10\6\uffff";
    static final String dfa_4s = "\1\65\7\uffff\1\142\1\uffff\1\142\1\65\6\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\14\1\13\1\16\1\15";
    static final String dfa_6s = "\22\uffff}>";
    static final String[] dfa_7s = {
            "\1\10\1\uffff\1\7\2\uffff\1\1\10\uffff\1\6\1\13\1\uffff\1\4\1\5\2\uffff\1\11\1\12\11\uffff\1\3\16\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15\40\uffff\1\14\20\uffff\1\14\2\uffff\1\14\4\uffff\1\14\1\uffff\1\14\4\uffff\2\14",
            "",
            "\1\17\40\uffff\1\16\20\uffff\1\16\2\uffff\1\16\4\uffff\1\16\1\uffff\1\16\4\uffff\2\16",
            "\1\20\54\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1329:2: (kw= Abstract | kw= Bus | kw= Data | kw= Device | kw= Memory | kw= Process | kw= Processor | kw= Subprogram | (kw= Subprogram kw= Group ) | kw= KW_System | (kw= Thread kw= Group ) | kw= Thread | (kw= Virtual kw= Bus ) | (kw= Virtual kw= Processor ) )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x6042000000400000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x13303B7C1FB429E0L,0x0000100000000000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000404000000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000002L,0x0000000012000000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x1B313B7C9FB429E0L,0x00001A8340520200L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000100000040000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x1B313F7C9FB429E0L,0x00001A8340520200L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000100400000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000400200000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x13303B7C1FB429E0L,0x0000100400000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x7B313B7C9FB429E0L,0x00001A8340520200L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000000005000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x1B313B7C9FB429E0L,0x00001A8140520200L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000020L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0000000028000190L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000000000500000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0480000000000002L,0x0000000001080000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000100000010400L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000002L,0x0000000000820000L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x1B313B7C9FB429E0L,0x00001A8340560200L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000240000L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000020000000L,0x0000000080000000L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000008040000000L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x1B313B7C9FB439E0L,0x00001A8140520200L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000004000L,0x0000000004200400L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000004200400L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000002L,0x0000000040800000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000004L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    }


}
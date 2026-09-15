package org.osate.xtext.aadl2.ba.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.xtext.aadl2.ba.services.BehaviorAnnexGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
public class InternalBehaviorAnnexParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Computation", "Transitions", "Classifier", "Otherwise", "Reference", "Variables", "Complete", "Constant", "Dispatch", "Internal", "Applies", "Binding", "Compute", "Initial", "Timeout", "Updated", "Forall", "Frozen", "States", "Count", "Delta", "Elsif", "False", "Final", "Fresh", "Modes", "State", "Until", "While", "Else", "Stop", "Then", "True", "PlusSignEqualsSignGreaterThanSign", "RightSquareBracketHyphenMinusGreaterThanSign", "Abs", "And", "Any", "End", "For", "Mod", "Not", "Rem", "Xor", "ExclamationMarkLessThanSign", "ExclamationMarkEqualsSign", "ExclamationMarkGreaterThanSign", "AsteriskAsterisk", "HyphenMinusLeftSquareBracket", "FullStopFullStop", "ColonColon", "ColonEqualsSign", "LessThanSignEqualsSign", "EqualsSignGreaterThanSign", "GreaterThanSignEqualsSign", "GreaterThanSignGreaterThanSign", "Do", "If", "In", "On", "Or", "To", "ExclamationMark", "NumberSign", "Ampersand", "Apostrophe", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "QuestionMark", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int Fresh=28;
    public static final int Or=64;
    public static final int Transitions=5;
    public static final int Stop=34;
    public static final int EqualsSignGreaterThanSign=57;
    public static final int Internal=13;
    public static final int ExclamationMarkLessThanSign=48;
    public static final int Count=23;
    public static final int False=26;
    public static final int LessThanSign=80;
    public static final int States=22;
    public static final int Otherwise=7;
    public static final int PlusSignEqualsSignGreaterThanSign=37;
    public static final int LeftParenthesis=70;
    public static final int Then=35;
    public static final int ExclamationMark=66;
    public static final int GreaterThanSign=82;
    public static final int RULE_ID=97;
    public static final int RULE_DIGIT=89;
    public static final int Frozen=21;
    public static final int GreaterThanSignEqualsSign=58;
    public static final int ColonColon=54;
    public static final int PlusSign=73;
    public static final int Xor=47;
    public static final int LeftSquareBracket=84;
    public static final int If=61;
    public static final int In=62;
    public static final int Complete=10;
    public static final int RULE_REAL_LIT=92;
    public static final int Dispatch=12;
    public static final int Classifier=6;
    public static final int ExclamationMarkGreaterThanSign=50;
    public static final int Comma=74;
    public static final int HyphenMinus=75;
    public static final int Abs=39;
    public static final int Elsif=25;
    public static final int LessThanSignEqualsSign=56;
    public static final int Solidus=77;
    public static final int RightCurlyBracket=87;
    public static final int Final=27;
    public static final int Apostrophe=69;
    public static final int Modes=29;
    public static final int FullStop=76;
    public static final int Reference=8;
    public static final int Semicolon=79;
    public static final int RULE_EXPONENT=90;
    public static final int Delta=24;
    public static final int QuestionMark=83;
    public static final int Else=33;
    public static final int RULE_EXTENDED_DIGIT=95;
    public static final int Rem=46;
    public static final int ExclamationMarkEqualsSign=49;
    public static final int Initial=17;
    public static final int True=36;
    public static final int RULE_INT_EXPONENT=91;
    public static final int FullStopFullStop=53;
    public static final int Ampersand=68;
    public static final int To=65;
    public static final int Applies=14;
    public static final int Forall=20;
    public static final int RULE_BASED_INTEGER=93;
    public static final int RightSquareBracket=85;
    public static final int Binding=15;
    public static final int Updated=19;
    public static final int Timeout=18;
    public static final int For=43;
    public static final int RightParenthesis=71;
    public static final int Do=60;
    public static final int ColonEqualsSign=55;
    public static final int Not=45;
    public static final int Computation=4;
    public static final int State=30;
    public static final int And=40;
    public static final int NumberSign=67;
    public static final int AsteriskAsterisk=51;
    public static final int End=42;
    public static final int RULE_INTEGER_LIT=94;
    public static final int Constant=11;
    public static final int RULE_STRING=96;
    public static final int Any=41;
    public static final int RULE_SL_COMMENT=88;
    public static final int Variables=9;
    public static final int EqualsSign=81;
    public static final int Colon=78;
    public static final int EOF=-1;
    public static final int Asterisk=72;
    public static final int Until=31;
    public static final int Mod=44;
    public static final int RULE_WS=98;
    public static final int HyphenMinusLeftSquareBracket=52;
    public static final int LeftCurlyBracket=86;
    public static final int While=32;
    public static final int GreaterThanSignGreaterThanSign=59;
    public static final int RightSquareBracketHyphenMinusGreaterThanSign=38;
    public static final int Compute=16;
    public static final int On=63;

    // delegates
    // delegators


        public InternalBehaviorAnnexParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBehaviorAnnexParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBehaviorAnnexParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBehaviorAnnexParser.g"; }



     	private BehaviorAnnexGrammarAccess grammarAccess;

        public InternalBehaviorAnnexParser(TokenStream input, BehaviorAnnexGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "AnnexSubclause";
       	}

       	@Override
       	protected BehaviorAnnexGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleAnnexSubclause"
    // InternalBehaviorAnnexParser.g:77:1: entryRuleAnnexSubclause returns [EObject current=null] : iv_ruleAnnexSubclause= ruleAnnexSubclause EOF ;
    public final EObject entryRuleAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnexSubclause = null;


        try {
            // InternalBehaviorAnnexParser.g:77:55: (iv_ruleAnnexSubclause= ruleAnnexSubclause EOF )
            // InternalBehaviorAnnexParser.g:78:2: iv_ruleAnnexSubclause= ruleAnnexSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnexSubclauseRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAnnexSubclause=ruleAnnexSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnexSubclause; 
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
    // $ANTLR end "entryRuleAnnexSubclause"


    // $ANTLR start "ruleAnnexSubclause"
    // InternalBehaviorAnnexParser.g:84:1: ruleAnnexSubclause returns [EObject current=null] : this_BehaviorAnnex_0= ruleBehaviorAnnex ;
    public final EObject ruleAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject this_BehaviorAnnex_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:90:2: (this_BehaviorAnnex_0= ruleBehaviorAnnex )
            // InternalBehaviorAnnexParser.g:91:2: this_BehaviorAnnex_0= ruleBehaviorAnnex
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getAnnexSubclauseAccess().getBehaviorAnnexParserRuleCall());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_BehaviorAnnex_0=ruleBehaviorAnnex();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_BehaviorAnnex_0;
              		afterParserOrEnumRuleCall();
              	
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
    // $ANTLR end "ruleAnnexSubclause"


    // $ANTLR start "entryRuleBehaviorAnnex"
    // InternalBehaviorAnnexParser.g:102:1: entryRuleBehaviorAnnex returns [EObject current=null] : iv_ruleBehaviorAnnex= ruleBehaviorAnnex EOF ;
    public final EObject entryRuleBehaviorAnnex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorAnnex = null;


        try {
            // InternalBehaviorAnnexParser.g:102:54: (iv_ruleBehaviorAnnex= ruleBehaviorAnnex EOF )
            // InternalBehaviorAnnexParser.g:103:2: iv_ruleBehaviorAnnex= ruleBehaviorAnnex EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorAnnexRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorAnnex=ruleBehaviorAnnex();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorAnnex; 
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
    // $ANTLR end "entryRuleBehaviorAnnex"


    // $ANTLR start "ruleBehaviorAnnex"
    // InternalBehaviorAnnexParser.g:109:1: ruleBehaviorAnnex returns [EObject current=null] : ( () (otherlv_1= Variables ( (lv_variableGroups_2_0= ruleBehaviorVariableGroup ) )+ )? (otherlv_3= States ( (lv_stateGroups_4_0= ruleBehaviorStateGroup ) )+ )? (otherlv_5= Transitions ( (lv_transitions_6_0= ruleBehaviorTransition ) )+ )? ) ;
    public final EObject ruleBehaviorAnnex() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_variableGroups_2_0 = null;

        EObject lv_stateGroups_4_0 = null;

        EObject lv_transitions_6_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:115:2: ( ( () (otherlv_1= Variables ( (lv_variableGroups_2_0= ruleBehaviorVariableGroup ) )+ )? (otherlv_3= States ( (lv_stateGroups_4_0= ruleBehaviorStateGroup ) )+ )? (otherlv_5= Transitions ( (lv_transitions_6_0= ruleBehaviorTransition ) )+ )? ) )
            // InternalBehaviorAnnexParser.g:116:2: ( () (otherlv_1= Variables ( (lv_variableGroups_2_0= ruleBehaviorVariableGroup ) )+ )? (otherlv_3= States ( (lv_stateGroups_4_0= ruleBehaviorStateGroup ) )+ )? (otherlv_5= Transitions ( (lv_transitions_6_0= ruleBehaviorTransition ) )+ )? )
            {
            // InternalBehaviorAnnexParser.g:116:2: ( () (otherlv_1= Variables ( (lv_variableGroups_2_0= ruleBehaviorVariableGroup ) )+ )? (otherlv_3= States ( (lv_stateGroups_4_0= ruleBehaviorStateGroup ) )+ )? (otherlv_5= Transitions ( (lv_transitions_6_0= ruleBehaviorTransition ) )+ )? )
            // InternalBehaviorAnnexParser.g:117:3: () (otherlv_1= Variables ( (lv_variableGroups_2_0= ruleBehaviorVariableGroup ) )+ )? (otherlv_3= States ( (lv_stateGroups_4_0= ruleBehaviorStateGroup ) )+ )? (otherlv_5= Transitions ( (lv_transitions_6_0= ruleBehaviorTransition ) )+ )?
            {
            // InternalBehaviorAnnexParser.g:117:3: ()
            // InternalBehaviorAnnexParser.g:118:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBehaviorAnnexAccess().getBehaviorAnnexAction_0(),
              					current);
              			
            }

            }

            // InternalBehaviorAnnexParser.g:124:3: (otherlv_1= Variables ( (lv_variableGroups_2_0= ruleBehaviorVariableGroup ) )+ )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Variables) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:125:4: otherlv_1= Variables ( (lv_variableGroups_2_0= ruleBehaviorVariableGroup ) )+
                    {
                    otherlv_1=(Token)match(input,Variables,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getBehaviorAnnexAccess().getVariablesKeyword_1_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:129:4: ( (lv_variableGroups_2_0= ruleBehaviorVariableGroup ) )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_ID) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalBehaviorAnnexParser.g:130:5: (lv_variableGroups_2_0= ruleBehaviorVariableGroup )
                    	    {
                    	    // InternalBehaviorAnnexParser.g:130:5: (lv_variableGroups_2_0= ruleBehaviorVariableGroup )
                    	    // InternalBehaviorAnnexParser.g:131:6: lv_variableGroups_2_0= ruleBehaviorVariableGroup
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getBehaviorAnnexAccess().getVariableGroupsBehaviorVariableGroupParserRuleCall_1_1_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    lv_variableGroups_2_0=ruleBehaviorVariableGroup();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getBehaviorAnnexRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"variableGroups",
                    	      							lv_variableGroups_2_0,
                    	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorVariableGroup");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:149:3: (otherlv_3= States ( (lv_stateGroups_4_0= ruleBehaviorStateGroup ) )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==States) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:150:4: otherlv_3= States ( (lv_stateGroups_4_0= ruleBehaviorStateGroup ) )+
                    {
                    otherlv_3=(Token)match(input,States,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getBehaviorAnnexAccess().getStatesKeyword_2_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:154:4: ( (lv_stateGroups_4_0= ruleBehaviorStateGroup ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalBehaviorAnnexParser.g:155:5: (lv_stateGroups_4_0= ruleBehaviorStateGroup )
                    	    {
                    	    // InternalBehaviorAnnexParser.g:155:5: (lv_stateGroups_4_0= ruleBehaviorStateGroup )
                    	    // InternalBehaviorAnnexParser.g:156:6: lv_stateGroups_4_0= ruleBehaviorStateGroup
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getBehaviorAnnexAccess().getStateGroupsBehaviorStateGroupParserRuleCall_2_1_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    lv_stateGroups_4_0=ruleBehaviorStateGroup();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getBehaviorAnnexRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"stateGroups",
                    	      							lv_stateGroups_4_0,
                    	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorStateGroup");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:174:3: (otherlv_5= Transitions ( (lv_transitions_6_0= ruleBehaviorTransition ) )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Transitions) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:175:4: otherlv_5= Transitions ( (lv_transitions_6_0= ruleBehaviorTransition ) )+
                    {
                    otherlv_5=(Token)match(input,Transitions,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getBehaviorAnnexAccess().getTransitionsKeyword_3_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:179:4: ( (lv_transitions_6_0= ruleBehaviorTransition ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalBehaviorAnnexParser.g:180:5: (lv_transitions_6_0= ruleBehaviorTransition )
                    	    {
                    	    // InternalBehaviorAnnexParser.g:180:5: (lv_transitions_6_0= ruleBehaviorTransition )
                    	    // InternalBehaviorAnnexParser.g:181:6: lv_transitions_6_0= ruleBehaviorTransition
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getBehaviorAnnexAccess().getTransitionsBehaviorTransitionParserRuleCall_3_1_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_transitions_6_0=ruleBehaviorTransition();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getBehaviorAnnexRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"transitions",
                    	      							lv_transitions_6_0,
                    	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTransition");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


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
    // $ANTLR end "ruleBehaviorAnnex"


    // $ANTLR start "entryRuleBehaviorVariableGroup"
    // InternalBehaviorAnnexParser.g:203:1: entryRuleBehaviorVariableGroup returns [EObject current=null] : iv_ruleBehaviorVariableGroup= ruleBehaviorVariableGroup EOF ;
    public final EObject entryRuleBehaviorVariableGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorVariableGroup = null;


        try {
            // InternalBehaviorAnnexParser.g:203:62: (iv_ruleBehaviorVariableGroup= ruleBehaviorVariableGroup EOF )
            // InternalBehaviorAnnexParser.g:204:2: iv_ruleBehaviorVariableGroup= ruleBehaviorVariableGroup EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorVariableGroupRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorVariableGroup=ruleBehaviorVariableGroup();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorVariableGroup; 
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
    // $ANTLR end "entryRuleBehaviorVariableGroup"


    // $ANTLR start "ruleBehaviorVariableGroup"
    // InternalBehaviorAnnexParser.g:210:1: ruleBehaviorVariableGroup returns [EObject current=null] : ( ( (lv_variables_0_0= ruleBehaviorVariable ) ) (otherlv_1= Comma ( (lv_variables_2_0= ruleBehaviorVariable ) ) )* otherlv_3= Colon ( ( ruleQCREF ) ) (otherlv_5= ColonEqualsSign ( (lv_initialValue_6_0= ruleValueConstant ) ) )? (otherlv_7= LeftCurlyBracket ( (lv_propertyAssociations_8_0= ruleBehaviorPropertyAssociation ) )+ otherlv_9= RightCurlyBracket )? otherlv_10= Semicolon ) ;
    public final EObject ruleBehaviorVariableGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_variables_0_0 = null;

        EObject lv_variables_2_0 = null;

        EObject lv_initialValue_6_0 = null;

        EObject lv_propertyAssociations_8_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:216:2: ( ( ( (lv_variables_0_0= ruleBehaviorVariable ) ) (otherlv_1= Comma ( (lv_variables_2_0= ruleBehaviorVariable ) ) )* otherlv_3= Colon ( ( ruleQCREF ) ) (otherlv_5= ColonEqualsSign ( (lv_initialValue_6_0= ruleValueConstant ) ) )? (otherlv_7= LeftCurlyBracket ( (lv_propertyAssociations_8_0= ruleBehaviorPropertyAssociation ) )+ otherlv_9= RightCurlyBracket )? otherlv_10= Semicolon ) )
            // InternalBehaviorAnnexParser.g:217:2: ( ( (lv_variables_0_0= ruleBehaviorVariable ) ) (otherlv_1= Comma ( (lv_variables_2_0= ruleBehaviorVariable ) ) )* otherlv_3= Colon ( ( ruleQCREF ) ) (otherlv_5= ColonEqualsSign ( (lv_initialValue_6_0= ruleValueConstant ) ) )? (otherlv_7= LeftCurlyBracket ( (lv_propertyAssociations_8_0= ruleBehaviorPropertyAssociation ) )+ otherlv_9= RightCurlyBracket )? otherlv_10= Semicolon )
            {
            // InternalBehaviorAnnexParser.g:217:2: ( ( (lv_variables_0_0= ruleBehaviorVariable ) ) (otherlv_1= Comma ( (lv_variables_2_0= ruleBehaviorVariable ) ) )* otherlv_3= Colon ( ( ruleQCREF ) ) (otherlv_5= ColonEqualsSign ( (lv_initialValue_6_0= ruleValueConstant ) ) )? (otherlv_7= LeftCurlyBracket ( (lv_propertyAssociations_8_0= ruleBehaviorPropertyAssociation ) )+ otherlv_9= RightCurlyBracket )? otherlv_10= Semicolon )
            // InternalBehaviorAnnexParser.g:218:3: ( (lv_variables_0_0= ruleBehaviorVariable ) ) (otherlv_1= Comma ( (lv_variables_2_0= ruleBehaviorVariable ) ) )* otherlv_3= Colon ( ( ruleQCREF ) ) (otherlv_5= ColonEqualsSign ( (lv_initialValue_6_0= ruleValueConstant ) ) )? (otherlv_7= LeftCurlyBracket ( (lv_propertyAssociations_8_0= ruleBehaviorPropertyAssociation ) )+ otherlv_9= RightCurlyBracket )? otherlv_10= Semicolon
            {
            // InternalBehaviorAnnexParser.g:218:3: ( (lv_variables_0_0= ruleBehaviorVariable ) )
            // InternalBehaviorAnnexParser.g:219:4: (lv_variables_0_0= ruleBehaviorVariable )
            {
            // InternalBehaviorAnnexParser.g:219:4: (lv_variables_0_0= ruleBehaviorVariable )
            // InternalBehaviorAnnexParser.g:220:5: lv_variables_0_0= ruleBehaviorVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBehaviorVariableGroupAccess().getVariablesBehaviorVariableParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_7);
            lv_variables_0_0=ruleBehaviorVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBehaviorVariableGroupRule());
              					}
              					add(
              						current,
              						"variables",
              						lv_variables_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorVariable");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:237:3: (otherlv_1= Comma ( (lv_variables_2_0= ruleBehaviorVariable ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Comma) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:238:4: otherlv_1= Comma ( (lv_variables_2_0= ruleBehaviorVariable ) )
            	    {
            	    otherlv_1=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getBehaviorVariableGroupAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalBehaviorAnnexParser.g:242:4: ( (lv_variables_2_0= ruleBehaviorVariable ) )
            	    // InternalBehaviorAnnexParser.g:243:5: (lv_variables_2_0= ruleBehaviorVariable )
            	    {
            	    // InternalBehaviorAnnexParser.g:243:5: (lv_variables_2_0= ruleBehaviorVariable )
            	    // InternalBehaviorAnnexParser.g:244:6: lv_variables_2_0= ruleBehaviorVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBehaviorVariableGroupAccess().getVariablesBehaviorVariableParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_variables_2_0=ruleBehaviorVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBehaviorVariableGroupRule());
            	      						}
            	      						add(
            	      							current,
            	      							"variables",
            	      							lv_variables_2_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorVariable");
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

            otherlv_3=(Token)match(input,Colon,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBehaviorVariableGroupAccess().getColonKeyword_2());
              		
            }
            // InternalBehaviorAnnexParser.g:266:3: ( ( ruleQCREF ) )
            // InternalBehaviorAnnexParser.g:267:4: ( ruleQCREF )
            {
            // InternalBehaviorAnnexParser.g:267:4: ( ruleQCREF )
            // InternalBehaviorAnnexParser.g:268:5: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBehaviorVariableGroupRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBehaviorVariableGroupAccess().getDataClassifierComponentClassifierCrossReference_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_8);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:282:3: (otherlv_5= ColonEqualsSign ( (lv_initialValue_6_0= ruleValueConstant ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ColonEqualsSign) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:283:4: otherlv_5= ColonEqualsSign ( (lv_initialValue_6_0= ruleValueConstant ) )
                    {
                    otherlv_5=(Token)match(input,ColonEqualsSign,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getBehaviorVariableGroupAccess().getColonEqualsSignKeyword_4_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:287:4: ( (lv_initialValue_6_0= ruleValueConstant ) )
                    // InternalBehaviorAnnexParser.g:288:5: (lv_initialValue_6_0= ruleValueConstant )
                    {
                    // InternalBehaviorAnnexParser.g:288:5: (lv_initialValue_6_0= ruleValueConstant )
                    // InternalBehaviorAnnexParser.g:289:6: lv_initialValue_6_0= ruleValueConstant
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBehaviorVariableGroupAccess().getInitialValueValueConstantParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_initialValue_6_0=ruleValueConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBehaviorVariableGroupRule());
                      						}
                      						set(
                      							current,
                      							"initialValue",
                      							lv_initialValue_6_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueConstant");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:307:3: (otherlv_7= LeftCurlyBracket ( (lv_propertyAssociations_8_0= ruleBehaviorPropertyAssociation ) )+ otherlv_9= RightCurlyBracket )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LeftCurlyBracket) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:308:4: otherlv_7= LeftCurlyBracket ( (lv_propertyAssociations_8_0= ruleBehaviorPropertyAssociation ) )+ otherlv_9= RightCurlyBracket
                    {
                    otherlv_7=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getBehaviorVariableGroupAccess().getLeftCurlyBracketKeyword_5_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:312:4: ( (lv_propertyAssociations_8_0= ruleBehaviorPropertyAssociation ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalBehaviorAnnexParser.g:313:5: (lv_propertyAssociations_8_0= ruleBehaviorPropertyAssociation )
                    	    {
                    	    // InternalBehaviorAnnexParser.g:313:5: (lv_propertyAssociations_8_0= ruleBehaviorPropertyAssociation )
                    	    // InternalBehaviorAnnexParser.g:314:6: lv_propertyAssociations_8_0= ruleBehaviorPropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getBehaviorVariableGroupAccess().getPropertyAssociationsBehaviorPropertyAssociationParserRuleCall_5_1_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_11);
                    	    lv_propertyAssociations_8_0=ruleBehaviorPropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getBehaviorVariableGroupRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"propertyAssociations",
                    	      							lv_propertyAssociations_8_0,
                    	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorPropertyAssociation");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    otherlv_9=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getBehaviorVariableGroupAccess().getRightCurlyBracketKeyword_5_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_10=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getBehaviorVariableGroupAccess().getSemicolonKeyword_6());
              		
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
    // $ANTLR end "ruleBehaviorVariableGroup"


    // $ANTLR start "entryRuleBehaviorVariable"
    // InternalBehaviorAnnexParser.g:344:1: entryRuleBehaviorVariable returns [EObject current=null] : iv_ruleBehaviorVariable= ruleBehaviorVariable EOF ;
    public final EObject entryRuleBehaviorVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorVariable = null;


        try {
            // InternalBehaviorAnnexParser.g:344:57: (iv_ruleBehaviorVariable= ruleBehaviorVariable EOF )
            // InternalBehaviorAnnexParser.g:345:2: iv_ruleBehaviorVariable= ruleBehaviorVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorVariableRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorVariable=ruleBehaviorVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorVariable; 
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
    // $ANTLR end "entryRuleBehaviorVariable"


    // $ANTLR start "ruleBehaviorVariable"
    // InternalBehaviorAnnexParser.g:351:1: ruleBehaviorVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_arrayDimensions_1_0= ruleArrayDimension ) )* ) ;
    public final EObject ruleBehaviorVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_arrayDimensions_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:357:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_arrayDimensions_1_0= ruleArrayDimension ) )* ) )
            // InternalBehaviorAnnexParser.g:358:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_arrayDimensions_1_0= ruleArrayDimension ) )* )
            {
            // InternalBehaviorAnnexParser.g:358:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_arrayDimensions_1_0= ruleArrayDimension ) )* )
            // InternalBehaviorAnnexParser.g:359:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_arrayDimensions_1_0= ruleArrayDimension ) )*
            {
            // InternalBehaviorAnnexParser.g:359:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:360:4: (lv_name_0_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:360:4: (lv_name_0_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:361:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getBehaviorVariableAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBehaviorVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:377:3: ( (lv_arrayDimensions_1_0= ruleArrayDimension ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==LeftSquareBracket) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:378:4: (lv_arrayDimensions_1_0= ruleArrayDimension )
            	    {
            	    // InternalBehaviorAnnexParser.g:378:4: (lv_arrayDimensions_1_0= ruleArrayDimension )
            	    // InternalBehaviorAnnexParser.g:379:5: lv_arrayDimensions_1_0= ruleArrayDimension
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBehaviorVariableAccess().getArrayDimensionsArrayDimensionParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_13);
            	    lv_arrayDimensions_1_0=ruleArrayDimension();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBehaviorVariableRule());
            	      					}
            	      					add(
            	      						current,
            	      						"arrayDimensions",
            	      						lv_arrayDimensions_1_0,
            	      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ArrayDimension");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // $ANTLR end "ruleBehaviorVariable"


    // $ANTLR start "entryRuleArrayDimension"
    // InternalBehaviorAnnexParser.g:400:1: entryRuleArrayDimension returns [EObject current=null] : iv_ruleArrayDimension= ruleArrayDimension EOF ;
    public final EObject entryRuleArrayDimension() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayDimension = null;


        try {
            // InternalBehaviorAnnexParser.g:400:55: (iv_ruleArrayDimension= ruleArrayDimension EOF )
            // InternalBehaviorAnnexParser.g:401:2: iv_ruleArrayDimension= ruleArrayDimension EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayDimensionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleArrayDimension=ruleArrayDimension();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayDimension; 
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
    // $ANTLR end "entryRuleArrayDimension"


    // $ANTLR start "ruleArrayDimension"
    // InternalBehaviorAnnexParser.g:407:1: ruleArrayDimension returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_size_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket ) ;
    public final EObject ruleArrayDimension() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_size_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:413:2: ( (otherlv_0= LeftSquareBracket ( (lv_size_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:414:2: (otherlv_0= LeftSquareBracket ( (lv_size_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:414:2: (otherlv_0= LeftSquareBracket ( (lv_size_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:415:3: otherlv_0= LeftSquareBracket ( (lv_size_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArrayDimensionAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:419:3: ( (lv_size_1_0= ruleIntegerValue ) )
            // InternalBehaviorAnnexParser.g:420:4: (lv_size_1_0= ruleIntegerValue )
            {
            // InternalBehaviorAnnexParser.g:420:4: (lv_size_1_0= ruleIntegerValue )
            // InternalBehaviorAnnexParser.g:421:5: lv_size_1_0= ruleIntegerValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArrayDimensionAccess().getSizeIntegerValueParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_15);
            lv_size_1_0=ruleIntegerValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArrayDimensionRule());
              					}
              					set(
              						current,
              						"size",
              						lv_size_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.IntegerValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getArrayDimensionAccess().getRightSquareBracketKeyword_2());
              		
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
    // $ANTLR end "ruleArrayDimension"


    // $ANTLR start "entryRuleBehaviorPropertyAssociation"
    // InternalBehaviorAnnexParser.g:446:1: entryRuleBehaviorPropertyAssociation returns [EObject current=null] : iv_ruleBehaviorPropertyAssociation= ruleBehaviorPropertyAssociation EOF ;
    public final EObject entryRuleBehaviorPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorPropertyAssociation = null;


        try {
            // InternalBehaviorAnnexParser.g:446:68: (iv_ruleBehaviorPropertyAssociation= ruleBehaviorPropertyAssociation EOF )
            // InternalBehaviorAnnexParser.g:447:2: iv_ruleBehaviorPropertyAssociation= ruleBehaviorPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorPropertyAssociationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorPropertyAssociation=ruleBehaviorPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorPropertyAssociation; 
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
    // $ANTLR end "entryRuleBehaviorPropertyAssociation"


    // $ANTLR start "ruleBehaviorPropertyAssociation"
    // InternalBehaviorAnnexParser.g:453:1: ruleBehaviorPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleBehaviorPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:459:2: ( ( ( ( ruleQPREF ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) )
            // InternalBehaviorAnnexParser.g:460:2: ( ( ( ruleQPREF ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            {
            // InternalBehaviorAnnexParser.g:460:2: ( ( ( ruleQPREF ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            // InternalBehaviorAnnexParser.g:461:3: ( ( ruleQPREF ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon
            {
            // InternalBehaviorAnnexParser.g:461:3: ( ( ruleQPREF ) )
            // InternalBehaviorAnnexParser.g:462:4: ( ruleQPREF )
            {
            // InternalBehaviorAnnexParser.g:462:4: ( ruleQPREF )
            // InternalBehaviorAnnexParser.g:463:5: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBehaviorPropertyAssociationRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBehaviorPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_16);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBehaviorPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:481:3: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalBehaviorAnnexParser.g:482:4: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalBehaviorAnnexParser.g:482:4: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalBehaviorAnnexParser.g:483:5: lv_ownedValue_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBehaviorPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_12);
            lv_ownedValue_2_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBehaviorPropertyAssociationRule());
              					}
              					set(
              						current,
              						"ownedValue",
              						lv_ownedValue_2_0,
              						"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBehaviorPropertyAssociationAccess().getSemicolonKeyword_3());
              		
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
    // $ANTLR end "ruleBehaviorPropertyAssociation"


    // $ANTLR start "entryRuleBehaviorStateGroup"
    // InternalBehaviorAnnexParser.g:508:1: entryRuleBehaviorStateGroup returns [EObject current=null] : iv_ruleBehaviorStateGroup= ruleBehaviorStateGroup EOF ;
    public final EObject entryRuleBehaviorStateGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorStateGroup = null;


        try {
            // InternalBehaviorAnnexParser.g:508:59: (iv_ruleBehaviorStateGroup= ruleBehaviorStateGroup EOF )
            // InternalBehaviorAnnexParser.g:509:2: iv_ruleBehaviorStateGroup= ruleBehaviorStateGroup EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorStateGroupRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorStateGroup=ruleBehaviorStateGroup();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorStateGroup; 
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
    // $ANTLR end "entryRuleBehaviorStateGroup"


    // $ANTLR start "ruleBehaviorStateGroup"
    // InternalBehaviorAnnexParser.g:515:1: ruleBehaviorStateGroup returns [EObject current=null] : ( ( (lv_states_0_0= ruleBehaviorState ) ) (otherlv_1= Comma ( (lv_states_2_0= ruleBehaviorState ) ) )* otherlv_3= Colon ( (lv_initial_4_0= Initial ) )? ( (lv_complete_5_0= Complete ) )? ( (lv_final_6_0= Final ) )? otherlv_7= State otherlv_8= Semicolon ) ;
    public final EObject ruleBehaviorStateGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_initial_4_0=null;
        Token lv_complete_5_0=null;
        Token lv_final_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_states_0_0 = null;

        EObject lv_states_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:521:2: ( ( ( (lv_states_0_0= ruleBehaviorState ) ) (otherlv_1= Comma ( (lv_states_2_0= ruleBehaviorState ) ) )* otherlv_3= Colon ( (lv_initial_4_0= Initial ) )? ( (lv_complete_5_0= Complete ) )? ( (lv_final_6_0= Final ) )? otherlv_7= State otherlv_8= Semicolon ) )
            // InternalBehaviorAnnexParser.g:522:2: ( ( (lv_states_0_0= ruleBehaviorState ) ) (otherlv_1= Comma ( (lv_states_2_0= ruleBehaviorState ) ) )* otherlv_3= Colon ( (lv_initial_4_0= Initial ) )? ( (lv_complete_5_0= Complete ) )? ( (lv_final_6_0= Final ) )? otherlv_7= State otherlv_8= Semicolon )
            {
            // InternalBehaviorAnnexParser.g:522:2: ( ( (lv_states_0_0= ruleBehaviorState ) ) (otherlv_1= Comma ( (lv_states_2_0= ruleBehaviorState ) ) )* otherlv_3= Colon ( (lv_initial_4_0= Initial ) )? ( (lv_complete_5_0= Complete ) )? ( (lv_final_6_0= Final ) )? otherlv_7= State otherlv_8= Semicolon )
            // InternalBehaviorAnnexParser.g:523:3: ( (lv_states_0_0= ruleBehaviorState ) ) (otherlv_1= Comma ( (lv_states_2_0= ruleBehaviorState ) ) )* otherlv_3= Colon ( (lv_initial_4_0= Initial ) )? ( (lv_complete_5_0= Complete ) )? ( (lv_final_6_0= Final ) )? otherlv_7= State otherlv_8= Semicolon
            {
            // InternalBehaviorAnnexParser.g:523:3: ( (lv_states_0_0= ruleBehaviorState ) )
            // InternalBehaviorAnnexParser.g:524:4: (lv_states_0_0= ruleBehaviorState )
            {
            // InternalBehaviorAnnexParser.g:524:4: (lv_states_0_0= ruleBehaviorState )
            // InternalBehaviorAnnexParser.g:525:5: lv_states_0_0= ruleBehaviorState
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBehaviorStateGroupAccess().getStatesBehaviorStateParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_7);
            lv_states_0_0=ruleBehaviorState();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBehaviorStateGroupRule());
              					}
              					add(
              						current,
              						"states",
              						lv_states_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorState");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:542:3: (otherlv_1= Comma ( (lv_states_2_0= ruleBehaviorState ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==Comma) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:543:4: otherlv_1= Comma ( (lv_states_2_0= ruleBehaviorState ) )
            	    {
            	    otherlv_1=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getBehaviorStateGroupAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalBehaviorAnnexParser.g:547:4: ( (lv_states_2_0= ruleBehaviorState ) )
            	    // InternalBehaviorAnnexParser.g:548:5: (lv_states_2_0= ruleBehaviorState )
            	    {
            	    // InternalBehaviorAnnexParser.g:548:5: (lv_states_2_0= ruleBehaviorState )
            	    // InternalBehaviorAnnexParser.g:549:6: lv_states_2_0= ruleBehaviorState
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBehaviorStateGroupAccess().getStatesBehaviorStateParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_states_2_0=ruleBehaviorState();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBehaviorStateGroupRule());
            	      						}
            	      						add(
            	      							current,
            	      							"states",
            	      							lv_states_2_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorState");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_3=(Token)match(input,Colon,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBehaviorStateGroupAccess().getColonKeyword_2());
              		
            }
            // InternalBehaviorAnnexParser.g:571:3: ( (lv_initial_4_0= Initial ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Initial) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:572:4: (lv_initial_4_0= Initial )
                    {
                    // InternalBehaviorAnnexParser.g:572:4: (lv_initial_4_0= Initial )
                    // InternalBehaviorAnnexParser.g:573:5: lv_initial_4_0= Initial
                    {
                    lv_initial_4_0=(Token)match(input,Initial,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_initial_4_0, grammarAccess.getBehaviorStateGroupAccess().getInitialInitialKeyword_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBehaviorStateGroupRule());
                      					}
                      					setWithLastConsumed(current, "initial", lv_initial_4_0 != null, "initial");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:585:3: ( (lv_complete_5_0= Complete ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Complete) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:586:4: (lv_complete_5_0= Complete )
                    {
                    // InternalBehaviorAnnexParser.g:586:4: (lv_complete_5_0= Complete )
                    // InternalBehaviorAnnexParser.g:587:5: lv_complete_5_0= Complete
                    {
                    lv_complete_5_0=(Token)match(input,Complete,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_complete_5_0, grammarAccess.getBehaviorStateGroupAccess().getCompleteCompleteKeyword_4_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBehaviorStateGroupRule());
                      					}
                      					setWithLastConsumed(current, "complete", lv_complete_5_0 != null, "complete");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:599:3: ( (lv_final_6_0= Final ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==Final) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:600:4: (lv_final_6_0= Final )
                    {
                    // InternalBehaviorAnnexParser.g:600:4: (lv_final_6_0= Final )
                    // InternalBehaviorAnnexParser.g:601:5: lv_final_6_0= Final
                    {
                    lv_final_6_0=(Token)match(input,Final,FollowSets000.FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_final_6_0, grammarAccess.getBehaviorStateGroupAccess().getFinalFinalKeyword_5_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBehaviorStateGroupRule());
                      					}
                      					setWithLastConsumed(current, "final", lv_final_6_0 != null, "final");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,State,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getBehaviorStateGroupAccess().getStateKeyword_6());
              		
            }
            otherlv_8=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getBehaviorStateGroupAccess().getSemicolonKeyword_7());
              		
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
    // $ANTLR end "ruleBehaviorStateGroup"


    // $ANTLR start "entryRuleBehaviorState"
    // InternalBehaviorAnnexParser.g:625:1: entryRuleBehaviorState returns [EObject current=null] : iv_ruleBehaviorState= ruleBehaviorState EOF ;
    public final EObject entryRuleBehaviorState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorState = null;


        try {
            // InternalBehaviorAnnexParser.g:625:54: (iv_ruleBehaviorState= ruleBehaviorState EOF )
            // InternalBehaviorAnnexParser.g:626:2: iv_ruleBehaviorState= ruleBehaviorState EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorStateRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorState=ruleBehaviorState();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorState; 
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
    // $ANTLR end "entryRuleBehaviorState"


    // $ANTLR start "ruleBehaviorState"
    // InternalBehaviorAnnexParser.g:632:1: ruleBehaviorState returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleBehaviorState() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:638:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalBehaviorAnnexParser.g:639:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalBehaviorAnnexParser.g:639:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:640:3: (lv_name_0_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:640:3: (lv_name_0_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:641:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_name_0_0, grammarAccess.getBehaviorStateAccess().getNameIDTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getBehaviorStateRule());
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
    // $ANTLR end "ruleBehaviorState"


    // $ANTLR start "entryRuleBehaviorTransition"
    // InternalBehaviorAnnexParser.g:660:1: entryRuleBehaviorTransition returns [EObject current=null] : iv_ruleBehaviorTransition= ruleBehaviorTransition EOF ;
    public final EObject entryRuleBehaviorTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorTransition = null;


        try {
            // InternalBehaviorAnnexParser.g:660:59: (iv_ruleBehaviorTransition= ruleBehaviorTransition EOF )
            // InternalBehaviorAnnexParser.g:661:2: iv_ruleBehaviorTransition= ruleBehaviorTransition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorTransitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorTransition=ruleBehaviorTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorTransition; 
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
    // $ANTLR end "entryRuleBehaviorTransition"


    // $ANTLR start "ruleBehaviorTransition"
    // InternalBehaviorAnnexParser.g:667:1: ruleBehaviorTransition returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (lv_priority_2_0= RULE_INTEGER_LIT ) ) otherlv_3= RightSquareBracket )? otherlv_4= Colon )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= Comma ( (otherlv_7= RULE_ID ) ) )* otherlv_8= HyphenMinusLeftSquareBracket ( (lv_condition_9_0= ruleBehaviorCondition ) )? otherlv_10= RightSquareBracketHyphenMinusGreaterThanSign ( (otherlv_11= RULE_ID ) ) ( (lv_actionBlock_12_0= ruleBehaviorActionBlock ) )? otherlv_13= Semicolon ) ;
    public final EObject ruleBehaviorTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_priority_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_condition_9_0 = null;

        EObject lv_actionBlock_12_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:673:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (lv_priority_2_0= RULE_INTEGER_LIT ) ) otherlv_3= RightSquareBracket )? otherlv_4= Colon )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= Comma ( (otherlv_7= RULE_ID ) ) )* otherlv_8= HyphenMinusLeftSquareBracket ( (lv_condition_9_0= ruleBehaviorCondition ) )? otherlv_10= RightSquareBracketHyphenMinusGreaterThanSign ( (otherlv_11= RULE_ID ) ) ( (lv_actionBlock_12_0= ruleBehaviorActionBlock ) )? otherlv_13= Semicolon ) )
            // InternalBehaviorAnnexParser.g:674:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (lv_priority_2_0= RULE_INTEGER_LIT ) ) otherlv_3= RightSquareBracket )? otherlv_4= Colon )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= Comma ( (otherlv_7= RULE_ID ) ) )* otherlv_8= HyphenMinusLeftSquareBracket ( (lv_condition_9_0= ruleBehaviorCondition ) )? otherlv_10= RightSquareBracketHyphenMinusGreaterThanSign ( (otherlv_11= RULE_ID ) ) ( (lv_actionBlock_12_0= ruleBehaviorActionBlock ) )? otherlv_13= Semicolon )
            {
            // InternalBehaviorAnnexParser.g:674:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (lv_priority_2_0= RULE_INTEGER_LIT ) ) otherlv_3= RightSquareBracket )? otherlv_4= Colon )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= Comma ( (otherlv_7= RULE_ID ) ) )* otherlv_8= HyphenMinusLeftSquareBracket ( (lv_condition_9_0= ruleBehaviorCondition ) )? otherlv_10= RightSquareBracketHyphenMinusGreaterThanSign ( (otherlv_11= RULE_ID ) ) ( (lv_actionBlock_12_0= ruleBehaviorActionBlock ) )? otherlv_13= Semicolon )
            // InternalBehaviorAnnexParser.g:675:3: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (lv_priority_2_0= RULE_INTEGER_LIT ) ) otherlv_3= RightSquareBracket )? otherlv_4= Colon )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= Comma ( (otherlv_7= RULE_ID ) ) )* otherlv_8= HyphenMinusLeftSquareBracket ( (lv_condition_9_0= ruleBehaviorCondition ) )? otherlv_10= RightSquareBracketHyphenMinusGreaterThanSign ( (otherlv_11= RULE_ID ) ) ( (lv_actionBlock_12_0= ruleBehaviorActionBlock ) )? otherlv_13= Semicolon
            {
            // InternalBehaviorAnnexParser.g:675:3: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (lv_priority_2_0= RULE_INTEGER_LIT ) ) otherlv_3= RightSquareBracket )? otherlv_4= Colon )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==Colon||LA17_1==LeftSquareBracket) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:676:4: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftSquareBracket ( (lv_priority_2_0= RULE_INTEGER_LIT ) ) otherlv_3= RightSquareBracket )? otherlv_4= Colon
                    {
                    // InternalBehaviorAnnexParser.g:676:4: ( (lv_name_0_0= RULE_ID ) )
                    // InternalBehaviorAnnexParser.g:677:5: (lv_name_0_0= RULE_ID )
                    {
                    // InternalBehaviorAnnexParser.g:677:5: (lv_name_0_0= RULE_ID )
                    // InternalBehaviorAnnexParser.g:678:6: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_0_0, grammarAccess.getBehaviorTransitionAccess().getNameIDTerminalRuleCall_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBehaviorTransitionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_0_0,
                      							"org.osate.xtext.aadl2.properties.Properties.ID");
                      					
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:694:4: (otherlv_1= LeftSquareBracket ( (lv_priority_2_0= RULE_INTEGER_LIT ) ) otherlv_3= RightSquareBracket )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==LeftSquareBracket) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:695:5: otherlv_1= LeftSquareBracket ( (lv_priority_2_0= RULE_INTEGER_LIT ) ) otherlv_3= RightSquareBracket
                            {
                            otherlv_1=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_23); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_1, grammarAccess.getBehaviorTransitionAccess().getLeftSquareBracketKeyword_0_1_0());
                              				
                            }
                            // InternalBehaviorAnnexParser.g:699:5: ( (lv_priority_2_0= RULE_INTEGER_LIT ) )
                            // InternalBehaviorAnnexParser.g:700:6: (lv_priority_2_0= RULE_INTEGER_LIT )
                            {
                            // InternalBehaviorAnnexParser.g:700:6: (lv_priority_2_0= RULE_INTEGER_LIT )
                            // InternalBehaviorAnnexParser.g:701:7: lv_priority_2_0= RULE_INTEGER_LIT
                            {
                            lv_priority_2_0=(Token)match(input,RULE_INTEGER_LIT,FollowSets000.FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_priority_2_0, grammarAccess.getBehaviorTransitionAccess().getPriorityINTEGER_LITTerminalRuleCall_0_1_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getBehaviorTransitionRule());
                              							}
                              							setWithLastConsumed(
                              								current,
                              								"priority",
                              								lv_priority_2_0,
                              								"org.osate.xtext.aadl2.properties.Properties.INTEGER_LIT");
                              						
                            }

                            }


                            }

                            otherlv_3=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_24); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getBehaviorTransitionAccess().getRightSquareBracketKeyword_0_1_2());
                              				
                            }

                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,Colon,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBehaviorTransitionAccess().getColonKeyword_0_2());
                      			
                    }

                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:727:3: ( (otherlv_5= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:728:4: (otherlv_5= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:728:4: (otherlv_5= RULE_ID )
            // InternalBehaviorAnnexParser.g:729:5: otherlv_5= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBehaviorTransitionRule());
              					}
              				
            }
            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_5, grammarAccess.getBehaviorTransitionAccess().getSourceStatesBehaviorStateCrossReference_1_0());
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:740:3: (otherlv_6= Comma ( (otherlv_7= RULE_ID ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==Comma) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:741:4: otherlv_6= Comma ( (otherlv_7= RULE_ID ) )
            	    {
            	    otherlv_6=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getBehaviorTransitionAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalBehaviorAnnexParser.g:745:4: ( (otherlv_7= RULE_ID ) )
            	    // InternalBehaviorAnnexParser.g:746:5: (otherlv_7= RULE_ID )
            	    {
            	    // InternalBehaviorAnnexParser.g:746:5: (otherlv_7= RULE_ID )
            	    // InternalBehaviorAnnexParser.g:747:6: otherlv_7= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getBehaviorTransitionRule());
            	      						}
            	      					
            	    }
            	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_7, grammarAccess.getBehaviorTransitionAccess().getSourceStatesBehaviorStateCrossReference_2_1_0());
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_8=(Token)match(input,HyphenMinusLeftSquareBracket,FollowSets000.FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getBehaviorTransitionAccess().getHyphenMinusLeftSquareBracketKeyword_3());
              		
            }
            // InternalBehaviorAnnexParser.g:763:3: ( (lv_condition_9_0= ruleBehaviorCondition ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Otherwise||LA19_0==Timeout||LA19_0==False||LA19_0==True||LA19_0==Abs||LA19_0==Not||LA19_0==On||LA19_0==NumberSign||LA19_0==LeftParenthesis||LA19_0==PlusSign||LA19_0==HyphenMinus||LA19_0==RULE_REAL_LIT||LA19_0==RULE_INTEGER_LIT||(LA19_0>=RULE_STRING && LA19_0<=RULE_ID)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:764:4: (lv_condition_9_0= ruleBehaviorCondition )
                    {
                    // InternalBehaviorAnnexParser.g:764:4: (lv_condition_9_0= ruleBehaviorCondition )
                    // InternalBehaviorAnnexParser.g:765:5: lv_condition_9_0= ruleBehaviorCondition
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBehaviorTransitionAccess().getConditionBehaviorConditionParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_27);
                    lv_condition_9_0=ruleBehaviorCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBehaviorTransitionRule());
                      					}
                      					set(
                      						current,
                      						"condition",
                      						lv_condition_9_0,
                      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorCondition");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,RightSquareBracketHyphenMinusGreaterThanSign,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getBehaviorTransitionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_5());
              		
            }
            // InternalBehaviorAnnexParser.g:786:3: ( (otherlv_11= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:787:4: (otherlv_11= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:787:4: (otherlv_11= RULE_ID )
            // InternalBehaviorAnnexParser.g:788:5: otherlv_11= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBehaviorTransitionRule());
              					}
              				
            }
            otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_11, grammarAccess.getBehaviorTransitionAccess().getDestinationStateBehaviorStateCrossReference_6_0());
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:799:3: ( (lv_actionBlock_12_0= ruleBehaviorActionBlock ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==LeftCurlyBracket) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:800:4: (lv_actionBlock_12_0= ruleBehaviorActionBlock )
                    {
                    // InternalBehaviorAnnexParser.g:800:4: (lv_actionBlock_12_0= ruleBehaviorActionBlock )
                    // InternalBehaviorAnnexParser.g:801:5: lv_actionBlock_12_0= ruleBehaviorActionBlock
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBehaviorTransitionAccess().getActionBlockBehaviorActionBlockParserRuleCall_7_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_12);
                    lv_actionBlock_12_0=ruleBehaviorActionBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBehaviorTransitionRule());
                      					}
                      					set(
                      						current,
                      						"actionBlock",
                      						lv_actionBlock_12_0,
                      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActionBlock");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getBehaviorTransitionAccess().getSemicolonKeyword_8());
              		
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
    // $ANTLR end "ruleBehaviorTransition"


    // $ANTLR start "entryRuleBehaviorCondition"
    // InternalBehaviorAnnexParser.g:826:1: entryRuleBehaviorCondition returns [EObject current=null] : iv_ruleBehaviorCondition= ruleBehaviorCondition EOF ;
    public final EObject entryRuleBehaviorCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorCondition = null;


        try {
            // InternalBehaviorAnnexParser.g:826:58: (iv_ruleBehaviorCondition= ruleBehaviorCondition EOF )
            // InternalBehaviorAnnexParser.g:827:2: iv_ruleBehaviorCondition= ruleBehaviorCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorConditionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorCondition=ruleBehaviorCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorCondition; 
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
    // $ANTLR end "entryRuleBehaviorCondition"


    // $ANTLR start "ruleBehaviorCondition"
    // InternalBehaviorAnnexParser.g:833:1: ruleBehaviorCondition returns [EObject current=null] : ( (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_internal_2_0= ruleInternalCondition ) ) | ( (lv_modeSwitch_3_0= ruleModeSwitchCondition ) ) ) ) | ( (lv_execute_4_0= ruleExecuteCondition ) ) ) ;
    public final EObject ruleBehaviorCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_dispatch_1_0 = null;

        EObject lv_internal_2_0 = null;

        EObject lv_modeSwitch_3_0 = null;

        EObject lv_execute_4_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:839:2: ( ( (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_internal_2_0= ruleInternalCondition ) ) | ( (lv_modeSwitch_3_0= ruleModeSwitchCondition ) ) ) ) | ( (lv_execute_4_0= ruleExecuteCondition ) ) ) )
            // InternalBehaviorAnnexParser.g:840:2: ( (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_internal_2_0= ruleInternalCondition ) ) | ( (lv_modeSwitch_3_0= ruleModeSwitchCondition ) ) ) ) | ( (lv_execute_4_0= ruleExecuteCondition ) ) )
            {
            // InternalBehaviorAnnexParser.g:840:2: ( (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_internal_2_0= ruleInternalCondition ) ) | ( (lv_modeSwitch_3_0= ruleModeSwitchCondition ) ) ) ) | ( (lv_execute_4_0= ruleExecuteCondition ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==On) ) {
                alt22=1;
            }
            else if ( (LA22_0==Otherwise||LA22_0==Timeout||LA22_0==False||LA22_0==True||LA22_0==Abs||LA22_0==Not||LA22_0==NumberSign||LA22_0==LeftParenthesis||LA22_0==PlusSign||LA22_0==HyphenMinus||LA22_0==RULE_REAL_LIT||LA22_0==RULE_INTEGER_LIT||(LA22_0>=RULE_STRING && LA22_0<=RULE_ID)) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:841:3: (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_internal_2_0= ruleInternalCondition ) ) | ( (lv_modeSwitch_3_0= ruleModeSwitchCondition ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:841:3: (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_internal_2_0= ruleInternalCondition ) ) | ( (lv_modeSwitch_3_0= ruleModeSwitchCondition ) ) ) )
                    // InternalBehaviorAnnexParser.g:842:4: otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_internal_2_0= ruleInternalCondition ) ) | ( (lv_modeSwitch_3_0= ruleModeSwitchCondition ) ) )
                    {
                    otherlv_0=(Token)match(input,On,FollowSets000.FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getBehaviorConditionAccess().getOnKeyword_0_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:846:4: ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_internal_2_0= ruleInternalCondition ) ) | ( (lv_modeSwitch_3_0= ruleModeSwitchCondition ) ) )
                    int alt21=3;
                    switch ( input.LA(1) ) {
                    case Dispatch:
                        {
                        alt21=1;
                        }
                        break;
                    case Internal:
                        {
                        alt21=2;
                        }
                        break;
                    case LeftParenthesis:
                    case RULE_ID:
                        {
                        alt21=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }

                    switch (alt21) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:847:5: ( (lv_dispatch_1_0= ruleDispatchCondition ) )
                            {
                            // InternalBehaviorAnnexParser.g:847:5: ( (lv_dispatch_1_0= ruleDispatchCondition ) )
                            // InternalBehaviorAnnexParser.g:848:6: (lv_dispatch_1_0= ruleDispatchCondition )
                            {
                            // InternalBehaviorAnnexParser.g:848:6: (lv_dispatch_1_0= ruleDispatchCondition )
                            // InternalBehaviorAnnexParser.g:849:7: lv_dispatch_1_0= ruleDispatchCondition
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getBehaviorConditionAccess().getDispatchDispatchConditionParserRuleCall_0_1_0_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_dispatch_1_0=ruleDispatchCondition();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getBehaviorConditionRule());
                              							}
                              							set(
                              								current,
                              								"dispatch",
                              								lv_dispatch_1_0,
                              								"org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchCondition");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBehaviorAnnexParser.g:867:5: ( (lv_internal_2_0= ruleInternalCondition ) )
                            {
                            // InternalBehaviorAnnexParser.g:867:5: ( (lv_internal_2_0= ruleInternalCondition ) )
                            // InternalBehaviorAnnexParser.g:868:6: (lv_internal_2_0= ruleInternalCondition )
                            {
                            // InternalBehaviorAnnexParser.g:868:6: (lv_internal_2_0= ruleInternalCondition )
                            // InternalBehaviorAnnexParser.g:869:7: lv_internal_2_0= ruleInternalCondition
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getBehaviorConditionAccess().getInternalInternalConditionParserRuleCall_0_1_1_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_internal_2_0=ruleInternalCondition();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getBehaviorConditionRule());
                              							}
                              							set(
                              								current,
                              								"internal",
                              								lv_internal_2_0,
                              								"org.osate.xtext.aadl2.ba.BehaviorAnnex.InternalCondition");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalBehaviorAnnexParser.g:887:5: ( (lv_modeSwitch_3_0= ruleModeSwitchCondition ) )
                            {
                            // InternalBehaviorAnnexParser.g:887:5: ( (lv_modeSwitch_3_0= ruleModeSwitchCondition ) )
                            // InternalBehaviorAnnexParser.g:888:6: (lv_modeSwitch_3_0= ruleModeSwitchCondition )
                            {
                            // InternalBehaviorAnnexParser.g:888:6: (lv_modeSwitch_3_0= ruleModeSwitchCondition )
                            // InternalBehaviorAnnexParser.g:889:7: lv_modeSwitch_3_0= ruleModeSwitchCondition
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getBehaviorConditionAccess().getModeSwitchModeSwitchConditionParserRuleCall_0_1_2_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_modeSwitch_3_0=ruleModeSwitchCondition();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getBehaviorConditionRule());
                              							}
                              							set(
                              								current,
                              								"modeSwitch",
                              								lv_modeSwitch_3_0,
                              								"org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchCondition");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:909:3: ( (lv_execute_4_0= ruleExecuteCondition ) )
                    {
                    // InternalBehaviorAnnexParser.g:909:3: ( (lv_execute_4_0= ruleExecuteCondition ) )
                    // InternalBehaviorAnnexParser.g:910:4: (lv_execute_4_0= ruleExecuteCondition )
                    {
                    // InternalBehaviorAnnexParser.g:910:4: (lv_execute_4_0= ruleExecuteCondition )
                    // InternalBehaviorAnnexParser.g:911:5: lv_execute_4_0= ruleExecuteCondition
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBehaviorConditionAccess().getExecuteExecuteConditionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_execute_4_0=ruleExecuteCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBehaviorConditionRule());
                      					}
                      					set(
                      						current,
                      						"execute",
                      						lv_execute_4_0,
                      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ExecuteCondition");
                      					afterParserOrEnumRuleCall();
                      				
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
    // $ANTLR end "ruleBehaviorCondition"


    // $ANTLR start "entryRuleExecuteCondition"
    // InternalBehaviorAnnexParser.g:932:1: entryRuleExecuteCondition returns [EObject current=null] : iv_ruleExecuteCondition= ruleExecuteCondition EOF ;
    public final EObject entryRuleExecuteCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecuteCondition = null;


        try {
            // InternalBehaviorAnnexParser.g:932:57: (iv_ruleExecuteCondition= ruleExecuteCondition EOF )
            // InternalBehaviorAnnexParser.g:933:2: iv_ruleExecuteCondition= ruleExecuteCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExecuteConditionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExecuteCondition=ruleExecuteCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExecuteCondition; 
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
    // $ANTLR end "entryRuleExecuteCondition"


    // $ANTLR start "ruleExecuteCondition"
    // InternalBehaviorAnnexParser.g:939:1: ruleExecuteCondition returns [EObject current=null] : ( ( (lv_value_0_0= ruleValueExpression ) ) | ( (lv_timeout_1_0= Timeout ) ) | ( (lv_otherwise_2_0= Otherwise ) ) ) ;
    public final EObject ruleExecuteCondition() throws RecognitionException {
        EObject current = null;

        Token lv_timeout_1_0=null;
        Token lv_otherwise_2_0=null;
        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:945:2: ( ( ( (lv_value_0_0= ruleValueExpression ) ) | ( (lv_timeout_1_0= Timeout ) ) | ( (lv_otherwise_2_0= Otherwise ) ) ) )
            // InternalBehaviorAnnexParser.g:946:2: ( ( (lv_value_0_0= ruleValueExpression ) ) | ( (lv_timeout_1_0= Timeout ) ) | ( (lv_otherwise_2_0= Otherwise ) ) )
            {
            // InternalBehaviorAnnexParser.g:946:2: ( ( (lv_value_0_0= ruleValueExpression ) ) | ( (lv_timeout_1_0= Timeout ) ) | ( (lv_otherwise_2_0= Otherwise ) ) )
            int alt23=3;
            switch ( input.LA(1) ) {
            case False:
            case True:
            case Abs:
            case Not:
            case NumberSign:
            case LeftParenthesis:
            case PlusSign:
            case HyphenMinus:
            case RULE_REAL_LIT:
            case RULE_INTEGER_LIT:
            case RULE_STRING:
            case RULE_ID:
                {
                alt23=1;
                }
                break;
            case Timeout:
                {
                alt23=2;
                }
                break;
            case Otherwise:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:947:3: ( (lv_value_0_0= ruleValueExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:947:3: ( (lv_value_0_0= ruleValueExpression ) )
                    // InternalBehaviorAnnexParser.g:948:4: (lv_value_0_0= ruleValueExpression )
                    {
                    // InternalBehaviorAnnexParser.g:948:4: (lv_value_0_0= ruleValueExpression )
                    // InternalBehaviorAnnexParser.g:949:5: lv_value_0_0= ruleValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getExecuteConditionAccess().getValueValueExpressionParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_0_0=ruleValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getExecuteConditionRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_0_0,
                      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:967:3: ( (lv_timeout_1_0= Timeout ) )
                    {
                    // InternalBehaviorAnnexParser.g:967:3: ( (lv_timeout_1_0= Timeout ) )
                    // InternalBehaviorAnnexParser.g:968:4: (lv_timeout_1_0= Timeout )
                    {
                    // InternalBehaviorAnnexParser.g:968:4: (lv_timeout_1_0= Timeout )
                    // InternalBehaviorAnnexParser.g:969:5: lv_timeout_1_0= Timeout
                    {
                    lv_timeout_1_0=(Token)match(input,Timeout,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_timeout_1_0, grammarAccess.getExecuteConditionAccess().getTimeoutTimeoutKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getExecuteConditionRule());
                      					}
                      					setWithLastConsumed(current, "timeout", lv_timeout_1_0 != null, "timeout");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBehaviorAnnexParser.g:982:3: ( (lv_otherwise_2_0= Otherwise ) )
                    {
                    // InternalBehaviorAnnexParser.g:982:3: ( (lv_otherwise_2_0= Otherwise ) )
                    // InternalBehaviorAnnexParser.g:983:4: (lv_otherwise_2_0= Otherwise )
                    {
                    // InternalBehaviorAnnexParser.g:983:4: (lv_otherwise_2_0= Otherwise )
                    // InternalBehaviorAnnexParser.g:984:5: lv_otherwise_2_0= Otherwise
                    {
                    lv_otherwise_2_0=(Token)match(input,Otherwise,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_otherwise_2_0, grammarAccess.getExecuteConditionAccess().getOtherwiseOtherwiseKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getExecuteConditionRule());
                      					}
                      					setWithLastConsumed(current, "otherwise", lv_otherwise_2_0 != null, "otherwise");
                      				
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
    // $ANTLR end "ruleExecuteCondition"


    // $ANTLR start "entryRuleDispatchCondition"
    // InternalBehaviorAnnexParser.g:1000:1: entryRuleDispatchCondition returns [EObject current=null] : iv_ruleDispatchCondition= ruleDispatchCondition EOF ;
    public final EObject entryRuleDispatchCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDispatchCondition = null;


        try {
            // InternalBehaviorAnnexParser.g:1000:58: (iv_ruleDispatchCondition= ruleDispatchCondition EOF )
            // InternalBehaviorAnnexParser.g:1001:2: iv_ruleDispatchCondition= ruleDispatchCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDispatchConditionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDispatchCondition=ruleDispatchCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDispatchCondition; 
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
    // $ANTLR end "entryRuleDispatchCondition"


    // $ANTLR start "ruleDispatchCondition"
    // InternalBehaviorAnnexParser.g:1007:1: ruleDispatchCondition returns [EObject current=null] : ( () otherlv_1= Dispatch ( (lv_trigger_2_0= ruleDispatchTriggerCondition ) )? (otherlv_3= Frozen otherlv_4= LeftParenthesis ( (lv_frozenPorts_5_0= ruleReference ) ) (otherlv_6= Comma ( (lv_frozenPorts_7_0= ruleReference ) ) )* otherlv_8= RightParenthesis )? ) ;
    public final EObject ruleDispatchCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_trigger_2_0 = null;

        EObject lv_frozenPorts_5_0 = null;

        EObject lv_frozenPorts_7_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1013:2: ( ( () otherlv_1= Dispatch ( (lv_trigger_2_0= ruleDispatchTriggerCondition ) )? (otherlv_3= Frozen otherlv_4= LeftParenthesis ( (lv_frozenPorts_5_0= ruleReference ) ) (otherlv_6= Comma ( (lv_frozenPorts_7_0= ruleReference ) ) )* otherlv_8= RightParenthesis )? ) )
            // InternalBehaviorAnnexParser.g:1014:2: ( () otherlv_1= Dispatch ( (lv_trigger_2_0= ruleDispatchTriggerCondition ) )? (otherlv_3= Frozen otherlv_4= LeftParenthesis ( (lv_frozenPorts_5_0= ruleReference ) ) (otherlv_6= Comma ( (lv_frozenPorts_7_0= ruleReference ) ) )* otherlv_8= RightParenthesis )? )
            {
            // InternalBehaviorAnnexParser.g:1014:2: ( () otherlv_1= Dispatch ( (lv_trigger_2_0= ruleDispatchTriggerCondition ) )? (otherlv_3= Frozen otherlv_4= LeftParenthesis ( (lv_frozenPorts_5_0= ruleReference ) ) (otherlv_6= Comma ( (lv_frozenPorts_7_0= ruleReference ) ) )* otherlv_8= RightParenthesis )? )
            // InternalBehaviorAnnexParser.g:1015:3: () otherlv_1= Dispatch ( (lv_trigger_2_0= ruleDispatchTriggerCondition ) )? (otherlv_3= Frozen otherlv_4= LeftParenthesis ( (lv_frozenPorts_5_0= ruleReference ) ) (otherlv_6= Comma ( (lv_frozenPorts_7_0= ruleReference ) ) )* otherlv_8= RightParenthesis )?
            {
            // InternalBehaviorAnnexParser.g:1015:3: ()
            // InternalBehaviorAnnexParser.g:1016:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDispatchConditionAccess().getDispatchConditionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Dispatch,FollowSets000.FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDispatchConditionAccess().getDispatchKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:1026:3: ( (lv_trigger_2_0= ruleDispatchTriggerCondition ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Timeout||LA24_0==Stop||LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1027:4: (lv_trigger_2_0= ruleDispatchTriggerCondition )
                    {
                    // InternalBehaviorAnnexParser.g:1027:4: (lv_trigger_2_0= ruleDispatchTriggerCondition )
                    // InternalBehaviorAnnexParser.g:1028:5: lv_trigger_2_0= ruleDispatchTriggerCondition
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDispatchConditionAccess().getTriggerDispatchTriggerConditionParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_30);
                    lv_trigger_2_0=ruleDispatchTriggerCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDispatchConditionRule());
                      					}
                      					set(
                      						current,
                      						"trigger",
                      						lv_trigger_2_0,
                      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchTriggerCondition");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:1045:3: (otherlv_3= Frozen otherlv_4= LeftParenthesis ( (lv_frozenPorts_5_0= ruleReference ) ) (otherlv_6= Comma ( (lv_frozenPorts_7_0= ruleReference ) ) )* otherlv_8= RightParenthesis )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Frozen) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1046:4: otherlv_3= Frozen otherlv_4= LeftParenthesis ( (lv_frozenPorts_5_0= ruleReference ) ) (otherlv_6= Comma ( (lv_frozenPorts_7_0= ruleReference ) ) )* otherlv_8= RightParenthesis
                    {
                    otherlv_3=(Token)match(input,Frozen,FollowSets000.FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDispatchConditionAccess().getFrozenKeyword_3_0());
                      			
                    }
                    otherlv_4=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDispatchConditionAccess().getLeftParenthesisKeyword_3_1());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:1054:4: ( (lv_frozenPorts_5_0= ruleReference ) )
                    // InternalBehaviorAnnexParser.g:1055:5: (lv_frozenPorts_5_0= ruleReference )
                    {
                    // InternalBehaviorAnnexParser.g:1055:5: (lv_frozenPorts_5_0= ruleReference )
                    // InternalBehaviorAnnexParser.g:1056:6: lv_frozenPorts_5_0= ruleReference
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDispatchConditionAccess().getFrozenPortsReferenceParserRuleCall_3_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_32);
                    lv_frozenPorts_5_0=ruleReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDispatchConditionRule());
                      						}
                      						add(
                      							current,
                      							"frozenPorts",
                      							lv_frozenPorts_5_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:1073:4: (otherlv_6= Comma ( (lv_frozenPorts_7_0= ruleReference ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==Comma) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalBehaviorAnnexParser.g:1074:5: otherlv_6= Comma ( (lv_frozenPorts_7_0= ruleReference ) )
                    	    {
                    	    otherlv_6=(Token)match(input,Comma,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getDispatchConditionAccess().getCommaKeyword_3_3_0());
                    	      				
                    	    }
                    	    // InternalBehaviorAnnexParser.g:1078:5: ( (lv_frozenPorts_7_0= ruleReference ) )
                    	    // InternalBehaviorAnnexParser.g:1079:6: (lv_frozenPorts_7_0= ruleReference )
                    	    {
                    	    // InternalBehaviorAnnexParser.g:1079:6: (lv_frozenPorts_7_0= ruleReference )
                    	    // InternalBehaviorAnnexParser.g:1080:7: lv_frozenPorts_7_0= ruleReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getDispatchConditionAccess().getFrozenPortsReferenceParserRuleCall_3_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_32);
                    	    lv_frozenPorts_7_0=ruleReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getDispatchConditionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"frozenPorts",
                    	      								lv_frozenPorts_7_0,
                    	      								"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
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

                    otherlv_8=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getDispatchConditionAccess().getRightParenthesisKeyword_3_4());
                      			
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
    // $ANTLR end "ruleDispatchCondition"


    // $ANTLR start "entryRuleDispatchTriggerCondition"
    // InternalBehaviorAnnexParser.g:1107:1: entryRuleDispatchTriggerCondition returns [EObject current=null] : iv_ruleDispatchTriggerCondition= ruleDispatchTriggerCondition EOF ;
    public final EObject entryRuleDispatchTriggerCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDispatchTriggerCondition = null;


        try {
            // InternalBehaviorAnnexParser.g:1107:65: (iv_ruleDispatchTriggerCondition= ruleDispatchTriggerCondition EOF )
            // InternalBehaviorAnnexParser.g:1108:2: iv_ruleDispatchTriggerCondition= ruleDispatchTriggerCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDispatchTriggerConditionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDispatchTriggerCondition=ruleDispatchTriggerCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDispatchTriggerCondition; 
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
    // $ANTLR end "entryRuleDispatchTriggerCondition"


    // $ANTLR start "ruleDispatchTriggerCondition"
    // InternalBehaviorAnnexParser.g:1114:1: ruleDispatchTriggerCondition returns [EObject current=null] : ( ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) ) | ( ( (lv_timeout_1_0= Timeout ) ) (otherlv_2= LeftParenthesis ( (lv_resetPorts_3_0= ruleReference ) ) (otherlv_4= Or ( (lv_resetPorts_5_0= ruleReference ) ) )* otherlv_6= RightParenthesis )? ( (lv_time_7_0= ruleBehaviorTime ) )? ) | ( (lv_stop_8_0= Stop ) ) ) ;
    public final EObject ruleDispatchTriggerCondition() throws RecognitionException {
        EObject current = null;

        Token lv_timeout_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_stop_8_0=null;
        EObject lv_expression_0_0 = null;

        EObject lv_resetPorts_3_0 = null;

        EObject lv_resetPorts_5_0 = null;

        EObject lv_time_7_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1120:2: ( ( ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) ) | ( ( (lv_timeout_1_0= Timeout ) ) (otherlv_2= LeftParenthesis ( (lv_resetPorts_3_0= ruleReference ) ) (otherlv_4= Or ( (lv_resetPorts_5_0= ruleReference ) ) )* otherlv_6= RightParenthesis )? ( (lv_time_7_0= ruleBehaviorTime ) )? ) | ( (lv_stop_8_0= Stop ) ) ) )
            // InternalBehaviorAnnexParser.g:1121:2: ( ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) ) | ( ( (lv_timeout_1_0= Timeout ) ) (otherlv_2= LeftParenthesis ( (lv_resetPorts_3_0= ruleReference ) ) (otherlv_4= Or ( (lv_resetPorts_5_0= ruleReference ) ) )* otherlv_6= RightParenthesis )? ( (lv_time_7_0= ruleBehaviorTime ) )? ) | ( (lv_stop_8_0= Stop ) ) )
            {
            // InternalBehaviorAnnexParser.g:1121:2: ( ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) ) | ( ( (lv_timeout_1_0= Timeout ) ) (otherlv_2= LeftParenthesis ( (lv_resetPorts_3_0= ruleReference ) ) (otherlv_4= Or ( (lv_resetPorts_5_0= ruleReference ) ) )* otherlv_6= RightParenthesis )? ( (lv_time_7_0= ruleBehaviorTime ) )? ) | ( (lv_stop_8_0= Stop ) ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt30=1;
                }
                break;
            case Timeout:
                {
                alt30=2;
                }
                break;
            case Stop:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1122:3: ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:1122:3: ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) )
                    // InternalBehaviorAnnexParser.g:1123:4: (lv_expression_0_0= ruleDispatchTriggerLogicalExpression )
                    {
                    // InternalBehaviorAnnexParser.g:1123:4: (lv_expression_0_0= ruleDispatchTriggerLogicalExpression )
                    // InternalBehaviorAnnexParser.g:1124:5: lv_expression_0_0= ruleDispatchTriggerLogicalExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDispatchTriggerConditionAccess().getExpressionDispatchTriggerLogicalExpressionParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expression_0_0=ruleDispatchTriggerLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDispatchTriggerConditionRule());
                      					}
                      					set(
                      						current,
                      						"expression",
                      						lv_expression_0_0,
                      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchTriggerLogicalExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:1142:3: ( ( (lv_timeout_1_0= Timeout ) ) (otherlv_2= LeftParenthesis ( (lv_resetPorts_3_0= ruleReference ) ) (otherlv_4= Or ( (lv_resetPorts_5_0= ruleReference ) ) )* otherlv_6= RightParenthesis )? ( (lv_time_7_0= ruleBehaviorTime ) )? )
                    {
                    // InternalBehaviorAnnexParser.g:1142:3: ( ( (lv_timeout_1_0= Timeout ) ) (otherlv_2= LeftParenthesis ( (lv_resetPorts_3_0= ruleReference ) ) (otherlv_4= Or ( (lv_resetPorts_5_0= ruleReference ) ) )* otherlv_6= RightParenthesis )? ( (lv_time_7_0= ruleBehaviorTime ) )? )
                    // InternalBehaviorAnnexParser.g:1143:4: ( (lv_timeout_1_0= Timeout ) ) (otherlv_2= LeftParenthesis ( (lv_resetPorts_3_0= ruleReference ) ) (otherlv_4= Or ( (lv_resetPorts_5_0= ruleReference ) ) )* otherlv_6= RightParenthesis )? ( (lv_time_7_0= ruleBehaviorTime ) )?
                    {
                    // InternalBehaviorAnnexParser.g:1143:4: ( (lv_timeout_1_0= Timeout ) )
                    // InternalBehaviorAnnexParser.g:1144:5: (lv_timeout_1_0= Timeout )
                    {
                    // InternalBehaviorAnnexParser.g:1144:5: (lv_timeout_1_0= Timeout )
                    // InternalBehaviorAnnexParser.g:1145:6: lv_timeout_1_0= Timeout
                    {
                    lv_timeout_1_0=(Token)match(input,Timeout,FollowSets000.FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_timeout_1_0, grammarAccess.getDispatchTriggerConditionAccess().getTimeoutTimeoutKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDispatchTriggerConditionRule());
                      						}
                      						setWithLastConsumed(current, "timeout", lv_timeout_1_0 != null, "timeout");
                      					
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:1157:4: (otherlv_2= LeftParenthesis ( (lv_resetPorts_3_0= ruleReference ) ) (otherlv_4= Or ( (lv_resetPorts_5_0= ruleReference ) ) )* otherlv_6= RightParenthesis )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==LeftParenthesis) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:1158:5: otherlv_2= LeftParenthesis ( (lv_resetPorts_3_0= ruleReference ) ) (otherlv_4= Or ( (lv_resetPorts_5_0= ruleReference ) ) )* otherlv_6= RightParenthesis
                            {
                            otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getDispatchTriggerConditionAccess().getLeftParenthesisKeyword_1_1_0());
                              				
                            }
                            // InternalBehaviorAnnexParser.g:1162:5: ( (lv_resetPorts_3_0= ruleReference ) )
                            // InternalBehaviorAnnexParser.g:1163:6: (lv_resetPorts_3_0= ruleReference )
                            {
                            // InternalBehaviorAnnexParser.g:1163:6: (lv_resetPorts_3_0= ruleReference )
                            // InternalBehaviorAnnexParser.g:1164:7: lv_resetPorts_3_0= ruleReference
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getDispatchTriggerConditionAccess().getResetPortsReferenceParserRuleCall_1_1_1_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_34);
                            lv_resetPorts_3_0=ruleReference();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getDispatchTriggerConditionRule());
                              							}
                              							add(
                              								current,
                              								"resetPorts",
                              								lv_resetPorts_3_0,
                              								"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalBehaviorAnnexParser.g:1181:5: (otherlv_4= Or ( (lv_resetPorts_5_0= ruleReference ) ) )*
                            loop27:
                            do {
                                int alt27=2;
                                int LA27_0 = input.LA(1);

                                if ( (LA27_0==Or) ) {
                                    alt27=1;
                                }


                                switch (alt27) {
                            	case 1 :
                            	    // InternalBehaviorAnnexParser.g:1182:6: otherlv_4= Or ( (lv_resetPorts_5_0= ruleReference ) )
                            	    {
                            	    otherlv_4=(Token)match(input,Or,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_4, grammarAccess.getDispatchTriggerConditionAccess().getOrKeyword_1_1_2_0());
                            	      					
                            	    }
                            	    // InternalBehaviorAnnexParser.g:1186:6: ( (lv_resetPorts_5_0= ruleReference ) )
                            	    // InternalBehaviorAnnexParser.g:1187:7: (lv_resetPorts_5_0= ruleReference )
                            	    {
                            	    // InternalBehaviorAnnexParser.g:1187:7: (lv_resetPorts_5_0= ruleReference )
                            	    // InternalBehaviorAnnexParser.g:1188:8: lv_resetPorts_5_0= ruleReference
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getDispatchTriggerConditionAccess().getResetPortsReferenceParserRuleCall_1_1_2_1_0());
                            	      							
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_34);
                            	    lv_resetPorts_5_0=ruleReference();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getDispatchTriggerConditionRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"resetPorts",
                            	      									lv_resetPorts_5_0,
                            	      									"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
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

                            otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getDispatchTriggerConditionAccess().getRightParenthesisKeyword_1_1_3());
                              				
                            }

                            }
                            break;

                    }

                    // InternalBehaviorAnnexParser.g:1211:4: ( (lv_time_7_0= ruleBehaviorTime ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==NumberSign||LA29_0==RULE_INTEGER_LIT||LA29_0==RULE_ID) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:1212:5: (lv_time_7_0= ruleBehaviorTime )
                            {
                            // InternalBehaviorAnnexParser.g:1212:5: (lv_time_7_0= ruleBehaviorTime )
                            // InternalBehaviorAnnexParser.g:1213:6: lv_time_7_0= ruleBehaviorTime
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getDispatchTriggerConditionAccess().getTimeBehaviorTimeParserRuleCall_1_2_0());
                              					
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_time_7_0=ruleBehaviorTime();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getDispatchTriggerConditionRule());
                              						}
                              						set(
                              							current,
                              							"time",
                              							lv_time_7_0,
                              							"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTime");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBehaviorAnnexParser.g:1232:3: ( (lv_stop_8_0= Stop ) )
                    {
                    // InternalBehaviorAnnexParser.g:1232:3: ( (lv_stop_8_0= Stop ) )
                    // InternalBehaviorAnnexParser.g:1233:4: (lv_stop_8_0= Stop )
                    {
                    // InternalBehaviorAnnexParser.g:1233:4: (lv_stop_8_0= Stop )
                    // InternalBehaviorAnnexParser.g:1234:5: lv_stop_8_0= Stop
                    {
                    lv_stop_8_0=(Token)match(input,Stop,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_stop_8_0, grammarAccess.getDispatchTriggerConditionAccess().getStopStopKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getDispatchTriggerConditionRule());
                      					}
                      					setWithLastConsumed(current, "stop", lv_stop_8_0 != null, "stop");
                      				
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
    // $ANTLR end "ruleDispatchTriggerCondition"


    // $ANTLR start "entryRuleDispatchTriggerLogicalExpression"
    // InternalBehaviorAnnexParser.g:1250:1: entryRuleDispatchTriggerLogicalExpression returns [EObject current=null] : iv_ruleDispatchTriggerLogicalExpression= ruleDispatchTriggerLogicalExpression EOF ;
    public final EObject entryRuleDispatchTriggerLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDispatchTriggerLogicalExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:1250:73: (iv_ruleDispatchTriggerLogicalExpression= ruleDispatchTriggerLogicalExpression EOF )
            // InternalBehaviorAnnexParser.g:1251:2: iv_ruleDispatchTriggerLogicalExpression= ruleDispatchTriggerLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDispatchTriggerLogicalExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDispatchTriggerLogicalExpression=ruleDispatchTriggerLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDispatchTriggerLogicalExpression; 
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
    // $ANTLR end "entryRuleDispatchTriggerLogicalExpression"


    // $ANTLR start "ruleDispatchTriggerLogicalExpression"
    // InternalBehaviorAnnexParser.g:1257:1: ruleDispatchTriggerLogicalExpression returns [EObject current=null] : ( ( (lv_conjunctions_0_0= ruleDispatchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )* ) ;
    public final EObject ruleDispatchTriggerLogicalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_conjunctions_0_0 = null;

        EObject lv_conjunctions_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1263:2: ( ( ( (lv_conjunctions_0_0= ruleDispatchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1264:2: ( ( (lv_conjunctions_0_0= ruleDispatchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1264:2: ( ( (lv_conjunctions_0_0= ruleDispatchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )* )
            // InternalBehaviorAnnexParser.g:1265:3: ( (lv_conjunctions_0_0= ruleDispatchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )*
            {
            // InternalBehaviorAnnexParser.g:1265:3: ( (lv_conjunctions_0_0= ruleDispatchConjunction ) )
            // InternalBehaviorAnnexParser.g:1266:4: (lv_conjunctions_0_0= ruleDispatchConjunction )
            {
            // InternalBehaviorAnnexParser.g:1266:4: (lv_conjunctions_0_0= ruleDispatchConjunction )
            // InternalBehaviorAnnexParser.g:1267:5: lv_conjunctions_0_0= ruleDispatchConjunction
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDispatchTriggerLogicalExpressionAccess().getConjunctionsDispatchConjunctionParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_36);
            lv_conjunctions_0_0=ruleDispatchConjunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDispatchTriggerLogicalExpressionRule());
              					}
              					add(
              						current,
              						"conjunctions",
              						lv_conjunctions_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchConjunction");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:1284:3: (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==Or) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:1285:4: otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) )
            	    {
            	    otherlv_1=(Token)match(input,Or,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getDispatchTriggerLogicalExpressionAccess().getOrKeyword_1_0());
            	      			
            	    }
            	    // InternalBehaviorAnnexParser.g:1289:4: ( (lv_conjunctions_2_0= ruleDispatchConjunction ) )
            	    // InternalBehaviorAnnexParser.g:1290:5: (lv_conjunctions_2_0= ruleDispatchConjunction )
            	    {
            	    // InternalBehaviorAnnexParser.g:1290:5: (lv_conjunctions_2_0= ruleDispatchConjunction )
            	    // InternalBehaviorAnnexParser.g:1291:6: lv_conjunctions_2_0= ruleDispatchConjunction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDispatchTriggerLogicalExpressionAccess().getConjunctionsDispatchConjunctionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_36);
            	    lv_conjunctions_2_0=ruleDispatchConjunction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getDispatchTriggerLogicalExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"conjunctions",
            	      							lv_conjunctions_2_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchConjunction");
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
    // $ANTLR end "ruleDispatchTriggerLogicalExpression"


    // $ANTLR start "entryRuleDispatchConjunction"
    // InternalBehaviorAnnexParser.g:1313:1: entryRuleDispatchConjunction returns [EObject current=null] : iv_ruleDispatchConjunction= ruleDispatchConjunction EOF ;
    public final EObject entryRuleDispatchConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDispatchConjunction = null;


        try {
            // InternalBehaviorAnnexParser.g:1313:60: (iv_ruleDispatchConjunction= ruleDispatchConjunction EOF )
            // InternalBehaviorAnnexParser.g:1314:2: iv_ruleDispatchConjunction= ruleDispatchConjunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDispatchConjunctionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDispatchConjunction=ruleDispatchConjunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDispatchConjunction; 
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
    // $ANTLR end "entryRuleDispatchConjunction"


    // $ANTLR start "ruleDispatchConjunction"
    // InternalBehaviorAnnexParser.g:1320:1: ruleDispatchConjunction returns [EObject current=null] : ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* ) ;
    public final EObject ruleDispatchConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_triggers_0_0 = null;

        EObject lv_triggers_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1326:2: ( ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1327:2: ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1327:2: ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* )
            // InternalBehaviorAnnexParser.g:1328:3: ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )*
            {
            // InternalBehaviorAnnexParser.g:1328:3: ( (lv_triggers_0_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:1329:4: (lv_triggers_0_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:1329:4: (lv_triggers_0_0= ruleReference )
            // InternalBehaviorAnnexParser.g:1330:5: lv_triggers_0_0= ruleReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDispatchConjunctionAccess().getTriggersReferenceParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_37);
            lv_triggers_0_0=ruleReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDispatchConjunctionRule());
              					}
              					add(
              						current,
              						"triggers",
              						lv_triggers_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:1347:3: (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==And) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:1348:4: otherlv_1= And ( (lv_triggers_2_0= ruleReference ) )
            	    {
            	    otherlv_1=(Token)match(input,And,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getDispatchConjunctionAccess().getAndKeyword_1_0());
            	      			
            	    }
            	    // InternalBehaviorAnnexParser.g:1352:4: ( (lv_triggers_2_0= ruleReference ) )
            	    // InternalBehaviorAnnexParser.g:1353:5: (lv_triggers_2_0= ruleReference )
            	    {
            	    // InternalBehaviorAnnexParser.g:1353:5: (lv_triggers_2_0= ruleReference )
            	    // InternalBehaviorAnnexParser.g:1354:6: lv_triggers_2_0= ruleReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDispatchConjunctionAccess().getTriggersReferenceParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_37);
            	    lv_triggers_2_0=ruleReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getDispatchConjunctionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"triggers",
            	      							lv_triggers_2_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // $ANTLR end "ruleDispatchConjunction"


    // $ANTLR start "entryRuleModeSwitchCondition"
    // InternalBehaviorAnnexParser.g:1376:1: entryRuleModeSwitchCondition returns [EObject current=null] : iv_ruleModeSwitchCondition= ruleModeSwitchCondition EOF ;
    public final EObject entryRuleModeSwitchCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeSwitchCondition = null;


        try {
            // InternalBehaviorAnnexParser.g:1376:60: (iv_ruleModeSwitchCondition= ruleModeSwitchCondition EOF )
            // InternalBehaviorAnnexParser.g:1377:2: iv_ruleModeSwitchCondition= ruleModeSwitchCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeSwitchConditionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModeSwitchCondition=ruleModeSwitchCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModeSwitchCondition; 
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
    // $ANTLR end "entryRuleModeSwitchCondition"


    // $ANTLR start "ruleModeSwitchCondition"
    // InternalBehaviorAnnexParser.g:1383:1: ruleModeSwitchCondition returns [EObject current=null] : ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) ( ( (lv_logicalOperators_1_0= ruleLogicalOrOperator ) ) ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* ) ;
    public final EObject ruleModeSwitchCondition() throws RecognitionException {
        EObject current = null;

        EObject lv_conjunctions_0_0 = null;

        AntlrDatatypeRuleToken lv_logicalOperators_1_0 = null;

        EObject lv_conjunctions_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1389:2: ( ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) ( ( (lv_logicalOperators_1_0= ruleLogicalOrOperator ) ) ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1390:2: ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) ( ( (lv_logicalOperators_1_0= ruleLogicalOrOperator ) ) ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1390:2: ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) ( ( (lv_logicalOperators_1_0= ruleLogicalOrOperator ) ) ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* )
            // InternalBehaviorAnnexParser.g:1391:3: ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) ( ( (lv_logicalOperators_1_0= ruleLogicalOrOperator ) ) ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )*
            {
            // InternalBehaviorAnnexParser.g:1391:3: ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) )
            // InternalBehaviorAnnexParser.g:1392:4: (lv_conjunctions_0_0= ruleModeSwitchConjunction )
            {
            // InternalBehaviorAnnexParser.g:1392:4: (lv_conjunctions_0_0= ruleModeSwitchConjunction )
            // InternalBehaviorAnnexParser.g:1393:5: lv_conjunctions_0_0= ruleModeSwitchConjunction
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getModeSwitchConditionAccess().getConjunctionsModeSwitchConjunctionParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_38);
            lv_conjunctions_0_0=ruleModeSwitchConjunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getModeSwitchConditionRule());
              					}
              					add(
              						current,
              						"conjunctions",
              						lv_conjunctions_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchConjunction");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:1410:3: ( ( (lv_logicalOperators_1_0= ruleLogicalOrOperator ) ) ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==Xor||LA33_0==Or) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:1411:4: ( (lv_logicalOperators_1_0= ruleLogicalOrOperator ) ) ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) )
            	    {
            	    // InternalBehaviorAnnexParser.g:1411:4: ( (lv_logicalOperators_1_0= ruleLogicalOrOperator ) )
            	    // InternalBehaviorAnnexParser.g:1412:5: (lv_logicalOperators_1_0= ruleLogicalOrOperator )
            	    {
            	    // InternalBehaviorAnnexParser.g:1412:5: (lv_logicalOperators_1_0= ruleLogicalOrOperator )
            	    // InternalBehaviorAnnexParser.g:1413:6: lv_logicalOperators_1_0= ruleLogicalOrOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModeSwitchConditionAccess().getLogicalOperatorsLogicalOrOperatorParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_28);
            	    lv_logicalOperators_1_0=ruleLogicalOrOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getModeSwitchConditionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"logicalOperators",
            	      							lv_logicalOperators_1_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.LogicalOrOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalBehaviorAnnexParser.g:1430:4: ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) )
            	    // InternalBehaviorAnnexParser.g:1431:5: (lv_conjunctions_2_0= ruleModeSwitchConjunction )
            	    {
            	    // InternalBehaviorAnnexParser.g:1431:5: (lv_conjunctions_2_0= ruleModeSwitchConjunction )
            	    // InternalBehaviorAnnexParser.g:1432:6: lv_conjunctions_2_0= ruleModeSwitchConjunction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModeSwitchConditionAccess().getConjunctionsModeSwitchConjunctionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_38);
            	    lv_conjunctions_2_0=ruleModeSwitchConjunction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getModeSwitchConditionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"conjunctions",
            	      							lv_conjunctions_2_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchConjunction");
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
    // $ANTLR end "ruleModeSwitchCondition"


    // $ANTLR start "entryRuleModeSwitchConjunction"
    // InternalBehaviorAnnexParser.g:1454:1: entryRuleModeSwitchConjunction returns [EObject current=null] : iv_ruleModeSwitchConjunction= ruleModeSwitchConjunction EOF ;
    public final EObject entryRuleModeSwitchConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeSwitchConjunction = null;


        try {
            // InternalBehaviorAnnexParser.g:1454:62: (iv_ruleModeSwitchConjunction= ruleModeSwitchConjunction EOF )
            // InternalBehaviorAnnexParser.g:1455:2: iv_ruleModeSwitchConjunction= ruleModeSwitchConjunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeSwitchConjunctionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModeSwitchConjunction=ruleModeSwitchConjunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModeSwitchConjunction; 
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
    // $ANTLR end "entryRuleModeSwitchConjunction"


    // $ANTLR start "ruleModeSwitchConjunction"
    // InternalBehaviorAnnexParser.g:1461:1: ruleModeSwitchConjunction returns [EObject current=null] : ( ( (lv_triggers_0_0= ruleModeSwitchTrigger ) ) ( ( (lv_logicalOperators_1_0= ruleLogicalAndOperator ) ) ( (lv_triggers_2_0= ruleModeSwitchTrigger ) ) )* ) ;
    public final EObject ruleModeSwitchConjunction() throws RecognitionException {
        EObject current = null;

        EObject lv_triggers_0_0 = null;

        AntlrDatatypeRuleToken lv_logicalOperators_1_0 = null;

        EObject lv_triggers_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1467:2: ( ( ( (lv_triggers_0_0= ruleModeSwitchTrigger ) ) ( ( (lv_logicalOperators_1_0= ruleLogicalAndOperator ) ) ( (lv_triggers_2_0= ruleModeSwitchTrigger ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1468:2: ( ( (lv_triggers_0_0= ruleModeSwitchTrigger ) ) ( ( (lv_logicalOperators_1_0= ruleLogicalAndOperator ) ) ( (lv_triggers_2_0= ruleModeSwitchTrigger ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1468:2: ( ( (lv_triggers_0_0= ruleModeSwitchTrigger ) ) ( ( (lv_logicalOperators_1_0= ruleLogicalAndOperator ) ) ( (lv_triggers_2_0= ruleModeSwitchTrigger ) ) )* )
            // InternalBehaviorAnnexParser.g:1469:3: ( (lv_triggers_0_0= ruleModeSwitchTrigger ) ) ( ( (lv_logicalOperators_1_0= ruleLogicalAndOperator ) ) ( (lv_triggers_2_0= ruleModeSwitchTrigger ) ) )*
            {
            // InternalBehaviorAnnexParser.g:1469:3: ( (lv_triggers_0_0= ruleModeSwitchTrigger ) )
            // InternalBehaviorAnnexParser.g:1470:4: (lv_triggers_0_0= ruleModeSwitchTrigger )
            {
            // InternalBehaviorAnnexParser.g:1470:4: (lv_triggers_0_0= ruleModeSwitchTrigger )
            // InternalBehaviorAnnexParser.g:1471:5: lv_triggers_0_0= ruleModeSwitchTrigger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getModeSwitchConjunctionAccess().getTriggersModeSwitchTriggerParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_37);
            lv_triggers_0_0=ruleModeSwitchTrigger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getModeSwitchConjunctionRule());
              					}
              					add(
              						current,
              						"triggers",
              						lv_triggers_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchTrigger");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:1488:3: ( ( (lv_logicalOperators_1_0= ruleLogicalAndOperator ) ) ( (lv_triggers_2_0= ruleModeSwitchTrigger ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==And) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:1489:4: ( (lv_logicalOperators_1_0= ruleLogicalAndOperator ) ) ( (lv_triggers_2_0= ruleModeSwitchTrigger ) )
            	    {
            	    // InternalBehaviorAnnexParser.g:1489:4: ( (lv_logicalOperators_1_0= ruleLogicalAndOperator ) )
            	    // InternalBehaviorAnnexParser.g:1490:5: (lv_logicalOperators_1_0= ruleLogicalAndOperator )
            	    {
            	    // InternalBehaviorAnnexParser.g:1490:5: (lv_logicalOperators_1_0= ruleLogicalAndOperator )
            	    // InternalBehaviorAnnexParser.g:1491:6: lv_logicalOperators_1_0= ruleLogicalAndOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModeSwitchConjunctionAccess().getLogicalOperatorsLogicalAndOperatorParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_28);
            	    lv_logicalOperators_1_0=ruleLogicalAndOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getModeSwitchConjunctionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"logicalOperators",
            	      							lv_logicalOperators_1_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.LogicalAndOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalBehaviorAnnexParser.g:1508:4: ( (lv_triggers_2_0= ruleModeSwitchTrigger ) )
            	    // InternalBehaviorAnnexParser.g:1509:5: (lv_triggers_2_0= ruleModeSwitchTrigger )
            	    {
            	    // InternalBehaviorAnnexParser.g:1509:5: (lv_triggers_2_0= ruleModeSwitchTrigger )
            	    // InternalBehaviorAnnexParser.g:1510:6: lv_triggers_2_0= ruleModeSwitchTrigger
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModeSwitchConjunctionAccess().getTriggersModeSwitchTriggerParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_37);
            	    lv_triggers_2_0=ruleModeSwitchTrigger();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getModeSwitchConjunctionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"triggers",
            	      							lv_triggers_2_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchTrigger");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // $ANTLR end "ruleModeSwitchConjunction"


    // $ANTLR start "entryRuleModeSwitchTrigger"
    // InternalBehaviorAnnexParser.g:1532:1: entryRuleModeSwitchTrigger returns [EObject current=null] : iv_ruleModeSwitchTrigger= ruleModeSwitchTrigger EOF ;
    public final EObject entryRuleModeSwitchTrigger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeSwitchTrigger = null;


        try {
            // InternalBehaviorAnnexParser.g:1532:58: (iv_ruleModeSwitchTrigger= ruleModeSwitchTrigger EOF )
            // InternalBehaviorAnnexParser.g:1533:2: iv_ruleModeSwitchTrigger= ruleModeSwitchTrigger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeSwitchTriggerRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModeSwitchTrigger=ruleModeSwitchTrigger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModeSwitchTrigger; 
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
    // $ANTLR end "entryRuleModeSwitchTrigger"


    // $ANTLR start "ruleModeSwitchTrigger"
    // InternalBehaviorAnnexParser.g:1539:1: ruleModeSwitchTrigger returns [EObject current=null] : ( ( (lv_reference_0_0= ruleReference ) ) | (otherlv_1= LeftParenthesis ( (lv_expression_2_0= ruleModeSwitchCondition ) ) otherlv_3= RightParenthesis ) ) ;
    public final EObject ruleModeSwitchTrigger() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_reference_0_0 = null;

        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1545:2: ( ( ( (lv_reference_0_0= ruleReference ) ) | (otherlv_1= LeftParenthesis ( (lv_expression_2_0= ruleModeSwitchCondition ) ) otherlv_3= RightParenthesis ) ) )
            // InternalBehaviorAnnexParser.g:1546:2: ( ( (lv_reference_0_0= ruleReference ) ) | (otherlv_1= LeftParenthesis ( (lv_expression_2_0= ruleModeSwitchCondition ) ) otherlv_3= RightParenthesis ) )
            {
            // InternalBehaviorAnnexParser.g:1546:2: ( ( (lv_reference_0_0= ruleReference ) ) | (otherlv_1= LeftParenthesis ( (lv_expression_2_0= ruleModeSwitchCondition ) ) otherlv_3= RightParenthesis ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            else if ( (LA35_0==LeftParenthesis) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1547:3: ( (lv_reference_0_0= ruleReference ) )
                    {
                    // InternalBehaviorAnnexParser.g:1547:3: ( (lv_reference_0_0= ruleReference ) )
                    // InternalBehaviorAnnexParser.g:1548:4: (lv_reference_0_0= ruleReference )
                    {
                    // InternalBehaviorAnnexParser.g:1548:4: (lv_reference_0_0= ruleReference )
                    // InternalBehaviorAnnexParser.g:1549:5: lv_reference_0_0= ruleReference
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getModeSwitchTriggerAccess().getReferenceReferenceParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_reference_0_0=ruleReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getModeSwitchTriggerRule());
                      					}
                      					set(
                      						current,
                      						"reference",
                      						lv_reference_0_0,
                      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:1567:3: (otherlv_1= LeftParenthesis ( (lv_expression_2_0= ruleModeSwitchCondition ) ) otherlv_3= RightParenthesis )
                    {
                    // InternalBehaviorAnnexParser.g:1567:3: (otherlv_1= LeftParenthesis ( (lv_expression_2_0= ruleModeSwitchCondition ) ) otherlv_3= RightParenthesis )
                    // InternalBehaviorAnnexParser.g:1568:4: otherlv_1= LeftParenthesis ( (lv_expression_2_0= ruleModeSwitchCondition ) ) otherlv_3= RightParenthesis
                    {
                    otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getModeSwitchTriggerAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:1572:4: ( (lv_expression_2_0= ruleModeSwitchCondition ) )
                    // InternalBehaviorAnnexParser.g:1573:5: (lv_expression_2_0= ruleModeSwitchCondition )
                    {
                    // InternalBehaviorAnnexParser.g:1573:5: (lv_expression_2_0= ruleModeSwitchCondition )
                    // InternalBehaviorAnnexParser.g:1574:6: lv_expression_2_0= ruleModeSwitchCondition
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getModeSwitchTriggerAccess().getExpressionModeSwitchConditionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_39);
                    lv_expression_2_0=ruleModeSwitchCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getModeSwitchTriggerRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_2_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchCondition");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getModeSwitchTriggerAccess().getRightParenthesisKeyword_1_2());
                      			
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
    // $ANTLR end "ruleModeSwitchTrigger"


    // $ANTLR start "entryRuleInternalCondition"
    // InternalBehaviorAnnexParser.g:1600:1: entryRuleInternalCondition returns [EObject current=null] : iv_ruleInternalCondition= ruleInternalCondition EOF ;
    public final EObject entryRuleInternalCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInternalCondition = null;


        try {
            // InternalBehaviorAnnexParser.g:1600:58: (iv_ruleInternalCondition= ruleInternalCondition EOF )
            // InternalBehaviorAnnexParser.g:1601:2: iv_ruleInternalCondition= ruleInternalCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInternalConditionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInternalCondition=ruleInternalCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInternalCondition; 
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
    // $ANTLR end "entryRuleInternalCondition"


    // $ANTLR start "ruleInternalCondition"
    // InternalBehaviorAnnexParser.g:1607:1: ruleInternalCondition returns [EObject current=null] : (otherlv_0= Internal ( (lv_internalPorts_1_0= ruleReference ) ) (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )* ) ;
    public final EObject ruleInternalCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_internalPorts_1_0 = null;

        EObject lv_internalPorts_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1613:2: ( (otherlv_0= Internal ( (lv_internalPorts_1_0= ruleReference ) ) (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1614:2: (otherlv_0= Internal ( (lv_internalPorts_1_0= ruleReference ) ) (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1614:2: (otherlv_0= Internal ( (lv_internalPorts_1_0= ruleReference ) ) (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )* )
            // InternalBehaviorAnnexParser.g:1615:3: otherlv_0= Internal ( (lv_internalPorts_1_0= ruleReference ) ) (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )*
            {
            otherlv_0=(Token)match(input,Internal,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getInternalConditionAccess().getInternalKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:1619:3: ( (lv_internalPorts_1_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:1620:4: (lv_internalPorts_1_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:1620:4: (lv_internalPorts_1_0= ruleReference )
            // InternalBehaviorAnnexParser.g:1621:5: lv_internalPorts_1_0= ruleReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInternalConditionAccess().getInternalPortsReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_36);
            lv_internalPorts_1_0=ruleReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInternalConditionRule());
              					}
              					add(
              						current,
              						"internalPorts",
              						lv_internalPorts_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:1638:3: (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==Or) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:1639:4: otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) )
            	    {
            	    otherlv_2=(Token)match(input,Or,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getInternalConditionAccess().getOrKeyword_2_0());
            	      			
            	    }
            	    // InternalBehaviorAnnexParser.g:1643:4: ( (lv_internalPorts_3_0= ruleReference ) )
            	    // InternalBehaviorAnnexParser.g:1644:5: (lv_internalPorts_3_0= ruleReference )
            	    {
            	    // InternalBehaviorAnnexParser.g:1644:5: (lv_internalPorts_3_0= ruleReference )
            	    // InternalBehaviorAnnexParser.g:1645:6: lv_internalPorts_3_0= ruleReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getInternalConditionAccess().getInternalPortsReferenceParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_36);
            	    lv_internalPorts_3_0=ruleReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getInternalConditionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"internalPorts",
            	      							lv_internalPorts_3_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // $ANTLR end "ruleInternalCondition"


    // $ANTLR start "entryRuleBehaviorActionBlock"
    // InternalBehaviorAnnexParser.g:1667:1: entryRuleBehaviorActionBlock returns [EObject current=null] : iv_ruleBehaviorActionBlock= ruleBehaviorActionBlock EOF ;
    public final EObject entryRuleBehaviorActionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorActionBlock = null;


        try {
            // InternalBehaviorAnnexParser.g:1667:60: (iv_ruleBehaviorActionBlock= ruleBehaviorActionBlock EOF )
            // InternalBehaviorAnnexParser.g:1668:2: iv_ruleBehaviorActionBlock= ruleBehaviorActionBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorActionBlockRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorActionBlock=ruleBehaviorActionBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorActionBlock; 
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
    // $ANTLR end "entryRuleBehaviorActionBlock"


    // $ANTLR start "ruleBehaviorActionBlock"
    // InternalBehaviorAnnexParser.g:1674:1: ruleBehaviorActionBlock returns [EObject current=null] : (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? ) ;
    public final EObject ruleBehaviorActionBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_content_1_0 = null;

        EObject lv_timeout_4_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1680:2: ( (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? ) )
            // InternalBehaviorAnnexParser.g:1681:2: (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:1681:2: (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? )
            // InternalBehaviorAnnexParser.g:1682:3: otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )?
            {
            otherlv_0=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBehaviorActionBlockAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:1686:3: ( (lv_content_1_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:1687:4: (lv_content_1_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:1687:4: (lv_content_1_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:1688:5: lv_content_1_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBehaviorActionBlockAccess().getContentBehaviorActionsParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_41);
            lv_content_1_0=ruleBehaviorActions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBehaviorActionBlockRule());
              					}
              					set(
              						current,
              						"content",
              						lv_content_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getBehaviorActionBlockAccess().getRightCurlyBracketKeyword_2());
              		
            }
            // InternalBehaviorAnnexParser.g:1709:3: (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Timeout) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1710:4: otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) )
                    {
                    otherlv_3=(Token)match(input,Timeout,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getBehaviorActionBlockAccess().getTimeoutKeyword_3_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:1714:4: ( (lv_timeout_4_0= ruleBehaviorTime ) )
                    // InternalBehaviorAnnexParser.g:1715:5: (lv_timeout_4_0= ruleBehaviorTime )
                    {
                    // InternalBehaviorAnnexParser.g:1715:5: (lv_timeout_4_0= ruleBehaviorTime )
                    // InternalBehaviorAnnexParser.g:1716:6: lv_timeout_4_0= ruleBehaviorTime
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBehaviorActionBlockAccess().getTimeoutBehaviorTimeParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_timeout_4_0=ruleBehaviorTime();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBehaviorActionBlockRule());
                      						}
                      						set(
                      							current,
                      							"timeout",
                      							lv_timeout_4_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTime");
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
    // $ANTLR end "ruleBehaviorActionBlock"


    // $ANTLR start "entryRuleBehaviorActions"
    // InternalBehaviorAnnexParser.g:1738:1: entryRuleBehaviorActions returns [EObject current=null] : iv_ruleBehaviorActions= ruleBehaviorActions EOF ;
    public final EObject entryRuleBehaviorActions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorActions = null;


        try {
            // InternalBehaviorAnnexParser.g:1738:56: (iv_ruleBehaviorActions= ruleBehaviorActions EOF )
            // InternalBehaviorAnnexParser.g:1739:2: iv_ruleBehaviorActions= ruleBehaviorActions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorActionsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorActions=ruleBehaviorActions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorActions; 
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
    // $ANTLR end "entryRuleBehaviorActions"


    // $ANTLR start "ruleBehaviorActions"
    // InternalBehaviorAnnexParser.g:1745:1: ruleBehaviorActions returns [EObject current=null] : (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? ) ;
    public final EObject ruleBehaviorActions() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject this_BehaviorAction_0 = null;

        EObject lv_actions_3_0 = null;

        EObject lv_actions_5_0 = null;

        EObject lv_actions_8_0 = null;

        EObject lv_actions_10_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1751:2: ( (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? ) )
            // InternalBehaviorAnnexParser.g:1752:2: (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? )
            {
            // InternalBehaviorAnnexParser.g:1752:2: (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? )
            // InternalBehaviorAnnexParser.g:1753:3: this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBehaviorActionsAccess().getBehaviorActionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_43);
            this_BehaviorAction_0=ruleBehaviorAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BehaviorAction_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBehaviorAnnexParser.g:1761:3: ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )?
            int alt40=3;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==Semicolon) ) {
                alt40=1;
            }
            else if ( (LA40_0==Ampersand) ) {
                alt40=2;
            }
            switch (alt40) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1762:4: ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* )
                    {
                    // InternalBehaviorAnnexParser.g:1762:4: ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* )
                    // InternalBehaviorAnnexParser.g:1763:5: () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )*
                    {
                    // InternalBehaviorAnnexParser.g:1763:5: ()
                    // InternalBehaviorAnnexParser.g:1764:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndAdd(
                      							grammarAccess.getBehaviorActionsAccess().getBehaviorActionSequenceActionsAction_1_0_0(),
                      							current);
                      					
                    }

                    }

                    otherlv_2=(Token)match(input,Semicolon,FollowSets000.FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_1());
                      				
                    }
                    // InternalBehaviorAnnexParser.g:1774:5: ( (lv_actions_3_0= ruleBehaviorAction ) )
                    // InternalBehaviorAnnexParser.g:1775:6: (lv_actions_3_0= ruleBehaviorAction )
                    {
                    // InternalBehaviorAnnexParser.g:1775:6: (lv_actions_3_0= ruleBehaviorAction )
                    // InternalBehaviorAnnexParser.g:1776:7: lv_actions_3_0= ruleBehaviorAction
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_0_2_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_44);
                    lv_actions_3_0=ruleBehaviorAction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getBehaviorActionsRule());
                      							}
                      							add(
                      								current,
                      								"actions",
                      								lv_actions_3_0,
                      								"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorAction");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:1793:5: (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==Semicolon) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalBehaviorAnnexParser.g:1794:6: otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Semicolon,FollowSets000.FOLLOW_40); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_4, grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_3_0());
                    	      					
                    	    }
                    	    // InternalBehaviorAnnexParser.g:1798:6: ( (lv_actions_5_0= ruleBehaviorAction ) )
                    	    // InternalBehaviorAnnexParser.g:1799:7: (lv_actions_5_0= ruleBehaviorAction )
                    	    {
                    	    // InternalBehaviorAnnexParser.g:1799:7: (lv_actions_5_0= ruleBehaviorAction )
                    	    // InternalBehaviorAnnexParser.g:1800:8: lv_actions_5_0= ruleBehaviorAction
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_0_3_1_0());
                    	      							
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_44);
                    	    lv_actions_5_0=ruleBehaviorAction();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getBehaviorActionsRule());
                    	      								}
                    	      								add(
                    	      									current,
                    	      									"actions",
                    	      									lv_actions_5_0,
                    	      									"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorAction");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:1820:4: ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* )
                    {
                    // InternalBehaviorAnnexParser.g:1820:4: ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* )
                    // InternalBehaviorAnnexParser.g:1821:5: () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )*
                    {
                    // InternalBehaviorAnnexParser.g:1821:5: ()
                    // InternalBehaviorAnnexParser.g:1822:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndAdd(
                      							grammarAccess.getBehaviorActionsAccess().getBehaviorActionSetActionsAction_1_1_0(),
                      							current);
                      					
                    }

                    }

                    otherlv_7=(Token)match(input,Ampersand,FollowSets000.FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getBehaviorActionsAccess().getAmpersandKeyword_1_1_1());
                      				
                    }
                    // InternalBehaviorAnnexParser.g:1832:5: ( (lv_actions_8_0= ruleBehaviorAction ) )
                    // InternalBehaviorAnnexParser.g:1833:6: (lv_actions_8_0= ruleBehaviorAction )
                    {
                    // InternalBehaviorAnnexParser.g:1833:6: (lv_actions_8_0= ruleBehaviorAction )
                    // InternalBehaviorAnnexParser.g:1834:7: lv_actions_8_0= ruleBehaviorAction
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_1_2_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_45);
                    lv_actions_8_0=ruleBehaviorAction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getBehaviorActionsRule());
                      							}
                      							add(
                      								current,
                      								"actions",
                      								lv_actions_8_0,
                      								"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorAction");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:1851:5: (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==Ampersand) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalBehaviorAnnexParser.g:1852:6: otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Ampersand,FollowSets000.FOLLOW_40); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_9, grammarAccess.getBehaviorActionsAccess().getAmpersandKeyword_1_1_3_0());
                    	      					
                    	    }
                    	    // InternalBehaviorAnnexParser.g:1856:6: ( (lv_actions_10_0= ruleBehaviorAction ) )
                    	    // InternalBehaviorAnnexParser.g:1857:7: (lv_actions_10_0= ruleBehaviorAction )
                    	    {
                    	    // InternalBehaviorAnnexParser.g:1857:7: (lv_actions_10_0= ruleBehaviorAction )
                    	    // InternalBehaviorAnnexParser.g:1858:8: lv_actions_10_0= ruleBehaviorAction
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_1_3_1_0());
                    	      							
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_45);
                    	    lv_actions_10_0=ruleBehaviorAction();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getBehaviorActionsRule());
                    	      								}
                    	      								add(
                    	      									current,
                    	      									"actions",
                    	      									lv_actions_10_0,
                    	      									"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorAction");
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
    // $ANTLR end "ruleBehaviorActions"


    // $ANTLR start "entryRuleBehaviorAction"
    // InternalBehaviorAnnexParser.g:1882:1: entryRuleBehaviorAction returns [EObject current=null] : iv_ruleBehaviorAction= ruleBehaviorAction EOF ;
    public final EObject entryRuleBehaviorAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorAction = null;


        try {
            // InternalBehaviorAnnexParser.g:1882:55: (iv_ruleBehaviorAction= ruleBehaviorAction EOF )
            // InternalBehaviorAnnexParser.g:1883:2: iv_ruleBehaviorAction= ruleBehaviorAction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorActionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorAction=ruleBehaviorAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorAction; 
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
    // $ANTLR end "entryRuleBehaviorAction"


    // $ANTLR start "ruleBehaviorAction"
    // InternalBehaviorAnnexParser.g:1889:1: ruleBehaviorAction returns [EObject current=null] : ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock ) ;
    public final EObject ruleBehaviorAction() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentAction_0 = null;

        EObject this_CommunicationAction_1 = null;

        EObject this_TimedAction_2 = null;

        EObject this_IfStatement_3 = null;

        EObject this_ForStatement_4 = null;

        EObject this_WhileStatement_5 = null;

        EObject this_DoUntilStatement_6 = null;

        EObject this_BehaviorActionBlock_7 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1895:2: ( ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock ) )
            // InternalBehaviorAnnexParser.g:1896:2: ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock )
            {
            // InternalBehaviorAnnexParser.g:1896:2: ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock )
            int alt41=8;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1897:3: ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction )
                    {
                    // InternalBehaviorAnnexParser.g:1897:3: ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction )
                    // InternalBehaviorAnnexParser.g:1898:4: ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getBehaviorActionAccess().getAssignmentActionParserRuleCall_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AssignmentAction_0=ruleAssignmentAction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_AssignmentAction_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:1909:3: this_CommunicationAction_1= ruleCommunicationAction
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBehaviorActionAccess().getCommunicationActionParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CommunicationAction_1=ruleCommunicationAction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CommunicationAction_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBehaviorAnnexParser.g:1918:3: this_TimedAction_2= ruleTimedAction
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBehaviorActionAccess().getTimedActionParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TimedAction_2=ruleTimedAction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TimedAction_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBehaviorAnnexParser.g:1927:3: this_IfStatement_3= ruleIfStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBehaviorActionAccess().getIfStatementParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_IfStatement_3=ruleIfStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfStatement_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBehaviorAnnexParser.g:1936:3: this_ForStatement_4= ruleForStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBehaviorActionAccess().getForStatementParserRuleCall_4());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ForStatement_4=ruleForStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ForStatement_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalBehaviorAnnexParser.g:1945:3: this_WhileStatement_5= ruleWhileStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBehaviorActionAccess().getWhileStatementParserRuleCall_5());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WhileStatement_5=ruleWhileStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_WhileStatement_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalBehaviorAnnexParser.g:1954:3: this_DoUntilStatement_6= ruleDoUntilStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBehaviorActionAccess().getDoUntilStatementParserRuleCall_6());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DoUntilStatement_6=ruleDoUntilStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DoUntilStatement_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalBehaviorAnnexParser.g:1963:3: this_BehaviorActionBlock_7= ruleBehaviorActionBlock
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getBehaviorActionAccess().getBehaviorActionBlockParserRuleCall_7());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BehaviorActionBlock_7=ruleBehaviorActionBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BehaviorActionBlock_7;
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
    // $ANTLR end "ruleBehaviorAction"


    // $ANTLR start "entryRuleAssignmentAction"
    // InternalBehaviorAnnexParser.g:1975:1: entryRuleAssignmentAction returns [EObject current=null] : iv_ruleAssignmentAction= ruleAssignmentAction EOF ;
    public final EObject entryRuleAssignmentAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentAction = null;


        try {
            // InternalBehaviorAnnexParser.g:1975:57: (iv_ruleAssignmentAction= ruleAssignmentAction EOF )
            // InternalBehaviorAnnexParser.g:1976:2: iv_ruleAssignmentAction= ruleAssignmentAction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentActionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignmentAction=ruleAssignmentAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentAction; 
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
    // $ANTLR end "entryRuleAssignmentAction"


    // $ANTLR start "ruleAssignmentAction"
    // InternalBehaviorAnnexParser.g:1982:1: ruleAssignmentAction returns [EObject current=null] : ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) ) ;
    public final EObject ruleAssignmentAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_any_3_0=null;
        EObject lv_target_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1988:2: ( ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) ) )
            // InternalBehaviorAnnexParser.g:1989:2: ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) )
            {
            // InternalBehaviorAnnexParser.g:1989:2: ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) )
            // InternalBehaviorAnnexParser.g:1990:3: ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) )
            {
            // InternalBehaviorAnnexParser.g:1990:3: ( (lv_target_0_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:1991:4: (lv_target_0_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:1991:4: (lv_target_0_0= ruleReference )
            // InternalBehaviorAnnexParser.g:1992:5: lv_target_0_0= ruleReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignmentActionAccess().getTargetReferenceParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_46);
            lv_target_0_0=ruleReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignmentActionRule());
              					}
              					set(
              						current,
              						"target",
              						lv_target_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,ColonEqualsSign,FollowSets000.FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAssignmentActionAccess().getColonEqualsSignKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:2013:3: ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==False||LA42_0==True||LA42_0==Abs||LA42_0==Not||LA42_0==NumberSign||LA42_0==LeftParenthesis||LA42_0==PlusSign||LA42_0==HyphenMinus||LA42_0==RULE_REAL_LIT||LA42_0==RULE_INTEGER_LIT||(LA42_0>=RULE_STRING && LA42_0<=RULE_ID)) ) {
                alt42=1;
            }
            else if ( (LA42_0==Any) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2014:4: ( (lv_value_2_0= ruleValueExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:2014:4: ( (lv_value_2_0= ruleValueExpression ) )
                    // InternalBehaviorAnnexParser.g:2015:5: (lv_value_2_0= ruleValueExpression )
                    {
                    // InternalBehaviorAnnexParser.g:2015:5: (lv_value_2_0= ruleValueExpression )
                    // InternalBehaviorAnnexParser.g:2016:6: lv_value_2_0= ruleValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentActionAccess().getValueValueExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_2_0=ruleValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentActionRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_2_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:2034:4: ( (lv_any_3_0= Any ) )
                    {
                    // InternalBehaviorAnnexParser.g:2034:4: ( (lv_any_3_0= Any ) )
                    // InternalBehaviorAnnexParser.g:2035:5: (lv_any_3_0= Any )
                    {
                    // InternalBehaviorAnnexParser.g:2035:5: (lv_any_3_0= Any )
                    // InternalBehaviorAnnexParser.g:2036:6: lv_any_3_0= Any
                    {
                    lv_any_3_0=(Token)match(input,Any,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_any_3_0, grammarAccess.getAssignmentActionAccess().getAnyAnyKeyword_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentActionRule());
                      						}
                      						setWithLastConsumed(current, "any", lv_any_3_0 != null, "any");
                      					
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
    // $ANTLR end "ruleAssignmentAction"


    // $ANTLR start "entryRuleCommunicationAction"
    // InternalBehaviorAnnexParser.g:2053:1: entryRuleCommunicationAction returns [EObject current=null] : iv_ruleCommunicationAction= ruleCommunicationAction EOF ;
    public final EObject entryRuleCommunicationAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommunicationAction = null;


        try {
            // InternalBehaviorAnnexParser.g:2053:60: (iv_ruleCommunicationAction= ruleCommunicationAction EOF )
            // InternalBehaviorAnnexParser.g:2054:2: iv_ruleCommunicationAction= ruleCommunicationAction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCommunicationActionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCommunicationAction=ruleCommunicationAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCommunicationAction; 
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
    // $ANTLR end "entryRuleCommunicationAction"


    // $ANTLR start "ruleCommunicationAction"
    // InternalBehaviorAnnexParser.g:2060:1: ruleCommunicationAction returns [EObject current=null] : ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) ) ;
    public final EObject ruleCommunicationAction() throws RecognitionException {
        EObject current = null;

        Token lv_send_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_dequeue_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_freeze_11_0=null;
        Token lv_lock_12_0=null;
        Token lv_unlock_13_0=null;
        Token lv_all_14_0=null;
        Token lv_allLock_15_0=null;
        Token lv_allUnlock_16_0=null;
        EObject lv_reference_0_0 = null;

        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_target_9_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2066:2: ( ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) ) )
            // InternalBehaviorAnnexParser.g:2067:2: ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) )
            {
            // InternalBehaviorAnnexParser.g:2067:2: ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                alt48=1;
            }
            else if ( (LA48_0==Asterisk) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2068:3: ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:2068:3: ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) )
                    // InternalBehaviorAnnexParser.g:2069:4: ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:2069:4: ( (lv_reference_0_0= ruleReference ) )
                    // InternalBehaviorAnnexParser.g:2070:5: (lv_reference_0_0= ruleReference )
                    {
                    // InternalBehaviorAnnexParser.g:2070:5: (lv_reference_0_0= ruleReference )
                    // InternalBehaviorAnnexParser.g:2071:6: lv_reference_0_0= ruleReference
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCommunicationActionAccess().getReferenceReferenceParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_48);
                    lv_reference_0_0=ruleReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCommunicationActionRule());
                      						}
                      						set(
                      							current,
                      							"reference",
                      							lv_reference_0_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:2088:4: ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) )
                    int alt46=5;
                    switch ( input.LA(1) ) {
                    case ExclamationMark:
                        {
                        alt46=1;
                        }
                        break;
                    case QuestionMark:
                        {
                        alt46=2;
                        }
                        break;
                    case GreaterThanSignGreaterThanSign:
                        {
                        alt46=3;
                        }
                        break;
                    case ExclamationMarkLessThanSign:
                        {
                        alt46=4;
                        }
                        break;
                    case ExclamationMarkGreaterThanSign:
                        {
                        alt46=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }

                    switch (alt46) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:2089:5: ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? )
                            {
                            // InternalBehaviorAnnexParser.g:2089:5: ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? )
                            // InternalBehaviorAnnexParser.g:2090:6: ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )?
                            {
                            // InternalBehaviorAnnexParser.g:2090:6: ( (lv_send_1_0= ExclamationMark ) )
                            // InternalBehaviorAnnexParser.g:2091:7: (lv_send_1_0= ExclamationMark )
                            {
                            // InternalBehaviorAnnexParser.g:2091:7: (lv_send_1_0= ExclamationMark )
                            // InternalBehaviorAnnexParser.g:2092:8: lv_send_1_0= ExclamationMark
                            {
                            lv_send_1_0=(Token)match(input,ExclamationMark,FollowSets000.FOLLOW_49); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_send_1_0, grammarAccess.getCommunicationActionAccess().getSendExclamationMarkKeyword_0_1_0_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getCommunicationActionRule());
                              								}
                              								setWithLastConsumed(current, "send", lv_send_1_0 != null, "!");
                              							
                            }

                            }


                            }

                            // InternalBehaviorAnnexParser.g:2104:6: (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )?
                            int alt44=2;
                            int LA44_0 = input.LA(1);

                            if ( (LA44_0==LeftParenthesis) ) {
                                alt44=1;
                            }
                            switch (alt44) {
                                case 1 :
                                    // InternalBehaviorAnnexParser.g:2105:7: otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis
                                    {
                                    otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_50); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_2, grammarAccess.getCommunicationActionAccess().getLeftParenthesisKeyword_0_1_0_1_0());
                                      						
                                    }
                                    // InternalBehaviorAnnexParser.g:2109:7: ( (lv_parameters_3_0= ruleValueExpression ) )
                                    // InternalBehaviorAnnexParser.g:2110:8: (lv_parameters_3_0= ruleValueExpression )
                                    {
                                    // InternalBehaviorAnnexParser.g:2110:8: (lv_parameters_3_0= ruleValueExpression )
                                    // InternalBehaviorAnnexParser.g:2111:9: lv_parameters_3_0= ruleValueExpression
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getCommunicationActionAccess().getParametersValueExpressionParserRuleCall_0_1_0_1_1_0());
                                      								
                                    }
                                    pushFollow(FollowSets000.FOLLOW_32);
                                    lv_parameters_3_0=ruleValueExpression();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getCommunicationActionRule());
                                      									}
                                      									add(
                                      										current,
                                      										"parameters",
                                      										lv_parameters_3_0,
                                      										"org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                                      									afterParserOrEnumRuleCall();
                                      								
                                    }

                                    }


                                    }

                                    // InternalBehaviorAnnexParser.g:2128:7: (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )*
                                    loop43:
                                    do {
                                        int alt43=2;
                                        int LA43_0 = input.LA(1);

                                        if ( (LA43_0==Comma) ) {
                                            alt43=1;
                                        }


                                        switch (alt43) {
                                    	case 1 :
                                    	    // InternalBehaviorAnnexParser.g:2129:8: otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) )
                                    	    {
                                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_50); if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	      								newLeafNode(otherlv_4, grammarAccess.getCommunicationActionAccess().getCommaKeyword_0_1_0_1_2_0());
                                    	      							
                                    	    }
                                    	    // InternalBehaviorAnnexParser.g:2133:8: ( (lv_parameters_5_0= ruleValueExpression ) )
                                    	    // InternalBehaviorAnnexParser.g:2134:9: (lv_parameters_5_0= ruleValueExpression )
                                    	    {
                                    	    // InternalBehaviorAnnexParser.g:2134:9: (lv_parameters_5_0= ruleValueExpression )
                                    	    // InternalBehaviorAnnexParser.g:2135:10: lv_parameters_5_0= ruleValueExpression
                                    	    {
                                    	    if ( state.backtracking==0 ) {

                                    	      										newCompositeNode(grammarAccess.getCommunicationActionAccess().getParametersValueExpressionParserRuleCall_0_1_0_1_2_1_0());
                                    	      									
                                    	    }
                                    	    pushFollow(FollowSets000.FOLLOW_32);
                                    	    lv_parameters_5_0=ruleValueExpression();

                                    	    state._fsp--;
                                    	    if (state.failed) return current;
                                    	    if ( state.backtracking==0 ) {

                                    	      										if (current==null) {
                                    	      											current = createModelElementForParent(grammarAccess.getCommunicationActionRule());
                                    	      										}
                                    	      										add(
                                    	      											current,
                                    	      											"parameters",
                                    	      											lv_parameters_5_0,
                                    	      											"org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                                    	      										afterParserOrEnumRuleCall();
                                    	      									
                                    	    }

                                    	    }


                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop43;
                                        }
                                    } while (true);

                                    otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_6, grammarAccess.getCommunicationActionAccess().getRightParenthesisKeyword_0_1_0_1_3());
                                      						
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBehaviorAnnexParser.g:2160:5: ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? )
                            {
                            // InternalBehaviorAnnexParser.g:2160:5: ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? )
                            // InternalBehaviorAnnexParser.g:2161:6: ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )?
                            {
                            // InternalBehaviorAnnexParser.g:2161:6: ( (lv_dequeue_7_0= QuestionMark ) )
                            // InternalBehaviorAnnexParser.g:2162:7: (lv_dequeue_7_0= QuestionMark )
                            {
                            // InternalBehaviorAnnexParser.g:2162:7: (lv_dequeue_7_0= QuestionMark )
                            // InternalBehaviorAnnexParser.g:2163:8: lv_dequeue_7_0= QuestionMark
                            {
                            lv_dequeue_7_0=(Token)match(input,QuestionMark,FollowSets000.FOLLOW_49); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_dequeue_7_0, grammarAccess.getCommunicationActionAccess().getDequeueQuestionMarkKeyword_0_1_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getCommunicationActionRule());
                              								}
                              								setWithLastConsumed(current, "dequeue", lv_dequeue_7_0 != null, "?");
                              							
                            }

                            }


                            }

                            // InternalBehaviorAnnexParser.g:2175:6: (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )?
                            int alt45=2;
                            int LA45_0 = input.LA(1);

                            if ( (LA45_0==LeftParenthesis) ) {
                                alt45=1;
                            }
                            switch (alt45) {
                                case 1 :
                                    // InternalBehaviorAnnexParser.g:2176:7: otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis
                                    {
                                    otherlv_8=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_8, grammarAccess.getCommunicationActionAccess().getLeftParenthesisKeyword_0_1_1_1_0());
                                      						
                                    }
                                    // InternalBehaviorAnnexParser.g:2180:7: ( (lv_target_9_0= ruleReference ) )
                                    // InternalBehaviorAnnexParser.g:2181:8: (lv_target_9_0= ruleReference )
                                    {
                                    // InternalBehaviorAnnexParser.g:2181:8: (lv_target_9_0= ruleReference )
                                    // InternalBehaviorAnnexParser.g:2182:9: lv_target_9_0= ruleReference
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getCommunicationActionAccess().getTargetReferenceParserRuleCall_0_1_1_1_1_0());
                                      								
                                    }
                                    pushFollow(FollowSets000.FOLLOW_39);
                                    lv_target_9_0=ruleReference();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getCommunicationActionRule());
                                      									}
                                      									set(
                                      										current,
                                      										"target",
                                      										lv_target_9_0,
                                      										"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                                      									afterParserOrEnumRuleCall();
                                      								
                                    }

                                    }


                                    }

                                    otherlv_10=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_10, grammarAccess.getCommunicationActionAccess().getRightParenthesisKeyword_0_1_1_1_2());
                                      						
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalBehaviorAnnexParser.g:2206:5: ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2206:5: ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) )
                            // InternalBehaviorAnnexParser.g:2207:6: (lv_freeze_11_0= GreaterThanSignGreaterThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2207:6: (lv_freeze_11_0= GreaterThanSignGreaterThanSign )
                            // InternalBehaviorAnnexParser.g:2208:7: lv_freeze_11_0= GreaterThanSignGreaterThanSign
                            {
                            lv_freeze_11_0=(Token)match(input,GreaterThanSignGreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_freeze_11_0, grammarAccess.getCommunicationActionAccess().getFreezeGreaterThanSignGreaterThanSignKeyword_0_1_2_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getCommunicationActionRule());
                              							}
                              							setWithLastConsumed(current, "freeze", lv_freeze_11_0 != null, ">>");
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 4 :
                            // InternalBehaviorAnnexParser.g:2221:5: ( (lv_lock_12_0= ExclamationMarkLessThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2221:5: ( (lv_lock_12_0= ExclamationMarkLessThanSign ) )
                            // InternalBehaviorAnnexParser.g:2222:6: (lv_lock_12_0= ExclamationMarkLessThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2222:6: (lv_lock_12_0= ExclamationMarkLessThanSign )
                            // InternalBehaviorAnnexParser.g:2223:7: lv_lock_12_0= ExclamationMarkLessThanSign
                            {
                            lv_lock_12_0=(Token)match(input,ExclamationMarkLessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_lock_12_0, grammarAccess.getCommunicationActionAccess().getLockExclamationMarkLessThanSignKeyword_0_1_3_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getCommunicationActionRule());
                              							}
                              							setWithLastConsumed(current, "lock", lv_lock_12_0 != null, "!<");
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 5 :
                            // InternalBehaviorAnnexParser.g:2236:5: ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2236:5: ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) )
                            // InternalBehaviorAnnexParser.g:2237:6: (lv_unlock_13_0= ExclamationMarkGreaterThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2237:6: (lv_unlock_13_0= ExclamationMarkGreaterThanSign )
                            // InternalBehaviorAnnexParser.g:2238:7: lv_unlock_13_0= ExclamationMarkGreaterThanSign
                            {
                            lv_unlock_13_0=(Token)match(input,ExclamationMarkGreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_unlock_13_0, grammarAccess.getCommunicationActionAccess().getUnlockExclamationMarkGreaterThanSignKeyword_0_1_4_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getCommunicationActionRule());
                              							}
                              							setWithLastConsumed(current, "unlock", lv_unlock_13_0 != null, "!>");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:2253:3: ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:2253:3: ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) )
                    // InternalBehaviorAnnexParser.g:2254:4: ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:2254:4: ( (lv_all_14_0= Asterisk ) )
                    // InternalBehaviorAnnexParser.g:2255:5: (lv_all_14_0= Asterisk )
                    {
                    // InternalBehaviorAnnexParser.g:2255:5: (lv_all_14_0= Asterisk )
                    // InternalBehaviorAnnexParser.g:2256:6: lv_all_14_0= Asterisk
                    {
                    lv_all_14_0=(Token)match(input,Asterisk,FollowSets000.FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_all_14_0, grammarAccess.getCommunicationActionAccess().getAllAsteriskKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCommunicationActionRule());
                      						}
                      						setWithLastConsumed(current, "all", lv_all_14_0 != null, "*");
                      					
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:2268:4: ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==ExclamationMarkLessThanSign) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==ExclamationMarkGreaterThanSign) ) {
                        alt47=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:2269:5: ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2269:5: ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) )
                            // InternalBehaviorAnnexParser.g:2270:6: (lv_allLock_15_0= ExclamationMarkLessThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2270:6: (lv_allLock_15_0= ExclamationMarkLessThanSign )
                            // InternalBehaviorAnnexParser.g:2271:7: lv_allLock_15_0= ExclamationMarkLessThanSign
                            {
                            lv_allLock_15_0=(Token)match(input,ExclamationMarkLessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_allLock_15_0, grammarAccess.getCommunicationActionAccess().getAllLockExclamationMarkLessThanSignKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getCommunicationActionRule());
                              							}
                              							setWithLastConsumed(current, "allLock", lv_allLock_15_0 != null, "!<");
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBehaviorAnnexParser.g:2284:5: ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2284:5: ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) )
                            // InternalBehaviorAnnexParser.g:2285:6: (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2285:6: (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign )
                            // InternalBehaviorAnnexParser.g:2286:7: lv_allUnlock_16_0= ExclamationMarkGreaterThanSign
                            {
                            lv_allUnlock_16_0=(Token)match(input,ExclamationMarkGreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_allUnlock_16_0, grammarAccess.getCommunicationActionAccess().getAllUnlockExclamationMarkGreaterThanSignKeyword_1_1_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getCommunicationActionRule());
                              							}
                              							setWithLastConsumed(current, "allUnlock", lv_allUnlock_16_0 != null, "!>");
                              						
                            }

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleCommunicationAction"


    // $ANTLR start "entryRuleTimedAction"
    // InternalBehaviorAnnexParser.g:2304:1: entryRuleTimedAction returns [EObject current=null] : iv_ruleTimedAction= ruleTimedAction EOF ;
    public final EObject entryRuleTimedAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimedAction = null;


        try {
            // InternalBehaviorAnnexParser.g:2304:52: (iv_ruleTimedAction= ruleTimedAction EOF )
            // InternalBehaviorAnnexParser.g:2305:2: iv_ruleTimedAction= ruleTimedAction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimedActionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTimedAction=ruleTimedAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTimedAction; 
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
    // $ANTLR end "entryRuleTimedAction"


    // $ANTLR start "ruleTimedAction"
    // InternalBehaviorAnnexParser.g:2311:1: ruleTimedAction returns [EObject current=null] : (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? ) ;
    public final EObject ruleTimedAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_lowerTime_2_0 = null;

        EObject lv_upperTime_4_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2317:2: ( (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? ) )
            // InternalBehaviorAnnexParser.g:2318:2: (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? )
            {
            // InternalBehaviorAnnexParser.g:2318:2: (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? )
            // InternalBehaviorAnnexParser.g:2319:3: otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )?
            {
            otherlv_0=(Token)match(input,Computation,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTimedActionAccess().getComputationKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTimedActionAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:2327:3: ( (lv_lowerTime_2_0= ruleBehaviorTime ) )
            // InternalBehaviorAnnexParser.g:2328:4: (lv_lowerTime_2_0= ruleBehaviorTime )
            {
            // InternalBehaviorAnnexParser.g:2328:4: (lv_lowerTime_2_0= ruleBehaviorTime )
            // InternalBehaviorAnnexParser.g:2329:5: lv_lowerTime_2_0= ruleBehaviorTime
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTimedActionAccess().getLowerTimeBehaviorTimeParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_52);
            lv_lowerTime_2_0=ruleBehaviorTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTimedActionRule());
              					}
              					set(
              						current,
              						"lowerTime",
              						lv_lowerTime_2_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTime");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:2346:3: (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==FullStopFullStop) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2347:4: otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getTimedActionAccess().getFullStopFullStopKeyword_3_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:2351:4: ( (lv_upperTime_4_0= ruleBehaviorTime ) )
                    // InternalBehaviorAnnexParser.g:2352:5: (lv_upperTime_4_0= ruleBehaviorTime )
                    {
                    // InternalBehaviorAnnexParser.g:2352:5: (lv_upperTime_4_0= ruleBehaviorTime )
                    // InternalBehaviorAnnexParser.g:2353:6: lv_upperTime_4_0= ruleBehaviorTime
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTimedActionAccess().getUpperTimeBehaviorTimeParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_39);
                    lv_upperTime_4_0=ruleBehaviorTime();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTimedActionRule());
                      						}
                      						set(
                      							current,
                      							"upperTime",
                      							lv_upperTime_4_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTime");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_53); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getTimedActionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalBehaviorAnnexParser.g:2375:3: (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==In) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2376:4: otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis
                    {
                    otherlv_6=(Token)match(input,In,FollowSets000.FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getTimedActionAccess().getInKeyword_5_0());
                      			
                    }
                    otherlv_7=(Token)match(input,Binding,FollowSets000.FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getTimedActionAccess().getBindingKeyword_5_1());
                      			
                    }
                    otherlv_8=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getTimedActionAccess().getLeftParenthesisKeyword_5_2());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:2388:4: ( ( ruleQCREF ) )
                    // InternalBehaviorAnnexParser.g:2389:5: ( ruleQCREF )
                    {
                    // InternalBehaviorAnnexParser.g:2389:5: ( ruleQCREF )
                    // InternalBehaviorAnnexParser.g:2390:6: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimedActionRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTimedActionAccess().getProcessorsComponentClassifierCrossReference_5_3_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_32);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:2404:4: (otherlv_10= Comma ( ( ruleQCREF ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==Comma) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalBehaviorAnnexParser.g:2405:5: otherlv_10= Comma ( ( ruleQCREF ) )
                    	    {
                    	    otherlv_10=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_10, grammarAccess.getTimedActionAccess().getCommaKeyword_5_4_0());
                    	      				
                    	    }
                    	    // InternalBehaviorAnnexParser.g:2409:5: ( ( ruleQCREF ) )
                    	    // InternalBehaviorAnnexParser.g:2410:6: ( ruleQCREF )
                    	    {
                    	    // InternalBehaviorAnnexParser.g:2410:6: ( ruleQCREF )
                    	    // InternalBehaviorAnnexParser.g:2411:7: ruleQCREF
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getTimedActionRule());
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getTimedActionAccess().getProcessorsComponentClassifierCrossReference_5_4_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_32);
                    	    ruleQCREF();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getTimedActionAccess().getRightParenthesisKeyword_5_5());
                      			
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
    // $ANTLR end "ruleTimedAction"


    // $ANTLR start "entryRuleIfStatement"
    // InternalBehaviorAnnexParser.g:2435:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2435:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalBehaviorAnnexParser.g:2436:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfStatement; 
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
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // InternalBehaviorAnnexParser.g:2442:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_condition_2_0 = null;

        EObject lv_thenActions_4_0 = null;

        EObject lv_elseIfs_5_0 = null;

        EObject lv_elseActions_7_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2448:2: ( (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If ) )
            // InternalBehaviorAnnexParser.g:2449:2: (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If )
            {
            // InternalBehaviorAnnexParser.g:2449:2: (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If )
            // InternalBehaviorAnnexParser.g:2450:3: otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If
            {
            otherlv_0=(Token)match(input,If,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:2458:3: ( (lv_condition_2_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2459:4: (lv_condition_2_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2459:4: (lv_condition_2_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2460:5: lv_condition_2_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getConditionValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_39);
            lv_condition_2_0=ruleValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_2_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalBehaviorAnnexParser.g:2481:3: ( (lv_thenActions_4_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2482:4: (lv_thenActions_4_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2482:4: (lv_thenActions_4_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2483:5: lv_thenActions_4_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getThenActionsBehaviorActionsParserRuleCall_4_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_55);
            lv_thenActions_4_0=ruleBehaviorActions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"thenActions",
              						lv_thenActions_4_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:2500:3: ( (lv_elseIfs_5_0= ruleElseIfClause ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==Elsif) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:2501:4: (lv_elseIfs_5_0= ruleElseIfClause )
            	    {
            	    // InternalBehaviorAnnexParser.g:2501:4: (lv_elseIfs_5_0= ruleElseIfClause )
            	    // InternalBehaviorAnnexParser.g:2502:5: lv_elseIfs_5_0= ruleElseIfClause
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfsElseIfClauseParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_55);
            	    lv_elseIfs_5_0=ruleElseIfClause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"elseIfs",
            	      						lv_elseIfs_5_0,
            	      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ElseIfClause");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            // InternalBehaviorAnnexParser.g:2519:3: (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==Else) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2520:4: otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) )
                    {
                    otherlv_6=(Token)match(input,Else,FollowSets000.FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getElseKeyword_6_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:2524:4: ( (lv_elseActions_7_0= ruleBehaviorActions ) )
                    // InternalBehaviorAnnexParser.g:2525:5: (lv_elseActions_7_0= ruleBehaviorActions )
                    {
                    // InternalBehaviorAnnexParser.g:2525:5: (lv_elseActions_7_0= ruleBehaviorActions )
                    // InternalBehaviorAnnexParser.g:2526:6: lv_elseActions_7_0= ruleBehaviorActions
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfStatementAccess().getElseActionsBehaviorActionsParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_56);
                    lv_elseActions_7_0=ruleBehaviorActions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfStatementRule());
                      						}
                      						set(
                      							current,
                      							"elseActions",
                      							lv_elseActions_7_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,End,FollowSets000.FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getIfStatementAccess().getEndKeyword_7());
              		
            }
            otherlv_9=(Token)match(input,If,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getIfStatementAccess().getIfKeyword_8());
              		
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
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleElseIfClause"
    // InternalBehaviorAnnexParser.g:2556:1: entryRuleElseIfClause returns [EObject current=null] : iv_ruleElseIfClause= ruleElseIfClause EOF ;
    public final EObject entryRuleElseIfClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfClause = null;


        try {
            // InternalBehaviorAnnexParser.g:2556:53: (iv_ruleElseIfClause= ruleElseIfClause EOF )
            // InternalBehaviorAnnexParser.g:2557:2: iv_ruleElseIfClause= ruleElseIfClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseIfClauseRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElseIfClause=ruleElseIfClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseIfClause; 
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
    // $ANTLR end "entryRuleElseIfClause"


    // $ANTLR start "ruleElseIfClause"
    // InternalBehaviorAnnexParser.g:2563:1: ruleElseIfClause returns [EObject current=null] : (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) ) ;
    public final EObject ruleElseIfClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_actions_4_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2569:2: ( (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) ) )
            // InternalBehaviorAnnexParser.g:2570:2: (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) )
            {
            // InternalBehaviorAnnexParser.g:2570:2: (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) )
            // InternalBehaviorAnnexParser.g:2571:3: otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) )
            {
            otherlv_0=(Token)match(input,Elsif,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getElseIfClauseAccess().getElsifKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getElseIfClauseAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:2579:3: ( (lv_condition_2_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2580:4: (lv_condition_2_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2580:4: (lv_condition_2_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2581:5: lv_condition_2_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getElseIfClauseAccess().getConditionValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_39);
            lv_condition_2_0=ruleValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getElseIfClauseRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_2_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getElseIfClauseAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalBehaviorAnnexParser.g:2602:3: ( (lv_actions_4_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2603:4: (lv_actions_4_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2603:4: (lv_actions_4_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2604:5: lv_actions_4_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getElseIfClauseAccess().getActionsBehaviorActionsParserRuleCall_4_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_actions_4_0=ruleBehaviorActions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getElseIfClauseRule());
              					}
              					set(
              						current,
              						"actions",
              						lv_actions_4_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
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
    // $ANTLR end "ruleElseIfClause"


    // $ANTLR start "entryRuleForStatement"
    // InternalBehaviorAnnexParser.g:2625:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2625:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalBehaviorAnnexParser.g:2626:2: iv_ruleForStatement= ruleForStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleForStatement=ruleForStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForStatement; 
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
    // $ANTLR end "entryRuleForStatement"


    // $ANTLR start "ruleForStatement"
    // InternalBehaviorAnnexParser.g:2632:1: ruleForStatement returns [EObject current=null] : ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) (otherlv_4= Colon ( ( ruleQCREF ) ) )? otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket ) ;
    public final EObject ruleForStatement() throws RecognitionException {
        EObject current = null;

        Token lv_for_0_0=null;
        Token lv_forall_1_0=null;
        Token otherlv_2=null;
        Token lv_variable_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_values_7_0 = null;

        EObject lv_actions_10_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2638:2: ( ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) (otherlv_4= Colon ( ( ruleQCREF ) ) )? otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket ) )
            // InternalBehaviorAnnexParser.g:2639:2: ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) (otherlv_4= Colon ( ( ruleQCREF ) ) )? otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket )
            {
            // InternalBehaviorAnnexParser.g:2639:2: ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) (otherlv_4= Colon ( ( ruleQCREF ) ) )? otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket )
            // InternalBehaviorAnnexParser.g:2640:3: ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) (otherlv_4= Colon ( ( ruleQCREF ) ) )? otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket
            {
            // InternalBehaviorAnnexParser.g:2640:3: ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==For) ) {
                alt54=1;
            }
            else if ( (LA54_0==Forall) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2641:4: ( (lv_for_0_0= For ) )
                    {
                    // InternalBehaviorAnnexParser.g:2641:4: ( (lv_for_0_0= For ) )
                    // InternalBehaviorAnnexParser.g:2642:5: (lv_for_0_0= For )
                    {
                    // InternalBehaviorAnnexParser.g:2642:5: (lv_for_0_0= For )
                    // InternalBehaviorAnnexParser.g:2643:6: lv_for_0_0= For
                    {
                    lv_for_0_0=(Token)match(input,For,FollowSets000.FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_for_0_0, grammarAccess.getForStatementAccess().getForForKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getForStatementRule());
                      						}
                      						setWithLastConsumed(current, "for", lv_for_0_0 != null, "for");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:2656:4: ( (lv_forall_1_0= Forall ) )
                    {
                    // InternalBehaviorAnnexParser.g:2656:4: ( (lv_forall_1_0= Forall ) )
                    // InternalBehaviorAnnexParser.g:2657:5: (lv_forall_1_0= Forall )
                    {
                    // InternalBehaviorAnnexParser.g:2657:5: (lv_forall_1_0= Forall )
                    // InternalBehaviorAnnexParser.g:2658:6: lv_forall_1_0= Forall
                    {
                    lv_forall_1_0=(Token)match(input,Forall,FollowSets000.FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_forall_1_0, grammarAccess.getForStatementAccess().getForallForallKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getForStatementRule());
                      						}
                      						setWithLastConsumed(current, "forall", lv_forall_1_0 != null, "forall");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:2675:3: ( (lv_variable_3_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:2676:4: (lv_variable_3_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:2676:4: (lv_variable_3_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:2677:5: lv_variable_3_0= RULE_ID
            {
            lv_variable_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_variable_3_0, grammarAccess.getForStatementAccess().getVariableIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getForStatementRule());
              					}
              					setWithLastConsumed(
              						current,
              						"variable",
              						lv_variable_3_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:2693:3: (otherlv_4= Colon ( ( ruleQCREF ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==Colon) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2694:4: otherlv_4= Colon ( ( ruleQCREF ) )
                    {
                    otherlv_4=(Token)match(input,Colon,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getForStatementAccess().getColonKeyword_3_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:2698:4: ( ( ruleQCREF ) )
                    // InternalBehaviorAnnexParser.g:2699:5: ( ruleQCREF )
                    {
                    // InternalBehaviorAnnexParser.g:2699:5: ( ruleQCREF )
                    // InternalBehaviorAnnexParser.g:2700:6: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getForStatementRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getForStatementAccess().getDataClassifierComponentClassifierCrossReference_3_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_59);
                    ruleQCREF();

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

            otherlv_6=(Token)match(input,In,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getForStatementAccess().getInKeyword_4());
              		
            }
            // InternalBehaviorAnnexParser.g:2719:3: ( (lv_values_7_0= ruleElementValues ) )
            // InternalBehaviorAnnexParser.g:2720:4: (lv_values_7_0= ruleElementValues )
            {
            // InternalBehaviorAnnexParser.g:2720:4: (lv_values_7_0= ruleElementValues )
            // InternalBehaviorAnnexParser.g:2721:5: lv_values_7_0= ruleElementValues
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementAccess().getValuesElementValuesParserRuleCall_5_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_39);
            lv_values_7_0=ruleElementValues();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRule());
              					}
              					set(
              						current,
              						"values",
              						lv_values_7_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ElementValues");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_8=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_6());
              		
            }
            otherlv_9=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getForStatementAccess().getLeftCurlyBracketKeyword_7());
              		
            }
            // InternalBehaviorAnnexParser.g:2746:3: ( (lv_actions_10_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2747:4: (lv_actions_10_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2747:4: (lv_actions_10_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2748:5: lv_actions_10_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForStatementAccess().getActionsBehaviorActionsParserRuleCall_8_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_41);
            lv_actions_10_0=ruleBehaviorActions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForStatementRule());
              					}
              					set(
              						current,
              						"actions",
              						lv_actions_10_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_11=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getForStatementAccess().getRightCurlyBracketKeyword_9());
              		
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
    // $ANTLR end "ruleForStatement"


    // $ANTLR start "entryRuleWhileStatement"
    // InternalBehaviorAnnexParser.g:2773:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2773:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalBehaviorAnnexParser.g:2774:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhileStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhileStatement; 
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
    // $ANTLR end "entryRuleWhileStatement"


    // $ANTLR start "ruleWhileStatement"
    // InternalBehaviorAnnexParser.g:2780:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_condition_2_0 = null;

        EObject lv_actions_5_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2786:2: ( (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket ) )
            // InternalBehaviorAnnexParser.g:2787:2: (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket )
            {
            // InternalBehaviorAnnexParser.g:2787:2: (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket )
            // InternalBehaviorAnnexParser.g:2788:3: otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket
            {
            otherlv_0=(Token)match(input,While,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:2796:3: ( (lv_condition_2_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2797:4: (lv_condition_2_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2797:4: (lv_condition_2_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2798:5: lv_condition_2_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_39);
            lv_condition_2_0=ruleValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWhileStatementRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_2_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getWhileStatementAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalBehaviorAnnexParser.g:2823:3: ( (lv_actions_5_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2824:4: (lv_actions_5_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2824:4: (lv_actions_5_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2825:5: lv_actions_5_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWhileStatementAccess().getActionsBehaviorActionsParserRuleCall_5_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_41);
            lv_actions_5_0=ruleBehaviorActions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWhileStatementRule());
              					}
              					set(
              						current,
              						"actions",
              						lv_actions_5_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getWhileStatementAccess().getRightCurlyBracketKeyword_6());
              		
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
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleDoUntilStatement"
    // InternalBehaviorAnnexParser.g:2850:1: entryRuleDoUntilStatement returns [EObject current=null] : iv_ruleDoUntilStatement= ruleDoUntilStatement EOF ;
    public final EObject entryRuleDoUntilStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoUntilStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2850:57: (iv_ruleDoUntilStatement= ruleDoUntilStatement EOF )
            // InternalBehaviorAnnexParser.g:2851:2: iv_ruleDoUntilStatement= ruleDoUntilStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDoUntilStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDoUntilStatement=ruleDoUntilStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDoUntilStatement; 
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
    // $ANTLR end "entryRuleDoUntilStatement"


    // $ANTLR start "ruleDoUntilStatement"
    // InternalBehaviorAnnexParser.g:2857:1: ruleDoUntilStatement returns [EObject current=null] : (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis ) ;
    public final EObject ruleDoUntilStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_actions_1_0 = null;

        EObject lv_condition_4_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2863:2: ( (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:2864:2: (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:2864:2: (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis )
            // InternalBehaviorAnnexParser.g:2865:3: otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis
            {
            otherlv_0=(Token)match(input,Do,FollowSets000.FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDoUntilStatementAccess().getDoKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:2869:3: ( (lv_actions_1_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2870:4: (lv_actions_1_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2870:4: (lv_actions_1_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2871:5: lv_actions_1_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDoUntilStatementAccess().getActionsBehaviorActionsParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_61);
            lv_actions_1_0=ruleBehaviorActions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDoUntilStatementRule());
              					}
              					set(
              						current,
              						"actions",
              						lv_actions_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Until,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDoUntilStatementAccess().getUntilKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getDoUntilStatementAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalBehaviorAnnexParser.g:2896:3: ( (lv_condition_4_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2897:4: (lv_condition_4_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2897:4: (lv_condition_4_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2898:5: lv_condition_4_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDoUntilStatementAccess().getConditionValueExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_39);
            lv_condition_4_0=ruleValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDoUntilStatementRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_4_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getDoUntilStatementAccess().getRightParenthesisKeyword_5());
              		
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
    // $ANTLR end "ruleDoUntilStatement"


    // $ANTLR start "entryRuleElementValues"
    // InternalBehaviorAnnexParser.g:2923:1: entryRuleElementValues returns [EObject current=null] : iv_ruleElementValues= ruleElementValues EOF ;
    public final EObject entryRuleElementValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementValues = null;


        try {
            // InternalBehaviorAnnexParser.g:2923:54: (iv_ruleElementValues= ruleElementValues EOF )
            // InternalBehaviorAnnexParser.g:2924:2: iv_ruleElementValues= ruleElementValues EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementValuesRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElementValues=ruleElementValues();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElementValues; 
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
    // $ANTLR end "entryRuleElementValues"


    // $ANTLR start "ruleElementValues"
    // InternalBehaviorAnnexParser.g:2930:1: ruleElementValues returns [EObject current=null] : ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? ) ;
    public final EObject ruleElementValues() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_lower_0_0 = null;

        EObject lv_upper_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2936:2: ( ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? ) )
            // InternalBehaviorAnnexParser.g:2937:2: ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:2937:2: ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? )
            // InternalBehaviorAnnexParser.g:2938:3: ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )?
            {
            // InternalBehaviorAnnexParser.g:2938:3: ( (lv_lower_0_0= ruleIntegerValue ) )
            // InternalBehaviorAnnexParser.g:2939:4: (lv_lower_0_0= ruleIntegerValue )
            {
            // InternalBehaviorAnnexParser.g:2939:4: (lv_lower_0_0= ruleIntegerValue )
            // InternalBehaviorAnnexParser.g:2940:5: lv_lower_0_0= ruleIntegerValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getElementValuesAccess().getLowerIntegerValueParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_62);
            lv_lower_0_0=ruleIntegerValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getElementValuesRule());
              					}
              					set(
              						current,
              						"lower",
              						lv_lower_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.IntegerValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:2957:3: (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==FullStopFullStop) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2958:4: otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) )
                    {
                    otherlv_1=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getElementValuesAccess().getFullStopFullStopKeyword_1_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:2962:4: ( (lv_upper_2_0= ruleIntegerValue ) )
                    // InternalBehaviorAnnexParser.g:2963:5: (lv_upper_2_0= ruleIntegerValue )
                    {
                    // InternalBehaviorAnnexParser.g:2963:5: (lv_upper_2_0= ruleIntegerValue )
                    // InternalBehaviorAnnexParser.g:2964:6: lv_upper_2_0= ruleIntegerValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getElementValuesAccess().getUpperIntegerValueParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_upper_2_0=ruleIntegerValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getElementValuesRule());
                      						}
                      						set(
                      							current,
                      							"upper",
                      							lv_upper_2_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.IntegerValue");
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
    // $ANTLR end "ruleElementValues"


    // $ANTLR start "entryRuleBehaviorTime"
    // InternalBehaviorAnnexParser.g:2986:1: entryRuleBehaviorTime returns [EObject current=null] : iv_ruleBehaviorTime= ruleBehaviorTime EOF ;
    public final EObject entryRuleBehaviorTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorTime = null;


        try {
            // InternalBehaviorAnnexParser.g:2986:53: (iv_ruleBehaviorTime= ruleBehaviorTime EOF )
            // InternalBehaviorAnnexParser.g:2987:2: iv_ruleBehaviorTime= ruleBehaviorTime EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorTimeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorTime=ruleBehaviorTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorTime; 
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
    // $ANTLR end "entryRuleBehaviorTime"


    // $ANTLR start "ruleBehaviorTime"
    // InternalBehaviorAnnexParser.g:2993:1: ruleBehaviorTime returns [EObject current=null] : ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleBehaviorTime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2999:2: ( ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) ) )
            // InternalBehaviorAnnexParser.g:3000:2: ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalBehaviorAnnexParser.g:3000:2: ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) )
            // InternalBehaviorAnnexParser.g:3001:3: ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) )
            {
            // InternalBehaviorAnnexParser.g:3001:3: ( (lv_value_0_0= ruleIntegerValue ) )
            // InternalBehaviorAnnexParser.g:3002:4: (lv_value_0_0= ruleIntegerValue )
            {
            // InternalBehaviorAnnexParser.g:3002:4: (lv_value_0_0= ruleIntegerValue )
            // InternalBehaviorAnnexParser.g:3003:5: lv_value_0_0= ruleIntegerValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBehaviorTimeAccess().getValueIntegerValueParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_3);
            lv_value_0_0=ruleIntegerValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBehaviorTimeRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.IntegerValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:3020:3: ( (otherlv_1= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:3021:4: (otherlv_1= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:3021:4: (otherlv_1= RULE_ID )
            // InternalBehaviorAnnexParser.g:3022:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBehaviorTimeRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getBehaviorTimeAccess().getUnitUnitLiteralCrossReference_1_0());
              				
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
    // $ANTLR end "ruleBehaviorTime"


    // $ANTLR start "entryRuleIntegerValue"
    // InternalBehaviorAnnexParser.g:3037:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // InternalBehaviorAnnexParser.g:3037:53: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // InternalBehaviorAnnexParser.g:3038:2: iv_ruleIntegerValue= ruleIntegerValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIntegerValue=ruleIntegerValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerValue; 
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
    // $ANTLR end "entryRuleIntegerValue"


    // $ANTLR start "ruleIntegerValue"
    // InternalBehaviorAnnexParser.g:3044:1: ruleIntegerValue returns [EObject current=null] : (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject this_BehaviorIntegerLiteral_0 = null;

        EObject this_HashPropertyReference_1 = null;

        EObject this_ReferenceExpression_2 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3050:2: ( (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression ) )
            // InternalBehaviorAnnexParser.g:3051:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression )
            {
            // InternalBehaviorAnnexParser.g:3051:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression )
            int alt57=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGER_LIT:
                {
                alt57=1;
                }
                break;
            case NumberSign:
                {
                alt57=2;
                }
                break;
            case RULE_ID:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3052:3: this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getIntegerValueAccess().getBehaviorIntegerLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BehaviorIntegerLiteral_0=ruleBehaviorIntegerLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BehaviorIntegerLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3061:3: this_HashPropertyReference_1= ruleHashPropertyReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getIntegerValueAccess().getHashPropertyReferenceParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_HashPropertyReference_1=ruleHashPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HashPropertyReference_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBehaviorAnnexParser.g:3070:3: this_ReferenceExpression_2= ruleReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getIntegerValueAccess().getReferenceExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReferenceExpression_2=ruleReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ReferenceExpression_2;
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
    // $ANTLR end "ruleIntegerValue"


    // $ANTLR start "entryRuleValueExpression"
    // InternalBehaviorAnnexParser.g:3082:1: entryRuleValueExpression returns [EObject current=null] : iv_ruleValueExpression= ruleValueExpression EOF ;
    public final EObject entryRuleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3082:56: (iv_ruleValueExpression= ruleValueExpression EOF )
            // InternalBehaviorAnnexParser.g:3083:2: iv_ruleValueExpression= ruleValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueExpression=ruleValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueExpression; 
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
    // $ANTLR end "entryRuleValueExpression"


    // $ANTLR start "ruleValueExpression"
    // InternalBehaviorAnnexParser.g:3089:1: ruleValueExpression returns [EObject current=null] : (this_Relation_0= ruleRelation ( () ( (lv_operator_2_0= ruleLogicalOperator ) ) ( (lv_right_3_0= ruleRelation ) ) )* ) ;
    public final EObject ruleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Relation_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3095:2: ( (this_Relation_0= ruleRelation ( () ( (lv_operator_2_0= ruleLogicalOperator ) ) ( (lv_right_3_0= ruleRelation ) ) )* ) )
            // InternalBehaviorAnnexParser.g:3096:2: (this_Relation_0= ruleRelation ( () ( (lv_operator_2_0= ruleLogicalOperator ) ) ( (lv_right_3_0= ruleRelation ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:3096:2: (this_Relation_0= ruleRelation ( () ( (lv_operator_2_0= ruleLogicalOperator ) ) ( (lv_right_3_0= ruleRelation ) ) )* )
            // InternalBehaviorAnnexParser.g:3097:3: this_Relation_0= ruleRelation ( () ( (lv_operator_2_0= ruleLogicalOperator ) ) ( (lv_right_3_0= ruleRelation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getValueExpressionAccess().getRelationParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_63);
            this_Relation_0=ruleRelation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Relation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBehaviorAnnexParser.g:3105:3: ( () ( (lv_operator_2_0= ruleLogicalOperator ) ) ( (lv_right_3_0= ruleRelation ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==And||LA58_0==Xor||LA58_0==Or) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:3106:4: () ( (lv_operator_2_0= ruleLogicalOperator ) ) ( (lv_right_3_0= ruleRelation ) )
            	    {
            	    // InternalBehaviorAnnexParser.g:3106:4: ()
            	    // InternalBehaviorAnnexParser.g:3107:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getValueExpressionAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalBehaviorAnnexParser.g:3113:4: ( (lv_operator_2_0= ruleLogicalOperator ) )
            	    // InternalBehaviorAnnexParser.g:3114:5: (lv_operator_2_0= ruleLogicalOperator )
            	    {
            	    // InternalBehaviorAnnexParser.g:3114:5: (lv_operator_2_0= ruleLogicalOperator )
            	    // InternalBehaviorAnnexParser.g:3115:6: lv_operator_2_0= ruleLogicalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getValueExpressionAccess().getOperatorLogicalOperatorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_50);
            	    lv_operator_2_0=ruleLogicalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getValueExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operator",
            	      							lv_operator_2_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.LogicalOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalBehaviorAnnexParser.g:3132:4: ( (lv_right_3_0= ruleRelation ) )
            	    // InternalBehaviorAnnexParser.g:3133:5: (lv_right_3_0= ruleRelation )
            	    {
            	    // InternalBehaviorAnnexParser.g:3133:5: (lv_right_3_0= ruleRelation )
            	    // InternalBehaviorAnnexParser.g:3134:6: lv_right_3_0= ruleRelation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getValueExpressionAccess().getRightRelationParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_63);
            	    lv_right_3_0=ruleRelation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getValueExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.Relation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
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
    // $ANTLR end "ruleValueExpression"


    // $ANTLR start "entryRuleLogicalOperator"
    // InternalBehaviorAnnexParser.g:3156:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // InternalBehaviorAnnexParser.g:3156:55: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // InternalBehaviorAnnexParser.g:3157:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
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
    // $ANTLR end "entryRuleLogicalOperator"


    // $ANTLR start "ruleLogicalOperator"
    // InternalBehaviorAnnexParser.g:3163:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LogicalAndOperator_0= ruleLogicalAndOperator | this_LogicalOrOperator_1= ruleLogicalOrOperator ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_LogicalAndOperator_0 = null;

        AntlrDatatypeRuleToken this_LogicalOrOperator_1 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3169:2: ( (this_LogicalAndOperator_0= ruleLogicalAndOperator | this_LogicalOrOperator_1= ruleLogicalOrOperator ) )
            // InternalBehaviorAnnexParser.g:3170:2: (this_LogicalAndOperator_0= ruleLogicalAndOperator | this_LogicalOrOperator_1= ruleLogicalOrOperator )
            {
            // InternalBehaviorAnnexParser.g:3170:2: (this_LogicalAndOperator_0= ruleLogicalAndOperator | this_LogicalOrOperator_1= ruleLogicalOrOperator )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==And) ) {
                alt59=1;
            }
            else if ( (LA59_0==Xor||LA59_0==Or) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3171:3: this_LogicalAndOperator_0= ruleLogicalAndOperator
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLogicalOperatorAccess().getLogicalAndOperatorParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LogicalAndOperator_0=ruleLogicalAndOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_LogicalAndOperator_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3182:3: this_LogicalOrOperator_1= ruleLogicalOrOperator
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLogicalOperatorAccess().getLogicalOrOperatorParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LogicalOrOperator_1=ruleLogicalOrOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_LogicalOrOperator_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleLogicalOperator"


    // $ANTLR start "entryRuleLogicalOrOperator"
    // InternalBehaviorAnnexParser.g:3196:1: entryRuleLogicalOrOperator returns [String current=null] : iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF ;
    public final String entryRuleLogicalOrOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOrOperator = null;


        try {
            // InternalBehaviorAnnexParser.g:3196:57: (iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF )
            // InternalBehaviorAnnexParser.g:3197:2: iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLogicalOrOperator=ruleLogicalOrOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrOperator.getText(); 
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
    // $ANTLR end "entryRuleLogicalOrOperator"


    // $ANTLR start "ruleLogicalOrOperator"
    // InternalBehaviorAnnexParser.g:3203:1: ruleLogicalOrOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= Or (kw= Else )? ) | kw= Xor ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOrOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3209:2: ( ( (kw= Or (kw= Else )? ) | kw= Xor ) )
            // InternalBehaviorAnnexParser.g:3210:2: ( (kw= Or (kw= Else )? ) | kw= Xor )
            {
            // InternalBehaviorAnnexParser.g:3210:2: ( (kw= Or (kw= Else )? ) | kw= Xor )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==Or) ) {
                alt61=1;
            }
            else if ( (LA61_0==Xor) ) {
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
                    // InternalBehaviorAnnexParser.g:3211:3: (kw= Or (kw= Else )? )
                    {
                    // InternalBehaviorAnnexParser.g:3211:3: (kw= Or (kw= Else )? )
                    // InternalBehaviorAnnexParser.g:3212:4: kw= Or (kw= Else )?
                    {
                    kw=(Token)match(input,Or,FollowSets000.FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLogicalOrOperatorAccess().getOrKeyword_0_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:3217:4: (kw= Else )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==Else) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:3218:5: kw= Else
                            {
                            kw=(Token)match(input,Else,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getLogicalOrOperatorAccess().getElseKeyword_0_1());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3226:3: kw= Xor
                    {
                    kw=(Token)match(input,Xor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOrOperatorAccess().getXorKeyword_1());
                      		
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
    // $ANTLR end "ruleLogicalOrOperator"


    // $ANTLR start "entryRuleLogicalAndOperator"
    // InternalBehaviorAnnexParser.g:3235:1: entryRuleLogicalAndOperator returns [String current=null] : iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF ;
    public final String entryRuleLogicalAndOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalAndOperator = null;


        try {
            // InternalBehaviorAnnexParser.g:3235:58: (iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF )
            // InternalBehaviorAnnexParser.g:3236:2: iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLogicalAndOperator=ruleLogicalAndOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndOperator.getText(); 
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
    // $ANTLR end "entryRuleLogicalAndOperator"


    // $ANTLR start "ruleLogicalAndOperator"
    // InternalBehaviorAnnexParser.g:3242:1: ruleLogicalAndOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= And (kw= Then )? ) ;
    public final AntlrDatatypeRuleToken ruleLogicalAndOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3248:2: ( (kw= And (kw= Then )? ) )
            // InternalBehaviorAnnexParser.g:3249:2: (kw= And (kw= Then )? )
            {
            // InternalBehaviorAnnexParser.g:3249:2: (kw= And (kw= Then )? )
            // InternalBehaviorAnnexParser.g:3250:3: kw= And (kw= Then )?
            {
            kw=(Token)match(input,And,FollowSets000.FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getLogicalAndOperatorAccess().getAndKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:3255:3: (kw= Then )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==Then) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3256:4: kw= Then
                    {
                    kw=(Token)match(input,Then,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getLogicalAndOperatorAccess().getThenKeyword_1());
                      			
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
    // $ANTLR end "ruleLogicalAndOperator"


    // $ANTLR start "entryRuleRelation"
    // InternalBehaviorAnnexParser.g:3266:1: entryRuleRelation returns [EObject current=null] : iv_ruleRelation= ruleRelation EOF ;
    public final EObject entryRuleRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelation = null;


        try {
            // InternalBehaviorAnnexParser.g:3266:49: (iv_ruleRelation= ruleRelation EOF )
            // InternalBehaviorAnnexParser.g:3267:2: iv_ruleRelation= ruleRelation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelation=ruleRelation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelation; 
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
    // $ANTLR end "entryRuleRelation"


    // $ANTLR start "ruleRelation"
    // InternalBehaviorAnnexParser.g:3273:1: ruleRelation returns [EObject current=null] : (this_SimpleExpression_0= ruleSimpleExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_right_3_0= ruleSimpleExpression ) ) )? ) ;
    public final EObject ruleRelation() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3279:2: ( (this_SimpleExpression_0= ruleSimpleExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_right_3_0= ruleSimpleExpression ) ) )? ) )
            // InternalBehaviorAnnexParser.g:3280:2: (this_SimpleExpression_0= ruleSimpleExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_right_3_0= ruleSimpleExpression ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:3280:2: (this_SimpleExpression_0= ruleSimpleExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_right_3_0= ruleSimpleExpression ) ) )? )
            // InternalBehaviorAnnexParser.g:3281:3: this_SimpleExpression_0= ruleSimpleExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_right_3_0= ruleSimpleExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationAccess().getSimpleExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_66);
            this_SimpleExpression_0=ruleSimpleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_SimpleExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBehaviorAnnexParser.g:3289:3: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_right_3_0= ruleSimpleExpression ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==ExclamationMarkEqualsSign||LA63_0==LessThanSignEqualsSign||LA63_0==GreaterThanSignEqualsSign||(LA63_0>=LessThanSign && LA63_0<=GreaterThanSign)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3290:4: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_right_3_0= ruleSimpleExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3290:4: ()
                    // InternalBehaviorAnnexParser.g:3291:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getRelationAccess().getBinaryExpressionLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalBehaviorAnnexParser.g:3297:4: ( (lv_operator_2_0= ruleRelationalOperator ) )
                    // InternalBehaviorAnnexParser.g:3298:5: (lv_operator_2_0= ruleRelationalOperator )
                    {
                    // InternalBehaviorAnnexParser.g:3298:5: (lv_operator_2_0= ruleRelationalOperator )
                    // InternalBehaviorAnnexParser.g:3299:6: lv_operator_2_0= ruleRelationalOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationAccess().getOperatorRelationalOperatorParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_50);
                    lv_operator_2_0=ruleRelationalOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRelationRule());
                      						}
                      						set(
                      							current,
                      							"operator",
                      							lv_operator_2_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.RelationalOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:3316:4: ( (lv_right_3_0= ruleSimpleExpression ) )
                    // InternalBehaviorAnnexParser.g:3317:5: (lv_right_3_0= ruleSimpleExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3317:5: (lv_right_3_0= ruleSimpleExpression )
                    // InternalBehaviorAnnexParser.g:3318:6: lv_right_3_0= ruleSimpleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationAccess().getRightSimpleExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_right_3_0=ruleSimpleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRelationRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.SimpleExpression");
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
    // $ANTLR end "ruleRelation"


    // $ANTLR start "entryRuleRelationalOperator"
    // InternalBehaviorAnnexParser.g:3340:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // InternalBehaviorAnnexParser.g:3340:58: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalBehaviorAnnexParser.g:3341:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
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
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // InternalBehaviorAnnexParser.g:3347:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSign | kw= ExclamationMarkEqualsSign | kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3353:2: ( (kw= EqualsSign | kw= ExclamationMarkEqualsSign | kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign ) )
            // InternalBehaviorAnnexParser.g:3354:2: (kw= EqualsSign | kw= ExclamationMarkEqualsSign | kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign )
            {
            // InternalBehaviorAnnexParser.g:3354:2: (kw= EqualsSign | kw= ExclamationMarkEqualsSign | kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign )
            int alt64=6;
            switch ( input.LA(1) ) {
            case EqualsSign:
                {
                alt64=1;
                }
                break;
            case ExclamationMarkEqualsSign:
                {
                alt64=2;
                }
                break;
            case LessThanSign:
                {
                alt64=3;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt64=4;
                }
                break;
            case GreaterThanSign:
                {
                alt64=5;
                }
                break;
            case GreaterThanSignEqualsSign:
                {
                alt64=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3355:3: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3361:3: kw= ExclamationMarkEqualsSign
                    {
                    kw=(Token)match(input,ExclamationMarkEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getExclamationMarkEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBehaviorAnnexParser.g:3367:3: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBehaviorAnnexParser.g:3373:3: kw= LessThanSignEqualsSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBehaviorAnnexParser.g:3379:3: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalBehaviorAnnexParser.g:3385:3: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_5());
                      		
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
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "entryRuleSimpleExpression"
    // InternalBehaviorAnnexParser.g:3394:1: entryRuleSimpleExpression returns [EObject current=null] : iv_ruleSimpleExpression= ruleSimpleExpression EOF ;
    public final EObject entryRuleSimpleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3394:57: (iv_ruleSimpleExpression= ruleSimpleExpression EOF )
            // InternalBehaviorAnnexParser.g:3395:2: iv_ruleSimpleExpression= ruleSimpleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleExpression=ruleSimpleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleExpression; 
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
    // $ANTLR end "entryRuleSimpleExpression"


    // $ANTLR start "ruleSimpleExpression"
    // InternalBehaviorAnnexParser.g:3401:1: ruleSimpleExpression returns [EObject current=null] : ( ( ( () ( (lv_operator_1_0= ruleUnaryAddingOperator ) ) ( (lv_operand_2_0= ruleTerm ) ) ) | this_Term_3= ruleTerm ) ( () ( (lv_operator_5_0= ruleBinaryAddingOperator ) ) ( (lv_right_6_0= ruleTerm ) ) )* ) ;
    public final EObject ruleSimpleExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_Term_3 = null;

        AntlrDatatypeRuleToken lv_operator_5_0 = null;

        EObject lv_right_6_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3407:2: ( ( ( ( () ( (lv_operator_1_0= ruleUnaryAddingOperator ) ) ( (lv_operand_2_0= ruleTerm ) ) ) | this_Term_3= ruleTerm ) ( () ( (lv_operator_5_0= ruleBinaryAddingOperator ) ) ( (lv_right_6_0= ruleTerm ) ) )* ) )
            // InternalBehaviorAnnexParser.g:3408:2: ( ( ( () ( (lv_operator_1_0= ruleUnaryAddingOperator ) ) ( (lv_operand_2_0= ruleTerm ) ) ) | this_Term_3= ruleTerm ) ( () ( (lv_operator_5_0= ruleBinaryAddingOperator ) ) ( (lv_right_6_0= ruleTerm ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:3408:2: ( ( ( () ( (lv_operator_1_0= ruleUnaryAddingOperator ) ) ( (lv_operand_2_0= ruleTerm ) ) ) | this_Term_3= ruleTerm ) ( () ( (lv_operator_5_0= ruleBinaryAddingOperator ) ) ( (lv_right_6_0= ruleTerm ) ) )* )
            // InternalBehaviorAnnexParser.g:3409:3: ( ( () ( (lv_operator_1_0= ruleUnaryAddingOperator ) ) ( (lv_operand_2_0= ruleTerm ) ) ) | this_Term_3= ruleTerm ) ( () ( (lv_operator_5_0= ruleBinaryAddingOperator ) ) ( (lv_right_6_0= ruleTerm ) ) )*
            {
            // InternalBehaviorAnnexParser.g:3409:3: ( ( () ( (lv_operator_1_0= ruleUnaryAddingOperator ) ) ( (lv_operand_2_0= ruleTerm ) ) ) | this_Term_3= ruleTerm )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==PlusSign||LA65_0==HyphenMinus) ) {
                alt65=1;
            }
            else if ( (LA65_0==False||LA65_0==True||LA65_0==Abs||LA65_0==Not||LA65_0==NumberSign||LA65_0==LeftParenthesis||LA65_0==RULE_REAL_LIT||LA65_0==RULE_INTEGER_LIT||(LA65_0>=RULE_STRING && LA65_0<=RULE_ID)) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3410:4: ( () ( (lv_operator_1_0= ruleUnaryAddingOperator ) ) ( (lv_operand_2_0= ruleTerm ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:3410:4: ( () ( (lv_operator_1_0= ruleUnaryAddingOperator ) ) ( (lv_operand_2_0= ruleTerm ) ) )
                    // InternalBehaviorAnnexParser.g:3411:5: () ( (lv_operator_1_0= ruleUnaryAddingOperator ) ) ( (lv_operand_2_0= ruleTerm ) )
                    {
                    // InternalBehaviorAnnexParser.g:3411:5: ()
                    // InternalBehaviorAnnexParser.g:3412:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElement(
                      							grammarAccess.getSimpleExpressionAccess().getUnaryExpressionAction_0_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalBehaviorAnnexParser.g:3418:5: ( (lv_operator_1_0= ruleUnaryAddingOperator ) )
                    // InternalBehaviorAnnexParser.g:3419:6: (lv_operator_1_0= ruleUnaryAddingOperator )
                    {
                    // InternalBehaviorAnnexParser.g:3419:6: (lv_operator_1_0= ruleUnaryAddingOperator )
                    // InternalBehaviorAnnexParser.g:3420:7: lv_operator_1_0= ruleUnaryAddingOperator
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSimpleExpressionAccess().getOperatorUnaryAddingOperatorParserRuleCall_0_0_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_50);
                    lv_operator_1_0=ruleUnaryAddingOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getSimpleExpressionRule());
                      							}
                      							set(
                      								current,
                      								"operator",
                      								lv_operator_1_0,
                      								"org.osate.xtext.aadl2.ba.BehaviorAnnex.UnaryAddingOperator");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:3437:5: ( (lv_operand_2_0= ruleTerm ) )
                    // InternalBehaviorAnnexParser.g:3438:6: (lv_operand_2_0= ruleTerm )
                    {
                    // InternalBehaviorAnnexParser.g:3438:6: (lv_operand_2_0= ruleTerm )
                    // InternalBehaviorAnnexParser.g:3439:7: lv_operand_2_0= ruleTerm
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSimpleExpressionAccess().getOperandTermParserRuleCall_0_0_2_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_67);
                    lv_operand_2_0=ruleTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getSimpleExpressionRule());
                      							}
                      							set(
                      								current,
                      								"operand",
                      								lv_operand_2_0,
                      								"org.osate.xtext.aadl2.ba.BehaviorAnnex.Term");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3458:4: this_Term_3= ruleTerm
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getSimpleExpressionAccess().getTermParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_67);
                    this_Term_3=ruleTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Term_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:3467:3: ( () ( (lv_operator_5_0= ruleBinaryAddingOperator ) ) ( (lv_right_6_0= ruleTerm ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==PlusSign||LA66_0==HyphenMinus) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:3468:4: () ( (lv_operator_5_0= ruleBinaryAddingOperator ) ) ( (lv_right_6_0= ruleTerm ) )
            	    {
            	    // InternalBehaviorAnnexParser.g:3468:4: ()
            	    // InternalBehaviorAnnexParser.g:3469:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSimpleExpressionAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalBehaviorAnnexParser.g:3475:4: ( (lv_operator_5_0= ruleBinaryAddingOperator ) )
            	    // InternalBehaviorAnnexParser.g:3476:5: (lv_operator_5_0= ruleBinaryAddingOperator )
            	    {
            	    // InternalBehaviorAnnexParser.g:3476:5: (lv_operator_5_0= ruleBinaryAddingOperator )
            	    // InternalBehaviorAnnexParser.g:3477:6: lv_operator_5_0= ruleBinaryAddingOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSimpleExpressionAccess().getOperatorBinaryAddingOperatorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_50);
            	    lv_operator_5_0=ruleBinaryAddingOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getSimpleExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operator",
            	      							lv_operator_5_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.BinaryAddingOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalBehaviorAnnexParser.g:3494:4: ( (lv_right_6_0= ruleTerm ) )
            	    // InternalBehaviorAnnexParser.g:3495:5: (lv_right_6_0= ruleTerm )
            	    {
            	    // InternalBehaviorAnnexParser.g:3495:5: (lv_right_6_0= ruleTerm )
            	    // InternalBehaviorAnnexParser.g:3496:6: lv_right_6_0= ruleTerm
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSimpleExpressionAccess().getRightTermParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_67);
            	    lv_right_6_0=ruleTerm();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getSimpleExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_6_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.Term");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
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
    // $ANTLR end "ruleSimpleExpression"


    // $ANTLR start "entryRuleUnaryAddingOperator"
    // InternalBehaviorAnnexParser.g:3518:1: entryRuleUnaryAddingOperator returns [String current=null] : iv_ruleUnaryAddingOperator= ruleUnaryAddingOperator EOF ;
    public final String entryRuleUnaryAddingOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryAddingOperator = null;


        try {
            // InternalBehaviorAnnexParser.g:3518:59: (iv_ruleUnaryAddingOperator= ruleUnaryAddingOperator EOF )
            // InternalBehaviorAnnexParser.g:3519:2: iv_ruleUnaryAddingOperator= ruleUnaryAddingOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryAddingOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnaryAddingOperator=ruleUnaryAddingOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryAddingOperator.getText(); 
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
    // $ANTLR end "entryRuleUnaryAddingOperator"


    // $ANTLR start "ruleUnaryAddingOperator"
    // InternalBehaviorAnnexParser.g:3525:1: ruleUnaryAddingOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= HyphenMinus | kw= PlusSign ) ;
    public final AntlrDatatypeRuleToken ruleUnaryAddingOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3531:2: ( (kw= HyphenMinus | kw= PlusSign ) )
            // InternalBehaviorAnnexParser.g:3532:2: (kw= HyphenMinus | kw= PlusSign )
            {
            // InternalBehaviorAnnexParser.g:3532:2: (kw= HyphenMinus | kw= PlusSign )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==HyphenMinus) ) {
                alt67=1;
            }
            else if ( (LA67_0==PlusSign) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3533:3: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryAddingOperatorAccess().getHyphenMinusKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3539:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryAddingOperatorAccess().getPlusSignKeyword_1());
                      		
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
    // $ANTLR end "ruleUnaryAddingOperator"


    // $ANTLR start "entryRuleBinaryAddingOperator"
    // InternalBehaviorAnnexParser.g:3548:1: entryRuleBinaryAddingOperator returns [String current=null] : iv_ruleBinaryAddingOperator= ruleBinaryAddingOperator EOF ;
    public final String entryRuleBinaryAddingOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryAddingOperator = null;


        try {
            // InternalBehaviorAnnexParser.g:3548:60: (iv_ruleBinaryAddingOperator= ruleBinaryAddingOperator EOF )
            // InternalBehaviorAnnexParser.g:3549:2: iv_ruleBinaryAddingOperator= ruleBinaryAddingOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryAddingOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBinaryAddingOperator=ruleBinaryAddingOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryAddingOperator.getText(); 
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
    // $ANTLR end "entryRuleBinaryAddingOperator"


    // $ANTLR start "ruleBinaryAddingOperator"
    // InternalBehaviorAnnexParser.g:3555:1: ruleBinaryAddingOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken ruleBinaryAddingOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3561:2: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalBehaviorAnnexParser.g:3562:2: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalBehaviorAnnexParser.g:3562:2: (kw= PlusSign | kw= HyphenMinus )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==PlusSign) ) {
                alt68=1;
            }
            else if ( (LA68_0==HyphenMinus) ) {
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
                    // InternalBehaviorAnnexParser.g:3563:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBinaryAddingOperatorAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3569:3: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBinaryAddingOperatorAccess().getHyphenMinusKeyword_1());
                      		
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
    // $ANTLR end "ruleBinaryAddingOperator"


    // $ANTLR start "entryRuleTerm"
    // InternalBehaviorAnnexParser.g:3578:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:3578:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalBehaviorAnnexParser.g:3579:2: iv_ruleTerm= ruleTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerm; 
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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalBehaviorAnnexParser.g:3585:1: ruleTerm returns [EObject current=null] : (this_Factor_0= ruleFactor ( () ( (lv_operator_2_0= ruleMultiplyingOperator ) ) ( (lv_right_3_0= ruleFactor ) ) )* ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Factor_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3591:2: ( (this_Factor_0= ruleFactor ( () ( (lv_operator_2_0= ruleMultiplyingOperator ) ) ( (lv_right_3_0= ruleFactor ) ) )* ) )
            // InternalBehaviorAnnexParser.g:3592:2: (this_Factor_0= ruleFactor ( () ( (lv_operator_2_0= ruleMultiplyingOperator ) ) ( (lv_right_3_0= ruleFactor ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:3592:2: (this_Factor_0= ruleFactor ( () ( (lv_operator_2_0= ruleMultiplyingOperator ) ) ( (lv_right_3_0= ruleFactor ) ) )* )
            // InternalBehaviorAnnexParser.g:3593:3: this_Factor_0= ruleFactor ( () ( (lv_operator_2_0= ruleMultiplyingOperator ) ) ( (lv_right_3_0= ruleFactor ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getTermAccess().getFactorParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_68);
            this_Factor_0=ruleFactor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Factor_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalBehaviorAnnexParser.g:3601:3: ( () ( (lv_operator_2_0= ruleMultiplyingOperator ) ) ( (lv_right_3_0= ruleFactor ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==Mod||LA69_0==Rem||LA69_0==Asterisk||LA69_0==Solidus) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:3602:4: () ( (lv_operator_2_0= ruleMultiplyingOperator ) ) ( (lv_right_3_0= ruleFactor ) )
            	    {
            	    // InternalBehaviorAnnexParser.g:3602:4: ()
            	    // InternalBehaviorAnnexParser.g:3603:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getTermAccess().getBinaryExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalBehaviorAnnexParser.g:3609:4: ( (lv_operator_2_0= ruleMultiplyingOperator ) )
            	    // InternalBehaviorAnnexParser.g:3610:5: (lv_operator_2_0= ruleMultiplyingOperator )
            	    {
            	    // InternalBehaviorAnnexParser.g:3610:5: (lv_operator_2_0= ruleMultiplyingOperator )
            	    // InternalBehaviorAnnexParser.g:3611:6: lv_operator_2_0= ruleMultiplyingOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTermAccess().getOperatorMultiplyingOperatorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_50);
            	    lv_operator_2_0=ruleMultiplyingOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTermRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operator",
            	      							lv_operator_2_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.MultiplyingOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalBehaviorAnnexParser.g:3628:4: ( (lv_right_3_0= ruleFactor ) )
            	    // InternalBehaviorAnnexParser.g:3629:5: (lv_right_3_0= ruleFactor )
            	    {
            	    // InternalBehaviorAnnexParser.g:3629:5: (lv_right_3_0= ruleFactor )
            	    // InternalBehaviorAnnexParser.g:3630:6: lv_right_3_0= ruleFactor
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTermAccess().getRightFactorParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_68);
            	    lv_right_3_0=ruleFactor();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getTermRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.Factor");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
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
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleMultiplyingOperator"
    // InternalBehaviorAnnexParser.g:3652:1: entryRuleMultiplyingOperator returns [String current=null] : iv_ruleMultiplyingOperator= ruleMultiplyingOperator EOF ;
    public final String entryRuleMultiplyingOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplyingOperator = null;


        try {
            // InternalBehaviorAnnexParser.g:3652:59: (iv_ruleMultiplyingOperator= ruleMultiplyingOperator EOF )
            // InternalBehaviorAnnexParser.g:3653:2: iv_ruleMultiplyingOperator= ruleMultiplyingOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplyingOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplyingOperator=ruleMultiplyingOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplyingOperator.getText(); 
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
    // $ANTLR end "entryRuleMultiplyingOperator"


    // $ANTLR start "ruleMultiplyingOperator"
    // InternalBehaviorAnnexParser.g:3659:1: ruleMultiplyingOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Asterisk | kw= Solidus | kw= Mod | kw= Rem ) ;
    public final AntlrDatatypeRuleToken ruleMultiplyingOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3665:2: ( (kw= Asterisk | kw= Solidus | kw= Mod | kw= Rem ) )
            // InternalBehaviorAnnexParser.g:3666:2: (kw= Asterisk | kw= Solidus | kw= Mod | kw= Rem )
            {
            // InternalBehaviorAnnexParser.g:3666:2: (kw= Asterisk | kw= Solidus | kw= Mod | kw= Rem )
            int alt70=4;
            switch ( input.LA(1) ) {
            case Asterisk:
                {
                alt70=1;
                }
                break;
            case Solidus:
                {
                alt70=2;
                }
                break;
            case Mod:
                {
                alt70=3;
                }
                break;
            case Rem:
                {
                alt70=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3667:3: kw= Asterisk
                    {
                    kw=(Token)match(input,Asterisk,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getMultiplyingOperatorAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3673:3: kw= Solidus
                    {
                    kw=(Token)match(input,Solidus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getMultiplyingOperatorAccess().getSolidusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBehaviorAnnexParser.g:3679:3: kw= Mod
                    {
                    kw=(Token)match(input,Mod,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getMultiplyingOperatorAccess().getModKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBehaviorAnnexParser.g:3685:3: kw= Rem
                    {
                    kw=(Token)match(input,Rem,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getMultiplyingOperatorAccess().getRemKeyword_3());
                      		
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
    // $ANTLR end "ruleMultiplyingOperator"


    // $ANTLR start "entryRuleFactor"
    // InternalBehaviorAnnexParser.g:3694:1: entryRuleFactor returns [EObject current=null] : iv_ruleFactor= ruleFactor EOF ;
    public final EObject entryRuleFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFactor = null;


        try {
            // InternalBehaviorAnnexParser.g:3694:47: (iv_ruleFactor= ruleFactor EOF )
            // InternalBehaviorAnnexParser.g:3695:2: iv_ruleFactor= ruleFactor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFactorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFactor=ruleFactor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFactor; 
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
    // $ANTLR end "entryRuleFactor"


    // $ANTLR start "ruleFactor"
    // InternalBehaviorAnnexParser.g:3701:1: ruleFactor returns [EObject current=null] : ( (this_Value_0= ruleValue ( () ( (lv_operator_2_0= ruleBinaryNumericOperator ) ) ( (lv_right_3_0= ruleValue ) ) )? ) | ( () ( (lv_operator_5_0= ruleUnaryValueOperator ) ) ( (lv_operand_6_0= ruleValue ) ) ) ) ;
    public final EObject ruleFactor() throws RecognitionException {
        EObject current = null;

        EObject this_Value_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;

        AntlrDatatypeRuleToken lv_operator_5_0 = null;

        EObject lv_operand_6_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3707:2: ( ( (this_Value_0= ruleValue ( () ( (lv_operator_2_0= ruleBinaryNumericOperator ) ) ( (lv_right_3_0= ruleValue ) ) )? ) | ( () ( (lv_operator_5_0= ruleUnaryValueOperator ) ) ( (lv_operand_6_0= ruleValue ) ) ) ) )
            // InternalBehaviorAnnexParser.g:3708:2: ( (this_Value_0= ruleValue ( () ( (lv_operator_2_0= ruleBinaryNumericOperator ) ) ( (lv_right_3_0= ruleValue ) ) )? ) | ( () ( (lv_operator_5_0= ruleUnaryValueOperator ) ) ( (lv_operand_6_0= ruleValue ) ) ) )
            {
            // InternalBehaviorAnnexParser.g:3708:2: ( (this_Value_0= ruleValue ( () ( (lv_operator_2_0= ruleBinaryNumericOperator ) ) ( (lv_right_3_0= ruleValue ) ) )? ) | ( () ( (lv_operator_5_0= ruleUnaryValueOperator ) ) ( (lv_operand_6_0= ruleValue ) ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==False||LA72_0==True||LA72_0==NumberSign||LA72_0==LeftParenthesis||LA72_0==RULE_REAL_LIT||LA72_0==RULE_INTEGER_LIT||(LA72_0>=RULE_STRING && LA72_0<=RULE_ID)) ) {
                alt72=1;
            }
            else if ( (LA72_0==Abs||LA72_0==Not) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3709:3: (this_Value_0= ruleValue ( () ( (lv_operator_2_0= ruleBinaryNumericOperator ) ) ( (lv_right_3_0= ruleValue ) ) )? )
                    {
                    // InternalBehaviorAnnexParser.g:3709:3: (this_Value_0= ruleValue ( () ( (lv_operator_2_0= ruleBinaryNumericOperator ) ) ( (lv_right_3_0= ruleValue ) ) )? )
                    // InternalBehaviorAnnexParser.g:3710:4: this_Value_0= ruleValue ( () ( (lv_operator_2_0= ruleBinaryNumericOperator ) ) ( (lv_right_3_0= ruleValue ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getFactorAccess().getValueParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_69);
                    this_Value_0=ruleValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Value_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalBehaviorAnnexParser.g:3718:4: ( () ( (lv_operator_2_0= ruleBinaryNumericOperator ) ) ( (lv_right_3_0= ruleValue ) ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==AsteriskAsterisk) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:3719:5: () ( (lv_operator_2_0= ruleBinaryNumericOperator ) ) ( (lv_right_3_0= ruleValue ) )
                            {
                            // InternalBehaviorAnnexParser.g:3719:5: ()
                            // InternalBehaviorAnnexParser.g:3720:6: 
                            {
                            if ( state.backtracking==0 ) {

                              						current = forceCreateModelElementAndSet(
                              							grammarAccess.getFactorAccess().getBinaryExpressionLeftAction_0_1_0(),
                              							current);
                              					
                            }

                            }

                            // InternalBehaviorAnnexParser.g:3726:5: ( (lv_operator_2_0= ruleBinaryNumericOperator ) )
                            // InternalBehaviorAnnexParser.g:3727:6: (lv_operator_2_0= ruleBinaryNumericOperator )
                            {
                            // InternalBehaviorAnnexParser.g:3727:6: (lv_operator_2_0= ruleBinaryNumericOperator )
                            // InternalBehaviorAnnexParser.g:3728:7: lv_operator_2_0= ruleBinaryNumericOperator
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getFactorAccess().getOperatorBinaryNumericOperatorParserRuleCall_0_1_1_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_70);
                            lv_operator_2_0=ruleBinaryNumericOperator();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getFactorRule());
                              							}
                              							set(
                              								current,
                              								"operator",
                              								lv_operator_2_0,
                              								"org.osate.xtext.aadl2.ba.BehaviorAnnex.BinaryNumericOperator");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalBehaviorAnnexParser.g:3745:5: ( (lv_right_3_0= ruleValue ) )
                            // InternalBehaviorAnnexParser.g:3746:6: (lv_right_3_0= ruleValue )
                            {
                            // InternalBehaviorAnnexParser.g:3746:6: (lv_right_3_0= ruleValue )
                            // InternalBehaviorAnnexParser.g:3747:7: lv_right_3_0= ruleValue
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getFactorAccess().getRightValueParserRuleCall_0_1_2_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_right_3_0=ruleValue();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getFactorRule());
                              							}
                              							set(
                              								current,
                              								"right",
                              								lv_right_3_0,
                              								"org.osate.xtext.aadl2.ba.BehaviorAnnex.Value");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3767:3: ( () ( (lv_operator_5_0= ruleUnaryValueOperator ) ) ( (lv_operand_6_0= ruleValue ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:3767:3: ( () ( (lv_operator_5_0= ruleUnaryValueOperator ) ) ( (lv_operand_6_0= ruleValue ) ) )
                    // InternalBehaviorAnnexParser.g:3768:4: () ( (lv_operator_5_0= ruleUnaryValueOperator ) ) ( (lv_operand_6_0= ruleValue ) )
                    {
                    // InternalBehaviorAnnexParser.g:3768:4: ()
                    // InternalBehaviorAnnexParser.g:3769:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getFactorAccess().getUnaryExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalBehaviorAnnexParser.g:3775:4: ( (lv_operator_5_0= ruleUnaryValueOperator ) )
                    // InternalBehaviorAnnexParser.g:3776:5: (lv_operator_5_0= ruleUnaryValueOperator )
                    {
                    // InternalBehaviorAnnexParser.g:3776:5: (lv_operator_5_0= ruleUnaryValueOperator )
                    // InternalBehaviorAnnexParser.g:3777:6: lv_operator_5_0= ruleUnaryValueOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFactorAccess().getOperatorUnaryValueOperatorParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_70);
                    lv_operator_5_0=ruleUnaryValueOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFactorRule());
                      						}
                      						set(
                      							current,
                      							"operator",
                      							lv_operator_5_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.UnaryValueOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:3794:4: ( (lv_operand_6_0= ruleValue ) )
                    // InternalBehaviorAnnexParser.g:3795:5: (lv_operand_6_0= ruleValue )
                    {
                    // InternalBehaviorAnnexParser.g:3795:5: (lv_operand_6_0= ruleValue )
                    // InternalBehaviorAnnexParser.g:3796:6: lv_operand_6_0= ruleValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFactorAccess().getOperandValueParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_operand_6_0=ruleValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFactorRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_6_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.Value");
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
    // $ANTLR end "ruleFactor"


    // $ANTLR start "entryRuleBinaryNumericOperator"
    // InternalBehaviorAnnexParser.g:3818:1: entryRuleBinaryNumericOperator returns [String current=null] : iv_ruleBinaryNumericOperator= ruleBinaryNumericOperator EOF ;
    public final String entryRuleBinaryNumericOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryNumericOperator = null;


        try {
            // InternalBehaviorAnnexParser.g:3818:61: (iv_ruleBinaryNumericOperator= ruleBinaryNumericOperator EOF )
            // InternalBehaviorAnnexParser.g:3819:2: iv_ruleBinaryNumericOperator= ruleBinaryNumericOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryNumericOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBinaryNumericOperator=ruleBinaryNumericOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryNumericOperator.getText(); 
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
    // $ANTLR end "entryRuleBinaryNumericOperator"


    // $ANTLR start "ruleBinaryNumericOperator"
    // InternalBehaviorAnnexParser.g:3825:1: ruleBinaryNumericOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= AsteriskAsterisk ;
    public final AntlrDatatypeRuleToken ruleBinaryNumericOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3831:2: (kw= AsteriskAsterisk )
            // InternalBehaviorAnnexParser.g:3832:2: kw= AsteriskAsterisk
            {
            kw=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getBinaryNumericOperatorAccess().getAsteriskAsteriskKeyword());
              	
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
    // $ANTLR end "ruleBinaryNumericOperator"


    // $ANTLR start "entryRuleUnaryValueOperator"
    // InternalBehaviorAnnexParser.g:3840:1: entryRuleUnaryValueOperator returns [String current=null] : iv_ruleUnaryValueOperator= ruleUnaryValueOperator EOF ;
    public final String entryRuleUnaryValueOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryValueOperator = null;


        try {
            // InternalBehaviorAnnexParser.g:3840:58: (iv_ruleUnaryValueOperator= ruleUnaryValueOperator EOF )
            // InternalBehaviorAnnexParser.g:3841:2: iv_ruleUnaryValueOperator= ruleUnaryValueOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryValueOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnaryValueOperator=ruleUnaryValueOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryValueOperator.getText(); 
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
    // $ANTLR end "entryRuleUnaryValueOperator"


    // $ANTLR start "ruleUnaryValueOperator"
    // InternalBehaviorAnnexParser.g:3847:1: ruleUnaryValueOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Abs | kw= Not ) ;
    public final AntlrDatatypeRuleToken ruleUnaryValueOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3853:2: ( (kw= Abs | kw= Not ) )
            // InternalBehaviorAnnexParser.g:3854:2: (kw= Abs | kw= Not )
            {
            // InternalBehaviorAnnexParser.g:3854:2: (kw= Abs | kw= Not )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==Abs) ) {
                alt73=1;
            }
            else if ( (LA73_0==Not) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3855:3: kw= Abs
                    {
                    kw=(Token)match(input,Abs,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryValueOperatorAccess().getAbsKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3861:3: kw= Not
                    {
                    kw=(Token)match(input,Not,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryValueOperatorAccess().getNotKeyword_1());
                      		
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
    // $ANTLR end "ruleUnaryValueOperator"


    // $ANTLR start "entryRuleValue"
    // InternalBehaviorAnnexParser.g:3870:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalBehaviorAnnexParser.g:3870:46: (iv_ruleValue= ruleValue EOF )
            // InternalBehaviorAnnexParser.g:3871:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalBehaviorAnnexParser.g:3877:1: ruleValue returns [EObject current=null] : (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_ValueConstant_0 = null;

        EObject this_ReferenceExpression_1 = null;

        EObject this_ParenthesizedExpression_2 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3883:2: ( (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) )
            // InternalBehaviorAnnexParser.g:3884:2: (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            {
            // InternalBehaviorAnnexParser.g:3884:2: (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            int alt74=3;
            switch ( input.LA(1) ) {
            case False:
            case True:
            case NumberSign:
            case RULE_REAL_LIT:
            case RULE_INTEGER_LIT:
            case RULE_STRING:
                {
                alt74=1;
                }
                break;
            case RULE_ID:
                {
                alt74=2;
                }
                break;
            case LeftParenthesis:
                {
                alt74=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3885:3: this_ValueConstant_0= ruleValueConstant
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueAccess().getValueConstantParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ValueConstant_0=ruleValueConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValueConstant_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3894:3: this_ReferenceExpression_1= ruleReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueAccess().getReferenceExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReferenceExpression_1=ruleReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ReferenceExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBehaviorAnnexParser.g:3903:3: this_ParenthesizedExpression_2= ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueAccess().getParenthesizedExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParenthesizedExpression_2=ruleParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParenthesizedExpression_2;
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
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // InternalBehaviorAnnexParser.g:3915:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3915:64: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // InternalBehaviorAnnexParser.g:3916:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
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
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // InternalBehaviorAnnexParser.g:3922:1: ruleParenthesizedExpression returns [EObject current=null] : (otherlv_0= LeftParenthesis ( (lv_expression_1_0= ruleValueExpression ) ) otherlv_2= RightParenthesis ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3928:2: ( (otherlv_0= LeftParenthesis ( (lv_expression_1_0= ruleValueExpression ) ) otherlv_2= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:3929:2: (otherlv_0= LeftParenthesis ( (lv_expression_1_0= ruleValueExpression ) ) otherlv_2= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:3929:2: (otherlv_0= LeftParenthesis ( (lv_expression_1_0= ruleValueExpression ) ) otherlv_2= RightParenthesis )
            // InternalBehaviorAnnexParser.g:3930:3: otherlv_0= LeftParenthesis ( (lv_expression_1_0= ruleValueExpression ) ) otherlv_2= RightParenthesis
            {
            otherlv_0=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:3934:3: ( (lv_expression_1_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:3935:4: (lv_expression_1_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:3935:4: (lv_expression_1_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:3936:5: lv_expression_1_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionValueExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_39);
            lv_expression_1_0=ruleValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParenthesizedExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
              		
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
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleValueConstant"
    // InternalBehaviorAnnexParser.g:3961:1: entryRuleValueConstant returns [EObject current=null] : iv_ruleValueConstant= ruleValueConstant EOF ;
    public final EObject entryRuleValueConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueConstant = null;


        try {
            // InternalBehaviorAnnexParser.g:3961:54: (iv_ruleValueConstant= ruleValueConstant EOF )
            // InternalBehaviorAnnexParser.g:3962:2: iv_ruleValueConstant= ruleValueConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueConstantRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueConstant=ruleValueConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueConstant; 
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
    // $ANTLR end "entryRuleValueConstant"


    // $ANTLR start "ruleValueConstant"
    // InternalBehaviorAnnexParser.g:3968:1: ruleValueConstant returns [EObject current=null] : (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference ) ;
    public final EObject ruleValueConstant() throws RecognitionException {
        EObject current = null;

        EObject this_BehaviorIntegerLiteral_0 = null;

        EObject this_BehaviorRealLiteral_1 = null;

        EObject this_BehaviorStringLiteral_2 = null;

        EObject this_BehaviorBooleanLiteral_3 = null;

        EObject this_HashPropertyReference_4 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3974:2: ( (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference ) )
            // InternalBehaviorAnnexParser.g:3975:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference )
            {
            // InternalBehaviorAnnexParser.g:3975:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference )
            int alt75=5;
            switch ( input.LA(1) ) {
            case RULE_INTEGER_LIT:
                {
                alt75=1;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt75=2;
                }
                break;
            case RULE_STRING:
                {
                alt75=3;
                }
                break;
            case False:
            case True:
                {
                alt75=4;
                }
                break;
            case NumberSign:
                {
                alt75=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }

            switch (alt75) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3976:3: this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueConstantAccess().getBehaviorIntegerLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BehaviorIntegerLiteral_0=ruleBehaviorIntegerLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BehaviorIntegerLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3985:3: this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueConstantAccess().getBehaviorRealLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BehaviorRealLiteral_1=ruleBehaviorRealLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BehaviorRealLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBehaviorAnnexParser.g:3994:3: this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueConstantAccess().getBehaviorStringLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BehaviorStringLiteral_2=ruleBehaviorStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BehaviorStringLiteral_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBehaviorAnnexParser.g:4003:3: this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueConstantAccess().getBehaviorBooleanLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BehaviorBooleanLiteral_3=ruleBehaviorBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BehaviorBooleanLiteral_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBehaviorAnnexParser.g:4012:3: this_HashPropertyReference_4= ruleHashPropertyReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueConstantAccess().getHashPropertyReferenceParserRuleCall_4());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_HashPropertyReference_4=ruleHashPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HashPropertyReference_4;
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
    // $ANTLR end "ruleValueConstant"


    // $ANTLR start "entryRuleBehaviorIntegerLiteral"
    // InternalBehaviorAnnexParser.g:4024:1: entryRuleBehaviorIntegerLiteral returns [EObject current=null] : iv_ruleBehaviorIntegerLiteral= ruleBehaviorIntegerLiteral EOF ;
    public final EObject entryRuleBehaviorIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorIntegerLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:4024:63: (iv_ruleBehaviorIntegerLiteral= ruleBehaviorIntegerLiteral EOF )
            // InternalBehaviorAnnexParser.g:4025:2: iv_ruleBehaviorIntegerLiteral= ruleBehaviorIntegerLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorIntegerLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorIntegerLiteral=ruleBehaviorIntegerLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorIntegerLiteral; 
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
    // $ANTLR end "entryRuleBehaviorIntegerLiteral"


    // $ANTLR start "ruleBehaviorIntegerLiteral"
    // InternalBehaviorAnnexParser.g:4031:1: ruleBehaviorIntegerLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGER_LIT ) ) ;
    public final EObject ruleBehaviorIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4037:2: ( ( (lv_value_0_0= RULE_INTEGER_LIT ) ) )
            // InternalBehaviorAnnexParser.g:4038:2: ( (lv_value_0_0= RULE_INTEGER_LIT ) )
            {
            // InternalBehaviorAnnexParser.g:4038:2: ( (lv_value_0_0= RULE_INTEGER_LIT ) )
            // InternalBehaviorAnnexParser.g:4039:3: (lv_value_0_0= RULE_INTEGER_LIT )
            {
            // InternalBehaviorAnnexParser.g:4039:3: (lv_value_0_0= RULE_INTEGER_LIT )
            // InternalBehaviorAnnexParser.g:4040:4: lv_value_0_0= RULE_INTEGER_LIT
            {
            lv_value_0_0=(Token)match(input,RULE_INTEGER_LIT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getBehaviorIntegerLiteralAccess().getValueINTEGER_LITTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getBehaviorIntegerLiteralRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.osate.xtext.aadl2.properties.Properties.INTEGER_LIT");
              			
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
    // $ANTLR end "ruleBehaviorIntegerLiteral"


    // $ANTLR start "entryRuleBehaviorRealLiteral"
    // InternalBehaviorAnnexParser.g:4059:1: entryRuleBehaviorRealLiteral returns [EObject current=null] : iv_ruleBehaviorRealLiteral= ruleBehaviorRealLiteral EOF ;
    public final EObject entryRuleBehaviorRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorRealLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:4059:60: (iv_ruleBehaviorRealLiteral= ruleBehaviorRealLiteral EOF )
            // InternalBehaviorAnnexParser.g:4060:2: iv_ruleBehaviorRealLiteral= ruleBehaviorRealLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorRealLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorRealLiteral=ruleBehaviorRealLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorRealLiteral; 
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
    // $ANTLR end "entryRuleBehaviorRealLiteral"


    // $ANTLR start "ruleBehaviorRealLiteral"
    // InternalBehaviorAnnexParser.g:4066:1: ruleBehaviorRealLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_REAL_LIT ) ) ;
    public final EObject ruleBehaviorRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4072:2: ( ( (lv_value_0_0= RULE_REAL_LIT ) ) )
            // InternalBehaviorAnnexParser.g:4073:2: ( (lv_value_0_0= RULE_REAL_LIT ) )
            {
            // InternalBehaviorAnnexParser.g:4073:2: ( (lv_value_0_0= RULE_REAL_LIT ) )
            // InternalBehaviorAnnexParser.g:4074:3: (lv_value_0_0= RULE_REAL_LIT )
            {
            // InternalBehaviorAnnexParser.g:4074:3: (lv_value_0_0= RULE_REAL_LIT )
            // InternalBehaviorAnnexParser.g:4075:4: lv_value_0_0= RULE_REAL_LIT
            {
            lv_value_0_0=(Token)match(input,RULE_REAL_LIT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getBehaviorRealLiteralAccess().getValueREAL_LITTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getBehaviorRealLiteralRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.osate.xtext.aadl2.properties.Properties.REAL_LIT");
              			
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
    // $ANTLR end "ruleBehaviorRealLiteral"


    // $ANTLR start "entryRuleBehaviorStringLiteral"
    // InternalBehaviorAnnexParser.g:4094:1: entryRuleBehaviorStringLiteral returns [EObject current=null] : iv_ruleBehaviorStringLiteral= ruleBehaviorStringLiteral EOF ;
    public final EObject entryRuleBehaviorStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorStringLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:4094:62: (iv_ruleBehaviorStringLiteral= ruleBehaviorStringLiteral EOF )
            // InternalBehaviorAnnexParser.g:4095:2: iv_ruleBehaviorStringLiteral= ruleBehaviorStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorStringLiteral=ruleBehaviorStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorStringLiteral; 
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
    // $ANTLR end "entryRuleBehaviorStringLiteral"


    // $ANTLR start "ruleBehaviorStringLiteral"
    // InternalBehaviorAnnexParser.g:4101:1: ruleBehaviorStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleBehaviorStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4107:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalBehaviorAnnexParser.g:4108:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalBehaviorAnnexParser.g:4108:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalBehaviorAnnexParser.g:4109:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalBehaviorAnnexParser.g:4109:3: (lv_value_0_0= RULE_STRING )
            // InternalBehaviorAnnexParser.g:4110:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getBehaviorStringLiteralAccess().getValueSTRINGTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getBehaviorStringLiteralRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.osate.xtext.aadl2.properties.Properties.STRING");
              			
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
    // $ANTLR end "ruleBehaviorStringLiteral"


    // $ANTLR start "entryRuleBehaviorBooleanLiteral"
    // InternalBehaviorAnnexParser.g:4129:1: entryRuleBehaviorBooleanLiteral returns [EObject current=null] : iv_ruleBehaviorBooleanLiteral= ruleBehaviorBooleanLiteral EOF ;
    public final EObject entryRuleBehaviorBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorBooleanLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:4129:63: (iv_ruleBehaviorBooleanLiteral= ruleBehaviorBooleanLiteral EOF )
            // InternalBehaviorAnnexParser.g:4130:2: iv_ruleBehaviorBooleanLiteral= ruleBehaviorBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBehaviorBooleanLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBehaviorBooleanLiteral=ruleBehaviorBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBehaviorBooleanLiteral; 
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
    // $ANTLR end "entryRuleBehaviorBooleanLiteral"


    // $ANTLR start "ruleBehaviorBooleanLiteral"
    // InternalBehaviorAnnexParser.g:4136:1: ruleBehaviorBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBehaviorBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4142:2: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalBehaviorAnnexParser.g:4143:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalBehaviorAnnexParser.g:4143:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalBehaviorAnnexParser.g:4144:3: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalBehaviorAnnexParser.g:4144:3: ()
            // InternalBehaviorAnnexParser.g:4145:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBehaviorBooleanLiteralAccess().getBehaviorBooleanLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalBehaviorAnnexParser.g:4151:3: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==True) ) {
                alt76=1;
            }
            else if ( (LA76_0==False) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4152:4: ( (lv_value_1_0= True ) )
                    {
                    // InternalBehaviorAnnexParser.g:4152:4: ( (lv_value_1_0= True ) )
                    // InternalBehaviorAnnexParser.g:4153:5: (lv_value_1_0= True )
                    {
                    // InternalBehaviorAnnexParser.g:4153:5: (lv_value_1_0= True )
                    // InternalBehaviorAnnexParser.g:4154:6: lv_value_1_0= True
                    {
                    lv_value_1_0=(Token)match(input,True,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getBehaviorBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBehaviorBooleanLiteralRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_1_0 != null, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:4167:4: otherlv_2= False
                    {
                    otherlv_2=(Token)match(input,False,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBehaviorBooleanLiteralAccess().getFalseKeyword_1_1());
                      			
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
    // $ANTLR end "ruleBehaviorBooleanLiteral"


    // $ANTLR start "entryRuleReferenceExpression"
    // InternalBehaviorAnnexParser.g:4176:1: entryRuleReferenceExpression returns [EObject current=null] : iv_ruleReferenceExpression= ruleReferenceExpression EOF ;
    public final EObject entryRuleReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:4176:60: (iv_ruleReferenceExpression= ruleReferenceExpression EOF )
            // InternalBehaviorAnnexParser.g:4177:2: iv_ruleReferenceExpression= ruleReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReferenceExpression=ruleReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceExpression; 
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
    // $ANTLR end "entryRuleReferenceExpression"


    // $ANTLR start "ruleReferenceExpression"
    // InternalBehaviorAnnexParser.g:4183:1: ruleReferenceExpression returns [EObject current=null] : ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) | ( (lv_updated_6_0= Updated ) ) ) ) )? ) ;
    public final EObject ruleReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token lv_dequeue_2_0=null;
        Token otherlv_3=null;
        Token lv_count_4_0=null;
        Token lv_fresh_5_0=null;
        Token lv_updated_6_0=null;
        EObject lv_reference_0_0 = null;

        EObject lv_property_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4189:2: ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) | ( (lv_updated_6_0= Updated ) ) ) ) )? ) )
            // InternalBehaviorAnnexParser.g:4190:2: ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) | ( (lv_updated_6_0= Updated ) ) ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:4190:2: ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) | ( (lv_updated_6_0= Updated ) ) ) ) )? )
            // InternalBehaviorAnnexParser.g:4191:3: ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) | ( (lv_updated_6_0= Updated ) ) ) ) )?
            {
            // InternalBehaviorAnnexParser.g:4191:3: ( (lv_reference_0_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:4192:4: (lv_reference_0_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:4192:4: (lv_reference_0_0= ruleReference )
            // InternalBehaviorAnnexParser.g:4193:5: lv_reference_0_0= ruleReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getReferenceExpressionAccess().getReferenceReferenceParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_71);
            lv_reference_0_0=ruleReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getReferenceExpressionRule());
              					}
              					set(
              						current,
              						"reference",
              						lv_reference_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:4210:3: ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) | ( (lv_updated_6_0= Updated ) ) ) ) )?
            int alt78=4;
            switch ( input.LA(1) ) {
                case NumberSign:
                    {
                    alt78=1;
                    }
                    break;
                case QuestionMark:
                    {
                    alt78=2;
                    }
                    break;
                case Apostrophe:
                    {
                    alt78=3;
                    }
                    break;
            }

            switch (alt78) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4211:4: ( (lv_property_1_0= rulePropertyReferenceTail ) )
                    {
                    // InternalBehaviorAnnexParser.g:4211:4: ( (lv_property_1_0= rulePropertyReferenceTail ) )
                    // InternalBehaviorAnnexParser.g:4212:5: (lv_property_1_0= rulePropertyReferenceTail )
                    {
                    // InternalBehaviorAnnexParser.g:4212:5: (lv_property_1_0= rulePropertyReferenceTail )
                    // InternalBehaviorAnnexParser.g:4213:6: lv_property_1_0= rulePropertyReferenceTail
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getReferenceExpressionAccess().getPropertyPropertyReferenceTailParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_property_1_0=rulePropertyReferenceTail();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getReferenceExpressionRule());
                      						}
                      						set(
                      							current,
                      							"property",
                      							lv_property_1_0,
                      							"org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyReferenceTail");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:4231:4: ( (lv_dequeue_2_0= QuestionMark ) )
                    {
                    // InternalBehaviorAnnexParser.g:4231:4: ( (lv_dequeue_2_0= QuestionMark ) )
                    // InternalBehaviorAnnexParser.g:4232:5: (lv_dequeue_2_0= QuestionMark )
                    {
                    // InternalBehaviorAnnexParser.g:4232:5: (lv_dequeue_2_0= QuestionMark )
                    // InternalBehaviorAnnexParser.g:4233:6: lv_dequeue_2_0= QuestionMark
                    {
                    lv_dequeue_2_0=(Token)match(input,QuestionMark,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_dequeue_2_0, grammarAccess.getReferenceExpressionAccess().getDequeueQuestionMarkKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getReferenceExpressionRule());
                      						}
                      						setWithLastConsumed(current, "dequeue", lv_dequeue_2_0 != null, "?");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBehaviorAnnexParser.g:4246:4: (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) | ( (lv_updated_6_0= Updated ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:4246:4: (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) | ( (lv_updated_6_0= Updated ) ) ) )
                    // InternalBehaviorAnnexParser.g:4247:5: otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) | ( (lv_updated_6_0= Updated ) ) )
                    {
                    otherlv_3=(Token)match(input,Apostrophe,FollowSets000.FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getReferenceExpressionAccess().getApostropheKeyword_1_2_0());
                      				
                    }
                    // InternalBehaviorAnnexParser.g:4251:5: ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) | ( (lv_updated_6_0= Updated ) ) )
                    int alt77=3;
                    switch ( input.LA(1) ) {
                    case Count:
                        {
                        alt77=1;
                        }
                        break;
                    case Fresh:
                        {
                        alt77=2;
                        }
                        break;
                    case Updated:
                        {
                        alt77=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 77, 0, input);

                        throw nvae;
                    }

                    switch (alt77) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:4252:6: ( (lv_count_4_0= Count ) )
                            {
                            // InternalBehaviorAnnexParser.g:4252:6: ( (lv_count_4_0= Count ) )
                            // InternalBehaviorAnnexParser.g:4253:7: (lv_count_4_0= Count )
                            {
                            // InternalBehaviorAnnexParser.g:4253:7: (lv_count_4_0= Count )
                            // InternalBehaviorAnnexParser.g:4254:8: lv_count_4_0= Count
                            {
                            lv_count_4_0=(Token)match(input,Count,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_count_4_0, grammarAccess.getReferenceExpressionAccess().getCountCountKeyword_1_2_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getReferenceExpressionRule());
                              								}
                              								setWithLastConsumed(current, "count", lv_count_4_0 != null, "count");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBehaviorAnnexParser.g:4267:6: ( (lv_fresh_5_0= Fresh ) )
                            {
                            // InternalBehaviorAnnexParser.g:4267:6: ( (lv_fresh_5_0= Fresh ) )
                            // InternalBehaviorAnnexParser.g:4268:7: (lv_fresh_5_0= Fresh )
                            {
                            // InternalBehaviorAnnexParser.g:4268:7: (lv_fresh_5_0= Fresh )
                            // InternalBehaviorAnnexParser.g:4269:8: lv_fresh_5_0= Fresh
                            {
                            lv_fresh_5_0=(Token)match(input,Fresh,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_fresh_5_0, grammarAccess.getReferenceExpressionAccess().getFreshFreshKeyword_1_2_1_1_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getReferenceExpressionRule());
                              								}
                              								setWithLastConsumed(current, "fresh", lv_fresh_5_0 != null, "fresh");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalBehaviorAnnexParser.g:4282:6: ( (lv_updated_6_0= Updated ) )
                            {
                            // InternalBehaviorAnnexParser.g:4282:6: ( (lv_updated_6_0= Updated ) )
                            // InternalBehaviorAnnexParser.g:4283:7: (lv_updated_6_0= Updated )
                            {
                            // InternalBehaviorAnnexParser.g:4283:7: (lv_updated_6_0= Updated )
                            // InternalBehaviorAnnexParser.g:4284:8: lv_updated_6_0= Updated
                            {
                            lv_updated_6_0=(Token)match(input,Updated,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_updated_6_0, grammarAccess.getReferenceExpressionAccess().getUpdatedUpdatedKeyword_1_2_1_2_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getReferenceExpressionRule());
                              								}
                              								setWithLastConsumed(current, "updated", lv_updated_6_0 != null, "updated");
                              							
                            }

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleReferenceExpression"


    // $ANTLR start "entryRuleHashPropertyReference"
    // InternalBehaviorAnnexParser.g:4303:1: entryRuleHashPropertyReference returns [EObject current=null] : iv_ruleHashPropertyReference= ruleHashPropertyReference EOF ;
    public final EObject entryRuleHashPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHashPropertyReference = null;


        try {
            // InternalBehaviorAnnexParser.g:4303:62: (iv_ruleHashPropertyReference= ruleHashPropertyReference EOF )
            // InternalBehaviorAnnexParser.g:4304:2: iv_ruleHashPropertyReference= ruleHashPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHashPropertyReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleHashPropertyReference=ruleHashPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHashPropertyReference; 
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
    // $ANTLR end "entryRuleHashPropertyReference"


    // $ANTLR start "ruleHashPropertyReference"
    // InternalBehaviorAnnexParser.g:4310:1: ruleHashPropertyReference returns [EObject current=null] : (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) ;
    public final EObject ruleHashPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_property_1_0 = null;

        EObject lv_indexes_2_0 = null;

        EObject lv_fields_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4316:2: ( (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) )
            // InternalBehaviorAnnexParser.g:4317:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            {
            // InternalBehaviorAnnexParser.g:4317:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            // InternalBehaviorAnnexParser.g:4318:3: otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            {
            otherlv_0=(Token)match(input,NumberSign,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getHashPropertyReferenceAccess().getNumberSignKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:4322:3: ( (lv_property_1_0= ruleQualifiedName ) )
            // InternalBehaviorAnnexParser.g:4323:4: (lv_property_1_0= ruleQualifiedName )
            {
            // InternalBehaviorAnnexParser.g:4323:4: (lv_property_1_0= ruleQualifiedName )
            // InternalBehaviorAnnexParser.g:4324:5: lv_property_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getPropertyQualifiedNameParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_73);
            lv_property_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHashPropertyReferenceRule());
              					}
              					set(
              						current,
              						"property",
              						lv_property_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:4341:3: ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==LeftSquareBracket) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:4342:4: (lv_indexes_2_0= rulePropertyArrayIndex )
            	    {
            	    // InternalBehaviorAnnexParser.g:4342:4: (lv_indexes_2_0= rulePropertyArrayIndex )
            	    // InternalBehaviorAnnexParser.g:4343:5: lv_indexes_2_0= rulePropertyArrayIndex
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getIndexesPropertyArrayIndexParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_73);
            	    lv_indexes_2_0=rulePropertyArrayIndex();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getHashPropertyReferenceRule());
            	      					}
            	      					add(
            	      						current,
            	      						"indexes",
            	      						lv_indexes_2_0,
            	      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyArrayIndex");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

            // InternalBehaviorAnnexParser.g:4360:3: ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==FullStop) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:4361:4: (lv_fields_3_0= ruleNamedPropertyField )
            	    {
            	    // InternalBehaviorAnnexParser.g:4361:4: (lv_fields_3_0= ruleNamedPropertyField )
            	    // InternalBehaviorAnnexParser.g:4362:5: lv_fields_3_0= ruleNamedPropertyField
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getFieldsNamedPropertyFieldParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_74);
            	    lv_fields_3_0=ruleNamedPropertyField();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getHashPropertyReferenceRule());
            	      					}
            	      					add(
            	      						current,
            	      						"fields",
            	      						lv_fields_3_0,
            	      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.NamedPropertyField");
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
    // $ANTLR end "ruleHashPropertyReference"


    // $ANTLR start "entryRulePropertyReferenceTail"
    // InternalBehaviorAnnexParser.g:4383:1: entryRulePropertyReferenceTail returns [EObject current=null] : iv_rulePropertyReferenceTail= rulePropertyReferenceTail EOF ;
    public final EObject entryRulePropertyReferenceTail() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyReferenceTail = null;


        try {
            // InternalBehaviorAnnexParser.g:4383:62: (iv_rulePropertyReferenceTail= rulePropertyReferenceTail EOF )
            // InternalBehaviorAnnexParser.g:4384:2: iv_rulePropertyReferenceTail= rulePropertyReferenceTail EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyReferenceTailRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyReferenceTail=rulePropertyReferenceTail();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyReferenceTail; 
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
    // $ANTLR end "entryRulePropertyReferenceTail"


    // $ANTLR start "rulePropertyReferenceTail"
    // InternalBehaviorAnnexParser.g:4390:1: rulePropertyReferenceTail returns [EObject current=null] : (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) ;
    public final EObject rulePropertyReferenceTail() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_property_1_0 = null;

        EObject lv_indexes_2_0 = null;

        EObject lv_fields_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4396:2: ( (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) )
            // InternalBehaviorAnnexParser.g:4397:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            {
            // InternalBehaviorAnnexParser.g:4397:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            // InternalBehaviorAnnexParser.g:4398:3: otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            {
            otherlv_0=(Token)match(input,NumberSign,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPropertyReferenceTailAccess().getNumberSignKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:4402:3: ( (lv_property_1_0= ruleQualifiedName ) )
            // InternalBehaviorAnnexParser.g:4403:4: (lv_property_1_0= ruleQualifiedName )
            {
            // InternalBehaviorAnnexParser.g:4403:4: (lv_property_1_0= ruleQualifiedName )
            // InternalBehaviorAnnexParser.g:4404:5: lv_property_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getPropertyQualifiedNameParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_73);
            lv_property_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPropertyReferenceTailRule());
              					}
              					set(
              						current,
              						"property",
              						lv_property_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:4421:3: ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==LeftSquareBracket) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:4422:4: (lv_indexes_2_0= rulePropertyArrayIndex )
            	    {
            	    // InternalBehaviorAnnexParser.g:4422:4: (lv_indexes_2_0= rulePropertyArrayIndex )
            	    // InternalBehaviorAnnexParser.g:4423:5: lv_indexes_2_0= rulePropertyArrayIndex
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getIndexesPropertyArrayIndexParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_73);
            	    lv_indexes_2_0=rulePropertyArrayIndex();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getPropertyReferenceTailRule());
            	      					}
            	      					add(
            	      						current,
            	      						"indexes",
            	      						lv_indexes_2_0,
            	      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyArrayIndex");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);

            // InternalBehaviorAnnexParser.g:4440:3: ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==FullStop) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:4441:4: (lv_fields_3_0= ruleNamedPropertyField )
            	    {
            	    // InternalBehaviorAnnexParser.g:4441:4: (lv_fields_3_0= ruleNamedPropertyField )
            	    // InternalBehaviorAnnexParser.g:4442:5: lv_fields_3_0= ruleNamedPropertyField
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getFieldsNamedPropertyFieldParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_74);
            	    lv_fields_3_0=ruleNamedPropertyField();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getPropertyReferenceTailRule());
            	      					}
            	      					add(
            	      						current,
            	      						"fields",
            	      						lv_fields_3_0,
            	      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.NamedPropertyField");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
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
    // $ANTLR end "rulePropertyReferenceTail"


    // $ANTLR start "entryRuleNamedPropertyField"
    // InternalBehaviorAnnexParser.g:4463:1: entryRuleNamedPropertyField returns [EObject current=null] : iv_ruleNamedPropertyField= ruleNamedPropertyField EOF ;
    public final EObject entryRuleNamedPropertyField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedPropertyField = null;


        try {
            // InternalBehaviorAnnexParser.g:4463:59: (iv_ruleNamedPropertyField= ruleNamedPropertyField EOF )
            // InternalBehaviorAnnexParser.g:4464:2: iv_ruleNamedPropertyField= ruleNamedPropertyField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedPropertyFieldRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNamedPropertyField=ruleNamedPropertyField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedPropertyField; 
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
    // $ANTLR end "entryRuleNamedPropertyField"


    // $ANTLR start "ruleNamedPropertyField"
    // InternalBehaviorAnnexParser.g:4470:1: ruleNamedPropertyField returns [EObject current=null] : (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ) ;
    public final EObject ruleNamedPropertyField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_indexes_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4476:2: ( (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ) )
            // InternalBehaviorAnnexParser.g:4477:2: (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* )
            {
            // InternalBehaviorAnnexParser.g:4477:2: (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* )
            // InternalBehaviorAnnexParser.g:4478:3: otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            {
            otherlv_0=(Token)match(input,FullStop,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getNamedPropertyFieldAccess().getFullStopKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:4482:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:4483:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:4483:4: (lv_name_1_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:4484:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getNamedPropertyFieldAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getNamedPropertyFieldRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:4500:3: ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==LeftSquareBracket) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:4501:4: (lv_indexes_2_0= rulePropertyArrayIndex )
            	    {
            	    // InternalBehaviorAnnexParser.g:4501:4: (lv_indexes_2_0= rulePropertyArrayIndex )
            	    // InternalBehaviorAnnexParser.g:4502:5: lv_indexes_2_0= rulePropertyArrayIndex
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getNamedPropertyFieldAccess().getIndexesPropertyArrayIndexParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_13);
            	    lv_indexes_2_0=rulePropertyArrayIndex();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getNamedPropertyFieldRule());
            	      					}
            	      					add(
            	      						current,
            	      						"indexes",
            	      						lv_indexes_2_0,
            	      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyArrayIndex");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop83;
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
    // $ANTLR end "ruleNamedPropertyField"


    // $ANTLR start "entryRulePropertyArrayIndex"
    // InternalBehaviorAnnexParser.g:4523:1: entryRulePropertyArrayIndex returns [EObject current=null] : iv_rulePropertyArrayIndex= rulePropertyArrayIndex EOF ;
    public final EObject entryRulePropertyArrayIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyArrayIndex = null;


        try {
            // InternalBehaviorAnnexParser.g:4523:59: (iv_rulePropertyArrayIndex= rulePropertyArrayIndex EOF )
            // InternalBehaviorAnnexParser.g:4524:2: iv_rulePropertyArrayIndex= rulePropertyArrayIndex EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyArrayIndexRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyArrayIndex=rulePropertyArrayIndex();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyArrayIndex; 
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
    // $ANTLR end "entryRulePropertyArrayIndex"


    // $ANTLR start "rulePropertyArrayIndex"
    // InternalBehaviorAnnexParser.g:4530:1: rulePropertyArrayIndex returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket ) ;
    public final EObject rulePropertyArrayIndex() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4536:2: ( (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:4537:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:4537:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:4538:3: otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_75); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPropertyArrayIndexAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:4542:3: ( (lv_value_1_0= rulePropertyIndexValue ) )
            // InternalBehaviorAnnexParser.g:4543:4: (lv_value_1_0= rulePropertyIndexValue )
            {
            // InternalBehaviorAnnexParser.g:4543:4: (lv_value_1_0= rulePropertyIndexValue )
            // InternalBehaviorAnnexParser.g:4544:5: lv_value_1_0= rulePropertyIndexValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyArrayIndexAccess().getValuePropertyIndexValueParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_15);
            lv_value_1_0=rulePropertyIndexValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPropertyArrayIndexRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyIndexValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPropertyArrayIndexAccess().getRightSquareBracketKeyword_2());
              		
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
    // $ANTLR end "rulePropertyArrayIndex"


    // $ANTLR start "entryRulePropertyIndexValue"
    // InternalBehaviorAnnexParser.g:4569:1: entryRulePropertyIndexValue returns [EObject current=null] : iv_rulePropertyIndexValue= rulePropertyIndexValue EOF ;
    public final EObject entryRulePropertyIndexValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyIndexValue = null;


        try {
            // InternalBehaviorAnnexParser.g:4569:59: (iv_rulePropertyIndexValue= rulePropertyIndexValue EOF )
            // InternalBehaviorAnnexParser.g:4570:2: iv_rulePropertyIndexValue= rulePropertyIndexValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyIndexValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyIndexValue=rulePropertyIndexValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyIndexValue; 
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
    // $ANTLR end "entryRulePropertyIndexValue"


    // $ANTLR start "rulePropertyIndexValue"
    // InternalBehaviorAnnexParser.g:4576:1: rulePropertyIndexValue returns [EObject current=null] : (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression ) ;
    public final EObject rulePropertyIndexValue() throws RecognitionException {
        EObject current = null;

        EObject this_BehaviorIntegerLiteral_0 = null;

        EObject this_PropertyIndexPropertyReference_1 = null;

        EObject this_UnindexedReferenceExpression_2 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4582:2: ( (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression ) )
            // InternalBehaviorAnnexParser.g:4583:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression )
            {
            // InternalBehaviorAnnexParser.g:4583:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression )
            int alt84=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGER_LIT:
                {
                alt84=1;
                }
                break;
            case NumberSign:
                {
                alt84=2;
                }
                break;
            case RULE_ID:
                {
                alt84=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4584:3: this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyIndexValueAccess().getBehaviorIntegerLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BehaviorIntegerLiteral_0=ruleBehaviorIntegerLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BehaviorIntegerLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:4593:3: this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyIndexValueAccess().getPropertyIndexPropertyReferenceParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PropertyIndexPropertyReference_1=rulePropertyIndexPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PropertyIndexPropertyReference_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBehaviorAnnexParser.g:4602:3: this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyIndexValueAccess().getUnindexedReferenceExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UnindexedReferenceExpression_2=ruleUnindexedReferenceExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnindexedReferenceExpression_2;
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
    // $ANTLR end "rulePropertyIndexValue"


    // $ANTLR start "entryRulePropertyIndexPropertyReference"
    // InternalBehaviorAnnexParser.g:4614:1: entryRulePropertyIndexPropertyReference returns [EObject current=null] : iv_rulePropertyIndexPropertyReference= rulePropertyIndexPropertyReference EOF ;
    public final EObject entryRulePropertyIndexPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyIndexPropertyReference = null;


        try {
            // InternalBehaviorAnnexParser.g:4614:71: (iv_rulePropertyIndexPropertyReference= rulePropertyIndexPropertyReference EOF )
            // InternalBehaviorAnnexParser.g:4615:2: iv_rulePropertyIndexPropertyReference= rulePropertyIndexPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyIndexPropertyReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyIndexPropertyReference=rulePropertyIndexPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyIndexPropertyReference; 
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
    // $ANTLR end "entryRulePropertyIndexPropertyReference"


    // $ANTLR start "rulePropertyIndexPropertyReference"
    // InternalBehaviorAnnexParser.g:4621:1: rulePropertyIndexPropertyReference returns [EObject current=null] : (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ) ;
    public final EObject rulePropertyIndexPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_property_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4627:2: ( (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ) )
            // InternalBehaviorAnnexParser.g:4628:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) )
            {
            // InternalBehaviorAnnexParser.g:4628:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) )
            // InternalBehaviorAnnexParser.g:4629:3: otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,NumberSign,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPropertyIndexPropertyReferenceAccess().getNumberSignKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:4633:3: ( (lv_property_1_0= ruleQualifiedName ) )
            // InternalBehaviorAnnexParser.g:4634:4: (lv_property_1_0= ruleQualifiedName )
            {
            // InternalBehaviorAnnexParser.g:4634:4: (lv_property_1_0= ruleQualifiedName )
            // InternalBehaviorAnnexParser.g:4635:5: lv_property_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyIndexPropertyReferenceAccess().getPropertyQualifiedNameParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_property_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPropertyIndexPropertyReferenceRule());
              					}
              					set(
              						current,
              						"property",
              						lv_property_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.QualifiedName");
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
    // $ANTLR end "rulePropertyIndexPropertyReference"


    // $ANTLR start "entryRuleUnindexedReferenceExpression"
    // InternalBehaviorAnnexParser.g:4656:1: entryRuleUnindexedReferenceExpression returns [EObject current=null] : iv_ruleUnindexedReferenceExpression= ruleUnindexedReferenceExpression EOF ;
    public final EObject entryRuleUnindexedReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReferenceExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:4656:69: (iv_ruleUnindexedReferenceExpression= ruleUnindexedReferenceExpression EOF )
            // InternalBehaviorAnnexParser.g:4657:2: iv_ruleUnindexedReferenceExpression= ruleUnindexedReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnindexedReferenceExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnindexedReferenceExpression=ruleUnindexedReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnindexedReferenceExpression; 
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
    // $ANTLR end "entryRuleUnindexedReferenceExpression"


    // $ANTLR start "ruleUnindexedReferenceExpression"
    // InternalBehaviorAnnexParser.g:4663:1: ruleUnindexedReferenceExpression returns [EObject current=null] : ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) | ( (lv_updated_5_0= Updated ) ) ) ) )? ) ;
    public final EObject ruleUnindexedReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token lv_dequeue_1_0=null;
        Token otherlv_2=null;
        Token lv_count_3_0=null;
        Token lv_fresh_4_0=null;
        Token lv_updated_5_0=null;
        EObject lv_reference_0_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4669:2: ( ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) | ( (lv_updated_5_0= Updated ) ) ) ) )? ) )
            // InternalBehaviorAnnexParser.g:4670:2: ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) | ( (lv_updated_5_0= Updated ) ) ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:4670:2: ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) | ( (lv_updated_5_0= Updated ) ) ) ) )? )
            // InternalBehaviorAnnexParser.g:4671:3: ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) | ( (lv_updated_5_0= Updated ) ) ) ) )?
            {
            // InternalBehaviorAnnexParser.g:4671:3: ( (lv_reference_0_0= ruleUnindexedReference ) )
            // InternalBehaviorAnnexParser.g:4672:4: (lv_reference_0_0= ruleUnindexedReference )
            {
            // InternalBehaviorAnnexParser.g:4672:4: (lv_reference_0_0= ruleUnindexedReference )
            // InternalBehaviorAnnexParser.g:4673:5: lv_reference_0_0= ruleUnindexedReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnindexedReferenceExpressionAccess().getReferenceUnindexedReferenceParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_76);
            lv_reference_0_0=ruleUnindexedReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnindexedReferenceExpressionRule());
              					}
              					set(
              						current,
              						"reference",
              						lv_reference_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:4690:3: ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) | ( (lv_updated_5_0= Updated ) ) ) ) )?
            int alt86=3;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==QuestionMark) ) {
                alt86=1;
            }
            else if ( (LA86_0==Apostrophe) ) {
                alt86=2;
            }
            switch (alt86) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4691:4: ( (lv_dequeue_1_0= QuestionMark ) )
                    {
                    // InternalBehaviorAnnexParser.g:4691:4: ( (lv_dequeue_1_0= QuestionMark ) )
                    // InternalBehaviorAnnexParser.g:4692:5: (lv_dequeue_1_0= QuestionMark )
                    {
                    // InternalBehaviorAnnexParser.g:4692:5: (lv_dequeue_1_0= QuestionMark )
                    // InternalBehaviorAnnexParser.g:4693:6: lv_dequeue_1_0= QuestionMark
                    {
                    lv_dequeue_1_0=(Token)match(input,QuestionMark,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_dequeue_1_0, grammarAccess.getUnindexedReferenceExpressionAccess().getDequeueQuestionMarkKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnindexedReferenceExpressionRule());
                      						}
                      						setWithLastConsumed(current, "dequeue", lv_dequeue_1_0 != null, "?");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:4706:4: (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) | ( (lv_updated_5_0= Updated ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:4706:4: (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) | ( (lv_updated_5_0= Updated ) ) ) )
                    // InternalBehaviorAnnexParser.g:4707:5: otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) | ( (lv_updated_5_0= Updated ) ) )
                    {
                    otherlv_2=(Token)match(input,Apostrophe,FollowSets000.FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getUnindexedReferenceExpressionAccess().getApostropheKeyword_1_1_0());
                      				
                    }
                    // InternalBehaviorAnnexParser.g:4711:5: ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) | ( (lv_updated_5_0= Updated ) ) )
                    int alt85=3;
                    switch ( input.LA(1) ) {
                    case Count:
                        {
                        alt85=1;
                        }
                        break;
                    case Fresh:
                        {
                        alt85=2;
                        }
                        break;
                    case Updated:
                        {
                        alt85=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 85, 0, input);

                        throw nvae;
                    }

                    switch (alt85) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:4712:6: ( (lv_count_3_0= Count ) )
                            {
                            // InternalBehaviorAnnexParser.g:4712:6: ( (lv_count_3_0= Count ) )
                            // InternalBehaviorAnnexParser.g:4713:7: (lv_count_3_0= Count )
                            {
                            // InternalBehaviorAnnexParser.g:4713:7: (lv_count_3_0= Count )
                            // InternalBehaviorAnnexParser.g:4714:8: lv_count_3_0= Count
                            {
                            lv_count_3_0=(Token)match(input,Count,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_count_3_0, grammarAccess.getUnindexedReferenceExpressionAccess().getCountCountKeyword_1_1_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getUnindexedReferenceExpressionRule());
                              								}
                              								setWithLastConsumed(current, "count", lv_count_3_0 != null, "count");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBehaviorAnnexParser.g:4727:6: ( (lv_fresh_4_0= Fresh ) )
                            {
                            // InternalBehaviorAnnexParser.g:4727:6: ( (lv_fresh_4_0= Fresh ) )
                            // InternalBehaviorAnnexParser.g:4728:7: (lv_fresh_4_0= Fresh )
                            {
                            // InternalBehaviorAnnexParser.g:4728:7: (lv_fresh_4_0= Fresh )
                            // InternalBehaviorAnnexParser.g:4729:8: lv_fresh_4_0= Fresh
                            {
                            lv_fresh_4_0=(Token)match(input,Fresh,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_fresh_4_0, grammarAccess.getUnindexedReferenceExpressionAccess().getFreshFreshKeyword_1_1_1_1_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getUnindexedReferenceExpressionRule());
                              								}
                              								setWithLastConsumed(current, "fresh", lv_fresh_4_0 != null, "fresh");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalBehaviorAnnexParser.g:4742:6: ( (lv_updated_5_0= Updated ) )
                            {
                            // InternalBehaviorAnnexParser.g:4742:6: ( (lv_updated_5_0= Updated ) )
                            // InternalBehaviorAnnexParser.g:4743:7: (lv_updated_5_0= Updated )
                            {
                            // InternalBehaviorAnnexParser.g:4743:7: (lv_updated_5_0= Updated )
                            // InternalBehaviorAnnexParser.g:4744:8: lv_updated_5_0= Updated
                            {
                            lv_updated_5_0=(Token)match(input,Updated,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_updated_5_0, grammarAccess.getUnindexedReferenceExpressionAccess().getUpdatedUpdatedKeyword_1_1_1_2_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getUnindexedReferenceExpressionRule());
                              								}
                              								setWithLastConsumed(current, "updated", lv_updated_5_0 != null, "updated");
                              							
                            }

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleUnindexedReferenceExpression"


    // $ANTLR start "entryRuleUnindexedReference"
    // InternalBehaviorAnnexParser.g:4763:1: entryRuleUnindexedReference returns [EObject current=null] : iv_ruleUnindexedReference= ruleUnindexedReference EOF ;
    public final EObject entryRuleUnindexedReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReference = null;


        try {
            // InternalBehaviorAnnexParser.g:4763:59: (iv_ruleUnindexedReference= ruleUnindexedReference EOF )
            // InternalBehaviorAnnexParser.g:4764:2: iv_ruleUnindexedReference= ruleUnindexedReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnindexedReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnindexedReference=ruleUnindexedReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnindexedReference; 
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
    // $ANTLR end "entryRuleUnindexedReference"


    // $ANTLR start "ruleUnindexedReference"
    // InternalBehaviorAnnexParser.g:4770:1: ruleUnindexedReference returns [EObject current=null] : ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* ) ;
    public final EObject ruleUnindexedReference() throws RecognitionException {
        EObject current = null;

        EObject lv_segments_0_0 = null;

        EObject lv_tails_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4776:2: ( ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* ) )
            // InternalBehaviorAnnexParser.g:4777:2: ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* )
            {
            // InternalBehaviorAnnexParser.g:4777:2: ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* )
            // InternalBehaviorAnnexParser.g:4778:3: ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )*
            {
            // InternalBehaviorAnnexParser.g:4778:3: ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:4779:4: (lv_segments_0_0= ruleUnindexedReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:4779:4: (lv_segments_0_0= ruleUnindexedReferenceSegment )
            // InternalBehaviorAnnexParser.g:4780:5: lv_segments_0_0= ruleUnindexedReferenceSegment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnindexedReferenceAccess().getSegmentsUnindexedReferenceSegmentParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_77);
            lv_segments_0_0=ruleUnindexedReferenceSegment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnindexedReferenceRule());
              					}
              					add(
              						current,
              						"segments",
              						lv_segments_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReferenceSegment");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:4797:3: ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==ColonColon||LA87_0==FullStop) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:4798:4: (lv_tails_1_0= ruleUnindexedReferenceTail )
            	    {
            	    // InternalBehaviorAnnexParser.g:4798:4: (lv_tails_1_0= ruleUnindexedReferenceTail )
            	    // InternalBehaviorAnnexParser.g:4799:5: lv_tails_1_0= ruleUnindexedReferenceTail
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnindexedReferenceAccess().getTailsUnindexedReferenceTailParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_77);
            	    lv_tails_1_0=ruleUnindexedReferenceTail();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getUnindexedReferenceRule());
            	      					}
            	      					add(
            	      						current,
            	      						"tails",
            	      						lv_tails_1_0,
            	      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReferenceTail");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop87;
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
    // $ANTLR end "ruleUnindexedReference"


    // $ANTLR start "entryRuleUnindexedReferenceTail"
    // InternalBehaviorAnnexParser.g:4820:1: entryRuleUnindexedReferenceTail returns [EObject current=null] : iv_ruleUnindexedReferenceTail= ruleUnindexedReferenceTail EOF ;
    public final EObject entryRuleUnindexedReferenceTail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReferenceTail = null;


        try {
            // InternalBehaviorAnnexParser.g:4820:63: (iv_ruleUnindexedReferenceTail= ruleUnindexedReferenceTail EOF )
            // InternalBehaviorAnnexParser.g:4821:2: iv_ruleUnindexedReferenceTail= ruleUnindexedReferenceTail EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnindexedReferenceTailRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnindexedReferenceTail=ruleUnindexedReferenceTail();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnindexedReferenceTail; 
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
    // $ANTLR end "entryRuleUnindexedReferenceTail"


    // $ANTLR start "ruleUnindexedReferenceTail"
    // InternalBehaviorAnnexParser.g:4827:1: ruleUnindexedReferenceTail returns [EObject current=null] : ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) ) ;
    public final EObject ruleUnindexedReferenceTail() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_separator_0_0 = null;

        EObject lv_segment_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4833:2: ( ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) ) )
            // InternalBehaviorAnnexParser.g:4834:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) )
            {
            // InternalBehaviorAnnexParser.g:4834:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) )
            // InternalBehaviorAnnexParser.g:4835:3: ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) )
            {
            // InternalBehaviorAnnexParser.g:4835:3: ( (lv_separator_0_0= ruleReferenceSeparator ) )
            // InternalBehaviorAnnexParser.g:4836:4: (lv_separator_0_0= ruleReferenceSeparator )
            {
            // InternalBehaviorAnnexParser.g:4836:4: (lv_separator_0_0= ruleReferenceSeparator )
            // InternalBehaviorAnnexParser.g:4837:5: lv_separator_0_0= ruleReferenceSeparator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnindexedReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_75);
            lv_separator_0_0=ruleReferenceSeparator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnindexedReferenceTailRule());
              					}
              					set(
              						current,
              						"separator",
              						lv_separator_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceSeparator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:4854:3: ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:4855:4: (lv_segment_1_0= ruleUnindexedReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:4855:4: (lv_segment_1_0= ruleUnindexedReferenceSegment )
            // InternalBehaviorAnnexParser.g:4856:5: lv_segment_1_0= ruleUnindexedReferenceSegment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnindexedReferenceTailAccess().getSegmentUnindexedReferenceSegmentParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_segment_1_0=ruleUnindexedReferenceSegment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnindexedReferenceTailRule());
              					}
              					set(
              						current,
              						"segment",
              						lv_segment_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReferenceSegment");
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
    // $ANTLR end "ruleUnindexedReferenceTail"


    // $ANTLR start "entryRuleUnindexedReferenceSegment"
    // InternalBehaviorAnnexParser.g:4877:1: entryRuleUnindexedReferenceSegment returns [EObject current=null] : iv_ruleUnindexedReferenceSegment= ruleUnindexedReferenceSegment EOF ;
    public final EObject entryRuleUnindexedReferenceSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReferenceSegment = null;


        try {
            // InternalBehaviorAnnexParser.g:4877:66: (iv_ruleUnindexedReferenceSegment= ruleUnindexedReferenceSegment EOF )
            // InternalBehaviorAnnexParser.g:4878:2: iv_ruleUnindexedReferenceSegment= ruleUnindexedReferenceSegment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnindexedReferenceSegmentRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnindexedReferenceSegment=ruleUnindexedReferenceSegment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnindexedReferenceSegment; 
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
    // $ANTLR end "entryRuleUnindexedReferenceSegment"


    // $ANTLR start "ruleUnindexedReferenceSegment"
    // InternalBehaviorAnnexParser.g:4884:1: ruleUnindexedReferenceSegment returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleUnindexedReferenceSegment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4890:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalBehaviorAnnexParser.g:4891:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalBehaviorAnnexParser.g:4891:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:4892:3: (lv_name_0_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:4892:3: (lv_name_0_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:4893:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_name_0_0, grammarAccess.getUnindexedReferenceSegmentAccess().getNameIDTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getUnindexedReferenceSegmentRule());
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
    // $ANTLR end "ruleUnindexedReferenceSegment"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalBehaviorAnnexParser.g:4912:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalBehaviorAnnexParser.g:4912:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalBehaviorAnnexParser.g:4913:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalBehaviorAnnexParser.g:4919:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4925:2: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* ) )
            // InternalBehaviorAnnexParser.g:4926:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* )
            {
            // InternalBehaviorAnnexParser.g:4926:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* )
            // InternalBehaviorAnnexParser.g:4927:3: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_78); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalBehaviorAnnexParser.g:4934:3: (kw= ColonColon this_ID_2= RULE_ID )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==ColonColon) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:4935:4: kw= ColonColon this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_78); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop88;
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleReference"
    // InternalBehaviorAnnexParser.g:4952:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalBehaviorAnnexParser.g:4952:50: (iv_ruleReference= ruleReference EOF )
            // InternalBehaviorAnnexParser.g:4953:2: iv_ruleReference= ruleReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReference=ruleReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReference; 
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
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalBehaviorAnnexParser.g:4959:1: ruleReference returns [EObject current=null] : ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        EObject lv_segments_0_0 = null;

        EObject lv_tails_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4965:2: ( ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* ) )
            // InternalBehaviorAnnexParser.g:4966:2: ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* )
            {
            // InternalBehaviorAnnexParser.g:4966:2: ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* )
            // InternalBehaviorAnnexParser.g:4967:3: ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )*
            {
            // InternalBehaviorAnnexParser.g:4967:3: ( (lv_segments_0_0= ruleReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:4968:4: (lv_segments_0_0= ruleReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:4968:4: (lv_segments_0_0= ruleReferenceSegment )
            // InternalBehaviorAnnexParser.g:4969:5: lv_segments_0_0= ruleReferenceSegment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getReferenceAccess().getSegmentsReferenceSegmentParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_77);
            lv_segments_0_0=ruleReferenceSegment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getReferenceRule());
              					}
              					add(
              						current,
              						"segments",
              						lv_segments_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceSegment");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:4986:3: ( (lv_tails_1_0= ruleReferenceTail ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==ColonColon||LA89_0==FullStop) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:4987:4: (lv_tails_1_0= ruleReferenceTail )
            	    {
            	    // InternalBehaviorAnnexParser.g:4987:4: (lv_tails_1_0= ruleReferenceTail )
            	    // InternalBehaviorAnnexParser.g:4988:5: lv_tails_1_0= ruleReferenceTail
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getReferenceAccess().getTailsReferenceTailParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_77);
            	    lv_tails_1_0=ruleReferenceTail();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getReferenceRule());
            	      					}
            	      					add(
            	      						current,
            	      						"tails",
            	      						lv_tails_1_0,
            	      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceTail");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop89;
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
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleReferenceTail"
    // InternalBehaviorAnnexParser.g:5009:1: entryRuleReferenceTail returns [EObject current=null] : iv_ruleReferenceTail= ruleReferenceTail EOF ;
    public final EObject entryRuleReferenceTail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTail = null;


        try {
            // InternalBehaviorAnnexParser.g:5009:54: (iv_ruleReferenceTail= ruleReferenceTail EOF )
            // InternalBehaviorAnnexParser.g:5010:2: iv_ruleReferenceTail= ruleReferenceTail EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTailRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReferenceTail=ruleReferenceTail();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceTail; 
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
    // $ANTLR end "entryRuleReferenceTail"


    // $ANTLR start "ruleReferenceTail"
    // InternalBehaviorAnnexParser.g:5016:1: ruleReferenceTail returns [EObject current=null] : ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) ) ;
    public final EObject ruleReferenceTail() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_separator_0_0 = null;

        EObject lv_segment_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5022:2: ( ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) ) )
            // InternalBehaviorAnnexParser.g:5023:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) )
            {
            // InternalBehaviorAnnexParser.g:5023:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) )
            // InternalBehaviorAnnexParser.g:5024:3: ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) )
            {
            // InternalBehaviorAnnexParser.g:5024:3: ( (lv_separator_0_0= ruleReferenceSeparator ) )
            // InternalBehaviorAnnexParser.g:5025:4: (lv_separator_0_0= ruleReferenceSeparator )
            {
            // InternalBehaviorAnnexParser.g:5025:4: (lv_separator_0_0= ruleReferenceSeparator )
            // InternalBehaviorAnnexParser.g:5026:5: lv_separator_0_0= ruleReferenceSeparator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_14);
            lv_separator_0_0=ruleReferenceSeparator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getReferenceTailRule());
              					}
              					set(
              						current,
              						"separator",
              						lv_separator_0_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceSeparator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:5043:3: ( (lv_segment_1_0= ruleReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:5044:4: (lv_segment_1_0= ruleReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:5044:4: (lv_segment_1_0= ruleReferenceSegment )
            // InternalBehaviorAnnexParser.g:5045:5: lv_segment_1_0= ruleReferenceSegment
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getReferenceTailAccess().getSegmentReferenceSegmentParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_segment_1_0=ruleReferenceSegment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getReferenceTailRule());
              					}
              					set(
              						current,
              						"segment",
              						lv_segment_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceSegment");
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
    // $ANTLR end "ruleReferenceTail"


    // $ANTLR start "entryRuleReferenceSeparator"
    // InternalBehaviorAnnexParser.g:5066:1: entryRuleReferenceSeparator returns [String current=null] : iv_ruleReferenceSeparator= ruleReferenceSeparator EOF ;
    public final String entryRuleReferenceSeparator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReferenceSeparator = null;


        try {
            // InternalBehaviorAnnexParser.g:5066:58: (iv_ruleReferenceSeparator= ruleReferenceSeparator EOF )
            // InternalBehaviorAnnexParser.g:5067:2: iv_ruleReferenceSeparator= ruleReferenceSeparator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceSeparatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReferenceSeparator=ruleReferenceSeparator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceSeparator.getText(); 
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
    // $ANTLR end "entryRuleReferenceSeparator"


    // $ANTLR start "ruleReferenceSeparator"
    // InternalBehaviorAnnexParser.g:5073:1: ruleReferenceSeparator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= ColonColon | kw= FullStop ) ;
    public final AntlrDatatypeRuleToken ruleReferenceSeparator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5079:2: ( (kw= ColonColon | kw= FullStop ) )
            // InternalBehaviorAnnexParser.g:5080:2: (kw= ColonColon | kw= FullStop )
            {
            // InternalBehaviorAnnexParser.g:5080:2: (kw= ColonColon | kw= FullStop )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==ColonColon) ) {
                alt90=1;
            }
            else if ( (LA90_0==FullStop) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5081:3: kw= ColonColon
                    {
                    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getReferenceSeparatorAccess().getColonColonKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:5087:3: kw= FullStop
                    {
                    kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getReferenceSeparatorAccess().getFullStopKeyword_1());
                      		
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
    // $ANTLR end "ruleReferenceSeparator"


    // $ANTLR start "entryRuleReferenceSegment"
    // InternalBehaviorAnnexParser.g:5096:1: entryRuleReferenceSegment returns [EObject current=null] : iv_ruleReferenceSegment= ruleReferenceSegment EOF ;
    public final EObject entryRuleReferenceSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSegment = null;


        try {
            // InternalBehaviorAnnexParser.g:5096:57: (iv_ruleReferenceSegment= ruleReferenceSegment EOF )
            // InternalBehaviorAnnexParser.g:5097:2: iv_ruleReferenceSegment= ruleReferenceSegment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceSegmentRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReferenceSegment=ruleReferenceSegment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceSegment; 
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
    // $ANTLR end "entryRuleReferenceSegment"


    // $ANTLR start "ruleReferenceSegment"
    // InternalBehaviorAnnexParser.g:5103:1: ruleReferenceSegment returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* ) ;
    public final EObject ruleReferenceSegment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_indexes_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5109:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* ) )
            // InternalBehaviorAnnexParser.g:5110:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* )
            {
            // InternalBehaviorAnnexParser.g:5110:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* )
            // InternalBehaviorAnnexParser.g:5111:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )*
            {
            // InternalBehaviorAnnexParser.g:5111:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:5112:4: (lv_name_0_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:5112:4: (lv_name_0_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:5113:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getReferenceSegmentAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getReferenceSegmentRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:5129:3: ( (lv_indexes_1_0= ruleArrayIndex ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==LeftSquareBracket) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:5130:4: (lv_indexes_1_0= ruleArrayIndex )
            	    {
            	    // InternalBehaviorAnnexParser.g:5130:4: (lv_indexes_1_0= ruleArrayIndex )
            	    // InternalBehaviorAnnexParser.g:5131:5: lv_indexes_1_0= ruleArrayIndex
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getReferenceSegmentAccess().getIndexesArrayIndexParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_13);
            	    lv_indexes_1_0=ruleArrayIndex();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getReferenceSegmentRule());
            	      					}
            	      					add(
            	      						current,
            	      						"indexes",
            	      						lv_indexes_1_0,
            	      						"org.osate.xtext.aadl2.ba.BehaviorAnnex.ArrayIndex");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop91;
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
    // $ANTLR end "ruleReferenceSegment"


    // $ANTLR start "entryRuleArrayIndex"
    // InternalBehaviorAnnexParser.g:5152:1: entryRuleArrayIndex returns [EObject current=null] : iv_ruleArrayIndex= ruleArrayIndex EOF ;
    public final EObject entryRuleArrayIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayIndex = null;


        try {
            // InternalBehaviorAnnexParser.g:5152:51: (iv_ruleArrayIndex= ruleArrayIndex EOF )
            // InternalBehaviorAnnexParser.g:5153:2: iv_ruleArrayIndex= ruleArrayIndex EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayIndexRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleArrayIndex=ruleArrayIndex();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayIndex; 
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
    // $ANTLR end "entryRuleArrayIndex"


    // $ANTLR start "ruleArrayIndex"
    // InternalBehaviorAnnexParser.g:5159:1: ruleArrayIndex returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket ) ;
    public final EObject ruleArrayIndex() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5165:2: ( (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:5166:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:5166:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:5167:3: otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArrayIndexAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:5171:3: ( (lv_value_1_0= ruleIntegerValue ) )
            // InternalBehaviorAnnexParser.g:5172:4: (lv_value_1_0= ruleIntegerValue )
            {
            // InternalBehaviorAnnexParser.g:5172:4: (lv_value_1_0= ruleIntegerValue )
            // InternalBehaviorAnnexParser.g:5173:5: lv_value_1_0= ruleIntegerValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArrayIndexAccess().getValueIntegerValueParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_15);
            lv_value_1_0=ruleIntegerValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArrayIndexRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.osate.xtext.aadl2.ba.BehaviorAnnex.IntegerValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getArrayIndexAccess().getRightSquareBracketKeyword_2());
              		
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
    // $ANTLR end "ruleArrayIndex"


    // $ANTLR start "entryRuleContainedPropertyAssociation"
    // InternalBehaviorAnnexParser.g:5198:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalBehaviorAnnexParser.g:5198:69: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalBehaviorAnnexParser.g:5199:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
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
    // InternalBehaviorAnnexParser.g:5205:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon ) ;
    public final EObject ruleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_append_2_0=null;
        Token lv_constant_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_ownedValue_4_0 = null;

        EObject lv_ownedValue_6_0 = null;

        EObject lv_appliesTo_9_0 = null;

        EObject lv_appliesTo_11_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5211:2: ( ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon ) )
            // InternalBehaviorAnnexParser.g:5212:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon )
            {
            // InternalBehaviorAnnexParser.g:5212:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon )
            // InternalBehaviorAnnexParser.g:5213:3: ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon
            {
            // InternalBehaviorAnnexParser.g:5213:3: ( ( ruleQPREF ) )
            // InternalBehaviorAnnexParser.g:5214:4: ( ruleQPREF )
            {
            // InternalBehaviorAnnexParser.g:5214:4: ( ruleQPREF )
            // InternalBehaviorAnnexParser.g:5215:5: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_79);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:5229:3: (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==EqualsSignGreaterThanSign) ) {
                alt92=1;
            }
            else if ( (LA92_0==PlusSignEqualsSignGreaterThanSign) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5230:4: otherlv_1= EqualsSignGreaterThanSign
                    {
                    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_80); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:5235:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    {
                    // InternalBehaviorAnnexParser.g:5235:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    // InternalBehaviorAnnexParser.g:5236:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    {
                    // InternalBehaviorAnnexParser.g:5236:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    // InternalBehaviorAnnexParser.g:5237:6: lv_append_2_0= PlusSignEqualsSignGreaterThanSign
                    {
                    lv_append_2_0=(Token)match(input,PlusSignEqualsSignGreaterThanSign,FollowSets000.FOLLOW_80); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      						}
                      						setWithLastConsumed(current, "append", lv_append_2_0 != null, "+=>");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:5250:3: ( (lv_constant_3_0= Constant ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==Constant) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5251:4: (lv_constant_3_0= Constant )
                    {
                    // InternalBehaviorAnnexParser.g:5251:4: (lv_constant_3_0= Constant )
                    // InternalBehaviorAnnexParser.g:5252:5: lv_constant_3_0= Constant
                    {
                    lv_constant_3_0=(Token)match(input,Constant,FollowSets000.FOLLOW_80); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      					}
                      					setWithLastConsumed(current, "constant", lv_constant_3_0 != null, "constant");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:5264:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalBehaviorAnnexParser.g:5265:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalBehaviorAnnexParser.g:5265:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalBehaviorAnnexParser.g:5266:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalBehaviorAnnexParser.g:5266:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalBehaviorAnnexParser.g:5267:6: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());
              					
            }
            pushFollow(FollowSets000.FOLLOW_81);
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

            // InternalBehaviorAnnexParser.g:5284:4: (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==Comma) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:5285:5: otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_80); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	      				
            	    }
            	    // InternalBehaviorAnnexParser.g:5289:5: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalBehaviorAnnexParser.g:5290:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalBehaviorAnnexParser.g:5290:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalBehaviorAnnexParser.g:5291:7: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_81);
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
            	    break loop94;
                }
            } while (true);


            }

            // InternalBehaviorAnnexParser.g:5310:3: (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==Applies) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5311:4: otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    {
                    otherlv_7=(Token)match(input,Applies,FollowSets000.FOLLOW_82); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getContainedPropertyAssociationAccess().getAppliesKeyword_4_0());
                      			
                    }
                    otherlv_8=(Token)match(input,To,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getContainedPropertyAssociationAccess().getToKeyword_4_1());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:5319:4: ( (lv_appliesTo_9_0= ruleContainmentPath ) )
                    // InternalBehaviorAnnexParser.g:5320:5: (lv_appliesTo_9_0= ruleContainmentPath )
                    {
                    // InternalBehaviorAnnexParser.g:5320:5: (lv_appliesTo_9_0= ruleContainmentPath )
                    // InternalBehaviorAnnexParser.g:5321:6: lv_appliesTo_9_0= ruleContainmentPath
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_83);
                    lv_appliesTo_9_0=ruleContainmentPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                      						}
                      						add(
                      							current,
                      							"appliesTo",
                      							lv_appliesTo_9_0,
                      							"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:5338:4: (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==Comma) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // InternalBehaviorAnnexParser.g:5339:5: otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_10=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_10, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_3_0());
                    	      				
                    	    }
                    	    // InternalBehaviorAnnexParser.g:5343:5: ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                    	    // InternalBehaviorAnnexParser.g:5344:6: (lv_appliesTo_11_0= ruleContainmentPath )
                    	    {
                    	    // InternalBehaviorAnnexParser.g:5344:6: (lv_appliesTo_11_0= ruleContainmentPath )
                    	    // InternalBehaviorAnnexParser.g:5345:7: lv_appliesTo_11_0= ruleContainmentPath
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_83);
                    	    lv_appliesTo_11_0=ruleContainmentPath();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"appliesTo",
                    	      								lv_appliesTo_11_0,
                    	      								"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop95;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:5364:3: (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==In) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5365:4: otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis
                    {
                    otherlv_12=(Token)match(input,In,FollowSets000.FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getInKeyword_5_0());
                      			
                    }
                    otherlv_13=(Token)match(input,Binding,FollowSets000.FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getContainedPropertyAssociationAccess().getBindingKeyword_5_1());
                      			
                    }
                    otherlv_14=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_2());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:5377:4: ( ( ruleQCREF ) )
                    // InternalBehaviorAnnexParser.g:5378:5: ( ruleQCREF )
                    {
                    // InternalBehaviorAnnexParser.g:5378:5: ( ruleQCREF )
                    // InternalBehaviorAnnexParser.g:5379:6: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_3_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_39);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_16=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_17=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_17, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
              		
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


    // $ANTLR start "entryRuleContainmentPath"
    // InternalBehaviorAnnexParser.g:5406:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalBehaviorAnnexParser.g:5406:56: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalBehaviorAnnexParser.g:5407:2: iv_ruleContainmentPath= ruleContainmentPath EOF
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
    // InternalBehaviorAnnexParser.g:5413:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5419:2: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalBehaviorAnnexParser.g:5420:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalBehaviorAnnexParser.g:5420:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalBehaviorAnnexParser.g:5421:3: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalBehaviorAnnexParser.g:5421:3: (lv_path_0_0= ruleContainmentPathElement )
            // InternalBehaviorAnnexParser.g:5422:4: lv_path_0_0= ruleContainmentPathElement
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
    // InternalBehaviorAnnexParser.g:5442:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalBehaviorAnnexParser.g:5442:67: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalBehaviorAnnexParser.g:5443:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
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
    // InternalBehaviorAnnexParser.g:5449:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? ) ;
    public final EObject ruleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_ownedValue_0_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5455:2: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? ) )
            // InternalBehaviorAnnexParser.g:5456:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? )
            {
            // InternalBehaviorAnnexParser.g:5456:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? )
            // InternalBehaviorAnnexParser.g:5457:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )?
            {
            // InternalBehaviorAnnexParser.g:5457:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalBehaviorAnnexParser.g:5458:4: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalBehaviorAnnexParser.g:5458:4: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalBehaviorAnnexParser.g:5459:5: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_53);
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
              						"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:5476:3: (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==In) ) {
                int LA99_1 = input.LA(2);

                if ( (LA99_1==Modes) ) {
                    alt99=1;
                }
            }
            switch (alt99) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5477:4: otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis
                    {
                    otherlv_1=(Token)match(input,In,FollowSets000.FOLLOW_84); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0());
                      			
                    }
                    otherlv_2=(Token)match(input,Modes,FollowSets000.FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1());
                      			
                    }
                    otherlv_3=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:5489:4: ( (otherlv_4= RULE_ID ) )
                    // InternalBehaviorAnnexParser.g:5490:5: (otherlv_4= RULE_ID )
                    {
                    // InternalBehaviorAnnexParser.g:5490:5: (otherlv_4= RULE_ID )
                    // InternalBehaviorAnnexParser.g:5491:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                      						}
                      					
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0());
                      					
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:5502:4: (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )*
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==Comma) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // InternalBehaviorAnnexParser.g:5503:5: otherlv_5= Comma ( (otherlv_6= RULE_ID ) )
                    	    {
                    	    otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0());
                    	      				
                    	    }
                    	    // InternalBehaviorAnnexParser.g:5507:5: ( (otherlv_6= RULE_ID ) )
                    	    // InternalBehaviorAnnexParser.g:5508:6: (otherlv_6= RULE_ID )
                    	    {
                    	    // InternalBehaviorAnnexParser.g:5508:6: (otherlv_6= RULE_ID )
                    	    // InternalBehaviorAnnexParser.g:5509:7: otherlv_6= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop98;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_5());
                      			
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
    // InternalBehaviorAnnexParser.g:5530:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalBehaviorAnnexParser.g:5530:54: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalBehaviorAnnexParser.g:5531:2: iv_rulePropertyValue= rulePropertyValue EOF
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
    // InternalBehaviorAnnexParser.g:5537:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5543:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalBehaviorAnnexParser.g:5544:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalBehaviorAnnexParser.g:5544:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalBehaviorAnnexParser.g:5545:3: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalBehaviorAnnexParser.g:5545:3: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalBehaviorAnnexParser.g:5546:4: lv_ownedValue_0_0= rulePropertyExpression
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
              					"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
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


    // $ANTLR start "entryRulePropertyExpression"
    // InternalBehaviorAnnexParser.g:5566:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:5566:59: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalBehaviorAnnexParser.g:5567:2: iv_rulePropertyExpression= rulePropertyExpression EOF
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
    // InternalBehaviorAnnexParser.g:5573:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RecordTerm_0 = null;

        EObject this_ReferenceTerm_1 = null;

        EObject this_ComponentClassifierTerm_2 = null;

        EObject this_ComputedTerm_3 = null;

        EObject this_StringTerm_4 = null;

        EObject this_NumericRangeTerm_5 = null;

        EObject this_RealTerm_6 = null;

        EObject this_IntegerTerm_7 = null;

        EObject this_ListTerm_8 = null;

        EObject this_BooleanLiteral_9 = null;

        EObject this_LiteralorReferenceTerm_10 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5579:2: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) )
            // InternalBehaviorAnnexParser.g:5580:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            {
            // InternalBehaviorAnnexParser.g:5580:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            int alt100=11;
            alt100 = dfa100.predict(input);
            switch (alt100) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5581:3: this_RecordTerm_0= ruleRecordTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RecordTerm_0=ruleRecordTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RecordTerm_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:5590:3: this_ReferenceTerm_1= ruleReferenceTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReferenceTerm_1=ruleReferenceTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ReferenceTerm_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalBehaviorAnnexParser.g:5599:3: this_ComponentClassifierTerm_2= ruleComponentClassifierTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ComponentClassifierTerm_2=ruleComponentClassifierTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ComponentClassifierTerm_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalBehaviorAnnexParser.g:5608:3: this_ComputedTerm_3= ruleComputedTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ComputedTerm_3=ruleComputedTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ComputedTerm_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalBehaviorAnnexParser.g:5617:3: this_StringTerm_4= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_StringTerm_4=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringTerm_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalBehaviorAnnexParser.g:5626:3: this_NumericRangeTerm_5= ruleNumericRangeTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NumericRangeTerm_5=ruleNumericRangeTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NumericRangeTerm_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalBehaviorAnnexParser.g:5635:3: this_RealTerm_6= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RealTerm_6=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RealTerm_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalBehaviorAnnexParser.g:5644:3: this_IntegerTerm_7= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_IntegerTerm_7=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntegerTerm_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalBehaviorAnnexParser.g:5653:3: this_ListTerm_8= ruleListTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ListTerm_8=ruleListTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ListTerm_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalBehaviorAnnexParser.g:5662:3: this_BooleanLiteral_9= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BooleanLiteral_9=ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanLiteral_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalBehaviorAnnexParser.g:5671:3: this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralorReferenceTerm_10=ruleLiteralorReferenceTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralorReferenceTerm_10;
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
    // $ANTLR end "rulePropertyExpression"


    // $ANTLR start "entryRuleLiteralorReferenceTerm"
    // InternalBehaviorAnnexParser.g:5683:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5683:63: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalBehaviorAnnexParser.g:5684:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralorReferenceTerm; 
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
    // $ANTLR end "entryRuleLiteralorReferenceTerm"


    // $ANTLR start "ruleLiteralorReferenceTerm"
    // InternalBehaviorAnnexParser.g:5690:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5696:2: ( ( ( ruleQPREF ) ) )
            // InternalBehaviorAnnexParser.g:5697:2: ( ( ruleQPREF ) )
            {
            // InternalBehaviorAnnexParser.g:5697:2: ( ( ruleQPREF ) )
            // InternalBehaviorAnnexParser.g:5698:3: ( ruleQPREF )
            {
            // InternalBehaviorAnnexParser.g:5698:3: ( ruleQPREF )
            // InternalBehaviorAnnexParser.g:5699:4: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0());
              			
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
    // $ANTLR end "ruleLiteralorReferenceTerm"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalBehaviorAnnexParser.g:5716:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:5716:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalBehaviorAnnexParser.g:5717:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteral; 
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
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalBehaviorAnnexParser.g:5723:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5729:2: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalBehaviorAnnexParser.g:5730:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalBehaviorAnnexParser.g:5730:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalBehaviorAnnexParser.g:5731:3: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalBehaviorAnnexParser.g:5731:3: ()
            // InternalBehaviorAnnexParser.g:5732:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalBehaviorAnnexParser.g:5738:3: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==True) ) {
                alt101=1;
            }
            else if ( (LA101_0==False) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5739:4: ( (lv_value_1_0= True ) )
                    {
                    // InternalBehaviorAnnexParser.g:5739:4: ( (lv_value_1_0= True ) )
                    // InternalBehaviorAnnexParser.g:5740:5: (lv_value_1_0= True )
                    {
                    // InternalBehaviorAnnexParser.g:5740:5: (lv_value_1_0= True )
                    // InternalBehaviorAnnexParser.g:5741:6: lv_value_1_0= True
                    {
                    lv_value_1_0=(Token)match(input,True,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBooleanLiteralRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_1_0 != null, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:5754:4: otherlv_2= False
                    {
                    otherlv_2=(Token)match(input,False,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
                      			
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
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleConstantValue"
    // InternalBehaviorAnnexParser.g:5763:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalBehaviorAnnexParser.g:5763:54: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalBehaviorAnnexParser.g:5764:2: iv_ruleConstantValue= ruleConstantValue EOF
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
    // InternalBehaviorAnnexParser.g:5770:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5776:2: ( ( ( ruleQPREF ) ) )
            // InternalBehaviorAnnexParser.g:5777:2: ( ( ruleQPREF ) )
            {
            // InternalBehaviorAnnexParser.g:5777:2: ( ( ruleQPREF ) )
            // InternalBehaviorAnnexParser.g:5778:3: ( ruleQPREF )
            {
            // InternalBehaviorAnnexParser.g:5778:3: ( ruleQPREF )
            // InternalBehaviorAnnexParser.g:5779:4: ruleQPREF
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


    // $ANTLR start "entryRuleReferenceTerm"
    // InternalBehaviorAnnexParser.g:5796:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5796:54: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalBehaviorAnnexParser.g:5797:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReferenceTerm=ruleReferenceTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceTerm; 
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
    // $ANTLR end "entryRuleReferenceTerm"


    // $ANTLR start "ruleReferenceTerm"
    // InternalBehaviorAnnexParser.g:5803:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5809:2: ( (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:5810:2: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:5810:2: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            // InternalBehaviorAnnexParser.g:5811:3: otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Reference,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:5819:3: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalBehaviorAnnexParser.g:5820:4: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalBehaviorAnnexParser.g:5820:4: (lv_path_2_0= ruleContainmentPathElement )
            // InternalBehaviorAnnexParser.g:5821:5: lv_path_2_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_39);
            lv_path_2_0=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getReferenceTermRule());
              					}
              					set(
              						current,
              						"path",
              						lv_path_2_0,
              						"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3());
              		
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
    // $ANTLR end "ruleReferenceTerm"


    // $ANTLR start "entryRuleRecordTerm"
    // InternalBehaviorAnnexParser.g:5846:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5846:51: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalBehaviorAnnexParser.g:5847:2: iv_ruleRecordTerm= ruleRecordTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRecordTerm=ruleRecordTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordTerm; 
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
    // $ANTLR end "entryRuleRecordTerm"


    // $ANTLR start "ruleRecordTerm"
    // InternalBehaviorAnnexParser.g:5853:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5859:2: ( (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:5860:2: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:5860:2: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:5861:3: otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalBehaviorAnnexParser.g:5865:3: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt102=0;
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==RULE_ID) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:5866:4: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // InternalBehaviorAnnexParser.g:5866:4: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // InternalBehaviorAnnexParser.g:5867:5: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_85);
            	    lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRecordTermRule());
            	      					}
            	      					add(
            	      						current,
            	      						"ownedFieldValue",
            	      						lv_ownedFieldValue_1_0,
            	      						"org.osate.xtext.aadl2.properties.Properties.FieldPropertyAssociation");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt102 >= 1 ) break loop102;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(102, input);
                        throw eee;
                }
                cnt102++;
            } while (true);

            otherlv_2=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2());
              		
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
    // $ANTLR end "ruleRecordTerm"


    // $ANTLR start "entryRuleComputedTerm"
    // InternalBehaviorAnnexParser.g:5892:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5892:53: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalBehaviorAnnexParser.g:5893:2: iv_ruleComputedTerm= ruleComputedTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComputedTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleComputedTerm=ruleComputedTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComputedTerm; 
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
    // $ANTLR end "entryRuleComputedTerm"


    // $ANTLR start "ruleComputedTerm"
    // InternalBehaviorAnnexParser.g:5899:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5905:2: ( (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:5906:2: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:5906:2: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            // InternalBehaviorAnnexParser.g:5907:3: otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Compute,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:5915:3: ( (lv_function_2_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:5916:4: (lv_function_2_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:5916:4: (lv_function_2_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:5917:5: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_function_2_0, grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getComputedTermRule());
              					}
              					setWithLastConsumed(
              						current,
              						"function",
              						lv_function_2_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3());
              		
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
    // $ANTLR end "ruleComputedTerm"


    // $ANTLR start "entryRuleComponentClassifierTerm"
    // InternalBehaviorAnnexParser.g:5941:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5941:64: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalBehaviorAnnexParser.g:5942:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentClassifierTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentClassifierTerm; 
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
    // $ANTLR end "entryRuleComponentClassifierTerm"


    // $ANTLR start "ruleComponentClassifierTerm"
    // InternalBehaviorAnnexParser.g:5948:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5954:2: ( (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:5955:2: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:5955:2: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            // InternalBehaviorAnnexParser.g:5956:3: otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Classifier,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:5964:3: ( ( ruleQCREF ) )
            // InternalBehaviorAnnexParser.g:5965:4: ( ruleQCREF )
            {
            // InternalBehaviorAnnexParser.g:5965:4: ( ruleQCREF )
            // InternalBehaviorAnnexParser.g:5966:5: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getComponentClassifierTermRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_39);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3());
              		
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
    // $ANTLR end "ruleComponentClassifierTerm"


    // $ANTLR start "entryRuleListTerm"
    // InternalBehaviorAnnexParser.g:5988:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5988:49: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalBehaviorAnnexParser.g:5989:2: iv_ruleListTerm= ruleListTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleListTerm=ruleListTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListTerm; 
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
    // $ANTLR end "entryRuleListTerm"


    // $ANTLR start "ruleListTerm"
    // InternalBehaviorAnnexParser.g:5995:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6001:2: ( ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:6002:2: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:6002:2: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            // InternalBehaviorAnnexParser.g:6003:3: () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis
            {
            // InternalBehaviorAnnexParser.g:6003:3: ()
            // InternalBehaviorAnnexParser.g:6004:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getListTermAccess().getListValueAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_86); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:6014:3: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==Classifier||LA104_0==Reference||LA104_0==Compute||LA104_0==False||LA104_0==True||LA104_0==LeftParenthesis||LA104_0==PlusSign||LA104_0==HyphenMinus||LA104_0==LeftSquareBracket||LA104_0==RULE_REAL_LIT||LA104_0==RULE_INTEGER_LIT||(LA104_0>=RULE_STRING && LA104_0<=RULE_ID)) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6015:4: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalBehaviorAnnexParser.g:6015:4: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalBehaviorAnnexParser.g:6016:5: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalBehaviorAnnexParser.g:6016:5: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalBehaviorAnnexParser.g:6017:6: lv_ownedListElement_2_0= rulePropertyExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_32);
                    lv_ownedListElement_2_0=rulePropertyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getListTermRule());
                      						}
                      						add(
                      							current,
                      							"ownedListElement",
                      							lv_ownedListElement_2_0,
                      							"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:6034:4: (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop103:
                    do {
                        int alt103=2;
                        int LA103_0 = input.LA(1);

                        if ( (LA103_0==Comma) ) {
                            alt103=1;
                        }


                        switch (alt103) {
                    	case 1 :
                    	    // InternalBehaviorAnnexParser.g:6035:5: otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalBehaviorAnnexParser.g:6039:5: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // InternalBehaviorAnnexParser.g:6040:6: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // InternalBehaviorAnnexParser.g:6040:6: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // InternalBehaviorAnnexParser.g:6041:7: lv_ownedListElement_4_0= rulePropertyExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_32);
                    	    lv_ownedListElement_4_0=rulePropertyExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getListTermRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"ownedListElement",
                    	      								lv_ownedListElement_4_0,
                    	      								"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop103;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getListTermAccess().getRightParenthesisKeyword_3());
              		
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
    // $ANTLR end "ruleListTerm"


    // $ANTLR start "entryRuleFieldPropertyAssociation"
    // InternalBehaviorAnnexParser.g:6068:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalBehaviorAnnexParser.g:6068:65: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalBehaviorAnnexParser.g:6069:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
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
    // InternalBehaviorAnnexParser.g:6075:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6081:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) )
            // InternalBehaviorAnnexParser.g:6082:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            {
            // InternalBehaviorAnnexParser.g:6082:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            // InternalBehaviorAnnexParser.g:6083:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon
            {
            // InternalBehaviorAnnexParser.g:6083:3: ( (otherlv_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:6084:4: (otherlv_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:6084:4: (otherlv_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:6085:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:6100:3: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalBehaviorAnnexParser.g:6101:4: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalBehaviorAnnexParser.g:6101:4: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalBehaviorAnnexParser.g:6102:5: lv_ownedValue_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_12);
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
              						"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
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
    // InternalBehaviorAnnexParser.g:6127:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalBehaviorAnnexParser.g:6127:63: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalBehaviorAnnexParser.g:6128:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
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
    // InternalBehaviorAnnexParser.g:6134:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6140:2: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalBehaviorAnnexParser.g:6141:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:6141:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalBehaviorAnnexParser.g:6142:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalBehaviorAnnexParser.g:6142:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* )
            // InternalBehaviorAnnexParser.g:6143:4: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            {
            // InternalBehaviorAnnexParser.g:6143:4: ( (otherlv_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:6144:5: (otherlv_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:6144:5: (otherlv_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:6145:6: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getContainmentPathElementRule());
              						}
              					
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_73); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0());
              					
            }

            }


            }

            // InternalBehaviorAnnexParser.g:6156:4: ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==LeftSquareBracket) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:6157:5: (lv_arrayRange_1_0= ruleArrayRange )
            	    {
            	    // InternalBehaviorAnnexParser.g:6157:5: (lv_arrayRange_1_0= ruleArrayRange )
            	    // InternalBehaviorAnnexParser.g:6158:6: lv_arrayRange_1_0= ruleArrayRange
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_73);
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
            	    break loop105;
                }
            } while (true);


            }

            // InternalBehaviorAnnexParser.g:6176:3: (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==FullStop) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6177:4: otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,FullStop,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:6181:4: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalBehaviorAnnexParser.g:6182:5: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalBehaviorAnnexParser.g:6182:5: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalBehaviorAnnexParser.g:6183:6: lv_path_3_0= ruleContainmentPathElement
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
    // InternalBehaviorAnnexParser.g:6205:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalBehaviorAnnexParser.g:6205:49: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalBehaviorAnnexParser.g:6206:2: iv_rulePlusMinus= rulePlusMinus EOF
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
    // InternalBehaviorAnnexParser.g:6212:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6218:2: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalBehaviorAnnexParser.g:6219:2: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalBehaviorAnnexParser.g:6219:2: (kw= PlusSign | kw= HyphenMinus )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==PlusSign) ) {
                alt107=1;
            }
            else if ( (LA107_0==HyphenMinus) ) {
                alt107=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }
            switch (alt107) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6220:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:6226:3: kw= HyphenMinus
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


    // $ANTLR start "entryRuleStringTerm"
    // InternalBehaviorAnnexParser.g:6235:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:6235:51: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalBehaviorAnnexParser.g:6236:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
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
    // $ANTLR end "entryRuleStringTerm"


    // $ANTLR start "ruleStringTerm"
    // InternalBehaviorAnnexParser.g:6242:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6248:2: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalBehaviorAnnexParser.g:6249:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalBehaviorAnnexParser.g:6249:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalBehaviorAnnexParser.g:6250:3: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalBehaviorAnnexParser.g:6250:3: (lv_value_0_0= ruleNoQuoteString )
            // InternalBehaviorAnnexParser.g:6251:4: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_0_0=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getStringTermRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
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
    // $ANTLR end "ruleStringTerm"


    // $ANTLR start "entryRuleNoQuoteString"
    // InternalBehaviorAnnexParser.g:6271:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalBehaviorAnnexParser.g:6271:53: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalBehaviorAnnexParser.g:6272:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
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
    // InternalBehaviorAnnexParser.g:6278:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6284:2: (this_STRING_0= RULE_STRING )
            // InternalBehaviorAnnexParser.g:6285:2: this_STRING_0= RULE_STRING
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
    // InternalBehaviorAnnexParser.g:6295:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalBehaviorAnnexParser.g:6295:51: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalBehaviorAnnexParser.g:6296:2: iv_ruleArrayRange= ruleArrayRange EOF
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
    // InternalBehaviorAnnexParser.g:6302:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6308:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:6309:2: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:6309:2: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:6310:3: () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket
            {
            // InternalBehaviorAnnexParser.g:6310:3: ()
            // InternalBehaviorAnnexParser.g:6311:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:6321:3: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalBehaviorAnnexParser.g:6322:4: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalBehaviorAnnexParser.g:6322:4: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalBehaviorAnnexParser.g:6323:5: lv_lowerBound_2_0= ruleINTVALUE
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_87);
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

            // InternalBehaviorAnnexParser.g:6340:3: (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==FullStopFullStop) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6341:4: otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:6345:4: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalBehaviorAnnexParser.g:6346:5: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalBehaviorAnnexParser.g:6346:5: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalBehaviorAnnexParser.g:6347:6: lv_upperBound_4_0= ruleINTVALUE
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_15);
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
    // InternalBehaviorAnnexParser.g:6373:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalBehaviorAnnexParser.g:6373:55: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalBehaviorAnnexParser.g:6374:2: iv_ruleSignedConstant= ruleSignedConstant EOF
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
    // InternalBehaviorAnnexParser.g:6380:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6386:2: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalBehaviorAnnexParser.g:6387:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalBehaviorAnnexParser.g:6387:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalBehaviorAnnexParser.g:6388:3: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalBehaviorAnnexParser.g:6388:3: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalBehaviorAnnexParser.g:6389:4: (lv_op_0_0= rulePlusMinus )
            {
            // InternalBehaviorAnnexParser.g:6389:4: (lv_op_0_0= rulePlusMinus )
            // InternalBehaviorAnnexParser.g:6390:5: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_88);
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

            // InternalBehaviorAnnexParser.g:6407:3: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalBehaviorAnnexParser.g:6408:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalBehaviorAnnexParser.g:6408:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalBehaviorAnnexParser.g:6409:5: lv_ownedPropertyExpression_1_0= ruleConstantValue
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
    // InternalBehaviorAnnexParser.g:6430:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:6430:52: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalBehaviorAnnexParser.g:6431:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
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
    // InternalBehaviorAnnexParser.g:6437:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6443:2: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalBehaviorAnnexParser.g:6444:2: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalBehaviorAnnexParser.g:6444:2: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalBehaviorAnnexParser.g:6445:3: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalBehaviorAnnexParser.g:6445:3: ( (lv_value_0_0= ruleSignedInt ) )
            // InternalBehaviorAnnexParser.g:6446:4: (lv_value_0_0= ruleSignedInt )
            {
            // InternalBehaviorAnnexParser.g:6446:4: (lv_value_0_0= ruleSignedInt )
            // InternalBehaviorAnnexParser.g:6447:5: lv_value_0_0= ruleSignedInt
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
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

            // InternalBehaviorAnnexParser.g:6464:3: ( (otherlv_1= RULE_ID ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==RULE_ID) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6465:4: (otherlv_1= RULE_ID )
                    {
                    // InternalBehaviorAnnexParser.g:6465:4: (otherlv_1= RULE_ID )
                    // InternalBehaviorAnnexParser.g:6466:5: otherlv_1= RULE_ID
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
    // InternalBehaviorAnnexParser.g:6481:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // InternalBehaviorAnnexParser.g:6481:49: (iv_ruleSignedInt= ruleSignedInt EOF )
            // InternalBehaviorAnnexParser.g:6482:2: iv_ruleSignedInt= ruleSignedInt EOF
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
    // InternalBehaviorAnnexParser.g:6488:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6494:2: ( ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalBehaviorAnnexParser.g:6495:2: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalBehaviorAnnexParser.g:6495:2: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalBehaviorAnnexParser.g:6496:3: (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // InternalBehaviorAnnexParser.g:6496:3: (kw= PlusSign | kw= HyphenMinus )?
            int alt110=3;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==PlusSign) ) {
                alt110=1;
            }
            else if ( (LA110_0==HyphenMinus) ) {
                alt110=2;
            }
            switch (alt110) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6497:4: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:6503:4: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
    // InternalBehaviorAnnexParser.g:6520:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:6520:49: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalBehaviorAnnexParser.g:6521:2: iv_ruleRealTerm= ruleRealTerm EOF
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
    // InternalBehaviorAnnexParser.g:6527:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6533:2: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalBehaviorAnnexParser.g:6534:2: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalBehaviorAnnexParser.g:6534:2: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalBehaviorAnnexParser.g:6535:3: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalBehaviorAnnexParser.g:6535:3: ( (lv_value_0_0= ruleSignedReal ) )
            // InternalBehaviorAnnexParser.g:6536:4: (lv_value_0_0= ruleSignedReal )
            {
            // InternalBehaviorAnnexParser.g:6536:4: (lv_value_0_0= ruleSignedReal )
            // InternalBehaviorAnnexParser.g:6537:5: lv_value_0_0= ruleSignedReal
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
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
              						"org.osate.xtext.aadl2.properties.Properties.SignedReal");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:6554:3: ( (otherlv_1= RULE_ID ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==RULE_ID) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6555:4: (otherlv_1= RULE_ID )
                    {
                    // InternalBehaviorAnnexParser.g:6555:4: (otherlv_1= RULE_ID )
                    // InternalBehaviorAnnexParser.g:6556:5: otherlv_1= RULE_ID
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


    // $ANTLR start "entryRuleSignedReal"
    // InternalBehaviorAnnexParser.g:6571:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // InternalBehaviorAnnexParser.g:6571:50: (iv_ruleSignedReal= ruleSignedReal EOF )
            // InternalBehaviorAnnexParser.g:6572:2: iv_ruleSignedReal= ruleSignedReal EOF
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
    // InternalBehaviorAnnexParser.g:6578:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6584:2: ( ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // InternalBehaviorAnnexParser.g:6585:2: ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // InternalBehaviorAnnexParser.g:6585:2: ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT )
            // InternalBehaviorAnnexParser.g:6586:3: (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // InternalBehaviorAnnexParser.g:6586:3: (kw= PlusSign | kw= HyphenMinus )?
            int alt112=3;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==PlusSign) ) {
                alt112=1;
            }
            else if ( (LA112_0==HyphenMinus) ) {
                alt112=2;
            }
            switch (alt112) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6587:4: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_89); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:6593:4: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_89); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            this_REAL_LIT_2=(Token)match(input,RULE_REAL_LIT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_REAL_LIT_2);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_REAL_LIT_2, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1());
              		
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
    // $ANTLR end "ruleSignedReal"


    // $ANTLR start "entryRuleNumericRangeTerm"
    // InternalBehaviorAnnexParser.g:6610:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:6610:57: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalBehaviorAnnexParser.g:6611:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericRangeTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNumericRangeTerm=ruleNumericRangeTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericRangeTerm; 
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
    // $ANTLR end "entryRuleNumericRangeTerm"


    // $ANTLR start "ruleNumericRangeTerm"
    // InternalBehaviorAnnexParser.g:6617:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6623:2: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalBehaviorAnnexParser.g:6624:2: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:6624:2: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalBehaviorAnnexParser.g:6625:3: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalBehaviorAnnexParser.g:6625:3: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalBehaviorAnnexParser.g:6626:4: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalBehaviorAnnexParser.g:6626:4: (lv_minimum_0_0= ruleNumAlt )
            // InternalBehaviorAnnexParser.g:6627:5: lv_minimum_0_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_90);
            lv_minimum_0_0=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
              					}
              					set(
              						current,
              						"minimum",
              						lv_minimum_0_0,
              						"org.osate.xtext.aadl2.properties.Properties.NumAlt");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_88); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
              		
            }
            // InternalBehaviorAnnexParser.g:6648:3: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalBehaviorAnnexParser.g:6649:4: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalBehaviorAnnexParser.g:6649:4: (lv_maximum_2_0= ruleNumAlt )
            // InternalBehaviorAnnexParser.g:6650:5: lv_maximum_2_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_91);
            lv_maximum_2_0=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
              					}
              					set(
              						current,
              						"maximum",
              						lv_maximum_2_0,
              						"org.osate.xtext.aadl2.properties.Properties.NumAlt");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalBehaviorAnnexParser.g:6667:3: (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==Delta) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6668:4: otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,Delta,FollowSets000.FOLLOW_88); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                      			
                    }
                    // InternalBehaviorAnnexParser.g:6672:4: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalBehaviorAnnexParser.g:6673:5: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalBehaviorAnnexParser.g:6673:5: (lv_delta_4_0= ruleNumAlt )
                    // InternalBehaviorAnnexParser.g:6674:6: lv_delta_4_0= ruleNumAlt
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_delta_4_0=ruleNumAlt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      						}
                      						set(
                      							current,
                      							"delta",
                      							lv_delta_4_0,
                      							"org.osate.xtext.aadl2.properties.Properties.NumAlt");
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
    // $ANTLR end "ruleNumericRangeTerm"


    // $ANTLR start "entryRuleNumAlt"
    // InternalBehaviorAnnexParser.g:6696:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalBehaviorAnnexParser.g:6696:47: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalBehaviorAnnexParser.g:6697:2: iv_ruleNumAlt= ruleNumAlt EOF
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
    // InternalBehaviorAnnexParser.g:6703:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;



        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6709:2: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalBehaviorAnnexParser.g:6710:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalBehaviorAnnexParser.g:6710:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt114=4;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt114=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt114=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt114=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 114, 1, input);

                    throw nvae;
                }

                }
                break;
            case HyphenMinus:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt114=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt114=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt114=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 114, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt114=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt114=2;
                }
                break;
            case RULE_ID:
                {
                alt114=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }

            switch (alt114) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6711:3: this_RealTerm_0= ruleRealTerm
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
                    // InternalBehaviorAnnexParser.g:6720:3: this_IntegerTerm_1= ruleIntegerTerm
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
                    // InternalBehaviorAnnexParser.g:6729:3: this_SignedConstant_2= ruleSignedConstant
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
                    // InternalBehaviorAnnexParser.g:6738:3: this_ConstantValue_3= ruleConstantValue
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


    // $ANTLR start "entryRuleINTVALUE"
    // InternalBehaviorAnnexParser.g:6750:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalBehaviorAnnexParser.g:6750:48: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalBehaviorAnnexParser.g:6751:2: iv_ruleINTVALUE= ruleINTVALUE EOF
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
    // InternalBehaviorAnnexParser.g:6757:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6763:2: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalBehaviorAnnexParser.g:6764:2: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalBehaviorAnnexParser.g:6774:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalBehaviorAnnexParser.g:6774:45: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalBehaviorAnnexParser.g:6775:2: iv_ruleQPREF= ruleQPREF EOF
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
    // InternalBehaviorAnnexParser.g:6781:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6787:2: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) )
            // InternalBehaviorAnnexParser.g:6788:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            {
            // InternalBehaviorAnnexParser.g:6788:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            // InternalBehaviorAnnexParser.g:6789:3: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_78); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalBehaviorAnnexParser.g:6796:3: (kw= ColonColon this_ID_2= RULE_ID )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==ColonColon) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6797:4: kw= ColonColon this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_3); if (state.failed) return current;
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


    // $ANTLR start "entryRuleQCREF"
    // InternalBehaviorAnnexParser.g:6814:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalBehaviorAnnexParser.g:6814:45: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalBehaviorAnnexParser.g:6815:2: iv_ruleQCREF= ruleQCREF EOF
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
    // InternalBehaviorAnnexParser.g:6821:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6827:2: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // InternalBehaviorAnnexParser.g:6828:2: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // InternalBehaviorAnnexParser.g:6828:2: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // InternalBehaviorAnnexParser.g:6829:3: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // InternalBehaviorAnnexParser.g:6829:3: (this_ID_0= RULE_ID kw= ColonColon )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==RULE_ID) ) {
                    int LA116_1 = input.LA(2);

                    if ( (LA116_1==ColonColon) ) {
                        alt116=1;
                    }


                }


                switch (alt116) {
            	case 1 :
            	    // InternalBehaviorAnnexParser.g:6830:4: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_92); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_0);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0());
            	      			
            	    }
            	    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop116;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_74); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_2);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1());
              		
            }
            // InternalBehaviorAnnexParser.g:6850:3: (kw= FullStop this_ID_4= RULE_ID )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==FullStop) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6851:4: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0());
                      			
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


    // $ANTLR start "entryRuleSTAR"
    // InternalBehaviorAnnexParser.g:6868:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalBehaviorAnnexParser.g:6868:44: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalBehaviorAnnexParser.g:6869:2: iv_ruleSTAR= ruleSTAR EOF
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
    // InternalBehaviorAnnexParser.g:6875:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Asterisk ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6881:2: (kw= Asterisk )
            // InternalBehaviorAnnexParser.g:6882:2: kw= Asterisk
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

    // $ANTLR start synpred1_InternalBehaviorAnnexParser
    public final void synpred1_InternalBehaviorAnnexParser_fragment() throws RecognitionException {   
        // InternalBehaviorAnnexParser.g:1898:4: ( ruleAssignmentAction )
        // InternalBehaviorAnnexParser.g:1898:5: ruleAssignmentAction
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleAssignmentAction();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalBehaviorAnnexParser

    // Delegated rules

    public final boolean synpred1_InternalBehaviorAnnexParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalBehaviorAnnexParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA41 dfa41 = new DFA41(this);
    protected DFA100 dfa100 = new DFA100(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\4\1\0\11\uffff";
    static final String dfa_3s = "\1\141\1\0\11\uffff";
    static final String dfa_4s = "\2\uffff\1\2\1\3\1\4\1\5\1\uffff\1\6\1\7\1\10\1\1";
    static final String dfa_5s = "\1\uffff\1\0\11\uffff}>";
    static final String[] dfa_6s = {
            "\1\3\17\uffff\1\5\13\uffff\1\7\12\uffff\1\5\20\uffff\1\10\1\4\12\uffff\1\2\15\uffff\1\11\12\uffff\1\1",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1896:2: ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_1 = input.LA(1);

                         
                        int index41_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalBehaviorAnnexParser()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index41_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\25\uffff";
    static final String dfa_8s = "\10\uffff\1\17\1\21\1\23\3\uffff\1\17\1\uffff\1\21\3\uffff\1\23";
    static final String dfa_9s = "\1\6\5\uffff\2\134\3\16\3\uffff\1\16\1\uffff\1\16\1\uffff\1\141\1\uffff\1\16";
    static final String dfa_10s = "\1\141\5\uffff\4\141\1\117\3\uffff\1\117\1\uffff\1\117\1\uffff\1\141\1\uffff\1\117";
    static final String dfa_11s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\5\uffff\1\11\1\12\1\6\1\uffff\1\7\1\uffff\1\10\1\uffff\1\13\1\uffff";
    static final String dfa_12s = "\25\uffff}>";
    static final String[] dfa_13s = {
            "\1\3\1\uffff\1\2\7\uffff\1\4\11\uffff\1\14\11\uffff\1\14\41\uffff\1\13\2\uffff\1\6\1\uffff\1\7\10\uffff\1\1\7\uffff\1\10\1\uffff\1\11\1\uffff\1\5\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\10\1\uffff\1\11\2\uffff\1\15",
            "\1\10\1\uffff\1\11\2\uffff\1\15",
            "\1\17\46\uffff\1\15\10\uffff\1\17\10\uffff\1\17\2\uffff\1\17\4\uffff\1\17\21\uffff\1\16",
            "\1\21\46\uffff\1\15\10\uffff\1\21\10\uffff\1\21\2\uffff\1\21\4\uffff\1\21\21\uffff\1\20",
            "\1\23\46\uffff\1\15\1\22\7\uffff\1\23\10\uffff\1\23\2\uffff\1\23\4\uffff\1\23",
            "",
            "",
            "",
            "\1\17\46\uffff\1\15\10\uffff\1\17\10\uffff\1\17\2\uffff\1\17\4\uffff\1\17",
            "",
            "\1\21\46\uffff\1\15\10\uffff\1\21\10\uffff\1\21\2\uffff\1\21\4\uffff\1\21",
            "",
            "\1\24",
            "",
            "\1\23\46\uffff\1\15\10\uffff\1\23\10\uffff\1\23\2\uffff\1\23\4\uffff\1\23"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA100 extends DFA {

        public DFA100(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 100;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "5580:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000400022L,0x0000000200000000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000022L,0x0000000200000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004400L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0080000000000000L,0x0000000000408000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000001004000000L,0x0000000150000008L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000408000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000200800000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000001004000000L,0x0000000350000008L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000001004010140L,0x0000000350100A40L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000048020400L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000048000400L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000104000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000400L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x800020D004040080L,0x0000000350000A48L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001004003000L,0x0000000350000048L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001404240002L,0x0000000350000008L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000480L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000001004000002L,0x0000000350000048L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000081L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000001004000002L,0x0000000350000008L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000800000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x3000081104100010L,0x0000000350400108L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008010L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000229004000000L,0x0000000350000A48L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0805000000000000L,0x0000000000080004L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000209004000000L,0x0000000350000A48L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0005000000000000L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x4000000000000002L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000040202000000L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x2000000000000000L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x4000000000000000L,0x0000000000004000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0020000000000002L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000810000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000800000002L});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0502000000000002L,0x0000000000070000L});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000A00L});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000500000000002L,0x0000000000002100L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0008000000000002L});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000001004000000L,0x0000000350000048L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080028L});
        public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000010880000L});
        public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000002L,0x0000000000101000L});
        public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
        public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000240000008L});
        public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080020L});
        public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0040000000000002L,0x0000000000001000L});
        public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0040000000000002L});
        public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0200002000000000L});
        public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000001004010940L,0x0000000350100A40L});
        public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x4000000000004000L,0x0000000000008400L});
        public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x4000000000000000L,0x0000000000008400L});
        public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000000200200000L});
        public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000001004010140L,0x0000000350100AC0L});
        public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0020000000000000L,0x0000000000200000L});
        public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000000250000A00L});
        public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
        public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0040000000000000L});
    }


}
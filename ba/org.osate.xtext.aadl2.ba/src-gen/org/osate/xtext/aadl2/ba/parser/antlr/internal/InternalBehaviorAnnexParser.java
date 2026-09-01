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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Computation", "Transitions", "Classifier", "Otherwise", "Reference", "Variables", "Complete", "Constant", "Dispatch", "Applies", "Binding", "Compute", "Initial", "Timeout", "Forall", "Frozen", "States", "Count", "Delta", "Elsif", "False", "Final", "Fresh", "Modes", "State", "Until", "While", "Else", "Stop", "True", "PlusSignEqualsSignGreaterThanSign", "RightSquareBracketHyphenMinusGreaterThanSign", "Abs", "And", "Any", "End", "For", "Mod", "Not", "Rem", "Xor", "ExclamationMarkLessThanSign", "ExclamationMarkEqualsSign", "ExclamationMarkGreaterThanSign", "AsteriskAsterisk", "HyphenMinusLeftSquareBracket", "FullStopFullStop", "ColonColon", "ColonEqualsSign", "LessThanSignEqualsSign", "EqualsSignGreaterThanSign", "GreaterThanSignEqualsSign", "GreaterThanSignGreaterThanSign", "Do", "If", "In", "On", "Or", "To", "ExclamationMark", "NumberSign", "Ampersand", "Apostrophe", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "QuestionMark", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int Fresh=26;
    public static final int Or=61;
    public static final int Transitions=5;
    public static final int Stop=32;
    public static final int EqualsSignGreaterThanSign=54;
    public static final int ExclamationMarkLessThanSign=45;
    public static final int Count=21;
    public static final int False=24;
    public static final int LessThanSign=77;
    public static final int States=20;
    public static final int Otherwise=7;
    public static final int PlusSignEqualsSignGreaterThanSign=34;
    public static final int LeftParenthesis=67;
    public static final int ExclamationMark=63;
    public static final int GreaterThanSign=79;
    public static final int RULE_ID=94;
    public static final int RULE_DIGIT=86;
    public static final int Frozen=19;
    public static final int GreaterThanSignEqualsSign=55;
    public static final int ColonColon=51;
    public static final int PlusSign=70;
    public static final int Xor=44;
    public static final int LeftSquareBracket=81;
    public static final int If=58;
    public static final int In=59;
    public static final int Complete=10;
    public static final int RULE_REAL_LIT=89;
    public static final int Dispatch=12;
    public static final int Classifier=6;
    public static final int ExclamationMarkGreaterThanSign=47;
    public static final int Comma=71;
    public static final int HyphenMinus=72;
    public static final int Abs=36;
    public static final int Elsif=23;
    public static final int LessThanSignEqualsSign=53;
    public static final int Solidus=74;
    public static final int RightCurlyBracket=84;
    public static final int Final=25;
    public static final int Apostrophe=66;
    public static final int Modes=27;
    public static final int FullStop=73;
    public static final int Reference=8;
    public static final int Semicolon=76;
    public static final int RULE_EXPONENT=87;
    public static final int Delta=22;
    public static final int QuestionMark=80;
    public static final int Else=31;
    public static final int RULE_EXTENDED_DIGIT=92;
    public static final int Rem=43;
    public static final int ExclamationMarkEqualsSign=46;
    public static final int Initial=16;
    public static final int True=33;
    public static final int RULE_INT_EXPONENT=88;
    public static final int FullStopFullStop=50;
    public static final int Ampersand=65;
    public static final int To=62;
    public static final int Applies=13;
    public static final int Forall=18;
    public static final int RULE_BASED_INTEGER=90;
    public static final int RightSquareBracket=82;
    public static final int Binding=14;
    public static final int Timeout=17;
    public static final int For=40;
    public static final int RightParenthesis=68;
    public static final int Do=57;
    public static final int ColonEqualsSign=52;
    public static final int Not=42;
    public static final int Computation=4;
    public static final int State=28;
    public static final int And=37;
    public static final int NumberSign=64;
    public static final int AsteriskAsterisk=48;
    public static final int End=39;
    public static final int RULE_INTEGER_LIT=91;
    public static final int Constant=11;
    public static final int RULE_STRING=93;
    public static final int Any=38;
    public static final int RULE_SL_COMMENT=85;
    public static final int Variables=9;
    public static final int EqualsSign=78;
    public static final int Colon=75;
    public static final int EOF=-1;
    public static final int Asterisk=69;
    public static final int Until=29;
    public static final int Mod=41;
    public static final int RULE_WS=95;
    public static final int HyphenMinusLeftSquareBracket=49;
    public static final int LeftCurlyBracket=83;
    public static final int While=30;
    public static final int GreaterThanSignGreaterThanSign=56;
    public static final int RightSquareBracketHyphenMinusGreaterThanSign=35;
    public static final int Compute=15;
    public static final int On=60;

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
    // InternalBehaviorAnnexParser.g:833:1: ruleBehaviorCondition returns [EObject current=null] : ( (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_modeSwitch_2_0= ruleModeSwitchCondition ) ) ) ) | ( (lv_execute_3_0= ruleExecuteCondition ) ) ) ;
    public final EObject ruleBehaviorCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_dispatch_1_0 = null;

        EObject lv_modeSwitch_2_0 = null;

        EObject lv_execute_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:839:2: ( ( (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_modeSwitch_2_0= ruleModeSwitchCondition ) ) ) ) | ( (lv_execute_3_0= ruleExecuteCondition ) ) ) )
            // InternalBehaviorAnnexParser.g:840:2: ( (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_modeSwitch_2_0= ruleModeSwitchCondition ) ) ) ) | ( (lv_execute_3_0= ruleExecuteCondition ) ) )
            {
            // InternalBehaviorAnnexParser.g:840:2: ( (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_modeSwitch_2_0= ruleModeSwitchCondition ) ) ) ) | ( (lv_execute_3_0= ruleExecuteCondition ) ) )
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
                    // InternalBehaviorAnnexParser.g:841:3: (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_modeSwitch_2_0= ruleModeSwitchCondition ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:841:3: (otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_modeSwitch_2_0= ruleModeSwitchCondition ) ) ) )
                    // InternalBehaviorAnnexParser.g:842:4: otherlv_0= On ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_modeSwitch_2_0= ruleModeSwitchCondition ) ) )
                    {
                    otherlv_0=(Token)match(input,On,FollowSets000.FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_0, grammarAccess.getBehaviorConditionAccess().getOnKeyword_0_0());

                    }
                    // InternalBehaviorAnnexParser.g:846:4: ( ( (lv_dispatch_1_0= ruleDispatchCondition ) ) | ( (lv_modeSwitch_2_0= ruleModeSwitchCondition ) ) )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==Dispatch) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==RULE_ID) ) {
                        alt21=2;
                    }
                    else {
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
                            // InternalBehaviorAnnexParser.g:867:5: ( (lv_modeSwitch_2_0= ruleModeSwitchCondition ) )
                            {
                            // InternalBehaviorAnnexParser.g:867:5: ( (lv_modeSwitch_2_0= ruleModeSwitchCondition ) )
                            // InternalBehaviorAnnexParser.g:868:6: (lv_modeSwitch_2_0= ruleModeSwitchCondition )
                            {
                            // InternalBehaviorAnnexParser.g:868:6: (lv_modeSwitch_2_0= ruleModeSwitchCondition )
                            // InternalBehaviorAnnexParser.g:869:7: lv_modeSwitch_2_0= ruleModeSwitchCondition
                            {
                            if ( state.backtracking==0 ) {

                                                          newCompositeNode(grammarAccess.getBehaviorConditionAccess().getModeSwitchModeSwitchConditionParserRuleCall_0_1_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_modeSwitch_2_0=ruleModeSwitchCondition();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElementForParent(grammarAccess.getBehaviorConditionRule());
                                                          }
                                                          set(
                                                              current,
                                                              "modeSwitch",
                                                              lv_modeSwitch_2_0,
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
                    // InternalBehaviorAnnexParser.g:889:3: ( (lv_execute_3_0= ruleExecuteCondition ) )
                    {
                    // InternalBehaviorAnnexParser.g:889:3: ( (lv_execute_3_0= ruleExecuteCondition ) )
                    // InternalBehaviorAnnexParser.g:890:4: (lv_execute_3_0= ruleExecuteCondition )
                    {
                    // InternalBehaviorAnnexParser.g:890:4: (lv_execute_3_0= ruleExecuteCondition )
                    // InternalBehaviorAnnexParser.g:891:5: lv_execute_3_0= ruleExecuteCondition
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getBehaviorConditionAccess().getExecuteExecuteConditionParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_execute_3_0=ruleExecuteCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          if (current==null) {
                                              current = createModelElementForParent(grammarAccess.getBehaviorConditionRule());
                                          }
                                          set(
                                              current,
                                              "execute",
                                              lv_execute_3_0,
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
    // InternalBehaviorAnnexParser.g:912:1: entryRuleExecuteCondition returns [EObject current=null] : iv_ruleExecuteCondition= ruleExecuteCondition EOF ;
    public final EObject entryRuleExecuteCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecuteCondition = null;


        try {
            // InternalBehaviorAnnexParser.g:912:57: (iv_ruleExecuteCondition= ruleExecuteCondition EOF )
            // InternalBehaviorAnnexParser.g:913:2: iv_ruleExecuteCondition= ruleExecuteCondition EOF
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
    // InternalBehaviorAnnexParser.g:919:1: ruleExecuteCondition returns [EObject current=null] : ( ( (lv_value_0_0= ruleValueExpression ) ) | ( (lv_timeout_1_0= Timeout ) ) | ( (lv_otherwise_2_0= Otherwise ) ) ) ;
    public final EObject ruleExecuteCondition() throws RecognitionException {
        EObject current = null;

        Token lv_timeout_1_0=null;
        Token lv_otherwise_2_0=null;
        EObject lv_value_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:925:2: ( ( ( (lv_value_0_0= ruleValueExpression ) ) | ( (lv_timeout_1_0= Timeout ) ) | ( (lv_otherwise_2_0= Otherwise ) ) ) )
            // InternalBehaviorAnnexParser.g:926:2: ( ( (lv_value_0_0= ruleValueExpression ) ) | ( (lv_timeout_1_0= Timeout ) ) | ( (lv_otherwise_2_0= Otherwise ) ) )
            {
            // InternalBehaviorAnnexParser.g:926:2: ( ( (lv_value_0_0= ruleValueExpression ) ) | ( (lv_timeout_1_0= Timeout ) ) | ( (lv_otherwise_2_0= Otherwise ) ) )
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
                    // InternalBehaviorAnnexParser.g:927:3: ( (lv_value_0_0= ruleValueExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:927:3: ( (lv_value_0_0= ruleValueExpression ) )
                    // InternalBehaviorAnnexParser.g:928:4: (lv_value_0_0= ruleValueExpression )
                    {
                    // InternalBehaviorAnnexParser.g:928:4: (lv_value_0_0= ruleValueExpression )
                    // InternalBehaviorAnnexParser.g:929:5: lv_value_0_0= ruleValueExpression
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
                    // InternalBehaviorAnnexParser.g:947:3: ( (lv_timeout_1_0= Timeout ) )
                    {
                    // InternalBehaviorAnnexParser.g:947:3: ( (lv_timeout_1_0= Timeout ) )
                    // InternalBehaviorAnnexParser.g:948:4: (lv_timeout_1_0= Timeout )
                    {
                    // InternalBehaviorAnnexParser.g:948:4: (lv_timeout_1_0= Timeout )
                    // InternalBehaviorAnnexParser.g:949:5: lv_timeout_1_0= Timeout
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
                    // InternalBehaviorAnnexParser.g:962:3: ( (lv_otherwise_2_0= Otherwise ) )
                    {
                    // InternalBehaviorAnnexParser.g:962:3: ( (lv_otherwise_2_0= Otherwise ) )
                    // InternalBehaviorAnnexParser.g:963:4: (lv_otherwise_2_0= Otherwise )
                    {
                    // InternalBehaviorAnnexParser.g:963:4: (lv_otherwise_2_0= Otherwise )
                    // InternalBehaviorAnnexParser.g:964:5: lv_otherwise_2_0= Otherwise
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
    // InternalBehaviorAnnexParser.g:980:1: entryRuleDispatchCondition returns [EObject current=null] : iv_ruleDispatchCondition= ruleDispatchCondition EOF ;
    public final EObject entryRuleDispatchCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDispatchCondition = null;


        try {
            // InternalBehaviorAnnexParser.g:980:58: (iv_ruleDispatchCondition= ruleDispatchCondition EOF )
            // InternalBehaviorAnnexParser.g:981:2: iv_ruleDispatchCondition= ruleDispatchCondition EOF
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
    // InternalBehaviorAnnexParser.g:987:1: ruleDispatchCondition returns [EObject current=null] : (otherlv_0= Dispatch ( (lv_trigger_1_0= ruleDispatchTriggerCondition ) )? (otherlv_2= Frozen ( (lv_frozenPorts_3_0= ruleReference ) ) (otherlv_4= Comma ( (lv_frozenPorts_5_0= ruleReference ) ) )* )? ) ;
    public final EObject ruleDispatchCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_trigger_1_0 = null;

        EObject lv_frozenPorts_3_0 = null;

        EObject lv_frozenPorts_5_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:993:2: ( (otherlv_0= Dispatch ( (lv_trigger_1_0= ruleDispatchTriggerCondition ) )? (otherlv_2= Frozen ( (lv_frozenPorts_3_0= ruleReference ) ) (otherlv_4= Comma ( (lv_frozenPorts_5_0= ruleReference ) ) )* )? ) )
            // InternalBehaviorAnnexParser.g:994:2: (otherlv_0= Dispatch ( (lv_trigger_1_0= ruleDispatchTriggerCondition ) )? (otherlv_2= Frozen ( (lv_frozenPorts_3_0= ruleReference ) ) (otherlv_4= Comma ( (lv_frozenPorts_5_0= ruleReference ) ) )* )? )
            {
            // InternalBehaviorAnnexParser.g:994:2: (otherlv_0= Dispatch ( (lv_trigger_1_0= ruleDispatchTriggerCondition ) )? (otherlv_2= Frozen ( (lv_frozenPorts_3_0= ruleReference ) ) (otherlv_4= Comma ( (lv_frozenPorts_5_0= ruleReference ) ) )* )? )
            // InternalBehaviorAnnexParser.g:995:3: otherlv_0= Dispatch ( (lv_trigger_1_0= ruleDispatchTriggerCondition ) )? (otherlv_2= Frozen ( (lv_frozenPorts_3_0= ruleReference ) ) (otherlv_4= Comma ( (lv_frozenPorts_5_0= ruleReference ) ) )* )?
            {
            otherlv_0=(Token)match(input,Dispatch,FollowSets000.FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getDispatchConditionAccess().getDispatchKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:999:3: ( (lv_trigger_1_0= ruleDispatchTriggerCondition ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Timeout||LA24_0==Stop||LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1000:4: (lv_trigger_1_0= ruleDispatchTriggerCondition )
                    {
                    // InternalBehaviorAnnexParser.g:1000:4: (lv_trigger_1_0= ruleDispatchTriggerCondition )
                    // InternalBehaviorAnnexParser.g:1001:5: lv_trigger_1_0= ruleDispatchTriggerCondition
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getDispatchConditionAccess().getTriggerDispatchTriggerConditionParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_30);
                    lv_trigger_1_0=ruleDispatchTriggerCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          if (current==null) {
                                              current = createModelElementForParent(grammarAccess.getDispatchConditionRule());
                                          }
                                          set(
                                              current,
                                              "trigger",
                                              lv_trigger_1_0,
                                              "org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchTriggerCondition");
                                          afterParserOrEnumRuleCall();

                    }

                    }


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:1018:3: (otherlv_2= Frozen ( (lv_frozenPorts_3_0= ruleReference ) ) (otherlv_4= Comma ( (lv_frozenPorts_5_0= ruleReference ) ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Frozen) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1019:4: otherlv_2= Frozen ( (lv_frozenPorts_3_0= ruleReference ) ) (otherlv_4= Comma ( (lv_frozenPorts_5_0= ruleReference ) ) )*
                    {
                    otherlv_2=(Token)match(input,Frozen,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_2, grammarAccess.getDispatchConditionAccess().getFrozenKeyword_2_0());

                    }
                    // InternalBehaviorAnnexParser.g:1023:4: ( (lv_frozenPorts_3_0= ruleReference ) )
                    // InternalBehaviorAnnexParser.g:1024:5: (lv_frozenPorts_3_0= ruleReference )
                    {
                    // InternalBehaviorAnnexParser.g:1024:5: (lv_frozenPorts_3_0= ruleReference )
                    // InternalBehaviorAnnexParser.g:1025:6: lv_frozenPorts_3_0= ruleReference
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getDispatchConditionAccess().getFrozenPortsReferenceParserRuleCall_2_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_31);
                    lv_frozenPorts_3_0=ruleReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                              if (current==null) {
                                                  current = createModelElementForParent(grammarAccess.getDispatchConditionRule());
                                              }
                                              add(
                                                  current,
                                                  "frozenPorts",
                                                  lv_frozenPorts_3_0,
                                                  "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                                              afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:1042:4: (otherlv_4= Comma ( (lv_frozenPorts_5_0= ruleReference ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==Comma) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:1043:5: otherlv_4= Comma ( (lv_frozenPorts_5_0= ruleReference ) )
                            {
                            otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                  newLeafNode(otherlv_4, grammarAccess.getDispatchConditionAccess().getCommaKeyword_2_2_0());

                            }
                            // InternalBehaviorAnnexParser.g:1047:5: ( (lv_frozenPorts_5_0= ruleReference ) )
                            // InternalBehaviorAnnexParser.g:1048:6: (lv_frozenPorts_5_0= ruleReference )
                            {
                            // InternalBehaviorAnnexParser.g:1048:6: (lv_frozenPorts_5_0= ruleReference )
                            // InternalBehaviorAnnexParser.g:1049:7: lv_frozenPorts_5_0= ruleReference
                            {
                            if ( state.backtracking==0 ) {

                                                          newCompositeNode(grammarAccess.getDispatchConditionAccess().getFrozenPortsReferenceParserRuleCall_2_2_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_31);
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


                            }
                            break;

                        default :
                            break loop25;
                        }
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
    // $ANTLR end "ruleDispatchCondition"


    // $ANTLR start "entryRuleDispatchTriggerCondition"
    // InternalBehaviorAnnexParser.g:1072:1: entryRuleDispatchTriggerCondition returns [EObject current=null] : iv_ruleDispatchTriggerCondition= ruleDispatchTriggerCondition EOF ;
    public final EObject entryRuleDispatchTriggerCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDispatchTriggerCondition = null;


        try {
            // InternalBehaviorAnnexParser.g:1072:65: (iv_ruleDispatchTriggerCondition= ruleDispatchTriggerCondition EOF )
            // InternalBehaviorAnnexParser.g:1073:2: iv_ruleDispatchTriggerCondition= ruleDispatchTriggerCondition EOF
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
    // InternalBehaviorAnnexParser.g:1079:1: ruleDispatchTriggerCondition returns [EObject current=null] : ( ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) ) | ( ( (lv_timeout_1_0= Timeout ) ) ( (lv_time_2_0= ruleBehaviorTime ) )? ) | ( (lv_stop_3_0= Stop ) ) ) ;
    public final EObject ruleDispatchTriggerCondition() throws RecognitionException {
        EObject current = null;

        Token lv_timeout_1_0=null;
        Token lv_stop_3_0=null;
        EObject lv_expression_0_0 = null;

        EObject lv_time_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1085:2: ( ( ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) ) | ( ( (lv_timeout_1_0= Timeout ) ) ( (lv_time_2_0= ruleBehaviorTime ) )? ) | ( (lv_stop_3_0= Stop ) ) ) )
            // InternalBehaviorAnnexParser.g:1086:2: ( ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) ) | ( ( (lv_timeout_1_0= Timeout ) ) ( (lv_time_2_0= ruleBehaviorTime ) )? ) | ( (lv_stop_3_0= Stop ) ) )
            {
            // InternalBehaviorAnnexParser.g:1086:2: ( ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) ) | ( ( (lv_timeout_1_0= Timeout ) ) ( (lv_time_2_0= ruleBehaviorTime ) )? ) | ( (lv_stop_3_0= Stop ) ) )
            int alt28=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt28=1;
                }
                break;
            case Timeout:
                {
                alt28=2;
                }
                break;
            case Stop:
                {
                alt28=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1087:3: ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:1087:3: ( (lv_expression_0_0= ruleDispatchTriggerLogicalExpression ) )
                    // InternalBehaviorAnnexParser.g:1088:4: (lv_expression_0_0= ruleDispatchTriggerLogicalExpression )
                    {
                    // InternalBehaviorAnnexParser.g:1088:4: (lv_expression_0_0= ruleDispatchTriggerLogicalExpression )
                    // InternalBehaviorAnnexParser.g:1089:5: lv_expression_0_0= ruleDispatchTriggerLogicalExpression
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
                    // InternalBehaviorAnnexParser.g:1107:3: ( ( (lv_timeout_1_0= Timeout ) ) ( (lv_time_2_0= ruleBehaviorTime ) )? )
                    {
                    // InternalBehaviorAnnexParser.g:1107:3: ( ( (lv_timeout_1_0= Timeout ) ) ( (lv_time_2_0= ruleBehaviorTime ) )? )
                    // InternalBehaviorAnnexParser.g:1108:4: ( (lv_timeout_1_0= Timeout ) ) ( (lv_time_2_0= ruleBehaviorTime ) )?
                    {
                    // InternalBehaviorAnnexParser.g:1108:4: ( (lv_timeout_1_0= Timeout ) )
                    // InternalBehaviorAnnexParser.g:1109:5: (lv_timeout_1_0= Timeout )
                    {
                    // InternalBehaviorAnnexParser.g:1109:5: (lv_timeout_1_0= Timeout )
                    // InternalBehaviorAnnexParser.g:1110:6: lv_timeout_1_0= Timeout
                    {
                    lv_timeout_1_0=(Token)match(input,Timeout,FollowSets000.FOLLOW_32); if (state.failed) return current;
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

                    // InternalBehaviorAnnexParser.g:1122:4: ( (lv_time_2_0= ruleBehaviorTime ) )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==NumberSign||LA27_0==RULE_INTEGER_LIT||LA27_0==RULE_ID) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:1123:5: (lv_time_2_0= ruleBehaviorTime )
                            {
                            // InternalBehaviorAnnexParser.g:1123:5: (lv_time_2_0= ruleBehaviorTime )
                            // InternalBehaviorAnnexParser.g:1124:6: lv_time_2_0= ruleBehaviorTime
                            {
                            if ( state.backtracking==0 ) {

                                                      newCompositeNode(grammarAccess.getDispatchTriggerConditionAccess().getTimeBehaviorTimeParserRuleCall_1_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_time_2_0=ruleBehaviorTime();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                      if (current==null) {
                                                          current = createModelElementForParent(grammarAccess.getDispatchTriggerConditionRule());
                                                      }
                                                      set(
                                                          current,
                                                          "time",
                                                          lv_time_2_0,
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
                    // InternalBehaviorAnnexParser.g:1143:3: ( (lv_stop_3_0= Stop ) )
                    {
                    // InternalBehaviorAnnexParser.g:1143:3: ( (lv_stop_3_0= Stop ) )
                    // InternalBehaviorAnnexParser.g:1144:4: (lv_stop_3_0= Stop )
                    {
                    // InternalBehaviorAnnexParser.g:1144:4: (lv_stop_3_0= Stop )
                    // InternalBehaviorAnnexParser.g:1145:5: lv_stop_3_0= Stop
                    {
                    lv_stop_3_0=(Token)match(input,Stop,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          newLeafNode(lv_stop_3_0, grammarAccess.getDispatchTriggerConditionAccess().getStopStopKeyword_2_0());

                    }
                    if ( state.backtracking==0 ) {

                                          if (current==null) {
                                              current = createModelElement(grammarAccess.getDispatchTriggerConditionRule());
                                          }
                                          setWithLastConsumed(current, "stop", lv_stop_3_0 != null, "stop");

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
    // InternalBehaviorAnnexParser.g:1161:1: entryRuleDispatchTriggerLogicalExpression returns [EObject current=null] : iv_ruleDispatchTriggerLogicalExpression= ruleDispatchTriggerLogicalExpression EOF ;
    public final EObject entryRuleDispatchTriggerLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDispatchTriggerLogicalExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:1161:73: (iv_ruleDispatchTriggerLogicalExpression= ruleDispatchTriggerLogicalExpression EOF )
            // InternalBehaviorAnnexParser.g:1162:2: iv_ruleDispatchTriggerLogicalExpression= ruleDispatchTriggerLogicalExpression EOF
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
    // InternalBehaviorAnnexParser.g:1168:1: ruleDispatchTriggerLogicalExpression returns [EObject current=null] : ( ( (lv_conjunctions_0_0= ruleDispatchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )* ) ;
    public final EObject ruleDispatchTriggerLogicalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_conjunctions_0_0 = null;

        EObject lv_conjunctions_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1174:2: ( ( ( (lv_conjunctions_0_0= ruleDispatchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1175:2: ( ( (lv_conjunctions_0_0= ruleDispatchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1175:2: ( ( (lv_conjunctions_0_0= ruleDispatchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )* )
            // InternalBehaviorAnnexParser.g:1176:3: ( (lv_conjunctions_0_0= ruleDispatchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )*
            {
            // InternalBehaviorAnnexParser.g:1176:3: ( (lv_conjunctions_0_0= ruleDispatchConjunction ) )
            // InternalBehaviorAnnexParser.g:1177:4: (lv_conjunctions_0_0= ruleDispatchConjunction )
            {
            // InternalBehaviorAnnexParser.g:1177:4: (lv_conjunctions_0_0= ruleDispatchConjunction )
            // InternalBehaviorAnnexParser.g:1178:5: lv_conjunctions_0_0= ruleDispatchConjunction
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getDispatchTriggerLogicalExpressionAccess().getConjunctionsDispatchConjunctionParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_33);
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

            // InternalBehaviorAnnexParser.g:1195:3: (otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==Or) ) {
                    alt29=1;
                }


                switch (alt29) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1196:4: otherlv_1= Or ( (lv_conjunctions_2_0= ruleDispatchConjunction ) )
                    {
                    otherlv_1=(Token)match(input,Or,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_1, grammarAccess.getDispatchTriggerLogicalExpressionAccess().getOrKeyword_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:1200:4: ( (lv_conjunctions_2_0= ruleDispatchConjunction ) )
                    // InternalBehaviorAnnexParser.g:1201:5: (lv_conjunctions_2_0= ruleDispatchConjunction )
                    {
                    // InternalBehaviorAnnexParser.g:1201:5: (lv_conjunctions_2_0= ruleDispatchConjunction )
                    // InternalBehaviorAnnexParser.g:1202:6: lv_conjunctions_2_0= ruleDispatchConjunction
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getDispatchTriggerLogicalExpressionAccess().getConjunctionsDispatchConjunctionParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_33);
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
                    break loop29;
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
    // InternalBehaviorAnnexParser.g:1224:1: entryRuleDispatchConjunction returns [EObject current=null] : iv_ruleDispatchConjunction= ruleDispatchConjunction EOF ;
    public final EObject entryRuleDispatchConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDispatchConjunction = null;


        try {
            // InternalBehaviorAnnexParser.g:1224:60: (iv_ruleDispatchConjunction= ruleDispatchConjunction EOF )
            // InternalBehaviorAnnexParser.g:1225:2: iv_ruleDispatchConjunction= ruleDispatchConjunction EOF
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
    // InternalBehaviorAnnexParser.g:1231:1: ruleDispatchConjunction returns [EObject current=null] : ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* ) ;
    public final EObject ruleDispatchConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_triggers_0_0 = null;

        EObject lv_triggers_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1237:2: ( ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1238:2: ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1238:2: ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* )
            // InternalBehaviorAnnexParser.g:1239:3: ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )*
            {
            // InternalBehaviorAnnexParser.g:1239:3: ( (lv_triggers_0_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:1240:4: (lv_triggers_0_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:1240:4: (lv_triggers_0_0= ruleReference )
            // InternalBehaviorAnnexParser.g:1241:5: lv_triggers_0_0= ruleReference
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getDispatchConjunctionAccess().getTriggersReferenceParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_34);
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

            // InternalBehaviorAnnexParser.g:1258:3: (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==And) ) {
                    alt30=1;
                }


                switch (alt30) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1259:4: otherlv_1= And ( (lv_triggers_2_0= ruleReference ) )
                    {
                    otherlv_1=(Token)match(input,And,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_1, grammarAccess.getDispatchConjunctionAccess().getAndKeyword_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:1263:4: ( (lv_triggers_2_0= ruleReference ) )
                    // InternalBehaviorAnnexParser.g:1264:5: (lv_triggers_2_0= ruleReference )
                    {
                    // InternalBehaviorAnnexParser.g:1264:5: (lv_triggers_2_0= ruleReference )
                    // InternalBehaviorAnnexParser.g:1265:6: lv_triggers_2_0= ruleReference
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getDispatchConjunctionAccess().getTriggersReferenceParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_34);
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
                    break loop30;
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
    // InternalBehaviorAnnexParser.g:1287:1: entryRuleModeSwitchCondition returns [EObject current=null] : iv_ruleModeSwitchCondition= ruleModeSwitchCondition EOF ;
    public final EObject entryRuleModeSwitchCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeSwitchCondition = null;


        try {
            // InternalBehaviorAnnexParser.g:1287:60: (iv_ruleModeSwitchCondition= ruleModeSwitchCondition EOF )
            // InternalBehaviorAnnexParser.g:1288:2: iv_ruleModeSwitchCondition= ruleModeSwitchCondition EOF
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
    // InternalBehaviorAnnexParser.g:1294:1: ruleModeSwitchCondition returns [EObject current=null] : ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* ) ;
    public final EObject ruleModeSwitchCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_conjunctions_0_0 = null;

        EObject lv_conjunctions_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1300:2: ( ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1301:2: ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1301:2: ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* )
            // InternalBehaviorAnnexParser.g:1302:3: ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )*
            {
            // InternalBehaviorAnnexParser.g:1302:3: ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) )
            // InternalBehaviorAnnexParser.g:1303:4: (lv_conjunctions_0_0= ruleModeSwitchConjunction )
            {
            // InternalBehaviorAnnexParser.g:1303:4: (lv_conjunctions_0_0= ruleModeSwitchConjunction )
            // InternalBehaviorAnnexParser.g:1304:5: lv_conjunctions_0_0= ruleModeSwitchConjunction
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getModeSwitchConditionAccess().getConjunctionsModeSwitchConjunctionParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_33);
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

            // InternalBehaviorAnnexParser.g:1321:3: (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==Or) ) {
                    alt31=1;
                }


                switch (alt31) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1322:4: otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) )
                    {
                    otherlv_1=(Token)match(input,Or,FollowSets000.FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_1, grammarAccess.getModeSwitchConditionAccess().getOrKeyword_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:1326:4: ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) )
                    // InternalBehaviorAnnexParser.g:1327:5: (lv_conjunctions_2_0= ruleModeSwitchConjunction )
                    {
                    // InternalBehaviorAnnexParser.g:1327:5: (lv_conjunctions_2_0= ruleModeSwitchConjunction )
                    // InternalBehaviorAnnexParser.g:1328:6: lv_conjunctions_2_0= ruleModeSwitchConjunction
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getModeSwitchConditionAccess().getConjunctionsModeSwitchConjunctionParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_33);
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
    // $ANTLR end "ruleModeSwitchCondition"


    // $ANTLR start "entryRuleModeSwitchConjunction"
    // InternalBehaviorAnnexParser.g:1350:1: entryRuleModeSwitchConjunction returns [EObject current=null] : iv_ruleModeSwitchConjunction= ruleModeSwitchConjunction EOF ;
    public final EObject entryRuleModeSwitchConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeSwitchConjunction = null;


        try {
            // InternalBehaviorAnnexParser.g:1350:62: (iv_ruleModeSwitchConjunction= ruleModeSwitchConjunction EOF )
            // InternalBehaviorAnnexParser.g:1351:2: iv_ruleModeSwitchConjunction= ruleModeSwitchConjunction EOF
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
    // InternalBehaviorAnnexParser.g:1357:1: ruleModeSwitchConjunction returns [EObject current=null] : ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* ) ;
    public final EObject ruleModeSwitchConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_triggers_0_0 = null;

        EObject lv_triggers_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1363:2: ( ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1364:2: ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1364:2: ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* )
            // InternalBehaviorAnnexParser.g:1365:3: ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )*
            {
            // InternalBehaviorAnnexParser.g:1365:3: ( (lv_triggers_0_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:1366:4: (lv_triggers_0_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:1366:4: (lv_triggers_0_0= ruleReference )
            // InternalBehaviorAnnexParser.g:1367:5: lv_triggers_0_0= ruleReference
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getModeSwitchConjunctionAccess().getTriggersReferenceParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_34);
            lv_triggers_0_0=ruleReference();

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
                                      "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                                  afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalBehaviorAnnexParser.g:1384:3: (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==And) ) {
                    alt32=1;
                }


                switch (alt32) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1385:4: otherlv_1= And ( (lv_triggers_2_0= ruleReference ) )
                    {
                    otherlv_1=(Token)match(input,And,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_1, grammarAccess.getModeSwitchConjunctionAccess().getAndKeyword_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:1389:4: ( (lv_triggers_2_0= ruleReference ) )
                    // InternalBehaviorAnnexParser.g:1390:5: (lv_triggers_2_0= ruleReference )
                    {
                    // InternalBehaviorAnnexParser.g:1390:5: (lv_triggers_2_0= ruleReference )
                    // InternalBehaviorAnnexParser.g:1391:6: lv_triggers_2_0= ruleReference
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getModeSwitchConjunctionAccess().getTriggersReferenceParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_34);
                    lv_triggers_2_0=ruleReference();

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
    // $ANTLR end "ruleModeSwitchConjunction"


    // $ANTLR start "entryRuleBehaviorActionBlock"
    // InternalBehaviorAnnexParser.g:1413:1: entryRuleBehaviorActionBlock returns [EObject current=null] : iv_ruleBehaviorActionBlock= ruleBehaviorActionBlock EOF ;
    public final EObject entryRuleBehaviorActionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorActionBlock = null;


        try {
            // InternalBehaviorAnnexParser.g:1413:60: (iv_ruleBehaviorActionBlock= ruleBehaviorActionBlock EOF )
            // InternalBehaviorAnnexParser.g:1414:2: iv_ruleBehaviorActionBlock= ruleBehaviorActionBlock EOF
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
    // InternalBehaviorAnnexParser.g:1420:1: ruleBehaviorActionBlock returns [EObject current=null] : (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? ) ;
    public final EObject ruleBehaviorActionBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_content_1_0 = null;

        EObject lv_timeout_4_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1426:2: ( (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? ) )
            // InternalBehaviorAnnexParser.g:1427:2: (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:1427:2: (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? )
            // InternalBehaviorAnnexParser.g:1428:3: otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )?
            {
            otherlv_0=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getBehaviorActionBlockAccess().getLeftCurlyBracketKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:1432:3: ( (lv_content_1_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:1433:4: (lv_content_1_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:1433:4: (lv_content_1_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:1434:5: lv_content_1_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getBehaviorActionBlockAccess().getContentBehaviorActionsParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_36);
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

            otherlv_2=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_2, grammarAccess.getBehaviorActionBlockAccess().getRightCurlyBracketKeyword_2());

            }
            // InternalBehaviorAnnexParser.g:1455:3: (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==Timeout) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1456:4: otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) )
                    {
                    otherlv_3=(Token)match(input,Timeout,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_3, grammarAccess.getBehaviorActionBlockAccess().getTimeoutKeyword_3_0());

                    }
                    // InternalBehaviorAnnexParser.g:1460:4: ( (lv_timeout_4_0= ruleBehaviorTime ) )
                    // InternalBehaviorAnnexParser.g:1461:5: (lv_timeout_4_0= ruleBehaviorTime )
                    {
                    // InternalBehaviorAnnexParser.g:1461:5: (lv_timeout_4_0= ruleBehaviorTime )
                    // InternalBehaviorAnnexParser.g:1462:6: lv_timeout_4_0= ruleBehaviorTime
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
    // InternalBehaviorAnnexParser.g:1484:1: entryRuleBehaviorActions returns [EObject current=null] : iv_ruleBehaviorActions= ruleBehaviorActions EOF ;
    public final EObject entryRuleBehaviorActions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorActions = null;


        try {
            // InternalBehaviorAnnexParser.g:1484:56: (iv_ruleBehaviorActions= ruleBehaviorActions EOF )
            // InternalBehaviorAnnexParser.g:1485:2: iv_ruleBehaviorActions= ruleBehaviorActions EOF
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
    // InternalBehaviorAnnexParser.g:1491:1: ruleBehaviorActions returns [EObject current=null] : (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? ) ;
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
            // InternalBehaviorAnnexParser.g:1497:2: ( (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? ) )
            // InternalBehaviorAnnexParser.g:1498:2: (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? )
            {
            // InternalBehaviorAnnexParser.g:1498:2: (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? )
            // InternalBehaviorAnnexParser.g:1499:3: this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )?
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getBehaviorActionsAccess().getBehaviorActionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_38);
            this_BehaviorAction_0=ruleBehaviorAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_BehaviorAction_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:1507:3: ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )?
            int alt36=3;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==Semicolon) ) {
                alt36=1;
            }
            else if ( (LA36_0==Ampersand) ) {
                alt36=2;
            }
            switch (alt36) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1508:4: ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* )
                    {
                    // InternalBehaviorAnnexParser.g:1508:4: ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* )
                    // InternalBehaviorAnnexParser.g:1509:5: () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )*
                    {
                    // InternalBehaviorAnnexParser.g:1509:5: ()
                    // InternalBehaviorAnnexParser.g:1510:6:
                    {
                    if ( state.backtracking==0 ) {

                                              current = forceCreateModelElementAndAdd(
                                                  grammarAccess.getBehaviorActionsAccess().getBehaviorActionSequenceActionsAction_1_0_0(),
                                                  current);

                    }

                    }

                    otherlv_2=(Token)match(input,Semicolon,FollowSets000.FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          newLeafNode(otherlv_2, grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_1());

                    }
                    // InternalBehaviorAnnexParser.g:1520:5: ( (lv_actions_3_0= ruleBehaviorAction ) )
                    // InternalBehaviorAnnexParser.g:1521:6: (lv_actions_3_0= ruleBehaviorAction )
                    {
                    // InternalBehaviorAnnexParser.g:1521:6: (lv_actions_3_0= ruleBehaviorAction )
                    // InternalBehaviorAnnexParser.g:1522:7: lv_actions_3_0= ruleBehaviorAction
                    {
                    if ( state.backtracking==0 ) {

                                                  newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_0_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_39);
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

                    // InternalBehaviorAnnexParser.g:1539:5: (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==Semicolon) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:1540:6: otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) )
                            {
                            otherlv_4=(Token)match(input,Semicolon,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                      newLeafNode(otherlv_4, grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_3_0());

                            }
                            // InternalBehaviorAnnexParser.g:1544:6: ( (lv_actions_5_0= ruleBehaviorAction ) )
                            // InternalBehaviorAnnexParser.g:1545:7: (lv_actions_5_0= ruleBehaviorAction )
                            {
                            // InternalBehaviorAnnexParser.g:1545:7: (lv_actions_5_0= ruleBehaviorAction )
                            // InternalBehaviorAnnexParser.g:1546:8: lv_actions_5_0= ruleBehaviorAction
                            {
                            if ( state.backtracking==0 ) {

                                                              newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_0_3_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_39);
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
                            break loop34;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:1566:4: ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* )
                    {
                    // InternalBehaviorAnnexParser.g:1566:4: ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* )
                    // InternalBehaviorAnnexParser.g:1567:5: () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )*
                    {
                    // InternalBehaviorAnnexParser.g:1567:5: ()
                    // InternalBehaviorAnnexParser.g:1568:6:
                    {
                    if ( state.backtracking==0 ) {

                                              current = forceCreateModelElementAndAdd(
                                                  grammarAccess.getBehaviorActionsAccess().getBehaviorActionSetActionsAction_1_1_0(),
                                                  current);

                    }

                    }

                    otherlv_7=(Token)match(input,Ampersand,FollowSets000.FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          newLeafNode(otherlv_7, grammarAccess.getBehaviorActionsAccess().getAmpersandKeyword_1_1_1());

                    }
                    // InternalBehaviorAnnexParser.g:1578:5: ( (lv_actions_8_0= ruleBehaviorAction ) )
                    // InternalBehaviorAnnexParser.g:1579:6: (lv_actions_8_0= ruleBehaviorAction )
                    {
                    // InternalBehaviorAnnexParser.g:1579:6: (lv_actions_8_0= ruleBehaviorAction )
                    // InternalBehaviorAnnexParser.g:1580:7: lv_actions_8_0= ruleBehaviorAction
                    {
                    if ( state.backtracking==0 ) {

                                                  newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_40);
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

                    // InternalBehaviorAnnexParser.g:1597:5: (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==Ampersand) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:1598:6: otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) )
                            {
                            otherlv_9=(Token)match(input,Ampersand,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                      newLeafNode(otherlv_9, grammarAccess.getBehaviorActionsAccess().getAmpersandKeyword_1_1_3_0());

                            }
                            // InternalBehaviorAnnexParser.g:1602:6: ( (lv_actions_10_0= ruleBehaviorAction ) )
                            // InternalBehaviorAnnexParser.g:1603:7: (lv_actions_10_0= ruleBehaviorAction )
                            {
                            // InternalBehaviorAnnexParser.g:1603:7: (lv_actions_10_0= ruleBehaviorAction )
                            // InternalBehaviorAnnexParser.g:1604:8: lv_actions_10_0= ruleBehaviorAction
                            {
                            if ( state.backtracking==0 ) {

                                                              newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_1_3_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_40);
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
                            break loop35;
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
    // InternalBehaviorAnnexParser.g:1628:1: entryRuleBehaviorAction returns [EObject current=null] : iv_ruleBehaviorAction= ruleBehaviorAction EOF ;
    public final EObject entryRuleBehaviorAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorAction = null;


        try {
            // InternalBehaviorAnnexParser.g:1628:55: (iv_ruleBehaviorAction= ruleBehaviorAction EOF )
            // InternalBehaviorAnnexParser.g:1629:2: iv_ruleBehaviorAction= ruleBehaviorAction EOF
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
    // InternalBehaviorAnnexParser.g:1635:1: ruleBehaviorAction returns [EObject current=null] : ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock ) ;
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
            // InternalBehaviorAnnexParser.g:1641:2: ( ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock ) )
            // InternalBehaviorAnnexParser.g:1642:2: ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock )
            {
            // InternalBehaviorAnnexParser.g:1642:2: ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock )
            int alt37=8;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1643:3: ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction )
                    {
                    // InternalBehaviorAnnexParser.g:1643:3: ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction )
                    // InternalBehaviorAnnexParser.g:1644:4: ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction
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
                    // InternalBehaviorAnnexParser.g:1655:3: this_CommunicationAction_1= ruleCommunicationAction
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
                    // InternalBehaviorAnnexParser.g:1664:3: this_TimedAction_2= ruleTimedAction
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
                    // InternalBehaviorAnnexParser.g:1673:3: this_IfStatement_3= ruleIfStatement
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
                    // InternalBehaviorAnnexParser.g:1682:3: this_ForStatement_4= ruleForStatement
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
                    // InternalBehaviorAnnexParser.g:1691:3: this_WhileStatement_5= ruleWhileStatement
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
                    // InternalBehaviorAnnexParser.g:1700:3: this_DoUntilStatement_6= ruleDoUntilStatement
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
                    // InternalBehaviorAnnexParser.g:1709:3: this_BehaviorActionBlock_7= ruleBehaviorActionBlock
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
    // InternalBehaviorAnnexParser.g:1721:1: entryRuleAssignmentAction returns [EObject current=null] : iv_ruleAssignmentAction= ruleAssignmentAction EOF ;
    public final EObject entryRuleAssignmentAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentAction = null;


        try {
            // InternalBehaviorAnnexParser.g:1721:57: (iv_ruleAssignmentAction= ruleAssignmentAction EOF )
            // InternalBehaviorAnnexParser.g:1722:2: iv_ruleAssignmentAction= ruleAssignmentAction EOF
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
    // InternalBehaviorAnnexParser.g:1728:1: ruleAssignmentAction returns [EObject current=null] : ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) ) ;
    public final EObject ruleAssignmentAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_any_3_0=null;
        EObject lv_target_0_0 = null;

        EObject lv_value_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1734:2: ( ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) ) )
            // InternalBehaviorAnnexParser.g:1735:2: ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) )
            {
            // InternalBehaviorAnnexParser.g:1735:2: ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) )
            // InternalBehaviorAnnexParser.g:1736:3: ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) )
            {
            // InternalBehaviorAnnexParser.g:1736:3: ( (lv_target_0_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:1737:4: (lv_target_0_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:1737:4: (lv_target_0_0= ruleReference )
            // InternalBehaviorAnnexParser.g:1738:5: lv_target_0_0= ruleReference
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getAssignmentActionAccess().getTargetReferenceParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_41);
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

            otherlv_1=(Token)match(input,ColonEqualsSign,FollowSets000.FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getAssignmentActionAccess().getColonEqualsSignKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:1759:3: ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==False||LA38_0==True||LA38_0==Abs||LA38_0==Not||LA38_0==NumberSign||LA38_0==LeftParenthesis||LA38_0==PlusSign||LA38_0==HyphenMinus||LA38_0==RULE_REAL_LIT||LA38_0==RULE_INTEGER_LIT||(LA38_0>=RULE_STRING && LA38_0<=RULE_ID)) ) {
                alt38=1;
            }
            else if ( (LA38_0==Any) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1760:4: ( (lv_value_2_0= ruleValueExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:1760:4: ( (lv_value_2_0= ruleValueExpression ) )
                    // InternalBehaviorAnnexParser.g:1761:5: (lv_value_2_0= ruleValueExpression )
                    {
                    // InternalBehaviorAnnexParser.g:1761:5: (lv_value_2_0= ruleValueExpression )
                    // InternalBehaviorAnnexParser.g:1762:6: lv_value_2_0= ruleValueExpression
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
                    // InternalBehaviorAnnexParser.g:1780:4: ( (lv_any_3_0= Any ) )
                    {
                    // InternalBehaviorAnnexParser.g:1780:4: ( (lv_any_3_0= Any ) )
                    // InternalBehaviorAnnexParser.g:1781:5: (lv_any_3_0= Any )
                    {
                    // InternalBehaviorAnnexParser.g:1781:5: (lv_any_3_0= Any )
                    // InternalBehaviorAnnexParser.g:1782:6: lv_any_3_0= Any
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
    // InternalBehaviorAnnexParser.g:1799:1: entryRuleCommunicationAction returns [EObject current=null] : iv_ruleCommunicationAction= ruleCommunicationAction EOF ;
    public final EObject entryRuleCommunicationAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommunicationAction = null;


        try {
            // InternalBehaviorAnnexParser.g:1799:60: (iv_ruleCommunicationAction= ruleCommunicationAction EOF )
            // InternalBehaviorAnnexParser.g:1800:2: iv_ruleCommunicationAction= ruleCommunicationAction EOF
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
    // InternalBehaviorAnnexParser.g:1806:1: ruleCommunicationAction returns [EObject current=null] : ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) ) ;
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
            // InternalBehaviorAnnexParser.g:1812:2: ( ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) ) )
            // InternalBehaviorAnnexParser.g:1813:2: ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) )
            {
            // InternalBehaviorAnnexParser.g:1813:2: ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                alt44=1;
            }
            else if ( (LA44_0==Asterisk) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1814:3: ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:1814:3: ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) )
                    // InternalBehaviorAnnexParser.g:1815:4: ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:1815:4: ( (lv_reference_0_0= ruleReference ) )
                    // InternalBehaviorAnnexParser.g:1816:5: (lv_reference_0_0= ruleReference )
                    {
                    // InternalBehaviorAnnexParser.g:1816:5: (lv_reference_0_0= ruleReference )
                    // InternalBehaviorAnnexParser.g:1817:6: lv_reference_0_0= ruleReference
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getCommunicationActionAccess().getReferenceReferenceParserRuleCall_0_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_43);
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

                    // InternalBehaviorAnnexParser.g:1834:4: ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) )
                    int alt42=5;
                    switch ( input.LA(1) ) {
                    case ExclamationMark:
                        {
                        alt42=1;
                        }
                        break;
                    case QuestionMark:
                        {
                        alt42=2;
                        }
                        break;
                    case GreaterThanSignGreaterThanSign:
                        {
                        alt42=3;
                        }
                        break;
                    case ExclamationMarkLessThanSign:
                        {
                        alt42=4;
                        }
                        break;
                    case ExclamationMarkGreaterThanSign:
                        {
                        alt42=5;
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
                            // InternalBehaviorAnnexParser.g:1835:5: ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? )
                            {
                            // InternalBehaviorAnnexParser.g:1835:5: ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? )
                            // InternalBehaviorAnnexParser.g:1836:6: ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )?
                            {
                            // InternalBehaviorAnnexParser.g:1836:6: ( (lv_send_1_0= ExclamationMark ) )
                            // InternalBehaviorAnnexParser.g:1837:7: (lv_send_1_0= ExclamationMark )
                            {
                            // InternalBehaviorAnnexParser.g:1837:7: (lv_send_1_0= ExclamationMark )
                            // InternalBehaviorAnnexParser.g:1838:8: lv_send_1_0= ExclamationMark
                            {
                            lv_send_1_0=(Token)match(input,ExclamationMark,FollowSets000.FOLLOW_44); if (state.failed) return current;
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

                            // InternalBehaviorAnnexParser.g:1850:6: (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )?
                            int alt40=2;
                            int LA40_0 = input.LA(1);

                            if ( (LA40_0==LeftParenthesis) ) {
                                alt40=1;
                            }
                            switch (alt40) {
                                case 1 :
                                    // InternalBehaviorAnnexParser.g:1851:7: otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis
                                    {
                                    otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_45); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                                                  newLeafNode(otherlv_2, grammarAccess.getCommunicationActionAccess().getLeftParenthesisKeyword_0_1_0_1_0());

                                    }
                                    // InternalBehaviorAnnexParser.g:1855:7: ( (lv_parameters_3_0= ruleValueExpression ) )
                                    // InternalBehaviorAnnexParser.g:1856:8: (lv_parameters_3_0= ruleValueExpression )
                                    {
                                    // InternalBehaviorAnnexParser.g:1856:8: (lv_parameters_3_0= ruleValueExpression )
                                    // InternalBehaviorAnnexParser.g:1857:9: lv_parameters_3_0= ruleValueExpression
                                    {
                                    if ( state.backtracking==0 ) {

                                                                          newCompositeNode(grammarAccess.getCommunicationActionAccess().getParametersValueExpressionParserRuleCall_0_1_0_1_1_0());

                                    }
                                    pushFollow(FollowSets000.FOLLOW_46);
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

                                    // InternalBehaviorAnnexParser.g:1874:7: (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )*
                                    loop39:
                                    do {
                                        int alt39=2;
                                        int LA39_0 = input.LA(1);

                                        if ( (LA39_0==Comma) ) {
                                            alt39=1;
                                        }


                                        switch (alt39) {
                                        case 1 :
                                            // InternalBehaviorAnnexParser.g:1875:8: otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) )
                                            {
                                            otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_45); if (state.failed) return current;
                                            if ( state.backtracking==0 ) {

                                                                              newLeafNode(otherlv_4, grammarAccess.getCommunicationActionAccess().getCommaKeyword_0_1_0_1_2_0());

                                            }
                                            // InternalBehaviorAnnexParser.g:1879:8: ( (lv_parameters_5_0= ruleValueExpression ) )
                                            // InternalBehaviorAnnexParser.g:1880:9: (lv_parameters_5_0= ruleValueExpression )
                                            {
                                            // InternalBehaviorAnnexParser.g:1880:9: (lv_parameters_5_0= ruleValueExpression )
                                            // InternalBehaviorAnnexParser.g:1881:10: lv_parameters_5_0= ruleValueExpression
                                            {
                                            if ( state.backtracking==0 ) {

                                                                                      newCompositeNode(grammarAccess.getCommunicationActionAccess().getParametersValueExpressionParserRuleCall_0_1_0_1_2_1_0());

                                            }
                                            pushFollow(FollowSets000.FOLLOW_46);
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
                                            break loop39;
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
                            // InternalBehaviorAnnexParser.g:1906:5: ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? )
                            {
                            // InternalBehaviorAnnexParser.g:1906:5: ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? )
                            // InternalBehaviorAnnexParser.g:1907:6: ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )?
                            {
                            // InternalBehaviorAnnexParser.g:1907:6: ( (lv_dequeue_7_0= QuestionMark ) )
                            // InternalBehaviorAnnexParser.g:1908:7: (lv_dequeue_7_0= QuestionMark )
                            {
                            // InternalBehaviorAnnexParser.g:1908:7: (lv_dequeue_7_0= QuestionMark )
                            // InternalBehaviorAnnexParser.g:1909:8: lv_dequeue_7_0= QuestionMark
                            {
                            lv_dequeue_7_0=(Token)match(input,QuestionMark,FollowSets000.FOLLOW_44); if (state.failed) return current;
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

                            // InternalBehaviorAnnexParser.g:1921:6: (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )?
                            int alt41=2;
                            int LA41_0 = input.LA(1);

                            if ( (LA41_0==LeftParenthesis) ) {
                                alt41=1;
                            }
                            switch (alt41) {
                                case 1 :
                                    // InternalBehaviorAnnexParser.g:1922:7: otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis
                                    {
                                    otherlv_8=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                                                  newLeafNode(otherlv_8, grammarAccess.getCommunicationActionAccess().getLeftParenthesisKeyword_0_1_1_1_0());

                                    }
                                    // InternalBehaviorAnnexParser.g:1926:7: ( (lv_target_9_0= ruleReference ) )
                                    // InternalBehaviorAnnexParser.g:1927:8: (lv_target_9_0= ruleReference )
                                    {
                                    // InternalBehaviorAnnexParser.g:1927:8: (lv_target_9_0= ruleReference )
                                    // InternalBehaviorAnnexParser.g:1928:9: lv_target_9_0= ruleReference
                                    {
                                    if ( state.backtracking==0 ) {

                                                                          newCompositeNode(grammarAccess.getCommunicationActionAccess().getTargetReferenceParserRuleCall_0_1_1_1_1_0());

                                    }
                                    pushFollow(FollowSets000.FOLLOW_47);
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
                            // InternalBehaviorAnnexParser.g:1952:5: ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:1952:5: ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) )
                            // InternalBehaviorAnnexParser.g:1953:6: (lv_freeze_11_0= GreaterThanSignGreaterThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:1953:6: (lv_freeze_11_0= GreaterThanSignGreaterThanSign )
                            // InternalBehaviorAnnexParser.g:1954:7: lv_freeze_11_0= GreaterThanSignGreaterThanSign
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
                            // InternalBehaviorAnnexParser.g:1967:5: ( (lv_lock_12_0= ExclamationMarkLessThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:1967:5: ( (lv_lock_12_0= ExclamationMarkLessThanSign ) )
                            // InternalBehaviorAnnexParser.g:1968:6: (lv_lock_12_0= ExclamationMarkLessThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:1968:6: (lv_lock_12_0= ExclamationMarkLessThanSign )
                            // InternalBehaviorAnnexParser.g:1969:7: lv_lock_12_0= ExclamationMarkLessThanSign
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
                            // InternalBehaviorAnnexParser.g:1982:5: ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:1982:5: ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) )
                            // InternalBehaviorAnnexParser.g:1983:6: (lv_unlock_13_0= ExclamationMarkGreaterThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:1983:6: (lv_unlock_13_0= ExclamationMarkGreaterThanSign )
                            // InternalBehaviorAnnexParser.g:1984:7: lv_unlock_13_0= ExclamationMarkGreaterThanSign
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
                    // InternalBehaviorAnnexParser.g:1999:3: ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:1999:3: ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) )
                    // InternalBehaviorAnnexParser.g:2000:4: ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:2000:4: ( (lv_all_14_0= Asterisk ) )
                    // InternalBehaviorAnnexParser.g:2001:5: (lv_all_14_0= Asterisk )
                    {
                    // InternalBehaviorAnnexParser.g:2001:5: (lv_all_14_0= Asterisk )
                    // InternalBehaviorAnnexParser.g:2002:6: lv_all_14_0= Asterisk
                    {
                    lv_all_14_0=(Token)match(input,Asterisk,FollowSets000.FOLLOW_48); if (state.failed) return current;
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

                    // InternalBehaviorAnnexParser.g:2014:4: ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==ExclamationMarkLessThanSign) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==ExclamationMarkGreaterThanSign) ) {
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
                            // InternalBehaviorAnnexParser.g:2015:5: ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2015:5: ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) )
                            // InternalBehaviorAnnexParser.g:2016:6: (lv_allLock_15_0= ExclamationMarkLessThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2016:6: (lv_allLock_15_0= ExclamationMarkLessThanSign )
                            // InternalBehaviorAnnexParser.g:2017:7: lv_allLock_15_0= ExclamationMarkLessThanSign
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
                            // InternalBehaviorAnnexParser.g:2030:5: ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2030:5: ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) )
                            // InternalBehaviorAnnexParser.g:2031:6: (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2031:6: (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign )
                            // InternalBehaviorAnnexParser.g:2032:7: lv_allUnlock_16_0= ExclamationMarkGreaterThanSign
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
    // InternalBehaviorAnnexParser.g:2050:1: entryRuleTimedAction returns [EObject current=null] : iv_ruleTimedAction= ruleTimedAction EOF ;
    public final EObject entryRuleTimedAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimedAction = null;


        try {
            // InternalBehaviorAnnexParser.g:2050:52: (iv_ruleTimedAction= ruleTimedAction EOF )
            // InternalBehaviorAnnexParser.g:2051:2: iv_ruleTimedAction= ruleTimedAction EOF
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
    // InternalBehaviorAnnexParser.g:2057:1: ruleTimedAction returns [EObject current=null] : (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? ) ;
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
            // InternalBehaviorAnnexParser.g:2063:2: ( (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? ) )
            // InternalBehaviorAnnexParser.g:2064:2: (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? )
            {
            // InternalBehaviorAnnexParser.g:2064:2: (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? )
            // InternalBehaviorAnnexParser.g:2065:3: otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )?
            {
            otherlv_0=(Token)match(input,Computation,FollowSets000.FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getTimedActionAccess().getComputationKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getTimedActionAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:2073:3: ( (lv_lowerTime_2_0= ruleBehaviorTime ) )
            // InternalBehaviorAnnexParser.g:2074:4: (lv_lowerTime_2_0= ruleBehaviorTime )
            {
            // InternalBehaviorAnnexParser.g:2074:4: (lv_lowerTime_2_0= ruleBehaviorTime )
            // InternalBehaviorAnnexParser.g:2075:5: lv_lowerTime_2_0= ruleBehaviorTime
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getTimedActionAccess().getLowerTimeBehaviorTimeParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_50);
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

            // InternalBehaviorAnnexParser.g:2092:3: (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==FullStopFullStop) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2093:4: otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_3, grammarAccess.getTimedActionAccess().getFullStopFullStopKeyword_3_0());

                    }
                    // InternalBehaviorAnnexParser.g:2097:4: ( (lv_upperTime_4_0= ruleBehaviorTime ) )
                    // InternalBehaviorAnnexParser.g:2098:5: (lv_upperTime_4_0= ruleBehaviorTime )
                    {
                    // InternalBehaviorAnnexParser.g:2098:5: (lv_upperTime_4_0= ruleBehaviorTime )
                    // InternalBehaviorAnnexParser.g:2099:6: lv_upperTime_4_0= ruleBehaviorTime
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getTimedActionAccess().getUpperTimeBehaviorTimeParserRuleCall_3_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_47);
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

            otherlv_5=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_5, grammarAccess.getTimedActionAccess().getRightParenthesisKeyword_4());

            }
            // InternalBehaviorAnnexParser.g:2121:3: (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==In) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2122:4: otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis
                    {
                    otherlv_6=(Token)match(input,In,FollowSets000.FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_6, grammarAccess.getTimedActionAccess().getInKeyword_5_0());

                    }
                    otherlv_7=(Token)match(input,Binding,FollowSets000.FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_7, grammarAccess.getTimedActionAccess().getBindingKeyword_5_1());

                    }
                    otherlv_8=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_8, grammarAccess.getTimedActionAccess().getLeftParenthesisKeyword_5_2());

                    }
                    // InternalBehaviorAnnexParser.g:2134:4: ( ( ruleQCREF ) )
                    // InternalBehaviorAnnexParser.g:2135:5: ( ruleQCREF )
                    {
                    // InternalBehaviorAnnexParser.g:2135:5: ( ruleQCREF )
                    // InternalBehaviorAnnexParser.g:2136:6: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                                              if (current==null) {
                                                  current = createModelElement(grammarAccess.getTimedActionRule());
                                              }

                    }
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getTimedActionAccess().getProcessorsComponentClassifierCrossReference_5_3_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_46);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                              afterParserOrEnumRuleCall();

                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:2150:4: (otherlv_10= Comma ( ( ruleQCREF ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==Comma) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:2151:5: otherlv_10= Comma ( ( ruleQCREF ) )
                            {
                            otherlv_10=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                  newLeafNode(otherlv_10, grammarAccess.getTimedActionAccess().getCommaKeyword_5_4_0());

                            }
                            // InternalBehaviorAnnexParser.g:2155:5: ( ( ruleQCREF ) )
                            // InternalBehaviorAnnexParser.g:2156:6: ( ruleQCREF )
                            {
                            // InternalBehaviorAnnexParser.g:2156:6: ( ruleQCREF )
                            // InternalBehaviorAnnexParser.g:2157:7: ruleQCREF
                            {
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getTimedActionRule());
                                                          }

                            }
                            if ( state.backtracking==0 ) {

                                                          newCompositeNode(grammarAccess.getTimedActionAccess().getProcessorsComponentClassifierCrossReference_5_4_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_46);
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
                            break loop46;
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
    // InternalBehaviorAnnexParser.g:2181:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2181:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalBehaviorAnnexParser.g:2182:2: iv_ruleIfStatement= ruleIfStatement EOF
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
    // InternalBehaviorAnnexParser.g:2188:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If ) ;
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
            // InternalBehaviorAnnexParser.g:2194:2: ( (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If ) )
            // InternalBehaviorAnnexParser.g:2195:2: (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If )
            {
            // InternalBehaviorAnnexParser.g:2195:2: (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If )
            // InternalBehaviorAnnexParser.g:2196:3: otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If
            {
            otherlv_0=(Token)match(input,If,FollowSets000.FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:2204:3: ( (lv_condition_2_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2205:4: (lv_condition_2_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2205:4: (lv_condition_2_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2206:5: lv_condition_2_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getIfStatementAccess().getConditionValueExpressionParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_47);
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

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3());

            }
            // InternalBehaviorAnnexParser.g:2227:3: ( (lv_thenActions_4_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2228:4: (lv_thenActions_4_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2228:4: (lv_thenActions_4_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2229:5: lv_thenActions_4_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getIfStatementAccess().getThenActionsBehaviorActionsParserRuleCall_4_0());

            }
            pushFollow(FollowSets000.FOLLOW_53);
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

            // InternalBehaviorAnnexParser.g:2246:3: ( (lv_elseIfs_5_0= ruleElseIfClause ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==Elsif) ) {
                    alt48=1;
                }


                switch (alt48) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2247:4: (lv_elseIfs_5_0= ruleElseIfClause )
                    {
                    // InternalBehaviorAnnexParser.g:2247:4: (lv_elseIfs_5_0= ruleElseIfClause )
                    // InternalBehaviorAnnexParser.g:2248:5: lv_elseIfs_5_0= ruleElseIfClause
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfsElseIfClauseParserRuleCall_5_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_53);
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
                    break loop48;
                }
            } while (true);

            // InternalBehaviorAnnexParser.g:2265:3: (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==Else) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2266:4: otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) )
                    {
                    otherlv_6=(Token)match(input,Else,FollowSets000.FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getElseKeyword_6_0());

                    }
                    // InternalBehaviorAnnexParser.g:2270:4: ( (lv_elseActions_7_0= ruleBehaviorActions ) )
                    // InternalBehaviorAnnexParser.g:2271:5: (lv_elseActions_7_0= ruleBehaviorActions )
                    {
                    // InternalBehaviorAnnexParser.g:2271:5: (lv_elseActions_7_0= ruleBehaviorActions )
                    // InternalBehaviorAnnexParser.g:2272:6: lv_elseActions_7_0= ruleBehaviorActions
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getIfStatementAccess().getElseActionsBehaviorActionsParserRuleCall_6_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_54);
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

            otherlv_8=(Token)match(input,End,FollowSets000.FOLLOW_55); if (state.failed) return current;
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
    // InternalBehaviorAnnexParser.g:2302:1: entryRuleElseIfClause returns [EObject current=null] : iv_ruleElseIfClause= ruleElseIfClause EOF ;
    public final EObject entryRuleElseIfClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfClause = null;


        try {
            // InternalBehaviorAnnexParser.g:2302:53: (iv_ruleElseIfClause= ruleElseIfClause EOF )
            // InternalBehaviorAnnexParser.g:2303:2: iv_ruleElseIfClause= ruleElseIfClause EOF
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
    // InternalBehaviorAnnexParser.g:2309:1: ruleElseIfClause returns [EObject current=null] : (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) ) ;
    public final EObject ruleElseIfClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_actions_4_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2315:2: ( (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) ) )
            // InternalBehaviorAnnexParser.g:2316:2: (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) )
            {
            // InternalBehaviorAnnexParser.g:2316:2: (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) )
            // InternalBehaviorAnnexParser.g:2317:3: otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) )
            {
            otherlv_0=(Token)match(input,Elsif,FollowSets000.FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getElseIfClauseAccess().getElsifKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getElseIfClauseAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:2325:3: ( (lv_condition_2_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2326:4: (lv_condition_2_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2326:4: (lv_condition_2_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2327:5: lv_condition_2_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getElseIfClauseAccess().getConditionValueExpressionParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_47);
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

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_3, grammarAccess.getElseIfClauseAccess().getRightParenthesisKeyword_3());

            }
            // InternalBehaviorAnnexParser.g:2348:3: ( (lv_actions_4_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2349:4: (lv_actions_4_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2349:4: (lv_actions_4_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2350:5: lv_actions_4_0= ruleBehaviorActions
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
    // InternalBehaviorAnnexParser.g:2371:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2371:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalBehaviorAnnexParser.g:2372:2: iv_ruleForStatement= ruleForStatement EOF
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
    // InternalBehaviorAnnexParser.g:2378:1: ruleForStatement returns [EObject current=null] : ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) otherlv_4= Colon ( ( ruleQCREF ) ) otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket ) ;
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
            // InternalBehaviorAnnexParser.g:2384:2: ( ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) otherlv_4= Colon ( ( ruleQCREF ) ) otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket ) )
            // InternalBehaviorAnnexParser.g:2385:2: ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) otherlv_4= Colon ( ( ruleQCREF ) ) otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket )
            {
            // InternalBehaviorAnnexParser.g:2385:2: ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) otherlv_4= Colon ( ( ruleQCREF ) ) otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket )
            // InternalBehaviorAnnexParser.g:2386:3: ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) otherlv_4= Colon ( ( ruleQCREF ) ) otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket
            {
            // InternalBehaviorAnnexParser.g:2386:3: ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==For) ) {
                alt50=1;
            }
            else if ( (LA50_0==Forall) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2387:4: ( (lv_for_0_0= For ) )
                    {
                    // InternalBehaviorAnnexParser.g:2387:4: ( (lv_for_0_0= For ) )
                    // InternalBehaviorAnnexParser.g:2388:5: (lv_for_0_0= For )
                    {
                    // InternalBehaviorAnnexParser.g:2388:5: (lv_for_0_0= For )
                    // InternalBehaviorAnnexParser.g:2389:6: lv_for_0_0= For
                    {
                    lv_for_0_0=(Token)match(input,For,FollowSets000.FOLLOW_49); if (state.failed) return current;
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
                    // InternalBehaviorAnnexParser.g:2402:4: ( (lv_forall_1_0= Forall ) )
                    {
                    // InternalBehaviorAnnexParser.g:2402:4: ( (lv_forall_1_0= Forall ) )
                    // InternalBehaviorAnnexParser.g:2403:5: (lv_forall_1_0= Forall )
                    {
                    // InternalBehaviorAnnexParser.g:2403:5: (lv_forall_1_0= Forall )
                    // InternalBehaviorAnnexParser.g:2404:6: lv_forall_1_0= Forall
                    {
                    lv_forall_1_0=(Token)match(input,Forall,FollowSets000.FOLLOW_49); if (state.failed) return current;
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
            // InternalBehaviorAnnexParser.g:2421:3: ( (lv_variable_3_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:2422:4: (lv_variable_3_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:2422:4: (lv_variable_3_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:2423:5: lv_variable_3_0= RULE_ID
            {
            lv_variable_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_24); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,Colon,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_4, grammarAccess.getForStatementAccess().getColonKeyword_3());

            }
            // InternalBehaviorAnnexParser.g:2443:3: ( ( ruleQCREF ) )
            // InternalBehaviorAnnexParser.g:2444:4: ( ruleQCREF )
            {
            // InternalBehaviorAnnexParser.g:2444:4: ( ruleQCREF )
            // InternalBehaviorAnnexParser.g:2445:5: ruleQCREF
            {
            if ( state.backtracking==0 ) {

                                  if (current==null) {
                                      current = createModelElement(grammarAccess.getForStatementRule());
                                  }

            }
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getForStatementAccess().getDataClassifierComponentClassifierCrossReference_4_0());

            }
            pushFollow(FollowSets000.FOLLOW_56);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                                  afterParserOrEnumRuleCall();

            }

            }


            }

            otherlv_6=(Token)match(input,In,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_6, grammarAccess.getForStatementAccess().getInKeyword_5());

            }
            // InternalBehaviorAnnexParser.g:2463:3: ( (lv_values_7_0= ruleElementValues ) )
            // InternalBehaviorAnnexParser.g:2464:4: (lv_values_7_0= ruleElementValues )
            {
            // InternalBehaviorAnnexParser.g:2464:4: (lv_values_7_0= ruleElementValues )
            // InternalBehaviorAnnexParser.g:2465:5: lv_values_7_0= ruleElementValues
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getForStatementAccess().getValuesElementValuesParserRuleCall_6_0());

            }
            pushFollow(FollowSets000.FOLLOW_47);
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

            otherlv_8=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_8, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_7());

            }
            otherlv_9=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_9, grammarAccess.getForStatementAccess().getLeftCurlyBracketKeyword_8());

            }
            // InternalBehaviorAnnexParser.g:2490:3: ( (lv_actions_10_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2491:4: (lv_actions_10_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2491:4: (lv_actions_10_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2492:5: lv_actions_10_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getForStatementAccess().getActionsBehaviorActionsParserRuleCall_9_0());

            }
            pushFollow(FollowSets000.FOLLOW_36);
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

                          newLeafNode(otherlv_11, grammarAccess.getForStatementAccess().getRightCurlyBracketKeyword_10());

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
    // InternalBehaviorAnnexParser.g:2517:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2517:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalBehaviorAnnexParser.g:2518:2: iv_ruleWhileStatement= ruleWhileStatement EOF
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
    // InternalBehaviorAnnexParser.g:2524:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket ) ;
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
            // InternalBehaviorAnnexParser.g:2530:2: ( (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket ) )
            // InternalBehaviorAnnexParser.g:2531:2: (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket )
            {
            // InternalBehaviorAnnexParser.g:2531:2: (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket )
            // InternalBehaviorAnnexParser.g:2532:3: otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket
            {
            otherlv_0=(Token)match(input,While,FollowSets000.FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:2540:3: ( (lv_condition_2_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2541:4: (lv_condition_2_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2541:4: (lv_condition_2_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2542:5: lv_condition_2_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionValueExpressionParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_47);
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

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_3, grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_3());

            }
            otherlv_4=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_4, grammarAccess.getWhileStatementAccess().getLeftCurlyBracketKeyword_4());

            }
            // InternalBehaviorAnnexParser.g:2567:3: ( (lv_actions_5_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2568:4: (lv_actions_5_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2568:4: (lv_actions_5_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2569:5: lv_actions_5_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getWhileStatementAccess().getActionsBehaviorActionsParserRuleCall_5_0());

            }
            pushFollow(FollowSets000.FOLLOW_36);
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
    // InternalBehaviorAnnexParser.g:2594:1: entryRuleDoUntilStatement returns [EObject current=null] : iv_ruleDoUntilStatement= ruleDoUntilStatement EOF ;
    public final EObject entryRuleDoUntilStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoUntilStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2594:57: (iv_ruleDoUntilStatement= ruleDoUntilStatement EOF )
            // InternalBehaviorAnnexParser.g:2595:2: iv_ruleDoUntilStatement= ruleDoUntilStatement EOF
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
    // InternalBehaviorAnnexParser.g:2601:1: ruleDoUntilStatement returns [EObject current=null] : (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis ) ;
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
            // InternalBehaviorAnnexParser.g:2607:2: ( (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:2608:2: (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:2608:2: (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis )
            // InternalBehaviorAnnexParser.g:2609:3: otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis
            {
            otherlv_0=(Token)match(input,Do,FollowSets000.FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getDoUntilStatementAccess().getDoKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:2613:3: ( (lv_actions_1_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2614:4: (lv_actions_1_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2614:4: (lv_actions_1_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2615:5: lv_actions_1_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getDoUntilStatementAccess().getActionsBehaviorActionsParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_58);
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

            otherlv_2=(Token)match(input,Until,FollowSets000.FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_2, grammarAccess.getDoUntilStatementAccess().getUntilKeyword_2());

            }
            otherlv_3=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_3, grammarAccess.getDoUntilStatementAccess().getLeftParenthesisKeyword_3());

            }
            // InternalBehaviorAnnexParser.g:2640:3: ( (lv_condition_4_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2641:4: (lv_condition_4_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2641:4: (lv_condition_4_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2642:5: lv_condition_4_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getDoUntilStatementAccess().getConditionValueExpressionParserRuleCall_4_0());

            }
            pushFollow(FollowSets000.FOLLOW_47);
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
    // InternalBehaviorAnnexParser.g:2667:1: entryRuleElementValues returns [EObject current=null] : iv_ruleElementValues= ruleElementValues EOF ;
    public final EObject entryRuleElementValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementValues = null;


        try {
            // InternalBehaviorAnnexParser.g:2667:54: (iv_ruleElementValues= ruleElementValues EOF )
            // InternalBehaviorAnnexParser.g:2668:2: iv_ruleElementValues= ruleElementValues EOF
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
    // InternalBehaviorAnnexParser.g:2674:1: ruleElementValues returns [EObject current=null] : ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? ) ;
    public final EObject ruleElementValues() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_lower_0_0 = null;

        EObject lv_upper_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2680:2: ( ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? ) )
            // InternalBehaviorAnnexParser.g:2681:2: ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:2681:2: ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? )
            // InternalBehaviorAnnexParser.g:2682:3: ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )?
            {
            // InternalBehaviorAnnexParser.g:2682:3: ( (lv_lower_0_0= ruleIntegerValue ) )
            // InternalBehaviorAnnexParser.g:2683:4: (lv_lower_0_0= ruleIntegerValue )
            {
            // InternalBehaviorAnnexParser.g:2683:4: (lv_lower_0_0= ruleIntegerValue )
            // InternalBehaviorAnnexParser.g:2684:5: lv_lower_0_0= ruleIntegerValue
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getElementValuesAccess().getLowerIntegerValueParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_59);
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

            // InternalBehaviorAnnexParser.g:2701:3: (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FullStopFullStop) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2702:4: otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) )
                    {
                    otherlv_1=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_1, grammarAccess.getElementValuesAccess().getFullStopFullStopKeyword_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:2706:4: ( (lv_upper_2_0= ruleIntegerValue ) )
                    // InternalBehaviorAnnexParser.g:2707:5: (lv_upper_2_0= ruleIntegerValue )
                    {
                    // InternalBehaviorAnnexParser.g:2707:5: (lv_upper_2_0= ruleIntegerValue )
                    // InternalBehaviorAnnexParser.g:2708:6: lv_upper_2_0= ruleIntegerValue
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
    // InternalBehaviorAnnexParser.g:2730:1: entryRuleBehaviorTime returns [EObject current=null] : iv_ruleBehaviorTime= ruleBehaviorTime EOF ;
    public final EObject entryRuleBehaviorTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorTime = null;


        try {
            // InternalBehaviorAnnexParser.g:2730:53: (iv_ruleBehaviorTime= ruleBehaviorTime EOF )
            // InternalBehaviorAnnexParser.g:2731:2: iv_ruleBehaviorTime= ruleBehaviorTime EOF
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
    // InternalBehaviorAnnexParser.g:2737:1: ruleBehaviorTime returns [EObject current=null] : ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleBehaviorTime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2743:2: ( ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) ) )
            // InternalBehaviorAnnexParser.g:2744:2: ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalBehaviorAnnexParser.g:2744:2: ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) )
            // InternalBehaviorAnnexParser.g:2745:3: ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) )
            {
            // InternalBehaviorAnnexParser.g:2745:3: ( (lv_value_0_0= ruleIntegerValue ) )
            // InternalBehaviorAnnexParser.g:2746:4: (lv_value_0_0= ruleIntegerValue )
            {
            // InternalBehaviorAnnexParser.g:2746:4: (lv_value_0_0= ruleIntegerValue )
            // InternalBehaviorAnnexParser.g:2747:5: lv_value_0_0= ruleIntegerValue
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

            // InternalBehaviorAnnexParser.g:2764:3: ( (otherlv_1= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:2765:4: (otherlv_1= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:2765:4: (otherlv_1= RULE_ID )
            // InternalBehaviorAnnexParser.g:2766:5: otherlv_1= RULE_ID
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
    // InternalBehaviorAnnexParser.g:2781:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // InternalBehaviorAnnexParser.g:2781:53: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // InternalBehaviorAnnexParser.g:2782:2: iv_ruleIntegerValue= ruleIntegerValue EOF
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
    // InternalBehaviorAnnexParser.g:2788:1: ruleIntegerValue returns [EObject current=null] : (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject this_BehaviorIntegerLiteral_0 = null;

        EObject this_HashPropertyReference_1 = null;

        EObject this_ReferenceExpression_2 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2794:2: ( (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression ) )
            // InternalBehaviorAnnexParser.g:2795:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression )
            {
            // InternalBehaviorAnnexParser.g:2795:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression )
            int alt52=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGER_LIT:
                {
                alt52=1;
                }
                break;
            case NumberSign:
                {
                alt52=2;
                }
                break;
            case RULE_ID:
                {
                alt52=3;
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
                    // InternalBehaviorAnnexParser.g:2796:3: this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral
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
                    // InternalBehaviorAnnexParser.g:2805:3: this_HashPropertyReference_1= ruleHashPropertyReference
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
                    // InternalBehaviorAnnexParser.g:2814:3: this_ReferenceExpression_2= ruleReferenceExpression
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
    // InternalBehaviorAnnexParser.g:2826:1: entryRuleValueExpression returns [EObject current=null] : iv_ruleValueExpression= ruleValueExpression EOF ;
    public final EObject entryRuleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:2826:56: (iv_ruleValueExpression= ruleValueExpression EOF )
            // InternalBehaviorAnnexParser.g:2827:2: iv_ruleValueExpression= ruleValueExpression EOF
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
    // InternalBehaviorAnnexParser.g:2833:1: ruleValueExpression returns [EObject current=null] : this_LogicalOrExpression_0= ruleLogicalOrExpression ;
    public final EObject ruleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalOrExpression_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2839:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression )
            // InternalBehaviorAnnexParser.g:2840:2: this_LogicalOrExpression_0= ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {

                      newCompositeNode(grammarAccess.getValueExpressionAccess().getLogicalOrExpressionParserRuleCall());

            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_LogicalOrExpression_0;
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
    // $ANTLR end "ruleValueExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // InternalBehaviorAnnexParser.g:2851:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:2851:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalBehaviorAnnexParser.g:2852:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression;
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
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // InternalBehaviorAnnexParser.g:2858:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2864:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalBehaviorAnnexParser.g:2865:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:2865:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalBehaviorAnnexParser.g:2866:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_60);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_LogicalAndExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:2874:3: ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==Xor||LA54_0==Or) ) {
                    alt54=1;
                }


                switch (alt54) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2875:4: () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:2875:4: ()
                    // InternalBehaviorAnnexParser.g:2876:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getLogicalOrExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:2882:4: ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) )
                    // InternalBehaviorAnnexParser.g:2883:5: ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) )
                    {
                    // InternalBehaviorAnnexParser.g:2883:5: ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) )
                    // InternalBehaviorAnnexParser.g:2884:6: (lv_operator_2_1= Or | lv_operator_2_2= Xor )
                    {
                    // InternalBehaviorAnnexParser.g:2884:6: (lv_operator_2_1= Or | lv_operator_2_2= Xor )
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==Or) ) {
                        alt53=1;
                    }
                    else if ( (LA53_0==Xor) ) {
                        alt53=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 0, input);

                        throw nvae;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:2885:7: lv_operator_2_1= Or
                            {
                            lv_operator_2_1=(Token)match(input,Or,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_1, grammarAccess.getLogicalOrExpressionAccess().getOperatorOrKeyword_1_1_0_0());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getLogicalOrExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_1, null);

                            }

                            }
                            break;
                        case 2 :
                            // InternalBehaviorAnnexParser.g:2896:7: lv_operator_2_2= Xor
                            {
                            lv_operator_2_2=(Token)match(input,Xor,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_2, grammarAccess.getLogicalOrExpressionAccess().getOperatorXorKeyword_1_1_0_1());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getLogicalOrExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_2, null);

                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalBehaviorAnnexParser.g:2909:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    // InternalBehaviorAnnexParser.g:2910:5: (lv_right_3_0= ruleLogicalAndExpression )
                    {
                    // InternalBehaviorAnnexParser.g:2910:5: (lv_right_3_0= ruleLogicalAndExpression )
                    // InternalBehaviorAnnexParser.g:2911:6: lv_right_3_0= ruleLogicalAndExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_60);
                    lv_right_3_0=ruleLogicalAndExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                              if (current==null) {
                                                  current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
                                              }
                                              set(
                                                  current,
                                                  "right",
                                                  lv_right_3_0,
                                                  "org.osate.xtext.aadl2.ba.BehaviorAnnex.LogicalAndExpression");
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
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalBehaviorAnnexParser.g:2933:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:2933:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalBehaviorAnnexParser.g:2934:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression;
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
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // InternalBehaviorAnnexParser.g:2940:1: ruleLogicalAndExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_right_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2946:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalBehaviorAnnexParser.g:2947:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:2947:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // InternalBehaviorAnnexParser.g:2948:3: this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRelationalExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_34);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_RelationalExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:2956:3: ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==And) ) {
                    alt55=1;
                }


                switch (alt55) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2957:4: () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:2957:4: ()
                    // InternalBehaviorAnnexParser.g:2958:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getLogicalAndExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:2964:4: ( (lv_operator_2_0= And ) )
                    // InternalBehaviorAnnexParser.g:2965:5: (lv_operator_2_0= And )
                    {
                    // InternalBehaviorAnnexParser.g:2965:5: (lv_operator_2_0= And )
                    // InternalBehaviorAnnexParser.g:2966:6: lv_operator_2_0= And
                    {
                    lv_operator_2_0=(Token)match(input,And,FollowSets000.FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_operator_2_0, grammarAccess.getLogicalAndExpressionAccess().getOperatorAndKeyword_1_1_0());

                    }
                    if ( state.backtracking==0 ) {

                                              if (current==null) {
                                                  current = createModelElement(grammarAccess.getLogicalAndExpressionRule());
                                              }
                                              setWithLastConsumed(current, "operator", lv_operator_2_0, "and");

                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:2978:4: ( (lv_right_3_0= ruleRelationalExpression ) )
                    // InternalBehaviorAnnexParser.g:2979:5: (lv_right_3_0= ruleRelationalExpression )
                    {
                    // InternalBehaviorAnnexParser.g:2979:5: (lv_right_3_0= ruleRelationalExpression )
                    // InternalBehaviorAnnexParser.g:2980:6: lv_right_3_0= ruleRelationalExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_34);
                    lv_right_3_0=ruleRelationalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                              if (current==null) {
                                                  current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
                                              }
                                              set(
                                                  current,
                                                  "right",
                                                  lv_right_3_0,
                                                  "org.osate.xtext.aadl2.ba.BehaviorAnnex.RelationalExpression");
                                              afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

                default :
                    break loop55;
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
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalBehaviorAnnexParser.g:3002:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3002:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalBehaviorAnnexParser.g:3003:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalBehaviorAnnexParser.g:3009:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        Token lv_operator_2_5=null;
        Token lv_operator_2_6=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_right_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3015:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) )
            // InternalBehaviorAnnexParser.g:3016:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:3016:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            // InternalBehaviorAnnexParser.g:3017:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_61);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_AdditiveExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:3025:3: ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==ExclamationMarkEqualsSign||LA57_0==LessThanSignEqualsSign||LA57_0==GreaterThanSignEqualsSign||(LA57_0>=LessThanSign && LA57_0<=GreaterThanSign)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3026:4: () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3026:4: ()
                    // InternalBehaviorAnnexParser.g:3027:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getRelationalExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3033:4: ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) )
                    // InternalBehaviorAnnexParser.g:3034:5: ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) )
                    {
                    // InternalBehaviorAnnexParser.g:3034:5: ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) )
                    // InternalBehaviorAnnexParser.g:3035:6: (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign )
                    {
                    // InternalBehaviorAnnexParser.g:3035:6: (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign )
                    int alt56=6;
                    switch ( input.LA(1) ) {
                    case EqualsSign:
                        {
                        alt56=1;
                        }
                        break;
                    case ExclamationMarkEqualsSign:
                        {
                        alt56=2;
                        }
                        break;
                    case LessThanSign:
                        {
                        alt56=3;
                        }
                        break;
                    case LessThanSignEqualsSign:
                        {
                        alt56=4;
                        }
                        break;
                    case GreaterThanSign:
                        {
                        alt56=5;
                        }
                        break;
                    case GreaterThanSignEqualsSign:
                        {
                        alt56=6;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 56, 0, input);

                        throw nvae;
                    }

                    switch (alt56) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:3036:7: lv_operator_2_1= EqualsSign
                            {
                            lv_operator_2_1=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_1, grammarAccess.getRelationalExpressionAccess().getOperatorEqualsSignKeyword_1_1_0_0());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getRelationalExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_1, null);

                            }

                            }
                            break;
                        case 2 :
                            // InternalBehaviorAnnexParser.g:3047:7: lv_operator_2_2= ExclamationMarkEqualsSign
                            {
                            lv_operator_2_2=(Token)match(input,ExclamationMarkEqualsSign,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_2, grammarAccess.getRelationalExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getRelationalExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_2, null);

                            }

                            }
                            break;
                        case 3 :
                            // InternalBehaviorAnnexParser.g:3058:7: lv_operator_2_3= LessThanSign
                            {
                            lv_operator_2_3=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_3, grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_2());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getRelationalExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_3, null);

                            }

                            }
                            break;
                        case 4 :
                            // InternalBehaviorAnnexParser.g:3069:7: lv_operator_2_4= LessThanSignEqualsSign
                            {
                            lv_operator_2_4=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_4, grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_3());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getRelationalExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_4, null);

                            }

                            }
                            break;
                        case 5 :
                            // InternalBehaviorAnnexParser.g:3080:7: lv_operator_2_5= GreaterThanSign
                            {
                            lv_operator_2_5=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_5, grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_4());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getRelationalExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_5, null);

                            }

                            }
                            break;
                        case 6 :
                            // InternalBehaviorAnnexParser.g:3091:7: lv_operator_2_6= GreaterThanSignEqualsSign
                            {
                            lv_operator_2_6=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_6, grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_5());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getRelationalExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_6, null);

                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalBehaviorAnnexParser.g:3104:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
                    // InternalBehaviorAnnexParser.g:3105:5: (lv_right_3_0= ruleAdditiveExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3105:5: (lv_right_3_0= ruleAdditiveExpression )
                    // InternalBehaviorAnnexParser.g:3106:6: lv_right_3_0= ruleAdditiveExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
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
                                                  "org.osate.xtext.aadl2.ba.BehaviorAnnex.AdditiveExpression");
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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalBehaviorAnnexParser.g:3128:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3128:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalBehaviorAnnexParser.g:3129:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalBehaviorAnnexParser.g:3135:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3141:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalBehaviorAnnexParser.g:3142:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:3142:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalBehaviorAnnexParser.g:3143:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_62);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_MultiplicativeExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:3151:3: ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==PlusSign||LA59_0==HyphenMinus) ) {
                    alt59=1;
                }


                switch (alt59) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3152:4: () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3152:4: ()
                    // InternalBehaviorAnnexParser.g:3153:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getAdditiveExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3159:4: ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) )
                    // InternalBehaviorAnnexParser.g:3160:5: ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) )
                    {
                    // InternalBehaviorAnnexParser.g:3160:5: ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) )
                    // InternalBehaviorAnnexParser.g:3161:6: (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus )
                    {
                    // InternalBehaviorAnnexParser.g:3161:6: (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus )
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==PlusSign) ) {
                        alt58=1;
                    }
                    else if ( (LA58_0==HyphenMinus) ) {
                        alt58=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 58, 0, input);

                        throw nvae;
                    }
                    switch (alt58) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:3162:7: lv_operator_2_1= PlusSign
                            {
                            lv_operator_2_1=(Token)match(input,PlusSign,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_1, grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_1_0_0());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getAdditiveExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_1, null);

                            }

                            }
                            break;
                        case 2 :
                            // InternalBehaviorAnnexParser.g:3173:7: lv_operator_2_2= HyphenMinus
                            {
                            lv_operator_2_2=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_2, grammarAccess.getAdditiveExpressionAccess().getOperatorHyphenMinusKeyword_1_1_0_1());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getAdditiveExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_2, null);

                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalBehaviorAnnexParser.g:3186:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    // InternalBehaviorAnnexParser.g:3187:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3187:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    // InternalBehaviorAnnexParser.g:3188:6: lv_right_3_0= ruleMultiplicativeExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_62);
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
                                                  "org.osate.xtext.aadl2.ba.BehaviorAnnex.MultiplicativeExpression");
                                              afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

                default :
                    break loop59;
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


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalBehaviorAnnexParser.g:3210:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3210:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalBehaviorAnnexParser.g:3211:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalBehaviorAnnexParser.g:3217:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        EObject this_PowerExpression_0 = null;

        EObject lv_right_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3223:2: ( (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) )
            // InternalBehaviorAnnexParser.g:3224:2: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:3224:2: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            // InternalBehaviorAnnexParser.g:3225:3: this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getPowerExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_63);
            this_PowerExpression_0=rulePowerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_PowerExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:3233:3: ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==Mod||LA61_0==Rem||LA61_0==Asterisk||LA61_0==Solidus) ) {
                    alt61=1;
                }


                switch (alt61) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3234:4: () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3234:4: ()
                    // InternalBehaviorAnnexParser.g:3235:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getMultiplicativeExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3241:4: ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) )
                    // InternalBehaviorAnnexParser.g:3242:5: ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) )
                    {
                    // InternalBehaviorAnnexParser.g:3242:5: ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) )
                    // InternalBehaviorAnnexParser.g:3243:6: (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem )
                    {
                    // InternalBehaviorAnnexParser.g:3243:6: (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem )
                    int alt60=4;
                    switch ( input.LA(1) ) {
                    case Asterisk:
                        {
                        alt60=1;
                        }
                        break;
                    case Solidus:
                        {
                        alt60=2;
                        }
                        break;
                    case Mod:
                        {
                        alt60=3;
                        }
                        break;
                    case Rem:
                        {
                        alt60=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 60, 0, input);

                        throw nvae;
                    }

                    switch (alt60) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:3244:7: lv_operator_2_1= Asterisk
                            {
                            lv_operator_2_1=(Token)match(input,Asterisk,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_1, grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskKeyword_1_1_0_0());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_1, null);

                            }

                            }
                            break;
                        case 2 :
                            // InternalBehaviorAnnexParser.g:3255:7: lv_operator_2_2= Solidus
                            {
                            lv_operator_2_2=(Token)match(input,Solidus,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_2, grammarAccess.getMultiplicativeExpressionAccess().getOperatorSolidusKeyword_1_1_0_1());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_2, null);

                            }

                            }
                            break;
                        case 3 :
                            // InternalBehaviorAnnexParser.g:3266:7: lv_operator_2_3= Mod
                            {
                            lv_operator_2_3=(Token)match(input,Mod,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_3, grammarAccess.getMultiplicativeExpressionAccess().getOperatorModKeyword_1_1_0_2());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_3, null);

                            }

                            }
                            break;
                        case 4 :
                            // InternalBehaviorAnnexParser.g:3277:7: lv_operator_2_4= Rem
                            {
                            lv_operator_2_4=(Token)match(input,Rem,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_2_4, grammarAccess.getMultiplicativeExpressionAccess().getOperatorRemKeyword_1_1_0_3());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_2_4, null);

                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalBehaviorAnnexParser.g:3290:4: ( (lv_right_3_0= rulePowerExpression ) )
                    // InternalBehaviorAnnexParser.g:3291:5: (lv_right_3_0= rulePowerExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3291:5: (lv_right_3_0= rulePowerExpression )
                    // InternalBehaviorAnnexParser.g:3292:6: lv_right_3_0= rulePowerExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightPowerExpressionParserRuleCall_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_63);
                    lv_right_3_0=rulePowerExpression();

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
                                                  "org.osate.xtext.aadl2.ba.BehaviorAnnex.PowerExpression");
                                              afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }
                    break;

                default :
                    break loop61;
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


    // $ANTLR start "entryRulePowerExpression"
    // InternalBehaviorAnnexParser.g:3314:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3314:56: (iv_rulePowerExpression= rulePowerExpression EOF )
            // InternalBehaviorAnnexParser.g:3315:2: iv_rulePowerExpression= rulePowerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPowerExpressionRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePowerExpression=rulePowerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePowerExpression;
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
    // $ANTLR end "entryRulePowerExpression"


    // $ANTLR start "rulePowerExpression"
    // InternalBehaviorAnnexParser.g:3321:1: rulePowerExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )? ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_right_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3327:2: ( (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )? ) )
            // InternalBehaviorAnnexParser.g:3328:2: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:3328:2: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )? )
            // InternalBehaviorAnnexParser.g:3329:3: this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_64);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_UnaryExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:3337:3: ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==AsteriskAsterisk) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3338:4: () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3338:4: ()
                    // InternalBehaviorAnnexParser.g:3339:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getPowerExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3345:4: ( (lv_operator_2_0= AsteriskAsterisk ) )
                    // InternalBehaviorAnnexParser.g:3346:5: (lv_operator_2_0= AsteriskAsterisk )
                    {
                    // InternalBehaviorAnnexParser.g:3346:5: (lv_operator_2_0= AsteriskAsterisk )
                    // InternalBehaviorAnnexParser.g:3347:6: lv_operator_2_0= AsteriskAsterisk
                    {
                    lv_operator_2_0=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_operator_2_0, grammarAccess.getPowerExpressionAccess().getOperatorAsteriskAsteriskKeyword_1_1_0());

                    }
                    if ( state.backtracking==0 ) {

                                              if (current==null) {
                                                  current = createModelElement(grammarAccess.getPowerExpressionRule());
                                              }
                                              setWithLastConsumed(current, "operator", lv_operator_2_0, "**");

                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:3359:4: ( (lv_right_3_0= rulePowerExpression ) )
                    // InternalBehaviorAnnexParser.g:3360:5: (lv_right_3_0= rulePowerExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3360:5: (lv_right_3_0= rulePowerExpression )
                    // InternalBehaviorAnnexParser.g:3361:6: lv_right_3_0= rulePowerExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getPowerExpressionAccess().getRightPowerExpressionParserRuleCall_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_right_3_0=rulePowerExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                              if (current==null) {
                                                  current = createModelElementForParent(grammarAccess.getPowerExpressionRule());
                                              }
                                              set(
                                                  current,
                                                  "right",
                                                  lv_right_3_0,
                                                  "org.osate.xtext.aadl2.ba.BehaviorAnnex.PowerExpression");
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
    // $ANTLR end "rulePowerExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalBehaviorAnnexParser.g:3383:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3383:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalBehaviorAnnexParser.g:3384:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule());
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression;
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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalBehaviorAnnexParser.g:3390:1: ruleUnaryExpression returns [EObject current=null] : ( ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;
        Token lv_operator_1_4=null;
        EObject lv_operand_2_0 = null;

        EObject this_PrimaryExpression_3 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3396:2: ( ( ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression ) )
            // InternalBehaviorAnnexParser.g:3397:2: ( ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression )
            {
            // InternalBehaviorAnnexParser.g:3397:2: ( ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==Abs||LA64_0==Not||LA64_0==PlusSign||LA64_0==HyphenMinus) ) {
                alt64=1;
            }
            else if ( (LA64_0==False||LA64_0==True||LA64_0==NumberSign||LA64_0==LeftParenthesis||LA64_0==RULE_REAL_LIT||LA64_0==RULE_INTEGER_LIT||(LA64_0>=RULE_STRING && LA64_0<=RULE_ID)) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3398:3: ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:3398:3: ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) )
                    // InternalBehaviorAnnexParser.g:3399:4: () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3399:4: ()
                    // InternalBehaviorAnnexParser.g:3400:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElement(
                                              grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_0_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3406:4: ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) )
                    // InternalBehaviorAnnexParser.g:3407:5: ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) )
                    {
                    // InternalBehaviorAnnexParser.g:3407:5: ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) )
                    // InternalBehaviorAnnexParser.g:3408:6: (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not )
                    {
                    // InternalBehaviorAnnexParser.g:3408:6: (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not )
                    int alt63=4;
                    switch ( input.LA(1) ) {
                    case PlusSign:
                        {
                        alt63=1;
                        }
                        break;
                    case HyphenMinus:
                        {
                        alt63=2;
                        }
                        break;
                    case Abs:
                        {
                        alt63=3;
                        }
                        break;
                    case Not:
                        {
                        alt63=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 63, 0, input);

                        throw nvae;
                    }

                    switch (alt63) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:3409:7: lv_operator_1_1= PlusSign
                            {
                            lv_operator_1_1=(Token)match(input,PlusSign,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_1_1, grammarAccess.getUnaryExpressionAccess().getOperatorPlusSignKeyword_0_1_0_0());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getUnaryExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_1_1, null);

                            }

                            }
                            break;
                        case 2 :
                            // InternalBehaviorAnnexParser.g:3420:7: lv_operator_1_2= HyphenMinus
                            {
                            lv_operator_1_2=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_1_2, grammarAccess.getUnaryExpressionAccess().getOperatorHyphenMinusKeyword_0_1_0_1());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getUnaryExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_1_2, null);

                            }

                            }
                            break;
                        case 3 :
                            // InternalBehaviorAnnexParser.g:3431:7: lv_operator_1_3= Abs
                            {
                            lv_operator_1_3=(Token)match(input,Abs,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_1_3, grammarAccess.getUnaryExpressionAccess().getOperatorAbsKeyword_0_1_0_2());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getUnaryExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_1_3, null);

                            }

                            }
                            break;
                        case 4 :
                            // InternalBehaviorAnnexParser.g:3442:7: lv_operator_1_4= Not
                            {
                            lv_operator_1_4=(Token)match(input,Not,FollowSets000.FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(lv_operator_1_4, grammarAccess.getUnaryExpressionAccess().getOperatorNotKeyword_0_1_0_3());

                            }
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getUnaryExpressionRule());
                                                          }
                                                          setWithLastConsumed(current, "operator", lv_operator_1_4, null);

                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalBehaviorAnnexParser.g:3455:4: ( (lv_operand_2_0= ruleUnaryExpression ) )
                    // InternalBehaviorAnnexParser.g:3456:5: (lv_operand_2_0= ruleUnaryExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3456:5: (lv_operand_2_0= ruleUnaryExpression )
                    // InternalBehaviorAnnexParser.g:3457:6: lv_operand_2_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperandUnaryExpressionParserRuleCall_0_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_operand_2_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                              if (current==null) {
                                                  current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                                              }
                                              set(
                                                  current,
                                                  "operand",
                                                  lv_operand_2_0,
                                                  "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnaryExpression");
                                              afterParserOrEnumRuleCall();

                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:3476:3: this_PrimaryExpression_3= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PrimaryExpression_3=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                  current = this_PrimaryExpression_3;
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
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalBehaviorAnnexParser.g:3488:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3488:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalBehaviorAnnexParser.g:3489:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalBehaviorAnnexParser.g:3495:1: rulePrimaryExpression returns [EObject current=null] : (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_ValueConstant_0 = null;

        EObject this_ReferenceExpression_1 = null;

        EObject this_ValueExpression_3 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3501:2: ( (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis ) ) )
            // InternalBehaviorAnnexParser.g:3502:2: (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis ) )
            {
            // InternalBehaviorAnnexParser.g:3502:2: (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis ) )
            int alt65=3;
            switch ( input.LA(1) ) {
            case False:
            case True:
            case NumberSign:
            case RULE_REAL_LIT:
            case RULE_INTEGER_LIT:
            case RULE_STRING:
                {
                alt65=1;
                }
                break;
            case RULE_ID:
                {
                alt65=2;
                }
                break;
            case LeftParenthesis:
                {
                alt65=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3503:3: this_ValueConstant_0= ruleValueConstant
                    {
                    if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueConstantParserRuleCall_0());

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
                    // InternalBehaviorAnnexParser.g:3512:3: this_ReferenceExpression_1= ruleReferenceExpression
                    {
                    if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getReferenceExpressionParserRuleCall_1());

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
                    // InternalBehaviorAnnexParser.g:3521:3: (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis )
                    {
                    // InternalBehaviorAnnexParser.g:3521:3: (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis )
                    // InternalBehaviorAnnexParser.g:3522:4: otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis
                    {
                    otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_0());

                    }
                    if ( state.backtracking==0 ) {

                                      newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueExpressionParserRuleCall_2_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_47);
                    this_ValueExpression_3=ruleValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      current = this_ValueExpression_3;
                                      afterParserOrEnumRuleCall();

                    }
                    otherlv_4=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2());

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


    // $ANTLR start "entryRuleValueConstant"
    // InternalBehaviorAnnexParser.g:3543:1: entryRuleValueConstant returns [EObject current=null] : iv_ruleValueConstant= ruleValueConstant EOF ;
    public final EObject entryRuleValueConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueConstant = null;


        try {
            // InternalBehaviorAnnexParser.g:3543:54: (iv_ruleValueConstant= ruleValueConstant EOF )
            // InternalBehaviorAnnexParser.g:3544:2: iv_ruleValueConstant= ruleValueConstant EOF
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
    // InternalBehaviorAnnexParser.g:3550:1: ruleValueConstant returns [EObject current=null] : (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference ) ;
    public final EObject ruleValueConstant() throws RecognitionException {
        EObject current = null;

        EObject this_BehaviorIntegerLiteral_0 = null;

        EObject this_BehaviorRealLiteral_1 = null;

        EObject this_BehaviorStringLiteral_2 = null;

        EObject this_BehaviorBooleanLiteral_3 = null;

        EObject this_HashPropertyReference_4 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3556:2: ( (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference ) )
            // InternalBehaviorAnnexParser.g:3557:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference )
            {
            // InternalBehaviorAnnexParser.g:3557:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference )
            int alt66=5;
            switch ( input.LA(1) ) {
            case RULE_INTEGER_LIT:
                {
                alt66=1;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt66=2;
                }
                break;
            case RULE_STRING:
                {
                alt66=3;
                }
                break;
            case False:
            case True:
                {
                alt66=4;
                }
                break;
            case NumberSign:
                {
                alt66=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3558:3: this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral
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
                    // InternalBehaviorAnnexParser.g:3567:3: this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral
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
                    // InternalBehaviorAnnexParser.g:3576:3: this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral
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
                    // InternalBehaviorAnnexParser.g:3585:3: this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral
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
                    // InternalBehaviorAnnexParser.g:3594:3: this_HashPropertyReference_4= ruleHashPropertyReference
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
    // InternalBehaviorAnnexParser.g:3606:1: entryRuleBehaviorIntegerLiteral returns [EObject current=null] : iv_ruleBehaviorIntegerLiteral= ruleBehaviorIntegerLiteral EOF ;
    public final EObject entryRuleBehaviorIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorIntegerLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:3606:63: (iv_ruleBehaviorIntegerLiteral= ruleBehaviorIntegerLiteral EOF )
            // InternalBehaviorAnnexParser.g:3607:2: iv_ruleBehaviorIntegerLiteral= ruleBehaviorIntegerLiteral EOF
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
    // InternalBehaviorAnnexParser.g:3613:1: ruleBehaviorIntegerLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGER_LIT ) ) ;
    public final EObject ruleBehaviorIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3619:2: ( ( (lv_value_0_0= RULE_INTEGER_LIT ) ) )
            // InternalBehaviorAnnexParser.g:3620:2: ( (lv_value_0_0= RULE_INTEGER_LIT ) )
            {
            // InternalBehaviorAnnexParser.g:3620:2: ( (lv_value_0_0= RULE_INTEGER_LIT ) )
            // InternalBehaviorAnnexParser.g:3621:3: (lv_value_0_0= RULE_INTEGER_LIT )
            {
            // InternalBehaviorAnnexParser.g:3621:3: (lv_value_0_0= RULE_INTEGER_LIT )
            // InternalBehaviorAnnexParser.g:3622:4: lv_value_0_0= RULE_INTEGER_LIT
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
    // InternalBehaviorAnnexParser.g:3641:1: entryRuleBehaviorRealLiteral returns [EObject current=null] : iv_ruleBehaviorRealLiteral= ruleBehaviorRealLiteral EOF ;
    public final EObject entryRuleBehaviorRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorRealLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:3641:60: (iv_ruleBehaviorRealLiteral= ruleBehaviorRealLiteral EOF )
            // InternalBehaviorAnnexParser.g:3642:2: iv_ruleBehaviorRealLiteral= ruleBehaviorRealLiteral EOF
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
    // InternalBehaviorAnnexParser.g:3648:1: ruleBehaviorRealLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_REAL_LIT ) ) ;
    public final EObject ruleBehaviorRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3654:2: ( ( (lv_value_0_0= RULE_REAL_LIT ) ) )
            // InternalBehaviorAnnexParser.g:3655:2: ( (lv_value_0_0= RULE_REAL_LIT ) )
            {
            // InternalBehaviorAnnexParser.g:3655:2: ( (lv_value_0_0= RULE_REAL_LIT ) )
            // InternalBehaviorAnnexParser.g:3656:3: (lv_value_0_0= RULE_REAL_LIT )
            {
            // InternalBehaviorAnnexParser.g:3656:3: (lv_value_0_0= RULE_REAL_LIT )
            // InternalBehaviorAnnexParser.g:3657:4: lv_value_0_0= RULE_REAL_LIT
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
    // InternalBehaviorAnnexParser.g:3676:1: entryRuleBehaviorStringLiteral returns [EObject current=null] : iv_ruleBehaviorStringLiteral= ruleBehaviorStringLiteral EOF ;
    public final EObject entryRuleBehaviorStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorStringLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:3676:62: (iv_ruleBehaviorStringLiteral= ruleBehaviorStringLiteral EOF )
            // InternalBehaviorAnnexParser.g:3677:2: iv_ruleBehaviorStringLiteral= ruleBehaviorStringLiteral EOF
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
    // InternalBehaviorAnnexParser.g:3683:1: ruleBehaviorStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleBehaviorStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3689:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalBehaviorAnnexParser.g:3690:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalBehaviorAnnexParser.g:3690:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalBehaviorAnnexParser.g:3691:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalBehaviorAnnexParser.g:3691:3: (lv_value_0_0= RULE_STRING )
            // InternalBehaviorAnnexParser.g:3692:4: lv_value_0_0= RULE_STRING
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
    // InternalBehaviorAnnexParser.g:3711:1: entryRuleBehaviorBooleanLiteral returns [EObject current=null] : iv_ruleBehaviorBooleanLiteral= ruleBehaviorBooleanLiteral EOF ;
    public final EObject entryRuleBehaviorBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorBooleanLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:3711:63: (iv_ruleBehaviorBooleanLiteral= ruleBehaviorBooleanLiteral EOF )
            // InternalBehaviorAnnexParser.g:3712:2: iv_ruleBehaviorBooleanLiteral= ruleBehaviorBooleanLiteral EOF
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
    // InternalBehaviorAnnexParser.g:3718:1: ruleBehaviorBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBehaviorBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3724:2: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalBehaviorAnnexParser.g:3725:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalBehaviorAnnexParser.g:3725:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalBehaviorAnnexParser.g:3726:3: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalBehaviorAnnexParser.g:3726:3: ()
            // InternalBehaviorAnnexParser.g:3727:4:
            {
            if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getBehaviorBooleanLiteralAccess().getBehaviorBooleanLiteralAction_0(),
                                  current);

            }

            }

            // InternalBehaviorAnnexParser.g:3733:3: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==True) ) {
                alt67=1;
            }
            else if ( (LA67_0==False) ) {
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
                    // InternalBehaviorAnnexParser.g:3734:4: ( (lv_value_1_0= True ) )
                    {
                    // InternalBehaviorAnnexParser.g:3734:4: ( (lv_value_1_0= True ) )
                    // InternalBehaviorAnnexParser.g:3735:5: (lv_value_1_0= True )
                    {
                    // InternalBehaviorAnnexParser.g:3735:5: (lv_value_1_0= True )
                    // InternalBehaviorAnnexParser.g:3736:6: lv_value_1_0= True
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
                    // InternalBehaviorAnnexParser.g:3749:4: otherlv_2= False
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
    // InternalBehaviorAnnexParser.g:3758:1: entryRuleReferenceExpression returns [EObject current=null] : iv_ruleReferenceExpression= ruleReferenceExpression EOF ;
    public final EObject entryRuleReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3758:60: (iv_ruleReferenceExpression= ruleReferenceExpression EOF )
            // InternalBehaviorAnnexParser.g:3759:2: iv_ruleReferenceExpression= ruleReferenceExpression EOF
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
    // InternalBehaviorAnnexParser.g:3765:1: ruleReferenceExpression returns [EObject current=null] : ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )? ) ;
    public final EObject ruleReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token lv_dequeue_2_0=null;
        Token otherlv_3=null;
        Token lv_count_4_0=null;
        Token lv_fresh_5_0=null;
        EObject lv_reference_0_0 = null;

        EObject lv_property_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3771:2: ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )? ) )
            // InternalBehaviorAnnexParser.g:3772:2: ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:3772:2: ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )? )
            // InternalBehaviorAnnexParser.g:3773:3: ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )?
            {
            // InternalBehaviorAnnexParser.g:3773:3: ( (lv_reference_0_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:3774:4: (lv_reference_0_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:3774:4: (lv_reference_0_0= ruleReference )
            // InternalBehaviorAnnexParser.g:3775:5: lv_reference_0_0= ruleReference
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getReferenceExpressionAccess().getReferenceReferenceParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_65);
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

            // InternalBehaviorAnnexParser.g:3792:3: ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )?
            int alt69=4;
            switch ( input.LA(1) ) {
                case NumberSign:
                    {
                    alt69=1;
                    }
                    break;
                case QuestionMark:
                    {
                    alt69=2;
                    }
                    break;
                case Apostrophe:
                    {
                    alt69=3;
                    }
                    break;
            }

            switch (alt69) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3793:4: ( (lv_property_1_0= rulePropertyReferenceTail ) )
                    {
                    // InternalBehaviorAnnexParser.g:3793:4: ( (lv_property_1_0= rulePropertyReferenceTail ) )
                    // InternalBehaviorAnnexParser.g:3794:5: (lv_property_1_0= rulePropertyReferenceTail )
                    {
                    // InternalBehaviorAnnexParser.g:3794:5: (lv_property_1_0= rulePropertyReferenceTail )
                    // InternalBehaviorAnnexParser.g:3795:6: lv_property_1_0= rulePropertyReferenceTail
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
                    // InternalBehaviorAnnexParser.g:3813:4: ( (lv_dequeue_2_0= QuestionMark ) )
                    {
                    // InternalBehaviorAnnexParser.g:3813:4: ( (lv_dequeue_2_0= QuestionMark ) )
                    // InternalBehaviorAnnexParser.g:3814:5: (lv_dequeue_2_0= QuestionMark )
                    {
                    // InternalBehaviorAnnexParser.g:3814:5: (lv_dequeue_2_0= QuestionMark )
                    // InternalBehaviorAnnexParser.g:3815:6: lv_dequeue_2_0= QuestionMark
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
                    // InternalBehaviorAnnexParser.g:3828:4: (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:3828:4: (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) )
                    // InternalBehaviorAnnexParser.g:3829:5: otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) )
                    {
                    otherlv_3=(Token)match(input,Apostrophe,FollowSets000.FOLLOW_66); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          newLeafNode(otherlv_3, grammarAccess.getReferenceExpressionAccess().getApostropheKeyword_1_2_0());

                    }
                    // InternalBehaviorAnnexParser.g:3833:5: ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) )
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==Count) ) {
                        alt68=1;
                    }
                    else if ( (LA68_0==Fresh) ) {
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
                            // InternalBehaviorAnnexParser.g:3834:6: ( (lv_count_4_0= Count ) )
                            {
                            // InternalBehaviorAnnexParser.g:3834:6: ( (lv_count_4_0= Count ) )
                            // InternalBehaviorAnnexParser.g:3835:7: (lv_count_4_0= Count )
                            {
                            // InternalBehaviorAnnexParser.g:3835:7: (lv_count_4_0= Count )
                            // InternalBehaviorAnnexParser.g:3836:8: lv_count_4_0= Count
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
                            // InternalBehaviorAnnexParser.g:3849:6: ( (lv_fresh_5_0= Fresh ) )
                            {
                            // InternalBehaviorAnnexParser.g:3849:6: ( (lv_fresh_5_0= Fresh ) )
                            // InternalBehaviorAnnexParser.g:3850:7: (lv_fresh_5_0= Fresh )
                            {
                            // InternalBehaviorAnnexParser.g:3850:7: (lv_fresh_5_0= Fresh )
                            // InternalBehaviorAnnexParser.g:3851:8: lv_fresh_5_0= Fresh
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
    // InternalBehaviorAnnexParser.g:3870:1: entryRuleHashPropertyReference returns [EObject current=null] : iv_ruleHashPropertyReference= ruleHashPropertyReference EOF ;
    public final EObject entryRuleHashPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHashPropertyReference = null;


        try {
            // InternalBehaviorAnnexParser.g:3870:62: (iv_ruleHashPropertyReference= ruleHashPropertyReference EOF )
            // InternalBehaviorAnnexParser.g:3871:2: iv_ruleHashPropertyReference= ruleHashPropertyReference EOF
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
    // InternalBehaviorAnnexParser.g:3877:1: ruleHashPropertyReference returns [EObject current=null] : (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) ;
    public final EObject ruleHashPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_property_1_0 = null;

        EObject lv_indexes_2_0 = null;

        EObject lv_fields_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3883:2: ( (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) )
            // InternalBehaviorAnnexParser.g:3884:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            {
            // InternalBehaviorAnnexParser.g:3884:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            // InternalBehaviorAnnexParser.g:3885:3: otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            {
            otherlv_0=(Token)match(input,NumberSign,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getHashPropertyReferenceAccess().getNumberSignKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:3889:3: ( (lv_property_1_0= ruleQualifiedName ) )
            // InternalBehaviorAnnexParser.g:3890:4: (lv_property_1_0= ruleQualifiedName )
            {
            // InternalBehaviorAnnexParser.g:3890:4: (lv_property_1_0= ruleQualifiedName )
            // InternalBehaviorAnnexParser.g:3891:5: lv_property_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getPropertyQualifiedNameParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_67);
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

            // InternalBehaviorAnnexParser.g:3908:3: ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==LeftSquareBracket) ) {
                    alt70=1;
                }


                switch (alt70) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3909:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    {
                    // InternalBehaviorAnnexParser.g:3909:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    // InternalBehaviorAnnexParser.g:3910:5: lv_indexes_2_0= rulePropertyArrayIndex
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getIndexesPropertyArrayIndexParserRuleCall_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_67);
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
                    break loop70;
                }
            } while (true);

            // InternalBehaviorAnnexParser.g:3927:3: ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==FullStop) ) {
                    alt71=1;
                }


                switch (alt71) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3928:4: (lv_fields_3_0= ruleNamedPropertyField )
                    {
                    // InternalBehaviorAnnexParser.g:3928:4: (lv_fields_3_0= ruleNamedPropertyField )
                    // InternalBehaviorAnnexParser.g:3929:5: lv_fields_3_0= ruleNamedPropertyField
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getFieldsNamedPropertyFieldParserRuleCall_3_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_68);
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
                    break loop71;
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
    // InternalBehaviorAnnexParser.g:3950:1: entryRulePropertyReferenceTail returns [EObject current=null] : iv_rulePropertyReferenceTail= rulePropertyReferenceTail EOF ;
    public final EObject entryRulePropertyReferenceTail() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyReferenceTail = null;


        try {
            // InternalBehaviorAnnexParser.g:3950:62: (iv_rulePropertyReferenceTail= rulePropertyReferenceTail EOF )
            // InternalBehaviorAnnexParser.g:3951:2: iv_rulePropertyReferenceTail= rulePropertyReferenceTail EOF
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
    // InternalBehaviorAnnexParser.g:3957:1: rulePropertyReferenceTail returns [EObject current=null] : (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) ;
    public final EObject rulePropertyReferenceTail() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_property_1_0 = null;

        EObject lv_indexes_2_0 = null;

        EObject lv_fields_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3963:2: ( (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) )
            // InternalBehaviorAnnexParser.g:3964:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            {
            // InternalBehaviorAnnexParser.g:3964:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            // InternalBehaviorAnnexParser.g:3965:3: otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            {
            otherlv_0=(Token)match(input,NumberSign,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getPropertyReferenceTailAccess().getNumberSignKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:3969:3: ( (lv_property_1_0= ruleQualifiedName ) )
            // InternalBehaviorAnnexParser.g:3970:4: (lv_property_1_0= ruleQualifiedName )
            {
            // InternalBehaviorAnnexParser.g:3970:4: (lv_property_1_0= ruleQualifiedName )
            // InternalBehaviorAnnexParser.g:3971:5: lv_property_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getPropertyQualifiedNameParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_67);
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

            // InternalBehaviorAnnexParser.g:3988:3: ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==LeftSquareBracket) ) {
                    alt72=1;
                }


                switch (alt72) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3989:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    {
                    // InternalBehaviorAnnexParser.g:3989:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    // InternalBehaviorAnnexParser.g:3990:5: lv_indexes_2_0= rulePropertyArrayIndex
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getIndexesPropertyArrayIndexParserRuleCall_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_67);
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
                    break loop72;
                }
            } while (true);

            // InternalBehaviorAnnexParser.g:4007:3: ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==FullStop) ) {
                    alt73=1;
                }


                switch (alt73) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4008:4: (lv_fields_3_0= ruleNamedPropertyField )
                    {
                    // InternalBehaviorAnnexParser.g:4008:4: (lv_fields_3_0= ruleNamedPropertyField )
                    // InternalBehaviorAnnexParser.g:4009:5: lv_fields_3_0= ruleNamedPropertyField
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getFieldsNamedPropertyFieldParserRuleCall_3_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_68);
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
                    break loop73;
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
    // InternalBehaviorAnnexParser.g:4030:1: entryRuleNamedPropertyField returns [EObject current=null] : iv_ruleNamedPropertyField= ruleNamedPropertyField EOF ;
    public final EObject entryRuleNamedPropertyField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedPropertyField = null;


        try {
            // InternalBehaviorAnnexParser.g:4030:59: (iv_ruleNamedPropertyField= ruleNamedPropertyField EOF )
            // InternalBehaviorAnnexParser.g:4031:2: iv_ruleNamedPropertyField= ruleNamedPropertyField EOF
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
    // InternalBehaviorAnnexParser.g:4037:1: ruleNamedPropertyField returns [EObject current=null] : (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ) ;
    public final EObject ruleNamedPropertyField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_indexes_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4043:2: ( (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ) )
            // InternalBehaviorAnnexParser.g:4044:2: (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* )
            {
            // InternalBehaviorAnnexParser.g:4044:2: (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* )
            // InternalBehaviorAnnexParser.g:4045:3: otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            {
            otherlv_0=(Token)match(input,FullStop,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getNamedPropertyFieldAccess().getFullStopKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:4049:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:4050:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:4050:4: (lv_name_1_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:4051:5: lv_name_1_0= RULE_ID
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

            // InternalBehaviorAnnexParser.g:4067:3: ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==LeftSquareBracket) ) {
                    alt74=1;
                }


                switch (alt74) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4068:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    {
                    // InternalBehaviorAnnexParser.g:4068:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    // InternalBehaviorAnnexParser.g:4069:5: lv_indexes_2_0= rulePropertyArrayIndex
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
                    break loop74;
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
    // InternalBehaviorAnnexParser.g:4090:1: entryRulePropertyArrayIndex returns [EObject current=null] : iv_rulePropertyArrayIndex= rulePropertyArrayIndex EOF ;
    public final EObject entryRulePropertyArrayIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyArrayIndex = null;


        try {
            // InternalBehaviorAnnexParser.g:4090:59: (iv_rulePropertyArrayIndex= rulePropertyArrayIndex EOF )
            // InternalBehaviorAnnexParser.g:4091:2: iv_rulePropertyArrayIndex= rulePropertyArrayIndex EOF
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
    // InternalBehaviorAnnexParser.g:4097:1: rulePropertyArrayIndex returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket ) ;
    public final EObject rulePropertyArrayIndex() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4103:2: ( (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:4104:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:4104:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:4105:3: otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getPropertyArrayIndexAccess().getLeftSquareBracketKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:4109:3: ( (lv_value_1_0= rulePropertyIndexValue ) )
            // InternalBehaviorAnnexParser.g:4110:4: (lv_value_1_0= rulePropertyIndexValue )
            {
            // InternalBehaviorAnnexParser.g:4110:4: (lv_value_1_0= rulePropertyIndexValue )
            // InternalBehaviorAnnexParser.g:4111:5: lv_value_1_0= rulePropertyIndexValue
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
    // InternalBehaviorAnnexParser.g:4136:1: entryRulePropertyIndexValue returns [EObject current=null] : iv_rulePropertyIndexValue= rulePropertyIndexValue EOF ;
    public final EObject entryRulePropertyIndexValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyIndexValue = null;


        try {
            // InternalBehaviorAnnexParser.g:4136:59: (iv_rulePropertyIndexValue= rulePropertyIndexValue EOF )
            // InternalBehaviorAnnexParser.g:4137:2: iv_rulePropertyIndexValue= rulePropertyIndexValue EOF
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
    // InternalBehaviorAnnexParser.g:4143:1: rulePropertyIndexValue returns [EObject current=null] : (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression ) ;
    public final EObject rulePropertyIndexValue() throws RecognitionException {
        EObject current = null;

        EObject this_BehaviorIntegerLiteral_0 = null;

        EObject this_PropertyIndexPropertyReference_1 = null;

        EObject this_UnindexedReferenceExpression_2 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4149:2: ( (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression ) )
            // InternalBehaviorAnnexParser.g:4150:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression )
            {
            // InternalBehaviorAnnexParser.g:4150:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression )
            int alt75=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGER_LIT:
                {
                alt75=1;
                }
                break;
            case NumberSign:
                {
                alt75=2;
                }
                break;
            case RULE_ID:
                {
                alt75=3;
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
                    // InternalBehaviorAnnexParser.g:4151:3: this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral
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
                    // InternalBehaviorAnnexParser.g:4160:3: this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference
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
                    // InternalBehaviorAnnexParser.g:4169:3: this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression
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
    // InternalBehaviorAnnexParser.g:4181:1: entryRulePropertyIndexPropertyReference returns [EObject current=null] : iv_rulePropertyIndexPropertyReference= rulePropertyIndexPropertyReference EOF ;
    public final EObject entryRulePropertyIndexPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyIndexPropertyReference = null;


        try {
            // InternalBehaviorAnnexParser.g:4181:71: (iv_rulePropertyIndexPropertyReference= rulePropertyIndexPropertyReference EOF )
            // InternalBehaviorAnnexParser.g:4182:2: iv_rulePropertyIndexPropertyReference= rulePropertyIndexPropertyReference EOF
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
    // InternalBehaviorAnnexParser.g:4188:1: rulePropertyIndexPropertyReference returns [EObject current=null] : (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ) ;
    public final EObject rulePropertyIndexPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_property_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4194:2: ( (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ) )
            // InternalBehaviorAnnexParser.g:4195:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) )
            {
            // InternalBehaviorAnnexParser.g:4195:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) )
            // InternalBehaviorAnnexParser.g:4196:3: otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,NumberSign,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getPropertyIndexPropertyReferenceAccess().getNumberSignKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:4200:3: ( (lv_property_1_0= ruleQualifiedName ) )
            // InternalBehaviorAnnexParser.g:4201:4: (lv_property_1_0= ruleQualifiedName )
            {
            // InternalBehaviorAnnexParser.g:4201:4: (lv_property_1_0= ruleQualifiedName )
            // InternalBehaviorAnnexParser.g:4202:5: lv_property_1_0= ruleQualifiedName
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
    // InternalBehaviorAnnexParser.g:4223:1: entryRuleUnindexedReferenceExpression returns [EObject current=null] : iv_ruleUnindexedReferenceExpression= ruleUnindexedReferenceExpression EOF ;
    public final EObject entryRuleUnindexedReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReferenceExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:4223:69: (iv_ruleUnindexedReferenceExpression= ruleUnindexedReferenceExpression EOF )
            // InternalBehaviorAnnexParser.g:4224:2: iv_ruleUnindexedReferenceExpression= ruleUnindexedReferenceExpression EOF
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
    // InternalBehaviorAnnexParser.g:4230:1: ruleUnindexedReferenceExpression returns [EObject current=null] : ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )? ) ;
    public final EObject ruleUnindexedReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token lv_dequeue_1_0=null;
        Token otherlv_2=null;
        Token lv_count_3_0=null;
        Token lv_fresh_4_0=null;
        EObject lv_reference_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4236:2: ( ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )? ) )
            // InternalBehaviorAnnexParser.g:4237:2: ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:4237:2: ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )? )
            // InternalBehaviorAnnexParser.g:4238:3: ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )?
            {
            // InternalBehaviorAnnexParser.g:4238:3: ( (lv_reference_0_0= ruleUnindexedReference ) )
            // InternalBehaviorAnnexParser.g:4239:4: (lv_reference_0_0= ruleUnindexedReference )
            {
            // InternalBehaviorAnnexParser.g:4239:4: (lv_reference_0_0= ruleUnindexedReference )
            // InternalBehaviorAnnexParser.g:4240:5: lv_reference_0_0= ruleUnindexedReference
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getUnindexedReferenceExpressionAccess().getReferenceUnindexedReferenceParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_70);
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

            // InternalBehaviorAnnexParser.g:4257:3: ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )?
            int alt77=3;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==QuestionMark) ) {
                alt77=1;
            }
            else if ( (LA77_0==Apostrophe) ) {
                alt77=2;
            }
            switch (alt77) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4258:4: ( (lv_dequeue_1_0= QuestionMark ) )
                    {
                    // InternalBehaviorAnnexParser.g:4258:4: ( (lv_dequeue_1_0= QuestionMark ) )
                    // InternalBehaviorAnnexParser.g:4259:5: (lv_dequeue_1_0= QuestionMark )
                    {
                    // InternalBehaviorAnnexParser.g:4259:5: (lv_dequeue_1_0= QuestionMark )
                    // InternalBehaviorAnnexParser.g:4260:6: lv_dequeue_1_0= QuestionMark
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
                    // InternalBehaviorAnnexParser.g:4273:4: (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:4273:4: (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) )
                    // InternalBehaviorAnnexParser.g:4274:5: otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) )
                    {
                    otherlv_2=(Token)match(input,Apostrophe,FollowSets000.FOLLOW_66); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          newLeafNode(otherlv_2, grammarAccess.getUnindexedReferenceExpressionAccess().getApostropheKeyword_1_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:4278:5: ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) )
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==Count) ) {
                        alt76=1;
                    }
                    else if ( (LA76_0==Fresh) ) {
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
                            // InternalBehaviorAnnexParser.g:4279:6: ( (lv_count_3_0= Count ) )
                            {
                            // InternalBehaviorAnnexParser.g:4279:6: ( (lv_count_3_0= Count ) )
                            // InternalBehaviorAnnexParser.g:4280:7: (lv_count_3_0= Count )
                            {
                            // InternalBehaviorAnnexParser.g:4280:7: (lv_count_3_0= Count )
                            // InternalBehaviorAnnexParser.g:4281:8: lv_count_3_0= Count
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
                            // InternalBehaviorAnnexParser.g:4294:6: ( (lv_fresh_4_0= Fresh ) )
                            {
                            // InternalBehaviorAnnexParser.g:4294:6: ( (lv_fresh_4_0= Fresh ) )
                            // InternalBehaviorAnnexParser.g:4295:7: (lv_fresh_4_0= Fresh )
                            {
                            // InternalBehaviorAnnexParser.g:4295:7: (lv_fresh_4_0= Fresh )
                            // InternalBehaviorAnnexParser.g:4296:8: lv_fresh_4_0= Fresh
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
    // InternalBehaviorAnnexParser.g:4315:1: entryRuleUnindexedReference returns [EObject current=null] : iv_ruleUnindexedReference= ruleUnindexedReference EOF ;
    public final EObject entryRuleUnindexedReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReference = null;


        try {
            // InternalBehaviorAnnexParser.g:4315:59: (iv_ruleUnindexedReference= ruleUnindexedReference EOF )
            // InternalBehaviorAnnexParser.g:4316:2: iv_ruleUnindexedReference= ruleUnindexedReference EOF
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
    // InternalBehaviorAnnexParser.g:4322:1: ruleUnindexedReference returns [EObject current=null] : ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* ) ;
    public final EObject ruleUnindexedReference() throws RecognitionException {
        EObject current = null;

        EObject lv_segments_0_0 = null;

        EObject lv_tails_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4328:2: ( ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* ) )
            // InternalBehaviorAnnexParser.g:4329:2: ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* )
            {
            // InternalBehaviorAnnexParser.g:4329:2: ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* )
            // InternalBehaviorAnnexParser.g:4330:3: ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )*
            {
            // InternalBehaviorAnnexParser.g:4330:3: ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:4331:4: (lv_segments_0_0= ruleUnindexedReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:4331:4: (lv_segments_0_0= ruleUnindexedReferenceSegment )
            // InternalBehaviorAnnexParser.g:4332:5: lv_segments_0_0= ruleUnindexedReferenceSegment
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getUnindexedReferenceAccess().getSegmentsUnindexedReferenceSegmentParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_71);
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

            // InternalBehaviorAnnexParser.g:4349:3: ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==ColonColon||LA78_0==FullStop) ) {
                    alt78=1;
                }


                switch (alt78) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4350:4: (lv_tails_1_0= ruleUnindexedReferenceTail )
                    {
                    // InternalBehaviorAnnexParser.g:4350:4: (lv_tails_1_0= ruleUnindexedReferenceTail )
                    // InternalBehaviorAnnexParser.g:4351:5: lv_tails_1_0= ruleUnindexedReferenceTail
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getUnindexedReferenceAccess().getTailsUnindexedReferenceTailParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_71);
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
                    break loop78;
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
    // InternalBehaviorAnnexParser.g:4372:1: entryRuleUnindexedReferenceTail returns [EObject current=null] : iv_ruleUnindexedReferenceTail= ruleUnindexedReferenceTail EOF ;
    public final EObject entryRuleUnindexedReferenceTail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReferenceTail = null;


        try {
            // InternalBehaviorAnnexParser.g:4372:63: (iv_ruleUnindexedReferenceTail= ruleUnindexedReferenceTail EOF )
            // InternalBehaviorAnnexParser.g:4373:2: iv_ruleUnindexedReferenceTail= ruleUnindexedReferenceTail EOF
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
    // InternalBehaviorAnnexParser.g:4379:1: ruleUnindexedReferenceTail returns [EObject current=null] : ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) ) ;
    public final EObject ruleUnindexedReferenceTail() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_separator_0_0 = null;

        EObject lv_segment_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4385:2: ( ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) ) )
            // InternalBehaviorAnnexParser.g:4386:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) )
            {
            // InternalBehaviorAnnexParser.g:4386:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) )
            // InternalBehaviorAnnexParser.g:4387:3: ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) )
            {
            // InternalBehaviorAnnexParser.g:4387:3: ( (lv_separator_0_0= ruleReferenceSeparator ) )
            // InternalBehaviorAnnexParser.g:4388:4: (lv_separator_0_0= ruleReferenceSeparator )
            {
            // InternalBehaviorAnnexParser.g:4388:4: (lv_separator_0_0= ruleReferenceSeparator )
            // InternalBehaviorAnnexParser.g:4389:5: lv_separator_0_0= ruleReferenceSeparator
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getUnindexedReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_69);
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

            // InternalBehaviorAnnexParser.g:4406:3: ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:4407:4: (lv_segment_1_0= ruleUnindexedReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:4407:4: (lv_segment_1_0= ruleUnindexedReferenceSegment )
            // InternalBehaviorAnnexParser.g:4408:5: lv_segment_1_0= ruleUnindexedReferenceSegment
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
    // InternalBehaviorAnnexParser.g:4429:1: entryRuleUnindexedReferenceSegment returns [EObject current=null] : iv_ruleUnindexedReferenceSegment= ruleUnindexedReferenceSegment EOF ;
    public final EObject entryRuleUnindexedReferenceSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReferenceSegment = null;


        try {
            // InternalBehaviorAnnexParser.g:4429:66: (iv_ruleUnindexedReferenceSegment= ruleUnindexedReferenceSegment EOF )
            // InternalBehaviorAnnexParser.g:4430:2: iv_ruleUnindexedReferenceSegment= ruleUnindexedReferenceSegment EOF
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
    // InternalBehaviorAnnexParser.g:4436:1: ruleUnindexedReferenceSegment returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleUnindexedReferenceSegment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4442:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalBehaviorAnnexParser.g:4443:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalBehaviorAnnexParser.g:4443:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:4444:3: (lv_name_0_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:4444:3: (lv_name_0_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:4445:4: lv_name_0_0= RULE_ID
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
    // InternalBehaviorAnnexParser.g:4464:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalBehaviorAnnexParser.g:4464:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalBehaviorAnnexParser.g:4465:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalBehaviorAnnexParser.g:4471:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4477:2: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* ) )
            // InternalBehaviorAnnexParser.g:4478:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* )
            {
            // InternalBehaviorAnnexParser.g:4478:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* )
            // InternalBehaviorAnnexParser.g:4479:3: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_72); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current.merge(this_ID_0);

            }
            if ( state.backtracking==0 ) {

                          newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());

            }
            // InternalBehaviorAnnexParser.g:4486:3: (kw= ColonColon this_ID_2= RULE_ID )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==ColonColon) ) {
                    alt79=1;
                }


                switch (alt79) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4487:4: kw= ColonColon this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0());

                    }
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      current.merge(this_ID_2);

                    }
                    if ( state.backtracking==0 ) {

                                      newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());

                    }

                    }
                    break;

                default :
                    break loop79;
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
    // InternalBehaviorAnnexParser.g:4504:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalBehaviorAnnexParser.g:4504:50: (iv_ruleReference= ruleReference EOF )
            // InternalBehaviorAnnexParser.g:4505:2: iv_ruleReference= ruleReference EOF
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
    // InternalBehaviorAnnexParser.g:4511:1: ruleReference returns [EObject current=null] : ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        EObject lv_segments_0_0 = null;

        EObject lv_tails_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4517:2: ( ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* ) )
            // InternalBehaviorAnnexParser.g:4518:2: ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* )
            {
            // InternalBehaviorAnnexParser.g:4518:2: ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* )
            // InternalBehaviorAnnexParser.g:4519:3: ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )*
            {
            // InternalBehaviorAnnexParser.g:4519:3: ( (lv_segments_0_0= ruleReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:4520:4: (lv_segments_0_0= ruleReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:4520:4: (lv_segments_0_0= ruleReferenceSegment )
            // InternalBehaviorAnnexParser.g:4521:5: lv_segments_0_0= ruleReferenceSegment
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getReferenceAccess().getSegmentsReferenceSegmentParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_71);
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

            // InternalBehaviorAnnexParser.g:4538:3: ( (lv_tails_1_0= ruleReferenceTail ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==ColonColon||LA80_0==FullStop) ) {
                    alt80=1;
                }


                switch (alt80) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4539:4: (lv_tails_1_0= ruleReferenceTail )
                    {
                    // InternalBehaviorAnnexParser.g:4539:4: (lv_tails_1_0= ruleReferenceTail )
                    // InternalBehaviorAnnexParser.g:4540:5: lv_tails_1_0= ruleReferenceTail
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getReferenceAccess().getTailsReferenceTailParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_71);
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
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleReferenceTail"
    // InternalBehaviorAnnexParser.g:4561:1: entryRuleReferenceTail returns [EObject current=null] : iv_ruleReferenceTail= ruleReferenceTail EOF ;
    public final EObject entryRuleReferenceTail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTail = null;


        try {
            // InternalBehaviorAnnexParser.g:4561:54: (iv_ruleReferenceTail= ruleReferenceTail EOF )
            // InternalBehaviorAnnexParser.g:4562:2: iv_ruleReferenceTail= ruleReferenceTail EOF
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
    // InternalBehaviorAnnexParser.g:4568:1: ruleReferenceTail returns [EObject current=null] : ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) ) ;
    public final EObject ruleReferenceTail() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_separator_0_0 = null;

        EObject lv_segment_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4574:2: ( ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) ) )
            // InternalBehaviorAnnexParser.g:4575:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) )
            {
            // InternalBehaviorAnnexParser.g:4575:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) )
            // InternalBehaviorAnnexParser.g:4576:3: ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) )
            {
            // InternalBehaviorAnnexParser.g:4576:3: ( (lv_separator_0_0= ruleReferenceSeparator ) )
            // InternalBehaviorAnnexParser.g:4577:4: (lv_separator_0_0= ruleReferenceSeparator )
            {
            // InternalBehaviorAnnexParser.g:4577:4: (lv_separator_0_0= ruleReferenceSeparator )
            // InternalBehaviorAnnexParser.g:4578:5: lv_separator_0_0= ruleReferenceSeparator
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

            // InternalBehaviorAnnexParser.g:4595:3: ( (lv_segment_1_0= ruleReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:4596:4: (lv_segment_1_0= ruleReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:4596:4: (lv_segment_1_0= ruleReferenceSegment )
            // InternalBehaviorAnnexParser.g:4597:5: lv_segment_1_0= ruleReferenceSegment
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
    // InternalBehaviorAnnexParser.g:4618:1: entryRuleReferenceSeparator returns [String current=null] : iv_ruleReferenceSeparator= ruleReferenceSeparator EOF ;
    public final String entryRuleReferenceSeparator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReferenceSeparator = null;


        try {
            // InternalBehaviorAnnexParser.g:4618:58: (iv_ruleReferenceSeparator= ruleReferenceSeparator EOF )
            // InternalBehaviorAnnexParser.g:4619:2: iv_ruleReferenceSeparator= ruleReferenceSeparator EOF
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
    // InternalBehaviorAnnexParser.g:4625:1: ruleReferenceSeparator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= ColonColon | kw= FullStop ) ;
    public final AntlrDatatypeRuleToken ruleReferenceSeparator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4631:2: ( (kw= ColonColon | kw= FullStop ) )
            // InternalBehaviorAnnexParser.g:4632:2: (kw= ColonColon | kw= FullStop )
            {
            // InternalBehaviorAnnexParser.g:4632:2: (kw= ColonColon | kw= FullStop )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==ColonColon) ) {
                alt81=1;
            }
            else if ( (LA81_0==FullStop) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4633:3: kw= ColonColon
                    {
                    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                  current.merge(kw);
                                  newLeafNode(kw, grammarAccess.getReferenceSeparatorAccess().getColonColonKeyword_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:4639:3: kw= FullStop
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
    // InternalBehaviorAnnexParser.g:4648:1: entryRuleReferenceSegment returns [EObject current=null] : iv_ruleReferenceSegment= ruleReferenceSegment EOF ;
    public final EObject entryRuleReferenceSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSegment = null;


        try {
            // InternalBehaviorAnnexParser.g:4648:57: (iv_ruleReferenceSegment= ruleReferenceSegment EOF )
            // InternalBehaviorAnnexParser.g:4649:2: iv_ruleReferenceSegment= ruleReferenceSegment EOF
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
    // InternalBehaviorAnnexParser.g:4655:1: ruleReferenceSegment returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* ) ;
    public final EObject ruleReferenceSegment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_indexes_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4661:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* ) )
            // InternalBehaviorAnnexParser.g:4662:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* )
            {
            // InternalBehaviorAnnexParser.g:4662:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* )
            // InternalBehaviorAnnexParser.g:4663:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )*
            {
            // InternalBehaviorAnnexParser.g:4663:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:4664:4: (lv_name_0_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:4664:4: (lv_name_0_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:4665:5: lv_name_0_0= RULE_ID
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

            // InternalBehaviorAnnexParser.g:4681:3: ( (lv_indexes_1_0= ruleArrayIndex ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==LeftSquareBracket) ) {
                    alt82=1;
                }


                switch (alt82) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4682:4: (lv_indexes_1_0= ruleArrayIndex )
                    {
                    // InternalBehaviorAnnexParser.g:4682:4: (lv_indexes_1_0= ruleArrayIndex )
                    // InternalBehaviorAnnexParser.g:4683:5: lv_indexes_1_0= ruleArrayIndex
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
    // $ANTLR end "ruleReferenceSegment"


    // $ANTLR start "entryRuleArrayIndex"
    // InternalBehaviorAnnexParser.g:4704:1: entryRuleArrayIndex returns [EObject current=null] : iv_ruleArrayIndex= ruleArrayIndex EOF ;
    public final EObject entryRuleArrayIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayIndex = null;


        try {
            // InternalBehaviorAnnexParser.g:4704:51: (iv_ruleArrayIndex= ruleArrayIndex EOF )
            // InternalBehaviorAnnexParser.g:4705:2: iv_ruleArrayIndex= ruleArrayIndex EOF
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
    // InternalBehaviorAnnexParser.g:4711:1: ruleArrayIndex returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket ) ;
    public final EObject ruleArrayIndex() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4717:2: ( (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:4718:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:4718:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:4719:3: otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getArrayIndexAccess().getLeftSquareBracketKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:4723:3: ( (lv_value_1_0= ruleIntegerValue ) )
            // InternalBehaviorAnnexParser.g:4724:4: (lv_value_1_0= ruleIntegerValue )
            {
            // InternalBehaviorAnnexParser.g:4724:4: (lv_value_1_0= ruleIntegerValue )
            // InternalBehaviorAnnexParser.g:4725:5: lv_value_1_0= ruleIntegerValue
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
    // InternalBehaviorAnnexParser.g:4750:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalBehaviorAnnexParser.g:4750:69: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalBehaviorAnnexParser.g:4751:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
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
    // InternalBehaviorAnnexParser.g:4757:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon ) ;
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
            // InternalBehaviorAnnexParser.g:4763:2: ( ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon ) )
            // InternalBehaviorAnnexParser.g:4764:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon )
            {
            // InternalBehaviorAnnexParser.g:4764:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon )
            // InternalBehaviorAnnexParser.g:4765:3: ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon
            {
            // InternalBehaviorAnnexParser.g:4765:3: ( ( ruleQPREF ) )
            // InternalBehaviorAnnexParser.g:4766:4: ( ruleQPREF )
            {
            // InternalBehaviorAnnexParser.g:4766:4: ( ruleQPREF )
            // InternalBehaviorAnnexParser.g:4767:5: ruleQPREF
            {
            if ( state.backtracking==0 ) {

                                  if (current==null) {
                                      current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                                  }

            }
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_73);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                                  afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalBehaviorAnnexParser.g:4781:3: (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==EqualsSignGreaterThanSign) ) {
                alt83=1;
            }
            else if ( (LA83_0==PlusSignEqualsSignGreaterThanSign) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4782:4: otherlv_1= EqualsSignGreaterThanSign
                    {
                    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_74); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:4787:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    {
                    // InternalBehaviorAnnexParser.g:4787:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    // InternalBehaviorAnnexParser.g:4788:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    {
                    // InternalBehaviorAnnexParser.g:4788:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    // InternalBehaviorAnnexParser.g:4789:6: lv_append_2_0= PlusSignEqualsSignGreaterThanSign
                    {
                    lv_append_2_0=(Token)match(input,PlusSignEqualsSignGreaterThanSign,FollowSets000.FOLLOW_74); if (state.failed) return current;
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

            // InternalBehaviorAnnexParser.g:4802:3: ( (lv_constant_3_0= Constant ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==Constant) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4803:4: (lv_constant_3_0= Constant )
                    {
                    // InternalBehaviorAnnexParser.g:4803:4: (lv_constant_3_0= Constant )
                    // InternalBehaviorAnnexParser.g:4804:5: lv_constant_3_0= Constant
                    {
                    lv_constant_3_0=(Token)match(input,Constant,FollowSets000.FOLLOW_74); if (state.failed) return current;
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

            // InternalBehaviorAnnexParser.g:4816:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalBehaviorAnnexParser.g:4817:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalBehaviorAnnexParser.g:4817:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalBehaviorAnnexParser.g:4818:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalBehaviorAnnexParser.g:4818:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalBehaviorAnnexParser.g:4819:6: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
            if ( state.backtracking==0 ) {

                                      newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_75);
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

            // InternalBehaviorAnnexParser.g:4836:4: (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==Comma) ) {
                    alt85=1;
                }


                switch (alt85) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4837:5: otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
                    {
                    otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_74); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:4841:5: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
                    // InternalBehaviorAnnexParser.g:4842:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
                    {
                    // InternalBehaviorAnnexParser.g:4842:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
                    // InternalBehaviorAnnexParser.g:4843:7: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
                    {
                    if ( state.backtracking==0 ) {

                                                  newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_75);
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
                    break loop85;
                }
            } while (true);


            }

            // InternalBehaviorAnnexParser.g:4862:3: (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==Applies) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4863:4: otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    {
                    otherlv_7=(Token)match(input,Applies,FollowSets000.FOLLOW_76); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_7, grammarAccess.getContainedPropertyAssociationAccess().getAppliesKeyword_4_0());

                    }
                    otherlv_8=(Token)match(input,To,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_8, grammarAccess.getContainedPropertyAssociationAccess().getToKeyword_4_1());

                    }
                    // InternalBehaviorAnnexParser.g:4871:4: ( (lv_appliesTo_9_0= ruleContainmentPath ) )
                    // InternalBehaviorAnnexParser.g:4872:5: (lv_appliesTo_9_0= ruleContainmentPath )
                    {
                    // InternalBehaviorAnnexParser.g:4872:5: (lv_appliesTo_9_0= ruleContainmentPath )
                    // InternalBehaviorAnnexParser.g:4873:6: lv_appliesTo_9_0= ruleContainmentPath
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_77);
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

                    // InternalBehaviorAnnexParser.g:4890:4: (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==Comma) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:4891:5: otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                            {
                            otherlv_10=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                  newLeafNode(otherlv_10, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_3_0());

                            }
                            // InternalBehaviorAnnexParser.g:4895:5: ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                            // InternalBehaviorAnnexParser.g:4896:6: (lv_appliesTo_11_0= ruleContainmentPath )
                            {
                            // InternalBehaviorAnnexParser.g:4896:6: (lv_appliesTo_11_0= ruleContainmentPath )
                            // InternalBehaviorAnnexParser.g:4897:7: lv_appliesTo_11_0= ruleContainmentPath
                            {
                            if ( state.backtracking==0 ) {

                                                          newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_3_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_77);
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
                            break loop86;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:4916:3: (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==In) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4917:4: otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis
                    {
                    otherlv_12=(Token)match(input,In,FollowSets000.FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getInKeyword_5_0());

                    }
                    otherlv_13=(Token)match(input,Binding,FollowSets000.FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_13, grammarAccess.getContainedPropertyAssociationAccess().getBindingKeyword_5_1());

                    }
                    otherlv_14=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_2());

                    }
                    // InternalBehaviorAnnexParser.g:4929:4: ( ( ruleQCREF ) )
                    // InternalBehaviorAnnexParser.g:4930:5: ( ruleQCREF )
                    {
                    // InternalBehaviorAnnexParser.g:4930:5: ( ruleQCREF )
                    // InternalBehaviorAnnexParser.g:4931:6: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                                              if (current==null) {
                                                  current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                                              }

                    }
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_3_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_47);
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
    // InternalBehaviorAnnexParser.g:4958:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalBehaviorAnnexParser.g:4958:56: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalBehaviorAnnexParser.g:4959:2: iv_ruleContainmentPath= ruleContainmentPath EOF
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
    // InternalBehaviorAnnexParser.g:4965:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4971:2: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalBehaviorAnnexParser.g:4972:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalBehaviorAnnexParser.g:4972:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalBehaviorAnnexParser.g:4973:3: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalBehaviorAnnexParser.g:4973:3: (lv_path_0_0= ruleContainmentPathElement )
            // InternalBehaviorAnnexParser.g:4974:4: lv_path_0_0= ruleContainmentPathElement
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
    // InternalBehaviorAnnexParser.g:4994:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalBehaviorAnnexParser.g:4994:67: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalBehaviorAnnexParser.g:4995:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
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
    // InternalBehaviorAnnexParser.g:5001:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? ) ;
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
            // InternalBehaviorAnnexParser.g:5007:2: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? ) )
            // InternalBehaviorAnnexParser.g:5008:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? )
            {
            // InternalBehaviorAnnexParser.g:5008:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? )
            // InternalBehaviorAnnexParser.g:5009:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )?
            {
            // InternalBehaviorAnnexParser.g:5009:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalBehaviorAnnexParser.g:5010:4: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalBehaviorAnnexParser.g:5010:4: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalBehaviorAnnexParser.g:5011:5: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_51);
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

            // InternalBehaviorAnnexParser.g:5028:3: (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==In) ) {
                int LA90_1 = input.LA(2);

                if ( (LA90_1==Modes) ) {
                    alt90=1;
                }
            }
            switch (alt90) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5029:4: otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis
                    {
                    otherlv_1=(Token)match(input,In,FollowSets000.FOLLOW_78); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_1, grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0());

                    }
                    otherlv_2=(Token)match(input,Modes,FollowSets000.FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1());

                    }
                    otherlv_3=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2());

                    }
                    // InternalBehaviorAnnexParser.g:5041:4: ( (otherlv_4= RULE_ID ) )
                    // InternalBehaviorAnnexParser.g:5042:5: (otherlv_4= RULE_ID )
                    {
                    // InternalBehaviorAnnexParser.g:5042:5: (otherlv_4= RULE_ID )
                    // InternalBehaviorAnnexParser.g:5043:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                                              if (current==null) {
                                                  current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                                              }

                    }
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                              newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0());

                    }

                    }


                    }

                    // InternalBehaviorAnnexParser.g:5054:4: (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==Comma) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:5055:5: otherlv_5= Comma ( (otherlv_6= RULE_ID ) )
                            {
                            otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                  newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0());

                            }
                            // InternalBehaviorAnnexParser.g:5059:5: ( (otherlv_6= RULE_ID ) )
                            // InternalBehaviorAnnexParser.g:5060:6: (otherlv_6= RULE_ID )
                            {
                            // InternalBehaviorAnnexParser.g:5060:6: (otherlv_6= RULE_ID )
                            // InternalBehaviorAnnexParser.g:5061:7: otherlv_6= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                                                          if (current==null) {
                                                              current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                                                          }

                            }
                            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_46); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                          newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0());

                            }

                            }


                            }


                            }
                            break;

                        default :
                            break loop89;
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
    // InternalBehaviorAnnexParser.g:5082:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalBehaviorAnnexParser.g:5082:54: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalBehaviorAnnexParser.g:5083:2: iv_rulePropertyValue= rulePropertyValue EOF
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
    // InternalBehaviorAnnexParser.g:5089:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5095:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalBehaviorAnnexParser.g:5096:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalBehaviorAnnexParser.g:5096:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalBehaviorAnnexParser.g:5097:3: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalBehaviorAnnexParser.g:5097:3: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalBehaviorAnnexParser.g:5098:4: lv_ownedValue_0_0= rulePropertyExpression
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
    // InternalBehaviorAnnexParser.g:5118:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:5118:59: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalBehaviorAnnexParser.g:5119:2: iv_rulePropertyExpression= rulePropertyExpression EOF
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
    // InternalBehaviorAnnexParser.g:5125:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) ;
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
            // InternalBehaviorAnnexParser.g:5131:2: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) )
            // InternalBehaviorAnnexParser.g:5132:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            {
            // InternalBehaviorAnnexParser.g:5132:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            int alt91=11;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5133:3: this_RecordTerm_0= ruleRecordTerm
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
                    // InternalBehaviorAnnexParser.g:5142:3: this_ReferenceTerm_1= ruleReferenceTerm
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
                    // InternalBehaviorAnnexParser.g:5151:3: this_ComponentClassifierTerm_2= ruleComponentClassifierTerm
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
                    // InternalBehaviorAnnexParser.g:5160:3: this_ComputedTerm_3= ruleComputedTerm
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
                    // InternalBehaviorAnnexParser.g:5169:3: this_StringTerm_4= ruleStringTerm
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
                    // InternalBehaviorAnnexParser.g:5178:3: this_NumericRangeTerm_5= ruleNumericRangeTerm
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
                    // InternalBehaviorAnnexParser.g:5187:3: this_RealTerm_6= ruleRealTerm
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
                    // InternalBehaviorAnnexParser.g:5196:3: this_IntegerTerm_7= ruleIntegerTerm
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
                    // InternalBehaviorAnnexParser.g:5205:3: this_ListTerm_8= ruleListTerm
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
                    // InternalBehaviorAnnexParser.g:5214:3: this_BooleanLiteral_9= ruleBooleanLiteral
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
                    // InternalBehaviorAnnexParser.g:5223:3: this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm
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
    // InternalBehaviorAnnexParser.g:5235:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5235:63: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalBehaviorAnnexParser.g:5236:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
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
    // InternalBehaviorAnnexParser.g:5242:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5248:2: ( ( ( ruleQPREF ) ) )
            // InternalBehaviorAnnexParser.g:5249:2: ( ( ruleQPREF ) )
            {
            // InternalBehaviorAnnexParser.g:5249:2: ( ( ruleQPREF ) )
            // InternalBehaviorAnnexParser.g:5250:3: ( ruleQPREF )
            {
            // InternalBehaviorAnnexParser.g:5250:3: ( ruleQPREF )
            // InternalBehaviorAnnexParser.g:5251:4: ruleQPREF
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
    // InternalBehaviorAnnexParser.g:5268:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:5268:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalBehaviorAnnexParser.g:5269:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalBehaviorAnnexParser.g:5275:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5281:2: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalBehaviorAnnexParser.g:5282:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalBehaviorAnnexParser.g:5282:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalBehaviorAnnexParser.g:5283:3: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalBehaviorAnnexParser.g:5283:3: ()
            // InternalBehaviorAnnexParser.g:5284:4:
            {
            if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                                  current);

            }

            }

            // InternalBehaviorAnnexParser.g:5290:3: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==True) ) {
                alt92=1;
            }
            else if ( (LA92_0==False) ) {
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
                    // InternalBehaviorAnnexParser.g:5291:4: ( (lv_value_1_0= True ) )
                    {
                    // InternalBehaviorAnnexParser.g:5291:4: ( (lv_value_1_0= True ) )
                    // InternalBehaviorAnnexParser.g:5292:5: (lv_value_1_0= True )
                    {
                    // InternalBehaviorAnnexParser.g:5292:5: (lv_value_1_0= True )
                    // InternalBehaviorAnnexParser.g:5293:6: lv_value_1_0= True
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
                    // InternalBehaviorAnnexParser.g:5306:4: otherlv_2= False
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
    // InternalBehaviorAnnexParser.g:5315:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalBehaviorAnnexParser.g:5315:54: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalBehaviorAnnexParser.g:5316:2: iv_ruleConstantValue= ruleConstantValue EOF
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
    // InternalBehaviorAnnexParser.g:5322:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5328:2: ( ( ( ruleQPREF ) ) )
            // InternalBehaviorAnnexParser.g:5329:2: ( ( ruleQPREF ) )
            {
            // InternalBehaviorAnnexParser.g:5329:2: ( ( ruleQPREF ) )
            // InternalBehaviorAnnexParser.g:5330:3: ( ruleQPREF )
            {
            // InternalBehaviorAnnexParser.g:5330:3: ( ruleQPREF )
            // InternalBehaviorAnnexParser.g:5331:4: ruleQPREF
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
    // InternalBehaviorAnnexParser.g:5348:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5348:54: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalBehaviorAnnexParser.g:5349:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
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
    // InternalBehaviorAnnexParser.g:5355:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5361:2: ( (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:5362:2: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:5362:2: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            // InternalBehaviorAnnexParser.g:5363:3: otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Reference,FollowSets000.FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:5371:3: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalBehaviorAnnexParser.g:5372:4: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalBehaviorAnnexParser.g:5372:4: (lv_path_2_0= ruleContainmentPathElement )
            // InternalBehaviorAnnexParser.g:5373:5: lv_path_2_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_47);
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
    // InternalBehaviorAnnexParser.g:5398:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5398:51: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalBehaviorAnnexParser.g:5399:2: iv_ruleRecordTerm= ruleRecordTerm EOF
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
    // InternalBehaviorAnnexParser.g:5405:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5411:2: ( (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:5412:2: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:5412:2: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:5413:3: otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:5417:3: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt93=0;
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==RULE_ID) ) {
                    alt93=1;
                }


                switch (alt93) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5418:4: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
                    {
                    // InternalBehaviorAnnexParser.g:5418:4: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
                    // InternalBehaviorAnnexParser.g:5419:5: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_79);
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
                    if ( cnt93 >= 1 ) break loop93;
                    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(93, input);
                        throw eee;
                }
                cnt93++;
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
    // InternalBehaviorAnnexParser.g:5444:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5444:53: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalBehaviorAnnexParser.g:5445:2: iv_ruleComputedTerm= ruleComputedTerm EOF
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
    // InternalBehaviorAnnexParser.g:5451:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5457:2: ( (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:5458:2: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:5458:2: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            // InternalBehaviorAnnexParser.g:5459:3: otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Compute,FollowSets000.FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:5467:3: ( (lv_function_2_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:5468:4: (lv_function_2_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:5468:4: (lv_function_2_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:5469:5: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_47); if (state.failed) return current;
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
    // InternalBehaviorAnnexParser.g:5493:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5493:64: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalBehaviorAnnexParser.g:5494:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
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
    // InternalBehaviorAnnexParser.g:5500:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5506:2: ( (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:5507:2: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:5507:2: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            // InternalBehaviorAnnexParser.g:5508:3: otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Classifier,FollowSets000.FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:5516:3: ( ( ruleQCREF ) )
            // InternalBehaviorAnnexParser.g:5517:4: ( ruleQCREF )
            {
            // InternalBehaviorAnnexParser.g:5517:4: ( ruleQCREF )
            // InternalBehaviorAnnexParser.g:5518:5: ruleQCREF
            {
            if ( state.backtracking==0 ) {

                                  if (current==null) {
                                      current = createModelElement(grammarAccess.getComponentClassifierTermRule());
                                  }

            }
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_47);
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
    // InternalBehaviorAnnexParser.g:5540:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5540:49: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalBehaviorAnnexParser.g:5541:2: iv_ruleListTerm= ruleListTerm EOF
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
    // InternalBehaviorAnnexParser.g:5547:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5553:2: ( ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:5554:2: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:5554:2: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            // InternalBehaviorAnnexParser.g:5555:3: () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis
            {
            // InternalBehaviorAnnexParser.g:5555:3: ()
            // InternalBehaviorAnnexParser.g:5556:4:
            {
            if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getListTermAccess().getListValueAction_0(),
                                  current);

            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_80); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:5566:3: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==Classifier||LA95_0==Reference||LA95_0==Compute||LA95_0==False||LA95_0==True||LA95_0==LeftParenthesis||LA95_0==PlusSign||LA95_0==HyphenMinus||LA95_0==LeftSquareBracket||LA95_0==RULE_REAL_LIT||LA95_0==RULE_INTEGER_LIT||(LA95_0>=RULE_STRING && LA95_0<=RULE_ID)) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5567:4: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalBehaviorAnnexParser.g:5567:4: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalBehaviorAnnexParser.g:5568:5: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalBehaviorAnnexParser.g:5568:5: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalBehaviorAnnexParser.g:5569:6: lv_ownedListElement_2_0= rulePropertyExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_46);
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

                    // InternalBehaviorAnnexParser.g:5586:4: (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==Comma) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:5587:5: otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                            {
                            otherlv_3=(Token)match(input,Comma,FollowSets000.FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                  newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());

                            }
                            // InternalBehaviorAnnexParser.g:5591:5: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                            // InternalBehaviorAnnexParser.g:5592:6: (lv_ownedListElement_4_0= rulePropertyExpression )
                            {
                            // InternalBehaviorAnnexParser.g:5592:6: (lv_ownedListElement_4_0= rulePropertyExpression )
                            // InternalBehaviorAnnexParser.g:5593:7: lv_ownedListElement_4_0= rulePropertyExpression
                            {
                            if ( state.backtracking==0 ) {

                                                          newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_46);
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
                            break loop94;
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
    // InternalBehaviorAnnexParser.g:5620:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalBehaviorAnnexParser.g:5620:65: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalBehaviorAnnexParser.g:5621:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
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
    // InternalBehaviorAnnexParser.g:5627:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5633:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) )
            // InternalBehaviorAnnexParser.g:5634:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            {
            // InternalBehaviorAnnexParser.g:5634:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            // InternalBehaviorAnnexParser.g:5635:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon
            {
            // InternalBehaviorAnnexParser.g:5635:3: ( (otherlv_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:5636:4: (otherlv_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:5636:4: (otherlv_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:5637:5: otherlv_0= RULE_ID
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
            // InternalBehaviorAnnexParser.g:5652:3: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalBehaviorAnnexParser.g:5653:4: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalBehaviorAnnexParser.g:5653:4: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalBehaviorAnnexParser.g:5654:5: lv_ownedValue_2_0= rulePropertyExpression
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
    // InternalBehaviorAnnexParser.g:5679:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalBehaviorAnnexParser.g:5679:63: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalBehaviorAnnexParser.g:5680:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
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
    // InternalBehaviorAnnexParser.g:5686:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5692:2: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalBehaviorAnnexParser.g:5693:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:5693:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalBehaviorAnnexParser.g:5694:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalBehaviorAnnexParser.g:5694:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* )
            // InternalBehaviorAnnexParser.g:5695:4: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            {
            // InternalBehaviorAnnexParser.g:5695:4: ( (otherlv_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:5696:5: (otherlv_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:5696:5: (otherlv_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:5697:6: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

                                      if (current==null) {
                                          current = createModelElement(grammarAccess.getContainmentPathElementRule());
                                      }

            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0());

            }

            }


            }

            // InternalBehaviorAnnexParser.g:5708:4: ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==LeftSquareBracket) ) {
                    alt96=1;
                }


                switch (alt96) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5709:5: (lv_arrayRange_1_0= ruleArrayRange )
                    {
                    // InternalBehaviorAnnexParser.g:5709:5: (lv_arrayRange_1_0= ruleArrayRange )
                    // InternalBehaviorAnnexParser.g:5710:6: lv_arrayRange_1_0= ruleArrayRange
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_67);
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
                    break loop96;
                }
            } while (true);


            }

            // InternalBehaviorAnnexParser.g:5728:3: (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==FullStop) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5729:4: otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,FullStop,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:5733:4: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalBehaviorAnnexParser.g:5734:5: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalBehaviorAnnexParser.g:5734:5: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalBehaviorAnnexParser.g:5735:6: lv_path_3_0= ruleContainmentPathElement
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
    // InternalBehaviorAnnexParser.g:5757:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalBehaviorAnnexParser.g:5757:49: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalBehaviorAnnexParser.g:5758:2: iv_rulePlusMinus= rulePlusMinus EOF
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
    // InternalBehaviorAnnexParser.g:5764:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5770:2: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalBehaviorAnnexParser.g:5771:2: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalBehaviorAnnexParser.g:5771:2: (kw= PlusSign | kw= HyphenMinus )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==PlusSign) ) {
                alt98=1;
            }
            else if ( (LA98_0==HyphenMinus) ) {
                alt98=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5772:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                  current.merge(kw);
                                  newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:5778:3: kw= HyphenMinus
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
    // InternalBehaviorAnnexParser.g:5787:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5787:51: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalBehaviorAnnexParser.g:5788:2: iv_ruleStringTerm= ruleStringTerm EOF
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
    // InternalBehaviorAnnexParser.g:5794:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5800:2: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalBehaviorAnnexParser.g:5801:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalBehaviorAnnexParser.g:5801:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalBehaviorAnnexParser.g:5802:3: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalBehaviorAnnexParser.g:5802:3: (lv_value_0_0= ruleNoQuoteString )
            // InternalBehaviorAnnexParser.g:5803:4: lv_value_0_0= ruleNoQuoteString
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
    // InternalBehaviorAnnexParser.g:5823:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalBehaviorAnnexParser.g:5823:53: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalBehaviorAnnexParser.g:5824:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
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
    // InternalBehaviorAnnexParser.g:5830:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5836:2: (this_STRING_0= RULE_STRING )
            // InternalBehaviorAnnexParser.g:5837:2: this_STRING_0= RULE_STRING
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
    // InternalBehaviorAnnexParser.g:5847:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalBehaviorAnnexParser.g:5847:51: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalBehaviorAnnexParser.g:5848:2: iv_ruleArrayRange= ruleArrayRange EOF
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
    // InternalBehaviorAnnexParser.g:5854:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5860:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:5861:2: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:5861:2: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:5862:3: () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket
            {
            // InternalBehaviorAnnexParser.g:5862:3: ()
            // InternalBehaviorAnnexParser.g:5863:4:
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
            // InternalBehaviorAnnexParser.g:5873:3: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalBehaviorAnnexParser.g:5874:4: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalBehaviorAnnexParser.g:5874:4: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalBehaviorAnnexParser.g:5875:5: lv_lowerBound_2_0= ruleINTVALUE
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_81);
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

            // InternalBehaviorAnnexParser.g:5892:3: (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==FullStopFullStop) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5893:4: otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());

                    }
                    // InternalBehaviorAnnexParser.g:5897:4: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalBehaviorAnnexParser.g:5898:5: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalBehaviorAnnexParser.g:5898:5: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalBehaviorAnnexParser.g:5899:6: lv_upperBound_4_0= ruleINTVALUE
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
    // InternalBehaviorAnnexParser.g:5925:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalBehaviorAnnexParser.g:5925:55: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalBehaviorAnnexParser.g:5926:2: iv_ruleSignedConstant= ruleSignedConstant EOF
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
    // InternalBehaviorAnnexParser.g:5932:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5938:2: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalBehaviorAnnexParser.g:5939:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalBehaviorAnnexParser.g:5939:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalBehaviorAnnexParser.g:5940:3: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalBehaviorAnnexParser.g:5940:3: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalBehaviorAnnexParser.g:5941:4: (lv_op_0_0= rulePlusMinus )
            {
            // InternalBehaviorAnnexParser.g:5941:4: (lv_op_0_0= rulePlusMinus )
            // InternalBehaviorAnnexParser.g:5942:5: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_82);
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

            // InternalBehaviorAnnexParser.g:5959:3: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalBehaviorAnnexParser.g:5960:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalBehaviorAnnexParser.g:5960:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalBehaviorAnnexParser.g:5961:5: lv_ownedPropertyExpression_1_0= ruleConstantValue
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
    // InternalBehaviorAnnexParser.g:5982:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5982:52: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalBehaviorAnnexParser.g:5983:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
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
    // InternalBehaviorAnnexParser.g:5989:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5995:2: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalBehaviorAnnexParser.g:5996:2: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalBehaviorAnnexParser.g:5996:2: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalBehaviorAnnexParser.g:5997:3: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalBehaviorAnnexParser.g:5997:3: ( (lv_value_0_0= ruleSignedInt ) )
            // InternalBehaviorAnnexParser.g:5998:4: (lv_value_0_0= ruleSignedInt )
            {
            // InternalBehaviorAnnexParser.g:5998:4: (lv_value_0_0= ruleSignedInt )
            // InternalBehaviorAnnexParser.g:5999:5: lv_value_0_0= ruleSignedInt
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

            // InternalBehaviorAnnexParser.g:6016:3: ( (otherlv_1= RULE_ID ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==RULE_ID) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6017:4: (otherlv_1= RULE_ID )
                    {
                    // InternalBehaviorAnnexParser.g:6017:4: (otherlv_1= RULE_ID )
                    // InternalBehaviorAnnexParser.g:6018:5: otherlv_1= RULE_ID
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
    // InternalBehaviorAnnexParser.g:6033:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // InternalBehaviorAnnexParser.g:6033:49: (iv_ruleSignedInt= ruleSignedInt EOF )
            // InternalBehaviorAnnexParser.g:6034:2: iv_ruleSignedInt= ruleSignedInt EOF
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
    // InternalBehaviorAnnexParser.g:6040:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6046:2: ( ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalBehaviorAnnexParser.g:6047:2: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalBehaviorAnnexParser.g:6047:2: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalBehaviorAnnexParser.g:6048:3: (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // InternalBehaviorAnnexParser.g:6048:3: (kw= PlusSign | kw= HyphenMinus )?
            int alt101=3;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==PlusSign) ) {
                alt101=1;
            }
            else if ( (LA101_0==HyphenMinus) ) {
                alt101=2;
            }
            switch (alt101) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6049:4: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:6055:4: kw= HyphenMinus
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
    // InternalBehaviorAnnexParser.g:6072:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:6072:49: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalBehaviorAnnexParser.g:6073:2: iv_ruleRealTerm= ruleRealTerm EOF
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
    // InternalBehaviorAnnexParser.g:6079:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6085:2: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalBehaviorAnnexParser.g:6086:2: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalBehaviorAnnexParser.g:6086:2: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalBehaviorAnnexParser.g:6087:3: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalBehaviorAnnexParser.g:6087:3: ( (lv_value_0_0= ruleSignedReal ) )
            // InternalBehaviorAnnexParser.g:6088:4: (lv_value_0_0= ruleSignedReal )
            {
            // InternalBehaviorAnnexParser.g:6088:4: (lv_value_0_0= ruleSignedReal )
            // InternalBehaviorAnnexParser.g:6089:5: lv_value_0_0= ruleSignedReal
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

            // InternalBehaviorAnnexParser.g:6106:3: ( (otherlv_1= RULE_ID ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==RULE_ID) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6107:4: (otherlv_1= RULE_ID )
                    {
                    // InternalBehaviorAnnexParser.g:6107:4: (otherlv_1= RULE_ID )
                    // InternalBehaviorAnnexParser.g:6108:5: otherlv_1= RULE_ID
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
    // InternalBehaviorAnnexParser.g:6123:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // InternalBehaviorAnnexParser.g:6123:50: (iv_ruleSignedReal= ruleSignedReal EOF )
            // InternalBehaviorAnnexParser.g:6124:2: iv_ruleSignedReal= ruleSignedReal EOF
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
    // InternalBehaviorAnnexParser.g:6130:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6136:2: ( ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // InternalBehaviorAnnexParser.g:6137:2: ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // InternalBehaviorAnnexParser.g:6137:2: ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT )
            // InternalBehaviorAnnexParser.g:6138:3: (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // InternalBehaviorAnnexParser.g:6138:3: (kw= PlusSign | kw= HyphenMinus )?
            int alt103=3;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==PlusSign) ) {
                alt103=1;
            }
            else if ( (LA103_0==HyphenMinus) ) {
                alt103=2;
            }
            switch (alt103) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6139:4: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_83); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:6145:4: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_83); if (state.failed) return current;
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
    // InternalBehaviorAnnexParser.g:6162:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:6162:57: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalBehaviorAnnexParser.g:6163:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
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
    // InternalBehaviorAnnexParser.g:6169:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6175:2: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalBehaviorAnnexParser.g:6176:2: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:6176:2: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalBehaviorAnnexParser.g:6177:3: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalBehaviorAnnexParser.g:6177:3: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalBehaviorAnnexParser.g:6178:4: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalBehaviorAnnexParser.g:6178:4: (lv_minimum_0_0= ruleNumAlt )
            // InternalBehaviorAnnexParser.g:6179:5: lv_minimum_0_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_84);
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

            otherlv_1=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_82); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:6200:3: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalBehaviorAnnexParser.g:6201:4: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalBehaviorAnnexParser.g:6201:4: (lv_maximum_2_0= ruleNumAlt )
            // InternalBehaviorAnnexParser.g:6202:5: lv_maximum_2_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_85);
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

            // InternalBehaviorAnnexParser.g:6219:3: (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==Delta) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6220:4: otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,Delta,FollowSets000.FOLLOW_82); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());

                    }
                    // InternalBehaviorAnnexParser.g:6224:4: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalBehaviorAnnexParser.g:6225:5: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalBehaviorAnnexParser.g:6225:5: (lv_delta_4_0= ruleNumAlt )
                    // InternalBehaviorAnnexParser.g:6226:6: lv_delta_4_0= ruleNumAlt
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
    // InternalBehaviorAnnexParser.g:6248:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalBehaviorAnnexParser.g:6248:47: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalBehaviorAnnexParser.g:6249:2: iv_ruleNumAlt= ruleNumAlt EOF
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
    // InternalBehaviorAnnexParser.g:6255:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6261:2: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalBehaviorAnnexParser.g:6262:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalBehaviorAnnexParser.g:6262:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt105=4;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                switch ( input.LA(2) ) {
                case RULE_REAL_LIT:
                    {
                    alt105=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt105=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt105=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 105, 1, input);

                    throw nvae;
                }

                }
                break;
            case HyphenMinus:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt105=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt105=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt105=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 105, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt105=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt105=2;
                }
                break;
            case RULE_ID:
                {
                alt105=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }

            switch (alt105) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6263:3: this_RealTerm_0= ruleRealTerm
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
                    // InternalBehaviorAnnexParser.g:6272:3: this_IntegerTerm_1= ruleIntegerTerm
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
                    // InternalBehaviorAnnexParser.g:6281:3: this_SignedConstant_2= ruleSignedConstant
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
                    // InternalBehaviorAnnexParser.g:6290:3: this_ConstantValue_3= ruleConstantValue
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
    // InternalBehaviorAnnexParser.g:6302:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalBehaviorAnnexParser.g:6302:48: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalBehaviorAnnexParser.g:6303:2: iv_ruleINTVALUE= ruleINTVALUE EOF
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
    // InternalBehaviorAnnexParser.g:6309:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6315:2: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalBehaviorAnnexParser.g:6316:2: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalBehaviorAnnexParser.g:6326:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalBehaviorAnnexParser.g:6326:45: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalBehaviorAnnexParser.g:6327:2: iv_ruleQPREF= ruleQPREF EOF
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
    // InternalBehaviorAnnexParser.g:6333:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6339:2: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) )
            // InternalBehaviorAnnexParser.g:6340:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            {
            // InternalBehaviorAnnexParser.g:6340:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            // InternalBehaviorAnnexParser.g:6341:3: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_72); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current.merge(this_ID_0);

            }
            if ( state.backtracking==0 ) {

                          newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0());

            }
            // InternalBehaviorAnnexParser.g:6348:3: (kw= ColonColon this_ID_2= RULE_ID )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==ColonColon) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6349:4: kw= ColonColon this_ID_2= RULE_ID
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
    // InternalBehaviorAnnexParser.g:6366:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalBehaviorAnnexParser.g:6366:45: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalBehaviorAnnexParser.g:6367:2: iv_ruleQCREF= ruleQCREF EOF
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
    // InternalBehaviorAnnexParser.g:6373:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6379:2: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // InternalBehaviorAnnexParser.g:6380:2: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // InternalBehaviorAnnexParser.g:6380:2: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // InternalBehaviorAnnexParser.g:6381:3: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // InternalBehaviorAnnexParser.g:6381:3: (this_ID_0= RULE_ID kw= ColonColon )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==RULE_ID) ) {
                    int LA107_1 = input.LA(2);

                    if ( (LA107_1==ColonColon) ) {
                        alt107=1;
                    }


                }


                switch (alt107) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6382:4: this_ID_0= RULE_ID kw= ColonColon
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_86); if (state.failed) return current;
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
                    break loop107;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_68); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current.merge(this_ID_2);

            }
            if ( state.backtracking==0 ) {

                          newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1());

            }
            // InternalBehaviorAnnexParser.g:6402:3: (kw= FullStop this_ID_4= RULE_ID )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==FullStop) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6403:4: kw= FullStop this_ID_4= RULE_ID
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
    // InternalBehaviorAnnexParser.g:6420:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalBehaviorAnnexParser.g:6420:44: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalBehaviorAnnexParser.g:6421:2: iv_ruleSTAR= ruleSTAR EOF
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
    // InternalBehaviorAnnexParser.g:6427:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Asterisk ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6433:2: (kw= Asterisk )
            // InternalBehaviorAnnexParser.g:6434:2: kw= Asterisk
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
        // InternalBehaviorAnnexParser.g:1644:4: ( ruleAssignmentAction )
        // InternalBehaviorAnnexParser.g:1644:5: ruleAssignmentAction
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


    protected DFA37 dfa37 = new DFA37(this);
    protected DFA91 dfa91 = new DFA91(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\4\1\0\11\uffff";
    static final String dfa_3s = "\1\136\1\0\11\uffff";
    static final String dfa_4s = "\2\uffff\1\2\1\3\1\4\1\5\1\uffff\1\6\1\7\1\10\1\1";
    static final String dfa_5s = "\1\uffff\1\0\11\uffff}>";
    static final String[] dfa_6s = {
            "\1\3\15\uffff\1\5\13\uffff\1\7\11\uffff\1\5\20\uffff\1\10\1\4\12\uffff\1\2\15\uffff\1\11\12\uffff\1\1",
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

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1642:2: ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
            int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA37_1 = input.LA(1);


                        int index37_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalBehaviorAnnexParser()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}


                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\25\uffff";
    static final String dfa_8s = "\10\uffff\1\17\1\21\1\23\3\uffff\1\17\1\uffff\1\21\3\uffff\1\23";
    static final String dfa_9s = "\1\6\5\uffff\2\131\3\15\3\uffff\1\15\1\uffff\1\15\1\uffff\1\136\1\uffff\1\15";
    static final String dfa_10s = "\1\136\5\uffff\4\136\1\114\3\uffff\1\114\1\uffff\1\114\1\uffff\1\136\1\uffff\1\114";
    static final String dfa_11s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\5\uffff\1\11\1\12\1\6\1\uffff\1\7\1\uffff\1\10\1\uffff\1\13\1\uffff";
    static final String dfa_12s = "\25\uffff}>";
    static final String[] dfa_13s = {
            "\1\3\1\uffff\1\2\6\uffff\1\4\10\uffff\1\14\10\uffff\1\14\41\uffff\1\13\2\uffff\1\6\1\uffff\1\7\10\uffff\1\1\7\uffff\1\10\1\uffff\1\11\1\uffff\1\5\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\10\1\uffff\1\11\2\uffff\1\15",
            "\1\10\1\uffff\1\11\2\uffff\1\15",
            "\1\17\44\uffff\1\15\10\uffff\1\17\10\uffff\1\17\2\uffff\1\17\4\uffff\1\17\21\uffff\1\16",
            "\1\21\44\uffff\1\15\10\uffff\1\21\10\uffff\1\21\2\uffff\1\21\4\uffff\1\21\21\uffff\1\20",
            "\1\23\44\uffff\1\15\1\22\7\uffff\1\23\10\uffff\1\23\2\uffff\1\23\4\uffff\1\23",
            "",
            "",
            "",
            "\1\17\44\uffff\1\15\10\uffff\1\17\10\uffff\1\17\2\uffff\1\17\4\uffff\1\17",
            "",
            "\1\21\44\uffff\1\15\10\uffff\1\21\10\uffff\1\21\2\uffff\1\21\4\uffff\1\21",
            "",
            "\1\24",
            "",
            "\1\23\44\uffff\1\15\10\uffff\1\23\10\uffff\1\23\2\uffff\1\23\4\uffff\1\23"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "5132:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )";
        }
    }



    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000100022L,0x0000000040000000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000022L,0x0000000040000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000880L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0010000000000000L,0x0000000000081000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000201000000L,0x000000002A000001L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000081000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000040100000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000201000000L,0x000000006A000001L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000201008140L,0x000000006A020148L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000012010400L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000012000400L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000012000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020800L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0002000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x1000041A01020080L,0x000000006A000149L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000201001000L,0x000000006A000001L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000003010A0002L,0x000000006A000001L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000201000002L,0x000000006A000001L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000002000000002L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0600010241040010L,0x000000006A080021L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001002L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000045201000000L,0x000000006A000149L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x8100A00000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000041201000000L,0x000000006A000149L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000090L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000A00000000000L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0800000000000002L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000008080800000L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0400000000000000L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0004000000000002L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x2000100000000002L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x00A0400000000002L,0x000000000000E000L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000140L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x00000A0000000002L,0x0000000000000420L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010005L});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000004200000L});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020200L});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000048000001L});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010004L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000200L});
        public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0008000000000002L});
        public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0040000400000000L});
        public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000201008940L,0x000000006A020148L});
        public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0800000000002000L,0x0000000000001080L});
        public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0800000000000000L,0x0000000000001080L});
        public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000040040000L});
        public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000201008140L,0x000000006A020158L});
        public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0004000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000000L,0x000000004A000140L});
        public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
        public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0008000000000000L});
    }


}
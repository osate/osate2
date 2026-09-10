package org.osate.xtext.aadl2.ba.parser.antlr.internal;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.xtext.aadl2.ba.services.BehaviorAnnexGrammarAccess;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Computation", "Transitions", "Classifier", "Otherwise", "Reference", "Variables", "Complete", "Constant", "Dispatch", "Internal", "Applies", "Binding", "Compute", "Initial", "Timeout", "Forall", "Frozen", "States", "Count", "Delta", "Elsif", "False", "Final", "Fresh", "Modes", "State", "Until", "While", "Else", "Stop", "True", "PlusSignEqualsSignGreaterThanSign", "RightSquareBracketHyphenMinusGreaterThanSign", "Abs", "And", "Any", "End", "For", "Mod", "Not", "Rem", "Xor", "ExclamationMarkLessThanSign", "ExclamationMarkEqualsSign", "ExclamationMarkGreaterThanSign", "AsteriskAsterisk", "HyphenMinusLeftSquareBracket", "FullStopFullStop", "ColonColon", "ColonEqualsSign", "LessThanSignEqualsSign", "EqualsSignGreaterThanSign", "GreaterThanSignEqualsSign", "GreaterThanSignGreaterThanSign", "Do", "If", "In", "On", "Or", "To", "ExclamationMark", "NumberSign", "Ampersand", "Apostrophe", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "QuestionMark", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int Fresh=27;
    public static final int Or=62;
    public static final int Transitions=5;
    public static final int Stop=33;
    public static final int EqualsSignGreaterThanSign=55;
    public static final int Internal=13;
    public static final int ExclamationMarkLessThanSign=46;
    public static final int Count=22;
    public static final int False=25;
    public static final int LessThanSign=78;
    public static final int States=21;
    public static final int Otherwise=7;
    public static final int PlusSignEqualsSignGreaterThanSign=35;
    public static final int LeftParenthesis=68;
    public static final int ExclamationMark=64;
    public static final int GreaterThanSign=80;
    public static final int RULE_ID=95;
    public static final int RULE_DIGIT=87;
    public static final int Frozen=20;
    public static final int GreaterThanSignEqualsSign=56;
    public static final int ColonColon=52;
    public static final int PlusSign=71;
    public static final int Xor=45;
    public static final int LeftSquareBracket=82;
    public static final int If=59;
    public static final int In=60;
    public static final int Complete=10;
    public static final int RULE_REAL_LIT=90;
    public static final int Dispatch=12;
    public static final int Classifier=6;
    public static final int ExclamationMarkGreaterThanSign=48;
    public static final int Comma=72;
    public static final int HyphenMinus=73;
    public static final int Abs=37;
    public static final int Elsif=24;
    public static final int LessThanSignEqualsSign=54;
    public static final int Solidus=75;
    public static final int RightCurlyBracket=85;
    public static final int Final=26;
    public static final int Apostrophe=67;
    public static final int Modes=28;
    public static final int FullStop=74;
    public static final int Reference=8;
    public static final int Semicolon=77;
    public static final int RULE_EXPONENT=88;
    public static final int Delta=23;
    public static final int QuestionMark=81;
    public static final int Else=32;
    public static final int RULE_EXTENDED_DIGIT=93;
    public static final int Rem=44;
    public static final int ExclamationMarkEqualsSign=47;
    public static final int Initial=17;
    public static final int True=34;
    public static final int RULE_INT_EXPONENT=89;
    public static final int FullStopFullStop=51;
    public static final int Ampersand=66;
    public static final int To=63;
    public static final int Applies=14;
    public static final int Forall=19;
    public static final int RULE_BASED_INTEGER=91;
    public static final int RightSquareBracket=83;
    public static final int Binding=15;
    public static final int Timeout=18;
    public static final int For=41;
    public static final int RightParenthesis=69;
    public static final int Do=58;
    public static final int ColonEqualsSign=53;
    public static final int Not=43;
    public static final int Computation=4;
    public static final int State=29;
    public static final int And=38;
    public static final int NumberSign=65;
    public static final int AsteriskAsterisk=49;
    public static final int End=40;
    public static final int RULE_INTEGER_LIT=92;
    public static final int Constant=11;
    public static final int RULE_STRING=94;
    public static final int Any=39;
    public static final int RULE_SL_COMMENT=86;
    public static final int Variables=9;
    public static final int EqualsSign=79;
    public static final int Colon=76;
    public static final int EOF=-1;
    public static final int Asterisk=70;
    public static final int Until=30;
    public static final int Mod=42;
    public static final int RULE_WS=96;
    public static final int HyphenMinusLeftSquareBracket=50;
    public static final int LeftCurlyBracket=84;
    public static final int While=31;
    public static final int GreaterThanSignGreaterThanSign=57;
    public static final int RightSquareBracketHyphenMinusGreaterThanSign=36;
    public static final int Compute=16;
    public static final int On=61;

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
    // InternalBehaviorAnnexParser.g:1383:1: ruleModeSwitchCondition returns [EObject current=null] : ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* ) ;
    public final EObject ruleModeSwitchCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_conjunctions_0_0 = null;

        EObject lv_conjunctions_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1389:2: ( ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1390:2: ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1390:2: ( ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )* )
            // InternalBehaviorAnnexParser.g:1391:3: ( (lv_conjunctions_0_0= ruleModeSwitchConjunction ) ) (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )*
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
            pushFollow(FollowSets000.FOLLOW_36);
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

            // InternalBehaviorAnnexParser.g:1410:3: (otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==Or) ) {
                    alt33=1;
                }


                switch (alt33) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1411:4: otherlv_1= Or ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) )
                    {
                    otherlv_1=(Token)match(input,Or,FollowSets000.FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_1, grammarAccess.getModeSwitchConditionAccess().getOrKeyword_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:1415:4: ( (lv_conjunctions_2_0= ruleModeSwitchConjunction ) )
                    // InternalBehaviorAnnexParser.g:1416:5: (lv_conjunctions_2_0= ruleModeSwitchConjunction )
                    {
                    // InternalBehaviorAnnexParser.g:1416:5: (lv_conjunctions_2_0= ruleModeSwitchConjunction )
                    // InternalBehaviorAnnexParser.g:1417:6: lv_conjunctions_2_0= ruleModeSwitchConjunction
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getModeSwitchConditionAccess().getConjunctionsModeSwitchConjunctionParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_36);
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
    // InternalBehaviorAnnexParser.g:1439:1: entryRuleModeSwitchConjunction returns [EObject current=null] : iv_ruleModeSwitchConjunction= ruleModeSwitchConjunction EOF ;
    public final EObject entryRuleModeSwitchConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeSwitchConjunction = null;


        try {
            // InternalBehaviorAnnexParser.g:1439:62: (iv_ruleModeSwitchConjunction= ruleModeSwitchConjunction EOF )
            // InternalBehaviorAnnexParser.g:1440:2: iv_ruleModeSwitchConjunction= ruleModeSwitchConjunction EOF
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
    // InternalBehaviorAnnexParser.g:1446:1: ruleModeSwitchConjunction returns [EObject current=null] : ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* ) ;
    public final EObject ruleModeSwitchConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_triggers_0_0 = null;

        EObject lv_triggers_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1452:2: ( ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1453:2: ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1453:2: ( ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )* )
            // InternalBehaviorAnnexParser.g:1454:3: ( (lv_triggers_0_0= ruleReference ) ) (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )*
            {
            // InternalBehaviorAnnexParser.g:1454:3: ( (lv_triggers_0_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:1455:4: (lv_triggers_0_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:1455:4: (lv_triggers_0_0= ruleReference )
            // InternalBehaviorAnnexParser.g:1456:5: lv_triggers_0_0= ruleReference
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getModeSwitchConjunctionAccess().getTriggersReferenceParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_37);
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

            // InternalBehaviorAnnexParser.g:1473:3: (otherlv_1= And ( (lv_triggers_2_0= ruleReference ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==And) ) {
                    alt34=1;
                }


                switch (alt34) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1474:4: otherlv_1= And ( (lv_triggers_2_0= ruleReference ) )
                    {
                    otherlv_1=(Token)match(input,And,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_1, grammarAccess.getModeSwitchConjunctionAccess().getAndKeyword_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:1478:4: ( (lv_triggers_2_0= ruleReference ) )
                    // InternalBehaviorAnnexParser.g:1479:5: (lv_triggers_2_0= ruleReference )
                    {
                    // InternalBehaviorAnnexParser.g:1479:5: (lv_triggers_2_0= ruleReference )
                    // InternalBehaviorAnnexParser.g:1480:6: lv_triggers_2_0= ruleReference
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getModeSwitchConjunctionAccess().getTriggersReferenceParserRuleCall_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_37);
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


    // $ANTLR start "entryRuleInternalCondition"
    // InternalBehaviorAnnexParser.g:1502:1: entryRuleInternalCondition returns [EObject current=null] : iv_ruleInternalCondition= ruleInternalCondition EOF ;
    public final EObject entryRuleInternalCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInternalCondition = null;


        try {
            // InternalBehaviorAnnexParser.g:1502:58: (iv_ruleInternalCondition= ruleInternalCondition EOF )
            // InternalBehaviorAnnexParser.g:1503:2: iv_ruleInternalCondition= ruleInternalCondition EOF
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
    // InternalBehaviorAnnexParser.g:1509:1: ruleInternalCondition returns [EObject current=null] : (otherlv_0= Internal ( (lv_internalPorts_1_0= ruleReference ) ) (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )* ) ;
    public final EObject ruleInternalCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_internalPorts_1_0 = null;

        EObject lv_internalPorts_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1515:2: ( (otherlv_0= Internal ( (lv_internalPorts_1_0= ruleReference ) ) (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )* ) )
            // InternalBehaviorAnnexParser.g:1516:2: (otherlv_0= Internal ( (lv_internalPorts_1_0= ruleReference ) ) (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:1516:2: (otherlv_0= Internal ( (lv_internalPorts_1_0= ruleReference ) ) (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )* )
            // InternalBehaviorAnnexParser.g:1517:3: otherlv_0= Internal ( (lv_internalPorts_1_0= ruleReference ) ) (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )*
            {
            otherlv_0=(Token)match(input,Internal,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getInternalConditionAccess().getInternalKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:1521:3: ( (lv_internalPorts_1_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:1522:4: (lv_internalPorts_1_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:1522:4: (lv_internalPorts_1_0= ruleReference )
            // InternalBehaviorAnnexParser.g:1523:5: lv_internalPorts_1_0= ruleReference
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

            // InternalBehaviorAnnexParser.g:1540:3: (otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==Or) ) {
                    alt35=1;
                }


                switch (alt35) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1541:4: otherlv_2= Or ( (lv_internalPorts_3_0= ruleReference ) )
                    {
                    otherlv_2=(Token)match(input,Or,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_2, grammarAccess.getInternalConditionAccess().getOrKeyword_2_0());

                    }
                    // InternalBehaviorAnnexParser.g:1545:4: ( (lv_internalPorts_3_0= ruleReference ) )
                    // InternalBehaviorAnnexParser.g:1546:5: (lv_internalPorts_3_0= ruleReference )
                    {
                    // InternalBehaviorAnnexParser.g:1546:5: (lv_internalPorts_3_0= ruleReference )
                    // InternalBehaviorAnnexParser.g:1547:6: lv_internalPorts_3_0= ruleReference
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
    // $ANTLR end "ruleInternalCondition"


    // $ANTLR start "entryRuleBehaviorActionBlock"
    // InternalBehaviorAnnexParser.g:1569:1: entryRuleBehaviorActionBlock returns [EObject current=null] : iv_ruleBehaviorActionBlock= ruleBehaviorActionBlock EOF ;
    public final EObject entryRuleBehaviorActionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorActionBlock = null;


        try {
            // InternalBehaviorAnnexParser.g:1569:60: (iv_ruleBehaviorActionBlock= ruleBehaviorActionBlock EOF )
            // InternalBehaviorAnnexParser.g:1570:2: iv_ruleBehaviorActionBlock= ruleBehaviorActionBlock EOF
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
    // InternalBehaviorAnnexParser.g:1576:1: ruleBehaviorActionBlock returns [EObject current=null] : (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? ) ;
    public final EObject ruleBehaviorActionBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_content_1_0 = null;

        EObject lv_timeout_4_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1582:2: ( (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? ) )
            // InternalBehaviorAnnexParser.g:1583:2: (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:1583:2: (otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )? )
            // InternalBehaviorAnnexParser.g:1584:3: otherlv_0= LeftCurlyBracket ( (lv_content_1_0= ruleBehaviorActions ) ) otherlv_2= RightCurlyBracket (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )?
            {
            otherlv_0=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getBehaviorActionBlockAccess().getLeftCurlyBracketKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:1588:3: ( (lv_content_1_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:1589:4: (lv_content_1_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:1589:4: (lv_content_1_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:1590:5: lv_content_1_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getBehaviorActionBlockAccess().getContentBehaviorActionsParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_39);
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

            otherlv_2=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_2, grammarAccess.getBehaviorActionBlockAccess().getRightCurlyBracketKeyword_2());

            }
            // InternalBehaviorAnnexParser.g:1611:3: (otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==Timeout) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1612:4: otherlv_3= Timeout ( (lv_timeout_4_0= ruleBehaviorTime ) )
                    {
                    otherlv_3=(Token)match(input,Timeout,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_3, grammarAccess.getBehaviorActionBlockAccess().getTimeoutKeyword_3_0());

                    }
                    // InternalBehaviorAnnexParser.g:1616:4: ( (lv_timeout_4_0= ruleBehaviorTime ) )
                    // InternalBehaviorAnnexParser.g:1617:5: (lv_timeout_4_0= ruleBehaviorTime )
                    {
                    // InternalBehaviorAnnexParser.g:1617:5: (lv_timeout_4_0= ruleBehaviorTime )
                    // InternalBehaviorAnnexParser.g:1618:6: lv_timeout_4_0= ruleBehaviorTime
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
    // InternalBehaviorAnnexParser.g:1640:1: entryRuleBehaviorActions returns [EObject current=null] : iv_ruleBehaviorActions= ruleBehaviorActions EOF ;
    public final EObject entryRuleBehaviorActions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorActions = null;


        try {
            // InternalBehaviorAnnexParser.g:1640:56: (iv_ruleBehaviorActions= ruleBehaviorActions EOF )
            // InternalBehaviorAnnexParser.g:1641:2: iv_ruleBehaviorActions= ruleBehaviorActions EOF
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
    // InternalBehaviorAnnexParser.g:1647:1: ruleBehaviorActions returns [EObject current=null] : (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? ) ;
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
            // InternalBehaviorAnnexParser.g:1653:2: ( (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? ) )
            // InternalBehaviorAnnexParser.g:1654:2: (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? )
            {
            // InternalBehaviorAnnexParser.g:1654:2: (this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )? )
            // InternalBehaviorAnnexParser.g:1655:3: this_BehaviorAction_0= ruleBehaviorAction ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )?
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getBehaviorActionsAccess().getBehaviorActionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_41);
            this_BehaviorAction_0=ruleBehaviorAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_BehaviorAction_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:1663:3: ( ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* ) | ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* ) )?
            int alt39=3;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Semicolon) ) {
                alt39=1;
            }
            else if ( (LA39_0==Ampersand) ) {
                alt39=2;
            }
            switch (alt39) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1664:4: ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* )
                    {
                    // InternalBehaviorAnnexParser.g:1664:4: ( () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )* )
                    // InternalBehaviorAnnexParser.g:1665:5: () otherlv_2= Semicolon ( (lv_actions_3_0= ruleBehaviorAction ) ) (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )*
                    {
                    // InternalBehaviorAnnexParser.g:1665:5: ()
                    // InternalBehaviorAnnexParser.g:1666:6:
                    {
                    if ( state.backtracking==0 ) {

                                              current = forceCreateModelElementAndAdd(
                                                  grammarAccess.getBehaviorActionsAccess().getBehaviorActionSequenceActionsAction_1_0_0(),
                                                  current);

                    }

                    }

                    otherlv_2=(Token)match(input,Semicolon,FollowSets000.FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          newLeafNode(otherlv_2, grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_1());

                    }
                    // InternalBehaviorAnnexParser.g:1676:5: ( (lv_actions_3_0= ruleBehaviorAction ) )
                    // InternalBehaviorAnnexParser.g:1677:6: (lv_actions_3_0= ruleBehaviorAction )
                    {
                    // InternalBehaviorAnnexParser.g:1677:6: (lv_actions_3_0= ruleBehaviorAction )
                    // InternalBehaviorAnnexParser.g:1678:7: lv_actions_3_0= ruleBehaviorAction
                    {
                    if ( state.backtracking==0 ) {

                                                  newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_0_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_42);
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

                    // InternalBehaviorAnnexParser.g:1695:5: (otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==Semicolon) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:1696:6: otherlv_4= Semicolon ( (lv_actions_5_0= ruleBehaviorAction ) )
                            {
                            otherlv_4=(Token)match(input,Semicolon,FollowSets000.FOLLOW_38); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                      newLeafNode(otherlv_4, grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_3_0());

                            }
                            // InternalBehaviorAnnexParser.g:1700:6: ( (lv_actions_5_0= ruleBehaviorAction ) )
                            // InternalBehaviorAnnexParser.g:1701:7: (lv_actions_5_0= ruleBehaviorAction )
                            {
                            // InternalBehaviorAnnexParser.g:1701:7: (lv_actions_5_0= ruleBehaviorAction )
                            // InternalBehaviorAnnexParser.g:1702:8: lv_actions_5_0= ruleBehaviorAction
                            {
                            if ( state.backtracking==0 ) {

                                                              newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_0_3_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_42);
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
                            break loop37;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:1722:4: ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* )
                    {
                    // InternalBehaviorAnnexParser.g:1722:4: ( () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )* )
                    // InternalBehaviorAnnexParser.g:1723:5: () otherlv_7= Ampersand ( (lv_actions_8_0= ruleBehaviorAction ) ) (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )*
                    {
                    // InternalBehaviorAnnexParser.g:1723:5: ()
                    // InternalBehaviorAnnexParser.g:1724:6:
                    {
                    if ( state.backtracking==0 ) {

                                              current = forceCreateModelElementAndAdd(
                                                  grammarAccess.getBehaviorActionsAccess().getBehaviorActionSetActionsAction_1_1_0(),
                                                  current);

                    }

                    }

                    otherlv_7=(Token)match(input,Ampersand,FollowSets000.FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          newLeafNode(otherlv_7, grammarAccess.getBehaviorActionsAccess().getAmpersandKeyword_1_1_1());

                    }
                    // InternalBehaviorAnnexParser.g:1734:5: ( (lv_actions_8_0= ruleBehaviorAction ) )
                    // InternalBehaviorAnnexParser.g:1735:6: (lv_actions_8_0= ruleBehaviorAction )
                    {
                    // InternalBehaviorAnnexParser.g:1735:6: (lv_actions_8_0= ruleBehaviorAction )
                    // InternalBehaviorAnnexParser.g:1736:7: lv_actions_8_0= ruleBehaviorAction
                    {
                    if ( state.backtracking==0 ) {

                                                  newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_43);
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

                    // InternalBehaviorAnnexParser.g:1753:5: (otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==Ampersand) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:1754:6: otherlv_9= Ampersand ( (lv_actions_10_0= ruleBehaviorAction ) )
                            {
                            otherlv_9=(Token)match(input,Ampersand,FollowSets000.FOLLOW_38); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                      newLeafNode(otherlv_9, grammarAccess.getBehaviorActionsAccess().getAmpersandKeyword_1_1_3_0());

                            }
                            // InternalBehaviorAnnexParser.g:1758:6: ( (lv_actions_10_0= ruleBehaviorAction ) )
                            // InternalBehaviorAnnexParser.g:1759:7: (lv_actions_10_0= ruleBehaviorAction )
                            {
                            // InternalBehaviorAnnexParser.g:1759:7: (lv_actions_10_0= ruleBehaviorAction )
                            // InternalBehaviorAnnexParser.g:1760:8: lv_actions_10_0= ruleBehaviorAction
                            {
                            if ( state.backtracking==0 ) {

                                                              newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_1_3_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_43);
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
                            break loop38;
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
    // InternalBehaviorAnnexParser.g:1784:1: entryRuleBehaviorAction returns [EObject current=null] : iv_ruleBehaviorAction= ruleBehaviorAction EOF ;
    public final EObject entryRuleBehaviorAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorAction = null;


        try {
            // InternalBehaviorAnnexParser.g:1784:55: (iv_ruleBehaviorAction= ruleBehaviorAction EOF )
            // InternalBehaviorAnnexParser.g:1785:2: iv_ruleBehaviorAction= ruleBehaviorAction EOF
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
    // InternalBehaviorAnnexParser.g:1791:1: ruleBehaviorAction returns [EObject current=null] : ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock ) ;
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
            // InternalBehaviorAnnexParser.g:1797:2: ( ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock ) )
            // InternalBehaviorAnnexParser.g:1798:2: ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock )
            {
            // InternalBehaviorAnnexParser.g:1798:2: ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock )
            int alt40=8;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1799:3: ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction )
                    {
                    // InternalBehaviorAnnexParser.g:1799:3: ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction )
                    // InternalBehaviorAnnexParser.g:1800:4: ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction
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
                    // InternalBehaviorAnnexParser.g:1811:3: this_CommunicationAction_1= ruleCommunicationAction
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
                    // InternalBehaviorAnnexParser.g:1820:3: this_TimedAction_2= ruleTimedAction
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
                    // InternalBehaviorAnnexParser.g:1829:3: this_IfStatement_3= ruleIfStatement
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
                    // InternalBehaviorAnnexParser.g:1838:3: this_ForStatement_4= ruleForStatement
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
                    // InternalBehaviorAnnexParser.g:1847:3: this_WhileStatement_5= ruleWhileStatement
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
                    // InternalBehaviorAnnexParser.g:1856:3: this_DoUntilStatement_6= ruleDoUntilStatement
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
                    // InternalBehaviorAnnexParser.g:1865:3: this_BehaviorActionBlock_7= ruleBehaviorActionBlock
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
    // InternalBehaviorAnnexParser.g:1877:1: entryRuleAssignmentAction returns [EObject current=null] : iv_ruleAssignmentAction= ruleAssignmentAction EOF ;
    public final EObject entryRuleAssignmentAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentAction = null;


        try {
            // InternalBehaviorAnnexParser.g:1877:57: (iv_ruleAssignmentAction= ruleAssignmentAction EOF )
            // InternalBehaviorAnnexParser.g:1878:2: iv_ruleAssignmentAction= ruleAssignmentAction EOF
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
    // InternalBehaviorAnnexParser.g:1884:1: ruleAssignmentAction returns [EObject current=null] : ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) ) ;
    public final EObject ruleAssignmentAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_any_3_0=null;
        EObject lv_target_0_0 = null;

        EObject lv_value_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:1890:2: ( ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) ) )
            // InternalBehaviorAnnexParser.g:1891:2: ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) )
            {
            // InternalBehaviorAnnexParser.g:1891:2: ( ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) ) )
            // InternalBehaviorAnnexParser.g:1892:3: ( (lv_target_0_0= ruleReference ) ) otherlv_1= ColonEqualsSign ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) )
            {
            // InternalBehaviorAnnexParser.g:1892:3: ( (lv_target_0_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:1893:4: (lv_target_0_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:1893:4: (lv_target_0_0= ruleReference )
            // InternalBehaviorAnnexParser.g:1894:5: lv_target_0_0= ruleReference
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getAssignmentActionAccess().getTargetReferenceParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_44);
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

            otherlv_1=(Token)match(input,ColonEqualsSign,FollowSets000.FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getAssignmentActionAccess().getColonEqualsSignKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:1915:3: ( ( (lv_value_2_0= ruleValueExpression ) ) | ( (lv_any_3_0= Any ) ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==False||LA41_0==True||LA41_0==Abs||LA41_0==Not||LA41_0==NumberSign||LA41_0==LeftParenthesis||LA41_0==PlusSign||LA41_0==HyphenMinus||LA41_0==RULE_REAL_LIT||LA41_0==RULE_INTEGER_LIT||(LA41_0>=RULE_STRING && LA41_0<=RULE_ID)) ) {
                alt41=1;
            }
            else if ( (LA41_0==Any) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:1916:4: ( (lv_value_2_0= ruleValueExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:1916:4: ( (lv_value_2_0= ruleValueExpression ) )
                    // InternalBehaviorAnnexParser.g:1917:5: (lv_value_2_0= ruleValueExpression )
                    {
                    // InternalBehaviorAnnexParser.g:1917:5: (lv_value_2_0= ruleValueExpression )
                    // InternalBehaviorAnnexParser.g:1918:6: lv_value_2_0= ruleValueExpression
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
                    // InternalBehaviorAnnexParser.g:1936:4: ( (lv_any_3_0= Any ) )
                    {
                    // InternalBehaviorAnnexParser.g:1936:4: ( (lv_any_3_0= Any ) )
                    // InternalBehaviorAnnexParser.g:1937:5: (lv_any_3_0= Any )
                    {
                    // InternalBehaviorAnnexParser.g:1937:5: (lv_any_3_0= Any )
                    // InternalBehaviorAnnexParser.g:1938:6: lv_any_3_0= Any
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
    // InternalBehaviorAnnexParser.g:1955:1: entryRuleCommunicationAction returns [EObject current=null] : iv_ruleCommunicationAction= ruleCommunicationAction EOF ;
    public final EObject entryRuleCommunicationAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommunicationAction = null;


        try {
            // InternalBehaviorAnnexParser.g:1955:60: (iv_ruleCommunicationAction= ruleCommunicationAction EOF )
            // InternalBehaviorAnnexParser.g:1956:2: iv_ruleCommunicationAction= ruleCommunicationAction EOF
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
    // InternalBehaviorAnnexParser.g:1962:1: ruleCommunicationAction returns [EObject current=null] : ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) ) ;
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
            // InternalBehaviorAnnexParser.g:1968:2: ( ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) ) )
            // InternalBehaviorAnnexParser.g:1969:2: ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) )
            {
            // InternalBehaviorAnnexParser.g:1969:2: ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) ) | ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID) ) {
                alt47=1;
            }
            else if ( (LA47_0==Asterisk) ) {
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
                    // InternalBehaviorAnnexParser.g:1970:3: ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:1970:3: ( ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) ) )
                    // InternalBehaviorAnnexParser.g:1971:4: ( (lv_reference_0_0= ruleReference ) ) ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:1971:4: ( (lv_reference_0_0= ruleReference ) )
                    // InternalBehaviorAnnexParser.g:1972:5: (lv_reference_0_0= ruleReference )
                    {
                    // InternalBehaviorAnnexParser.g:1972:5: (lv_reference_0_0= ruleReference )
                    // InternalBehaviorAnnexParser.g:1973:6: lv_reference_0_0= ruleReference
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getCommunicationActionAccess().getReferenceReferenceParserRuleCall_0_0_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_46);
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

                    // InternalBehaviorAnnexParser.g:1990:4: ( ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? ) | ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? ) | ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) ) | ( (lv_lock_12_0= ExclamationMarkLessThanSign ) ) | ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) ) )
                    int alt45=5;
                    switch ( input.LA(1) ) {
                    case ExclamationMark:
                        {
                        alt45=1;
                        }
                        break;
                    case QuestionMark:
                        {
                        alt45=2;
                        }
                        break;
                    case GreaterThanSignGreaterThanSign:
                        {
                        alt45=3;
                        }
                        break;
                    case ExclamationMarkLessThanSign:
                        {
                        alt45=4;
                        }
                        break;
                    case ExclamationMarkGreaterThanSign:
                        {
                        alt45=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }

                    switch (alt45) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:1991:5: ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? )
                            {
                            // InternalBehaviorAnnexParser.g:1991:5: ( ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )? )
                            // InternalBehaviorAnnexParser.g:1992:6: ( (lv_send_1_0= ExclamationMark ) ) (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )?
                            {
                            // InternalBehaviorAnnexParser.g:1992:6: ( (lv_send_1_0= ExclamationMark ) )
                            // InternalBehaviorAnnexParser.g:1993:7: (lv_send_1_0= ExclamationMark )
                            {
                            // InternalBehaviorAnnexParser.g:1993:7: (lv_send_1_0= ExclamationMark )
                            // InternalBehaviorAnnexParser.g:1994:8: lv_send_1_0= ExclamationMark
                            {
                            lv_send_1_0=(Token)match(input,ExclamationMark,FollowSets000.FOLLOW_47); if (state.failed) return current;
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

                            // InternalBehaviorAnnexParser.g:2006:6: (otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis )?
                            int alt43=2;
                            int LA43_0 = input.LA(1);

                            if ( (LA43_0==LeftParenthesis) ) {
                                alt43=1;
                            }
                            switch (alt43) {
                                case 1 :
                                    // InternalBehaviorAnnexParser.g:2007:7: otherlv_2= LeftParenthesis ( (lv_parameters_3_0= ruleValueExpression ) ) (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )* otherlv_6= RightParenthesis
                                    {
                                    otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_48); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                                                  newLeafNode(otherlv_2, grammarAccess.getCommunicationActionAccess().getLeftParenthesisKeyword_0_1_0_1_0());

                                    }
                                    // InternalBehaviorAnnexParser.g:2011:7: ( (lv_parameters_3_0= ruleValueExpression ) )
                                    // InternalBehaviorAnnexParser.g:2012:8: (lv_parameters_3_0= ruleValueExpression )
                                    {
                                    // InternalBehaviorAnnexParser.g:2012:8: (lv_parameters_3_0= ruleValueExpression )
                                    // InternalBehaviorAnnexParser.g:2013:9: lv_parameters_3_0= ruleValueExpression
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

                                    // InternalBehaviorAnnexParser.g:2030:7: (otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) ) )*
                                    loop42:
                                    do {
                                        int alt42=2;
                                        int LA42_0 = input.LA(1);

                                        if ( (LA42_0==Comma) ) {
                                            alt42=1;
                                        }


                                        switch (alt42) {
                                        case 1 :
                                            // InternalBehaviorAnnexParser.g:2031:8: otherlv_4= Comma ( (lv_parameters_5_0= ruleValueExpression ) )
                                            {
                                            otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_48); if (state.failed) return current;
                                            if ( state.backtracking==0 ) {

                                                                              newLeafNode(otherlv_4, grammarAccess.getCommunicationActionAccess().getCommaKeyword_0_1_0_1_2_0());

                                            }
                                            // InternalBehaviorAnnexParser.g:2035:8: ( (lv_parameters_5_0= ruleValueExpression ) )
                                            // InternalBehaviorAnnexParser.g:2036:9: (lv_parameters_5_0= ruleValueExpression )
                                            {
                                            // InternalBehaviorAnnexParser.g:2036:9: (lv_parameters_5_0= ruleValueExpression )
                                            // InternalBehaviorAnnexParser.g:2037:10: lv_parameters_5_0= ruleValueExpression
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
                                            break loop42;
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
                            // InternalBehaviorAnnexParser.g:2062:5: ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? )
                            {
                            // InternalBehaviorAnnexParser.g:2062:5: ( ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )? )
                            // InternalBehaviorAnnexParser.g:2063:6: ( (lv_dequeue_7_0= QuestionMark ) ) (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )?
                            {
                            // InternalBehaviorAnnexParser.g:2063:6: ( (lv_dequeue_7_0= QuestionMark ) )
                            // InternalBehaviorAnnexParser.g:2064:7: (lv_dequeue_7_0= QuestionMark )
                            {
                            // InternalBehaviorAnnexParser.g:2064:7: (lv_dequeue_7_0= QuestionMark )
                            // InternalBehaviorAnnexParser.g:2065:8: lv_dequeue_7_0= QuestionMark
                            {
                            lv_dequeue_7_0=(Token)match(input,QuestionMark,FollowSets000.FOLLOW_47); if (state.failed) return current;
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

                            // InternalBehaviorAnnexParser.g:2077:6: (otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis )?
                            int alt44=2;
                            int LA44_0 = input.LA(1);

                            if ( (LA44_0==LeftParenthesis) ) {
                                alt44=1;
                            }
                            switch (alt44) {
                                case 1 :
                                    // InternalBehaviorAnnexParser.g:2078:7: otherlv_8= LeftParenthesis ( (lv_target_9_0= ruleReference ) ) otherlv_10= RightParenthesis
                                    {
                                    otherlv_8=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                                                  newLeafNode(otherlv_8, grammarAccess.getCommunicationActionAccess().getLeftParenthesisKeyword_0_1_1_1_0());

                                    }
                                    // InternalBehaviorAnnexParser.g:2082:7: ( (lv_target_9_0= ruleReference ) )
                                    // InternalBehaviorAnnexParser.g:2083:8: (lv_target_9_0= ruleReference )
                                    {
                                    // InternalBehaviorAnnexParser.g:2083:8: (lv_target_9_0= ruleReference )
                                    // InternalBehaviorAnnexParser.g:2084:9: lv_target_9_0= ruleReference
                                    {
                                    if ( state.backtracking==0 ) {

                                                                          newCompositeNode(grammarAccess.getCommunicationActionAccess().getTargetReferenceParserRuleCall_0_1_1_1_1_0());

                                    }
                                    pushFollow(FollowSets000.FOLLOW_49);
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
                            // InternalBehaviorAnnexParser.g:2108:5: ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2108:5: ( (lv_freeze_11_0= GreaterThanSignGreaterThanSign ) )
                            // InternalBehaviorAnnexParser.g:2109:6: (lv_freeze_11_0= GreaterThanSignGreaterThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2109:6: (lv_freeze_11_0= GreaterThanSignGreaterThanSign )
                            // InternalBehaviorAnnexParser.g:2110:7: lv_freeze_11_0= GreaterThanSignGreaterThanSign
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
                            // InternalBehaviorAnnexParser.g:2123:5: ( (lv_lock_12_0= ExclamationMarkLessThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2123:5: ( (lv_lock_12_0= ExclamationMarkLessThanSign ) )
                            // InternalBehaviorAnnexParser.g:2124:6: (lv_lock_12_0= ExclamationMarkLessThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2124:6: (lv_lock_12_0= ExclamationMarkLessThanSign )
                            // InternalBehaviorAnnexParser.g:2125:7: lv_lock_12_0= ExclamationMarkLessThanSign
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
                            // InternalBehaviorAnnexParser.g:2138:5: ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2138:5: ( (lv_unlock_13_0= ExclamationMarkGreaterThanSign ) )
                            // InternalBehaviorAnnexParser.g:2139:6: (lv_unlock_13_0= ExclamationMarkGreaterThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2139:6: (lv_unlock_13_0= ExclamationMarkGreaterThanSign )
                            // InternalBehaviorAnnexParser.g:2140:7: lv_unlock_13_0= ExclamationMarkGreaterThanSign
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
                    // InternalBehaviorAnnexParser.g:2155:3: ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:2155:3: ( ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) ) )
                    // InternalBehaviorAnnexParser.g:2156:4: ( (lv_all_14_0= Asterisk ) ) ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:2156:4: ( (lv_all_14_0= Asterisk ) )
                    // InternalBehaviorAnnexParser.g:2157:5: (lv_all_14_0= Asterisk )
                    {
                    // InternalBehaviorAnnexParser.g:2157:5: (lv_all_14_0= Asterisk )
                    // InternalBehaviorAnnexParser.g:2158:6: lv_all_14_0= Asterisk
                    {
                    lv_all_14_0=(Token)match(input,Asterisk,FollowSets000.FOLLOW_50); if (state.failed) return current;
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

                    // InternalBehaviorAnnexParser.g:2170:4: ( ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) ) | ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) ) )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==ExclamationMarkLessThanSign) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==ExclamationMarkGreaterThanSign) ) {
                        alt46=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:2171:5: ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2171:5: ( (lv_allLock_15_0= ExclamationMarkLessThanSign ) )
                            // InternalBehaviorAnnexParser.g:2172:6: (lv_allLock_15_0= ExclamationMarkLessThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2172:6: (lv_allLock_15_0= ExclamationMarkLessThanSign )
                            // InternalBehaviorAnnexParser.g:2173:7: lv_allLock_15_0= ExclamationMarkLessThanSign
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
                            // InternalBehaviorAnnexParser.g:2186:5: ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) )
                            {
                            // InternalBehaviorAnnexParser.g:2186:5: ( (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign ) )
                            // InternalBehaviorAnnexParser.g:2187:6: (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign )
                            {
                            // InternalBehaviorAnnexParser.g:2187:6: (lv_allUnlock_16_0= ExclamationMarkGreaterThanSign )
                            // InternalBehaviorAnnexParser.g:2188:7: lv_allUnlock_16_0= ExclamationMarkGreaterThanSign
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
    // InternalBehaviorAnnexParser.g:2206:1: entryRuleTimedAction returns [EObject current=null] : iv_ruleTimedAction= ruleTimedAction EOF ;
    public final EObject entryRuleTimedAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimedAction = null;


        try {
            // InternalBehaviorAnnexParser.g:2206:52: (iv_ruleTimedAction= ruleTimedAction EOF )
            // InternalBehaviorAnnexParser.g:2207:2: iv_ruleTimedAction= ruleTimedAction EOF
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
    // InternalBehaviorAnnexParser.g:2213:1: ruleTimedAction returns [EObject current=null] : (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? ) ;
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
            // InternalBehaviorAnnexParser.g:2219:2: ( (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? ) )
            // InternalBehaviorAnnexParser.g:2220:2: (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? )
            {
            // InternalBehaviorAnnexParser.g:2220:2: (otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )? )
            // InternalBehaviorAnnexParser.g:2221:3: otherlv_0= Computation otherlv_1= LeftParenthesis ( (lv_lowerTime_2_0= ruleBehaviorTime ) ) (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )? otherlv_5= RightParenthesis (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )?
            {
            otherlv_0=(Token)match(input,Computation,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getTimedActionAccess().getComputationKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getTimedActionAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:2229:3: ( (lv_lowerTime_2_0= ruleBehaviorTime ) )
            // InternalBehaviorAnnexParser.g:2230:4: (lv_lowerTime_2_0= ruleBehaviorTime )
            {
            // InternalBehaviorAnnexParser.g:2230:4: (lv_lowerTime_2_0= ruleBehaviorTime )
            // InternalBehaviorAnnexParser.g:2231:5: lv_lowerTime_2_0= ruleBehaviorTime
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getTimedActionAccess().getLowerTimeBehaviorTimeParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_51);
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

            // InternalBehaviorAnnexParser.g:2248:3: (otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==FullStopFullStop) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2249:4: otherlv_3= FullStopFullStop ( (lv_upperTime_4_0= ruleBehaviorTime ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_3, grammarAccess.getTimedActionAccess().getFullStopFullStopKeyword_3_0());

                    }
                    // InternalBehaviorAnnexParser.g:2253:4: ( (lv_upperTime_4_0= ruleBehaviorTime ) )
                    // InternalBehaviorAnnexParser.g:2254:5: (lv_upperTime_4_0= ruleBehaviorTime )
                    {
                    // InternalBehaviorAnnexParser.g:2254:5: (lv_upperTime_4_0= ruleBehaviorTime )
                    // InternalBehaviorAnnexParser.g:2255:6: lv_upperTime_4_0= ruleBehaviorTime
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getTimedActionAccess().getUpperTimeBehaviorTimeParserRuleCall_3_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_49);
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

            otherlv_5=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_5, grammarAccess.getTimedActionAccess().getRightParenthesisKeyword_4());

            }
            // InternalBehaviorAnnexParser.g:2277:3: (otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==In) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2278:4: otherlv_6= In otherlv_7= Binding otherlv_8= LeftParenthesis ( ( ruleQCREF ) ) (otherlv_10= Comma ( ( ruleQCREF ) ) )* otherlv_12= RightParenthesis
                    {
                    otherlv_6=(Token)match(input,In,FollowSets000.FOLLOW_53); if (state.failed) return current;
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
                    // InternalBehaviorAnnexParser.g:2290:4: ( ( ruleQCREF ) )
                    // InternalBehaviorAnnexParser.g:2291:5: ( ruleQCREF )
                    {
                    // InternalBehaviorAnnexParser.g:2291:5: ( ruleQCREF )
                    // InternalBehaviorAnnexParser.g:2292:6: ruleQCREF
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

                    // InternalBehaviorAnnexParser.g:2306:4: (otherlv_10= Comma ( ( ruleQCREF ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==Comma) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:2307:5: otherlv_10= Comma ( ( ruleQCREF ) )
                            {
                            otherlv_10=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                  newLeafNode(otherlv_10, grammarAccess.getTimedActionAccess().getCommaKeyword_5_4_0());

                            }
                            // InternalBehaviorAnnexParser.g:2311:5: ( ( ruleQCREF ) )
                            // InternalBehaviorAnnexParser.g:2312:6: ( ruleQCREF )
                            {
                            // InternalBehaviorAnnexParser.g:2312:6: ( ruleQCREF )
                            // InternalBehaviorAnnexParser.g:2313:7: ruleQCREF
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
                            break loop49;
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
    // InternalBehaviorAnnexParser.g:2337:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2337:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalBehaviorAnnexParser.g:2338:2: iv_ruleIfStatement= ruleIfStatement EOF
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
    // InternalBehaviorAnnexParser.g:2344:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If ) ;
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
            // InternalBehaviorAnnexParser.g:2350:2: ( (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If ) )
            // InternalBehaviorAnnexParser.g:2351:2: (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If )
            {
            // InternalBehaviorAnnexParser.g:2351:2: (otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If )
            // InternalBehaviorAnnexParser.g:2352:3: otherlv_0= If otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_thenActions_4_0= ruleBehaviorActions ) ) ( (lv_elseIfs_5_0= ruleElseIfClause ) )* (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )? otherlv_8= End otherlv_9= If
            {
            otherlv_0=(Token)match(input,If,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:2360:3: ( (lv_condition_2_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2361:4: (lv_condition_2_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2361:4: (lv_condition_2_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2362:5: lv_condition_2_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getIfStatementAccess().getConditionValueExpressionParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_49);
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

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3());

            }
            // InternalBehaviorAnnexParser.g:2383:3: ( (lv_thenActions_4_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2384:4: (lv_thenActions_4_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2384:4: (lv_thenActions_4_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2385:5: lv_thenActions_4_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getIfStatementAccess().getThenActionsBehaviorActionsParserRuleCall_4_0());

            }
            pushFollow(FollowSets000.FOLLOW_54);
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

            // InternalBehaviorAnnexParser.g:2402:3: ( (lv_elseIfs_5_0= ruleElseIfClause ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==Elsif) ) {
                    alt51=1;
                }


                switch (alt51) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2403:4: (lv_elseIfs_5_0= ruleElseIfClause )
                    {
                    // InternalBehaviorAnnexParser.g:2403:4: (lv_elseIfs_5_0= ruleElseIfClause )
                    // InternalBehaviorAnnexParser.g:2404:5: lv_elseIfs_5_0= ruleElseIfClause
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfsElseIfClauseParserRuleCall_5_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_54);
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
                    break loop51;
                }
            } while (true);

            // InternalBehaviorAnnexParser.g:2421:3: (otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==Else) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2422:4: otherlv_6= Else ( (lv_elseActions_7_0= ruleBehaviorActions ) )
                    {
                    otherlv_6=(Token)match(input,Else,FollowSets000.FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getElseKeyword_6_0());

                    }
                    // InternalBehaviorAnnexParser.g:2426:4: ( (lv_elseActions_7_0= ruleBehaviorActions ) )
                    // InternalBehaviorAnnexParser.g:2427:5: (lv_elseActions_7_0= ruleBehaviorActions )
                    {
                    // InternalBehaviorAnnexParser.g:2427:5: (lv_elseActions_7_0= ruleBehaviorActions )
                    // InternalBehaviorAnnexParser.g:2428:6: lv_elseActions_7_0= ruleBehaviorActions
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getIfStatementAccess().getElseActionsBehaviorActionsParserRuleCall_6_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_55);
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

            otherlv_8=(Token)match(input,End,FollowSets000.FOLLOW_56); if (state.failed) return current;
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
    // InternalBehaviorAnnexParser.g:2458:1: entryRuleElseIfClause returns [EObject current=null] : iv_ruleElseIfClause= ruleElseIfClause EOF ;
    public final EObject entryRuleElseIfClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfClause = null;


        try {
            // InternalBehaviorAnnexParser.g:2458:53: (iv_ruleElseIfClause= ruleElseIfClause EOF )
            // InternalBehaviorAnnexParser.g:2459:2: iv_ruleElseIfClause= ruleElseIfClause EOF
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
    // InternalBehaviorAnnexParser.g:2465:1: ruleElseIfClause returns [EObject current=null] : (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) ) ;
    public final EObject ruleElseIfClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_actions_4_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2471:2: ( (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) ) )
            // InternalBehaviorAnnexParser.g:2472:2: (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) )
            {
            // InternalBehaviorAnnexParser.g:2472:2: (otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) ) )
            // InternalBehaviorAnnexParser.g:2473:3: otherlv_0= Elsif otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis ( (lv_actions_4_0= ruleBehaviorActions ) )
            {
            otherlv_0=(Token)match(input,Elsif,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getElseIfClauseAccess().getElsifKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getElseIfClauseAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:2481:3: ( (lv_condition_2_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2482:4: (lv_condition_2_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2482:4: (lv_condition_2_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2483:5: lv_condition_2_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getElseIfClauseAccess().getConditionValueExpressionParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_49);
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

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_3, grammarAccess.getElseIfClauseAccess().getRightParenthesisKeyword_3());

            }
            // InternalBehaviorAnnexParser.g:2504:3: ( (lv_actions_4_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2505:4: (lv_actions_4_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2505:4: (lv_actions_4_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2506:5: lv_actions_4_0= ruleBehaviorActions
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
    // InternalBehaviorAnnexParser.g:2527:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2527:53: (iv_ruleForStatement= ruleForStatement EOF )
            // InternalBehaviorAnnexParser.g:2528:2: iv_ruleForStatement= ruleForStatement EOF
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
    // InternalBehaviorAnnexParser.g:2534:1: ruleForStatement returns [EObject current=null] : ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) otherlv_4= Colon ( ( ruleQCREF ) ) otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket ) ;
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
            // InternalBehaviorAnnexParser.g:2540:2: ( ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) otherlv_4= Colon ( ( ruleQCREF ) ) otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket ) )
            // InternalBehaviorAnnexParser.g:2541:2: ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) otherlv_4= Colon ( ( ruleQCREF ) ) otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket )
            {
            // InternalBehaviorAnnexParser.g:2541:2: ( ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) otherlv_4= Colon ( ( ruleQCREF ) ) otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket )
            // InternalBehaviorAnnexParser.g:2542:3: ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) ) otherlv_2= LeftParenthesis ( (lv_variable_3_0= RULE_ID ) ) otherlv_4= Colon ( ( ruleQCREF ) ) otherlv_6= In ( (lv_values_7_0= ruleElementValues ) ) otherlv_8= RightParenthesis otherlv_9= LeftCurlyBracket ( (lv_actions_10_0= ruleBehaviorActions ) ) otherlv_11= RightCurlyBracket
            {
            // InternalBehaviorAnnexParser.g:2542:3: ( ( (lv_for_0_0= For ) ) | ( (lv_forall_1_0= Forall ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==For) ) {
                alt53=1;
            }
            else if ( (LA53_0==Forall) ) {
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
                    // InternalBehaviorAnnexParser.g:2543:4: ( (lv_for_0_0= For ) )
                    {
                    // InternalBehaviorAnnexParser.g:2543:4: ( (lv_for_0_0= For ) )
                    // InternalBehaviorAnnexParser.g:2544:5: (lv_for_0_0= For )
                    {
                    // InternalBehaviorAnnexParser.g:2544:5: (lv_for_0_0= For )
                    // InternalBehaviorAnnexParser.g:2545:6: lv_for_0_0= For
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
                    // InternalBehaviorAnnexParser.g:2558:4: ( (lv_forall_1_0= Forall ) )
                    {
                    // InternalBehaviorAnnexParser.g:2558:4: ( (lv_forall_1_0= Forall ) )
                    // InternalBehaviorAnnexParser.g:2559:5: (lv_forall_1_0= Forall )
                    {
                    // InternalBehaviorAnnexParser.g:2559:5: (lv_forall_1_0= Forall )
                    // InternalBehaviorAnnexParser.g:2560:6: lv_forall_1_0= Forall
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
            // InternalBehaviorAnnexParser.g:2577:3: ( (lv_variable_3_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:2578:4: (lv_variable_3_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:2578:4: (lv_variable_3_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:2579:5: lv_variable_3_0= RULE_ID
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
            // InternalBehaviorAnnexParser.g:2599:3: ( ( ruleQCREF ) )
            // InternalBehaviorAnnexParser.g:2600:4: ( ruleQCREF )
            {
            // InternalBehaviorAnnexParser.g:2600:4: ( ruleQCREF )
            // InternalBehaviorAnnexParser.g:2601:5: ruleQCREF
            {
            if ( state.backtracking==0 ) {

                                  if (current==null) {
                                      current = createModelElement(grammarAccess.getForStatementRule());
                                  }

            }
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getForStatementAccess().getDataClassifierComponentClassifierCrossReference_4_0());

            }
            pushFollow(FollowSets000.FOLLOW_57);
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
            // InternalBehaviorAnnexParser.g:2619:3: ( (lv_values_7_0= ruleElementValues ) )
            // InternalBehaviorAnnexParser.g:2620:4: (lv_values_7_0= ruleElementValues )
            {
            // InternalBehaviorAnnexParser.g:2620:4: (lv_values_7_0= ruleElementValues )
            // InternalBehaviorAnnexParser.g:2621:5: lv_values_7_0= ruleElementValues
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getForStatementAccess().getValuesElementValuesParserRuleCall_6_0());

            }
            pushFollow(FollowSets000.FOLLOW_49);
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

            otherlv_8=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_8, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_7());

            }
            otherlv_9=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_9, grammarAccess.getForStatementAccess().getLeftCurlyBracketKeyword_8());

            }
            // InternalBehaviorAnnexParser.g:2646:3: ( (lv_actions_10_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2647:4: (lv_actions_10_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2647:4: (lv_actions_10_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2648:5: lv_actions_10_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getForStatementAccess().getActionsBehaviorActionsParserRuleCall_9_0());

            }
            pushFollow(FollowSets000.FOLLOW_39);
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
    // InternalBehaviorAnnexParser.g:2673:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2673:55: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // InternalBehaviorAnnexParser.g:2674:2: iv_ruleWhileStatement= ruleWhileStatement EOF
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
    // InternalBehaviorAnnexParser.g:2680:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket ) ;
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
            // InternalBehaviorAnnexParser.g:2686:2: ( (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket ) )
            // InternalBehaviorAnnexParser.g:2687:2: (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket )
            {
            // InternalBehaviorAnnexParser.g:2687:2: (otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket )
            // InternalBehaviorAnnexParser.g:2688:3: otherlv_0= While otherlv_1= LeftParenthesis ( (lv_condition_2_0= ruleValueExpression ) ) otherlv_3= RightParenthesis otherlv_4= LeftCurlyBracket ( (lv_actions_5_0= ruleBehaviorActions ) ) otherlv_6= RightCurlyBracket
            {
            otherlv_0=(Token)match(input,While,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:2696:3: ( (lv_condition_2_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2697:4: (lv_condition_2_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2697:4: (lv_condition_2_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2698:5: lv_condition_2_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionValueExpressionParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_49);
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

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_3, grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_3());

            }
            otherlv_4=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_4, grammarAccess.getWhileStatementAccess().getLeftCurlyBracketKeyword_4());

            }
            // InternalBehaviorAnnexParser.g:2723:3: ( (lv_actions_5_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2724:4: (lv_actions_5_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2724:4: (lv_actions_5_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2725:5: lv_actions_5_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getWhileStatementAccess().getActionsBehaviorActionsParserRuleCall_5_0());

            }
            pushFollow(FollowSets000.FOLLOW_39);
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
    // InternalBehaviorAnnexParser.g:2750:1: entryRuleDoUntilStatement returns [EObject current=null] : iv_ruleDoUntilStatement= ruleDoUntilStatement EOF ;
    public final EObject entryRuleDoUntilStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoUntilStatement = null;


        try {
            // InternalBehaviorAnnexParser.g:2750:57: (iv_ruleDoUntilStatement= ruleDoUntilStatement EOF )
            // InternalBehaviorAnnexParser.g:2751:2: iv_ruleDoUntilStatement= ruleDoUntilStatement EOF
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
    // InternalBehaviorAnnexParser.g:2757:1: ruleDoUntilStatement returns [EObject current=null] : (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis ) ;
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
            // InternalBehaviorAnnexParser.g:2763:2: ( (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:2764:2: (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:2764:2: (otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis )
            // InternalBehaviorAnnexParser.g:2765:3: otherlv_0= Do ( (lv_actions_1_0= ruleBehaviorActions ) ) otherlv_2= Until otherlv_3= LeftParenthesis ( (lv_condition_4_0= ruleValueExpression ) ) otherlv_5= RightParenthesis
            {
            otherlv_0=(Token)match(input,Do,FollowSets000.FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getDoUntilStatementAccess().getDoKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:2769:3: ( (lv_actions_1_0= ruleBehaviorActions ) )
            // InternalBehaviorAnnexParser.g:2770:4: (lv_actions_1_0= ruleBehaviorActions )
            {
            // InternalBehaviorAnnexParser.g:2770:4: (lv_actions_1_0= ruleBehaviorActions )
            // InternalBehaviorAnnexParser.g:2771:5: lv_actions_1_0= ruleBehaviorActions
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getDoUntilStatementAccess().getActionsBehaviorActionsParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_59);
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
            otherlv_3=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_3, grammarAccess.getDoUntilStatementAccess().getLeftParenthesisKeyword_3());

            }
            // InternalBehaviorAnnexParser.g:2796:3: ( (lv_condition_4_0= ruleValueExpression ) )
            // InternalBehaviorAnnexParser.g:2797:4: (lv_condition_4_0= ruleValueExpression )
            {
            // InternalBehaviorAnnexParser.g:2797:4: (lv_condition_4_0= ruleValueExpression )
            // InternalBehaviorAnnexParser.g:2798:5: lv_condition_4_0= ruleValueExpression
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getDoUntilStatementAccess().getConditionValueExpressionParserRuleCall_4_0());

            }
            pushFollow(FollowSets000.FOLLOW_49);
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
    // InternalBehaviorAnnexParser.g:2823:1: entryRuleElementValues returns [EObject current=null] : iv_ruleElementValues= ruleElementValues EOF ;
    public final EObject entryRuleElementValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementValues = null;


        try {
            // InternalBehaviorAnnexParser.g:2823:54: (iv_ruleElementValues= ruleElementValues EOF )
            // InternalBehaviorAnnexParser.g:2824:2: iv_ruleElementValues= ruleElementValues EOF
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
    // InternalBehaviorAnnexParser.g:2830:1: ruleElementValues returns [EObject current=null] : ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? ) ;
    public final EObject ruleElementValues() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_lower_0_0 = null;

        EObject lv_upper_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2836:2: ( ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? ) )
            // InternalBehaviorAnnexParser.g:2837:2: ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:2837:2: ( ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )? )
            // InternalBehaviorAnnexParser.g:2838:3: ( (lv_lower_0_0= ruleIntegerValue ) ) (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )?
            {
            // InternalBehaviorAnnexParser.g:2838:3: ( (lv_lower_0_0= ruleIntegerValue ) )
            // InternalBehaviorAnnexParser.g:2839:4: (lv_lower_0_0= ruleIntegerValue )
            {
            // InternalBehaviorAnnexParser.g:2839:4: (lv_lower_0_0= ruleIntegerValue )
            // InternalBehaviorAnnexParser.g:2840:5: lv_lower_0_0= ruleIntegerValue
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getElementValuesAccess().getLowerIntegerValueParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_60);
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

            // InternalBehaviorAnnexParser.g:2857:3: (otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==FullStopFullStop) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2858:4: otherlv_1= FullStopFullStop ( (lv_upper_2_0= ruleIntegerValue ) )
                    {
                    otherlv_1=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_1, grammarAccess.getElementValuesAccess().getFullStopFullStopKeyword_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:2862:4: ( (lv_upper_2_0= ruleIntegerValue ) )
                    // InternalBehaviorAnnexParser.g:2863:5: (lv_upper_2_0= ruleIntegerValue )
                    {
                    // InternalBehaviorAnnexParser.g:2863:5: (lv_upper_2_0= ruleIntegerValue )
                    // InternalBehaviorAnnexParser.g:2864:6: lv_upper_2_0= ruleIntegerValue
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
    // InternalBehaviorAnnexParser.g:2886:1: entryRuleBehaviorTime returns [EObject current=null] : iv_ruleBehaviorTime= ruleBehaviorTime EOF ;
    public final EObject entryRuleBehaviorTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorTime = null;


        try {
            // InternalBehaviorAnnexParser.g:2886:53: (iv_ruleBehaviorTime= ruleBehaviorTime EOF )
            // InternalBehaviorAnnexParser.g:2887:2: iv_ruleBehaviorTime= ruleBehaviorTime EOF
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
    // InternalBehaviorAnnexParser.g:2893:1: ruleBehaviorTime returns [EObject current=null] : ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleBehaviorTime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2899:2: ( ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) ) )
            // InternalBehaviorAnnexParser.g:2900:2: ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalBehaviorAnnexParser.g:2900:2: ( ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) ) )
            // InternalBehaviorAnnexParser.g:2901:3: ( (lv_value_0_0= ruleIntegerValue ) ) ( (otherlv_1= RULE_ID ) )
            {
            // InternalBehaviorAnnexParser.g:2901:3: ( (lv_value_0_0= ruleIntegerValue ) )
            // InternalBehaviorAnnexParser.g:2902:4: (lv_value_0_0= ruleIntegerValue )
            {
            // InternalBehaviorAnnexParser.g:2902:4: (lv_value_0_0= ruleIntegerValue )
            // InternalBehaviorAnnexParser.g:2903:5: lv_value_0_0= ruleIntegerValue
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

            // InternalBehaviorAnnexParser.g:2920:3: ( (otherlv_1= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:2921:4: (otherlv_1= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:2921:4: (otherlv_1= RULE_ID )
            // InternalBehaviorAnnexParser.g:2922:5: otherlv_1= RULE_ID
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
    // InternalBehaviorAnnexParser.g:2937:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // InternalBehaviorAnnexParser.g:2937:53: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // InternalBehaviorAnnexParser.g:2938:2: iv_ruleIntegerValue= ruleIntegerValue EOF
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
    // InternalBehaviorAnnexParser.g:2944:1: ruleIntegerValue returns [EObject current=null] : (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject this_BehaviorIntegerLiteral_0 = null;

        EObject this_HashPropertyReference_1 = null;

        EObject this_ReferenceExpression_2 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2950:2: ( (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression ) )
            // InternalBehaviorAnnexParser.g:2951:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression )
            {
            // InternalBehaviorAnnexParser.g:2951:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_HashPropertyReference_1= ruleHashPropertyReference | this_ReferenceExpression_2= ruleReferenceExpression )
            int alt55=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGER_LIT:
                {
                alt55=1;
                }
                break;
            case NumberSign:
                {
                alt55=2;
                }
                break;
            case RULE_ID:
                {
                alt55=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:2952:3: this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral
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
                    // InternalBehaviorAnnexParser.g:2961:3: this_HashPropertyReference_1= ruleHashPropertyReference
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
                    // InternalBehaviorAnnexParser.g:2970:3: this_ReferenceExpression_2= ruleReferenceExpression
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
    // InternalBehaviorAnnexParser.g:2982:1: entryRuleValueExpression returns [EObject current=null] : iv_ruleValueExpression= ruleValueExpression EOF ;
    public final EObject entryRuleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:2982:56: (iv_ruleValueExpression= ruleValueExpression EOF )
            // InternalBehaviorAnnexParser.g:2983:2: iv_ruleValueExpression= ruleValueExpression EOF
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
    // InternalBehaviorAnnexParser.g:2989:1: ruleValueExpression returns [EObject current=null] : this_LogicalOrExpression_0= ruleLogicalOrExpression ;
    public final EObject ruleValueExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalOrExpression_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:2995:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression )
            // InternalBehaviorAnnexParser.g:2996:2: this_LogicalOrExpression_0= ruleLogicalOrExpression
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
    // InternalBehaviorAnnexParser.g:3007:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3007:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalBehaviorAnnexParser.g:3008:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalBehaviorAnnexParser.g:3014:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3020:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalBehaviorAnnexParser.g:3021:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:3021:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalBehaviorAnnexParser.g:3022:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_61);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_LogicalAndExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:3030:3: ( () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==Xor||LA57_0==Or) ) {
                    alt57=1;
                }


                switch (alt57) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3031:4: () ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) ) ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3031:4: ()
                    // InternalBehaviorAnnexParser.g:3032:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getLogicalOrExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3038:4: ( ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) ) )
                    // InternalBehaviorAnnexParser.g:3039:5: ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) )
                    {
                    // InternalBehaviorAnnexParser.g:3039:5: ( (lv_operator_2_1= Or | lv_operator_2_2= Xor ) )
                    // InternalBehaviorAnnexParser.g:3040:6: (lv_operator_2_1= Or | lv_operator_2_2= Xor )
                    {
                    // InternalBehaviorAnnexParser.g:3040:6: (lv_operator_2_1= Or | lv_operator_2_2= Xor )
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==Or) ) {
                        alt56=1;
                    }
                    else if ( (LA56_0==Xor) ) {
                        alt56=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 56, 0, input);

                        throw nvae;
                    }
                    switch (alt56) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:3041:7: lv_operator_2_1= Or
                            {
                            lv_operator_2_1=(Token)match(input,Or,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3052:7: lv_operator_2_2= Xor
                            {
                            lv_operator_2_2=(Token)match(input,Xor,FollowSets000.FOLLOW_48); if (state.failed) return current;
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

                    // InternalBehaviorAnnexParser.g:3065:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
                    // InternalBehaviorAnnexParser.g:3066:5: (lv_right_3_0= ruleLogicalAndExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3066:5: (lv_right_3_0= ruleLogicalAndExpression )
                    // InternalBehaviorAnnexParser.g:3067:6: lv_right_3_0= ruleLogicalAndExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_61);
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
                    break loop57;
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
    // InternalBehaviorAnnexParser.g:3089:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3089:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalBehaviorAnnexParser.g:3090:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalBehaviorAnnexParser.g:3096:1: ruleLogicalAndExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_right_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3102:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalBehaviorAnnexParser.g:3103:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:3103:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // InternalBehaviorAnnexParser.g:3104:3: this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRelationalExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_37);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_RelationalExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:3112:3: ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==And) ) {
                    alt58=1;
                }


                switch (alt58) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3113:4: () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3113:4: ()
                    // InternalBehaviorAnnexParser.g:3114:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getLogicalAndExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3120:4: ( (lv_operator_2_0= And ) )
                    // InternalBehaviorAnnexParser.g:3121:5: (lv_operator_2_0= And )
                    {
                    // InternalBehaviorAnnexParser.g:3121:5: (lv_operator_2_0= And )
                    // InternalBehaviorAnnexParser.g:3122:6: lv_operator_2_0= And
                    {
                    lv_operator_2_0=(Token)match(input,And,FollowSets000.FOLLOW_48); if (state.failed) return current;
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

                    // InternalBehaviorAnnexParser.g:3134:4: ( (lv_right_3_0= ruleRelationalExpression ) )
                    // InternalBehaviorAnnexParser.g:3135:5: (lv_right_3_0= ruleRelationalExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3135:5: (lv_right_3_0= ruleRelationalExpression )
                    // InternalBehaviorAnnexParser.g:3136:6: lv_right_3_0= ruleRelationalExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_37);
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
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalBehaviorAnnexParser.g:3158:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3158:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalBehaviorAnnexParser.g:3159:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalBehaviorAnnexParser.g:3165:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) ;
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
            // InternalBehaviorAnnexParser.g:3171:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? ) )
            // InternalBehaviorAnnexParser.g:3172:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:3172:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )? )
            // InternalBehaviorAnnexParser.g:3173:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_62);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_AdditiveExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:3181:3: ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==ExclamationMarkEqualsSign||LA60_0==LessThanSignEqualsSign||LA60_0==GreaterThanSignEqualsSign||(LA60_0>=LessThanSign && LA60_0<=GreaterThanSign)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3182:4: () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3182:4: ()
                    // InternalBehaviorAnnexParser.g:3183:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getRelationalExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3189:4: ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) ) )
                    // InternalBehaviorAnnexParser.g:3190:5: ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) )
                    {
                    // InternalBehaviorAnnexParser.g:3190:5: ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign ) )
                    // InternalBehaviorAnnexParser.g:3191:6: (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign )
                    {
                    // InternalBehaviorAnnexParser.g:3191:6: (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign | lv_operator_2_3= LessThanSign | lv_operator_2_4= LessThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= GreaterThanSignEqualsSign )
                    int alt59=6;
                    switch ( input.LA(1) ) {
                    case EqualsSign:
                        {
                        alt59=1;
                        }
                        break;
                    case ExclamationMarkEqualsSign:
                        {
                        alt59=2;
                        }
                        break;
                    case LessThanSign:
                        {
                        alt59=3;
                        }
                        break;
                    case LessThanSignEqualsSign:
                        {
                        alt59=4;
                        }
                        break;
                    case GreaterThanSign:
                        {
                        alt59=5;
                        }
                        break;
                    case GreaterThanSignEqualsSign:
                        {
                        alt59=6;
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
                            // InternalBehaviorAnnexParser.g:3192:7: lv_operator_2_1= EqualsSign
                            {
                            lv_operator_2_1=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3203:7: lv_operator_2_2= ExclamationMarkEqualsSign
                            {
                            lv_operator_2_2=(Token)match(input,ExclamationMarkEqualsSign,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3214:7: lv_operator_2_3= LessThanSign
                            {
                            lv_operator_2_3=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3225:7: lv_operator_2_4= LessThanSignEqualsSign
                            {
                            lv_operator_2_4=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3236:7: lv_operator_2_5= GreaterThanSign
                            {
                            lv_operator_2_5=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3247:7: lv_operator_2_6= GreaterThanSignEqualsSign
                            {
                            lv_operator_2_6=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_48); if (state.failed) return current;
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

                    // InternalBehaviorAnnexParser.g:3260:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
                    // InternalBehaviorAnnexParser.g:3261:5: (lv_right_3_0= ruleAdditiveExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3261:5: (lv_right_3_0= ruleAdditiveExpression )
                    // InternalBehaviorAnnexParser.g:3262:6: lv_right_3_0= ruleAdditiveExpression
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
    // InternalBehaviorAnnexParser.g:3284:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3284:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalBehaviorAnnexParser.g:3285:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalBehaviorAnnexParser.g:3291:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3297:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalBehaviorAnnexParser.g:3298:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:3298:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalBehaviorAnnexParser.g:3299:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_63);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_MultiplicativeExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:3307:3: ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==PlusSign||LA62_0==HyphenMinus) ) {
                    alt62=1;
                }


                switch (alt62) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3308:4: () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3308:4: ()
                    // InternalBehaviorAnnexParser.g:3309:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getAdditiveExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3315:4: ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) )
                    // InternalBehaviorAnnexParser.g:3316:5: ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) )
                    {
                    // InternalBehaviorAnnexParser.g:3316:5: ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) )
                    // InternalBehaviorAnnexParser.g:3317:6: (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus )
                    {
                    // InternalBehaviorAnnexParser.g:3317:6: (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==PlusSign) ) {
                        alt61=1;
                    }
                    else if ( (LA61_0==HyphenMinus) ) {
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
                            // InternalBehaviorAnnexParser.g:3318:7: lv_operator_2_1= PlusSign
                            {
                            lv_operator_2_1=(Token)match(input,PlusSign,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3329:7: lv_operator_2_2= HyphenMinus
                            {
                            lv_operator_2_2=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_48); if (state.failed) return current;
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

                    // InternalBehaviorAnnexParser.g:3342:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
                    // InternalBehaviorAnnexParser.g:3343:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3343:5: (lv_right_3_0= ruleMultiplicativeExpression )
                    // InternalBehaviorAnnexParser.g:3344:6: lv_right_3_0= ruleMultiplicativeExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_63);
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
                    break loop62;
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
    // InternalBehaviorAnnexParser.g:3366:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3366:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalBehaviorAnnexParser.g:3367:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalBehaviorAnnexParser.g:3373:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) ;
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
            // InternalBehaviorAnnexParser.g:3379:2: ( (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* ) )
            // InternalBehaviorAnnexParser.g:3380:2: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            {
            // InternalBehaviorAnnexParser.g:3380:2: (this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )* )
            // InternalBehaviorAnnexParser.g:3381:3: this_PowerExpression_0= rulePowerExpression ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getPowerExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_64);
            this_PowerExpression_0=rulePowerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_PowerExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:3389:3: ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==Mod||LA64_0==Rem||LA64_0==Asterisk||LA64_0==Solidus) ) {
                    alt64=1;
                }


                switch (alt64) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3390:4: () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) ) ( (lv_right_3_0= rulePowerExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3390:4: ()
                    // InternalBehaviorAnnexParser.g:3391:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getMultiplicativeExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3397:4: ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) ) )
                    // InternalBehaviorAnnexParser.g:3398:5: ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) )
                    {
                    // InternalBehaviorAnnexParser.g:3398:5: ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem ) )
                    // InternalBehaviorAnnexParser.g:3399:6: (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem )
                    {
                    // InternalBehaviorAnnexParser.g:3399:6: (lv_operator_2_1= Asterisk | lv_operator_2_2= Solidus | lv_operator_2_3= Mod | lv_operator_2_4= Rem )
                    int alt63=4;
                    switch ( input.LA(1) ) {
                    case Asterisk:
                        {
                        alt63=1;
                        }
                        break;
                    case Solidus:
                        {
                        alt63=2;
                        }
                        break;
                    case Mod:
                        {
                        alt63=3;
                        }
                        break;
                    case Rem:
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
                            // InternalBehaviorAnnexParser.g:3400:7: lv_operator_2_1= Asterisk
                            {
                            lv_operator_2_1=(Token)match(input,Asterisk,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3411:7: lv_operator_2_2= Solidus
                            {
                            lv_operator_2_2=(Token)match(input,Solidus,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3422:7: lv_operator_2_3= Mod
                            {
                            lv_operator_2_3=(Token)match(input,Mod,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3433:7: lv_operator_2_4= Rem
                            {
                            lv_operator_2_4=(Token)match(input,Rem,FollowSets000.FOLLOW_48); if (state.failed) return current;
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

                    // InternalBehaviorAnnexParser.g:3446:4: ( (lv_right_3_0= rulePowerExpression ) )
                    // InternalBehaviorAnnexParser.g:3447:5: (lv_right_3_0= rulePowerExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3447:5: (lv_right_3_0= rulePowerExpression )
                    // InternalBehaviorAnnexParser.g:3448:6: lv_right_3_0= rulePowerExpression
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightPowerExpressionParserRuleCall_1_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_64);
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
                    break loop64;
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
    // InternalBehaviorAnnexParser.g:3470:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3470:56: (iv_rulePowerExpression= rulePowerExpression EOF )
            // InternalBehaviorAnnexParser.g:3471:2: iv_rulePowerExpression= rulePowerExpression EOF
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
    // InternalBehaviorAnnexParser.g:3477:1: rulePowerExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )? ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_right_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3483:2: ( (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )? ) )
            // InternalBehaviorAnnexParser.g:3484:2: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:3484:2: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )? )
            // InternalBehaviorAnnexParser.g:3485:3: this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

                          newCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryExpressionParserRuleCall_0());

            }
            pushFollow(FollowSets000.FOLLOW_65);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current = this_UnaryExpression_0;
                          afterParserOrEnumRuleCall();

            }
            // InternalBehaviorAnnexParser.g:3493:3: ( () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==AsteriskAsterisk) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3494:4: () ( (lv_operator_2_0= AsteriskAsterisk ) ) ( (lv_right_3_0= rulePowerExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3494:4: ()
                    // InternalBehaviorAnnexParser.g:3495:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElementAndSet(
                                              grammarAccess.getPowerExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3501:4: ( (lv_operator_2_0= AsteriskAsterisk ) )
                    // InternalBehaviorAnnexParser.g:3502:5: (lv_operator_2_0= AsteriskAsterisk )
                    {
                    // InternalBehaviorAnnexParser.g:3502:5: (lv_operator_2_0= AsteriskAsterisk )
                    // InternalBehaviorAnnexParser.g:3503:6: lv_operator_2_0= AsteriskAsterisk
                    {
                    lv_operator_2_0=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_48); if (state.failed) return current;
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

                    // InternalBehaviorAnnexParser.g:3515:4: ( (lv_right_3_0= rulePowerExpression ) )
                    // InternalBehaviorAnnexParser.g:3516:5: (lv_right_3_0= rulePowerExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3516:5: (lv_right_3_0= rulePowerExpression )
                    // InternalBehaviorAnnexParser.g:3517:6: lv_right_3_0= rulePowerExpression
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
    // InternalBehaviorAnnexParser.g:3539:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3539:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalBehaviorAnnexParser.g:3540:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalBehaviorAnnexParser.g:3546:1: ruleUnaryExpression returns [EObject current=null] : ( ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression ) ;
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
            // InternalBehaviorAnnexParser.g:3552:2: ( ( ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression ) )
            // InternalBehaviorAnnexParser.g:3553:2: ( ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression )
            {
            // InternalBehaviorAnnexParser.g:3553:2: ( ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==Abs||LA67_0==Not||LA67_0==PlusSign||LA67_0==HyphenMinus) ) {
                alt67=1;
            }
            else if ( (LA67_0==False||LA67_0==True||LA67_0==NumberSign||LA67_0==LeftParenthesis||LA67_0==RULE_REAL_LIT||LA67_0==RULE_INTEGER_LIT||(LA67_0>=RULE_STRING && LA67_0<=RULE_ID)) ) {
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
                    // InternalBehaviorAnnexParser.g:3554:3: ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:3554:3: ( () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) )
                    // InternalBehaviorAnnexParser.g:3555:4: () ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) )
                    {
                    // InternalBehaviorAnnexParser.g:3555:4: ()
                    // InternalBehaviorAnnexParser.g:3556:5:
                    {
                    if ( state.backtracking==0 ) {

                                          current = forceCreateModelElement(
                                              grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_0_0(),
                                              current);

                    }

                    }

                    // InternalBehaviorAnnexParser.g:3562:4: ( ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) ) )
                    // InternalBehaviorAnnexParser.g:3563:5: ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) )
                    {
                    // InternalBehaviorAnnexParser.g:3563:5: ( (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not ) )
                    // InternalBehaviorAnnexParser.g:3564:6: (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not )
                    {
                    // InternalBehaviorAnnexParser.g:3564:6: (lv_operator_1_1= PlusSign | lv_operator_1_2= HyphenMinus | lv_operator_1_3= Abs | lv_operator_1_4= Not )
                    int alt66=4;
                    switch ( input.LA(1) ) {
                    case PlusSign:
                        {
                        alt66=1;
                        }
                        break;
                    case HyphenMinus:
                        {
                        alt66=2;
                        }
                        break;
                    case Abs:
                        {
                        alt66=3;
                        }
                        break;
                    case Not:
                        {
                        alt66=4;
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
                            // InternalBehaviorAnnexParser.g:3565:7: lv_operator_1_1= PlusSign
                            {
                            lv_operator_1_1=(Token)match(input,PlusSign,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3576:7: lv_operator_1_2= HyphenMinus
                            {
                            lv_operator_1_2=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3587:7: lv_operator_1_3= Abs
                            {
                            lv_operator_1_3=(Token)match(input,Abs,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
                            // InternalBehaviorAnnexParser.g:3598:7: lv_operator_1_4= Not
                            {
                            lv_operator_1_4=(Token)match(input,Not,FollowSets000.FOLLOW_48); if (state.failed) return current;
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

                    // InternalBehaviorAnnexParser.g:3611:4: ( (lv_operand_2_0= ruleUnaryExpression ) )
                    // InternalBehaviorAnnexParser.g:3612:5: (lv_operand_2_0= ruleUnaryExpression )
                    {
                    // InternalBehaviorAnnexParser.g:3612:5: (lv_operand_2_0= ruleUnaryExpression )
                    // InternalBehaviorAnnexParser.g:3613:6: lv_operand_2_0= ruleUnaryExpression
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
                    // InternalBehaviorAnnexParser.g:3632:3: this_PrimaryExpression_3= rulePrimaryExpression
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
    // InternalBehaviorAnnexParser.g:3644:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3644:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalBehaviorAnnexParser.g:3645:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalBehaviorAnnexParser.g:3651:1: rulePrimaryExpression returns [EObject current=null] : (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_ValueConstant_0 = null;

        EObject this_ReferenceExpression_1 = null;

        EObject this_ValueExpression_3 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3657:2: ( (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis ) ) )
            // InternalBehaviorAnnexParser.g:3658:2: (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis ) )
            {
            // InternalBehaviorAnnexParser.g:3658:2: (this_ValueConstant_0= ruleValueConstant | this_ReferenceExpression_1= ruleReferenceExpression | (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis ) )
            int alt68=3;
            switch ( input.LA(1) ) {
            case False:
            case True:
            case NumberSign:
            case RULE_REAL_LIT:
            case RULE_INTEGER_LIT:
            case RULE_STRING:
                {
                alt68=1;
                }
                break;
            case RULE_ID:
                {
                alt68=2;
                }
                break;
            case LeftParenthesis:
                {
                alt68=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3659:3: this_ValueConstant_0= ruleValueConstant
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
                    // InternalBehaviorAnnexParser.g:3668:3: this_ReferenceExpression_1= ruleReferenceExpression
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
                    // InternalBehaviorAnnexParser.g:3677:3: (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis )
                    {
                    // InternalBehaviorAnnexParser.g:3677:3: (otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis )
                    // InternalBehaviorAnnexParser.g:3678:4: otherlv_2= LeftParenthesis this_ValueExpression_3= ruleValueExpression otherlv_4= RightParenthesis
                    {
                    otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_0());

                    }
                    if ( state.backtracking==0 ) {

                                      newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueExpressionParserRuleCall_2_1());

                    }
                    pushFollow(FollowSets000.FOLLOW_49);
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
    // InternalBehaviorAnnexParser.g:3699:1: entryRuleValueConstant returns [EObject current=null] : iv_ruleValueConstant= ruleValueConstant EOF ;
    public final EObject entryRuleValueConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueConstant = null;


        try {
            // InternalBehaviorAnnexParser.g:3699:54: (iv_ruleValueConstant= ruleValueConstant EOF )
            // InternalBehaviorAnnexParser.g:3700:2: iv_ruleValueConstant= ruleValueConstant EOF
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
    // InternalBehaviorAnnexParser.g:3706:1: ruleValueConstant returns [EObject current=null] : (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference ) ;
    public final EObject ruleValueConstant() throws RecognitionException {
        EObject current = null;

        EObject this_BehaviorIntegerLiteral_0 = null;

        EObject this_BehaviorRealLiteral_1 = null;

        EObject this_BehaviorStringLiteral_2 = null;

        EObject this_BehaviorBooleanLiteral_3 = null;

        EObject this_HashPropertyReference_4 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3712:2: ( (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference ) )
            // InternalBehaviorAnnexParser.g:3713:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference )
            {
            // InternalBehaviorAnnexParser.g:3713:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral | this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral | this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral | this_HashPropertyReference_4= ruleHashPropertyReference )
            int alt69=5;
            switch ( input.LA(1) ) {
            case RULE_INTEGER_LIT:
                {
                alt69=1;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt69=2;
                }
                break;
            case RULE_STRING:
                {
                alt69=3;
                }
                break;
            case False:
            case True:
                {
                alt69=4;
                }
                break;
            case NumberSign:
                {
                alt69=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3714:3: this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral
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
                    // InternalBehaviorAnnexParser.g:3723:3: this_BehaviorRealLiteral_1= ruleBehaviorRealLiteral
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
                    // InternalBehaviorAnnexParser.g:3732:3: this_BehaviorStringLiteral_2= ruleBehaviorStringLiteral
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
                    // InternalBehaviorAnnexParser.g:3741:3: this_BehaviorBooleanLiteral_3= ruleBehaviorBooleanLiteral
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
                    // InternalBehaviorAnnexParser.g:3750:3: this_HashPropertyReference_4= ruleHashPropertyReference
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
    // InternalBehaviorAnnexParser.g:3762:1: entryRuleBehaviorIntegerLiteral returns [EObject current=null] : iv_ruleBehaviorIntegerLiteral= ruleBehaviorIntegerLiteral EOF ;
    public final EObject entryRuleBehaviorIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorIntegerLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:3762:63: (iv_ruleBehaviorIntegerLiteral= ruleBehaviorIntegerLiteral EOF )
            // InternalBehaviorAnnexParser.g:3763:2: iv_ruleBehaviorIntegerLiteral= ruleBehaviorIntegerLiteral EOF
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
    // InternalBehaviorAnnexParser.g:3769:1: ruleBehaviorIntegerLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGER_LIT ) ) ;
    public final EObject ruleBehaviorIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3775:2: ( ( (lv_value_0_0= RULE_INTEGER_LIT ) ) )
            // InternalBehaviorAnnexParser.g:3776:2: ( (lv_value_0_0= RULE_INTEGER_LIT ) )
            {
            // InternalBehaviorAnnexParser.g:3776:2: ( (lv_value_0_0= RULE_INTEGER_LIT ) )
            // InternalBehaviorAnnexParser.g:3777:3: (lv_value_0_0= RULE_INTEGER_LIT )
            {
            // InternalBehaviorAnnexParser.g:3777:3: (lv_value_0_0= RULE_INTEGER_LIT )
            // InternalBehaviorAnnexParser.g:3778:4: lv_value_0_0= RULE_INTEGER_LIT
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
    // InternalBehaviorAnnexParser.g:3797:1: entryRuleBehaviorRealLiteral returns [EObject current=null] : iv_ruleBehaviorRealLiteral= ruleBehaviorRealLiteral EOF ;
    public final EObject entryRuleBehaviorRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorRealLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:3797:60: (iv_ruleBehaviorRealLiteral= ruleBehaviorRealLiteral EOF )
            // InternalBehaviorAnnexParser.g:3798:2: iv_ruleBehaviorRealLiteral= ruleBehaviorRealLiteral EOF
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
    // InternalBehaviorAnnexParser.g:3804:1: ruleBehaviorRealLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_REAL_LIT ) ) ;
    public final EObject ruleBehaviorRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3810:2: ( ( (lv_value_0_0= RULE_REAL_LIT ) ) )
            // InternalBehaviorAnnexParser.g:3811:2: ( (lv_value_0_0= RULE_REAL_LIT ) )
            {
            // InternalBehaviorAnnexParser.g:3811:2: ( (lv_value_0_0= RULE_REAL_LIT ) )
            // InternalBehaviorAnnexParser.g:3812:3: (lv_value_0_0= RULE_REAL_LIT )
            {
            // InternalBehaviorAnnexParser.g:3812:3: (lv_value_0_0= RULE_REAL_LIT )
            // InternalBehaviorAnnexParser.g:3813:4: lv_value_0_0= RULE_REAL_LIT
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
    // InternalBehaviorAnnexParser.g:3832:1: entryRuleBehaviorStringLiteral returns [EObject current=null] : iv_ruleBehaviorStringLiteral= ruleBehaviorStringLiteral EOF ;
    public final EObject entryRuleBehaviorStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorStringLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:3832:62: (iv_ruleBehaviorStringLiteral= ruleBehaviorStringLiteral EOF )
            // InternalBehaviorAnnexParser.g:3833:2: iv_ruleBehaviorStringLiteral= ruleBehaviorStringLiteral EOF
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
    // InternalBehaviorAnnexParser.g:3839:1: ruleBehaviorStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleBehaviorStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3845:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalBehaviorAnnexParser.g:3846:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalBehaviorAnnexParser.g:3846:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalBehaviorAnnexParser.g:3847:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalBehaviorAnnexParser.g:3847:3: (lv_value_0_0= RULE_STRING )
            // InternalBehaviorAnnexParser.g:3848:4: lv_value_0_0= RULE_STRING
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
    // InternalBehaviorAnnexParser.g:3867:1: entryRuleBehaviorBooleanLiteral returns [EObject current=null] : iv_ruleBehaviorBooleanLiteral= ruleBehaviorBooleanLiteral EOF ;
    public final EObject entryRuleBehaviorBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBehaviorBooleanLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:3867:63: (iv_ruleBehaviorBooleanLiteral= ruleBehaviorBooleanLiteral EOF )
            // InternalBehaviorAnnexParser.g:3868:2: iv_ruleBehaviorBooleanLiteral= ruleBehaviorBooleanLiteral EOF
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
    // InternalBehaviorAnnexParser.g:3874:1: ruleBehaviorBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBehaviorBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:3880:2: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalBehaviorAnnexParser.g:3881:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalBehaviorAnnexParser.g:3881:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalBehaviorAnnexParser.g:3882:3: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalBehaviorAnnexParser.g:3882:3: ()
            // InternalBehaviorAnnexParser.g:3883:4:
            {
            if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getBehaviorBooleanLiteralAccess().getBehaviorBooleanLiteralAction_0(),
                                  current);

            }

            }

            // InternalBehaviorAnnexParser.g:3889:3: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==True) ) {
                alt70=1;
            }
            else if ( (LA70_0==False) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3890:4: ( (lv_value_1_0= True ) )
                    {
                    // InternalBehaviorAnnexParser.g:3890:4: ( (lv_value_1_0= True ) )
                    // InternalBehaviorAnnexParser.g:3891:5: (lv_value_1_0= True )
                    {
                    // InternalBehaviorAnnexParser.g:3891:5: (lv_value_1_0= True )
                    // InternalBehaviorAnnexParser.g:3892:6: lv_value_1_0= True
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
                    // InternalBehaviorAnnexParser.g:3905:4: otherlv_2= False
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
    // InternalBehaviorAnnexParser.g:3914:1: entryRuleReferenceExpression returns [EObject current=null] : iv_ruleReferenceExpression= ruleReferenceExpression EOF ;
    public final EObject entryRuleReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:3914:60: (iv_ruleReferenceExpression= ruleReferenceExpression EOF )
            // InternalBehaviorAnnexParser.g:3915:2: iv_ruleReferenceExpression= ruleReferenceExpression EOF
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
    // InternalBehaviorAnnexParser.g:3921:1: ruleReferenceExpression returns [EObject current=null] : ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )? ) ;
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
            // InternalBehaviorAnnexParser.g:3927:2: ( ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )? ) )
            // InternalBehaviorAnnexParser.g:3928:2: ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:3928:2: ( ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )? )
            // InternalBehaviorAnnexParser.g:3929:3: ( (lv_reference_0_0= ruleReference ) ) ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )?
            {
            // InternalBehaviorAnnexParser.g:3929:3: ( (lv_reference_0_0= ruleReference ) )
            // InternalBehaviorAnnexParser.g:3930:4: (lv_reference_0_0= ruleReference )
            {
            // InternalBehaviorAnnexParser.g:3930:4: (lv_reference_0_0= ruleReference )
            // InternalBehaviorAnnexParser.g:3931:5: lv_reference_0_0= ruleReference
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getReferenceExpressionAccess().getReferenceReferenceParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_66);
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

            // InternalBehaviorAnnexParser.g:3948:3: ( ( (lv_property_1_0= rulePropertyReferenceTail ) ) | ( (lv_dequeue_2_0= QuestionMark ) ) | (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) ) )?
            int alt72=4;
            switch ( input.LA(1) ) {
                case NumberSign:
                    {
                    alt72=1;
                    }
                    break;
                case QuestionMark:
                    {
                    alt72=2;
                    }
                    break;
                case Apostrophe:
                    {
                    alt72=3;
                    }
                    break;
            }

            switch (alt72) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:3949:4: ( (lv_property_1_0= rulePropertyReferenceTail ) )
                    {
                    // InternalBehaviorAnnexParser.g:3949:4: ( (lv_property_1_0= rulePropertyReferenceTail ) )
                    // InternalBehaviorAnnexParser.g:3950:5: (lv_property_1_0= rulePropertyReferenceTail )
                    {
                    // InternalBehaviorAnnexParser.g:3950:5: (lv_property_1_0= rulePropertyReferenceTail )
                    // InternalBehaviorAnnexParser.g:3951:6: lv_property_1_0= rulePropertyReferenceTail
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
                    // InternalBehaviorAnnexParser.g:3969:4: ( (lv_dequeue_2_0= QuestionMark ) )
                    {
                    // InternalBehaviorAnnexParser.g:3969:4: ( (lv_dequeue_2_0= QuestionMark ) )
                    // InternalBehaviorAnnexParser.g:3970:5: (lv_dequeue_2_0= QuestionMark )
                    {
                    // InternalBehaviorAnnexParser.g:3970:5: (lv_dequeue_2_0= QuestionMark )
                    // InternalBehaviorAnnexParser.g:3971:6: lv_dequeue_2_0= QuestionMark
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
                    // InternalBehaviorAnnexParser.g:3984:4: (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:3984:4: (otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) ) )
                    // InternalBehaviorAnnexParser.g:3985:5: otherlv_3= Apostrophe ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) )
                    {
                    otherlv_3=(Token)match(input,Apostrophe,FollowSets000.FOLLOW_67); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          newLeafNode(otherlv_3, grammarAccess.getReferenceExpressionAccess().getApostropheKeyword_1_2_0());

                    }
                    // InternalBehaviorAnnexParser.g:3989:5: ( ( (lv_count_4_0= Count ) ) | ( (lv_fresh_5_0= Fresh ) ) )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==Count) ) {
                        alt71=1;
                    }
                    else if ( (LA71_0==Fresh) ) {
                        alt71=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:3990:6: ( (lv_count_4_0= Count ) )
                            {
                            // InternalBehaviorAnnexParser.g:3990:6: ( (lv_count_4_0= Count ) )
                            // InternalBehaviorAnnexParser.g:3991:7: (lv_count_4_0= Count )
                            {
                            // InternalBehaviorAnnexParser.g:3991:7: (lv_count_4_0= Count )
                            // InternalBehaviorAnnexParser.g:3992:8: lv_count_4_0= Count
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
                            // InternalBehaviorAnnexParser.g:4005:6: ( (lv_fresh_5_0= Fresh ) )
                            {
                            // InternalBehaviorAnnexParser.g:4005:6: ( (lv_fresh_5_0= Fresh ) )
                            // InternalBehaviorAnnexParser.g:4006:7: (lv_fresh_5_0= Fresh )
                            {
                            // InternalBehaviorAnnexParser.g:4006:7: (lv_fresh_5_0= Fresh )
                            // InternalBehaviorAnnexParser.g:4007:8: lv_fresh_5_0= Fresh
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
    // InternalBehaviorAnnexParser.g:4026:1: entryRuleHashPropertyReference returns [EObject current=null] : iv_ruleHashPropertyReference= ruleHashPropertyReference EOF ;
    public final EObject entryRuleHashPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHashPropertyReference = null;


        try {
            // InternalBehaviorAnnexParser.g:4026:62: (iv_ruleHashPropertyReference= ruleHashPropertyReference EOF )
            // InternalBehaviorAnnexParser.g:4027:2: iv_ruleHashPropertyReference= ruleHashPropertyReference EOF
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
    // InternalBehaviorAnnexParser.g:4033:1: ruleHashPropertyReference returns [EObject current=null] : (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) ;
    public final EObject ruleHashPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_property_1_0 = null;

        EObject lv_indexes_2_0 = null;

        EObject lv_fields_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4039:2: ( (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) )
            // InternalBehaviorAnnexParser.g:4040:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            {
            // InternalBehaviorAnnexParser.g:4040:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            // InternalBehaviorAnnexParser.g:4041:3: otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            {
            otherlv_0=(Token)match(input,NumberSign,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getHashPropertyReferenceAccess().getNumberSignKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:4045:3: ( (lv_property_1_0= ruleQualifiedName ) )
            // InternalBehaviorAnnexParser.g:4046:4: (lv_property_1_0= ruleQualifiedName )
            {
            // InternalBehaviorAnnexParser.g:4046:4: (lv_property_1_0= ruleQualifiedName )
            // InternalBehaviorAnnexParser.g:4047:5: lv_property_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getPropertyQualifiedNameParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_68);
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

            // InternalBehaviorAnnexParser.g:4064:3: ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==LeftSquareBracket) ) {
                    alt73=1;
                }


                switch (alt73) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4065:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    {
                    // InternalBehaviorAnnexParser.g:4065:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    // InternalBehaviorAnnexParser.g:4066:5: lv_indexes_2_0= rulePropertyArrayIndex
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getIndexesPropertyArrayIndexParserRuleCall_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_68);
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
                    break loop73;
                }
            } while (true);

            // InternalBehaviorAnnexParser.g:4083:3: ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==FullStop) ) {
                    alt74=1;
                }


                switch (alt74) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4084:4: (lv_fields_3_0= ruleNamedPropertyField )
                    {
                    // InternalBehaviorAnnexParser.g:4084:4: (lv_fields_3_0= ruleNamedPropertyField )
                    // InternalBehaviorAnnexParser.g:4085:5: lv_fields_3_0= ruleNamedPropertyField
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getFieldsNamedPropertyFieldParserRuleCall_3_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_69);
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
    // $ANTLR end "ruleHashPropertyReference"


    // $ANTLR start "entryRulePropertyReferenceTail"
    // InternalBehaviorAnnexParser.g:4106:1: entryRulePropertyReferenceTail returns [EObject current=null] : iv_rulePropertyReferenceTail= rulePropertyReferenceTail EOF ;
    public final EObject entryRulePropertyReferenceTail() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyReferenceTail = null;


        try {
            // InternalBehaviorAnnexParser.g:4106:62: (iv_rulePropertyReferenceTail= rulePropertyReferenceTail EOF )
            // InternalBehaviorAnnexParser.g:4107:2: iv_rulePropertyReferenceTail= rulePropertyReferenceTail EOF
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
    // InternalBehaviorAnnexParser.g:4113:1: rulePropertyReferenceTail returns [EObject current=null] : (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) ;
    public final EObject rulePropertyReferenceTail() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_property_1_0 = null;

        EObject lv_indexes_2_0 = null;

        EObject lv_fields_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4119:2: ( (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* ) )
            // InternalBehaviorAnnexParser.g:4120:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            {
            // InternalBehaviorAnnexParser.g:4120:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )* )
            // InternalBehaviorAnnexParser.g:4121:3: otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            {
            otherlv_0=(Token)match(input,NumberSign,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getPropertyReferenceTailAccess().getNumberSignKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:4125:3: ( (lv_property_1_0= ruleQualifiedName ) )
            // InternalBehaviorAnnexParser.g:4126:4: (lv_property_1_0= ruleQualifiedName )
            {
            // InternalBehaviorAnnexParser.g:4126:4: (lv_property_1_0= ruleQualifiedName )
            // InternalBehaviorAnnexParser.g:4127:5: lv_property_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getPropertyQualifiedNameParserRuleCall_1_0());

            }
            pushFollow(FollowSets000.FOLLOW_68);
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

            // InternalBehaviorAnnexParser.g:4144:3: ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==LeftSquareBracket) ) {
                    alt75=1;
                }


                switch (alt75) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4145:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    {
                    // InternalBehaviorAnnexParser.g:4145:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    // InternalBehaviorAnnexParser.g:4146:5: lv_indexes_2_0= rulePropertyArrayIndex
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getIndexesPropertyArrayIndexParserRuleCall_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_68);
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
                    break loop75;
                }
            } while (true);

            // InternalBehaviorAnnexParser.g:4163:3: ( (lv_fields_3_0= ruleNamedPropertyField ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==FullStop) ) {
                    alt76=1;
                }


                switch (alt76) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4164:4: (lv_fields_3_0= ruleNamedPropertyField )
                    {
                    // InternalBehaviorAnnexParser.g:4164:4: (lv_fields_3_0= ruleNamedPropertyField )
                    // InternalBehaviorAnnexParser.g:4165:5: lv_fields_3_0= ruleNamedPropertyField
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getFieldsNamedPropertyFieldParserRuleCall_3_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_69);
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
                    break loop76;
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
    // InternalBehaviorAnnexParser.g:4186:1: entryRuleNamedPropertyField returns [EObject current=null] : iv_ruleNamedPropertyField= ruleNamedPropertyField EOF ;
    public final EObject entryRuleNamedPropertyField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedPropertyField = null;


        try {
            // InternalBehaviorAnnexParser.g:4186:59: (iv_ruleNamedPropertyField= ruleNamedPropertyField EOF )
            // InternalBehaviorAnnexParser.g:4187:2: iv_ruleNamedPropertyField= ruleNamedPropertyField EOF
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
    // InternalBehaviorAnnexParser.g:4193:1: ruleNamedPropertyField returns [EObject current=null] : (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ) ;
    public final EObject ruleNamedPropertyField() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_indexes_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4199:2: ( (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* ) )
            // InternalBehaviorAnnexParser.g:4200:2: (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* )
            {
            // InternalBehaviorAnnexParser.g:4200:2: (otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )* )
            // InternalBehaviorAnnexParser.g:4201:3: otherlv_0= FullStop ( (lv_name_1_0= RULE_ID ) ) ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            {
            otherlv_0=(Token)match(input,FullStop,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getNamedPropertyFieldAccess().getFullStopKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:4205:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:4206:4: (lv_name_1_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:4206:4: (lv_name_1_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:4207:5: lv_name_1_0= RULE_ID
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

            // InternalBehaviorAnnexParser.g:4223:3: ( (lv_indexes_2_0= rulePropertyArrayIndex ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==LeftSquareBracket) ) {
                    alt77=1;
                }


                switch (alt77) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4224:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    {
                    // InternalBehaviorAnnexParser.g:4224:4: (lv_indexes_2_0= rulePropertyArrayIndex )
                    // InternalBehaviorAnnexParser.g:4225:5: lv_indexes_2_0= rulePropertyArrayIndex
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
                    break loop77;
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
    // InternalBehaviorAnnexParser.g:4246:1: entryRulePropertyArrayIndex returns [EObject current=null] : iv_rulePropertyArrayIndex= rulePropertyArrayIndex EOF ;
    public final EObject entryRulePropertyArrayIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyArrayIndex = null;


        try {
            // InternalBehaviorAnnexParser.g:4246:59: (iv_rulePropertyArrayIndex= rulePropertyArrayIndex EOF )
            // InternalBehaviorAnnexParser.g:4247:2: iv_rulePropertyArrayIndex= rulePropertyArrayIndex EOF
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
    // InternalBehaviorAnnexParser.g:4253:1: rulePropertyArrayIndex returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket ) ;
    public final EObject rulePropertyArrayIndex() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4259:2: ( (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:4260:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:4260:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:4261:3: otherlv_0= LeftSquareBracket ( (lv_value_1_0= rulePropertyIndexValue ) ) otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getPropertyArrayIndexAccess().getLeftSquareBracketKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:4265:3: ( (lv_value_1_0= rulePropertyIndexValue ) )
            // InternalBehaviorAnnexParser.g:4266:4: (lv_value_1_0= rulePropertyIndexValue )
            {
            // InternalBehaviorAnnexParser.g:4266:4: (lv_value_1_0= rulePropertyIndexValue )
            // InternalBehaviorAnnexParser.g:4267:5: lv_value_1_0= rulePropertyIndexValue
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
    // InternalBehaviorAnnexParser.g:4292:1: entryRulePropertyIndexValue returns [EObject current=null] : iv_rulePropertyIndexValue= rulePropertyIndexValue EOF ;
    public final EObject entryRulePropertyIndexValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyIndexValue = null;


        try {
            // InternalBehaviorAnnexParser.g:4292:59: (iv_rulePropertyIndexValue= rulePropertyIndexValue EOF )
            // InternalBehaviorAnnexParser.g:4293:2: iv_rulePropertyIndexValue= rulePropertyIndexValue EOF
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
    // InternalBehaviorAnnexParser.g:4299:1: rulePropertyIndexValue returns [EObject current=null] : (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression ) ;
    public final EObject rulePropertyIndexValue() throws RecognitionException {
        EObject current = null;

        EObject this_BehaviorIntegerLiteral_0 = null;

        EObject this_PropertyIndexPropertyReference_1 = null;

        EObject this_UnindexedReferenceExpression_2 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4305:2: ( (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression ) )
            // InternalBehaviorAnnexParser.g:4306:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression )
            {
            // InternalBehaviorAnnexParser.g:4306:2: (this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral | this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference | this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression )
            int alt78=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGER_LIT:
                {
                alt78=1;
                }
                break;
            case NumberSign:
                {
                alt78=2;
                }
                break;
            case RULE_ID:
                {
                alt78=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4307:3: this_BehaviorIntegerLiteral_0= ruleBehaviorIntegerLiteral
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
                    // InternalBehaviorAnnexParser.g:4316:3: this_PropertyIndexPropertyReference_1= rulePropertyIndexPropertyReference
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
                    // InternalBehaviorAnnexParser.g:4325:3: this_UnindexedReferenceExpression_2= ruleUnindexedReferenceExpression
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
    // InternalBehaviorAnnexParser.g:4337:1: entryRulePropertyIndexPropertyReference returns [EObject current=null] : iv_rulePropertyIndexPropertyReference= rulePropertyIndexPropertyReference EOF ;
    public final EObject entryRulePropertyIndexPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyIndexPropertyReference = null;


        try {
            // InternalBehaviorAnnexParser.g:4337:71: (iv_rulePropertyIndexPropertyReference= rulePropertyIndexPropertyReference EOF )
            // InternalBehaviorAnnexParser.g:4338:2: iv_rulePropertyIndexPropertyReference= rulePropertyIndexPropertyReference EOF
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
    // InternalBehaviorAnnexParser.g:4344:1: rulePropertyIndexPropertyReference returns [EObject current=null] : (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ) ;
    public final EObject rulePropertyIndexPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_property_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4350:2: ( (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) ) )
            // InternalBehaviorAnnexParser.g:4351:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) )
            {
            // InternalBehaviorAnnexParser.g:4351:2: (otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) ) )
            // InternalBehaviorAnnexParser.g:4352:3: otherlv_0= NumberSign ( (lv_property_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,NumberSign,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getPropertyIndexPropertyReferenceAccess().getNumberSignKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:4356:3: ( (lv_property_1_0= ruleQualifiedName ) )
            // InternalBehaviorAnnexParser.g:4357:4: (lv_property_1_0= ruleQualifiedName )
            {
            // InternalBehaviorAnnexParser.g:4357:4: (lv_property_1_0= ruleQualifiedName )
            // InternalBehaviorAnnexParser.g:4358:5: lv_property_1_0= ruleQualifiedName
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
    // InternalBehaviorAnnexParser.g:4379:1: entryRuleUnindexedReferenceExpression returns [EObject current=null] : iv_ruleUnindexedReferenceExpression= ruleUnindexedReferenceExpression EOF ;
    public final EObject entryRuleUnindexedReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReferenceExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:4379:69: (iv_ruleUnindexedReferenceExpression= ruleUnindexedReferenceExpression EOF )
            // InternalBehaviorAnnexParser.g:4380:2: iv_ruleUnindexedReferenceExpression= ruleUnindexedReferenceExpression EOF
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
    // InternalBehaviorAnnexParser.g:4386:1: ruleUnindexedReferenceExpression returns [EObject current=null] : ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )? ) ;
    public final EObject ruleUnindexedReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token lv_dequeue_1_0=null;
        Token otherlv_2=null;
        Token lv_count_3_0=null;
        Token lv_fresh_4_0=null;
        EObject lv_reference_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4392:2: ( ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )? ) )
            // InternalBehaviorAnnexParser.g:4393:2: ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:4393:2: ( ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )? )
            // InternalBehaviorAnnexParser.g:4394:3: ( (lv_reference_0_0= ruleUnindexedReference ) ) ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )?
            {
            // InternalBehaviorAnnexParser.g:4394:3: ( (lv_reference_0_0= ruleUnindexedReference ) )
            // InternalBehaviorAnnexParser.g:4395:4: (lv_reference_0_0= ruleUnindexedReference )
            {
            // InternalBehaviorAnnexParser.g:4395:4: (lv_reference_0_0= ruleUnindexedReference )
            // InternalBehaviorAnnexParser.g:4396:5: lv_reference_0_0= ruleUnindexedReference
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getUnindexedReferenceExpressionAccess().getReferenceUnindexedReferenceParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_71);
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

            // InternalBehaviorAnnexParser.g:4413:3: ( ( (lv_dequeue_1_0= QuestionMark ) ) | (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) ) )?
            int alt80=3;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==QuestionMark) ) {
                alt80=1;
            }
            else if ( (LA80_0==Apostrophe) ) {
                alt80=2;
            }
            switch (alt80) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4414:4: ( (lv_dequeue_1_0= QuestionMark ) )
                    {
                    // InternalBehaviorAnnexParser.g:4414:4: ( (lv_dequeue_1_0= QuestionMark ) )
                    // InternalBehaviorAnnexParser.g:4415:5: (lv_dequeue_1_0= QuestionMark )
                    {
                    // InternalBehaviorAnnexParser.g:4415:5: (lv_dequeue_1_0= QuestionMark )
                    // InternalBehaviorAnnexParser.g:4416:6: lv_dequeue_1_0= QuestionMark
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
                    // InternalBehaviorAnnexParser.g:4429:4: (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) )
                    {
                    // InternalBehaviorAnnexParser.g:4429:4: (otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) ) )
                    // InternalBehaviorAnnexParser.g:4430:5: otherlv_2= Apostrophe ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) )
                    {
                    otherlv_2=(Token)match(input,Apostrophe,FollowSets000.FOLLOW_67); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          newLeafNode(otherlv_2, grammarAccess.getUnindexedReferenceExpressionAccess().getApostropheKeyword_1_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:4434:5: ( ( (lv_count_3_0= Count ) ) | ( (lv_fresh_4_0= Fresh ) ) )
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==Count) ) {
                        alt79=1;
                    }
                    else if ( (LA79_0==Fresh) ) {
                        alt79=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 79, 0, input);

                        throw nvae;
                    }
                    switch (alt79) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:4435:6: ( (lv_count_3_0= Count ) )
                            {
                            // InternalBehaviorAnnexParser.g:4435:6: ( (lv_count_3_0= Count ) )
                            // InternalBehaviorAnnexParser.g:4436:7: (lv_count_3_0= Count )
                            {
                            // InternalBehaviorAnnexParser.g:4436:7: (lv_count_3_0= Count )
                            // InternalBehaviorAnnexParser.g:4437:8: lv_count_3_0= Count
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
                            // InternalBehaviorAnnexParser.g:4450:6: ( (lv_fresh_4_0= Fresh ) )
                            {
                            // InternalBehaviorAnnexParser.g:4450:6: ( (lv_fresh_4_0= Fresh ) )
                            // InternalBehaviorAnnexParser.g:4451:7: (lv_fresh_4_0= Fresh )
                            {
                            // InternalBehaviorAnnexParser.g:4451:7: (lv_fresh_4_0= Fresh )
                            // InternalBehaviorAnnexParser.g:4452:8: lv_fresh_4_0= Fresh
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
    // InternalBehaviorAnnexParser.g:4471:1: entryRuleUnindexedReference returns [EObject current=null] : iv_ruleUnindexedReference= ruleUnindexedReference EOF ;
    public final EObject entryRuleUnindexedReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReference = null;


        try {
            // InternalBehaviorAnnexParser.g:4471:59: (iv_ruleUnindexedReference= ruleUnindexedReference EOF )
            // InternalBehaviorAnnexParser.g:4472:2: iv_ruleUnindexedReference= ruleUnindexedReference EOF
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
    // InternalBehaviorAnnexParser.g:4478:1: ruleUnindexedReference returns [EObject current=null] : ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* ) ;
    public final EObject ruleUnindexedReference() throws RecognitionException {
        EObject current = null;

        EObject lv_segments_0_0 = null;

        EObject lv_tails_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4484:2: ( ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* ) )
            // InternalBehaviorAnnexParser.g:4485:2: ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* )
            {
            // InternalBehaviorAnnexParser.g:4485:2: ( ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )* )
            // InternalBehaviorAnnexParser.g:4486:3: ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) ) ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )*
            {
            // InternalBehaviorAnnexParser.g:4486:3: ( (lv_segments_0_0= ruleUnindexedReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:4487:4: (lv_segments_0_0= ruleUnindexedReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:4487:4: (lv_segments_0_0= ruleUnindexedReferenceSegment )
            // InternalBehaviorAnnexParser.g:4488:5: lv_segments_0_0= ruleUnindexedReferenceSegment
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getUnindexedReferenceAccess().getSegmentsUnindexedReferenceSegmentParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_72);
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

            // InternalBehaviorAnnexParser.g:4505:3: ( (lv_tails_1_0= ruleUnindexedReferenceTail ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==ColonColon||LA81_0==FullStop) ) {
                    alt81=1;
                }


                switch (alt81) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4506:4: (lv_tails_1_0= ruleUnindexedReferenceTail )
                    {
                    // InternalBehaviorAnnexParser.g:4506:4: (lv_tails_1_0= ruleUnindexedReferenceTail )
                    // InternalBehaviorAnnexParser.g:4507:5: lv_tails_1_0= ruleUnindexedReferenceTail
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getUnindexedReferenceAccess().getTailsUnindexedReferenceTailParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_72);
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
                    break loop81;
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
    // InternalBehaviorAnnexParser.g:4528:1: entryRuleUnindexedReferenceTail returns [EObject current=null] : iv_ruleUnindexedReferenceTail= ruleUnindexedReferenceTail EOF ;
    public final EObject entryRuleUnindexedReferenceTail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReferenceTail = null;


        try {
            // InternalBehaviorAnnexParser.g:4528:63: (iv_ruleUnindexedReferenceTail= ruleUnindexedReferenceTail EOF )
            // InternalBehaviorAnnexParser.g:4529:2: iv_ruleUnindexedReferenceTail= ruleUnindexedReferenceTail EOF
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
    // InternalBehaviorAnnexParser.g:4535:1: ruleUnindexedReferenceTail returns [EObject current=null] : ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) ) ;
    public final EObject ruleUnindexedReferenceTail() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_separator_0_0 = null;

        EObject lv_segment_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4541:2: ( ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) ) )
            // InternalBehaviorAnnexParser.g:4542:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) )
            {
            // InternalBehaviorAnnexParser.g:4542:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) ) )
            // InternalBehaviorAnnexParser.g:4543:3: ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) )
            {
            // InternalBehaviorAnnexParser.g:4543:3: ( (lv_separator_0_0= ruleReferenceSeparator ) )
            // InternalBehaviorAnnexParser.g:4544:4: (lv_separator_0_0= ruleReferenceSeparator )
            {
            // InternalBehaviorAnnexParser.g:4544:4: (lv_separator_0_0= ruleReferenceSeparator )
            // InternalBehaviorAnnexParser.g:4545:5: lv_separator_0_0= ruleReferenceSeparator
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getUnindexedReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_70);
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

            // InternalBehaviorAnnexParser.g:4562:3: ( (lv_segment_1_0= ruleUnindexedReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:4563:4: (lv_segment_1_0= ruleUnindexedReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:4563:4: (lv_segment_1_0= ruleUnindexedReferenceSegment )
            // InternalBehaviorAnnexParser.g:4564:5: lv_segment_1_0= ruleUnindexedReferenceSegment
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
    // InternalBehaviorAnnexParser.g:4585:1: entryRuleUnindexedReferenceSegment returns [EObject current=null] : iv_ruleUnindexedReferenceSegment= ruleUnindexedReferenceSegment EOF ;
    public final EObject entryRuleUnindexedReferenceSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnindexedReferenceSegment = null;


        try {
            // InternalBehaviorAnnexParser.g:4585:66: (iv_ruleUnindexedReferenceSegment= ruleUnindexedReferenceSegment EOF )
            // InternalBehaviorAnnexParser.g:4586:2: iv_ruleUnindexedReferenceSegment= ruleUnindexedReferenceSegment EOF
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
    // InternalBehaviorAnnexParser.g:4592:1: ruleUnindexedReferenceSegment returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleUnindexedReferenceSegment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4598:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalBehaviorAnnexParser.g:4599:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalBehaviorAnnexParser.g:4599:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:4600:3: (lv_name_0_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:4600:3: (lv_name_0_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:4601:4: lv_name_0_0= RULE_ID
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
    // InternalBehaviorAnnexParser.g:4620:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalBehaviorAnnexParser.g:4620:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalBehaviorAnnexParser.g:4621:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalBehaviorAnnexParser.g:4627:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4633:2: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* ) )
            // InternalBehaviorAnnexParser.g:4634:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* )
            {
            // InternalBehaviorAnnexParser.g:4634:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )* )
            // InternalBehaviorAnnexParser.g:4635:3: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_73); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current.merge(this_ID_0);

            }
            if ( state.backtracking==0 ) {

                          newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());

            }
            // InternalBehaviorAnnexParser.g:4642:3: (kw= ColonColon this_ID_2= RULE_ID )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==ColonColon) ) {
                    alt82=1;
                }


                switch (alt82) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4643:4: kw= ColonColon this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0());

                    }
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_73); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      current.merge(this_ID_2);

                    }
                    if ( state.backtracking==0 ) {

                                      newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleReference"
    // InternalBehaviorAnnexParser.g:4660:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalBehaviorAnnexParser.g:4660:50: (iv_ruleReference= ruleReference EOF )
            // InternalBehaviorAnnexParser.g:4661:2: iv_ruleReference= ruleReference EOF
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
    // InternalBehaviorAnnexParser.g:4667:1: ruleReference returns [EObject current=null] : ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        EObject lv_segments_0_0 = null;

        EObject lv_tails_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4673:2: ( ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* ) )
            // InternalBehaviorAnnexParser.g:4674:2: ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* )
            {
            // InternalBehaviorAnnexParser.g:4674:2: ( ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )* )
            // InternalBehaviorAnnexParser.g:4675:3: ( (lv_segments_0_0= ruleReferenceSegment ) ) ( (lv_tails_1_0= ruleReferenceTail ) )*
            {
            // InternalBehaviorAnnexParser.g:4675:3: ( (lv_segments_0_0= ruleReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:4676:4: (lv_segments_0_0= ruleReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:4676:4: (lv_segments_0_0= ruleReferenceSegment )
            // InternalBehaviorAnnexParser.g:4677:5: lv_segments_0_0= ruleReferenceSegment
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getReferenceAccess().getSegmentsReferenceSegmentParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_72);
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

            // InternalBehaviorAnnexParser.g:4694:3: ( (lv_tails_1_0= ruleReferenceTail ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==ColonColon||LA83_0==FullStop) ) {
                    alt83=1;
                }


                switch (alt83) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4695:4: (lv_tails_1_0= ruleReferenceTail )
                    {
                    // InternalBehaviorAnnexParser.g:4695:4: (lv_tails_1_0= ruleReferenceTail )
                    // InternalBehaviorAnnexParser.g:4696:5: lv_tails_1_0= ruleReferenceTail
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getReferenceAccess().getTailsReferenceTailParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_72);
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
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleReferenceTail"
    // InternalBehaviorAnnexParser.g:4717:1: entryRuleReferenceTail returns [EObject current=null] : iv_ruleReferenceTail= ruleReferenceTail EOF ;
    public final EObject entryRuleReferenceTail() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTail = null;


        try {
            // InternalBehaviorAnnexParser.g:4717:54: (iv_ruleReferenceTail= ruleReferenceTail EOF )
            // InternalBehaviorAnnexParser.g:4718:2: iv_ruleReferenceTail= ruleReferenceTail EOF
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
    // InternalBehaviorAnnexParser.g:4724:1: ruleReferenceTail returns [EObject current=null] : ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) ) ;
    public final EObject ruleReferenceTail() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_separator_0_0 = null;

        EObject lv_segment_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4730:2: ( ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) ) )
            // InternalBehaviorAnnexParser.g:4731:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) )
            {
            // InternalBehaviorAnnexParser.g:4731:2: ( ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) ) )
            // InternalBehaviorAnnexParser.g:4732:3: ( (lv_separator_0_0= ruleReferenceSeparator ) ) ( (lv_segment_1_0= ruleReferenceSegment ) )
            {
            // InternalBehaviorAnnexParser.g:4732:3: ( (lv_separator_0_0= ruleReferenceSeparator ) )
            // InternalBehaviorAnnexParser.g:4733:4: (lv_separator_0_0= ruleReferenceSeparator )
            {
            // InternalBehaviorAnnexParser.g:4733:4: (lv_separator_0_0= ruleReferenceSeparator )
            // InternalBehaviorAnnexParser.g:4734:5: lv_separator_0_0= ruleReferenceSeparator
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

            // InternalBehaviorAnnexParser.g:4751:3: ( (lv_segment_1_0= ruleReferenceSegment ) )
            // InternalBehaviorAnnexParser.g:4752:4: (lv_segment_1_0= ruleReferenceSegment )
            {
            // InternalBehaviorAnnexParser.g:4752:4: (lv_segment_1_0= ruleReferenceSegment )
            // InternalBehaviorAnnexParser.g:4753:5: lv_segment_1_0= ruleReferenceSegment
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
    // InternalBehaviorAnnexParser.g:4774:1: entryRuleReferenceSeparator returns [String current=null] : iv_ruleReferenceSeparator= ruleReferenceSeparator EOF ;
    public final String entryRuleReferenceSeparator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReferenceSeparator = null;


        try {
            // InternalBehaviorAnnexParser.g:4774:58: (iv_ruleReferenceSeparator= ruleReferenceSeparator EOF )
            // InternalBehaviorAnnexParser.g:4775:2: iv_ruleReferenceSeparator= ruleReferenceSeparator EOF
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
    // InternalBehaviorAnnexParser.g:4781:1: ruleReferenceSeparator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= ColonColon | kw= FullStop ) ;
    public final AntlrDatatypeRuleToken ruleReferenceSeparator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4787:2: ( (kw= ColonColon | kw= FullStop ) )
            // InternalBehaviorAnnexParser.g:4788:2: (kw= ColonColon | kw= FullStop )
            {
            // InternalBehaviorAnnexParser.g:4788:2: (kw= ColonColon | kw= FullStop )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==ColonColon) ) {
                alt84=1;
            }
            else if ( (LA84_0==FullStop) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4789:3: kw= ColonColon
                    {
                    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                  current.merge(kw);
                                  newLeafNode(kw, grammarAccess.getReferenceSeparatorAccess().getColonColonKeyword_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:4795:3: kw= FullStop
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
    // InternalBehaviorAnnexParser.g:4804:1: entryRuleReferenceSegment returns [EObject current=null] : iv_ruleReferenceSegment= ruleReferenceSegment EOF ;
    public final EObject entryRuleReferenceSegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSegment = null;


        try {
            // InternalBehaviorAnnexParser.g:4804:57: (iv_ruleReferenceSegment= ruleReferenceSegment EOF )
            // InternalBehaviorAnnexParser.g:4805:2: iv_ruleReferenceSegment= ruleReferenceSegment EOF
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
    // InternalBehaviorAnnexParser.g:4811:1: ruleReferenceSegment returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* ) ;
    public final EObject ruleReferenceSegment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_indexes_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4817:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* ) )
            // InternalBehaviorAnnexParser.g:4818:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* )
            {
            // InternalBehaviorAnnexParser.g:4818:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )* )
            // InternalBehaviorAnnexParser.g:4819:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_indexes_1_0= ruleArrayIndex ) )*
            {
            // InternalBehaviorAnnexParser.g:4819:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:4820:4: (lv_name_0_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:4820:4: (lv_name_0_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:4821:5: lv_name_0_0= RULE_ID
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

            // InternalBehaviorAnnexParser.g:4837:3: ( (lv_indexes_1_0= ruleArrayIndex ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==LeftSquareBracket) ) {
                    alt85=1;
                }


                switch (alt85) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4838:4: (lv_indexes_1_0= ruleArrayIndex )
                    {
                    // InternalBehaviorAnnexParser.g:4838:4: (lv_indexes_1_0= ruleArrayIndex )
                    // InternalBehaviorAnnexParser.g:4839:5: lv_indexes_1_0= ruleArrayIndex
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
                    break loop85;
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
    // InternalBehaviorAnnexParser.g:4860:1: entryRuleArrayIndex returns [EObject current=null] : iv_ruleArrayIndex= ruleArrayIndex EOF ;
    public final EObject entryRuleArrayIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayIndex = null;


        try {
            // InternalBehaviorAnnexParser.g:4860:51: (iv_ruleArrayIndex= ruleArrayIndex EOF )
            // InternalBehaviorAnnexParser.g:4861:2: iv_ruleArrayIndex= ruleArrayIndex EOF
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
    // InternalBehaviorAnnexParser.g:4867:1: ruleArrayIndex returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket ) ;
    public final EObject ruleArrayIndex() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:4873:2: ( (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:4874:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:4874:2: (otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:4875:3: otherlv_0= LeftSquareBracket ( (lv_value_1_0= ruleIntegerValue ) ) otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getArrayIndexAccess().getLeftSquareBracketKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:4879:3: ( (lv_value_1_0= ruleIntegerValue ) )
            // InternalBehaviorAnnexParser.g:4880:4: (lv_value_1_0= ruleIntegerValue )
            {
            // InternalBehaviorAnnexParser.g:4880:4: (lv_value_1_0= ruleIntegerValue )
            // InternalBehaviorAnnexParser.g:4881:5: lv_value_1_0= ruleIntegerValue
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
    // InternalBehaviorAnnexParser.g:4906:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalBehaviorAnnexParser.g:4906:69: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalBehaviorAnnexParser.g:4907:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
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
    // InternalBehaviorAnnexParser.g:4913:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon ) ;
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
            // InternalBehaviorAnnexParser.g:4919:2: ( ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon ) )
            // InternalBehaviorAnnexParser.g:4920:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon )
            {
            // InternalBehaviorAnnexParser.g:4920:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon )
            // InternalBehaviorAnnexParser.g:4921:3: ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )? otherlv_17= Semicolon
            {
            // InternalBehaviorAnnexParser.g:4921:3: ( ( ruleQPREF ) )
            // InternalBehaviorAnnexParser.g:4922:4: ( ruleQPREF )
            {
            // InternalBehaviorAnnexParser.g:4922:4: ( ruleQPREF )
            // InternalBehaviorAnnexParser.g:4923:5: ruleQPREF
            {
            if ( state.backtracking==0 ) {

                                  if (current==null) {
                                      current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                                  }

            }
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_74);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                                  afterParserOrEnumRuleCall();

            }

            }


            }

            // InternalBehaviorAnnexParser.g:4937:3: (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==EqualsSignGreaterThanSign) ) {
                alt86=1;
            }
            else if ( (LA86_0==PlusSignEqualsSignGreaterThanSign) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4938:4: otherlv_1= EqualsSignGreaterThanSign
                    {
                    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_75); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:4943:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    {
                    // InternalBehaviorAnnexParser.g:4943:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    // InternalBehaviorAnnexParser.g:4944:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    {
                    // InternalBehaviorAnnexParser.g:4944:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    // InternalBehaviorAnnexParser.g:4945:6: lv_append_2_0= PlusSignEqualsSignGreaterThanSign
                    {
                    lv_append_2_0=(Token)match(input,PlusSignEqualsSignGreaterThanSign,FollowSets000.FOLLOW_75); if (state.failed) return current;
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

            // InternalBehaviorAnnexParser.g:4958:3: ( (lv_constant_3_0= Constant ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==Constant) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4959:4: (lv_constant_3_0= Constant )
                    {
                    // InternalBehaviorAnnexParser.g:4959:4: (lv_constant_3_0= Constant )
                    // InternalBehaviorAnnexParser.g:4960:5: lv_constant_3_0= Constant
                    {
                    lv_constant_3_0=(Token)match(input,Constant,FollowSets000.FOLLOW_75); if (state.failed) return current;
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

            // InternalBehaviorAnnexParser.g:4972:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalBehaviorAnnexParser.g:4973:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalBehaviorAnnexParser.g:4973:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalBehaviorAnnexParser.g:4974:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalBehaviorAnnexParser.g:4974:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalBehaviorAnnexParser.g:4975:6: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
            if ( state.backtracking==0 ) {

                                      newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_76);
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

            // InternalBehaviorAnnexParser.g:4992:4: (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==Comma) ) {
                    alt88=1;
                }


                switch (alt88) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:4993:5: otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
                    {
                    otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_75); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                          newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:4997:5: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
                    // InternalBehaviorAnnexParser.g:4998:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
                    {
                    // InternalBehaviorAnnexParser.g:4998:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
                    // InternalBehaviorAnnexParser.g:4999:7: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
                    {
                    if ( state.backtracking==0 ) {

                                                  newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_76);
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
                    break loop88;
                }
            } while (true);


            }

            // InternalBehaviorAnnexParser.g:5018:3: (otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==Applies) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5019:4: otherlv_7= Applies otherlv_8= To ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    {
                    otherlv_7=(Token)match(input,Applies,FollowSets000.FOLLOW_77); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_7, grammarAccess.getContainedPropertyAssociationAccess().getAppliesKeyword_4_0());

                    }
                    otherlv_8=(Token)match(input,To,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_8, grammarAccess.getContainedPropertyAssociationAccess().getToKeyword_4_1());

                    }
                    // InternalBehaviorAnnexParser.g:5027:4: ( (lv_appliesTo_9_0= ruleContainmentPath ) )
                    // InternalBehaviorAnnexParser.g:5028:5: (lv_appliesTo_9_0= ruleContainmentPath )
                    {
                    // InternalBehaviorAnnexParser.g:5028:5: (lv_appliesTo_9_0= ruleContainmentPath )
                    // InternalBehaviorAnnexParser.g:5029:6: lv_appliesTo_9_0= ruleContainmentPath
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_78);
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

                    // InternalBehaviorAnnexParser.g:5046:4: (otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==Comma) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:5047:5: otherlv_10= Comma ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                            {
                            otherlv_10=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                  newLeafNode(otherlv_10, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_3_0());

                            }
                            // InternalBehaviorAnnexParser.g:5051:5: ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                            // InternalBehaviorAnnexParser.g:5052:6: (lv_appliesTo_11_0= ruleContainmentPath )
                            {
                            // InternalBehaviorAnnexParser.g:5052:6: (lv_appliesTo_11_0= ruleContainmentPath )
                            // InternalBehaviorAnnexParser.g:5053:7: lv_appliesTo_11_0= ruleContainmentPath
                            {
                            if ( state.backtracking==0 ) {

                                                          newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_3_1_0());

                            }
                            pushFollow(FollowSets000.FOLLOW_78);
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
                            break loop89;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalBehaviorAnnexParser.g:5072:3: (otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==In) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5073:4: otherlv_12= In otherlv_13= Binding otherlv_14= LeftParenthesis ( ( ruleQCREF ) ) otherlv_16= RightParenthesis
                    {
                    otherlv_12=(Token)match(input,In,FollowSets000.FOLLOW_53); if (state.failed) return current;
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
                    // InternalBehaviorAnnexParser.g:5085:4: ( ( ruleQCREF ) )
                    // InternalBehaviorAnnexParser.g:5086:5: ( ruleQCREF )
                    {
                    // InternalBehaviorAnnexParser.g:5086:5: ( ruleQCREF )
                    // InternalBehaviorAnnexParser.g:5087:6: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                                              if (current==null) {
                                                  current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                                              }

                    }
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_3_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_49);
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
    // InternalBehaviorAnnexParser.g:5114:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalBehaviorAnnexParser.g:5114:56: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalBehaviorAnnexParser.g:5115:2: iv_ruleContainmentPath= ruleContainmentPath EOF
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
    // InternalBehaviorAnnexParser.g:5121:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5127:2: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalBehaviorAnnexParser.g:5128:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalBehaviorAnnexParser.g:5128:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalBehaviorAnnexParser.g:5129:3: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalBehaviorAnnexParser.g:5129:3: (lv_path_0_0= ruleContainmentPathElement )
            // InternalBehaviorAnnexParser.g:5130:4: lv_path_0_0= ruleContainmentPathElement
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
    // InternalBehaviorAnnexParser.g:5150:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalBehaviorAnnexParser.g:5150:67: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalBehaviorAnnexParser.g:5151:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
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
    // InternalBehaviorAnnexParser.g:5157:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? ) ;
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
            // InternalBehaviorAnnexParser.g:5163:2: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? ) )
            // InternalBehaviorAnnexParser.g:5164:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? )
            {
            // InternalBehaviorAnnexParser.g:5164:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )? )
            // InternalBehaviorAnnexParser.g:5165:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )?
            {
            // InternalBehaviorAnnexParser.g:5165:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalBehaviorAnnexParser.g:5166:4: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalBehaviorAnnexParser.g:5166:4: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalBehaviorAnnexParser.g:5167:5: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_52);
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

            // InternalBehaviorAnnexParser.g:5184:3: (otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==In) ) {
                int LA93_1 = input.LA(2);

                if ( (LA93_1==Modes) ) {
                    alt93=1;
                }
            }
            switch (alt93) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5185:4: otherlv_1= In otherlv_2= Modes otherlv_3= LeftParenthesis ( (otherlv_4= RULE_ID ) ) (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )* otherlv_7= RightParenthesis
                    {
                    otherlv_1=(Token)match(input,In,FollowSets000.FOLLOW_79); if (state.failed) return current;
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
                    // InternalBehaviorAnnexParser.g:5197:4: ( (otherlv_4= RULE_ID ) )
                    // InternalBehaviorAnnexParser.g:5198:5: (otherlv_4= RULE_ID )
                    {
                    // InternalBehaviorAnnexParser.g:5198:5: (otherlv_4= RULE_ID )
                    // InternalBehaviorAnnexParser.g:5199:6: otherlv_4= RULE_ID
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

                    // InternalBehaviorAnnexParser.g:5210:4: (otherlv_5= Comma ( (otherlv_6= RULE_ID ) ) )*
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==Comma) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:5211:5: otherlv_5= Comma ( (otherlv_6= RULE_ID ) )
                            {
                            otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_3); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                  newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0());

                            }
                            // InternalBehaviorAnnexParser.g:5215:5: ( (otherlv_6= RULE_ID ) )
                            // InternalBehaviorAnnexParser.g:5216:6: (otherlv_6= RULE_ID )
                            {
                            // InternalBehaviorAnnexParser.g:5216:6: (otherlv_6= RULE_ID )
                            // InternalBehaviorAnnexParser.g:5217:7: otherlv_6= RULE_ID
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
                            break loop92;
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
    // InternalBehaviorAnnexParser.g:5238:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalBehaviorAnnexParser.g:5238:54: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalBehaviorAnnexParser.g:5239:2: iv_rulePropertyValue= rulePropertyValue EOF
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
    // InternalBehaviorAnnexParser.g:5245:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5251:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalBehaviorAnnexParser.g:5252:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalBehaviorAnnexParser.g:5252:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalBehaviorAnnexParser.g:5253:3: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalBehaviorAnnexParser.g:5253:3: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalBehaviorAnnexParser.g:5254:4: lv_ownedValue_0_0= rulePropertyExpression
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
    // InternalBehaviorAnnexParser.g:5274:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalBehaviorAnnexParser.g:5274:59: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalBehaviorAnnexParser.g:5275:2: iv_rulePropertyExpression= rulePropertyExpression EOF
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
    // InternalBehaviorAnnexParser.g:5281:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) ;
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
            // InternalBehaviorAnnexParser.g:5287:2: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) )
            // InternalBehaviorAnnexParser.g:5288:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            {
            // InternalBehaviorAnnexParser.g:5288:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            int alt94=11;
            alt94 = dfa94.predict(input);
            switch (alt94) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5289:3: this_RecordTerm_0= ruleRecordTerm
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
                    // InternalBehaviorAnnexParser.g:5298:3: this_ReferenceTerm_1= ruleReferenceTerm
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
                    // InternalBehaviorAnnexParser.g:5307:3: this_ComponentClassifierTerm_2= ruleComponentClassifierTerm
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
                    // InternalBehaviorAnnexParser.g:5316:3: this_ComputedTerm_3= ruleComputedTerm
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
                    // InternalBehaviorAnnexParser.g:5325:3: this_StringTerm_4= ruleStringTerm
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
                    // InternalBehaviorAnnexParser.g:5334:3: this_NumericRangeTerm_5= ruleNumericRangeTerm
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
                    // InternalBehaviorAnnexParser.g:5343:3: this_RealTerm_6= ruleRealTerm
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
                    // InternalBehaviorAnnexParser.g:5352:3: this_IntegerTerm_7= ruleIntegerTerm
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
                    // InternalBehaviorAnnexParser.g:5361:3: this_ListTerm_8= ruleListTerm
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
                    // InternalBehaviorAnnexParser.g:5370:3: this_BooleanLiteral_9= ruleBooleanLiteral
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
                    // InternalBehaviorAnnexParser.g:5379:3: this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm
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
    // InternalBehaviorAnnexParser.g:5391:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5391:63: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalBehaviorAnnexParser.g:5392:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
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
    // InternalBehaviorAnnexParser.g:5398:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5404:2: ( ( ( ruleQPREF ) ) )
            // InternalBehaviorAnnexParser.g:5405:2: ( ( ruleQPREF ) )
            {
            // InternalBehaviorAnnexParser.g:5405:2: ( ( ruleQPREF ) )
            // InternalBehaviorAnnexParser.g:5406:3: ( ruleQPREF )
            {
            // InternalBehaviorAnnexParser.g:5406:3: ( ruleQPREF )
            // InternalBehaviorAnnexParser.g:5407:4: ruleQPREF
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
    // InternalBehaviorAnnexParser.g:5424:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalBehaviorAnnexParser.g:5424:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalBehaviorAnnexParser.g:5425:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalBehaviorAnnexParser.g:5431:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5437:2: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalBehaviorAnnexParser.g:5438:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalBehaviorAnnexParser.g:5438:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalBehaviorAnnexParser.g:5439:3: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalBehaviorAnnexParser.g:5439:3: ()
            // InternalBehaviorAnnexParser.g:5440:4:
            {
            if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                                  current);

            }

            }

            // InternalBehaviorAnnexParser.g:5446:3: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==True) ) {
                alt95=1;
            }
            else if ( (LA95_0==False) ) {
                alt95=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5447:4: ( (lv_value_1_0= True ) )
                    {
                    // InternalBehaviorAnnexParser.g:5447:4: ( (lv_value_1_0= True ) )
                    // InternalBehaviorAnnexParser.g:5448:5: (lv_value_1_0= True )
                    {
                    // InternalBehaviorAnnexParser.g:5448:5: (lv_value_1_0= True )
                    // InternalBehaviorAnnexParser.g:5449:6: lv_value_1_0= True
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
                    // InternalBehaviorAnnexParser.g:5462:4: otherlv_2= False
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
    // InternalBehaviorAnnexParser.g:5471:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalBehaviorAnnexParser.g:5471:54: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalBehaviorAnnexParser.g:5472:2: iv_ruleConstantValue= ruleConstantValue EOF
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
    // InternalBehaviorAnnexParser.g:5478:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5484:2: ( ( ( ruleQPREF ) ) )
            // InternalBehaviorAnnexParser.g:5485:2: ( ( ruleQPREF ) )
            {
            // InternalBehaviorAnnexParser.g:5485:2: ( ( ruleQPREF ) )
            // InternalBehaviorAnnexParser.g:5486:3: ( ruleQPREF )
            {
            // InternalBehaviorAnnexParser.g:5486:3: ( ruleQPREF )
            // InternalBehaviorAnnexParser.g:5487:4: ruleQPREF
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
    // InternalBehaviorAnnexParser.g:5504:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5504:54: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalBehaviorAnnexParser.g:5505:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
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
    // InternalBehaviorAnnexParser.g:5511:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5517:2: ( (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:5518:2: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:5518:2: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            // InternalBehaviorAnnexParser.g:5519:3: otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Reference,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:5527:3: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalBehaviorAnnexParser.g:5528:4: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalBehaviorAnnexParser.g:5528:4: (lv_path_2_0= ruleContainmentPathElement )
            // InternalBehaviorAnnexParser.g:5529:5: lv_path_2_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_49);
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
    // InternalBehaviorAnnexParser.g:5554:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5554:51: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalBehaviorAnnexParser.g:5555:2: iv_ruleRecordTerm= ruleRecordTerm EOF
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
    // InternalBehaviorAnnexParser.g:5561:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5567:2: ( (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:5568:2: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:5568:2: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:5569:3: otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());

            }
            // InternalBehaviorAnnexParser.g:5573:3: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt96=0;
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==RULE_ID) ) {
                    alt96=1;
                }


                switch (alt96) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5574:4: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
                    {
                    // InternalBehaviorAnnexParser.g:5574:4: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
                    // InternalBehaviorAnnexParser.g:5575:5: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
                    {
                    if ( state.backtracking==0 ) {

                                          newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_80);
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
                    if ( cnt96 >= 1 ) break loop96;
                    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(96, input);
                        throw eee;
                }
                cnt96++;
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
    // InternalBehaviorAnnexParser.g:5600:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5600:53: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalBehaviorAnnexParser.g:5601:2: iv_ruleComputedTerm= ruleComputedTerm EOF
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
    // InternalBehaviorAnnexParser.g:5607:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5613:2: ( (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:5614:2: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:5614:2: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            // InternalBehaviorAnnexParser.g:5615:3: otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Compute,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:5623:3: ( (lv_function_2_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:5624:4: (lv_function_2_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:5624:4: (lv_function_2_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:5625:5: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_49); if (state.failed) return current;
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
    // InternalBehaviorAnnexParser.g:5649:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5649:64: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalBehaviorAnnexParser.g:5650:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
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
    // InternalBehaviorAnnexParser.g:5656:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5662:2: ( (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:5663:2: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:5663:2: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            // InternalBehaviorAnnexParser.g:5664:3: otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Classifier,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());

            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:5672:3: ( ( ruleQCREF ) )
            // InternalBehaviorAnnexParser.g:5673:4: ( ruleQCREF )
            {
            // InternalBehaviorAnnexParser.g:5673:4: ( ruleQCREF )
            // InternalBehaviorAnnexParser.g:5674:5: ruleQCREF
            {
            if ( state.backtracking==0 ) {

                                  if (current==null) {
                                      current = createModelElement(grammarAccess.getComponentClassifierTermRule());
                                  }

            }
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_49);
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
    // InternalBehaviorAnnexParser.g:5696:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5696:49: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalBehaviorAnnexParser.g:5697:2: iv_ruleListTerm= ruleListTerm EOF
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
    // InternalBehaviorAnnexParser.g:5703:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5709:2: ( ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) )
            // InternalBehaviorAnnexParser.g:5710:2: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            {
            // InternalBehaviorAnnexParser.g:5710:2: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            // InternalBehaviorAnnexParser.g:5711:3: () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis
            {
            // InternalBehaviorAnnexParser.g:5711:3: ()
            // InternalBehaviorAnnexParser.g:5712:4:
            {
            if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getListTermAccess().getListValueAction_0(),
                                  current);

            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_81); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:5722:3: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==Classifier||LA98_0==Reference||LA98_0==Compute||LA98_0==False||LA98_0==True||LA98_0==LeftParenthesis||LA98_0==PlusSign||LA98_0==HyphenMinus||LA98_0==LeftSquareBracket||LA98_0==RULE_REAL_LIT||LA98_0==RULE_INTEGER_LIT||(LA98_0>=RULE_STRING && LA98_0<=RULE_ID)) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5723:4: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalBehaviorAnnexParser.g:5723:4: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalBehaviorAnnexParser.g:5724:5: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalBehaviorAnnexParser.g:5724:5: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalBehaviorAnnexParser.g:5725:6: lv_ownedListElement_2_0= rulePropertyExpression
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

                    // InternalBehaviorAnnexParser.g:5742:4: (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( (LA97_0==Comma) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                        case 1 :
                            // InternalBehaviorAnnexParser.g:5743:5: otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                            {
                            otherlv_3=(Token)match(input,Comma,FollowSets000.FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                                  newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());

                            }
                            // InternalBehaviorAnnexParser.g:5747:5: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                            // InternalBehaviorAnnexParser.g:5748:6: (lv_ownedListElement_4_0= rulePropertyExpression )
                            {
                            // InternalBehaviorAnnexParser.g:5748:6: (lv_ownedListElement_4_0= rulePropertyExpression )
                            // InternalBehaviorAnnexParser.g:5749:7: lv_ownedListElement_4_0= rulePropertyExpression
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
                            break loop97;
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
    // InternalBehaviorAnnexParser.g:5776:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalBehaviorAnnexParser.g:5776:65: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalBehaviorAnnexParser.g:5777:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
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
    // InternalBehaviorAnnexParser.g:5783:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5789:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) )
            // InternalBehaviorAnnexParser.g:5790:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            {
            // InternalBehaviorAnnexParser.g:5790:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            // InternalBehaviorAnnexParser.g:5791:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon
            {
            // InternalBehaviorAnnexParser.g:5791:3: ( (otherlv_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:5792:4: (otherlv_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:5792:4: (otherlv_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:5793:5: otherlv_0= RULE_ID
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
            // InternalBehaviorAnnexParser.g:5808:3: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalBehaviorAnnexParser.g:5809:4: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalBehaviorAnnexParser.g:5809:4: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalBehaviorAnnexParser.g:5810:5: lv_ownedValue_2_0= rulePropertyExpression
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
    // InternalBehaviorAnnexParser.g:5835:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalBehaviorAnnexParser.g:5835:63: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalBehaviorAnnexParser.g:5836:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
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
    // InternalBehaviorAnnexParser.g:5842:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5848:2: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalBehaviorAnnexParser.g:5849:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:5849:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalBehaviorAnnexParser.g:5850:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalBehaviorAnnexParser.g:5850:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* )
            // InternalBehaviorAnnexParser.g:5851:4: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            {
            // InternalBehaviorAnnexParser.g:5851:4: ( (otherlv_0= RULE_ID ) )
            // InternalBehaviorAnnexParser.g:5852:5: (otherlv_0= RULE_ID )
            {
            // InternalBehaviorAnnexParser.g:5852:5: (otherlv_0= RULE_ID )
            // InternalBehaviorAnnexParser.g:5853:6: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

                                      if (current==null) {
                                          current = createModelElement(grammarAccess.getContainmentPathElementRule());
                                      }

            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_68); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0());

            }

            }


            }

            // InternalBehaviorAnnexParser.g:5864:4: ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==LeftSquareBracket) ) {
                    alt99=1;
                }


                switch (alt99) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5865:5: (lv_arrayRange_1_0= ruleArrayRange )
                    {
                    // InternalBehaviorAnnexParser.g:5865:5: (lv_arrayRange_1_0= ruleArrayRange )
                    // InternalBehaviorAnnexParser.g:5866:6: lv_arrayRange_1_0= ruleArrayRange
                    {
                    if ( state.backtracking==0 ) {

                                              newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0());

                    }
                    pushFollow(FollowSets000.FOLLOW_68);
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
                    break loop99;
                }
            } while (true);


            }

            // InternalBehaviorAnnexParser.g:5884:3: (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==FullStop) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:5885:4: otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,FullStop,FollowSets000.FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());

                    }
                    // InternalBehaviorAnnexParser.g:5889:4: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalBehaviorAnnexParser.g:5890:5: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalBehaviorAnnexParser.g:5890:5: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalBehaviorAnnexParser.g:5891:6: lv_path_3_0= ruleContainmentPathElement
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
    // InternalBehaviorAnnexParser.g:5913:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalBehaviorAnnexParser.g:5913:49: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalBehaviorAnnexParser.g:5914:2: iv_rulePlusMinus= rulePlusMinus EOF
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
    // InternalBehaviorAnnexParser.g:5920:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5926:2: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalBehaviorAnnexParser.g:5927:2: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalBehaviorAnnexParser.g:5927:2: (kw= PlusSign | kw= HyphenMinus )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==PlusSign) ) {
                alt101=1;
            }
            else if ( (LA101_0==HyphenMinus) ) {
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
                    // InternalBehaviorAnnexParser.g:5928:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                  current.merge(kw);
                                  newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:5934:3: kw= HyphenMinus
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
    // InternalBehaviorAnnexParser.g:5943:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:5943:51: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalBehaviorAnnexParser.g:5944:2: iv_ruleStringTerm= ruleStringTerm EOF
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
    // InternalBehaviorAnnexParser.g:5950:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5956:2: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalBehaviorAnnexParser.g:5957:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalBehaviorAnnexParser.g:5957:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalBehaviorAnnexParser.g:5958:3: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalBehaviorAnnexParser.g:5958:3: (lv_value_0_0= ruleNoQuoteString )
            // InternalBehaviorAnnexParser.g:5959:4: lv_value_0_0= ruleNoQuoteString
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
    // InternalBehaviorAnnexParser.g:5979:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalBehaviorAnnexParser.g:5979:53: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalBehaviorAnnexParser.g:5980:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
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
    // InternalBehaviorAnnexParser.g:5986:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:5992:2: (this_STRING_0= RULE_STRING )
            // InternalBehaviorAnnexParser.g:5993:2: this_STRING_0= RULE_STRING
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
    // InternalBehaviorAnnexParser.g:6003:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalBehaviorAnnexParser.g:6003:51: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalBehaviorAnnexParser.g:6004:2: iv_ruleArrayRange= ruleArrayRange EOF
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
    // InternalBehaviorAnnexParser.g:6010:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6016:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) )
            // InternalBehaviorAnnexParser.g:6017:2: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            {
            // InternalBehaviorAnnexParser.g:6017:2: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            // InternalBehaviorAnnexParser.g:6018:3: () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket
            {
            // InternalBehaviorAnnexParser.g:6018:3: ()
            // InternalBehaviorAnnexParser.g:6019:4:
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
            // InternalBehaviorAnnexParser.g:6029:3: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalBehaviorAnnexParser.g:6030:4: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalBehaviorAnnexParser.g:6030:4: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalBehaviorAnnexParser.g:6031:5: lv_lowerBound_2_0= ruleINTVALUE
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_82);
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

            // InternalBehaviorAnnexParser.g:6048:3: (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==FullStopFullStop) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6049:4: otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());

                    }
                    // InternalBehaviorAnnexParser.g:6053:4: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalBehaviorAnnexParser.g:6054:5: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalBehaviorAnnexParser.g:6054:5: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalBehaviorAnnexParser.g:6055:6: lv_upperBound_4_0= ruleINTVALUE
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
    // InternalBehaviorAnnexParser.g:6081:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalBehaviorAnnexParser.g:6081:55: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalBehaviorAnnexParser.g:6082:2: iv_ruleSignedConstant= ruleSignedConstant EOF
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
    // InternalBehaviorAnnexParser.g:6088:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6094:2: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalBehaviorAnnexParser.g:6095:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalBehaviorAnnexParser.g:6095:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalBehaviorAnnexParser.g:6096:3: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalBehaviorAnnexParser.g:6096:3: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalBehaviorAnnexParser.g:6097:4: (lv_op_0_0= rulePlusMinus )
            {
            // InternalBehaviorAnnexParser.g:6097:4: (lv_op_0_0= rulePlusMinus )
            // InternalBehaviorAnnexParser.g:6098:5: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_83);
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

            // InternalBehaviorAnnexParser.g:6115:3: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalBehaviorAnnexParser.g:6116:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalBehaviorAnnexParser.g:6116:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalBehaviorAnnexParser.g:6117:5: lv_ownedPropertyExpression_1_0= ruleConstantValue
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
    // InternalBehaviorAnnexParser.g:6138:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:6138:52: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalBehaviorAnnexParser.g:6139:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
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
    // InternalBehaviorAnnexParser.g:6145:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6151:2: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalBehaviorAnnexParser.g:6152:2: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalBehaviorAnnexParser.g:6152:2: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalBehaviorAnnexParser.g:6153:3: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalBehaviorAnnexParser.g:6153:3: ( (lv_value_0_0= ruleSignedInt ) )
            // InternalBehaviorAnnexParser.g:6154:4: (lv_value_0_0= ruleSignedInt )
            {
            // InternalBehaviorAnnexParser.g:6154:4: (lv_value_0_0= ruleSignedInt )
            // InternalBehaviorAnnexParser.g:6155:5: lv_value_0_0= ruleSignedInt
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

            // InternalBehaviorAnnexParser.g:6172:3: ( (otherlv_1= RULE_ID ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_ID) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6173:4: (otherlv_1= RULE_ID )
                    {
                    // InternalBehaviorAnnexParser.g:6173:4: (otherlv_1= RULE_ID )
                    // InternalBehaviorAnnexParser.g:6174:5: otherlv_1= RULE_ID
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
    // InternalBehaviorAnnexParser.g:6189:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // InternalBehaviorAnnexParser.g:6189:49: (iv_ruleSignedInt= ruleSignedInt EOF )
            // InternalBehaviorAnnexParser.g:6190:2: iv_ruleSignedInt= ruleSignedInt EOF
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
    // InternalBehaviorAnnexParser.g:6196:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6202:2: ( ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalBehaviorAnnexParser.g:6203:2: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalBehaviorAnnexParser.g:6203:2: ( (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalBehaviorAnnexParser.g:6204:3: (kw= PlusSign | kw= HyphenMinus )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // InternalBehaviorAnnexParser.g:6204:3: (kw= PlusSign | kw= HyphenMinus )?
            int alt104=3;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==PlusSign) ) {
                alt104=1;
            }
            else if ( (LA104_0==HyphenMinus) ) {
                alt104=2;
            }
            switch (alt104) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6205:4: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:6211:4: kw= HyphenMinus
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
    // InternalBehaviorAnnexParser.g:6228:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:6228:49: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalBehaviorAnnexParser.g:6229:2: iv_ruleRealTerm= ruleRealTerm EOF
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
    // InternalBehaviorAnnexParser.g:6235:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6241:2: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalBehaviorAnnexParser.g:6242:2: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalBehaviorAnnexParser.g:6242:2: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalBehaviorAnnexParser.g:6243:3: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalBehaviorAnnexParser.g:6243:3: ( (lv_value_0_0= ruleSignedReal ) )
            // InternalBehaviorAnnexParser.g:6244:4: (lv_value_0_0= ruleSignedReal )
            {
            // InternalBehaviorAnnexParser.g:6244:4: (lv_value_0_0= ruleSignedReal )
            // InternalBehaviorAnnexParser.g:6245:5: lv_value_0_0= ruleSignedReal
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

            // InternalBehaviorAnnexParser.g:6262:3: ( (otherlv_1= RULE_ID ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==RULE_ID) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6263:4: (otherlv_1= RULE_ID )
                    {
                    // InternalBehaviorAnnexParser.g:6263:4: (otherlv_1= RULE_ID )
                    // InternalBehaviorAnnexParser.g:6264:5: otherlv_1= RULE_ID
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
    // InternalBehaviorAnnexParser.g:6279:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // InternalBehaviorAnnexParser.g:6279:50: (iv_ruleSignedReal= ruleSignedReal EOF )
            // InternalBehaviorAnnexParser.g:6280:2: iv_ruleSignedReal= ruleSignedReal EOF
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
    // InternalBehaviorAnnexParser.g:6286:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6292:2: ( ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // InternalBehaviorAnnexParser.g:6293:2: ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // InternalBehaviorAnnexParser.g:6293:2: ( (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT )
            // InternalBehaviorAnnexParser.g:6294:3: (kw= PlusSign | kw= HyphenMinus )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // InternalBehaviorAnnexParser.g:6294:3: (kw= PlusSign | kw= HyphenMinus )?
            int alt106=3;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==PlusSign) ) {
                alt106=1;
            }
            else if ( (LA106_0==HyphenMinus) ) {
                alt106=2;
            }
            switch (alt106) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6295:4: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_84); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0());

                    }

                    }
                    break;
                case 2 :
                    // InternalBehaviorAnnexParser.g:6301:4: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_84); if (state.failed) return current;
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
    // InternalBehaviorAnnexParser.g:6318:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalBehaviorAnnexParser.g:6318:57: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalBehaviorAnnexParser.g:6319:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
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
    // InternalBehaviorAnnexParser.g:6325:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6331:2: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalBehaviorAnnexParser.g:6332:2: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalBehaviorAnnexParser.g:6332:2: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalBehaviorAnnexParser.g:6333:3: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalBehaviorAnnexParser.g:6333:3: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalBehaviorAnnexParser.g:6334:4: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalBehaviorAnnexParser.g:6334:4: (lv_minimum_0_0= ruleNumAlt )
            // InternalBehaviorAnnexParser.g:6335:5: lv_minimum_0_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0());

            }
            pushFollow(FollowSets000.FOLLOW_85);
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

            otherlv_1=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_83); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());

            }
            // InternalBehaviorAnnexParser.g:6356:3: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalBehaviorAnnexParser.g:6357:4: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalBehaviorAnnexParser.g:6357:4: (lv_maximum_2_0= ruleNumAlt )
            // InternalBehaviorAnnexParser.g:6358:5: lv_maximum_2_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {

                                  newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0());

            }
            pushFollow(FollowSets000.FOLLOW_86);
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

            // InternalBehaviorAnnexParser.g:6375:3: (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==Delta) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6376:4: otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,Delta,FollowSets000.FOLLOW_83); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                                      newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());

                    }
                    // InternalBehaviorAnnexParser.g:6380:4: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalBehaviorAnnexParser.g:6381:5: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalBehaviorAnnexParser.g:6381:5: (lv_delta_4_0= ruleNumAlt )
                    // InternalBehaviorAnnexParser.g:6382:6: lv_delta_4_0= ruleNumAlt
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
    // InternalBehaviorAnnexParser.g:6404:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalBehaviorAnnexParser.g:6404:47: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalBehaviorAnnexParser.g:6405:2: iv_ruleNumAlt= ruleNumAlt EOF
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
    // InternalBehaviorAnnexParser.g:6411:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;



            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6417:2: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalBehaviorAnnexParser.g:6418:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalBehaviorAnnexParser.g:6418:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt108=4;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt108=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt108=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt108=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 108, 1, input);

                    throw nvae;
                }

                }
                break;
            case HyphenMinus:
                {
                switch ( input.LA(2) ) {
                case RULE_REAL_LIT:
                    {
                    alt108=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt108=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt108=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 108, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt108=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt108=2;
                }
                break;
            case RULE_ID:
                {
                alt108=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6419:3: this_RealTerm_0= ruleRealTerm
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
                    // InternalBehaviorAnnexParser.g:6428:3: this_IntegerTerm_1= ruleIntegerTerm
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
                    // InternalBehaviorAnnexParser.g:6437:3: this_SignedConstant_2= ruleSignedConstant
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
                    // InternalBehaviorAnnexParser.g:6446:3: this_ConstantValue_3= ruleConstantValue
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
    // InternalBehaviorAnnexParser.g:6458:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalBehaviorAnnexParser.g:6458:48: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalBehaviorAnnexParser.g:6459:2: iv_ruleINTVALUE= ruleINTVALUE EOF
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
    // InternalBehaviorAnnexParser.g:6465:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6471:2: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalBehaviorAnnexParser.g:6472:2: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalBehaviorAnnexParser.g:6482:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalBehaviorAnnexParser.g:6482:45: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalBehaviorAnnexParser.g:6483:2: iv_ruleQPREF= ruleQPREF EOF
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
    // InternalBehaviorAnnexParser.g:6489:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6495:2: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) )
            // InternalBehaviorAnnexParser.g:6496:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            {
            // InternalBehaviorAnnexParser.g:6496:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            // InternalBehaviorAnnexParser.g:6497:3: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_73); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current.merge(this_ID_0);

            }
            if ( state.backtracking==0 ) {

                          newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0());

            }
            // InternalBehaviorAnnexParser.g:6504:3: (kw= ColonColon this_ID_2= RULE_ID )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==ColonColon) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6505:4: kw= ColonColon this_ID_2= RULE_ID
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
    // InternalBehaviorAnnexParser.g:6522:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalBehaviorAnnexParser.g:6522:45: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalBehaviorAnnexParser.g:6523:2: iv_ruleQCREF= ruleQCREF EOF
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
    // InternalBehaviorAnnexParser.g:6529:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6535:2: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // InternalBehaviorAnnexParser.g:6536:2: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // InternalBehaviorAnnexParser.g:6536:2: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // InternalBehaviorAnnexParser.g:6537:3: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // InternalBehaviorAnnexParser.g:6537:3: (this_ID_0= RULE_ID kw= ColonColon )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==RULE_ID) ) {
                    int LA110_1 = input.LA(2);

                    if ( (LA110_1==ColonColon) ) {
                        alt110=1;
                    }


                }


                switch (alt110) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6538:4: this_ID_0= RULE_ID kw= ColonColon
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_87); if (state.failed) return current;
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
                    break loop110;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                          current.merge(this_ID_2);

            }
            if ( state.backtracking==0 ) {

                          newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1());

            }
            // InternalBehaviorAnnexParser.g:6558:3: (kw= FullStop this_ID_4= RULE_ID )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==FullStop) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalBehaviorAnnexParser.g:6559:4: kw= FullStop this_ID_4= RULE_ID
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
    // InternalBehaviorAnnexParser.g:6576:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalBehaviorAnnexParser.g:6576:44: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalBehaviorAnnexParser.g:6577:2: iv_ruleSTAR= ruleSTAR EOF
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
    // InternalBehaviorAnnexParser.g:6583:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Asterisk ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


            enterRule();

        try {
            // InternalBehaviorAnnexParser.g:6589:2: (kw= Asterisk )
            // InternalBehaviorAnnexParser.g:6590:2: kw= Asterisk
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
        // InternalBehaviorAnnexParser.g:1800:4: ( ruleAssignmentAction )
        // InternalBehaviorAnnexParser.g:1800:5: ruleAssignmentAction
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


    protected DFA40 dfa40 = new DFA40(this);
    protected DFA94 dfa94 = new DFA94(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\4\1\0\11\uffff";
    static final String dfa_3s = "\1\137\1\0\11\uffff";
    static final String dfa_4s = "\2\uffff\1\2\1\3\1\4\1\5\1\uffff\1\6\1\7\1\10\1\1";
    static final String dfa_5s = "\1\uffff\1\0\11\uffff}>";
    static final String[] dfa_6s = {
            "\1\3\16\uffff\1\5\13\uffff\1\7\11\uffff\1\5\20\uffff\1\10\1\4\12\uffff\1\2\15\uffff\1\11\12\uffff\1\1",
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

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1798:2: ( ( ( ruleAssignmentAction )=>this_AssignmentAction_0= ruleAssignmentAction ) | this_CommunicationAction_1= ruleCommunicationAction | this_TimedAction_2= ruleTimedAction | this_IfStatement_3= ruleIfStatement | this_ForStatement_4= ruleForStatement | this_WhileStatement_5= ruleWhileStatement | this_DoUntilStatement_6= ruleDoUntilStatement | this_BehaviorActionBlock_7= ruleBehaviorActionBlock )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
            int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA40_1 = input.LA(1);


                        int index40_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalBehaviorAnnexParser()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}


                        input.seek(index40_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\25\uffff";
    static final String dfa_8s = "\10\uffff\1\17\1\21\1\23\3\uffff\1\17\1\uffff\1\21\3\uffff\1\23";
    static final String dfa_9s = "\1\6\5\uffff\2\132\3\16\3\uffff\1\16\1\uffff\1\16\1\uffff\1\137\1\uffff\1\16";
    static final String dfa_10s = "\1\137\5\uffff\4\137\1\115\3\uffff\1\115\1\uffff\1\115\1\uffff\1\137\1\uffff\1\115";
    static final String dfa_11s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\5\uffff\1\11\1\12\1\6\1\uffff\1\7\1\uffff\1\10\1\uffff\1\13\1\uffff";
    static final String dfa_12s = "\25\uffff}>";
    static final String[] dfa_13s = {
            "\1\3\1\uffff\1\2\7\uffff\1\4\10\uffff\1\14\10\uffff\1\14\41\uffff\1\13\2\uffff\1\6\1\uffff\1\7\10\uffff\1\1\7\uffff\1\10\1\uffff\1\11\1\uffff\1\5\1\12",
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

    class DFA94 extends DFA {

        public DFA94(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 94;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "5288:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )";
        }
    }



    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000200022L,0x0000000080000000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000022L,0x0000000080000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001100L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0020000000000000L,0x0000000000102000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000402000000L,0x0000000054000002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000102000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000080200000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000402000000L,0x00000000D4000002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000402010140L,0x00000000D4040290L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000024020400L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000024000400L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000024000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000041000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x2000083402040080L,0x00000000D4000292L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000402003000L,0x00000000D4000002L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000602140002L,0x00000000D4000002L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000120L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000402000002L,0x00000000D4000012L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000402000002L,0x00000000D4000002L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x4000000000000002L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0C00020482080010L,0x00000000D4100042L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002004L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x000008A402000000L,0x00000000D4000292L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0201400000000000L,0x0000000000020001L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000082402000000L,0x00000000D4000292L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0001400000000000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x1000000000000002L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000010101000000L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x1000000000000000L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0008000000000002L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x4000200000000002L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0140800000000002L,0x000000000001C000L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000280L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000140000000002L,0x0000000000000840L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0002000000000002L});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x000000000002000AL});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000008400000L});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000000040400L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000090000002L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020008L});
        public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0010000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0010000000000002L});
        public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0080000800000000L});
        public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000402010940L,0x00000000D4040290L});
        public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x1000000000004000L,0x0000000000002100L});
        public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x8000000000000000L});
        public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x1000000000000000L,0x0000000000002100L});
        public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x0000000080080000L});
        public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000402010140L,0x00000000D40402B0L});
        public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0008000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000094000280L});
        public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
        public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0010000000000000L});
    }


}
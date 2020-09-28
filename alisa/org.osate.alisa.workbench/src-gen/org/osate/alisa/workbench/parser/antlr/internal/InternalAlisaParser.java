package org.osate.alisa.workbench.parser.antlr.internal;

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
import org.osate.alisa.workbench.services.AlisaGrammarAccess;



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
public class InternalAlisaParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_REAL_LIT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_EXTENDED_DIGIT", "RULE_BASED_INTEGER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'assurance'", "'case'", "':'", "'for'", "'['", "']'", "'plan'", "'assure'", "'global'", "'subsystem'", "'all'", "'assume'", "'issues'", "'task'", "'category'", "'any'", "'description'", "'this'", "'boolean'", "'integer'", "'units'", "'real'", "'string'", "'model'", "'element'", "'#'", "'.'", "'%'", "'in'", "'img'", "'/'", "'or'", "'||'", "'and'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'><'", "'+'", "'-'", "'*'", "'div'", "'mod'", "'not'", "'('", "','", "')'", "'..'", "'delta'", "'if'", "'then'", "'else'", "'endif'", "'true'", "'false'", "'::'"
    };
    public static final int T__50=50;
    public static final int RULE_INT_EXPONENT=10;
    public static final int T__19=19;
    public static final int T__59=59;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_BASED_INTEGER=12;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_DIGIT=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_REAL_LIT=7;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=14;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int RULE_WS=15;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_EXPONENT=9;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int RULE_EXTENDED_DIGIT=11;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalAlisaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAlisaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAlisaParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAlisa.g"; }



     	private AlisaGrammarAccess grammarAccess;

        public InternalAlisaParser(TokenStream input, AlisaGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "AssuranceCase";
       	}

       	@Override
       	protected AlisaGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleAssuranceCase"
    // InternalAlisa.g:85:1: entryRuleAssuranceCase returns [EObject current=null] : iv_ruleAssuranceCase= ruleAssuranceCase EOF ;
    public final EObject entryRuleAssuranceCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssuranceCase = null;


        try {
            // InternalAlisa.g:85:54: (iv_ruleAssuranceCase= ruleAssuranceCase EOF )
            // InternalAlisa.g:86:2: iv_ruleAssuranceCase= ruleAssuranceCase EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssuranceCaseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssuranceCase=ruleAssuranceCase();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssuranceCase; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssuranceCase"


    // $ANTLR start "ruleAssuranceCase"
    // InternalAlisa.g:92:1: ruleAssuranceCase returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'case' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( (lv_description_8_0= ruleDescription ) )? ( (lv_assurancePlans_9_0= ruleAssurancePlan ) )+ ( (lv_tasks_10_0= ruleAssuranceTask ) )* otherlv_11= ']' ) ;
    public final EObject ruleAssuranceCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_title_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_description_8_0 = null;

        EObject lv_assurancePlans_9_0 = null;

        EObject lv_tasks_10_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:98:2: ( (otherlv_0= 'assurance' otherlv_1= 'case' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( (lv_description_8_0= ruleDescription ) )? ( (lv_assurancePlans_9_0= ruleAssurancePlan ) )+ ( (lv_tasks_10_0= ruleAssuranceTask ) )* otherlv_11= ']' ) )
            // InternalAlisa.g:99:2: (otherlv_0= 'assurance' otherlv_1= 'case' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( (lv_description_8_0= ruleDescription ) )? ( (lv_assurancePlans_9_0= ruleAssurancePlan ) )+ ( (lv_tasks_10_0= ruleAssuranceTask ) )* otherlv_11= ']' )
            {
            // InternalAlisa.g:99:2: (otherlv_0= 'assurance' otherlv_1= 'case' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( (lv_description_8_0= ruleDescription ) )? ( (lv_assurancePlans_9_0= ruleAssurancePlan ) )+ ( (lv_tasks_10_0= ruleAssuranceTask ) )* otherlv_11= ']' )
            // InternalAlisa.g:100:3: otherlv_0= 'assurance' otherlv_1= 'case' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( (lv_description_8_0= ruleDescription ) )? ( (lv_assurancePlans_9_0= ruleAssurancePlan ) )+ ( (lv_tasks_10_0= ruleAssuranceTask ) )* otherlv_11= ']'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAssuranceCaseAccess().getAssuranceKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAssuranceCaseAccess().getCaseKeyword_1());
              		
            }
            // InternalAlisa.g:108:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalAlisa.g:109:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalAlisa.g:109:4: (lv_name_2_0= ruleQualifiedName )
            // InternalAlisa.g:110:5: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssuranceCaseAccess().getNameQualifiedNameParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.osate.alisa.common.Common.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAlisa.g:127:3: (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==19) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalAlisa.g:128:4: otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAssuranceCaseAccess().getColonKeyword_3_0());
                      			
                    }
                    // InternalAlisa.g:132:4: ( (lv_title_4_0= RULE_STRING ) )
                    // InternalAlisa.g:133:5: (lv_title_4_0= RULE_STRING )
                    {
                    // InternalAlisa.g:133:5: (lv_title_4_0= RULE_STRING )
                    // InternalAlisa.g:134:6: lv_title_4_0= RULE_STRING
                    {
                    lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_title_4_0, grammarAccess.getAssuranceCaseAccess().getTitleSTRINGTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssuranceCaseRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"title",
                      							lv_title_4_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getAssuranceCaseAccess().getForKeyword_4());
              		
            }
            // InternalAlisa.g:155:3: ( ( ruleAadlClassifierReference ) )
            // InternalAlisa.g:156:4: ( ruleAadlClassifierReference )
            {
            // InternalAlisa.g:156:4: ( ruleAadlClassifierReference )
            // InternalAlisa.g:157:5: ruleAadlClassifierReference
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAssuranceCaseRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssuranceCaseAccess().getSystemComponentTypeCrossReference_5_0());
              				
            }
            pushFollow(FOLLOW_8);
            ruleAadlClassifierReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,21,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getAssuranceCaseAccess().getLeftSquareBracketKeyword_6());
              		
            }
            // InternalAlisa.g:175:3: ( (lv_description_8_0= ruleDescription ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==33) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalAlisa.g:176:4: (lv_description_8_0= ruleDescription )
                    {
                    // InternalAlisa.g:176:4: (lv_description_8_0= ruleDescription )
                    // InternalAlisa.g:177:5: lv_description_8_0= ruleDescription
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAssuranceCaseAccess().getDescriptionDescriptionParserRuleCall_7_0());
                      				
                    }
                    pushFollow(FOLLOW_9);
                    lv_description_8_0=ruleDescription();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
                      					}
                      					set(
                      						current,
                      						"description",
                      						lv_description_8_0,
                      						"org.osate.alisa.common.Common.Description");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalAlisa.g:194:3: ( (lv_assurancePlans_9_0= ruleAssurancePlan ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==23) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // InternalAlisa.g:195:4: (lv_assurancePlans_9_0= ruleAssurancePlan )
            	    {
            	    // InternalAlisa.g:195:4: (lv_assurancePlans_9_0= ruleAssurancePlan )
            	    // InternalAlisa.g:196:5: lv_assurancePlans_9_0= ruleAssurancePlan
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAssuranceCaseAccess().getAssurancePlansAssurancePlanParserRuleCall_8_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_assurancePlans_9_0=ruleAssurancePlan();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
            	      					}
            	      					add(
            	      						current,
            	      						"assurancePlans",
            	      						lv_assurancePlans_9_0,
            	      						"org.osate.alisa.workbench.Alisa.AssurancePlan");
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

            // InternalAlisa.g:213:3: ( (lv_tasks_10_0= ruleAssuranceTask ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalAlisa.g:214:4: (lv_tasks_10_0= ruleAssuranceTask )
            	    {
            	    // InternalAlisa.g:214:4: (lv_tasks_10_0= ruleAssuranceTask )
            	    // InternalAlisa.g:215:5: lv_tasks_10_0= ruleAssuranceTask
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAssuranceCaseAccess().getTasksAssuranceTaskParserRuleCall_9_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_tasks_10_0=ruleAssuranceTask();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
            	      					}
            	      					add(
            	      						current,
            	      						"tasks",
            	      						lv_tasks_10_0,
            	      						"org.osate.alisa.workbench.Alisa.AssuranceTask");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_11=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getAssuranceCaseAccess().getRightSquareBracketKeyword_10());
              		
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
    // $ANTLR end "ruleAssuranceCase"


    // $ANTLR start "entryRuleAssurancePlan"
    // InternalAlisa.g:240:1: entryRuleAssurancePlan returns [EObject current=null] : iv_ruleAssurancePlan= ruleAssurancePlan EOF ;
    public final EObject entryRuleAssurancePlan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssurancePlan = null;


        try {
            // InternalAlisa.g:240:54: (iv_ruleAssurancePlan= ruleAssurancePlan EOF )
            // InternalAlisa.g:241:2: iv_ruleAssurancePlan= ruleAssurancePlan EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssurancePlanRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssurancePlan=ruleAssurancePlan();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssurancePlan; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssurancePlan"


    // $ANTLR start "ruleAssurancePlan"
    // InternalAlisa.g:247:1: ruleAssurancePlan returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_25= ']' ) ;
    public final EObject ruleAssurancePlan() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_title_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_assureAll_18_0=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_assumeAll_22_0=null;
        Token otherlv_23=null;
        Token lv_issues_24_0=null;
        Token otherlv_25=null;
        EObject lv_description_9_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:253:2: ( (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_25= ']' ) )
            // InternalAlisa.g:254:2: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_25= ']' )
            {
            // InternalAlisa.g:254:2: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_25= ']' )
            // InternalAlisa.g:255:3: otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_25= ']'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAssurancePlanAccess().getAssuranceKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,23,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAssurancePlanAccess().getPlanKeyword_1());
              		
            }
            // InternalAlisa.g:263:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalAlisa.g:264:4: (lv_name_2_0= RULE_ID )
            {
            // InternalAlisa.g:264:4: (lv_name_2_0= RULE_ID )
            // InternalAlisa.g:265:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getAssurancePlanAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAssurancePlanRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalAlisa.g:281:3: (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalAlisa.g:282:4: otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAssurancePlanAccess().getColonKeyword_3_0());
                      			
                    }
                    // InternalAlisa.g:286:4: ( (lv_title_4_0= RULE_STRING ) )
                    // InternalAlisa.g:287:5: (lv_title_4_0= RULE_STRING )
                    {
                    // InternalAlisa.g:287:5: (lv_title_4_0= RULE_STRING )
                    // InternalAlisa.g:288:6: lv_title_4_0= RULE_STRING
                    {
                    lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_title_4_0, grammarAccess.getAssurancePlanAccess().getTitleSTRINGTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssurancePlanRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"title",
                      							lv_title_4_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getAssurancePlanAccess().getForKeyword_4());
              		
            }
            // InternalAlisa.g:309:3: ( ( ruleAadlClassifierReference ) )
            // InternalAlisa.g:310:4: ( ruleAadlClassifierReference )
            {
            // InternalAlisa.g:310:4: ( ruleAadlClassifierReference )
            // InternalAlisa.g:311:5: ruleAadlClassifierReference
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAssurancePlanRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssurancePlanAccess().getTargetComponentImplementationCrossReference_5_0());
              				
            }
            pushFollow(FOLLOW_8);
            ruleAadlClassifierReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,21,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getAssurancePlanAccess().getLeftSquareBracketKeyword_6());
              		
            }
            // InternalAlisa.g:329:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )* ) ) )
            // InternalAlisa.g:330:4: ( ( ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            {
            // InternalAlisa.g:330:4: ( ( ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            // InternalAlisa.g:331:5: ( ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            // InternalAlisa.g:334:5: ( ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )* )
            // InternalAlisa.g:335:6: ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )*
            {
            // InternalAlisa.g:335:6: ( ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) ) )*
            loop13:
            do {
                int alt13=7;
                int LA13_0 = input.LA(1);

                if ( LA13_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0) ) {
                    alt13=1;
                }
                else if ( LA13_0 == 24 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) || getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) ) {
                    int LA13_3 = input.LA(2);

                    if ( LA13_3 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) {
                        alt13=3;
                    }
                    else if ( LA13_3 == RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) ) {
                        alt13=2;
                    }
                    else if ( LA13_3 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) ) {
                        alt13=4;
                    }


                }
                else if ( LA13_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4) ) {
                    alt13=5;
                }
                else if ( LA13_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 5) ) {
                    alt13=6;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalAlisa.g:336:4: ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) )
            	    {
            	    // InternalAlisa.g:336:4: ({...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) ) )
            	    // InternalAlisa.g:337:5: {...}? => ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // InternalAlisa.g:337:110: ( ({...}? => ( (lv_description_9_0= ruleDescription ) ) ) )
            	    // InternalAlisa.g:338:6: ({...}? => ( (lv_description_9_0= ruleDescription ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0);
            	    // InternalAlisa.g:341:9: ({...}? => ( (lv_description_9_0= ruleDescription ) ) )
            	    // InternalAlisa.g:341:10: {...}? => ( (lv_description_9_0= ruleDescription ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // InternalAlisa.g:341:19: ( (lv_description_9_0= ruleDescription ) )
            	    // InternalAlisa.g:341:20: (lv_description_9_0= ruleDescription )
            	    {
            	    // InternalAlisa.g:341:20: (lv_description_9_0= ruleDescription )
            	    // InternalAlisa.g:342:10: lv_description_9_0= ruleDescription
            	    {
            	    if ( state.backtracking==0 ) {

            	      										newCompositeNode(grammarAccess.getAssurancePlanAccess().getDescriptionDescriptionParserRuleCall_7_0_0());
            	      									
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_description_9_0=ruleDescription();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										if (current==null) {
            	      											current = createModelElementForParent(grammarAccess.getAssurancePlanRule());
            	      										}
            	      										set(
            	      											current,
            	      											"description",
            	      											lv_description_9_0,
            	      											"org.osate.alisa.common.Common.Description");
            	      										afterParserOrEnumRuleCall();
            	      									
            	    }

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalAlisa.g:364:4: ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // InternalAlisa.g:364:4: ({...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // InternalAlisa.g:365:5: {...}? => ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // InternalAlisa.g:365:110: ( ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) ) )
            	    // InternalAlisa.g:366:6: ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1);
            	    // InternalAlisa.g:369:9: ({...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ ) )
            	    // InternalAlisa.g:369:10: {...}? => (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // InternalAlisa.g:369:19: (otherlv_10= 'assure' ( ( ruleQualifiedName ) )+ )
            	    // InternalAlisa.g:369:20: otherlv_10= 'assure' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_10=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_10, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_1_0());
            	      								
            	    }
            	    // InternalAlisa.g:373:9: ( ( ruleQualifiedName ) )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==RULE_ID) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalAlisa.g:374:10: ( ruleQualifiedName )
            	    	    {
            	    	    // InternalAlisa.g:374:10: ( ruleQualifiedName )
            	    	    // InternalAlisa.g:375:11: ruleQualifiedName
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											if (current==null) {
            	    	      												current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	      											}
            	    	      										
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      											newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssureVerificationPlanCrossReference_7_1_1_0());
            	    	      										
            	    	    }
            	    	    pushFollow(FOLLOW_14);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											afterParserOrEnumRuleCall();
            	    	      										
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt6 >= 1 ) break loop6;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(6, input);
            	                throw eee;
            	        }
            	        cnt6++;
            	    } while (true);


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalAlisa.g:395:4: ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // InternalAlisa.g:395:4: ({...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // InternalAlisa.g:396:5: {...}? => ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // InternalAlisa.g:396:110: ( ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) ) )
            	    // InternalAlisa.g:397:6: ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2);
            	    // InternalAlisa.g:400:9: ({...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ ) )
            	    // InternalAlisa.g:400:10: {...}? => (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // InternalAlisa.g:400:19: (otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+ )
            	    // InternalAlisa.g:400:20: otherlv_12= 'assure' otherlv_13= 'global' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_12=(Token)match(input,24,FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_12, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_2_0());
            	      								
            	    }
            	    otherlv_13=(Token)match(input,25,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_13, grammarAccess.getAssurancePlanAccess().getGlobalKeyword_7_2_1());
            	      								
            	    }
            	    // InternalAlisa.g:408:9: ( ( ruleQualifiedName ) )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==RULE_ID) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // InternalAlisa.g:409:10: ( ruleQualifiedName )
            	    	    {
            	    	    // InternalAlisa.g:409:10: ( ruleQualifiedName )
            	    	    // InternalAlisa.g:410:11: ruleQualifiedName
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											if (current==null) {
            	    	      												current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	      											}
            	    	      										
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      											newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssureGlobalVerificationPlanCrossReference_7_2_2_0());
            	    	      										
            	    	    }
            	    	    pushFollow(FOLLOW_14);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											afterParserOrEnumRuleCall();
            	    	      										
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt7 >= 1 ) break loop7;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(7, input);
            	                throw eee;
            	        }
            	        cnt7++;
            	    } while (true);


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalAlisa.g:430:4: ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) )
            	    {
            	    // InternalAlisa.g:430:4: ({...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) ) )
            	    // InternalAlisa.g:431:5: {...}? => ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // InternalAlisa.g:431:110: ( ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) ) )
            	    // InternalAlisa.g:432:6: ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3);
            	    // InternalAlisa.g:435:9: ({...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) ) )
            	    // InternalAlisa.g:435:10: {...}? => (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // InternalAlisa.g:435:19: (otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) ) )
            	    // InternalAlisa.g:435:20: otherlv_15= 'assure' otherlv_16= 'subsystem' ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) )
            	    {
            	    otherlv_15=(Token)match(input,24,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_15, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_3_0());
            	      								
            	    }
            	    otherlv_16=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_16, grammarAccess.getAssurancePlanAccess().getSubsystemKeyword_7_3_1());
            	      								
            	    }
            	    // InternalAlisa.g:443:9: ( ( (otherlv_17= RULE_ID ) )+ | ( (lv_assureAll_18_0= 'all' ) ) )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==RULE_ID) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==27) ) {
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
            	            // InternalAlisa.g:444:10: ( (otherlv_17= RULE_ID ) )+
            	            {
            	            // InternalAlisa.g:444:10: ( (otherlv_17= RULE_ID ) )+
            	            int cnt8=0;
            	            loop8:
            	            do {
            	                int alt8=2;
            	                int LA8_0 = input.LA(1);

            	                if ( (LA8_0==RULE_ID) ) {
            	                    alt8=1;
            	                }


            	                switch (alt8) {
            	            	case 1 :
            	            	    // InternalAlisa.g:445:11: (otherlv_17= RULE_ID )
            	            	    {
            	            	    // InternalAlisa.g:445:11: (otherlv_17= RULE_ID )
            	            	    // InternalAlisa.g:446:12: otherlv_17= RULE_ID
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      												if (current==null) {
            	            	      													current = createModelElement(grammarAccess.getAssurancePlanRule());
            	            	      												}
            	            	      											
            	            	    }
            	            	    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      												newLeafNode(otherlv_17, grammarAccess.getAssurancePlanAccess().getAssureSubsystemsSubcomponentCrossReference_7_3_2_0_0());
            	            	      											
            	            	    }

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    if ( cnt8 >= 1 ) break loop8;
            	            	    if (state.backtracking>0) {state.failed=true; return current;}
            	                        EarlyExitException eee =
            	                            new EarlyExitException(8, input);
            	                        throw eee;
            	                }
            	                cnt8++;
            	            } while (true);


            	            }
            	            break;
            	        case 2 :
            	            // InternalAlisa.g:458:10: ( (lv_assureAll_18_0= 'all' ) )
            	            {
            	            // InternalAlisa.g:458:10: ( (lv_assureAll_18_0= 'all' ) )
            	            // InternalAlisa.g:459:11: (lv_assureAll_18_0= 'all' )
            	            {
            	            // InternalAlisa.g:459:11: (lv_assureAll_18_0= 'all' )
            	            // InternalAlisa.g:460:12: lv_assureAll_18_0= 'all'
            	            {
            	            lv_assureAll_18_0=(Token)match(input,27,FOLLOW_13); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              												newLeafNode(lv_assureAll_18_0, grammarAccess.getAssurancePlanAccess().getAssureAllAllKeyword_7_3_2_1_0());
            	              											
            	            }
            	            if ( state.backtracking==0 ) {

            	              												if (current==null) {
            	              													current = createModelElement(grammarAccess.getAssurancePlanRule());
            	              												}
            	              												setWithLastConsumed(current, "assureAll", true, "all");
            	              											
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalAlisa.g:479:4: ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) )
            	    {
            	    // InternalAlisa.g:479:4: ({...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) ) )
            	    // InternalAlisa.g:480:5: {...}? => ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4)");
            	    }
            	    // InternalAlisa.g:480:110: ( ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) ) )
            	    // InternalAlisa.g:481:6: ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4);
            	    // InternalAlisa.g:484:9: ({...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) ) )
            	    // InternalAlisa.g:484:10: {...}? => (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // InternalAlisa.g:484:19: (otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) ) )
            	    // InternalAlisa.g:484:20: otherlv_19= 'assume' otherlv_20= 'subsystem' ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) )
            	    {
            	    otherlv_19=(Token)match(input,28,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_19, grammarAccess.getAssurancePlanAccess().getAssumeKeyword_7_4_0());
            	      								
            	    }
            	    otherlv_20=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_20, grammarAccess.getAssurancePlanAccess().getSubsystemKeyword_7_4_1());
            	      								
            	    }
            	    // InternalAlisa.g:492:9: ( ( (otherlv_21= RULE_ID ) )+ | ( (lv_assumeAll_22_0= 'all' ) ) )
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==RULE_ID) ) {
            	        alt11=1;
            	    }
            	    else if ( (LA11_0==27) ) {
            	        alt11=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 11, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // InternalAlisa.g:493:10: ( (otherlv_21= RULE_ID ) )+
            	            {
            	            // InternalAlisa.g:493:10: ( (otherlv_21= RULE_ID ) )+
            	            int cnt10=0;
            	            loop10:
            	            do {
            	                int alt10=2;
            	                int LA10_0 = input.LA(1);

            	                if ( (LA10_0==RULE_ID) ) {
            	                    alt10=1;
            	                }


            	                switch (alt10) {
            	            	case 1 :
            	            	    // InternalAlisa.g:494:11: (otherlv_21= RULE_ID )
            	            	    {
            	            	    // InternalAlisa.g:494:11: (otherlv_21= RULE_ID )
            	            	    // InternalAlisa.g:495:12: otherlv_21= RULE_ID
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      												if (current==null) {
            	            	      													current = createModelElement(grammarAccess.getAssurancePlanRule());
            	            	      												}
            	            	      											
            	            	    }
            	            	    otherlv_21=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      												newLeafNode(otherlv_21, grammarAccess.getAssurancePlanAccess().getAssumeSubsystemsSubcomponentCrossReference_7_4_2_0_0());
            	            	      											
            	            	    }

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    if ( cnt10 >= 1 ) break loop10;
            	            	    if (state.backtracking>0) {state.failed=true; return current;}
            	                        EarlyExitException eee =
            	                            new EarlyExitException(10, input);
            	                        throw eee;
            	                }
            	                cnt10++;
            	            } while (true);


            	            }
            	            break;
            	        case 2 :
            	            // InternalAlisa.g:507:10: ( (lv_assumeAll_22_0= 'all' ) )
            	            {
            	            // InternalAlisa.g:507:10: ( (lv_assumeAll_22_0= 'all' ) )
            	            // InternalAlisa.g:508:11: (lv_assumeAll_22_0= 'all' )
            	            {
            	            // InternalAlisa.g:508:11: (lv_assumeAll_22_0= 'all' )
            	            // InternalAlisa.g:509:12: lv_assumeAll_22_0= 'all'
            	            {
            	            lv_assumeAll_22_0=(Token)match(input,27,FOLLOW_13); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              												newLeafNode(lv_assumeAll_22_0, grammarAccess.getAssurancePlanAccess().getAssumeAllAllKeyword_7_4_2_1_0());
            	              											
            	            }
            	            if ( state.backtracking==0 ) {

            	              												if (current==null) {
            	              													current = createModelElement(grammarAccess.getAssurancePlanRule());
            	              												}
            	              												setWithLastConsumed(current, "assumeAll", true, "all");
            	              											
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalAlisa.g:528:4: ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // InternalAlisa.g:528:4: ({...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) ) )
            	    // InternalAlisa.g:529:5: {...}? => ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 5) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 5)");
            	    }
            	    // InternalAlisa.g:529:110: ( ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) ) )
            	    // InternalAlisa.g:530:6: ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 5);
            	    // InternalAlisa.g:533:9: ({...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ ) )
            	    // InternalAlisa.g:533:10: {...}? => (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // InternalAlisa.g:533:19: (otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+ )
            	    // InternalAlisa.g:533:20: otherlv_23= 'issues' ( (lv_issues_24_0= RULE_STRING ) )+
            	    {
            	    otherlv_23=(Token)match(input,29,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_23, grammarAccess.getAssurancePlanAccess().getIssuesKeyword_7_5_0());
            	      								
            	    }
            	    // InternalAlisa.g:537:9: ( (lv_issues_24_0= RULE_STRING ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==RULE_STRING) ) {
            	            alt12=1;
            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // InternalAlisa.g:538:10: (lv_issues_24_0= RULE_STRING )
            	    	    {
            	    	    // InternalAlisa.g:538:10: (lv_issues_24_0= RULE_STRING )
            	    	    // InternalAlisa.g:539:11: lv_issues_24_0= RULE_STRING
            	    	    {
            	    	    lv_issues_24_0=(Token)match(input,RULE_STRING,FOLLOW_18); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											newLeafNode(lv_issues_24_0, grammarAccess.getAssurancePlanAccess().getIssuesSTRINGTerminalRuleCall_7_5_1_0());
            	    	      										
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      											if (current==null) {
            	    	      												current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	      											}
            	    	      											addWithLastConsumed(
            	    	      												current,
            	    	      												"issues",
            	    	      												lv_issues_24_0,
            	    	      												"org.eclipse.xtext.common.Terminals.STRING");
            	    	      										
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt12 >= 1 ) break loop12;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(12, input);
            	                throw eee;
            	        }
            	        cnt12++;
            	    } while (true);


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());

            }

            otherlv_25=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_25, grammarAccess.getAssurancePlanAccess().getRightSquareBracketKeyword_8());
              		
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
    // $ANTLR end "ruleAssurancePlan"


    // $ANTLR start "entryRuleAssuranceTask"
    // InternalAlisa.g:576:1: entryRuleAssuranceTask returns [EObject current=null] : iv_ruleAssuranceTask= ruleAssuranceTask EOF ;
    public final EObject entryRuleAssuranceTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssuranceTask = null;


        try {
            // InternalAlisa.g:576:54: (iv_ruleAssuranceTask= ruleAssuranceTask EOF )
            // InternalAlisa.g:577:2: iv_ruleAssuranceTask= ruleAssuranceTask EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssuranceTaskRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssuranceTask=ruleAssuranceTask();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssuranceTask; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssuranceTask"


    // $ANTLR start "ruleAssuranceTask"
    // InternalAlisa.g:583:1: ruleAssuranceTask returns [EObject current=null] : ( () otherlv_1= 'assurance' otherlv_2= 'task' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= ':' ( (lv_title_5_0= RULE_STRING ) ) )? otherlv_6= '[' ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_14= ']' ) ;
    public final EObject ruleAssuranceTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_title_5_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token lv_anyCategory_11_0=null;
        Token otherlv_12=null;
        Token lv_issues_13_0=null;
        Token otherlv_14=null;
        EObject lv_description_8_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:589:2: ( ( () otherlv_1= 'assurance' otherlv_2= 'task' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= ':' ( (lv_title_5_0= RULE_STRING ) ) )? otherlv_6= '[' ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_14= ']' ) )
            // InternalAlisa.g:590:2: ( () otherlv_1= 'assurance' otherlv_2= 'task' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= ':' ( (lv_title_5_0= RULE_STRING ) ) )? otherlv_6= '[' ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_14= ']' )
            {
            // InternalAlisa.g:590:2: ( () otherlv_1= 'assurance' otherlv_2= 'task' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= ':' ( (lv_title_5_0= RULE_STRING ) ) )? otherlv_6= '[' ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_14= ']' )
            // InternalAlisa.g:591:3: () otherlv_1= 'assurance' otherlv_2= 'task' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= ':' ( (lv_title_5_0= RULE_STRING ) ) )? otherlv_6= '[' ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_14= ']'
            {
            // InternalAlisa.g:591:3: ()
            // InternalAlisa.g:592:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAssuranceTaskAccess().getAssuranceTaskAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAssuranceTaskAccess().getAssuranceKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,30,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAssuranceTaskAccess().getTaskKeyword_2());
              		
            }
            // InternalAlisa.g:606:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalAlisa.g:607:4: (lv_name_3_0= RULE_ID )
            {
            // InternalAlisa.g:607:4: (lv_name_3_0= RULE_ID )
            // InternalAlisa.g:608:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_3_0, grammarAccess.getAssuranceTaskAccess().getNameIDTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAssuranceTaskRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_3_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalAlisa.g:624:3: (otherlv_4= ':' ( (lv_title_5_0= RULE_STRING ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==19) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalAlisa.g:625:4: otherlv_4= ':' ( (lv_title_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getAssuranceTaskAccess().getColonKeyword_4_0());
                      			
                    }
                    // InternalAlisa.g:629:4: ( (lv_title_5_0= RULE_STRING ) )
                    // InternalAlisa.g:630:5: (lv_title_5_0= RULE_STRING )
                    {
                    // InternalAlisa.g:630:5: (lv_title_5_0= RULE_STRING )
                    // InternalAlisa.g:631:6: lv_title_5_0= RULE_STRING
                    {
                    lv_title_5_0=(Token)match(input,RULE_STRING,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_title_5_0, grammarAccess.getAssuranceTaskAccess().getTitleSTRINGTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssuranceTaskRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"title",
                      							lv_title_5_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_5());
              		
            }
            // InternalAlisa.g:652:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )* ) ) )
            // InternalAlisa.g:653:4: ( ( ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            {
            // InternalAlisa.g:653:4: ( ( ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            // InternalAlisa.g:654:5: ( ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6());
            // InternalAlisa.g:657:5: ( ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )* )
            // InternalAlisa.g:658:6: ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )*
            {
            // InternalAlisa.g:658:6: ( ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) ) )*
            loop18:
            do {
                int alt18=4;
                int LA18_0 = input.LA(1);

                if ( LA18_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 0) ) {
                    alt18=1;
                }
                else if ( LA18_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 1) ) {
                    alt18=2;
                }
                else if ( LA18_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 2) ) {
                    alt18=3;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalAlisa.g:659:4: ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) )
            	    {
            	    // InternalAlisa.g:659:4: ({...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) ) )
            	    // InternalAlisa.g:660:5: {...}? => ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 0)");
            	    }
            	    // InternalAlisa.g:660:110: ( ({...}? => ( (lv_description_8_0= ruleDescription ) ) ) )
            	    // InternalAlisa.g:661:6: ({...}? => ( (lv_description_8_0= ruleDescription ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 0);
            	    // InternalAlisa.g:664:9: ({...}? => ( (lv_description_8_0= ruleDescription ) ) )
            	    // InternalAlisa.g:664:10: {...}? => ( (lv_description_8_0= ruleDescription ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // InternalAlisa.g:664:19: ( (lv_description_8_0= ruleDescription ) )
            	    // InternalAlisa.g:664:20: (lv_description_8_0= ruleDescription )
            	    {
            	    // InternalAlisa.g:664:20: (lv_description_8_0= ruleDescription )
            	    // InternalAlisa.g:665:10: lv_description_8_0= ruleDescription
            	    {
            	    if ( state.backtracking==0 ) {

            	      										newCompositeNode(grammarAccess.getAssuranceTaskAccess().getDescriptionDescriptionParserRuleCall_6_0_0());
            	      									
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_description_8_0=ruleDescription();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										if (current==null) {
            	      											current = createModelElementForParent(grammarAccess.getAssuranceTaskRule());
            	      										}
            	      										set(
            	      											current,
            	      											"description",
            	      											lv_description_8_0,
            	      											"org.osate.alisa.common.Common.Description");
            	      										afterParserOrEnumRuleCall();
            	      									
            	    }

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalAlisa.g:687:4: ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) )
            	    {
            	    // InternalAlisa.g:687:4: ({...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) ) )
            	    // InternalAlisa.g:688:5: {...}? => ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 1)");
            	    }
            	    // InternalAlisa.g:688:110: ( ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) ) )
            	    // InternalAlisa.g:689:6: ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 1);
            	    // InternalAlisa.g:692:9: ({...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? ) )
            	    // InternalAlisa.g:692:10: {...}? => (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // InternalAlisa.g:692:19: (otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )? )
            	    // InternalAlisa.g:692:20: otherlv_9= 'category' ( ( ruleQualifiedName ) )+ ( (lv_anyCategory_11_0= 'any' ) )?
            	    {
            	    otherlv_9=(Token)match(input,31,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_9, grammarAccess.getAssuranceTaskAccess().getCategoryKeyword_6_1_0());
            	      								
            	    }
            	    // InternalAlisa.g:696:9: ( ( ruleQualifiedName ) )+
            	    int cnt15=0;
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==RULE_ID) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // InternalAlisa.g:697:10: ( ruleQualifiedName )
            	    	    {
            	    	    // InternalAlisa.g:697:10: ( ruleQualifiedName )
            	    	    // InternalAlisa.g:698:11: ruleQualifiedName
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											if (current==null) {
            	    	      												current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	    	      											}
            	    	      										
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      											newCompositeNode(grammarAccess.getAssuranceTaskAccess().getCategoryCategoryCrossReference_6_1_1_0());
            	    	      										
            	    	    }
            	    	    pushFollow(FOLLOW_22);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											afterParserOrEnumRuleCall();
            	    	      										
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt15 >= 1 ) break loop15;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(15, input);
            	                throw eee;
            	        }
            	        cnt15++;
            	    } while (true);

            	    // InternalAlisa.g:712:9: ( (lv_anyCategory_11_0= 'any' ) )?
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( (LA16_0==32) ) {
            	        alt16=1;
            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // InternalAlisa.g:713:10: (lv_anyCategory_11_0= 'any' )
            	            {
            	            // InternalAlisa.g:713:10: (lv_anyCategory_11_0= 'any' )
            	            // InternalAlisa.g:714:11: lv_anyCategory_11_0= 'any'
            	            {
            	            lv_anyCategory_11_0=(Token)match(input,32,FOLLOW_21); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              											newLeafNode(lv_anyCategory_11_0, grammarAccess.getAssuranceTaskAccess().getAnyCategoryAnyKeyword_6_1_2_0());
            	              										
            	            }
            	            if ( state.backtracking==0 ) {

            	              											if (current==null) {
            	              												current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	              											}
            	              											setWithLastConsumed(current, "anyCategory", true, "any");
            	              										
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalAlisa.g:732:4: ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // InternalAlisa.g:732:4: ({...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) ) )
            	    // InternalAlisa.g:733:5: {...}? => ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 2)");
            	    }
            	    // InternalAlisa.g:733:110: ( ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) ) )
            	    // InternalAlisa.g:734:6: ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), 2);
            	    // InternalAlisa.g:737:9: ({...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ ) )
            	    // InternalAlisa.g:737:10: {...}? => (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // InternalAlisa.g:737:19: (otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+ )
            	    // InternalAlisa.g:737:20: otherlv_12= 'issues' ( (lv_issues_13_0= RULE_STRING ) )+
            	    {
            	    otherlv_12=(Token)match(input,29,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_12, grammarAccess.getAssuranceTaskAccess().getIssuesKeyword_6_2_0());
            	      								
            	    }
            	    // InternalAlisa.g:741:9: ( (lv_issues_13_0= RULE_STRING ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==RULE_STRING) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // InternalAlisa.g:742:10: (lv_issues_13_0= RULE_STRING )
            	    	    {
            	    	    // InternalAlisa.g:742:10: (lv_issues_13_0= RULE_STRING )
            	    	    // InternalAlisa.g:743:11: lv_issues_13_0= RULE_STRING
            	    	    {
            	    	    lv_issues_13_0=(Token)match(input,RULE_STRING,FOLLOW_23); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											newLeafNode(lv_issues_13_0, grammarAccess.getAssuranceTaskAccess().getIssuesSTRINGTerminalRuleCall_6_2_1_0());
            	    	      										
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      											if (current==null) {
            	    	      												current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	    	      											}
            	    	      											addWithLastConsumed(
            	    	      												current,
            	    	      												"issues",
            	    	      												lv_issues_13_0,
            	    	      												"org.eclipse.xtext.common.Terminals.STRING");
            	    	      										
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt17 >= 1 ) break loop17;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(17, input);
            	                throw eee;
            	        }
            	        cnt17++;
            	    } while (true);


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6());

            }

            otherlv_14=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_14, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_7());
              		
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
    // $ANTLR end "ruleAssuranceTask"


    // $ANTLR start "entryRuleDescription"
    // InternalAlisa.g:780:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // InternalAlisa.g:780:52: (iv_ruleDescription= ruleDescription EOF )
            // InternalAlisa.g:781:2: iv_ruleDescription= ruleDescription EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDescription=ruleDescription();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescription; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescription"


    // $ANTLR start "ruleDescription"
    // InternalAlisa.g:787:1: ruleDescription returns [EObject current=null] : (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ ) ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_description_1_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:793:2: ( (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ ) )
            // InternalAlisa.g:794:2: (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ )
            {
            // InternalAlisa.g:794:2: (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ )
            // InternalAlisa.g:795:3: otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+
            {
            otherlv_0=(Token)match(input,33,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDescriptionAccess().getDescriptionKeyword_0());
              		
            }
            // InternalAlisa.g:799:3: ( (lv_description_1_0= ruleDescriptionElement ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_ID)||LA19_0==34||LA19_0==46) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalAlisa.g:800:4: (lv_description_1_0= ruleDescriptionElement )
            	    {
            	    // InternalAlisa.g:800:4: (lv_description_1_0= ruleDescriptionElement )
            	    // InternalAlisa.g:801:5: lv_description_1_0= ruleDescriptionElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_description_1_0=ruleDescriptionElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDescriptionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"description",
            	      						lv_description_1_0,
            	      						"org.osate.alisa.common.Common.DescriptionElement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
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
    // $ANTLR end "ruleDescription"


    // $ANTLR start "entryRuleDescriptionElement"
    // InternalAlisa.g:822:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // InternalAlisa.g:822:59: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // InternalAlisa.g:823:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescriptionElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescriptionElement"


    // $ANTLR start "ruleDescriptionElement"
    // InternalAlisa.g:829:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) ) | ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) ) | ( (lv_showValue_3_0= ruleShowValue ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_thisTarget_1_0=null;
        EObject lv_image_2_0 = null;

        EObject lv_showValue_3_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:835:2: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) ) | ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) ) | ( (lv_showValue_3_0= ruleShowValue ) ) ) )
            // InternalAlisa.g:836:2: ( ( (lv_text_0_0= RULE_STRING ) ) | ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) ) | ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) ) | ( (lv_showValue_3_0= ruleShowValue ) ) )
            {
            // InternalAlisa.g:836:2: ( ( (lv_text_0_0= RULE_STRING ) ) | ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) ) | ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) ) | ( (lv_showValue_3_0= ruleShowValue ) ) )
            int alt20=4;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_STRING) ) {
                alt20=1;
            }
            else if ( (LA20_0==34) && (synpred1_InternalAlisa())) {
                alt20=2;
            }
            else if ( (LA20_0==46) && (synpred2_InternalAlisa())) {
                alt20=3;
            }
            else if ( (LA20_0==RULE_ID) ) {
                alt20=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalAlisa.g:837:3: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // InternalAlisa.g:837:3: ( (lv_text_0_0= RULE_STRING ) )
                    // InternalAlisa.g:838:4: (lv_text_0_0= RULE_STRING )
                    {
                    // InternalAlisa.g:838:4: (lv_text_0_0= RULE_STRING )
                    // InternalAlisa.g:839:5: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_text_0_0, grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getDescriptionElementRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"text",
                      						lv_text_0_0,
                      						"org.eclipse.xtext.common.Terminals.STRING");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAlisa.g:856:3: ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) )
                    {
                    // InternalAlisa.g:856:3: ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) )
                    // InternalAlisa.g:857:4: ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' )
                    {
                    // InternalAlisa.g:861:4: (lv_thisTarget_1_0= 'this' )
                    // InternalAlisa.g:862:5: lv_thisTarget_1_0= 'this'
                    {
                    lv_thisTarget_1_0=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_thisTarget_1_0, grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getDescriptionElementRule());
                      					}
                      					setWithLastConsumed(current, "thisTarget", true, "this");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAlisa.g:875:3: ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) )
                    {
                    // InternalAlisa.g:875:3: ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) )
                    // InternalAlisa.g:876:4: ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference )
                    {
                    // InternalAlisa.g:880:4: (lv_image_2_0= ruleImageReference )
                    // InternalAlisa.g:881:5: lv_image_2_0= ruleImageReference
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_image_2_0=ruleImageReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                      					}
                      					set(
                      						current,
                      						"image",
                      						lv_image_2_0,
                      						"org.osate.alisa.common.Common.ImageReference");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalAlisa.g:899:3: ( (lv_showValue_3_0= ruleShowValue ) )
                    {
                    // InternalAlisa.g:899:3: ( (lv_showValue_3_0= ruleShowValue ) )
                    // InternalAlisa.g:900:4: (lv_showValue_3_0= ruleShowValue )
                    {
                    // InternalAlisa.g:900:4: (lv_showValue_3_0= ruleShowValue )
                    // InternalAlisa.g:901:5: lv_showValue_3_0= ruleShowValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_showValue_3_0=ruleShowValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                      					}
                      					set(
                      						current,
                      						"showValue",
                      						lv_showValue_3_0,
                      						"org.osate.alisa.common.Common.ShowValue");
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
    // $ANTLR end "ruleDescriptionElement"


    // $ANTLR start "entryRuleTypeRef"
    // InternalAlisa.g:922:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // InternalAlisa.g:922:48: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalAlisa.g:923:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalAlisa.g:929:1: ruleTypeRef returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;


        	enterRule();

        try {
            // InternalAlisa.g:935:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ) )
            // InternalAlisa.g:936:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            {
            // InternalAlisa.g:936:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            int alt23=6;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt23=1;
                }
                break;
            case 36:
                {
                alt23=2;
                }
                break;
            case 38:
                {
                alt23=3;
                }
                break;
            case 39:
                {
                alt23=4;
                }
                break;
            case 40:
                {
                alt23=5;
                }
                break;
            case RULE_ID:
                {
                alt23=6;
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
                    // InternalAlisa.g:937:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalAlisa.g:937:3: ( () otherlv_1= 'boolean' )
                    // InternalAlisa.g:938:4: () otherlv_1= 'boolean'
                    {
                    // InternalAlisa.g:938:4: ()
                    // InternalAlisa.g:939:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getAadlBooleanAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypeRefAccess().getBooleanKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAlisa.g:951:3: ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // InternalAlisa.g:951:3: ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // InternalAlisa.g:952:4: () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    // InternalAlisa.g:952:4: ()
                    // InternalAlisa.g:953:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getAadlIntegerAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,36,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getTypeRefAccess().getIntegerKeyword_1_1());
                      			
                    }
                    // InternalAlisa.g:963:4: (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==37) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalAlisa.g:964:5: otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            otherlv_4=(Token)match(input,37,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getTypeRefAccess().getUnitsKeyword_1_2_0());
                              				
                            }
                            // InternalAlisa.g:968:5: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // InternalAlisa.g:969:6: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // InternalAlisa.g:969:6: ( ruleAADLPROPERTYREFERENCE )
                            // InternalAlisa.g:970:7: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getTypeRefRule());
                              							}
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            ruleAADLPROPERTYREFERENCE();

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
                    break;
                case 3 :
                    // InternalAlisa.g:987:3: ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // InternalAlisa.g:987:3: ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // InternalAlisa.g:988:4: () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    // InternalAlisa.g:988:4: ()
                    // InternalAlisa.g:989:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getAadlRealAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,38,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getTypeRefAccess().getRealKeyword_2_1());
                      			
                    }
                    // InternalAlisa.g:999:4: (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==37) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalAlisa.g:1000:5: otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            otherlv_8=(Token)match(input,37,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_8, grammarAccess.getTypeRefAccess().getUnitsKeyword_2_2_0());
                              				
                            }
                            // InternalAlisa.g:1004:5: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // InternalAlisa.g:1005:6: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // InternalAlisa.g:1005:6: ( ruleAADLPROPERTYREFERENCE )
                            // InternalAlisa.g:1006:7: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getTypeRefRule());
                              							}
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            ruleAADLPROPERTYREFERENCE();

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
                    break;
                case 4 :
                    // InternalAlisa.g:1023:3: ( () otherlv_11= 'string' )
                    {
                    // InternalAlisa.g:1023:3: ( () otherlv_11= 'string' )
                    // InternalAlisa.g:1024:4: () otherlv_11= 'string'
                    {
                    // InternalAlisa.g:1024:4: ()
                    // InternalAlisa.g:1025:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getAadlStringAction_3_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_11=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getTypeRefAccess().getStringKeyword_3_1());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalAlisa.g:1037:3: ( () otherlv_13= 'model' otherlv_14= 'element' )
                    {
                    // InternalAlisa.g:1037:3: ( () otherlv_13= 'model' otherlv_14= 'element' )
                    // InternalAlisa.g:1038:4: () otherlv_13= 'model' otherlv_14= 'element'
                    {
                    // InternalAlisa.g:1038:4: ()
                    // InternalAlisa.g:1039:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getModelRefAction_4_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_13=(Token)match(input,40,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getTypeRefAccess().getModelKeyword_4_1());
                      			
                    }
                    otherlv_14=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getTypeRefAccess().getElementKeyword_4_2());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalAlisa.g:1055:3: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
                    {
                    // InternalAlisa.g:1055:3: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
                    // InternalAlisa.g:1056:4: () ( ( ruleAADLPROPERTYREFERENCE ) )
                    {
                    // InternalAlisa.g:1056:4: ()
                    // InternalAlisa.g:1057:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getTypeRefAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAlisa.g:1063:4: ( ( ruleAADLPROPERTYREFERENCE ) )
                    // InternalAlisa.g:1064:5: ( ruleAADLPROPERTYREFERENCE )
                    {
                    // InternalAlisa.g:1064:5: ( ruleAADLPROPERTYREFERENCE )
                    // InternalAlisa.g:1065:6: ruleAADLPROPERTYREFERENCE
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTypeRefRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeRefAccess().getRefPropertyTypeCrossReference_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleAADLPROPERTYREFERENCE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRulePropertyRef"
    // InternalAlisa.g:1084:1: entryRulePropertyRef returns [EObject current=null] : iv_rulePropertyRef= rulePropertyRef EOF ;
    public final EObject entryRulePropertyRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyRef = null;


        try {
            // InternalAlisa.g:1084:52: (iv_rulePropertyRef= rulePropertyRef EOF )
            // InternalAlisa.g:1085:2: iv_rulePropertyRef= rulePropertyRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyRef=rulePropertyRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyRef"


    // $ANTLR start "rulePropertyRef"
    // InternalAlisa.g:1091:1: rulePropertyRef returns [EObject current=null] : ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ;
    public final EObject rulePropertyRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalAlisa.g:1097:2: ( ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            // InternalAlisa.g:1098:2: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
            {
            // InternalAlisa.g:1098:2: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
            // InternalAlisa.g:1099:3: () ( ( ruleAADLPROPERTYREFERENCE ) )
            {
            // InternalAlisa.g:1099:3: ()
            // InternalAlisa.g:1100:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPropertyRefAccess().getPropertyRefAction_0(),
              					current);
              			
            }

            }

            // InternalAlisa.g:1106:3: ( ( ruleAADLPROPERTYREFERENCE ) )
            // InternalAlisa.g:1107:4: ( ruleAADLPROPERTYREFERENCE )
            {
            // InternalAlisa.g:1107:4: ( ruleAADLPROPERTYREFERENCE )
            // InternalAlisa.g:1108:5: ruleAADLPROPERTYREFERENCE
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPropertyRefRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyRefAccess().getRefPropertyCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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
    // $ANTLR end "rulePropertyRef"


    // $ANTLR start "entryRuleAModelOrPropertyReference"
    // InternalAlisa.g:1126:1: entryRuleAModelOrPropertyReference returns [EObject current=null] : iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF ;
    public final EObject entryRuleAModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAModelOrPropertyReference = null;


        try {
            // InternalAlisa.g:1126:66: (iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF )
            // InternalAlisa.g:1127:2: iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAModelOrPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAModelOrPropertyReference=ruleAModelOrPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAModelOrPropertyReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAModelOrPropertyReference"


    // $ANTLR start "ruleAModelOrPropertyReference"
    // InternalAlisa.g:1133:1: ruleAModelOrPropertyReference returns [EObject current=null] : ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference ) ;
    public final EObject ruleAModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AModelReference_0 = null;

        EObject this_APropertyReference_4 = null;



        	enterRule();

        try {
            // InternalAlisa.g:1139:2: ( ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference ) )
            // InternalAlisa.g:1140:2: ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference )
            {
            // InternalAlisa.g:1140:2: ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            else if ( (LA25_0==42) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalAlisa.g:1141:3: (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // InternalAlisa.g:1141:3: (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // InternalAlisa.g:1142:4: this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAModelReferenceParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_28);
                    this_AModelReference_0=ruleAModelReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_AModelReference_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalAlisa.g:1150:4: ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==42) && (synpred3_InternalAlisa())) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalAlisa.g:1151:5: ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            // InternalAlisa.g:1151:5: ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) )
                            // InternalAlisa.g:1152:6: ( ( () '#' ) )=> ( () otherlv_2= '#' )
                            {
                            // InternalAlisa.g:1158:6: ( () otherlv_2= '#' )
                            // InternalAlisa.g:1159:7: () otherlv_2= '#'
                            {
                            // InternalAlisa.g:1159:7: ()
                            // InternalAlisa.g:1160:8: 
                            {
                            if ( state.backtracking==0 ) {

                              								current = forceCreateModelElementAndSet(
                              									grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0(),
                              									current);
                              							
                            }

                            }

                            otherlv_2=(Token)match(input,42,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_2, grammarAccess.getAModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1());
                              						
                            }

                            }


                            }

                            // InternalAlisa.g:1172:5: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // InternalAlisa.g:1173:6: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // InternalAlisa.g:1173:6: ( ruleAADLPROPERTYREFERENCE )
                            // InternalAlisa.g:1174:7: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAModelOrPropertyReferenceRule());
                              							}
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            ruleAADLPROPERTYREFERENCE();

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
                    break;
                case 2 :
                    // InternalAlisa.g:1191:3: this_APropertyReference_4= ruleAPropertyReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_APropertyReference_4=ruleAPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_APropertyReference_4;
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
    // $ANTLR end "ruleAModelOrPropertyReference"


    // $ANTLR start "entryRuleAModelReference"
    // InternalAlisa.g:1203:1: entryRuleAModelReference returns [EObject current=null] : iv_ruleAModelReference= ruleAModelReference EOF ;
    public final EObject entryRuleAModelReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAModelReference = null;


        try {
            // InternalAlisa.g:1203:56: (iv_ruleAModelReference= ruleAModelReference EOF )
            // InternalAlisa.g:1204:2: iv_ruleAModelReference= ruleAModelReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAModelReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAModelReference=ruleAModelReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAModelReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAModelReference"


    // $ANTLR start "ruleAModelReference"
    // InternalAlisa.g:1210:1: ruleAModelReference returns [EObject current=null] : ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleAModelReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalAlisa.g:1216:2: ( ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) )
            // InternalAlisa.g:1217:2: ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            {
            // InternalAlisa.g:1217:2: ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            // InternalAlisa.g:1218:3: ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            {
            // InternalAlisa.g:1218:3: ( ( ruleThisKeyword ) )
            // InternalAlisa.g:1219:4: ( ruleThisKeyword )
            {
            // InternalAlisa.g:1219:4: ( ruleThisKeyword )
            // InternalAlisa.g:1220:5: ruleThisKeyword
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAModelReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_29);
            ruleThisKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAlisa.g:1234:3: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==43) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalAlisa.g:1235:4: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
            	    {
            	    // InternalAlisa.g:1235:4: ()
            	    // InternalAlisa.g:1236:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAModelReferenceAccess().getAModelReferencePrevAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAModelReferenceAccess().getFullStopKeyword_1_1());
            	      			
            	    }
            	    // InternalAlisa.g:1246:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalAlisa.g:1247:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalAlisa.g:1247:5: (otherlv_3= RULE_ID )
            	    // InternalAlisa.g:1248:6: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getAModelReferenceRule());
            	      						}
            	      					
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_3, grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_1_2_0());
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // $ANTLR end "ruleAModelReference"


    // $ANTLR start "entryRuleAPropertyReference"
    // InternalAlisa.g:1264:1: entryRuleAPropertyReference returns [EObject current=null] : iv_ruleAPropertyReference= ruleAPropertyReference EOF ;
    public final EObject entryRuleAPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPropertyReference = null;


        try {
            // InternalAlisa.g:1264:59: (iv_ruleAPropertyReference= ruleAPropertyReference EOF )
            // InternalAlisa.g:1265:2: iv_ruleAPropertyReference= ruleAPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAPropertyReference=ruleAPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPropertyReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAPropertyReference"


    // $ANTLR start "ruleAPropertyReference"
    // InternalAlisa.g:1271:1: ruleAPropertyReference returns [EObject current=null] : ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) ) ;
    public final EObject ruleAPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalAlisa.g:1277:2: ( ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            // InternalAlisa.g:1278:2: ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            {
            // InternalAlisa.g:1278:2: ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            // InternalAlisa.g:1279:3: () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) )
            {
            // InternalAlisa.g:1279:3: ()
            // InternalAlisa.g:1280:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,42,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAPropertyReferenceAccess().getNumberSignKeyword_1());
              		
            }
            // InternalAlisa.g:1290:3: ( ( ruleAADLPROPERTYREFERENCE ) )
            // InternalAlisa.g:1291:4: ( ruleAADLPROPERTYREFERENCE )
            {
            // InternalAlisa.g:1291:4: ( ruleAADLPROPERTYREFERENCE )
            // InternalAlisa.g:1292:5: ruleAADLPROPERTYREFERENCE
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAPropertyReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleAPropertyReference"


    // $ANTLR start "entryRuleAVariableReference"
    // InternalAlisa.g:1310:1: entryRuleAVariableReference returns [EObject current=null] : iv_ruleAVariableReference= ruleAVariableReference EOF ;
    public final EObject entryRuleAVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAVariableReference = null;


        try {
            // InternalAlisa.g:1310:59: (iv_ruleAVariableReference= ruleAVariableReference EOF )
            // InternalAlisa.g:1311:2: iv_ruleAVariableReference= ruleAVariableReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAVariableReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAVariableReference=ruleAVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAVariableReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAVariableReference"


    // $ANTLR start "ruleAVariableReference"
    // InternalAlisa.g:1317:1: ruleAVariableReference returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleAVariableReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalAlisa.g:1323:2: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // InternalAlisa.g:1324:2: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalAlisa.g:1324:2: ( () ( (otherlv_1= RULE_ID ) ) )
            // InternalAlisa.g:1325:3: () ( (otherlv_1= RULE_ID ) )
            {
            // InternalAlisa.g:1325:3: ()
            // InternalAlisa.g:1326:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0(),
              					current);
              			
            }

            }

            // InternalAlisa.g:1332:3: ( (otherlv_1= RULE_ID ) )
            // InternalAlisa.g:1333:4: (otherlv_1= RULE_ID )
            {
            // InternalAlisa.g:1333:4: (otherlv_1= RULE_ID )
            // InternalAlisa.g:1334:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAVariableReferenceRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationCrossReference_1_0());
              				
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
    // $ANTLR end "ruleAVariableReference"


    // $ANTLR start "entryRuleShowValue"
    // InternalAlisa.g:1349:1: entryRuleShowValue returns [EObject current=null] : iv_ruleShowValue= ruleShowValue EOF ;
    public final EObject entryRuleShowValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShowValue = null;


        try {
            // InternalAlisa.g:1349:50: (iv_ruleShowValue= ruleShowValue EOF )
            // InternalAlisa.g:1350:2: iv_ruleShowValue= ruleShowValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShowValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShowValue=ruleShowValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShowValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShowValue"


    // $ANTLR start "ruleShowValue"
    // InternalAlisa.g:1356:1: ruleShowValue returns [EObject current=null] : ( ( (lv_expression_0_0= ruleAVariableReference ) ) ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleShowValue() throws RecognitionException {
        EObject current = null;

        Token lv_convert_1_0=null;
        Token lv_drop_2_0=null;
        Token otherlv_3=null;
        EObject lv_expression_0_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:1362:2: ( ( ( (lv_expression_0_0= ruleAVariableReference ) ) ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalAlisa.g:1363:2: ( ( (lv_expression_0_0= ruleAVariableReference ) ) ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalAlisa.g:1363:2: ( ( (lv_expression_0_0= ruleAVariableReference ) ) ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )? )
            // InternalAlisa.g:1364:3: ( (lv_expression_0_0= ruleAVariableReference ) ) ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalAlisa.g:1364:3: ( (lv_expression_0_0= ruleAVariableReference ) )
            // InternalAlisa.g:1365:4: (lv_expression_0_0= ruleAVariableReference )
            {
            // InternalAlisa.g:1365:4: (lv_expression_0_0= ruleAVariableReference )
            // InternalAlisa.g:1366:5: lv_expression_0_0= ruleAVariableReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getShowValueAccess().getExpressionAVariableReferenceParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_30);
            lv_expression_0_0=ruleAVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getShowValueRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_0_0,
              						"org.osate.alisa.common.Common.AVariableReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAlisa.g:1383:3: ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=44 && LA28_0<=45)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAlisa.g:1384:4: ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalAlisa.g:1384:4: ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==44) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==45) ) {
                        alt27=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalAlisa.g:1385:5: ( (lv_convert_1_0= '%' ) )
                            {
                            // InternalAlisa.g:1385:5: ( (lv_convert_1_0= '%' ) )
                            // InternalAlisa.g:1386:6: (lv_convert_1_0= '%' )
                            {
                            // InternalAlisa.g:1386:6: (lv_convert_1_0= '%' )
                            // InternalAlisa.g:1387:7: lv_convert_1_0= '%'
                            {
                            lv_convert_1_0=(Token)match(input,44,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_convert_1_0, grammarAccess.getShowValueAccess().getConvertPercentSignKeyword_1_0_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getShowValueRule());
                              							}
                              							setWithLastConsumed(current, "convert", true, "%");
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalAlisa.g:1400:5: ( (lv_drop_2_0= 'in' ) )
                            {
                            // InternalAlisa.g:1400:5: ( (lv_drop_2_0= 'in' ) )
                            // InternalAlisa.g:1401:6: (lv_drop_2_0= 'in' )
                            {
                            // InternalAlisa.g:1401:6: (lv_drop_2_0= 'in' )
                            // InternalAlisa.g:1402:7: lv_drop_2_0= 'in'
                            {
                            lv_drop_2_0=(Token)match(input,45,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_drop_2_0, grammarAccess.getShowValueAccess().getDropInKeyword_1_0_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getShowValueRule());
                              							}
                              							setWithLastConsumed(current, "drop", true, "in");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalAlisa.g:1415:4: ( (otherlv_3= RULE_ID ) )
                    // InternalAlisa.g:1416:5: (otherlv_3= RULE_ID )
                    {
                    // InternalAlisa.g:1416:5: (otherlv_3= RULE_ID )
                    // InternalAlisa.g:1417:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getShowValueRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_0());
                      					
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
    // $ANTLR end "ruleShowValue"


    // $ANTLR start "entryRuleImageReference"
    // InternalAlisa.g:1433:1: entryRuleImageReference returns [EObject current=null] : iv_ruleImageReference= ruleImageReference EOF ;
    public final EObject entryRuleImageReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageReference = null;


        try {
            // InternalAlisa.g:1433:55: (iv_ruleImageReference= ruleImageReference EOF )
            // InternalAlisa.g:1434:2: iv_ruleImageReference= ruleImageReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImageReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImageReference=ruleImageReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImageReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImageReference"


    // $ANTLR start "ruleImageReference"
    // InternalAlisa.g:1440:1: ruleImageReference returns [EObject current=null] : (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) ;
    public final EObject ruleImageReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_imgfile_1_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:1446:2: ( (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) )
            // InternalAlisa.g:1447:2: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            {
            // InternalAlisa.g:1447:2: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            // InternalAlisa.g:1448:3: otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImageReferenceAccess().getImgKeyword_0());
              		
            }
            // InternalAlisa.g:1452:3: ( (lv_imgfile_1_0= ruleIMGREF ) )
            // InternalAlisa.g:1453:4: (lv_imgfile_1_0= ruleIMGREF )
            {
            // InternalAlisa.g:1453:4: (lv_imgfile_1_0= ruleIMGREF )
            // InternalAlisa.g:1454:5: lv_imgfile_1_0= ruleIMGREF
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_imgfile_1_0=ruleIMGREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getImageReferenceRule());
              					}
              					set(
              						current,
              						"imgfile",
              						lv_imgfile_1_0,
              						"org.osate.alisa.common.Common.IMGREF");
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
    // $ANTLR end "ruleImageReference"


    // $ANTLR start "entryRuleIMGREF"
    // InternalAlisa.g:1475:1: entryRuleIMGREF returns [String current=null] : iv_ruleIMGREF= ruleIMGREF EOF ;
    public final String entryRuleIMGREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMGREF = null;


        try {
            // InternalAlisa.g:1475:46: (iv_ruleIMGREF= ruleIMGREF EOF )
            // InternalAlisa.g:1476:2: iv_ruleIMGREF= ruleIMGREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIMGREFRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIMGREF=ruleIMGREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIMGREF.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIMGREF"


    // $ANTLR start "ruleIMGREF"
    // InternalAlisa.g:1482:1: ruleIMGREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIMGREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;


        	enterRule();

        try {
            // InternalAlisa.g:1488:2: ( ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // InternalAlisa.g:1489:2: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // InternalAlisa.g:1489:2: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // InternalAlisa.g:1490:3: (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // InternalAlisa.g:1490:3: (this_ID_0= RULE_ID kw= '/' )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    int LA29_1 = input.LA(2);

                    if ( (LA29_1==47) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // InternalAlisa.g:1491:4: this_ID_0= RULE_ID kw= '/'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_0);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_0, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0());
            	      			
            	    }
            	    kw=(Token)match(input,47,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_2);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_2, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1());
              		
            }
            kw=(Token)match(input,43,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getIMGREFAccess().getFullStopKeyword_2());
              		
            }
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_4);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_4, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_3());
              		
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
    // $ANTLR end "ruleIMGREF"


    // $ANTLR start "entryRuleAExpression"
    // InternalAlisa.g:1527:1: entryRuleAExpression returns [EObject current=null] : iv_ruleAExpression= ruleAExpression EOF ;
    public final EObject entryRuleAExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExpression = null;


        try {
            // InternalAlisa.g:1527:52: (iv_ruleAExpression= ruleAExpression EOF )
            // InternalAlisa.g:1528:2: iv_ruleAExpression= ruleAExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAExpression=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAExpression"


    // $ANTLR start "ruleAExpression"
    // InternalAlisa.g:1534:1: ruleAExpression returns [EObject current=null] : this_AOrExpression_0= ruleAOrExpression ;
    public final EObject ruleAExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AOrExpression_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:1540:2: (this_AOrExpression_0= ruleAOrExpression )
            // InternalAlisa.g:1541:2: this_AOrExpression_0= ruleAOrExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_AOrExpression_0=ruleAOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_AOrExpression_0;
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
    // $ANTLR end "ruleAExpression"


    // $ANTLR start "entryRuleAOrExpression"
    // InternalAlisa.g:1552:1: entryRuleAOrExpression returns [EObject current=null] : iv_ruleAOrExpression= ruleAOrExpression EOF ;
    public final EObject entryRuleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOrExpression = null;


        try {
            // InternalAlisa.g:1552:54: (iv_ruleAOrExpression= ruleAOrExpression EOF )
            // InternalAlisa.g:1553:2: iv_ruleAOrExpression= ruleAOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAOrExpression=ruleAOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAOrExpression"


    // $ANTLR start "ruleAOrExpression"
    // InternalAlisa.g:1559:1: ruleAOrExpression returns [EObject current=null] : (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) ;
    public final EObject ruleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAndExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:1565:2: ( (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) )
            // InternalAlisa.g:1566:2: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            {
            // InternalAlisa.g:1566:2: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            // InternalAlisa.g:1567:3: this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_33);
            this_AAndExpression_0=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAlisa.g:1575:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==48) && (synpred4_InternalAlisa())) {
                    alt30=1;
                }
                else if ( (LA30_0==49) && (synpred4_InternalAlisa())) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalAlisa.g:1576:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) )
            	    {
            	    // InternalAlisa.g:1576:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) )
            	    // InternalAlisa.g:1577:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    {
            	    // InternalAlisa.g:1587:5: ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    // InternalAlisa.g:1588:6: () ( (lv_operator_2_0= ruleOpOr ) )
            	    {
            	    // InternalAlisa.g:1588:6: ()
            	    // InternalAlisa.g:1589:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalAlisa.g:1595:6: ( (lv_operator_2_0= ruleOpOr ) )
            	    // InternalAlisa.g:1596:7: (lv_operator_2_0= ruleOpOr )
            	    {
            	    // InternalAlisa.g:1596:7: (lv_operator_2_0= ruleOpOr )
            	    // InternalAlisa.g:1597:8: lv_operator_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_operator_2_0=ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpOr");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalAlisa.g:1616:4: ( (lv_right_3_0= ruleAAndExpression ) )
            	    // InternalAlisa.g:1617:5: (lv_right_3_0= ruleAAndExpression )
            	    {
            	    // InternalAlisa.g:1617:5: (lv_right_3_0= ruleAAndExpression )
            	    // InternalAlisa.g:1618:6: lv_right_3_0= ruleAAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAOrExpressionAccess().getRightAAndExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_right_3_0=ruleAAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.AAndExpression");
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
    // $ANTLR end "ruleAOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // InternalAlisa.g:1640:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalAlisa.g:1640:44: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalAlisa.g:1641:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalAlisa.g:1647:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'or' | kw= '||' ) ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAlisa.g:1653:2: ( (kw= 'or' | kw= '||' ) )
            // InternalAlisa.g:1654:2: (kw= 'or' | kw= '||' )
            {
            // InternalAlisa.g:1654:2: (kw= 'or' | kw= '||' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==48) ) {
                alt31=1;
            }
            else if ( (LA31_0==49) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalAlisa.g:1655:3: kw= 'or'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAlisa.g:1661:3: kw= '||'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAAndExpression"
    // InternalAlisa.g:1670:1: entryRuleAAndExpression returns [EObject current=null] : iv_ruleAAndExpression= ruleAAndExpression EOF ;
    public final EObject entryRuleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAndExpression = null;


        try {
            // InternalAlisa.g:1670:55: (iv_ruleAAndExpression= ruleAAndExpression EOF )
            // InternalAlisa.g:1671:2: iv_ruleAAndExpression= ruleAAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAAndExpression=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAAndExpression"


    // $ANTLR start "ruleAAndExpression"
    // InternalAlisa.g:1677:1: ruleAAndExpression returns [EObject current=null] : (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* ) ;
    public final EObject ruleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AEqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:1683:2: ( (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* ) )
            // InternalAlisa.g:1684:2: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* )
            {
            // InternalAlisa.g:1684:2: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* )
            // InternalAlisa.g:1685:3: this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_35);
            this_AEqualityExpression_0=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AEqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAlisa.g:1693:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==50) && (synpred5_InternalAlisa())) {
                    alt32=1;
                }
                else if ( (LA32_0==51) && (synpred5_InternalAlisa())) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalAlisa.g:1694:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) )
            	    {
            	    // InternalAlisa.g:1694:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) )
            	    // InternalAlisa.g:1695:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    {
            	    // InternalAlisa.g:1705:5: ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    // InternalAlisa.g:1706:6: () ( (lv_operator_2_0= ruleOpAnd ) )
            	    {
            	    // InternalAlisa.g:1706:6: ()
            	    // InternalAlisa.g:1707:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalAlisa.g:1713:6: ( (lv_operator_2_0= ruleOpAnd ) )
            	    // InternalAlisa.g:1714:7: (lv_operator_2_0= ruleOpAnd )
            	    {
            	    // InternalAlisa.g:1714:7: (lv_operator_2_0= ruleOpAnd )
            	    // InternalAlisa.g:1715:8: lv_operator_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_operator_2_0=ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpAnd");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalAlisa.g:1734:4: ( (lv_right_3_0= ruleAEqualityExpression ) )
            	    // InternalAlisa.g:1735:5: (lv_right_3_0= ruleAEqualityExpression )
            	    {
            	    // InternalAlisa.g:1735:5: (lv_right_3_0= ruleAEqualityExpression )
            	    // InternalAlisa.g:1736:6: lv_right_3_0= ruleAEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAAndExpressionAccess().getRightAEqualityExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_right_3_0=ruleAEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.AEqualityExpression");
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
    // $ANTLR end "ruleAAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // InternalAlisa.g:1758:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalAlisa.g:1758:45: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalAlisa.g:1759:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalAlisa.g:1765:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= '&&' ) ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAlisa.g:1771:2: ( (kw= 'and' | kw= '&&' ) )
            // InternalAlisa.g:1772:2: (kw= 'and' | kw= '&&' )
            {
            // InternalAlisa.g:1772:2: (kw= 'and' | kw= '&&' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==50) ) {
                alt33=1;
            }
            else if ( (LA33_0==51) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalAlisa.g:1773:3: kw= 'and'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAlisa.g:1779:3: kw= '&&'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAEqualityExpression"
    // InternalAlisa.g:1788:1: entryRuleAEqualityExpression returns [EObject current=null] : iv_ruleAEqualityExpression= ruleAEqualityExpression EOF ;
    public final EObject entryRuleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAEqualityExpression = null;


        try {
            // InternalAlisa.g:1788:60: (iv_ruleAEqualityExpression= ruleAEqualityExpression EOF )
            // InternalAlisa.g:1789:2: iv_ruleAEqualityExpression= ruleAEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAEqualityExpression=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAEqualityExpression"


    // $ANTLR start "ruleAEqualityExpression"
    // InternalAlisa.g:1795:1: ruleAEqualityExpression returns [EObject current=null] : (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) ;
    public final EObject ruleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ARelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:1801:2: ( (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) )
            // InternalAlisa.g:1802:2: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            {
            // InternalAlisa.g:1802:2: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            // InternalAlisa.g:1803:3: this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_36);
            this_ARelationalExpression_0=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ARelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAlisa.g:1811:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==52) && (synpred6_InternalAlisa())) {
                    alt34=1;
                }
                else if ( (LA34_0==53) && (synpred6_InternalAlisa())) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalAlisa.g:1812:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) )
            	    {
            	    // InternalAlisa.g:1812:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) )
            	    // InternalAlisa.g:1813:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    {
            	    // InternalAlisa.g:1823:5: ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    // InternalAlisa.g:1824:6: () ( (lv_operator_2_0= ruleOpEquality ) )
            	    {
            	    // InternalAlisa.g:1824:6: ()
            	    // InternalAlisa.g:1825:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalAlisa.g:1831:6: ( (lv_operator_2_0= ruleOpEquality ) )
            	    // InternalAlisa.g:1832:7: (lv_operator_2_0= ruleOpEquality )
            	    {
            	    // InternalAlisa.g:1832:7: (lv_operator_2_0= ruleOpEquality )
            	    // InternalAlisa.g:1833:8: lv_operator_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_operator_2_0=ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpEquality");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalAlisa.g:1852:4: ( (lv_right_3_0= ruleARelationalExpression ) )
            	    // InternalAlisa.g:1853:5: (lv_right_3_0= ruleARelationalExpression )
            	    {
            	    // InternalAlisa.g:1853:5: (lv_right_3_0= ruleARelationalExpression )
            	    // InternalAlisa.g:1854:6: lv_right_3_0= ruleARelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getRightARelationalExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_right_3_0=ruleARelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.ARelationalExpression");
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
    // $ANTLR end "ruleAEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // InternalAlisa.g:1876:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalAlisa.g:1876:50: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalAlisa.g:1877:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalAlisa.g:1883:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAlisa.g:1889:2: ( (kw= '==' | kw= '!=' ) )
            // InternalAlisa.g:1890:2: (kw= '==' | kw= '!=' )
            {
            // InternalAlisa.g:1890:2: (kw= '==' | kw= '!=' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==52) ) {
                alt35=1;
            }
            else if ( (LA35_0==53) ) {
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
                    // InternalAlisa.g:1891:3: kw= '=='
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAlisa.g:1897:3: kw= '!='
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleARelationalExpression"
    // InternalAlisa.g:1906:1: entryRuleARelationalExpression returns [EObject current=null] : iv_ruleARelationalExpression= ruleARelationalExpression EOF ;
    public final EObject entryRuleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARelationalExpression = null;


        try {
            // InternalAlisa.g:1906:62: (iv_ruleARelationalExpression= ruleARelationalExpression EOF )
            // InternalAlisa.g:1907:2: iv_ruleARelationalExpression= ruleARelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleARelationalExpression=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleARelationalExpression"


    // $ANTLR start "ruleARelationalExpression"
    // InternalAlisa.g:1913:1: ruleARelationalExpression returns [EObject current=null] : (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) ;
    public final EObject ruleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:1919:2: ( (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) )
            // InternalAlisa.g:1920:2: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            {
            // InternalAlisa.g:1920:2: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            // InternalAlisa.g:1921:3: this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_37);
            this_AAdditiveExpression_0=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AAdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAlisa.g:1929:3: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==54) && (synpred7_InternalAlisa())) {
                    alt36=1;
                }
                else if ( (LA36_0==55) && (synpred7_InternalAlisa())) {
                    alt36=1;
                }
                else if ( (LA36_0==56) && (synpred7_InternalAlisa())) {
                    alt36=1;
                }
                else if ( (LA36_0==57) && (synpred7_InternalAlisa())) {
                    alt36=1;
                }
                else if ( (LA36_0==58) && (synpred7_InternalAlisa())) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalAlisa.g:1930:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    {
            	    // InternalAlisa.g:1930:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) )
            	    // InternalAlisa.g:1931:5: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    {
            	    // InternalAlisa.g:1941:5: ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    // InternalAlisa.g:1942:6: () ( (lv_operator_2_0= ruleOpCompare ) )
            	    {
            	    // InternalAlisa.g:1942:6: ()
            	    // InternalAlisa.g:1943:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalAlisa.g:1949:6: ( (lv_operator_2_0= ruleOpCompare ) )
            	    // InternalAlisa.g:1950:7: (lv_operator_2_0= ruleOpCompare )
            	    {
            	    // InternalAlisa.g:1950:7: (lv_operator_2_0= ruleOpCompare )
            	    // InternalAlisa.g:1951:8: lv_operator_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getARelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_operator_2_0=ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpCompare");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalAlisa.g:1970:4: ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    // InternalAlisa.g:1971:5: (lv_right_3_0= ruleAAdditiveExpression )
            	    {
            	    // InternalAlisa.g:1971:5: (lv_right_3_0= ruleAAdditiveExpression )
            	    // InternalAlisa.g:1972:6: lv_right_3_0= ruleAAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
            	    lv_right_3_0=ruleAAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.AAdditiveExpression");
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
    // $ANTLR end "ruleARelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // InternalAlisa.g:1994:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalAlisa.g:1994:49: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalAlisa.g:1995:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalAlisa.g:2001:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAlisa.g:2007:2: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' ) )
            // InternalAlisa.g:2008:2: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' )
            {
            // InternalAlisa.g:2008:2: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' )
            int alt37=5;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt37=1;
                }
                break;
            case 55:
                {
                alt37=2;
                }
                break;
            case 56:
                {
                alt37=3;
                }
                break;
            case 57:
                {
                alt37=4;
                }
                break;
            case 58:
                {
                alt37=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalAlisa.g:2009:3: kw= '>='
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAlisa.g:2015:3: kw= '<='
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalAlisa.g:2021:3: kw= '>'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalAlisa.g:2027:3: kw= '<'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalAlisa.g:2033:3: kw= '><'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAAdditiveExpression"
    // InternalAlisa.g:2042:1: entryRuleAAdditiveExpression returns [EObject current=null] : iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF ;
    public final EObject entryRuleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAdditiveExpression = null;


        try {
            // InternalAlisa.g:2042:60: (iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF )
            // InternalAlisa.g:2043:2: iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAAdditiveExpression=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAAdditiveExpression"


    // $ANTLR start "ruleAAdditiveExpression"
    // InternalAlisa.g:2049:1: ruleAAdditiveExpression returns [EObject current=null] : (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AMultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:2055:2: ( (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) )
            // InternalAlisa.g:2056:2: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            {
            // InternalAlisa.g:2056:2: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            // InternalAlisa.g:2057:3: this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_38);
            this_AMultiplicativeExpression_0=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AMultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAlisa.g:2065:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==59) && (synpred8_InternalAlisa())) {
                    alt38=1;
                }
                else if ( (LA38_0==60) && (synpred8_InternalAlisa())) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalAlisa.g:2066:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    {
            	    // InternalAlisa.g:2066:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) )
            	    // InternalAlisa.g:2067:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    {
            	    // InternalAlisa.g:2077:5: ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    // InternalAlisa.g:2078:6: () ( (lv_operator_2_0= ruleOpAdd ) )
            	    {
            	    // InternalAlisa.g:2078:6: ()
            	    // InternalAlisa.g:2079:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalAlisa.g:2085:6: ( (lv_operator_2_0= ruleOpAdd ) )
            	    // InternalAlisa.g:2086:7: (lv_operator_2_0= ruleOpAdd )
            	    {
            	    // InternalAlisa.g:2086:7: (lv_operator_2_0= ruleOpAdd )
            	    // InternalAlisa.g:2087:8: lv_operator_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_operator_2_0=ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpAdd");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalAlisa.g:2106:4: ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    // InternalAlisa.g:2107:5: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    {
            	    // InternalAlisa.g:2107:5: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    // InternalAlisa.g:2108:6: lv_right_3_0= ruleAMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_right_3_0=ruleAMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.AMultiplicativeExpression");
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // InternalAlisa.g:2130:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalAlisa.g:2130:45: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalAlisa.g:2131:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalAlisa.g:2137:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAlisa.g:2143:2: ( (kw= '+' | kw= '-' ) )
            // InternalAlisa.g:2144:2: (kw= '+' | kw= '-' )
            {
            // InternalAlisa.g:2144:2: (kw= '+' | kw= '-' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==59) ) {
                alt39=1;
            }
            else if ( (LA39_0==60) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalAlisa.g:2145:3: kw= '+'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAlisa.g:2151:3: kw= '-'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAMultiplicativeExpression"
    // InternalAlisa.g:2160:1: entryRuleAMultiplicativeExpression returns [EObject current=null] : iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF ;
    public final EObject entryRuleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiplicativeExpression = null;


        try {
            // InternalAlisa.g:2160:66: (iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF )
            // InternalAlisa.g:2161:2: iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAMultiplicativeExpression=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAMultiplicativeExpression"


    // $ANTLR start "ruleAMultiplicativeExpression"
    // InternalAlisa.g:2167:1: ruleAMultiplicativeExpression returns [EObject current=null] : (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* ) ;
    public final EObject ruleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AUnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:2173:2: ( (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* ) )
            // InternalAlisa.g:2174:2: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* )
            {
            // InternalAlisa.g:2174:2: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* )
            // InternalAlisa.g:2175:3: this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_39);
            this_AUnaryOperation_0=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AUnaryOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAlisa.g:2183:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==61) && (synpred9_InternalAlisa())) {
                    alt40=1;
                }
                else if ( (LA40_0==47) && (synpred9_InternalAlisa())) {
                    alt40=1;
                }
                else if ( (LA40_0==62) && (synpred9_InternalAlisa())) {
                    alt40=1;
                }
                else if ( (LA40_0==63) && (synpred9_InternalAlisa())) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalAlisa.g:2184:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) )
            	    {
            	    // InternalAlisa.g:2184:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) )
            	    // InternalAlisa.g:2185:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    {
            	    // InternalAlisa.g:2195:5: ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    // InternalAlisa.g:2196:6: () ( (lv_operator_2_0= ruleOpMulti ) )
            	    {
            	    // InternalAlisa.g:2196:6: ()
            	    // InternalAlisa.g:2197:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalAlisa.g:2203:6: ( (lv_operator_2_0= ruleOpMulti ) )
            	    // InternalAlisa.g:2204:7: (lv_operator_2_0= ruleOpMulti )
            	    {
            	    // InternalAlisa.g:2204:7: (lv_operator_2_0= ruleOpMulti )
            	    // InternalAlisa.g:2205:8: lv_operator_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_operator_2_0=ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpMulti");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalAlisa.g:2224:4: ( (lv_right_3_0= ruleAUnaryOperation ) )
            	    // InternalAlisa.g:2225:5: (lv_right_3_0= ruleAUnaryOperation )
            	    {
            	    // InternalAlisa.g:2225:5: (lv_right_3_0= ruleAUnaryOperation )
            	    // InternalAlisa.g:2226:6: lv_right_3_0= ruleAUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getRightAUnaryOperationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_right_3_0=ruleAUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.AUnaryOperation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
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
    // $ANTLR end "ruleAMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // InternalAlisa.g:2248:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalAlisa.g:2248:47: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalAlisa.g:2249:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalAlisa.g:2255:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAlisa.g:2261:2: ( (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' ) )
            // InternalAlisa.g:2262:2: (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' )
            {
            // InternalAlisa.g:2262:2: (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' )
            int alt41=4;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt41=1;
                }
                break;
            case 47:
                {
                alt41=2;
                }
                break;
            case 62:
                {
                alt41=3;
                }
                break;
            case 63:
                {
                alt41=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalAlisa.g:2263:3: kw= '*'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAlisa.g:2269:3: kw= '/'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalAlisa.g:2275:3: kw= 'div'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalAlisa.g:2281:3: kw= 'mod'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAUnaryOperation"
    // InternalAlisa.g:2290:1: entryRuleAUnaryOperation returns [EObject current=null] : iv_ruleAUnaryOperation= ruleAUnaryOperation EOF ;
    public final EObject entryRuleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnaryOperation = null;


        try {
            // InternalAlisa.g:2290:56: (iv_ruleAUnaryOperation= ruleAUnaryOperation EOF )
            // InternalAlisa.g:2291:2: iv_ruleAUnaryOperation= ruleAUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAUnaryOperation=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAUnaryOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAUnaryOperation"


    // $ANTLR start "ruleAUnaryOperation"
    // InternalAlisa.g:2297:1: ruleAUnaryOperation returns [EObject current=null] : ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression ) ;
    public final EObject ruleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_AUnitExpression_3 = null;



        	enterRule();

        try {
            // InternalAlisa.g:2303:2: ( ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression ) )
            // InternalAlisa.g:2304:2: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression )
            {
            // InternalAlisa.g:2304:2: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=59 && LA42_0<=60)||LA42_0==64) ) {
                alt42=1;
            }
            else if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_REAL_LIT)||LA42_0==21||LA42_0==34||LA42_0==42||LA42_0==65||LA42_0==70||(LA42_0>=74 && LA42_0<=75)) ) {
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
                    // InternalAlisa.g:2305:3: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    {
                    // InternalAlisa.g:2305:3: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    // InternalAlisa.g:2306:4: () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    {
                    // InternalAlisa.g:2306:4: ()
                    // InternalAlisa.g:2307:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAlisa.g:2313:4: ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) )
                    // InternalAlisa.g:2314:5: ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary )
                    {
                    // InternalAlisa.g:2318:5: (lv_operator_1_0= ruleOpUnary )
                    // InternalAlisa.g:2319:6: lv_operator_1_0= ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_34);
                    lv_operator_1_0=ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
                      						}
                      						set(
                      							current,
                      							"operator",
                      							lv_operator_1_0,
                      							"org.osate.alisa.common.Common.OpUnary");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalAlisa.g:2336:4: ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    // InternalAlisa.g:2337:5: (lv_operand_2_0= ruleAUnaryOperation )
                    {
                    // InternalAlisa.g:2337:5: (lv_operand_2_0= ruleAUnaryOperation )
                    // InternalAlisa.g:2338:6: lv_operand_2_0= ruleAUnaryOperation
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleAUnaryOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.osate.alisa.common.Common.AUnaryOperation");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAlisa.g:2357:3: this_AUnitExpression_3= ruleAUnitExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAUnaryOperationAccess().getAUnitExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AUnitExpression_3=ruleAUnitExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AUnitExpression_3;
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
    // $ANTLR end "ruleAUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // InternalAlisa.g:2369:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalAlisa.g:2369:47: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalAlisa.g:2370:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalAlisa.g:2376:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAlisa.g:2382:2: ( (kw= 'not' | kw= '-' | kw= '+' ) )
            // InternalAlisa.g:2383:2: (kw= 'not' | kw= '-' | kw= '+' )
            {
            // InternalAlisa.g:2383:2: (kw= 'not' | kw= '-' | kw= '+' )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt43=1;
                }
                break;
            case 60:
                {
                alt43=2;
                }
                break;
            case 59:
                {
                alt43=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalAlisa.g:2384:3: kw= 'not'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAlisa.g:2390:3: kw= '-'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalAlisa.g:2396:3: kw= '+'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAUnitExpression"
    // InternalAlisa.g:2405:1: entryRuleAUnitExpression returns [EObject current=null] : iv_ruleAUnitExpression= ruleAUnitExpression EOF ;
    public final EObject entryRuleAUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnitExpression = null;


        try {
            // InternalAlisa.g:2405:56: (iv_ruleAUnitExpression= ruleAUnitExpression EOF )
            // InternalAlisa.g:2406:2: iv_ruleAUnitExpression= ruleAUnitExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAUnitExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAUnitExpression=ruleAUnitExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAUnitExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAUnitExpression"


    // $ANTLR start "ruleAUnitExpression"
    // InternalAlisa.g:2412:1: ruleAUnitExpression returns [EObject current=null] : (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleAUnitExpression() throws RecognitionException {
        EObject current = null;

        Token lv_convert_2_0=null;
        Token lv_drop_3_0=null;
        Token otherlv_4=null;
        EObject this_APrimaryExpression_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:2418:2: ( (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalAlisa.g:2419:2: (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalAlisa.g:2419:2: (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            // InternalAlisa.g:2420:3: this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAUnitExpressionAccess().getAPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_40);
            this_APrimaryExpression_0=ruleAPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_APrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalAlisa.g:2428:3: ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID||(LA45_0>=44 && LA45_0<=45)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAlisa.g:2429:4: () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalAlisa.g:2429:4: ()
                    // InternalAlisa.g:2430:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalAlisa.g:2436:4: ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )?
                    int alt44=3;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==44) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==45) ) {
                        alt44=2;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalAlisa.g:2437:5: ( (lv_convert_2_0= '%' ) )
                            {
                            // InternalAlisa.g:2437:5: ( (lv_convert_2_0= '%' ) )
                            // InternalAlisa.g:2438:6: (lv_convert_2_0= '%' )
                            {
                            // InternalAlisa.g:2438:6: (lv_convert_2_0= '%' )
                            // InternalAlisa.g:2439:7: lv_convert_2_0= '%'
                            {
                            lv_convert_2_0=(Token)match(input,44,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_convert_2_0, grammarAccess.getAUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAUnitExpressionRule());
                              							}
                              							setWithLastConsumed(current, "convert", true, "%");
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalAlisa.g:2452:5: ( (lv_drop_3_0= 'in' ) )
                            {
                            // InternalAlisa.g:2452:5: ( (lv_drop_3_0= 'in' ) )
                            // InternalAlisa.g:2453:6: (lv_drop_3_0= 'in' )
                            {
                            // InternalAlisa.g:2453:6: (lv_drop_3_0= 'in' )
                            // InternalAlisa.g:2454:7: lv_drop_3_0= 'in'
                            {
                            lv_drop_3_0=(Token)match(input,45,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_drop_3_0, grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAUnitExpressionRule());
                              							}
                              							setWithLastConsumed(current, "drop", true, "in");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalAlisa.g:2467:4: ( (otherlv_4= RULE_ID ) )
                    // InternalAlisa.g:2468:5: (otherlv_4= RULE_ID )
                    {
                    // InternalAlisa.g:2468:5: (otherlv_4= RULE_ID )
                    // InternalAlisa.g:2469:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAUnitExpressionRule());
                      						}
                      					
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_4, grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0());
                      					
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
    // $ANTLR end "ruleAUnitExpression"


    // $ANTLR start "entryRuleAPrimaryExpression"
    // InternalAlisa.g:2485:1: entryRuleAPrimaryExpression returns [EObject current=null] : iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF ;
    public final EObject entryRuleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPrimaryExpression = null;


        try {
            // InternalAlisa.g:2485:59: (iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF )
            // InternalAlisa.g:2486:2: iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAPrimaryExpression=ruleAPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAPrimaryExpression"


    // $ANTLR start "ruleAPrimaryExpression"
    // InternalAlisa.g:2492:1: ruleAPrimaryExpression returns [EObject current=null] : (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression ) ;
    public final EObject ruleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ALiteral_0 = null;

        EObject this_AVariableReference_1 = null;

        EObject this_AModelOrPropertyReference_2 = null;

        EObject this_AFunctionCall_3 = null;

        EObject this_ARangeExpression_4 = null;

        EObject this_AIfExpression_5 = null;

        EObject this_AParenthesizedExpression_6 = null;



        	enterRule();

        try {
            // InternalAlisa.g:2498:2: ( (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression ) )
            // InternalAlisa.g:2499:2: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression )
            {
            // InternalAlisa.g:2499:2: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression )
            int alt46=7;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INT:
            case RULE_REAL_LIT:
            case 74:
            case 75:
                {
                alt46=1;
                }
                break;
            case RULE_ID:
                {
                int LA46_2 = input.LA(2);

                if ( (LA46_2==EOF||LA46_2==RULE_ID||LA46_2==22||(LA46_2>=44 && LA46_2<=45)||(LA46_2>=47 && LA46_2<=63)||(LA46_2>=66 && LA46_2<=69)||(LA46_2>=71 && LA46_2<=73)) ) {
                    alt46=2;
                }
                else if ( (LA46_2==43||LA46_2==65) ) {
                    alt46=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 2, input);

                    throw nvae;
                }
                }
                break;
            case 34:
            case 42:
                {
                alt46=3;
                }
                break;
            case 21:
                {
                alt46=5;
                }
                break;
            case 70:
                {
                alt46=6;
                }
                break;
            case 65:
                {
                alt46=7;
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
                    // InternalAlisa.g:2500:3: this_ALiteral_0= ruleALiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ALiteral_0=ruleALiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ALiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAlisa.g:2509:3: this_AVariableReference_1= ruleAVariableReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AVariableReference_1=ruleAVariableReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AVariableReference_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalAlisa.g:2518:3: this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAModelOrPropertyReferenceParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AModelOrPropertyReference_2=ruleAModelOrPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AModelOrPropertyReference_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalAlisa.g:2527:3: this_AFunctionCall_3= ruleAFunctionCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAFunctionCallParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AFunctionCall_3=ruleAFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AFunctionCall_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalAlisa.g:2536:3: this_ARangeExpression_4= ruleARangeExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getARangeExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ARangeExpression_4=ruleARangeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ARangeExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalAlisa.g:2545:3: this_AIfExpression_5= ruleAIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAIfExpressionParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AIfExpression_5=ruleAIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AIfExpression_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalAlisa.g:2554:3: this_AParenthesizedExpression_6= ruleAParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AParenthesizedExpression_6=ruleAParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AParenthesizedExpression_6;
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
    // $ANTLR end "ruleAPrimaryExpression"


    // $ANTLR start "entryRuleAFunctionCall"
    // InternalAlisa.g:2566:1: entryRuleAFunctionCall returns [EObject current=null] : iv_ruleAFunctionCall= ruleAFunctionCall EOF ;
    public final EObject entryRuleAFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAFunctionCall = null;


        try {
            // InternalAlisa.g:2566:54: (iv_ruleAFunctionCall= ruleAFunctionCall EOF )
            // InternalAlisa.g:2567:2: iv_ruleAFunctionCall= ruleAFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAFunctionCall=ruleAFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAFunctionCall"


    // $ANTLR start "ruleAFunctionCall"
    // InternalAlisa.g:2573:1: ruleAFunctionCall returns [EObject current=null] : ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleAFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_function_1_0 = null;

        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:2579:2: ( ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalAlisa.g:2580:2: ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalAlisa.g:2580:2: ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' )
            // InternalAlisa.g:2581:3: () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')'
            {
            // InternalAlisa.g:2581:3: ()
            // InternalAlisa.g:2582:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAFunctionCallAccess().getAFunctionCallAction_0(),
              					current);
              			
            }

            }

            // InternalAlisa.g:2588:3: ( (lv_function_1_0= ruleQualifiedName ) )
            // InternalAlisa.g:2589:4: (lv_function_1_0= ruleQualifiedName )
            {
            // InternalAlisa.g:2589:4: (lv_function_1_0= ruleQualifiedName )
            // InternalAlisa.g:2590:5: lv_function_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAFunctionCallAccess().getFunctionQualifiedNameParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_41);
            lv_function_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
              					}
              					set(
              						current,
              						"function",
              						lv_function_1_0,
              						"org.osate.alisa.common.Common.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,65,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAFunctionCallAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalAlisa.g:2611:3: ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=RULE_STRING && LA48_0<=RULE_REAL_LIT)||LA48_0==21||LA48_0==34||LA48_0==42||(LA48_0>=59 && LA48_0<=60)||(LA48_0>=64 && LA48_0<=65)||LA48_0==70||(LA48_0>=74 && LA48_0<=75)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalAlisa.g:2612:4: ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )*
                    {
                    // InternalAlisa.g:2612:4: ( (lv_arguments_3_0= ruleAExpression ) )
                    // InternalAlisa.g:2613:5: (lv_arguments_3_0= ruleAExpression )
                    {
                    // InternalAlisa.g:2613:5: (lv_arguments_3_0= ruleAExpression )
                    // InternalAlisa.g:2614:6: lv_arguments_3_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
                    lv_arguments_3_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
                      						}
                      						add(
                      							current,
                      							"arguments",
                      							lv_arguments_3_0,
                      							"org.osate.alisa.common.Common.AExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalAlisa.g:2631:4: (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==66) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalAlisa.g:2632:5: otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,66,FOLLOW_34); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getAFunctionCallAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalAlisa.g:2636:5: ( (lv_arguments_5_0= ruleAExpression ) )
                    	    // InternalAlisa.g:2637:6: (lv_arguments_5_0= ruleAExpression )
                    	    {
                    	    // InternalAlisa.g:2637:6: (lv_arguments_5_0= ruleAExpression )
                    	    // InternalAlisa.g:2638:7: lv_arguments_5_0= ruleAExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_43);
                    	    lv_arguments_5_0=ruleAExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"arguments",
                    	      								lv_arguments_5_0,
                    	      								"org.osate.alisa.common.Common.AExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getAFunctionCallAccess().getRightParenthesisKeyword_4());
              		
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
    // $ANTLR end "ruleAFunctionCall"


    // $ANTLR start "entryRuleARangeExpression"
    // InternalAlisa.g:2665:1: entryRuleARangeExpression returns [EObject current=null] : iv_ruleARangeExpression= ruleARangeExpression EOF ;
    public final EObject entryRuleARangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARangeExpression = null;


        try {
            // InternalAlisa.g:2665:57: (iv_ruleARangeExpression= ruleARangeExpression EOF )
            // InternalAlisa.g:2666:2: iv_ruleARangeExpression= ruleARangeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARangeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleARangeExpression=ruleARangeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARangeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleARangeExpression"


    // $ANTLR start "ruleARangeExpression"
    // InternalAlisa.g:2672:1: ruleARangeExpression returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' ) ;
    public final EObject ruleARangeExpression() throws RecognitionException {
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
            // InternalAlisa.g:2678:2: ( ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' ) )
            // InternalAlisa.g:2679:2: ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' )
            {
            // InternalAlisa.g:2679:2: ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' )
            // InternalAlisa.g:2680:3: () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']'
            {
            // InternalAlisa.g:2680:3: ()
            // InternalAlisa.g:2681:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getARangeExpressionAccess().getARangeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,21,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getARangeExpressionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalAlisa.g:2691:3: ( (lv_minimum_2_0= ruleAExpression ) )
            // InternalAlisa.g:2692:4: (lv_minimum_2_0= ruleAExpression )
            {
            // InternalAlisa.g:2692:4: (lv_minimum_2_0= ruleAExpression )
            // InternalAlisa.g:2693:5: lv_minimum_2_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getARangeExpressionAccess().getMinimumAExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_44);
            lv_minimum_2_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
              					}
              					set(
              						current,
              						"minimum",
              						lv_minimum_2_0,
              						"org.osate.alisa.common.Common.AExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,68,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getARangeExpressionAccess().getFullStopFullStopKeyword_3());
              		
            }
            // InternalAlisa.g:2714:3: ( (lv_maximum_4_0= ruleAExpression ) )
            // InternalAlisa.g:2715:4: (lv_maximum_4_0= ruleAExpression )
            {
            // InternalAlisa.g:2715:4: (lv_maximum_4_0= ruleAExpression )
            // InternalAlisa.g:2716:5: lv_maximum_4_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getARangeExpressionAccess().getMaximumAExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_45);
            lv_maximum_4_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
              					}
              					set(
              						current,
              						"maximum",
              						lv_maximum_4_0,
              						"org.osate.alisa.common.Common.AExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAlisa.g:2733:3: ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==69) && (synpred11_InternalAlisa())) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalAlisa.g:2734:4: ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) )
                    {
                    // InternalAlisa.g:2734:4: ( ( 'delta' )=>otherlv_5= 'delta' )
                    // InternalAlisa.g:2735:5: ( 'delta' )=>otherlv_5= 'delta'
                    {
                    otherlv_5=(Token)match(input,69,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getARangeExpressionAccess().getDeltaKeyword_5_0());
                      				
                    }

                    }

                    // InternalAlisa.g:2741:4: ( (lv_delta_6_0= ruleAExpression ) )
                    // InternalAlisa.g:2742:5: (lv_delta_6_0= ruleAExpression )
                    {
                    // InternalAlisa.g:2742:5: (lv_delta_6_0= ruleAExpression )
                    // InternalAlisa.g:2743:6: lv_delta_6_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getARangeExpressionAccess().getDeltaAExpressionParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_46);
                    lv_delta_6_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
                      						}
                      						set(
                      							current,
                      							"delta",
                      							lv_delta_6_0,
                      							"org.osate.alisa.common.Common.AExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getARangeExpressionAccess().getRightSquareBracketKeyword_6());
              		
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
    // $ANTLR end "ruleARangeExpression"


    // $ANTLR start "entryRuleAIfExpression"
    // InternalAlisa.g:2769:1: entryRuleAIfExpression returns [EObject current=null] : iv_ruleAIfExpression= ruleAIfExpression EOF ;
    public final EObject entryRuleAIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIfExpression = null;


        try {
            // InternalAlisa.g:2769:54: (iv_ruleAIfExpression= ruleAIfExpression EOF )
            // InternalAlisa.g:2770:2: iv_ruleAIfExpression= ruleAIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAIfExpression=ruleAIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAIfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAIfExpression"


    // $ANTLR start "ruleAIfExpression"
    // InternalAlisa.g:2776:1: ruleAIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' ) ;
    public final EObject ruleAIfExpression() throws RecognitionException {
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
            // InternalAlisa.g:2782:2: ( ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' ) )
            // InternalAlisa.g:2783:2: ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' )
            {
            // InternalAlisa.g:2783:2: ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' )
            // InternalAlisa.g:2784:3: () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif'
            {
            // InternalAlisa.g:2784:3: ()
            // InternalAlisa.g:2785:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAIfExpressionAccess().getAConditionalAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,70,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAIfExpressionAccess().getIfKeyword_1());
              		
            }
            // InternalAlisa.g:2795:3: ( (lv_if_2_0= ruleAExpression ) )
            // InternalAlisa.g:2796:4: (lv_if_2_0= ruleAExpression )
            {
            // InternalAlisa.g:2796:4: (lv_if_2_0= ruleAExpression )
            // InternalAlisa.g:2797:5: lv_if_2_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAIfExpressionAccess().getIfAExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_47);
            lv_if_2_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
              					}
              					set(
              						current,
              						"if",
              						lv_if_2_0,
              						"org.osate.alisa.common.Common.AExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,71,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAIfExpressionAccess().getThenKeyword_3());
              		
            }
            // InternalAlisa.g:2818:3: ( (lv_then_4_0= ruleAExpression ) )
            // InternalAlisa.g:2819:4: (lv_then_4_0= ruleAExpression )
            {
            // InternalAlisa.g:2819:4: (lv_then_4_0= ruleAExpression )
            // InternalAlisa.g:2820:5: lv_then_4_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAIfExpressionAccess().getThenAExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_48);
            lv_then_4_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_4_0,
              						"org.osate.alisa.common.Common.AExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalAlisa.g:2837:3: (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==72) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalAlisa.g:2838:4: otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) )
                    {
                    otherlv_5=(Token)match(input,72,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getAIfExpressionAccess().getElseKeyword_5_0());
                      			
                    }
                    // InternalAlisa.g:2842:4: ( (lv_else_6_0= ruleAExpression ) )
                    // InternalAlisa.g:2843:5: (lv_else_6_0= ruleAExpression )
                    {
                    // InternalAlisa.g:2843:5: (lv_else_6_0= ruleAExpression )
                    // InternalAlisa.g:2844:6: lv_else_6_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAIfExpressionAccess().getElseAExpressionParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_49);
                    lv_else_6_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_6_0,
                      							"org.osate.alisa.common.Common.AExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getAIfExpressionAccess().getEndifKeyword_6());
              		
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
    // $ANTLR end "ruleAIfExpression"


    // $ANTLR start "entryRuleALiteral"
    // InternalAlisa.g:2870:1: entryRuleALiteral returns [EObject current=null] : iv_ruleALiteral= ruleALiteral EOF ;
    public final EObject entryRuleALiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleALiteral = null;


        try {
            // InternalAlisa.g:2870:49: (iv_ruleALiteral= ruleALiteral EOF )
            // InternalAlisa.g:2871:2: iv_ruleALiteral= ruleALiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getALiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleALiteral=ruleALiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleALiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleALiteral"


    // $ANTLR start "ruleALiteral"
    // InternalAlisa.g:2877:1: ruleALiteral returns [EObject current=null] : (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm ) ;
    public final EObject ruleALiteral() throws RecognitionException {
        EObject current = null;

        EObject this_ABooleanLiteral_0 = null;

        EObject this_ARealTerm_1 = null;

        EObject this_AIntegerTerm_2 = null;

        EObject this_StringTerm_3 = null;



        	enterRule();

        try {
            // InternalAlisa.g:2883:2: ( (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm ) )
            // InternalAlisa.g:2884:2: (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm )
            {
            // InternalAlisa.g:2884:2: (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm )
            int alt51=4;
            switch ( input.LA(1) ) {
            case 74:
            case 75:
                {
                alt51=1;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt51=2;
                }
                break;
            case RULE_INT:
                {
                alt51=3;
                }
                break;
            case RULE_STRING:
                {
                alt51=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalAlisa.g:2885:3: this_ABooleanLiteral_0= ruleABooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ABooleanLiteral_0=ruleABooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ABooleanLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalAlisa.g:2894:3: this_ARealTerm_1= ruleARealTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ARealTerm_1=ruleARealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ARealTerm_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalAlisa.g:2903:3: this_AIntegerTerm_2= ruleAIntegerTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AIntegerTerm_2=ruleAIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AIntegerTerm_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalAlisa.g:2912:3: this_StringTerm_3= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringTerm_3=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringTerm_3;
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
    // $ANTLR end "ruleALiteral"


    // $ANTLR start "entryRuleAIntegerTerm"
    // InternalAlisa.g:2924:1: entryRuleAIntegerTerm returns [EObject current=null] : iv_ruleAIntegerTerm= ruleAIntegerTerm EOF ;
    public final EObject entryRuleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIntegerTerm = null;


        try {
            // InternalAlisa.g:2924:53: (iv_ruleAIntegerTerm= ruleAIntegerTerm EOF )
            // InternalAlisa.g:2925:2: iv_ruleAIntegerTerm= ruleAIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntegerTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAIntegerTerm=ruleAIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAIntegerTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAIntegerTerm"


    // $ANTLR start "ruleAIntegerTerm"
    // InternalAlisa.g:2931:1: ruleAIntegerTerm returns [EObject current=null] : ( (lv_value_0_0= ruleAInt ) ) ;
    public final EObject ruleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:2937:2: ( ( (lv_value_0_0= ruleAInt ) ) )
            // InternalAlisa.g:2938:2: ( (lv_value_0_0= ruleAInt ) )
            {
            // InternalAlisa.g:2938:2: ( (lv_value_0_0= ruleAInt ) )
            // InternalAlisa.g:2939:3: (lv_value_0_0= ruleAInt )
            {
            // InternalAlisa.g:2939:3: (lv_value_0_0= ruleAInt )
            // InternalAlisa.g:2940:4: lv_value_0_0= ruleAInt
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleAInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getAIntegerTermRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.osate.alisa.common.Common.AInt");
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
    // $ANTLR end "ruleAIntegerTerm"


    // $ANTLR start "entryRuleAInt"
    // InternalAlisa.g:2960:1: entryRuleAInt returns [String current=null] : iv_ruleAInt= ruleAInt EOF ;
    public final String entryRuleAInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAInt = null;


        try {
            // InternalAlisa.g:2960:44: (iv_ruleAInt= ruleAInt EOF )
            // InternalAlisa.g:2961:2: iv_ruleAInt= ruleAInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAInt=ruleAInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAInt.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAInt"


    // $ANTLR start "ruleAInt"
    // InternalAlisa.g:2967:1: ruleAInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleAInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;


        	enterRule();

        try {
            // InternalAlisa.g:2973:2: (this_INT_0= RULE_INT )
            // InternalAlisa.g:2974:2: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_INT_0, grammarAccess.getAIntAccess().getINTTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAInt"


    // $ANTLR start "entryRuleARealTerm"
    // InternalAlisa.g:2984:1: entryRuleARealTerm returns [EObject current=null] : iv_ruleARealTerm= ruleARealTerm EOF ;
    public final EObject entryRuleARealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARealTerm = null;


        try {
            // InternalAlisa.g:2984:50: (iv_ruleARealTerm= ruleARealTerm EOF )
            // InternalAlisa.g:2985:2: iv_ruleARealTerm= ruleARealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleARealTerm=ruleARealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARealTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleARealTerm"


    // $ANTLR start "ruleARealTerm"
    // InternalAlisa.g:2991:1: ruleARealTerm returns [EObject current=null] : ( (lv_value_0_0= ruleAReal ) ) ;
    public final EObject ruleARealTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:2997:2: ( ( (lv_value_0_0= ruleAReal ) ) )
            // InternalAlisa.g:2998:2: ( (lv_value_0_0= ruleAReal ) )
            {
            // InternalAlisa.g:2998:2: ( (lv_value_0_0= ruleAReal ) )
            // InternalAlisa.g:2999:3: (lv_value_0_0= ruleAReal )
            {
            // InternalAlisa.g:2999:3: (lv_value_0_0= ruleAReal )
            // InternalAlisa.g:3000:4: lv_value_0_0= ruleAReal
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleAReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getARealTermRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.osate.alisa.common.Common.AReal");
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
    // $ANTLR end "ruleARealTerm"


    // $ANTLR start "entryRuleAReal"
    // InternalAlisa.g:3020:1: entryRuleAReal returns [String current=null] : iv_ruleAReal= ruleAReal EOF ;
    public final String entryRuleAReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAReal = null;


        try {
            // InternalAlisa.g:3020:45: (iv_ruleAReal= ruleAReal EOF )
            // InternalAlisa.g:3021:2: iv_ruleAReal= ruleAReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAReal=ruleAReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAReal.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAReal"


    // $ANTLR start "ruleAReal"
    // InternalAlisa.g:3027:1: ruleAReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleAReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;


        	enterRule();

        try {
            // InternalAlisa.g:3033:2: (this_REAL_LIT_0= RULE_REAL_LIT )
            // InternalAlisa.g:3034:2: this_REAL_LIT_0= RULE_REAL_LIT
            {
            this_REAL_LIT_0=(Token)match(input,RULE_REAL_LIT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_REAL_LIT_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_REAL_LIT_0, grammarAccess.getARealAccess().getREAL_LITTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAReal"


    // $ANTLR start "entryRuleABooleanLiteral"
    // InternalAlisa.g:3044:1: entryRuleABooleanLiteral returns [EObject current=null] : iv_ruleABooleanLiteral= ruleABooleanLiteral EOF ;
    public final EObject entryRuleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleABooleanLiteral = null;


        try {
            // InternalAlisa.g:3044:56: (iv_ruleABooleanLiteral= ruleABooleanLiteral EOF )
            // InternalAlisa.g:3045:2: iv_ruleABooleanLiteral= ruleABooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getABooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleABooleanLiteral=ruleABooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleABooleanLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleABooleanLiteral"


    // $ANTLR start "ruleABooleanLiteral"
    // InternalAlisa.g:3051:1: ruleABooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalAlisa.g:3057:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalAlisa.g:3058:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalAlisa.g:3058:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalAlisa.g:3059:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalAlisa.g:3059:3: ()
            // InternalAlisa.g:3060:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalAlisa.g:3066:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==74) ) {
                alt52=1;
            }
            else if ( (LA52_0==75) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalAlisa.g:3067:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalAlisa.g:3067:4: ( (lv_value_1_0= 'true' ) )
                    // InternalAlisa.g:3068:5: (lv_value_1_0= 'true' )
                    {
                    // InternalAlisa.g:3068:5: (lv_value_1_0= 'true' )
                    // InternalAlisa.g:3069:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getABooleanLiteralRule());
                      						}
                      						setWithLastConsumed(current, "value", true, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAlisa.g:3082:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getABooleanLiteralAccess().getFalseKeyword_1_1());
                      			
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
    // $ANTLR end "ruleABooleanLiteral"


    // $ANTLR start "entryRuleStringTerm"
    // InternalAlisa.g:3091:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalAlisa.g:3091:51: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalAlisa.g:3092:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalAlisa.g:3098:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalAlisa.g:3104:2: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalAlisa.g:3105:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalAlisa.g:3105:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalAlisa.g:3106:3: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalAlisa.g:3106:3: (lv_value_0_0= ruleNoQuoteString )
            // InternalAlisa.g:3107:4: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
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
              					"org.osate.alisa.common.Common.NoQuoteString");
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
    // InternalAlisa.g:3127:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalAlisa.g:3127:53: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalAlisa.g:3128:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalAlisa.g:3134:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalAlisa.g:3140:2: (this_STRING_0= RULE_STRING )
            // InternalAlisa.g:3141:2: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAParenthesizedExpression"
    // InternalAlisa.g:3151:1: entryRuleAParenthesizedExpression returns [EObject current=null] : iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF ;
    public final EObject entryRuleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAParenthesizedExpression = null;


        try {
            // InternalAlisa.g:3151:65: (iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF )
            // InternalAlisa.g:3152:2: iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAParenthesizedExpression=ruleAParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAParenthesizedExpression"


    // $ANTLR start "ruleAParenthesizedExpression"
    // InternalAlisa.g:3158:1: ruleAParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) ;
    public final EObject ruleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AExpression_1 = null;



        	enterRule();

        try {
            // InternalAlisa.g:3164:2: ( (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) )
            // InternalAlisa.g:3165:2: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            {
            // InternalAlisa.g:3165:2: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            // InternalAlisa.g:3166:3: otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_50);
            this_AExpression_1=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AExpression_1;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
              		
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
    // $ANTLR end "ruleAParenthesizedExpression"


    // $ANTLR start "entryRuleAadlClassifierReference"
    // InternalAlisa.g:3186:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // InternalAlisa.g:3186:63: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // InternalAlisa.g:3187:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAadlClassifierReference.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAadlClassifierReference"


    // $ANTLR start "ruleAadlClassifierReference"
    // InternalAlisa.g:3193:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;


        	enterRule();

        try {
            // InternalAlisa.g:3199:2: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? ) )
            // InternalAlisa.g:3200:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? )
            {
            // InternalAlisa.g:3200:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? )
            // InternalAlisa.g:3201:3: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalAlisa.g:3208:3: (kw= '::' this_ID_2= RULE_ID )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==76) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalAlisa.g:3209:4: kw= '::' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,76,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_52); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
            } while (true);

            // InternalAlisa.g:3222:3: (kw= '.' this_ID_4= RULE_ID )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==43) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalAlisa.g:3223:4: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,43,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0());
                      			
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_4);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_4, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_2_1());
                      			
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
    // $ANTLR end "ruleAadlClassifierReference"


    // $ANTLR start "entryRuleAADLPROPERTYREFERENCE"
    // InternalAlisa.g:3240:1: entryRuleAADLPROPERTYREFERENCE returns [String current=null] : iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF ;
    public final String entryRuleAADLPROPERTYREFERENCE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAADLPROPERTYREFERENCE = null;


        try {
            // InternalAlisa.g:3240:61: (iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF )
            // InternalAlisa.g:3241:2: iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAADLPROPERTYREFERENCERule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAADLPROPERTYREFERENCE=ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAADLPROPERTYREFERENCE.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAADLPROPERTYREFERENCE"


    // $ANTLR start "ruleAADLPROPERTYREFERENCE"
    // InternalAlisa.g:3247:1: ruleAADLPROPERTYREFERENCE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAADLPROPERTYREFERENCE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalAlisa.g:3253:2: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // InternalAlisa.g:3254:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // InternalAlisa.g:3254:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // InternalAlisa.g:3255:3: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_53); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalAlisa.g:3262:3: (kw= '::' this_ID_2= RULE_ID )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==76) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalAlisa.g:3263:4: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,76,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0());
                      			
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_2, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_1_1());
                      			
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
    // $ANTLR end "ruleAADLPROPERTYREFERENCE"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalAlisa.g:3280:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalAlisa.g:3280:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalAlisa.g:3281:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalAlisa.g:3287:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalAlisa.g:3293:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalAlisa.g:3294:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalAlisa.g:3294:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalAlisa.g:3295:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalAlisa.g:3302:3: (kw= '.' this_ID_2= RULE_ID )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==43) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalAlisa.g:3303:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,43,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop56;
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


    // $ANTLR start "entryRuleThisKeyword"
    // InternalAlisa.g:3320:1: entryRuleThisKeyword returns [String current=null] : iv_ruleThisKeyword= ruleThisKeyword EOF ;
    public final String entryRuleThisKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleThisKeyword = null;


        try {
            // InternalAlisa.g:3320:51: (iv_ruleThisKeyword= ruleThisKeyword EOF )
            // InternalAlisa.g:3321:2: iv_ruleThisKeyword= ruleThisKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThisKeywordRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleThisKeyword=ruleThisKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThisKeyword.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThisKeyword"


    // $ANTLR start "ruleThisKeyword"
    // InternalAlisa.g:3327:1: ruleThisKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'this' ;
    public final AntlrDatatypeRuleToken ruleThisKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAlisa.g:3333:2: (kw= 'this' )
            // InternalAlisa.g:3334:2: kw= 'this'
            {
            kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getThisKeywordAccess().getThisKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThisKeyword"

    // $ANTLR start synpred1_InternalAlisa
    public final void synpred1_InternalAlisa_fragment() throws RecognitionException {   
        // InternalAlisa.g:857:4: ( ( 'this' ) )
        // InternalAlisa.g:857:5: ( 'this' )
        {
        // InternalAlisa.g:857:5: ( 'this' )
        // InternalAlisa.g:858:5: 'this'
        {
        match(input,34,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalAlisa

    // $ANTLR start synpred2_InternalAlisa
    public final void synpred2_InternalAlisa_fragment() throws RecognitionException {   
        // InternalAlisa.g:876:4: ( ( ruleImageReference ) )
        // InternalAlisa.g:876:5: ( ruleImageReference )
        {
        // InternalAlisa.g:876:5: ( ruleImageReference )
        // InternalAlisa.g:877:5: ruleImageReference
        {
        pushFollow(FOLLOW_2);
        ruleImageReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalAlisa

    // $ANTLR start synpred3_InternalAlisa
    public final void synpred3_InternalAlisa_fragment() throws RecognitionException {   
        // InternalAlisa.g:1152:6: ( ( () '#' ) )
        // InternalAlisa.g:1152:7: ( () '#' )
        {
        // InternalAlisa.g:1152:7: ( () '#' )
        // InternalAlisa.g:1153:7: () '#'
        {
        // InternalAlisa.g:1153:7: ()
        // InternalAlisa.g:1154:7: 
        {
        }

        match(input,42,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalAlisa

    // $ANTLR start synpred4_InternalAlisa
    public final void synpred4_InternalAlisa_fragment() throws RecognitionException {   
        // InternalAlisa.g:1577:5: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalAlisa.g:1577:6: ( () ( ( ruleOpOr ) ) )
        {
        // InternalAlisa.g:1577:6: ( () ( ( ruleOpOr ) ) )
        // InternalAlisa.g:1578:6: () ( ( ruleOpOr ) )
        {
        // InternalAlisa.g:1578:6: ()
        // InternalAlisa.g:1579:6: 
        {
        }

        // InternalAlisa.g:1580:6: ( ( ruleOpOr ) )
        // InternalAlisa.g:1581:7: ( ruleOpOr )
        {
        // InternalAlisa.g:1581:7: ( ruleOpOr )
        // InternalAlisa.g:1582:8: ruleOpOr
        {
        pushFollow(FOLLOW_2);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalAlisa

    // $ANTLR start synpred5_InternalAlisa
    public final void synpred5_InternalAlisa_fragment() throws RecognitionException {   
        // InternalAlisa.g:1695:5: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalAlisa.g:1695:6: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalAlisa.g:1695:6: ( () ( ( ruleOpAnd ) ) )
        // InternalAlisa.g:1696:6: () ( ( ruleOpAnd ) )
        {
        // InternalAlisa.g:1696:6: ()
        // InternalAlisa.g:1697:6: 
        {
        }

        // InternalAlisa.g:1698:6: ( ( ruleOpAnd ) )
        // InternalAlisa.g:1699:7: ( ruleOpAnd )
        {
        // InternalAlisa.g:1699:7: ( ruleOpAnd )
        // InternalAlisa.g:1700:8: ruleOpAnd
        {
        pushFollow(FOLLOW_2);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalAlisa

    // $ANTLR start synpred6_InternalAlisa
    public final void synpred6_InternalAlisa_fragment() throws RecognitionException {   
        // InternalAlisa.g:1813:5: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalAlisa.g:1813:6: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalAlisa.g:1813:6: ( () ( ( ruleOpEquality ) ) )
        // InternalAlisa.g:1814:6: () ( ( ruleOpEquality ) )
        {
        // InternalAlisa.g:1814:6: ()
        // InternalAlisa.g:1815:6: 
        {
        }

        // InternalAlisa.g:1816:6: ( ( ruleOpEquality ) )
        // InternalAlisa.g:1817:7: ( ruleOpEquality )
        {
        // InternalAlisa.g:1817:7: ( ruleOpEquality )
        // InternalAlisa.g:1818:8: ruleOpEquality
        {
        pushFollow(FOLLOW_2);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalAlisa

    // $ANTLR start synpred7_InternalAlisa
    public final void synpred7_InternalAlisa_fragment() throws RecognitionException {   
        // InternalAlisa.g:1931:5: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalAlisa.g:1931:6: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalAlisa.g:1931:6: ( () ( ( ruleOpCompare ) ) )
        // InternalAlisa.g:1932:6: () ( ( ruleOpCompare ) )
        {
        // InternalAlisa.g:1932:6: ()
        // InternalAlisa.g:1933:6: 
        {
        }

        // InternalAlisa.g:1934:6: ( ( ruleOpCompare ) )
        // InternalAlisa.g:1935:7: ( ruleOpCompare )
        {
        // InternalAlisa.g:1935:7: ( ruleOpCompare )
        // InternalAlisa.g:1936:8: ruleOpCompare
        {
        pushFollow(FOLLOW_2);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalAlisa

    // $ANTLR start synpred8_InternalAlisa
    public final void synpred8_InternalAlisa_fragment() throws RecognitionException {   
        // InternalAlisa.g:2067:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalAlisa.g:2067:6: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalAlisa.g:2067:6: ( () ( ( ruleOpAdd ) ) )
        // InternalAlisa.g:2068:6: () ( ( ruleOpAdd ) )
        {
        // InternalAlisa.g:2068:6: ()
        // InternalAlisa.g:2069:6: 
        {
        }

        // InternalAlisa.g:2070:6: ( ( ruleOpAdd ) )
        // InternalAlisa.g:2071:7: ( ruleOpAdd )
        {
        // InternalAlisa.g:2071:7: ( ruleOpAdd )
        // InternalAlisa.g:2072:8: ruleOpAdd
        {
        pushFollow(FOLLOW_2);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalAlisa

    // $ANTLR start synpred9_InternalAlisa
    public final void synpred9_InternalAlisa_fragment() throws RecognitionException {   
        // InternalAlisa.g:2185:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalAlisa.g:2185:6: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalAlisa.g:2185:6: ( () ( ( ruleOpMulti ) ) )
        // InternalAlisa.g:2186:6: () ( ( ruleOpMulti ) )
        {
        // InternalAlisa.g:2186:6: ()
        // InternalAlisa.g:2187:6: 
        {
        }

        // InternalAlisa.g:2188:6: ( ( ruleOpMulti ) )
        // InternalAlisa.g:2189:7: ( ruleOpMulti )
        {
        // InternalAlisa.g:2189:7: ( ruleOpMulti )
        // InternalAlisa.g:2190:8: ruleOpMulti
        {
        pushFollow(FOLLOW_2);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalAlisa

    // $ANTLR start synpred11_InternalAlisa
    public final void synpred11_InternalAlisa_fragment() throws RecognitionException {   
        // InternalAlisa.g:2735:5: ( 'delta' )
        // InternalAlisa.g:2735:6: 'delta'
        {
        match(input,69,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalAlisa

    // Delegated rules

    public final boolean synpred2_InternalAlisa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalAlisa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalAlisa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalAlisa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalAlisa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalAlisa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalAlisa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalAlisa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalAlisa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalAlisa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalAlisa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalAlisa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalAlisa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalAlisa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalAlisa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalAlisa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalAlisa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalAlisa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalAlisa() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalAlisa_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000200020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000200420000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000420000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000231400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000231400020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000231400010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000002A0400000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000003A0400020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000002A0400010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000400400000030L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000400400000032L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000300000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x18004404002000F0L,0x0000000000000C43L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x07C0000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xE000800000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000300000000022L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x18004404002000F0L,0x0000000000000C4BL});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000020L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000080000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});

}

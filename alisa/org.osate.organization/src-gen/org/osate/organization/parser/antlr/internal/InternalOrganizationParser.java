package org.osate.organization.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.organization.services.OrganizationGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
public class InternalOrganizationParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'organization'", "'stakeholder'", "'['", "'full'", "'name'", "'title'", "'description'", "'role'", "'email'", "'phone'", "'supervisor'", "']'", "'.'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalOrganizationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOrganizationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOrganizationParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOrganization.g"; }



     	private OrganizationGrammarAccess grammarAccess;

        public InternalOrganizationParser(TokenStream input, OrganizationGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Organization";
       	}

       	@Override
       	protected OrganizationGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleOrganization"
    // InternalOrganization.g:84:1: entryRuleOrganization returns [EObject current=null] : iv_ruleOrganization= ruleOrganization EOF ;
    public final EObject entryRuleOrganization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrganization = null;


        try {
            // InternalOrganization.g:84:53: (iv_ruleOrganization= ruleOrganization EOF )
            // InternalOrganization.g:85:2: iv_ruleOrganization= ruleOrganization EOF
            {
             newCompositeNode(grammarAccess.getOrganizationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrganization=ruleOrganization();

            state._fsp--;

             current =iv_ruleOrganization; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrganization"


    // $ANTLR start "ruleOrganization"
    // InternalOrganization.g:91:1: ruleOrganization returns [EObject current=null] : (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ ) ;
    public final EObject ruleOrganization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_stakeholder_2_0 = null;



        	enterRule();

        try {
            // InternalOrganization.g:97:2: ( (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ ) )
            // InternalOrganization.g:98:2: (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ )
            {
            // InternalOrganization.g:98:2: (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ )
            // InternalOrganization.g:99:3: otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getOrganizationAccess().getOrganizationKeyword_0());
            		
            // InternalOrganization.g:103:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOrganization.g:104:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOrganization.g:104:4: (lv_name_1_0= RULE_ID )
            // InternalOrganization.g:105:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getOrganizationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOrganizationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalOrganization.g:121:3: ( (lv_stakeholder_2_0= ruleStakeholder ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||(LA1_0>=21 && LA1_0<=22)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOrganization.g:122:4: (lv_stakeholder_2_0= ruleStakeholder )
            	    {
            	    // InternalOrganization.g:122:4: (lv_stakeholder_2_0= ruleStakeholder )
            	    // InternalOrganization.g:123:5: lv_stakeholder_2_0= ruleStakeholder
            	    {

            	    					newCompositeNode(grammarAccess.getOrganizationAccess().getStakeholderStakeholderParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_stakeholder_2_0=ruleStakeholder();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOrganizationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"stakeholder",
            	    						lv_stakeholder_2_0,
            	    						"org.osate.organization.Organization.Stakeholder");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrganization"


    // $ANTLR start "entryRuleStakeholder"
    // InternalOrganization.g:144:1: entryRuleStakeholder returns [EObject current=null] : iv_ruleStakeholder= ruleStakeholder EOF ;
    public final EObject entryRuleStakeholder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStakeholder = null;


        try {
            // InternalOrganization.g:144:52: (iv_ruleStakeholder= ruleStakeholder EOF )
            // InternalOrganization.g:145:2: iv_ruleStakeholder= ruleStakeholder EOF
            {
             newCompositeNode(grammarAccess.getStakeholderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStakeholder=ruleStakeholder();

            state._fsp--;

             current =iv_ruleStakeholder; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStakeholder"


    // $ANTLR start "ruleStakeholder"
    // InternalOrganization.g:151:1: ruleStakeholder returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleStakeholder() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_fullname_7_0=null;
        Token otherlv_8=null;
        Token lv_title_9_0=null;
        Token otherlv_10=null;
        Token lv_description_11_0=null;
        Token otherlv_12=null;
        Token lv_role_13_0=null;
        Token otherlv_14=null;
        Token lv_email_15_0=null;
        Token otherlv_16=null;
        Token lv_phone_17_0=null;
        Token otherlv_18=null;
        Token otherlv_20=null;


        	enterRule();

        try {
            // InternalOrganization.g:157:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) ) )+ {...}?) ) ) )
            // InternalOrganization.g:158:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) ) )+ {...}?) ) )
            {
            // InternalOrganization.g:158:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) ) )+ {...}?) ) )
            // InternalOrganization.g:159:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) ) )+ {...}?) )
            {
            // InternalOrganization.g:159:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) ) )+ {...}?) )
            // InternalOrganization.g:160:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup());
            			
            // InternalOrganization.g:163:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) ) )+ {...}?)
            // InternalOrganization.g:164:5: ( ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) ) )+ {...}?
            {
            // InternalOrganization.g:164:5: ( ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=3;
                switch ( input.LA(1) ) {
                case 12:
                    {
                    int LA4_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0) ) {
                        alt4=1;
                    }


                    }
                    break;
                case 21:
                    {
                    int LA4_3 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1) ) {
                        alt4=2;
                    }


                    }
                    break;
                case 22:
                    {
                    int LA4_4 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1) ) {
                        alt4=2;
                    }


                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // InternalOrganization.g:165:3: ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) )
            	    {
            	    // InternalOrganization.g:165:3: ({...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) )
            	    // InternalOrganization.g:166:4: {...}? => ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalOrganization.g:166:105: ( ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) )
            	    // InternalOrganization.g:167:5: ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalOrganization.g:170:8: ({...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) )
            	    // InternalOrganization.g:170:9: {...}? => (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // InternalOrganization.g:170:18: (otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) )
            	    // InternalOrganization.g:170:19: otherlv_1= 'stakeholder' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            	    {
            	    otherlv_1=(Token)match(input,12,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getStakeholderAccess().getStakeholderKeyword_0_0());
            	    							
            	    // InternalOrganization.g:174:8: ( (lv_name_2_0= RULE_ID ) )
            	    // InternalOrganization.g:175:9: (lv_name_2_0= RULE_ID )
            	    {
            	    // InternalOrganization.g:175:9: (lv_name_2_0= RULE_ID )
            	    // InternalOrganization.g:176:10: lv_name_2_0= RULE_ID
            	    {
            	    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            	    										newLeafNode(lv_name_2_0, grammarAccess.getStakeholderAccess().getNameIDTerminalRuleCall_0_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getStakeholderRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"org.eclipse.xtext.common.Terminals.ID");
            	    									

            	    }


            	    }

            	    otherlv_3=(Token)match(input,13,FOLLOW_7); 

            	    								newLeafNode(otherlv_3, grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_0_2());
            	    							
            	    // InternalOrganization.g:196:8: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            	    // InternalOrganization.g:197:9: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) )
            	    {
            	    // InternalOrganization.g:197:9: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) )
            	    // InternalOrganization.g:198:10: ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* )
            	    {
            	     
            	    									  getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            	    									
            	    // InternalOrganization.g:201:10: ( ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* )
            	    // InternalOrganization.g:202:11: ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )*
            	    {
            	    // InternalOrganization.g:202:11: ( ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )*
            	    loop2:
            	    do {
            	        int alt2=7;
            	        int LA2_0 = input.LA(1);

            	        if ( LA2_0 == 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
            	            alt2=1;
            	        }
            	        else if ( LA2_0 == 16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
            	            alt2=2;
            	        }
            	        else if ( LA2_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
            	            alt2=3;
            	        }
            	        else if ( LA2_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
            	            alt2=4;
            	        }
            	        else if ( LA2_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
            	            alt2=5;
            	        }
            	        else if ( LA2_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
            	            alt2=6;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalOrganization.g:203:9: ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganization.g:203:9: ({...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganization.g:204:10: {...}? => ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0)");
            	    	    }
            	    	    // InternalOrganization.g:204:115: ( ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganization.g:205:11: ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) )
            	    	    {

            	    	    											getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0);
            	    	    										
            	    	    // InternalOrganization.g:208:14: ({...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganization.g:208:15: {...}? => (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganization.g:208:24: (otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) ) )
            	    	    // InternalOrganization.g:208:25: otherlv_5= 'full' otherlv_6= 'name' ( (lv_fullname_7_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_5=(Token)match(input,14,FOLLOW_8); 

            	    	    														newLeafNode(otherlv_5, grammarAccess.getStakeholderAccess().getFullKeyword_0_3_0_0());
            	    	    													
            	    	    otherlv_6=(Token)match(input,15,FOLLOW_9); 

            	    	    														newLeafNode(otherlv_6, grammarAccess.getStakeholderAccess().getNameKeyword_0_3_0_1());
            	    	    													
            	    	    // InternalOrganization.g:216:14: ( (lv_fullname_7_0= RULE_STRING ) )
            	    	    // InternalOrganization.g:217:15: (lv_fullname_7_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganization.g:217:15: (lv_fullname_7_0= RULE_STRING )
            	    	    // InternalOrganization.g:218:16: lv_fullname_7_0= RULE_STRING
            	    	    {
            	    	    lv_fullname_7_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            	    	    																newLeafNode(lv_fullname_7_0, grammarAccess.getStakeholderAccess().getFullnameSTRINGTerminalRuleCall_0_3_0_2_0());
            	    	    															

            	    	    																if (current==null) {
            	    	    																	current = createModelElement(grammarAccess.getStakeholderRule());
            	    	    																}
            	    	    																setWithLastConsumed(
            	    	    																	current,
            	    	    																	"fullname",
            	    	    																	lv_fullname_7_0,
            	    	    																	"org.eclipse.xtext.common.Terminals.STRING");
            	    	    															

            	    	    }


            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    											getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // InternalOrganization.g:240:9: ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganization.g:240:9: ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganization.g:241:10: {...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1)");
            	    	    }
            	    	    // InternalOrganization.g:241:115: ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganization.g:242:11: ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) )
            	    	    {

            	    	    											getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1);
            	    	    										
            	    	    // InternalOrganization.g:245:14: ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganization.g:245:15: {...}? => (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganization.g:245:24: (otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) ) )
            	    	    // InternalOrganization.g:245:25: otherlv_8= 'title' ( (lv_title_9_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_8=(Token)match(input,16,FOLLOW_9); 

            	    	    														newLeafNode(otherlv_8, grammarAccess.getStakeholderAccess().getTitleKeyword_0_3_1_0());
            	    	    													
            	    	    // InternalOrganization.g:249:14: ( (lv_title_9_0= RULE_STRING ) )
            	    	    // InternalOrganization.g:250:15: (lv_title_9_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganization.g:250:15: (lv_title_9_0= RULE_STRING )
            	    	    // InternalOrganization.g:251:16: lv_title_9_0= RULE_STRING
            	    	    {
            	    	    lv_title_9_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            	    	    																newLeafNode(lv_title_9_0, grammarAccess.getStakeholderAccess().getTitleSTRINGTerminalRuleCall_0_3_1_1_0());
            	    	    															

            	    	    																if (current==null) {
            	    	    																	current = createModelElement(grammarAccess.getStakeholderRule());
            	    	    																}
            	    	    																setWithLastConsumed(
            	    	    																	current,
            	    	    																	"title",
            	    	    																	lv_title_9_0,
            	    	    																	"org.eclipse.xtext.common.Terminals.STRING");
            	    	    															

            	    	    }


            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    											getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // InternalOrganization.g:273:9: ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganization.g:273:9: ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganization.g:274:10: {...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2)");
            	    	    }
            	    	    // InternalOrganization.g:274:115: ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganization.g:275:11: ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) )
            	    	    {

            	    	    											getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2);
            	    	    										
            	    	    // InternalOrganization.g:278:14: ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganization.g:278:15: {...}? => (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganization.g:278:24: (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )
            	    	    // InternalOrganization.g:278:25: otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_10=(Token)match(input,17,FOLLOW_9); 

            	    	    														newLeafNode(otherlv_10, grammarAccess.getStakeholderAccess().getDescriptionKeyword_0_3_2_0());
            	    	    													
            	    	    // InternalOrganization.g:282:14: ( (lv_description_11_0= RULE_STRING ) )
            	    	    // InternalOrganization.g:283:15: (lv_description_11_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganization.g:283:15: (lv_description_11_0= RULE_STRING )
            	    	    // InternalOrganization.g:284:16: lv_description_11_0= RULE_STRING
            	    	    {
            	    	    lv_description_11_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            	    	    																newLeafNode(lv_description_11_0, grammarAccess.getStakeholderAccess().getDescriptionSTRINGTerminalRuleCall_0_3_2_1_0());
            	    	    															

            	    	    																if (current==null) {
            	    	    																	current = createModelElement(grammarAccess.getStakeholderRule());
            	    	    																}
            	    	    																setWithLastConsumed(
            	    	    																	current,
            	    	    																	"description",
            	    	    																	lv_description_11_0,
            	    	    																	"org.eclipse.xtext.common.Terminals.STRING");
            	    	    															

            	    	    }


            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    											getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 4 :
            	    	    // InternalOrganization.g:306:9: ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganization.g:306:9: ({...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganization.g:307:10: {...}? => ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3)");
            	    	    }
            	    	    // InternalOrganization.g:307:115: ( ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganization.g:308:11: ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) )
            	    	    {

            	    	    											getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3);
            	    	    										
            	    	    // InternalOrganization.g:311:14: ({...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganization.g:311:15: {...}? => (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganization.g:311:24: (otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) ) )
            	    	    // InternalOrganization.g:311:25: otherlv_12= 'role' ( (lv_role_13_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_12=(Token)match(input,18,FOLLOW_9); 

            	    	    														newLeafNode(otherlv_12, grammarAccess.getStakeholderAccess().getRoleKeyword_0_3_3_0());
            	    	    													
            	    	    // InternalOrganization.g:315:14: ( (lv_role_13_0= RULE_STRING ) )
            	    	    // InternalOrganization.g:316:15: (lv_role_13_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganization.g:316:15: (lv_role_13_0= RULE_STRING )
            	    	    // InternalOrganization.g:317:16: lv_role_13_0= RULE_STRING
            	    	    {
            	    	    lv_role_13_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            	    	    																newLeafNode(lv_role_13_0, grammarAccess.getStakeholderAccess().getRoleSTRINGTerminalRuleCall_0_3_3_1_0());
            	    	    															

            	    	    																if (current==null) {
            	    	    																	current = createModelElement(grammarAccess.getStakeholderRule());
            	    	    																}
            	    	    																setWithLastConsumed(
            	    	    																	current,
            	    	    																	"role",
            	    	    																	lv_role_13_0,
            	    	    																	"org.eclipse.xtext.common.Terminals.STRING");
            	    	    															

            	    	    }


            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    											getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 5 :
            	    	    // InternalOrganization.g:339:9: ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganization.g:339:9: ({...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganization.g:340:10: {...}? => ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4)");
            	    	    }
            	    	    // InternalOrganization.g:340:115: ( ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganization.g:341:11: ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) )
            	    	    {

            	    	    											getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4);
            	    	    										
            	    	    // InternalOrganization.g:344:14: ({...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganization.g:344:15: {...}? => (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganization.g:344:24: (otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) ) )
            	    	    // InternalOrganization.g:344:25: otherlv_14= 'email' ( (lv_email_15_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_14=(Token)match(input,19,FOLLOW_9); 

            	    	    														newLeafNode(otherlv_14, grammarAccess.getStakeholderAccess().getEmailKeyword_0_3_4_0());
            	    	    													
            	    	    // InternalOrganization.g:348:14: ( (lv_email_15_0= RULE_STRING ) )
            	    	    // InternalOrganization.g:349:15: (lv_email_15_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganization.g:349:15: (lv_email_15_0= RULE_STRING )
            	    	    // InternalOrganization.g:350:16: lv_email_15_0= RULE_STRING
            	    	    {
            	    	    lv_email_15_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            	    	    																newLeafNode(lv_email_15_0, grammarAccess.getStakeholderAccess().getEmailSTRINGTerminalRuleCall_0_3_4_1_0());
            	    	    															

            	    	    																if (current==null) {
            	    	    																	current = createModelElement(grammarAccess.getStakeholderRule());
            	    	    																}
            	    	    																setWithLastConsumed(
            	    	    																	current,
            	    	    																	"email",
            	    	    																	lv_email_15_0,
            	    	    																	"org.eclipse.xtext.common.Terminals.STRING");
            	    	    															

            	    	    }


            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    											getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 6 :
            	    	    // InternalOrganization.g:372:9: ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganization.g:372:9: ({...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganization.g:373:10: {...}? => ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5)");
            	    	    }
            	    	    // InternalOrganization.g:373:115: ( ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganization.g:374:11: ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) )
            	    	    {

            	    	    											getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5);
            	    	    										
            	    	    // InternalOrganization.g:377:14: ({...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganization.g:377:15: {...}? => (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganization.g:377:24: (otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) ) )
            	    	    // InternalOrganization.g:377:25: otherlv_16= 'phone' ( (lv_phone_17_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_16=(Token)match(input,20,FOLLOW_9); 

            	    	    														newLeafNode(otherlv_16, grammarAccess.getStakeholderAccess().getPhoneKeyword_0_3_5_0());
            	    	    													
            	    	    // InternalOrganization.g:381:14: ( (lv_phone_17_0= RULE_STRING ) )
            	    	    // InternalOrganization.g:382:15: (lv_phone_17_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganization.g:382:15: (lv_phone_17_0= RULE_STRING )
            	    	    // InternalOrganization.g:383:16: lv_phone_17_0= RULE_STRING
            	    	    {
            	    	    lv_phone_17_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            	    	    																newLeafNode(lv_phone_17_0, grammarAccess.getStakeholderAccess().getPhoneSTRINGTerminalRuleCall_0_3_5_1_0());
            	    	    															

            	    	    																if (current==null) {
            	    	    																	current = createModelElement(grammarAccess.getStakeholderRule());
            	    	    																}
            	    	    																setWithLastConsumed(
            	    	    																	current,
            	    	    																	"phone",
            	    	    																	lv_phone_17_0,
            	    	    																	"org.eclipse.xtext.common.Terminals.STRING");
            	    	    															

            	    	    }


            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    											getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    									  getUnorderedGroupHelper().leave(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            	    									

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOrganization.g:418:3: ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) )
            	    {
            	    // InternalOrganization.g:418:3: ({...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) ) )
            	    // InternalOrganization.g:419:4: {...}? => ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalOrganization.g:419:105: ( ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) ) )
            	    // InternalOrganization.g:420:5: ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalOrganization.g:423:8: ({...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' ) )
            	    // InternalOrganization.g:423:9: {...}? => ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // InternalOrganization.g:423:18: ( (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']' )
            	    // InternalOrganization.g:423:19: (otherlv_18= 'supervisor' ( ( ruleQID ) ) )? otherlv_20= ']'
            	    {
            	    // InternalOrganization.g:423:19: (otherlv_18= 'supervisor' ( ( ruleQID ) ) )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==21) ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // InternalOrganization.g:424:9: otherlv_18= 'supervisor' ( ( ruleQID ) )
            	            {
            	            otherlv_18=(Token)match(input,21,FOLLOW_3); 

            	            									newLeafNode(otherlv_18, grammarAccess.getStakeholderAccess().getSupervisorKeyword_1_0_0());
            	            								
            	            // InternalOrganization.g:428:9: ( ( ruleQID ) )
            	            // InternalOrganization.g:429:10: ( ruleQID )
            	            {
            	            // InternalOrganization.g:429:10: ( ruleQID )
            	            // InternalOrganization.g:430:11: ruleQID
            	            {

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getStakeholderRule());
            	            											}
            	            										

            	            											newCompositeNode(grammarAccess.getStakeholderAccess().getSupervisorStakeholderCrossReference_1_0_1_0());
            	            										
            	            pushFollow(FOLLOW_10);
            	            ruleQID();

            	            state._fsp--;


            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    otherlv_20=(Token)match(input,22,FOLLOW_5); 

            	    								newLeafNode(otherlv_20, grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_1_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getStakeholderAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canLeave(grammarAccess.getStakeholderAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getStakeholderAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStakeholder"


    // $ANTLR start "entryRuleQID"
    // InternalOrganization.g:466:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // InternalOrganization.g:466:43: (iv_ruleQID= ruleQID EOF )
            // InternalOrganization.g:467:2: iv_ruleQID= ruleQID EOF
            {
             newCompositeNode(grammarAccess.getQIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQID=ruleQID();

            state._fsp--;

             current =iv_ruleQID.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // InternalOrganization.g:473:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalOrganization.g:479:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) )
            // InternalOrganization.g:480:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            {
            // InternalOrganization.g:480:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            // InternalOrganization.g:481:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0());
            		
            // InternalOrganization.g:488:3: (kw= '.' this_ID_2= RULE_ID )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==23) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalOrganization.g:489:4: kw= '.' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,23,FOLLOW_3); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_1_0());
                    			
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    				current.merge(this_ID_2);
                    			

                    				newLeafNode(this_ID_2, grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQID"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000601000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000601002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000007F5002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000800002L});

}

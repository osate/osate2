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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Organization", "Description", "Stakeholder", "Supervisor", "Email", "Phone", "Title", "Full", "Name", "Role", "FullStop", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Organization=4;
    public static final int Description=5;
    public static final int Email=8;
    public static final int RULE_STRING=19;
    public static final int Full=11;
    public static final int Name=12;
    public static final int RULE_SL_COMMENT=21;
    public static final int Stakeholder=6;
    public static final int Phone=9;
    public static final int EOF=-1;
    public static final int RightSquareBracket=16;
    public static final int Supervisor=7;
    public static final int FullStop=14;
    public static final int RULE_ID=17;
    public static final int RULE_WS=22;
    public static final int Title=10;
    public static final int RULE_ANY_OTHER=23;
    public static final int Role=13;
    public static final int RULE_INT=18;
    public static final int RULE_ML_COMMENT=20;
    public static final int LeftSquareBracket=15;

    // delegates
    // delegators


        public InternalOrganizationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOrganizationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOrganizationParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOrganizationParser.g"; }




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
    // InternalOrganizationParser.g:81:1: entryRuleOrganization returns [EObject current=null] : iv_ruleOrganization= ruleOrganization EOF ;
    public final EObject entryRuleOrganization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrganization = null;


        try {
            // InternalOrganizationParser.g:82:2: (iv_ruleOrganization= ruleOrganization EOF )
            // InternalOrganizationParser.g:83:2: iv_ruleOrganization= ruleOrganization EOF
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
    // InternalOrganizationParser.g:90:1: ruleOrganization returns [EObject current=null] : (otherlv_0= Organization ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ ) ;
    public final EObject ruleOrganization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_stakeholder_2_0 = null;


         enterRule(); 
            
        try {
            // InternalOrganizationParser.g:93:28: ( (otherlv_0= Organization ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ ) )
            // InternalOrganizationParser.g:94:1: (otherlv_0= Organization ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ )
            {
            // InternalOrganizationParser.g:94:1: (otherlv_0= Organization ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ )
            // InternalOrganizationParser.g:95:2: otherlv_0= Organization ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+
            {
            otherlv_0=(Token)match(input,Organization,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getOrganizationAccess().getOrganizationKeyword_0());
                
            // InternalOrganizationParser.g:99:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalOrganizationParser.g:100:1: (lv_name_1_0= RULE_ID )
            {
            // InternalOrganizationParser.g:100:1: (lv_name_1_0= RULE_ID )
            // InternalOrganizationParser.g:101:3: lv_name_1_0= RULE_ID
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

            // InternalOrganizationParser.g:117:2: ( (lv_stakeholder_2_0= ruleStakeholder ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=Stakeholder && LA1_0<=Supervisor)||LA1_0==RightSquareBracket) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOrganizationParser.g:118:1: (lv_stakeholder_2_0= ruleStakeholder )
            	    {
            	    // InternalOrganizationParser.g:118:1: (lv_stakeholder_2_0= ruleStakeholder )
            	    // InternalOrganizationParser.g:119:3: lv_stakeholder_2_0= ruleStakeholder
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
    // InternalOrganizationParser.g:143:1: entryRuleStakeholder returns [EObject current=null] : iv_ruleStakeholder= ruleStakeholder EOF ;
    public final EObject entryRuleStakeholder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStakeholder = null;


        try {
            // InternalOrganizationParser.g:144:2: (iv_ruleStakeholder= ruleStakeholder EOF )
            // InternalOrganizationParser.g:145:2: iv_ruleStakeholder= ruleStakeholder EOF
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
    // InternalOrganizationParser.g:152:1: ruleStakeholder returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) ) )+ {...}?) ) ) ;
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
            // InternalOrganizationParser.g:155:28: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) ) )+ {...}?) ) ) )
            // InternalOrganizationParser.g:156:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) ) )+ {...}?) ) )
            {
            // InternalOrganizationParser.g:156:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) ) )+ {...}?) ) )
            // InternalOrganizationParser.g:158:1: ( ( ( ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) ) )+ {...}?) )
            {
            // InternalOrganizationParser.g:158:1: ( ( ( ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) ) )+ {...}?) )
            // InternalOrganizationParser.g:159:2: ( ( ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup());
            	
            // InternalOrganizationParser.g:162:2: ( ( ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) ) )+ {...}?)
            // InternalOrganizationParser.g:163:3: ( ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) ) )+ {...}?
            {
            // InternalOrganizationParser.g:163:3: ( ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=3;
                switch ( input.LA(1) ) {
                case Stakeholder:
                    {
                    int LA4_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0) ) {
                        alt4=1;
                    }


                    }
                    break;
                case Supervisor:
                    {
                    int LA4_3 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1) ) {
                        alt4=2;
                    }


                    }
                    break;
                case RightSquareBracket:
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
            	    // InternalOrganizationParser.g:165:4: ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) )
            	    {
            	    // InternalOrganizationParser.g:165:4: ({...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) ) )
            	    // InternalOrganizationParser.g:166:5: {...}? => ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalOrganizationParser.g:166:106: ( ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) ) )
            	    // InternalOrganizationParser.g:167:6: ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0);
            	    	 				
            	    // InternalOrganizationParser.g:170:6: ({...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) ) )
            	    // InternalOrganizationParser.g:170:7: {...}? => (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // InternalOrganizationParser.g:170:16: (otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) )
            	    // InternalOrganizationParser.g:171:2: otherlv_1= Stakeholder ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            	    {
            	    otherlv_1=(Token)match(input,Stakeholder,FOLLOW_3); 

            	        	newLeafNode(otherlv_1, grammarAccess.getStakeholderAccess().getStakeholderKeyword_0_0());
            	        
            	    // InternalOrganizationParser.g:175:1: ( (lv_name_2_0= RULE_ID ) )
            	    // InternalOrganizationParser.g:176:1: (lv_name_2_0= RULE_ID )
            	    {
            	    // InternalOrganizationParser.g:176:1: (lv_name_2_0= RULE_ID )
            	    // InternalOrganizationParser.g:177:3: lv_name_2_0= RULE_ID
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

            	    otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_7); 

            	        	newLeafNode(otherlv_3, grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_0_2());
            	        
            	    // InternalOrganizationParser.g:198:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            	    // InternalOrganizationParser.g:200:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) )
            	    {
            	    // InternalOrganizationParser.g:200:1: ( ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* ) )
            	    // InternalOrganizationParser.g:201:2: ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* )
            	    {
            	     
            	    	  getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            	    	
            	    // InternalOrganizationParser.g:204:2: ( ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )* )
            	    // InternalOrganizationParser.g:205:3: ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )*
            	    {
            	    // InternalOrganizationParser.g:205:3: ( ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) ) )*
            	    loop2:
            	    do {
            	        int alt2=7;
            	        int LA2_0 = input.LA(1);

            	        if ( LA2_0 == Full && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
            	            alt2=1;
            	        }
            	        else if ( LA2_0 == Title && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
            	            alt2=2;
            	        }
            	        else if ( LA2_0 == Description && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
            	            alt2=3;
            	        }
            	        else if ( LA2_0 == Role && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
            	            alt2=4;
            	        }
            	        else if ( LA2_0 == Email && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
            	            alt2=5;
            	        }
            	        else if ( LA2_0 == Phone && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
            	            alt2=6;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalOrganizationParser.g:207:4: ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganizationParser.g:207:4: ({...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganizationParser.g:208:5: {...}? => ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0)");
            	    	    }
            	    	    // InternalOrganizationParser.g:208:110: ( ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganizationParser.g:209:6: ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0);
            	    	    	 				
            	    	    // InternalOrganizationParser.g:212:6: ({...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganizationParser.g:212:7: {...}? => (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganizationParser.g:212:16: (otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) ) )
            	    	    // InternalOrganizationParser.g:213:2: otherlv_5= Full otherlv_6= Name ( (lv_fullname_7_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_5=(Token)match(input,Full,FOLLOW_8); 

            	    	        	newLeafNode(otherlv_5, grammarAccess.getStakeholderAccess().getFullKeyword_0_3_0_0());
            	    	        
            	    	    otherlv_6=(Token)match(input,Name,FOLLOW_9); 

            	    	        	newLeafNode(otherlv_6, grammarAccess.getStakeholderAccess().getNameKeyword_0_3_0_1());
            	    	        
            	    	    // InternalOrganizationParser.g:222:1: ( (lv_fullname_7_0= RULE_STRING ) )
            	    	    // InternalOrganizationParser.g:223:1: (lv_fullname_7_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganizationParser.g:223:1: (lv_fullname_7_0= RULE_STRING )
            	    	    // InternalOrganizationParser.g:224:3: lv_fullname_7_0= RULE_STRING
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
            	    	    // InternalOrganizationParser.g:247:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganizationParser.g:247:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganizationParser.g:248:5: {...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1)");
            	    	    }
            	    	    // InternalOrganizationParser.g:248:110: ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganizationParser.g:249:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1);
            	    	    	 				
            	    	    // InternalOrganizationParser.g:252:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganizationParser.g:252:7: {...}? => (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganizationParser.g:252:16: (otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) ) )
            	    	    // InternalOrganizationParser.g:253:2: otherlv_8= Title ( (lv_title_9_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_8=(Token)match(input,Title,FOLLOW_9); 

            	    	        	newLeafNode(otherlv_8, grammarAccess.getStakeholderAccess().getTitleKeyword_0_3_1_0());
            	    	        
            	    	    // InternalOrganizationParser.g:257:1: ( (lv_title_9_0= RULE_STRING ) )
            	    	    // InternalOrganizationParser.g:258:1: (lv_title_9_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganizationParser.g:258:1: (lv_title_9_0= RULE_STRING )
            	    	    // InternalOrganizationParser.g:259:3: lv_title_9_0= RULE_STRING
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
            	    	    // InternalOrganizationParser.g:282:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganizationParser.g:282:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganizationParser.g:283:5: {...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2)");
            	    	    }
            	    	    // InternalOrganizationParser.g:283:110: ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganizationParser.g:284:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2);
            	    	    	 				
            	    	    // InternalOrganizationParser.g:287:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganizationParser.g:287:7: {...}? => (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganizationParser.g:287:16: (otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) ) )
            	    	    // InternalOrganizationParser.g:288:2: otherlv_10= Description ( (lv_description_11_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_10=(Token)match(input,Description,FOLLOW_9); 

            	    	        	newLeafNode(otherlv_10, grammarAccess.getStakeholderAccess().getDescriptionKeyword_0_3_2_0());
            	    	        
            	    	    // InternalOrganizationParser.g:292:1: ( (lv_description_11_0= RULE_STRING ) )
            	    	    // InternalOrganizationParser.g:293:1: (lv_description_11_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganizationParser.g:293:1: (lv_description_11_0= RULE_STRING )
            	    	    // InternalOrganizationParser.g:294:3: lv_description_11_0= RULE_STRING
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
            	    	    // InternalOrganizationParser.g:317:4: ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganizationParser.g:317:4: ({...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganizationParser.g:318:5: {...}? => ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3)");
            	    	    }
            	    	    // InternalOrganizationParser.g:318:110: ( ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganizationParser.g:319:6: ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3);
            	    	    	 				
            	    	    // InternalOrganizationParser.g:322:6: ({...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganizationParser.g:322:7: {...}? => (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganizationParser.g:322:16: (otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) ) )
            	    	    // InternalOrganizationParser.g:323:2: otherlv_12= Role ( (lv_role_13_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_12=(Token)match(input,Role,FOLLOW_9); 

            	    	        	newLeafNode(otherlv_12, grammarAccess.getStakeholderAccess().getRoleKeyword_0_3_3_0());
            	    	        
            	    	    // InternalOrganizationParser.g:327:1: ( (lv_role_13_0= RULE_STRING ) )
            	    	    // InternalOrganizationParser.g:328:1: (lv_role_13_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganizationParser.g:328:1: (lv_role_13_0= RULE_STRING )
            	    	    // InternalOrganizationParser.g:329:3: lv_role_13_0= RULE_STRING
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
            	    	    // InternalOrganizationParser.g:352:4: ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganizationParser.g:352:4: ({...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganizationParser.g:353:5: {...}? => ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4)");
            	    	    }
            	    	    // InternalOrganizationParser.g:353:110: ( ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganizationParser.g:354:6: ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4);
            	    	    	 				
            	    	    // InternalOrganizationParser.g:357:6: ({...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganizationParser.g:357:7: {...}? => (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganizationParser.g:357:16: (otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) ) )
            	    	    // InternalOrganizationParser.g:358:2: otherlv_14= Email ( (lv_email_15_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_14=(Token)match(input,Email,FOLLOW_9); 

            	    	        	newLeafNode(otherlv_14, grammarAccess.getStakeholderAccess().getEmailKeyword_0_3_4_0());
            	    	        
            	    	    // InternalOrganizationParser.g:362:1: ( (lv_email_15_0= RULE_STRING ) )
            	    	    // InternalOrganizationParser.g:363:1: (lv_email_15_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganizationParser.g:363:1: (lv_email_15_0= RULE_STRING )
            	    	    // InternalOrganizationParser.g:364:3: lv_email_15_0= RULE_STRING
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
            	    	    // InternalOrganizationParser.g:387:4: ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) )
            	    	    {
            	    	    // InternalOrganizationParser.g:387:4: ({...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) ) )
            	    	    // InternalOrganizationParser.g:388:5: {...}? => ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5)");
            	    	    }
            	    	    // InternalOrganizationParser.g:388:110: ( ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) ) )
            	    	    // InternalOrganizationParser.g:389:6: ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5);
            	    	    	 				
            	    	    // InternalOrganizationParser.g:392:6: ({...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) ) )
            	    	    // InternalOrganizationParser.g:392:7: {...}? => (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    	    }
            	    	    // InternalOrganizationParser.g:392:16: (otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) ) )
            	    	    // InternalOrganizationParser.g:393:2: otherlv_16= Phone ( (lv_phone_17_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_16=(Token)match(input,Phone,FOLLOW_9); 

            	    	        	newLeafNode(otherlv_16, grammarAccess.getStakeholderAccess().getPhoneKeyword_0_3_5_0());
            	    	        
            	    	    // InternalOrganizationParser.g:397:1: ( (lv_phone_17_0= RULE_STRING ) )
            	    	    // InternalOrganizationParser.g:398:1: (lv_phone_17_0= RULE_STRING )
            	    	    {
            	    	    // InternalOrganizationParser.g:398:1: (lv_phone_17_0= RULE_STRING )
            	    	    // InternalOrganizationParser.g:399:3: lv_phone_17_0= RULE_STRING
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
            	    // InternalOrganizationParser.g:436:4: ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) )
            	    {
            	    // InternalOrganizationParser.g:436:4: ({...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) ) )
            	    // InternalOrganizationParser.g:437:5: {...}? => ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalOrganizationParser.g:437:106: ( ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) ) )
            	    // InternalOrganizationParser.g:438:6: ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1);
            	    	 				
            	    // InternalOrganizationParser.g:441:6: ({...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket ) )
            	    // InternalOrganizationParser.g:441:7: {...}? => ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // InternalOrganizationParser.g:441:16: ( (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket )
            	    // InternalOrganizationParser.g:441:17: (otherlv_18= Supervisor ( ( ruleQID ) ) )? otherlv_20= RightSquareBracket
            	    {
            	    // InternalOrganizationParser.g:441:17: (otherlv_18= Supervisor ( ( ruleQID ) ) )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==Supervisor) ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // InternalOrganizationParser.g:442:2: otherlv_18= Supervisor ( ( ruleQID ) )
            	            {
            	            otherlv_18=(Token)match(input,Supervisor,FOLLOW_3); 

            	                	newLeafNode(otherlv_18, grammarAccess.getStakeholderAccess().getSupervisorKeyword_1_0_0());
            	                
            	            // InternalOrganizationParser.g:446:1: ( ( ruleQID ) )
            	            // InternalOrganizationParser.g:447:1: ( ruleQID )
            	            {
            	            // InternalOrganizationParser.g:447:1: ( ruleQID )
            	            // InternalOrganizationParser.g:448:3: ruleQID
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

            	    otherlv_20=(Token)match(input,RightSquareBracket,FOLLOW_5); 

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
    // InternalOrganizationParser.g:490:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // InternalOrganizationParser.g:491:1: (iv_ruleQID= ruleQID EOF )
            // InternalOrganizationParser.g:492:2: iv_ruleQID= ruleQID EOF
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
    // InternalOrganizationParser.g:499:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalOrganizationParser.g:503:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )? ) )
            // InternalOrganizationParser.g:504:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )? )
            {
            // InternalOrganizationParser.g:504:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )? )
            // InternalOrganizationParser.g:504:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 
                
            // InternalOrganizationParser.g:511:1: (kw= FullStop this_ID_2= RULE_ID )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==FullStop) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalOrganizationParser.g:512:2: kw= FullStop this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_3); 

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000000100C0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000100C2L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000012FE2L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000004002L});

}

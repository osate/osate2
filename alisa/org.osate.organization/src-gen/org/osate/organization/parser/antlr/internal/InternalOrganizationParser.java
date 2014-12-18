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

@SuppressWarnings("all")
public class InternalOrganizationParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'organization'", "'stakeholder'", "'['", "'title'", "'description'", "'role'", "'email'", "'phone'", "']'", "'.'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalOrganizationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOrganizationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOrganizationParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g"; }



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
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:67:1: entryRuleOrganization returns [EObject current=null] : iv_ruleOrganization= ruleOrganization EOF ;
    public final EObject entryRuleOrganization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrganization = null;


        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:68:2: (iv_ruleOrganization= ruleOrganization EOF )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:69:2: iv_ruleOrganization= ruleOrganization EOF
            {
             newCompositeNode(grammarAccess.getOrganizationRule()); 
            pushFollow(FOLLOW_ruleOrganization_in_entryRuleOrganization75);
            iv_ruleOrganization=ruleOrganization();

            state._fsp--;

             current =iv_ruleOrganization; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrganization85); 

            }

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
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:76:1: ruleOrganization returns [EObject current=null] : (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ ) ;
    public final EObject ruleOrganization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_stakeholder_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:79:28: ( (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:80:1: (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:80:1: (otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+ )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:80:3: otherlv_0= 'organization' ( (lv_name_1_0= RULE_ID ) ) ( (lv_stakeholder_2_0= ruleStakeholder ) )+
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleOrganization122); 

                	newLeafNode(otherlv_0, grammarAccess.getOrganizationAccess().getOrganizationKeyword_0());
                
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:85:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOrganization139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getOrganizationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOrganizationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:102:2: ( (lv_stakeholder_2_0= ruleStakeholder ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:103:1: (lv_stakeholder_2_0= ruleStakeholder )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:103:1: (lv_stakeholder_2_0= ruleStakeholder )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:104:3: lv_stakeholder_2_0= ruleStakeholder
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOrganizationAccess().getStakeholderStakeholderParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStakeholder_in_ruleOrganization165);
            	    lv_stakeholder_2_0=ruleStakeholder();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOrganizationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"stakeholder",
            	            		lv_stakeholder_2_0, 
            	            		"Stakeholder");
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
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:128:1: entryRuleStakeholder returns [EObject current=null] : iv_ruleStakeholder= ruleStakeholder EOF ;
    public final EObject entryRuleStakeholder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStakeholder = null;


        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:129:2: (iv_ruleStakeholder= ruleStakeholder EOF )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:130:2: iv_ruleStakeholder= ruleStakeholder EOF
            {
             newCompositeNode(grammarAccess.getStakeholderRule()); 
            pushFollow(FOLLOW_ruleStakeholder_in_entryRuleStakeholder202);
            iv_ruleStakeholder=ruleStakeholder();

            state._fsp--;

             current =iv_ruleStakeholder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStakeholder212); 

            }

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
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:137:1: ruleStakeholder returns [EObject current=null] : (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' ) ;
    public final EObject ruleStakeholder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_title_5_0 = null;

        AntlrDatatypeRuleToken lv_description_7_0 = null;

        AntlrDatatypeRuleToken lv_role_9_0 = null;

        AntlrDatatypeRuleToken lv_email_11_0 = null;

        AntlrDatatypeRuleToken lv_phone_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:140:28: ( (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:1: (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:1: (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:3: otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleStakeholder249); 

                	newLeafNode(otherlv_0, grammarAccess.getStakeholderAccess().getStakeholderKeyword_0());
                
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:145:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:146:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:146:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:147:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStakeholder266); 

            			newLeafNode(lv_name_1_0, grammarAccess.getStakeholderAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStakeholderRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleStakeholder283); 

                	newLeafNode(otherlv_2, grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:167:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:169:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:169:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:170:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            	
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:173:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:174:3: ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )*
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:174:3: ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )*
            loop2:
            do {
                int alt2=6;
                int LA2_0 = input.LA(1);

                if ( LA2_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                    alt2=1;
                }
                else if ( LA2_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                    alt2=2;
                }
                else if ( LA2_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                    alt2=3;
                }
                else if ( LA2_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                    alt2=4;
                }
                else if ( LA2_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                    alt2=5;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:176:4: ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:176:4: ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:177:5: {...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:177:108: ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:178:6: ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:6: ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:7: {...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:16: (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:18: otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleStakeholder341); 

            	        	newLeafNode(otherlv_4, grammarAccess.getStakeholderAccess().getTitleKeyword_3_0_0());
            	        
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:185:1: ( (lv_title_5_0= ruleValueString ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:186:1: (lv_title_5_0= ruleValueString )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:186:1: (lv_title_5_0= ruleValueString )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:187:3: lv_title_5_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStakeholderAccess().getTitleValueStringParserRuleCall_3_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholder362);
            	    lv_title_5_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStakeholderRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"title",
            	            		lv_title_5_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:210:4: ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:210:4: ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:211:5: {...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:211:108: ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:212:6: ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:6: ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:7: {...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:16: (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:18: otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) )
            	    {
            	    otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleStakeholder430); 

            	        	newLeafNode(otherlv_6, grammarAccess.getStakeholderAccess().getDescriptionKeyword_3_1_0());
            	        
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:219:1: ( (lv_description_7_0= ruleValueString ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:220:1: (lv_description_7_0= ruleValueString )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:220:1: (lv_description_7_0= ruleValueString )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:221:3: lv_description_7_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStakeholderAccess().getDescriptionValueStringParserRuleCall_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholder451);
            	    lv_description_7_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStakeholderRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_7_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:244:4: ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:244:4: ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:245:5: {...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:245:108: ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:246:6: ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:6: ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:7: {...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:16: (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:18: otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) )
            	    {
            	    otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleStakeholder519); 

            	        	newLeafNode(otherlv_8, grammarAccess.getStakeholderAccess().getRoleKeyword_3_2_0());
            	        
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:253:1: ( (lv_role_9_0= ruleValueString ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:254:1: (lv_role_9_0= ruleValueString )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:254:1: (lv_role_9_0= ruleValueString )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:255:3: lv_role_9_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStakeholderAccess().getRoleValueStringParserRuleCall_3_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholder540);
            	    lv_role_9_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStakeholderRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"role",
            	            		lv_role_9_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:278:4: ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:278:4: ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:279:5: {...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:279:108: ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:280:6: ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:6: ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:7: {...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:16: (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:18: otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) )
            	    {
            	    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleStakeholder608); 

            	        	newLeafNode(otherlv_10, grammarAccess.getStakeholderAccess().getEmailKeyword_3_3_0());
            	        
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:287:1: ( (lv_email_11_0= ruleValueString ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:288:1: (lv_email_11_0= ruleValueString )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:288:1: (lv_email_11_0= ruleValueString )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:289:3: lv_email_11_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStakeholderAccess().getEmailValueStringParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholder629);
            	    lv_email_11_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStakeholderRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"email",
            	            		lv_email_11_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:312:4: ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:312:4: ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:313:5: {...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:313:108: ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:314:6: ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:6: ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:7: {...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:16: (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:18: otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) )
            	    {
            	    otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleStakeholder697); 

            	        	newLeafNode(otherlv_12, grammarAccess.getStakeholderAccess().getPhoneKeyword_3_4_0());
            	        
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:321:1: ( (lv_phone_13_0= ruleValueString ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:322:1: (lv_phone_13_0= ruleValueString )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:322:1: (lv_phone_13_0= ruleValueString )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:323:3: lv_phone_13_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStakeholderAccess().getPhoneValueStringParserRuleCall_3_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholder718);
            	    lv_phone_13_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStakeholderRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"phone",
            	            		lv_phone_13_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            	    	 				

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

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            	

            }

            otherlv_14=(Token)match(input,19,FOLLOW_19_in_ruleStakeholder771); 

                	newLeafNode(otherlv_14, grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_4());
                

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


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:367:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:368:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:369:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription809);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription819); 

            }

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
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:376:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:379:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:380:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:380:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_STRING)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:381:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:381:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:382:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription864);
            	    lv_description_0_0=ruleDescriptionElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDescriptionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"description",
            	            		lv_description_0_0, 
            	            		"DescriptionElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


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
    // $ANTLR end "ruleDescription"


    // $ANTLR start "entryRuleDescriptionElement"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:406:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:407:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:408:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement900);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement910); 

            }

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
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:415:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:418:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:419:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:419:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:419:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:419:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:420:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:420:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:421:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement952); 

                    			newLeafNode(lv_text_0_0, grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"text",
                            		lv_text_0_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:438:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:438:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:439:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:439:1: (otherlv_1= RULE_ID )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:440:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement983); 

                    		newLeafNode(otherlv_1, grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 
                    	

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleDescriptionElement"


    // $ANTLR start "entryRuleReferencePath"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:459:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:460:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:461:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath1019);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath1029); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferencePath"


    // $ANTLR start "ruleReferencePath"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:468:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:471:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:472:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:472:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:472:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:472:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:473:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:473:1: (otherlv_0= RULE_ID )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:474:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath1074); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:485:2: (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:485:4: otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleReferencePath1087); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:489:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:490:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:490:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:491:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath1108);
            lv_subpath_2_0=ruleReferencePath();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferencePathRule());
            	        }
                   		set(
                   			current, 
                   			"subpath",
                    		lv_subpath_2_0, 
                    		"ReferencePath");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


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
    // $ANTLR end "ruleReferencePath"


    // $ANTLR start "entryRuleValueString"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:515:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:516:2: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:517:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString1146);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString1157); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueString"


    // $ANTLR start "ruleValueString"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:524:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:527:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:528:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString1196); 

            		current.merge(this_STRING_0);
                
             
                newLeafNode(this_STRING_0, grammarAccess.getValueStringAccess().getSTRINGTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleValueString"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleOrganization_in_entryRuleOrganization75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrganization85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleOrganization122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOrganization139 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleStakeholder_in_ruleOrganization165 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_entryRuleStakeholder202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStakeholder212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleStakeholder249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStakeholder266 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleStakeholder283 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_14_in_ruleStakeholder341 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholder362 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_15_in_ruleStakeholder430 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholder451 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_16_in_ruleStakeholder519 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholder540 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_17_in_ruleStakeholder608 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholder629 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_18_in_ruleStakeholder697 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholder718 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_19_in_ruleStakeholder771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription809 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription864 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath1019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath1074 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleReferencePath1087 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString1146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString1196 = new BitSet(new long[]{0x0000000000000002L});

}

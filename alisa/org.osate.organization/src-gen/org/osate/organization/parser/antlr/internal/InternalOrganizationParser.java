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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'organization'", "'stakeholder'", "'['", "'full'", "'name'", "'title'", "'description'", "'role'", "'email'", "'phone'", "']'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

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
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:137:1: ruleStakeholder returns [EObject current=null] : (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_17= ']' ) ;
    public final EObject ruleStakeholder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_fullname_6_0=null;
        Token otherlv_7=null;
        Token lv_title_8_0=null;
        Token otherlv_9=null;
        Token lv_description_10_0=null;
        Token otherlv_11=null;
        Token lv_role_12_0=null;
        Token otherlv_13=null;
        Token lv_email_14_0=null;
        Token otherlv_15=null;
        Token lv_phone_16_0=null;
        Token otherlv_17=null;

         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:140:28: ( (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_17= ']' ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:1: (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_17= ']' )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:1: (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_17= ']' )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:3: otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_17= ']'
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
                
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:167:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:169:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:169:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:170:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            	
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:173:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )* )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:174:3: ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:174:3: ( ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) ) )*
            loop2:
            do {
                int alt2=7;
                int LA2_0 = input.LA(1);

                if ( LA2_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                    alt2=1;
                }
                else if ( LA2_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                    alt2=2;
                }
                else if ( LA2_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                    alt2=3;
                }
                else if ( LA2_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                    alt2=4;
                }
                else if ( LA2_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                    alt2=5;
                }
                else if ( LA2_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5) ) {
                    alt2=6;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:176:4: ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:176:4: ({...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:177:5: {...}? => ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:177:108: ( ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:178:6: ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:6: ({...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:7: {...}? => (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:16: (otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:18: otherlv_4= 'full' otherlv_5= 'name' ( (lv_fullname_6_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleStakeholder341); 

            	        	newLeafNode(otherlv_4, grammarAccess.getStakeholderAccess().getFullKeyword_3_0_0());
            	        
            	    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleStakeholder353); 

            	        	newLeafNode(otherlv_5, grammarAccess.getStakeholderAccess().getNameKeyword_3_0_1());
            	        
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:189:1: ( (lv_fullname_6_0= RULE_STRING ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:190:1: (lv_fullname_6_0= RULE_STRING )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:190:1: (lv_fullname_6_0= RULE_STRING )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:191:3: lv_fullname_6_0= RULE_STRING
            	    {
            	    lv_fullname_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStakeholder370); 

            	    			newLeafNode(lv_fullname_6_0, grammarAccess.getStakeholderAccess().getFullnameSTRINGTerminalRuleCall_3_0_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getStakeholderRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"fullname",
            	            		lv_fullname_6_0, 
            	            		"STRING");
            	    	    

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
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:214:4: ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:214:4: ({...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:5: {...}? => ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:108: ( ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:216:6: ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:219:6: ({...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:219:7: {...}? => (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:219:16: (otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:219:18: otherlv_7= 'title' ( (lv_title_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleStakeholder443); 

            	        	newLeafNode(otherlv_7, grammarAccess.getStakeholderAccess().getTitleKeyword_3_1_0());
            	        
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:223:1: ( (lv_title_8_0= RULE_STRING ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:224:1: (lv_title_8_0= RULE_STRING )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:224:1: (lv_title_8_0= RULE_STRING )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:225:3: lv_title_8_0= RULE_STRING
            	    {
            	    lv_title_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStakeholder460); 

            	    			newLeafNode(lv_title_8_0, grammarAccess.getStakeholderAccess().getTitleSTRINGTerminalRuleCall_3_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getStakeholderRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"title",
            	            		lv_title_8_0, 
            	            		"STRING");
            	    	    

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
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:248:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:248:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:5: {...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:108: ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:250:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:253:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:253:7: {...}? => (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:253:16: (otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:253:18: otherlv_9= 'description' ( (lv_description_10_0= RULE_STRING ) )
            	    {
            	    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleStakeholder533); 

            	        	newLeafNode(otherlv_9, grammarAccess.getStakeholderAccess().getDescriptionKeyword_3_2_0());
            	        
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:257:1: ( (lv_description_10_0= RULE_STRING ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:258:1: (lv_description_10_0= RULE_STRING )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:258:1: (lv_description_10_0= RULE_STRING )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:259:3: lv_description_10_0= RULE_STRING
            	    {
            	    lv_description_10_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStakeholder550); 

            	    			newLeafNode(lv_description_10_0, grammarAccess.getStakeholderAccess().getDescriptionSTRINGTerminalRuleCall_3_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getStakeholderRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"description",
            	            		lv_description_10_0, 
            	            		"STRING");
            	    	    

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
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:282:4: ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:282:4: ({...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:5: {...}? => ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:108: ( ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:284:6: ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:287:6: ({...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:287:7: {...}? => (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:287:16: (otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:287:18: otherlv_11= 'role' ( (lv_role_12_0= RULE_STRING ) )
            	    {
            	    otherlv_11=(Token)match(input,18,FOLLOW_18_in_ruleStakeholder623); 

            	        	newLeafNode(otherlv_11, grammarAccess.getStakeholderAccess().getRoleKeyword_3_3_0());
            	        
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:291:1: ( (lv_role_12_0= RULE_STRING ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:292:1: (lv_role_12_0= RULE_STRING )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:292:1: (lv_role_12_0= RULE_STRING )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:293:3: lv_role_12_0= RULE_STRING
            	    {
            	    lv_role_12_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStakeholder640); 

            	    			newLeafNode(lv_role_12_0, grammarAccess.getStakeholderAccess().getRoleSTRINGTerminalRuleCall_3_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getStakeholderRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"role",
            	            		lv_role_12_0, 
            	            		"STRING");
            	    	    

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
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:316:4: ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:316:4: ({...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:5: {...}? => ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:108: ( ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:318:6: ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:321:6: ({...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:321:7: {...}? => (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:321:16: (otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:321:18: otherlv_13= 'email' ( (lv_email_14_0= RULE_STRING ) )
            	    {
            	    otherlv_13=(Token)match(input,19,FOLLOW_19_in_ruleStakeholder713); 

            	        	newLeafNode(otherlv_13, grammarAccess.getStakeholderAccess().getEmailKeyword_3_4_0());
            	        
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:325:1: ( (lv_email_14_0= RULE_STRING ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:326:1: (lv_email_14_0= RULE_STRING )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:326:1: (lv_email_14_0= RULE_STRING )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:327:3: lv_email_14_0= RULE_STRING
            	    {
            	    lv_email_14_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStakeholder730); 

            	    			newLeafNode(lv_email_14_0, grammarAccess.getStakeholderAccess().getEmailSTRINGTerminalRuleCall_3_4_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getStakeholderRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"email",
            	            		lv_email_14_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:350:4: ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:350:4: ({...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:351:5: {...}? => ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:351:108: ( ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:352:6: ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:355:6: ({...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:355:7: {...}? => (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
            	    }
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:355:16: (otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:355:18: otherlv_15= 'phone' ( (lv_phone_16_0= RULE_STRING ) )
            	    {
            	    otherlv_15=(Token)match(input,20,FOLLOW_20_in_ruleStakeholder803); 

            	        	newLeafNode(otherlv_15, grammarAccess.getStakeholderAccess().getPhoneKeyword_3_5_0());
            	        
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:359:1: ( (lv_phone_16_0= RULE_STRING ) )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:360:1: (lv_phone_16_0= RULE_STRING )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:360:1: (lv_phone_16_0= RULE_STRING )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:361:3: lv_phone_16_0= RULE_STRING
            	    {
            	    lv_phone_16_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStakeholder820); 

            	    			newLeafNode(lv_phone_16_0, grammarAccess.getStakeholderAccess().getPhoneSTRINGTerminalRuleCall_3_5_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getStakeholderRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"phone",
            	            		lv_phone_16_0, 
            	            		"STRING");
            	    	    

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

            otherlv_17=(Token)match(input,21,FOLLOW_21_in_ruleStakeholder878); 

                	newLeafNode(otherlv_17, grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_4());
                

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
    public static final BitSet FOLLOW_13_in_ruleStakeholder283 = new BitSet(new long[]{0x00000000003F4000L});
    public static final BitSet FOLLOW_14_in_ruleStakeholder341 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStakeholder353 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStakeholder370 = new BitSet(new long[]{0x00000000003F4000L});
    public static final BitSet FOLLOW_16_in_ruleStakeholder443 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStakeholder460 = new BitSet(new long[]{0x00000000003F4000L});
    public static final BitSet FOLLOW_17_in_ruleStakeholder533 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStakeholder550 = new BitSet(new long[]{0x00000000003F4000L});
    public static final BitSet FOLLOW_18_in_ruleStakeholder623 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStakeholder640 = new BitSet(new long[]{0x00000000003F4000L});
    public static final BitSet FOLLOW_19_in_ruleStakeholder713 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStakeholder730 = new BitSet(new long[]{0x00000000003F4000L});
    public static final BitSet FOLLOW_20_in_ruleStakeholder803 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStakeholder820 = new BitSet(new long[]{0x00000000003F4000L});
    public static final BitSet FOLLOW_21_in_ruleStakeholder878 = new BitSet(new long[]{0x0000000000000002L});

}

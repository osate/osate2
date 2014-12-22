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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'organization'", "'stakeholder'", "'['", "'title'", "'description'", "'role'", "'email'", "'phone'", "']'", "'.'", "'.*'"
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
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:137:1: ruleStakeholder returns [EObject current=null] : (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )? ) ;
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
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:140:28: ( (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )? ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:1: (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )? )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:1: (otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )? )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:141:3: otherlv_0= 'stakeholder' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )?
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

            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:163:2: (otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:163:4: otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) ) otherlv_14= ']'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleStakeholder284); 

                        	newLeafNode(otherlv_2, grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:167:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) ) )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:169:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) )
                    {
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:169:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* ) )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:170:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* )
                    {
                     
                    	  getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:173:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )* )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:174:3: ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )*
                    {
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:174:3: ( ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) ) ) )*
                    loop2:
                    do {
                        int alt2=6;
                        int LA2_0 = input.LA(1);

                        if ( LA2_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                            alt2=1;
                        }
                        else if ( LA2_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                            alt2=2;
                        }
                        else if ( LA2_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                            alt2=3;
                        }
                        else if ( LA2_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                            alt2=4;
                        }
                        else if ( LA2_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                            alt2=5;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:176:4: ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:176:4: ({...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:177:5: {...}? => ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0)");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:177:110: ( ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:178:6: ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0);
                    	    	 				
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:6: ({...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:7: {...}? => (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:16: (otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:181:18: otherlv_4= 'title' ( (lv_title_5_0= ruleValueString ) )
                    	    {
                    	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleStakeholder342); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getStakeholderAccess().getTitleKeyword_2_1_0_0());
                    	        
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:185:1: ( (lv_title_5_0= ruleValueString ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:186:1: (lv_title_5_0= ruleValueString )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:186:1: (lv_title_5_0= ruleValueString )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:187:3: lv_title_5_0= ruleValueString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStakeholderAccess().getTitleValueStringParserRuleCall_2_1_0_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholder363);
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

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	    	 				

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
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1)");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:211:110: ( ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:212:6: ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1);
                    	    	 				
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:6: ({...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:7: {...}? => (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:16: (otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:215:18: otherlv_6= 'description' ( (lv_description_7_0= ruleValueString ) )
                    	    {
                    	    otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleStakeholder431); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getStakeholderAccess().getDescriptionKeyword_2_1_1_0());
                    	        
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:219:1: ( (lv_description_7_0= ruleValueString ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:220:1: (lv_description_7_0= ruleValueString )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:220:1: (lv_description_7_0= ruleValueString )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:221:3: lv_description_7_0= ruleValueString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStakeholderAccess().getDescriptionValueStringParserRuleCall_2_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholder452);
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

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	    	 				

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
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2)");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:245:110: ( ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:246:6: ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2);
                    	    	 				
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:6: ({...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:7: {...}? => (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:16: (otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:249:18: otherlv_8= 'role' ( (lv_role_9_0= ruleValueString ) )
                    	    {
                    	    otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleStakeholder520); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getStakeholderAccess().getRoleKeyword_2_1_2_0());
                    	        
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:253:1: ( (lv_role_9_0= ruleValueString ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:254:1: (lv_role_9_0= ruleValueString )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:254:1: (lv_role_9_0= ruleValueString )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:255:3: lv_role_9_0= ruleValueString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStakeholderAccess().getRoleValueStringParserRuleCall_2_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholder541);
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

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	    	 				

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
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3)");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:279:110: ( ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:280:6: ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3);
                    	    	 				
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:6: ({...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:7: {...}? => (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:16: (otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:283:18: otherlv_10= 'email' ( (lv_email_11_0= ruleValueString ) )
                    	    {
                    	    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleStakeholder609); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getStakeholderAccess().getEmailKeyword_2_1_3_0());
                    	        
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:287:1: ( (lv_email_11_0= ruleValueString ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:288:1: (lv_email_11_0= ruleValueString )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:288:1: (lv_email_11_0= ruleValueString )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:289:3: lv_email_11_0= ruleValueString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStakeholderAccess().getEmailValueStringParserRuleCall_2_1_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholder630);
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

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	    	 				

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
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4)");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:313:110: ( ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:314:6: ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4);
                    	    	 				
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:6: ({...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:7: {...}? => (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleStakeholder", "true");
                    	    }
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:16: (otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:317:18: otherlv_12= 'phone' ( (lv_phone_13_0= ruleValueString ) )
                    	    {
                    	    otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleStakeholder698); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getStakeholderAccess().getPhoneKeyword_2_1_4_0());
                    	        
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:321:1: ( (lv_phone_13_0= ruleValueString ) )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:322:1: (lv_phone_13_0= ruleValueString )
                    	    {
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:322:1: (lv_phone_13_0= ruleValueString )
                    	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:323:3: lv_phone_13_0= ruleValueString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStakeholderAccess().getPhoneValueStringParserRuleCall_2_1_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholder719);
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

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	    	 				

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

                     
                    	  getUnorderedGroupHelper().leave(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
                    	

                    }

                    otherlv_14=(Token)match(input,19,FOLLOW_19_in_ruleStakeholder772); 

                        	newLeafNode(otherlv_14, grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_2_2());
                        

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
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription812);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription822); 

            }

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
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_STRING)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:381:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:381:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:382:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription867);
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement903);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement913); 

            }

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
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:419:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:419:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:420:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:420:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:421:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement955); 

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
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement986); 

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
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath1022);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath1032); 

            }

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
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath1077); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:485:2: (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:485:4: otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleReferencePath1090); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:489:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:490:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:490:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:491:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath1111);
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
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:517:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:518:2: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:519:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString1151);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString1162); 

            }

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
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:526:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:529:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:530:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString1201); 

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


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:545:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:546:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:547:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1246);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1257); 

            }

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
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:554:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:557:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:558:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:558:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:558:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1297); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:565:1: (kw= '.' this_ID_2= RULE_ID )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:566:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,20,FOLLOW_20_in_ruleQualifiedName1316); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1331); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop6;
                }
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:586:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:587:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:588:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard1379);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard1390); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:595:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:598:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:599:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:599:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:600:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard1437);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:610:1: (kw= '.*' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.organization/src-gen/org/osate/organization/parser/antlr/internal/InternalOrganization.g:611:2: kw= '.*'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleQualifiedNameWithWildcard1456); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
                        

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
    // $ANTLR end "ruleQualifiedNameWithWildcard"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleOrganization_in_entryRuleOrganization75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrganization85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleOrganization122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOrganization139 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleStakeholder_in_ruleOrganization165 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_entryRuleStakeholder202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStakeholder212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleStakeholder249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStakeholder266 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleStakeholder284 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_14_in_ruleStakeholder342 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholder363 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_15_in_ruleStakeholder431 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholder452 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_16_in_ruleStakeholder520 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholder541 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_17_in_ruleStakeholder609 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholder630 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_18_in_ruleStakeholder698 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholder719 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_19_in_ruleStakeholder772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription867 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath1022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath1077 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleReferencePath1090 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString1151 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1297 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleQualifiedName1316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1331 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard1379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard1437 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleQualifiedNameWithWildcard1456 = new BitSet(new long[]{0x0000000000000002L});

}

package org.osate.alisa.workbench.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.alisa.workbench.services.AlisaGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAlisaParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'assurance'", "'plan'", "':'", "'for'", "'['", "'description'", "'assert'", "'subsystems'", "'assume'", "'issues'", "']'", "'task'", "'filter'", "'requirements'", "'verifications'", "'selections'", "'claims'", "'this'", "'::'", "'.'"
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
    public static final int T__30=30;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalAlisaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAlisaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAlisaParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g"; }



     	private AlisaGrammarAccess grammarAccess;
     	
        public InternalAlisaParser(TokenStream input, AlisaGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "AlisaWorkArea";	
       	}
       	
       	@Override
       	protected AlisaGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleAlisaWorkArea"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:67:1: entryRuleAlisaWorkArea returns [EObject current=null] : iv_ruleAlisaWorkArea= ruleAlisaWorkArea EOF ;
    public final EObject entryRuleAlisaWorkArea() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlisaWorkArea = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:68:2: (iv_ruleAlisaWorkArea= ruleAlisaWorkArea EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:69:2: iv_ruleAlisaWorkArea= ruleAlisaWorkArea EOF
            {
             newCompositeNode(grammarAccess.getAlisaWorkAreaRule()); 
            pushFollow(FOLLOW_ruleAlisaWorkArea_in_entryRuleAlisaWorkArea75);
            iv_ruleAlisaWorkArea=ruleAlisaWorkArea();

            state._fsp--;

             current =iv_ruleAlisaWorkArea; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlisaWorkArea85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlisaWorkArea"


    // $ANTLR start "ruleAlisaWorkArea"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:76:1: ruleAlisaWorkArea returns [EObject current=null] : ( ( (lv_cases_0_1= ruleAssurancePlan | lv_cases_0_2= ruleAssuranceTask ) ) )* ;
    public final EObject ruleAlisaWorkArea() throws RecognitionException {
        EObject current = null;

        EObject lv_cases_0_1 = null;

        EObject lv_cases_0_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:79:28: ( ( ( (lv_cases_0_1= ruleAssurancePlan | lv_cases_0_2= ruleAssuranceTask ) ) )* )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:80:1: ( ( (lv_cases_0_1= ruleAssurancePlan | lv_cases_0_2= ruleAssuranceTask ) ) )*
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:80:1: ( ( (lv_cases_0_1= ruleAssurancePlan | lv_cases_0_2= ruleAssuranceTask ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:81:1: ( (lv_cases_0_1= ruleAssurancePlan | lv_cases_0_2= ruleAssuranceTask ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:81:1: ( (lv_cases_0_1= ruleAssurancePlan | lv_cases_0_2= ruleAssuranceTask ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:82:1: (lv_cases_0_1= ruleAssurancePlan | lv_cases_0_2= ruleAssuranceTask )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:82:1: (lv_cases_0_1= ruleAssurancePlan | lv_cases_0_2= ruleAssuranceTask )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==11) ) {
            	        int LA1_1 = input.LA(2);

            	        if ( (LA1_1==22) ) {
            	            alt1=2;
            	        }
            	        else if ( (LA1_1==12) ) {
            	            alt1=1;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 1, 1, input);

            	            throw nvae;
            	        }
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:83:3: lv_cases_0_1= ruleAssurancePlan
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getAlisaWorkAreaAccess().getCasesAssurancePlanParserRuleCall_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleAssurancePlan_in_ruleAlisaWorkArea132);
            	            lv_cases_0_1=ruleAssurancePlan();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getAlisaWorkAreaRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"cases",
            	                    		lv_cases_0_1, 
            	                    		"AssurancePlan");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:98:8: lv_cases_0_2= ruleAssuranceTask
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getAlisaWorkAreaAccess().getCasesAssuranceTaskParserRuleCall_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleAssuranceTask_in_ruleAlisaWorkArea151);
            	            lv_cases_0_2=ruleAssuranceTask();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getAlisaWorkAreaRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"cases",
            	                    		lv_cases_0_2, 
            	                    		"AssuranceTask");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
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
    // $ANTLR end "ruleAlisaWorkArea"


    // $ANTLR start "entryRuleAssurancePlan"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:124:1: entryRuleAssurancePlan returns [EObject current=null] : iv_ruleAssurancePlan= ruleAssurancePlan EOF ;
    public final EObject entryRuleAssurancePlan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssurancePlan = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:125:2: (iv_ruleAssurancePlan= ruleAssurancePlan EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:126:2: iv_ruleAssurancePlan= ruleAssurancePlan EOF
            {
             newCompositeNode(grammarAccess.getAssurancePlanRule()); 
            pushFollow(FOLLOW_ruleAssurancePlan_in_entryRuleAssurancePlan190);
            iv_ruleAssurancePlan=ruleAssurancePlan();

            state._fsp--;

             current =iv_ruleAssurancePlan; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssurancePlan200); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:133:1: ruleAssurancePlan returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_19= ']' ) ;
    public final EObject ruleAssurancePlan() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_title_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token lv_issues_18_0=null;
        Token otherlv_19=null;
        EObject lv_description_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:136:28: ( (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_19= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:1: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_19= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:1: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_19= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:3: otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_19= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleAssurancePlan237); 

                	newLeafNode(otherlv_0, grammarAccess.getAssurancePlanAccess().getAssuranceKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleAssurancePlan249); 

                	newLeafNode(otherlv_1, grammarAccess.getAssurancePlanAccess().getPlanKeyword_1());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:145:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:146:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:146:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:147:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssurancePlan266); 

            			newLeafNode(lv_name_2_0, grammarAccess.getAssurancePlanAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:163:2: (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:163:4: otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleAssurancePlan284); 

                        	newLeafNode(otherlv_3, grammarAccess.getAssurancePlanAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:167:1: ( (lv_title_4_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:168:1: (lv_title_4_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:168:1: (lv_title_4_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:169:3: lv_title_4_0= RULE_STRING
                    {
                    lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssurancePlan301); 

                    			newLeafNode(lv_title_4_0, grammarAccess.getAssurancePlanAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"title",
                            		lv_title_4_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleAssurancePlan320); 

                	newLeafNode(otherlv_5, grammarAccess.getAssurancePlanAccess().getForKeyword_4());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:189:1: ( ( ruleAadlClassifierReference ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:190:1: ( ruleAadlClassifierReference )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:190:1: ( ruleAadlClassifierReference )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:191:3: ruleAadlClassifierReference
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getSystemComponentImplementationCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan343);
            ruleAadlClassifierReference();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleAssurancePlan355); 

                	newLeafNode(otherlv_7, grammarAccess.getAssurancePlanAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:208:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:210:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:210:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:211:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:214:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:215:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:215:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=5;
                int LA7_0 = input.LA(1);

                if ( LA7_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) ) {
                    alt7=2;
                }
                else if ( LA7_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) {
                    alt7=3;
                }
                else if ( LA7_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) ) {
                    alt7=4;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:217:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:217:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:218:5: {...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:218:110: ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:219:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:222:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:222:7: {...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:222:16: (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:222:18: otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) )
            	    {
            	    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleAssurancePlan413); 

            	        	newLeafNode(otherlv_9, grammarAccess.getAssurancePlanAccess().getDescriptionKeyword_7_0_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:226:1: ( (lv_description_10_0= ruleDescription ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:227:1: (lv_description_10_0= ruleDescription )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:227:1: (lv_description_10_0= ruleDescription )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:228:3: lv_description_10_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getDescriptionDescriptionParserRuleCall_7_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleAssurancePlan434);
            	    lv_description_10_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAssurancePlanRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_10_0, 
            	            		"Description");
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:251:4: ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:251:4: ({...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:252:5: {...}? => ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:252:110: ( ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:253:6: ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:6: ({...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:7: {...}? => (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:16: (otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:18: otherlv_11= 'assert' otherlv_12= 'subsystems' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_11=(Token)match(input,17,FOLLOW_17_in_ruleAssurancePlan502); 

            	        	newLeafNode(otherlv_11, grammarAccess.getAssurancePlanAccess().getAssertKeyword_7_1_0());
            	        
            	    otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleAssurancePlan514); 

            	        	newLeafNode(otherlv_12, grammarAccess.getAssurancePlanAccess().getSubsystemsKeyword_7_1_1());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:264:1: ( ( ruleQualifiedName ) )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==RULE_ID) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:265:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:265:1: ( ruleQualifiedName )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:266:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getSubsystemPlansAssurancePlanCrossReference_7_1_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssurancePlan537);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:286:4: ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:286:4: ({...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:287:5: {...}? => ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:287:110: ( ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:288:6: ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:6: ({...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:7: {...}? => (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:16: (otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:18: otherlv_14= 'assume' otherlv_15= 'subsystems' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_14=(Token)match(input,19,FOLLOW_19_in_ruleAssurancePlan606); 

            	        	newLeafNode(otherlv_14, grammarAccess.getAssurancePlanAccess().getAssumeKeyword_7_2_0());
            	        
            	    otherlv_15=(Token)match(input,18,FOLLOW_18_in_ruleAssurancePlan618); 

            	        	newLeafNode(otherlv_15, grammarAccess.getAssurancePlanAccess().getSubsystemsKeyword_7_2_1());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:299:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:300:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:300:1: ( ruleQualifiedName )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:301:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getVerifiedAssumptionAssurancePlanCrossReference_7_2_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssurancePlan641);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt5 >= 1 ) break loop5;
            	                EarlyExitException eee =
            	                    new EarlyExitException(5, input);
            	                throw eee;
            	        }
            	        cnt5++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:321:4: ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:321:4: ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:322:5: {...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:322:110: ( ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:323:6: ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:6: ({...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:7: {...}? => (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:16: (otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:18: otherlv_17= 'issues' ( (lv_issues_18_0= RULE_STRING ) )+
            	    {
            	    otherlv_17=(Token)match(input,20,FOLLOW_20_in_ruleAssurancePlan710); 

            	        	newLeafNode(otherlv_17, grammarAccess.getAssurancePlanAccess().getIssuesKeyword_7_3_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:330:1: ( (lv_issues_18_0= RULE_STRING ) )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==RULE_STRING) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:331:1: (lv_issues_18_0= RULE_STRING )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:331:1: (lv_issues_18_0= RULE_STRING )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:332:3: lv_issues_18_0= RULE_STRING
            	    	    {
            	    	    lv_issues_18_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssurancePlan727); 

            	    	    			newLeafNode(lv_issues_18_0, grammarAccess.getAssurancePlanAccess().getIssuesSTRINGTerminalRuleCall_7_3_1_0()); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	           		addWithLastConsumed(
            	    	           			current, 
            	    	           			"issues",
            	    	            		lv_issues_18_0, 
            	    	            		"STRING");
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt6 >= 1 ) break loop6;
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

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7()) ) {
                throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canLeave(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	

            }

            otherlv_19=(Token)match(input,21,FOLLOW_21_in_ruleAssurancePlan792); 

                	newLeafNode(otherlv_19, grammarAccess.getAssurancePlanAccess().getRightSquareBracketKeyword_8());
                

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
    // $ANTLR end "ruleAssurancePlan"


    // $ANTLR start "entryRuleAssuranceTask"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:375:1: entryRuleAssuranceTask returns [EObject current=null] : iv_ruleAssuranceTask= ruleAssuranceTask EOF ;
    public final EObject entryRuleAssuranceTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssuranceTask = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:376:2: (iv_ruleAssuranceTask= ruleAssuranceTask EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:377:2: iv_ruleAssuranceTask= ruleAssuranceTask EOF
            {
             newCompositeNode(grammarAccess.getAssuranceTaskRule()); 
            pushFollow(FOLLOW_ruleAssuranceTask_in_entryRuleAssuranceTask828);
            iv_ruleAssuranceTask=ruleAssuranceTask();

            state._fsp--;

             current =iv_ruleAssuranceTask; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssuranceTask838); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:384:1: ruleAssuranceTask returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' ) ;
    public final EObject ruleAssuranceTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_title_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token lv_issues_22_0=null;
        Token otherlv_23=null;
        EObject lv_description_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:387:28: ( (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:388:1: (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:388:1: (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:388:3: otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleAssuranceTask875); 

                	newLeafNode(otherlv_0, grammarAccess.getAssuranceTaskAccess().getAssuranceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleAssuranceTask887); 

                	newLeafNode(otherlv_1, grammarAccess.getAssuranceTaskAccess().getTaskKeyword_1());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:396:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:397:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:397:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:398:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask904); 

            			newLeafNode(lv_name_2_0, grammarAccess.getAssuranceTaskAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:414:2: (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==13) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:414:4: otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleAssuranceTask922); 

                        	newLeafNode(otherlv_3, grammarAccess.getAssuranceTaskAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:418:1: ( (lv_title_4_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:419:1: (lv_title_4_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:419:1: (lv_title_4_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:420:3: lv_title_4_0= RULE_STRING
                    {
                    lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssuranceTask939); 

                    			newLeafNode(lv_title_4_0, grammarAccess.getAssuranceTaskAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"title",
                            		lv_title_4_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleAssuranceTask958); 

                	newLeafNode(otherlv_5, grammarAccess.getAssuranceTaskAccess().getForKeyword_4());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:440:1: ( (otherlv_6= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:441:1: (otherlv_6= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:441:1: (otherlv_6= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:442:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask978); 

            		newLeafNode(otherlv_6, grammarAccess.getAssuranceTaskAccess().getAssurancePlanAssurancePlanCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleAssuranceTask990); 

                	newLeafNode(otherlv_7, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:457:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:459:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:459:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:460:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:463:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:464:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:464:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=4;
                int LA17_0 = input.LA(1);

                if ( LA17_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0) ) {
                    alt17=1;
                }
                else if ( (LA17_0==23|| LA17_0 >=25 && LA17_0<=27) && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1) ) {
                    alt17=2;
                }
                else if ( LA17_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2) ) {
                    alt17=3;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:466:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:466:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:467:5: {...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:467:110: ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:468:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:471:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:471:7: {...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:471:16: (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:471:18: otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) )
            	    {
            	    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleAssuranceTask1048); 

            	        	newLeafNode(otherlv_9, grammarAccess.getAssuranceTaskAccess().getDescriptionKeyword_7_0_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:475:1: ( (lv_description_10_0= ruleDescription ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:476:1: (lv_description_10_0= ruleDescription )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:476:1: (lv_description_10_0= ruleDescription )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:477:3: lv_description_10_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getDescriptionDescriptionParserRuleCall_7_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleAssuranceTask1069);
            	    lv_description_10_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAssuranceTaskRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_10_0, 
            	            		"Description");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:500:4: ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:500:4: ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:501:5: {...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:501:110: ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:502:6: ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:505:6: ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:505:7: {...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:505:16: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) )
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==23||(LA15_0>=25 && LA15_0<=26)) ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0==27) ) {
            	        alt15=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 15, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:505:17: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:505:17: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:507:1: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:507:1: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:508:2: ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?)
            	            {
            	             
            	            	  getUnorderedGroupHelper().enter(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0());
            	            	
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:511:2: ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?)
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:512:3: ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:512:3: ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+
            	            int cnt13=0;
            	            loop13:
            	            do {
            	                int alt13=4;
            	                switch ( input.LA(1) ) {
            	                case 23:
            	                    {
            	                    int LA13_2 = input.LA(2);

            	                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0) ) {
            	                        alt13=1;
            	                    }


            	                    }
            	                    break;
            	                case 25:
            	                    {
            	                    int LA13_3 = input.LA(2);

            	                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1) ) {
            	                        alt13=2;
            	                    }


            	                    }
            	                    break;
            	                case 26:
            	                    {
            	                    int LA13_4 = input.LA(2);

            	                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 2) ) {
            	                        alt13=3;
            	                    }


            	                    }
            	                    break;

            	                }

            	                switch (alt13) {
            	            	case 1 :
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:514:4: ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:514:4: ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:515:5: {...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) )
            	            	    {
            	            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0)");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:515:114: ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:516:6: ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) )
            	            	    {
            	            	     
            	            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0);
            	            	    	 				
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:519:6: ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:519:7: {...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? )
            	            	    {
            	            	    if ( !((true)) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:519:16: (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:519:18: otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )?
            	            	    {
            	            	    otherlv_12=(Token)match(input,23,FOLLOW_23_in_ruleAssuranceTask1183); 

            	            	        	newLeafNode(otherlv_12, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0_0());
            	            	        
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:523:1: (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )?
            	            	    int alt10=2;
            	            	    int LA10_0 = input.LA(1);

            	            	    if ( (LA10_0==24) ) {
            	            	        alt10=1;
            	            	    }
            	            	    switch (alt10) {
            	            	        case 1 :
            	            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:523:3: otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+
            	            	            {
            	            	            otherlv_13=(Token)match(input,24,FOLLOW_24_in_ruleAssuranceTask1196); 

            	            	                	newLeafNode(otherlv_13, grammarAccess.getAssuranceTaskAccess().getRequirementsKeyword_7_1_0_0_1_0());
            	            	                
            	            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:527:1: ( (otherlv_14= RULE_ID ) )+
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
            	            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:528:1: (otherlv_14= RULE_ID )
            	            	            	    {
            	            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:528:1: (otherlv_14= RULE_ID )
            	            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:529:3: otherlv_14= RULE_ID
            	            	            	    {

            	            	            	    			if (current==null) {
            	            	            	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	            	    	        }
            	            	            	            
            	            	            	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1216); 

            	            	            	    		newLeafNode(otherlv_14, grammarAccess.getAssuranceTaskAccess().getRequirementFilterRequirementCategoryCrossReference_7_1_0_0_1_1_0()); 
            	            	            	    	

            	            	            	    }


            	            	            	    }
            	            	            	    break;

            	            	            	default :
            	            	            	    if ( cnt9 >= 1 ) break loop9;
            	            	                        EarlyExitException eee =
            	            	                            new EarlyExitException(9, input);
            	            	                        throw eee;
            	            	                }
            	            	                cnt9++;
            	            	            } while (true);


            	            	            }
            	            	            break;

            	            	    }


            	            	    }


            	            	    }

            	            	     
            	            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0());
            	            	    	 				

            	            	    }


            	            	    }


            	            	    }
            	            	    break;
            	            	case 2 :
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:547:4: ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:547:4: ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:548:5: {...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) )
            	            	    {
            	            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1)");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:548:114: ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:549:6: ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) )
            	            	    {
            	            	     
            	            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1);
            	            	    	 				
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:552:6: ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:552:7: {...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ )
            	            	    {
            	            	    if ( !((true)) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:552:16: (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:552:18: otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+
            	            	    {
            	            	    otherlv_15=(Token)match(input,25,FOLLOW_25_in_ruleAssuranceTask1287); 

            	            	        	newLeafNode(otherlv_15, grammarAccess.getAssuranceTaskAccess().getVerificationsKeyword_7_1_0_1_0());
            	            	        
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:556:1: ( (otherlv_16= RULE_ID ) )+
            	            	    int cnt11=0;
            	            	    loop11:
            	            	    do {
            	            	        int alt11=2;
            	            	        int LA11_0 = input.LA(1);

            	            	        if ( (LA11_0==RULE_ID) ) {
            	            	            alt11=1;
            	            	        }


            	            	        switch (alt11) {
            	            	    	case 1 :
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:557:1: (otherlv_16= RULE_ID )
            	            	    	    {
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:557:1: (otherlv_16= RULE_ID )
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:558:3: otherlv_16= RULE_ID
            	            	    	    {

            	            	    	    			if (current==null) {
            	            	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	    	    	        }
            	            	    	            
            	            	    	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1307); 

            	            	    	    		newLeafNode(otherlv_16, grammarAccess.getAssuranceTaskAccess().getVerificationFilterVerificationCategoryCrossReference_7_1_0_1_1_0()); 
            	            	    	    	

            	            	    	    }


            	            	    	    }
            	            	    	    break;

            	            	    	default :
            	            	    	    if ( cnt11 >= 1 ) break loop11;
            	            	                EarlyExitException eee =
            	            	                    new EarlyExitException(11, input);
            	            	                throw eee;
            	            	        }
            	            	        cnt11++;
            	            	    } while (true);


            	            	    }


            	            	    }

            	            	     
            	            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0());
            	            	    	 				

            	            	    }


            	            	    }


            	            	    }
            	            	    break;
            	            	case 3 :
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:576:4: ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:576:4: ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:577:5: {...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) )
            	            	    {
            	            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 2) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 2)");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:577:114: ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:578:6: ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) )
            	            	    {
            	            	     
            	            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 2);
            	            	    	 				
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:581:6: ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:581:7: {...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ )
            	            	    {
            	            	    if ( !((true)) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:581:16: (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:581:18: otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+
            	            	    {
            	            	    otherlv_17=(Token)match(input,26,FOLLOW_26_in_ruleAssuranceTask1376); 

            	            	        	newLeafNode(otherlv_17, grammarAccess.getAssuranceTaskAccess().getSelectionsKeyword_7_1_0_2_0());
            	            	        
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:585:1: ( (otherlv_18= RULE_ID ) )+
            	            	    int cnt12=0;
            	            	    loop12:
            	            	    do {
            	            	        int alt12=2;
            	            	        int LA12_0 = input.LA(1);

            	            	        if ( (LA12_0==RULE_ID) ) {
            	            	            alt12=1;
            	            	        }


            	            	        switch (alt12) {
            	            	    	case 1 :
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:586:1: (otherlv_18= RULE_ID )
            	            	    	    {
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:586:1: (otherlv_18= RULE_ID )
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:587:3: otherlv_18= RULE_ID
            	            	    	    {

            	            	    	    			if (current==null) {
            	            	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	    	    	        }
            	            	    	            
            	            	    	    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1396); 

            	            	    	    		newLeafNode(otherlv_18, grammarAccess.getAssuranceTaskAccess().getSelectionFilterSelectionCategoryCrossReference_7_1_0_2_1_0()); 
            	            	    	    	

            	            	    	    }


            	            	    	    }
            	            	    	    break;

            	            	    	default :
            	            	    	    if ( cnt12 >= 1 ) break loop12;
            	            	                EarlyExitException eee =
            	            	                    new EarlyExitException(12, input);
            	            	                throw eee;
            	            	        }
            	            	        cnt12++;
            	            	    } while (true);


            	            	    }


            	            	    }

            	            	     
            	            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0());
            	            	    	 				

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    if ( cnt13 >= 1 ) break loop13;
            	                        EarlyExitException eee =
            	                            new EarlyExitException(13, input);
            	                        throw eee;
            	                }
            	                cnt13++;
            	            } while (true);

            	            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0()) ) {
            	                throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canLeave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0())");
            	            }

            	            }


            	            }

            	             
            	            	  getUnorderedGroupHelper().leave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0());
            	            	

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:614:6: (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:614:6: (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:614:8: otherlv_19= 'claims' ( ( ruleQualifiedName ) )+
            	            {
            	            otherlv_19=(Token)match(input,27,FOLLOW_27_in_ruleAssuranceTask1463); 

            	                	newLeafNode(otherlv_19, grammarAccess.getAssuranceTaskAccess().getClaimsKeyword_7_1_1_0());
            	                
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:618:1: ( ( ruleQualifiedName ) )+
            	            int cnt14=0;
            	            loop14:
            	            do {
            	                int alt14=2;
            	                int LA14_0 = input.LA(1);

            	                if ( (LA14_0==RULE_ID) ) {
            	                    alt14=1;
            	                }


            	                switch (alt14) {
            	            	case 1 :
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:619:1: ( ruleQualifiedName )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:619:1: ( ruleQualifiedName )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:620:3: ruleQualifiedName
            	            	    {

            	            	    			if (current==null) {
            	            	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	    	        }
            	            	            
            	            	     
            	            	    	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getClaimsClaimCrossReference_7_1_1_1_0()); 
            	            	    	    
            	            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssuranceTask1486);
            	            	    ruleQualifiedName();

            	            	    state._fsp--;

            	            	     
            	            	    	        afterParserOrEnumRuleCall();
            	            	    	    

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    if ( cnt14 >= 1 ) break loop14;
            	                        EarlyExitException eee =
            	                            new EarlyExitException(14, input);
            	                        throw eee;
            	                }
            	                cnt14++;
            	            } while (true);


            	            }


            	            }
            	            break;

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:640:4: ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:640:4: ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:641:5: {...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:641:110: ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:642:6: ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:645:6: ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:645:7: {...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:645:16: (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:645:18: otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+
            	    {
            	    otherlv_21=(Token)match(input,20,FOLLOW_20_in_ruleAssuranceTask1556); 

            	        	newLeafNode(otherlv_21, grammarAccess.getAssuranceTaskAccess().getIssuesKeyword_7_2_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:649:1: ( (lv_issues_22_0= RULE_STRING ) )+
            	    int cnt16=0;
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==RULE_STRING) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:650:1: (lv_issues_22_0= RULE_STRING )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:650:1: (lv_issues_22_0= RULE_STRING )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:651:3: lv_issues_22_0= RULE_STRING
            	    	    {
            	    	    lv_issues_22_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssuranceTask1573); 

            	    	    			newLeafNode(lv_issues_22_0, grammarAccess.getAssuranceTaskAccess().getIssuesSTRINGTerminalRuleCall_7_2_1_0()); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	    	    	        }
            	    	           		addWithLastConsumed(
            	    	           			current, 
            	    	           			"issues",
            	    	            		lv_issues_22_0, 
            	    	            		"STRING");
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt16 >= 1 ) break loop16;
            	                EarlyExitException eee =
            	                    new EarlyExitException(16, input);
            	                throw eee;
            	        }
            	        cnt16++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7()) ) {
                throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canLeave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	

            }

            otherlv_23=(Token)match(input,21,FOLLOW_21_in_ruleAssuranceTask1638); 

                	newLeafNode(otherlv_23, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8());
                

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
    // $ANTLR end "ruleAssuranceTask"


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:694:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:695:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:696:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription1674);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription1684); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:703:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:706:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:707:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:707:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING||LA18_0==28) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:708:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:708:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:709:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription1729);
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
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:733:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:734:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:735:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1765);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement1775); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:742:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_thisTarget_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:745:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:746:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:746:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_STRING) ) {
                alt19=1;
            }
            else if ( (LA19_0==28) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:746:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:746:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:747:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:747:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:748:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement1817); 

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
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:765:6: ( (lv_thisTarget_1_0= 'this' ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:765:6: ( (lv_thisTarget_1_0= 'this' ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:766:1: (lv_thisTarget_1_0= 'this' )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:766:1: (lv_thisTarget_1_0= 'this' )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:767:3: lv_thisTarget_1_0= 'this'
                    {
                    lv_thisTarget_1_0=(Token)match(input,28,FOLLOW_28_in_ruleDescriptionElement1846); 

                            newLeafNode(lv_thisTarget_1_0, grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                           		setWithLastConsumed(current, "thisTarget", true, "this");
                    	    

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


    // $ANTLR start "entryRuleAadlClassifierReference"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:788:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:789:2: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:790:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1896);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference1907); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:797:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:800:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:801:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:801:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:801:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1947); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:808:1: (kw= '::' this_ID_2= RULE_ID )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==29) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:809:2: kw= '::' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,29,FOLLOW_29_in_ruleAadlClassifierReference1966); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1981); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:821:3: (kw= '.' this_ID_4= RULE_ID )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:822:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleAadlClassifierReference2002); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference2017); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_2_1()); 
                        

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
    // $ANTLR end "ruleAadlClassifierReference"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:842:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:843:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:844:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2065);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2076); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:851:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:854:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:855:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:855:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:855:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2116); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:862:1: (kw= '.' this_ID_2= RULE_ID )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:863:2: kw= '.' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleQualifiedName2135); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
                        
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2150); 

                    		current.merge(this_ID_2);
                        
                     
                        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
                        

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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleAlisaWorkArea_in_entryRuleAlisaWorkArea75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlisaWorkArea85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssurancePlan_in_ruleAlisaWorkArea132 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleAssuranceTask_in_ruleAlisaWorkArea151 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleAssurancePlan_in_entryRuleAssurancePlan190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssurancePlan200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleAssurancePlan237 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAssurancePlan249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssurancePlan266 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleAssurancePlan284 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssurancePlan301 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAssurancePlan320 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan343 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssurancePlan355 = new BitSet(new long[]{0x00000000001B0000L});
    public static final BitSet FOLLOW_16_in_ruleAssurancePlan413 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssurancePlan434 = new BitSet(new long[]{0x00000000003B0000L});
    public static final BitSet FOLLOW_17_in_ruleAssurancePlan502 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAssurancePlan514 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssurancePlan537 = new BitSet(new long[]{0x00000000003B0010L});
    public static final BitSet FOLLOW_19_in_ruleAssurancePlan606 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAssurancePlan618 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssurancePlan641 = new BitSet(new long[]{0x00000000003B0010L});
    public static final BitSet FOLLOW_20_in_ruleAssurancePlan710 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssurancePlan727 = new BitSet(new long[]{0x00000000003B0020L});
    public static final BitSet FOLLOW_21_in_ruleAssurancePlan792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssuranceTask_in_entryRuleAssuranceTask828 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssuranceTask838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleAssuranceTask875 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleAssuranceTask887 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask904 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleAssuranceTask922 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssuranceTask939 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAssuranceTask958 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask978 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssuranceTask990 = new BitSet(new long[]{0x000000000E910000L});
    public static final BitSet FOLLOW_16_in_ruleAssuranceTask1048 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssuranceTask1069 = new BitSet(new long[]{0x000000000EB10000L});
    public static final BitSet FOLLOW_23_in_ruleAssuranceTask1183 = new BitSet(new long[]{0x000000000FB10000L});
    public static final BitSet FOLLOW_24_in_ruleAssuranceTask1196 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1216 = new BitSet(new long[]{0x000000000EB10010L});
    public static final BitSet FOLLOW_25_in_ruleAssuranceTask1287 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1307 = new BitSet(new long[]{0x000000000EB10010L});
    public static final BitSet FOLLOW_26_in_ruleAssuranceTask1376 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1396 = new BitSet(new long[]{0x000000000EB10010L});
    public static final BitSet FOLLOW_27_in_ruleAssuranceTask1463 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssuranceTask1486 = new BitSet(new long[]{0x000000000EB10010L});
    public static final BitSet FOLLOW_20_in_ruleAssuranceTask1556 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssuranceTask1573 = new BitSet(new long[]{0x000000000EB10020L});
    public static final BitSet FOLLOW_21_in_ruleAssuranceTask1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription1674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription1729 = new BitSet(new long[]{0x0000000010000022L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleDescriptionElement1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference1907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1947 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAadlClassifierReference1966 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1981 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_30_in_ruleAadlClassifierReference2002 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference2017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2065 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2116 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleQualifiedName2135 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2150 = new BitSet(new long[]{0x0000000000000002L});

}

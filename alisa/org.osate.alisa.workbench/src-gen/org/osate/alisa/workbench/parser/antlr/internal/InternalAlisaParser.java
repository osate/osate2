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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'assurance'", "'plan'", "':'", "'for'", "'['", "'description'", "'assure'", "'subsystem'", "'plans'", "'assume'", "'subsystems'", "'issues'", "']'", "'task'", "'filter'", "'requirements'", "'verifications'", "'selections'", "'claims'", "'this'", "'::'", "'.'"
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
    public static final int T__31=31;
    public static final int T__32=32;
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

            	        if ( (LA1_1==24) ) {
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:133:1: ruleAssurancePlan returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_20= ']' ) ;
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
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token lv_issues_19_0=null;
        Token otherlv_20=null;
        EObject lv_description_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:136:28: ( (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_20= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:1: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_20= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:1: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_20= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:3: otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_20= ']'
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
                    
             
            	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getTargetComponentImplementationCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan343);
            ruleAadlClassifierReference();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleAssurancePlan355); 

                	newLeafNode(otherlv_7, grammarAccess.getAssurancePlanAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:208:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )* ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:210:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:210:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:211:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:214:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )* )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:215:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )*
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:215:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) ) )*
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
                else if ( LA7_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) {
                    alt7=3;
                }
                else if ( LA7_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) ) {
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:251:4: ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:251:4: ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:252:5: {...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:252:110: ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:253:6: ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:6: ({...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:7: {...}? => (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:16: (otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:18: otherlv_11= 'assure' otherlv_12= 'subsystem' otherlv_13= 'plans' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_11=(Token)match(input,17,FOLLOW_17_in_ruleAssurancePlan502); 

            	        	newLeafNode(otherlv_11, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_1_0());
            	        
            	    otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleAssurancePlan514); 

            	        	newLeafNode(otherlv_12, grammarAccess.getAssurancePlanAccess().getSubsystemKeyword_7_1_1());
            	        
            	    otherlv_13=(Token)match(input,19,FOLLOW_19_in_ruleAssurancePlan526); 

            	        	newLeafNode(otherlv_13, grammarAccess.getAssurancePlanAccess().getPlansKeyword_7_1_2());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:268:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:269:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:269:1: ( ruleQualifiedName )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:270:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssurePlansAssurancePlanCrossReference_7_1_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssurancePlan549);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:290:4: ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:290:4: ({...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:5: {...}? => ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:110: ( ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:292:6: ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:295:6: ({...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:295:7: {...}? => (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:295:16: (otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:295:18: otherlv_15= 'assume' otherlv_16= 'subsystems' ( ( ruleAadlClassifierReference ) )+
            	    {
            	    otherlv_15=(Token)match(input,20,FOLLOW_20_in_ruleAssurancePlan618); 

            	        	newLeafNode(otherlv_15, grammarAccess.getAssurancePlanAccess().getAssumeKeyword_7_2_0());
            	        
            	    otherlv_16=(Token)match(input,21,FOLLOW_21_in_ruleAssurancePlan630); 

            	        	newLeafNode(otherlv_16, grammarAccess.getAssurancePlanAccess().getSubsystemsKeyword_7_2_1());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:303:1: ( ( ruleAadlClassifierReference ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:304:1: ( ruleAadlClassifierReference )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:304:1: ( ruleAadlClassifierReference )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:305:3: ruleAadlClassifierReference
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssumeSubsystemsComponentClassifierCrossReference_7_2_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan653);
            	    	    ruleAadlClassifierReference();

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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:325:4: ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:325:4: ({...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:5: {...}? => ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:110: ( ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:327:6: ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:330:6: ({...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:330:7: {...}? => (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:330:16: (otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:330:18: otherlv_18= 'issues' ( (lv_issues_19_0= RULE_STRING ) )+
            	    {
            	    otherlv_18=(Token)match(input,22,FOLLOW_22_in_ruleAssurancePlan722); 

            	        	newLeafNode(otherlv_18, grammarAccess.getAssurancePlanAccess().getIssuesKeyword_7_3_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:334:1: ( (lv_issues_19_0= RULE_STRING ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:335:1: (lv_issues_19_0= RULE_STRING )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:335:1: (lv_issues_19_0= RULE_STRING )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:336:3: lv_issues_19_0= RULE_STRING
            	    	    {
            	    	    lv_issues_19_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssurancePlan739); 

            	    	    			newLeafNode(lv_issues_19_0, grammarAccess.getAssurancePlanAccess().getIssuesSTRINGTerminalRuleCall_7_3_1_0()); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	           		addWithLastConsumed(
            	    	           			current, 
            	    	           			"issues",
            	    	            		lv_issues_19_0, 
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
            	    break loop7;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	

            }

            otherlv_20=(Token)match(input,23,FOLLOW_23_in_ruleAssurancePlan798); 

                	newLeafNode(otherlv_20, grammarAccess.getAssurancePlanAccess().getRightSquareBracketKeyword_8());
                

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:378:1: entryRuleAssuranceTask returns [EObject current=null] : iv_ruleAssuranceTask= ruleAssuranceTask EOF ;
    public final EObject entryRuleAssuranceTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssuranceTask = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:379:2: (iv_ruleAssuranceTask= ruleAssuranceTask EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:380:2: iv_ruleAssuranceTask= ruleAssuranceTask EOF
            {
             newCompositeNode(grammarAccess.getAssuranceTaskRule()); 
            pushFollow(FOLLOW_ruleAssuranceTask_in_entryRuleAssuranceTask834);
            iv_ruleAssuranceTask=ruleAssuranceTask();

            state._fsp--;

             current =iv_ruleAssuranceTask; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssuranceTask844); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:387:1: ruleAssuranceTask returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' ) ;
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
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:390:28: ( (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:391:1: (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:391:1: (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:391:3: otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleAssuranceTask881); 

                	newLeafNode(otherlv_0, grammarAccess.getAssuranceTaskAccess().getAssuranceKeyword_0());
                
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleAssuranceTask893); 

                	newLeafNode(otherlv_1, grammarAccess.getAssuranceTaskAccess().getTaskKeyword_1());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:399:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:400:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:400:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:401:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask910); 

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

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:417:2: (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==13) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:417:4: otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleAssuranceTask928); 

                        	newLeafNode(otherlv_3, grammarAccess.getAssuranceTaskAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:421:1: ( (lv_title_4_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:422:1: (lv_title_4_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:422:1: (lv_title_4_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:423:3: lv_title_4_0= RULE_STRING
                    {
                    lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssuranceTask945); 

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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleAssuranceTask964); 

                	newLeafNode(otherlv_5, grammarAccess.getAssuranceTaskAccess().getForKeyword_4());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:443:1: ( (otherlv_6= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:444:1: (otherlv_6= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:444:1: (otherlv_6= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:445:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask984); 

            		newLeafNode(otherlv_6, grammarAccess.getAssuranceTaskAccess().getAssurancePlanAssurancePlanCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleAssuranceTask996); 

                	newLeafNode(otherlv_7, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:460:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:462:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:462:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:463:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:466:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:467:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:467:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=4;
                int LA17_0 = input.LA(1);

                if ( LA17_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0) ) {
                    alt17=1;
                }
                else if ( (LA17_0==25|| LA17_0 >=27 && LA17_0<=29) && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1) ) {
                    alt17=2;
                }
                else if ( LA17_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2) ) {
                    alt17=3;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:469:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:469:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:470:5: {...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:470:110: ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:471:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:474:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:474:7: {...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:474:16: (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:474:18: otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) )
            	    {
            	    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleAssuranceTask1054); 

            	        	newLeafNode(otherlv_9, grammarAccess.getAssuranceTaskAccess().getDescriptionKeyword_7_0_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:478:1: ( (lv_description_10_0= ruleDescription ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:479:1: (lv_description_10_0= ruleDescription )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:479:1: (lv_description_10_0= ruleDescription )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:480:3: lv_description_10_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getDescriptionDescriptionParserRuleCall_7_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleAssuranceTask1075);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:503:4: ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:503:4: ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:504:5: {...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:504:110: ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:505:6: ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:508:6: ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:508:7: {...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:508:16: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) )
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==25||(LA15_0>=27 && LA15_0<=28)) ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0==29) ) {
            	        alt15=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 15, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:508:17: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:508:17: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:510:1: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:510:1: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:511:2: ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?)
            	            {
            	             
            	            	  getUnorderedGroupHelper().enter(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0());
            	            	
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:514:2: ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?)
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:515:3: ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:515:3: ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+
            	            int cnt13=0;
            	            loop13:
            	            do {
            	                int alt13=4;
            	                switch ( input.LA(1) ) {
            	                case 25:
            	                    {
            	                    int LA13_2 = input.LA(2);

            	                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0) ) {
            	                        alt13=1;
            	                    }


            	                    }
            	                    break;
            	                case 27:
            	                    {
            	                    int LA13_3 = input.LA(2);

            	                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1) ) {
            	                        alt13=2;
            	                    }


            	                    }
            	                    break;
            	                case 28:
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
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:517:4: ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:517:4: ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:518:5: {...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) )
            	            	    {
            	            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0)");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:518:114: ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:519:6: ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) )
            	            	    {
            	            	     
            	            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0);
            	            	    	 				
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:522:6: ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:522:7: {...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? )
            	            	    {
            	            	    if ( !((true)) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:522:16: (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:522:18: otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )?
            	            	    {
            	            	    otherlv_12=(Token)match(input,25,FOLLOW_25_in_ruleAssuranceTask1189); 

            	            	        	newLeafNode(otherlv_12, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0_0());
            	            	        
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:526:1: (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )?
            	            	    int alt10=2;
            	            	    int LA10_0 = input.LA(1);

            	            	    if ( (LA10_0==26) ) {
            	            	        alt10=1;
            	            	    }
            	            	    switch (alt10) {
            	            	        case 1 :
            	            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:526:3: otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+
            	            	            {
            	            	            otherlv_13=(Token)match(input,26,FOLLOW_26_in_ruleAssuranceTask1202); 

            	            	                	newLeafNode(otherlv_13, grammarAccess.getAssuranceTaskAccess().getRequirementsKeyword_7_1_0_0_1_0());
            	            	                
            	            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:530:1: ( (otherlv_14= RULE_ID ) )+
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
            	            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:531:1: (otherlv_14= RULE_ID )
            	            	            	    {
            	            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:531:1: (otherlv_14= RULE_ID )
            	            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:532:3: otherlv_14= RULE_ID
            	            	            	    {

            	            	            	    			if (current==null) {
            	            	            	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	            	    	        }
            	            	            	            
            	            	            	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1222); 

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
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:550:4: ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:550:4: ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:551:5: {...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) )
            	            	    {
            	            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1)");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:551:114: ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:552:6: ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) )
            	            	    {
            	            	     
            	            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1);
            	            	    	 				
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:555:6: ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:555:7: {...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ )
            	            	    {
            	            	    if ( !((true)) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:555:16: (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:555:18: otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+
            	            	    {
            	            	    otherlv_15=(Token)match(input,27,FOLLOW_27_in_ruleAssuranceTask1293); 

            	            	        	newLeafNode(otherlv_15, grammarAccess.getAssuranceTaskAccess().getVerificationsKeyword_7_1_0_1_0());
            	            	        
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:559:1: ( (otherlv_16= RULE_ID ) )+
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
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:560:1: (otherlv_16= RULE_ID )
            	            	    	    {
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:560:1: (otherlv_16= RULE_ID )
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:561:3: otherlv_16= RULE_ID
            	            	    	    {

            	            	    	    			if (current==null) {
            	            	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	    	    	        }
            	            	    	            
            	            	    	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1313); 

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
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:579:4: ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:579:4: ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:580:5: {...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) )
            	            	    {
            	            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 2) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 2)");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:580:114: ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:581:6: ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) )
            	            	    {
            	            	     
            	            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 2);
            	            	    	 				
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:584:6: ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:584:7: {...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ )
            	            	    {
            	            	    if ( !((true)) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:584:16: (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:584:18: otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+
            	            	    {
            	            	    otherlv_17=(Token)match(input,28,FOLLOW_28_in_ruleAssuranceTask1382); 

            	            	        	newLeafNode(otherlv_17, grammarAccess.getAssuranceTaskAccess().getSelectionsKeyword_7_1_0_2_0());
            	            	        
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:588:1: ( (otherlv_18= RULE_ID ) )+
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
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:589:1: (otherlv_18= RULE_ID )
            	            	    	    {
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:589:1: (otherlv_18= RULE_ID )
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:590:3: otherlv_18= RULE_ID
            	            	    	    {

            	            	    	    			if (current==null) {
            	            	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	    	    	        }
            	            	    	            
            	            	    	    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1402); 

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
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:617:6: (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:617:6: (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:617:8: otherlv_19= 'claims' ( ( ruleQualifiedName ) )+
            	            {
            	            otherlv_19=(Token)match(input,29,FOLLOW_29_in_ruleAssuranceTask1469); 

            	                	newLeafNode(otherlv_19, grammarAccess.getAssuranceTaskAccess().getClaimsKeyword_7_1_1_0());
            	                
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:621:1: ( ( ruleQualifiedName ) )+
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
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:622:1: ( ruleQualifiedName )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:622:1: ( ruleQualifiedName )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:623:3: ruleQualifiedName
            	            	    {

            	            	    			if (current==null) {
            	            	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	    	        }
            	            	            
            	            	     
            	            	    	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getClaimsClaimCrossReference_7_1_1_1_0()); 
            	            	    	    
            	            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssuranceTask1492);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:643:4: ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:643:4: ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:644:5: {...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:644:110: ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:645:6: ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:648:6: ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:648:7: {...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:648:16: (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:648:18: otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+
            	    {
            	    otherlv_21=(Token)match(input,22,FOLLOW_22_in_ruleAssuranceTask1562); 

            	        	newLeafNode(otherlv_21, grammarAccess.getAssuranceTaskAccess().getIssuesKeyword_7_2_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:652:1: ( (lv_issues_22_0= RULE_STRING ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:653:1: (lv_issues_22_0= RULE_STRING )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:653:1: (lv_issues_22_0= RULE_STRING )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:654:3: lv_issues_22_0= RULE_STRING
            	    	    {
            	    	    lv_issues_22_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssuranceTask1579); 

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

            otherlv_23=(Token)match(input,23,FOLLOW_23_in_ruleAssuranceTask1644); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:697:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:698:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:699:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription1680);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription1690); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:706:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:709:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:710:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:710:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING||LA18_0==30) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:711:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:711:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:712:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription1735);
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:736:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:737:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:738:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1771);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement1781); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:745:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_thisTarget_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:748:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:749:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:749:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_STRING) ) {
                alt19=1;
            }
            else if ( (LA19_0==30) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:749:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:749:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:750:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:750:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:751:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement1823); 

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
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:768:6: ( (lv_thisTarget_1_0= 'this' ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:768:6: ( (lv_thisTarget_1_0= 'this' ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:769:1: (lv_thisTarget_1_0= 'this' )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:769:1: (lv_thisTarget_1_0= 'this' )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:770:3: lv_thisTarget_1_0= 'this'
                    {
                    lv_thisTarget_1_0=(Token)match(input,30,FOLLOW_30_in_ruleDescriptionElement1852); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:791:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:792:2: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:793:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1902);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference1913); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:800:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:803:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:804:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:804:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:804:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1953); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:811:1: (kw= '::' this_ID_2= RULE_ID )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:812:2: kw= '::' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,31,FOLLOW_31_in_ruleAadlClassifierReference1972); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1987); 

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

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:824:3: (kw= '.' this_ID_4= RULE_ID )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:825:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleAadlClassifierReference2008); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference2023); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:845:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:846:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:847:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2071);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2082); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:854:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:857:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:858:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:858:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:858:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2122); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:865:1: (kw= '.' this_ID_2= RULE_ID )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:866:2: kw= '.' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleQualifiedName2141); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
                        
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2156); 

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
    public static final BitSet FOLLOW_15_in_ruleAssurancePlan355 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_16_in_ruleAssurancePlan413 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssurancePlan434 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_17_in_ruleAssurancePlan502 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAssurancePlan514 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAssurancePlan526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssurancePlan549 = new BitSet(new long[]{0x0000000000D30010L});
    public static final BitSet FOLLOW_20_in_ruleAssurancePlan618 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleAssurancePlan630 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan653 = new BitSet(new long[]{0x0000000000D30010L});
    public static final BitSet FOLLOW_22_in_ruleAssurancePlan722 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssurancePlan739 = new BitSet(new long[]{0x0000000000D30020L});
    public static final BitSet FOLLOW_23_in_ruleAssurancePlan798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssuranceTask_in_entryRuleAssuranceTask834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssuranceTask844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleAssuranceTask881 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleAssuranceTask893 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask910 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleAssuranceTask928 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssuranceTask945 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAssuranceTask964 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask984 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssuranceTask996 = new BitSet(new long[]{0x000000003A410000L});
    public static final BitSet FOLLOW_16_in_ruleAssuranceTask1054 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssuranceTask1075 = new BitSet(new long[]{0x000000003AC10000L});
    public static final BitSet FOLLOW_25_in_ruleAssuranceTask1189 = new BitSet(new long[]{0x000000003EC10000L});
    public static final BitSet FOLLOW_26_in_ruleAssuranceTask1202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1222 = new BitSet(new long[]{0x000000003AC10010L});
    public static final BitSet FOLLOW_27_in_ruleAssuranceTask1293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1313 = new BitSet(new long[]{0x000000003AC10010L});
    public static final BitSet FOLLOW_28_in_ruleAssuranceTask1382 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1402 = new BitSet(new long[]{0x000000003AC10010L});
    public static final BitSet FOLLOW_29_in_ruleAssuranceTask1469 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssuranceTask1492 = new BitSet(new long[]{0x000000003AC10010L});
    public static final BitSet FOLLOW_22_in_ruleAssuranceTask1562 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssuranceTask1579 = new BitSet(new long[]{0x000000003AC10020L});
    public static final BitSet FOLLOW_23_in_ruleAssuranceTask1644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription1680 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription1735 = new BitSet(new long[]{0x0000000040000022L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDescriptionElement1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1953 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAadlClassifierReference1972 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1987 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_32_in_ruleAadlClassifierReference2008 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2071 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2122 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleQualifiedName2141 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2156 = new BitSet(new long[]{0x0000000000000002L});

}

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'assurance'", "'plan'", "':'", "'for'", "'['", "'description'", "'assure'", "'all'", "'subsystem'", "'plans'", "'assume'", "'subsystems'", "'issues'", "']'", "'task'", "'filter'", "'requirements'", "'verifications'", "'selections'", "'this'", "'::'", "'.'"
    };
    public static final int RULE_STRING=4;
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
    public static final int RULE_ID=5;
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

            	        if ( (LA1_1==12) ) {
            	            alt1=1;
            	        }
            	        else if ( (LA1_1==25) ) {
            	            alt1=2;
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:133:1: ruleAssurancePlan returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_23= ']' ) ;
    public final EObject ruleAssurancePlan() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_title_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token lv_issues_22_0=null;
        Token otherlv_23=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_description_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:136:28: ( (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_23= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:1: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_23= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:1: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_23= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:3: otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_23= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleAssurancePlan237); 

                	newLeafNode(otherlv_0, grammarAccess.getAssurancePlanAccess().getAssuranceKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleAssurancePlan249); 

                	newLeafNode(otherlv_1, grammarAccess.getAssurancePlanAccess().getPlanKeyword_1());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:145:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:146:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:146:1: (lv_name_2_0= ruleQualifiedName )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:147:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssurancePlan270);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssurancePlanRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

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
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleAssurancePlan283); 

                        	newLeafNode(otherlv_3, grammarAccess.getAssurancePlanAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:167:1: ( (lv_title_4_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:168:1: (lv_title_4_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:168:1: (lv_title_4_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:169:3: lv_title_4_0= RULE_STRING
                    {
                    lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssurancePlan300); 

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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleAssurancePlan319); 

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
            	    
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan342);
            ruleAadlClassifierReference();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleAssurancePlan354); 

                	newLeafNode(otherlv_7, grammarAccess.getAssurancePlanAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:208:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )* ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:210:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:210:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:211:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:214:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )* )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:215:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )*
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:215:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )*
            loop8:
            do {
                int alt8=6;
                int LA8_0 = input.LA(1);

                if ( LA8_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0) ) {
                    alt8=1;
                }
                else if ( LA8_0 ==17 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) ) {
                    int LA8_3 = input.LA(2);

                    if ( LA8_3 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) ) {
                        alt8=2;
                    }
                    else if ( LA8_3 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) {
                        alt8=3;
                    }


                }
                else if ( LA8_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) ) {
                    alt8=4;
                }
                else if ( LA8_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4) ) {
                    alt8=5;
                }


                switch (alt8) {
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
            	    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleAssurancePlan412); 

            	        	newLeafNode(otherlv_9, grammarAccess.getAssurancePlanAccess().getDescriptionKeyword_7_0_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:226:1: ( (lv_description_10_0= ruleDescription ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:227:1: (lv_description_10_0= ruleDescription )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:227:1: (lv_description_10_0= ruleDescription )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:228:3: lv_description_10_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getDescriptionDescriptionParserRuleCall_7_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleAssurancePlan433);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:251:4: ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:251:4: ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:252:5: {...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:252:110: ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:253:6: ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:6: ({...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:7: {...}? => (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:16: (otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:18: otherlv_11= 'assure' otherlv_12= 'all' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_11=(Token)match(input,17,FOLLOW_17_in_ruleAssurancePlan501); 

            	        	newLeafNode(otherlv_11, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_1_0());
            	        
            	    otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleAssurancePlan513); 

            	        	newLeafNode(otherlv_12, grammarAccess.getAssurancePlanAccess().getAllKeyword_7_1_1());
            	        
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
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssureAllVerificationPlanCrossReference_7_1_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssurancePlan536);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:286:4: ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:286:4: ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:287:5: {...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:287:110: ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:288:6: ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:6: ({...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:7: {...}? => (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:16: (otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:18: otherlv_14= 'assure' otherlv_15= 'subsystem' otherlv_16= 'plans' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_14=(Token)match(input,17,FOLLOW_17_in_ruleAssurancePlan605); 

            	        	newLeafNode(otherlv_14, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_2_0());
            	        
            	    otherlv_15=(Token)match(input,19,FOLLOW_19_in_ruleAssurancePlan617); 

            	        	newLeafNode(otherlv_15, grammarAccess.getAssurancePlanAccess().getSubsystemKeyword_7_2_1());
            	        
            	    otherlv_16=(Token)match(input,20,FOLLOW_20_in_ruleAssurancePlan629); 

            	        	newLeafNode(otherlv_16, grammarAccess.getAssurancePlanAccess().getPlansKeyword_7_2_2());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:303:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:304:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:304:1: ( ruleQualifiedName )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:305:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssurePlansAssurancePlanCrossReference_7_2_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssurancePlan652);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:325:4: ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:325:4: ({...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:5: {...}? => ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:110: ( ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:327:6: ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:330:6: ({...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:330:7: {...}? => (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:330:16: (otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:330:18: otherlv_18= 'assume' otherlv_19= 'subsystems' ( ( ruleAadlClassifierReference ) )+
            	    {
            	    otherlv_18=(Token)match(input,21,FOLLOW_21_in_ruleAssurancePlan721); 

            	        	newLeafNode(otherlv_18, grammarAccess.getAssurancePlanAccess().getAssumeKeyword_7_3_0());
            	        
            	    otherlv_19=(Token)match(input,22,FOLLOW_22_in_ruleAssurancePlan733); 

            	        	newLeafNode(otherlv_19, grammarAccess.getAssurancePlanAccess().getSubsystemsKeyword_7_3_1());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:338:1: ( ( ruleAadlClassifierReference ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:339:1: ( ruleAadlClassifierReference )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:339:1: ( ruleAadlClassifierReference )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:340:3: ruleAadlClassifierReference
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssumeSubsystemsComponentClassifierCrossReference_7_3_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan756);
            	    	    ruleAadlClassifierReference();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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
            	case 5 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:360:4: ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:360:4: ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:361:5: {...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:361:110: ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:362:6: ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:365:6: ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:365:7: {...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:365:16: (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:365:18: otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+
            	    {
            	    otherlv_21=(Token)match(input,23,FOLLOW_23_in_ruleAssurancePlan825); 

            	        	newLeafNode(otherlv_21, grammarAccess.getAssurancePlanAccess().getIssuesKeyword_7_4_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:369:1: ( (lv_issues_22_0= RULE_STRING ) )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==RULE_STRING) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:370:1: (lv_issues_22_0= RULE_STRING )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:370:1: (lv_issues_22_0= RULE_STRING )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:371:3: lv_issues_22_0= RULE_STRING
            	    	    {
            	    	    lv_issues_22_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssurancePlan842); 

            	    	    			newLeafNode(lv_issues_22_0, grammarAccess.getAssurancePlanAccess().getIssuesSTRINGTerminalRuleCall_7_4_1_0()); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
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
            	    	    if ( cnt7 >= 1 ) break loop7;
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

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	

            }

            otherlv_23=(Token)match(input,24,FOLLOW_24_in_ruleAssurancePlan901); 

                	newLeafNode(otherlv_23, grammarAccess.getAssurancePlanAccess().getRightSquareBracketKeyword_8());
                

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:413:1: entryRuleAssuranceTask returns [EObject current=null] : iv_ruleAssuranceTask= ruleAssuranceTask EOF ;
    public final EObject entryRuleAssuranceTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssuranceTask = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:414:2: (iv_ruleAssuranceTask= ruleAssuranceTask EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:415:2: iv_ruleAssuranceTask= ruleAssuranceTask EOF
            {
             newCompositeNode(grammarAccess.getAssuranceTaskRule()); 
            pushFollow(FOLLOW_ruleAssuranceTask_in_entryRuleAssuranceTask937);
            iv_ruleAssuranceTask=ruleAssuranceTask();

            state._fsp--;

             current =iv_ruleAssuranceTask; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssuranceTask947); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:422:1: ruleAssuranceTask returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleQualifiedName ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_21= ']' ) ;
    public final EObject ruleAssuranceTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_title_4_0=null;
        Token otherlv_5=null;
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
        Token lv_issues_20_0=null;
        Token otherlv_21=null;
        EObject lv_description_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:425:28: ( (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleQualifiedName ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_21= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:426:1: (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleQualifiedName ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_21= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:426:1: (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleQualifiedName ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_21= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:426:3: otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleQualifiedName ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_21= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleAssuranceTask984); 

                	newLeafNode(otherlv_0, grammarAccess.getAssuranceTaskAccess().getAssuranceKeyword_0());
                
            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleAssuranceTask996); 

                	newLeafNode(otherlv_1, grammarAccess.getAssuranceTaskAccess().getTaskKeyword_1());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:434:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:435:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:435:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:436:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1013); 

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

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:452:2: (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==13) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:452:4: otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleAssuranceTask1031); 

                        	newLeafNode(otherlv_3, grammarAccess.getAssuranceTaskAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:456:1: ( (lv_title_4_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:457:1: (lv_title_4_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:457:1: (lv_title_4_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:458:3: lv_title_4_0= RULE_STRING
                    {
                    lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssuranceTask1048); 

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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleAssuranceTask1067); 

                	newLeafNode(otherlv_5, grammarAccess.getAssuranceTaskAccess().getForKeyword_4());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:478:1: ( ( ruleQualifiedName ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:479:1: ( ruleQualifiedName )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:479:1: ( ruleQualifiedName )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:480:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getAssurancePlanAssurancePlanCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssuranceTask1090);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleAssuranceTask1102); 

                	newLeafNode(otherlv_7, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:497:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:499:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:499:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:500:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:503:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:504:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:504:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=4;
                int LA16_0 = input.LA(1);

                if ( LA16_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0) ) {
                    alt16=1;
                }
                else if ( (LA16_0==26|| LA16_0 >=28 && LA16_0<=29) && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1) ) {
                    alt16=2;
                }
                else if ( LA16_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2) ) {
                    alt16=3;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:506:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:506:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:507:5: {...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:507:110: ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:508:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:511:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:511:7: {...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:511:16: (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:511:18: otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) )
            	    {
            	    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleAssuranceTask1160); 

            	        	newLeafNode(otherlv_9, grammarAccess.getAssuranceTaskAccess().getDescriptionKeyword_7_0_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:515:1: ( (lv_description_10_0= ruleDescription ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:516:1: (lv_description_10_0= ruleDescription )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:516:1: (lv_description_10_0= ruleDescription )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:517:3: lv_description_10_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getDescriptionDescriptionParserRuleCall_7_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleAssuranceTask1181);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:540:4: ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:540:4: ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:541:5: {...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:541:110: ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:542:6: ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:545:6: ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:545:7: {...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:545:16: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:547:1: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:547:1: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:548:2: ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?)
            	    {
            	     
            	    	  getUnorderedGroupHelper().enter(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1());
            	    	
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:551:2: ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?)
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:552:3: ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:552:3: ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+
            	    int cnt14=0;
            	    loop14:
            	    do {
            	        int alt14=4;
            	        switch ( input.LA(1) ) {
            	        case 26:
            	            {
            	            int LA14_2 = input.LA(2);

            	            if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 0) ) {
            	                alt14=1;
            	            }


            	            }
            	            break;
            	        case 28:
            	            {
            	            int LA14_3 = input.LA(2);

            	            if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 1) ) {
            	                alt14=2;
            	            }


            	            }
            	            break;
            	        case 29:
            	            {
            	            int LA14_4 = input.LA(2);

            	            if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 2) ) {
            	                alt14=3;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt14) {
            	    	case 1 :
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:554:4: ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:554:4: ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:555:5: {...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 0) ) {
            	    	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 0)");
            	    	    }
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:555:112: ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:556:6: ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 0);
            	    	    	 				
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:559:6: ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:559:7: {...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    	    }
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:559:16: (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:559:18: otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )?
            	    	    {
            	    	    otherlv_12=(Token)match(input,26,FOLLOW_26_in_ruleAssuranceTask1294); 

            	    	        	newLeafNode(otherlv_12, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0());
            	    	        
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:563:1: (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )?
            	    	    int alt11=2;
            	    	    int LA11_0 = input.LA(1);

            	    	    if ( (LA11_0==27) ) {
            	    	        alt11=1;
            	    	    }
            	    	    switch (alt11) {
            	    	        case 1 :
            	    	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:563:3: otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+
            	    	            {
            	    	            otherlv_13=(Token)match(input,27,FOLLOW_27_in_ruleAssuranceTask1307); 

            	    	                	newLeafNode(otherlv_13, grammarAccess.getAssuranceTaskAccess().getRequirementsKeyword_7_1_0_1_0());
            	    	                
            	    	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:567:1: ( (otherlv_14= RULE_ID ) )+
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
            	    	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:568:1: (otherlv_14= RULE_ID )
            	    	            	    {
            	    	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:568:1: (otherlv_14= RULE_ID )
            	    	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:569:3: otherlv_14= RULE_ID
            	    	            	    {

            	    	            	    			if (current==null) {
            	    	            	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	    	            	    	        }
            	    	            	            
            	    	            	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1327); 

            	    	            	    		newLeafNode(otherlv_14, grammarAccess.getAssuranceTaskAccess().getRequirementFilterRequirementCategoryCrossReference_7_1_0_1_1_0()); 
            	    	            	    	

            	    	            	    }


            	    	            	    }
            	    	            	    break;

            	    	            	default :
            	    	            	    if ( cnt10 >= 1 ) break loop10;
            	    	                        EarlyExitException eee =
            	    	                            new EarlyExitException(10, input);
            	    	                        throw eee;
            	    	                }
            	    	                cnt10++;
            	    	            } while (true);


            	    	            }
            	    	            break;

            	    	    }


            	    	    }


            	    	    }

            	    	     
            	    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1());
            	    	    	 				

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:587:4: ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:587:4: ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:588:5: {...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 1) ) {
            	    	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 1)");
            	    	    }
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:588:112: ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:589:6: ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 1);
            	    	    	 				
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:592:6: ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:592:7: {...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    	    }
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:592:16: (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:592:18: otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+
            	    	    {
            	    	    otherlv_15=(Token)match(input,28,FOLLOW_28_in_ruleAssuranceTask1398); 

            	    	        	newLeafNode(otherlv_15, grammarAccess.getAssuranceTaskAccess().getVerificationsKeyword_7_1_1_0());
            	    	        
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:596:1: ( (otherlv_16= RULE_ID ) )+
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
            	    	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:597:1: (otherlv_16= RULE_ID )
            	    	    	    {
            	    	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:597:1: (otherlv_16= RULE_ID )
            	    	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:598:3: otherlv_16= RULE_ID
            	    	    	    {

            	    	    	    			if (current==null) {
            	    	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	    	    	    	        }
            	    	    	            
            	    	    	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1418); 

            	    	    	    		newLeafNode(otherlv_16, grammarAccess.getAssuranceTaskAccess().getVerificationFilterVerificationCategoryCrossReference_7_1_1_1_0()); 
            	    	    	    	

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

            	    	     
            	    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1());
            	    	    	 				

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:616:4: ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:616:4: ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:617:5: {...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 2) ) {
            	    	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 2)");
            	    	    }
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:617:112: ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:618:6: ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) )
            	    	    {
            	    	     
            	    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1(), 2);
            	    	    	 				
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:621:6: ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:621:7: {...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    	    }
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:621:16: (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:621:18: otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+
            	    	    {
            	    	    otherlv_17=(Token)match(input,29,FOLLOW_29_in_ruleAssuranceTask1487); 

            	    	        	newLeafNode(otherlv_17, grammarAccess.getAssuranceTaskAccess().getSelectionsKeyword_7_1_2_0());
            	    	        
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:625:1: ( (otherlv_18= RULE_ID ) )+
            	    	    int cnt13=0;
            	    	    loop13:
            	    	    do {
            	    	        int alt13=2;
            	    	        int LA13_0 = input.LA(1);

            	    	        if ( (LA13_0==RULE_ID) ) {
            	    	            alt13=1;
            	    	        }


            	    	        switch (alt13) {
            	    	    	case 1 :
            	    	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:626:1: (otherlv_18= RULE_ID )
            	    	    	    {
            	    	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:626:1: (otherlv_18= RULE_ID )
            	    	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:627:3: otherlv_18= RULE_ID
            	    	    	    {

            	    	    	    			if (current==null) {
            	    	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	    	    	    	        }
            	    	    	            
            	    	    	    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1507); 

            	    	    	    		newLeafNode(otherlv_18, grammarAccess.getAssuranceTaskAccess().getSelectionFilterSelectionCategoryCrossReference_7_1_2_1_0()); 
            	    	    	    	

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


            	    	    }


            	    	    }

            	    	     
            	    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1());
            	    	    	 				

            	    	    }


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

            	    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1()) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canLeave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1())");
            	    }

            	    }


            	    }

            	     
            	    	  getUnorderedGroupHelper().leave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1());
            	    	

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:660:4: ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:660:4: ({...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:661:5: {...}? => ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:661:110: ( ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:662:6: ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:665:6: ({...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:665:7: {...}? => (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:665:16: (otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:665:18: otherlv_19= 'issues' ( (lv_issues_20_0= RULE_STRING ) )+
            	    {
            	    otherlv_19=(Token)match(input,23,FOLLOW_23_in_ruleAssuranceTask1622); 

            	        	newLeafNode(otherlv_19, grammarAccess.getAssuranceTaskAccess().getIssuesKeyword_7_2_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:669:1: ( (lv_issues_20_0= RULE_STRING ) )+
            	    int cnt15=0;
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==RULE_STRING) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:670:1: (lv_issues_20_0= RULE_STRING )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:670:1: (lv_issues_20_0= RULE_STRING )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:671:3: lv_issues_20_0= RULE_STRING
            	    	    {
            	    	    lv_issues_20_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssuranceTask1639); 

            	    	    			newLeafNode(lv_issues_20_0, grammarAccess.getAssuranceTaskAccess().getIssuesSTRINGTerminalRuleCall_7_2_1_0()); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	    	    	        }
            	    	           		addWithLastConsumed(
            	    	           			current, 
            	    	           			"issues",
            	    	            		lv_issues_20_0, 
            	    	            		"STRING");
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt15 >= 1 ) break loop15;
            	                EarlyExitException eee =
            	                    new EarlyExitException(15, input);
            	                throw eee;
            	        }
            	        cnt15++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	    	 				

            	    }


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

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7()) ) {
                throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canLeave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	

            }

            otherlv_21=(Token)match(input,24,FOLLOW_24_in_ruleAssuranceTask1704); 

                	newLeafNode(otherlv_21, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8());
                

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:714:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:715:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:716:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription1740);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription1750); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:723:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:726:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:727:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:727:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_STRING||LA17_0==30) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:728:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:728:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:729:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription1795);
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
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:753:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:754:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:755:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1831);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement1841); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:762:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_thisTarget_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:765:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:766:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:766:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_STRING) ) {
                alt18=1;
            }
            else if ( (LA18_0==30) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:766:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:766:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:767:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:767:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:768:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement1883); 

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
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:785:6: ( (lv_thisTarget_1_0= 'this' ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:785:6: ( (lv_thisTarget_1_0= 'this' ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:786:1: (lv_thisTarget_1_0= 'this' )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:786:1: (lv_thisTarget_1_0= 'this' )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:787:3: lv_thisTarget_1_0= 'this'
                    {
                    lv_thisTarget_1_0=(Token)match(input,30,FOLLOW_30_in_ruleDescriptionElement1912); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:808:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:809:2: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:810:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1962);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference1973); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:817:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:820:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:821:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:821:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:821:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference2013); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:828:1: (kw= '::' this_ID_2= RULE_ID )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==31) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:829:2: kw= '::' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,31,FOLLOW_31_in_ruleAadlClassifierReference2032); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference2047); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:841:3: (kw= '.' this_ID_4= RULE_ID )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:842:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleAadlClassifierReference2068); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference2083); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:862:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:863:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:864:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2131);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2142); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:871:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:874:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:875:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:875:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:875:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2182); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:882:1: (kw= '.' this_ID_2= RULE_ID )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:883:2: kw= '.' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleQualifiedName2201); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
                        
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2216); 

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
    public static final BitSet FOLLOW_12_in_ruleAssurancePlan249 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssurancePlan270 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleAssurancePlan283 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssurancePlan300 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAssurancePlan319 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan342 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssurancePlan354 = new BitSet(new long[]{0x0000000001A30000L});
    public static final BitSet FOLLOW_16_in_ruleAssurancePlan412 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssurancePlan433 = new BitSet(new long[]{0x0000000001A30000L});
    public static final BitSet FOLLOW_17_in_ruleAssurancePlan501 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAssurancePlan513 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssurancePlan536 = new BitSet(new long[]{0x0000000001A30020L});
    public static final BitSet FOLLOW_17_in_ruleAssurancePlan605 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAssurancePlan617 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAssurancePlan629 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssurancePlan652 = new BitSet(new long[]{0x0000000001A30020L});
    public static final BitSet FOLLOW_21_in_ruleAssurancePlan721 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleAssurancePlan733 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan756 = new BitSet(new long[]{0x0000000001A30020L});
    public static final BitSet FOLLOW_23_in_ruleAssurancePlan825 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssurancePlan842 = new BitSet(new long[]{0x0000000001A30010L});
    public static final BitSet FOLLOW_24_in_ruleAssurancePlan901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssuranceTask_in_entryRuleAssuranceTask937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssuranceTask947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleAssuranceTask984 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleAssuranceTask996 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1013 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleAssuranceTask1031 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssuranceTask1048 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAssuranceTask1067 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssuranceTask1090 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssuranceTask1102 = new BitSet(new long[]{0x0000000034810000L});
    public static final BitSet FOLLOW_16_in_ruleAssuranceTask1160 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssuranceTask1181 = new BitSet(new long[]{0x0000000035810000L});
    public static final BitSet FOLLOW_26_in_ruleAssuranceTask1294 = new BitSet(new long[]{0x000000003D810000L});
    public static final BitSet FOLLOW_27_in_ruleAssuranceTask1307 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1327 = new BitSet(new long[]{0x0000000035810020L});
    public static final BitSet FOLLOW_28_in_ruleAssuranceTask1398 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1418 = new BitSet(new long[]{0x0000000035810020L});
    public static final BitSet FOLLOW_29_in_ruleAssuranceTask1487 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1507 = new BitSet(new long[]{0x0000000035810020L});
    public static final BitSet FOLLOW_23_in_ruleAssuranceTask1622 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssuranceTask1639 = new BitSet(new long[]{0x0000000035810010L});
    public static final BitSet FOLLOW_24_in_ruleAssuranceTask1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription1740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription1795 = new BitSet(new long[]{0x0000000040000012L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDescriptionElement1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference2013 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAadlClassifierReference2032 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference2047 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_32_in_ruleAadlClassifierReference2068 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2182 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleQualifiedName2201 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2216 = new BitSet(new long[]{0x0000000000000002L});

}

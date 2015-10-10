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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'assurance'", "'plan'", "':'", "'for'", "'['", "'description'", "'assure'", "'own'", "'global'", "'subsystem'", "'plans'", "'assume'", "'subsystems'", "'all'", "'issues'", "']'", "'task'", "'filter'", "'only'", "'this'", "'::'", "'.'"
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

            	        if ( (LA1_1==27) ) {
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:133:1: ruleAssurancePlan returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_27= ']' ) ;
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
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_assumeAll_24_0=null;
        Token otherlv_25=null;
        Token lv_issues_26_0=null;
        Token otherlv_27=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_description_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:136:28: ( (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_27= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:1: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_27= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:1: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_27= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:3: otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= ruleQualifiedName ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_27= ']'
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
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:208:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )* ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:210:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:210:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:211:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:214:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )* )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:215:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )*
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:215:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) ) )*
            loop10:
            do {
                int alt10=7;
                int LA10_0 = input.LA(1);

                if ( LA10_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0) ) {
                    alt10=1;
                }
                else if ( LA10_0 ==17 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) || getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) || getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) ) {
                    int LA10_3 = input.LA(2);

                    if ( LA10_3 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) ) {
                        alt10=2;
                    }
                    else if ( LA10_3 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) {
                        alt10=3;
                    }
                    else if ( LA10_3 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) ) {
                        alt10=4;
                    }


                }
                else if ( LA10_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4) ) {
                    alt10=5;
                }
                else if ( LA10_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 5) ) {
                    alt10=6;
                }


                switch (alt10) {
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:251:4: ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:251:4: ({...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:252:5: {...}? => ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:252:110: ( ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:253:6: ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:6: ({...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:7: {...}? => (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:16: (otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:18: otherlv_11= 'assure' otherlv_12= 'own' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_11=(Token)match(input,17,FOLLOW_17_in_ruleAssurancePlan501); 

            	        	newLeafNode(otherlv_11, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_1_0());
            	        
            	    otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleAssurancePlan513); 

            	        	newLeafNode(otherlv_12, grammarAccess.getAssurancePlanAccess().getOwnKeyword_7_1_1());
            	        
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
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssureOwnVerificationPlanCrossReference_7_1_2_0()); 
            	    	    	    
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:286:4: ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:286:4: ({...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:287:5: {...}? => ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:287:110: ( ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:288:6: ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:6: ({...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:7: {...}? => (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:16: (otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:291:18: otherlv_14= 'assure' otherlv_15= 'global' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_14=(Token)match(input,17,FOLLOW_17_in_ruleAssurancePlan605); 

            	        	newLeafNode(otherlv_14, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_2_0());
            	        
            	    otherlv_15=(Token)match(input,19,FOLLOW_19_in_ruleAssurancePlan617); 

            	        	newLeafNode(otherlv_15, grammarAccess.getAssurancePlanAccess().getGlobalKeyword_7_2_1());
            	        
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
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssureGlobalVerificationPlanCrossReference_7_2_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssurancePlan640);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:321:4: ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:321:4: ({...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:322:5: {...}? => ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:322:110: ( ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:323:6: ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:6: ({...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:7: {...}? => (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:16: (otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:326:18: otherlv_17= 'assure' otherlv_18= 'subsystem' otherlv_19= 'plans' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_17=(Token)match(input,17,FOLLOW_17_in_ruleAssurancePlan709); 

            	        	newLeafNode(otherlv_17, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_3_0());
            	        
            	    otherlv_18=(Token)match(input,20,FOLLOW_20_in_ruleAssurancePlan721); 

            	        	newLeafNode(otherlv_18, grammarAccess.getAssurancePlanAccess().getSubsystemKeyword_7_3_1());
            	        
            	    otherlv_19=(Token)match(input,21,FOLLOW_21_in_ruleAssurancePlan733); 

            	        	newLeafNode(otherlv_19, grammarAccess.getAssurancePlanAccess().getPlansKeyword_7_3_2());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:338:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:339:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:339:1: ( ruleQualifiedName )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:340:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssureSubsystemPlansAssurancePlanCrossReference_7_3_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssurancePlan756);
            	    	    ruleQualifiedName();

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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:360:4: ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:360:4: ({...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:361:5: {...}? => ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:361:110: ( ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:362:6: ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 4);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:365:6: ({...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:365:7: {...}? => (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:365:16: (otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:365:18: otherlv_21= 'assume' otherlv_22= 'subsystems' ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) )
            	    {
            	    otherlv_21=(Token)match(input,22,FOLLOW_22_in_ruleAssurancePlan825); 

            	        	newLeafNode(otherlv_21, grammarAccess.getAssurancePlanAccess().getAssumeKeyword_7_4_0());
            	        
            	    otherlv_22=(Token)match(input,23,FOLLOW_23_in_ruleAssurancePlan837); 

            	        	newLeafNode(otherlv_22, grammarAccess.getAssurancePlanAccess().getSubsystemsKeyword_7_4_1());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:373:1: ( ( ( ruleAadlClassifierReference ) )+ | ( (lv_assumeAll_24_0= 'all' ) ) )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==RULE_ID) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==24) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:373:2: ( ( ruleAadlClassifierReference ) )+
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:373:2: ( ( ruleAadlClassifierReference ) )+
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
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:374:1: ( ruleAadlClassifierReference )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:374:1: ( ruleAadlClassifierReference )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:375:3: ruleAadlClassifierReference
            	            	    {

            	            	    			if (current==null) {
            	            	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	            	    	        }
            	            	            
            	            	     
            	            	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getAssumeSubsystemsComponentClassifierCrossReference_7_4_2_0_0()); 
            	            	    	    
            	            	    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan861);
            	            	    ruleAadlClassifierReference();

            	            	    state._fsp--;

            	            	     
            	            	    	        afterParserOrEnumRuleCall();
            	            	    	    

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
            	            break;
            	        case 2 :
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:389:6: ( (lv_assumeAll_24_0= 'all' ) )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:389:6: ( (lv_assumeAll_24_0= 'all' ) )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:390:1: (lv_assumeAll_24_0= 'all' )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:390:1: (lv_assumeAll_24_0= 'all' )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:391:3: lv_assumeAll_24_0= 'all'
            	            {
            	            lv_assumeAll_24_0=(Token)match(input,24,FOLLOW_24_in_ruleAssurancePlan886); 

            	                    newLeafNode(lv_assumeAll_24_0, grammarAccess.getAssurancePlanAccess().getAssumeAllAllKeyword_7_4_2_1_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	            	        }
            	                   		setWithLastConsumed(current, "assumeAll", true, "all");
            	            	    

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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:411:4: ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:411:4: ({...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:412:5: {...}? => ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 5)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:412:110: ( ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:413:6: ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 5);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:416:6: ({...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:416:7: {...}? => (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:416:16: (otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:416:18: otherlv_25= 'issues' ( (lv_issues_26_0= RULE_STRING ) )+
            	    {
            	    otherlv_25=(Token)match(input,25,FOLLOW_25_in_ruleAssurancePlan968); 

            	        	newLeafNode(otherlv_25, grammarAccess.getAssurancePlanAccess().getIssuesKeyword_7_5_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:420:1: ( (lv_issues_26_0= RULE_STRING ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==RULE_STRING) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:421:1: (lv_issues_26_0= RULE_STRING )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:421:1: (lv_issues_26_0= RULE_STRING )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:422:3: lv_issues_26_0= RULE_STRING
            	    	    {
            	    	    lv_issues_26_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssurancePlan985); 

            	    	    			newLeafNode(lv_issues_26_0, grammarAccess.getAssurancePlanAccess().getIssuesSTRINGTerminalRuleCall_7_5_1_0()); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	           		addWithLastConsumed(
            	    	           			current, 
            	    	           			"issues",
            	    	            		lv_issues_26_0, 
            	    	            		"STRING");
            	    	    	    

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


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	

            }

            otherlv_27=(Token)match(input,26,FOLLOW_26_in_ruleAssurancePlan1044); 

                	newLeafNode(otherlv_27, grammarAccess.getAssurancePlanAccess().getRightSquareBracketKeyword_8());
                

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:464:1: entryRuleAssuranceTask returns [EObject current=null] : iv_ruleAssuranceTask= ruleAssuranceTask EOF ;
    public final EObject entryRuleAssuranceTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssuranceTask = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:465:2: (iv_ruleAssuranceTask= ruleAssuranceTask EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:466:2: iv_ruleAssuranceTask= ruleAssuranceTask EOF
            {
             newCompositeNode(grammarAccess.getAssuranceTaskRule()); 
            pushFollow(FOLLOW_ruleAssuranceTask_in_entryRuleAssuranceTask1080);
            iv_ruleAssuranceTask=ruleAssuranceTask();

            state._fsp--;

             current =iv_ruleAssuranceTask; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssuranceTask1090); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:473:1: ruleAssuranceTask returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleQualifiedName ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_16= ']' ) ;
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
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token lv_strictFilter_13_0=null;
        Token otherlv_14=null;
        Token lv_issues_15_0=null;
        Token otherlv_16=null;
        EObject lv_description_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:476:28: ( (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleQualifiedName ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_16= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:477:1: (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleQualifiedName ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_16= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:477:1: (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleQualifiedName ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_16= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:477:3: otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleQualifiedName ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )* ) ) ) otherlv_16= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleAssuranceTask1127); 

                	newLeafNode(otherlv_0, grammarAccess.getAssuranceTaskAccess().getAssuranceKeyword_0());
                
            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleAssuranceTask1139); 

                	newLeafNode(otherlv_1, grammarAccess.getAssuranceTaskAccess().getTaskKeyword_1());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:485:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:486:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:486:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:487:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1156); 

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

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:503:2: (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==13) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:503:4: otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleAssuranceTask1174); 

                        	newLeafNode(otherlv_3, grammarAccess.getAssuranceTaskAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:507:1: ( (lv_title_4_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:508:1: (lv_title_4_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:508:1: (lv_title_4_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:509:3: lv_title_4_0= RULE_STRING
                    {
                    lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssuranceTask1191); 

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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleAssuranceTask1210); 

                	newLeafNode(otherlv_5, grammarAccess.getAssuranceTaskAccess().getForKeyword_4());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:529:1: ( ( ruleQualifiedName ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:530:1: ( ruleQualifiedName )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:530:1: ( ruleQualifiedName )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:531:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getAssurancePlanAssurancePlanCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssuranceTask1233);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleAssuranceTask1245); 

                	newLeafNode(otherlv_7, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:548:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )* ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:550:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:550:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )* ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:551:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:554:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )* )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:555:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )*
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:555:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) ) )*
            loop15:
            do {
                int alt15=4;
                int LA15_0 = input.LA(1);

                if ( LA15_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0) ) {
                    alt15=1;
                }
                else if ( LA15_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1) ) {
                    alt15=2;
                }
                else if ( LA15_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2) ) {
                    alt15=3;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:557:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:557:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:558:5: {...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:558:110: ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:559:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:562:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:562:7: {...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:562:16: (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:562:18: otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) )
            	    {
            	    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleAssuranceTask1303); 

            	        	newLeafNode(otherlv_9, grammarAccess.getAssuranceTaskAccess().getDescriptionKeyword_7_0_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:566:1: ( (lv_description_10_0= ruleDescription ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:567:1: (lv_description_10_0= ruleDescription )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:567:1: (lv_description_10_0= ruleDescription )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:568:3: lv_description_10_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getDescriptionDescriptionParserRuleCall_7_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleAssuranceTask1324);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:591:4: ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:591:4: ({...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:592:5: {...}? => ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:592:110: ( ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:593:6: ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:596:6: ({...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:596:7: {...}? => (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:596:16: (otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )? )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:596:18: otherlv_11= 'filter' ( (otherlv_12= RULE_ID ) )+ ( (lv_strictFilter_13_0= 'only' ) )?
            	    {
            	    otherlv_11=(Token)match(input,28,FOLLOW_28_in_ruleAssuranceTask1392); 

            	        	newLeafNode(otherlv_11, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:600:1: ( (otherlv_12= RULE_ID ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:601:1: (otherlv_12= RULE_ID )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:601:1: (otherlv_12= RULE_ID )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:602:3: otherlv_12= RULE_ID
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	    	    	        }
            	    	            
            	    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1412); 

            	    	    		newLeafNode(otherlv_12, grammarAccess.getAssuranceTaskAccess().getFilterCategoryCrossReference_7_1_1_0()); 
            	    	    	

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

            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:613:3: ( (lv_strictFilter_13_0= 'only' ) )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==29) ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:614:1: (lv_strictFilter_13_0= 'only' )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:614:1: (lv_strictFilter_13_0= 'only' )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:615:3: lv_strictFilter_13_0= 'only'
            	            {
            	            lv_strictFilter_13_0=(Token)match(input,29,FOLLOW_29_in_ruleAssuranceTask1431); 

            	                    newLeafNode(lv_strictFilter_13_0, grammarAccess.getAssuranceTaskAccess().getStrictFilterOnlyKeyword_7_1_2_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	        }
            	                   		setWithLastConsumed(current, "strictFilter", true, "only");
            	            	    

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:635:4: ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:635:4: ({...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:636:5: {...}? => ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:636:110: ( ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:637:6: ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:640:6: ({...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:640:7: {...}? => (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:640:16: (otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:640:18: otherlv_14= 'issues' ( (lv_issues_15_0= RULE_STRING ) )+
            	    {
            	    otherlv_14=(Token)match(input,25,FOLLOW_25_in_ruleAssuranceTask1513); 

            	        	newLeafNode(otherlv_14, grammarAccess.getAssuranceTaskAccess().getIssuesKeyword_7_2_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:644:1: ( (lv_issues_15_0= RULE_STRING ) )+
            	    int cnt14=0;
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==RULE_STRING) ) {
            	            alt14=1;
            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:645:1: (lv_issues_15_0= RULE_STRING )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:645:1: (lv_issues_15_0= RULE_STRING )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:646:3: lv_issues_15_0= RULE_STRING
            	    	    {
            	    	    lv_issues_15_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssuranceTask1530); 

            	    	    			newLeafNode(lv_issues_15_0, grammarAccess.getAssuranceTaskAccess().getIssuesSTRINGTerminalRuleCall_7_2_1_0()); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	    	    	        }
            	    	           		addWithLastConsumed(
            	    	           			current, 
            	    	           			"issues",
            	    	            		lv_issues_15_0, 
            	    	            		"STRING");
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	

            }

            otherlv_16=(Token)match(input,26,FOLLOW_26_in_ruleAssuranceTask1589); 

                	newLeafNode(otherlv_16, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8());
                

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:688:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:689:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:690:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription1625);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription1635); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:697:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:700:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:701:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:701:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_STRING||LA16_0==30) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:702:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:702:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:703:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription1680);
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:727:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:728:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:729:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1716);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement1726); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:736:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_thisTarget_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:739:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:740:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:740:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_STRING) ) {
                alt17=1;
            }
            else if ( (LA17_0==30) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:740:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:740:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:741:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:741:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:742:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement1768); 

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
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:759:6: ( (lv_thisTarget_1_0= 'this' ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:759:6: ( (lv_thisTarget_1_0= 'this' ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:760:1: (lv_thisTarget_1_0= 'this' )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:760:1: (lv_thisTarget_1_0= 'this' )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:761:3: lv_thisTarget_1_0= 'this'
                    {
                    lv_thisTarget_1_0=(Token)match(input,30,FOLLOW_30_in_ruleDescriptionElement1797); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:782:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:783:2: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:784:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1847);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference1858); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:791:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:794:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:795:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:795:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:795:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ (kw= '.' this_ID_4= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1898); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:802:1: (kw= '::' this_ID_2= RULE_ID )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==31) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:803:2: kw= '::' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,31,FOLLOW_31_in_ruleAadlClassifierReference1917); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1932); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1_1()); 
            	        

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

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:815:3: (kw= '.' this_ID_4= RULE_ID )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==32) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:816:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleAadlClassifierReference1953); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1968); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:836:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:837:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:838:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2016);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2027); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:845:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:848:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:849:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:849:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:849:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2067); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:856:1: (kw= '.' this_ID_2= RULE_ID )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:857:2: kw= '.' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleQualifiedName2086); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
                        
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2101); 

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
    public static final BitSet FOLLOW_15_in_ruleAssurancePlan354 = new BitSet(new long[]{0x0000000006430000L});
    public static final BitSet FOLLOW_16_in_ruleAssurancePlan412 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssurancePlan433 = new BitSet(new long[]{0x0000000006430000L});
    public static final BitSet FOLLOW_17_in_ruleAssurancePlan501 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAssurancePlan513 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssurancePlan536 = new BitSet(new long[]{0x0000000006430020L});
    public static final BitSet FOLLOW_17_in_ruleAssurancePlan605 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAssurancePlan617 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssurancePlan640 = new BitSet(new long[]{0x0000000006430020L});
    public static final BitSet FOLLOW_17_in_ruleAssurancePlan709 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAssurancePlan721 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleAssurancePlan733 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssurancePlan756 = new BitSet(new long[]{0x0000000006430020L});
    public static final BitSet FOLLOW_22_in_ruleAssurancePlan825 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleAssurancePlan837 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan861 = new BitSet(new long[]{0x0000000006430020L});
    public static final BitSet FOLLOW_24_in_ruleAssurancePlan886 = new BitSet(new long[]{0x0000000006430000L});
    public static final BitSet FOLLOW_25_in_ruleAssurancePlan968 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssurancePlan985 = new BitSet(new long[]{0x0000000006430010L});
    public static final BitSet FOLLOW_26_in_ruleAssurancePlan1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssuranceTask_in_entryRuleAssuranceTask1080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssuranceTask1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleAssuranceTask1127 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleAssuranceTask1139 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1156 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleAssuranceTask1174 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssuranceTask1191 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAssuranceTask1210 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssuranceTask1233 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssuranceTask1245 = new BitSet(new long[]{0x0000000016010000L});
    public static final BitSet FOLLOW_16_in_ruleAssuranceTask1303 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssuranceTask1324 = new BitSet(new long[]{0x0000000016010000L});
    public static final BitSet FOLLOW_28_in_ruleAssuranceTask1392 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1412 = new BitSet(new long[]{0x0000000036010020L});
    public static final BitSet FOLLOW_29_in_ruleAssuranceTask1431 = new BitSet(new long[]{0x0000000016010000L});
    public static final BitSet FOLLOW_25_in_ruleAssuranceTask1513 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssuranceTask1530 = new BitSet(new long[]{0x0000000016010010L});
    public static final BitSet FOLLOW_26_in_ruleAssuranceTask1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription1625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription1680 = new BitSet(new long[]{0x0000000040000012L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1716 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDescriptionElement1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1898 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAadlClassifierReference1917 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1932 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_32_in_ruleAadlClassifierReference1953 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2016 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2067 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleQualifiedName2086 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2101 = new BitSet(new long[]{0x0000000000000002L});

}

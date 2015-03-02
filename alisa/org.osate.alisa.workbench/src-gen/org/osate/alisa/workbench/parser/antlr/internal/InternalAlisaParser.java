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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'alisa'", "'assurance'", "'plan'", "':'", "'for'", "'['", "'description'", "'assert'", "'assume'", "'issues'", "']'", "'task'", "'of'", "'filter'", "'requirements'", "'verifications'", "'selections'", "'claims'", "'this'", "'::'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:76:1: ruleAlisaWorkArea returns [EObject current=null] : (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_cases_2_1= ruleAssurancePlan | lv_cases_2_2= ruleAssuranceTask ) ) )* ) ;
    public final EObject ruleAlisaWorkArea() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_cases_2_1 = null;

        EObject lv_cases_2_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:79:28: ( (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_cases_2_1= ruleAssurancePlan | lv_cases_2_2= ruleAssuranceTask ) ) )* ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:80:1: (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_cases_2_1= ruleAssurancePlan | lv_cases_2_2= ruleAssuranceTask ) ) )* )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:80:1: (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_cases_2_1= ruleAssurancePlan | lv_cases_2_2= ruleAssuranceTask ) ) )* )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:80:3: otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_cases_2_1= ruleAssurancePlan | lv_cases_2_2= ruleAssuranceTask ) ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleAlisaWorkArea122); 

                	newLeafNode(otherlv_0, grammarAccess.getAlisaWorkAreaAccess().getAlisaKeyword_0());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:85:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAlisaWorkArea139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAlisaWorkAreaAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAlisaWorkAreaRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:102:2: ( ( (lv_cases_2_1= ruleAssurancePlan | lv_cases_2_2= ruleAssuranceTask ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:103:1: ( (lv_cases_2_1= ruleAssurancePlan | lv_cases_2_2= ruleAssuranceTask ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:103:1: ( (lv_cases_2_1= ruleAssurancePlan | lv_cases_2_2= ruleAssuranceTask ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:104:1: (lv_cases_2_1= ruleAssurancePlan | lv_cases_2_2= ruleAssuranceTask )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:104:1: (lv_cases_2_1= ruleAssurancePlan | lv_cases_2_2= ruleAssuranceTask )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==12) ) {
            	        int LA1_1 = input.LA(2);

            	        if ( (LA1_1==13) ) {
            	            alt1=1;
            	        }
            	        else if ( (LA1_1==22) ) {
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
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:105:3: lv_cases_2_1= ruleAssurancePlan
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getAlisaWorkAreaAccess().getCasesAssurancePlanParserRuleCall_2_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleAssurancePlan_in_ruleAlisaWorkArea167);
            	            lv_cases_2_1=ruleAssurancePlan();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getAlisaWorkAreaRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"cases",
            	                    		lv_cases_2_1, 
            	                    		"AssurancePlan");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:120:8: lv_cases_2_2= ruleAssuranceTask
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getAlisaWorkAreaAccess().getCasesAssuranceTaskParserRuleCall_2_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleAssuranceTask_in_ruleAlisaWorkArea186);
            	            lv_cases_2_2=ruleAssuranceTask();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getAlisaWorkAreaRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"cases",
            	                    		lv_cases_2_2, 
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:146:1: entryRuleAssurancePlan returns [EObject current=null] : iv_ruleAssurancePlan= ruleAssurancePlan EOF ;
    public final EObject entryRuleAssurancePlan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssurancePlan = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:147:2: (iv_ruleAssurancePlan= ruleAssurancePlan EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:148:2: iv_ruleAssurancePlan= ruleAssurancePlan EOF
            {
             newCompositeNode(grammarAccess.getAssurancePlanRule()); 
            pushFollow(FOLLOW_ruleAssurancePlan_in_entryRuleAssurancePlan226);
            iv_ruleAssurancePlan=ruleAssurancePlan();

            state._fsp--;

             current =iv_ruleAssurancePlan; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssurancePlan236); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:155:1: ruleAssurancePlan returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_17= ']' ) ;
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
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_issues_16_0=null;
        Token otherlv_17=null;
        EObject lv_description_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:158:28: ( (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_17= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:159:1: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_17= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:159:1: (otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_17= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:159:3: otherlv_0= 'assurance' otherlv_1= 'plan' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_17= ']'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleAssurancePlan273); 

                	newLeafNode(otherlv_0, grammarAccess.getAssurancePlanAccess().getAssuranceKeyword_0());
                
            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleAssurancePlan285); 

                	newLeafNode(otherlv_1, grammarAccess.getAssurancePlanAccess().getPlanKeyword_1());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:167:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:168:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:168:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:169:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssurancePlan302); 

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

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:185:2: (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:185:4: otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleAssurancePlan320); 

                        	newLeafNode(otherlv_3, grammarAccess.getAssurancePlanAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:189:1: ( (lv_title_4_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:190:1: (lv_title_4_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:190:1: (lv_title_4_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:191:3: lv_title_4_0= RULE_STRING
                    {
                    lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssurancePlan337); 

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

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleAssurancePlan356); 

                	newLeafNode(otherlv_5, grammarAccess.getAssurancePlanAccess().getForKeyword_4());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:211:1: ( ( ruleAadlClassifierReference ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:212:1: ( ruleAadlClassifierReference )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:212:1: ( ruleAadlClassifierReference )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:213:3: ruleAadlClassifierReference
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getSystemComponentImplementationCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan379);
            ruleAadlClassifierReference();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleAssurancePlan391); 

                	newLeafNode(otherlv_7, grammarAccess.getAssurancePlanAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:230:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:232:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:232:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:233:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7());
            	
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:236:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:237:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:237:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=5;
                int LA7_0 = input.LA(1);

                if ( LA7_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) ) {
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:239:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:239:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:240:5: {...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:240:110: ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:241:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 0);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:244:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:244:7: {...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:244:16: (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:244:18: otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) )
            	    {
            	    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleAssurancePlan449); 

            	        	newLeafNode(otherlv_9, grammarAccess.getAssurancePlanAccess().getDescriptionKeyword_7_0_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:248:1: ( (lv_description_10_0= ruleDescription ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:249:1: (lv_description_10_0= ruleDescription )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:249:1: (lv_description_10_0= ruleDescription )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:250:3: lv_description_10_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getDescriptionDescriptionParserRuleCall_7_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleAssurancePlan470);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:273:4: ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:273:4: ({...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:274:5: {...}? => ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:274:110: ( ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:275:6: ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:278:6: ({...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:278:7: {...}? => (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:278:16: (otherlv_11= 'assert' ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:278:18: otherlv_11= 'assert' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_11=(Token)match(input,18,FOLLOW_18_in_ruleAssurancePlan538); 

            	        	newLeafNode(otherlv_11, grammarAccess.getAssurancePlanAccess().getAssertKeyword_7_1_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:282:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:283:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:283:1: ( ruleQualifiedName )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:284:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getPlansVerificationPlanCrossReference_7_1_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssurancePlan561);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:304:4: ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:304:4: ({...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:305:5: {...}? => ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:305:110: ( ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:306:6: ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 2);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:309:6: ({...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:309:7: {...}? => (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:309:16: (otherlv_13= 'assume' ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:309:18: otherlv_13= 'assume' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_13=(Token)match(input,19,FOLLOW_19_in_ruleAssurancePlan630); 

            	        	newLeafNode(otherlv_13, grammarAccess.getAssurancePlanAccess().getAssumeKeyword_7_2_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:313:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:314:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:314:1: ( ruleQualifiedName )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:315:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssurancePlanAccess().getVerifiedAssumptionAssurancePlanCrossReference_7_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssurancePlan653);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:335:4: ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:335:4: ({...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:336:5: {...}? => ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:336:110: ( ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:337:6: ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), 3);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:340:6: ({...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:340:7: {...}? => (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssurancePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:340:16: (otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:340:18: otherlv_15= 'issues' ( (lv_issues_16_0= RULE_STRING ) )+
            	    {
            	    otherlv_15=(Token)match(input,20,FOLLOW_20_in_ruleAssurancePlan722); 

            	        	newLeafNode(otherlv_15, grammarAccess.getAssurancePlanAccess().getIssuesKeyword_7_3_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:344:1: ( (lv_issues_16_0= RULE_STRING ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:345:1: (lv_issues_16_0= RULE_STRING )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:345:1: (lv_issues_16_0= RULE_STRING )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:346:3: lv_issues_16_0= RULE_STRING
            	    	    {
            	    	    lv_issues_16_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssurancePlan739); 

            	    	    			newLeafNode(lv_issues_16_0, grammarAccess.getAssurancePlanAccess().getIssuesSTRINGTerminalRuleCall_7_3_1_0()); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssurancePlanRule());
            	    	    	        }
            	    	           		addWithLastConsumed(
            	    	           			current, 
            	    	           			"issues",
            	    	            		lv_issues_16_0, 
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

            otherlv_17=(Token)match(input,21,FOLLOW_21_in_ruleAssurancePlan804); 

                	newLeafNode(otherlv_17, grammarAccess.getAssurancePlanAccess().getRightSquareBracketKeyword_8());
                

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:389:1: entryRuleAssuranceTask returns [EObject current=null] : iv_ruleAssuranceTask= ruleAssuranceTask EOF ;
    public final EObject entryRuleAssuranceTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssuranceTask = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:390:2: (iv_ruleAssuranceTask= ruleAssuranceTask EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:391:2: iv_ruleAssuranceTask= ruleAssuranceTask EOF
            {
             newCompositeNode(grammarAccess.getAssuranceTaskRule()); 
            pushFollow(FOLLOW_ruleAssuranceTask_in_entryRuleAssuranceTask840);
            iv_ruleAssuranceTask=ruleAssuranceTask();

            state._fsp--;

             current =iv_ruleAssuranceTask; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssuranceTask850); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:398:1: ruleAssuranceTask returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'of' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' ) ;
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
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:401:28: ( (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'of' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:402:1: (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'of' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:402:1: (otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'of' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:402:3: otherlv_0= 'assurance' otherlv_1= 'task' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? otherlv_5= 'of' ( (otherlv_6= RULE_ID ) ) otherlv_7= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) ) otherlv_23= ']'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleAssuranceTask887); 

                	newLeafNode(otherlv_0, grammarAccess.getAssuranceTaskAccess().getAssuranceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleAssuranceTask899); 

                	newLeafNode(otherlv_1, grammarAccess.getAssuranceTaskAccess().getTaskKeyword_1());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:410:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:411:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:411:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:412:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask916); 

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

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:428:2: (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==14) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:428:4: otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleAssuranceTask934); 

                        	newLeafNode(otherlv_3, grammarAccess.getAssuranceTaskAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:432:1: ( (lv_title_4_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:433:1: (lv_title_4_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:433:1: (lv_title_4_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:434:3: lv_title_4_0= RULE_STRING
                    {
                    lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssuranceTask951); 

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

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleAssuranceTask970); 

                	newLeafNode(otherlv_5, grammarAccess.getAssuranceTaskAccess().getOfKeyword_4());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:454:1: ( (otherlv_6= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:455:1: (otherlv_6= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:455:1: (otherlv_6= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:456:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask990); 

            		newLeafNode(otherlv_6, grammarAccess.getAssuranceTaskAccess().getAssurancePlanAssurancePlanCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleAssuranceTask1002); 

                	newLeafNode(otherlv_7, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:471:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:473:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:473:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:474:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7());
            	
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:477:2: ( ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?)
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:478:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+ {...}?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:478:3: ( ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=4;
                int LA17_0 = input.LA(1);

                if ( LA17_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0) ) {
                    alt17=1;
                }
                else if ( (LA17_0==24|| LA17_0 >=26 && LA17_0<=28) && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1) ) {
                    alt17=2;
                }
                else if ( LA17_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2) ) {
                    alt17=3;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:480:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:480:4: ({...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:481:5: {...}? => ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:481:110: ( ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:482:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 0);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:485:6: ({...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:485:7: {...}? => (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:485:16: (otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:485:18: otherlv_9= 'description' ( (lv_description_10_0= ruleDescription ) )
            	    {
            	    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleAssuranceTask1060); 

            	        	newLeafNode(otherlv_9, grammarAccess.getAssuranceTaskAccess().getDescriptionKeyword_7_0_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:489:1: ( (lv_description_10_0= ruleDescription ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:490:1: (lv_description_10_0= ruleDescription )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:490:1: (lv_description_10_0= ruleDescription )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:491:3: lv_description_10_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getDescriptionDescriptionParserRuleCall_7_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleAssuranceTask1081);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:514:4: ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:514:4: ({...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:515:5: {...}? => ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:515:110: ( ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:516:6: ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:519:6: ({...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:519:7: {...}? => ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:519:16: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) ) | (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ ) )
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==24||(LA15_0>=26 && LA15_0<=27)) ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0==28) ) {
            	        alt15=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 15, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:519:17: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:519:17: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) ) )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:521:1: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:521:1: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?) )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:522:2: ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?)
            	            {
            	             
            	            	  getUnorderedGroupHelper().enter(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0());
            	            	
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:525:2: ( ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?)
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:526:3: ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+ {...}?
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:526:3: ( ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) ) )+
            	            int cnt13=0;
            	            loop13:
            	            do {
            	                int alt13=4;
            	                switch ( input.LA(1) ) {
            	                case 24:
            	                    {
            	                    int LA13_2 = input.LA(2);

            	                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0) ) {
            	                        alt13=1;
            	                    }


            	                    }
            	                    break;
            	                case 26:
            	                    {
            	                    int LA13_3 = input.LA(2);

            	                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1) ) {
            	                        alt13=2;
            	                    }


            	                    }
            	                    break;
            	                case 27:
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
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:528:4: ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:528:4: ({...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:529:5: {...}? => ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) )
            	            	    {
            	            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0)");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:529:114: ( ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:530:6: ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) )
            	            	    {
            	            	     
            	            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 0);
            	            	    	 				
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:533:6: ({...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:533:7: {...}? => (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? )
            	            	    {
            	            	    if ( !((true)) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:533:16: (otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )? )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:533:18: otherlv_12= 'filter' (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )?
            	            	    {
            	            	    otherlv_12=(Token)match(input,24,FOLLOW_24_in_ruleAssuranceTask1195); 

            	            	        	newLeafNode(otherlv_12, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0_0());
            	            	        
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:537:1: (otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+ )?
            	            	    int alt10=2;
            	            	    int LA10_0 = input.LA(1);

            	            	    if ( (LA10_0==25) ) {
            	            	        alt10=1;
            	            	    }
            	            	    switch (alt10) {
            	            	        case 1 :
            	            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:537:3: otherlv_13= 'requirements' ( (otherlv_14= RULE_ID ) )+
            	            	            {
            	            	            otherlv_13=(Token)match(input,25,FOLLOW_25_in_ruleAssuranceTask1208); 

            	            	                	newLeafNode(otherlv_13, grammarAccess.getAssuranceTaskAccess().getRequirementsKeyword_7_1_0_0_1_0());
            	            	                
            	            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:541:1: ( (otherlv_14= RULE_ID ) )+
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
            	            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:542:1: (otherlv_14= RULE_ID )
            	            	            	    {
            	            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:542:1: (otherlv_14= RULE_ID )
            	            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:543:3: otherlv_14= RULE_ID
            	            	            	    {

            	            	            	    			if (current==null) {
            	            	            	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	            	    	        }
            	            	            	            
            	            	            	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1228); 

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
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:561:4: ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:561:4: ({...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:562:5: {...}? => ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) )
            	            	    {
            	            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1)");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:562:114: ( ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:563:6: ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) )
            	            	    {
            	            	     
            	            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 1);
            	            	    	 				
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:566:6: ({...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:566:7: {...}? => (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ )
            	            	    {
            	            	    if ( !((true)) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:566:16: (otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+ )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:566:18: otherlv_15= 'verifications' ( (otherlv_16= RULE_ID ) )+
            	            	    {
            	            	    otherlv_15=(Token)match(input,26,FOLLOW_26_in_ruleAssuranceTask1299); 

            	            	        	newLeafNode(otherlv_15, grammarAccess.getAssuranceTaskAccess().getVerificationsKeyword_7_1_0_1_0());
            	            	        
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:570:1: ( (otherlv_16= RULE_ID ) )+
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
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:571:1: (otherlv_16= RULE_ID )
            	            	    	    {
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:571:1: (otherlv_16= RULE_ID )
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:572:3: otherlv_16= RULE_ID
            	            	    	    {

            	            	    	    			if (current==null) {
            	            	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	    	    	        }
            	            	    	            
            	            	    	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1319); 

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
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:590:4: ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:590:4: ({...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:591:5: {...}? => ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) )
            	            	    {
            	            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 2) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 2)");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:591:114: ( ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:592:6: ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) )
            	            	    {
            	            	     
            	            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7_1_0(), 2);
            	            	    	 				
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:595:6: ({...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ ) )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:595:7: {...}? => (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ )
            	            	    {
            	            	    if ( !((true)) ) {
            	            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	            	    }
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:595:16: (otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+ )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:595:18: otherlv_17= 'selections' ( (otherlv_18= RULE_ID ) )+
            	            	    {
            	            	    otherlv_17=(Token)match(input,27,FOLLOW_27_in_ruleAssuranceTask1388); 

            	            	        	newLeafNode(otherlv_17, grammarAccess.getAssuranceTaskAccess().getSelectionsKeyword_7_1_0_2_0());
            	            	        
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:599:1: ( (otherlv_18= RULE_ID ) )+
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
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:600:1: (otherlv_18= RULE_ID )
            	            	    	    {
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:600:1: (otherlv_18= RULE_ID )
            	            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:601:3: otherlv_18= RULE_ID
            	            	    	    {

            	            	    	    			if (current==null) {
            	            	    	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	    	    	        }
            	            	    	            
            	            	    	    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceTask1408); 

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
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:628:6: (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ )
            	            {
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:628:6: (otherlv_19= 'claims' ( ( ruleQualifiedName ) )+ )
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:628:8: otherlv_19= 'claims' ( ( ruleQualifiedName ) )+
            	            {
            	            otherlv_19=(Token)match(input,28,FOLLOW_28_in_ruleAssuranceTask1475); 

            	                	newLeafNode(otherlv_19, grammarAccess.getAssuranceTaskAccess().getClaimsKeyword_7_1_1_0());
            	                
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:632:1: ( ( ruleQualifiedName ) )+
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
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:633:1: ( ruleQualifiedName )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:633:1: ( ruleQualifiedName )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:634:3: ruleQualifiedName
            	            	    {

            	            	    			if (current==null) {
            	            	    	            current = createModelElement(grammarAccess.getAssuranceTaskRule());
            	            	    	        }
            	            	            
            	            	     
            	            	    	        newCompositeNode(grammarAccess.getAssuranceTaskAccess().getClaimsClaimCrossReference_7_1_1_1_0()); 
            	            	    	    
            	            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssuranceTask1498);
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
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:654:4: ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:654:4: ({...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:655:5: {...}? => ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:655:110: ( ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:656:6: ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_7(), 2);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:659:6: ({...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:659:7: {...}? => (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceTask", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:659:16: (otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+ )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:659:18: otherlv_21= 'issues' ( (lv_issues_22_0= RULE_STRING ) )+
            	    {
            	    otherlv_21=(Token)match(input,20,FOLLOW_20_in_ruleAssuranceTask1568); 

            	        	newLeafNode(otherlv_21, grammarAccess.getAssuranceTaskAccess().getIssuesKeyword_7_2_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:663:1: ( (lv_issues_22_0= RULE_STRING ) )+
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
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:664:1: (lv_issues_22_0= RULE_STRING )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:664:1: (lv_issues_22_0= RULE_STRING )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:665:3: lv_issues_22_0= RULE_STRING
            	    	    {
            	    	    lv_issues_22_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAssuranceTask1585); 

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

            otherlv_23=(Token)match(input,21,FOLLOW_21_in_ruleAssuranceTask1650); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:708:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:709:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:710:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription1686);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription1696); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:717:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:720:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:721:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:721:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING||LA18_0==29) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:722:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:722:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:723:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription1741);
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:747:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:748:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:749:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1777);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement1787); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:756:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_thisTarget_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:759:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:760:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:760:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_thisTarget_1_0= 'this' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_STRING) ) {
                alt19=1;
            }
            else if ( (LA19_0==29) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:760:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:760:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:761:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:761:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:762:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement1829); 

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
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:779:6: ( (lv_thisTarget_1_0= 'this' ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:779:6: ( (lv_thisTarget_1_0= 'this' ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:780:1: (lv_thisTarget_1_0= 'this' )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:780:1: (lv_thisTarget_1_0= 'this' )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:781:3: lv_thisTarget_1_0= 'this'
                    {
                    lv_thisTarget_1_0=(Token)match(input,29,FOLLOW_29_in_ruleDescriptionElement1858); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:802:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:803:2: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:804:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1908);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference1919); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:811:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '::' this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:814:28: ( (this_ID_0= RULE_ID kw= '::' this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:815:1: (this_ID_0= RULE_ID kw= '::' this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:815:1: (this_ID_0= RULE_ID kw= '::' this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:815:6: this_ID_0= RULE_ID kw= '::' this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1959); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0()); 
                
            kw=(Token)match(input,30,FOLLOW_30_in_ruleAadlClassifierReference1977); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_1()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1992); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_2()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:835:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:836:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleAadlClassifierReference2011); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_3_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference2026); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_3_1()); 
                        

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:856:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:857:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:858:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2074);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2085); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:865:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:868:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:869:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:869:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:869:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2125); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:876:1: (kw= '.' this_ID_2= RULE_ID )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:877:2: kw= '.' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleQualifiedName2144); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
                        
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2159); 

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
    public static final BitSet FOLLOW_11_in_ruleAlisaWorkArea122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAlisaWorkArea139 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleAssurancePlan_in_ruleAlisaWorkArea167 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleAssuranceTask_in_ruleAlisaWorkArea186 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleAssurancePlan_in_entryRuleAssurancePlan226 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssurancePlan236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleAssurancePlan273 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleAssurancePlan285 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssurancePlan302 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleAssurancePlan320 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssurancePlan337 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssurancePlan356 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleAssurancePlan379 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAssurancePlan391 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_17_in_ruleAssurancePlan449 = new BitSet(new long[]{0x0000000020000020L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssurancePlan470 = new BitSet(new long[]{0x00000000003E0000L});
    public static final BitSet FOLLOW_18_in_ruleAssurancePlan538 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssurancePlan561 = new BitSet(new long[]{0x00000000003E0010L});
    public static final BitSet FOLLOW_19_in_ruleAssurancePlan630 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssurancePlan653 = new BitSet(new long[]{0x00000000003E0010L});
    public static final BitSet FOLLOW_20_in_ruleAssurancePlan722 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssurancePlan739 = new BitSet(new long[]{0x00000000003E0020L});
    public static final BitSet FOLLOW_21_in_ruleAssurancePlan804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssuranceTask_in_entryRuleAssuranceTask840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssuranceTask850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleAssuranceTask887 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleAssuranceTask899 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask916 = new BitSet(new long[]{0x0000000000804000L});
    public static final BitSet FOLLOW_14_in_ruleAssuranceTask934 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssuranceTask951 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleAssuranceTask970 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask990 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAssuranceTask1002 = new BitSet(new long[]{0x000000001D120000L});
    public static final BitSet FOLLOW_17_in_ruleAssuranceTask1060 = new BitSet(new long[]{0x0000000020000020L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssuranceTask1081 = new BitSet(new long[]{0x000000001D320000L});
    public static final BitSet FOLLOW_24_in_ruleAssuranceTask1195 = new BitSet(new long[]{0x000000001F320000L});
    public static final BitSet FOLLOW_25_in_ruleAssuranceTask1208 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1228 = new BitSet(new long[]{0x000000001D320010L});
    public static final BitSet FOLLOW_26_in_ruleAssuranceTask1299 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1319 = new BitSet(new long[]{0x000000001D320010L});
    public static final BitSet FOLLOW_27_in_ruleAssuranceTask1388 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceTask1408 = new BitSet(new long[]{0x000000001D320010L});
    public static final BitSet FOLLOW_28_in_ruleAssuranceTask1475 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssuranceTask1498 = new BitSet(new long[]{0x000000001D320010L});
    public static final BitSet FOLLOW_20_in_ruleAssuranceTask1568 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAssuranceTask1585 = new BitSet(new long[]{0x000000001D320020L});
    public static final BitSet FOLLOW_21_in_ruleAssuranceTask1650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription1686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription1741 = new BitSet(new long[]{0x0000000020000022L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDescriptionElement1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1959 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleAadlClassifierReference1977 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1992 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleAadlClassifierReference2011 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2074 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2125 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleQualifiedName2144 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2159 = new BitSet(new long[]{0x0000000000000002L});

}

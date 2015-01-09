package org.osate.assure.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.assure.services.AssureGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAssureParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'case'", "'for'", "'['", "']'", "'verification'", "'of'", "'output'", "'logfile'", "'date'", "'state'", "'status'", "'claim'", "'pass'", "'fail'", "'neutral'", "'unknown'", "'todo'", "'running'", "'redo'", "'completed'", "'tbd'"
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


        public InternalAssureParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAssureParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAssureParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g"; }



     	private AssureGrammarAccess grammarAccess;
     	
        public InternalAssureParser(TokenStream input, AssureGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "CaseResult";	
       	}
       	
       	@Override
       	protected AssureGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleCaseResult"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:68:1: entryRuleCaseResult returns [EObject current=null] : iv_ruleCaseResult= ruleCaseResult EOF ;
    public final EObject entryRuleCaseResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseResult = null;


        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:69:2: (iv_ruleCaseResult= ruleCaseResult EOF )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:70:2: iv_ruleCaseResult= ruleCaseResult EOF
            {
             newCompositeNode(grammarAccess.getCaseResultRule()); 
            pushFollow(FOLLOW_ruleCaseResult_in_entryRuleCaseResult75);
            iv_ruleCaseResult=ruleCaseResult();

            state._fsp--;

             current =iv_ruleCaseResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseResult85); 

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
    // $ANTLR end "entryRuleCaseResult"


    // $ANTLR start "ruleCaseResult"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:77:1: ruleCaseResult returns [EObject current=null] : (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (otherlv_3= RULE_ID ) ) otherlv_4= '[' ( (lv_result_5_0= ruleAggregateResultData ) )? ( (lv_subCaseResult_6_0= ruleCaseResult ) )* ( (lv_claimResult_7_0= ruleClaimResult ) )* otherlv_8= ']' ) ;
    public final EObject ruleCaseResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        EObject lv_result_5_0 = null;

        EObject lv_subCaseResult_6_0 = null;

        EObject lv_claimResult_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:80:28: ( (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (otherlv_3= RULE_ID ) ) otherlv_4= '[' ( (lv_result_5_0= ruleAggregateResultData ) )? ( (lv_subCaseResult_6_0= ruleCaseResult ) )* ( (lv_claimResult_7_0= ruleClaimResult ) )* otherlv_8= ']' ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:81:1: (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (otherlv_3= RULE_ID ) ) otherlv_4= '[' ( (lv_result_5_0= ruleAggregateResultData ) )? ( (lv_subCaseResult_6_0= ruleCaseResult ) )* ( (lv_claimResult_7_0= ruleClaimResult ) )* otherlv_8= ']' )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:81:1: (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (otherlv_3= RULE_ID ) ) otherlv_4= '[' ( (lv_result_5_0= ruleAggregateResultData ) )? ( (lv_subCaseResult_6_0= ruleCaseResult ) )* ( (lv_claimResult_7_0= ruleClaimResult ) )* otherlv_8= ']' )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:81:3: otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( (otherlv_3= RULE_ID ) ) otherlv_4= '[' ( (lv_result_5_0= ruleAggregateResultData ) )? ( (lv_subCaseResult_6_0= ruleCaseResult ) )* ( (lv_claimResult_7_0= ruleClaimResult ) )* otherlv_8= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleCaseResult122); 

                	newLeafNode(otherlv_0, grammarAccess.getCaseResultAccess().getCaseKeyword_0());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:85:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:86:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:86:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:87:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCaseResult139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCaseResultAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCaseResultRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleCaseResult156); 

                	newLeafNode(otherlv_2, grammarAccess.getCaseResultAccess().getForKeyword_2());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:107:1: ( (otherlv_3= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:108:1: (otherlv_3= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:108:1: (otherlv_3= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:109:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCaseResultRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCaseResult176); 

            		newLeafNode(otherlv_3, grammarAccess.getCaseResultAccess().getTargetInstanceObjectCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleCaseResult188); 

                	newLeafNode(otherlv_4, grammarAccess.getCaseResultAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:124:1: ( (lv_result_5_0= ruleAggregateResultData ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==23) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:125:1: (lv_result_5_0= ruleAggregateResultData )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:125:1: (lv_result_5_0= ruleAggregateResultData )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:126:3: lv_result_5_0= ruleAggregateResultData
                    {
                     
                    	        newCompositeNode(grammarAccess.getCaseResultAccess().getResultAggregateResultDataParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAggregateResultData_in_ruleCaseResult209);
                    lv_result_5_0=ruleAggregateResultData();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCaseResultRule());
                    	        }
                           		set(
                           			current, 
                           			"result",
                            		lv_result_5_0, 
                            		"AggregateResultData");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:142:3: ( (lv_subCaseResult_6_0= ruleCaseResult ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:143:1: (lv_subCaseResult_6_0= ruleCaseResult )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:143:1: (lv_subCaseResult_6_0= ruleCaseResult )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:144:3: lv_subCaseResult_6_0= ruleCaseResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCaseResultAccess().getSubCaseResultCaseResultParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCaseResult_in_ruleCaseResult231);
            	    lv_subCaseResult_6_0=ruleCaseResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCaseResultRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subCaseResult",
            	            		lv_subCaseResult_6_0, 
            	            		"CaseResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:160:3: ( (lv_claimResult_7_0= ruleClaimResult ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==22) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:161:1: (lv_claimResult_7_0= ruleClaimResult )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:161:1: (lv_claimResult_7_0= ruleClaimResult )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:162:3: lv_claimResult_7_0= ruleClaimResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCaseResultAccess().getClaimResultClaimResultParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleClaimResult_in_ruleCaseResult253);
            	    lv_claimResult_7_0=ruleClaimResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCaseResultRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"claimResult",
            	            		lv_claimResult_7_0, 
            	            		"ClaimResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleCaseResult266); 

                	newLeafNode(otherlv_8, grammarAccess.getCaseResultAccess().getRightSquareBracketKeyword_8());
                

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
    // $ANTLR end "ruleCaseResult"


    // $ANTLR start "entryRuleVerificationResult"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:190:1: entryRuleVerificationResult returns [EObject current=null] : iv_ruleVerificationResult= ruleVerificationResult EOF ;
    public final EObject entryRuleVerificationResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationResult = null;


        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:191:2: (iv_ruleVerificationResult= ruleVerificationResult EOF )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:192:2: iv_ruleVerificationResult= ruleVerificationResult EOF
            {
             newCompositeNode(grammarAccess.getVerificationResultRule()); 
            pushFollow(FOLLOW_ruleVerificationResult_in_entryRuleVerificationResult302);
            iv_ruleVerificationResult=ruleVerificationResult();

            state._fsp--;

             current =iv_ruleVerificationResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationResult312); 

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
    // $ANTLR end "entryRuleVerificationResult"


    // $ANTLR start "ruleVerificationResult"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:199:1: ruleVerificationResult returns [EObject current=null] : (otherlv_0= 'verification' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'of' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'for' ( (otherlv_5= RULE_ID ) ) otherlv_6= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) ) ( (lv_assumptionVerificationResult_18_0= ruleVerificationResult ) )* otherlv_19= ']' ) ;
    public final EObject ruleVerificationResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_title_9_0=null;
        Token otherlv_10=null;
        Token lv_description_11_0=null;
        Token otherlv_12=null;
        Token lv_date_13_0=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_19=null;
        Enumerator lv_state_15_0 = null;

        Enumerator lv_status_17_0 = null;

        EObject lv_assumptionVerificationResult_18_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:202:28: ( (otherlv_0= 'verification' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'of' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'for' ( (otherlv_5= RULE_ID ) ) otherlv_6= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) ) ( (lv_assumptionVerificationResult_18_0= ruleVerificationResult ) )* otherlv_19= ']' ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:203:1: (otherlv_0= 'verification' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'of' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'for' ( (otherlv_5= RULE_ID ) ) otherlv_6= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) ) ( (lv_assumptionVerificationResult_18_0= ruleVerificationResult ) )* otherlv_19= ']' )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:203:1: (otherlv_0= 'verification' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'of' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'for' ( (otherlv_5= RULE_ID ) ) otherlv_6= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) ) ( (lv_assumptionVerificationResult_18_0= ruleVerificationResult ) )* otherlv_19= ']' )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:203:3: otherlv_0= 'verification' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'of' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'for' ( (otherlv_5= RULE_ID ) ) otherlv_6= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) ) ( (lv_assumptionVerificationResult_18_0= ruleVerificationResult ) )* otherlv_19= ']'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleVerificationResult349); 

                	newLeafNode(otherlv_0, grammarAccess.getVerificationResultAccess().getVerificationKeyword_0());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:207:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:208:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:208:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:209:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationResult366); 

            			newLeafNode(lv_name_1_0, grammarAccess.getVerificationResultAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVerificationResultRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleVerificationResult383); 

                	newLeafNode(otherlv_2, grammarAccess.getVerificationResultAccess().getOfKeyword_2());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:229:1: ( (otherlv_3= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:230:1: (otherlv_3= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:230:1: (otherlv_3= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:231:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVerificationResultRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationResult403); 

            		newLeafNode(otherlv_3, grammarAccess.getVerificationResultAccess().getVerificationActivityVerificationActivityCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleVerificationResult415); 

                	newLeafNode(otherlv_4, grammarAccess.getVerificationResultAccess().getForKeyword_4());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:246:1: ( (otherlv_5= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:247:1: (otherlv_5= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:247:1: (otherlv_5= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:248:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVerificationResultRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationResult435); 

            		newLeafNode(otherlv_5, grammarAccess.getVerificationResultAccess().getTargetInstanceObjectCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleVerificationResult447); 

                	newLeafNode(otherlv_6, grammarAccess.getVerificationResultAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:263:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:265:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:265:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:266:2: ( ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7());
            	
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:269:2: ( ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )* )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:270:3: ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )*
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:270:3: ( ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) ) )*
            loop4:
            do {
                int alt4=6;
                int LA4_0 = input.LA(1);

                if ( LA4_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 0) ) {
                    alt4=1;
                }
                else if ( LA4_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 1) ) {
                    alt4=2;
                }
                else if ( LA4_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 2) ) {
                    alt4=3;
                }
                else if ( LA4_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 3) ) {
                    alt4=4;
                }
                else if ( LA4_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 4) ) {
                    alt4=5;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:272:4: ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:272:4: ({...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:273:5: {...}? => ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:273:115: ( ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:274:6: ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 0);
            	    	 				
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:277:6: ({...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:277:7: {...}? => (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "true");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:277:16: (otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:277:18: otherlv_8= 'output' ( (lv_title_9_0= RULE_STRING ) )
            	    {
            	    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleVerificationResult505); 

            	        	newLeafNode(otherlv_8, grammarAccess.getVerificationResultAccess().getOutputKeyword_7_0_0());
            	        
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:281:1: ( (lv_title_9_0= RULE_STRING ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:282:1: (lv_title_9_0= RULE_STRING )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:282:1: (lv_title_9_0= RULE_STRING )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:283:3: lv_title_9_0= RULE_STRING
            	    {
            	    lv_title_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVerificationResult522); 

            	    			newLeafNode(lv_title_9_0, grammarAccess.getVerificationResultAccess().getTitleSTRINGTerminalRuleCall_7_0_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getVerificationResultRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"title",
            	            		lv_title_9_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:306:4: ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:306:4: ({...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:307:5: {...}? => ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:307:115: ( ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:308:6: ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:311:6: ({...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:311:7: {...}? => (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "true");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:311:16: (otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:311:18: otherlv_10= 'logfile' ( (lv_description_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleVerificationResult595); 

            	        	newLeafNode(otherlv_10, grammarAccess.getVerificationResultAccess().getLogfileKeyword_7_1_0());
            	        
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:315:1: ( (lv_description_11_0= RULE_STRING ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:316:1: (lv_description_11_0= RULE_STRING )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:316:1: (lv_description_11_0= RULE_STRING )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:317:3: lv_description_11_0= RULE_STRING
            	    {
            	    lv_description_11_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVerificationResult612); 

            	    			newLeafNode(lv_description_11_0, grammarAccess.getVerificationResultAccess().getDescriptionSTRINGTerminalRuleCall_7_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getVerificationResultRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"description",
            	            		lv_description_11_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:340:4: ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:340:4: ({...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:341:5: {...}? => ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:341:115: ( ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:342:6: ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 2);
            	    	 				
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:345:6: ({...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:345:7: {...}? => (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "true");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:345:16: (otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:345:18: otherlv_12= 'date' ( (lv_date_13_0= RULE_STRING ) )
            	    {
            	    otherlv_12=(Token)match(input,19,FOLLOW_19_in_ruleVerificationResult685); 

            	        	newLeafNode(otherlv_12, grammarAccess.getVerificationResultAccess().getDateKeyword_7_2_0());
            	        
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:349:1: ( (lv_date_13_0= RULE_STRING ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:350:1: (lv_date_13_0= RULE_STRING )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:350:1: (lv_date_13_0= RULE_STRING )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:351:3: lv_date_13_0= RULE_STRING
            	    {
            	    lv_date_13_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVerificationResult702); 

            	    			newLeafNode(lv_date_13_0, grammarAccess.getVerificationResultAccess().getDateSTRINGTerminalRuleCall_7_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getVerificationResultRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"date",
            	            		lv_date_13_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:374:4: ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:374:4: ({...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:375:5: {...}? => ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:375:115: ( ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:376:6: ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 3);
            	    	 				
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:379:6: ({...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:379:7: {...}? => (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "true");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:379:16: (otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:379:18: otherlv_14= 'state' ( (lv_state_15_0= ruleVerificationResultState ) )
            	    {
            	    otherlv_14=(Token)match(input,20,FOLLOW_20_in_ruleVerificationResult775); 

            	        	newLeafNode(otherlv_14, grammarAccess.getVerificationResultAccess().getStateKeyword_7_3_0());
            	        
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:383:1: ( (lv_state_15_0= ruleVerificationResultState ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:384:1: (lv_state_15_0= ruleVerificationResultState )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:384:1: (lv_state_15_0= ruleVerificationResultState )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:385:3: lv_state_15_0= ruleVerificationResultState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVerificationResultAccess().getStateVerificationResultStateEnumRuleCall_7_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationResultState_in_ruleVerificationResult796);
            	    lv_state_15_0=ruleVerificationResultState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVerificationResultRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"state",
            	            		lv_state_15_0, 
            	            		"VerificationResultState");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:408:4: ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:408:4: ({...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:409:5: {...}? => ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 4)");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:409:115: ( ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:410:6: ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7(), 4);
            	    	 				
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:413:6: ({...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:413:7: {...}? => (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "true");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:413:16: (otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:413:18: otherlv_16= 'status' ( (lv_status_17_0= ruleVerificationResultStatus ) )
            	    {
            	    otherlv_16=(Token)match(input,21,FOLLOW_21_in_ruleVerificationResult864); 

            	        	newLeafNode(otherlv_16, grammarAccess.getVerificationResultAccess().getStatusKeyword_7_4_0());
            	        
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:417:1: ( (lv_status_17_0= ruleVerificationResultStatus ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:418:1: (lv_status_17_0= ruleVerificationResultStatus )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:418:1: (lv_status_17_0= ruleVerificationResultStatus )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:419:3: lv_status_17_0= ruleVerificationResultStatus
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVerificationResultAccess().getStatusVerificationResultStatusEnumRuleCall_7_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationResultStatus_in_ruleVerificationResult885);
            	    lv_status_17_0=ruleVerificationResultStatus();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVerificationResultRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"status",
            	            		lv_status_17_0, 
            	            		"VerificationResultStatus");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getVerificationResultAccess().getUnorderedGroup_7());
            	

            }

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:449:2: ( (lv_assumptionVerificationResult_18_0= ruleVerificationResult ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:450:1: (lv_assumptionVerificationResult_18_0= ruleVerificationResult )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:450:1: (lv_assumptionVerificationResult_18_0= ruleVerificationResult )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:451:3: lv_assumptionVerificationResult_18_0= ruleVerificationResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVerificationResultAccess().getAssumptionVerificationResultVerificationResultParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationResult_in_ruleVerificationResult947);
            	    lv_assumptionVerificationResult_18_0=ruleVerificationResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVerificationResultRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"assumptionVerificationResult",
            	            		lv_assumptionVerificationResult_18_0, 
            	            		"VerificationResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_19=(Token)match(input,14,FOLLOW_14_in_ruleVerificationResult960); 

                	newLeafNode(otherlv_19, grammarAccess.getVerificationResultAccess().getRightSquareBracketKeyword_9());
                

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
    // $ANTLR end "ruleVerificationResult"


    // $ANTLR start "entryRuleClaimResult"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:479:1: entryRuleClaimResult returns [EObject current=null] : iv_ruleClaimResult= ruleClaimResult EOF ;
    public final EObject entryRuleClaimResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimResult = null;


        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:480:2: (iv_ruleClaimResult= ruleClaimResult EOF )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:481:2: iv_ruleClaimResult= ruleClaimResult EOF
            {
             newCompositeNode(grammarAccess.getClaimResultRule()); 
            pushFollow(FOLLOW_ruleClaimResult_in_entryRuleClaimResult996);
            iv_ruleClaimResult=ruleClaimResult();

            state._fsp--;

             current =iv_ruleClaimResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClaimResult1006); 

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
    // $ANTLR end "entryRuleClaimResult"


    // $ANTLR start "ruleClaimResult"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:488:1: ruleClaimResult returns [EObject current=null] : (otherlv_0= 'claim' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'of' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'for' ( (otherlv_5= RULE_ID ) ) otherlv_6= '[' ( (lv_result_7_0= ruleAggregateResultData ) )? ( (lv_subClaimResult_8_0= ruleClaimResult ) )* ( (lv_verificationResult_9_0= ruleVerificationResult ) )* otherlv_10= ']' ) ;
    public final EObject ruleClaimResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_10=null;
        EObject lv_result_7_0 = null;

        EObject lv_subClaimResult_8_0 = null;

        EObject lv_verificationResult_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:491:28: ( (otherlv_0= 'claim' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'of' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'for' ( (otherlv_5= RULE_ID ) ) otherlv_6= '[' ( (lv_result_7_0= ruleAggregateResultData ) )? ( (lv_subClaimResult_8_0= ruleClaimResult ) )* ( (lv_verificationResult_9_0= ruleVerificationResult ) )* otherlv_10= ']' ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:492:1: (otherlv_0= 'claim' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'of' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'for' ( (otherlv_5= RULE_ID ) ) otherlv_6= '[' ( (lv_result_7_0= ruleAggregateResultData ) )? ( (lv_subClaimResult_8_0= ruleClaimResult ) )* ( (lv_verificationResult_9_0= ruleVerificationResult ) )* otherlv_10= ']' )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:492:1: (otherlv_0= 'claim' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'of' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'for' ( (otherlv_5= RULE_ID ) ) otherlv_6= '[' ( (lv_result_7_0= ruleAggregateResultData ) )? ( (lv_subClaimResult_8_0= ruleClaimResult ) )* ( (lv_verificationResult_9_0= ruleVerificationResult ) )* otherlv_10= ']' )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:492:3: otherlv_0= 'claim' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'of' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'for' ( (otherlv_5= RULE_ID ) ) otherlv_6= '[' ( (lv_result_7_0= ruleAggregateResultData ) )? ( (lv_subClaimResult_8_0= ruleClaimResult ) )* ( (lv_verificationResult_9_0= ruleVerificationResult ) )* otherlv_10= ']'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleClaimResult1043); 

                	newLeafNode(otherlv_0, grammarAccess.getClaimResultAccess().getClaimKeyword_0());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:496:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:497:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:497:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:498:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClaimResult1060); 

            			newLeafNode(lv_name_1_0, grammarAccess.getClaimResultAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClaimResultRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleClaimResult1077); 

                	newLeafNode(otherlv_2, grammarAccess.getClaimResultAccess().getOfKeyword_2());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:518:1: ( (otherlv_3= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:519:1: (otherlv_3= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:519:1: (otherlv_3= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:520:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getClaimResultRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClaimResult1097); 

            		newLeafNode(otherlv_3, grammarAccess.getClaimResultAccess().getRequirementRequirementCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleClaimResult1109); 

                	newLeafNode(otherlv_4, grammarAccess.getClaimResultAccess().getForKeyword_4());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:535:1: ( (otherlv_5= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:536:1: (otherlv_5= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:536:1: (otherlv_5= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:537:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getClaimResultRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClaimResult1129); 

            		newLeafNode(otherlv_5, grammarAccess.getClaimResultAccess().getTargetInstanceObjectCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleClaimResult1141); 

                	newLeafNode(otherlv_6, grammarAccess.getClaimResultAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:552:1: ( (lv_result_7_0= ruleAggregateResultData ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:553:1: (lv_result_7_0= ruleAggregateResultData )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:553:1: (lv_result_7_0= ruleAggregateResultData )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:554:3: lv_result_7_0= ruleAggregateResultData
                    {
                     
                    	        newCompositeNode(grammarAccess.getClaimResultAccess().getResultAggregateResultDataParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAggregateResultData_in_ruleClaimResult1162);
                    lv_result_7_0=ruleAggregateResultData();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getClaimResultRule());
                    	        }
                           		set(
                           			current, 
                           			"result",
                            		lv_result_7_0, 
                            		"AggregateResultData");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:570:3: ( (lv_subClaimResult_8_0= ruleClaimResult ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==22) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:571:1: (lv_subClaimResult_8_0= ruleClaimResult )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:571:1: (lv_subClaimResult_8_0= ruleClaimResult )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:572:3: lv_subClaimResult_8_0= ruleClaimResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClaimResultAccess().getSubClaimResultClaimResultParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleClaimResult_in_ruleClaimResult1184);
            	    lv_subClaimResult_8_0=ruleClaimResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClaimResultRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subClaimResult",
            	            		lv_subClaimResult_8_0, 
            	            		"ClaimResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:588:3: ( (lv_verificationResult_9_0= ruleVerificationResult ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:589:1: (lv_verificationResult_9_0= ruleVerificationResult )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:589:1: (lv_verificationResult_9_0= ruleVerificationResult )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:590:3: lv_verificationResult_9_0= ruleVerificationResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClaimResultAccess().getVerificationResultVerificationResultParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationResult_in_ruleClaimResult1206);
            	    lv_verificationResult_9_0=ruleVerificationResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClaimResultRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"verificationResult",
            	            		lv_verificationResult_9_0, 
            	            		"VerificationResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleClaimResult1219); 

                	newLeafNode(otherlv_10, grammarAccess.getClaimResultAccess().getRightSquareBracketKeyword_10());
                

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
    // $ANTLR end "ruleClaimResult"


    // $ANTLR start "entryRuleAggregateResultData"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:618:1: entryRuleAggregateResultData returns [EObject current=null] : iv_ruleAggregateResultData= ruleAggregateResultData EOF ;
    public final EObject entryRuleAggregateResultData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAggregateResultData = null;


        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:619:2: (iv_ruleAggregateResultData= ruleAggregateResultData EOF )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:620:2: iv_ruleAggregateResultData= ruleAggregateResultData EOF
            {
             newCompositeNode(grammarAccess.getAggregateResultDataRule()); 
            pushFollow(FOLLOW_ruleAggregateResultData_in_entryRuleAggregateResultData1255);
            iv_ruleAggregateResultData=ruleAggregateResultData();

            state._fsp--;

             current =iv_ruleAggregateResultData; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAggregateResultData1265); 

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
    // $ANTLR end "entryRuleAggregateResultData"


    // $ANTLR start "ruleAggregateResultData"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:627:1: ruleAggregateResultData returns [EObject current=null] : ( (otherlv_0= 'pass' ( (lv_passCount_1_0= RULE_INT ) ) ) (otherlv_2= 'fail' ( (lv_failCount_3_0= RULE_INT ) ) ) (otherlv_4= 'neutral' ( (lv_neutralCount_5_0= RULE_INT ) ) ) (otherlv_6= 'unknown' ( (lv_unknownCount_7_0= RULE_INT ) ) ) ) ;
    public final EObject ruleAggregateResultData() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_passCount_1_0=null;
        Token otherlv_2=null;
        Token lv_failCount_3_0=null;
        Token otherlv_4=null;
        Token lv_neutralCount_5_0=null;
        Token otherlv_6=null;
        Token lv_unknownCount_7_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:630:28: ( ( (otherlv_0= 'pass' ( (lv_passCount_1_0= RULE_INT ) ) ) (otherlv_2= 'fail' ( (lv_failCount_3_0= RULE_INT ) ) ) (otherlv_4= 'neutral' ( (lv_neutralCount_5_0= RULE_INT ) ) ) (otherlv_6= 'unknown' ( (lv_unknownCount_7_0= RULE_INT ) ) ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:631:1: ( (otherlv_0= 'pass' ( (lv_passCount_1_0= RULE_INT ) ) ) (otherlv_2= 'fail' ( (lv_failCount_3_0= RULE_INT ) ) ) (otherlv_4= 'neutral' ( (lv_neutralCount_5_0= RULE_INT ) ) ) (otherlv_6= 'unknown' ( (lv_unknownCount_7_0= RULE_INT ) ) ) )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:631:1: ( (otherlv_0= 'pass' ( (lv_passCount_1_0= RULE_INT ) ) ) (otherlv_2= 'fail' ( (lv_failCount_3_0= RULE_INT ) ) ) (otherlv_4= 'neutral' ( (lv_neutralCount_5_0= RULE_INT ) ) ) (otherlv_6= 'unknown' ( (lv_unknownCount_7_0= RULE_INT ) ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:631:2: (otherlv_0= 'pass' ( (lv_passCount_1_0= RULE_INT ) ) ) (otherlv_2= 'fail' ( (lv_failCount_3_0= RULE_INT ) ) ) (otherlv_4= 'neutral' ( (lv_neutralCount_5_0= RULE_INT ) ) ) (otherlv_6= 'unknown' ( (lv_unknownCount_7_0= RULE_INT ) ) )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:631:2: (otherlv_0= 'pass' ( (lv_passCount_1_0= RULE_INT ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:631:4: otherlv_0= 'pass' ( (lv_passCount_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleAggregateResultData1303); 

                	newLeafNode(otherlv_0, grammarAccess.getAggregateResultDataAccess().getPassKeyword_0_0());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:635:1: ( (lv_passCount_1_0= RULE_INT ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:636:1: (lv_passCount_1_0= RULE_INT )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:636:1: (lv_passCount_1_0= RULE_INT )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:637:3: lv_passCount_1_0= RULE_INT
            {
            lv_passCount_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAggregateResultData1320); 

            			newLeafNode(lv_passCount_1_0, grammarAccess.getAggregateResultDataAccess().getPassCountINTTerminalRuleCall_0_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAggregateResultDataRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"passCount",
                    		lv_passCount_1_0, 
                    		"INT");
            	    

            }


            }


            }

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:653:3: (otherlv_2= 'fail' ( (lv_failCount_3_0= RULE_INT ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:653:5: otherlv_2= 'fail' ( (lv_failCount_3_0= RULE_INT ) )
            {
            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleAggregateResultData1339); 

                	newLeafNode(otherlv_2, grammarAccess.getAggregateResultDataAccess().getFailKeyword_1_0());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:657:1: ( (lv_failCount_3_0= RULE_INT ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:658:1: (lv_failCount_3_0= RULE_INT )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:658:1: (lv_failCount_3_0= RULE_INT )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:659:3: lv_failCount_3_0= RULE_INT
            {
            lv_failCount_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAggregateResultData1356); 

            			newLeafNode(lv_failCount_3_0, grammarAccess.getAggregateResultDataAccess().getFailCountINTTerminalRuleCall_1_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAggregateResultDataRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"failCount",
                    		lv_failCount_3_0, 
                    		"INT");
            	    

            }


            }


            }

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:675:3: (otherlv_4= 'neutral' ( (lv_neutralCount_5_0= RULE_INT ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:675:5: otherlv_4= 'neutral' ( (lv_neutralCount_5_0= RULE_INT ) )
            {
            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleAggregateResultData1375); 

                	newLeafNode(otherlv_4, grammarAccess.getAggregateResultDataAccess().getNeutralKeyword_2_0());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:679:1: ( (lv_neutralCount_5_0= RULE_INT ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:680:1: (lv_neutralCount_5_0= RULE_INT )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:680:1: (lv_neutralCount_5_0= RULE_INT )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:681:3: lv_neutralCount_5_0= RULE_INT
            {
            lv_neutralCount_5_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAggregateResultData1392); 

            			newLeafNode(lv_neutralCount_5_0, grammarAccess.getAggregateResultDataAccess().getNeutralCountINTTerminalRuleCall_2_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAggregateResultDataRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"neutralCount",
                    		lv_neutralCount_5_0, 
                    		"INT");
            	    

            }


            }


            }

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:697:3: (otherlv_6= 'unknown' ( (lv_unknownCount_7_0= RULE_INT ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:697:5: otherlv_6= 'unknown' ( (lv_unknownCount_7_0= RULE_INT ) )
            {
            otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleAggregateResultData1411); 

                	newLeafNode(otherlv_6, grammarAccess.getAggregateResultDataAccess().getUnknownKeyword_3_0());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:701:1: ( (lv_unknownCount_7_0= RULE_INT ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:702:1: (lv_unknownCount_7_0= RULE_INT )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:702:1: (lv_unknownCount_7_0= RULE_INT )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:703:3: lv_unknownCount_7_0= RULE_INT
            {
            lv_unknownCount_7_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAggregateResultData1428); 

            			newLeafNode(lv_unknownCount_7_0, grammarAccess.getAggregateResultDataAccess().getUnknownCountINTTerminalRuleCall_3_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAggregateResultDataRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"unknownCount",
                    		lv_unknownCount_7_0, 
                    		"INT");
            	    

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
    // $ANTLR end "ruleAggregateResultData"


    // $ANTLR start "ruleVerificationResultState"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:729:1: ruleVerificationResultState returns [Enumerator current=null] : ( (enumLiteral_0= 'todo' ) | (enumLiteral_1= 'running' ) | (enumLiteral_2= 'redo' ) | (enumLiteral_3= 'completed' ) ) ;
    public final Enumerator ruleVerificationResultState() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:731:28: ( ( (enumLiteral_0= 'todo' ) | (enumLiteral_1= 'running' ) | (enumLiteral_2= 'redo' ) | (enumLiteral_3= 'completed' ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:732:1: ( (enumLiteral_0= 'todo' ) | (enumLiteral_1= 'running' ) | (enumLiteral_2= 'redo' ) | (enumLiteral_3= 'completed' ) )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:732:1: ( (enumLiteral_0= 'todo' ) | (enumLiteral_1= 'running' ) | (enumLiteral_2= 'redo' ) | (enumLiteral_3= 'completed' ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt9=1;
                }
                break;
            case 28:
                {
                alt9=2;
                }
                break;
            case 29:
                {
                alt9=3;
                }
                break;
            case 30:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:732:2: (enumLiteral_0= 'todo' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:732:2: (enumLiteral_0= 'todo' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:732:4: enumLiteral_0= 'todo'
                    {
                    enumLiteral_0=(Token)match(input,27,FOLLOW_27_in_ruleVerificationResultState1486); 

                            current = grammarAccess.getVerificationResultStateAccess().getTODOEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVerificationResultStateAccess().getTODOEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:738:6: (enumLiteral_1= 'running' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:738:6: (enumLiteral_1= 'running' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:738:8: enumLiteral_1= 'running'
                    {
                    enumLiteral_1=(Token)match(input,28,FOLLOW_28_in_ruleVerificationResultState1503); 

                            current = grammarAccess.getVerificationResultStateAccess().getRUNNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVerificationResultStateAccess().getRUNNINGEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:744:6: (enumLiteral_2= 'redo' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:744:6: (enumLiteral_2= 'redo' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:744:8: enumLiteral_2= 'redo'
                    {
                    enumLiteral_2=(Token)match(input,29,FOLLOW_29_in_ruleVerificationResultState1520); 

                            current = grammarAccess.getVerificationResultStateAccess().getREDOEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVerificationResultStateAccess().getREDOEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:750:6: (enumLiteral_3= 'completed' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:750:6: (enumLiteral_3= 'completed' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:750:8: enumLiteral_3= 'completed'
                    {
                    enumLiteral_3=(Token)match(input,30,FOLLOW_30_in_ruleVerificationResultState1537); 

                            current = grammarAccess.getVerificationResultStateAccess().getCOMPLETEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVerificationResultStateAccess().getCOMPLETEDEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleVerificationResultState"


    // $ANTLR start "ruleVerificationResultStatus"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:760:1: ruleVerificationResultStatus returns [Enumerator current=null] : ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'pass' ) | (enumLiteral_2= 'fail' ) | (enumLiteral_3= 'unknown' ) ) ;
    public final Enumerator ruleVerificationResultStatus() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:762:28: ( ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'pass' ) | (enumLiteral_2= 'fail' ) | (enumLiteral_3= 'unknown' ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:763:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'pass' ) | (enumLiteral_2= 'fail' ) | (enumLiteral_3= 'unknown' ) )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:763:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'pass' ) | (enumLiteral_2= 'fail' ) | (enumLiteral_3= 'unknown' ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt10=1;
                }
                break;
            case 23:
                {
                alt10=2;
                }
                break;
            case 24:
                {
                alt10=3;
                }
                break;
            case 26:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:763:2: (enumLiteral_0= 'tbd' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:763:2: (enumLiteral_0= 'tbd' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:763:4: enumLiteral_0= 'tbd'
                    {
                    enumLiteral_0=(Token)match(input,31,FOLLOW_31_in_ruleVerificationResultStatus1582); 

                            current = grammarAccess.getVerificationResultStatusAccess().getTBDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVerificationResultStatusAccess().getTBDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:769:6: (enumLiteral_1= 'pass' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:769:6: (enumLiteral_1= 'pass' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:769:8: enumLiteral_1= 'pass'
                    {
                    enumLiteral_1=(Token)match(input,23,FOLLOW_23_in_ruleVerificationResultStatus1599); 

                            current = grammarAccess.getVerificationResultStatusAccess().getPASSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVerificationResultStatusAccess().getPASSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:775:6: (enumLiteral_2= 'fail' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:775:6: (enumLiteral_2= 'fail' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:775:8: enumLiteral_2= 'fail'
                    {
                    enumLiteral_2=(Token)match(input,24,FOLLOW_24_in_ruleVerificationResultStatus1616); 

                            current = grammarAccess.getVerificationResultStatusAccess().getFAILEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVerificationResultStatusAccess().getFAILEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:781:6: (enumLiteral_3= 'unknown' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:781:6: (enumLiteral_3= 'unknown' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:781:8: enumLiteral_3= 'unknown'
                    {
                    enumLiteral_3=(Token)match(input,26,FOLLOW_26_in_ruleVerificationResultStatus1633); 

                            current = grammarAccess.getVerificationResultStatusAccess().getUNKNOWNEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVerificationResultStatusAccess().getUNKNOWNEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleVerificationResultStatus"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCaseResult_in_entryRuleCaseResult75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseResult85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleCaseResult122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCaseResult139 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleCaseResult156 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCaseResult176 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCaseResult188 = new BitSet(new long[]{0x0000000000C04800L});
    public static final BitSet FOLLOW_ruleAggregateResultData_in_ruleCaseResult209 = new BitSet(new long[]{0x0000000000404800L});
    public static final BitSet FOLLOW_ruleCaseResult_in_ruleCaseResult231 = new BitSet(new long[]{0x0000000000404800L});
    public static final BitSet FOLLOW_ruleClaimResult_in_ruleCaseResult253 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_14_in_ruleCaseResult266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationResult_in_entryRuleVerificationResult302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationResult312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleVerificationResult349 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationResult366 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleVerificationResult383 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationResult403 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVerificationResult415 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationResult435 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleVerificationResult447 = new BitSet(new long[]{0x00000000003EC000L});
    public static final BitSet FOLLOW_17_in_ruleVerificationResult505 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVerificationResult522 = new BitSet(new long[]{0x00000000003EC000L});
    public static final BitSet FOLLOW_18_in_ruleVerificationResult595 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVerificationResult612 = new BitSet(new long[]{0x00000000003EC000L});
    public static final BitSet FOLLOW_19_in_ruleVerificationResult685 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVerificationResult702 = new BitSet(new long[]{0x00000000003EC000L});
    public static final BitSet FOLLOW_20_in_ruleVerificationResult775 = new BitSet(new long[]{0x0000000078000000L});
    public static final BitSet FOLLOW_ruleVerificationResultState_in_ruleVerificationResult796 = new BitSet(new long[]{0x00000000003EC000L});
    public static final BitSet FOLLOW_21_in_ruleVerificationResult864 = new BitSet(new long[]{0x0000000085800000L});
    public static final BitSet FOLLOW_ruleVerificationResultStatus_in_ruleVerificationResult885 = new BitSet(new long[]{0x00000000003EC000L});
    public static final BitSet FOLLOW_ruleVerificationResult_in_ruleVerificationResult947 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleVerificationResult960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClaimResult_in_entryRuleClaimResult996 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClaimResult1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleClaimResult1043 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClaimResult1060 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleClaimResult1077 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClaimResult1097 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleClaimResult1109 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClaimResult1129 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleClaimResult1141 = new BitSet(new long[]{0x0000000000C0C000L});
    public static final BitSet FOLLOW_ruleAggregateResultData_in_ruleClaimResult1162 = new BitSet(new long[]{0x000000000040C000L});
    public static final BitSet FOLLOW_ruleClaimResult_in_ruleClaimResult1184 = new BitSet(new long[]{0x000000000040C000L});
    public static final BitSet FOLLOW_ruleVerificationResult_in_ruleClaimResult1206 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleClaimResult1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAggregateResultData_in_entryRuleAggregateResultData1255 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAggregateResultData1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleAggregateResultData1303 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAggregateResultData1320 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleAggregateResultData1339 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAggregateResultData1356 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleAggregateResultData1375 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAggregateResultData1392 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAggregateResultData1411 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAggregateResultData1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVerificationResultState1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVerificationResultState1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVerificationResultState1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVerificationResultState1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVerificationResultStatus1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVerificationResultStatus1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleVerificationResultStatus1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleVerificationResultStatus1633 = new BitSet(new long[]{0x0000000000000002L});

}

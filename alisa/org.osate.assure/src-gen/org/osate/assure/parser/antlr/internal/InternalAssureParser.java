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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'assurance'", "'case'", "'for'", "'['", "']'", "'verification'", "'result'", "'of'", "'output'", "'logfile'", "'date'", "'state'", "'status'", "'claim'", "'pass'", "'fail'", "'neutral'", "'unknown'", "'perform'", "'inprogress'", "'redo'", "'completed'"
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
    public static final int T__32=32;
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
        	return "AssuranceCase";	
       	}
       	
       	@Override
       	protected AssureGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleAssuranceCase"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:68:1: entryRuleAssuranceCase returns [EObject current=null] : iv_ruleAssuranceCase= ruleAssuranceCase EOF ;
    public final EObject entryRuleAssuranceCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssuranceCase = null;


        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:69:2: (iv_ruleAssuranceCase= ruleAssuranceCase EOF )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:70:2: iv_ruleAssuranceCase= ruleAssuranceCase EOF
            {
             newCompositeNode(grammarAccess.getAssuranceCaseRule()); 
            pushFollow(FOLLOW_ruleAssuranceCase_in_entryRuleAssuranceCase75);
            iv_ruleAssuranceCase=ruleAssuranceCase();

            state._fsp--;

             current =iv_ruleAssuranceCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssuranceCase85); 

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
    // $ANTLR end "entryRuleAssuranceCase"


    // $ANTLR start "ruleAssuranceCase"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:77:1: ruleAssuranceCase returns [EObject current=null] : (otherlv_0= 'assurance' otherlv_1= 'case' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' ( (lv_results_6_0= ruleAssuranceResult ) )+ otherlv_7= ']' ) ;
    public final EObject ruleAssuranceCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_results_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:80:28: ( (otherlv_0= 'assurance' otherlv_1= 'case' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' ( (lv_results_6_0= ruleAssuranceResult ) )+ otherlv_7= ']' ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:81:1: (otherlv_0= 'assurance' otherlv_1= 'case' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' ( (lv_results_6_0= ruleAssuranceResult ) )+ otherlv_7= ']' )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:81:1: (otherlv_0= 'assurance' otherlv_1= 'case' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' ( (lv_results_6_0= ruleAssuranceResult ) )+ otherlv_7= ']' )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:81:3: otherlv_0= 'assurance' otherlv_1= 'case' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' ( (lv_results_6_0= ruleAssuranceResult ) )+ otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleAssuranceCase122); 

                	newLeafNode(otherlv_0, grammarAccess.getAssuranceCaseAccess().getAssuranceKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleAssuranceCase134); 

                	newLeafNode(otherlv_1, grammarAccess.getAssuranceCaseAccess().getCaseKeyword_1());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:89:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:90:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:90:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:91:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceCase151); 

            			newLeafNode(lv_name_2_0, grammarAccess.getAssuranceCaseAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceCaseRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleAssuranceCase168); 

                	newLeafNode(otherlv_3, grammarAccess.getAssuranceCaseAccess().getForKeyword_3());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:111:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:112:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:112:1: (otherlv_4= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:113:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceCaseRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceCase188); 

            		newLeafNode(otherlv_4, grammarAccess.getAssuranceCaseAccess().getTargetSystemInstanceCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleAssuranceCase200); 

                	newLeafNode(otherlv_5, grammarAccess.getAssuranceCaseAccess().getLeftSquareBracketKeyword_5());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:128:1: ( (lv_results_6_0= ruleAssuranceResult ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16||LA1_0==24) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:129:1: (lv_results_6_0= ruleAssuranceResult )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:129:1: (lv_results_6_0= ruleAssuranceResult )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:130:3: lv_results_6_0= ruleAssuranceResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssuranceCaseAccess().getResultsAssuranceResultParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssuranceResult_in_ruleAssuranceCase221);
            	    lv_results_6_0=ruleAssuranceResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"results",
            	            		lv_results_6_0, 
            	            		"AssuranceResult");
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

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleAssuranceCase234); 

                	newLeafNode(otherlv_7, grammarAccess.getAssuranceCaseAccess().getRightSquareBracketKeyword_7());
                

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
    // $ANTLR end "ruleAssuranceCase"


    // $ANTLR start "entryRuleVerificationResult"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:158:1: entryRuleVerificationResult returns [EObject current=null] : iv_ruleVerificationResult= ruleVerificationResult EOF ;
    public final EObject entryRuleVerificationResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationResult = null;


        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:159:2: (iv_ruleVerificationResult= ruleVerificationResult EOF )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:160:2: iv_ruleVerificationResult= ruleVerificationResult EOF
            {
             newCompositeNode(grammarAccess.getVerificationResultRule()); 
            pushFollow(FOLLOW_ruleVerificationResult_in_entryRuleVerificationResult270);
            iv_ruleVerificationResult=ruleVerificationResult();

            state._fsp--;

             current =iv_ruleVerificationResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationResult280); 

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
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:167:1: ruleVerificationResult returns [EObject current=null] : (otherlv_0= 'verification' otherlv_1= 'result' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) ) ( (lv_assumptionVerificationResult_17_0= ruleVerificationResult ) )* otherlv_18= ']' ) ;
    public final EObject ruleVerificationResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_title_8_0=null;
        Token otherlv_9=null;
        Token lv_description_10_0=null;
        Token otherlv_11=null;
        Token lv_method_12_0=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_18=null;
        Enumerator lv_state_14_0 = null;

        Enumerator lv_status_16_0 = null;

        EObject lv_assumptionVerificationResult_17_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:170:28: ( (otherlv_0= 'verification' otherlv_1= 'result' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) ) ( (lv_assumptionVerificationResult_17_0= ruleVerificationResult ) )* otherlv_18= ']' ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:171:1: (otherlv_0= 'verification' otherlv_1= 'result' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) ) ( (lv_assumptionVerificationResult_17_0= ruleVerificationResult ) )* otherlv_18= ']' )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:171:1: (otherlv_0= 'verification' otherlv_1= 'result' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) ) ( (lv_assumptionVerificationResult_17_0= ruleVerificationResult ) )* otherlv_18= ']' )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:171:3: otherlv_0= 'verification' otherlv_1= 'result' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) ) ( (lv_assumptionVerificationResult_17_0= ruleVerificationResult ) )* otherlv_18= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVerificationResult317); 

                	newLeafNode(otherlv_0, grammarAccess.getVerificationResultAccess().getVerificationKeyword_0());
                
            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleVerificationResult329); 

                	newLeafNode(otherlv_1, grammarAccess.getVerificationResultAccess().getResultKeyword_1());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:179:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:180:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:180:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:181:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationResult346); 

            			newLeafNode(lv_name_2_0, grammarAccess.getVerificationResultAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVerificationResultRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleVerificationResult363); 

                	newLeafNode(otherlv_3, grammarAccess.getVerificationResultAccess().getOfKeyword_3());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:201:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:202:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:202:1: (otherlv_4= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:203:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVerificationResultRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationResult383); 

            		newLeafNode(otherlv_4, grammarAccess.getVerificationResultAccess().getVerificationActivityVerificationActivityCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleVerificationResult395); 

                	newLeafNode(otherlv_5, grammarAccess.getVerificationResultAccess().getLeftSquareBracketKeyword_5());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:218:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:220:1: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:220:1: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )* ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:221:2: ( ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6());
            	
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:224:2: ( ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )* )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:225:3: ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )*
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:225:3: ( ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) ) )*
            loop2:
            do {
                int alt2=6;
                int LA2_0 = input.LA(1);

                if ( LA2_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 0) ) {
                    alt2=1;
                }
                else if ( LA2_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 1) ) {
                    alt2=2;
                }
                else if ( LA2_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 2) ) {
                    alt2=3;
                }
                else if ( LA2_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 3) ) {
                    alt2=4;
                }
                else if ( LA2_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 4) ) {
                    alt2=5;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:227:4: ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:227:4: ({...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:228:5: {...}? => ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 0)");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:228:115: ( ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:229:6: ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 0);
            	    	 				
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:232:6: ({...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:232:7: {...}? => (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "true");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:232:16: (otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:232:18: otherlv_7= 'output' ( (lv_title_8_0= RULE_STRING ) )
            	    {
            	    otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleVerificationResult453); 

            	        	newLeafNode(otherlv_7, grammarAccess.getVerificationResultAccess().getOutputKeyword_6_0_0());
            	        
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:236:1: ( (lv_title_8_0= RULE_STRING ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:237:1: (lv_title_8_0= RULE_STRING )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:237:1: (lv_title_8_0= RULE_STRING )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:238:3: lv_title_8_0= RULE_STRING
            	    {
            	    lv_title_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVerificationResult470); 

            	    			newLeafNode(lv_title_8_0, grammarAccess.getVerificationResultAccess().getTitleSTRINGTerminalRuleCall_6_0_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getVerificationResultRule());
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:261:4: ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:261:4: ({...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:262:5: {...}? => ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 1)");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:262:115: ( ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:263:6: ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 1);
            	    	 				
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:266:6: ({...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:266:7: {...}? => (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "true");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:266:16: (otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:266:18: otherlv_9= 'logfile' ( (lv_description_10_0= RULE_STRING ) )
            	    {
            	    otherlv_9=(Token)match(input,20,FOLLOW_20_in_ruleVerificationResult543); 

            	        	newLeafNode(otherlv_9, grammarAccess.getVerificationResultAccess().getLogfileKeyword_6_1_0());
            	        
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:270:1: ( (lv_description_10_0= RULE_STRING ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:271:1: (lv_description_10_0= RULE_STRING )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:271:1: (lv_description_10_0= RULE_STRING )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:272:3: lv_description_10_0= RULE_STRING
            	    {
            	    lv_description_10_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVerificationResult560); 

            	    			newLeafNode(lv_description_10_0, grammarAccess.getVerificationResultAccess().getDescriptionSTRINGTerminalRuleCall_6_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getVerificationResultRule());
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:295:4: ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:295:4: ({...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:296:5: {...}? => ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 2)");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:296:115: ( ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:297:6: ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 2);
            	    	 				
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:300:6: ({...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:300:7: {...}? => (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "true");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:300:16: (otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:300:18: otherlv_11= 'date' ( (lv_method_12_0= RULE_STRING ) )
            	    {
            	    otherlv_11=(Token)match(input,21,FOLLOW_21_in_ruleVerificationResult633); 

            	        	newLeafNode(otherlv_11, grammarAccess.getVerificationResultAccess().getDateKeyword_6_2_0());
            	        
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:304:1: ( (lv_method_12_0= RULE_STRING ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:305:1: (lv_method_12_0= RULE_STRING )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:305:1: (lv_method_12_0= RULE_STRING )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:306:3: lv_method_12_0= RULE_STRING
            	    {
            	    lv_method_12_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVerificationResult650); 

            	    			newLeafNode(lv_method_12_0, grammarAccess.getVerificationResultAccess().getMethodSTRINGTerminalRuleCall_6_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getVerificationResultRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"method",
            	            		lv_method_12_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:329:4: ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:329:4: ({...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:330:5: {...}? => ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 3)");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:330:115: ( ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:331:6: ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 3);
            	    	 				
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:334:6: ({...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:334:7: {...}? => (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "true");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:334:16: (otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:334:18: otherlv_13= 'state' ( (lv_state_14_0= ruleVerificationResultState ) )
            	    {
            	    otherlv_13=(Token)match(input,22,FOLLOW_22_in_ruleVerificationResult723); 

            	        	newLeafNode(otherlv_13, grammarAccess.getVerificationResultAccess().getStateKeyword_6_3_0());
            	        
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:338:1: ( (lv_state_14_0= ruleVerificationResultState ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:339:1: (lv_state_14_0= ruleVerificationResultState )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:339:1: (lv_state_14_0= ruleVerificationResultState )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:340:3: lv_state_14_0= ruleVerificationResultState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVerificationResultAccess().getStateVerificationResultStateEnumRuleCall_6_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationResultState_in_ruleVerificationResult744);
            	    lv_state_14_0=ruleVerificationResultState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVerificationResultRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"state",
            	            		lv_state_14_0, 
            	            		"VerificationResultState");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:363:4: ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:363:4: ({...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:364:5: {...}? => ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "getUnorderedGroupHelper().canSelect(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 4)");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:364:115: ( ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:365:6: ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6(), 4);
            	    	 				
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:368:6: ({...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:368:7: {...}? => (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleVerificationResult", "true");
            	    }
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:368:16: (otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:368:18: otherlv_15= 'status' ( (lv_status_16_0= ruleVerificationResultStatus ) )
            	    {
            	    otherlv_15=(Token)match(input,23,FOLLOW_23_in_ruleVerificationResult812); 

            	        	newLeafNode(otherlv_15, grammarAccess.getVerificationResultAccess().getStatusKeyword_6_4_0());
            	        
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:372:1: ( (lv_status_16_0= ruleVerificationResultStatus ) )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:373:1: (lv_status_16_0= ruleVerificationResultStatus )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:373:1: (lv_status_16_0= ruleVerificationResultStatus )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:374:3: lv_status_16_0= ruleVerificationResultStatus
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVerificationResultAccess().getStatusVerificationResultStatusEnumRuleCall_6_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationResultStatus_in_ruleVerificationResult833);
            	    lv_status_16_0=ruleVerificationResultStatus();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVerificationResultRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"status",
            	            		lv_status_16_0, 
            	            		"VerificationResultStatus");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6());
            	    	 				

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

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getVerificationResultAccess().getUnorderedGroup_6());
            	

            }

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:404:2: ( (lv_assumptionVerificationResult_17_0= ruleVerificationResult ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:405:1: (lv_assumptionVerificationResult_17_0= ruleVerificationResult )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:405:1: (lv_assumptionVerificationResult_17_0= ruleVerificationResult )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:406:3: lv_assumptionVerificationResult_17_0= ruleVerificationResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVerificationResultAccess().getAssumptionVerificationResultVerificationResultParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationResult_in_ruleVerificationResult895);
            	    lv_assumptionVerificationResult_17_0=ruleVerificationResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVerificationResultRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"assumptionVerificationResult",
            	            		lv_assumptionVerificationResult_17_0, 
            	            		"VerificationResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_18=(Token)match(input,15,FOLLOW_15_in_ruleVerificationResult908); 

                	newLeafNode(otherlv_18, grammarAccess.getVerificationResultAccess().getRightSquareBracketKeyword_8());
                

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
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:434:1: entryRuleClaimResult returns [EObject current=null] : iv_ruleClaimResult= ruleClaimResult EOF ;
    public final EObject entryRuleClaimResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimResult = null;


        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:435:2: (iv_ruleClaimResult= ruleClaimResult EOF )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:436:2: iv_ruleClaimResult= ruleClaimResult EOF
            {
             newCompositeNode(grammarAccess.getClaimResultRule()); 
            pushFollow(FOLLOW_ruleClaimResult_in_entryRuleClaimResult944);
            iv_ruleClaimResult=ruleClaimResult();

            state._fsp--;

             current =iv_ruleClaimResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClaimResult954); 

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
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:443:1: ruleClaimResult returns [EObject current=null] : (otherlv_0= 'claim' otherlv_1= 'result' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' (otherlv_6= 'pass' ( (lv_passCount_7_0= RULE_INT ) ) ) (otherlv_8= 'fail' ( (lv_failCount_9_0= RULE_INT ) ) ) (otherlv_10= 'neutral' ( (lv_neutralCount_11_0= RULE_INT ) ) ) (otherlv_12= 'unknown' ( (lv_unknownCount_13_0= RULE_INT ) ) ) ( (lv_subClaimResult_14_0= ruleClaimResult ) )* ( (lv_subVAResult_15_0= ruleVerificationResult ) )* otherlv_16= ']' ) ;
    public final EObject ruleClaimResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_passCount_7_0=null;
        Token otherlv_8=null;
        Token lv_failCount_9_0=null;
        Token otherlv_10=null;
        Token lv_neutralCount_11_0=null;
        Token otherlv_12=null;
        Token lv_unknownCount_13_0=null;
        Token otherlv_16=null;
        EObject lv_subClaimResult_14_0 = null;

        EObject lv_subVAResult_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:446:28: ( (otherlv_0= 'claim' otherlv_1= 'result' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' (otherlv_6= 'pass' ( (lv_passCount_7_0= RULE_INT ) ) ) (otherlv_8= 'fail' ( (lv_failCount_9_0= RULE_INT ) ) ) (otherlv_10= 'neutral' ( (lv_neutralCount_11_0= RULE_INT ) ) ) (otherlv_12= 'unknown' ( (lv_unknownCount_13_0= RULE_INT ) ) ) ( (lv_subClaimResult_14_0= ruleClaimResult ) )* ( (lv_subVAResult_15_0= ruleVerificationResult ) )* otherlv_16= ']' ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:447:1: (otherlv_0= 'claim' otherlv_1= 'result' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' (otherlv_6= 'pass' ( (lv_passCount_7_0= RULE_INT ) ) ) (otherlv_8= 'fail' ( (lv_failCount_9_0= RULE_INT ) ) ) (otherlv_10= 'neutral' ( (lv_neutralCount_11_0= RULE_INT ) ) ) (otherlv_12= 'unknown' ( (lv_unknownCount_13_0= RULE_INT ) ) ) ( (lv_subClaimResult_14_0= ruleClaimResult ) )* ( (lv_subVAResult_15_0= ruleVerificationResult ) )* otherlv_16= ']' )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:447:1: (otherlv_0= 'claim' otherlv_1= 'result' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' (otherlv_6= 'pass' ( (lv_passCount_7_0= RULE_INT ) ) ) (otherlv_8= 'fail' ( (lv_failCount_9_0= RULE_INT ) ) ) (otherlv_10= 'neutral' ( (lv_neutralCount_11_0= RULE_INT ) ) ) (otherlv_12= 'unknown' ( (lv_unknownCount_13_0= RULE_INT ) ) ) ( (lv_subClaimResult_14_0= ruleClaimResult ) )* ( (lv_subVAResult_15_0= ruleVerificationResult ) )* otherlv_16= ']' )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:447:3: otherlv_0= 'claim' otherlv_1= 'result' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) otherlv_5= '[' (otherlv_6= 'pass' ( (lv_passCount_7_0= RULE_INT ) ) ) (otherlv_8= 'fail' ( (lv_failCount_9_0= RULE_INT ) ) ) (otherlv_10= 'neutral' ( (lv_neutralCount_11_0= RULE_INT ) ) ) (otherlv_12= 'unknown' ( (lv_unknownCount_13_0= RULE_INT ) ) ) ( (lv_subClaimResult_14_0= ruleClaimResult ) )* ( (lv_subVAResult_15_0= ruleVerificationResult ) )* otherlv_16= ']'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleClaimResult991); 

                	newLeafNode(otherlv_0, grammarAccess.getClaimResultAccess().getClaimKeyword_0());
                
            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleClaimResult1003); 

                	newLeafNode(otherlv_1, grammarAccess.getClaimResultAccess().getResultKeyword_1());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:455:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:456:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:456:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:457:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClaimResult1020); 

            			newLeafNode(lv_name_2_0, grammarAccess.getClaimResultAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClaimResultRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleClaimResult1037); 

                	newLeafNode(otherlv_3, grammarAccess.getClaimResultAccess().getOfKeyword_3());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:477:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:478:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:478:1: (otherlv_4= RULE_ID )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:479:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getClaimResultRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClaimResult1057); 

            		newLeafNode(otherlv_4, grammarAccess.getClaimResultAccess().getRequirementRequirementCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleClaimResult1069); 

                	newLeafNode(otherlv_5, grammarAccess.getClaimResultAccess().getLeftSquareBracketKeyword_5());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:494:1: (otherlv_6= 'pass' ( (lv_passCount_7_0= RULE_INT ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:494:3: otherlv_6= 'pass' ( (lv_passCount_7_0= RULE_INT ) )
            {
            otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleClaimResult1082); 

                	newLeafNode(otherlv_6, grammarAccess.getClaimResultAccess().getPassKeyword_6_0());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:498:1: ( (lv_passCount_7_0= RULE_INT ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:499:1: (lv_passCount_7_0= RULE_INT )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:499:1: (lv_passCount_7_0= RULE_INT )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:500:3: lv_passCount_7_0= RULE_INT
            {
            lv_passCount_7_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClaimResult1099); 

            			newLeafNode(lv_passCount_7_0, grammarAccess.getClaimResultAccess().getPassCountINTTerminalRuleCall_6_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClaimResultRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"passCount",
                    		lv_passCount_7_0, 
                    		"INT");
            	    

            }


            }


            }

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:516:3: (otherlv_8= 'fail' ( (lv_failCount_9_0= RULE_INT ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:516:5: otherlv_8= 'fail' ( (lv_failCount_9_0= RULE_INT ) )
            {
            otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleClaimResult1118); 

                	newLeafNode(otherlv_8, grammarAccess.getClaimResultAccess().getFailKeyword_7_0());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:520:1: ( (lv_failCount_9_0= RULE_INT ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:521:1: (lv_failCount_9_0= RULE_INT )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:521:1: (lv_failCount_9_0= RULE_INT )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:522:3: lv_failCount_9_0= RULE_INT
            {
            lv_failCount_9_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClaimResult1135); 

            			newLeafNode(lv_failCount_9_0, grammarAccess.getClaimResultAccess().getFailCountINTTerminalRuleCall_7_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClaimResultRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"failCount",
                    		lv_failCount_9_0, 
                    		"INT");
            	    

            }


            }


            }

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:538:3: (otherlv_10= 'neutral' ( (lv_neutralCount_11_0= RULE_INT ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:538:5: otherlv_10= 'neutral' ( (lv_neutralCount_11_0= RULE_INT ) )
            {
            otherlv_10=(Token)match(input,27,FOLLOW_27_in_ruleClaimResult1154); 

                	newLeafNode(otherlv_10, grammarAccess.getClaimResultAccess().getNeutralKeyword_8_0());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:542:1: ( (lv_neutralCount_11_0= RULE_INT ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:543:1: (lv_neutralCount_11_0= RULE_INT )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:543:1: (lv_neutralCount_11_0= RULE_INT )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:544:3: lv_neutralCount_11_0= RULE_INT
            {
            lv_neutralCount_11_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClaimResult1171); 

            			newLeafNode(lv_neutralCount_11_0, grammarAccess.getClaimResultAccess().getNeutralCountINTTerminalRuleCall_8_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClaimResultRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"neutralCount",
                    		lv_neutralCount_11_0, 
                    		"INT");
            	    

            }


            }


            }

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:560:3: (otherlv_12= 'unknown' ( (lv_unknownCount_13_0= RULE_INT ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:560:5: otherlv_12= 'unknown' ( (lv_unknownCount_13_0= RULE_INT ) )
            {
            otherlv_12=(Token)match(input,28,FOLLOW_28_in_ruleClaimResult1190); 

                	newLeafNode(otherlv_12, grammarAccess.getClaimResultAccess().getUnknownKeyword_9_0());
                
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:564:1: ( (lv_unknownCount_13_0= RULE_INT ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:565:1: (lv_unknownCount_13_0= RULE_INT )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:565:1: (lv_unknownCount_13_0= RULE_INT )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:566:3: lv_unknownCount_13_0= RULE_INT
            {
            lv_unknownCount_13_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleClaimResult1207); 

            			newLeafNode(lv_unknownCount_13_0, grammarAccess.getClaimResultAccess().getUnknownCountINTTerminalRuleCall_9_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClaimResultRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"unknownCount",
                    		lv_unknownCount_13_0, 
                    		"INT");
            	    

            }


            }


            }

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:582:3: ( (lv_subClaimResult_14_0= ruleClaimResult ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==24) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:583:1: (lv_subClaimResult_14_0= ruleClaimResult )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:583:1: (lv_subClaimResult_14_0= ruleClaimResult )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:584:3: lv_subClaimResult_14_0= ruleClaimResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClaimResultAccess().getSubClaimResultClaimResultParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleClaimResult_in_ruleClaimResult1234);
            	    lv_subClaimResult_14_0=ruleClaimResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClaimResultRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subClaimResult",
            	            		lv_subClaimResult_14_0, 
            	            		"ClaimResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:600:3: ( (lv_subVAResult_15_0= ruleVerificationResult ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:601:1: (lv_subVAResult_15_0= ruleVerificationResult )
            	    {
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:601:1: (lv_subVAResult_15_0= ruleVerificationResult )
            	    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:602:3: lv_subVAResult_15_0= ruleVerificationResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClaimResultAccess().getSubVAResultVerificationResultParserRuleCall_11_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationResult_in_ruleClaimResult1256);
            	    lv_subVAResult_15_0=ruleVerificationResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClaimResultRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subVAResult",
            	            		lv_subVAResult_15_0, 
            	            		"VerificationResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_16=(Token)match(input,15,FOLLOW_15_in_ruleClaimResult1269); 

                	newLeafNode(otherlv_16, grammarAccess.getClaimResultAccess().getRightSquareBracketKeyword_12());
                

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


    // $ANTLR start "entryRuleAssuranceResult"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:630:1: entryRuleAssuranceResult returns [EObject current=null] : iv_ruleAssuranceResult= ruleAssuranceResult EOF ;
    public final EObject entryRuleAssuranceResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssuranceResult = null;


        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:631:2: (iv_ruleAssuranceResult= ruleAssuranceResult EOF )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:632:2: iv_ruleAssuranceResult= ruleAssuranceResult EOF
            {
             newCompositeNode(grammarAccess.getAssuranceResultRule()); 
            pushFollow(FOLLOW_ruleAssuranceResult_in_entryRuleAssuranceResult1305);
            iv_ruleAssuranceResult=ruleAssuranceResult();

            state._fsp--;

             current =iv_ruleAssuranceResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssuranceResult1315); 

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
    // $ANTLR end "entryRuleAssuranceResult"


    // $ANTLR start "ruleAssuranceResult"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:639:1: ruleAssuranceResult returns [EObject current=null] : (this_VerificationResult_0= ruleVerificationResult | this_ClaimResult_1= ruleClaimResult ) ;
    public final EObject ruleAssuranceResult() throws RecognitionException {
        EObject current = null;

        EObject this_VerificationResult_0 = null;

        EObject this_ClaimResult_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:642:28: ( (this_VerificationResult_0= ruleVerificationResult | this_ClaimResult_1= ruleClaimResult ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:643:1: (this_VerificationResult_0= ruleVerificationResult | this_ClaimResult_1= ruleClaimResult )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:643:1: (this_VerificationResult_0= ruleVerificationResult | this_ClaimResult_1= ruleClaimResult )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==24) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:644:5: this_VerificationResult_0= ruleVerificationResult
                    {
                     
                            newCompositeNode(grammarAccess.getAssuranceResultAccess().getVerificationResultParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVerificationResult_in_ruleAssuranceResult1362);
                    this_VerificationResult_0=ruleVerificationResult();

                    state._fsp--;

                     
                            current = this_VerificationResult_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:654:5: this_ClaimResult_1= ruleClaimResult
                    {
                     
                            newCompositeNode(grammarAccess.getAssuranceResultAccess().getClaimResultParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleClaimResult_in_ruleAssuranceResult1389);
                    this_ClaimResult_1=ruleClaimResult();

                    state._fsp--;

                     
                            current = this_ClaimResult_1; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleAssuranceResult"


    // $ANTLR start "ruleVerificationResultState"
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:670:1: ruleVerificationResultState returns [Enumerator current=null] : ( (enumLiteral_0= 'perform' ) | (enumLiteral_1= 'inprogress' ) | (enumLiteral_2= 'redo' ) | (enumLiteral_3= 'completed' ) ) ;
    public final Enumerator ruleVerificationResultState() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:672:28: ( ( (enumLiteral_0= 'perform' ) | (enumLiteral_1= 'inprogress' ) | (enumLiteral_2= 'redo' ) | (enumLiteral_3= 'completed' ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:673:1: ( (enumLiteral_0= 'perform' ) | (enumLiteral_1= 'inprogress' ) | (enumLiteral_2= 'redo' ) | (enumLiteral_3= 'completed' ) )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:673:1: ( (enumLiteral_0= 'perform' ) | (enumLiteral_1= 'inprogress' ) | (enumLiteral_2= 'redo' ) | (enumLiteral_3= 'completed' ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt7=1;
                }
                break;
            case 30:
                {
                alt7=2;
                }
                break;
            case 31:
                {
                alt7=3;
                }
                break;
            case 32:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:673:2: (enumLiteral_0= 'perform' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:673:2: (enumLiteral_0= 'perform' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:673:4: enumLiteral_0= 'perform'
                    {
                    enumLiteral_0=(Token)match(input,29,FOLLOW_29_in_ruleVerificationResultState1438); 

                            current = grammarAccess.getVerificationResultStateAccess().getPERFORMEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVerificationResultStateAccess().getPERFORMEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:679:6: (enumLiteral_1= 'inprogress' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:679:6: (enumLiteral_1= 'inprogress' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:679:8: enumLiteral_1= 'inprogress'
                    {
                    enumLiteral_1=(Token)match(input,30,FOLLOW_30_in_ruleVerificationResultState1455); 

                            current = grammarAccess.getVerificationResultStateAccess().getINPROGRESSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVerificationResultStateAccess().getINPROGRESSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:685:6: (enumLiteral_2= 'redo' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:685:6: (enumLiteral_2= 'redo' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:685:8: enumLiteral_2= 'redo'
                    {
                    enumLiteral_2=(Token)match(input,31,FOLLOW_31_in_ruleVerificationResultState1472); 

                            current = grammarAccess.getVerificationResultStateAccess().getREDOEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVerificationResultStateAccess().getREDOEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:691:6: (enumLiteral_3= 'completed' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:691:6: (enumLiteral_3= 'completed' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:691:8: enumLiteral_3= 'completed'
                    {
                    enumLiteral_3=(Token)match(input,32,FOLLOW_32_in_ruleVerificationResultState1489); 

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
    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:701:1: ruleVerificationResultStatus returns [Enumerator current=null] : ( (enumLiteral_0= 'unknown' ) | (enumLiteral_1= 'pass' ) | (enumLiteral_2= 'fail' ) | (enumLiteral_3= 'neutral' ) ) ;
    public final Enumerator ruleVerificationResultStatus() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:703:28: ( ( (enumLiteral_0= 'unknown' ) | (enumLiteral_1= 'pass' ) | (enumLiteral_2= 'fail' ) | (enumLiteral_3= 'neutral' ) ) )
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:704:1: ( (enumLiteral_0= 'unknown' ) | (enumLiteral_1= 'pass' ) | (enumLiteral_2= 'fail' ) | (enumLiteral_3= 'neutral' ) )
            {
            // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:704:1: ( (enumLiteral_0= 'unknown' ) | (enumLiteral_1= 'pass' ) | (enumLiteral_2= 'fail' ) | (enumLiteral_3= 'neutral' ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt8=1;
                }
                break;
            case 25:
                {
                alt8=2;
                }
                break;
            case 26:
                {
                alt8=3;
                }
                break;
            case 27:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:704:2: (enumLiteral_0= 'unknown' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:704:2: (enumLiteral_0= 'unknown' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:704:4: enumLiteral_0= 'unknown'
                    {
                    enumLiteral_0=(Token)match(input,28,FOLLOW_28_in_ruleVerificationResultStatus1534); 

                            current = grammarAccess.getVerificationResultStatusAccess().getUNKNOWNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVerificationResultStatusAccess().getUNKNOWNEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:710:6: (enumLiteral_1= 'pass' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:710:6: (enumLiteral_1= 'pass' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:710:8: enumLiteral_1= 'pass'
                    {
                    enumLiteral_1=(Token)match(input,25,FOLLOW_25_in_ruleVerificationResultStatus1551); 

                            current = grammarAccess.getVerificationResultStatusAccess().getPASSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVerificationResultStatusAccess().getPASSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:716:6: (enumLiteral_2= 'fail' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:716:6: (enumLiteral_2= 'fail' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:716:8: enumLiteral_2= 'fail'
                    {
                    enumLiteral_2=(Token)match(input,26,FOLLOW_26_in_ruleVerificationResultStatus1568); 

                            current = grammarAccess.getVerificationResultStatusAccess().getFAILEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVerificationResultStatusAccess().getFAILEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:722:6: (enumLiteral_3= 'neutral' )
                    {
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:722:6: (enumLiteral_3= 'neutral' )
                    // ../org.osate.assure/src-gen/org/osate/assure/parser/antlr/internal/InternalAssure.g:722:8: enumLiteral_3= 'neutral'
                    {
                    enumLiteral_3=(Token)match(input,27,FOLLOW_27_in_ruleVerificationResultStatus1585); 

                            current = grammarAccess.getVerificationResultStatusAccess().getNEUTRALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVerificationResultStatusAccess().getNEUTRALEnumLiteralDeclaration_3()); 
                        

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


 

    public static final BitSet FOLLOW_ruleAssuranceCase_in_entryRuleAssuranceCase75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssuranceCase85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleAssuranceCase122 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAssuranceCase134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceCase151 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleAssuranceCase168 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceCase188 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAssuranceCase200 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_ruleAssuranceResult_in_ruleAssuranceCase221 = new BitSet(new long[]{0x0000000001018000L});
    public static final BitSet FOLLOW_15_in_ruleAssuranceCase234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationResult_in_entryRuleVerificationResult270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationResult280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVerificationResult317 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVerificationResult329 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationResult346 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleVerificationResult363 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationResult383 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVerificationResult395 = new BitSet(new long[]{0x0000000000F98000L});
    public static final BitSet FOLLOW_19_in_ruleVerificationResult453 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVerificationResult470 = new BitSet(new long[]{0x0000000000F98000L});
    public static final BitSet FOLLOW_20_in_ruleVerificationResult543 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVerificationResult560 = new BitSet(new long[]{0x0000000000F98000L});
    public static final BitSet FOLLOW_21_in_ruleVerificationResult633 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVerificationResult650 = new BitSet(new long[]{0x0000000000F98000L});
    public static final BitSet FOLLOW_22_in_ruleVerificationResult723 = new BitSet(new long[]{0x00000001E0000000L});
    public static final BitSet FOLLOW_ruleVerificationResultState_in_ruleVerificationResult744 = new BitSet(new long[]{0x0000000000F98000L});
    public static final BitSet FOLLOW_23_in_ruleVerificationResult812 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_ruleVerificationResultStatus_in_ruleVerificationResult833 = new BitSet(new long[]{0x0000000000F98000L});
    public static final BitSet FOLLOW_ruleVerificationResult_in_ruleVerificationResult895 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleVerificationResult908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClaimResult_in_entryRuleClaimResult944 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClaimResult954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleClaimResult991 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleClaimResult1003 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClaimResult1020 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleClaimResult1037 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClaimResult1057 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleClaimResult1069 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleClaimResult1082 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClaimResult1099 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleClaimResult1118 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClaimResult1135 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleClaimResult1154 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClaimResult1171 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleClaimResult1190 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleClaimResult1207 = new BitSet(new long[]{0x0000000001018000L});
    public static final BitSet FOLLOW_ruleClaimResult_in_ruleClaimResult1234 = new BitSet(new long[]{0x0000000001018000L});
    public static final BitSet FOLLOW_ruleVerificationResult_in_ruleClaimResult1256 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleClaimResult1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssuranceResult_in_entryRuleAssuranceResult1305 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssuranceResult1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationResult_in_ruleAssuranceResult1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClaimResult_in_ruleAssuranceResult1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVerificationResultState1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVerificationResultState1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVerificationResultState1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleVerificationResultState1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVerificationResultStatus1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVerificationResultStatus1551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleVerificationResultStatus1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVerificationResultStatus1585 = new BitSet(new long[]{0x0000000000000002L});

}

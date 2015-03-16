package org.osate.results.parser.antlr.internal; 

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
import org.osate.results.services.ResultsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalResultsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'reports'", "':'", "'['", "'target'", "'description'", "'issues'", "']'", "'report'", "'heading'", "'results'", "'contributor'", "'data'", "'='", "'error'", "'warning'", "'success'", "'info'"
    };
    public static final int RULE_ID=4;
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


        public InternalResultsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalResultsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalResultsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g"; }



     	private ResultsGrammarAccess grammarAccess;
     	
        public InternalResultsParser(TokenStream input, ResultsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ResultReports";	
       	}
       	
       	@Override
       	protected ResultsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleResultReports"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:68:1: entryRuleResultReports returns [EObject current=null] : iv_ruleResultReports= ruleResultReports EOF ;
    public final EObject entryRuleResultReports() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReports = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:69:2: (iv_ruleResultReports= ruleResultReports EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:70:2: iv_ruleResultReports= ruleResultReports EOF
            {
             newCompositeNode(grammarAccess.getResultReportsRule()); 
            pushFollow(FOLLOW_ruleResultReports_in_entryRuleResultReports75);
            iv_ruleResultReports=ruleResultReports();

            state._fsp--;

             current =iv_ruleResultReports; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReports85); 

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
    // $ANTLR end "entryRuleResultReports"


    // $ANTLR start "ruleResultReports"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:77:1: ruleResultReports returns [EObject current=null] : (this_ResultReport_0= ruleResultReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport ) ;
    public final EObject ruleResultReports() throws RecognitionException {
        EObject current = null;

        EObject this_ResultReport_0 = null;

        EObject this_ResultReportCollection_1 = null;

        EObject this_IssuesReport_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:80:28: ( (this_ResultReport_0= ruleResultReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:81:1: (this_ResultReport_0= ruleResultReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:81:1: (this_ResultReport_0= ruleResultReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt1=1;
                }
                break;
            case 11:
                {
                alt1=2;
                }
                break;
            case 16:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:82:5: this_ResultReport_0= ruleResultReport
                    {
                     
                            newCompositeNode(grammarAccess.getResultReportsAccess().getResultReportParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleResultReport_in_ruleResultReports132);
                    this_ResultReport_0=ruleResultReport();

                    state._fsp--;

                     
                            current = this_ResultReport_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:92:5: this_ResultReportCollection_1= ruleResultReportCollection
                    {
                     
                            newCompositeNode(grammarAccess.getResultReportsAccess().getResultReportCollectionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleResultReportCollection_in_ruleResultReports159);
                    this_ResultReportCollection_1=ruleResultReportCollection();

                    state._fsp--;

                     
                            current = this_ResultReportCollection_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:102:5: this_IssuesReport_2= ruleIssuesReport
                    {
                     
                            newCompositeNode(grammarAccess.getResultReportsAccess().getIssuesReportParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleIssuesReport_in_ruleResultReports186);
                    this_IssuesReport_2=ruleIssuesReport();

                    state._fsp--;

                     
                            current = this_IssuesReport_2; 
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
    // $ANTLR end "ruleResultReports"


    // $ANTLR start "entryRuleResultReportCollection"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:118:1: entryRuleResultReportCollection returns [EObject current=null] : iv_ruleResultReportCollection= ruleResultReportCollection EOF ;
    public final EObject entryRuleResultReportCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReportCollection = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:119:2: (iv_ruleResultReportCollection= ruleResultReportCollection EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:120:2: iv_ruleResultReportCollection= ruleResultReportCollection EOF
            {
             newCompositeNode(grammarAccess.getResultReportCollectionRule()); 
            pushFollow(FOLLOW_ruleResultReportCollection_in_entryRuleResultReportCollection221);
            iv_ruleResultReportCollection=ruleResultReportCollection();

            state._fsp--;

             current =iv_ruleResultReportCollection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReportCollection231); 

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
    // $ANTLR end "entryRuleResultReportCollection"


    // $ANTLR start "ruleResultReportCollection"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:127:1: ruleResultReportCollection returns [EObject current=null] : (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* (otherlv_10= 'issues' ( (lv_issues_11_0= ruleReportIssue ) )* )? otherlv_12= ']' ) ;
    public final EObject ruleResultReportCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_decription_8_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_content_9_0 = null;

        EObject lv_issues_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:130:28: ( (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* (otherlv_10= 'issues' ( (lv_issues_11_0= ruleReportIssue ) )* )? otherlv_12= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:131:1: (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* (otherlv_10= 'issues' ( (lv_issues_11_0= ruleReportIssue ) )* )? otherlv_12= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:131:1: (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* (otherlv_10= 'issues' ( (lv_issues_11_0= ruleReportIssue ) )* )? otherlv_12= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:131:3: otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* (otherlv_10= 'issues' ( (lv_issues_11_0= ruleReportIssue ) )* )? otherlv_12= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleResultReportCollection268); 

                	newLeafNode(otherlv_0, grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:135:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:136:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:136:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:137:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultReportCollection285); 

            			newLeafNode(lv_name_1_0, grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResultReportCollectionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:153:2: (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:153:4: otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleResultReportCollection303); 

                        	newLeafNode(otherlv_2, grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:157:1: ( (lv_title_3_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:158:1: (lv_title_3_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:158:1: (lv_title_3_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:159:3: lv_title_3_0= RULE_STRING
                    {
                    lv_title_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReportCollection320); 

                    			newLeafNode(lv_title_3_0, grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportCollectionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleResultReportCollection339); 

                	newLeafNode(otherlv_4, grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_3());
                
            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleResultReportCollection351); 

                	newLeafNode(otherlv_5, grammarAccess.getResultReportCollectionAccess().getTargetKeyword_4());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:183:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:184:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:184:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:185:3: ruleURIID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getResultReportCollectionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleURIID_in_ruleResultReportCollection374);
            ruleURIID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:198:2: (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:198:4: otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleResultReportCollection387); 

                        	newLeafNode(otherlv_7, grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:202:1: ( (lv_decription_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:203:1: (lv_decription_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:203:1: (lv_decription_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:204:3: lv_decription_8_0= RULE_STRING
                    {
                    lv_decription_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReportCollection404); 

                    			newLeafNode(lv_decription_8_0, grammarAccess.getResultReportCollectionAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportCollectionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"decription",
                            		lv_decription_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:220:4: ( (lv_content_9_0= ruleResultReport ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:221:1: (lv_content_9_0= ruleResultReport )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:221:1: (lv_content_9_0= ruleResultReport )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:222:3: lv_content_9_0= ruleResultReport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleResultReport_in_ruleResultReportCollection432);
            	    lv_content_9_0=ruleResultReport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getResultReportCollectionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"content",
            	            		lv_content_9_0, 
            	            		"ResultReport");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:238:3: (otherlv_10= 'issues' ( (lv_issues_11_0= ruleReportIssue ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:238:5: otherlv_10= 'issues' ( (lv_issues_11_0= ruleReportIssue ) )*
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleResultReportCollection446); 

                        	newLeafNode(otherlv_10, grammarAccess.getResultReportCollectionAccess().getIssuesKeyword_8_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:242:1: ( (lv_issues_11_0= ruleReportIssue ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=24 && LA5_0<=27)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:243:1: (lv_issues_11_0= ruleReportIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:243:1: (lv_issues_11_0= ruleReportIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:244:3: lv_issues_11_0= ruleReportIssue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getIssuesReportIssueParserRuleCall_8_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleReportIssue_in_ruleResultReportCollection467);
                    	    lv_issues_11_0=ruleReportIssue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getResultReportCollectionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issues",
                    	            		lv_issues_11_0, 
                    	            		"ReportIssue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleResultReportCollection482); 

                	newLeafNode(otherlv_12, grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9());
                

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
    // $ANTLR end "ruleResultReportCollection"


    // $ANTLR start "entryRuleResultReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:272:1: entryRuleResultReport returns [EObject current=null] : iv_ruleResultReport= ruleResultReport EOF ;
    public final EObject entryRuleResultReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:273:2: (iv_ruleResultReport= ruleResultReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:274:2: iv_ruleResultReport= ruleResultReport EOF
            {
             newCompositeNode(grammarAccess.getResultReportRule()); 
            pushFollow(FOLLOW_ruleResultReport_in_entryRuleResultReport518);
            iv_ruleResultReport=ruleResultReport();

            state._fsp--;

             current =iv_ruleResultReport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReport528); 

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
    // $ANTLR end "entryRuleResultReport"


    // $ANTLR start "ruleResultReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:281:1: ruleResultReport returns [EObject current=null] : (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? (otherlv_14= 'issues' ( (lv_issues_15_0= ruleReportIssue ) )* )? otherlv_16= ']' ) ;
    public final EObject ruleResultReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_decription_8_0=null;
        Token otherlv_9=null;
        Token lv_heading_10_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_content_11_0 = null;

        EObject lv_resultData_13_0 = null;

        EObject lv_issues_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:284:28: ( (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? (otherlv_14= 'issues' ( (lv_issues_15_0= ruleReportIssue ) )* )? otherlv_16= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:285:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? (otherlv_14= 'issues' ( (lv_issues_15_0= ruleReportIssue ) )* )? otherlv_16= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:285:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? (otherlv_14= 'issues' ( (lv_issues_15_0= ruleReportIssue ) )* )? otherlv_16= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:285:3: otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? (otherlv_14= 'issues' ( (lv_issues_15_0= ruleReportIssue ) )* )? otherlv_16= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleResultReport565); 

                	newLeafNode(otherlv_0, grammarAccess.getResultReportAccess().getReportKeyword_0());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:289:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:290:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:290:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:291:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultReport582); 

            			newLeafNode(lv_name_1_0, grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResultReportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:307:2: (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==12) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:307:4: otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleResultReport600); 

                        	newLeafNode(otherlv_2, grammarAccess.getResultReportAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:311:1: ( (lv_title_3_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:312:1: (lv_title_3_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:312:1: (lv_title_3_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:313:3: lv_title_3_0= RULE_STRING
                    {
                    lv_title_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReport617); 

                    			newLeafNode(lv_title_3_0, grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleResultReport636); 

                	newLeafNode(otherlv_4, grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_3());
                
            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleResultReport648); 

                	newLeafNode(otherlv_5, grammarAccess.getResultReportAccess().getTargetKeyword_4());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:337:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:338:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:338:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:339:3: ruleURIID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getResultReportRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getResultReportAccess().getTargetEObjectCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleURIID_in_ruleResultReport671);
            ruleURIID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:352:2: (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:352:4: otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleResultReport684); 

                        	newLeafNode(otherlv_7, grammarAccess.getResultReportAccess().getDescriptionKeyword_6_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:356:1: ( (lv_decription_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:357:1: (lv_decription_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:357:1: (lv_decription_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:358:3: lv_decription_8_0= RULE_STRING
                    {
                    lv_decription_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReport701); 

                    			newLeafNode(lv_decription_8_0, grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"decription",
                            		lv_decription_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:374:4: (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:374:6: otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )*
                    {
                    otherlv_9=(Token)match(input,19,FOLLOW_19_in_ruleResultReport721); 

                        	newLeafNode(otherlv_9, grammarAccess.getResultReportAccess().getHeadingKeyword_7_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:378:1: ( (lv_heading_10_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:379:1: (lv_heading_10_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:379:1: (lv_heading_10_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:380:3: lv_heading_10_0= RULE_STRING
                    {
                    lv_heading_10_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReport738); 

                    			newLeafNode(lv_heading_10_0, grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"heading",
                            		lv_heading_10_0, 
                            		"STRING");
                    	    

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:396:2: ( (lv_content_11_0= ruleResultContributor ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==21) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:397:1: (lv_content_11_0= ruleResultContributor )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:397:1: (lv_content_11_0= ruleResultContributor )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:398:3: lv_content_11_0= ruleResultContributor
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getResultReportAccess().getContentResultContributorParserRuleCall_7_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleResultContributor_in_ruleResultReport764);
                    	    lv_content_11_0=ruleResultContributor();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getResultReportRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"content",
                    	            		lv_content_11_0, 
                    	            		"ResultContributor");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:414:5: (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:414:7: otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+
                    {
                    otherlv_12=(Token)match(input,20,FOLLOW_20_in_ruleResultReport780); 

                        	newLeafNode(otherlv_12, grammarAccess.getResultReportAccess().getResultsKeyword_8_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:418:1: ( (lv_resultData_13_0= ruleResultData ) )+
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
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:419:1: (lv_resultData_13_0= ruleResultData )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:419:1: (lv_resultData_13_0= ruleResultData )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:420:3: lv_resultData_13_0= ruleResultData
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleResultData_in_ruleResultReport801);
                    	    lv_resultData_13_0=ruleResultData();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getResultReportRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"resultData",
                    	            		lv_resultData_13_0, 
                    	            		"ResultData");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:436:5: (otherlv_14= 'issues' ( (lv_issues_15_0= ruleReportIssue ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==16) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:436:7: otherlv_14= 'issues' ( (lv_issues_15_0= ruleReportIssue ) )*
                    {
                    otherlv_14=(Token)match(input,16,FOLLOW_16_in_ruleResultReport817); 

                        	newLeafNode(otherlv_14, grammarAccess.getResultReportAccess().getIssuesKeyword_9_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:440:1: ( (lv_issues_15_0= ruleReportIssue ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=24 && LA13_0<=27)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:441:1: (lv_issues_15_0= ruleReportIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:441:1: (lv_issues_15_0= ruleReportIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:442:3: lv_issues_15_0= ruleReportIssue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getResultReportAccess().getIssuesReportIssueParserRuleCall_9_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleReportIssue_in_ruleResultReport838);
                    	    lv_issues_15_0=ruleReportIssue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getResultReportRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issues",
                    	            		lv_issues_15_0, 
                    	            		"ReportIssue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_16=(Token)match(input,17,FOLLOW_17_in_ruleResultReport853); 

                	newLeafNode(otherlv_16, grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_10());
                

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
    // $ANTLR end "ruleResultReport"


    // $ANTLR start "entryRuleIssuesReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:470:1: entryRuleIssuesReport returns [EObject current=null] : iv_ruleIssuesReport= ruleIssuesReport EOF ;
    public final EObject entryRuleIssuesReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIssuesReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:471:2: (iv_ruleIssuesReport= ruleIssuesReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:472:2: iv_ruleIssuesReport= ruleIssuesReport EOF
            {
             newCompositeNode(grammarAccess.getIssuesReportRule()); 
            pushFollow(FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport889);
            iv_ruleIssuesReport=ruleIssuesReport();

            state._fsp--;

             current =iv_ruleIssuesReport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIssuesReport899); 

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
    // $ANTLR end "entryRuleIssuesReport"


    // $ANTLR start "ruleIssuesReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:479:1: ruleIssuesReport returns [EObject current=null] : (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_issues_9_0= ruleReportIssue ) )* otherlv_10= ']' ) ;
    public final EObject ruleIssuesReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_decription_8_0=null;
        Token otherlv_10=null;
        EObject lv_issues_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:482:28: ( (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_issues_9_0= ruleReportIssue ) )* otherlv_10= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:483:1: (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_issues_9_0= ruleReportIssue ) )* otherlv_10= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:483:1: (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_issues_9_0= ruleReportIssue ) )* otherlv_10= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:483:3: otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_issues_9_0= ruleReportIssue ) )* otherlv_10= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleIssuesReport936); 

                	newLeafNode(otherlv_0, grammarAccess.getIssuesReportAccess().getIssuesKeyword_0());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:487:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:488:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:488:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:489:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIssuesReport953); 

            			newLeafNode(lv_name_1_0, grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIssuesReportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:505:2: (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==12) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:505:4: otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleIssuesReport971); 

                        	newLeafNode(otherlv_2, grammarAccess.getIssuesReportAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:509:1: ( (lv_title_3_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:510:1: (lv_title_3_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:510:1: (lv_title_3_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:511:3: lv_title_3_0= RULE_STRING
                    {
                    lv_title_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIssuesReport988); 

                    			newLeafNode(lv_title_3_0, grammarAccess.getIssuesReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIssuesReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleIssuesReport1007); 

                	newLeafNode(otherlv_4, grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3());
                
            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleIssuesReport1019); 

                	newLeafNode(otherlv_5, grammarAccess.getIssuesReportAccess().getTargetKeyword_4());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:535:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:536:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:536:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:537:3: ruleURIID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getIssuesReportRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleURIID_in_ruleIssuesReport1042);
            ruleURIID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:550:2: (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==15) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:550:4: otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleIssuesReport1055); 

                        	newLeafNode(otherlv_7, grammarAccess.getIssuesReportAccess().getDescriptionKeyword_6_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:554:1: ( (lv_decription_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:555:1: (lv_decription_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:555:1: (lv_decription_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:556:3: lv_decription_8_0= RULE_STRING
                    {
                    lv_decription_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIssuesReport1072); 

                    			newLeafNode(lv_decription_8_0, grammarAccess.getIssuesReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIssuesReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"decription",
                            		lv_decription_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:572:4: ( (lv_issues_9_0= ruleReportIssue ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=24 && LA17_0<=27)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:573:1: (lv_issues_9_0= ruleReportIssue )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:573:1: (lv_issues_9_0= ruleReportIssue )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:574:3: lv_issues_9_0= ruleReportIssue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getIssuesReportAccess().getIssuesReportIssueParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleReportIssue_in_ruleIssuesReport1100);
            	    lv_issues_9_0=ruleReportIssue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getIssuesReportRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issues",
            	            		lv_issues_9_0, 
            	            		"ReportIssue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleIssuesReport1113); 

                	newLeafNode(otherlv_10, grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_8());
                

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
    // $ANTLR end "ruleIssuesReport"


    // $ANTLR start "entryRuleResultContributor"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:604:1: entryRuleResultContributor returns [EObject current=null] : iv_ruleResultContributor= ruleResultContributor EOF ;
    public final EObject entryRuleResultContributor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultContributor = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:605:2: (iv_ruleResultContributor= ruleResultContributor EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:606:2: iv_ruleResultContributor= ruleResultContributor EOF
            {
             newCompositeNode(grammarAccess.getResultContributorRule()); 
            pushFollow(FOLLOW_ruleResultContributor_in_entryRuleResultContributor1151);
            iv_ruleResultContributor=ruleResultContributor();

            state._fsp--;

             current =iv_ruleResultContributor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultContributor1161); 

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
    // $ANTLR end "entryRuleResultContributor"


    // $ANTLR start "ruleResultContributor"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:613:1: ruleResultContributor returns [EObject current=null] : (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' otherlv_3= 'data' ( (lv_cell_4_0= RULE_STRING ) )+ (otherlv_5= 'issues' ( (lv_issues_6_0= ruleReportIssue ) )* )? ( (lv_subcontributor_7_0= ruleResultContributor ) )* otherlv_8= ']' ) ;
    public final EObject ruleResultContributor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_cell_4_0=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        EObject lv_issues_6_0 = null;

        EObject lv_subcontributor_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:616:28: ( (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' otherlv_3= 'data' ( (lv_cell_4_0= RULE_STRING ) )+ (otherlv_5= 'issues' ( (lv_issues_6_0= ruleReportIssue ) )* )? ( (lv_subcontributor_7_0= ruleResultContributor ) )* otherlv_8= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:617:1: (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' otherlv_3= 'data' ( (lv_cell_4_0= RULE_STRING ) )+ (otherlv_5= 'issues' ( (lv_issues_6_0= ruleReportIssue ) )* )? ( (lv_subcontributor_7_0= ruleResultContributor ) )* otherlv_8= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:617:1: (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' otherlv_3= 'data' ( (lv_cell_4_0= RULE_STRING ) )+ (otherlv_5= 'issues' ( (lv_issues_6_0= ruleReportIssue ) )* )? ( (lv_subcontributor_7_0= ruleResultContributor ) )* otherlv_8= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:617:3: otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' otherlv_3= 'data' ( (lv_cell_4_0= RULE_STRING ) )+ (otherlv_5= 'issues' ( (lv_issues_6_0= ruleReportIssue ) )* )? ( (lv_subcontributor_7_0= ruleResultContributor ) )* otherlv_8= ']'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleResultContributor1198); 

                	newLeafNode(otherlv_0, grammarAccess.getResultContributorAccess().getContributorKeyword_0());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:621:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:622:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:622:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:623:3: ruleURIID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getResultContributorRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getResultContributorAccess().getContributorEObjectCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleURIID_in_ruleResultContributor1221);
            ruleURIID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleResultContributor1233); 

                	newLeafNode(otherlv_2, grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2());
                
            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleResultContributor1245); 

                	newLeafNode(otherlv_3, grammarAccess.getResultContributorAccess().getDataKeyword_3());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:644:1: ( (lv_cell_4_0= RULE_STRING ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:645:1: (lv_cell_4_0= RULE_STRING )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:645:1: (lv_cell_4_0= RULE_STRING )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:646:3: lv_cell_4_0= RULE_STRING
            	    {
            	    lv_cell_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultContributor1262); 

            	    			newLeafNode(lv_cell_4_0, grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_4_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getResultContributorRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"cell",
            	            		lv_cell_4_0, 
            	            		"STRING");
            	    	    

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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:662:3: (otherlv_5= 'issues' ( (lv_issues_6_0= ruleReportIssue ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==16) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:662:5: otherlv_5= 'issues' ( (lv_issues_6_0= ruleReportIssue ) )*
                    {
                    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleResultContributor1281); 

                        	newLeafNode(otherlv_5, grammarAccess.getResultContributorAccess().getIssuesKeyword_5_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:666:1: ( (lv_issues_6_0= ruleReportIssue ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=24 && LA19_0<=27)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:667:1: (lv_issues_6_0= ruleReportIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:667:1: (lv_issues_6_0= ruleReportIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:668:3: lv_issues_6_0= ruleReportIssue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getResultContributorAccess().getIssuesReportIssueParserRuleCall_5_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleReportIssue_in_ruleResultContributor1302);
                    	    lv_issues_6_0=ruleReportIssue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issues",
                    	            		lv_issues_6_0, 
                    	            		"ReportIssue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:684:5: ( (lv_subcontributor_7_0= ruleResultContributor ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==21) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:685:1: (lv_subcontributor_7_0= ruleResultContributor )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:685:1: (lv_subcontributor_7_0= ruleResultContributor )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:686:3: lv_subcontributor_7_0= ruleResultContributor
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleResultContributor_in_ruleResultContributor1326);
            	    lv_subcontributor_7_0=ruleResultContributor();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subcontributor",
            	            		lv_subcontributor_7_0, 
            	            		"ResultContributor");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleResultContributor1339); 

                	newLeafNode(otherlv_8, grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_7());
                

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
    // $ANTLR end "ruleResultContributor"


    // $ANTLR start "entryRuleReportIssue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:714:1: entryRuleReportIssue returns [EObject current=null] : iv_ruleReportIssue= ruleReportIssue EOF ;
    public final EObject entryRuleReportIssue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReportIssue = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:715:2: (iv_ruleReportIssue= ruleReportIssue EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:716:2: iv_ruleReportIssue= ruleReportIssue EOF
            {
             newCompositeNode(grammarAccess.getReportIssueRule()); 
            pushFollow(FOLLOW_ruleReportIssue_in_entryRuleReportIssue1375);
            iv_ruleReportIssue=ruleReportIssue();

            state._fsp--;

             current =iv_ruleReportIssue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReportIssue1385); 

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
    // $ANTLR end "entryRuleReportIssue"


    // $ANTLR start "ruleReportIssue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:723:1: ruleReportIssue returns [EObject current=null] : ( ( (lv_issueType_0_0= ruleReportIssueType ) ) ( (lv_title_1_0= RULE_STRING ) ) ( ( ruleURIID ) ) ) ;
    public final EObject ruleReportIssue() throws RecognitionException {
        EObject current = null;

        Token lv_title_1_0=null;
        Enumerator lv_issueType_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:726:28: ( ( ( (lv_issueType_0_0= ruleReportIssueType ) ) ( (lv_title_1_0= RULE_STRING ) ) ( ( ruleURIID ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:727:1: ( ( (lv_issueType_0_0= ruleReportIssueType ) ) ( (lv_title_1_0= RULE_STRING ) ) ( ( ruleURIID ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:727:1: ( ( (lv_issueType_0_0= ruleReportIssueType ) ) ( (lv_title_1_0= RULE_STRING ) ) ( ( ruleURIID ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:727:2: ( (lv_issueType_0_0= ruleReportIssueType ) ) ( (lv_title_1_0= RULE_STRING ) ) ( ( ruleURIID ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:727:2: ( (lv_issueType_0_0= ruleReportIssueType ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:728:1: (lv_issueType_0_0= ruleReportIssueType )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:728:1: (lv_issueType_0_0= ruleReportIssueType )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:729:3: lv_issueType_0_0= ruleReportIssueType
            {
             
            	        newCompositeNode(grammarAccess.getReportIssueAccess().getIssueTypeReportIssueTypeEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleReportIssueType_in_ruleReportIssue1431);
            lv_issueType_0_0=ruleReportIssueType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReportIssueRule());
            	        }
                   		set(
                   			current, 
                   			"issueType",
                    		lv_issueType_0_0, 
                    		"ReportIssueType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:745:2: ( (lv_title_1_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:746:1: (lv_title_1_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:746:1: (lv_title_1_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:747:3: lv_title_1_0= RULE_STRING
            {
            lv_title_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReportIssue1448); 

            			newLeafNode(lv_title_1_0, grammarAccess.getReportIssueAccess().getTitleSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReportIssueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"title",
                    		lv_title_1_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:763:2: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:764:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:764:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:765:3: ruleURIID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReportIssueRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getReportIssueAccess().getTargetEObjectCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleURIID_in_ruleReportIssue1476);
            ruleURIID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleReportIssue"


    // $ANTLR start "entryRuleResultData"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:786:1: entryRuleResultData returns [EObject current=null] : iv_ruleResultData= ruleResultData EOF ;
    public final EObject entryRuleResultData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultData = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:787:2: (iv_ruleResultData= ruleResultData EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:788:2: iv_ruleResultData= ruleResultData EOF
            {
             newCompositeNode(grammarAccess.getResultDataRule()); 
            pushFollow(FOLLOW_ruleResultData_in_entryRuleResultData1512);
            iv_ruleResultData=ruleResultData();

            state._fsp--;

             current =iv_ruleResultData; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultData1522); 

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
    // $ANTLR end "entryRuleResultData"


    // $ANTLR start "ruleResultData"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:795:1: ruleResultData returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleResultData() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:798:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:799:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:799:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:799:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:799:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:800:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:800:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:801:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultData1564); 

            			newLeafNode(lv_name_0_0, grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResultDataRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleResultData1581); 

                	newLeafNode(otherlv_1, grammarAccess.getResultDataAccess().getEqualsSignKeyword_1());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:821:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:822:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:822:1: (lv_value_2_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:823:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultData1598); 

            			newLeafNode(lv_value_2_0, grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResultDataRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"STRING");
            	    

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
    // $ANTLR end "ruleResultData"


    // $ANTLR start "entryRuleURIID"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:847:1: entryRuleURIID returns [String current=null] : iv_ruleURIID= ruleURIID EOF ;
    public final String entryRuleURIID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURIID = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:848:2: (iv_ruleURIID= ruleURIID EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:849:2: iv_ruleURIID= ruleURIID EOF
            {
             newCompositeNode(grammarAccess.getURIIDRule()); 
            pushFollow(FOLLOW_ruleURIID_in_entryRuleURIID1640);
            iv_ruleURIID=ruleURIID();

            state._fsp--;

             current =iv_ruleURIID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIID1651); 

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
    // $ANTLR end "entryRuleURIID"


    // $ANTLR start "ruleURIID"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:856:1: ruleURIID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleURIID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:859:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:860:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIID1690); 

            		current.merge(this_STRING_0);
                
             
                newLeafNode(this_STRING_0, grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleURIID"


    // $ANTLR start "ruleReportIssueType"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:875:1: ruleReportIssueType returns [Enumerator current=null] : ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'success' ) | (enumLiteral_3= 'info' ) ) ;
    public final Enumerator ruleReportIssueType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:877:28: ( ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'success' ) | (enumLiteral_3= 'info' ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:878:1: ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'success' ) | (enumLiteral_3= 'info' ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:878:1: ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'success' ) | (enumLiteral_3= 'info' ) )
            int alt22=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt22=1;
                }
                break;
            case 25:
                {
                alt22=2;
                }
                break;
            case 26:
                {
                alt22=3;
                }
                break;
            case 27:
                {
                alt22=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:878:2: (enumLiteral_0= 'error' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:878:2: (enumLiteral_0= 'error' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:878:4: enumLiteral_0= 'error'
                    {
                    enumLiteral_0=(Token)match(input,24,FOLLOW_24_in_ruleReportIssueType1748); 

                            current = grammarAccess.getReportIssueTypeAccess().getERROREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getReportIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:884:6: (enumLiteral_1= 'warning' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:884:6: (enumLiteral_1= 'warning' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:884:8: enumLiteral_1= 'warning'
                    {
                    enumLiteral_1=(Token)match(input,25,FOLLOW_25_in_ruleReportIssueType1765); 

                            current = grammarAccess.getReportIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getReportIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:890:6: (enumLiteral_2= 'success' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:890:6: (enumLiteral_2= 'success' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:890:8: enumLiteral_2= 'success'
                    {
                    enumLiteral_2=(Token)match(input,26,FOLLOW_26_in_ruleReportIssueType1782); 

                            current = grammarAccess.getReportIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getReportIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:896:6: (enumLiteral_3= 'info' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:896:6: (enumLiteral_3= 'info' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:896:8: enumLiteral_3= 'info'
                    {
                    enumLiteral_3=(Token)match(input,27,FOLLOW_27_in_ruleReportIssueType1799); 

                            current = grammarAccess.getReportIssueTypeAccess().getINFOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getReportIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleReportIssueType"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleResultReports_in_entryRuleResultReports75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReports85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReport_in_ruleResultReports132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_ruleResultReports159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssuesReport_in_ruleResultReports186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_entryRuleResultReportCollection221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReportCollection231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleResultReportCollection268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultReportCollection285 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleResultReportCollection303 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportCollection320 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleResultReportCollection339 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleResultReportCollection351 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultReportCollection374 = new BitSet(new long[]{0x0000000000078000L});
    public static final BitSet FOLLOW_15_in_ruleResultReportCollection387 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportCollection404 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_ruleResultReport_in_ruleResultReportCollection432 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_16_in_ruleResultReportCollection446 = new BitSet(new long[]{0x000000000F020000L});
    public static final BitSet FOLLOW_ruleReportIssue_in_ruleResultReportCollection467 = new BitSet(new long[]{0x000000000F020000L});
    public static final BitSet FOLLOW_17_in_ruleResultReportCollection482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReport_in_entryRuleResultReport518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReport528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleResultReport565 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultReport582 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleResultReport600 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReport617 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleResultReport636 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleResultReport648 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultReport671 = new BitSet(new long[]{0x00000000001B8000L});
    public static final BitSet FOLLOW_15_in_ruleResultReport684 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReport701 = new BitSet(new long[]{0x00000000001B0000L});
    public static final BitSet FOLLOW_19_in_ruleResultReport721 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReport738 = new BitSet(new long[]{0x0000000000330000L});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultReport764 = new BitSet(new long[]{0x0000000000330000L});
    public static final BitSet FOLLOW_20_in_ruleResultReport780 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultReport801 = new BitSet(new long[]{0x0000000000030010L});
    public static final BitSet FOLLOW_16_in_ruleResultReport817 = new BitSet(new long[]{0x000000000F020000L});
    public static final BitSet FOLLOW_ruleReportIssue_in_ruleResultReport838 = new BitSet(new long[]{0x000000000F020000L});
    public static final BitSet FOLLOW_17_in_ruleResultReport853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIssuesReport899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleIssuesReport936 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIssuesReport953 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleIssuesReport971 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIssuesReport988 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleIssuesReport1007 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleIssuesReport1019 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleIssuesReport1042 = new BitSet(new long[]{0x000000000F028000L});
    public static final BitSet FOLLOW_15_in_ruleIssuesReport1055 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIssuesReport1072 = new BitSet(new long[]{0x000000000F020000L});
    public static final BitSet FOLLOW_ruleReportIssue_in_ruleIssuesReport1100 = new BitSet(new long[]{0x000000000F020000L});
    public static final BitSet FOLLOW_17_in_ruleIssuesReport1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_entryRuleResultContributor1151 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultContributor1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleResultContributor1198 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultContributor1221 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleResultContributor1233 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleResultContributor1245 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultContributor1262 = new BitSet(new long[]{0x0000000000230020L});
    public static final BitSet FOLLOW_16_in_ruleResultContributor1281 = new BitSet(new long[]{0x000000000F220000L});
    public static final BitSet FOLLOW_ruleReportIssue_in_ruleResultContributor1302 = new BitSet(new long[]{0x000000000F220000L});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultContributor1326 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_17_in_ruleResultContributor1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssue_in_entryRuleReportIssue1375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReportIssue1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssueType_in_ruleReportIssue1431 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReportIssue1448 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleReportIssue1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_entryRuleResultData1512 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultData1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultData1564 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleResultData1581 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultData1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_entryRuleURIID1640 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIID1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIID1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleReportIssueType1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleReportIssueType1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleReportIssueType1782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleReportIssueType1799 = new BitSet(new long[]{0x0000000000000002L});

}
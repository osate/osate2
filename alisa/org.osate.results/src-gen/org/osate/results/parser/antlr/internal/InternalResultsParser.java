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

/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
@SuppressWarnings("all")
public class InternalResultsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'reports'", "':'", "'['", "'target'", "'description'", "']'", "'report'", "'exception'", "'heading'", "'results'", "'contributor'", "'data'", "'issues'", "'issue'", "'='", "'error'", "'warning'", "'info'", "'success'", "'fail'", "'unknown'"
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:80:1: entryRuleResultReports returns [EObject current=null] : iv_ruleResultReports= ruleResultReports EOF ;
    public final EObject entryRuleResultReports() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReports = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:81:2: (iv_ruleResultReports= ruleResultReports EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:82:2: iv_ruleResultReports= ruleResultReports EOF
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:89:1: ruleResultReports returns [EObject current=null] : (this_ResultReport_0= ruleResultReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssueReport_2= ruleIssueReport ) ;
    public final EObject ruleResultReports() throws RecognitionException {
        EObject current = null;

        EObject this_ResultReport_0 = null;

        EObject this_ResultReportCollection_1 = null;

        EObject this_IssueReport_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:92:28: ( (this_ResultReport_0= ruleResultReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssueReport_2= ruleIssueReport ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:93:1: (this_ResultReport_0= ruleResultReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssueReport_2= ruleIssueReport )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:93:1: (this_ResultReport_0= ruleResultReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssueReport_2= ruleIssueReport )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt1=1;
                }
                break;
            case 11:
                {
                alt1=2;
                }
                break;
            case 23:
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:94:5: this_ResultReport_0= ruleResultReport
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:104:5: this_ResultReportCollection_1= ruleResultReportCollection
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:114:5: this_IssueReport_2= ruleIssueReport
                    {
                     
                            newCompositeNode(grammarAccess.getResultReportsAccess().getIssueReportParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleIssueReport_in_ruleResultReports186);
                    this_IssueReport_2=ruleIssueReport();

                    state._fsp--;

                     
                            current = this_IssueReport_2; 
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:130:1: entryRuleResultReportCollection returns [EObject current=null] : iv_ruleResultReportCollection= ruleResultReportCollection EOF ;
    public final EObject entryRuleResultReportCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReportCollection = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:131:2: (iv_ruleResultReportCollection= ruleResultReportCollection EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:132:2: iv_ruleResultReportCollection= ruleResultReportCollection EOF
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:139:1: ruleResultReportCollection returns [EObject current=null] : (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' ) ;
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
        Token otherlv_11=null;
        EObject lv_content_9_0 = null;

        EObject lv_issues_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:142:28: ( (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:1: (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:1: (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:3: otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleResultReportCollection268); 

                	newLeafNode(otherlv_0, grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:147:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:148:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:148:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:149:3: lv_name_1_0= RULE_ID
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:165:2: (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:165:4: otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleResultReportCollection303); 

                        	newLeafNode(otherlv_2, grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:169:1: ( (lv_title_3_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:170:1: (lv_title_3_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:170:1: (lv_title_3_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:171:3: lv_title_3_0= RULE_STRING
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
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:195:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:196:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:196:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:197:3: ruleURIID
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:210:2: (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:210:4: otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleResultReportCollection387); 

                        	newLeafNode(otherlv_7, grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:214:1: ( (lv_decription_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:215:1: (lv_decription_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:215:1: (lv_decription_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:216:3: lv_decription_8_0= RULE_STRING
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:232:4: ( (lv_content_9_0= ruleResultReport ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:233:1: (lv_content_9_0= ruleResultReport )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:233:1: (lv_content_9_0= ruleResultReport )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:234:3: lv_content_9_0= ruleResultReport
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:250:3: ( (lv_issues_10_0= ruleResultIssue ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==24) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:251:1: (lv_issues_10_0= ruleResultIssue )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:251:1: (lv_issues_10_0= ruleResultIssue )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:252:3: lv_issues_10_0= ruleResultIssue
                    {
                     
                    	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getIssuesResultIssueParserRuleCall_8_0()); 
                    	    
                    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultReportCollection454);
                    lv_issues_10_0=ruleResultIssue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getResultReportCollectionRule());
                    	        }
                           		add(
                           			current, 
                           			"issues",
                            		lv_issues_10_0, 
                            		"ResultIssue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,16,FOLLOW_16_in_ruleResultReportCollection467); 

                	newLeafNode(otherlv_11, grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9());
                

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:280:1: entryRuleResultReport returns [EObject current=null] : iv_ruleResultReport= ruleResultReport EOF ;
    public final EObject entryRuleResultReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:281:2: (iv_ruleResultReport= ruleResultReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:282:2: iv_ruleResultReport= ruleResultReport EOF
            {
             newCompositeNode(grammarAccess.getResultReportRule()); 
            pushFollow(FOLLOW_ruleResultReport_in_entryRuleResultReport503);
            iv_ruleResultReport=ruleResultReport();

            state._fsp--;

             current =iv_ruleResultReport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReport513); 

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:289:1: ruleResultReport returns [EObject current=null] : ( () otherlv_1= 'report' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? ( ( ruleURIID ) ) ( (lv_issueType_6_0= ruleResultIssueType ) ) ( (lv_message_7_0= RULE_STRING ) ) (otherlv_8= 'exception' ( (lv_exceptionType_9_0= RULE_STRING ) ) )? otherlv_10= '[' (otherlv_11= 'description' ( (lv_decription_12_0= RULE_STRING ) ) )? (otherlv_13= 'heading' ( (lv_heading_14_0= RULE_STRING ) ) ( (lv_content_15_0= ruleResultContributor ) )* )? (otherlv_16= 'results' ( (lv_resultData_17_0= ruleResultData ) )+ )? ( (lv_issues_18_0= ruleResultIssue ) )? otherlv_19= ']' ) ;
    public final EObject ruleResultReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_title_4_0=null;
        Token lv_message_7_0=null;
        Token otherlv_8=null;
        Token lv_exceptionType_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_decription_12_0=null;
        Token otherlv_13=null;
        Token lv_heading_14_0=null;
        Token otherlv_16=null;
        Token otherlv_19=null;
        Enumerator lv_issueType_6_0 = null;

        EObject lv_content_15_0 = null;

        EObject lv_resultData_17_0 = null;

        EObject lv_issues_18_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:292:28: ( ( () otherlv_1= 'report' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? ( ( ruleURIID ) ) ( (lv_issueType_6_0= ruleResultIssueType ) ) ( (lv_message_7_0= RULE_STRING ) ) (otherlv_8= 'exception' ( (lv_exceptionType_9_0= RULE_STRING ) ) )? otherlv_10= '[' (otherlv_11= 'description' ( (lv_decription_12_0= RULE_STRING ) ) )? (otherlv_13= 'heading' ( (lv_heading_14_0= RULE_STRING ) ) ( (lv_content_15_0= ruleResultContributor ) )* )? (otherlv_16= 'results' ( (lv_resultData_17_0= ruleResultData ) )+ )? ( (lv_issues_18_0= ruleResultIssue ) )? otherlv_19= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:1: ( () otherlv_1= 'report' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? ( ( ruleURIID ) ) ( (lv_issueType_6_0= ruleResultIssueType ) ) ( (lv_message_7_0= RULE_STRING ) ) (otherlv_8= 'exception' ( (lv_exceptionType_9_0= RULE_STRING ) ) )? otherlv_10= '[' (otherlv_11= 'description' ( (lv_decription_12_0= RULE_STRING ) ) )? (otherlv_13= 'heading' ( (lv_heading_14_0= RULE_STRING ) ) ( (lv_content_15_0= ruleResultContributor ) )* )? (otherlv_16= 'results' ( (lv_resultData_17_0= ruleResultData ) )+ )? ( (lv_issues_18_0= ruleResultIssue ) )? otherlv_19= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:1: ( () otherlv_1= 'report' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? ( ( ruleURIID ) ) ( (lv_issueType_6_0= ruleResultIssueType ) ) ( (lv_message_7_0= RULE_STRING ) ) (otherlv_8= 'exception' ( (lv_exceptionType_9_0= RULE_STRING ) ) )? otherlv_10= '[' (otherlv_11= 'description' ( (lv_decription_12_0= RULE_STRING ) ) )? (otherlv_13= 'heading' ( (lv_heading_14_0= RULE_STRING ) ) ( (lv_content_15_0= ruleResultContributor ) )* )? (otherlv_16= 'results' ( (lv_resultData_17_0= ruleResultData ) )+ )? ( (lv_issues_18_0= ruleResultIssue ) )? otherlv_19= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:2: () otherlv_1= 'report' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )? ( ( ruleURIID ) ) ( (lv_issueType_6_0= ruleResultIssueType ) ) ( (lv_message_7_0= RULE_STRING ) ) (otherlv_8= 'exception' ( (lv_exceptionType_9_0= RULE_STRING ) ) )? otherlv_10= '[' (otherlv_11= 'description' ( (lv_decription_12_0= RULE_STRING ) ) )? (otherlv_13= 'heading' ( (lv_heading_14_0= RULE_STRING ) ) ( (lv_content_15_0= ruleResultContributor ) )* )? (otherlv_16= 'results' ( (lv_resultData_17_0= ruleResultData ) )+ )? ( (lv_issues_18_0= ruleResultIssue ) )? otherlv_19= ']'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:294:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getResultReportAccess().getResultReportAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleResultReport559); 

                	newLeafNode(otherlv_1, grammarAccess.getResultReportAccess().getReportKeyword_1());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:303:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:304:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:304:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:305:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultReport576); 

            			newLeafNode(lv_name_2_0, grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResultReportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:321:2: (otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==12) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:321:4: otherlv_3= ':' ( (lv_title_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleResultReport594); 

                        	newLeafNode(otherlv_3, grammarAccess.getResultReportAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:325:1: ( (lv_title_4_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:326:1: (lv_title_4_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:326:1: (lv_title_4_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:327:3: lv_title_4_0= RULE_STRING
                    {
                    lv_title_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReport611); 

                    			newLeafNode(lv_title_4_0, grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportRule());
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:343:4: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:344:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:344:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:345:3: ruleURIID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getResultReportRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getResultReportAccess().getTargetEObjectCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleURIID_in_ruleResultReport641);
            ruleURIID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:358:2: ( (lv_issueType_6_0= ruleResultIssueType ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:359:1: (lv_issueType_6_0= ruleResultIssueType )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:359:1: (lv_issueType_6_0= ruleResultIssueType )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:360:3: lv_issueType_6_0= ruleResultIssueType
            {
             
            	        newCompositeNode(grammarAccess.getResultReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleResultIssueType_in_ruleResultReport662);
            lv_issueType_6_0=ruleResultIssueType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getResultReportRule());
            	        }
                   		set(
                   			current, 
                   			"issueType",
                    		lv_issueType_6_0, 
                    		"ResultIssueType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:376:2: ( (lv_message_7_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:377:1: (lv_message_7_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:377:1: (lv_message_7_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:378:3: lv_message_7_0= RULE_STRING
            {
            lv_message_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReport679); 

            			newLeafNode(lv_message_7_0, grammarAccess.getResultReportAccess().getMessageSTRINGTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResultReportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"message",
                    		lv_message_7_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:394:2: (otherlv_8= 'exception' ( (lv_exceptionType_9_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:394:4: otherlv_8= 'exception' ( (lv_exceptionType_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,18,FOLLOW_18_in_ruleResultReport697); 

                        	newLeafNode(otherlv_8, grammarAccess.getResultReportAccess().getExceptionKeyword_7_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:398:1: ( (lv_exceptionType_9_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:399:1: (lv_exceptionType_9_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:399:1: (lv_exceptionType_9_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:400:3: lv_exceptionType_9_0= RULE_STRING
                    {
                    lv_exceptionType_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReport714); 

                    			newLeafNode(lv_exceptionType_9_0, grammarAccess.getResultReportAccess().getExceptionTypeSTRINGTerminalRuleCall_7_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"exceptionType",
                            		lv_exceptionType_9_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,13,FOLLOW_13_in_ruleResultReport733); 

                	newLeafNode(otherlv_10, grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_8());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:420:1: (otherlv_11= 'description' ( (lv_decription_12_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:420:3: otherlv_11= 'description' ( (lv_decription_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,15,FOLLOW_15_in_ruleResultReport746); 

                        	newLeafNode(otherlv_11, grammarAccess.getResultReportAccess().getDescriptionKeyword_9_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:424:1: ( (lv_decription_12_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:425:1: (lv_decription_12_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:425:1: (lv_decription_12_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:426:3: lv_decription_12_0= RULE_STRING
                    {
                    lv_decription_12_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReport763); 

                    			newLeafNode(lv_decription_12_0, grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_9_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"decription",
                            		lv_decription_12_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:442:4: (otherlv_13= 'heading' ( (lv_heading_14_0= RULE_STRING ) ) ( (lv_content_15_0= ruleResultContributor ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:442:6: otherlv_13= 'heading' ( (lv_heading_14_0= RULE_STRING ) ) ( (lv_content_15_0= ruleResultContributor ) )*
                    {
                    otherlv_13=(Token)match(input,19,FOLLOW_19_in_ruleResultReport783); 

                        	newLeafNode(otherlv_13, grammarAccess.getResultReportAccess().getHeadingKeyword_10_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:446:1: ( (lv_heading_14_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:447:1: (lv_heading_14_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:447:1: (lv_heading_14_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:448:3: lv_heading_14_0= RULE_STRING
                    {
                    lv_heading_14_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReport800); 

                    			newLeafNode(lv_heading_14_0, grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_10_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"heading",
                            		lv_heading_14_0, 
                            		"STRING");
                    	    

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:464:2: ( (lv_content_15_0= ruleResultContributor ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==21) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:465:1: (lv_content_15_0= ruleResultContributor )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:465:1: (lv_content_15_0= ruleResultContributor )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:466:3: lv_content_15_0= ruleResultContributor
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getResultReportAccess().getContentResultContributorParserRuleCall_10_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleResultContributor_in_ruleResultReport826);
                    	    lv_content_15_0=ruleResultContributor();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getResultReportRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"content",
                    	            		lv_content_15_0, 
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:482:5: (otherlv_16= 'results' ( (lv_resultData_17_0= ruleResultData ) )+ )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:482:7: otherlv_16= 'results' ( (lv_resultData_17_0= ruleResultData ) )+
                    {
                    otherlv_16=(Token)match(input,20,FOLLOW_20_in_ruleResultReport842); 

                        	newLeafNode(otherlv_16, grammarAccess.getResultReportAccess().getResultsKeyword_11_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:486:1: ( (lv_resultData_17_0= ruleResultData ) )+
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
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:487:1: (lv_resultData_17_0= ruleResultData )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:487:1: (lv_resultData_17_0= ruleResultData )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:488:3: lv_resultData_17_0= ruleResultData
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_11_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleResultData_in_ruleResultReport863);
                    	    lv_resultData_17_0=ruleResultData();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getResultReportRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"resultData",
                    	            		lv_resultData_17_0, 
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:504:5: ( (lv_issues_18_0= ruleResultIssue ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:505:1: (lv_issues_18_0= ruleResultIssue )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:505:1: (lv_issues_18_0= ruleResultIssue )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:506:3: lv_issues_18_0= ruleResultIssue
                    {
                     
                    	        newCompositeNode(grammarAccess.getResultReportAccess().getIssuesResultIssueParserRuleCall_12_0()); 
                    	    
                    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultReport887);
                    lv_issues_18_0=ruleResultIssue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getResultReportRule());
                    	        }
                           		add(
                           			current, 
                           			"issues",
                            		lv_issues_18_0, 
                            		"ResultIssue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_19=(Token)match(input,16,FOLLOW_16_in_ruleResultReport900); 

                	newLeafNode(otherlv_19, grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_13());
                

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


    // $ANTLR start "entryRuleResultContributor"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:534:1: entryRuleResultContributor returns [EObject current=null] : iv_ruleResultContributor= ruleResultContributor EOF ;
    public final EObject entryRuleResultContributor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultContributor = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:535:2: (iv_ruleResultContributor= ruleResultContributor EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:536:2: iv_ruleResultContributor= ruleResultContributor EOF
            {
             newCompositeNode(grammarAccess.getResultContributorRule()); 
            pushFollow(FOLLOW_ruleResultContributor_in_entryRuleResultContributor936);
            iv_ruleResultContributor=ruleResultContributor();

            state._fsp--;

             current =iv_ruleResultContributor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultContributor946); 

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:543:1: ruleResultContributor returns [EObject current=null] : ( () otherlv_1= 'contributor' ( ( ruleURIID ) ) ( (lv_issueType_3_0= ruleResultIssueType ) ) ( (lv_message_4_0= RULE_STRING ) ) (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? otherlv_7= '[' otherlv_8= 'data' ( (lv_cell_9_0= RULE_STRING ) )+ ( (lv_issues_10_0= ruleResultIssue ) )* ( (lv_subcontributor_11_0= ruleResultContributor ) )* otherlv_12= ']' ) ;
    public final EObject ruleResultContributor() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_message_4_0=null;
        Token otherlv_5=null;
        Token lv_exceptionType_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_cell_9_0=null;
        Token otherlv_12=null;
        Enumerator lv_issueType_3_0 = null;

        EObject lv_issues_10_0 = null;

        EObject lv_subcontributor_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:546:28: ( ( () otherlv_1= 'contributor' ( ( ruleURIID ) ) ( (lv_issueType_3_0= ruleResultIssueType ) ) ( (lv_message_4_0= RULE_STRING ) ) (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? otherlv_7= '[' otherlv_8= 'data' ( (lv_cell_9_0= RULE_STRING ) )+ ( (lv_issues_10_0= ruleResultIssue ) )* ( (lv_subcontributor_11_0= ruleResultContributor ) )* otherlv_12= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:547:1: ( () otherlv_1= 'contributor' ( ( ruleURIID ) ) ( (lv_issueType_3_0= ruleResultIssueType ) ) ( (lv_message_4_0= RULE_STRING ) ) (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? otherlv_7= '[' otherlv_8= 'data' ( (lv_cell_9_0= RULE_STRING ) )+ ( (lv_issues_10_0= ruleResultIssue ) )* ( (lv_subcontributor_11_0= ruleResultContributor ) )* otherlv_12= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:547:1: ( () otherlv_1= 'contributor' ( ( ruleURIID ) ) ( (lv_issueType_3_0= ruleResultIssueType ) ) ( (lv_message_4_0= RULE_STRING ) ) (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? otherlv_7= '[' otherlv_8= 'data' ( (lv_cell_9_0= RULE_STRING ) )+ ( (lv_issues_10_0= ruleResultIssue ) )* ( (lv_subcontributor_11_0= ruleResultContributor ) )* otherlv_12= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:547:2: () otherlv_1= 'contributor' ( ( ruleURIID ) ) ( (lv_issueType_3_0= ruleResultIssueType ) ) ( (lv_message_4_0= RULE_STRING ) ) (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? otherlv_7= '[' otherlv_8= 'data' ( (lv_cell_9_0= RULE_STRING ) )+ ( (lv_issues_10_0= ruleResultIssue ) )* ( (lv_subcontributor_11_0= ruleResultContributor ) )* otherlv_12= ']'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:547:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:548:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getResultContributorAccess().getResultContributorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleResultContributor992); 

                	newLeafNode(otherlv_1, grammarAccess.getResultContributorAccess().getContributorKeyword_1());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:557:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:558:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:558:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:559:3: ruleURIID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getResultContributorRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleURIID_in_ruleResultContributor1015);
            ruleURIID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:572:2: ( (lv_issueType_3_0= ruleResultIssueType ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:573:1: (lv_issueType_3_0= ruleResultIssueType )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:573:1: (lv_issueType_3_0= ruleResultIssueType )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:574:3: lv_issueType_3_0= ruleResultIssueType
            {
             
            	        newCompositeNode(grammarAccess.getResultContributorAccess().getIssueTypeResultIssueTypeEnumRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleResultIssueType_in_ruleResultContributor1036);
            lv_issueType_3_0=ruleResultIssueType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
            	        }
                   		set(
                   			current, 
                   			"issueType",
                    		lv_issueType_3_0, 
                    		"ResultIssueType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:590:2: ( (lv_message_4_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:591:1: (lv_message_4_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:591:1: (lv_message_4_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:592:3: lv_message_4_0= RULE_STRING
            {
            lv_message_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultContributor1053); 

            			newLeafNode(lv_message_4_0, grammarAccess.getResultContributorAccess().getMessageSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResultContributorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"message",
                    		lv_message_4_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:608:2: (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==18) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:608:4: otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleResultContributor1071); 

                        	newLeafNode(otherlv_5, grammarAccess.getResultContributorAccess().getExceptionKeyword_5_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:612:1: ( (lv_exceptionType_6_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:613:1: (lv_exceptionType_6_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:613:1: (lv_exceptionType_6_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:614:3: lv_exceptionType_6_0= RULE_STRING
                    {
                    lv_exceptionType_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultContributor1088); 

                    			newLeafNode(lv_exceptionType_6_0, grammarAccess.getResultContributorAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultContributorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"exceptionType",
                            		lv_exceptionType_6_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleResultContributor1107); 

                	newLeafNode(otherlv_7, grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_6());
                
            otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleResultContributor1119); 

                	newLeafNode(otherlv_8, grammarAccess.getResultContributorAccess().getDataKeyword_7());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:638:1: ( (lv_cell_9_0= RULE_STRING ) )+
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
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:639:1: (lv_cell_9_0= RULE_STRING )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:639:1: (lv_cell_9_0= RULE_STRING )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:640:3: lv_cell_9_0= RULE_STRING
            	    {
            	    lv_cell_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultContributor1136); 

            	    			newLeafNode(lv_cell_9_0, grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_8_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getResultContributorRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"cell",
            	            		lv_cell_9_0, 
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:656:3: ( (lv_issues_10_0= ruleResultIssue ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:657:1: (lv_issues_10_0= ruleResultIssue )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:657:1: (lv_issues_10_0= ruleResultIssue )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:658:3: lv_issues_10_0= ruleResultIssue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultContributor1163);
            	    lv_issues_10_0=ruleResultIssue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issues",
            	            		lv_issues_10_0, 
            	            		"ResultIssue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:674:3: ( (lv_subcontributor_11_0= ruleResultContributor ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==21) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:675:1: (lv_subcontributor_11_0= ruleResultContributor )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:675:1: (lv_subcontributor_11_0= ruleResultContributor )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:676:3: lv_subcontributor_11_0= ruleResultContributor
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleResultContributor_in_ruleResultContributor1185);
            	    lv_subcontributor_11_0=ruleResultContributor();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subcontributor",
            	            		lv_subcontributor_11_0, 
            	            		"ResultContributor");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_12=(Token)match(input,16,FOLLOW_16_in_ruleResultContributor1198); 

                	newLeafNode(otherlv_12, grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_11());
                

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


    // $ANTLR start "entryRuleIssueReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:704:1: entryRuleIssueReport returns [EObject current=null] : iv_ruleIssueReport= ruleIssueReport EOF ;
    public final EObject entryRuleIssueReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIssueReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:705:2: (iv_ruleIssueReport= ruleIssueReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:706:2: iv_ruleIssueReport= ruleIssueReport EOF
            {
             newCompositeNode(grammarAccess.getIssueReportRule()); 
            pushFollow(FOLLOW_ruleIssueReport_in_entryRuleIssueReport1234);
            iv_ruleIssueReport=ruleIssueReport();

            state._fsp--;

             current =iv_ruleIssueReport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIssueReport1244); 

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
    // $ANTLR end "entryRuleIssueReport"


    // $ANTLR start "ruleIssueReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:713:1: ruleIssueReport returns [EObject current=null] : ( () otherlv_1= 'issues' ( (lv_issueType_2_0= ruleResultIssueType ) ) ( (lv_message_3_0= RULE_STRING ) ) (otherlv_4= 'target' ( ( ruleURIID ) ) )? (otherlv_6= 'exception' ( (lv_exceptionType_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? ) ;
    public final EObject ruleIssueReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_message_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_exceptionType_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Enumerator lv_issueType_2_0 = null;

        EObject lv_issues_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:716:28: ( ( () otherlv_1= 'issues' ( (lv_issueType_2_0= ruleResultIssueType ) ) ( (lv_message_3_0= RULE_STRING ) ) (otherlv_4= 'target' ( ( ruleURIID ) ) )? (otherlv_6= 'exception' ( (lv_exceptionType_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:717:1: ( () otherlv_1= 'issues' ( (lv_issueType_2_0= ruleResultIssueType ) ) ( (lv_message_3_0= RULE_STRING ) ) (otherlv_4= 'target' ( ( ruleURIID ) ) )? (otherlv_6= 'exception' ( (lv_exceptionType_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:717:1: ( () otherlv_1= 'issues' ( (lv_issueType_2_0= ruleResultIssueType ) ) ( (lv_message_3_0= RULE_STRING ) ) (otherlv_4= 'target' ( ( ruleURIID ) ) )? (otherlv_6= 'exception' ( (lv_exceptionType_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:717:2: () otherlv_1= 'issues' ( (lv_issueType_2_0= ruleResultIssueType ) ) ( (lv_message_3_0= RULE_STRING ) ) (otherlv_4= 'target' ( ( ruleURIID ) ) )? (otherlv_6= 'exception' ( (lv_exceptionType_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:717:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:718:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIssueReportAccess().getIssueReportAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleIssueReport1290); 

                	newLeafNode(otherlv_1, grammarAccess.getIssueReportAccess().getIssuesKeyword_1());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:727:1: ( (lv_issueType_2_0= ruleResultIssueType ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:728:1: (lv_issueType_2_0= ruleResultIssueType )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:728:1: (lv_issueType_2_0= ruleResultIssueType )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:729:3: lv_issueType_2_0= ruleResultIssueType
            {
             
            	        newCompositeNode(grammarAccess.getIssueReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleResultIssueType_in_ruleIssueReport1311);
            lv_issueType_2_0=ruleResultIssueType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIssueReportRule());
            	        }
                   		set(
                   			current, 
                   			"issueType",
                    		lv_issueType_2_0, 
                    		"ResultIssueType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:745:2: ( (lv_message_3_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:746:1: (lv_message_3_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:746:1: (lv_message_3_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:747:3: lv_message_3_0= RULE_STRING
            {
            lv_message_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIssueReport1328); 

            			newLeafNode(lv_message_3_0, grammarAccess.getIssueReportAccess().getMessageSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIssueReportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"message",
                    		lv_message_3_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:763:2: (otherlv_4= 'target' ( ( ruleURIID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==14) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:763:4: otherlv_4= 'target' ( ( ruleURIID ) )
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleIssueReport1346); 

                        	newLeafNode(otherlv_4, grammarAccess.getIssueReportAccess().getTargetKeyword_4_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:767:1: ( ( ruleURIID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:768:1: ( ruleURIID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:768:1: ( ruleURIID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:769:3: ruleURIID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getIssueReportRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getIssueReportAccess().getTargetEObjectCrossReference_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleURIID_in_ruleIssueReport1369);
                    ruleURIID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:782:4: (otherlv_6= 'exception' ( (lv_exceptionType_7_0= RULE_STRING ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==18) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:782:6: otherlv_6= 'exception' ( (lv_exceptionType_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleIssueReport1384); 

                        	newLeafNode(otherlv_6, grammarAccess.getIssueReportAccess().getExceptionKeyword_5_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:786:1: ( (lv_exceptionType_7_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:787:1: (lv_exceptionType_7_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:787:1: (lv_exceptionType_7_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:788:3: lv_exceptionType_7_0= RULE_STRING
                    {
                    lv_exceptionType_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIssueReport1401); 

                    			newLeafNode(lv_exceptionType_7_0, grammarAccess.getIssueReportAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIssueReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"exceptionType",
                            		lv_exceptionType_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:804:4: (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==13) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:804:6: otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']'
                    {
                    otherlv_8=(Token)match(input,13,FOLLOW_13_in_ruleIssueReport1421); 

                        	newLeafNode(otherlv_8, grammarAccess.getIssueReportAccess().getLeftSquareBracketKeyword_6_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:808:1: ( (lv_issues_9_0= ruleResultIssue ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==24) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:809:1: (lv_issues_9_0= ruleResultIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:809:1: (lv_issues_9_0= ruleResultIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:810:3: lv_issues_9_0= ruleResultIssue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getIssueReportAccess().getIssuesResultIssueParserRuleCall_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleResultIssue_in_ruleIssueReport1442);
                    	    lv_issues_9_0=ruleResultIssue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getIssueReportRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issues",
                    	            		lv_issues_9_0, 
                    	            		"ResultIssue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleIssueReport1455); 

                        	newLeafNode(otherlv_10, grammarAccess.getIssueReportAccess().getRightSquareBracketKeyword_6_2());
                        

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
    // $ANTLR end "ruleIssueReport"


    // $ANTLR start "entryRuleResultIssue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:838:1: entryRuleResultIssue returns [EObject current=null] : iv_ruleResultIssue= ruleResultIssue EOF ;
    public final EObject entryRuleResultIssue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultIssue = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:839:2: (iv_ruleResultIssue= ruleResultIssue EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:840:2: iv_ruleResultIssue= ruleResultIssue EOF
            {
             newCompositeNode(grammarAccess.getResultIssueRule()); 
            pushFollow(FOLLOW_ruleResultIssue_in_entryRuleResultIssue1493);
            iv_ruleResultIssue=ruleResultIssue();

            state._fsp--;

             current =iv_ruleResultIssue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultIssue1503); 

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
    // $ANTLR end "entryRuleResultIssue"


    // $ANTLR start "ruleResultIssue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:847:1: ruleResultIssue returns [EObject current=null] : (otherlv_0= 'issue' ( (lv_issueType_1_0= ruleResultIssueType ) ) ( (lv_message_2_0= RULE_STRING ) ) (otherlv_3= 'target' ( ( ruleURIID ) ) )? (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )? ) ;
    public final EObject ruleResultIssue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_message_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_exceptionType_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_issueType_1_0 = null;

        EObject lv_issues_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:850:28: ( (otherlv_0= 'issue' ( (lv_issueType_1_0= ruleResultIssueType ) ) ( (lv_message_2_0= RULE_STRING ) ) (otherlv_3= 'target' ( ( ruleURIID ) ) )? (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:851:1: (otherlv_0= 'issue' ( (lv_issueType_1_0= ruleResultIssueType ) ) ( (lv_message_2_0= RULE_STRING ) ) (otherlv_3= 'target' ( ( ruleURIID ) ) )? (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:851:1: (otherlv_0= 'issue' ( (lv_issueType_1_0= ruleResultIssueType ) ) ( (lv_message_2_0= RULE_STRING ) ) (otherlv_3= 'target' ( ( ruleURIID ) ) )? (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:851:3: otherlv_0= 'issue' ( (lv_issueType_1_0= ruleResultIssueType ) ) ( (lv_message_2_0= RULE_STRING ) ) (otherlv_3= 'target' ( ( ruleURIID ) ) )? (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleResultIssue1540); 

                	newLeafNode(otherlv_0, grammarAccess.getResultIssueAccess().getIssueKeyword_0());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:855:1: ( (lv_issueType_1_0= ruleResultIssueType ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:856:1: (lv_issueType_1_0= ruleResultIssueType )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:856:1: (lv_issueType_1_0= ruleResultIssueType )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:857:3: lv_issueType_1_0= ruleResultIssueType
            {
             
            	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleResultIssueType_in_ruleResultIssue1561);
            lv_issueType_1_0=ruleResultIssueType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getResultIssueRule());
            	        }
                   		set(
                   			current, 
                   			"issueType",
                    		lv_issueType_1_0, 
                    		"ResultIssueType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:873:2: ( (lv_message_2_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:874:1: (lv_message_2_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:874:1: (lv_message_2_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:875:3: lv_message_2_0= RULE_STRING
            {
            lv_message_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1578); 

            			newLeafNode(lv_message_2_0, grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResultIssueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"message",
                    		lv_message_2_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:891:2: (otherlv_3= 'target' ( ( ruleURIID ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==14) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:891:4: otherlv_3= 'target' ( ( ruleURIID ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleResultIssue1596); 

                        	newLeafNode(otherlv_3, grammarAccess.getResultIssueAccess().getTargetKeyword_3_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:895:1: ( ( ruleURIID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:896:1: ( ruleURIID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:896:1: ( ruleURIID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:897:3: ruleURIID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultIssueRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleURIID_in_ruleResultIssue1619);
                    ruleURIID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:910:4: (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==18) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:910:6: otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleResultIssue1634); 

                        	newLeafNode(otherlv_5, grammarAccess.getResultIssueAccess().getExceptionKeyword_4_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:914:1: ( (lv_exceptionType_6_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:915:1: (lv_exceptionType_6_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:915:1: (lv_exceptionType_6_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:916:3: lv_exceptionType_6_0= RULE_STRING
                    {
                    lv_exceptionType_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1651); 

                    			newLeafNode(lv_exceptionType_6_0, grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultIssueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"exceptionType",
                            		lv_exceptionType_6_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:932:4: (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==13) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:932:6: otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleResultIssue1671); 

                        	newLeafNode(otherlv_7, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:936:1: ( (lv_issues_8_0= ruleResultIssue ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==24) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:937:1: (lv_issues_8_0= ruleResultIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:937:1: (lv_issues_8_0= ruleResultIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:938:3: lv_issues_8_0= ruleResultIssue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultIssue1692);
                    	    lv_issues_8_0=ruleResultIssue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getResultIssueRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issues",
                    	            		lv_issues_8_0, 
                    	            		"ResultIssue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleResultIssue1705); 

                        	newLeafNode(otherlv_9, grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2());
                        

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
    // $ANTLR end "ruleResultIssue"


    // $ANTLR start "entryRuleResultData"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:966:1: entryRuleResultData returns [EObject current=null] : iv_ruleResultData= ruleResultData EOF ;
    public final EObject entryRuleResultData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultData = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:967:2: (iv_ruleResultData= ruleResultData EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:968:2: iv_ruleResultData= ruleResultData EOF
            {
             newCompositeNode(grammarAccess.getResultDataRule()); 
            pushFollow(FOLLOW_ruleResultData_in_entryRuleResultData1743);
            iv_ruleResultData=ruleResultData();

            state._fsp--;

             current =iv_ruleResultData; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultData1753); 

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:975:1: ruleResultData returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleResultData() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:978:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:979:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:979:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:979:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:979:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:980:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:980:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:981:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultData1795); 

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

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleResultData1812); 

                	newLeafNode(otherlv_1, grammarAccess.getResultDataAccess().getEqualsSignKeyword_1());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1001:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1002:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1002:1: (lv_value_2_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1003:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultData1829); 

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1027:1: entryRuleURIID returns [String current=null] : iv_ruleURIID= ruleURIID EOF ;
    public final String entryRuleURIID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURIID = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:2: (iv_ruleURIID= ruleURIID EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1029:2: iv_ruleURIID= ruleURIID EOF
            {
             newCompositeNode(grammarAccess.getURIIDRule()); 
            pushFollow(FOLLOW_ruleURIID_in_entryRuleURIID1871);
            iv_ruleURIID=ruleURIID();

            state._fsp--;

             current =iv_ruleURIID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIID1882); 

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1036:1: ruleURIID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleURIID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1039:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1040:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIID1921); 

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


    // $ANTLR start "ruleResultIssueType"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1055:1: ruleResultIssueType returns [Enumerator current=null] : ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'info' ) | (enumLiteral_3= 'success' ) | (enumLiteral_4= 'fail' ) | (enumLiteral_5= 'unknown' ) ) ;
    public final Enumerator ruleResultIssueType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1057:28: ( ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'info' ) | (enumLiteral_3= 'success' ) | (enumLiteral_4= 'fail' ) | (enumLiteral_5= 'unknown' ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1058:1: ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'info' ) | (enumLiteral_3= 'success' ) | (enumLiteral_4= 'fail' ) | (enumLiteral_5= 'unknown' ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1058:1: ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'info' ) | (enumLiteral_3= 'success' ) | (enumLiteral_4= 'fail' ) | (enumLiteral_5= 'unknown' ) )
            int alt26=6;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt26=1;
                }
                break;
            case 27:
                {
                alt26=2;
                }
                break;
            case 28:
                {
                alt26=3;
                }
                break;
            case 29:
                {
                alt26=4;
                }
                break;
            case 30:
                {
                alt26=5;
                }
                break;
            case 31:
                {
                alt26=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1058:2: (enumLiteral_0= 'error' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1058:2: (enumLiteral_0= 'error' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1058:4: enumLiteral_0= 'error'
                    {
                    enumLiteral_0=(Token)match(input,26,FOLLOW_26_in_ruleResultIssueType1979); 

                            current = grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1064:6: (enumLiteral_1= 'warning' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1064:6: (enumLiteral_1= 'warning' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1064:8: enumLiteral_1= 'warning'
                    {
                    enumLiteral_1=(Token)match(input,27,FOLLOW_27_in_ruleResultIssueType1996); 

                            current = grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1070:6: (enumLiteral_2= 'info' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1070:6: (enumLiteral_2= 'info' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1070:8: enumLiteral_2= 'info'
                    {
                    enumLiteral_2=(Token)match(input,28,FOLLOW_28_in_ruleResultIssueType2013); 

                            current = grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1076:6: (enumLiteral_3= 'success' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1076:6: (enumLiteral_3= 'success' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1076:8: enumLiteral_3= 'success'
                    {
                    enumLiteral_3=(Token)match(input,29,FOLLOW_29_in_ruleResultIssueType2030); 

                            current = grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1082:6: (enumLiteral_4= 'fail' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1082:6: (enumLiteral_4= 'fail' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1082:8: enumLiteral_4= 'fail'
                    {
                    enumLiteral_4=(Token)match(input,30,FOLLOW_30_in_ruleResultIssueType2047); 

                            current = grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1088:6: (enumLiteral_5= 'unknown' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1088:6: (enumLiteral_5= 'unknown' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1088:8: enumLiteral_5= 'unknown'
                    {
                    enumLiteral_5=(Token)match(input,31,FOLLOW_31_in_ruleResultIssueType2064); 

                            current = grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5()); 
                        

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
    // $ANTLR end "ruleResultIssueType"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleResultReports_in_entryRuleResultReports75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReports85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReport_in_ruleResultReports132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_ruleResultReports159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssueReport_in_ruleResultReports186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_entryRuleResultReportCollection221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReportCollection231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleResultReportCollection268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultReportCollection285 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleResultReportCollection303 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportCollection320 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleResultReportCollection339 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleResultReportCollection351 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultReportCollection374 = new BitSet(new long[]{0x0000000001038000L});
    public static final BitSet FOLLOW_15_in_ruleResultReportCollection387 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportCollection404 = new BitSet(new long[]{0x0000000001030000L});
    public static final BitSet FOLLOW_ruleResultReport_in_ruleResultReportCollection432 = new BitSet(new long[]{0x0000000001030000L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultReportCollection454 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleResultReportCollection467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReport_in_entryRuleResultReport503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReport513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleResultReport559 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultReport576 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_12_in_ruleResultReport594 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReport611 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultReport641 = new BitSet(new long[]{0x00000000FC000000L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_ruleResultReport662 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReport679 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_18_in_ruleResultReport697 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReport714 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleResultReport733 = new BitSet(new long[]{0x0000000001198000L});
    public static final BitSet FOLLOW_15_in_ruleResultReport746 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReport763 = new BitSet(new long[]{0x0000000001190000L});
    public static final BitSet FOLLOW_19_in_ruleResultReport783 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReport800 = new BitSet(new long[]{0x0000000001310000L});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultReport826 = new BitSet(new long[]{0x0000000001310000L});
    public static final BitSet FOLLOW_20_in_ruleResultReport842 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultReport863 = new BitSet(new long[]{0x0000000001010010L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultReport887 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleResultReport900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_entryRuleResultContributor936 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultContributor946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleResultContributor992 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultContributor1015 = new BitSet(new long[]{0x00000000FC000000L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_ruleResultContributor1036 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultContributor1053 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_18_in_ruleResultContributor1071 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultContributor1088 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleResultContributor1107 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleResultContributor1119 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultContributor1136 = new BitSet(new long[]{0x0000000001210020L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultContributor1163 = new BitSet(new long[]{0x0000000001210000L});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultContributor1185 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_16_in_ruleResultContributor1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssueReport_in_entryRuleIssueReport1234 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIssueReport1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleIssueReport1290 = new BitSet(new long[]{0x00000000FC000000L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_ruleIssueReport1311 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIssueReport1328 = new BitSet(new long[]{0x0000000000046002L});
    public static final BitSet FOLLOW_14_in_ruleIssueReport1346 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleIssueReport1369 = new BitSet(new long[]{0x0000000000042002L});
    public static final BitSet FOLLOW_18_in_ruleIssueReport1384 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIssueReport1401 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleIssueReport1421 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleIssueReport1442 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_16_in_ruleIssueReport1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_entryRuleResultIssue1493 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultIssue1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleResultIssue1540 = new BitSet(new long[]{0x00000000FC000000L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_ruleResultIssue1561 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1578 = new BitSet(new long[]{0x0000000000046002L});
    public static final BitSet FOLLOW_14_in_ruleResultIssue1596 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultIssue1619 = new BitSet(new long[]{0x0000000000042002L});
    public static final BitSet FOLLOW_18_in_ruleResultIssue1634 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1651 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleResultIssue1671 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultIssue1692 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_16_in_ruleResultIssue1705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_entryRuleResultData1743 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultData1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultData1795 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleResultData1812 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultData1829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_entryRuleURIID1871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIID1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIID1921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleResultIssueType1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleResultIssueType1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleResultIssueType2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleResultIssueType2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleResultIssueType2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleResultIssueType2064 = new BitSet(new long[]{0x0000000000000002L});

}
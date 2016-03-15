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
import java.util.Map;
import java.util.HashMap;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_REAL_LIT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_EXTENDED_DIGIT", "RULE_BASED_INTEGER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'reports'", "':'", "'for'", "'['", "'description'", "']'", "'report'", "'heading'", "'results'", "'contributor'", "'='", "'issues'", "'this'", "'target'", "'exception'", "'diagnosticId'", "'boolean'", "'integer'", "'real'", "'string'", "'#'", "'.'", "'%'", "'in'", "'img'", "'/'", "'or'", "'and'", "'=='", "'!='", "'>='", "'<'", "'>'", "'+'", "'-'", "'*'", "'div'", "'mod'", "'!'", "'('", "','", "')'", "'{'", "'}'", "'true'", "'false'", "'null'", "'::'", "'tbd'", "'error'", "'warning'", "'info'", "'success'", "'fail'"
    };
    public static final int T__50=50;
    public static final int RULE_INT_EXPONENT=10;
    public static final int T__19=19;
    public static final int T__59=59;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_BASED_INTEGER=12;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_DIGIT=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int RULE_REAL_LIT=7;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=14;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=15;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_EXPONENT=9;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int RULE_EXTENDED_DIGIT=11;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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
        	return "ResultReport";	
       	}
       	
       	@Override
       	protected ResultsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleResultReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:80:1: entryRuleResultReport returns [EObject current=null] : iv_ruleResultReport= ruleResultReport EOF ;
    public final EObject entryRuleResultReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:81:2: (iv_ruleResultReport= ruleResultReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:82:2: iv_ruleResultReport= ruleResultReport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultReportRule()); 
            }
            pushFollow(FOLLOW_ruleResultReport_in_entryRuleResultReport75);
            iv_ruleResultReport=ruleResultReport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultReport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReport85); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:89:1: ruleResultReport returns [EObject current=null] : (this_ResultDataReport_0= ruleResultDataReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport ) ;
    public final EObject ruleResultReport() throws RecognitionException {
        EObject current = null;

        EObject this_ResultDataReport_0 = null;

        EObject this_ResultReportCollection_1 = null;

        EObject this_IssuesReport_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:92:28: ( (this_ResultDataReport_0= ruleResultDataReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:93:1: (this_ResultDataReport_0= ruleResultDataReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:93:1: (this_ResultDataReport_0= ruleResultDataReport | this_ResultReportCollection_1= ruleResultReportCollection | this_IssuesReport_2= ruleIssuesReport )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt1=1;
                }
                break;
            case 17:
                {
                alt1=2;
                }
                break;
            case 28:
                {
                alt1=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:94:5: this_ResultDataReport_0= ruleResultDataReport
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getResultReportAccess().getResultDataReportParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleResultDataReport_in_ruleResultReport132);
                    this_ResultDataReport_0=ruleResultDataReport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ResultDataReport_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:104:5: this_ResultReportCollection_1= ruleResultReportCollection
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getResultReportAccess().getResultReportCollectionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleResultReportCollection_in_ruleResultReport159);
                    this_ResultReportCollection_1=ruleResultReportCollection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ResultReportCollection_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:114:5: this_IssuesReport_2= ruleIssuesReport
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getResultReportAccess().getIssuesReportParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIssuesReport_in_ruleResultReport186);
                    this_IssuesReport_2=ruleIssuesReport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IssuesReport_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleResultReport"


    // $ANTLR start "entryRuleResultReportCollection"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:130:1: entryRuleResultReportCollection returns [EObject current=null] : iv_ruleResultReportCollection= ruleResultReportCollection EOF ;
    public final EObject entryRuleResultReportCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReportCollection = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:131:2: (iv_ruleResultReportCollection= ruleResultReportCollection EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:132:2: iv_ruleResultReportCollection= ruleResultReportCollection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultReportCollectionRule()); 
            }
            pushFollow(FOLLOW_ruleResultReportCollection_in_entryRuleResultReportCollection221);
            iv_ruleResultReportCollection=ruleResultReportCollection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultReportCollection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReportCollection231); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:139:1: ruleResultReportCollection returns [EObject current=null] : (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' ) ;
    public final EObject ruleResultReportCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_description_8_0=null;
        Token otherlv_11=null;
        EObject lv_content_9_0 = null;

        EObject lv_issues_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:142:28: ( (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:1: (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:1: (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:3: otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleResultReportCollection268); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:147:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:148:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:148:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:149:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultReportCollection285); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

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


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:165:2: (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:165:4: otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleResultReportCollection303); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:169:1: ( (lv_title_3_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:170:1: (lv_title_3_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:170:1: (lv_title_3_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:171:3: lv_title_3_0= RULE_STRING
                    {
                    lv_title_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReportCollection320); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_title_3_0, grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

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


                    }
                    break;

            }

            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleResultReportCollection339); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getResultReportCollectionAccess().getForKeyword_3());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:191:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:192:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:192:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:193:3: ruleURIID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getResultReportCollectionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleURIID_in_ruleResultReportCollection362);
            ruleURIID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleResultReportCollection374); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_5());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:210:1: (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==21) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:210:3: otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleResultReportCollection387); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:214:1: ( (lv_description_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:215:1: (lv_description_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:215:1: (lv_description_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:216:3: lv_description_8_0= RULE_STRING
                    {
                    lv_description_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReportCollection404); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_8_0, grammarAccess.getResultReportCollectionAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultReportCollectionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_8_0, 
                              		"STRING");
                      	    
                    }

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

                if ( (LA4_0==17||LA4_0==23||LA4_0==28) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:233:1: (lv_content_9_0= ruleResultReport )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:233:1: (lv_content_9_0= ruleResultReport )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:234:3: lv_content_9_0= ruleResultReport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleResultReport_in_ruleResultReportCollection432);
            	    lv_content_9_0=ruleResultReport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:250:3: ( (lv_issues_10_0= ruleResultIssue ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=65 && LA5_0<=70)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:251:1: (lv_issues_10_0= ruleResultIssue )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:251:1: (lv_issues_10_0= ruleResultIssue )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:252:3: lv_issues_10_0= ruleResultIssue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getResultReportCollectionAccess().getIssuesResultIssueParserRuleCall_8_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultReportCollection454);
                    lv_issues_10_0=ruleResultIssue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }
                    break;

            }

            otherlv_11=(Token)match(input,22,FOLLOW_22_in_ruleResultReportCollection467); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleResultReportCollection"


    // $ANTLR start "entryRuleResultDataReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:280:1: entryRuleResultDataReport returns [EObject current=null] : iv_ruleResultDataReport= ruleResultDataReport EOF ;
    public final EObject entryRuleResultDataReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultDataReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:281:2: (iv_ruleResultDataReport= ruleResultDataReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:282:2: iv_ruleResultDataReport= ruleResultDataReport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultDataReportRule()); 
            }
            pushFollow(FOLLOW_ruleResultDataReport_in_entryRuleResultDataReport503);
            iv_ruleResultDataReport=ruleResultDataReport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultDataReport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultDataReport513); if (state.failed) return current;

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
    // $ANTLR end "entryRuleResultDataReport"


    // $ANTLR start "ruleResultDataReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:289:1: ruleResultDataReport returns [EObject current=null] : (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' ) ;
    public final EObject ruleResultDataReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_description_8_0=null;
        Token otherlv_9=null;
        Token lv_heading_10_0=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        EObject lv_content_11_0 = null;

        EObject lv_resultData_13_0 = null;

        EObject lv_issues_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:292:28: ( (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:3: otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleResultDataReport550); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getResultDataReportAccess().getReportKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:297:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:298:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:298:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:299:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultDataReport567); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getResultDataReportAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getResultDataReportRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:315:2: (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:315:4: otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleResultDataReport585); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getResultDataReportAccess().getColonKeyword_2_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:319:1: ( (lv_title_3_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:320:1: (lv_title_3_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:320:1: (lv_title_3_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:321:3: lv_title_3_0= RULE_STRING
                    {
                    lv_title_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultDataReport602); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_title_3_0, grammarAccess.getResultDataReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultDataReportRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"title",
                              		lv_title_3_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleResultDataReport621); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getResultDataReportAccess().getForKeyword_3());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:341:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:342:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:342:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:343:3: ruleURIID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getResultDataReportRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResultDataReportAccess().getTargetEObjectCrossReference_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleURIID_in_ruleResultDataReport644);
            ruleURIID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleResultDataReport656); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getResultDataReportAccess().getLeftSquareBracketKeyword_5());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:360:1: (otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:360:3: otherlv_7= 'description' ( (lv_description_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleResultDataReport669); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getResultDataReportAccess().getDescriptionKeyword_6_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:364:1: ( (lv_description_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:365:1: (lv_description_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:365:1: (lv_description_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:366:3: lv_description_8_0= RULE_STRING
                    {
                    lv_description_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultDataReport686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_8_0, grammarAccess.getResultDataReportAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultDataReportRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:382:4: (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:382:6: otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )*
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleResultDataReport706); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getResultDataReportAccess().getHeadingKeyword_7_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:386:1: ( (lv_heading_10_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:387:1: (lv_heading_10_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:387:1: (lv_heading_10_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:388:3: lv_heading_10_0= RULE_STRING
                    {
                    lv_heading_10_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultDataReport723); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_heading_10_0, grammarAccess.getResultDataReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultDataReportRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"heading",
                              		lv_heading_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:404:2: ( (lv_content_11_0= ruleResultContributor ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==26) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:405:1: (lv_content_11_0= ruleResultContributor )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:405:1: (lv_content_11_0= ruleResultContributor )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:406:3: lv_content_11_0= ruleResultContributor
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getResultDataReportAccess().getContentResultContributorParserRuleCall_7_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultContributor_in_ruleResultDataReport749);
                    	    lv_content_11_0=ruleResultContributor();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getResultDataReportRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"content",
                    	              		lv_content_11_0, 
                    	              		"ResultContributor");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:422:5: (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:422:7: otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+
                    {
                    otherlv_12=(Token)match(input,25,FOLLOW_25_in_ruleResultDataReport765); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getResultDataReportAccess().getResultsKeyword_8_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:426:1: ( (lv_resultData_13_0= ruleResultData ) )+
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
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:427:1: (lv_resultData_13_0= ruleResultData )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:427:1: (lv_resultData_13_0= ruleResultData )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:428:3: lv_resultData_13_0= ruleResultData
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getResultDataReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultData_in_ruleResultDataReport786);
                    	    lv_resultData_13_0=ruleResultData();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getResultDataReportRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"resultData",
                    	              		lv_resultData_13_0, 
                    	              		"ResultData");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:444:5: ( (lv_issues_14_0= ruleResultIssue ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=65 && LA12_0<=70)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:445:1: (lv_issues_14_0= ruleResultIssue )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:445:1: (lv_issues_14_0= ruleResultIssue )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:446:3: lv_issues_14_0= ruleResultIssue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getResultDataReportAccess().getIssuesResultIssueParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultDataReport810);
            	    lv_issues_14_0=ruleResultIssue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getResultDataReportRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"issues",
            	              		lv_issues_14_0, 
            	              		"ResultIssue");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_15=(Token)match(input,22,FOLLOW_22_in_ruleResultDataReport823); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getResultDataReportAccess().getRightSquareBracketKeyword_10());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleResultDataReport"


    // $ANTLR start "entryRuleResultContributor"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:474:1: entryRuleResultContributor returns [EObject current=null] : iv_ruleResultContributor= ruleResultContributor EOF ;
    public final EObject entryRuleResultContributor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultContributor = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:475:2: (iv_ruleResultContributor= ruleResultContributor EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:476:2: iv_ruleResultContributor= ruleResultContributor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultContributorRule()); 
            }
            pushFollow(FOLLOW_ruleResultContributor_in_entryRuleResultContributor859);
            iv_ruleResultContributor=ruleResultContributor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultContributor; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultContributor869); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:483:1: ruleResultContributor returns [EObject current=null] : (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )? ( (lv_issues_5_0= ruleResultIssue ) )* ( (lv_subcontributor_6_0= ruleResultContributor ) )* otherlv_7= ']' ) ;
    public final EObject ruleResultContributor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_resultData_4_0 = null;

        EObject lv_issues_5_0 = null;

        EObject lv_subcontributor_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:486:28: ( (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )? ( (lv_issues_5_0= ruleResultIssue ) )* ( (lv_subcontributor_6_0= ruleResultContributor ) )* otherlv_7= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:487:1: (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )? ( (lv_issues_5_0= ruleResultIssue ) )* ( (lv_subcontributor_6_0= ruleResultContributor ) )* otherlv_7= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:487:1: (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )? ( (lv_issues_5_0= ruleResultIssue ) )* ( (lv_subcontributor_6_0= ruleResultContributor ) )* otherlv_7= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:487:3: otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= '[' (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )? ( (lv_issues_5_0= ruleResultIssue ) )* ( (lv_subcontributor_6_0= ruleResultContributor ) )* otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleResultContributor906); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getResultContributorAccess().getContributorKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:491:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:492:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:492:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:493:3: ruleURIID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getResultContributorRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleURIID_in_ruleResultContributor929);
            ruleURIID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleResultContributor941); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:510:1: (otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+ )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:510:3: otherlv_3= 'results' ( (lv_resultData_4_0= ruleResultData ) )+
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleResultContributor954); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getResultContributorAccess().getResultsKeyword_3_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:514:1: ( (lv_resultData_4_0= ruleResultData ) )+
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
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:515:1: (lv_resultData_4_0= ruleResultData )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:515:1: (lv_resultData_4_0= ruleResultData )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:516:3: lv_resultData_4_0= ruleResultData
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getResultContributorAccess().getResultDataResultDataParserRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultData_in_ruleResultContributor975);
                    	    lv_resultData_4_0=ruleResultData();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"resultData",
                    	              		lv_resultData_4_0, 
                    	              		"ResultData");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:532:5: ( (lv_issues_5_0= ruleResultIssue ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=65 && LA15_0<=70)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:533:1: (lv_issues_5_0= ruleResultIssue )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:533:1: (lv_issues_5_0= ruleResultIssue )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:534:3: lv_issues_5_0= ruleResultIssue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultContributor999);
            	    lv_issues_5_0=ruleResultIssue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"issues",
            	              		lv_issues_5_0, 
            	              		"ResultIssue");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:550:3: ( (lv_subcontributor_6_0= ruleResultContributor ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:551:1: (lv_subcontributor_6_0= ruleResultContributor )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:551:1: (lv_subcontributor_6_0= ruleResultContributor )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:552:3: lv_subcontributor_6_0= ruleResultContributor
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleResultContributor_in_ruleResultContributor1021);
            	    lv_subcontributor_6_0=ruleResultContributor();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"subcontributor",
            	              		lv_subcontributor_6_0, 
            	              		"ResultContributor");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_7=(Token)match(input,22,FOLLOW_22_in_ruleResultContributor1034); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleResultContributor"


    // $ANTLR start "entryRuleResultData"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:580:1: entryRuleResultData returns [EObject current=null] : iv_ruleResultData= ruleResultData EOF ;
    public final EObject entryRuleResultData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultData = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:581:2: (iv_ruleResultData= ruleResultData EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:582:2: iv_ruleResultData= ruleResultData EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultDataRule()); 
            }
            pushFollow(FOLLOW_ruleResultData_in_entryRuleResultData1070);
            iv_ruleResultData=ruleResultData();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultData; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultData1080); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:589:1: ruleResultData returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) ) ) ;
    public final EObject ruleResultData() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token lv_integerValue_3_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:592:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:593:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:593:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:593:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:593:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:594:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:594:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:595:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultData1122); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

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


            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleResultData1139); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getResultDataAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:615:1: ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_integerValue_3_0= RULE_INT ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_STRING) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_INT) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:615:2: ( (lv_value_2_0= RULE_STRING ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:615:2: ( (lv_value_2_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:616:1: (lv_value_2_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:616:1: (lv_value_2_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:617:3: lv_value_2_0= RULE_STRING
                    {
                    lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultData1157); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_2_0, grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

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
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:634:6: ( (lv_integerValue_3_0= RULE_INT ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:634:6: ( (lv_integerValue_3_0= RULE_INT ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:635:1: (lv_integerValue_3_0= RULE_INT )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:635:1: (lv_integerValue_3_0= RULE_INT )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:636:3: lv_integerValue_3_0= RULE_INT
                    {
                    lv_integerValue_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleResultData1185); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_integerValue_3_0, grammarAccess.getResultDataAccess().getIntegerValueINTTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultDataRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"integerValue",
                              		lv_integerValue_3_0, 
                              		"INT");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleResultData"


    // $ANTLR start "entryRuleIssuesReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:660:1: entryRuleIssuesReport returns [EObject current=null] : iv_ruleIssuesReport= ruleIssuesReport EOF ;
    public final EObject entryRuleIssuesReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIssuesReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:661:2: (iv_ruleIssuesReport= ruleIssuesReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:662:2: iv_ruleIssuesReport= ruleIssuesReport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIssuesReportRule()); 
            }
            pushFollow(FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport1227);
            iv_ruleIssuesReport=ruleIssuesReport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIssuesReport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIssuesReport1237); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:669:1: ruleIssuesReport returns [EObject current=null] : (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? ) ;
    public final EObject ruleIssuesReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_8=null;
        EObject lv_issues_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:672:28: ( (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:673:1: (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:673:1: (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:673:3: otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleIssuesReport1274); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIssuesReportAccess().getIssuesKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:677:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:678:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:678:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:679:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIssuesReport1291); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

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


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:695:2: (otherlv_2= 'for' ( ( ruleURIID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==19) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:695:4: otherlv_2= 'for' ( ( ruleURIID ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleIssuesReport1309); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getIssuesReportAccess().getForKeyword_2_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:699:1: ( ( ruleURIID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:700:1: ( ruleURIID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:700:1: ( ruleURIID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:701:3: ruleURIID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getIssuesReportRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleURIID_in_ruleIssuesReport1332);
                    ruleURIID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:714:4: (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==20) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:714:6: otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']'
                    {
                    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleIssuesReport1347); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:718:1: (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==21) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:718:3: otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) )
                            {
                            otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleIssuesReport1360); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getIssuesReportAccess().getDescriptionKeyword_3_1_0());
                                  
                            }
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:722:1: ( (lv_description_6_0= RULE_STRING ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:723:1: (lv_description_6_0= RULE_STRING )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:723:1: (lv_description_6_0= RULE_STRING )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:724:3: lv_description_6_0= RULE_STRING
                            {
                            lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIssuesReport1377); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_description_6_0, grammarAccess.getIssuesReportAccess().getDescriptionSTRINGTerminalRuleCall_3_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getIssuesReportRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"description",
                                      		lv_description_6_0, 
                                      		"STRING");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:740:4: ( (lv_issues_7_0= ruleResultIssue ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=65 && LA20_0<=70)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:741:1: (lv_issues_7_0= ruleResultIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:741:1: (lv_issues_7_0= ruleResultIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:742:3: lv_issues_7_0= ruleResultIssue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getIssuesReportAccess().getIssuesResultIssueParserRuleCall_3_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultIssue_in_ruleIssuesReport1405);
                    	    lv_issues_7_0=ruleResultIssue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getIssuesReportRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"issues",
                    	              		lv_issues_7_0, 
                    	              		"ResultIssue");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleIssuesReport1418); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_3_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleIssuesReport"


    // $ANTLR start "entryRuleDescriptionElement"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:772:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:773:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:774:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            }
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1458);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescriptionElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement1468); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:781:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_thisTarget_2_0=null;
        EObject lv_showValue_1_0 = null;

        EObject lv_image_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:784:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:785:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:785:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) )
            int alt22=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt22=1;
                }
                break;
            case RULE_ID:
                {
                alt22=2;
                }
                break;
            case 29:
                {
                alt22=3;
                }
                break;
            case 41:
                {
                alt22=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:785:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:785:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:786:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:786:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:787:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement1510); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_text_0_0, grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:804:6: ( (lv_showValue_1_0= ruleShowValue ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:804:6: ( (lv_showValue_1_0= ruleShowValue ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:805:1: (lv_showValue_1_0= ruleShowValue )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:805:1: (lv_showValue_1_0= ruleShowValue )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:806:3: lv_showValue_1_0= ruleShowValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleShowValue_in_ruleDescriptionElement1542);
                    lv_showValue_1_0=ruleShowValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                      	        }
                             		set(
                             			current, 
                             			"showValue",
                              		lv_showValue_1_0, 
                              		"ShowValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:823:6: ( (lv_thisTarget_2_0= 'this' ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:823:6: ( (lv_thisTarget_2_0= 'this' ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:824:1: (lv_thisTarget_2_0= 'this' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:824:1: (lv_thisTarget_2_0= 'this' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:825:3: lv_thisTarget_2_0= 'this'
                    {
                    lv_thisTarget_2_0=(Token)match(input,29,FOLLOW_29_in_ruleDescriptionElement1566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_thisTarget_2_0, grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                      	        }
                             		setWithLastConsumed(current, "thisTarget", true, "this");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:839:6: ( (lv_image_3_0= ruleImageReference ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:839:6: ( (lv_image_3_0= ruleImageReference ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:840:1: (lv_image_3_0= ruleImageReference )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:840:1: (lv_image_3_0= ruleImageReference )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:841:3: lv_image_3_0= ruleImageReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleImageReference_in_ruleDescriptionElement1606);
                    lv_image_3_0=ruleImageReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                      	        }
                             		set(
                             			current, 
                             			"image",
                              		lv_image_3_0, 
                              		"ImageReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleDescriptionElement"


    // $ANTLR start "entryRuleResultIssue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:869:1: entryRuleResultIssue returns [EObject current=null] : iv_ruleResultIssue= ruleResultIssue EOF ;
    public final EObject entryRuleResultIssue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultIssue = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:870:2: (iv_ruleResultIssue= ruleResultIssue EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:871:2: iv_ruleResultIssue= ruleResultIssue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultIssueRule()); 
            }
            pushFollow(FOLLOW_ruleResultIssue_in_entryRuleResultIssue1646);
            iv_ruleResultIssue=ruleResultIssue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultIssue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultIssue1656); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:878:1: ruleResultIssue returns [EObject current=null] : ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? ) ;
    public final EObject ruleResultIssue() throws RecognitionException {
        EObject current = null;

        Token lv_message_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_exceptionType_5_0=null;
        Token otherlv_6=null;
        Token lv_diagnosticId_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Enumerator lv_issueType_0_0 = null;

        EObject lv_issues_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:881:28: ( ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:882:1: ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:882:1: ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:882:2: ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:882:2: ( (lv_issueType_0_0= ruleResultIssueType ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:883:1: (lv_issueType_0_0= ruleResultIssueType )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:883:1: (lv_issueType_0_0= ruleResultIssueType )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:884:3: lv_issueType_0_0= ruleResultIssueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleResultIssueType_in_ruleResultIssue1702);
            lv_issueType_0_0=ruleResultIssueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getResultIssueRule());
              	        }
                     		set(
                     			current, 
                     			"issueType",
                      		lv_issueType_0_0, 
                      		"ResultIssueType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:900:2: ( (lv_message_1_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:901:1: (lv_message_1_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:901:1: (lv_message_1_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:902:3: lv_message_1_0= RULE_STRING
            {
            lv_message_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1719); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_message_1_0, grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getResultIssueRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"message",
                      		lv_message_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:918:2: (otherlv_2= 'target' ( ( ruleURIID ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:918:4: otherlv_2= 'target' ( ( ruleURIID ) )
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleResultIssue1737); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getResultIssueAccess().getTargetKeyword_2_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:922:1: ( ( ruleURIID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:923:1: ( ruleURIID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:923:1: ( ruleURIID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:924:3: ruleURIID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultIssueRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleURIID_in_ruleResultIssue1760);
                    ruleURIID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:937:4: (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:937:6: otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleResultIssue1775); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getResultIssueAccess().getExceptionKeyword_3_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:941:1: ( (lv_exceptionType_5_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:942:1: (lv_exceptionType_5_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:942:1: (lv_exceptionType_5_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:943:3: lv_exceptionType_5_0= RULE_STRING
                    {
                    lv_exceptionType_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_exceptionType_5_0, grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultIssueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"exceptionType",
                              		lv_exceptionType_5_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:959:4: (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:959:6: otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleResultIssue1812); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getResultIssueAccess().getDiagnosticIdKeyword_4_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:963:1: ( (lv_diagnosticId_7_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:964:1: (lv_diagnosticId_7_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:964:1: (lv_diagnosticId_7_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:965:3: lv_diagnosticId_7_0= RULE_STRING
                    {
                    lv_diagnosticId_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1829); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_diagnosticId_7_0, grammarAccess.getResultIssueAccess().getDiagnosticIdSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultIssueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"diagnosticId",
                              		lv_diagnosticId_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:981:4: (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==20) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:981:6: otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleResultIssue1849); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:985:1: ( (lv_issues_9_0= ruleResultIssue ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( ((LA26_0>=65 && LA26_0<=70)) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:986:1: (lv_issues_9_0= ruleResultIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:986:1: (lv_issues_9_0= ruleResultIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:987:3: lv_issues_9_0= ruleResultIssue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultIssue1870);
                    	    lv_issues_9_0=ruleResultIssue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getResultIssueRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"issues",
                    	              		lv_issues_9_0, 
                    	              		"ResultIssue");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleResultIssue1883); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleResultIssue"


    // $ANTLR start "entryRuleTypeRef"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1015:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1016:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1017:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef1921);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef1931); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1024:1: ruleTypeRef returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' ) | ( () otherlv_5= 'real' ) | ( () otherlv_7= 'string' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1027:28: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' ) | ( () otherlv_5= 'real' ) | ( () otherlv_7= 'string' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:1: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' ) | ( () otherlv_5= 'real' ) | ( () otherlv_7= 'string' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:1: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' ) | ( () otherlv_5= 'real' ) | ( () otherlv_7= 'string' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            int alt28=5;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt28=1;
                }
                break;
            case 34:
                {
                alt28=2;
                }
                break;
            case 35:
                {
                alt28=3;
                }
                break;
            case 36:
                {
                alt28=4;
                }
                break;
            case RULE_ID:
                {
                alt28=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:2: ( () otherlv_1= 'boolean' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:2: ( () otherlv_1= 'boolean' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:3: () otherlv_1= 'boolean'
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:3: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1029:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlBooleanAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleTypeRef1978); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeRefAccess().getBooleanKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1039:6: ( () otherlv_3= 'integer' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1039:6: ( () otherlv_3= 'integer' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1039:7: () otherlv_3= 'integer'
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1039:7: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1040:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlIntegerAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleTypeRef2007); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypeRefAccess().getIntegerKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1050:6: ( () otherlv_5= 'real' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1050:6: ( () otherlv_5= 'real' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1050:7: () otherlv_5= 'real'
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1050:7: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1051:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlRealAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_5=(Token)match(input,35,FOLLOW_35_in_ruleTypeRef2036); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTypeRefAccess().getRealKeyword_2_1());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1061:6: ( () otherlv_7= 'string' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1061:6: ( () otherlv_7= 'string' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1061:7: () otherlv_7= 'string'
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1061:7: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1062:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlStringAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_7=(Token)match(input,36,FOLLOW_36_in_ruleTypeRef2065); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getTypeRefAccess().getStringKeyword_3_1());
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1072:6: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1072:6: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1072:7: () ( ( ruleAADLPROPERTYREFERENCE ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1072:7: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1073:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getTypeRefAction_4_0(),
                                  current);
                          
                    }

                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1078:2: ( ( ruleAADLPROPERTYREFERENCE ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1079:1: ( ruleAADLPROPERTYREFERENCE )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1079:1: ( ruleAADLPROPERTYREFERENCE )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1080:3: ruleAADLPROPERTYREFERENCE
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeRefRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeRefAccess().getTypePropertyTypeCrossReference_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef2105);
                    ruleAADLPROPERTYREFERENCE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleAModelOrPropertyReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1105:1: entryRuleAModelOrPropertyReference returns [EObject current=null] : iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF ;
    public final EObject entryRuleAModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAModelOrPropertyReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1106:2: (iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1107:2: iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAModelOrPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAModelOrPropertyReference_in_entryRuleAModelOrPropertyReference2146);
            iv_ruleAModelOrPropertyReference=ruleAModelOrPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAModelOrPropertyReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAModelOrPropertyReference2156); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAModelOrPropertyReference"


    // $ANTLR start "ruleAModelOrPropertyReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1114:1: ruleAModelOrPropertyReference returns [EObject current=null] : ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference ) ;
    public final EObject ruleAModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AModelReference_0 = null;

        EObject this_APropertyReference_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1117:28: ( ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1118:1: ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1118:1: ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==29) ) {
                alt30=1;
            }
            else if ( (LA30_0==37) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1118:2: (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1118:2: (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1119:5: this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAModelReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAModelReference_in_ruleAModelOrPropertyReference2204);
                    this_AModelReference_0=ruleAModelReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AModelReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1127:1: ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==37) && (synpred1_InternalResults())) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1127:2: ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1127:2: ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1127:3: ( ( () '#' ) )=> ( () otherlv_2= '#' )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1129:5: ( () otherlv_2= '#' )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1129:6: () otherlv_2= '#'
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1129:6: ()
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1130:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            otherlv_2=(Token)match(input,37,FOLLOW_37_in_ruleAModelOrPropertyReference2239); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getAModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1());
                                  
                            }

                            }


                            }

                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1139:3: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1140:1: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1140:1: ( ruleAADLPROPERTYREFERENCE )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1141:3: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getAModelOrPropertyReferenceRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAModelOrPropertyReference2264);
                            ruleAADLPROPERTYREFERENCE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1156:5: this_APropertyReference_4= ruleAPropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAPropertyReference_in_ruleAModelOrPropertyReference2295);
                    this_APropertyReference_4=ruleAPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_APropertyReference_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAModelOrPropertyReference"


    // $ANTLR start "entryRuleNestedModelelement"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1172:1: entryRuleNestedModelelement returns [EObject current=null] : iv_ruleNestedModelelement= ruleNestedModelelement EOF ;
    public final EObject entryRuleNestedModelelement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedModelelement = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1173:2: (iv_ruleNestedModelelement= ruleNestedModelelement EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1174:2: iv_ruleNestedModelelement= ruleNestedModelelement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedModelelementRule()); 
            }
            pushFollow(FOLLOW_ruleNestedModelelement_in_entryRuleNestedModelelement2330);
            iv_ruleNestedModelelement=ruleNestedModelelement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedModelelement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedModelelement2340); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNestedModelelement"


    // $ANTLR start "ruleNestedModelelement"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1181:1: ruleNestedModelelement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_next_2_0= ruleNestedModelelement ) ) )? ) ;
    public final EObject ruleNestedModelelement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_next_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1184:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_next_2_0= ruleNestedModelelement ) ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1185:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_next_2_0= ruleNestedModelelement ) ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1185:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_next_2_0= ruleNestedModelelement ) ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1185:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_next_2_0= ruleNestedModelelement ) ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1185:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1186:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1186:1: (otherlv_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1187:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getNestedModelelementRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNestedModelelement2385); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getNestedModelelementAccess().getModelElementNamedElementCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1198:2: (otherlv_1= '.' ( (lv_next_2_0= ruleNestedModelelement ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==38) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1198:4: otherlv_1= '.' ( (lv_next_2_0= ruleNestedModelelement ) )
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleNestedModelelement2398); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNestedModelelementAccess().getFullStopKeyword_1_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1202:1: ( (lv_next_2_0= ruleNestedModelelement ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1203:1: (lv_next_2_0= ruleNestedModelelement )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1203:1: (lv_next_2_0= ruleNestedModelelement )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1204:3: lv_next_2_0= ruleNestedModelelement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNestedModelelementAccess().getNextNestedModelelementParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNestedModelelement_in_ruleNestedModelelement2419);
                    lv_next_2_0=ruleNestedModelelement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNestedModelelementRule());
                      	        }
                             		set(
                             			current, 
                             			"next",
                              		lv_next_2_0, 
                              		"NestedModelelement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleNestedModelelement"


    // $ANTLR start "entryRuleAModelReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1228:1: entryRuleAModelReference returns [EObject current=null] : iv_ruleAModelReference= ruleAModelReference EOF ;
    public final EObject entryRuleAModelReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAModelReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1229:2: (iv_ruleAModelReference= ruleAModelReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1230:2: iv_ruleAModelReference= ruleAModelReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAModelReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAModelReference_in_entryRuleAModelReference2457);
            iv_ruleAModelReference=ruleAModelReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAModelReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAModelReference2467); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAModelReference"


    // $ANTLR start "ruleAModelReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1237:1: ruleAModelReference returns [EObject current=null] : ( () otherlv_1= 'this' (otherlv_2= '.' ( (lv_next_3_0= ruleNestedModelelement ) ) )? ) ;
    public final EObject ruleAModelReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_next_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1240:28: ( ( () otherlv_1= 'this' (otherlv_2= '.' ( (lv_next_3_0= ruleNestedModelelement ) ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1241:1: ( () otherlv_1= 'this' (otherlv_2= '.' ( (lv_next_3_0= ruleNestedModelelement ) ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1241:1: ( () otherlv_1= 'this' (otherlv_2= '.' ( (lv_next_3_0= ruleNestedModelelement ) ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1241:2: () otherlv_1= 'this' (otherlv_2= '.' ( (lv_next_3_0= ruleNestedModelelement ) ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1241:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1242:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAModelReferenceAccess().getAModelReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleAModelReference2513); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAModelReferenceAccess().getThisKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1251:1: (otherlv_2= '.' ( (lv_next_3_0= ruleNestedModelelement ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==38) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1251:3: otherlv_2= '.' ( (lv_next_3_0= ruleNestedModelelement ) )
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleAModelReference2526); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAModelReferenceAccess().getFullStopKeyword_2_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1255:1: ( (lv_next_3_0= ruleNestedModelelement ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1256:1: (lv_next_3_0= ruleNestedModelelement )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1256:1: (lv_next_3_0= ruleNestedModelelement )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1257:3: lv_next_3_0= ruleNestedModelelement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAModelReferenceAccess().getNextNestedModelelementParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNestedModelelement_in_ruleAModelReference2547);
                    lv_next_3_0=ruleNestedModelelement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAModelReferenceRule());
                      	        }
                             		set(
                             			current, 
                             			"next",
                              		lv_next_3_0, 
                              		"NestedModelelement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAModelReference"


    // $ANTLR start "entryRuleAPropertyReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1281:1: entryRuleAPropertyReference returns [EObject current=null] : iv_ruleAPropertyReference= ruleAPropertyReference EOF ;
    public final EObject entryRuleAPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPropertyReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1282:2: (iv_ruleAPropertyReference= ruleAPropertyReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1283:2: iv_ruleAPropertyReference= ruleAPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAPropertyReference_in_entryRuleAPropertyReference2585);
            iv_ruleAPropertyReference=ruleAPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPropertyReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPropertyReference2595); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAPropertyReference"


    // $ANTLR start "ruleAPropertyReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1290:1: ruleAPropertyReference returns [EObject current=null] : ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) ) ;
    public final EObject ruleAPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1293:28: ( ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1294:1: ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1294:1: ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1294:2: () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1294:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1295:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleAPropertyReference2641); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAPropertyReferenceAccess().getNumberSignKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1304:1: ( ( ruleAADLPROPERTYREFERENCE ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1305:1: ( ruleAADLPROPERTYREFERENCE )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1305:1: ( ruleAADLPROPERTYREFERENCE )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1306:3: ruleAADLPROPERTYREFERENCE
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAPropertyReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAPropertyReference2664);
            ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAPropertyReference"


    // $ANTLR start "entryRuleAVariableReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1327:1: entryRuleAVariableReference returns [EObject current=null] : iv_ruleAVariableReference= ruleAVariableReference EOF ;
    public final EObject entryRuleAVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAVariableReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1328:2: (iv_ruleAVariableReference= ruleAVariableReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1329:2: iv_ruleAVariableReference= ruleAVariableReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAVariableReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAVariableReference_in_entryRuleAVariableReference2700);
            iv_ruleAVariableReference=ruleAVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAVariableReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAVariableReference2710); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAVariableReference"


    // $ANTLR start "ruleAVariableReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1336:1: ruleAVariableReference returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleAVariableReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1339:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1340:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1340:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1340:2: () ( (otherlv_1= RULE_ID ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1340:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1341:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1346:2: ( (otherlv_1= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1347:1: (otherlv_1= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1347:1: (otherlv_1= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1348:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAVariableReferenceRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAVariableReference2764); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationCrossReference_1_0()); 
              	
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAVariableReference"


    // $ANTLR start "entryRuleShowValue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1367:1: entryRuleShowValue returns [EObject current=null] : iv_ruleShowValue= ruleShowValue EOF ;
    public final EObject entryRuleShowValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShowValue = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1368:2: (iv_ruleShowValue= ruleShowValue EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1369:2: iv_ruleShowValue= ruleShowValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShowValueRule()); 
            }
            pushFollow(FOLLOW_ruleShowValue_in_entryRuleShowValue2800);
            iv_ruleShowValue=ruleShowValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShowValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShowValue2810); if (state.failed) return current;

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
    // $ANTLR end "entryRuleShowValue"


    // $ANTLR start "ruleShowValue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1376:1: ruleShowValue returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? ) ;
    public final EObject ruleShowValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1379:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1380:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1380:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1380:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1380:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1381:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1381:1: (otherlv_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1382:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getShowValueRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue2855); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getShowValueAccess().getRefAVariableDeclarationCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1393:2: (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )?
            int alt33=3;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==39) ) {
                alt33=1;
            }
            else if ( (LA33_0==40) ) {
                alt33=2;
            }
            switch (alt33) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1393:4: otherlv_1= '%'
                    {
                    otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleShowValue2868); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1398:6: (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1398:6: (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1398:8: otherlv_2= 'in' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleShowValue2887); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getShowValueAccess().getInKeyword_1_1_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1402:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1403:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1403:1: (otherlv_3= RULE_ID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1404:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getShowValueRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue2907); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleShowValue"


    // $ANTLR start "entryRuleImageReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1423:1: entryRuleImageReference returns [EObject current=null] : iv_ruleImageReference= ruleImageReference EOF ;
    public final EObject entryRuleImageReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1424:2: (iv_ruleImageReference= ruleImageReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1425:2: iv_ruleImageReference= ruleImageReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImageReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleImageReference_in_entryRuleImageReference2946);
            iv_ruleImageReference=ruleImageReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImageReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImageReference2956); if (state.failed) return current;

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
    // $ANTLR end "entryRuleImageReference"


    // $ANTLR start "ruleImageReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1432:1: ruleImageReference returns [EObject current=null] : (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) ;
    public final EObject ruleImageReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_imgfile_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1435:28: ( (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1436:1: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1436:1: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1436:3: otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleImageReference2993); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImageReferenceAccess().getImgKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1440:1: ( (lv_imgfile_1_0= ruleIMGREF ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1441:1: (lv_imgfile_1_0= ruleIMGREF )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1441:1: (lv_imgfile_1_0= ruleIMGREF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1442:3: lv_imgfile_1_0= ruleIMGREF
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIMGREF_in_ruleImageReference3014);
            lv_imgfile_1_0=ruleIMGREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImageReferenceRule());
              	        }
                     		set(
                     			current, 
                     			"imgfile",
                      		lv_imgfile_1_0, 
                      		"IMGREF");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleImageReference"


    // $ANTLR start "entryRuleIMGREF"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1466:1: entryRuleIMGREF returns [String current=null] : iv_ruleIMGREF= ruleIMGREF EOF ;
    public final String entryRuleIMGREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMGREF = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1467:2: (iv_ruleIMGREF= ruleIMGREF EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1468:2: iv_ruleIMGREF= ruleIMGREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIMGREFRule()); 
            }
            pushFollow(FOLLOW_ruleIMGREF_in_entryRuleIMGREF3051);
            iv_ruleIMGREF=ruleIMGREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIMGREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMGREF3062); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIMGREF"


    // $ANTLR start "ruleIMGREF"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1475:1: ruleIMGREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIMGREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1478:28: ( ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1479:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1479:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1479:2: (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1479:2: (this_ID_0= RULE_ID kw= '/' )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID) ) {
                    int LA34_1 = input.LA(2);

                    if ( (LA34_1==42) ) {
                        alt34=1;
                    }


                }


                switch (alt34) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1479:7: this_ID_0= RULE_ID kw= '/'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF3103); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,42,FOLLOW_42_in_ruleIMGREF3121); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF3138); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            kw=(Token)match(input,38,FOLLOW_38_in_ruleIMGREF3156); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getIMGREFAccess().getFullStopKeyword_2()); 
                  
            }
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF3171); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_4);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_4, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_3()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleIMGREF"


    // $ANTLR start "entryRuleAExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1520:1: entryRuleAExpression returns [EObject current=null] : iv_ruleAExpression= ruleAExpression EOF ;
    public final EObject entryRuleAExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1521:2: (iv_ruleAExpression= ruleAExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1522:2: iv_ruleAExpression= ruleAExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAExpression_in_entryRuleAExpression3216);
            iv_ruleAExpression=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExpression3226); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAExpression"


    // $ANTLR start "ruleAExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1529:1: ruleAExpression returns [EObject current=null] : this_AOrExpression_0= ruleAOrExpression ;
    public final EObject ruleAExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AOrExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1532:28: (this_AOrExpression_0= ruleAOrExpression )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1534:5: this_AOrExpression_0= ruleAOrExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleAOrExpression_in_ruleAExpression3272);
            this_AOrExpression_0=ruleAOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAExpression"


    // $ANTLR start "entryRuleAOrExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1550:1: entryRuleAOrExpression returns [EObject current=null] : iv_ruleAOrExpression= ruleAOrExpression EOF ;
    public final EObject entryRuleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOrExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1551:2: (iv_ruleAOrExpression= ruleAOrExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1552:2: iv_ruleAOrExpression= ruleAOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression3306);
            iv_ruleAOrExpression=ruleAOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAOrExpression3316); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAOrExpression"


    // $ANTLR start "ruleAOrExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1559:1: ruleAOrExpression returns [EObject current=null] : (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* ) ;
    public final EObject ruleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAndExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1562:28: ( (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1563:1: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1563:1: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1564:5: this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression3363);
            this_AAndExpression_0=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1572:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==43) && (synpred2_InternalResults())) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1572:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1572:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1572:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1577:6: ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1577:7: () ( (lv_operator_2_0= ruleOpOr ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1577:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1578:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1583:2: ( (lv_operator_2_0= ruleOpOr ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1584:1: (lv_operator_2_0= ruleOpOr )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1584:1: (lv_operator_2_0= ruleOpOr )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1585:3: lv_operator_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleAOrExpression3412);
            	    lv_operator_2_0=ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"OpOr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1601:4: ( (lv_rightOperand_3_0= ruleAAndExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1602:1: (lv_rightOperand_3_0= ruleAAndExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1602:1: (lv_rightOperand_3_0= ruleAAndExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1603:3: lv_rightOperand_3_0= ruleAAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getRightOperandAAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression3435);
            	    lv_rightOperand_3_0=ruleAAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"AAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1627:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1628:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1629:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr3474);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr3485); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1636:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'or' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1639:28: (kw= 'or' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1641:2: kw= 'or'
            {
            kw=(Token)match(input,43,FOLLOW_43_in_ruleOpOr3522); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleAAndExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1654:1: entryRuleAAndExpression returns [EObject current=null] : iv_ruleAAndExpression= ruleAAndExpression EOF ;
    public final EObject entryRuleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAndExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1655:2: (iv_ruleAAndExpression= ruleAAndExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1656:2: iv_ruleAAndExpression= ruleAAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression3561);
            iv_ruleAAndExpression=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAndExpression3571); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAAndExpression"


    // $ANTLR start "ruleAAndExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1663:1: ruleAAndExpression returns [EObject current=null] : (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* ) ;
    public final EObject ruleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AEqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1666:28: ( (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1667:1: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1667:1: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1668:5: this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression3618);
            this_AEqualityExpression_0=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1676:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==44) && (synpred3_InternalResults())) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1676:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1676:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1676:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1681:6: ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1681:7: () ( (lv_operator_2_0= ruleOpAnd ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1681:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1682:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1687:2: ( (lv_operator_2_0= ruleOpAnd ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1688:1: (lv_operator_2_0= ruleOpAnd )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1688:1: (lv_operator_2_0= ruleOpAnd )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1689:3: lv_operator_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleAAndExpression3667);
            	    lv_operator_2_0=ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"OpAnd");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1705:4: ( (lv_rightOperand_3_0= ruleAEqualityExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1706:1: (lv_rightOperand_3_0= ruleAEqualityExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1706:1: (lv_rightOperand_3_0= ruleAEqualityExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1707:3: lv_rightOperand_3_0= ruleAEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getRightOperandAEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression3690);
            	    lv_rightOperand_3_0=ruleAEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"AEqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1731:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1732:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1733:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd3729);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd3740); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1740:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'and' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1743:28: (kw= 'and' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1745:2: kw= 'and'
            {
            kw=(Token)match(input,44,FOLLOW_44_in_ruleOpAnd3777); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleAEqualityExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1758:1: entryRuleAEqualityExpression returns [EObject current=null] : iv_ruleAEqualityExpression= ruleAEqualityExpression EOF ;
    public final EObject entryRuleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAEqualityExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1759:2: (iv_ruleAEqualityExpression= ruleAEqualityExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1760:2: iv_ruleAEqualityExpression= ruleAEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAEqualityExpression_in_entryRuleAEqualityExpression3816);
            iv_ruleAEqualityExpression=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAEqualityExpression3826); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAEqualityExpression"


    // $ANTLR start "ruleAEqualityExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1767:1: ruleAEqualityExpression returns [EObject current=null] : (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* ) ;
    public final EObject ruleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ARelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1770:28: ( (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1771:1: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1771:1: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1772:5: this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3873);
            this_ARelationalExpression_0=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ARelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1780:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==45) && (synpred4_InternalResults())) {
                    alt37=1;
                }
                else if ( (LA37_0==46) && (synpred4_InternalResults())) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1780:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1780:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1780:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1785:6: ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1785:7: () ( (lv_operator_2_0= ruleOpEquality ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1785:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1786:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1791:2: ( (lv_operator_2_0= ruleOpEquality ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1792:1: (lv_operator_2_0= ruleOpEquality )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1792:1: (lv_operator_2_0= ruleOpEquality )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1793:3: lv_operator_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleAEqualityExpression3922);
            	    lv_operator_2_0=ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"OpEquality");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1809:4: ( (lv_rightOperand_3_0= ruleARelationalExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1810:1: (lv_rightOperand_3_0= ruleARelationalExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1810:1: (lv_rightOperand_3_0= ruleARelationalExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1811:3: lv_rightOperand_3_0= ruleARelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getRightOperandARelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3945);
            	    lv_rightOperand_3_0=ruleARelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"ARelationalExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1835:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1836:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1837:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality3984);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality3995); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1844:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1847:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1848:1: (kw= '==' | kw= '!=' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1848:1: (kw= '==' | kw= '!=' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==45) ) {
                alt38=1;
            }
            else if ( (LA38_0==46) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1849:2: kw= '=='
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleOpEquality4033); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1856:2: kw= '!='
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleOpEquality4052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleARelationalExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1869:1: entryRuleARelationalExpression returns [EObject current=null] : iv_ruleARelationalExpression= ruleARelationalExpression EOF ;
    public final EObject entryRuleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARelationalExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1870:2: (iv_ruleARelationalExpression= ruleARelationalExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1871:2: iv_ruleARelationalExpression= ruleARelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression4092);
            iv_ruleARelationalExpression=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARelationalExpression4102); if (state.failed) return current;

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
    // $ANTLR end "entryRuleARelationalExpression"


    // $ANTLR start "ruleARelationalExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1878:1: ruleARelationalExpression returns [EObject current=null] : (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* ) ;
    public final EObject ruleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1881:28: ( (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1882:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1882:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1883:5: this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4149);
            this_AAdditiveExpression_0=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1891:1: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==47) && (synpred5_InternalResults())) {
                    alt39=1;
                }
                else if ( (LA39_0==48) && (synpred5_InternalResults())) {
                    alt39=1;
                }
                else if ( (LA39_0==49) && (synpred5_InternalResults())) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1891:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1891:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1891:3: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1896:6: ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1896:7: () ( (lv_operator_2_0= ruleOpCompare ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1896:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1897:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1902:2: ( (lv_operator_2_0= ruleOpCompare ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1903:1: (lv_operator_2_0= ruleOpCompare )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1903:1: (lv_operator_2_0= ruleOpCompare )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1904:3: lv_operator_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleARelationalExpression4198);
            	    lv_operator_2_0=ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"OpCompare");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1920:4: ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1921:1: (lv_rightOperand_3_0= ruleAAdditiveExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1921:1: (lv_rightOperand_3_0= ruleAAdditiveExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1922:3: lv_rightOperand_3_0= ruleAAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getRightOperandAAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4221);
            	    lv_rightOperand_3_0=ruleAAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"AAdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleARelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1946:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1947:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1948:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare4260);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare4271); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1958:28: ( (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1959:1: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1959:1: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            int alt40=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt40=1;
                }
                break;
            case 48:
                {
                int LA40_2 = input.LA(2);

                if ( (LA40_2==EOF||(LA40_2>=RULE_ID && LA40_2<=RULE_REAL_LIT)||LA40_2==20||LA40_2==29||LA40_2==37||(LA40_2>=50 && LA40_2<=51)||(LA40_2>=55 && LA40_2<=56)||LA40_2==59||(LA40_2>=61 && LA40_2<=63)) ) {
                    alt40=4;
                }
                else if ( (LA40_2==27) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 2, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                alt40=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1960:2: kw= '>='
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleOpCompare4309); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1966:6: (kw= '<' kw= '=' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1966:6: (kw= '<' kw= '=' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1967:2: kw= '<' kw= '='
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleOpCompare4329); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0()); 
                          
                    }
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpCompare4342); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1980:2: kw= '>'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleOpCompare4362); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1987:2: kw= '<'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleOpCompare4381); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleAAdditiveExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2000:1: entryRuleAAdditiveExpression returns [EObject current=null] : iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF ;
    public final EObject entryRuleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAdditiveExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2001:2: (iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2002:2: iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression4421);
            iv_ruleAAdditiveExpression=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAdditiveExpression4431); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAAdditiveExpression"


    // $ANTLR start "ruleAAdditiveExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2009:1: ruleAAdditiveExpression returns [EObject current=null] : (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AMultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2012:28: ( (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2013:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2013:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2014:5: this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4478);
            this_AMultiplicativeExpression_0=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2022:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==50) && (synpred6_InternalResults())) {
                    alt41=1;
                }
                else if ( (LA41_0==51) && (synpred6_InternalResults())) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2022:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2022:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2022:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2027:6: ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2027:7: () ( (lv_feature_2_0= ruleOpAdd ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2027:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2028:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2033:2: ( (lv_feature_2_0= ruleOpAdd ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2034:1: (lv_feature_2_0= ruleOpAdd )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2034:1: (lv_feature_2_0= ruleOpAdd )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2035:3: lv_feature_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getFeatureOpAddParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleAAdditiveExpression4527);
            	    lv_feature_2_0=ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"feature",
            	              		lv_feature_2_0, 
            	              		"OpAdd");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2051:4: ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2052:1: (lv_rightOperand_3_0= ruleAMultiplicativeExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2052:1: (lv_rightOperand_3_0= ruleAMultiplicativeExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2053:3: lv_rightOperand_3_0= ruleAMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getRightOperandAMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4550);
            	    lv_rightOperand_3_0=ruleAMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"AMultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2077:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2078:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2079:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd4589);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd4600); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2086:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2089:28: ( (kw= '+' | kw= '-' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2090:1: (kw= '+' | kw= '-' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2090:1: (kw= '+' | kw= '-' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==50) ) {
                alt42=1;
            }
            else if ( (LA42_0==51) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2091:2: kw= '+'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleOpAdd4638); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2098:2: kw= '-'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleOpAdd4657); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleAMultiplicativeExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2111:1: entryRuleAMultiplicativeExpression returns [EObject current=null] : iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF ;
    public final EObject entryRuleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiplicativeExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2112:2: (iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2113:2: iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression4697);
            iv_ruleAMultiplicativeExpression=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiplicativeExpression4707); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAMultiplicativeExpression"


    // $ANTLR start "ruleAMultiplicativeExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2120:1: ruleAMultiplicativeExpression returns [EObject current=null] : (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* ) ;
    public final EObject ruleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AUnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2123:28: ( (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2124:1: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2124:1: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2125:5: this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4754);
            this_AUnaryOperation_0=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2133:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==52) && (synpred7_InternalResults())) {
                    alt43=1;
                }
                else if ( (LA43_0==42) && (synpred7_InternalResults())) {
                    alt43=1;
                }
                else if ( (LA43_0==53) && (synpred7_InternalResults())) {
                    alt43=1;
                }
                else if ( (LA43_0==54) && (synpred7_InternalResults())) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2133:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2133:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2133:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2138:6: ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2138:7: () ( (lv_operator_2_0= ruleOpMulti ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2138:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2139:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2144:2: ( (lv_operator_2_0= ruleOpMulti ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2145:1: (lv_operator_2_0= ruleOpMulti )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2145:1: (lv_operator_2_0= ruleOpMulti )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2146:3: lv_operator_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleAMultiplicativeExpression4803);
            	    lv_operator_2_0=ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"OpMulti");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2162:4: ( (lv_rightOperand_3_0= ruleAUnaryOperation ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2163:1: (lv_rightOperand_3_0= ruleAUnaryOperation )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2163:1: (lv_rightOperand_3_0= ruleAUnaryOperation )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2164:3: lv_rightOperand_3_0= ruleAUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getRightOperandAUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4826);
            	    lv_rightOperand_3_0=ruleAUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"rightOperand",
            	              		lv_rightOperand_3_0, 
            	              		"AUnaryOperation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2188:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2189:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2190:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti4865);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti4876); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2197:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2200:28: ( (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2201:1: (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2201:1: (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' )
            int alt44=4;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt44=1;
                }
                break;
            case 42:
                {
                alt44=2;
                }
                break;
            case 53:
                {
                alt44=3;
                }
                break;
            case 54:
                {
                alt44=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2202:2: kw= '*'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleOpMulti4914); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2209:2: kw= '/'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleOpMulti4933); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2216:2: kw= 'div'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleOpMulti4952); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2223:2: kw= 'mod'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleOpMulti4971); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getModKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleAUnaryOperation"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2236:1: entryRuleAUnaryOperation returns [EObject current=null] : iv_ruleAUnaryOperation= ruleAUnaryOperation EOF ;
    public final EObject entryRuleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnaryOperation = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2237:2: (iv_ruleAUnaryOperation= ruleAUnaryOperation EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2238:2: iv_ruleAUnaryOperation= ruleAUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleAUnaryOperation_in_entryRuleAUnaryOperation5011);
            iv_ruleAUnaryOperation=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUnaryOperation5021); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAUnaryOperation"


    // $ANTLR start "ruleAUnaryOperation"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2245:1: ruleAUnaryOperation returns [EObject current=null] : ( ( () ( (lv_operatorv_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression ) ;
    public final EObject ruleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operatorv_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_APrimaryExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2248:28: ( ( ( () ( (lv_operatorv_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2249:1: ( ( () ( (lv_operatorv_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2249:1: ( ( () ( (lv_operatorv_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=50 && LA45_0<=51)||LA45_0==55) ) {
                alt45=1;
            }
            else if ( ((LA45_0>=RULE_ID && LA45_0<=RULE_REAL_LIT)||LA45_0==20||LA45_0==29||LA45_0==37||LA45_0==56||LA45_0==59||(LA45_0>=61 && LA45_0<=63)) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2249:2: ( () ( (lv_operatorv_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2249:2: ( () ( (lv_operatorv_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2249:3: () ( (lv_operatorv_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2249:3: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2250:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2255:2: ( (lv_operatorv_1_0= ruleOpUnary ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2256:1: (lv_operatorv_1_0= ruleOpUnary )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2256:1: (lv_operatorv_1_0= ruleOpUnary )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2257:3: lv_operatorv_1_0= ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperatorvOpUnaryParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleAUnaryOperation5077);
                    lv_operatorv_1_0=ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operatorv",
                              		lv_operatorv_1_0, 
                              		"OpUnary");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2273:2: ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2274:1: (lv_operand_2_0= ruleAUnaryOperation )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2274:1: (lv_operand_2_0= ruleAUnaryOperation )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2275:3: lv_operand_2_0= ruleAUnaryOperation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAUnaryOperation5098);
                    lv_operand_2_0=ruleAUnaryOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_2_0, 
                              		"AUnaryOperation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2293:5: this_APrimaryExpression_3= ruleAPrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAUnaryOperationAccess().getAPrimaryExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAPrimaryExpression_in_ruleAUnaryOperation5127);
                    this_APrimaryExpression_3=ruleAPrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_APrimaryExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2309:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2310:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2311:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary5163);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary5174); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2318:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2321:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2322:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2322:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt46=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt46=1;
                }
                break;
            case 51:
                {
                alt46=2;
                }
                break;
            case 50:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2323:2: kw= '!'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleOpUnary5212); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2330:2: kw= '-'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleOpUnary5231); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2337:2: kw= '+'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleOpUnary5250); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleAPrimaryExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2350:1: entryRuleAPrimaryExpression returns [EObject current=null] : iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF ;
    public final EObject entryRuleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPrimaryExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2351:2: (iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2352:2: iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAPrimaryExpression_in_entryRuleAPrimaryExpression5290);
            iv_ruleAPrimaryExpression=ruleAPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPrimaryExpression5300); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAPrimaryExpression"


    // $ANTLR start "ruleAPrimaryExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2359:1: ruleAPrimaryExpression returns [EObject current=null] : (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_AParenthesizedExpression_4= ruleAParenthesizedExpression ) ;
    public final EObject ruleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ALiteral_0 = null;

        EObject this_AVariableReference_1 = null;

        EObject this_AModelOrPropertyReference_2 = null;

        EObject this_AFunctionCall_3 = null;

        EObject this_AParenthesizedExpression_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2362:28: ( (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_AParenthesizedExpression_4= ruleAParenthesizedExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2363:1: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_AParenthesizedExpression_4= ruleAParenthesizedExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2363:1: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_AParenthesizedExpression_4= ruleAParenthesizedExpression )
            int alt47=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INT:
            case RULE_REAL_LIT:
            case 20:
            case 59:
            case 61:
            case 62:
            case 63:
                {
                alt47=1;
                }
                break;
            case RULE_ID:
                {
                int LA47_2 = input.LA(2);

                if ( (LA47_2==56) ) {
                    alt47=4;
                }
                else if ( (LA47_2==EOF||LA47_2==22||(LA47_2>=42 && LA47_2<=54)||(LA47_2>=57 && LA47_2<=58)||LA47_2==60) ) {
                    alt47=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 2, input);

                    throw nvae;
                }
                }
                break;
            case 29:
            case 37:
                {
                alt47=3;
                }
                break;
            case 56:
                {
                alt47=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2364:5: this_ALiteral_0= ruleALiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleALiteral_in_ruleAPrimaryExpression5347);
                    this_ALiteral_0=ruleALiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ALiteral_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2374:5: this_AVariableReference_1= ruleAVariableReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAVariableReference_in_ruleAPrimaryExpression5374);
                    this_AVariableReference_1=ruleAVariableReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AVariableReference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2384:5: this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAModelOrPropertyReferenceParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAModelOrPropertyReference_in_ruleAPrimaryExpression5401);
                    this_AModelOrPropertyReference_2=ruleAModelOrPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AModelOrPropertyReference_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2394:5: this_AFunctionCall_3= ruleAFunctionCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAFunctionCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAFunctionCall_in_ruleAPrimaryExpression5428);
                    this_AFunctionCall_3=ruleAFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AFunctionCall_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2404:5: this_AParenthesizedExpression_4= ruleAParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAParenthesizedExpression_in_ruleAPrimaryExpression5455);
                    this_AParenthesizedExpression_4=ruleAParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AParenthesizedExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAPrimaryExpression"


    // $ANTLR start "entryRuleAFunctionCall"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2420:1: entryRuleAFunctionCall returns [EObject current=null] : iv_ruleAFunctionCall= ruleAFunctionCall EOF ;
    public final EObject entryRuleAFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAFunctionCall = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2421:2: (iv_ruleAFunctionCall= ruleAFunctionCall EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2422:2: iv_ruleAFunctionCall= ruleAFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAFunctionCallRule()); 
            }
            pushFollow(FOLLOW_ruleAFunctionCall_in_entryRuleAFunctionCall5490);
            iv_ruleAFunctionCall=ruleAFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAFunctionCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAFunctionCall5500); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAFunctionCall"


    // $ANTLR start "ruleAFunctionCall"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2429:1: ruleAFunctionCall returns [EObject current=null] : ( () ( (lv_function_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_functionCallArguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_functionCallArguments_5_0= ruleAExpression ) ) )* otherlv_6= ')' ) ;
    public final EObject ruleAFunctionCall() throws RecognitionException {
        EObject current = null;

        Token lv_function_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_functionCallArguments_3_0 = null;

        EObject lv_functionCallArguments_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2432:28: ( ( () ( (lv_function_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_functionCallArguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_functionCallArguments_5_0= ruleAExpression ) ) )* otherlv_6= ')' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2433:1: ( () ( (lv_function_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_functionCallArguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_functionCallArguments_5_0= ruleAExpression ) ) )* otherlv_6= ')' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2433:1: ( () ( (lv_function_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_functionCallArguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_functionCallArguments_5_0= ruleAExpression ) ) )* otherlv_6= ')' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2433:2: () ( (lv_function_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_functionCallArguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_functionCallArguments_5_0= ruleAExpression ) ) )* otherlv_6= ')'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2433:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2434:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAFunctionCallAccess().getAFunctionCallAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2439:2: ( (lv_function_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2440:1: (lv_function_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2440:1: (lv_function_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2441:3: lv_function_1_0= RULE_ID
            {
            lv_function_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAFunctionCall5551); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_function_1_0, grammarAccess.getAFunctionCallAccess().getFunctionIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAFunctionCallRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"function",
                      		lv_function_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,56,FOLLOW_56_in_ruleAFunctionCall5568); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAFunctionCallAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2461:1: ( (lv_functionCallArguments_3_0= ruleAExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2462:1: (lv_functionCallArguments_3_0= ruleAExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2462:1: (lv_functionCallArguments_3_0= ruleAExpression )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2463:3: lv_functionCallArguments_3_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getFunctionCallArgumentsAExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleAFunctionCall5589);
            lv_functionCallArguments_3_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
              	        }
                     		add(
                     			current, 
                     			"functionCallArguments",
                      		lv_functionCallArguments_3_0, 
                      		"AExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2479:2: (otherlv_4= ',' ( (lv_functionCallArguments_5_0= ruleAExpression ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==57) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2479:4: otherlv_4= ',' ( (lv_functionCallArguments_5_0= ruleAExpression ) )
            	    {
            	    otherlv_4=(Token)match(input,57,FOLLOW_57_in_ruleAFunctionCall5602); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getAFunctionCallAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2483:1: ( (lv_functionCallArguments_5_0= ruleAExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2484:1: (lv_functionCallArguments_5_0= ruleAExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2484:1: (lv_functionCallArguments_5_0= ruleAExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2485:3: lv_functionCallArguments_5_0= ruleAExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getFunctionCallArgumentsAExpressionParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAExpression_in_ruleAFunctionCall5623);
            	    lv_functionCallArguments_5_0=ruleAExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"functionCallArguments",
            	              		lv_functionCallArguments_5_0, 
            	              		"AExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            otherlv_6=(Token)match(input,58,FOLLOW_58_in_ruleAFunctionCall5637); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAFunctionCallAccess().getRightParenthesisKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAFunctionCall"


    // $ANTLR start "entryRuleALiteral"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2513:1: entryRuleALiteral returns [EObject current=null] : iv_ruleALiteral= ruleALiteral EOF ;
    public final EObject entryRuleALiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleALiteral = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2514:2: (iv_ruleALiteral= ruleALiteral EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2515:2: iv_ruleALiteral= ruleALiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getALiteralRule()); 
            }
            pushFollow(FOLLOW_ruleALiteral_in_entryRuleALiteral5673);
            iv_ruleALiteral=ruleALiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleALiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleALiteral5683); if (state.failed) return current;

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
    // $ANTLR end "entryRuleALiteral"


    // $ANTLR start "ruleALiteral"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2522:1: ruleALiteral returns [EObject current=null] : (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm ) ;
    public final EObject ruleALiteral() throws RecognitionException {
        EObject current = null;

        EObject this_ASetTerm_0 = null;

        EObject this_AListTerm_1 = null;

        EObject this_ABooleanLiteral_2 = null;

        EObject this_ARealTerm_3 = null;

        EObject this_AIntegerTerm_4 = null;

        EObject this_ANullLiteral_5 = null;

        EObject this_StringTerm_6 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2525:28: ( (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2526:1: (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2526:1: (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm )
            int alt49=7;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt49=1;
                }
                break;
            case 20:
                {
                alt49=2;
                }
                break;
            case 61:
            case 62:
                {
                alt49=3;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt49=4;
                }
                break;
            case RULE_INT:
                {
                alt49=5;
                }
                break;
            case 63:
                {
                alt49=6;
                }
                break;
            case RULE_STRING:
                {
                alt49=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2527:5: this_ASetTerm_0= ruleASetTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getASetTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASetTerm_in_ruleALiteral5730);
                    this_ASetTerm_0=ruleASetTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASetTerm_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2537:5: this_AListTerm_1= ruleAListTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getAListTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAListTerm_in_ruleALiteral5757);
                    this_AListTerm_1=ruleAListTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AListTerm_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2547:5: this_ABooleanLiteral_2= ruleABooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleABooleanLiteral_in_ruleALiteral5784);
                    this_ABooleanLiteral_2=ruleABooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ABooleanLiteral_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2557:5: this_ARealTerm_3= ruleARealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleARealTerm_in_ruleALiteral5811);
                    this_ARealTerm_3=ruleARealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ARealTerm_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2567:5: this_AIntegerTerm_4= ruleAIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAIntegerTerm_in_ruleALiteral5838);
                    this_AIntegerTerm_4=ruleAIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AIntegerTerm_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2577:5: this_ANullLiteral_5= ruleANullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getANullLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleANullLiteral_in_ruleALiteral5865);
                    this_ANullLiteral_5=ruleANullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ANullLiteral_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2587:5: this_StringTerm_6= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringTerm_in_ruleALiteral5892);
                    this_StringTerm_6=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringTerm_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleALiteral"


    // $ANTLR start "entryRuleAIntegerTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2603:1: entryRuleAIntegerTerm returns [EObject current=null] : iv_ruleAIntegerTerm= ruleAIntegerTerm EOF ;
    public final EObject entryRuleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIntegerTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2604:2: (iv_ruleAIntegerTerm= ruleAIntegerTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2605:2: iv_ruleAIntegerTerm= ruleAIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntegerTermRule()); 
            }
            pushFollow(FOLLOW_ruleAIntegerTerm_in_entryRuleAIntegerTerm5927);
            iv_ruleAIntegerTerm=ruleAIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAIntegerTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIntegerTerm5937); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAIntegerTerm"


    // $ANTLR start "ruleAIntegerTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2612:1: ruleAIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2615:28: ( ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2616:1: ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2616:1: ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2616:2: ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2616:2: ( (lv_value_0_0= ruleAInt ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2617:1: (lv_value_0_0= ruleAInt )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2617:1: (lv_value_0_0= ruleAInt )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2618:3: lv_value_0_0= ruleAInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAInt_in_ruleAIntegerTerm5983);
            lv_value_0_0=ruleAInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAIntegerTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"AInt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2634:2: ( (otherlv_1= RULE_ID ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2635:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2635:1: (otherlv_1= RULE_ID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2636:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAIntegerTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAIntegerTerm6003); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getAIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                      	
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAIntegerTerm"


    // $ANTLR start "entryRuleAInt"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2655:1: entryRuleAInt returns [String current=null] : iv_ruleAInt= ruleAInt EOF ;
    public final String entryRuleAInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAInt = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2656:2: (iv_ruleAInt= ruleAInt EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2657:2: iv_ruleAInt= ruleAInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntRule()); 
            }
            pushFollow(FOLLOW_ruleAInt_in_entryRuleAInt6041);
            iv_ruleAInt=ruleAInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAInt6052); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAInt"


    // $ANTLR start "ruleAInt"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2664:1: ruleAInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleAInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2667:28: (this_INT_0= RULE_INT )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2668:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAInt6091); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getAIntAccess().getINTTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAInt"


    // $ANTLR start "entryRuleARealTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2683:1: entryRuleARealTerm returns [EObject current=null] : iv_ruleARealTerm= ruleARealTerm EOF ;
    public final EObject entryRuleARealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARealTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2684:2: (iv_ruleARealTerm= ruleARealTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2685:2: iv_ruleARealTerm= ruleARealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealTermRule()); 
            }
            pushFollow(FOLLOW_ruleARealTerm_in_entryRuleARealTerm6135);
            iv_ruleARealTerm=ruleARealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARealTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARealTerm6145); if (state.failed) return current;

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
    // $ANTLR end "entryRuleARealTerm"


    // $ANTLR start "ruleARealTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2692:1: ruleARealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleARealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2695:28: ( ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2696:1: ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2696:1: ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2696:2: ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2696:2: ( (lv_value_0_0= ruleAReal ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2697:1: (lv_value_0_0= ruleAReal )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2697:1: (lv_value_0_0= ruleAReal )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2698:3: lv_value_0_0= ruleAReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAReal_in_ruleARealTerm6191);
            lv_value_0_0=ruleAReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getARealTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"AReal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2714:2: ( (otherlv_1= RULE_ID ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2715:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2715:1: (otherlv_1= RULE_ID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2716:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getARealTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleARealTerm6211); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getARealTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                      	
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleARealTerm"


    // $ANTLR start "entryRuleAReal"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2735:1: entryRuleAReal returns [String current=null] : iv_ruleAReal= ruleAReal EOF ;
    public final String entryRuleAReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAReal = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2736:2: (iv_ruleAReal= ruleAReal EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2737:2: iv_ruleAReal= ruleAReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealRule()); 
            }
            pushFollow(FOLLOW_ruleAReal_in_entryRuleAReal6249);
            iv_ruleAReal=ruleAReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAReal.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAReal6260); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAReal"


    // $ANTLR start "ruleAReal"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2744:1: ruleAReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleAReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2747:28: (this_REAL_LIT_0= RULE_REAL_LIT )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2748:5: this_REAL_LIT_0= RULE_REAL_LIT
            {
            this_REAL_LIT_0=(Token)match(input,RULE_REAL_LIT,FOLLOW_RULE_REAL_LIT_in_ruleAReal6299); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_REAL_LIT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_REAL_LIT_0, grammarAccess.getARealAccess().getREAL_LITTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAReal"


    // $ANTLR start "entryRuleNumAlt"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2765:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2766:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2767:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumAltRule()); 
            }
            pushFollow(FOLLOW_ruleNumAlt_in_entryRuleNumAlt6345);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumAlt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumAlt6355); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNumAlt"


    // $ANTLR start "ruleNumAlt"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2774:1: ruleNumAlt returns [EObject current=null] : (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_ARealTerm_0 = null;

        EObject this_AIntegerTerm_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2777:28: ( (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2778:1: (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2778:1: (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_REAL_LIT) ) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_INT) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2779:5: this_ARealTerm_0= ruleARealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getARealTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleARealTerm_in_ruleNumAlt6402);
                    this_ARealTerm_0=ruleARealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ARealTerm_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2789:5: this_AIntegerTerm_1= ruleAIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getAIntegerTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAIntegerTerm_in_ruleNumAlt6429);
                    this_AIntegerTerm_1=ruleAIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AIntegerTerm_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleNumAlt"


    // $ANTLR start "entryRuleASetTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2805:1: entryRuleASetTerm returns [EObject current=null] : iv_ruleASetTerm= ruleASetTerm EOF ;
    public final EObject entryRuleASetTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASetTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2806:2: (iv_ruleASetTerm= ruleASetTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2807:2: iv_ruleASetTerm= ruleASetTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASetTermRule()); 
            }
            pushFollow(FOLLOW_ruleASetTerm_in_entryRuleASetTerm6464);
            iv_ruleASetTerm=ruleASetTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASetTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASetTerm6474); if (state.failed) return current;

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
    // $ANTLR end "entryRuleASetTerm"


    // $ANTLR start "ruleASetTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2814:1: ruleASetTerm returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleASetTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_elements_2_0 = null;

        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2817:28: ( ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2818:1: ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2818:1: ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2818:2: () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2818:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2819:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getASetTermAccess().getASetLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleASetTerm6520); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASetTermAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2828:1: ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=RULE_ID && LA54_0<=RULE_REAL_LIT)||LA54_0==20||LA54_0==29||LA54_0==37||(LA54_0>=50 && LA54_0<=51)||(LA54_0>=55 && LA54_0<=56)||LA54_0==59||(LA54_0>=61 && LA54_0<=63)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2828:2: ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )*
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2828:2: ( (lv_elements_2_0= ruleAExpression ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2829:1: (lv_elements_2_0= ruleAExpression )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2829:1: (lv_elements_2_0= ruleAExpression )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2830:3: lv_elements_2_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getASetTermAccess().getElementsAExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAExpression_in_ruleASetTerm6542);
                    lv_elements_2_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getASetTermRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_2_0, 
                              		"AExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2846:2: (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==57) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2846:4: otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,57,FOLLOW_57_in_ruleASetTerm6555); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getASetTermAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2850:1: ( (lv_elements_4_0= ruleAExpression ) )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2851:1: (lv_elements_4_0= ruleAExpression )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2851:1: (lv_elements_4_0= ruleAExpression )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2852:3: lv_elements_4_0= ruleAExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getASetTermAccess().getElementsAExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleAExpression_in_ruleASetTerm6576);
                    	    lv_elements_4_0=ruleAExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getASetTermRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_4_0, 
                    	              		"AExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,60,FOLLOW_60_in_ruleASetTerm6592); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getASetTermAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleASetTerm"


    // $ANTLR start "entryRuleAListTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2880:1: entryRuleAListTerm returns [EObject current=null] : iv_ruleAListTerm= ruleAListTerm EOF ;
    public final EObject entryRuleAListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAListTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2881:2: (iv_ruleAListTerm= ruleAListTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2882:2: iv_ruleAListTerm= ruleAListTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAListTermRule()); 
            }
            pushFollow(FOLLOW_ruleAListTerm_in_entryRuleAListTerm6628);
            iv_ruleAListTerm=ruleAListTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAListTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAListTerm6638); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAListTerm"


    // $ANTLR start "ruleAListTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2889:1: ruleAListTerm returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleAListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_elements_2_0 = null;

        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2892:28: ( ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2893:1: ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2893:1: ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2893:2: () otherlv_1= '[' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= ']'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2893:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2894:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAListTermAccess().getAListTermAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleAListTerm6684); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAListTermAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2903:1: ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=RULE_ID && LA56_0<=RULE_REAL_LIT)||LA56_0==20||LA56_0==29||LA56_0==37||(LA56_0>=50 && LA56_0<=51)||(LA56_0>=55 && LA56_0<=56)||LA56_0==59||(LA56_0>=61 && LA56_0<=63)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2903:2: ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )*
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2903:2: ( (lv_elements_2_0= ruleAExpression ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2904:1: (lv_elements_2_0= ruleAExpression )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2904:1: (lv_elements_2_0= ruleAExpression )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2905:3: lv_elements_2_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAListTermAccess().getElementsAExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAExpression_in_ruleAListTerm6706);
                    lv_elements_2_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAListTermRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_2_0, 
                              		"AExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2921:2: (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==57) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2921:4: otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,57,FOLLOW_57_in_ruleAListTerm6719); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getAListTermAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2925:1: ( (lv_elements_4_0= ruleAExpression ) )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2926:1: (lv_elements_4_0= ruleAExpression )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2926:1: (lv_elements_4_0= ruleAExpression )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2927:3: lv_elements_4_0= ruleAExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAListTermAccess().getElementsAExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleAExpression_in_ruleAListTerm6740);
                    	    lv_elements_4_0=ruleAExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAListTermRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_4_0, 
                    	              		"AExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleAListTerm6756); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAListTermAccess().getRightSquareBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAListTerm"


    // $ANTLR start "entryRuleAParenthesizedExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2955:1: entryRuleAParenthesizedExpression returns [EObject current=null] : iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF ;
    public final EObject entryRuleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAParenthesizedExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2956:2: (iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2957:2: iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAParenthesizedExpression_in_entryRuleAParenthesizedExpression6792);
            iv_ruleAParenthesizedExpression=ruleAParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAParenthesizedExpression6802); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAParenthesizedExpression"


    // $ANTLR start "ruleAParenthesizedExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2964:1: ruleAParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) ;
    public final EObject ruleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2967:28: ( (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2968:1: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2968:1: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2968:3: otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleAParenthesizedExpression6839); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleAParenthesizedExpression6861);
            this_AExpression_1=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,58,FOLLOW_58_in_ruleAParenthesizedExpression6872); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAParenthesizedExpression"


    // $ANTLR start "entryRuleABooleanLiteral"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2993:1: entryRuleABooleanLiteral returns [EObject current=null] : iv_ruleABooleanLiteral= ruleABooleanLiteral EOF ;
    public final EObject entryRuleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleABooleanLiteral = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2994:2: (iv_ruleABooleanLiteral= ruleABooleanLiteral EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2995:2: iv_ruleABooleanLiteral= ruleABooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getABooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleABooleanLiteral_in_entryRuleABooleanLiteral6908);
            iv_ruleABooleanLiteral=ruleABooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleABooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleABooleanLiteral6918); if (state.failed) return current;

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
    // $ANTLR end "entryRuleABooleanLiteral"


    // $ANTLR start "ruleABooleanLiteral"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3002:1: ruleABooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3005:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3006:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3006:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3006:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3006:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3007:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3012:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==61) ) {
                alt57=1;
            }
            else if ( (LA57_0==62) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3012:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3012:3: ( (lv_value_1_0= 'true' ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3013:1: (lv_value_1_0= 'true' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3013:1: (lv_value_1_0= 'true' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3014:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,61,FOLLOW_61_in_ruleABooleanLiteral6971); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_value_1_0, grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getABooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "value", true, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3028:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,62,FOLLOW_62_in_ruleABooleanLiteral7002); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getABooleanLiteralAccess().getFalseKeyword_1_1());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleABooleanLiteral"


    // $ANTLR start "entryRuleANullLiteral"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3040:1: entryRuleANullLiteral returns [EObject current=null] : iv_ruleANullLiteral= ruleANullLiteral EOF ;
    public final EObject entryRuleANullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleANullLiteral = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3041:2: (iv_ruleANullLiteral= ruleANullLiteral EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3042:2: iv_ruleANullLiteral= ruleANullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getANullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleANullLiteral_in_entryRuleANullLiteral7039);
            iv_ruleANullLiteral=ruleANullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleANullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleANullLiteral7049); if (state.failed) return current;

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
    // $ANTLR end "entryRuleANullLiteral"


    // $ANTLR start "ruleANullLiteral"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3049:1: ruleANullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleANullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3052:28: ( ( () otherlv_1= 'null' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3053:1: ( () otherlv_1= 'null' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3053:1: ( () otherlv_1= 'null' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3053:2: () otherlv_1= 'null'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3053:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3054:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getANullLiteralAccess().getANullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleANullLiteral7095); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getANullLiteralAccess().getNullKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleANullLiteral"


    // $ANTLR start "entryRuleStringTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3071:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3072:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3073:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm7131);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm7141); if (state.failed) return current;

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
    // $ANTLR end "entryRuleStringTerm"


    // $ANTLR start "ruleStringTerm"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3080:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3083:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3084:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3084:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3085:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3085:1: (lv_value_0_0= ruleNoQuoteString )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3086:3: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_ruleStringTerm7186);
            lv_value_0_0=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStringTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"NoQuoteString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleStringTerm"


    // $ANTLR start "entryRuleNoQuoteString"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3110:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3111:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3112:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString7222);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNoQuoteString7233); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNoQuoteString"


    // $ANTLR start "ruleNoQuoteString"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3119:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3122:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3123:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNoQuoteString7272); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleNoQuoteString"


    // $ANTLR start "entryRuleAADLPROPERTYREFERENCE"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3142:1: entryRuleAADLPROPERTYREFERENCE returns [String current=null] : iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF ;
    public final String entryRuleAADLPROPERTYREFERENCE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAADLPROPERTYREFERENCE = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3143:2: (iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3144:2: iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAADLPROPERTYREFERENCERule()); 
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_entryRuleAADLPROPERTYREFERENCE7321);
            iv_ruleAADLPROPERTYREFERENCE=ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAADLPROPERTYREFERENCE.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAADLPROPERTYREFERENCE7332); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAADLPROPERTYREFERENCE"


    // $ANTLR start "ruleAADLPROPERTYREFERENCE"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3151:1: ruleAADLPROPERTYREFERENCE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAADLPROPERTYREFERENCE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3154:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3155:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3155:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3155:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7372); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3162:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==64) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3163:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleAADLPROPERTYREFERENCE7391); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0()); 
                          
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7406); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_2, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_1_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAADLPROPERTYREFERENCE"


    // $ANTLR start "entryRuleURIID"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3183:1: entryRuleURIID returns [String current=null] : iv_ruleURIID= ruleURIID EOF ;
    public final String entryRuleURIID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURIID = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3184:2: (iv_ruleURIID= ruleURIID EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3185:2: iv_ruleURIID= ruleURIID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIIDRule()); 
            }
            pushFollow(FOLLOW_ruleURIID_in_entryRuleURIID7454);
            iv_ruleURIID=ruleURIID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIID7465); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3192:1: ruleURIID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleURIID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3195:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3196:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIID7504); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_STRING_0, grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleURIID"


    // $ANTLR start "ruleResultIssueType"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3213:1: ruleResultIssueType returns [Enumerator current=null] : ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) ) ;
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
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3215:28: ( ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3216:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3216:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) )
            int alt59=6;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt59=1;
                }
                break;
            case 66:
                {
                alt59=2;
                }
                break;
            case 67:
                {
                alt59=3;
                }
                break;
            case 68:
                {
                alt59=4;
                }
                break;
            case 69:
                {
                alt59=5;
                }
                break;
            case 70:
                {
                alt59=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3216:2: (enumLiteral_0= 'tbd' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3216:2: (enumLiteral_0= 'tbd' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3216:4: enumLiteral_0= 'tbd'
                    {
                    enumLiteral_0=(Token)match(input,65,FOLLOW_65_in_ruleResultIssueType7564); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3222:6: (enumLiteral_1= 'error' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3222:6: (enumLiteral_1= 'error' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3222:8: enumLiteral_1= 'error'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_66_in_ruleResultIssueType7581); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3228:6: (enumLiteral_2= 'warning' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3228:6: (enumLiteral_2= 'warning' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3228:8: enumLiteral_2= 'warning'
                    {
                    enumLiteral_2=(Token)match(input,67,FOLLOW_67_in_ruleResultIssueType7598); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3234:6: (enumLiteral_3= 'info' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3234:6: (enumLiteral_3= 'info' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3234:8: enumLiteral_3= 'info'
                    {
                    enumLiteral_3=(Token)match(input,68,FOLLOW_68_in_ruleResultIssueType7615); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3240:6: (enumLiteral_4= 'success' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3240:6: (enumLiteral_4= 'success' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3240:8: enumLiteral_4= 'success'
                    {
                    enumLiteral_4=(Token)match(input,69,FOLLOW_69_in_ruleResultIssueType7632); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3246:6: (enumLiteral_5= 'fail' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3246:6: (enumLiteral_5= 'fail' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3246:8: enumLiteral_5= 'fail'
                    {
                    enumLiteral_5=(Token)match(input,70,FOLLOW_70_in_ruleResultIssueType7649); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleResultIssueType"

    // $ANTLR start synpred1_InternalResults
    public final void synpred1_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1127:3: ( ( () '#' ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1127:4: ( () '#' )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1127:4: ( () '#' )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1127:5: () '#'
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1127:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1128:1: 
        {
        }

        match(input,37,FOLLOW_37_in_synpred1_InternalResults2220); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalResults

    // $ANTLR start synpred2_InternalResults
    public final void synpred2_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1572:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1572:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1572:4: ( () ( ( ruleOpOr ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1572:5: () ( ( ruleOpOr ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1572:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1573:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1573:2: ( ( ruleOpOr ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1574:1: ( ruleOpOr )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1574:1: ( ruleOpOr )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1575:1: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalResults3382);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalResults

    // $ANTLR start synpred3_InternalResults
    public final void synpred3_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1676:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1676:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1676:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1676:5: () ( ( ruleOpAnd ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1676:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1677:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1677:2: ( ( ruleOpAnd ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1678:1: ( ruleOpAnd )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1678:1: ( ruleOpAnd )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1679:1: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalResults3637);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalResults

    // $ANTLR start synpred4_InternalResults
    public final void synpred4_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1780:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1780:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1780:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1780:5: () ( ( ruleOpEquality ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1780:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1781:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1781:2: ( ( ruleOpEquality ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1782:1: ( ruleOpEquality )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1782:1: ( ruleOpEquality )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1783:1: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalResults3892);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalResults

    // $ANTLR start synpred5_InternalResults
    public final void synpred5_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1891:3: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1891:4: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1891:4: ( () ( ( ruleOpCompare ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1891:5: () ( ( ruleOpCompare ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1891:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1892:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1892:2: ( ( ruleOpCompare ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1893:1: ( ruleOpCompare )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1893:1: ( ruleOpCompare )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1894:1: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred5_InternalResults4168);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalResults

    // $ANTLR start synpred6_InternalResults
    public final void synpred6_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2022:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2022:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2022:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2022:5: () ( ( ruleOpAdd ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2022:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2023:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2023:2: ( ( ruleOpAdd ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2024:1: ( ruleOpAdd )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2024:1: ( ruleOpAdd )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2025:1: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred6_InternalResults4497);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalResults

    // $ANTLR start synpred7_InternalResults
    public final void synpred7_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2133:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2133:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2133:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2133:5: () ( ( ruleOpMulti ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2133:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2134:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2134:2: ( ( ruleOpMulti ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2135:1: ( ruleOpMulti )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2135:1: ( ruleOpMulti )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2136:1: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred7_InternalResults4773);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalResults

    // Delegated rules

    public final boolean synpred5_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleResultReport_in_entryRuleResultReport75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReport85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultDataReport_in_ruleResultReport132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_ruleResultReport159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssuesReport_in_ruleResultReport186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_entryRuleResultReportCollection221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReportCollection231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleResultReportCollection268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultReportCollection285 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleResultReportCollection303 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportCollection320 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleResultReportCollection339 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultReportCollection362 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleResultReportCollection374 = new BitSet(new long[]{0x0000000010E20000L,0x000000000000007EL});
    public static final BitSet FOLLOW_21_in_ruleResultReportCollection387 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportCollection404 = new BitSet(new long[]{0x0000000010C20000L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleResultReport_in_ruleResultReportCollection432 = new BitSet(new long[]{0x0000000010C20000L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultReportCollection454 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleResultReportCollection467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultDataReport_in_entryRuleResultDataReport503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultDataReport513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleResultDataReport550 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultDataReport567 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleResultDataReport585 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultDataReport602 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleResultDataReport621 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultDataReport644 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleResultDataReport656 = new BitSet(new long[]{0x0000000003600000L,0x000000000000007EL});
    public static final BitSet FOLLOW_21_in_ruleResultDataReport669 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultDataReport686 = new BitSet(new long[]{0x0000000003400000L,0x000000000000007EL});
    public static final BitSet FOLLOW_24_in_ruleResultDataReport706 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultDataReport723 = new BitSet(new long[]{0x0000000006400000L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultDataReport749 = new BitSet(new long[]{0x0000000006400000L,0x000000000000007EL});
    public static final BitSet FOLLOW_25_in_ruleResultDataReport765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultDataReport786 = new BitSet(new long[]{0x0000000000400010L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultDataReport810 = new BitSet(new long[]{0x0000000000400000L,0x000000000000007EL});
    public static final BitSet FOLLOW_22_in_ruleResultDataReport823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_entryRuleResultContributor859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultContributor869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleResultContributor906 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultContributor929 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleResultContributor941 = new BitSet(new long[]{0x0000000006400000L,0x000000000000007EL});
    public static final BitSet FOLLOW_25_in_ruleResultContributor954 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultContributor975 = new BitSet(new long[]{0x0000000004400010L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultContributor999 = new BitSet(new long[]{0x0000000004400000L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultContributor1021 = new BitSet(new long[]{0x0000000004400000L});
    public static final BitSet FOLLOW_22_in_ruleResultContributor1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_entryRuleResultData1070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultData1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultData1122 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleResultData1139 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultData1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleResultData1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport1227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIssuesReport1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleIssuesReport1274 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIssuesReport1291 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_19_in_ruleIssuesReport1309 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleIssuesReport1332 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleIssuesReport1347 = new BitSet(new long[]{0x0000000000600000L,0x000000000000007EL});
    public static final BitSet FOLLOW_21_in_ruleIssuesReport1360 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIssuesReport1377 = new BitSet(new long[]{0x0000000000400000L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleIssuesReport1405 = new BitSet(new long[]{0x0000000000400000L,0x000000000000007EL});
    public static final BitSet FOLLOW_22_in_ruleIssuesReport1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1458 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_ruleDescriptionElement1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDescriptionElement1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImageReference_in_ruleDescriptionElement1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_entryRuleResultIssue1646 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultIssue1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_ruleResultIssue1702 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1719 = new BitSet(new long[]{0x00000001C0100002L});
    public static final BitSet FOLLOW_30_in_ruleResultIssue1737 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultIssue1760 = new BitSet(new long[]{0x0000000180100002L});
    public static final BitSet FOLLOW_31_in_ruleResultIssue1775 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1792 = new BitSet(new long[]{0x0000000100100002L});
    public static final BitSet FOLLOW_32_in_ruleResultIssue1812 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1829 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleResultIssue1849 = new BitSet(new long[]{0x0000000000400000L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultIssue1870 = new BitSet(new long[]{0x0000000000400000L,0x000000000000007EL});
    public static final BitSet FOLLOW_22_in_ruleResultIssue1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleTypeRef1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleTypeRef2007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleTypeRef2036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleTypeRef2065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef2105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelOrPropertyReference_in_entryRuleAModelOrPropertyReference2146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAModelOrPropertyReference2156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelReference_in_ruleAModelOrPropertyReference2204 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleAModelOrPropertyReference2239 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAModelOrPropertyReference2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPropertyReference_in_ruleAModelOrPropertyReference2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedModelelement_in_entryRuleNestedModelelement2330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedModelelement2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNestedModelelement2385 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleNestedModelelement2398 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNestedModelelement_in_ruleNestedModelelement2419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelReference_in_entryRuleAModelReference2457 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAModelReference2467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAModelReference2513 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleAModelReference2526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNestedModelelement_in_ruleAModelReference2547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPropertyReference_in_entryRuleAPropertyReference2585 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPropertyReference2595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleAPropertyReference2641 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAPropertyReference2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableReference_in_entryRuleAVariableReference2700 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAVariableReference2710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAVariableReference2764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_entryRuleShowValue2800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShowValue2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue2855 = new BitSet(new long[]{0x0000018000000002L});
    public static final BitSet FOLLOW_39_in_ruleShowValue2868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleShowValue2887 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImageReference_in_entryRuleImageReference2946 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImageReference2956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleImageReference2993 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIMGREF_in_ruleImageReference3014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMGREF_in_entryRuleIMGREF3051 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMGREF3062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF3103 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleIMGREF3121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF3138 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleIMGREF3156 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF3171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExpression_in_entryRuleAExpression3216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExpression3226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_ruleAExpression3272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression3306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAOrExpression3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression3363 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleAOrExpression3412 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression3435 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr3474 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpOr3522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression3561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAndExpression3571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression3618 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleAAndExpression3667 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression3690 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd3729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd3740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOpAnd3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_entryRuleAEqualityExpression3816 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAEqualityExpression3826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3873 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleAEqualityExpression3922 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3945 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality3984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality3995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleOpEquality4033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleOpEquality4052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression4092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARelationalExpression4102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4149 = new BitSet(new long[]{0x0003800000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleARelationalExpression4198 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4221 = new BitSet(new long[]{0x0003800000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare4260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare4271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleOpCompare4309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOpCompare4329 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleOpCompare4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOpCompare4362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOpCompare4381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression4421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAdditiveExpression4431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4478 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleAAdditiveExpression4527 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4550 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd4589 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd4600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOpAdd4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOpAdd4657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression4697 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiplicativeExpression4707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4754 = new BitSet(new long[]{0x0070040000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleAMultiplicativeExpression4803 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4826 = new BitSet(new long[]{0x0070040000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti4865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti4876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleOpMulti4914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOpMulti4933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleOpMulti4952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleOpMulti4971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_entryRuleAUnaryOperation5011 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUnaryOperation5021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleAUnaryOperation5077 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAUnaryOperation5098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPrimaryExpression_in_ruleAUnaryOperation5127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary5163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary5174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleOpUnary5212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOpUnary5231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOpUnary5250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPrimaryExpression_in_entryRuleAPrimaryExpression5290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPrimaryExpression5300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALiteral_in_ruleAPrimaryExpression5347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableReference_in_ruleAPrimaryExpression5374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelOrPropertyReference_in_ruleAPrimaryExpression5401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAFunctionCall_in_ruleAPrimaryExpression5428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParenthesizedExpression_in_ruleAPrimaryExpression5455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAFunctionCall_in_entryRuleAFunctionCall5490 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAFunctionCall5500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAFunctionCall5551 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleAFunctionCall5568 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAFunctionCall5589 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_57_in_ruleAFunctionCall5602 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAFunctionCall5623 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_58_in_ruleAFunctionCall5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALiteral_in_entryRuleALiteral5673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleALiteral5683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASetTerm_in_ruleALiteral5730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAListTerm_in_ruleALiteral5757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanLiteral_in_ruleALiteral5784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_ruleALiteral5811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_ruleALiteral5838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANullLiteral_in_ruleALiteral5865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_ruleALiteral5892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_entryRuleAIntegerTerm5927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIntegerTerm5937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInt_in_ruleAIntegerTerm5983 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAIntegerTerm6003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInt_in_entryRuleAInt6041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAInt6052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAInt6091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_entryRuleARealTerm6135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARealTerm6145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReal_in_ruleARealTerm6191 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleARealTerm6211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReal_in_entryRuleAReal6249 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAReal6260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_LIT_in_ruleAReal6299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumAlt_in_entryRuleNumAlt6345 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumAlt6355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_ruleNumAlt6402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_ruleNumAlt6429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASetTerm_in_entryRuleASetTerm6464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASetTerm6474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleASetTerm6520 = new BitSet(new long[]{0xF98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleASetTerm6542 = new BitSet(new long[]{0x1200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleASetTerm6555 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleASetTerm6576 = new BitSet(new long[]{0x1200000000000000L});
    public static final BitSet FOLLOW_60_in_ruleASetTerm6592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAListTerm_in_entryRuleAListTerm6628 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAListTerm6638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleAListTerm6684 = new BitSet(new long[]{0xE98C0020205000F0L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAListTerm6706 = new BitSet(new long[]{0x0200000000400000L});
    public static final BitSet FOLLOW_57_in_ruleAListTerm6719 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAListTerm6740 = new BitSet(new long[]{0x0200000000400000L});
    public static final BitSet FOLLOW_22_in_ruleAListTerm6756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParenthesizedExpression_in_entryRuleAParenthesizedExpression6792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAParenthesizedExpression6802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleAParenthesizedExpression6839 = new BitSet(new long[]{0xE98C0020201000F0L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAParenthesizedExpression6861 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleAParenthesizedExpression6872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanLiteral_in_entryRuleABooleanLiteral6908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleABooleanLiteral6918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleABooleanLiteral6971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleABooleanLiteral7002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANullLiteral_in_entryRuleANullLiteral7039 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleANullLiteral7049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleANullLiteral7095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm7131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm7141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleStringTerm7186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString7222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNoQuoteString7233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNoQuoteString7272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_entryRuleAADLPROPERTYREFERENCE7321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAADLPROPERTYREFERENCE7332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7372 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleAADLPROPERTYREFERENCE7391 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_entryRuleURIID7454 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIID7465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIID7504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleResultIssueType7564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleResultIssueType7581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleResultIssueType7598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleResultIssueType7615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleResultIssueType7632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleResultIssueType7649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred1_InternalResults2220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalResults3382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalResults3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalResults3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred5_InternalResults4168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred6_InternalResults4497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred7_InternalResults4773 = new BitSet(new long[]{0x0000000000000002L});

}

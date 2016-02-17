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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_REAL_LIT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_EXTENDED_DIGIT", "RULE_BASED_INTEGER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'reports'", "':'", "'for'", "'['", "'description'", "']'", "'report'", "'heading'", "'results'", "'contributor'", "'='", "'issues'", "'this'", "'target'", "'exception'", "'diagnosticId'", "'@'", "'%'", "'img'", "'/'", "'.'", "'||'", "'&&'", "'=='", "'!='", "'>='", "'<'", "'>'", "'->'", "'..<'", "'..'", "'=>'", "'<>'", "'?:'", "'+'", "'-'", "'*'", "'**'", "'!'", "'{'", "','", "'}'", "'#'", "'('", "')'", "'true'", "'false'", "'null'", "'::'", "'tbd'", "'error'", "'warning'", "'info'", "'success'", "'fail'"
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
    public static final int T__71=71;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:139:1: ruleResultReportCollection returns [EObject current=null] : (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' ) ;
    public final EObject ruleResultReportCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_decription_8_0=null;
        Token otherlv_11=null;
        EObject lv_content_9_0 = null;

        EObject lv_issues_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:142:28: ( (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:1: (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:1: (otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:143:3: otherlv_0= 'reports' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? ( (lv_content_9_0= ruleResultReport ) )* ( (lv_issues_10_0= ruleResultIssue ) )? otherlv_11= ']'
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
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:210:1: (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==21) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:210:3: otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleResultReportCollection387); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:214:1: ( (lv_decription_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:215:1: (lv_decription_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:215:1: (lv_decription_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:216:3: lv_decription_8_0= RULE_STRING
                    {
                    lv_decription_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReportCollection404); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_decription_8_0, grammarAccess.getResultReportCollectionAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

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

            if ( ((LA5_0>=66 && LA5_0<=71)) ) {
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:289:1: ruleResultDataReport returns [EObject current=null] : (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' ) ;
    public final EObject ruleResultDataReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_decription_8_0=null;
        Token otherlv_9=null;
        Token lv_heading_10_0=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        EObject lv_content_11_0 = null;

        EObject lv_resultData_13_0 = null;

        EObject lv_issues_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:292:28: ( (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:293:3: otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= 'for' ( ( ruleURIID ) ) otherlv_6= '[' (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultContributor ) )* )? (otherlv_12= 'results' ( (lv_resultData_13_0= ruleResultData ) )+ )? ( (lv_issues_14_0= ruleResultIssue ) )* otherlv_15= ']'
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
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:360:1: (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:360:3: otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleResultDataReport669); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getResultDataReportAccess().getDescriptionKeyword_6_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:364:1: ( (lv_decription_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:365:1: (lv_decription_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:365:1: (lv_decription_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:366:3: lv_decription_8_0= RULE_STRING
                    {
                    lv_decription_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultDataReport686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_decription_8_0, grammarAccess.getResultDataReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultDataReportRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"decription",
                              		lv_decription_8_0, 
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

                if ( ((LA12_0>=66 && LA12_0<=71)) ) {
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

                if ( ((LA15_0>=66 && LA15_0<=71)) ) {
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:589:1: ruleResultData returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleResultData() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:592:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:593:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:593:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:593:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) )
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
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:615:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:616:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:616:1: (lv_value_2_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:617:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultData1156); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_2_0, grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0()); 
              		
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:641:1: entryRuleIssuesReport returns [EObject current=null] : iv_ruleIssuesReport= ruleIssuesReport EOF ;
    public final EObject entryRuleIssuesReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIssuesReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:642:2: (iv_ruleIssuesReport= ruleIssuesReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:643:2: iv_ruleIssuesReport= ruleIssuesReport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIssuesReportRule()); 
            }
            pushFollow(FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport1197);
            iv_ruleIssuesReport=ruleIssuesReport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIssuesReport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIssuesReport1207); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:650:1: ruleIssuesReport returns [EObject current=null] : (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? ) ;
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
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:653:28: ( (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:654:1: (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:654:1: (otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:654:3: otherlv_0= 'issues' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'for' ( ( ruleURIID ) ) )? (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleIssuesReport1244); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIssuesReportAccess().getIssuesKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:658:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:659:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:659:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:660:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIssuesReport1261); if (state.failed) return current;
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:676:2: (otherlv_2= 'for' ( ( ruleURIID ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==19) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:676:4: otherlv_2= 'for' ( ( ruleURIID ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleIssuesReport1279); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getIssuesReportAccess().getForKeyword_2_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:680:1: ( ( ruleURIID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:681:1: ( ruleURIID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:681:1: ( ruleURIID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:682:3: ruleURIID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getIssuesReportRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleURIID_in_ruleIssuesReport1302);
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:695:4: (otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==20) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:695:6: otherlv_4= '[' (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_issues_7_0= ruleResultIssue ) )* otherlv_8= ']'
                    {
                    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleIssuesReport1317); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:699:1: (otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==21) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:699:3: otherlv_5= 'description' ( (lv_description_6_0= RULE_STRING ) )
                            {
                            otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleIssuesReport1330); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getIssuesReportAccess().getDescriptionKeyword_3_1_0());
                                  
                            }
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:703:1: ( (lv_description_6_0= RULE_STRING ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:704:1: (lv_description_6_0= RULE_STRING )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:704:1: (lv_description_6_0= RULE_STRING )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:705:3: lv_description_6_0= RULE_STRING
                            {
                            lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIssuesReport1347); if (state.failed) return current;
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

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:721:4: ( (lv_issues_7_0= ruleResultIssue ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=66 && LA19_0<=71)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:722:1: (lv_issues_7_0= ruleResultIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:722:1: (lv_issues_7_0= ruleResultIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:723:3: lv_issues_7_0= ruleResultIssue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getIssuesReportAccess().getIssuesResultIssueParserRuleCall_3_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultIssue_in_ruleIssuesReport1375);
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
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleIssuesReport1388); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:753:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:754:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:755:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            }
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1428);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescriptionElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement1438); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:762:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_thisTarget_2_0=null;
        EObject lv_showValue_1_0 = null;

        EObject lv_image_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:765:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:766:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:766:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) )
            int alt21=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt21=1;
                }
                break;
            case RULE_ID:
                {
                alt21=2;
                }
                break;
            case 29:
                {
                alt21=3;
                }
                break;
            case 35:
                {
                alt21=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:766:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:766:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:767:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:767:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:768:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement1480); if (state.failed) return current;
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:785:6: ( (lv_showValue_1_0= ruleShowValue ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:785:6: ( (lv_showValue_1_0= ruleShowValue ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:786:1: (lv_showValue_1_0= ruleShowValue )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:786:1: (lv_showValue_1_0= ruleShowValue )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:787:3: lv_showValue_1_0= ruleShowValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleShowValue_in_ruleDescriptionElement1512);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:804:6: ( (lv_thisTarget_2_0= 'this' ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:804:6: ( (lv_thisTarget_2_0= 'this' ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:805:1: (lv_thisTarget_2_0= 'this' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:805:1: (lv_thisTarget_2_0= 'this' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:806:3: lv_thisTarget_2_0= 'this'
                    {
                    lv_thisTarget_2_0=(Token)match(input,29,FOLLOW_29_in_ruleDescriptionElement1536); if (state.failed) return current;
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:820:6: ( (lv_image_3_0= ruleImageReference ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:820:6: ( (lv_image_3_0= ruleImageReference ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:821:1: (lv_image_3_0= ruleImageReference )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:821:1: (lv_image_3_0= ruleImageReference )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:822:3: lv_image_3_0= ruleImageReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleImageReference_in_ruleDescriptionElement1576);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:850:1: entryRuleResultIssue returns [EObject current=null] : iv_ruleResultIssue= ruleResultIssue EOF ;
    public final EObject entryRuleResultIssue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultIssue = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:851:2: (iv_ruleResultIssue= ruleResultIssue EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:852:2: iv_ruleResultIssue= ruleResultIssue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultIssueRule()); 
            }
            pushFollow(FOLLOW_ruleResultIssue_in_entryRuleResultIssue1616);
            iv_ruleResultIssue=ruleResultIssue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultIssue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultIssue1626); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:859:1: ruleResultIssue returns [EObject current=null] : ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? ) ;
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
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:862:28: ( ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:863:1: ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:863:1: ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:863:2: ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:863:2: ( (lv_issueType_0_0= ruleResultIssueType ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:864:1: (lv_issueType_0_0= ruleResultIssueType )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:864:1: (lv_issueType_0_0= ruleResultIssueType )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:865:3: lv_issueType_0_0= ruleResultIssueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleResultIssueType_in_ruleResultIssue1672);
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:881:2: ( (lv_message_1_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:882:1: (lv_message_1_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:882:1: (lv_message_1_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:883:3: lv_message_1_0= RULE_STRING
            {
            lv_message_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1689); if (state.failed) return current;
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:899:2: (otherlv_2= 'target' ( ( ruleURIID ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:899:4: otherlv_2= 'target' ( ( ruleURIID ) )
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleResultIssue1707); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getResultIssueAccess().getTargetKeyword_2_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:903:1: ( ( ruleURIID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:904:1: ( ruleURIID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:904:1: ( ruleURIID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:905:3: ruleURIID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultIssueRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleURIID_in_ruleResultIssue1730);
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:918:4: (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:918:6: otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleResultIssue1745); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getResultIssueAccess().getExceptionKeyword_3_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:922:1: ( (lv_exceptionType_5_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:923:1: (lv_exceptionType_5_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:923:1: (lv_exceptionType_5_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:924:3: lv_exceptionType_5_0= RULE_STRING
                    {
                    lv_exceptionType_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1762); if (state.failed) return current;
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:940:4: (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:940:6: otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleResultIssue1782); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getResultIssueAccess().getDiagnosticIdKeyword_4_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:944:1: ( (lv_diagnosticId_7_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:945:1: (lv_diagnosticId_7_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:945:1: (lv_diagnosticId_7_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:946:3: lv_diagnosticId_7_0= RULE_STRING
                    {
                    lv_diagnosticId_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1799); if (state.failed) return current;
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:962:4: (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==20) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:962:6: otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleResultIssue1819); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:966:1: ( (lv_issues_9_0= ruleResultIssue ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=66 && LA25_0<=71)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:967:1: (lv_issues_9_0= ruleResultIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:967:1: (lv_issues_9_0= ruleResultIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:968:3: lv_issues_9_0= ruleResultIssue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultIssue1840);
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
                    	    break loop25;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleResultIssue1853); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAPropertyReference"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1000:1: entryRuleAPropertyReference returns [EObject current=null] : iv_ruleAPropertyReference= ruleAPropertyReference EOF ;
    public final EObject entryRuleAPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPropertyReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1001:2: (iv_ruleAPropertyReference= ruleAPropertyReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1002:2: iv_ruleAPropertyReference= ruleAPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAPropertyReference_in_entryRuleAPropertyReference1895);
            iv_ruleAPropertyReference=ruleAPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPropertyReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPropertyReference1905); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1009:1: ruleAPropertyReference returns [EObject current=null] : ( () otherlv_1= '@' ( ( ruleAADLPROPERTYREFERENCE ) ) ) ;
    public final EObject ruleAPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1012:28: ( ( () otherlv_1= '@' ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1013:1: ( () otherlv_1= '@' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1013:1: ( () otherlv_1= '@' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1013:2: () otherlv_1= '@' ( ( ruleAADLPROPERTYREFERENCE ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1013:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1014:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleAPropertyReference1951); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAPropertyReferenceAccess().getCommercialAtKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1023:1: ( ( ruleAADLPROPERTYREFERENCE ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1024:1: ( ruleAADLPROPERTYREFERENCE )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1024:1: ( ruleAADLPROPERTYREFERENCE )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1025:3: ruleAADLPROPERTYREFERENCE
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAPropertyReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAPropertyReference1974);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1046:1: entryRuleAVariableReference returns [EObject current=null] : iv_ruleAVariableReference= ruleAVariableReference EOF ;
    public final EObject entryRuleAVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAVariableReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1047:2: (iv_ruleAVariableReference= ruleAVariableReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1048:2: iv_ruleAVariableReference= ruleAVariableReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAVariableReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAVariableReference_in_entryRuleAVariableReference2010);
            iv_ruleAVariableReference=ruleAVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAVariableReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAVariableReference2020); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1055:1: ruleAVariableReference returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleAVariableReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1058:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1059:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1059:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1059:2: () ( (otherlv_1= RULE_ID ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1059:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1060:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1065:2: ( (otherlv_1= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1066:1: (otherlv_1= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1066:1: (otherlv_1= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1067:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAVariableReferenceRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAVariableReference2074); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1086:1: entryRuleShowValue returns [EObject current=null] : iv_ruleShowValue= ruleShowValue EOF ;
    public final EObject entryRuleShowValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShowValue = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1087:2: (iv_ruleShowValue= ruleShowValue EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1088:2: iv_ruleShowValue= ruleShowValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShowValueRule()); 
            }
            pushFollow(FOLLOW_ruleShowValue_in_entryRuleShowValue2110);
            iv_ruleShowValue=ruleShowValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShowValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShowValue2120); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1095:1: ruleShowValue returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject ruleShowValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1098:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1099:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1099:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1099:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1099:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1100:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1100:1: (otherlv_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1101:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getShowValueRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue2165); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getShowValueAccess().getRefAVariableDeclarationCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1112:2: (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==34) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1112:4: otherlv_1= '%' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleShowValue2178); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1116:1: ( (otherlv_2= RULE_ID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1117:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1117:1: (otherlv_2= RULE_ID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1118:3: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getShowValueRule());
                      	        }
                              
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue2198); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_2, grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_0()); 
                      	
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1137:1: entryRuleImageReference returns [EObject current=null] : iv_ruleImageReference= ruleImageReference EOF ;
    public final EObject entryRuleImageReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1138:2: (iv_ruleImageReference= ruleImageReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1139:2: iv_ruleImageReference= ruleImageReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImageReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleImageReference_in_entryRuleImageReference2236);
            iv_ruleImageReference=ruleImageReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImageReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImageReference2246); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1146:1: ruleImageReference returns [EObject current=null] : (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) ;
    public final EObject ruleImageReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_imgfile_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1149:28: ( (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1150:1: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1150:1: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1150:3: otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleImageReference2283); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImageReferenceAccess().getImgKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1154:1: ( (lv_imgfile_1_0= ruleIMGREF ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1155:1: (lv_imgfile_1_0= ruleIMGREF )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1155:1: (lv_imgfile_1_0= ruleIMGREF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1156:3: lv_imgfile_1_0= ruleIMGREF
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIMGREF_in_ruleImageReference2304);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1180:1: entryRuleIMGREF returns [String current=null] : iv_ruleIMGREF= ruleIMGREF EOF ;
    public final String entryRuleIMGREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMGREF = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1181:2: (iv_ruleIMGREF= ruleIMGREF EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1182:2: iv_ruleIMGREF= ruleIMGREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIMGREFRule()); 
            }
            pushFollow(FOLLOW_ruleIMGREF_in_entryRuleIMGREF2341);
            iv_ruleIMGREF=ruleIMGREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIMGREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMGREF2352); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1189:1: ruleIMGREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIMGREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1192:28: ( ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1193:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1193:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1193:2: (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1193:2: (this_ID_0= RULE_ID kw= '/' )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    int LA28_1 = input.LA(2);

                    if ( (LA28_1==36) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1193:7: this_ID_0= RULE_ID kw= '/'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF2393); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,36,FOLLOW_36_in_ruleIMGREF2411); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF2428); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            kw=(Token)match(input,37,FOLLOW_37_in_ruleIMGREF2446); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getIMGREFAccess().getFullStopKeyword_2()); 
                  
            }
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF2461); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1234:1: entryRuleAExpression returns [EObject current=null] : iv_ruleAExpression= ruleAExpression EOF ;
    public final EObject entryRuleAExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1235:2: (iv_ruleAExpression= ruleAExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1236:2: iv_ruleAExpression= ruleAExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAExpression_in_entryRuleAExpression2506);
            iv_ruleAExpression=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExpression2516); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1243:1: ruleAExpression returns [EObject current=null] : this_AOrExpression_0= ruleAOrExpression ;
    public final EObject ruleAExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AOrExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1246:28: (this_AOrExpression_0= ruleAOrExpression )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1248:5: this_AOrExpression_0= ruleAOrExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleAOrExpression_in_ruleAExpression2562);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1264:1: entryRuleAOrExpression returns [EObject current=null] : iv_ruleAOrExpression= ruleAOrExpression EOF ;
    public final EObject entryRuleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOrExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1265:2: (iv_ruleAOrExpression= ruleAOrExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1266:2: iv_ruleAOrExpression= ruleAOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression2596);
            iv_ruleAOrExpression=ruleAOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAOrExpression2606); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1273:1: ruleAOrExpression returns [EObject current=null] : (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* ) ;
    public final EObject ruleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAndExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1276:28: ( (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1277:1: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1277:1: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1278:5: this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression2653);
            this_AAndExpression_0=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1286:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==38) && (synpred1_InternalResults())) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1286:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1286:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1286:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1291:6: ( () ( (lv_feature_2_0= ruleOpOr ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1291:7: () ( (lv_feature_2_0= ruleOpOr ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1291:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1292:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1297:2: ( (lv_feature_2_0= ruleOpOr ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1298:1: (lv_feature_2_0= ruleOpOr )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1298:1: (lv_feature_2_0= ruleOpOr )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1299:3: lv_feature_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getFeatureOpOrParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleAOrExpression2702);
            	    lv_feature_2_0=ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"feature",
            	              		lv_feature_2_0, 
            	              		"OpOr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1315:4: ( (lv_rightOperand_3_0= ruleAAndExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1316:1: (lv_rightOperand_3_0= ruleAAndExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1316:1: (lv_rightOperand_3_0= ruleAAndExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1317:3: lv_rightOperand_3_0= ruleAAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getRightOperandAAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression2725);
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
            	    break loop29;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1341:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1342:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1343:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr2764);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr2775); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1350:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1353:28: (kw= '||' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1355:2: kw= '||'
            {
            kw=(Token)match(input,38,FOLLOW_38_in_ruleOpOr2812); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); 
                  
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1368:1: entryRuleAAndExpression returns [EObject current=null] : iv_ruleAAndExpression= ruleAAndExpression EOF ;
    public final EObject entryRuleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAndExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1369:2: (iv_ruleAAndExpression= ruleAAndExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1370:2: iv_ruleAAndExpression= ruleAAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression2851);
            iv_ruleAAndExpression=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAndExpression2861); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1377:1: ruleAAndExpression returns [EObject current=null] : (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* ) ;
    public final EObject ruleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AEqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1380:28: ( (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1381:1: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1381:1: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1382:5: this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2908);
            this_AEqualityExpression_0=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1390:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==39) && (synpred2_InternalResults())) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1390:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1390:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1390:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1395:6: ( () ( (lv_feature_2_0= ruleOpAnd ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1395:7: () ( (lv_feature_2_0= ruleOpAnd ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1395:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1396:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1401:2: ( (lv_feature_2_0= ruleOpAnd ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1402:1: (lv_feature_2_0= ruleOpAnd )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1402:1: (lv_feature_2_0= ruleOpAnd )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1403:3: lv_feature_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getFeatureOpAndParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleAAndExpression2957);
            	    lv_feature_2_0=ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"feature",
            	              		lv_feature_2_0, 
            	              		"OpAnd");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1419:4: ( (lv_rightOperand_3_0= ruleAEqualityExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1420:1: (lv_rightOperand_3_0= ruleAEqualityExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1420:1: (lv_rightOperand_3_0= ruleAEqualityExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1421:3: lv_rightOperand_3_0= ruleAEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getRightOperandAEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2980);
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
            	    break loop30;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1445:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1446:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1447:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd3019);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd3030); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1454:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1457:28: (kw= '&&' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1459:2: kw= '&&'
            {
            kw=(Token)match(input,39,FOLLOW_39_in_ruleOpAnd3067); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); 
                  
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1472:1: entryRuleAEqualityExpression returns [EObject current=null] : iv_ruleAEqualityExpression= ruleAEqualityExpression EOF ;
    public final EObject entryRuleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAEqualityExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1473:2: (iv_ruleAEqualityExpression= ruleAEqualityExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1474:2: iv_ruleAEqualityExpression= ruleAEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAEqualityExpression_in_entryRuleAEqualityExpression3106);
            iv_ruleAEqualityExpression=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAEqualityExpression3116); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1481:1: ruleAEqualityExpression returns [EObject current=null] : (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* ) ;
    public final EObject ruleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ARelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1484:28: ( (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1485:1: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1485:1: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1486:5: this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3163);
            this_ARelationalExpression_0=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ARelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1494:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==40) && (synpred3_InternalResults())) {
                    alt31=1;
                }
                else if ( (LA31_0==41) && (synpred3_InternalResults())) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1494:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1494:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1494:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1499:6: ( () ( (lv_feature_2_0= ruleOpEquality ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1499:7: () ( (lv_feature_2_0= ruleOpEquality ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1499:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1500:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1505:2: ( (lv_feature_2_0= ruleOpEquality ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1506:1: (lv_feature_2_0= ruleOpEquality )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1506:1: (lv_feature_2_0= ruleOpEquality )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1507:3: lv_feature_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getFeatureOpEqualityParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleAEqualityExpression3212);
            	    lv_feature_2_0=ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"feature",
            	              		lv_feature_2_0, 
            	              		"OpEquality");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1523:4: ( (lv_rightOperand_3_0= ruleARelationalExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1524:1: (lv_rightOperand_3_0= ruleARelationalExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1524:1: (lv_rightOperand_3_0= ruleARelationalExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1525:3: lv_rightOperand_3_0= ruleARelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getRightOperandARelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3235);
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
            	    break loop31;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1549:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1550:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1551:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality3274);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality3285); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1558:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1561:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1562:1: (kw= '==' | kw= '!=' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1562:1: (kw= '==' | kw= '!=' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==40) ) {
                alt32=1;
            }
            else if ( (LA32_0==41) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1563:2: kw= '=='
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleOpEquality3323); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1570:2: kw= '!='
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleOpEquality3342); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1583:1: entryRuleARelationalExpression returns [EObject current=null] : iv_ruleARelationalExpression= ruleARelationalExpression EOF ;
    public final EObject entryRuleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARelationalExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1584:2: (iv_ruleARelationalExpression= ruleARelationalExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1585:2: iv_ruleARelationalExpression= ruleARelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression3382);
            iv_ruleARelationalExpression=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARelationalExpression3392); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1592:1: ruleARelationalExpression returns [EObject current=null] : (this_AOtherOperatorExpression_0= ruleAOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )* ) ;
    public final EObject ruleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AOtherOperatorExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1595:28: ( (this_AOtherOperatorExpression_0= ruleAOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1596:1: (this_AOtherOperatorExpression_0= ruleAOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1596:1: (this_AOtherOperatorExpression_0= ruleAOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1597:5: this_AOtherOperatorExpression_0= ruleAOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getARelationalExpressionAccess().getAOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAOtherOperatorExpression_in_ruleARelationalExpression3439);
            this_AOtherOperatorExpression_0=ruleAOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1605:1: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==42) && (synpred4_InternalResults())) {
                    alt33=1;
                }
                else if ( (LA33_0==43) && (synpred4_InternalResults())) {
                    alt33=1;
                }
                else if ( (LA33_0==44) && (synpred4_InternalResults())) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1605:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1605:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1605:3: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1610:6: ( () ( (lv_feature_2_0= ruleOpCompare ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1610:7: () ( (lv_feature_2_0= ruleOpCompare ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1610:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1611:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1616:2: ( (lv_feature_2_0= ruleOpCompare ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:1: (lv_feature_2_0= ruleOpCompare )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:1: (lv_feature_2_0= ruleOpCompare )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1618:3: lv_feature_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getFeatureOpCompareParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleARelationalExpression3488);
            	    lv_feature_2_0=ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"feature",
            	              		lv_feature_2_0, 
            	              		"OpCompare");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1634:4: ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1635:1: (lv_rightOperand_3_0= ruleAOtherOperatorExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1635:1: (lv_rightOperand_3_0= ruleAOtherOperatorExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1636:3: lv_rightOperand_3_0= ruleAOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getRightOperandAOtherOperatorExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAOtherOperatorExpression_in_ruleARelationalExpression3511);
            	    lv_rightOperand_3_0=ruleAOtherOperatorExpression();

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
            	              		"AOtherOperatorExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1660:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1661:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1662:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare3550);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare3561); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1669:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1672:28: ( (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1673:1: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1673:1: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            int alt34=4;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt34=1;
                }
                break;
            case 43:
                {
                int LA34_2 = input.LA(2);

                if ( (LA34_2==EOF||(LA34_2>=RULE_ID && LA34_2<=RULE_REAL_LIT)||LA34_2==33||(LA34_2>=51 && LA34_2<=52)||(LA34_2>=55 && LA34_2<=56)||(LA34_2>=59 && LA34_2<=60)||(LA34_2>=62 && LA34_2<=64)) ) {
                    alt34=4;
                }
                else if ( (LA34_2==27) ) {
                    alt34=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 2, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                alt34=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1674:2: kw= '>='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleOpCompare3599); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1680:6: (kw= '<' kw= '=' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1680:6: (kw= '<' kw= '=' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1681:2: kw= '<' kw= '='
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleOpCompare3619); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0()); 
                          
                    }
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpCompare3632); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1694:2: kw= '>'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleOpCompare3652); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1701:2: kw= '<'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleOpCompare3671); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAOtherOperatorExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1714:1: entryRuleAOtherOperatorExpression returns [EObject current=null] : iv_ruleAOtherOperatorExpression= ruleAOtherOperatorExpression EOF ;
    public final EObject entryRuleAOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOtherOperatorExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1715:2: (iv_ruleAOtherOperatorExpression= ruleAOtherOperatorExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1716:2: iv_ruleAOtherOperatorExpression= ruleAOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAOtherOperatorExpression_in_entryRuleAOtherOperatorExpression3711);
            iv_ruleAOtherOperatorExpression=ruleAOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAOtherOperatorExpression3721); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAOtherOperatorExpression"


    // $ANTLR start "ruleAOtherOperatorExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1723:1: ruleAOtherOperatorExpression returns [EObject current=null] : (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* ) ;
    public final EObject ruleAOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1726:28: ( (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1727:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1727:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1728:5: this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAOtherOperatorExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleAOtherOperatorExpression3768);
            this_AAdditiveExpression_0=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1736:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                alt35 = dfa35.predict(input);
                switch (alt35) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1736:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1736:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1736:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1741:6: ( () ( (lv_feature_2_0= ruleOpOther ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1741:7: () ( (lv_feature_2_0= ruleOpOther ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1741:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1742:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAOtherOperatorExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1747:2: ( (lv_feature_2_0= ruleOpOther ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1748:1: (lv_feature_2_0= ruleOpOther )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1748:1: (lv_feature_2_0= ruleOpOther )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1749:3: lv_feature_2_0= ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOtherOperatorExpressionAccess().getFeatureOpOtherParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleAOtherOperatorExpression3817);
            	    lv_feature_2_0=ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAOtherOperatorExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"feature",
            	              		lv_feature_2_0, 
            	              		"OpOther");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1765:4: ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1766:1: (lv_rightOperand_3_0= ruleAAdditiveExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1766:1: (lv_rightOperand_3_0= ruleAAdditiveExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1767:3: lv_rightOperand_3_0= ruleAAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOtherOperatorExpressionAccess().getRightOperandAAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleAOtherOperatorExpression3840);
            	    lv_rightOperand_3_0=ruleAAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAOtherOperatorExpressionRule());
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
    // $ANTLR end "ruleAOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1791:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1792:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1793:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther3879);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther3890); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1800:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1803:28: ( (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1804:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1804:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            int alt38=9;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1805:2: kw= '->'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleOpOther3928); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1812:2: kw= '..<'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleOpOther3947); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1818:6: (kw= '>' kw= '..' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1818:6: (kw= '>' kw= '..' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1819:2: kw= '>' kw= '..'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleOpOther3967); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0()); 
                          
                    }
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleOpOther3980); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1832:2: kw= '..'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleOpOther4000); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1839:2: kw= '=>'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleOpOther4019); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1845:6: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1845:6: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1846:2: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleOpOther4039); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0()); 
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1851:1: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==44) ) {
                        int LA36_1 = input.LA(2);

                        if ( (LA36_1==44) && (synpred6_InternalResults())) {
                            alt36=1;
                        }
                        else if ( (LA36_1==EOF||(LA36_1>=RULE_ID && LA36_1<=RULE_REAL_LIT)||LA36_1==33||(LA36_1>=51 && LA36_1<=52)||(LA36_1>=55 && LA36_1<=56)||(LA36_1>=59 && LA36_1<=60)||(LA36_1>=62 && LA36_1<=64)) ) {
                            alt36=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 36, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1851:2: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1851:2: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1851:3: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1855:5: (kw= '>' kw= '>' )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1856:2: kw= '>' kw= '>'
                            {
                            kw=(Token)match(input,44,FOLLOW_44_in_ruleOpOther4070); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0()); 
                                  
                            }
                            kw=(Token)match(input,44,FOLLOW_44_in_ruleOpOther4083); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1()); 
                                  
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1869:2: kw= '>'
                            {
                            kw=(Token)match(input,44,FOLLOW_44_in_ruleOpOther4104); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1875:6: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1875:6: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1876:2: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleOpOther4126); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0()); 
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1881:1: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    int alt37=3;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==43) ) {
                        int LA37_1 = input.LA(2);

                        if ( (LA37_1==EOF||(LA37_1>=RULE_ID && LA37_1<=RULE_REAL_LIT)||LA37_1==33||(LA37_1>=51 && LA37_1<=52)||(LA37_1>=55 && LA37_1<=56)||(LA37_1>=59 && LA37_1<=60)||(LA37_1>=62 && LA37_1<=64)) ) {
                            alt37=2;
                        }
                        else if ( (LA37_1==43) && (synpred7_InternalResults())) {
                            alt37=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 37, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA37_0==48) ) {
                        alt37=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                        throw nvae;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1881:2: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1881:2: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1881:3: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1885:5: (kw= '<' kw= '<' )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1886:2: kw= '<' kw= '<'
                            {
                            kw=(Token)match(input,43,FOLLOW_43_in_ruleOpOther4157); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0()); 
                                  
                            }
                            kw=(Token)match(input,43,FOLLOW_43_in_ruleOpOther4170); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1()); 
                                  
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1899:2: kw= '<'
                            {
                            kw=(Token)match(input,43,FOLLOW_43_in_ruleOpOther4191); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1()); 
                                  
                            }

                            }
                            break;
                        case 3 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1906:2: kw= '=>'
                            {
                            kw=(Token)match(input,48,FOLLOW_48_in_ruleOpOther4210); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1913:2: kw= '<>'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleOpOther4231); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1920:2: kw= '?:'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleOpOther4250); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8()); 
                          
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
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleAAdditiveExpression"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1933:1: entryRuleAAdditiveExpression returns [EObject current=null] : iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF ;
    public final EObject entryRuleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAdditiveExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1934:2: (iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1935:2: iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression4290);
            iv_ruleAAdditiveExpression=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAdditiveExpression4300); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1942:1: ruleAAdditiveExpression returns [EObject current=null] : (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AMultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1945:28: ( (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1946:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1946:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1947:5: this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4347);
            this_AMultiplicativeExpression_0=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==51) && (synpred8_InternalResults())) {
                    alt39=1;
                }
                else if ( (LA39_0==52) && (synpred8_InternalResults())) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1960:6: ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1960:7: () ( (lv_feature_2_0= ruleOpAdd ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1960:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1961:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1966:2: ( (lv_feature_2_0= ruleOpAdd ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1967:1: (lv_feature_2_0= ruleOpAdd )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1967:1: (lv_feature_2_0= ruleOpAdd )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1968:3: lv_feature_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getFeatureOpAddParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleAAdditiveExpression4396);
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

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1984:4: ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1985:1: (lv_rightOperand_3_0= ruleAMultiplicativeExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1985:1: (lv_rightOperand_3_0= ruleAMultiplicativeExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1986:3: lv_rightOperand_3_0= ruleAMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getRightOperandAMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4419);
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
    // $ANTLR end "ruleAAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2010:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2011:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2012:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd4458);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd4469); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2019:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2022:28: ( (kw= '+' | kw= '-' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2023:1: (kw= '+' | kw= '-' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2023:1: (kw= '+' | kw= '-' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==51) ) {
                alt40=1;
            }
            else if ( (LA40_0==52) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2024:2: kw= '+'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleOpAdd4507); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2031:2: kw= '-'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleOpAdd4526); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2044:1: entryRuleAMultiplicativeExpression returns [EObject current=null] : iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF ;
    public final EObject entryRuleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiplicativeExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2045:2: (iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2046:2: iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression4566);
            iv_ruleAMultiplicativeExpression=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiplicativeExpression4576); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2053:1: ruleAMultiplicativeExpression returns [EObject current=null] : (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* ) ;
    public final EObject ruleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AUnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2056:28: ( (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2057:1: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2057:1: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2058:5: this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4623);
            this_AUnaryOperation_0=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2066:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==53) && (synpred9_InternalResults())) {
                    alt41=1;
                }
                else if ( (LA41_0==54) && (synpred9_InternalResults())) {
                    alt41=1;
                }
                else if ( (LA41_0==36) && (synpred9_InternalResults())) {
                    alt41=1;
                }
                else if ( (LA41_0==34) && (synpred9_InternalResults())) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2066:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2066:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2066:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2071:6: ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2071:7: () ( (lv_feature_2_0= ruleOpMulti ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2071:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2072:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2077:2: ( (lv_feature_2_0= ruleOpMulti ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2078:1: (lv_feature_2_0= ruleOpMulti )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2078:1: (lv_feature_2_0= ruleOpMulti )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2079:3: lv_feature_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getFeatureOpMultiParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleAMultiplicativeExpression4672);
            	    lv_feature_2_0=ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"feature",
            	              		lv_feature_2_0, 
            	              		"OpMulti");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2095:4: ( (lv_rightOperand_3_0= ruleAUnaryOperation ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2096:1: (lv_rightOperand_3_0= ruleAUnaryOperation )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2096:1: (lv_rightOperand_3_0= ruleAUnaryOperation )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2097:3: lv_rightOperand_3_0= ruleAUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getRightOperandAUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4695);
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
    // $ANTLR end "ruleAMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2121:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2122:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2123:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti4734);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti4745); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2130:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2133:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2134:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2134:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt42=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt42=1;
                }
                break;
            case 54:
                {
                alt42=2;
                }
                break;
            case 36:
                {
                alt42=3;
                }
                break;
            case 34:
                {
                alt42=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2135:2: kw= '*'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleOpMulti4783); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2142:2: kw= '**'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleOpMulti4802); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2149:2: kw= '/'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpMulti4821); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2156:2: kw= '%'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpMulti4840); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); 
                          
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2169:1: entryRuleAUnaryOperation returns [EObject current=null] : iv_ruleAUnaryOperation= ruleAUnaryOperation EOF ;
    public final EObject entryRuleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnaryOperation = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2170:2: (iv_ruleAUnaryOperation= ruleAUnaryOperation EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2171:2: iv_ruleAUnaryOperation= ruleAUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleAUnaryOperation_in_entryRuleAUnaryOperation4880);
            iv_ruleAUnaryOperation=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUnaryOperation4890); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2178:1: ruleAUnaryOperation returns [EObject current=null] : ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression ) ;
    public final EObject ruleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_feature_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_APrimaryExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2181:28: ( ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2182:1: ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2182:1: ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=51 && LA43_0<=52)||LA43_0==55) ) {
                alt43=1;
            }
            else if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_REAL_LIT)||LA43_0==33||LA43_0==56||(LA43_0>=59 && LA43_0<=60)||(LA43_0>=62 && LA43_0<=64)) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2182:2: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2182:2: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2182:3: () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2182:3: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2183:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2188:2: ( (lv_feature_1_0= ruleOpUnary ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2189:1: (lv_feature_1_0= ruleOpUnary )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2189:1: (lv_feature_1_0= ruleOpUnary )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2190:3: lv_feature_1_0= ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getFeatureOpUnaryParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleAUnaryOperation4946);
                    lv_feature_1_0=ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
                      	        }
                             		set(
                             			current, 
                             			"feature",
                              		lv_feature_1_0, 
                              		"OpUnary");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2206:2: ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2207:1: (lv_operand_2_0= ruleAUnaryOperation )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2207:1: (lv_operand_2_0= ruleAUnaryOperation )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2208:3: lv_operand_2_0= ruleAUnaryOperation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAUnaryOperation4967);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2226:5: this_APrimaryExpression_3= ruleAPrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAUnaryOperationAccess().getAPrimaryExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAPrimaryExpression_in_ruleAUnaryOperation4996);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2242:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2243:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2244:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary5032);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary5043); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2251:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2254:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2255:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2255:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt44=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt44=1;
                }
                break;
            case 52:
                {
                alt44=2;
                }
                break;
            case 51:
                {
                alt44=3;
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2256:2: kw= '!'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleOpUnary5081); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2263:2: kw= '-'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleOpUnary5100); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2270:2: kw= '+'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleOpUnary5119); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2283:1: entryRuleAPrimaryExpression returns [EObject current=null] : iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF ;
    public final EObject entryRuleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPrimaryExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2284:2: (iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2285:2: iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAPrimaryExpression_in_entryRuleAPrimaryExpression5159);
            iv_ruleAPrimaryExpression=ruleAPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPrimaryExpression5169); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2292:1: ruleAPrimaryExpression returns [EObject current=null] : (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_APropertyReference_2= ruleAPropertyReference | this_AParenthesizedExpression_3= ruleAParenthesizedExpression ) ;
    public final EObject ruleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ALiteral_0 = null;

        EObject this_AVariableReference_1 = null;

        EObject this_APropertyReference_2 = null;

        EObject this_AParenthesizedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2295:28: ( (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_APropertyReference_2= ruleAPropertyReference | this_AParenthesizedExpression_3= ruleAParenthesizedExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2296:1: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_APropertyReference_2= ruleAPropertyReference | this_AParenthesizedExpression_3= ruleAParenthesizedExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2296:1: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_APropertyReference_2= ruleAPropertyReference | this_AParenthesizedExpression_3= ruleAParenthesizedExpression )
            int alt45=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INT:
            case RULE_REAL_LIT:
            case 56:
            case 59:
            case 62:
            case 63:
            case 64:
                {
                alt45=1;
                }
                break;
            case RULE_ID:
                {
                alt45=2;
                }
                break;
            case 33:
                {
                alt45=3;
                }
                break;
            case 60:
                {
                alt45=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2297:5: this_ALiteral_0= ruleALiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleALiteral_in_ruleAPrimaryExpression5216);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2307:5: this_AVariableReference_1= ruleAVariableReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAVariableReference_in_ruleAPrimaryExpression5243);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2317:5: this_APropertyReference_2= ruleAPropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAPropertyReferenceParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAPropertyReference_in_ruleAPrimaryExpression5270);
                    this_APropertyReference_2=ruleAPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_APropertyReference_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2327:5: this_AParenthesizedExpression_3= ruleAParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAParenthesizedExpression_in_ruleAPrimaryExpression5297);
                    this_AParenthesizedExpression_3=ruleAParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AParenthesizedExpression_3; 
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


    // $ANTLR start "entryRuleALiteral"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2343:1: entryRuleALiteral returns [EObject current=null] : iv_ruleALiteral= ruleALiteral EOF ;
    public final EObject entryRuleALiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleALiteral = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2344:2: (iv_ruleALiteral= ruleALiteral EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2345:2: iv_ruleALiteral= ruleALiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getALiteralRule()); 
            }
            pushFollow(FOLLOW_ruleALiteral_in_entryRuleALiteral5332);
            iv_ruleALiteral=ruleALiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleALiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleALiteral5342); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2352:1: ruleALiteral returns [EObject current=null] : (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm ) ;
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
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2355:28: ( (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2356:1: (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2356:1: (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm )
            int alt46=7;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt46=1;
                }
                break;
            case 59:
                {
                alt46=2;
                }
                break;
            case 62:
            case 63:
                {
                alt46=3;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt46=4;
                }
                break;
            case RULE_INT:
                {
                alt46=5;
                }
                break;
            case 64:
                {
                alt46=6;
                }
                break;
            case RULE_STRING:
                {
                alt46=7;
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2357:5: this_ASetTerm_0= ruleASetTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getASetTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASetTerm_in_ruleALiteral5389);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2367:5: this_AListTerm_1= ruleAListTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getAListTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAListTerm_in_ruleALiteral5416);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2377:5: this_ABooleanLiteral_2= ruleABooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleABooleanLiteral_in_ruleALiteral5443);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2387:5: this_ARealTerm_3= ruleARealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleARealTerm_in_ruleALiteral5470);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2397:5: this_AIntegerTerm_4= ruleAIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAIntegerTerm_in_ruleALiteral5497);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2407:5: this_ANullLiteral_5= ruleANullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getANullLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleANullLiteral_in_ruleALiteral5524);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2417:5: this_StringTerm_6= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringTerm_in_ruleALiteral5551);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2433:1: entryRuleAIntegerTerm returns [EObject current=null] : iv_ruleAIntegerTerm= ruleAIntegerTerm EOF ;
    public final EObject entryRuleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIntegerTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2434:2: (iv_ruleAIntegerTerm= ruleAIntegerTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2435:2: iv_ruleAIntegerTerm= ruleAIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntegerTermRule()); 
            }
            pushFollow(FOLLOW_ruleAIntegerTerm_in_entryRuleAIntegerTerm5586);
            iv_ruleAIntegerTerm=ruleAIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAIntegerTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIntegerTerm5596); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2442:1: ruleAIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2445:28: ( ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2446:1: ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2446:1: ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2446:2: ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2446:2: ( (lv_value_0_0= ruleAInt ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2447:1: (lv_value_0_0= ruleAInt )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2447:1: (lv_value_0_0= ruleAInt )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2448:3: lv_value_0_0= ruleAInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAInt_in_ruleAIntegerTerm5642);
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2464:2: ( (otherlv_1= RULE_ID ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2465:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2465:1: (otherlv_1= RULE_ID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2466:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAIntegerTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAIntegerTerm5662); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2485:1: entryRuleAInt returns [String current=null] : iv_ruleAInt= ruleAInt EOF ;
    public final String entryRuleAInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAInt = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2486:2: (iv_ruleAInt= ruleAInt EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2487:2: iv_ruleAInt= ruleAInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntRule()); 
            }
            pushFollow(FOLLOW_ruleAInt_in_entryRuleAInt5700);
            iv_ruleAInt=ruleAInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAInt5711); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2494:1: ruleAInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleAInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2497:28: (this_INT_0= RULE_INT )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2498:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAInt5750); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2513:1: entryRuleARealTerm returns [EObject current=null] : iv_ruleARealTerm= ruleARealTerm EOF ;
    public final EObject entryRuleARealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARealTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2514:2: (iv_ruleARealTerm= ruleARealTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2515:2: iv_ruleARealTerm= ruleARealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealTermRule()); 
            }
            pushFollow(FOLLOW_ruleARealTerm_in_entryRuleARealTerm5794);
            iv_ruleARealTerm=ruleARealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARealTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARealTerm5804); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2522:1: ruleARealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleARealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2525:28: ( ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2526:1: ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2526:1: ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2526:2: ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2526:2: ( (lv_value_0_0= ruleAReal ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2527:1: (lv_value_0_0= ruleAReal )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2527:1: (lv_value_0_0= ruleAReal )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2528:3: lv_value_0_0= ruleAReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAReal_in_ruleARealTerm5850);
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2544:2: ( (otherlv_1= RULE_ID ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2545:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2545:1: (otherlv_1= RULE_ID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2546:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getARealTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleARealTerm5870); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2565:1: entryRuleAReal returns [String current=null] : iv_ruleAReal= ruleAReal EOF ;
    public final String entryRuleAReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAReal = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2566:2: (iv_ruleAReal= ruleAReal EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2567:2: iv_ruleAReal= ruleAReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealRule()); 
            }
            pushFollow(FOLLOW_ruleAReal_in_entryRuleAReal5908);
            iv_ruleAReal=ruleAReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAReal.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAReal5919); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2574:1: ruleAReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleAReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2577:28: (this_REAL_LIT_0= RULE_REAL_LIT )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2578:5: this_REAL_LIT_0= RULE_REAL_LIT
            {
            this_REAL_LIT_0=(Token)match(input,RULE_REAL_LIT,FOLLOW_RULE_REAL_LIT_in_ruleAReal5958); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2595:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2596:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2597:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumAltRule()); 
            }
            pushFollow(FOLLOW_ruleNumAlt_in_entryRuleNumAlt6004);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumAlt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumAlt6014); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2604:1: ruleNumAlt returns [EObject current=null] : (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_ARealTerm_0 = null;

        EObject this_AIntegerTerm_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2607:28: ( (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2608:1: (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2608:1: (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_REAL_LIT) ) {
                alt49=1;
            }
            else if ( (LA49_0==RULE_INT) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2609:5: this_ARealTerm_0= ruleARealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getARealTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleARealTerm_in_ruleNumAlt6061);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2619:5: this_AIntegerTerm_1= ruleAIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getAIntegerTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAIntegerTerm_in_ruleNumAlt6088);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2635:1: entryRuleASetTerm returns [EObject current=null] : iv_ruleASetTerm= ruleASetTerm EOF ;
    public final EObject entryRuleASetTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASetTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2636:2: (iv_ruleASetTerm= ruleASetTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2637:2: iv_ruleASetTerm= ruleASetTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASetTermRule()); 
            }
            pushFollow(FOLLOW_ruleASetTerm_in_entryRuleASetTerm6123);
            iv_ruleASetTerm=ruleASetTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASetTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASetTerm6133); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2644:1: ruleASetTerm returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleASetTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_elements_2_0 = null;

        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2647:28: ( ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2648:1: ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2648:1: ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2648:2: () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2648:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2649:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getASetTermAccess().getASetLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleASetTerm6179); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASetTermAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2658:1: ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=RULE_ID && LA51_0<=RULE_REAL_LIT)||LA51_0==33||(LA51_0>=51 && LA51_0<=52)||(LA51_0>=55 && LA51_0<=56)||(LA51_0>=59 && LA51_0<=60)||(LA51_0>=62 && LA51_0<=64)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2658:2: ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )*
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2658:2: ( (lv_elements_2_0= ruleAExpression ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2659:1: (lv_elements_2_0= ruleAExpression )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2659:1: (lv_elements_2_0= ruleAExpression )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2660:3: lv_elements_2_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getASetTermAccess().getElementsAExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAExpression_in_ruleASetTerm6201);
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

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2676:2: (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==57) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2676:4: otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,57,FOLLOW_57_in_ruleASetTerm6214); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getASetTermAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2680:1: ( (lv_elements_4_0= ruleAExpression ) )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2681:1: (lv_elements_4_0= ruleAExpression )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2681:1: (lv_elements_4_0= ruleAExpression )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2682:3: lv_elements_4_0= ruleAExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getASetTermAccess().getElementsAExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleAExpression_in_ruleASetTerm6235);
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
                    	    break loop50;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,58,FOLLOW_58_in_ruleASetTerm6251); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2710:1: entryRuleAListTerm returns [EObject current=null] : iv_ruleAListTerm= ruleAListTerm EOF ;
    public final EObject entryRuleAListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAListTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2711:2: (iv_ruleAListTerm= ruleAListTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2712:2: iv_ruleAListTerm= ruleAListTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAListTermRule()); 
            }
            pushFollow(FOLLOW_ruleAListTerm_in_entryRuleAListTerm6287);
            iv_ruleAListTerm=ruleAListTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAListTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAListTerm6297); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2719:1: ruleAListTerm returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )? otherlv_6= ']' ) ;
    public final EObject ruleAListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_elements_3_0 = null;

        EObject lv_elements_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2722:28: ( ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )? otherlv_6= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2723:1: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )? otherlv_6= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2723:1: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )? otherlv_6= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2723:2: () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )? otherlv_6= ']'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2723:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2724:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAListTermAccess().getAListTermAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleAListTerm6343); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAListTermAccess().getNumberSignKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleAListTerm6355); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAListTermAccess().getLeftSquareBracketKeyword_2());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2737:1: ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=RULE_ID && LA53_0<=RULE_REAL_LIT)||LA53_0==33||(LA53_0>=51 && LA53_0<=52)||(LA53_0>=55 && LA53_0<=56)||(LA53_0>=59 && LA53_0<=60)||(LA53_0>=62 && LA53_0<=64)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2737:2: ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )*
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2737:2: ( (lv_elements_3_0= ruleAExpression ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2738:1: (lv_elements_3_0= ruleAExpression )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2738:1: (lv_elements_3_0= ruleAExpression )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2739:3: lv_elements_3_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAListTermAccess().getElementsAExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAExpression_in_ruleAListTerm6377);
                    lv_elements_3_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAListTermRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_3_0, 
                              		"AExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2755:2: (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==57) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2755:4: otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,57,FOLLOW_57_in_ruleAListTerm6390); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getAListTermAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2759:1: ( (lv_elements_5_0= ruleAExpression ) )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2760:1: (lv_elements_5_0= ruleAExpression )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2760:1: (lv_elements_5_0= ruleAExpression )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2761:3: lv_elements_5_0= ruleAExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAListTermAccess().getElementsAExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleAExpression_in_ruleAListTerm6411);
                    	    lv_elements_5_0=ruleAExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAListTermRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_5_0, 
                    	              		"AExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleAListTerm6427); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAListTermAccess().getRightSquareBracketKeyword_4());
                  
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2789:1: entryRuleAParenthesizedExpression returns [EObject current=null] : iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF ;
    public final EObject entryRuleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAParenthesizedExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2790:2: (iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2791:2: iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAParenthesizedExpression_in_entryRuleAParenthesizedExpression6463);
            iv_ruleAParenthesizedExpression=ruleAParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAParenthesizedExpression6473); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2798:1: ruleAParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) ;
    public final EObject ruleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2801:28: ( (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2802:1: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2802:1: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2802:3: otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleAParenthesizedExpression6510); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleAParenthesizedExpression6532);
            this_AExpression_1=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,61,FOLLOW_61_in_ruleAParenthesizedExpression6543); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2827:1: entryRuleABooleanLiteral returns [EObject current=null] : iv_ruleABooleanLiteral= ruleABooleanLiteral EOF ;
    public final EObject entryRuleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleABooleanLiteral = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2828:2: (iv_ruleABooleanLiteral= ruleABooleanLiteral EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2829:2: iv_ruleABooleanLiteral= ruleABooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getABooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleABooleanLiteral_in_entryRuleABooleanLiteral6579);
            iv_ruleABooleanLiteral=ruleABooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleABooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleABooleanLiteral6589); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2836:1: ruleABooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2839:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2840:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2840:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2840:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2840:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2841:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2846:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==62) ) {
                alt54=1;
            }
            else if ( (LA54_0==63) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2846:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2846:3: ( (lv_value_1_0= 'true' ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2847:1: (lv_value_1_0= 'true' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2847:1: (lv_value_1_0= 'true' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2848:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,62,FOLLOW_62_in_ruleABooleanLiteral6642); if (state.failed) return current;
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2862:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,63,FOLLOW_63_in_ruleABooleanLiteral6673); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2874:1: entryRuleANullLiteral returns [EObject current=null] : iv_ruleANullLiteral= ruleANullLiteral EOF ;
    public final EObject entryRuleANullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleANullLiteral = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2875:2: (iv_ruleANullLiteral= ruleANullLiteral EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2876:2: iv_ruleANullLiteral= ruleANullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getANullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleANullLiteral_in_entryRuleANullLiteral6710);
            iv_ruleANullLiteral=ruleANullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleANullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleANullLiteral6720); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2883:1: ruleANullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleANullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2886:28: ( ( () otherlv_1= 'null' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2887:1: ( () otherlv_1= 'null' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2887:1: ( () otherlv_1= 'null' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2887:2: () otherlv_1= 'null'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2887:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2888:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getANullLiteralAccess().getANullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleANullLiteral6766); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2905:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2906:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2907:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm6802);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm6812); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2914:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2917:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2918:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2918:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2919:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2919:1: (lv_value_0_0= ruleNoQuoteString )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2920:3: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_ruleStringTerm6857);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2944:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2945:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2946:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString6893);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNoQuoteString6904); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2953:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2956:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2957:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNoQuoteString6943); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2976:1: entryRuleAADLPROPERTYREFERENCE returns [String current=null] : iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF ;
    public final String entryRuleAADLPROPERTYREFERENCE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAADLPROPERTYREFERENCE = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2977:2: (iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2978:2: iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAADLPROPERTYREFERENCERule()); 
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_entryRuleAADLPROPERTYREFERENCE6992);
            iv_ruleAADLPROPERTYREFERENCE=ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAADLPROPERTYREFERENCE.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAADLPROPERTYREFERENCE7003); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2985:1: ruleAADLPROPERTYREFERENCE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAADLPROPERTYREFERENCE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2988:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2989:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2989:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2989:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7043); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2996:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==65) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2997:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleAADLPROPERTYREFERENCE7062); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0()); 
                          
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7077); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3017:1: entryRuleURIID returns [String current=null] : iv_ruleURIID= ruleURIID EOF ;
    public final String entryRuleURIID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURIID = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3018:2: (iv_ruleURIID= ruleURIID EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3019:2: iv_ruleURIID= ruleURIID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIIDRule()); 
            }
            pushFollow(FOLLOW_ruleURIID_in_entryRuleURIID7125);
            iv_ruleURIID=ruleURIID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIID7136); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3026:1: ruleURIID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleURIID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3029:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3030:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIID7175); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3047:1: ruleResultIssueType returns [Enumerator current=null] : ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) ) ;
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
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3049:28: ( ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3050:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3050:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) )
            int alt56=6;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt56=1;
                }
                break;
            case 67:
                {
                alt56=2;
                }
                break;
            case 68:
                {
                alt56=3;
                }
                break;
            case 69:
                {
                alt56=4;
                }
                break;
            case 70:
                {
                alt56=5;
                }
                break;
            case 71:
                {
                alt56=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3050:2: (enumLiteral_0= 'tbd' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3050:2: (enumLiteral_0= 'tbd' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3050:4: enumLiteral_0= 'tbd'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_66_in_ruleResultIssueType7235); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3056:6: (enumLiteral_1= 'error' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3056:6: (enumLiteral_1= 'error' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3056:8: enumLiteral_1= 'error'
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_67_in_ruleResultIssueType7252); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3062:6: (enumLiteral_2= 'warning' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3062:6: (enumLiteral_2= 'warning' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3062:8: enumLiteral_2= 'warning'
                    {
                    enumLiteral_2=(Token)match(input,68,FOLLOW_68_in_ruleResultIssueType7269); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3068:6: (enumLiteral_3= 'info' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3068:6: (enumLiteral_3= 'info' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3068:8: enumLiteral_3= 'info'
                    {
                    enumLiteral_3=(Token)match(input,69,FOLLOW_69_in_ruleResultIssueType7286); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3074:6: (enumLiteral_4= 'success' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3074:6: (enumLiteral_4= 'success' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3074:8: enumLiteral_4= 'success'
                    {
                    enumLiteral_4=(Token)match(input,70,FOLLOW_70_in_ruleResultIssueType7303); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3080:6: (enumLiteral_5= 'fail' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3080:6: (enumLiteral_5= 'fail' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3080:8: enumLiteral_5= 'fail'
                    {
                    enumLiteral_5=(Token)match(input,71,FOLLOW_71_in_ruleResultIssueType7320); if (state.failed) return current;
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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1286:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1286:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1286:4: ( () ( ( ruleOpOr ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1286:5: () ( ( ruleOpOr ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1286:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1287:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1287:2: ( ( ruleOpOr ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1288:1: ( ruleOpOr )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1288:1: ( ruleOpOr )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1289:1: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred1_InternalResults2672);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalResults

    // $ANTLR start synpred2_InternalResults
    public final void synpred2_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1390:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1390:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1390:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1390:5: () ( ( ruleOpAnd ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1390:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1391:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1391:2: ( ( ruleOpAnd ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1392:1: ( ruleOpAnd )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1392:1: ( ruleOpAnd )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1393:1: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred2_InternalResults2927);
        ruleOpAnd();

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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1494:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1494:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1494:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1494:5: () ( ( ruleOpEquality ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1494:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1495:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1495:2: ( ( ruleOpEquality ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1496:1: ( ruleOpEquality )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1496:1: ( ruleOpEquality )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1497:1: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred3_InternalResults3182);
        ruleOpEquality();

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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1605:3: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1605:4: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1605:4: ( () ( ( ruleOpCompare ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1605:5: () ( ( ruleOpCompare ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1605:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1606:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1606:2: ( ( ruleOpCompare ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1607:1: ( ruleOpCompare )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1607:1: ( ruleOpCompare )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1608:1: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred4_InternalResults3458);
        ruleOpCompare();

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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1736:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1736:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1736:4: ( () ( ( ruleOpOther ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1736:5: () ( ( ruleOpOther ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1736:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1737:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1737:2: ( ( ruleOpOther ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1738:1: ( ruleOpOther )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1738:1: ( ruleOpOther )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1739:1: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred5_InternalResults3787);
        ruleOpOther();

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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1851:3: ( ( '>' '>' ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1851:4: ( '>' '>' )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1851:4: ( '>' '>' )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1852:2: '>' '>'
        {
        match(input,44,FOLLOW_44_in_synpred6_InternalResults4054); if (state.failed) return ;
        match(input,44,FOLLOW_44_in_synpred6_InternalResults4059); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalResults

    // $ANTLR start synpred7_InternalResults
    public final void synpred7_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1881:3: ( ( '<' '<' ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1881:4: ( '<' '<' )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1881:4: ( '<' '<' )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1882:2: '<' '<'
        {
        match(input,43,FOLLOW_43_in_synpred7_InternalResults4141); if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred7_InternalResults4146); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalResults

    // $ANTLR start synpred8_InternalResults
    public final void synpred8_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:5: () ( ( ruleOpAdd ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1955:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1956:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1956:2: ( ( ruleOpAdd ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1957:1: ( ruleOpAdd )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1957:1: ( ruleOpAdd )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1958:1: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalResults4366);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalResults

    // $ANTLR start synpred9_InternalResults
    public final void synpred9_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2066:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2066:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2066:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2066:5: () ( ( ruleOpMulti ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2066:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2067:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2067:2: ( ( ruleOpMulti ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2068:1: ( ruleOpMulti )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2068:1: ( ruleOpMulti )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2069:1: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalResults4642);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalResults

    // Delegated rules

    public final boolean synpred9_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalResults_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred8_InternalResults() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalResults_fragment(); // can never throw exception
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


    protected DFA35 dfa35 = new DFA35(this);
    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA35_eotS =
        "\16\uffff";
    static final String DFA35_eofS =
        "\1\1\15\uffff";
    static final String DFA35_minS =
        "\1\26\1\uffff\2\4\12\uffff";
    static final String DFA35_maxS =
        "\1\75\1\uffff\2\100\12\uffff";
    static final String DFA35_acceptS =
        "\1\uffff\1\2\2\uffff\12\1";
    static final String DFA35_specialS =
        "\1\0\1\uffff\1\2\1\1\12\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1\17\uffff\5\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\6\uffff"+
            "\2\1\2\uffff\1\1",
            "",
            "\4\1\23\uffff\1\1\5\uffff\1\1\11\uffff\1\12\4\uffff\1\13\2"+
            "\uffff\2\1\2\uffff\2\1\2\uffff\2\1\1\uffff\3\1",
            "\4\1\31\uffff\1\1\12\uffff\1\15\2\uffff\1\14\3\uffff\2\1\2"+
            "\uffff\2\1\2\uffff\2\1\1\uffff\3\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "()* loopback of 1736:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_0 = input.LA(1);

                         
                        int index35_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA35_0==EOF||LA35_0==22||(LA35_0>=38 && LA35_0<=42)||(LA35_0>=57 && LA35_0<=58)||LA35_0==61) ) {s = 1;}

                        else if ( (LA35_0==43) ) {s = 2;}

                        else if ( (LA35_0==44) ) {s = 3;}

                        else if ( (LA35_0==45) && (synpred5_InternalResults())) {s = 4;}

                        else if ( (LA35_0==46) && (synpred5_InternalResults())) {s = 5;}

                        else if ( (LA35_0==47) && (synpred5_InternalResults())) {s = 6;}

                        else if ( (LA35_0==48) && (synpred5_InternalResults())) {s = 7;}

                        else if ( (LA35_0==49) && (synpred5_InternalResults())) {s = 8;}

                        else if ( (LA35_0==50) && (synpred5_InternalResults())) {s = 9;}

                         
                        input.seek(index35_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_3 = input.LA(1);

                         
                        int index35_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA35_3>=RULE_ID && LA35_3<=RULE_REAL_LIT)||LA35_3==33||(LA35_3>=51 && LA35_3<=52)||(LA35_3>=55 && LA35_3<=56)||(LA35_3>=59 && LA35_3<=60)||(LA35_3>=62 && LA35_3<=64)) ) {s = 1;}

                        else if ( (LA35_3==47) && (synpred5_InternalResults())) {s = 12;}

                        else if ( (LA35_3==44) && (synpred5_InternalResults())) {s = 13;}

                         
                        input.seek(index35_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_2 = input.LA(1);

                         
                        int index35_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA35_2>=RULE_ID && LA35_2<=RULE_REAL_LIT)||LA35_2==27||LA35_2==33||(LA35_2>=51 && LA35_2<=52)||(LA35_2>=55 && LA35_2<=56)||(LA35_2>=59 && LA35_2<=60)||(LA35_2>=62 && LA35_2<=64)) ) {s = 1;}

                        else if ( (LA35_2==43) && (synpred5_InternalResults())) {s = 10;}

                        else if ( (LA35_2==48) && (synpred5_InternalResults())) {s = 11;}

                         
                        input.seek(index35_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA38_eotS =
        "\13\uffff";
    static final String DFA38_eofS =
        "\13\uffff";
    static final String DFA38_minS =
        "\1\53\2\uffff\1\54\7\uffff";
    static final String DFA38_maxS =
        "\1\62\2\uffff\1\57\7\uffff";
    static final String DFA38_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\6\1\3";
    static final String DFA38_specialS =
        "\13\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\6\1\3\1\1\1\2\1\4\1\5\1\7\1\10",
            "",
            "",
            "\1\11\2\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "1804:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )";
        }
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
    public static final BitSet FOLLOW_20_in_ruleResultReportCollection374 = new BitSet(new long[]{0x0000000010E20000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_21_in_ruleResultReportCollection387 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportCollection404 = new BitSet(new long[]{0x0000000010C20000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_ruleResultReport_in_ruleResultReportCollection432 = new BitSet(new long[]{0x0000000010C20000L,0x00000000000000FCL});
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
    public static final BitSet FOLLOW_20_in_ruleResultDataReport656 = new BitSet(new long[]{0x0000000003600000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_21_in_ruleResultDataReport669 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultDataReport686 = new BitSet(new long[]{0x0000000003400000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_24_in_ruleResultDataReport706 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultDataReport723 = new BitSet(new long[]{0x0000000006400000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultDataReport749 = new BitSet(new long[]{0x0000000006400000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_25_in_ruleResultDataReport765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultDataReport786 = new BitSet(new long[]{0x0000000000400010L,0x00000000000000FCL});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultDataReport810 = new BitSet(new long[]{0x0000000000400000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_22_in_ruleResultDataReport823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_entryRuleResultContributor859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultContributor869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleResultContributor906 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultContributor929 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleResultContributor941 = new BitSet(new long[]{0x0000000006400000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_25_in_ruleResultContributor954 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultContributor975 = new BitSet(new long[]{0x0000000004400010L,0x00000000000000FCL});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultContributor999 = new BitSet(new long[]{0x0000000004400000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultContributor1021 = new BitSet(new long[]{0x0000000004400000L});
    public static final BitSet FOLLOW_22_in_ruleResultContributor1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_entryRuleResultData1070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultData1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultData1122 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleResultData1139 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultData1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport1197 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIssuesReport1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleIssuesReport1244 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIssuesReport1261 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_19_in_ruleIssuesReport1279 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleIssuesReport1302 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleIssuesReport1317 = new BitSet(new long[]{0x0000000000600000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_21_in_ruleIssuesReport1330 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIssuesReport1347 = new BitSet(new long[]{0x0000000000400000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleIssuesReport1375 = new BitSet(new long[]{0x0000000000400000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_22_in_ruleIssuesReport1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_ruleDescriptionElement1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDescriptionElement1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImageReference_in_ruleDescriptionElement1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_entryRuleResultIssue1616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultIssue1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_ruleResultIssue1672 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1689 = new BitSet(new long[]{0x00000001C0100002L});
    public static final BitSet FOLLOW_30_in_ruleResultIssue1707 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultIssue1730 = new BitSet(new long[]{0x0000000180100002L});
    public static final BitSet FOLLOW_31_in_ruleResultIssue1745 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1762 = new BitSet(new long[]{0x0000000100100002L});
    public static final BitSet FOLLOW_32_in_ruleResultIssue1782 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1799 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleResultIssue1819 = new BitSet(new long[]{0x0000000000400000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultIssue1840 = new BitSet(new long[]{0x0000000000400000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_22_in_ruleResultIssue1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPropertyReference_in_entryRuleAPropertyReference1895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPropertyReference1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleAPropertyReference1951 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAPropertyReference1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableReference_in_entryRuleAVariableReference2010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAVariableReference2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAVariableReference2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_entryRuleShowValue2110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShowValue2120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue2165 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleShowValue2178 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue2198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImageReference_in_entryRuleImageReference2236 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImageReference2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleImageReference2283 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIMGREF_in_ruleImageReference2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMGREF_in_entryRuleIMGREF2341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMGREF2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF2393 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleIMGREF2411 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF2428 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleIMGREF2446 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF2461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExpression_in_entryRuleAExpression2506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExpression2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_ruleAExpression2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression2596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAOrExpression2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression2653 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleAOrExpression2702 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression2725 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr2764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr2775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpOr2812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression2851 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAndExpression2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2908 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleAAndExpression2957 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2980 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd3019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpAnd3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_entryRuleAEqualityExpression3106 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAEqualityExpression3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3163 = new BitSet(new long[]{0x0000030000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleAEqualityExpression3212 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3235 = new BitSet(new long[]{0x0000030000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality3274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality3285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpEquality3323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOpEquality3342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression3382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARelationalExpression3392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOtherOperatorExpression_in_ruleARelationalExpression3439 = new BitSet(new long[]{0x00001C0000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleARelationalExpression3488 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAOtherOperatorExpression_in_ruleARelationalExpression3511 = new BitSet(new long[]{0x00001C0000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare3550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOpCompare3599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpCompare3619 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleOpCompare3632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOpCompare3652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpCompare3671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOtherOperatorExpression_in_entryRuleAOtherOperatorExpression3711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAOtherOperatorExpression3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleAOtherOperatorExpression3768 = new BitSet(new long[]{0x0007F80000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleAOtherOperatorExpression3817 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleAOtherOperatorExpression3840 = new BitSet(new long[]{0x0007F80000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther3879 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleOpOther3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleOpOther3947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOpOther3967 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleOpOther3980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleOpOther4000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOpOther4019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOpOther4039 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleOpOther4070 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleOpOther4083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOpOther4104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpOther4126 = new BitSet(new long[]{0x0001080000000000L});
    public static final BitSet FOLLOW_43_in_ruleOpOther4157 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleOpOther4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpOther4191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOpOther4210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOpOther4231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOpOther4250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression4290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAdditiveExpression4300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4347 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleAAdditiveExpression4396 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4419 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd4458 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd4469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOpAdd4507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleOpAdd4526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression4566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiplicativeExpression4576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4623 = new BitSet(new long[]{0x0060001400000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleAMultiplicativeExpression4672 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4695 = new BitSet(new long[]{0x0060001400000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti4734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti4745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleOpMulti4783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleOpMulti4802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpMulti4821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpMulti4840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_entryRuleAUnaryOperation4880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUnaryOperation4890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleAUnaryOperation4946 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAUnaryOperation4967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPrimaryExpression_in_ruleAUnaryOperation4996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary5032 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary5043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleOpUnary5081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleOpUnary5100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOpUnary5119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPrimaryExpression_in_entryRuleAPrimaryExpression5159 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPrimaryExpression5169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALiteral_in_ruleAPrimaryExpression5216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableReference_in_ruleAPrimaryExpression5243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPropertyReference_in_ruleAPrimaryExpression5270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParenthesizedExpression_in_ruleAPrimaryExpression5297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALiteral_in_entryRuleALiteral5332 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleALiteral5342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASetTerm_in_ruleALiteral5389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAListTerm_in_ruleALiteral5416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanLiteral_in_ruleALiteral5443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_ruleALiteral5470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_ruleALiteral5497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANullLiteral_in_ruleALiteral5524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_ruleALiteral5551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_entryRuleAIntegerTerm5586 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIntegerTerm5596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInt_in_ruleAIntegerTerm5642 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAIntegerTerm5662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInt_in_entryRuleAInt5700 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAInt5711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAInt5750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_entryRuleARealTerm5794 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARealTerm5804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReal_in_ruleARealTerm5850 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleARealTerm5870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReal_in_entryRuleAReal5908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAReal5919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_LIT_in_ruleAReal5958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumAlt_in_entryRuleNumAlt6004 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumAlt6014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_ruleNumAlt6061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_ruleNumAlt6088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASetTerm_in_entryRuleASetTerm6123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASetTerm6133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleASetTerm6179 = new BitSet(new long[]{0xDD980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleASetTerm6201 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_57_in_ruleASetTerm6214 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleASetTerm6235 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_58_in_ruleASetTerm6251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAListTerm_in_entryRuleAListTerm6287 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAListTerm6297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleAListTerm6343 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAListTerm6355 = new BitSet(new long[]{0xD9980002004000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAListTerm6377 = new BitSet(new long[]{0x0200000000400000L});
    public static final BitSet FOLLOW_57_in_ruleAListTerm6390 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAListTerm6411 = new BitSet(new long[]{0x0200000000400000L});
    public static final BitSet FOLLOW_22_in_ruleAListTerm6427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParenthesizedExpression_in_entryRuleAParenthesizedExpression6463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAParenthesizedExpression6473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleAParenthesizedExpression6510 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAParenthesizedExpression6532 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleAParenthesizedExpression6543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanLiteral_in_entryRuleABooleanLiteral6579 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleABooleanLiteral6589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleABooleanLiteral6642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleABooleanLiteral6673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANullLiteral_in_entryRuleANullLiteral6710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleANullLiteral6720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleANullLiteral6766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm6802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm6812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleStringTerm6857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString6893 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNoQuoteString6904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNoQuoteString6943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_entryRuleAADLPROPERTYREFERENCE6992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAADLPROPERTYREFERENCE7003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7043 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleAADLPROPERTYREFERENCE7062 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_entryRuleURIID7125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIID7136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIID7175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleResultIssueType7235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleResultIssueType7252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleResultIssueType7269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleResultIssueType7286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleResultIssueType7303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleResultIssueType7320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred1_InternalResults2672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred2_InternalResults2927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred3_InternalResults3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred4_InternalResults3458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred5_InternalResults3787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred6_InternalResults4054 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred6_InternalResults4059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred7_InternalResults4141 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred7_InternalResults4146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalResults4366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalResults4642 = new BitSet(new long[]{0x0000000000000002L});

}

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_REAL_LIT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_EXTENDED_DIGIT", "RULE_BASED_INTEGER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'reports'", "':'", "'for'", "'['", "'description'", "']'", "'report'", "'heading'", "'results'", "'contributor'", "'='", "'issues'", "'this'", "'issue'", "'target'", "'exception'", "'@'", "'%'", "'img'", "'/'", "'.'", "'||'", "'&&'", "'=='", "'!='", "'>='", "'<'", "'>'", "'->'", "'..<'", "'..'", "'=>'", "'<>'", "'?:'", "'+'", "'-'", "'*'", "'**'", "'!'", "'{'", "','", "'}'", "'#'", "'('", "')'", "'true'", "'false'", "'null'", "'::'", "'tbd'", "'unknown'", "'error'", "'warning'", "'info'", "'success'", "'fail'"
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
    public static final int T__72=72;
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

            if ( (LA5_0==30) ) {
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

                if ( (LA12_0==30) ) {
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

                if ( (LA15_0==30) ) {
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

                        if ( (LA19_0==30) ) {
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:859:1: ruleResultIssue returns [EObject current=null] : (otherlv_0= 'issue' ( (lv_issueType_1_0= ruleResultIssueType ) ) ( (lv_message_2_0= RULE_STRING ) ) (otherlv_3= 'target' ( ( ruleURIID ) ) )? (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )? ) ;
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
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:862:28: ( (otherlv_0= 'issue' ( (lv_issueType_1_0= ruleResultIssueType ) ) ( (lv_message_2_0= RULE_STRING ) ) (otherlv_3= 'target' ( ( ruleURIID ) ) )? (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:863:1: (otherlv_0= 'issue' ( (lv_issueType_1_0= ruleResultIssueType ) ) ( (lv_message_2_0= RULE_STRING ) ) (otherlv_3= 'target' ( ( ruleURIID ) ) )? (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:863:1: (otherlv_0= 'issue' ( (lv_issueType_1_0= ruleResultIssueType ) ) ( (lv_message_2_0= RULE_STRING ) ) (otherlv_3= 'target' ( ( ruleURIID ) ) )? (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:863:3: otherlv_0= 'issue' ( (lv_issueType_1_0= ruleResultIssueType ) ) ( (lv_message_2_0= RULE_STRING ) ) (otherlv_3= 'target' ( ( ruleURIID ) ) )? (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )? (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleResultIssue1663); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getResultIssueAccess().getIssueKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:867:1: ( (lv_issueType_1_0= ruleResultIssueType ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:868:1: (lv_issueType_1_0= ruleResultIssueType )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:868:1: (lv_issueType_1_0= ruleResultIssueType )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:869:3: lv_issueType_1_0= ruleResultIssueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleResultIssueType_in_ruleResultIssue1684);
            lv_issueType_1_0=ruleResultIssueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:885:2: ( (lv_message_2_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:886:1: (lv_message_2_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:886:1: (lv_message_2_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:887:3: lv_message_2_0= RULE_STRING
            {
            lv_message_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1701); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_message_2_0, grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

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


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:903:2: (otherlv_3= 'target' ( ( ruleURIID ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==31) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:903:4: otherlv_3= 'target' ( ( ruleURIID ) )
                    {
                    otherlv_3=(Token)match(input,31,FOLLOW_31_in_ruleResultIssue1719); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getResultIssueAccess().getTargetKeyword_3_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:907:1: ( ( ruleURIID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:908:1: ( ruleURIID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:908:1: ( ruleURIID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:909:3: ruleURIID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultIssueRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleURIID_in_ruleResultIssue1742);
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:922:4: (otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:922:6: otherlv_5= 'exception' ( (lv_exceptionType_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_32_in_ruleResultIssue1757); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getResultIssueAccess().getExceptionKeyword_4_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:926:1: ( (lv_exceptionType_6_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:927:1: (lv_exceptionType_6_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:927:1: (lv_exceptionType_6_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:928:3: lv_exceptionType_6_0= RULE_STRING
                    {
                    lv_exceptionType_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue1774); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_exceptionType_6_0, grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

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


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:944:4: (otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==20) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:944:6: otherlv_7= '[' ( (lv_issues_8_0= ruleResultIssue ) )* otherlv_9= ']'
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleResultIssue1794); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:948:1: ( (lv_issues_8_0= ruleResultIssue ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==30) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:949:1: (lv_issues_8_0= ruleResultIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:949:1: (lv_issues_8_0= ruleResultIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:950:3: lv_issues_8_0= ruleResultIssue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultIssue1815);
                    	    lv_issues_8_0=ruleResultIssue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

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


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,22,FOLLOW_22_in_ruleResultIssue1828); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2());
                          
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:982:1: entryRuleAPropertyReference returns [EObject current=null] : iv_ruleAPropertyReference= ruleAPropertyReference EOF ;
    public final EObject entryRuleAPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPropertyReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:983:2: (iv_ruleAPropertyReference= ruleAPropertyReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:984:2: iv_ruleAPropertyReference= ruleAPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAPropertyReference_in_entryRuleAPropertyReference1870);
            iv_ruleAPropertyReference=ruleAPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPropertyReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPropertyReference1880); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:991:1: ruleAPropertyReference returns [EObject current=null] : ( () otherlv_1= '@' ( ( ruleAADLPROPERTYREFERENCE ) ) ) ;
    public final EObject ruleAPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:994:28: ( ( () otherlv_1= '@' ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:995:1: ( () otherlv_1= '@' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:995:1: ( () otherlv_1= '@' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:995:2: () otherlv_1= '@' ( ( ruleAADLPROPERTYREFERENCE ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:995:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:996:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleAPropertyReference1926); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAPropertyReferenceAccess().getCommercialAtKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1005:1: ( ( ruleAADLPROPERTYREFERENCE ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1006:1: ( ruleAADLPROPERTYREFERENCE )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1006:1: ( ruleAADLPROPERTYREFERENCE )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1007:3: ruleAADLPROPERTYREFERENCE
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAPropertyReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAPropertyReference1949);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1028:1: entryRuleAVariableReference returns [EObject current=null] : iv_ruleAVariableReference= ruleAVariableReference EOF ;
    public final EObject entryRuleAVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAVariableReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1029:2: (iv_ruleAVariableReference= ruleAVariableReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1030:2: iv_ruleAVariableReference= ruleAVariableReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAVariableReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAVariableReference_in_entryRuleAVariableReference1985);
            iv_ruleAVariableReference=ruleAVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAVariableReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAVariableReference1995); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1037:1: ruleAVariableReference returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleAVariableReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1040:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1041:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1041:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1041:2: () ( (otherlv_1= RULE_ID ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1041:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1042:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1047:2: ( (otherlv_1= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1048:1: (otherlv_1= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1048:1: (otherlv_1= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1049:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAVariableReferenceRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAVariableReference2049); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1068:1: entryRuleShowValue returns [EObject current=null] : iv_ruleShowValue= ruleShowValue EOF ;
    public final EObject entryRuleShowValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShowValue = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1069:2: (iv_ruleShowValue= ruleShowValue EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1070:2: iv_ruleShowValue= ruleShowValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShowValueRule()); 
            }
            pushFollow(FOLLOW_ruleShowValue_in_entryRuleShowValue2085);
            iv_ruleShowValue=ruleShowValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShowValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShowValue2095); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1077:1: ruleShowValue returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject ruleShowValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1080:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1081:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1081:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1081:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1081:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1082:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1082:1: (otherlv_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1083:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getShowValueRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue2140); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getShowValueAccess().getRefAVariableDeclarationCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1094:2: (otherlv_1= '%' ( (otherlv_2= RULE_ID ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==34) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1094:4: otherlv_1= '%' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleShowValue2153); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0());
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1098:1: ( (otherlv_2= RULE_ID ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1099:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1099:1: (otherlv_2= RULE_ID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1100:3: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getShowValueRule());
                      	        }
                              
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue2173); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1119:1: entryRuleImageReference returns [EObject current=null] : iv_ruleImageReference= ruleImageReference EOF ;
    public final EObject entryRuleImageReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageReference = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1120:2: (iv_ruleImageReference= ruleImageReference EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1121:2: iv_ruleImageReference= ruleImageReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImageReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleImageReference_in_entryRuleImageReference2211);
            iv_ruleImageReference=ruleImageReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImageReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImageReference2221); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1128:1: ruleImageReference returns [EObject current=null] : (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) ;
    public final EObject ruleImageReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_imgfile_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1131:28: ( (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1132:1: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1132:1: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1132:3: otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleImageReference2258); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImageReferenceAccess().getImgKeyword_0());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1136:1: ( (lv_imgfile_1_0= ruleIMGREF ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1137:1: (lv_imgfile_1_0= ruleIMGREF )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1137:1: (lv_imgfile_1_0= ruleIMGREF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1138:3: lv_imgfile_1_0= ruleIMGREF
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIMGREF_in_ruleImageReference2279);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1162:1: entryRuleIMGREF returns [String current=null] : iv_ruleIMGREF= ruleIMGREF EOF ;
    public final String entryRuleIMGREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMGREF = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1163:2: (iv_ruleIMGREF= ruleIMGREF EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1164:2: iv_ruleIMGREF= ruleIMGREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIMGREFRule()); 
            }
            pushFollow(FOLLOW_ruleIMGREF_in_entryRuleIMGREF2316);
            iv_ruleIMGREF=ruleIMGREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIMGREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMGREF2327); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1171:1: ruleIMGREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIMGREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1174:28: ( ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1175:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1175:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1175:2: (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1175:2: (this_ID_0= RULE_ID kw= '/' )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==36) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1175:7: this_ID_0= RULE_ID kw= '/'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF2368); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,36,FOLLOW_36_in_ruleIMGREF2386); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF2403); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            kw=(Token)match(input,37,FOLLOW_37_in_ruleIMGREF2421); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getIMGREFAccess().getFullStopKeyword_2()); 
                  
            }
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF2436); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1216:1: entryRuleAExpression returns [EObject current=null] : iv_ruleAExpression= ruleAExpression EOF ;
    public final EObject entryRuleAExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1217:2: (iv_ruleAExpression= ruleAExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1218:2: iv_ruleAExpression= ruleAExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAExpression_in_entryRuleAExpression2481);
            iv_ruleAExpression=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExpression2491); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1225:1: ruleAExpression returns [EObject current=null] : this_AOrExpression_0= ruleAOrExpression ;
    public final EObject ruleAExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AOrExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1228:28: (this_AOrExpression_0= ruleAOrExpression )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1230:5: this_AOrExpression_0= ruleAOrExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleAOrExpression_in_ruleAExpression2537);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1246:1: entryRuleAOrExpression returns [EObject current=null] : iv_ruleAOrExpression= ruleAOrExpression EOF ;
    public final EObject entryRuleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOrExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1247:2: (iv_ruleAOrExpression= ruleAOrExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1248:2: iv_ruleAOrExpression= ruleAOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression2571);
            iv_ruleAOrExpression=ruleAOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAOrExpression2581); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1255:1: ruleAOrExpression returns [EObject current=null] : (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* ) ;
    public final EObject ruleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAndExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1258:28: ( (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1259:1: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1259:1: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1260:5: this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression2628);
            this_AAndExpression_0=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1268:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==38) && (synpred1_InternalResults())) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1268:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleAAndExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1268:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1268:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOr ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1273:6: ( () ( (lv_feature_2_0= ruleOpOr ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1273:7: () ( (lv_feature_2_0= ruleOpOr ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1273:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1274:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1279:2: ( (lv_feature_2_0= ruleOpOr ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1280:1: (lv_feature_2_0= ruleOpOr )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1280:1: (lv_feature_2_0= ruleOpOr )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1281:3: lv_feature_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getFeatureOpOrParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleAOrExpression2677);
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

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1297:4: ( (lv_rightOperand_3_0= ruleAAndExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1298:1: (lv_rightOperand_3_0= ruleAAndExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1298:1: (lv_rightOperand_3_0= ruleAAndExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1299:3: lv_rightOperand_3_0= ruleAAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getRightOperandAAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression2700);
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
            	    break loop28;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1323:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1324:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1325:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr2739);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr2750); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1332:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1335:28: (kw= '||' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1337:2: kw= '||'
            {
            kw=(Token)match(input,38,FOLLOW_38_in_ruleOpOr2787); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1350:1: entryRuleAAndExpression returns [EObject current=null] : iv_ruleAAndExpression= ruleAAndExpression EOF ;
    public final EObject entryRuleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAndExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1351:2: (iv_ruleAAndExpression= ruleAAndExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1352:2: iv_ruleAAndExpression= ruleAAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression2826);
            iv_ruleAAndExpression=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAndExpression2836); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1359:1: ruleAAndExpression returns [EObject current=null] : (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* ) ;
    public final EObject ruleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AEqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1362:28: ( (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1363:1: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1363:1: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1364:5: this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2883);
            this_AEqualityExpression_0=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1372:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==39) && (synpred2_InternalResults())) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1372:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleAEqualityExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1372:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1372:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAnd ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1377:6: ( () ( (lv_feature_2_0= ruleOpAnd ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1377:7: () ( (lv_feature_2_0= ruleOpAnd ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1377:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1378:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1383:2: ( (lv_feature_2_0= ruleOpAnd ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1384:1: (lv_feature_2_0= ruleOpAnd )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1384:1: (lv_feature_2_0= ruleOpAnd )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1385:3: lv_feature_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getFeatureOpAndParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleAAndExpression2932);
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

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1401:4: ( (lv_rightOperand_3_0= ruleAEqualityExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1402:1: (lv_rightOperand_3_0= ruleAEqualityExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1402:1: (lv_rightOperand_3_0= ruleAEqualityExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1403:3: lv_rightOperand_3_0= ruleAEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getRightOperandAEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2955);
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
    // $ANTLR end "ruleAAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1427:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1428:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1429:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd2994);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd3005); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1436:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1439:28: (kw= '&&' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1441:2: kw= '&&'
            {
            kw=(Token)match(input,39,FOLLOW_39_in_ruleOpAnd3042); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1454:1: entryRuleAEqualityExpression returns [EObject current=null] : iv_ruleAEqualityExpression= ruleAEqualityExpression EOF ;
    public final EObject entryRuleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAEqualityExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1455:2: (iv_ruleAEqualityExpression= ruleAEqualityExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1456:2: iv_ruleAEqualityExpression= ruleAEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAEqualityExpression_in_entryRuleAEqualityExpression3081);
            iv_ruleAEqualityExpression=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAEqualityExpression3091); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1463:1: ruleAEqualityExpression returns [EObject current=null] : (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* ) ;
    public final EObject ruleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ARelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1466:28: ( (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1467:1: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1467:1: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1468:5: this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3138);
            this_ARelationalExpression_0=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ARelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1476:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==40) && (synpred3_InternalResults())) {
                    alt30=1;
                }
                else if ( (LA30_0==41) && (synpred3_InternalResults())) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1476:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleARelationalExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1476:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1476:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpEquality ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1481:6: ( () ( (lv_feature_2_0= ruleOpEquality ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1481:7: () ( (lv_feature_2_0= ruleOpEquality ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1481:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1482:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1487:2: ( (lv_feature_2_0= ruleOpEquality ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1488:1: (lv_feature_2_0= ruleOpEquality )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1488:1: (lv_feature_2_0= ruleOpEquality )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1489:3: lv_feature_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getFeatureOpEqualityParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleAEqualityExpression3187);
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

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1505:4: ( (lv_rightOperand_3_0= ruleARelationalExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1506:1: (lv_rightOperand_3_0= ruleARelationalExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1506:1: (lv_rightOperand_3_0= ruleARelationalExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1507:3: lv_rightOperand_3_0= ruleARelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getRightOperandARelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3210);
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
    // $ANTLR end "ruleAEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1531:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1532:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1533:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality3249);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality3260); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1540:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1543:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1544:1: (kw= '==' | kw= '!=' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1544:1: (kw= '==' | kw= '!=' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==40) ) {
                alt31=1;
            }
            else if ( (LA31_0==41) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1545:2: kw= '=='
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleOpEquality3298); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1552:2: kw= '!='
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleOpEquality3317); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1565:1: entryRuleARelationalExpression returns [EObject current=null] : iv_ruleARelationalExpression= ruleARelationalExpression EOF ;
    public final EObject entryRuleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARelationalExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1566:2: (iv_ruleARelationalExpression= ruleARelationalExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1567:2: iv_ruleARelationalExpression= ruleARelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression3357);
            iv_ruleARelationalExpression=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARelationalExpression3367); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1574:1: ruleARelationalExpression returns [EObject current=null] : (this_AOtherOperatorExpression_0= ruleAOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )* ) ;
    public final EObject ruleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AOtherOperatorExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1577:28: ( (this_AOtherOperatorExpression_0= ruleAOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1578:1: (this_AOtherOperatorExpression_0= ruleAOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1578:1: (this_AOtherOperatorExpression_0= ruleAOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1579:5: this_AOtherOperatorExpression_0= ruleAOtherOperatorExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getARelationalExpressionAccess().getAOtherOperatorExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAOtherOperatorExpression_in_ruleARelationalExpression3414);
            this_AOtherOperatorExpression_0=ruleAOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AOtherOperatorExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1587:1: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==42) && (synpred4_InternalResults())) {
                    alt32=1;
                }
                else if ( (LA32_0==43) && (synpred4_InternalResults())) {
                    alt32=1;
                }
                else if ( (LA32_0==44) && (synpred4_InternalResults())) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1587:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) ) ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1587:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1587:3: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpCompare ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1592:6: ( () ( (lv_feature_2_0= ruleOpCompare ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1592:7: () ( (lv_feature_2_0= ruleOpCompare ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1592:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1593:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1598:2: ( (lv_feature_2_0= ruleOpCompare ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1599:1: (lv_feature_2_0= ruleOpCompare )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1599:1: (lv_feature_2_0= ruleOpCompare )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1600:3: lv_feature_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getFeatureOpCompareParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleARelationalExpression3463);
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

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1616:4: ( (lv_rightOperand_3_0= ruleAOtherOperatorExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:1: (lv_rightOperand_3_0= ruleAOtherOperatorExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1617:1: (lv_rightOperand_3_0= ruleAOtherOperatorExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1618:3: lv_rightOperand_3_0= ruleAOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getRightOperandAOtherOperatorExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAOtherOperatorExpression_in_ruleARelationalExpression3486);
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
            	    break loop32;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1642:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1643:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1644:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare3525);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare3536); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1651:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1654:28: ( (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1655:1: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1655:1: (kw= '>=' | (kw= '<' kw= '=' ) | kw= '>' | kw= '<' )
            int alt33=4;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt33=1;
                }
                break;
            case 43:
                {
                int LA33_2 = input.LA(2);

                if ( (LA33_2==EOF||(LA33_2>=RULE_ID && LA33_2<=RULE_REAL_LIT)||LA33_2==33||(LA33_2>=51 && LA33_2<=52)||(LA33_2>=55 && LA33_2<=56)||(LA33_2>=59 && LA33_2<=60)||(LA33_2>=62 && LA33_2<=64)) ) {
                    alt33=4;
                }
                else if ( (LA33_2==27) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                alt33=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1656:2: kw= '>='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleOpCompare3574); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1662:6: (kw= '<' kw= '=' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1662:6: (kw= '<' kw= '=' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1663:2: kw= '<' kw= '='
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleOpCompare3594); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0()); 
                          
                    }
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleOpCompare3607); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1676:2: kw= '>'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleOpCompare3627); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1683:2: kw= '<'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleOpCompare3646); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1696:1: entryRuleAOtherOperatorExpression returns [EObject current=null] : iv_ruleAOtherOperatorExpression= ruleAOtherOperatorExpression EOF ;
    public final EObject entryRuleAOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOtherOperatorExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1697:2: (iv_ruleAOtherOperatorExpression= ruleAOtherOperatorExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1698:2: iv_ruleAOtherOperatorExpression= ruleAOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAOtherOperatorExpression_in_entryRuleAOtherOperatorExpression3686);
            iv_ruleAOtherOperatorExpression=ruleAOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAOtherOperatorExpression3696); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1705:1: ruleAOtherOperatorExpression returns [EObject current=null] : (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* ) ;
    public final EObject ruleAOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1708:28: ( (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1709:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1709:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1710:5: this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAOtherOperatorExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleAOtherOperatorExpression3743);
            this_AAdditiveExpression_0=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1718:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                alt34 = dfa34.predict(input);
                switch (alt34) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1718:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1718:2: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1718:3: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1723:6: ( () ( (lv_feature_2_0= ruleOpOther ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1723:7: () ( (lv_feature_2_0= ruleOpOther ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1723:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1724:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAOtherOperatorExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1729:2: ( (lv_feature_2_0= ruleOpOther ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1730:1: (lv_feature_2_0= ruleOpOther )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1730:1: (lv_feature_2_0= ruleOpOther )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1731:3: lv_feature_2_0= ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOtherOperatorExpressionAccess().getFeatureOpOtherParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOther_in_ruleAOtherOperatorExpression3792);
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

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1747:4: ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1748:1: (lv_rightOperand_3_0= ruleAAdditiveExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1748:1: (lv_rightOperand_3_0= ruleAAdditiveExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1749:3: lv_rightOperand_3_0= ruleAAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOtherOperatorExpressionAccess().getRightOperandAAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleAOtherOperatorExpression3815);
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
            	    break loop34;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1773:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1774:2: (iv_ruleOpOther= ruleOpOther EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1775:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_ruleOpOther_in_entryRuleOpOther3854);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOther3865); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1782:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1785:28: ( (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1786:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1786:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )
            int alt37=9;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1787:2: kw= '->'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleOpOther3903); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1794:2: kw= '..<'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleOpOther3922); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1800:6: (kw= '>' kw= '..' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1800:6: (kw= '>' kw= '..' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1801:2: kw= '>' kw= '..'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleOpOther3942); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0()); 
                          
                    }
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleOpOther3955); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1814:2: kw= '..'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleOpOther3975); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1821:2: kw= '=>'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleOpOther3994); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1827:6: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1827:6: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1828:2: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleOpOther4014); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0()); 
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1833:1: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==44) ) {
                        int LA35_1 = input.LA(2);

                        if ( (LA35_1==EOF||(LA35_1>=RULE_ID && LA35_1<=RULE_REAL_LIT)||LA35_1==33||(LA35_1>=51 && LA35_1<=52)||(LA35_1>=55 && LA35_1<=56)||(LA35_1>=59 && LA35_1<=60)||(LA35_1>=62 && LA35_1<=64)) ) {
                            alt35=2;
                        }
                        else if ( (LA35_1==44) && (synpred6_InternalResults())) {
                            alt35=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 35, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1833:2: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1833:2: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1833:3: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1837:5: (kw= '>' kw= '>' )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1838:2: kw= '>' kw= '>'
                            {
                            kw=(Token)match(input,44,FOLLOW_44_in_ruleOpOther4045); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0()); 
                                  
                            }
                            kw=(Token)match(input,44,FOLLOW_44_in_ruleOpOther4058); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1()); 
                                  
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1851:2: kw= '>'
                            {
                            kw=(Token)match(input,44,FOLLOW_44_in_ruleOpOther4079); if (state.failed) return current;
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1857:6: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1857:6: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1858:2: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleOpOther4101); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0()); 
                          
                    }
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1863:1: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' )
                    int alt36=3;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==43) ) {
                        int LA36_1 = input.LA(2);

                        if ( (LA36_1==EOF||(LA36_1>=RULE_ID && LA36_1<=RULE_REAL_LIT)||LA36_1==33||(LA36_1>=51 && LA36_1<=52)||(LA36_1>=55 && LA36_1<=56)||(LA36_1>=59 && LA36_1<=60)||(LA36_1>=62 && LA36_1<=64)) ) {
                            alt36=2;
                        }
                        else if ( (LA36_1==43) && (synpred7_InternalResults())) {
                            alt36=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 36, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA36_0==48) ) {
                        alt36=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1863:2: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1863:2: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1863:3: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
                            {
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1867:5: (kw= '<' kw= '<' )
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1868:2: kw= '<' kw= '<'
                            {
                            kw=(Token)match(input,43,FOLLOW_43_in_ruleOpOther4132); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0()); 
                                  
                            }
                            kw=(Token)match(input,43,FOLLOW_43_in_ruleOpOther4145); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1()); 
                                  
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1881:2: kw= '<'
                            {
                            kw=(Token)match(input,43,FOLLOW_43_in_ruleOpOther4166); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      current.merge(kw);
                                      newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1()); 
                                  
                            }

                            }
                            break;
                        case 3 :
                            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1888:2: kw= '=>'
                            {
                            kw=(Token)match(input,48,FOLLOW_48_in_ruleOpOther4185); if (state.failed) return current;
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1895:2: kw= '<>'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleOpOther4206); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1902:2: kw= '?:'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleOpOther4225); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1915:1: entryRuleAAdditiveExpression returns [EObject current=null] : iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF ;
    public final EObject entryRuleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAdditiveExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1916:2: (iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1917:2: iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression4265);
            iv_ruleAAdditiveExpression=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAdditiveExpression4275); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1924:1: ruleAAdditiveExpression returns [EObject current=null] : (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AMultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1927:28: ( (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1928:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1928:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1929:5: this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4322);
            this_AMultiplicativeExpression_0=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1937:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==51) && (synpred8_InternalResults())) {
                    alt38=1;
                }
                else if ( (LA38_0==52) && (synpred8_InternalResults())) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1937:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1937:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1937:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1942:6: ( () ( (lv_feature_2_0= ruleOpAdd ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1942:7: () ( (lv_feature_2_0= ruleOpAdd ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1942:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1943:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1948:2: ( (lv_feature_2_0= ruleOpAdd ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1949:1: (lv_feature_2_0= ruleOpAdd )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1949:1: (lv_feature_2_0= ruleOpAdd )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1950:3: lv_feature_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getFeatureOpAddParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleAAdditiveExpression4371);
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

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1966:4: ( (lv_rightOperand_3_0= ruleAMultiplicativeExpression ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1967:1: (lv_rightOperand_3_0= ruleAMultiplicativeExpression )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1967:1: (lv_rightOperand_3_0= ruleAMultiplicativeExpression )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1968:3: lv_rightOperand_3_0= ruleAMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getRightOperandAMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4394);
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
            	    break loop38;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1992:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1993:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1994:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd4433);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd4444); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2001:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2004:28: ( (kw= '+' | kw= '-' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2005:1: (kw= '+' | kw= '-' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2005:1: (kw= '+' | kw= '-' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==51) ) {
                alt39=1;
            }
            else if ( (LA39_0==52) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2006:2: kw= '+'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleOpAdd4482); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2013:2: kw= '-'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleOpAdd4501); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2026:1: entryRuleAMultiplicativeExpression returns [EObject current=null] : iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF ;
    public final EObject entryRuleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiplicativeExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2027:2: (iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2028:2: iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression4541);
            iv_ruleAMultiplicativeExpression=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiplicativeExpression4551); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2035:1: ruleAMultiplicativeExpression returns [EObject current=null] : (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* ) ;
    public final EObject ruleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AUnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_feature_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2038:28: ( (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2039:1: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2039:1: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )* )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2040:5: this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4598);
            this_AUnaryOperation_0=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2048:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==53) && (synpred9_InternalResults())) {
                    alt40=1;
                }
                else if ( (LA40_0==54) && (synpred9_InternalResults())) {
                    alt40=1;
                }
                else if ( (LA40_0==36) && (synpred9_InternalResults())) {
                    alt40=1;
                }
                else if ( (LA40_0==34) && (synpred9_InternalResults())) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2048:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleAUnaryOperation ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2048:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2048:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2053:6: ( () ( (lv_feature_2_0= ruleOpMulti ) ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2053:7: () ( (lv_feature_2_0= ruleOpMulti ) )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2053:7: ()
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2054:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftOperandAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2059:2: ( (lv_feature_2_0= ruleOpMulti ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2060:1: (lv_feature_2_0= ruleOpMulti )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2060:1: (lv_feature_2_0= ruleOpMulti )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2061:3: lv_feature_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getFeatureOpMultiParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleAMultiplicativeExpression4647);
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

            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2077:4: ( (lv_rightOperand_3_0= ruleAUnaryOperation ) )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2078:1: (lv_rightOperand_3_0= ruleAUnaryOperation )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2078:1: (lv_rightOperand_3_0= ruleAUnaryOperation )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2079:3: lv_rightOperand_3_0= ruleAUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getRightOperandAUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4670);
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
            	    break loop40;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2103:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2104:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2105:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti4709);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti4720); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2112:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2115:28: ( (kw= '*' | kw= '**' | kw= '/' | kw= '%' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2116:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2116:1: (kw= '*' | kw= '**' | kw= '/' | kw= '%' )
            int alt41=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt41=1;
                }
                break;
            case 54:
                {
                alt41=2;
                }
                break;
            case 36:
                {
                alt41=3;
                }
                break;
            case 34:
                {
                alt41=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2117:2: kw= '*'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleOpMulti4758); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2124:2: kw= '**'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleOpMulti4777); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2131:2: kw= '/'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpMulti4796); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2138:2: kw= '%'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleOpMulti4815); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2151:1: entryRuleAUnaryOperation returns [EObject current=null] : iv_ruleAUnaryOperation= ruleAUnaryOperation EOF ;
    public final EObject entryRuleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnaryOperation = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2152:2: (iv_ruleAUnaryOperation= ruleAUnaryOperation EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2153:2: iv_ruleAUnaryOperation= ruleAUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleAUnaryOperation_in_entryRuleAUnaryOperation4855);
            iv_ruleAUnaryOperation=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUnaryOperation4865); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2160:1: ruleAUnaryOperation returns [EObject current=null] : ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression ) ;
    public final EObject ruleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_feature_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_APrimaryExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2163:28: ( ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2164:1: ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2164:1: ( ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_APrimaryExpression_3= ruleAPrimaryExpression )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=51 && LA42_0<=52)||LA42_0==55) ) {
                alt42=1;
            }
            else if ( ((LA42_0>=RULE_ID && LA42_0<=RULE_REAL_LIT)||LA42_0==33||LA42_0==56||(LA42_0>=59 && LA42_0<=60)||(LA42_0>=62 && LA42_0<=64)) ) {
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2164:2: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2164:2: ( () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2164:3: () ( (lv_feature_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2164:3: ()
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2165:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2170:2: ( (lv_feature_1_0= ruleOpUnary ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2171:1: (lv_feature_1_0= ruleOpUnary )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2171:1: (lv_feature_1_0= ruleOpUnary )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2172:3: lv_feature_1_0= ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getFeatureOpUnaryParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleAUnaryOperation4921);
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

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2188:2: ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2189:1: (lv_operand_2_0= ruleAUnaryOperation )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2189:1: (lv_operand_2_0= ruleAUnaryOperation )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2190:3: lv_operand_2_0= ruleAUnaryOperation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAUnaryOperation4942);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2208:5: this_APrimaryExpression_3= ruleAPrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAUnaryOperationAccess().getAPrimaryExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAPrimaryExpression_in_ruleAUnaryOperation4971);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2224:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2225:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2226:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary5007);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary5018); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2233:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2236:28: ( (kw= '!' | kw= '-' | kw= '+' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2237:1: (kw= '!' | kw= '-' | kw= '+' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2237:1: (kw= '!' | kw= '-' | kw= '+' )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt43=1;
                }
                break;
            case 52:
                {
                alt43=2;
                }
                break;
            case 51:
                {
                alt43=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2238:2: kw= '!'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleOpUnary5056); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2245:2: kw= '-'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleOpUnary5075); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2252:2: kw= '+'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleOpUnary5094); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2265:1: entryRuleAPrimaryExpression returns [EObject current=null] : iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF ;
    public final EObject entryRuleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPrimaryExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2266:2: (iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2267:2: iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAPrimaryExpression_in_entryRuleAPrimaryExpression5134);
            iv_ruleAPrimaryExpression=ruleAPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPrimaryExpression5144); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2274:1: ruleAPrimaryExpression returns [EObject current=null] : (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_APropertyReference_2= ruleAPropertyReference | this_AParenthesizedExpression_3= ruleAParenthesizedExpression ) ;
    public final EObject ruleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ALiteral_0 = null;

        EObject this_AVariableReference_1 = null;

        EObject this_APropertyReference_2 = null;

        EObject this_AParenthesizedExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2277:28: ( (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_APropertyReference_2= ruleAPropertyReference | this_AParenthesizedExpression_3= ruleAParenthesizedExpression ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2278:1: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_APropertyReference_2= ruleAPropertyReference | this_AParenthesizedExpression_3= ruleAParenthesizedExpression )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2278:1: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_APropertyReference_2= ruleAPropertyReference | this_AParenthesizedExpression_3= ruleAParenthesizedExpression )
            int alt44=4;
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
                alt44=1;
                }
                break;
            case RULE_ID:
                {
                alt44=2;
                }
                break;
            case 33:
                {
                alt44=3;
                }
                break;
            case 60:
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2279:5: this_ALiteral_0= ruleALiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleALiteral_in_ruleAPrimaryExpression5191);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2289:5: this_AVariableReference_1= ruleAVariableReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAVariableReference_in_ruleAPrimaryExpression5218);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2299:5: this_APropertyReference_2= ruleAPropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAPropertyReferenceParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAPropertyReference_in_ruleAPrimaryExpression5245);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2309:5: this_AParenthesizedExpression_3= ruleAParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAParenthesizedExpression_in_ruleAPrimaryExpression5272);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2325:1: entryRuleALiteral returns [EObject current=null] : iv_ruleALiteral= ruleALiteral EOF ;
    public final EObject entryRuleALiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleALiteral = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2326:2: (iv_ruleALiteral= ruleALiteral EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2327:2: iv_ruleALiteral= ruleALiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getALiteralRule()); 
            }
            pushFollow(FOLLOW_ruleALiteral_in_entryRuleALiteral5307);
            iv_ruleALiteral=ruleALiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleALiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleALiteral5317); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2334:1: ruleALiteral returns [EObject current=null] : (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm ) ;
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
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2337:28: ( (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2338:1: (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2338:1: (this_ASetTerm_0= ruleASetTerm | this_AListTerm_1= ruleAListTerm | this_ABooleanLiteral_2= ruleABooleanLiteral | this_ARealTerm_3= ruleARealTerm | this_AIntegerTerm_4= ruleAIntegerTerm | this_ANullLiteral_5= ruleANullLiteral | this_StringTerm_6= ruleStringTerm )
            int alt45=7;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt45=1;
                }
                break;
            case 59:
                {
                alt45=2;
                }
                break;
            case 62:
            case 63:
                {
                alt45=3;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt45=4;
                }
                break;
            case RULE_INT:
                {
                alt45=5;
                }
                break;
            case 64:
                {
                alt45=6;
                }
                break;
            case RULE_STRING:
                {
                alt45=7;
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2339:5: this_ASetTerm_0= ruleASetTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getASetTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASetTerm_in_ruleALiteral5364);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2349:5: this_AListTerm_1= ruleAListTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getAListTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAListTerm_in_ruleALiteral5391);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2359:5: this_ABooleanLiteral_2= ruleABooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleABooleanLiteral_in_ruleALiteral5418);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2369:5: this_ARealTerm_3= ruleARealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleARealTerm_in_ruleALiteral5445);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2379:5: this_AIntegerTerm_4= ruleAIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAIntegerTerm_in_ruleALiteral5472);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2389:5: this_ANullLiteral_5= ruleANullLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getANullLiteralParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleANullLiteral_in_ruleALiteral5499);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2399:5: this_StringTerm_6= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringTerm_in_ruleALiteral5526);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2415:1: entryRuleAIntegerTerm returns [EObject current=null] : iv_ruleAIntegerTerm= ruleAIntegerTerm EOF ;
    public final EObject entryRuleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIntegerTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2416:2: (iv_ruleAIntegerTerm= ruleAIntegerTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2417:2: iv_ruleAIntegerTerm= ruleAIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntegerTermRule()); 
            }
            pushFollow(FOLLOW_ruleAIntegerTerm_in_entryRuleAIntegerTerm5561);
            iv_ruleAIntegerTerm=ruleAIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAIntegerTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIntegerTerm5571); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2424:1: ruleAIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2427:28: ( ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2428:1: ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2428:1: ( ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2428:2: ( (lv_value_0_0= ruleAInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2428:2: ( (lv_value_0_0= ruleAInt ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2429:1: (lv_value_0_0= ruleAInt )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2429:1: (lv_value_0_0= ruleAInt )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2430:3: lv_value_0_0= ruleAInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAInt_in_ruleAIntegerTerm5617);
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2446:2: ( (otherlv_1= RULE_ID ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2447:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2447:1: (otherlv_1= RULE_ID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2448:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAIntegerTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAIntegerTerm5637); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2467:1: entryRuleAInt returns [String current=null] : iv_ruleAInt= ruleAInt EOF ;
    public final String entryRuleAInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAInt = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2468:2: (iv_ruleAInt= ruleAInt EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2469:2: iv_ruleAInt= ruleAInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntRule()); 
            }
            pushFollow(FOLLOW_ruleAInt_in_entryRuleAInt5675);
            iv_ruleAInt=ruleAInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAInt5686); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2476:1: ruleAInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleAInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2479:28: (this_INT_0= RULE_INT )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2480:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAInt5725); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2495:1: entryRuleARealTerm returns [EObject current=null] : iv_ruleARealTerm= ruleARealTerm EOF ;
    public final EObject entryRuleARealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARealTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2496:2: (iv_ruleARealTerm= ruleARealTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2497:2: iv_ruleARealTerm= ruleARealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealTermRule()); 
            }
            pushFollow(FOLLOW_ruleARealTerm_in_entryRuleARealTerm5769);
            iv_ruleARealTerm=ruleARealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARealTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARealTerm5779); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2504:1: ruleARealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleARealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2507:28: ( ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2508:1: ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2508:1: ( ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2508:2: ( (lv_value_0_0= ruleAReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2508:2: ( (lv_value_0_0= ruleAReal ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2509:1: (lv_value_0_0= ruleAReal )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2509:1: (lv_value_0_0= ruleAReal )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2510:3: lv_value_0_0= ruleAReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAReal_in_ruleARealTerm5825);
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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2526:2: ( (otherlv_1= RULE_ID ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2527:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2527:1: (otherlv_1= RULE_ID )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2528:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getARealTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleARealTerm5845); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2547:1: entryRuleAReal returns [String current=null] : iv_ruleAReal= ruleAReal EOF ;
    public final String entryRuleAReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAReal = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2548:2: (iv_ruleAReal= ruleAReal EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2549:2: iv_ruleAReal= ruleAReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealRule()); 
            }
            pushFollow(FOLLOW_ruleAReal_in_entryRuleAReal5883);
            iv_ruleAReal=ruleAReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAReal.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAReal5894); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2556:1: ruleAReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleAReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2559:28: (this_REAL_LIT_0= RULE_REAL_LIT )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2560:5: this_REAL_LIT_0= RULE_REAL_LIT
            {
            this_REAL_LIT_0=(Token)match(input,RULE_REAL_LIT,FOLLOW_RULE_REAL_LIT_in_ruleAReal5933); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2577:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2578:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2579:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumAltRule()); 
            }
            pushFollow(FOLLOW_ruleNumAlt_in_entryRuleNumAlt5979);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumAlt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumAlt5989); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2586:1: ruleNumAlt returns [EObject current=null] : (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_ARealTerm_0 = null;

        EObject this_AIntegerTerm_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2589:28: ( (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2590:1: (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2590:1: (this_ARealTerm_0= ruleARealTerm | this_AIntegerTerm_1= ruleAIntegerTerm )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_REAL_LIT) ) {
                alt48=1;
            }
            else if ( (LA48_0==RULE_INT) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2591:5: this_ARealTerm_0= ruleARealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getARealTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleARealTerm_in_ruleNumAlt6036);
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2601:5: this_AIntegerTerm_1= ruleAIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getAIntegerTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAIntegerTerm_in_ruleNumAlt6063);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2617:1: entryRuleASetTerm returns [EObject current=null] : iv_ruleASetTerm= ruleASetTerm EOF ;
    public final EObject entryRuleASetTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASetTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2618:2: (iv_ruleASetTerm= ruleASetTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2619:2: iv_ruleASetTerm= ruleASetTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASetTermRule()); 
            }
            pushFollow(FOLLOW_ruleASetTerm_in_entryRuleASetTerm6098);
            iv_ruleASetTerm=ruleASetTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASetTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASetTerm6108); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2626:1: ruleASetTerm returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleASetTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_elements_2_0 = null;

        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2629:28: ( ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2630:1: ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2630:1: ( () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2630:2: () otherlv_1= '{' ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )? otherlv_5= '}'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2630:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2631:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getASetTermAccess().getASetLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleASetTerm6154); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASetTermAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2640:1: ( ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )* )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=RULE_ID && LA50_0<=RULE_REAL_LIT)||LA50_0==33||(LA50_0>=51 && LA50_0<=52)||(LA50_0>=55 && LA50_0<=56)||(LA50_0>=59 && LA50_0<=60)||(LA50_0>=62 && LA50_0<=64)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2640:2: ( (lv_elements_2_0= ruleAExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )*
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2640:2: ( (lv_elements_2_0= ruleAExpression ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2641:1: (lv_elements_2_0= ruleAExpression )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2641:1: (lv_elements_2_0= ruleAExpression )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2642:3: lv_elements_2_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getASetTermAccess().getElementsAExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAExpression_in_ruleASetTerm6176);
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

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2658:2: (otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==57) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2658:4: otherlv_3= ',' ( (lv_elements_4_0= ruleAExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,57,FOLLOW_57_in_ruleASetTerm6189); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getASetTermAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2662:1: ( (lv_elements_4_0= ruleAExpression ) )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2663:1: (lv_elements_4_0= ruleAExpression )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2663:1: (lv_elements_4_0= ruleAExpression )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2664:3: lv_elements_4_0= ruleAExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getASetTermAccess().getElementsAExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleAExpression_in_ruleASetTerm6210);
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
                    	    break loop49;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,58,FOLLOW_58_in_ruleASetTerm6226); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2692:1: entryRuleAListTerm returns [EObject current=null] : iv_ruleAListTerm= ruleAListTerm EOF ;
    public final EObject entryRuleAListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAListTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2693:2: (iv_ruleAListTerm= ruleAListTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2694:2: iv_ruleAListTerm= ruleAListTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAListTermRule()); 
            }
            pushFollow(FOLLOW_ruleAListTerm_in_entryRuleAListTerm6262);
            iv_ruleAListTerm=ruleAListTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAListTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAListTerm6272); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2701:1: ruleAListTerm returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )? otherlv_6= ']' ) ;
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
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2704:28: ( ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )? otherlv_6= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2705:1: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )? otherlv_6= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2705:1: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )? otherlv_6= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2705:2: () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )? otherlv_6= ']'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2705:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2706:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAListTermAccess().getAListTermAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleAListTerm6318); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAListTermAccess().getNumberSignKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleAListTerm6330); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAListTermAccess().getLeftSquareBracketKeyword_2());
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2719:1: ( ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=RULE_ID && LA52_0<=RULE_REAL_LIT)||LA52_0==33||(LA52_0>=51 && LA52_0<=52)||(LA52_0>=55 && LA52_0<=56)||(LA52_0>=59 && LA52_0<=60)||(LA52_0>=62 && LA52_0<=64)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2719:2: ( (lv_elements_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )*
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2719:2: ( (lv_elements_3_0= ruleAExpression ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2720:1: (lv_elements_3_0= ruleAExpression )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2720:1: (lv_elements_3_0= ruleAExpression )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2721:3: lv_elements_3_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAListTermAccess().getElementsAExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAExpression_in_ruleAListTerm6352);
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

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2737:2: (otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==57) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2737:4: otherlv_4= ',' ( (lv_elements_5_0= ruleAExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,57,FOLLOW_57_in_ruleAListTerm6365); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getAListTermAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2741:1: ( (lv_elements_5_0= ruleAExpression ) )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2742:1: (lv_elements_5_0= ruleAExpression )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2742:1: (lv_elements_5_0= ruleAExpression )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2743:3: lv_elements_5_0= ruleAExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAListTermAccess().getElementsAExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleAExpression_in_ruleAListTerm6386);
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
                    	    break loop51;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleAListTerm6402); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2771:1: entryRuleAParenthesizedExpression returns [EObject current=null] : iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF ;
    public final EObject entryRuleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAParenthesizedExpression = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2772:2: (iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2773:2: iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAParenthesizedExpression_in_entryRuleAParenthesizedExpression6438);
            iv_ruleAParenthesizedExpression=ruleAParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAParenthesizedExpression6448); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2780:1: ruleAParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) ;
    public final EObject ruleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2783:28: ( (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2784:1: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2784:1: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2784:3: otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleAParenthesizedExpression6485); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleAParenthesizedExpression6507);
            this_AExpression_1=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,61,FOLLOW_61_in_ruleAParenthesizedExpression6518); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2809:1: entryRuleABooleanLiteral returns [EObject current=null] : iv_ruleABooleanLiteral= ruleABooleanLiteral EOF ;
    public final EObject entryRuleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleABooleanLiteral = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2810:2: (iv_ruleABooleanLiteral= ruleABooleanLiteral EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2811:2: iv_ruleABooleanLiteral= ruleABooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getABooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleABooleanLiteral_in_entryRuleABooleanLiteral6554);
            iv_ruleABooleanLiteral=ruleABooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleABooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleABooleanLiteral6564); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2818:1: ruleABooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2821:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2822:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2822:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2822:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2822:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2823:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2828:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==62) ) {
                alt53=1;
            }
            else if ( (LA53_0==63) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2828:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2828:3: ( (lv_value_1_0= 'true' ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2829:1: (lv_value_1_0= 'true' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2829:1: (lv_value_1_0= 'true' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2830:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,62,FOLLOW_62_in_ruleABooleanLiteral6617); if (state.failed) return current;
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
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2844:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,63,FOLLOW_63_in_ruleABooleanLiteral6648); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2856:1: entryRuleANullLiteral returns [EObject current=null] : iv_ruleANullLiteral= ruleANullLiteral EOF ;
    public final EObject entryRuleANullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleANullLiteral = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2857:2: (iv_ruleANullLiteral= ruleANullLiteral EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2858:2: iv_ruleANullLiteral= ruleANullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getANullLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleANullLiteral_in_entryRuleANullLiteral6685);
            iv_ruleANullLiteral=ruleANullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleANullLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleANullLiteral6695); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2865:1: ruleANullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleANullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2868:28: ( ( () otherlv_1= 'null' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2869:1: ( () otherlv_1= 'null' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2869:1: ( () otherlv_1= 'null' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2869:2: () otherlv_1= 'null'
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2869:2: ()
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2870:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getANullLiteralAccess().getANullLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,64,FOLLOW_64_in_ruleANullLiteral6741); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2887:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2888:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2889:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm6777);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm6787); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2896:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2899:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2900:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2900:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2901:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2901:1: (lv_value_0_0= ruleNoQuoteString )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2902:3: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_ruleStringTerm6832);
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2926:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2927:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2928:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString6868);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNoQuoteString6879); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2935:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2938:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2939:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNoQuoteString6918); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2958:1: entryRuleAADLPROPERTYREFERENCE returns [String current=null] : iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF ;
    public final String entryRuleAADLPROPERTYREFERENCE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAADLPROPERTYREFERENCE = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2959:2: (iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2960:2: iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAADLPROPERTYREFERENCERule()); 
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_entryRuleAADLPROPERTYREFERENCE6967);
            iv_ruleAADLPROPERTYREFERENCE=ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAADLPROPERTYREFERENCE.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAADLPROPERTYREFERENCE6978); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2967:1: ruleAADLPROPERTYREFERENCE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAADLPROPERTYREFERENCE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2970:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2971:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2971:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2971:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7018); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2978:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==65) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2979:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleAADLPROPERTYREFERENCE7037); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0()); 
                          
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7052); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2999:1: entryRuleURIID returns [String current=null] : iv_ruleURIID= ruleURIID EOF ;
    public final String entryRuleURIID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURIID = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3000:2: (iv_ruleURIID= ruleURIID EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3001:2: iv_ruleURIID= ruleURIID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIIDRule()); 
            }
            pushFollow(FOLLOW_ruleURIID_in_entryRuleURIID7100);
            iv_ruleURIID=ruleURIID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIID7111); if (state.failed) return current;

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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3008:1: ruleURIID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleURIID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3011:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3012:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIID7150); if (state.failed) return current;
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
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3029:1: ruleResultIssueType returns [Enumerator current=null] : ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'unknown' ) | (enumLiteral_2= 'error' ) | (enumLiteral_3= 'warning' ) | (enumLiteral_4= 'info' ) | (enumLiteral_5= 'success' ) | (enumLiteral_6= 'fail' ) ) ;
    public final Enumerator ruleResultIssueType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;

         enterRule(); 
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3031:28: ( ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'unknown' ) | (enumLiteral_2= 'error' ) | (enumLiteral_3= 'warning' ) | (enumLiteral_4= 'info' ) | (enumLiteral_5= 'success' ) | (enumLiteral_6= 'fail' ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3032:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'unknown' ) | (enumLiteral_2= 'error' ) | (enumLiteral_3= 'warning' ) | (enumLiteral_4= 'info' ) | (enumLiteral_5= 'success' ) | (enumLiteral_6= 'fail' ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3032:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'unknown' ) | (enumLiteral_2= 'error' ) | (enumLiteral_3= 'warning' ) | (enumLiteral_4= 'info' ) | (enumLiteral_5= 'success' ) | (enumLiteral_6= 'fail' ) )
            int alt55=7;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt55=1;
                }
                break;
            case 67:
                {
                alt55=2;
                }
                break;
            case 68:
                {
                alt55=3;
                }
                break;
            case 69:
                {
                alt55=4;
                }
                break;
            case 70:
                {
                alt55=5;
                }
                break;
            case 71:
                {
                alt55=6;
                }
                break;
            case 72:
                {
                alt55=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3032:2: (enumLiteral_0= 'tbd' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3032:2: (enumLiteral_0= 'tbd' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3032:4: enumLiteral_0= 'tbd'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_66_in_ruleResultIssueType7210); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3038:6: (enumLiteral_1= 'unknown' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3038:6: (enumLiteral_1= 'unknown' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3038:8: enumLiteral_1= 'unknown'
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_67_in_ruleResultIssueType7227); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3044:6: (enumLiteral_2= 'error' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3044:6: (enumLiteral_2= 'error' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3044:8: enumLiteral_2= 'error'
                    {
                    enumLiteral_2=(Token)match(input,68,FOLLOW_68_in_ruleResultIssueType7244); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3050:6: (enumLiteral_3= 'warning' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3050:6: (enumLiteral_3= 'warning' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3050:8: enumLiteral_3= 'warning'
                    {
                    enumLiteral_3=(Token)match(input,69,FOLLOW_69_in_ruleResultIssueType7261); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3056:6: (enumLiteral_4= 'info' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3056:6: (enumLiteral_4= 'info' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3056:8: enumLiteral_4= 'info'
                    {
                    enumLiteral_4=(Token)match(input,70,FOLLOW_70_in_ruleResultIssueType7278); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3062:6: (enumLiteral_5= 'success' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3062:6: (enumLiteral_5= 'success' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3062:8: enumLiteral_5= 'success'
                    {
                    enumLiteral_5=(Token)match(input,71,FOLLOW_71_in_ruleResultIssueType7295); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3068:6: (enumLiteral_6= 'fail' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3068:6: (enumLiteral_6= 'fail' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:3068:8: enumLiteral_6= 'fail'
                    {
                    enumLiteral_6=(Token)match(input,72,FOLLOW_72_in_ruleResultIssueType7312); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_6()); 
                          
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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1268:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1268:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1268:4: ( () ( ( ruleOpOr ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1268:5: () ( ( ruleOpOr ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1268:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1269:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1269:2: ( ( ruleOpOr ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1270:1: ( ruleOpOr )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1270:1: ( ruleOpOr )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1271:1: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred1_InternalResults2647);
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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1372:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1372:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1372:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1372:5: () ( ( ruleOpAnd ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1372:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1373:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1373:2: ( ( ruleOpAnd ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1374:1: ( ruleOpAnd )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1374:1: ( ruleOpAnd )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1375:1: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred2_InternalResults2902);
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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1476:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1476:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1476:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1476:5: () ( ( ruleOpEquality ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1476:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1477:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1477:2: ( ( ruleOpEquality ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1478:1: ( ruleOpEquality )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1478:1: ( ruleOpEquality )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1479:1: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred3_InternalResults3157);
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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1587:3: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1587:4: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1587:4: ( () ( ( ruleOpCompare ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1587:5: () ( ( ruleOpCompare ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1587:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1588:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1588:2: ( ( ruleOpCompare ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1589:1: ( ruleOpCompare )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1589:1: ( ruleOpCompare )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1590:1: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred4_InternalResults3433);
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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1718:3: ( ( () ( ( ruleOpOther ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1718:4: ( () ( ( ruleOpOther ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1718:4: ( () ( ( ruleOpOther ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1718:5: () ( ( ruleOpOther ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1718:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1719:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1719:2: ( ( ruleOpOther ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1720:1: ( ruleOpOther )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1720:1: ( ruleOpOther )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1721:1: ruleOpOther
        {
        pushFollow(FOLLOW_ruleOpOther_in_synpred5_InternalResults3762);
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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1833:3: ( ( '>' '>' ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1833:4: ( '>' '>' )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1833:4: ( '>' '>' )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1834:2: '>' '>'
        {
        match(input,44,FOLLOW_44_in_synpred6_InternalResults4029); if (state.failed) return ;
        match(input,44,FOLLOW_44_in_synpred6_InternalResults4034); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalResults

    // $ANTLR start synpred7_InternalResults
    public final void synpred7_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1863:3: ( ( '<' '<' ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1863:4: ( '<' '<' )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1863:4: ( '<' '<' )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1864:2: '<' '<'
        {
        match(input,43,FOLLOW_43_in_synpred7_InternalResults4116); if (state.failed) return ;
        match(input,43,FOLLOW_43_in_synpred7_InternalResults4121); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalResults

    // $ANTLR start synpred8_InternalResults
    public final void synpred8_InternalResults_fragment() throws RecognitionException {   
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1937:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1937:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1937:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1937:5: () ( ( ruleOpAdd ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1937:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1938:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1938:2: ( ( ruleOpAdd ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1939:1: ( ruleOpAdd )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1939:1: ( ruleOpAdd )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:1940:1: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred8_InternalResults4341);
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
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2048:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2048:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2048:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2048:5: () ( ( ruleOpMulti ) )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2048:5: ()
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2049:1: 
        {
        }

        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2049:2: ( ( ruleOpMulti ) )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2050:1: ( ruleOpMulti )
        {
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2050:1: ( ruleOpMulti )
        // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:2051:1: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred9_InternalResults4617);
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


    protected DFA34 dfa34 = new DFA34(this);
    protected DFA37 dfa37 = new DFA37(this);
    static final String DFA34_eotS =
        "\16\uffff";
    static final String DFA34_eofS =
        "\1\1\15\uffff";
    static final String DFA34_minS =
        "\1\26\1\uffff\2\4\12\uffff";
    static final String DFA34_maxS =
        "\1\75\1\uffff\2\100\12\uffff";
    static final String DFA34_acceptS =
        "\1\uffff\1\2\2\uffff\12\1";
    static final String DFA34_specialS =
        "\1\0\1\uffff\1\2\1\1\12\uffff}>";
    static final String[] DFA34_transitionS = {
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

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "()* loopback of 1718:1: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( (lv_feature_2_0= ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleAAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_0 = input.LA(1);

                         
                        int index34_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA34_0==EOF||LA34_0==22||(LA34_0>=38 && LA34_0<=42)||(LA34_0>=57 && LA34_0<=58)||LA34_0==61) ) {s = 1;}

                        else if ( (LA34_0==43) ) {s = 2;}

                        else if ( (LA34_0==44) ) {s = 3;}

                        else if ( (LA34_0==45) && (synpred5_InternalResults())) {s = 4;}

                        else if ( (LA34_0==46) && (synpred5_InternalResults())) {s = 5;}

                        else if ( (LA34_0==47) && (synpred5_InternalResults())) {s = 6;}

                        else if ( (LA34_0==48) && (synpred5_InternalResults())) {s = 7;}

                        else if ( (LA34_0==49) && (synpred5_InternalResults())) {s = 8;}

                        else if ( (LA34_0==50) && (synpred5_InternalResults())) {s = 9;}

                         
                        input.seek(index34_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA34_3 = input.LA(1);

                         
                        int index34_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA34_3>=RULE_ID && LA34_3<=RULE_REAL_LIT)||LA34_3==33||(LA34_3>=51 && LA34_3<=52)||(LA34_3>=55 && LA34_3<=56)||(LA34_3>=59 && LA34_3<=60)||(LA34_3>=62 && LA34_3<=64)) ) {s = 1;}

                        else if ( (LA34_3==47) && (synpred5_InternalResults())) {s = 12;}

                        else if ( (LA34_3==44) && (synpred5_InternalResults())) {s = 13;}

                         
                        input.seek(index34_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA34_2 = input.LA(1);

                         
                        int index34_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA34_2>=RULE_ID && LA34_2<=RULE_REAL_LIT)||LA34_2==27||LA34_2==33||(LA34_2>=51 && LA34_2<=52)||(LA34_2>=55 && LA34_2<=56)||(LA34_2>=59 && LA34_2<=60)||(LA34_2>=62 && LA34_2<=64)) ) {s = 1;}

                        else if ( (LA34_2==43) && (synpred5_InternalResults())) {s = 10;}

                        else if ( (LA34_2==48) && (synpred5_InternalResults())) {s = 11;}

                         
                        input.seek(index34_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA37_eotS =
        "\13\uffff";
    static final String DFA37_eofS =
        "\13\uffff";
    static final String DFA37_minS =
        "\1\53\2\uffff\1\54\7\uffff";
    static final String DFA37_maxS =
        "\1\62\2\uffff\1\57\7\uffff";
    static final String DFA37_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\3\1\6";
    static final String DFA37_specialS =
        "\13\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\6\1\3\1\1\1\2\1\4\1\5\1\7\1\10",
            "",
            "",
            "\1\12\2\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "1786:1: (kw= '->' | kw= '..<' | (kw= '>' kw= '..' ) | kw= '..' | kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) | kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) | kw= '<' | kw= '=>' ) ) | kw= '<>' | kw= '?:' )";
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
    public static final BitSet FOLLOW_20_in_ruleResultReportCollection374 = new BitSet(new long[]{0x0000000050E20000L});
    public static final BitSet FOLLOW_21_in_ruleResultReportCollection387 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportCollection404 = new BitSet(new long[]{0x0000000050C20000L});
    public static final BitSet FOLLOW_ruleResultReport_in_ruleResultReportCollection432 = new BitSet(new long[]{0x0000000050C20000L});
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
    public static final BitSet FOLLOW_20_in_ruleResultDataReport656 = new BitSet(new long[]{0x0000000043600000L});
    public static final BitSet FOLLOW_21_in_ruleResultDataReport669 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultDataReport686 = new BitSet(new long[]{0x0000000043400000L});
    public static final BitSet FOLLOW_24_in_ruleResultDataReport706 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultDataReport723 = new BitSet(new long[]{0x0000000046400000L});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultDataReport749 = new BitSet(new long[]{0x0000000046400000L});
    public static final BitSet FOLLOW_25_in_ruleResultDataReport765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultDataReport786 = new BitSet(new long[]{0x0000000040400010L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultDataReport810 = new BitSet(new long[]{0x0000000040400000L});
    public static final BitSet FOLLOW_22_in_ruleResultDataReport823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_entryRuleResultContributor859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultContributor869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleResultContributor906 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultContributor929 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleResultContributor941 = new BitSet(new long[]{0x0000000046400000L});
    public static final BitSet FOLLOW_25_in_ruleResultContributor954 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultContributor975 = new BitSet(new long[]{0x0000000044400010L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultContributor999 = new BitSet(new long[]{0x0000000044400000L});
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
    public static final BitSet FOLLOW_20_in_ruleIssuesReport1317 = new BitSet(new long[]{0x0000000040600000L});
    public static final BitSet FOLLOW_21_in_ruleIssuesReport1330 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIssuesReport1347 = new BitSet(new long[]{0x0000000040400000L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleIssuesReport1375 = new BitSet(new long[]{0x0000000040400000L});
    public static final BitSet FOLLOW_22_in_ruleIssuesReport1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_ruleDescriptionElement1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDescriptionElement1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImageReference_in_ruleDescriptionElement1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_entryRuleResultIssue1616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultIssue1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleResultIssue1663 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001FCL});
    public static final BitSet FOLLOW_ruleResultIssueType_in_ruleResultIssue1684 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1701 = new BitSet(new long[]{0x0000000180100002L});
    public static final BitSet FOLLOW_31_in_ruleResultIssue1719 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultIssue1742 = new BitSet(new long[]{0x0000000100100002L});
    public static final BitSet FOLLOW_32_in_ruleResultIssue1757 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue1774 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleResultIssue1794 = new BitSet(new long[]{0x0000000040400000L});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultIssue1815 = new BitSet(new long[]{0x0000000040400000L});
    public static final BitSet FOLLOW_22_in_ruleResultIssue1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPropertyReference_in_entryRuleAPropertyReference1870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPropertyReference1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleAPropertyReference1926 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAPropertyReference1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableReference_in_entryRuleAVariableReference1985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAVariableReference1995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAVariableReference2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_entryRuleShowValue2085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShowValue2095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue2140 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleShowValue2153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImageReference_in_entryRuleImageReference2211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImageReference2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleImageReference2258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIMGREF_in_ruleImageReference2279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMGREF_in_entryRuleIMGREF2316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMGREF2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF2368 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleIMGREF2386 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF2403 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleIMGREF2421 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExpression_in_entryRuleAExpression2481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExpression2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_ruleAExpression2537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression2571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAOrExpression2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression2628 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleAOrExpression2677 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression2700 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr2739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpOr2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression2826 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAndExpression2836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2883 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleAAndExpression2932 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2955 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd2994 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd3005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpAnd3042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_entryRuleAEqualityExpression3081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAEqualityExpression3091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3138 = new BitSet(new long[]{0x0000030000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleAEqualityExpression3187 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression3210 = new BitSet(new long[]{0x0000030000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality3249 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality3260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpEquality3298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOpEquality3317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression3357 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARelationalExpression3367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOtherOperatorExpression_in_ruleARelationalExpression3414 = new BitSet(new long[]{0x00001C0000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleARelationalExpression3463 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAOtherOperatorExpression_in_ruleARelationalExpression3486 = new BitSet(new long[]{0x00001C0000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare3525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare3536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOpCompare3574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpCompare3594 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleOpCompare3607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOpCompare3627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpCompare3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOtherOperatorExpression_in_entryRuleAOtherOperatorExpression3686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAOtherOperatorExpression3696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleAOtherOperatorExpression3743 = new BitSet(new long[]{0x0007F80000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_ruleAOtherOperatorExpression3792 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleAOtherOperatorExpression3815 = new BitSet(new long[]{0x0007F80000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_entryRuleOpOther3854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOther3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleOpOther3903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleOpOther3922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOpOther3942 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleOpOther3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleOpOther3975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOpOther3994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOpOther4014 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleOpOther4045 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleOpOther4058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOpOther4079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpOther4101 = new BitSet(new long[]{0x0001080000000000L});
    public static final BitSet FOLLOW_43_in_ruleOpOther4132 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleOpOther4145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpOther4166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOpOther4185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOpOther4206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOpOther4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression4265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAdditiveExpression4275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4322 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleAAdditiveExpression4371 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression4394 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd4433 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd4444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOpAdd4482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleOpAdd4501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression4541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiplicativeExpression4551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4598 = new BitSet(new long[]{0x0060001400000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleAMultiplicativeExpression4647 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression4670 = new BitSet(new long[]{0x0060001400000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti4709 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti4720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleOpMulti4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleOpMulti4777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpMulti4796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOpMulti4815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_entryRuleAUnaryOperation4855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUnaryOperation4865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleAUnaryOperation4921 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAUnaryOperation4942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPrimaryExpression_in_ruleAUnaryOperation4971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary5007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary5018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleOpUnary5056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleOpUnary5075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOpUnary5094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPrimaryExpression_in_entryRuleAPrimaryExpression5134 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPrimaryExpression5144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALiteral_in_ruleAPrimaryExpression5191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableReference_in_ruleAPrimaryExpression5218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPropertyReference_in_ruleAPrimaryExpression5245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParenthesizedExpression_in_ruleAPrimaryExpression5272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALiteral_in_entryRuleALiteral5307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleALiteral5317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASetTerm_in_ruleALiteral5364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAListTerm_in_ruleALiteral5391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanLiteral_in_ruleALiteral5418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_ruleALiteral5445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_ruleALiteral5472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANullLiteral_in_ruleALiteral5499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_ruleALiteral5526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_entryRuleAIntegerTerm5561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIntegerTerm5571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInt_in_ruleAIntegerTerm5617 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAIntegerTerm5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInt_in_entryRuleAInt5675 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAInt5686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAInt5725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_entryRuleARealTerm5769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARealTerm5779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReal_in_ruleARealTerm5825 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleARealTerm5845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReal_in_entryRuleAReal5883 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAReal5894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_LIT_in_ruleAReal5933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumAlt_in_entryRuleNumAlt5979 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumAlt5989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_ruleNumAlt6036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_ruleNumAlt6063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASetTerm_in_entryRuleASetTerm6098 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASetTerm6108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleASetTerm6154 = new BitSet(new long[]{0xDD980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleASetTerm6176 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_57_in_ruleASetTerm6189 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleASetTerm6210 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_58_in_ruleASetTerm6226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAListTerm_in_entryRuleAListTerm6262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAListTerm6272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleAListTerm6318 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAListTerm6330 = new BitSet(new long[]{0xD9980002004000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAListTerm6352 = new BitSet(new long[]{0x0200000000400000L});
    public static final BitSet FOLLOW_57_in_ruleAListTerm6365 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAListTerm6386 = new BitSet(new long[]{0x0200000000400000L});
    public static final BitSet FOLLOW_22_in_ruleAListTerm6402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParenthesizedExpression_in_entryRuleAParenthesizedExpression6438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAParenthesizedExpression6448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleAParenthesizedExpression6485 = new BitSet(new long[]{0xD9980002000000F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAParenthesizedExpression6507 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleAParenthesizedExpression6518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanLiteral_in_entryRuleABooleanLiteral6554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleABooleanLiteral6564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleABooleanLiteral6617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleABooleanLiteral6648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANullLiteral_in_entryRuleANullLiteral6685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleANullLiteral6695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleANullLiteral6741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm6777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm6787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleStringTerm6832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString6868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNoQuoteString6879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNoQuoteString6918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_entryRuleAADLPROPERTYREFERENCE6967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAADLPROPERTYREFERENCE6978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7018 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleAADLPROPERTYREFERENCE7037 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE7052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_entryRuleURIID7100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIID7111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIID7150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleResultIssueType7210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleResultIssueType7227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleResultIssueType7244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleResultIssueType7261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleResultIssueType7278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleResultIssueType7295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleResultIssueType7312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred1_InternalResults2647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred2_InternalResults2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred3_InternalResults3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred4_InternalResults3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOther_in_synpred5_InternalResults3762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred6_InternalResults4029 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred6_InternalResults4034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred7_InternalResults4116 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_synpred7_InternalResults4121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred8_InternalResults4341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred9_InternalResults4617 = new BitSet(new long[]{0x0000000000000002L});

}

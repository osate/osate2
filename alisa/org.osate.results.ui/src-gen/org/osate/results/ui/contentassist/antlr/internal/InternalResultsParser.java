package org.osate.results.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
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
public class InternalResultsParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'error'", "'warning'", "'info'", "'success'", "'fail'", "'unknown'", "'reports'", "'['", "'target'", "']'", "':'", "'description'", "'report'", "'exception'", "'heading'", "'results'", "'contributor'", "'data'", "'issues'", "'issue'", "'='"
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


        public InternalResultsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalResultsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalResultsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g"; }


     
     	private ResultsGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ResultsGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleResultReports"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:72:1: entryRuleResultReports : ruleResultReports EOF ;
    public final void entryRuleResultReports() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:73:1: ( ruleResultReports EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:74:1: ruleResultReports EOF
            {
             before(grammarAccess.getResultReportsRule()); 
            pushFollow(FOLLOW_ruleResultReports_in_entryRuleResultReports61);
            ruleResultReports();

            state._fsp--;

             after(grammarAccess.getResultReportsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReports68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleResultReports"


    // $ANTLR start "ruleResultReports"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:81:1: ruleResultReports : ( ( rule__ResultReports__Alternatives ) ) ;
    public final void ruleResultReports() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:85:2: ( ( ( rule__ResultReports__Alternatives ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:86:1: ( ( rule__ResultReports__Alternatives ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:86:1: ( ( rule__ResultReports__Alternatives ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:87:1: ( rule__ResultReports__Alternatives )
            {
             before(grammarAccess.getResultReportsAccess().getAlternatives()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:88:1: ( rule__ResultReports__Alternatives )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:88:2: rule__ResultReports__Alternatives
            {
            pushFollow(FOLLOW_rule__ResultReports__Alternatives_in_ruleResultReports94);
            rule__ResultReports__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getResultReportsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResultReports"


    // $ANTLR start "entryRuleResultReportCollection"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:100:1: entryRuleResultReportCollection : ruleResultReportCollection EOF ;
    public final void entryRuleResultReportCollection() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:101:1: ( ruleResultReportCollection EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:102:1: ruleResultReportCollection EOF
            {
             before(grammarAccess.getResultReportCollectionRule()); 
            pushFollow(FOLLOW_ruleResultReportCollection_in_entryRuleResultReportCollection121);
            ruleResultReportCollection();

            state._fsp--;

             after(grammarAccess.getResultReportCollectionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReportCollection128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleResultReportCollection"


    // $ANTLR start "ruleResultReportCollection"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:109:1: ruleResultReportCollection : ( ( rule__ResultReportCollection__Group__0 ) ) ;
    public final void ruleResultReportCollection() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:113:2: ( ( ( rule__ResultReportCollection__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:114:1: ( ( rule__ResultReportCollection__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:114:1: ( ( rule__ResultReportCollection__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:115:1: ( rule__ResultReportCollection__Group__0 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:116:1: ( rule__ResultReportCollection__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:116:2: rule__ResultReportCollection__Group__0
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__0_in_ruleResultReportCollection154);
            rule__ResultReportCollection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResultReportCollectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResultReportCollection"


    // $ANTLR start "entryRuleResultReport"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:128:1: entryRuleResultReport : ruleResultReport EOF ;
    public final void entryRuleResultReport() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:129:1: ( ruleResultReport EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:130:1: ruleResultReport EOF
            {
             before(grammarAccess.getResultReportRule()); 
            pushFollow(FOLLOW_ruleResultReport_in_entryRuleResultReport181);
            ruleResultReport();

            state._fsp--;

             after(grammarAccess.getResultReportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReport188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleResultReport"


    // $ANTLR start "ruleResultReport"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:137:1: ruleResultReport : ( ( rule__ResultReport__Group__0 ) ) ;
    public final void ruleResultReport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:141:2: ( ( ( rule__ResultReport__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:142:1: ( ( rule__ResultReport__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:142:1: ( ( rule__ResultReport__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:143:1: ( rule__ResultReport__Group__0 )
            {
             before(grammarAccess.getResultReportAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:144:1: ( rule__ResultReport__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:144:2: rule__ResultReport__Group__0
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__0_in_ruleResultReport214);
            rule__ResultReport__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResultReport"


    // $ANTLR start "entryRuleResultContributor"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:156:1: entryRuleResultContributor : ruleResultContributor EOF ;
    public final void entryRuleResultContributor() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:157:1: ( ruleResultContributor EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:158:1: ruleResultContributor EOF
            {
             before(grammarAccess.getResultContributorRule()); 
            pushFollow(FOLLOW_ruleResultContributor_in_entryRuleResultContributor241);
            ruleResultContributor();

            state._fsp--;

             after(grammarAccess.getResultContributorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultContributor248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleResultContributor"


    // $ANTLR start "ruleResultContributor"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:165:1: ruleResultContributor : ( ( rule__ResultContributor__Group__0 ) ) ;
    public final void ruleResultContributor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:169:2: ( ( ( rule__ResultContributor__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:170:1: ( ( rule__ResultContributor__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:170:1: ( ( rule__ResultContributor__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:171:1: ( rule__ResultContributor__Group__0 )
            {
             before(grammarAccess.getResultContributorAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:172:1: ( rule__ResultContributor__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:172:2: rule__ResultContributor__Group__0
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__0_in_ruleResultContributor274);
            rule__ResultContributor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResultContributorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResultContributor"


    // $ANTLR start "entryRuleIssueReport"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:184:1: entryRuleIssueReport : ruleIssueReport EOF ;
    public final void entryRuleIssueReport() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:185:1: ( ruleIssueReport EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:186:1: ruleIssueReport EOF
            {
             before(grammarAccess.getIssueReportRule()); 
            pushFollow(FOLLOW_ruleIssueReport_in_entryRuleIssueReport301);
            ruleIssueReport();

            state._fsp--;

             after(grammarAccess.getIssueReportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIssueReport308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIssueReport"


    // $ANTLR start "ruleIssueReport"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:193:1: ruleIssueReport : ( ( rule__IssueReport__Group__0 ) ) ;
    public final void ruleIssueReport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:197:2: ( ( ( rule__IssueReport__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:198:1: ( ( rule__IssueReport__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:198:1: ( ( rule__IssueReport__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:199:1: ( rule__IssueReport__Group__0 )
            {
             before(grammarAccess.getIssueReportAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:200:1: ( rule__IssueReport__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:200:2: rule__IssueReport__Group__0
            {
            pushFollow(FOLLOW_rule__IssueReport__Group__0_in_ruleIssueReport334);
            rule__IssueReport__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIssueReportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIssueReport"


    // $ANTLR start "entryRuleResultIssue"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:212:1: entryRuleResultIssue : ruleResultIssue EOF ;
    public final void entryRuleResultIssue() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:213:1: ( ruleResultIssue EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:214:1: ruleResultIssue EOF
            {
             before(grammarAccess.getResultIssueRule()); 
            pushFollow(FOLLOW_ruleResultIssue_in_entryRuleResultIssue361);
            ruleResultIssue();

            state._fsp--;

             after(grammarAccess.getResultIssueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultIssue368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleResultIssue"


    // $ANTLR start "ruleResultIssue"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:221:1: ruleResultIssue : ( ( rule__ResultIssue__Group__0 ) ) ;
    public final void ruleResultIssue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:225:2: ( ( ( rule__ResultIssue__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:226:1: ( ( rule__ResultIssue__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:226:1: ( ( rule__ResultIssue__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:227:1: ( rule__ResultIssue__Group__0 )
            {
             before(grammarAccess.getResultIssueAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:228:1: ( rule__ResultIssue__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:228:2: rule__ResultIssue__Group__0
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__0_in_ruleResultIssue394);
            rule__ResultIssue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResultIssueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResultIssue"


    // $ANTLR start "entryRuleResultData"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:240:1: entryRuleResultData : ruleResultData EOF ;
    public final void entryRuleResultData() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:241:1: ( ruleResultData EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:242:1: ruleResultData EOF
            {
             before(grammarAccess.getResultDataRule()); 
            pushFollow(FOLLOW_ruleResultData_in_entryRuleResultData421);
            ruleResultData();

            state._fsp--;

             after(grammarAccess.getResultDataRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultData428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleResultData"


    // $ANTLR start "ruleResultData"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:249:1: ruleResultData : ( ( rule__ResultData__Group__0 ) ) ;
    public final void ruleResultData() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:253:2: ( ( ( rule__ResultData__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:254:1: ( ( rule__ResultData__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:254:1: ( ( rule__ResultData__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:255:1: ( rule__ResultData__Group__0 )
            {
             before(grammarAccess.getResultDataAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:256:1: ( rule__ResultData__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:256:2: rule__ResultData__Group__0
            {
            pushFollow(FOLLOW_rule__ResultData__Group__0_in_ruleResultData454);
            rule__ResultData__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResultDataAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResultData"


    // $ANTLR start "entryRuleURIID"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:268:1: entryRuleURIID : ruleURIID EOF ;
    public final void entryRuleURIID() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:269:1: ( ruleURIID EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:270:1: ruleURIID EOF
            {
             before(grammarAccess.getURIIDRule()); 
            pushFollow(FOLLOW_ruleURIID_in_entryRuleURIID481);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getURIIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIID488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleURIID"


    // $ANTLR start "ruleURIID"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:277:1: ruleURIID : ( RULE_STRING ) ;
    public final void ruleURIID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:281:2: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:282:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:282:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:283:1: RULE_STRING
            {
             before(grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIID514); 
             after(grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleURIID"


    // $ANTLR start "ruleResultIssueType"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:297:1: ruleResultIssueType : ( ( rule__ResultIssueType__Alternatives ) ) ;
    public final void ruleResultIssueType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:301:1: ( ( ( rule__ResultIssueType__Alternatives ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:302:1: ( ( rule__ResultIssueType__Alternatives ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:302:1: ( ( rule__ResultIssueType__Alternatives ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:303:1: ( rule__ResultIssueType__Alternatives )
            {
             before(grammarAccess.getResultIssueTypeAccess().getAlternatives()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:304:1: ( rule__ResultIssueType__Alternatives )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:304:2: rule__ResultIssueType__Alternatives
            {
            pushFollow(FOLLOW_rule__ResultIssueType__Alternatives_in_ruleResultIssueType550);
            rule__ResultIssueType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getResultIssueTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResultIssueType"


    // $ANTLR start "rule__ResultReports__Alternatives"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:315:1: rule__ResultReports__Alternatives : ( ( ruleResultReport ) | ( ruleResultReportCollection ) | ( ruleIssueReport ) );
    public final void rule__ResultReports__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:319:1: ( ( ruleResultReport ) | ( ruleResultReportCollection ) | ( ruleIssueReport ) )
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
            case 29:
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
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:320:1: ( ruleResultReport )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:320:1: ( ruleResultReport )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:321:1: ruleResultReport
                    {
                     before(grammarAccess.getResultReportsAccess().getResultReportParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleResultReport_in_rule__ResultReports__Alternatives585);
                    ruleResultReport();

                    state._fsp--;

                     after(grammarAccess.getResultReportsAccess().getResultReportParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:326:6: ( ruleResultReportCollection )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:326:6: ( ruleResultReportCollection )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:327:1: ruleResultReportCollection
                    {
                     before(grammarAccess.getResultReportsAccess().getResultReportCollectionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleResultReportCollection_in_rule__ResultReports__Alternatives602);
                    ruleResultReportCollection();

                    state._fsp--;

                     after(grammarAccess.getResultReportsAccess().getResultReportCollectionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:332:6: ( ruleIssueReport )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:332:6: ( ruleIssueReport )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:333:1: ruleIssueReport
                    {
                     before(grammarAccess.getResultReportsAccess().getIssueReportParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleIssueReport_in_rule__ResultReports__Alternatives619);
                    ruleIssueReport();

                    state._fsp--;

                     after(grammarAccess.getResultReportsAccess().getIssueReportParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReports__Alternatives"


    // $ANTLR start "rule__ResultIssueType__Alternatives"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:343:1: rule__ResultIssueType__Alternatives : ( ( ( 'error' ) ) | ( ( 'warning' ) ) | ( ( 'info' ) ) | ( ( 'success' ) ) | ( ( 'fail' ) ) | ( ( 'unknown' ) ) );
    public final void rule__ResultIssueType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:347:1: ( ( ( 'error' ) ) | ( ( 'warning' ) ) | ( ( 'info' ) ) | ( ( 'success' ) ) | ( ( 'fail' ) ) | ( ( 'unknown' ) ) )
            int alt2=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            case 15:
                {
                alt2=5;
                }
                break;
            case 16:
                {
                alt2=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:348:1: ( ( 'error' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:348:1: ( ( 'error' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:349:1: ( 'error' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:350:1: ( 'error' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:350:3: 'error'
                    {
                    match(input,11,FOLLOW_11_in_rule__ResultIssueType__Alternatives652); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:355:6: ( ( 'warning' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:355:6: ( ( 'warning' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:356:1: ( 'warning' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:357:1: ( 'warning' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:357:3: 'warning'
                    {
                    match(input,12,FOLLOW_12_in_rule__ResultIssueType__Alternatives673); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:362:6: ( ( 'info' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:362:6: ( ( 'info' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:363:1: ( 'info' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_2()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:364:1: ( 'info' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:364:3: 'info'
                    {
                    match(input,13,FOLLOW_13_in_rule__ResultIssueType__Alternatives694); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:369:6: ( ( 'success' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:369:6: ( ( 'success' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:370:1: ( 'success' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:371:1: ( 'success' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:371:3: 'success'
                    {
                    match(input,14,FOLLOW_14_in_rule__ResultIssueType__Alternatives715); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:376:6: ( ( 'fail' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:376:6: ( ( 'fail' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:377:1: ( 'fail' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_4()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:378:1: ( 'fail' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:378:3: 'fail'
                    {
                    match(input,15,FOLLOW_15_in_rule__ResultIssueType__Alternatives736); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:383:6: ( ( 'unknown' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:383:6: ( ( 'unknown' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:384:1: ( 'unknown' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:385:1: ( 'unknown' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:385:3: 'unknown'
                    {
                    match(input,16,FOLLOW_16_in_rule__ResultIssueType__Alternatives757); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssueType__Alternatives"


    // $ANTLR start "rule__ResultReportCollection__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:397:1: rule__ResultReportCollection__Group__0 : rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1 ;
    public final void rule__ResultReportCollection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:401:1: ( rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:402:2: rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__0__Impl_in_rule__ResultReportCollection__Group__0790);
            rule__ResultReportCollection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__1_in_rule__ResultReportCollection__Group__0793);
            rule__ResultReportCollection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__0"


    // $ANTLR start "rule__ResultReportCollection__Group__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:409:1: rule__ResultReportCollection__Group__0__Impl : ( 'reports' ) ;
    public final void rule__ResultReportCollection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:413:1: ( ( 'reports' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:414:1: ( 'reports' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:414:1: ( 'reports' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:415:1: 'reports'
            {
             before(grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__ResultReportCollection__Group__0__Impl821); 
             after(grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__0__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:428:1: rule__ResultReportCollection__Group__1 : rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2 ;
    public final void rule__ResultReportCollection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:432:1: ( rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:433:2: rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__1__Impl_in_rule__ResultReportCollection__Group__1852);
            rule__ResultReportCollection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__2_in_rule__ResultReportCollection__Group__1855);
            rule__ResultReportCollection__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__1"


    // $ANTLR start "rule__ResultReportCollection__Group__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:440:1: rule__ResultReportCollection__Group__1__Impl : ( ( rule__ResultReportCollection__NameAssignment_1 ) ) ;
    public final void rule__ResultReportCollection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:444:1: ( ( ( rule__ResultReportCollection__NameAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:445:1: ( ( rule__ResultReportCollection__NameAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:445:1: ( ( rule__ResultReportCollection__NameAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:446:1: ( rule__ResultReportCollection__NameAssignment_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:447:1: ( rule__ResultReportCollection__NameAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:447:2: rule__ResultReportCollection__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__NameAssignment_1_in_rule__ResultReportCollection__Group__1__Impl882);
            rule__ResultReportCollection__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__1__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:457:1: rule__ResultReportCollection__Group__2 : rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3 ;
    public final void rule__ResultReportCollection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:461:1: ( rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:462:2: rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__2__Impl_in_rule__ResultReportCollection__Group__2912);
            rule__ResultReportCollection__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__3_in_rule__ResultReportCollection__Group__2915);
            rule__ResultReportCollection__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__2"


    // $ANTLR start "rule__ResultReportCollection__Group__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:469:1: rule__ResultReportCollection__Group__2__Impl : ( ( rule__ResultReportCollection__Group_2__0 )? ) ;
    public final void rule__ResultReportCollection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:473:1: ( ( ( rule__ResultReportCollection__Group_2__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:474:1: ( ( rule__ResultReportCollection__Group_2__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:474:1: ( ( rule__ResultReportCollection__Group_2__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:475:1: ( rule__ResultReportCollection__Group_2__0 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:476:1: ( rule__ResultReportCollection__Group_2__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==21) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:476:2: rule__ResultReportCollection__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__0_in_rule__ResultReportCollection__Group__2__Impl942);
                    rule__ResultReportCollection__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportCollectionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__2__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group__3"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:486:1: rule__ResultReportCollection__Group__3 : rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4 ;
    public final void rule__ResultReportCollection__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:490:1: ( rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:491:2: rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__3__Impl_in_rule__ResultReportCollection__Group__3973);
            rule__ResultReportCollection__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__4_in_rule__ResultReportCollection__Group__3976);
            rule__ResultReportCollection__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__3"


    // $ANTLR start "rule__ResultReportCollection__Group__3__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:498:1: rule__ResultReportCollection__Group__3__Impl : ( '[' ) ;
    public final void rule__ResultReportCollection__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:502:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:503:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:503:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:504:1: '['
            {
             before(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_3()); 
            match(input,18,FOLLOW_18_in_rule__ResultReportCollection__Group__3__Impl1004); 
             after(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__3__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group__4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:517:1: rule__ResultReportCollection__Group__4 : rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5 ;
    public final void rule__ResultReportCollection__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:521:1: ( rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:522:2: rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__4__Impl_in_rule__ResultReportCollection__Group__41035);
            rule__ResultReportCollection__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__5_in_rule__ResultReportCollection__Group__41038);
            rule__ResultReportCollection__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__4"


    // $ANTLR start "rule__ResultReportCollection__Group__4__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:529:1: rule__ResultReportCollection__Group__4__Impl : ( 'target' ) ;
    public final void rule__ResultReportCollection__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:533:1: ( ( 'target' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:534:1: ( 'target' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:534:1: ( 'target' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:535:1: 'target'
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetKeyword_4()); 
            match(input,19,FOLLOW_19_in_rule__ResultReportCollection__Group__4__Impl1066); 
             after(grammarAccess.getResultReportCollectionAccess().getTargetKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__4__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group__5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:548:1: rule__ResultReportCollection__Group__5 : rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6 ;
    public final void rule__ResultReportCollection__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:552:1: ( rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:553:2: rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__5__Impl_in_rule__ResultReportCollection__Group__51097);
            rule__ResultReportCollection__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__6_in_rule__ResultReportCollection__Group__51100);
            rule__ResultReportCollection__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__5"


    // $ANTLR start "rule__ResultReportCollection__Group__5__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:560:1: rule__ResultReportCollection__Group__5__Impl : ( ( rule__ResultReportCollection__TargetAssignment_5 ) ) ;
    public final void rule__ResultReportCollection__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:564:1: ( ( ( rule__ResultReportCollection__TargetAssignment_5 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:565:1: ( ( rule__ResultReportCollection__TargetAssignment_5 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:565:1: ( ( rule__ResultReportCollection__TargetAssignment_5 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:566:1: ( rule__ResultReportCollection__TargetAssignment_5 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:567:1: ( rule__ResultReportCollection__TargetAssignment_5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:567:2: rule__ResultReportCollection__TargetAssignment_5
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__TargetAssignment_5_in_rule__ResultReportCollection__Group__5__Impl1127);
            rule__ResultReportCollection__TargetAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__5__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group__6"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:577:1: rule__ResultReportCollection__Group__6 : rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7 ;
    public final void rule__ResultReportCollection__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:581:1: ( rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:582:2: rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__6__Impl_in_rule__ResultReportCollection__Group__61157);
            rule__ResultReportCollection__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__7_in_rule__ResultReportCollection__Group__61160);
            rule__ResultReportCollection__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__6"


    // $ANTLR start "rule__ResultReportCollection__Group__6__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:589:1: rule__ResultReportCollection__Group__6__Impl : ( ( rule__ResultReportCollection__Group_6__0 )? ) ;
    public final void rule__ResultReportCollection__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:593:1: ( ( ( rule__ResultReportCollection__Group_6__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:594:1: ( ( rule__ResultReportCollection__Group_6__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:594:1: ( ( rule__ResultReportCollection__Group_6__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:595:1: ( rule__ResultReportCollection__Group_6__0 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:596:1: ( rule__ResultReportCollection__Group_6__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==22) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:596:2: rule__ResultReportCollection__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__0_in_rule__ResultReportCollection__Group__6__Impl1187);
                    rule__ResultReportCollection__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportCollectionAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__6__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group__7"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:606:1: rule__ResultReportCollection__Group__7 : rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8 ;
    public final void rule__ResultReportCollection__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:610:1: ( rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:611:2: rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__7__Impl_in_rule__ResultReportCollection__Group__71218);
            rule__ResultReportCollection__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__8_in_rule__ResultReportCollection__Group__71221);
            rule__ResultReportCollection__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__7"


    // $ANTLR start "rule__ResultReportCollection__Group__7__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:618:1: rule__ResultReportCollection__Group__7__Impl : ( ( rule__ResultReportCollection__ContentAssignment_7 )* ) ;
    public final void rule__ResultReportCollection__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:622:1: ( ( ( rule__ResultReportCollection__ContentAssignment_7 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:623:1: ( ( rule__ResultReportCollection__ContentAssignment_7 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:623:1: ( ( rule__ResultReportCollection__ContentAssignment_7 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:624:1: ( rule__ResultReportCollection__ContentAssignment_7 )*
            {
             before(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:625:1: ( rule__ResultReportCollection__ContentAssignment_7 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==23) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:625:2: rule__ResultReportCollection__ContentAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__ResultReportCollection__ContentAssignment_7_in_rule__ResultReportCollection__Group__7__Impl1248);
            	    rule__ResultReportCollection__ContentAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__7__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group__8"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:635:1: rule__ResultReportCollection__Group__8 : rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9 ;
    public final void rule__ResultReportCollection__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:639:1: ( rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:640:2: rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__8__Impl_in_rule__ResultReportCollection__Group__81279);
            rule__ResultReportCollection__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__9_in_rule__ResultReportCollection__Group__81282);
            rule__ResultReportCollection__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__8"


    // $ANTLR start "rule__ResultReportCollection__Group__8__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:647:1: rule__ResultReportCollection__Group__8__Impl : ( ( rule__ResultReportCollection__IssuesAssignment_8 )? ) ;
    public final void rule__ResultReportCollection__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:651:1: ( ( ( rule__ResultReportCollection__IssuesAssignment_8 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:652:1: ( ( rule__ResultReportCollection__IssuesAssignment_8 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:652:1: ( ( rule__ResultReportCollection__IssuesAssignment_8 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:653:1: ( rule__ResultReportCollection__IssuesAssignment_8 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:654:1: ( rule__ResultReportCollection__IssuesAssignment_8 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==30) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:654:2: rule__ResultReportCollection__IssuesAssignment_8
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__IssuesAssignment_8_in_rule__ResultReportCollection__Group__8__Impl1309);
                    rule__ResultReportCollection__IssuesAssignment_8();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__8__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group__9"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:664:1: rule__ResultReportCollection__Group__9 : rule__ResultReportCollection__Group__9__Impl ;
    public final void rule__ResultReportCollection__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:668:1: ( rule__ResultReportCollection__Group__9__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:669:2: rule__ResultReportCollection__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__9__Impl_in_rule__ResultReportCollection__Group__91340);
            rule__ResultReportCollection__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__9"


    // $ANTLR start "rule__ResultReportCollection__Group__9__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:675:1: rule__ResultReportCollection__Group__9__Impl : ( ']' ) ;
    public final void rule__ResultReportCollection__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:679:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:680:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:680:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:681:1: ']'
            {
             before(grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9()); 
            match(input,20,FOLLOW_20_in_rule__ResultReportCollection__Group__9__Impl1368); 
             after(grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group__9__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group_2__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:714:1: rule__ResultReportCollection__Group_2__0 : rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1 ;
    public final void rule__ResultReportCollection__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:718:1: ( rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:719:2: rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__0__Impl_in_rule__ResultReportCollection__Group_2__01419);
            rule__ResultReportCollection__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__1_in_rule__ResultReportCollection__Group_2__01422);
            rule__ResultReportCollection__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group_2__0"


    // $ANTLR start "rule__ResultReportCollection__Group_2__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:726:1: rule__ResultReportCollection__Group_2__0__Impl : ( ':' ) ;
    public final void rule__ResultReportCollection__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:730:1: ( ( ':' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:731:1: ( ':' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:731:1: ( ':' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:732:1: ':'
            {
             before(grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0()); 
            match(input,21,FOLLOW_21_in_rule__ResultReportCollection__Group_2__0__Impl1450); 
             after(grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group_2__0__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group_2__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:745:1: rule__ResultReportCollection__Group_2__1 : rule__ResultReportCollection__Group_2__1__Impl ;
    public final void rule__ResultReportCollection__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:749:1: ( rule__ResultReportCollection__Group_2__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:750:2: rule__ResultReportCollection__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__1__Impl_in_rule__ResultReportCollection__Group_2__11481);
            rule__ResultReportCollection__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group_2__1"


    // $ANTLR start "rule__ResultReportCollection__Group_2__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:756:1: rule__ResultReportCollection__Group_2__1__Impl : ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) ) ;
    public final void rule__ResultReportCollection__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:760:1: ( ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:761:1: ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:761:1: ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:762:1: ( rule__ResultReportCollection__TitleAssignment_2_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:763:1: ( rule__ResultReportCollection__TitleAssignment_2_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:763:2: rule__ResultReportCollection__TitleAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__TitleAssignment_2_1_in_rule__ResultReportCollection__Group_2__1__Impl1508);
            rule__ResultReportCollection__TitleAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group_2__1__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group_6__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:777:1: rule__ResultReportCollection__Group_6__0 : rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1 ;
    public final void rule__ResultReportCollection__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:781:1: ( rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:782:2: rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__0__Impl_in_rule__ResultReportCollection__Group_6__01542);
            rule__ResultReportCollection__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__1_in_rule__ResultReportCollection__Group_6__01545);
            rule__ResultReportCollection__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group_6__0"


    // $ANTLR start "rule__ResultReportCollection__Group_6__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:789:1: rule__ResultReportCollection__Group_6__0__Impl : ( 'description' ) ;
    public final void rule__ResultReportCollection__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:793:1: ( ( 'description' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:794:1: ( 'description' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:794:1: ( 'description' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:795:1: 'description'
            {
             before(grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0()); 
            match(input,22,FOLLOW_22_in_rule__ResultReportCollection__Group_6__0__Impl1573); 
             after(grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group_6__0__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group_6__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:808:1: rule__ResultReportCollection__Group_6__1 : rule__ResultReportCollection__Group_6__1__Impl ;
    public final void rule__ResultReportCollection__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:812:1: ( rule__ResultReportCollection__Group_6__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:813:2: rule__ResultReportCollection__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__1__Impl_in_rule__ResultReportCollection__Group_6__11604);
            rule__ResultReportCollection__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group_6__1"


    // $ANTLR start "rule__ResultReportCollection__Group_6__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:819:1: rule__ResultReportCollection__Group_6__1__Impl : ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) ) ;
    public final void rule__ResultReportCollection__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:823:1: ( ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:824:1: ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:824:1: ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:825:1: ( rule__ResultReportCollection__DecriptionAssignment_6_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getDecriptionAssignment_6_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:826:1: ( rule__ResultReportCollection__DecriptionAssignment_6_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:826:2: rule__ResultReportCollection__DecriptionAssignment_6_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__DecriptionAssignment_6_1_in_rule__ResultReportCollection__Group_6__1__Impl1631);
            rule__ResultReportCollection__DecriptionAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportCollectionAccess().getDecriptionAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__Group_6__1__Impl"


    // $ANTLR start "rule__ResultReport__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:840:1: rule__ResultReport__Group__0 : rule__ResultReport__Group__0__Impl rule__ResultReport__Group__1 ;
    public final void rule__ResultReport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:844:1: ( rule__ResultReport__Group__0__Impl rule__ResultReport__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:845:2: rule__ResultReport__Group__0__Impl rule__ResultReport__Group__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__0__Impl_in_rule__ResultReport__Group__01665);
            rule__ResultReport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__1_in_rule__ResultReport__Group__01668);
            rule__ResultReport__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__0"


    // $ANTLR start "rule__ResultReport__Group__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:852:1: rule__ResultReport__Group__0__Impl : ( () ) ;
    public final void rule__ResultReport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:856:1: ( ( () ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:857:1: ( () )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:857:1: ( () )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:858:1: ()
            {
             before(grammarAccess.getResultReportAccess().getResultReportAction_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:859:1: ()
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:861:1: 
            {
            }

             after(grammarAccess.getResultReportAccess().getResultReportAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__0__Impl"


    // $ANTLR start "rule__ResultReport__Group__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:871:1: rule__ResultReport__Group__1 : rule__ResultReport__Group__1__Impl rule__ResultReport__Group__2 ;
    public final void rule__ResultReport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:875:1: ( rule__ResultReport__Group__1__Impl rule__ResultReport__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:876:2: rule__ResultReport__Group__1__Impl rule__ResultReport__Group__2
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__1__Impl_in_rule__ResultReport__Group__11726);
            rule__ResultReport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__2_in_rule__ResultReport__Group__11729);
            rule__ResultReport__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__1"


    // $ANTLR start "rule__ResultReport__Group__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:883:1: rule__ResultReport__Group__1__Impl : ( 'report' ) ;
    public final void rule__ResultReport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:887:1: ( ( 'report' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:888:1: ( 'report' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:888:1: ( 'report' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:889:1: 'report'
            {
             before(grammarAccess.getResultReportAccess().getReportKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__ResultReport__Group__1__Impl1757); 
             after(grammarAccess.getResultReportAccess().getReportKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__1__Impl"


    // $ANTLR start "rule__ResultReport__Group__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:902:1: rule__ResultReport__Group__2 : rule__ResultReport__Group__2__Impl rule__ResultReport__Group__3 ;
    public final void rule__ResultReport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:906:1: ( rule__ResultReport__Group__2__Impl rule__ResultReport__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:907:2: rule__ResultReport__Group__2__Impl rule__ResultReport__Group__3
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__2__Impl_in_rule__ResultReport__Group__21788);
            rule__ResultReport__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__3_in_rule__ResultReport__Group__21791);
            rule__ResultReport__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__2"


    // $ANTLR start "rule__ResultReport__Group__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:914:1: rule__ResultReport__Group__2__Impl : ( ( rule__ResultReport__NameAssignment_2 ) ) ;
    public final void rule__ResultReport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:918:1: ( ( ( rule__ResultReport__NameAssignment_2 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:919:1: ( ( rule__ResultReport__NameAssignment_2 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:919:1: ( ( rule__ResultReport__NameAssignment_2 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:920:1: ( rule__ResultReport__NameAssignment_2 )
            {
             before(grammarAccess.getResultReportAccess().getNameAssignment_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:921:1: ( rule__ResultReport__NameAssignment_2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:921:2: rule__ResultReport__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ResultReport__NameAssignment_2_in_rule__ResultReport__Group__2__Impl1818);
            rule__ResultReport__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__2__Impl"


    // $ANTLR start "rule__ResultReport__Group__3"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:931:1: rule__ResultReport__Group__3 : rule__ResultReport__Group__3__Impl rule__ResultReport__Group__4 ;
    public final void rule__ResultReport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:935:1: ( rule__ResultReport__Group__3__Impl rule__ResultReport__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:936:2: rule__ResultReport__Group__3__Impl rule__ResultReport__Group__4
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__3__Impl_in_rule__ResultReport__Group__31848);
            rule__ResultReport__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__4_in_rule__ResultReport__Group__31851);
            rule__ResultReport__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__3"


    // $ANTLR start "rule__ResultReport__Group__3__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:943:1: rule__ResultReport__Group__3__Impl : ( ( rule__ResultReport__Group_3__0 )? ) ;
    public final void rule__ResultReport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:947:1: ( ( ( rule__ResultReport__Group_3__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:948:1: ( ( rule__ResultReport__Group_3__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:948:1: ( ( rule__ResultReport__Group_3__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:949:1: ( rule__ResultReport__Group_3__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_3()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:950:1: ( rule__ResultReport__Group_3__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:950:2: rule__ResultReport__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_3__0_in_rule__ResultReport__Group__3__Impl1878);
                    rule__ResultReport__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__3__Impl"


    // $ANTLR start "rule__ResultReport__Group__4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:960:1: rule__ResultReport__Group__4 : rule__ResultReport__Group__4__Impl rule__ResultReport__Group__5 ;
    public final void rule__ResultReport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:964:1: ( rule__ResultReport__Group__4__Impl rule__ResultReport__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:965:2: rule__ResultReport__Group__4__Impl rule__ResultReport__Group__5
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__4__Impl_in_rule__ResultReport__Group__41909);
            rule__ResultReport__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__5_in_rule__ResultReport__Group__41912);
            rule__ResultReport__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__4"


    // $ANTLR start "rule__ResultReport__Group__4__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:972:1: rule__ResultReport__Group__4__Impl : ( ( rule__ResultReport__TargetAssignment_4 ) ) ;
    public final void rule__ResultReport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:976:1: ( ( ( rule__ResultReport__TargetAssignment_4 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:977:1: ( ( rule__ResultReport__TargetAssignment_4 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:977:1: ( ( rule__ResultReport__TargetAssignment_4 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:978:1: ( rule__ResultReport__TargetAssignment_4 )
            {
             before(grammarAccess.getResultReportAccess().getTargetAssignment_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:979:1: ( rule__ResultReport__TargetAssignment_4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:979:2: rule__ResultReport__TargetAssignment_4
            {
            pushFollow(FOLLOW_rule__ResultReport__TargetAssignment_4_in_rule__ResultReport__Group__4__Impl1939);
            rule__ResultReport__TargetAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getTargetAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__4__Impl"


    // $ANTLR start "rule__ResultReport__Group__5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:989:1: rule__ResultReport__Group__5 : rule__ResultReport__Group__5__Impl rule__ResultReport__Group__6 ;
    public final void rule__ResultReport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:993:1: ( rule__ResultReport__Group__5__Impl rule__ResultReport__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:994:2: rule__ResultReport__Group__5__Impl rule__ResultReport__Group__6
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__5__Impl_in_rule__ResultReport__Group__51969);
            rule__ResultReport__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__6_in_rule__ResultReport__Group__51972);
            rule__ResultReport__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__5"


    // $ANTLR start "rule__ResultReport__Group__5__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1001:1: rule__ResultReport__Group__5__Impl : ( ( rule__ResultReport__IssueTypeAssignment_5 ) ) ;
    public final void rule__ResultReport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1005:1: ( ( ( rule__ResultReport__IssueTypeAssignment_5 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1006:1: ( ( rule__ResultReport__IssueTypeAssignment_5 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1006:1: ( ( rule__ResultReport__IssueTypeAssignment_5 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1007:1: ( rule__ResultReport__IssueTypeAssignment_5 )
            {
             before(grammarAccess.getResultReportAccess().getIssueTypeAssignment_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1008:1: ( rule__ResultReport__IssueTypeAssignment_5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1008:2: rule__ResultReport__IssueTypeAssignment_5
            {
            pushFollow(FOLLOW_rule__ResultReport__IssueTypeAssignment_5_in_rule__ResultReport__Group__5__Impl1999);
            rule__ResultReport__IssueTypeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getIssueTypeAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__5__Impl"


    // $ANTLR start "rule__ResultReport__Group__6"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1018:1: rule__ResultReport__Group__6 : rule__ResultReport__Group__6__Impl rule__ResultReport__Group__7 ;
    public final void rule__ResultReport__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1022:1: ( rule__ResultReport__Group__6__Impl rule__ResultReport__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1023:2: rule__ResultReport__Group__6__Impl rule__ResultReport__Group__7
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__6__Impl_in_rule__ResultReport__Group__62029);
            rule__ResultReport__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__7_in_rule__ResultReport__Group__62032);
            rule__ResultReport__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__6"


    // $ANTLR start "rule__ResultReport__Group__6__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1030:1: rule__ResultReport__Group__6__Impl : ( ( rule__ResultReport__MessageAssignment_6 ) ) ;
    public final void rule__ResultReport__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1034:1: ( ( ( rule__ResultReport__MessageAssignment_6 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1035:1: ( ( rule__ResultReport__MessageAssignment_6 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1035:1: ( ( rule__ResultReport__MessageAssignment_6 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1036:1: ( rule__ResultReport__MessageAssignment_6 )
            {
             before(grammarAccess.getResultReportAccess().getMessageAssignment_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1037:1: ( rule__ResultReport__MessageAssignment_6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1037:2: rule__ResultReport__MessageAssignment_6
            {
            pushFollow(FOLLOW_rule__ResultReport__MessageAssignment_6_in_rule__ResultReport__Group__6__Impl2059);
            rule__ResultReport__MessageAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getMessageAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__6__Impl"


    // $ANTLR start "rule__ResultReport__Group__7"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1047:1: rule__ResultReport__Group__7 : rule__ResultReport__Group__7__Impl rule__ResultReport__Group__8 ;
    public final void rule__ResultReport__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1051:1: ( rule__ResultReport__Group__7__Impl rule__ResultReport__Group__8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1052:2: rule__ResultReport__Group__7__Impl rule__ResultReport__Group__8
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__7__Impl_in_rule__ResultReport__Group__72089);
            rule__ResultReport__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__8_in_rule__ResultReport__Group__72092);
            rule__ResultReport__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__7"


    // $ANTLR start "rule__ResultReport__Group__7__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1059:1: rule__ResultReport__Group__7__Impl : ( ( rule__ResultReport__Group_7__0 )? ) ;
    public final void rule__ResultReport__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1063:1: ( ( ( rule__ResultReport__Group_7__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1064:1: ( ( rule__ResultReport__Group_7__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1064:1: ( ( rule__ResultReport__Group_7__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1065:1: ( rule__ResultReport__Group_7__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_7()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1066:1: ( rule__ResultReport__Group_7__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1066:2: rule__ResultReport__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_7__0_in_rule__ResultReport__Group__7__Impl2119);
                    rule__ResultReport__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__7__Impl"


    // $ANTLR start "rule__ResultReport__Group__8"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1076:1: rule__ResultReport__Group__8 : rule__ResultReport__Group__8__Impl rule__ResultReport__Group__9 ;
    public final void rule__ResultReport__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1080:1: ( rule__ResultReport__Group__8__Impl rule__ResultReport__Group__9 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1081:2: rule__ResultReport__Group__8__Impl rule__ResultReport__Group__9
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__8__Impl_in_rule__ResultReport__Group__82150);
            rule__ResultReport__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__9_in_rule__ResultReport__Group__82153);
            rule__ResultReport__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__8"


    // $ANTLR start "rule__ResultReport__Group__8__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1088:1: rule__ResultReport__Group__8__Impl : ( '[' ) ;
    public final void rule__ResultReport__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1092:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1093:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1093:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1094:1: '['
            {
             before(grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_8()); 
            match(input,18,FOLLOW_18_in_rule__ResultReport__Group__8__Impl2181); 
             after(grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__8__Impl"


    // $ANTLR start "rule__ResultReport__Group__9"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1107:1: rule__ResultReport__Group__9 : rule__ResultReport__Group__9__Impl rule__ResultReport__Group__10 ;
    public final void rule__ResultReport__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1111:1: ( rule__ResultReport__Group__9__Impl rule__ResultReport__Group__10 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1112:2: rule__ResultReport__Group__9__Impl rule__ResultReport__Group__10
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__9__Impl_in_rule__ResultReport__Group__92212);
            rule__ResultReport__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__10_in_rule__ResultReport__Group__92215);
            rule__ResultReport__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__9"


    // $ANTLR start "rule__ResultReport__Group__9__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1119:1: rule__ResultReport__Group__9__Impl : ( ( rule__ResultReport__Group_9__0 )? ) ;
    public final void rule__ResultReport__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1123:1: ( ( ( rule__ResultReport__Group_9__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1124:1: ( ( rule__ResultReport__Group_9__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1124:1: ( ( rule__ResultReport__Group_9__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1125:1: ( rule__ResultReport__Group_9__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_9()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1126:1: ( rule__ResultReport__Group_9__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1126:2: rule__ResultReport__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_9__0_in_rule__ResultReport__Group__9__Impl2242);
                    rule__ResultReport__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__9__Impl"


    // $ANTLR start "rule__ResultReport__Group__10"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1136:1: rule__ResultReport__Group__10 : rule__ResultReport__Group__10__Impl rule__ResultReport__Group__11 ;
    public final void rule__ResultReport__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1140:1: ( rule__ResultReport__Group__10__Impl rule__ResultReport__Group__11 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1141:2: rule__ResultReport__Group__10__Impl rule__ResultReport__Group__11
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__10__Impl_in_rule__ResultReport__Group__102273);
            rule__ResultReport__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__11_in_rule__ResultReport__Group__102276);
            rule__ResultReport__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__10"


    // $ANTLR start "rule__ResultReport__Group__10__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1148:1: rule__ResultReport__Group__10__Impl : ( ( rule__ResultReport__Group_10__0 )? ) ;
    public final void rule__ResultReport__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1152:1: ( ( ( rule__ResultReport__Group_10__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1153:1: ( ( rule__ResultReport__Group_10__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1153:1: ( ( rule__ResultReport__Group_10__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1154:1: ( rule__ResultReport__Group_10__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_10()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1155:1: ( rule__ResultReport__Group_10__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1155:2: rule__ResultReport__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_10__0_in_rule__ResultReport__Group__10__Impl2303);
                    rule__ResultReport__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__10__Impl"


    // $ANTLR start "rule__ResultReport__Group__11"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1165:1: rule__ResultReport__Group__11 : rule__ResultReport__Group__11__Impl rule__ResultReport__Group__12 ;
    public final void rule__ResultReport__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1169:1: ( rule__ResultReport__Group__11__Impl rule__ResultReport__Group__12 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1170:2: rule__ResultReport__Group__11__Impl rule__ResultReport__Group__12
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__11__Impl_in_rule__ResultReport__Group__112334);
            rule__ResultReport__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__12_in_rule__ResultReport__Group__112337);
            rule__ResultReport__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__11"


    // $ANTLR start "rule__ResultReport__Group__11__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1177:1: rule__ResultReport__Group__11__Impl : ( ( rule__ResultReport__Group_11__0 )? ) ;
    public final void rule__ResultReport__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1181:1: ( ( ( rule__ResultReport__Group_11__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1182:1: ( ( rule__ResultReport__Group_11__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1182:1: ( ( rule__ResultReport__Group_11__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1183:1: ( rule__ResultReport__Group_11__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_11()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1184:1: ( rule__ResultReport__Group_11__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==26) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1184:2: rule__ResultReport__Group_11__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_11__0_in_rule__ResultReport__Group__11__Impl2364);
                    rule__ResultReport__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__11__Impl"


    // $ANTLR start "rule__ResultReport__Group__12"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1194:1: rule__ResultReport__Group__12 : rule__ResultReport__Group__12__Impl rule__ResultReport__Group__13 ;
    public final void rule__ResultReport__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1198:1: ( rule__ResultReport__Group__12__Impl rule__ResultReport__Group__13 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1199:2: rule__ResultReport__Group__12__Impl rule__ResultReport__Group__13
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__12__Impl_in_rule__ResultReport__Group__122395);
            rule__ResultReport__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__13_in_rule__ResultReport__Group__122398);
            rule__ResultReport__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__12"


    // $ANTLR start "rule__ResultReport__Group__12__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1206:1: rule__ResultReport__Group__12__Impl : ( ( rule__ResultReport__IssuesAssignment_12 )? ) ;
    public final void rule__ResultReport__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1210:1: ( ( ( rule__ResultReport__IssuesAssignment_12 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1211:1: ( ( rule__ResultReport__IssuesAssignment_12 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1211:1: ( ( rule__ResultReport__IssuesAssignment_12 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1212:1: ( rule__ResultReport__IssuesAssignment_12 )?
            {
             before(grammarAccess.getResultReportAccess().getIssuesAssignment_12()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1213:1: ( rule__ResultReport__IssuesAssignment_12 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==30) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1213:2: rule__ResultReport__IssuesAssignment_12
                    {
                    pushFollow(FOLLOW_rule__ResultReport__IssuesAssignment_12_in_rule__ResultReport__Group__12__Impl2425);
                    rule__ResultReport__IssuesAssignment_12();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportAccess().getIssuesAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__12__Impl"


    // $ANTLR start "rule__ResultReport__Group__13"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1223:1: rule__ResultReport__Group__13 : rule__ResultReport__Group__13__Impl ;
    public final void rule__ResultReport__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1227:1: ( rule__ResultReport__Group__13__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1228:2: rule__ResultReport__Group__13__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__13__Impl_in_rule__ResultReport__Group__132456);
            rule__ResultReport__Group__13__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__13"


    // $ANTLR start "rule__ResultReport__Group__13__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1234:1: rule__ResultReport__Group__13__Impl : ( ']' ) ;
    public final void rule__ResultReport__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1238:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1239:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1239:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1240:1: ']'
            {
             before(grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_13()); 
            match(input,20,FOLLOW_20_in_rule__ResultReport__Group__13__Impl2484); 
             after(grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group__13__Impl"


    // $ANTLR start "rule__ResultReport__Group_3__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1281:1: rule__ResultReport__Group_3__0 : rule__ResultReport__Group_3__0__Impl rule__ResultReport__Group_3__1 ;
    public final void rule__ResultReport__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1285:1: ( rule__ResultReport__Group_3__0__Impl rule__ResultReport__Group_3__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1286:2: rule__ResultReport__Group_3__0__Impl rule__ResultReport__Group_3__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_3__0__Impl_in_rule__ResultReport__Group_3__02543);
            rule__ResultReport__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_3__1_in_rule__ResultReport__Group_3__02546);
            rule__ResultReport__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_3__0"


    // $ANTLR start "rule__ResultReport__Group_3__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1293:1: rule__ResultReport__Group_3__0__Impl : ( ':' ) ;
    public final void rule__ResultReport__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1297:1: ( ( ':' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1298:1: ( ':' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1298:1: ( ':' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1299:1: ':'
            {
             before(grammarAccess.getResultReportAccess().getColonKeyword_3_0()); 
            match(input,21,FOLLOW_21_in_rule__ResultReport__Group_3__0__Impl2574); 
             after(grammarAccess.getResultReportAccess().getColonKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_3__0__Impl"


    // $ANTLR start "rule__ResultReport__Group_3__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1312:1: rule__ResultReport__Group_3__1 : rule__ResultReport__Group_3__1__Impl ;
    public final void rule__ResultReport__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1316:1: ( rule__ResultReport__Group_3__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1317:2: rule__ResultReport__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_3__1__Impl_in_rule__ResultReport__Group_3__12605);
            rule__ResultReport__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_3__1"


    // $ANTLR start "rule__ResultReport__Group_3__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1323:1: rule__ResultReport__Group_3__1__Impl : ( ( rule__ResultReport__TitleAssignment_3_1 ) ) ;
    public final void rule__ResultReport__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1327:1: ( ( ( rule__ResultReport__TitleAssignment_3_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1328:1: ( ( rule__ResultReport__TitleAssignment_3_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1328:1: ( ( rule__ResultReport__TitleAssignment_3_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1329:1: ( rule__ResultReport__TitleAssignment_3_1 )
            {
             before(grammarAccess.getResultReportAccess().getTitleAssignment_3_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1330:1: ( rule__ResultReport__TitleAssignment_3_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1330:2: rule__ResultReport__TitleAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ResultReport__TitleAssignment_3_1_in_rule__ResultReport__Group_3__1__Impl2632);
            rule__ResultReport__TitleAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getTitleAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_3__1__Impl"


    // $ANTLR start "rule__ResultReport__Group_7__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1344:1: rule__ResultReport__Group_7__0 : rule__ResultReport__Group_7__0__Impl rule__ResultReport__Group_7__1 ;
    public final void rule__ResultReport__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1348:1: ( rule__ResultReport__Group_7__0__Impl rule__ResultReport__Group_7__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1349:2: rule__ResultReport__Group_7__0__Impl rule__ResultReport__Group_7__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_7__0__Impl_in_rule__ResultReport__Group_7__02666);
            rule__ResultReport__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_7__1_in_rule__ResultReport__Group_7__02669);
            rule__ResultReport__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_7__0"


    // $ANTLR start "rule__ResultReport__Group_7__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1356:1: rule__ResultReport__Group_7__0__Impl : ( 'exception' ) ;
    public final void rule__ResultReport__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1360:1: ( ( 'exception' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1361:1: ( 'exception' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1361:1: ( 'exception' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1362:1: 'exception'
            {
             before(grammarAccess.getResultReportAccess().getExceptionKeyword_7_0()); 
            match(input,24,FOLLOW_24_in_rule__ResultReport__Group_7__0__Impl2697); 
             after(grammarAccess.getResultReportAccess().getExceptionKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_7__0__Impl"


    // $ANTLR start "rule__ResultReport__Group_7__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1375:1: rule__ResultReport__Group_7__1 : rule__ResultReport__Group_7__1__Impl ;
    public final void rule__ResultReport__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1379:1: ( rule__ResultReport__Group_7__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1380:2: rule__ResultReport__Group_7__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_7__1__Impl_in_rule__ResultReport__Group_7__12728);
            rule__ResultReport__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_7__1"


    // $ANTLR start "rule__ResultReport__Group_7__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1386:1: rule__ResultReport__Group_7__1__Impl : ( ( rule__ResultReport__ExceptionTypeAssignment_7_1 ) ) ;
    public final void rule__ResultReport__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1390:1: ( ( ( rule__ResultReport__ExceptionTypeAssignment_7_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1391:1: ( ( rule__ResultReport__ExceptionTypeAssignment_7_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1391:1: ( ( rule__ResultReport__ExceptionTypeAssignment_7_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1392:1: ( rule__ResultReport__ExceptionTypeAssignment_7_1 )
            {
             before(grammarAccess.getResultReportAccess().getExceptionTypeAssignment_7_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1393:1: ( rule__ResultReport__ExceptionTypeAssignment_7_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1393:2: rule__ResultReport__ExceptionTypeAssignment_7_1
            {
            pushFollow(FOLLOW_rule__ResultReport__ExceptionTypeAssignment_7_1_in_rule__ResultReport__Group_7__1__Impl2755);
            rule__ResultReport__ExceptionTypeAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getExceptionTypeAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_7__1__Impl"


    // $ANTLR start "rule__ResultReport__Group_9__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1407:1: rule__ResultReport__Group_9__0 : rule__ResultReport__Group_9__0__Impl rule__ResultReport__Group_9__1 ;
    public final void rule__ResultReport__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1411:1: ( rule__ResultReport__Group_9__0__Impl rule__ResultReport__Group_9__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1412:2: rule__ResultReport__Group_9__0__Impl rule__ResultReport__Group_9__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_9__0__Impl_in_rule__ResultReport__Group_9__02789);
            rule__ResultReport__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_9__1_in_rule__ResultReport__Group_9__02792);
            rule__ResultReport__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_9__0"


    // $ANTLR start "rule__ResultReport__Group_9__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1419:1: rule__ResultReport__Group_9__0__Impl : ( 'description' ) ;
    public final void rule__ResultReport__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1423:1: ( ( 'description' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1424:1: ( 'description' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1424:1: ( 'description' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1425:1: 'description'
            {
             before(grammarAccess.getResultReportAccess().getDescriptionKeyword_9_0()); 
            match(input,22,FOLLOW_22_in_rule__ResultReport__Group_9__0__Impl2820); 
             after(grammarAccess.getResultReportAccess().getDescriptionKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_9__0__Impl"


    // $ANTLR start "rule__ResultReport__Group_9__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1438:1: rule__ResultReport__Group_9__1 : rule__ResultReport__Group_9__1__Impl ;
    public final void rule__ResultReport__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1442:1: ( rule__ResultReport__Group_9__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1443:2: rule__ResultReport__Group_9__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_9__1__Impl_in_rule__ResultReport__Group_9__12851);
            rule__ResultReport__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_9__1"


    // $ANTLR start "rule__ResultReport__Group_9__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1449:1: rule__ResultReport__Group_9__1__Impl : ( ( rule__ResultReport__DecriptionAssignment_9_1 ) ) ;
    public final void rule__ResultReport__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1453:1: ( ( ( rule__ResultReport__DecriptionAssignment_9_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1454:1: ( ( rule__ResultReport__DecriptionAssignment_9_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1454:1: ( ( rule__ResultReport__DecriptionAssignment_9_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1455:1: ( rule__ResultReport__DecriptionAssignment_9_1 )
            {
             before(grammarAccess.getResultReportAccess().getDecriptionAssignment_9_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1456:1: ( rule__ResultReport__DecriptionAssignment_9_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1456:2: rule__ResultReport__DecriptionAssignment_9_1
            {
            pushFollow(FOLLOW_rule__ResultReport__DecriptionAssignment_9_1_in_rule__ResultReport__Group_9__1__Impl2878);
            rule__ResultReport__DecriptionAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getDecriptionAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_9__1__Impl"


    // $ANTLR start "rule__ResultReport__Group_10__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1470:1: rule__ResultReport__Group_10__0 : rule__ResultReport__Group_10__0__Impl rule__ResultReport__Group_10__1 ;
    public final void rule__ResultReport__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1474:1: ( rule__ResultReport__Group_10__0__Impl rule__ResultReport__Group_10__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1475:2: rule__ResultReport__Group_10__0__Impl rule__ResultReport__Group_10__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_10__0__Impl_in_rule__ResultReport__Group_10__02912);
            rule__ResultReport__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_10__1_in_rule__ResultReport__Group_10__02915);
            rule__ResultReport__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_10__0"


    // $ANTLR start "rule__ResultReport__Group_10__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1482:1: rule__ResultReport__Group_10__0__Impl : ( 'heading' ) ;
    public final void rule__ResultReport__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1486:1: ( ( 'heading' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1487:1: ( 'heading' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1487:1: ( 'heading' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1488:1: 'heading'
            {
             before(grammarAccess.getResultReportAccess().getHeadingKeyword_10_0()); 
            match(input,25,FOLLOW_25_in_rule__ResultReport__Group_10__0__Impl2943); 
             after(grammarAccess.getResultReportAccess().getHeadingKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_10__0__Impl"


    // $ANTLR start "rule__ResultReport__Group_10__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1501:1: rule__ResultReport__Group_10__1 : rule__ResultReport__Group_10__1__Impl rule__ResultReport__Group_10__2 ;
    public final void rule__ResultReport__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1505:1: ( rule__ResultReport__Group_10__1__Impl rule__ResultReport__Group_10__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1506:2: rule__ResultReport__Group_10__1__Impl rule__ResultReport__Group_10__2
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_10__1__Impl_in_rule__ResultReport__Group_10__12974);
            rule__ResultReport__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_10__2_in_rule__ResultReport__Group_10__12977);
            rule__ResultReport__Group_10__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_10__1"


    // $ANTLR start "rule__ResultReport__Group_10__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1513:1: rule__ResultReport__Group_10__1__Impl : ( ( rule__ResultReport__HeadingAssignment_10_1 ) ) ;
    public final void rule__ResultReport__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1517:1: ( ( ( rule__ResultReport__HeadingAssignment_10_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1518:1: ( ( rule__ResultReport__HeadingAssignment_10_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1518:1: ( ( rule__ResultReport__HeadingAssignment_10_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1519:1: ( rule__ResultReport__HeadingAssignment_10_1 )
            {
             before(grammarAccess.getResultReportAccess().getHeadingAssignment_10_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1520:1: ( rule__ResultReport__HeadingAssignment_10_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1520:2: rule__ResultReport__HeadingAssignment_10_1
            {
            pushFollow(FOLLOW_rule__ResultReport__HeadingAssignment_10_1_in_rule__ResultReport__Group_10__1__Impl3004);
            rule__ResultReport__HeadingAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getHeadingAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_10__1__Impl"


    // $ANTLR start "rule__ResultReport__Group_10__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1530:1: rule__ResultReport__Group_10__2 : rule__ResultReport__Group_10__2__Impl ;
    public final void rule__ResultReport__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1534:1: ( rule__ResultReport__Group_10__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1535:2: rule__ResultReport__Group_10__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_10__2__Impl_in_rule__ResultReport__Group_10__23034);
            rule__ResultReport__Group_10__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_10__2"


    // $ANTLR start "rule__ResultReport__Group_10__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1541:1: rule__ResultReport__Group_10__2__Impl : ( ( rule__ResultReport__ContentAssignment_10_2 )* ) ;
    public final void rule__ResultReport__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1545:1: ( ( ( rule__ResultReport__ContentAssignment_10_2 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1546:1: ( ( rule__ResultReport__ContentAssignment_10_2 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1546:1: ( ( rule__ResultReport__ContentAssignment_10_2 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1547:1: ( rule__ResultReport__ContentAssignment_10_2 )*
            {
             before(grammarAccess.getResultReportAccess().getContentAssignment_10_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1548:1: ( rule__ResultReport__ContentAssignment_10_2 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==27) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1548:2: rule__ResultReport__ContentAssignment_10_2
            	    {
            	    pushFollow(FOLLOW_rule__ResultReport__ContentAssignment_10_2_in_rule__ResultReport__Group_10__2__Impl3061);
            	    rule__ResultReport__ContentAssignment_10_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getResultReportAccess().getContentAssignment_10_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_10__2__Impl"


    // $ANTLR start "rule__ResultReport__Group_11__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1564:1: rule__ResultReport__Group_11__0 : rule__ResultReport__Group_11__0__Impl rule__ResultReport__Group_11__1 ;
    public final void rule__ResultReport__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1568:1: ( rule__ResultReport__Group_11__0__Impl rule__ResultReport__Group_11__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1569:2: rule__ResultReport__Group_11__0__Impl rule__ResultReport__Group_11__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_11__0__Impl_in_rule__ResultReport__Group_11__03098);
            rule__ResultReport__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_11__1_in_rule__ResultReport__Group_11__03101);
            rule__ResultReport__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_11__0"


    // $ANTLR start "rule__ResultReport__Group_11__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1576:1: rule__ResultReport__Group_11__0__Impl : ( 'results' ) ;
    public final void rule__ResultReport__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1580:1: ( ( 'results' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1581:1: ( 'results' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1581:1: ( 'results' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1582:1: 'results'
            {
             before(grammarAccess.getResultReportAccess().getResultsKeyword_11_0()); 
            match(input,26,FOLLOW_26_in_rule__ResultReport__Group_11__0__Impl3129); 
             after(grammarAccess.getResultReportAccess().getResultsKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_11__0__Impl"


    // $ANTLR start "rule__ResultReport__Group_11__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1595:1: rule__ResultReport__Group_11__1 : rule__ResultReport__Group_11__1__Impl ;
    public final void rule__ResultReport__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1599:1: ( rule__ResultReport__Group_11__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1600:2: rule__ResultReport__Group_11__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_11__1__Impl_in_rule__ResultReport__Group_11__13160);
            rule__ResultReport__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_11__1"


    // $ANTLR start "rule__ResultReport__Group_11__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1606:1: rule__ResultReport__Group_11__1__Impl : ( ( ( rule__ResultReport__ResultDataAssignment_11_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_11_1 )* ) ) ;
    public final void rule__ResultReport__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1610:1: ( ( ( ( rule__ResultReport__ResultDataAssignment_11_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_11_1 )* ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1611:1: ( ( ( rule__ResultReport__ResultDataAssignment_11_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_11_1 )* ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1611:1: ( ( ( rule__ResultReport__ResultDataAssignment_11_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_11_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1612:1: ( ( rule__ResultReport__ResultDataAssignment_11_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_11_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1612:1: ( ( rule__ResultReport__ResultDataAssignment_11_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1613:1: ( rule__ResultReport__ResultDataAssignment_11_1 )
            {
             before(grammarAccess.getResultReportAccess().getResultDataAssignment_11_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1614:1: ( rule__ResultReport__ResultDataAssignment_11_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1614:2: rule__ResultReport__ResultDataAssignment_11_1
            {
            pushFollow(FOLLOW_rule__ResultReport__ResultDataAssignment_11_1_in_rule__ResultReport__Group_11__1__Impl3189);
            rule__ResultReport__ResultDataAssignment_11_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getResultDataAssignment_11_1()); 

            }

            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1617:1: ( ( rule__ResultReport__ResultDataAssignment_11_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1618:1: ( rule__ResultReport__ResultDataAssignment_11_1 )*
            {
             before(grammarAccess.getResultReportAccess().getResultDataAssignment_11_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1619:1: ( rule__ResultReport__ResultDataAssignment_11_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1619:2: rule__ResultReport__ResultDataAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultReport__ResultDataAssignment_11_1_in_rule__ResultReport__Group_11__1__Impl3201);
            	    rule__ResultReport__ResultDataAssignment_11_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getResultReportAccess().getResultDataAssignment_11_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__Group_11__1__Impl"


    // $ANTLR start "rule__ResultContributor__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1634:1: rule__ResultContributor__Group__0 : rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1 ;
    public final void rule__ResultContributor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1638:1: ( rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1639:2: rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__0__Impl_in_rule__ResultContributor__Group__03238);
            rule__ResultContributor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__1_in_rule__ResultContributor__Group__03241);
            rule__ResultContributor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__0"


    // $ANTLR start "rule__ResultContributor__Group__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1646:1: rule__ResultContributor__Group__0__Impl : ( () ) ;
    public final void rule__ResultContributor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1650:1: ( ( () ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1651:1: ( () )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1651:1: ( () )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1652:1: ()
            {
             before(grammarAccess.getResultContributorAccess().getResultContributorAction_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1653:1: ()
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1655:1: 
            {
            }

             after(grammarAccess.getResultContributorAccess().getResultContributorAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__0__Impl"


    // $ANTLR start "rule__ResultContributor__Group__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1665:1: rule__ResultContributor__Group__1 : rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2 ;
    public final void rule__ResultContributor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1669:1: ( rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1670:2: rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__1__Impl_in_rule__ResultContributor__Group__13299);
            rule__ResultContributor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__2_in_rule__ResultContributor__Group__13302);
            rule__ResultContributor__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__1"


    // $ANTLR start "rule__ResultContributor__Group__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1677:1: rule__ResultContributor__Group__1__Impl : ( 'contributor' ) ;
    public final void rule__ResultContributor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1681:1: ( ( 'contributor' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1682:1: ( 'contributor' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1682:1: ( 'contributor' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1683:1: 'contributor'
            {
             before(grammarAccess.getResultContributorAccess().getContributorKeyword_1()); 
            match(input,27,FOLLOW_27_in_rule__ResultContributor__Group__1__Impl3330); 
             after(grammarAccess.getResultContributorAccess().getContributorKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__1__Impl"


    // $ANTLR start "rule__ResultContributor__Group__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1696:1: rule__ResultContributor__Group__2 : rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3 ;
    public final void rule__ResultContributor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1700:1: ( rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1701:2: rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__2__Impl_in_rule__ResultContributor__Group__23361);
            rule__ResultContributor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__3_in_rule__ResultContributor__Group__23364);
            rule__ResultContributor__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__2"


    // $ANTLR start "rule__ResultContributor__Group__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1708:1: rule__ResultContributor__Group__2__Impl : ( ( rule__ResultContributor__TargetAssignment_2 ) ) ;
    public final void rule__ResultContributor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1712:1: ( ( ( rule__ResultContributor__TargetAssignment_2 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1713:1: ( ( rule__ResultContributor__TargetAssignment_2 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1713:1: ( ( rule__ResultContributor__TargetAssignment_2 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1714:1: ( rule__ResultContributor__TargetAssignment_2 )
            {
             before(grammarAccess.getResultContributorAccess().getTargetAssignment_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1715:1: ( rule__ResultContributor__TargetAssignment_2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1715:2: rule__ResultContributor__TargetAssignment_2
            {
            pushFollow(FOLLOW_rule__ResultContributor__TargetAssignment_2_in_rule__ResultContributor__Group__2__Impl3391);
            rule__ResultContributor__TargetAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getResultContributorAccess().getTargetAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__2__Impl"


    // $ANTLR start "rule__ResultContributor__Group__3"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1725:1: rule__ResultContributor__Group__3 : rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4 ;
    public final void rule__ResultContributor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1729:1: ( rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1730:2: rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__3__Impl_in_rule__ResultContributor__Group__33421);
            rule__ResultContributor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__4_in_rule__ResultContributor__Group__33424);
            rule__ResultContributor__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__3"


    // $ANTLR start "rule__ResultContributor__Group__3__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1737:1: rule__ResultContributor__Group__3__Impl : ( ( rule__ResultContributor__IssueTypeAssignment_3 ) ) ;
    public final void rule__ResultContributor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1741:1: ( ( ( rule__ResultContributor__IssueTypeAssignment_3 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1742:1: ( ( rule__ResultContributor__IssueTypeAssignment_3 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1742:1: ( ( rule__ResultContributor__IssueTypeAssignment_3 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1743:1: ( rule__ResultContributor__IssueTypeAssignment_3 )
            {
             before(grammarAccess.getResultContributorAccess().getIssueTypeAssignment_3()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1744:1: ( rule__ResultContributor__IssueTypeAssignment_3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1744:2: rule__ResultContributor__IssueTypeAssignment_3
            {
            pushFollow(FOLLOW_rule__ResultContributor__IssueTypeAssignment_3_in_rule__ResultContributor__Group__3__Impl3451);
            rule__ResultContributor__IssueTypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getResultContributorAccess().getIssueTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__3__Impl"


    // $ANTLR start "rule__ResultContributor__Group__4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1754:1: rule__ResultContributor__Group__4 : rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5 ;
    public final void rule__ResultContributor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1758:1: ( rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1759:2: rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__4__Impl_in_rule__ResultContributor__Group__43481);
            rule__ResultContributor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__5_in_rule__ResultContributor__Group__43484);
            rule__ResultContributor__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__4"


    // $ANTLR start "rule__ResultContributor__Group__4__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1766:1: rule__ResultContributor__Group__4__Impl : ( ( rule__ResultContributor__MessageAssignment_4 ) ) ;
    public final void rule__ResultContributor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1770:1: ( ( ( rule__ResultContributor__MessageAssignment_4 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1771:1: ( ( rule__ResultContributor__MessageAssignment_4 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1771:1: ( ( rule__ResultContributor__MessageAssignment_4 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1772:1: ( rule__ResultContributor__MessageAssignment_4 )
            {
             before(grammarAccess.getResultContributorAccess().getMessageAssignment_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1773:1: ( rule__ResultContributor__MessageAssignment_4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1773:2: rule__ResultContributor__MessageAssignment_4
            {
            pushFollow(FOLLOW_rule__ResultContributor__MessageAssignment_4_in_rule__ResultContributor__Group__4__Impl3511);
            rule__ResultContributor__MessageAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getResultContributorAccess().getMessageAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__4__Impl"


    // $ANTLR start "rule__ResultContributor__Group__5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1783:1: rule__ResultContributor__Group__5 : rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6 ;
    public final void rule__ResultContributor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1787:1: ( rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1788:2: rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__5__Impl_in_rule__ResultContributor__Group__53541);
            rule__ResultContributor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__6_in_rule__ResultContributor__Group__53544);
            rule__ResultContributor__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__5"


    // $ANTLR start "rule__ResultContributor__Group__5__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1795:1: rule__ResultContributor__Group__5__Impl : ( ( rule__ResultContributor__Group_5__0 )? ) ;
    public final void rule__ResultContributor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1799:1: ( ( ( rule__ResultContributor__Group_5__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1800:1: ( ( rule__ResultContributor__Group_5__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1800:1: ( ( rule__ResultContributor__Group_5__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1801:1: ( rule__ResultContributor__Group_5__0 )?
            {
             before(grammarAccess.getResultContributorAccess().getGroup_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1802:1: ( rule__ResultContributor__Group_5__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1802:2: rule__ResultContributor__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ResultContributor__Group_5__0_in_rule__ResultContributor__Group__5__Impl3571);
                    rule__ResultContributor__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultContributorAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__5__Impl"


    // $ANTLR start "rule__ResultContributor__Group__6"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1812:1: rule__ResultContributor__Group__6 : rule__ResultContributor__Group__6__Impl rule__ResultContributor__Group__7 ;
    public final void rule__ResultContributor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1816:1: ( rule__ResultContributor__Group__6__Impl rule__ResultContributor__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1817:2: rule__ResultContributor__Group__6__Impl rule__ResultContributor__Group__7
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__6__Impl_in_rule__ResultContributor__Group__63602);
            rule__ResultContributor__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__7_in_rule__ResultContributor__Group__63605);
            rule__ResultContributor__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__6"


    // $ANTLR start "rule__ResultContributor__Group__6__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1824:1: rule__ResultContributor__Group__6__Impl : ( '[' ) ;
    public final void rule__ResultContributor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1828:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1829:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1829:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1830:1: '['
            {
             before(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_6()); 
            match(input,18,FOLLOW_18_in_rule__ResultContributor__Group__6__Impl3633); 
             after(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__6__Impl"


    // $ANTLR start "rule__ResultContributor__Group__7"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1843:1: rule__ResultContributor__Group__7 : rule__ResultContributor__Group__7__Impl rule__ResultContributor__Group__8 ;
    public final void rule__ResultContributor__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1847:1: ( rule__ResultContributor__Group__7__Impl rule__ResultContributor__Group__8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1848:2: rule__ResultContributor__Group__7__Impl rule__ResultContributor__Group__8
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__7__Impl_in_rule__ResultContributor__Group__73664);
            rule__ResultContributor__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__8_in_rule__ResultContributor__Group__73667);
            rule__ResultContributor__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__7"


    // $ANTLR start "rule__ResultContributor__Group__7__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1855:1: rule__ResultContributor__Group__7__Impl : ( 'data' ) ;
    public final void rule__ResultContributor__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1859:1: ( ( 'data' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1860:1: ( 'data' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1860:1: ( 'data' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1861:1: 'data'
            {
             before(grammarAccess.getResultContributorAccess().getDataKeyword_7()); 
            match(input,28,FOLLOW_28_in_rule__ResultContributor__Group__7__Impl3695); 
             after(grammarAccess.getResultContributorAccess().getDataKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__7__Impl"


    // $ANTLR start "rule__ResultContributor__Group__8"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1874:1: rule__ResultContributor__Group__8 : rule__ResultContributor__Group__8__Impl rule__ResultContributor__Group__9 ;
    public final void rule__ResultContributor__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1878:1: ( rule__ResultContributor__Group__8__Impl rule__ResultContributor__Group__9 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1879:2: rule__ResultContributor__Group__8__Impl rule__ResultContributor__Group__9
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__8__Impl_in_rule__ResultContributor__Group__83726);
            rule__ResultContributor__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__9_in_rule__ResultContributor__Group__83729);
            rule__ResultContributor__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__8"


    // $ANTLR start "rule__ResultContributor__Group__8__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1886:1: rule__ResultContributor__Group__8__Impl : ( ( ( rule__ResultContributor__CellAssignment_8 ) ) ( ( rule__ResultContributor__CellAssignment_8 )* ) ) ;
    public final void rule__ResultContributor__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1890:1: ( ( ( ( rule__ResultContributor__CellAssignment_8 ) ) ( ( rule__ResultContributor__CellAssignment_8 )* ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1891:1: ( ( ( rule__ResultContributor__CellAssignment_8 ) ) ( ( rule__ResultContributor__CellAssignment_8 )* ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1891:1: ( ( ( rule__ResultContributor__CellAssignment_8 ) ) ( ( rule__ResultContributor__CellAssignment_8 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1892:1: ( ( rule__ResultContributor__CellAssignment_8 ) ) ( ( rule__ResultContributor__CellAssignment_8 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1892:1: ( ( rule__ResultContributor__CellAssignment_8 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1893:1: ( rule__ResultContributor__CellAssignment_8 )
            {
             before(grammarAccess.getResultContributorAccess().getCellAssignment_8()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1894:1: ( rule__ResultContributor__CellAssignment_8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1894:2: rule__ResultContributor__CellAssignment_8
            {
            pushFollow(FOLLOW_rule__ResultContributor__CellAssignment_8_in_rule__ResultContributor__Group__8__Impl3758);
            rule__ResultContributor__CellAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getResultContributorAccess().getCellAssignment_8()); 

            }

            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1897:1: ( ( rule__ResultContributor__CellAssignment_8 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1898:1: ( rule__ResultContributor__CellAssignment_8 )*
            {
             before(grammarAccess.getResultContributorAccess().getCellAssignment_8()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1899:1: ( rule__ResultContributor__CellAssignment_8 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_STRING) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1899:2: rule__ResultContributor__CellAssignment_8
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__CellAssignment_8_in_rule__ResultContributor__Group__8__Impl3770);
            	    rule__ResultContributor__CellAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getResultContributorAccess().getCellAssignment_8()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__8__Impl"


    // $ANTLR start "rule__ResultContributor__Group__9"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1910:1: rule__ResultContributor__Group__9 : rule__ResultContributor__Group__9__Impl rule__ResultContributor__Group__10 ;
    public final void rule__ResultContributor__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1914:1: ( rule__ResultContributor__Group__9__Impl rule__ResultContributor__Group__10 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1915:2: rule__ResultContributor__Group__9__Impl rule__ResultContributor__Group__10
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__9__Impl_in_rule__ResultContributor__Group__93803);
            rule__ResultContributor__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__10_in_rule__ResultContributor__Group__93806);
            rule__ResultContributor__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__9"


    // $ANTLR start "rule__ResultContributor__Group__9__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1922:1: rule__ResultContributor__Group__9__Impl : ( ( rule__ResultContributor__IssuesAssignment_9 )* ) ;
    public final void rule__ResultContributor__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1926:1: ( ( ( rule__ResultContributor__IssuesAssignment_9 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1927:1: ( ( rule__ResultContributor__IssuesAssignment_9 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1927:1: ( ( rule__ResultContributor__IssuesAssignment_9 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1928:1: ( rule__ResultContributor__IssuesAssignment_9 )*
            {
             before(grammarAccess.getResultContributorAccess().getIssuesAssignment_9()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1929:1: ( rule__ResultContributor__IssuesAssignment_9 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==30) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1929:2: rule__ResultContributor__IssuesAssignment_9
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__IssuesAssignment_9_in_rule__ResultContributor__Group__9__Impl3833);
            	    rule__ResultContributor__IssuesAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getResultContributorAccess().getIssuesAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__9__Impl"


    // $ANTLR start "rule__ResultContributor__Group__10"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1939:1: rule__ResultContributor__Group__10 : rule__ResultContributor__Group__10__Impl rule__ResultContributor__Group__11 ;
    public final void rule__ResultContributor__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1943:1: ( rule__ResultContributor__Group__10__Impl rule__ResultContributor__Group__11 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1944:2: rule__ResultContributor__Group__10__Impl rule__ResultContributor__Group__11
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__10__Impl_in_rule__ResultContributor__Group__103864);
            rule__ResultContributor__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__11_in_rule__ResultContributor__Group__103867);
            rule__ResultContributor__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__10"


    // $ANTLR start "rule__ResultContributor__Group__10__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1951:1: rule__ResultContributor__Group__10__Impl : ( ( rule__ResultContributor__SubcontributorAssignment_10 )* ) ;
    public final void rule__ResultContributor__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1955:1: ( ( ( rule__ResultContributor__SubcontributorAssignment_10 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1956:1: ( ( rule__ResultContributor__SubcontributorAssignment_10 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1956:1: ( ( rule__ResultContributor__SubcontributorAssignment_10 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1957:1: ( rule__ResultContributor__SubcontributorAssignment_10 )*
            {
             before(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_10()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1958:1: ( rule__ResultContributor__SubcontributorAssignment_10 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==27) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1958:2: rule__ResultContributor__SubcontributorAssignment_10
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__SubcontributorAssignment_10_in_rule__ResultContributor__Group__10__Impl3894);
            	    rule__ResultContributor__SubcontributorAssignment_10();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__10__Impl"


    // $ANTLR start "rule__ResultContributor__Group__11"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1968:1: rule__ResultContributor__Group__11 : rule__ResultContributor__Group__11__Impl ;
    public final void rule__ResultContributor__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1972:1: ( rule__ResultContributor__Group__11__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1973:2: rule__ResultContributor__Group__11__Impl
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__11__Impl_in_rule__ResultContributor__Group__113925);
            rule__ResultContributor__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__11"


    // $ANTLR start "rule__ResultContributor__Group__11__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1979:1: rule__ResultContributor__Group__11__Impl : ( ']' ) ;
    public final void rule__ResultContributor__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1983:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1984:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1984:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1985:1: ']'
            {
             before(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_11()); 
            match(input,20,FOLLOW_20_in_rule__ResultContributor__Group__11__Impl3953); 
             after(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group__11__Impl"


    // $ANTLR start "rule__ResultContributor__Group_5__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2022:1: rule__ResultContributor__Group_5__0 : rule__ResultContributor__Group_5__0__Impl rule__ResultContributor__Group_5__1 ;
    public final void rule__ResultContributor__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2026:1: ( rule__ResultContributor__Group_5__0__Impl rule__ResultContributor__Group_5__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2027:2: rule__ResultContributor__Group_5__0__Impl rule__ResultContributor__Group_5__1
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group_5__0__Impl_in_rule__ResultContributor__Group_5__04008);
            rule__ResultContributor__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group_5__1_in_rule__ResultContributor__Group_5__04011);
            rule__ResultContributor__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group_5__0"


    // $ANTLR start "rule__ResultContributor__Group_5__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2034:1: rule__ResultContributor__Group_5__0__Impl : ( 'exception' ) ;
    public final void rule__ResultContributor__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2038:1: ( ( 'exception' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2039:1: ( 'exception' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2039:1: ( 'exception' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2040:1: 'exception'
            {
             before(grammarAccess.getResultContributorAccess().getExceptionKeyword_5_0()); 
            match(input,24,FOLLOW_24_in_rule__ResultContributor__Group_5__0__Impl4039); 
             after(grammarAccess.getResultContributorAccess().getExceptionKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group_5__0__Impl"


    // $ANTLR start "rule__ResultContributor__Group_5__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2053:1: rule__ResultContributor__Group_5__1 : rule__ResultContributor__Group_5__1__Impl ;
    public final void rule__ResultContributor__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2057:1: ( rule__ResultContributor__Group_5__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2058:2: rule__ResultContributor__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group_5__1__Impl_in_rule__ResultContributor__Group_5__14070);
            rule__ResultContributor__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group_5__1"


    // $ANTLR start "rule__ResultContributor__Group_5__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2064:1: rule__ResultContributor__Group_5__1__Impl : ( ( rule__ResultContributor__ExceptionTypeAssignment_5_1 ) ) ;
    public final void rule__ResultContributor__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2068:1: ( ( ( rule__ResultContributor__ExceptionTypeAssignment_5_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2069:1: ( ( rule__ResultContributor__ExceptionTypeAssignment_5_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2069:1: ( ( rule__ResultContributor__ExceptionTypeAssignment_5_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2070:1: ( rule__ResultContributor__ExceptionTypeAssignment_5_1 )
            {
             before(grammarAccess.getResultContributorAccess().getExceptionTypeAssignment_5_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2071:1: ( rule__ResultContributor__ExceptionTypeAssignment_5_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2071:2: rule__ResultContributor__ExceptionTypeAssignment_5_1
            {
            pushFollow(FOLLOW_rule__ResultContributor__ExceptionTypeAssignment_5_1_in_rule__ResultContributor__Group_5__1__Impl4097);
            rule__ResultContributor__ExceptionTypeAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getResultContributorAccess().getExceptionTypeAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group_5__1__Impl"


    // $ANTLR start "rule__IssueReport__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2085:1: rule__IssueReport__Group__0 : rule__IssueReport__Group__0__Impl rule__IssueReport__Group__1 ;
    public final void rule__IssueReport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2089:1: ( rule__IssueReport__Group__0__Impl rule__IssueReport__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2090:2: rule__IssueReport__Group__0__Impl rule__IssueReport__Group__1
            {
            pushFollow(FOLLOW_rule__IssueReport__Group__0__Impl_in_rule__IssueReport__Group__04131);
            rule__IssueReport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssueReport__Group__1_in_rule__IssueReport__Group__04134);
            rule__IssueReport__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__0"


    // $ANTLR start "rule__IssueReport__Group__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2097:1: rule__IssueReport__Group__0__Impl : ( () ) ;
    public final void rule__IssueReport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2101:1: ( ( () ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2102:1: ( () )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2102:1: ( () )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2103:1: ()
            {
             before(grammarAccess.getIssueReportAccess().getIssueReportAction_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2104:1: ()
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2106:1: 
            {
            }

             after(grammarAccess.getIssueReportAccess().getIssueReportAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__0__Impl"


    // $ANTLR start "rule__IssueReport__Group__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2116:1: rule__IssueReport__Group__1 : rule__IssueReport__Group__1__Impl rule__IssueReport__Group__2 ;
    public final void rule__IssueReport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2120:1: ( rule__IssueReport__Group__1__Impl rule__IssueReport__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2121:2: rule__IssueReport__Group__1__Impl rule__IssueReport__Group__2
            {
            pushFollow(FOLLOW_rule__IssueReport__Group__1__Impl_in_rule__IssueReport__Group__14192);
            rule__IssueReport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssueReport__Group__2_in_rule__IssueReport__Group__14195);
            rule__IssueReport__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__1"


    // $ANTLR start "rule__IssueReport__Group__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2128:1: rule__IssueReport__Group__1__Impl : ( 'issues' ) ;
    public final void rule__IssueReport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2132:1: ( ( 'issues' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2133:1: ( 'issues' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2133:1: ( 'issues' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2134:1: 'issues'
            {
             before(grammarAccess.getIssueReportAccess().getIssuesKeyword_1()); 
            match(input,29,FOLLOW_29_in_rule__IssueReport__Group__1__Impl4223); 
             after(grammarAccess.getIssueReportAccess().getIssuesKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__1__Impl"


    // $ANTLR start "rule__IssueReport__Group__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2147:1: rule__IssueReport__Group__2 : rule__IssueReport__Group__2__Impl rule__IssueReport__Group__3 ;
    public final void rule__IssueReport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2151:1: ( rule__IssueReport__Group__2__Impl rule__IssueReport__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2152:2: rule__IssueReport__Group__2__Impl rule__IssueReport__Group__3
            {
            pushFollow(FOLLOW_rule__IssueReport__Group__2__Impl_in_rule__IssueReport__Group__24254);
            rule__IssueReport__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssueReport__Group__3_in_rule__IssueReport__Group__24257);
            rule__IssueReport__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__2"


    // $ANTLR start "rule__IssueReport__Group__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2159:1: rule__IssueReport__Group__2__Impl : ( ( rule__IssueReport__IssueTypeAssignment_2 ) ) ;
    public final void rule__IssueReport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2163:1: ( ( ( rule__IssueReport__IssueTypeAssignment_2 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2164:1: ( ( rule__IssueReport__IssueTypeAssignment_2 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2164:1: ( ( rule__IssueReport__IssueTypeAssignment_2 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2165:1: ( rule__IssueReport__IssueTypeAssignment_2 )
            {
             before(grammarAccess.getIssueReportAccess().getIssueTypeAssignment_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2166:1: ( rule__IssueReport__IssueTypeAssignment_2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2166:2: rule__IssueReport__IssueTypeAssignment_2
            {
            pushFollow(FOLLOW_rule__IssueReport__IssueTypeAssignment_2_in_rule__IssueReport__Group__2__Impl4284);
            rule__IssueReport__IssueTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIssueReportAccess().getIssueTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__2__Impl"


    // $ANTLR start "rule__IssueReport__Group__3"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2176:1: rule__IssueReport__Group__3 : rule__IssueReport__Group__3__Impl rule__IssueReport__Group__4 ;
    public final void rule__IssueReport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2180:1: ( rule__IssueReport__Group__3__Impl rule__IssueReport__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2181:2: rule__IssueReport__Group__3__Impl rule__IssueReport__Group__4
            {
            pushFollow(FOLLOW_rule__IssueReport__Group__3__Impl_in_rule__IssueReport__Group__34314);
            rule__IssueReport__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssueReport__Group__4_in_rule__IssueReport__Group__34317);
            rule__IssueReport__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__3"


    // $ANTLR start "rule__IssueReport__Group__3__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2188:1: rule__IssueReport__Group__3__Impl : ( ( rule__IssueReport__MessageAssignment_3 ) ) ;
    public final void rule__IssueReport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2192:1: ( ( ( rule__IssueReport__MessageAssignment_3 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2193:1: ( ( rule__IssueReport__MessageAssignment_3 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2193:1: ( ( rule__IssueReport__MessageAssignment_3 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2194:1: ( rule__IssueReport__MessageAssignment_3 )
            {
             before(grammarAccess.getIssueReportAccess().getMessageAssignment_3()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2195:1: ( rule__IssueReport__MessageAssignment_3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2195:2: rule__IssueReport__MessageAssignment_3
            {
            pushFollow(FOLLOW_rule__IssueReport__MessageAssignment_3_in_rule__IssueReport__Group__3__Impl4344);
            rule__IssueReport__MessageAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIssueReportAccess().getMessageAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__3__Impl"


    // $ANTLR start "rule__IssueReport__Group__4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2205:1: rule__IssueReport__Group__4 : rule__IssueReport__Group__4__Impl rule__IssueReport__Group__5 ;
    public final void rule__IssueReport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2209:1: ( rule__IssueReport__Group__4__Impl rule__IssueReport__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2210:2: rule__IssueReport__Group__4__Impl rule__IssueReport__Group__5
            {
            pushFollow(FOLLOW_rule__IssueReport__Group__4__Impl_in_rule__IssueReport__Group__44374);
            rule__IssueReport__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssueReport__Group__5_in_rule__IssueReport__Group__44377);
            rule__IssueReport__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__4"


    // $ANTLR start "rule__IssueReport__Group__4__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2217:1: rule__IssueReport__Group__4__Impl : ( ( rule__IssueReport__Group_4__0 )? ) ;
    public final void rule__IssueReport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2221:1: ( ( ( rule__IssueReport__Group_4__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2222:1: ( ( rule__IssueReport__Group_4__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2222:1: ( ( rule__IssueReport__Group_4__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2223:1: ( rule__IssueReport__Group_4__0 )?
            {
             before(grammarAccess.getIssueReportAccess().getGroup_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2224:1: ( rule__IssueReport__Group_4__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==19) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2224:2: rule__IssueReport__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__IssueReport__Group_4__0_in_rule__IssueReport__Group__4__Impl4404);
                    rule__IssueReport__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIssueReportAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__4__Impl"


    // $ANTLR start "rule__IssueReport__Group__5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2234:1: rule__IssueReport__Group__5 : rule__IssueReport__Group__5__Impl rule__IssueReport__Group__6 ;
    public final void rule__IssueReport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2238:1: ( rule__IssueReport__Group__5__Impl rule__IssueReport__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2239:2: rule__IssueReport__Group__5__Impl rule__IssueReport__Group__6
            {
            pushFollow(FOLLOW_rule__IssueReport__Group__5__Impl_in_rule__IssueReport__Group__54435);
            rule__IssueReport__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssueReport__Group__6_in_rule__IssueReport__Group__54438);
            rule__IssueReport__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__5"


    // $ANTLR start "rule__IssueReport__Group__5__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2246:1: rule__IssueReport__Group__5__Impl : ( ( rule__IssueReport__Group_5__0 )? ) ;
    public final void rule__IssueReport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2250:1: ( ( ( rule__IssueReport__Group_5__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2251:1: ( ( rule__IssueReport__Group_5__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2251:1: ( ( rule__IssueReport__Group_5__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2252:1: ( rule__IssueReport__Group_5__0 )?
            {
             before(grammarAccess.getIssueReportAccess().getGroup_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2253:1: ( rule__IssueReport__Group_5__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==24) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2253:2: rule__IssueReport__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__IssueReport__Group_5__0_in_rule__IssueReport__Group__5__Impl4465);
                    rule__IssueReport__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIssueReportAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__5__Impl"


    // $ANTLR start "rule__IssueReport__Group__6"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2263:1: rule__IssueReport__Group__6 : rule__IssueReport__Group__6__Impl ;
    public final void rule__IssueReport__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2267:1: ( rule__IssueReport__Group__6__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2268:2: rule__IssueReport__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__IssueReport__Group__6__Impl_in_rule__IssueReport__Group__64496);
            rule__IssueReport__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__6"


    // $ANTLR start "rule__IssueReport__Group__6__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2274:1: rule__IssueReport__Group__6__Impl : ( ( rule__IssueReport__Group_6__0 )? ) ;
    public final void rule__IssueReport__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2278:1: ( ( ( rule__IssueReport__Group_6__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2279:1: ( ( rule__IssueReport__Group_6__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2279:1: ( ( rule__IssueReport__Group_6__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2280:1: ( rule__IssueReport__Group_6__0 )?
            {
             before(grammarAccess.getIssueReportAccess().getGroup_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2281:1: ( rule__IssueReport__Group_6__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==18) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2281:2: rule__IssueReport__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__IssueReport__Group_6__0_in_rule__IssueReport__Group__6__Impl4523);
                    rule__IssueReport__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIssueReportAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group__6__Impl"


    // $ANTLR start "rule__IssueReport__Group_4__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2305:1: rule__IssueReport__Group_4__0 : rule__IssueReport__Group_4__0__Impl rule__IssueReport__Group_4__1 ;
    public final void rule__IssueReport__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2309:1: ( rule__IssueReport__Group_4__0__Impl rule__IssueReport__Group_4__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2310:2: rule__IssueReport__Group_4__0__Impl rule__IssueReport__Group_4__1
            {
            pushFollow(FOLLOW_rule__IssueReport__Group_4__0__Impl_in_rule__IssueReport__Group_4__04568);
            rule__IssueReport__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssueReport__Group_4__1_in_rule__IssueReport__Group_4__04571);
            rule__IssueReport__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_4__0"


    // $ANTLR start "rule__IssueReport__Group_4__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2317:1: rule__IssueReport__Group_4__0__Impl : ( 'target' ) ;
    public final void rule__IssueReport__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2321:1: ( ( 'target' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2322:1: ( 'target' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2322:1: ( 'target' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2323:1: 'target'
            {
             before(grammarAccess.getIssueReportAccess().getTargetKeyword_4_0()); 
            match(input,19,FOLLOW_19_in_rule__IssueReport__Group_4__0__Impl4599); 
             after(grammarAccess.getIssueReportAccess().getTargetKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_4__0__Impl"


    // $ANTLR start "rule__IssueReport__Group_4__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2336:1: rule__IssueReport__Group_4__1 : rule__IssueReport__Group_4__1__Impl ;
    public final void rule__IssueReport__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2340:1: ( rule__IssueReport__Group_4__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2341:2: rule__IssueReport__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__IssueReport__Group_4__1__Impl_in_rule__IssueReport__Group_4__14630);
            rule__IssueReport__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_4__1"


    // $ANTLR start "rule__IssueReport__Group_4__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2347:1: rule__IssueReport__Group_4__1__Impl : ( ( rule__IssueReport__TargetAssignment_4_1 ) ) ;
    public final void rule__IssueReport__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2351:1: ( ( ( rule__IssueReport__TargetAssignment_4_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2352:1: ( ( rule__IssueReport__TargetAssignment_4_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2352:1: ( ( rule__IssueReport__TargetAssignment_4_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2353:1: ( rule__IssueReport__TargetAssignment_4_1 )
            {
             before(grammarAccess.getIssueReportAccess().getTargetAssignment_4_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2354:1: ( rule__IssueReport__TargetAssignment_4_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2354:2: rule__IssueReport__TargetAssignment_4_1
            {
            pushFollow(FOLLOW_rule__IssueReport__TargetAssignment_4_1_in_rule__IssueReport__Group_4__1__Impl4657);
            rule__IssueReport__TargetAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getIssueReportAccess().getTargetAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_4__1__Impl"


    // $ANTLR start "rule__IssueReport__Group_5__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2368:1: rule__IssueReport__Group_5__0 : rule__IssueReport__Group_5__0__Impl rule__IssueReport__Group_5__1 ;
    public final void rule__IssueReport__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2372:1: ( rule__IssueReport__Group_5__0__Impl rule__IssueReport__Group_5__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2373:2: rule__IssueReport__Group_5__0__Impl rule__IssueReport__Group_5__1
            {
            pushFollow(FOLLOW_rule__IssueReport__Group_5__0__Impl_in_rule__IssueReport__Group_5__04691);
            rule__IssueReport__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssueReport__Group_5__1_in_rule__IssueReport__Group_5__04694);
            rule__IssueReport__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_5__0"


    // $ANTLR start "rule__IssueReport__Group_5__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2380:1: rule__IssueReport__Group_5__0__Impl : ( 'exception' ) ;
    public final void rule__IssueReport__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2384:1: ( ( 'exception' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2385:1: ( 'exception' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2385:1: ( 'exception' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2386:1: 'exception'
            {
             before(grammarAccess.getIssueReportAccess().getExceptionKeyword_5_0()); 
            match(input,24,FOLLOW_24_in_rule__IssueReport__Group_5__0__Impl4722); 
             after(grammarAccess.getIssueReportAccess().getExceptionKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_5__0__Impl"


    // $ANTLR start "rule__IssueReport__Group_5__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2399:1: rule__IssueReport__Group_5__1 : rule__IssueReport__Group_5__1__Impl ;
    public final void rule__IssueReport__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2403:1: ( rule__IssueReport__Group_5__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2404:2: rule__IssueReport__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__IssueReport__Group_5__1__Impl_in_rule__IssueReport__Group_5__14753);
            rule__IssueReport__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_5__1"


    // $ANTLR start "rule__IssueReport__Group_5__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2410:1: rule__IssueReport__Group_5__1__Impl : ( ( rule__IssueReport__ExceptionTypeAssignment_5_1 ) ) ;
    public final void rule__IssueReport__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2414:1: ( ( ( rule__IssueReport__ExceptionTypeAssignment_5_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2415:1: ( ( rule__IssueReport__ExceptionTypeAssignment_5_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2415:1: ( ( rule__IssueReport__ExceptionTypeAssignment_5_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2416:1: ( rule__IssueReport__ExceptionTypeAssignment_5_1 )
            {
             before(grammarAccess.getIssueReportAccess().getExceptionTypeAssignment_5_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2417:1: ( rule__IssueReport__ExceptionTypeAssignment_5_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2417:2: rule__IssueReport__ExceptionTypeAssignment_5_1
            {
            pushFollow(FOLLOW_rule__IssueReport__ExceptionTypeAssignment_5_1_in_rule__IssueReport__Group_5__1__Impl4780);
            rule__IssueReport__ExceptionTypeAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getIssueReportAccess().getExceptionTypeAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_5__1__Impl"


    // $ANTLR start "rule__IssueReport__Group_6__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2431:1: rule__IssueReport__Group_6__0 : rule__IssueReport__Group_6__0__Impl rule__IssueReport__Group_6__1 ;
    public final void rule__IssueReport__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2435:1: ( rule__IssueReport__Group_6__0__Impl rule__IssueReport__Group_6__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2436:2: rule__IssueReport__Group_6__0__Impl rule__IssueReport__Group_6__1
            {
            pushFollow(FOLLOW_rule__IssueReport__Group_6__0__Impl_in_rule__IssueReport__Group_6__04814);
            rule__IssueReport__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssueReport__Group_6__1_in_rule__IssueReport__Group_6__04817);
            rule__IssueReport__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_6__0"


    // $ANTLR start "rule__IssueReport__Group_6__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2443:1: rule__IssueReport__Group_6__0__Impl : ( '[' ) ;
    public final void rule__IssueReport__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2447:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2448:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2448:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2449:1: '['
            {
             before(grammarAccess.getIssueReportAccess().getLeftSquareBracketKeyword_6_0()); 
            match(input,18,FOLLOW_18_in_rule__IssueReport__Group_6__0__Impl4845); 
             after(grammarAccess.getIssueReportAccess().getLeftSquareBracketKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_6__0__Impl"


    // $ANTLR start "rule__IssueReport__Group_6__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2462:1: rule__IssueReport__Group_6__1 : rule__IssueReport__Group_6__1__Impl rule__IssueReport__Group_6__2 ;
    public final void rule__IssueReport__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2466:1: ( rule__IssueReport__Group_6__1__Impl rule__IssueReport__Group_6__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2467:2: rule__IssueReport__Group_6__1__Impl rule__IssueReport__Group_6__2
            {
            pushFollow(FOLLOW_rule__IssueReport__Group_6__1__Impl_in_rule__IssueReport__Group_6__14876);
            rule__IssueReport__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssueReport__Group_6__2_in_rule__IssueReport__Group_6__14879);
            rule__IssueReport__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_6__1"


    // $ANTLR start "rule__IssueReport__Group_6__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2474:1: rule__IssueReport__Group_6__1__Impl : ( ( rule__IssueReport__IssuesAssignment_6_1 )* ) ;
    public final void rule__IssueReport__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2478:1: ( ( ( rule__IssueReport__IssuesAssignment_6_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2479:1: ( ( rule__IssueReport__IssuesAssignment_6_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2479:1: ( ( rule__IssueReport__IssuesAssignment_6_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2480:1: ( rule__IssueReport__IssuesAssignment_6_1 )*
            {
             before(grammarAccess.getIssueReportAccess().getIssuesAssignment_6_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2481:1: ( rule__IssueReport__IssuesAssignment_6_1 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==30) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2481:2: rule__IssueReport__IssuesAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_rule__IssueReport__IssuesAssignment_6_1_in_rule__IssueReport__Group_6__1__Impl4906);
            	    rule__IssueReport__IssuesAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getIssueReportAccess().getIssuesAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_6__1__Impl"


    // $ANTLR start "rule__IssueReport__Group_6__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2491:1: rule__IssueReport__Group_6__2 : rule__IssueReport__Group_6__2__Impl ;
    public final void rule__IssueReport__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2495:1: ( rule__IssueReport__Group_6__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2496:2: rule__IssueReport__Group_6__2__Impl
            {
            pushFollow(FOLLOW_rule__IssueReport__Group_6__2__Impl_in_rule__IssueReport__Group_6__24937);
            rule__IssueReport__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_6__2"


    // $ANTLR start "rule__IssueReport__Group_6__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2502:1: rule__IssueReport__Group_6__2__Impl : ( ']' ) ;
    public final void rule__IssueReport__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2506:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2507:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2507:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2508:1: ']'
            {
             before(grammarAccess.getIssueReportAccess().getRightSquareBracketKeyword_6_2()); 
            match(input,20,FOLLOW_20_in_rule__IssueReport__Group_6__2__Impl4965); 
             after(grammarAccess.getIssueReportAccess().getRightSquareBracketKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__Group_6__2__Impl"


    // $ANTLR start "rule__ResultIssue__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2527:1: rule__ResultIssue__Group__0 : rule__ResultIssue__Group__0__Impl rule__ResultIssue__Group__1 ;
    public final void rule__ResultIssue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2531:1: ( rule__ResultIssue__Group__0__Impl rule__ResultIssue__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2532:2: rule__ResultIssue__Group__0__Impl rule__ResultIssue__Group__1
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__0__Impl_in_rule__ResultIssue__Group__05002);
            rule__ResultIssue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group__1_in_rule__ResultIssue__Group__05005);
            rule__ResultIssue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__0"


    // $ANTLR start "rule__ResultIssue__Group__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2539:1: rule__ResultIssue__Group__0__Impl : ( 'issue' ) ;
    public final void rule__ResultIssue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2543:1: ( ( 'issue' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2544:1: ( 'issue' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2544:1: ( 'issue' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2545:1: 'issue'
            {
             before(grammarAccess.getResultIssueAccess().getIssueKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__ResultIssue__Group__0__Impl5033); 
             after(grammarAccess.getResultIssueAccess().getIssueKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__0__Impl"


    // $ANTLR start "rule__ResultIssue__Group__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2558:1: rule__ResultIssue__Group__1 : rule__ResultIssue__Group__1__Impl rule__ResultIssue__Group__2 ;
    public final void rule__ResultIssue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2562:1: ( rule__ResultIssue__Group__1__Impl rule__ResultIssue__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2563:2: rule__ResultIssue__Group__1__Impl rule__ResultIssue__Group__2
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__1__Impl_in_rule__ResultIssue__Group__15064);
            rule__ResultIssue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group__2_in_rule__ResultIssue__Group__15067);
            rule__ResultIssue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__1"


    // $ANTLR start "rule__ResultIssue__Group__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2570:1: rule__ResultIssue__Group__1__Impl : ( ( rule__ResultIssue__IssueTypeAssignment_1 ) ) ;
    public final void rule__ResultIssue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2574:1: ( ( ( rule__ResultIssue__IssueTypeAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2575:1: ( ( rule__ResultIssue__IssueTypeAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2575:1: ( ( rule__ResultIssue__IssueTypeAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2576:1: ( rule__ResultIssue__IssueTypeAssignment_1 )
            {
             before(grammarAccess.getResultIssueAccess().getIssueTypeAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2577:1: ( rule__ResultIssue__IssueTypeAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2577:2: rule__ResultIssue__IssueTypeAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultIssue__IssueTypeAssignment_1_in_rule__ResultIssue__Group__1__Impl5094);
            rule__ResultIssue__IssueTypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getResultIssueAccess().getIssueTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__1__Impl"


    // $ANTLR start "rule__ResultIssue__Group__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2587:1: rule__ResultIssue__Group__2 : rule__ResultIssue__Group__2__Impl rule__ResultIssue__Group__3 ;
    public final void rule__ResultIssue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2591:1: ( rule__ResultIssue__Group__2__Impl rule__ResultIssue__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2592:2: rule__ResultIssue__Group__2__Impl rule__ResultIssue__Group__3
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__2__Impl_in_rule__ResultIssue__Group__25124);
            rule__ResultIssue__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group__3_in_rule__ResultIssue__Group__25127);
            rule__ResultIssue__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__2"


    // $ANTLR start "rule__ResultIssue__Group__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2599:1: rule__ResultIssue__Group__2__Impl : ( ( rule__ResultIssue__MessageAssignment_2 ) ) ;
    public final void rule__ResultIssue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2603:1: ( ( ( rule__ResultIssue__MessageAssignment_2 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2604:1: ( ( rule__ResultIssue__MessageAssignment_2 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2604:1: ( ( rule__ResultIssue__MessageAssignment_2 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2605:1: ( rule__ResultIssue__MessageAssignment_2 )
            {
             before(grammarAccess.getResultIssueAccess().getMessageAssignment_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2606:1: ( rule__ResultIssue__MessageAssignment_2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2606:2: rule__ResultIssue__MessageAssignment_2
            {
            pushFollow(FOLLOW_rule__ResultIssue__MessageAssignment_2_in_rule__ResultIssue__Group__2__Impl5154);
            rule__ResultIssue__MessageAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getResultIssueAccess().getMessageAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__2__Impl"


    // $ANTLR start "rule__ResultIssue__Group__3"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2616:1: rule__ResultIssue__Group__3 : rule__ResultIssue__Group__3__Impl rule__ResultIssue__Group__4 ;
    public final void rule__ResultIssue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2620:1: ( rule__ResultIssue__Group__3__Impl rule__ResultIssue__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2621:2: rule__ResultIssue__Group__3__Impl rule__ResultIssue__Group__4
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__3__Impl_in_rule__ResultIssue__Group__35184);
            rule__ResultIssue__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group__4_in_rule__ResultIssue__Group__35187);
            rule__ResultIssue__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__3"


    // $ANTLR start "rule__ResultIssue__Group__3__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2628:1: rule__ResultIssue__Group__3__Impl : ( ( rule__ResultIssue__Group_3__0 )? ) ;
    public final void rule__ResultIssue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2632:1: ( ( ( rule__ResultIssue__Group_3__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2633:1: ( ( rule__ResultIssue__Group_3__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2633:1: ( ( rule__ResultIssue__Group_3__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2634:1: ( rule__ResultIssue__Group_3__0 )?
            {
             before(grammarAccess.getResultIssueAccess().getGroup_3()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2635:1: ( rule__ResultIssue__Group_3__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==19) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2635:2: rule__ResultIssue__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ResultIssue__Group_3__0_in_rule__ResultIssue__Group__3__Impl5214);
                    rule__ResultIssue__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultIssueAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__3__Impl"


    // $ANTLR start "rule__ResultIssue__Group__4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2645:1: rule__ResultIssue__Group__4 : rule__ResultIssue__Group__4__Impl rule__ResultIssue__Group__5 ;
    public final void rule__ResultIssue__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2649:1: ( rule__ResultIssue__Group__4__Impl rule__ResultIssue__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2650:2: rule__ResultIssue__Group__4__Impl rule__ResultIssue__Group__5
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__4__Impl_in_rule__ResultIssue__Group__45245);
            rule__ResultIssue__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group__5_in_rule__ResultIssue__Group__45248);
            rule__ResultIssue__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__4"


    // $ANTLR start "rule__ResultIssue__Group__4__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2657:1: rule__ResultIssue__Group__4__Impl : ( ( rule__ResultIssue__Group_4__0 )? ) ;
    public final void rule__ResultIssue__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2661:1: ( ( ( rule__ResultIssue__Group_4__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2662:1: ( ( rule__ResultIssue__Group_4__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2662:1: ( ( rule__ResultIssue__Group_4__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2663:1: ( rule__ResultIssue__Group_4__0 )?
            {
             before(grammarAccess.getResultIssueAccess().getGroup_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2664:1: ( rule__ResultIssue__Group_4__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==24) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2664:2: rule__ResultIssue__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__ResultIssue__Group_4__0_in_rule__ResultIssue__Group__4__Impl5275);
                    rule__ResultIssue__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultIssueAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__4__Impl"


    // $ANTLR start "rule__ResultIssue__Group__5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2674:1: rule__ResultIssue__Group__5 : rule__ResultIssue__Group__5__Impl ;
    public final void rule__ResultIssue__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2678:1: ( rule__ResultIssue__Group__5__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2679:2: rule__ResultIssue__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__5__Impl_in_rule__ResultIssue__Group__55306);
            rule__ResultIssue__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__5"


    // $ANTLR start "rule__ResultIssue__Group__5__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2685:1: rule__ResultIssue__Group__5__Impl : ( ( rule__ResultIssue__Group_5__0 )? ) ;
    public final void rule__ResultIssue__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2689:1: ( ( ( rule__ResultIssue__Group_5__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2690:1: ( ( rule__ResultIssue__Group_5__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2690:1: ( ( rule__ResultIssue__Group_5__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2691:1: ( rule__ResultIssue__Group_5__0 )?
            {
             before(grammarAccess.getResultIssueAccess().getGroup_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2692:1: ( rule__ResultIssue__Group_5__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==18) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2692:2: rule__ResultIssue__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ResultIssue__Group_5__0_in_rule__ResultIssue__Group__5__Impl5333);
                    rule__ResultIssue__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultIssueAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group__5__Impl"


    // $ANTLR start "rule__ResultIssue__Group_3__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2714:1: rule__ResultIssue__Group_3__0 : rule__ResultIssue__Group_3__0__Impl rule__ResultIssue__Group_3__1 ;
    public final void rule__ResultIssue__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2718:1: ( rule__ResultIssue__Group_3__0__Impl rule__ResultIssue__Group_3__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2719:2: rule__ResultIssue__Group_3__0__Impl rule__ResultIssue__Group_3__1
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_3__0__Impl_in_rule__ResultIssue__Group_3__05376);
            rule__ResultIssue__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group_3__1_in_rule__ResultIssue__Group_3__05379);
            rule__ResultIssue__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_3__0"


    // $ANTLR start "rule__ResultIssue__Group_3__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2726:1: rule__ResultIssue__Group_3__0__Impl : ( 'target' ) ;
    public final void rule__ResultIssue__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2730:1: ( ( 'target' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2731:1: ( 'target' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2731:1: ( 'target' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2732:1: 'target'
            {
             before(grammarAccess.getResultIssueAccess().getTargetKeyword_3_0()); 
            match(input,19,FOLLOW_19_in_rule__ResultIssue__Group_3__0__Impl5407); 
             after(grammarAccess.getResultIssueAccess().getTargetKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_3__0__Impl"


    // $ANTLR start "rule__ResultIssue__Group_3__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2745:1: rule__ResultIssue__Group_3__1 : rule__ResultIssue__Group_3__1__Impl ;
    public final void rule__ResultIssue__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2749:1: ( rule__ResultIssue__Group_3__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2750:2: rule__ResultIssue__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_3__1__Impl_in_rule__ResultIssue__Group_3__15438);
            rule__ResultIssue__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_3__1"


    // $ANTLR start "rule__ResultIssue__Group_3__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2756:1: rule__ResultIssue__Group_3__1__Impl : ( ( rule__ResultIssue__TargetAssignment_3_1 ) ) ;
    public final void rule__ResultIssue__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2760:1: ( ( ( rule__ResultIssue__TargetAssignment_3_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2761:1: ( ( rule__ResultIssue__TargetAssignment_3_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2761:1: ( ( rule__ResultIssue__TargetAssignment_3_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2762:1: ( rule__ResultIssue__TargetAssignment_3_1 )
            {
             before(grammarAccess.getResultIssueAccess().getTargetAssignment_3_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2763:1: ( rule__ResultIssue__TargetAssignment_3_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2763:2: rule__ResultIssue__TargetAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ResultIssue__TargetAssignment_3_1_in_rule__ResultIssue__Group_3__1__Impl5465);
            rule__ResultIssue__TargetAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getResultIssueAccess().getTargetAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_3__1__Impl"


    // $ANTLR start "rule__ResultIssue__Group_4__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2777:1: rule__ResultIssue__Group_4__0 : rule__ResultIssue__Group_4__0__Impl rule__ResultIssue__Group_4__1 ;
    public final void rule__ResultIssue__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2781:1: ( rule__ResultIssue__Group_4__0__Impl rule__ResultIssue__Group_4__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2782:2: rule__ResultIssue__Group_4__0__Impl rule__ResultIssue__Group_4__1
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_4__0__Impl_in_rule__ResultIssue__Group_4__05499);
            rule__ResultIssue__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group_4__1_in_rule__ResultIssue__Group_4__05502);
            rule__ResultIssue__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_4__0"


    // $ANTLR start "rule__ResultIssue__Group_4__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2789:1: rule__ResultIssue__Group_4__0__Impl : ( 'exception' ) ;
    public final void rule__ResultIssue__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2793:1: ( ( 'exception' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2794:1: ( 'exception' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2794:1: ( 'exception' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2795:1: 'exception'
            {
             before(grammarAccess.getResultIssueAccess().getExceptionKeyword_4_0()); 
            match(input,24,FOLLOW_24_in_rule__ResultIssue__Group_4__0__Impl5530); 
             after(grammarAccess.getResultIssueAccess().getExceptionKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_4__0__Impl"


    // $ANTLR start "rule__ResultIssue__Group_4__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2808:1: rule__ResultIssue__Group_4__1 : rule__ResultIssue__Group_4__1__Impl ;
    public final void rule__ResultIssue__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2812:1: ( rule__ResultIssue__Group_4__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2813:2: rule__ResultIssue__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_4__1__Impl_in_rule__ResultIssue__Group_4__15561);
            rule__ResultIssue__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_4__1"


    // $ANTLR start "rule__ResultIssue__Group_4__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2819:1: rule__ResultIssue__Group_4__1__Impl : ( ( rule__ResultIssue__ExceptionTypeAssignment_4_1 ) ) ;
    public final void rule__ResultIssue__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2823:1: ( ( ( rule__ResultIssue__ExceptionTypeAssignment_4_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2824:1: ( ( rule__ResultIssue__ExceptionTypeAssignment_4_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2824:1: ( ( rule__ResultIssue__ExceptionTypeAssignment_4_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2825:1: ( rule__ResultIssue__ExceptionTypeAssignment_4_1 )
            {
             before(grammarAccess.getResultIssueAccess().getExceptionTypeAssignment_4_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2826:1: ( rule__ResultIssue__ExceptionTypeAssignment_4_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2826:2: rule__ResultIssue__ExceptionTypeAssignment_4_1
            {
            pushFollow(FOLLOW_rule__ResultIssue__ExceptionTypeAssignment_4_1_in_rule__ResultIssue__Group_4__1__Impl5588);
            rule__ResultIssue__ExceptionTypeAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getResultIssueAccess().getExceptionTypeAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_4__1__Impl"


    // $ANTLR start "rule__ResultIssue__Group_5__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2840:1: rule__ResultIssue__Group_5__0 : rule__ResultIssue__Group_5__0__Impl rule__ResultIssue__Group_5__1 ;
    public final void rule__ResultIssue__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2844:1: ( rule__ResultIssue__Group_5__0__Impl rule__ResultIssue__Group_5__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2845:2: rule__ResultIssue__Group_5__0__Impl rule__ResultIssue__Group_5__1
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_5__0__Impl_in_rule__ResultIssue__Group_5__05622);
            rule__ResultIssue__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group_5__1_in_rule__ResultIssue__Group_5__05625);
            rule__ResultIssue__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_5__0"


    // $ANTLR start "rule__ResultIssue__Group_5__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2852:1: rule__ResultIssue__Group_5__0__Impl : ( '[' ) ;
    public final void rule__ResultIssue__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2856:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2857:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2857:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2858:1: '['
            {
             before(grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0()); 
            match(input,18,FOLLOW_18_in_rule__ResultIssue__Group_5__0__Impl5653); 
             after(grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_5__0__Impl"


    // $ANTLR start "rule__ResultIssue__Group_5__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2871:1: rule__ResultIssue__Group_5__1 : rule__ResultIssue__Group_5__1__Impl rule__ResultIssue__Group_5__2 ;
    public final void rule__ResultIssue__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2875:1: ( rule__ResultIssue__Group_5__1__Impl rule__ResultIssue__Group_5__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2876:2: rule__ResultIssue__Group_5__1__Impl rule__ResultIssue__Group_5__2
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_5__1__Impl_in_rule__ResultIssue__Group_5__15684);
            rule__ResultIssue__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group_5__2_in_rule__ResultIssue__Group_5__15687);
            rule__ResultIssue__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_5__1"


    // $ANTLR start "rule__ResultIssue__Group_5__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2883:1: rule__ResultIssue__Group_5__1__Impl : ( ( rule__ResultIssue__IssuesAssignment_5_1 )* ) ;
    public final void rule__ResultIssue__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2887:1: ( ( ( rule__ResultIssue__IssuesAssignment_5_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2888:1: ( ( rule__ResultIssue__IssuesAssignment_5_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2888:1: ( ( rule__ResultIssue__IssuesAssignment_5_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2889:1: ( rule__ResultIssue__IssuesAssignment_5_1 )*
            {
             before(grammarAccess.getResultIssueAccess().getIssuesAssignment_5_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2890:1: ( rule__ResultIssue__IssuesAssignment_5_1 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==30) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2890:2: rule__ResultIssue__IssuesAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultIssue__IssuesAssignment_5_1_in_rule__ResultIssue__Group_5__1__Impl5714);
            	    rule__ResultIssue__IssuesAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getResultIssueAccess().getIssuesAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_5__1__Impl"


    // $ANTLR start "rule__ResultIssue__Group_5__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2900:1: rule__ResultIssue__Group_5__2 : rule__ResultIssue__Group_5__2__Impl ;
    public final void rule__ResultIssue__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2904:1: ( rule__ResultIssue__Group_5__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2905:2: rule__ResultIssue__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_5__2__Impl_in_rule__ResultIssue__Group_5__25745);
            rule__ResultIssue__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_5__2"


    // $ANTLR start "rule__ResultIssue__Group_5__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2911:1: rule__ResultIssue__Group_5__2__Impl : ( ']' ) ;
    public final void rule__ResultIssue__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2915:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2916:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2916:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2917:1: ']'
            {
             before(grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2()); 
            match(input,20,FOLLOW_20_in_rule__ResultIssue__Group_5__2__Impl5773); 
             after(grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__Group_5__2__Impl"


    // $ANTLR start "rule__ResultData__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2936:1: rule__ResultData__Group__0 : rule__ResultData__Group__0__Impl rule__ResultData__Group__1 ;
    public final void rule__ResultData__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2940:1: ( rule__ResultData__Group__0__Impl rule__ResultData__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2941:2: rule__ResultData__Group__0__Impl rule__ResultData__Group__1
            {
            pushFollow(FOLLOW_rule__ResultData__Group__0__Impl_in_rule__ResultData__Group__05810);
            rule__ResultData__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultData__Group__1_in_rule__ResultData__Group__05813);
            rule__ResultData__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultData__Group__0"


    // $ANTLR start "rule__ResultData__Group__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2948:1: rule__ResultData__Group__0__Impl : ( ( rule__ResultData__NameAssignment_0 ) ) ;
    public final void rule__ResultData__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2952:1: ( ( ( rule__ResultData__NameAssignment_0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2953:1: ( ( rule__ResultData__NameAssignment_0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2953:1: ( ( rule__ResultData__NameAssignment_0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2954:1: ( rule__ResultData__NameAssignment_0 )
            {
             before(grammarAccess.getResultDataAccess().getNameAssignment_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2955:1: ( rule__ResultData__NameAssignment_0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2955:2: rule__ResultData__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ResultData__NameAssignment_0_in_rule__ResultData__Group__0__Impl5840);
            rule__ResultData__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getResultDataAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultData__Group__0__Impl"


    // $ANTLR start "rule__ResultData__Group__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2965:1: rule__ResultData__Group__1 : rule__ResultData__Group__1__Impl rule__ResultData__Group__2 ;
    public final void rule__ResultData__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2969:1: ( rule__ResultData__Group__1__Impl rule__ResultData__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2970:2: rule__ResultData__Group__1__Impl rule__ResultData__Group__2
            {
            pushFollow(FOLLOW_rule__ResultData__Group__1__Impl_in_rule__ResultData__Group__15870);
            rule__ResultData__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultData__Group__2_in_rule__ResultData__Group__15873);
            rule__ResultData__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultData__Group__1"


    // $ANTLR start "rule__ResultData__Group__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2977:1: rule__ResultData__Group__1__Impl : ( '=' ) ;
    public final void rule__ResultData__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2981:1: ( ( '=' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2982:1: ( '=' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2982:1: ( '=' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2983:1: '='
            {
             before(grammarAccess.getResultDataAccess().getEqualsSignKeyword_1()); 
            match(input,31,FOLLOW_31_in_rule__ResultData__Group__1__Impl5901); 
             after(grammarAccess.getResultDataAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultData__Group__1__Impl"


    // $ANTLR start "rule__ResultData__Group__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2996:1: rule__ResultData__Group__2 : rule__ResultData__Group__2__Impl ;
    public final void rule__ResultData__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3000:1: ( rule__ResultData__Group__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3001:2: rule__ResultData__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultData__Group__2__Impl_in_rule__ResultData__Group__25932);
            rule__ResultData__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultData__Group__2"


    // $ANTLR start "rule__ResultData__Group__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3007:1: rule__ResultData__Group__2__Impl : ( ( rule__ResultData__ValueAssignment_2 ) ) ;
    public final void rule__ResultData__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3011:1: ( ( ( rule__ResultData__ValueAssignment_2 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3012:1: ( ( rule__ResultData__ValueAssignment_2 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3012:1: ( ( rule__ResultData__ValueAssignment_2 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3013:1: ( rule__ResultData__ValueAssignment_2 )
            {
             before(grammarAccess.getResultDataAccess().getValueAssignment_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3014:1: ( rule__ResultData__ValueAssignment_2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3014:2: rule__ResultData__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__ResultData__ValueAssignment_2_in_rule__ResultData__Group__2__Impl5959);
            rule__ResultData__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getResultDataAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultData__Group__2__Impl"


    // $ANTLR start "rule__ResultReportCollection__NameAssignment_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3031:1: rule__ResultReportCollection__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ResultReportCollection__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3035:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3036:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3036:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3037:1: RULE_ID
            {
             before(grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultReportCollection__NameAssignment_16000); 
             after(grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__NameAssignment_1"


    // $ANTLR start "rule__ResultReportCollection__TitleAssignment_2_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3046:1: rule__ResultReportCollection__TitleAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__ResultReportCollection__TitleAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3050:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3051:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3051:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3052:1: RULE_STRING
            {
             before(grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReportCollection__TitleAssignment_2_16031); 
             after(grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__TitleAssignment_2_1"


    // $ANTLR start "rule__ResultReportCollection__TargetAssignment_5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3061:1: rule__ResultReportCollection__TargetAssignment_5 : ( ( ruleURIID ) ) ;
    public final void rule__ResultReportCollection__TargetAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3065:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3066:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3066:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3067:1: ( ruleURIID )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_5_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3068:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3069:1: ruleURIID
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultReportCollection__TargetAssignment_56066);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__TargetAssignment_5"


    // $ANTLR start "rule__ResultReportCollection__DecriptionAssignment_6_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3080:1: rule__ResultReportCollection__DecriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ResultReportCollection__DecriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3084:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3085:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3085:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3086:1: RULE_STRING
            {
             before(grammarAccess.getResultReportCollectionAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReportCollection__DecriptionAssignment_6_16101); 
             after(grammarAccess.getResultReportCollectionAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__DecriptionAssignment_6_1"


    // $ANTLR start "rule__ResultReportCollection__ContentAssignment_7"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3095:1: rule__ResultReportCollection__ContentAssignment_7 : ( ruleResultReport ) ;
    public final void rule__ResultReportCollection__ContentAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3099:1: ( ( ruleResultReport ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3100:1: ( ruleResultReport )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3100:1: ( ruleResultReport )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3101:1: ruleResultReport
            {
             before(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleResultReport_in_rule__ResultReportCollection__ContentAssignment_76132);
            ruleResultReport();

            state._fsp--;

             after(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__ContentAssignment_7"


    // $ANTLR start "rule__ResultReportCollection__IssuesAssignment_8"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3110:1: rule__ResultReportCollection__IssuesAssignment_8 : ( ruleResultIssue ) ;
    public final void rule__ResultReportCollection__IssuesAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3114:1: ( ( ruleResultIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3115:1: ( ruleResultIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3115:1: ( ruleResultIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3116:1: ruleResultIssue
            {
             before(grammarAccess.getResultReportCollectionAccess().getIssuesResultIssueParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleResultIssue_in_rule__ResultReportCollection__IssuesAssignment_86163);
            ruleResultIssue();

            state._fsp--;

             after(grammarAccess.getResultReportCollectionAccess().getIssuesResultIssueParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__IssuesAssignment_8"


    // $ANTLR start "rule__ResultReport__NameAssignment_2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3125:1: rule__ResultReport__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ResultReport__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3129:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3130:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3130:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3131:1: RULE_ID
            {
             before(grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultReport__NameAssignment_26194); 
             after(grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__NameAssignment_2"


    // $ANTLR start "rule__ResultReport__TitleAssignment_3_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3140:1: rule__ResultReport__TitleAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__ResultReport__TitleAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3144:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3145:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3145:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3146:1: RULE_STRING
            {
             before(grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReport__TitleAssignment_3_16225); 
             after(grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__TitleAssignment_3_1"


    // $ANTLR start "rule__ResultReport__TargetAssignment_4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3155:1: rule__ResultReport__TargetAssignment_4 : ( ( ruleURIID ) ) ;
    public final void rule__ResultReport__TargetAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3159:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3160:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3160:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3161:1: ( ruleURIID )
            {
             before(grammarAccess.getResultReportAccess().getTargetEObjectCrossReference_4_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3162:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3163:1: ruleURIID
            {
             before(grammarAccess.getResultReportAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultReport__TargetAssignment_46260);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getResultReportAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getResultReportAccess().getTargetEObjectCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__TargetAssignment_4"


    // $ANTLR start "rule__ResultReport__IssueTypeAssignment_5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3174:1: rule__ResultReport__IssueTypeAssignment_5 : ( ruleResultIssueType ) ;
    public final void rule__ResultReport__IssueTypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3178:1: ( ( ruleResultIssueType ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3179:1: ( ruleResultIssueType )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3179:1: ( ruleResultIssueType )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3180:1: ruleResultIssueType
            {
             before(grammarAccess.getResultReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleResultIssueType_in_rule__ResultReport__IssueTypeAssignment_56295);
            ruleResultIssueType();

            state._fsp--;

             after(grammarAccess.getResultReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__IssueTypeAssignment_5"


    // $ANTLR start "rule__ResultReport__MessageAssignment_6"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3189:1: rule__ResultReport__MessageAssignment_6 : ( RULE_STRING ) ;
    public final void rule__ResultReport__MessageAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3193:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3194:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3194:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3195:1: RULE_STRING
            {
             before(grammarAccess.getResultReportAccess().getMessageSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReport__MessageAssignment_66326); 
             after(grammarAccess.getResultReportAccess().getMessageSTRINGTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__MessageAssignment_6"


    // $ANTLR start "rule__ResultReport__ExceptionTypeAssignment_7_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3204:1: rule__ResultReport__ExceptionTypeAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__ResultReport__ExceptionTypeAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3208:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3209:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3209:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3210:1: RULE_STRING
            {
             before(grammarAccess.getResultReportAccess().getExceptionTypeSTRINGTerminalRuleCall_7_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReport__ExceptionTypeAssignment_7_16357); 
             after(grammarAccess.getResultReportAccess().getExceptionTypeSTRINGTerminalRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__ExceptionTypeAssignment_7_1"


    // $ANTLR start "rule__ResultReport__DecriptionAssignment_9_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3219:1: rule__ResultReport__DecriptionAssignment_9_1 : ( RULE_STRING ) ;
    public final void rule__ResultReport__DecriptionAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3223:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3224:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3224:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3225:1: RULE_STRING
            {
             before(grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_9_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReport__DecriptionAssignment_9_16388); 
             after(grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__DecriptionAssignment_9_1"


    // $ANTLR start "rule__ResultReport__HeadingAssignment_10_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3234:1: rule__ResultReport__HeadingAssignment_10_1 : ( RULE_STRING ) ;
    public final void rule__ResultReport__HeadingAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3238:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3239:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3239:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3240:1: RULE_STRING
            {
             before(grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_10_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReport__HeadingAssignment_10_16419); 
             after(grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__HeadingAssignment_10_1"


    // $ANTLR start "rule__ResultReport__ContentAssignment_10_2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3249:1: rule__ResultReport__ContentAssignment_10_2 : ( ruleResultContributor ) ;
    public final void rule__ResultReport__ContentAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3253:1: ( ( ruleResultContributor ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3254:1: ( ruleResultContributor )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3254:1: ( ruleResultContributor )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3255:1: ruleResultContributor
            {
             before(grammarAccess.getResultReportAccess().getContentResultContributorParserRuleCall_10_2_0()); 
            pushFollow(FOLLOW_ruleResultContributor_in_rule__ResultReport__ContentAssignment_10_26450);
            ruleResultContributor();

            state._fsp--;

             after(grammarAccess.getResultReportAccess().getContentResultContributorParserRuleCall_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__ContentAssignment_10_2"


    // $ANTLR start "rule__ResultReport__ResultDataAssignment_11_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3264:1: rule__ResultReport__ResultDataAssignment_11_1 : ( ruleResultData ) ;
    public final void rule__ResultReport__ResultDataAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3268:1: ( ( ruleResultData ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3269:1: ( ruleResultData )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3269:1: ( ruleResultData )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3270:1: ruleResultData
            {
             before(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_11_1_0()); 
            pushFollow(FOLLOW_ruleResultData_in_rule__ResultReport__ResultDataAssignment_11_16481);
            ruleResultData();

            state._fsp--;

             after(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__ResultDataAssignment_11_1"


    // $ANTLR start "rule__ResultReport__IssuesAssignment_12"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3279:1: rule__ResultReport__IssuesAssignment_12 : ( ruleResultIssue ) ;
    public final void rule__ResultReport__IssuesAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3283:1: ( ( ruleResultIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3284:1: ( ruleResultIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3284:1: ( ruleResultIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3285:1: ruleResultIssue
            {
             before(grammarAccess.getResultReportAccess().getIssuesResultIssueParserRuleCall_12_0()); 
            pushFollow(FOLLOW_ruleResultIssue_in_rule__ResultReport__IssuesAssignment_126512);
            ruleResultIssue();

            state._fsp--;

             after(grammarAccess.getResultReportAccess().getIssuesResultIssueParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReport__IssuesAssignment_12"


    // $ANTLR start "rule__ResultContributor__TargetAssignment_2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3294:1: rule__ResultContributor__TargetAssignment_2 : ( ( ruleURIID ) ) ;
    public final void rule__ResultContributor__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3298:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3299:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3299:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3300:1: ( ruleURIID )
            {
             before(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_2_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3301:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3302:1: ruleURIID
            {
             before(grammarAccess.getResultContributorAccess().getTargetEObjectURIIDParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultContributor__TargetAssignment_26547);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getResultContributorAccess().getTargetEObjectURIIDParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__TargetAssignment_2"


    // $ANTLR start "rule__ResultContributor__IssueTypeAssignment_3"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3313:1: rule__ResultContributor__IssueTypeAssignment_3 : ( ruleResultIssueType ) ;
    public final void rule__ResultContributor__IssueTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3317:1: ( ( ruleResultIssueType ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3318:1: ( ruleResultIssueType )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3318:1: ( ruleResultIssueType )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3319:1: ruleResultIssueType
            {
             before(grammarAccess.getResultContributorAccess().getIssueTypeResultIssueTypeEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleResultIssueType_in_rule__ResultContributor__IssueTypeAssignment_36582);
            ruleResultIssueType();

            state._fsp--;

             after(grammarAccess.getResultContributorAccess().getIssueTypeResultIssueTypeEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__IssueTypeAssignment_3"


    // $ANTLR start "rule__ResultContributor__MessageAssignment_4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3328:1: rule__ResultContributor__MessageAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ResultContributor__MessageAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3332:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3333:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3333:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3334:1: RULE_STRING
            {
             before(grammarAccess.getResultContributorAccess().getMessageSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultContributor__MessageAssignment_46613); 
             after(grammarAccess.getResultContributorAccess().getMessageSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__MessageAssignment_4"


    // $ANTLR start "rule__ResultContributor__ExceptionTypeAssignment_5_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3343:1: rule__ResultContributor__ExceptionTypeAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ResultContributor__ExceptionTypeAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3347:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3348:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3348:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3349:1: RULE_STRING
            {
             before(grammarAccess.getResultContributorAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultContributor__ExceptionTypeAssignment_5_16644); 
             after(grammarAccess.getResultContributorAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__ExceptionTypeAssignment_5_1"


    // $ANTLR start "rule__ResultContributor__CellAssignment_8"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3358:1: rule__ResultContributor__CellAssignment_8 : ( RULE_STRING ) ;
    public final void rule__ResultContributor__CellAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3362:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3363:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3363:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3364:1: RULE_STRING
            {
             before(grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_8_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultContributor__CellAssignment_86675); 
             after(grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__CellAssignment_8"


    // $ANTLR start "rule__ResultContributor__IssuesAssignment_9"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3373:1: rule__ResultContributor__IssuesAssignment_9 : ( ruleResultIssue ) ;
    public final void rule__ResultContributor__IssuesAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3377:1: ( ( ruleResultIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3378:1: ( ruleResultIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3378:1: ( ruleResultIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3379:1: ruleResultIssue
            {
             before(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleResultIssue_in_rule__ResultContributor__IssuesAssignment_96706);
            ruleResultIssue();

            state._fsp--;

             after(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__IssuesAssignment_9"


    // $ANTLR start "rule__ResultContributor__SubcontributorAssignment_10"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3388:1: rule__ResultContributor__SubcontributorAssignment_10 : ( ruleResultContributor ) ;
    public final void rule__ResultContributor__SubcontributorAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3392:1: ( ( ruleResultContributor ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3393:1: ( ruleResultContributor )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3393:1: ( ruleResultContributor )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3394:1: ruleResultContributor
            {
             before(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_10_0()); 
            pushFollow(FOLLOW_ruleResultContributor_in_rule__ResultContributor__SubcontributorAssignment_106737);
            ruleResultContributor();

            state._fsp--;

             after(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__SubcontributorAssignment_10"


    // $ANTLR start "rule__IssueReport__IssueTypeAssignment_2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3403:1: rule__IssueReport__IssueTypeAssignment_2 : ( ruleResultIssueType ) ;
    public final void rule__IssueReport__IssueTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3407:1: ( ( ruleResultIssueType ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3408:1: ( ruleResultIssueType )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3408:1: ( ruleResultIssueType )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3409:1: ruleResultIssueType
            {
             before(grammarAccess.getIssueReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleResultIssueType_in_rule__IssueReport__IssueTypeAssignment_26768);
            ruleResultIssueType();

            state._fsp--;

             after(grammarAccess.getIssueReportAccess().getIssueTypeResultIssueTypeEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__IssueTypeAssignment_2"


    // $ANTLR start "rule__IssueReport__MessageAssignment_3"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3418:1: rule__IssueReport__MessageAssignment_3 : ( RULE_STRING ) ;
    public final void rule__IssueReport__MessageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3422:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3423:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3423:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3424:1: RULE_STRING
            {
             before(grammarAccess.getIssueReportAccess().getMessageSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IssueReport__MessageAssignment_36799); 
             after(grammarAccess.getIssueReportAccess().getMessageSTRINGTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__MessageAssignment_3"


    // $ANTLR start "rule__IssueReport__TargetAssignment_4_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3433:1: rule__IssueReport__TargetAssignment_4_1 : ( ( ruleURIID ) ) ;
    public final void rule__IssueReport__TargetAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3437:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3438:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3438:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3439:1: ( ruleURIID )
            {
             before(grammarAccess.getIssueReportAccess().getTargetEObjectCrossReference_4_1_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3440:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3441:1: ruleURIID
            {
             before(grammarAccess.getIssueReportAccess().getTargetEObjectURIIDParserRuleCall_4_1_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__IssueReport__TargetAssignment_4_16834);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getIssueReportAccess().getTargetEObjectURIIDParserRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getIssueReportAccess().getTargetEObjectCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__TargetAssignment_4_1"


    // $ANTLR start "rule__IssueReport__ExceptionTypeAssignment_5_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3452:1: rule__IssueReport__ExceptionTypeAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__IssueReport__ExceptionTypeAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3456:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3457:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3457:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3458:1: RULE_STRING
            {
             before(grammarAccess.getIssueReportAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IssueReport__ExceptionTypeAssignment_5_16869); 
             after(grammarAccess.getIssueReportAccess().getExceptionTypeSTRINGTerminalRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__ExceptionTypeAssignment_5_1"


    // $ANTLR start "rule__IssueReport__IssuesAssignment_6_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3467:1: rule__IssueReport__IssuesAssignment_6_1 : ( ruleResultIssue ) ;
    public final void rule__IssueReport__IssuesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3471:1: ( ( ruleResultIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3472:1: ( ruleResultIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3472:1: ( ruleResultIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3473:1: ruleResultIssue
            {
             before(grammarAccess.getIssueReportAccess().getIssuesResultIssueParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleResultIssue_in_rule__IssueReport__IssuesAssignment_6_16900);
            ruleResultIssue();

            state._fsp--;

             after(grammarAccess.getIssueReportAccess().getIssuesResultIssueParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssueReport__IssuesAssignment_6_1"


    // $ANTLR start "rule__ResultIssue__IssueTypeAssignment_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3482:1: rule__ResultIssue__IssueTypeAssignment_1 : ( ruleResultIssueType ) ;
    public final void rule__ResultIssue__IssueTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3486:1: ( ( ruleResultIssueType ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3487:1: ( ruleResultIssueType )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3487:1: ( ruleResultIssueType )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3488:1: ruleResultIssueType
            {
             before(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleResultIssueType_in_rule__ResultIssue__IssueTypeAssignment_16931);
            ruleResultIssueType();

            state._fsp--;

             after(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__IssueTypeAssignment_1"


    // $ANTLR start "rule__ResultIssue__MessageAssignment_2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3497:1: rule__ResultIssue__MessageAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ResultIssue__MessageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3501:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3502:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3502:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3503:1: RULE_STRING
            {
             before(grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultIssue__MessageAssignment_26962); 
             after(grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__MessageAssignment_2"


    // $ANTLR start "rule__ResultIssue__TargetAssignment_3_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3512:1: rule__ResultIssue__TargetAssignment_3_1 : ( ( ruleURIID ) ) ;
    public final void rule__ResultIssue__TargetAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3516:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3517:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3517:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3518:1: ( ruleURIID )
            {
             before(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_3_1_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3519:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3520:1: ruleURIID
            {
             before(grammarAccess.getResultIssueAccess().getTargetEObjectURIIDParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultIssue__TargetAssignment_3_16997);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getResultIssueAccess().getTargetEObjectURIIDParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__TargetAssignment_3_1"


    // $ANTLR start "rule__ResultIssue__ExceptionTypeAssignment_4_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3531:1: rule__ResultIssue__ExceptionTypeAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__ResultIssue__ExceptionTypeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3535:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3536:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3536:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3537:1: RULE_STRING
            {
             before(grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultIssue__ExceptionTypeAssignment_4_17032); 
             after(grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__ExceptionTypeAssignment_4_1"


    // $ANTLR start "rule__ResultIssue__IssuesAssignment_5_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3546:1: rule__ResultIssue__IssuesAssignment_5_1 : ( ruleResultIssue ) ;
    public final void rule__ResultIssue__IssuesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3550:1: ( ( ruleResultIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3551:1: ( ruleResultIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3551:1: ( ruleResultIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3552:1: ruleResultIssue
            {
             before(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleResultIssue_in_rule__ResultIssue__IssuesAssignment_5_17063);
            ruleResultIssue();

            state._fsp--;

             after(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultIssue__IssuesAssignment_5_1"


    // $ANTLR start "rule__ResultData__NameAssignment_0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3561:1: rule__ResultData__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ResultData__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3565:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3566:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3566:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3567:1: RULE_ID
            {
             before(grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultData__NameAssignment_07094); 
             after(grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultData__NameAssignment_0"


    // $ANTLR start "rule__ResultData__ValueAssignment_2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3576:1: rule__ResultData__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ResultData__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3580:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3581:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3581:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3582:1: RULE_STRING
            {
             before(grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultData__ValueAssignment_27125); 
             after(grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultData__ValueAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleResultReports_in_entryRuleResultReports61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReports68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReports__Alternatives_in_ruleResultReports94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_entryRuleResultReportCollection121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReportCollection128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__0_in_ruleResultReportCollection154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReport_in_entryRuleResultReport181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReport188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__0_in_ruleResultReport214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_entryRuleResultContributor241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultContributor248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__0_in_ruleResultContributor274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssueReport_in_entryRuleIssueReport301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIssueReport308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__0_in_ruleIssueReport334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_entryRuleResultIssue361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultIssue368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__0_in_ruleResultIssue394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_entryRuleResultData421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultData428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__0_in_ruleResultData454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_entryRuleURIID481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIID488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIID514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssueType__Alternatives_in_ruleResultIssueType550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReport_in_rule__ResultReports__Alternatives585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_rule__ResultReports__Alternatives602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssueReport_in_rule__ResultReports__Alternatives619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ResultIssueType__Alternatives652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ResultIssueType__Alternatives673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ResultIssueType__Alternatives694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ResultIssueType__Alternatives715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ResultIssueType__Alternatives736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ResultIssueType__Alternatives757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__0__Impl_in_rule__ResultReportCollection__Group__0790 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__1_in_rule__ResultReportCollection__Group__0793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ResultReportCollection__Group__0__Impl821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__1__Impl_in_rule__ResultReportCollection__Group__1852 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__2_in_rule__ResultReportCollection__Group__1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__NameAssignment_1_in_rule__ResultReportCollection__Group__1__Impl882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__2__Impl_in_rule__ResultReportCollection__Group__2912 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__3_in_rule__ResultReportCollection__Group__2915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__0_in_rule__ResultReportCollection__Group__2__Impl942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__3__Impl_in_rule__ResultReportCollection__Group__3973 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__4_in_rule__ResultReportCollection__Group__3976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ResultReportCollection__Group__3__Impl1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__4__Impl_in_rule__ResultReportCollection__Group__41035 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__5_in_rule__ResultReportCollection__Group__41038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ResultReportCollection__Group__4__Impl1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__5__Impl_in_rule__ResultReportCollection__Group__51097 = new BitSet(new long[]{0x0000000040D00000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__6_in_rule__ResultReportCollection__Group__51100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__TargetAssignment_5_in_rule__ResultReportCollection__Group__5__Impl1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__6__Impl_in_rule__ResultReportCollection__Group__61157 = new BitSet(new long[]{0x0000000040D00000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__7_in_rule__ResultReportCollection__Group__61160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__0_in_rule__ResultReportCollection__Group__6__Impl1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__7__Impl_in_rule__ResultReportCollection__Group__71218 = new BitSet(new long[]{0x0000000040D00000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__8_in_rule__ResultReportCollection__Group__71221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__ContentAssignment_7_in_rule__ResultReportCollection__Group__7__Impl1248 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__8__Impl_in_rule__ResultReportCollection__Group__81279 = new BitSet(new long[]{0x0000000040D00000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__9_in_rule__ResultReportCollection__Group__81282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__IssuesAssignment_8_in_rule__ResultReportCollection__Group__8__Impl1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__9__Impl_in_rule__ResultReportCollection__Group__91340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultReportCollection__Group__9__Impl1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__0__Impl_in_rule__ResultReportCollection__Group_2__01419 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__1_in_rule__ResultReportCollection__Group_2__01422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResultReportCollection__Group_2__0__Impl1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__1__Impl_in_rule__ResultReportCollection__Group_2__11481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__TitleAssignment_2_1_in_rule__ResultReportCollection__Group_2__1__Impl1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__0__Impl_in_rule__ResultReportCollection__Group_6__01542 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__1_in_rule__ResultReportCollection__Group_6__01545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ResultReportCollection__Group_6__0__Impl1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__1__Impl_in_rule__ResultReportCollection__Group_6__11604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__DecriptionAssignment_6_1_in_rule__ResultReportCollection__Group_6__1__Impl1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__0__Impl_in_rule__ResultReport__Group__01665 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__1_in_rule__ResultReport__Group__01668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__1__Impl_in_rule__ResultReport__Group__11726 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__2_in_rule__ResultReport__Group__11729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ResultReport__Group__1__Impl1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__2__Impl_in_rule__ResultReport__Group__21788 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__3_in_rule__ResultReport__Group__21791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__NameAssignment_2_in_rule__ResultReport__Group__2__Impl1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__3__Impl_in_rule__ResultReport__Group__31848 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__4_in_rule__ResultReport__Group__31851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_3__0_in_rule__ResultReport__Group__3__Impl1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__4__Impl_in_rule__ResultReport__Group__41909 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__5_in_rule__ResultReport__Group__41912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__TargetAssignment_4_in_rule__ResultReport__Group__4__Impl1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__5__Impl_in_rule__ResultReport__Group__51969 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__6_in_rule__ResultReport__Group__51972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__IssueTypeAssignment_5_in_rule__ResultReport__Group__5__Impl1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__6__Impl_in_rule__ResultReport__Group__62029 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__7_in_rule__ResultReport__Group__62032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__MessageAssignment_6_in_rule__ResultReport__Group__6__Impl2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__7__Impl_in_rule__ResultReport__Group__72089 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__8_in_rule__ResultReport__Group__72092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__0_in_rule__ResultReport__Group__7__Impl2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__8__Impl_in_rule__ResultReport__Group__82150 = new BitSet(new long[]{0x0000000046500000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__9_in_rule__ResultReport__Group__82153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ResultReport__Group__8__Impl2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__9__Impl_in_rule__ResultReport__Group__92212 = new BitSet(new long[]{0x0000000046500000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__10_in_rule__ResultReport__Group__92215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__0_in_rule__ResultReport__Group__9__Impl2242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__10__Impl_in_rule__ResultReport__Group__102273 = new BitSet(new long[]{0x0000000046500000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__11_in_rule__ResultReport__Group__102276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_10__0_in_rule__ResultReport__Group__10__Impl2303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__11__Impl_in_rule__ResultReport__Group__112334 = new BitSet(new long[]{0x0000000046500000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__12_in_rule__ResultReport__Group__112337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_11__0_in_rule__ResultReport__Group__11__Impl2364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__12__Impl_in_rule__ResultReport__Group__122395 = new BitSet(new long[]{0x0000000046500000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__13_in_rule__ResultReport__Group__122398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__IssuesAssignment_12_in_rule__ResultReport__Group__12__Impl2425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__13__Impl_in_rule__ResultReport__Group__132456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultReport__Group__13__Impl2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_3__0__Impl_in_rule__ResultReport__Group_3__02543 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_3__1_in_rule__ResultReport__Group_3__02546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResultReport__Group_3__0__Impl2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_3__1__Impl_in_rule__ResultReport__Group_3__12605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__TitleAssignment_3_1_in_rule__ResultReport__Group_3__1__Impl2632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__0__Impl_in_rule__ResultReport__Group_7__02666 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__1_in_rule__ResultReport__Group_7__02669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ResultReport__Group_7__0__Impl2697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__1__Impl_in_rule__ResultReport__Group_7__12728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__ExceptionTypeAssignment_7_1_in_rule__ResultReport__Group_7__1__Impl2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__0__Impl_in_rule__ResultReport__Group_9__02789 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__1_in_rule__ResultReport__Group_9__02792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ResultReport__Group_9__0__Impl2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__1__Impl_in_rule__ResultReport__Group_9__12851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__DecriptionAssignment_9_1_in_rule__ResultReport__Group_9__1__Impl2878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_10__0__Impl_in_rule__ResultReport__Group_10__02912 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_10__1_in_rule__ResultReport__Group_10__02915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ResultReport__Group_10__0__Impl2943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_10__1__Impl_in_rule__ResultReport__Group_10__12974 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_10__2_in_rule__ResultReport__Group_10__12977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__HeadingAssignment_10_1_in_rule__ResultReport__Group_10__1__Impl3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_10__2__Impl_in_rule__ResultReport__Group_10__23034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__ContentAssignment_10_2_in_rule__ResultReport__Group_10__2__Impl3061 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_11__0__Impl_in_rule__ResultReport__Group_11__03098 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_11__1_in_rule__ResultReport__Group_11__03101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ResultReport__Group_11__0__Impl3129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_11__1__Impl_in_rule__ResultReport__Group_11__13160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__ResultDataAssignment_11_1_in_rule__ResultReport__Group_11__1__Impl3189 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__ResultReport__ResultDataAssignment_11_1_in_rule__ResultReport__Group_11__1__Impl3201 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__0__Impl_in_rule__ResultContributor__Group__03238 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__1_in_rule__ResultContributor__Group__03241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__1__Impl_in_rule__ResultContributor__Group__13299 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__2_in_rule__ResultContributor__Group__13302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ResultContributor__Group__1__Impl3330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__2__Impl_in_rule__ResultContributor__Group__23361 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__3_in_rule__ResultContributor__Group__23364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__TargetAssignment_2_in_rule__ResultContributor__Group__2__Impl3391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__3__Impl_in_rule__ResultContributor__Group__33421 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__4_in_rule__ResultContributor__Group__33424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__IssueTypeAssignment_3_in_rule__ResultContributor__Group__3__Impl3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__4__Impl_in_rule__ResultContributor__Group__43481 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__5_in_rule__ResultContributor__Group__43484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__MessageAssignment_4_in_rule__ResultContributor__Group__4__Impl3511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__5__Impl_in_rule__ResultContributor__Group__53541 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__6_in_rule__ResultContributor__Group__53544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__0_in_rule__ResultContributor__Group__5__Impl3571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__6__Impl_in_rule__ResultContributor__Group__63602 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__7_in_rule__ResultContributor__Group__63605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ResultContributor__Group__6__Impl3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__7__Impl_in_rule__ResultContributor__Group__73664 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__8_in_rule__ResultContributor__Group__73667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ResultContributor__Group__7__Impl3695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__8__Impl_in_rule__ResultContributor__Group__83726 = new BitSet(new long[]{0x0000000048100000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__9_in_rule__ResultContributor__Group__83729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__CellAssignment_8_in_rule__ResultContributor__Group__8__Impl3758 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ResultContributor__CellAssignment_8_in_rule__ResultContributor__Group__8__Impl3770 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__9__Impl_in_rule__ResultContributor__Group__93803 = new BitSet(new long[]{0x0000000048100000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__10_in_rule__ResultContributor__Group__93806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__IssuesAssignment_9_in_rule__ResultContributor__Group__9__Impl3833 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__10__Impl_in_rule__ResultContributor__Group__103864 = new BitSet(new long[]{0x0000000048100000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__11_in_rule__ResultContributor__Group__103867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__SubcontributorAssignment_10_in_rule__ResultContributor__Group__10__Impl3894 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__11__Impl_in_rule__ResultContributor__Group__113925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultContributor__Group__11__Impl3953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__0__Impl_in_rule__ResultContributor__Group_5__04008 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__1_in_rule__ResultContributor__Group_5__04011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ResultContributor__Group_5__0__Impl4039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__1__Impl_in_rule__ResultContributor__Group_5__14070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__ExceptionTypeAssignment_5_1_in_rule__ResultContributor__Group_5__1__Impl4097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__0__Impl_in_rule__IssueReport__Group__04131 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__1_in_rule__IssueReport__Group__04134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__1__Impl_in_rule__IssueReport__Group__14192 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__2_in_rule__IssueReport__Group__14195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__IssueReport__Group__1__Impl4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__2__Impl_in_rule__IssueReport__Group__24254 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__3_in_rule__IssueReport__Group__24257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__IssueTypeAssignment_2_in_rule__IssueReport__Group__2__Impl4284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__3__Impl_in_rule__IssueReport__Group__34314 = new BitSet(new long[]{0x00000000010C0000L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__4_in_rule__IssueReport__Group__34317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__MessageAssignment_3_in_rule__IssueReport__Group__3__Impl4344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__4__Impl_in_rule__IssueReport__Group__44374 = new BitSet(new long[]{0x00000000010C0000L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__5_in_rule__IssueReport__Group__44377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_4__0_in_rule__IssueReport__Group__4__Impl4404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__5__Impl_in_rule__IssueReport__Group__54435 = new BitSet(new long[]{0x00000000010C0000L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__6_in_rule__IssueReport__Group__54438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_5__0_in_rule__IssueReport__Group__5__Impl4465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group__6__Impl_in_rule__IssueReport__Group__64496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_6__0_in_rule__IssueReport__Group__6__Impl4523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_4__0__Impl_in_rule__IssueReport__Group_4__04568 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_4__1_in_rule__IssueReport__Group_4__04571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__IssueReport__Group_4__0__Impl4599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_4__1__Impl_in_rule__IssueReport__Group_4__14630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__TargetAssignment_4_1_in_rule__IssueReport__Group_4__1__Impl4657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_5__0__Impl_in_rule__IssueReport__Group_5__04691 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_5__1_in_rule__IssueReport__Group_5__04694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__IssueReport__Group_5__0__Impl4722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_5__1__Impl_in_rule__IssueReport__Group_5__14753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__ExceptionTypeAssignment_5_1_in_rule__IssueReport__Group_5__1__Impl4780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_6__0__Impl_in_rule__IssueReport__Group_6__04814 = new BitSet(new long[]{0x0000000040100000L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_6__1_in_rule__IssueReport__Group_6__04817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__IssueReport__Group_6__0__Impl4845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_6__1__Impl_in_rule__IssueReport__Group_6__14876 = new BitSet(new long[]{0x0000000040100000L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_6__2_in_rule__IssueReport__Group_6__14879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssueReport__IssuesAssignment_6_1_in_rule__IssueReport__Group_6__1__Impl4906 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__IssueReport__Group_6__2__Impl_in_rule__IssueReport__Group_6__24937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__IssueReport__Group_6__2__Impl4965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__0__Impl_in_rule__ResultIssue__Group__05002 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__1_in_rule__ResultIssue__Group__05005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ResultIssue__Group__0__Impl5033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__1__Impl_in_rule__ResultIssue__Group__15064 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__2_in_rule__ResultIssue__Group__15067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__IssueTypeAssignment_1_in_rule__ResultIssue__Group__1__Impl5094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__2__Impl_in_rule__ResultIssue__Group__25124 = new BitSet(new long[]{0x00000000010C0000L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__3_in_rule__ResultIssue__Group__25127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__MessageAssignment_2_in_rule__ResultIssue__Group__2__Impl5154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__3__Impl_in_rule__ResultIssue__Group__35184 = new BitSet(new long[]{0x00000000010C0000L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__4_in_rule__ResultIssue__Group__35187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_3__0_in_rule__ResultIssue__Group__3__Impl5214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__4__Impl_in_rule__ResultIssue__Group__45245 = new BitSet(new long[]{0x00000000010C0000L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__5_in_rule__ResultIssue__Group__45248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_4__0_in_rule__ResultIssue__Group__4__Impl5275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__5__Impl_in_rule__ResultIssue__Group__55306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__0_in_rule__ResultIssue__Group__5__Impl5333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_3__0__Impl_in_rule__ResultIssue__Group_3__05376 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_3__1_in_rule__ResultIssue__Group_3__05379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ResultIssue__Group_3__0__Impl5407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_3__1__Impl_in_rule__ResultIssue__Group_3__15438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__TargetAssignment_3_1_in_rule__ResultIssue__Group_3__1__Impl5465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_4__0__Impl_in_rule__ResultIssue__Group_4__05499 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_4__1_in_rule__ResultIssue__Group_4__05502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ResultIssue__Group_4__0__Impl5530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_4__1__Impl_in_rule__ResultIssue__Group_4__15561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__ExceptionTypeAssignment_4_1_in_rule__ResultIssue__Group_4__1__Impl5588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__0__Impl_in_rule__ResultIssue__Group_5__05622 = new BitSet(new long[]{0x0000000040100000L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__1_in_rule__ResultIssue__Group_5__05625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ResultIssue__Group_5__0__Impl5653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__1__Impl_in_rule__ResultIssue__Group_5__15684 = new BitSet(new long[]{0x0000000040100000L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__2_in_rule__ResultIssue__Group_5__15687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__IssuesAssignment_5_1_in_rule__ResultIssue__Group_5__1__Impl5714 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__2__Impl_in_rule__ResultIssue__Group_5__25745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultIssue__Group_5__2__Impl5773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__0__Impl_in_rule__ResultData__Group__05810 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ResultData__Group__1_in_rule__ResultData__Group__05813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__NameAssignment_0_in_rule__ResultData__Group__0__Impl5840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__1__Impl_in_rule__ResultData__Group__15870 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultData__Group__2_in_rule__ResultData__Group__15873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ResultData__Group__1__Impl5901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__2__Impl_in_rule__ResultData__Group__25932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__ValueAssignment_2_in_rule__ResultData__Group__2__Impl5959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultReportCollection__NameAssignment_16000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReportCollection__TitleAssignment_2_16031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultReportCollection__TargetAssignment_56066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReportCollection__DecriptionAssignment_6_16101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReport_in_rule__ResultReportCollection__ContentAssignment_76132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_rule__ResultReportCollection__IssuesAssignment_86163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultReport__NameAssignment_26194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReport__TitleAssignment_3_16225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultReport__TargetAssignment_46260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_rule__ResultReport__IssueTypeAssignment_56295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReport__MessageAssignment_66326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReport__ExceptionTypeAssignment_7_16357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReport__DecriptionAssignment_9_16388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReport__HeadingAssignment_10_16419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_rule__ResultReport__ContentAssignment_10_26450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_rule__ResultReport__ResultDataAssignment_11_16481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_rule__ResultReport__IssuesAssignment_126512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultContributor__TargetAssignment_26547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_rule__ResultContributor__IssueTypeAssignment_36582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultContributor__MessageAssignment_46613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultContributor__ExceptionTypeAssignment_5_16644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultContributor__CellAssignment_86675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_rule__ResultContributor__IssuesAssignment_96706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_rule__ResultContributor__SubcontributorAssignment_106737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_rule__IssueReport__IssueTypeAssignment_26768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IssueReport__MessageAssignment_36799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__IssueReport__TargetAssignment_4_16834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IssueReport__ExceptionTypeAssignment_5_16869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_rule__IssueReport__IssuesAssignment_6_16900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_rule__ResultIssue__IssueTypeAssignment_16931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultIssue__MessageAssignment_26962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultIssue__TargetAssignment_3_16997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultIssue__ExceptionTypeAssignment_4_17032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_rule__ResultIssue__IssuesAssignment_5_17063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultData__NameAssignment_07094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultData__ValueAssignment_27125 = new BitSet(new long[]{0x0000000000000002L});

}
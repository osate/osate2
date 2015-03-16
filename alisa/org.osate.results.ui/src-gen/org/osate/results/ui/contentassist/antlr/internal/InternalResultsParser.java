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

@SuppressWarnings("all")
public class InternalResultsParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'error'", "'warning'", "'success'", "'info'", "'reports'", "'['", "'target'", "']'", "':'", "'description'", "'issues'", "'report'", "'heading'", "'results'", "'contributor'", "'data'", "'='"
    };
    public static final int RULE_ID=5;
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
    public static final int RULE_STRING=4;
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:60:1: entryRuleResultReports : ruleResultReports EOF ;
    public final void entryRuleResultReports() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:61:1: ( ruleResultReports EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:62:1: ruleResultReports EOF
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:69:1: ruleResultReports : ( ( rule__ResultReports__Alternatives ) ) ;
    public final void ruleResultReports() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:73:2: ( ( ( rule__ResultReports__Alternatives ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:74:1: ( ( rule__ResultReports__Alternatives ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:74:1: ( ( rule__ResultReports__Alternatives ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:75:1: ( rule__ResultReports__Alternatives )
            {
             before(grammarAccess.getResultReportsAccess().getAlternatives()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:76:1: ( rule__ResultReports__Alternatives )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:76:2: rule__ResultReports__Alternatives
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:88:1: entryRuleResultReportCollection : ruleResultReportCollection EOF ;
    public final void entryRuleResultReportCollection() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:89:1: ( ruleResultReportCollection EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:90:1: ruleResultReportCollection EOF
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:97:1: ruleResultReportCollection : ( ( rule__ResultReportCollection__Group__0 ) ) ;
    public final void ruleResultReportCollection() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:101:2: ( ( ( rule__ResultReportCollection__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:102:1: ( ( rule__ResultReportCollection__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:102:1: ( ( rule__ResultReportCollection__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:103:1: ( rule__ResultReportCollection__Group__0 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:104:1: ( rule__ResultReportCollection__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:104:2: rule__ResultReportCollection__Group__0
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:116:1: entryRuleResultReport : ruleResultReport EOF ;
    public final void entryRuleResultReport() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:117:1: ( ruleResultReport EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:118:1: ruleResultReport EOF
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:125:1: ruleResultReport : ( ( rule__ResultReport__Group__0 ) ) ;
    public final void ruleResultReport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:129:2: ( ( ( rule__ResultReport__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:130:1: ( ( rule__ResultReport__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:130:1: ( ( rule__ResultReport__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:131:1: ( rule__ResultReport__Group__0 )
            {
             before(grammarAccess.getResultReportAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:132:1: ( rule__ResultReport__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:132:2: rule__ResultReport__Group__0
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


    // $ANTLR start "entryRuleIssuesReport"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:144:1: entryRuleIssuesReport : ruleIssuesReport EOF ;
    public final void entryRuleIssuesReport() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:145:1: ( ruleIssuesReport EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:146:1: ruleIssuesReport EOF
            {
             before(grammarAccess.getIssuesReportRule()); 
            pushFollow(FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport241);
            ruleIssuesReport();

            state._fsp--;

             after(grammarAccess.getIssuesReportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIssuesReport248); 

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
    // $ANTLR end "entryRuleIssuesReport"


    // $ANTLR start "ruleIssuesReport"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:153:1: ruleIssuesReport : ( ( rule__IssuesReport__Group__0 ) ) ;
    public final void ruleIssuesReport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:157:2: ( ( ( rule__IssuesReport__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:158:1: ( ( rule__IssuesReport__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:158:1: ( ( rule__IssuesReport__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:159:1: ( rule__IssuesReport__Group__0 )
            {
             before(grammarAccess.getIssuesReportAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:160:1: ( rule__IssuesReport__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:160:2: rule__IssuesReport__Group__0
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__0_in_ruleIssuesReport274);
            rule__IssuesReport__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIssuesReportAccess().getGroup()); 

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
    // $ANTLR end "ruleIssuesReport"


    // $ANTLR start "entryRuleResultContributor"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:174:1: entryRuleResultContributor : ruleResultContributor EOF ;
    public final void entryRuleResultContributor() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:175:1: ( ruleResultContributor EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:176:1: ruleResultContributor EOF
            {
             before(grammarAccess.getResultContributorRule()); 
            pushFollow(FOLLOW_ruleResultContributor_in_entryRuleResultContributor303);
            ruleResultContributor();

            state._fsp--;

             after(grammarAccess.getResultContributorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultContributor310); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:183:1: ruleResultContributor : ( ( rule__ResultContributor__Group__0 ) ) ;
    public final void ruleResultContributor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:187:2: ( ( ( rule__ResultContributor__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:188:1: ( ( rule__ResultContributor__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:188:1: ( ( rule__ResultContributor__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:189:1: ( rule__ResultContributor__Group__0 )
            {
             before(grammarAccess.getResultContributorAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:190:1: ( rule__ResultContributor__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:190:2: rule__ResultContributor__Group__0
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__0_in_ruleResultContributor336);
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


    // $ANTLR start "entryRuleReportIssue"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:202:1: entryRuleReportIssue : ruleReportIssue EOF ;
    public final void entryRuleReportIssue() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:203:1: ( ruleReportIssue EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:204:1: ruleReportIssue EOF
            {
             before(grammarAccess.getReportIssueRule()); 
            pushFollow(FOLLOW_ruleReportIssue_in_entryRuleReportIssue363);
            ruleReportIssue();

            state._fsp--;

             after(grammarAccess.getReportIssueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReportIssue370); 

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
    // $ANTLR end "entryRuleReportIssue"


    // $ANTLR start "ruleReportIssue"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:211:1: ruleReportIssue : ( ( rule__ReportIssue__Group__0 ) ) ;
    public final void ruleReportIssue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:215:2: ( ( ( rule__ReportIssue__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:216:1: ( ( rule__ReportIssue__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:216:1: ( ( rule__ReportIssue__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:217:1: ( rule__ReportIssue__Group__0 )
            {
             before(grammarAccess.getReportIssueAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:218:1: ( rule__ReportIssue__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:218:2: rule__ReportIssue__Group__0
            {
            pushFollow(FOLLOW_rule__ReportIssue__Group__0_in_ruleReportIssue396);
            rule__ReportIssue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReportIssueAccess().getGroup()); 

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
    // $ANTLR end "ruleReportIssue"


    // $ANTLR start "entryRuleResultData"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:230:1: entryRuleResultData : ruleResultData EOF ;
    public final void entryRuleResultData() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:231:1: ( ruleResultData EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:232:1: ruleResultData EOF
            {
             before(grammarAccess.getResultDataRule()); 
            pushFollow(FOLLOW_ruleResultData_in_entryRuleResultData423);
            ruleResultData();

            state._fsp--;

             after(grammarAccess.getResultDataRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultData430); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:239:1: ruleResultData : ( ( rule__ResultData__Group__0 ) ) ;
    public final void ruleResultData() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:243:2: ( ( ( rule__ResultData__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:244:1: ( ( rule__ResultData__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:244:1: ( ( rule__ResultData__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:245:1: ( rule__ResultData__Group__0 )
            {
             before(grammarAccess.getResultDataAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:246:1: ( rule__ResultData__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:246:2: rule__ResultData__Group__0
            {
            pushFollow(FOLLOW_rule__ResultData__Group__0_in_ruleResultData456);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:258:1: entryRuleURIID : ruleURIID EOF ;
    public final void entryRuleURIID() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:259:1: ( ruleURIID EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:260:1: ruleURIID EOF
            {
             before(grammarAccess.getURIIDRule()); 
            pushFollow(FOLLOW_ruleURIID_in_entryRuleURIID483);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getURIIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIID490); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:267:1: ruleURIID : ( RULE_STRING ) ;
    public final void ruleURIID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:271:2: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:272:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:272:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:273:1: RULE_STRING
            {
             before(grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIID516); 
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


    // $ANTLR start "ruleReportIssueType"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:287:1: ruleReportIssueType : ( ( rule__ReportIssueType__Alternatives ) ) ;
    public final void ruleReportIssueType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:291:1: ( ( ( rule__ReportIssueType__Alternatives ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:292:1: ( ( rule__ReportIssueType__Alternatives ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:292:1: ( ( rule__ReportIssueType__Alternatives ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:293:1: ( rule__ReportIssueType__Alternatives )
            {
             before(grammarAccess.getReportIssueTypeAccess().getAlternatives()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:294:1: ( rule__ReportIssueType__Alternatives )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:294:2: rule__ReportIssueType__Alternatives
            {
            pushFollow(FOLLOW_rule__ReportIssueType__Alternatives_in_ruleReportIssueType552);
            rule__ReportIssueType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getReportIssueTypeAccess().getAlternatives()); 

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
    // $ANTLR end "ruleReportIssueType"


    // $ANTLR start "rule__ResultReports__Alternatives"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:305:1: rule__ResultReports__Alternatives : ( ( ruleResultReport ) | ( ruleResultReportCollection ) | ( ruleIssuesReport ) );
    public final void rule__ResultReports__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:309:1: ( ( ruleResultReport ) | ( ruleResultReportCollection ) | ( ruleIssuesReport ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 21:
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
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:310:1: ( ruleResultReport )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:310:1: ( ruleResultReport )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:311:1: ruleResultReport
                    {
                     before(grammarAccess.getResultReportsAccess().getResultReportParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleResultReport_in_rule__ResultReports__Alternatives587);
                    ruleResultReport();

                    state._fsp--;

                     after(grammarAccess.getResultReportsAccess().getResultReportParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:316:6: ( ruleResultReportCollection )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:316:6: ( ruleResultReportCollection )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:317:1: ruleResultReportCollection
                    {
                     before(grammarAccess.getResultReportsAccess().getResultReportCollectionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleResultReportCollection_in_rule__ResultReports__Alternatives604);
                    ruleResultReportCollection();

                    state._fsp--;

                     after(grammarAccess.getResultReportsAccess().getResultReportCollectionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:322:6: ( ruleIssuesReport )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:322:6: ( ruleIssuesReport )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:323:1: ruleIssuesReport
                    {
                     before(grammarAccess.getResultReportsAccess().getIssuesReportParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleIssuesReport_in_rule__ResultReports__Alternatives621);
                    ruleIssuesReport();

                    state._fsp--;

                     after(grammarAccess.getResultReportsAccess().getIssuesReportParserRuleCall_2()); 

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


    // $ANTLR start "rule__ReportIssueType__Alternatives"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:334:1: rule__ReportIssueType__Alternatives : ( ( ( 'error' ) ) | ( ( 'warning' ) ) | ( ( 'success' ) ) | ( ( 'info' ) ) );
    public final void rule__ReportIssueType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:338:1: ( ( ( 'error' ) ) | ( ( 'warning' ) ) | ( ( 'success' ) ) | ( ( 'info' ) ) )
            int alt2=4;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:339:1: ( ( 'error' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:339:1: ( ( 'error' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:340:1: ( 'error' )
                    {
                     before(grammarAccess.getReportIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:341:1: ( 'error' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:341:3: 'error'
                    {
                    match(input,11,FOLLOW_11_in_rule__ReportIssueType__Alternatives655); 

                    }

                     after(grammarAccess.getReportIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:346:6: ( ( 'warning' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:346:6: ( ( 'warning' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:347:1: ( 'warning' )
                    {
                     before(grammarAccess.getReportIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:348:1: ( 'warning' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:348:3: 'warning'
                    {
                    match(input,12,FOLLOW_12_in_rule__ReportIssueType__Alternatives676); 

                    }

                     after(grammarAccess.getReportIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:353:6: ( ( 'success' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:353:6: ( ( 'success' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:354:1: ( 'success' )
                    {
                     before(grammarAccess.getReportIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_2()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:355:1: ( 'success' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:355:3: 'success'
                    {
                    match(input,13,FOLLOW_13_in_rule__ReportIssueType__Alternatives697); 

                    }

                     after(grammarAccess.getReportIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:360:6: ( ( 'info' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:360:6: ( ( 'info' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:361:1: ( 'info' )
                    {
                     before(grammarAccess.getReportIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:362:1: ( 'info' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:362:3: 'info'
                    {
                    match(input,14,FOLLOW_14_in_rule__ReportIssueType__Alternatives718); 

                    }

                     after(grammarAccess.getReportIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); 

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
    // $ANTLR end "rule__ReportIssueType__Alternatives"


    // $ANTLR start "rule__ResultReportCollection__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:374:1: rule__ResultReportCollection__Group__0 : rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1 ;
    public final void rule__ResultReportCollection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:378:1: ( rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:379:2: rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__0__Impl_in_rule__ResultReportCollection__Group__0751);
            rule__ResultReportCollection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__1_in_rule__ResultReportCollection__Group__0754);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:386:1: rule__ResultReportCollection__Group__0__Impl : ( 'reports' ) ;
    public final void rule__ResultReportCollection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:390:1: ( ( 'reports' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:391:1: ( 'reports' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:391:1: ( 'reports' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:392:1: 'reports'
            {
             before(grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__ResultReportCollection__Group__0__Impl782); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:405:1: rule__ResultReportCollection__Group__1 : rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2 ;
    public final void rule__ResultReportCollection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:409:1: ( rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:410:2: rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__1__Impl_in_rule__ResultReportCollection__Group__1813);
            rule__ResultReportCollection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__2_in_rule__ResultReportCollection__Group__1816);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:417:1: rule__ResultReportCollection__Group__1__Impl : ( ( rule__ResultReportCollection__NameAssignment_1 ) ) ;
    public final void rule__ResultReportCollection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:421:1: ( ( ( rule__ResultReportCollection__NameAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:422:1: ( ( rule__ResultReportCollection__NameAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:422:1: ( ( rule__ResultReportCollection__NameAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:423:1: ( rule__ResultReportCollection__NameAssignment_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:424:1: ( rule__ResultReportCollection__NameAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:424:2: rule__ResultReportCollection__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__NameAssignment_1_in_rule__ResultReportCollection__Group__1__Impl843);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:434:1: rule__ResultReportCollection__Group__2 : rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3 ;
    public final void rule__ResultReportCollection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:438:1: ( rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:439:2: rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__2__Impl_in_rule__ResultReportCollection__Group__2873);
            rule__ResultReportCollection__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__3_in_rule__ResultReportCollection__Group__2876);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:446:1: rule__ResultReportCollection__Group__2__Impl : ( ( rule__ResultReportCollection__Group_2__0 )? ) ;
    public final void rule__ResultReportCollection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:450:1: ( ( ( rule__ResultReportCollection__Group_2__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:451:1: ( ( rule__ResultReportCollection__Group_2__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:451:1: ( ( rule__ResultReportCollection__Group_2__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:452:1: ( rule__ResultReportCollection__Group_2__0 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:453:1: ( rule__ResultReportCollection__Group_2__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:453:2: rule__ResultReportCollection__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__0_in_rule__ResultReportCollection__Group__2__Impl903);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:463:1: rule__ResultReportCollection__Group__3 : rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4 ;
    public final void rule__ResultReportCollection__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:467:1: ( rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:468:2: rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__3__Impl_in_rule__ResultReportCollection__Group__3934);
            rule__ResultReportCollection__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__4_in_rule__ResultReportCollection__Group__3937);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:475:1: rule__ResultReportCollection__Group__3__Impl : ( '[' ) ;
    public final void rule__ResultReportCollection__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:479:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:480:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:480:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:481:1: '['
            {
             before(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_3()); 
            match(input,16,FOLLOW_16_in_rule__ResultReportCollection__Group__3__Impl965); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:494:1: rule__ResultReportCollection__Group__4 : rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5 ;
    public final void rule__ResultReportCollection__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:498:1: ( rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:499:2: rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__4__Impl_in_rule__ResultReportCollection__Group__4996);
            rule__ResultReportCollection__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__5_in_rule__ResultReportCollection__Group__4999);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:506:1: rule__ResultReportCollection__Group__4__Impl : ( 'target' ) ;
    public final void rule__ResultReportCollection__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:510:1: ( ( 'target' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:511:1: ( 'target' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:511:1: ( 'target' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:512:1: 'target'
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetKeyword_4()); 
            match(input,17,FOLLOW_17_in_rule__ResultReportCollection__Group__4__Impl1027); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:525:1: rule__ResultReportCollection__Group__5 : rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6 ;
    public final void rule__ResultReportCollection__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:529:1: ( rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:530:2: rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__5__Impl_in_rule__ResultReportCollection__Group__51058);
            rule__ResultReportCollection__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__6_in_rule__ResultReportCollection__Group__51061);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:537:1: rule__ResultReportCollection__Group__5__Impl : ( ( rule__ResultReportCollection__TargetAssignment_5 ) ) ;
    public final void rule__ResultReportCollection__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:541:1: ( ( ( rule__ResultReportCollection__TargetAssignment_5 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:542:1: ( ( rule__ResultReportCollection__TargetAssignment_5 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:542:1: ( ( rule__ResultReportCollection__TargetAssignment_5 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:543:1: ( rule__ResultReportCollection__TargetAssignment_5 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:544:1: ( rule__ResultReportCollection__TargetAssignment_5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:544:2: rule__ResultReportCollection__TargetAssignment_5
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__TargetAssignment_5_in_rule__ResultReportCollection__Group__5__Impl1088);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:554:1: rule__ResultReportCollection__Group__6 : rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7 ;
    public final void rule__ResultReportCollection__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:558:1: ( rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:559:2: rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__6__Impl_in_rule__ResultReportCollection__Group__61118);
            rule__ResultReportCollection__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__7_in_rule__ResultReportCollection__Group__61121);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:566:1: rule__ResultReportCollection__Group__6__Impl : ( ( rule__ResultReportCollection__Group_6__0 )? ) ;
    public final void rule__ResultReportCollection__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:570:1: ( ( ( rule__ResultReportCollection__Group_6__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:571:1: ( ( rule__ResultReportCollection__Group_6__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:571:1: ( ( rule__ResultReportCollection__Group_6__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:572:1: ( rule__ResultReportCollection__Group_6__0 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:573:1: ( rule__ResultReportCollection__Group_6__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:573:2: rule__ResultReportCollection__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__0_in_rule__ResultReportCollection__Group__6__Impl1148);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:583:1: rule__ResultReportCollection__Group__7 : rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8 ;
    public final void rule__ResultReportCollection__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:587:1: ( rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:588:2: rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__7__Impl_in_rule__ResultReportCollection__Group__71179);
            rule__ResultReportCollection__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__8_in_rule__ResultReportCollection__Group__71182);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:595:1: rule__ResultReportCollection__Group__7__Impl : ( ( rule__ResultReportCollection__ContentAssignment_7 )* ) ;
    public final void rule__ResultReportCollection__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:599:1: ( ( ( rule__ResultReportCollection__ContentAssignment_7 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:600:1: ( ( rule__ResultReportCollection__ContentAssignment_7 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:600:1: ( ( rule__ResultReportCollection__ContentAssignment_7 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:601:1: ( rule__ResultReportCollection__ContentAssignment_7 )*
            {
             before(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:602:1: ( rule__ResultReportCollection__ContentAssignment_7 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==22) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:602:2: rule__ResultReportCollection__ContentAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__ResultReportCollection__ContentAssignment_7_in_rule__ResultReportCollection__Group__7__Impl1209);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:612:1: rule__ResultReportCollection__Group__8 : rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9 ;
    public final void rule__ResultReportCollection__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:616:1: ( rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:617:2: rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__8__Impl_in_rule__ResultReportCollection__Group__81240);
            rule__ResultReportCollection__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__9_in_rule__ResultReportCollection__Group__81243);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:624:1: rule__ResultReportCollection__Group__8__Impl : ( ( rule__ResultReportCollection__Group_8__0 )? ) ;
    public final void rule__ResultReportCollection__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:628:1: ( ( ( rule__ResultReportCollection__Group_8__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:629:1: ( ( rule__ResultReportCollection__Group_8__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:629:1: ( ( rule__ResultReportCollection__Group_8__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:630:1: ( rule__ResultReportCollection__Group_8__0 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup_8()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:631:1: ( rule__ResultReportCollection__Group_8__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:631:2: rule__ResultReportCollection__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__Group_8__0_in_rule__ResultReportCollection__Group__8__Impl1270);
                    rule__ResultReportCollection__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportCollectionAccess().getGroup_8()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:641:1: rule__ResultReportCollection__Group__9 : rule__ResultReportCollection__Group__9__Impl ;
    public final void rule__ResultReportCollection__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:645:1: ( rule__ResultReportCollection__Group__9__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:646:2: rule__ResultReportCollection__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__9__Impl_in_rule__ResultReportCollection__Group__91301);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:652:1: rule__ResultReportCollection__Group__9__Impl : ( ']' ) ;
    public final void rule__ResultReportCollection__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:656:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:657:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:657:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:658:1: ']'
            {
             before(grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9()); 
            match(input,18,FOLLOW_18_in_rule__ResultReportCollection__Group__9__Impl1329); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:691:1: rule__ResultReportCollection__Group_2__0 : rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1 ;
    public final void rule__ResultReportCollection__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:695:1: ( rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:696:2: rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__0__Impl_in_rule__ResultReportCollection__Group_2__01380);
            rule__ResultReportCollection__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__1_in_rule__ResultReportCollection__Group_2__01383);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:703:1: rule__ResultReportCollection__Group_2__0__Impl : ( ':' ) ;
    public final void rule__ResultReportCollection__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:707:1: ( ( ':' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:708:1: ( ':' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:708:1: ( ':' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:709:1: ':'
            {
             before(grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0()); 
            match(input,19,FOLLOW_19_in_rule__ResultReportCollection__Group_2__0__Impl1411); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:722:1: rule__ResultReportCollection__Group_2__1 : rule__ResultReportCollection__Group_2__1__Impl ;
    public final void rule__ResultReportCollection__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:726:1: ( rule__ResultReportCollection__Group_2__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:727:2: rule__ResultReportCollection__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__1__Impl_in_rule__ResultReportCollection__Group_2__11442);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:733:1: rule__ResultReportCollection__Group_2__1__Impl : ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) ) ;
    public final void rule__ResultReportCollection__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:737:1: ( ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:738:1: ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:738:1: ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:739:1: ( rule__ResultReportCollection__TitleAssignment_2_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:740:1: ( rule__ResultReportCollection__TitleAssignment_2_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:740:2: rule__ResultReportCollection__TitleAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__TitleAssignment_2_1_in_rule__ResultReportCollection__Group_2__1__Impl1469);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:754:1: rule__ResultReportCollection__Group_6__0 : rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1 ;
    public final void rule__ResultReportCollection__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:758:1: ( rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:759:2: rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__0__Impl_in_rule__ResultReportCollection__Group_6__01503);
            rule__ResultReportCollection__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__1_in_rule__ResultReportCollection__Group_6__01506);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:766:1: rule__ResultReportCollection__Group_6__0__Impl : ( 'description' ) ;
    public final void rule__ResultReportCollection__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:770:1: ( ( 'description' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:771:1: ( 'description' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:771:1: ( 'description' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:772:1: 'description'
            {
             before(grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0()); 
            match(input,20,FOLLOW_20_in_rule__ResultReportCollection__Group_6__0__Impl1534); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:785:1: rule__ResultReportCollection__Group_6__1 : rule__ResultReportCollection__Group_6__1__Impl ;
    public final void rule__ResultReportCollection__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:789:1: ( rule__ResultReportCollection__Group_6__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:790:2: rule__ResultReportCollection__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__1__Impl_in_rule__ResultReportCollection__Group_6__11565);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:796:1: rule__ResultReportCollection__Group_6__1__Impl : ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) ) ;
    public final void rule__ResultReportCollection__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:800:1: ( ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:801:1: ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:801:1: ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:802:1: ( rule__ResultReportCollection__DecriptionAssignment_6_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getDecriptionAssignment_6_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:803:1: ( rule__ResultReportCollection__DecriptionAssignment_6_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:803:2: rule__ResultReportCollection__DecriptionAssignment_6_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__DecriptionAssignment_6_1_in_rule__ResultReportCollection__Group_6__1__Impl1592);
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


    // $ANTLR start "rule__ResultReportCollection__Group_8__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:817:1: rule__ResultReportCollection__Group_8__0 : rule__ResultReportCollection__Group_8__0__Impl rule__ResultReportCollection__Group_8__1 ;
    public final void rule__ResultReportCollection__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:821:1: ( rule__ResultReportCollection__Group_8__0__Impl rule__ResultReportCollection__Group_8__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:822:2: rule__ResultReportCollection__Group_8__0__Impl rule__ResultReportCollection__Group_8__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_8__0__Impl_in_rule__ResultReportCollection__Group_8__01626);
            rule__ResultReportCollection__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group_8__1_in_rule__ResultReportCollection__Group_8__01629);
            rule__ResultReportCollection__Group_8__1();

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
    // $ANTLR end "rule__ResultReportCollection__Group_8__0"


    // $ANTLR start "rule__ResultReportCollection__Group_8__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:829:1: rule__ResultReportCollection__Group_8__0__Impl : ( 'issues' ) ;
    public final void rule__ResultReportCollection__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:833:1: ( ( 'issues' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:834:1: ( 'issues' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:834:1: ( 'issues' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:835:1: 'issues'
            {
             before(grammarAccess.getResultReportCollectionAccess().getIssuesKeyword_8_0()); 
            match(input,21,FOLLOW_21_in_rule__ResultReportCollection__Group_8__0__Impl1657); 
             after(grammarAccess.getResultReportCollectionAccess().getIssuesKeyword_8_0()); 

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
    // $ANTLR end "rule__ResultReportCollection__Group_8__0__Impl"


    // $ANTLR start "rule__ResultReportCollection__Group_8__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:848:1: rule__ResultReportCollection__Group_8__1 : rule__ResultReportCollection__Group_8__1__Impl ;
    public final void rule__ResultReportCollection__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:852:1: ( rule__ResultReportCollection__Group_8__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:853:2: rule__ResultReportCollection__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_8__1__Impl_in_rule__ResultReportCollection__Group_8__11688);
            rule__ResultReportCollection__Group_8__1__Impl();

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
    // $ANTLR end "rule__ResultReportCollection__Group_8__1"


    // $ANTLR start "rule__ResultReportCollection__Group_8__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:859:1: rule__ResultReportCollection__Group_8__1__Impl : ( ( rule__ResultReportCollection__IssuesAssignment_8_1 )* ) ;
    public final void rule__ResultReportCollection__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:863:1: ( ( ( rule__ResultReportCollection__IssuesAssignment_8_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:864:1: ( ( rule__ResultReportCollection__IssuesAssignment_8_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:864:1: ( ( rule__ResultReportCollection__IssuesAssignment_8_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:865:1: ( rule__ResultReportCollection__IssuesAssignment_8_1 )*
            {
             before(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:866:1: ( rule__ResultReportCollection__IssuesAssignment_8_1 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=11 && LA7_0<=14)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:866:2: rule__ResultReportCollection__IssuesAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultReportCollection__IssuesAssignment_8_1_in_rule__ResultReportCollection__Group_8__1__Impl1715);
            	    rule__ResultReportCollection__IssuesAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8_1()); 

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
    // $ANTLR end "rule__ResultReportCollection__Group_8__1__Impl"


    // $ANTLR start "rule__ResultReport__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:880:1: rule__ResultReport__Group__0 : rule__ResultReport__Group__0__Impl rule__ResultReport__Group__1 ;
    public final void rule__ResultReport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:884:1: ( rule__ResultReport__Group__0__Impl rule__ResultReport__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:885:2: rule__ResultReport__Group__0__Impl rule__ResultReport__Group__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__0__Impl_in_rule__ResultReport__Group__01750);
            rule__ResultReport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__1_in_rule__ResultReport__Group__01753);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:892:1: rule__ResultReport__Group__0__Impl : ( 'report' ) ;
    public final void rule__ResultReport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:896:1: ( ( 'report' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:897:1: ( 'report' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:897:1: ( 'report' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:898:1: 'report'
            {
             before(grammarAccess.getResultReportAccess().getReportKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__ResultReport__Group__0__Impl1781); 
             after(grammarAccess.getResultReportAccess().getReportKeyword_0()); 

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
    // $ANTLR end "rule__ResultReport__Group__0__Impl"


    // $ANTLR start "rule__ResultReport__Group__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:911:1: rule__ResultReport__Group__1 : rule__ResultReport__Group__1__Impl rule__ResultReport__Group__2 ;
    public final void rule__ResultReport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:915:1: ( rule__ResultReport__Group__1__Impl rule__ResultReport__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:916:2: rule__ResultReport__Group__1__Impl rule__ResultReport__Group__2
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__1__Impl_in_rule__ResultReport__Group__11812);
            rule__ResultReport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__2_in_rule__ResultReport__Group__11815);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:923:1: rule__ResultReport__Group__1__Impl : ( ( rule__ResultReport__NameAssignment_1 ) ) ;
    public final void rule__ResultReport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:927:1: ( ( ( rule__ResultReport__NameAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:928:1: ( ( rule__ResultReport__NameAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:928:1: ( ( rule__ResultReport__NameAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:929:1: ( rule__ResultReport__NameAssignment_1 )
            {
             before(grammarAccess.getResultReportAccess().getNameAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:930:1: ( rule__ResultReport__NameAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:930:2: rule__ResultReport__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultReport__NameAssignment_1_in_rule__ResultReport__Group__1__Impl1842);
            rule__ResultReport__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getNameAssignment_1()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:940:1: rule__ResultReport__Group__2 : rule__ResultReport__Group__2__Impl rule__ResultReport__Group__3 ;
    public final void rule__ResultReport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:944:1: ( rule__ResultReport__Group__2__Impl rule__ResultReport__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:945:2: rule__ResultReport__Group__2__Impl rule__ResultReport__Group__3
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__2__Impl_in_rule__ResultReport__Group__21872);
            rule__ResultReport__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__3_in_rule__ResultReport__Group__21875);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:952:1: rule__ResultReport__Group__2__Impl : ( ( rule__ResultReport__Group_2__0 )? ) ;
    public final void rule__ResultReport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:956:1: ( ( ( rule__ResultReport__Group_2__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:957:1: ( ( rule__ResultReport__Group_2__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:957:1: ( ( rule__ResultReport__Group_2__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:958:1: ( rule__ResultReport__Group_2__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:959:1: ( rule__ResultReport__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:959:2: rule__ResultReport__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_2__0_in_rule__ResultReport__Group__2__Impl1902);
                    rule__ResultReport__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportAccess().getGroup_2()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:969:1: rule__ResultReport__Group__3 : rule__ResultReport__Group__3__Impl rule__ResultReport__Group__4 ;
    public final void rule__ResultReport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:973:1: ( rule__ResultReport__Group__3__Impl rule__ResultReport__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:974:2: rule__ResultReport__Group__3__Impl rule__ResultReport__Group__4
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__3__Impl_in_rule__ResultReport__Group__31933);
            rule__ResultReport__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__4_in_rule__ResultReport__Group__31936);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:981:1: rule__ResultReport__Group__3__Impl : ( '[' ) ;
    public final void rule__ResultReport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:985:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:986:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:986:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:987:1: '['
            {
             before(grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_3()); 
            match(input,16,FOLLOW_16_in_rule__ResultReport__Group__3__Impl1964); 
             after(grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_3()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1000:1: rule__ResultReport__Group__4 : rule__ResultReport__Group__4__Impl rule__ResultReport__Group__5 ;
    public final void rule__ResultReport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1004:1: ( rule__ResultReport__Group__4__Impl rule__ResultReport__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1005:2: rule__ResultReport__Group__4__Impl rule__ResultReport__Group__5
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__4__Impl_in_rule__ResultReport__Group__41995);
            rule__ResultReport__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__5_in_rule__ResultReport__Group__41998);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1012:1: rule__ResultReport__Group__4__Impl : ( 'target' ) ;
    public final void rule__ResultReport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1016:1: ( ( 'target' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1017:1: ( 'target' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1017:1: ( 'target' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1018:1: 'target'
            {
             before(grammarAccess.getResultReportAccess().getTargetKeyword_4()); 
            match(input,17,FOLLOW_17_in_rule__ResultReport__Group__4__Impl2026); 
             after(grammarAccess.getResultReportAccess().getTargetKeyword_4()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1031:1: rule__ResultReport__Group__5 : rule__ResultReport__Group__5__Impl rule__ResultReport__Group__6 ;
    public final void rule__ResultReport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1035:1: ( rule__ResultReport__Group__5__Impl rule__ResultReport__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1036:2: rule__ResultReport__Group__5__Impl rule__ResultReport__Group__6
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__5__Impl_in_rule__ResultReport__Group__52057);
            rule__ResultReport__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__6_in_rule__ResultReport__Group__52060);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1043:1: rule__ResultReport__Group__5__Impl : ( ( rule__ResultReport__TargetAssignment_5 ) ) ;
    public final void rule__ResultReport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1047:1: ( ( ( rule__ResultReport__TargetAssignment_5 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1048:1: ( ( rule__ResultReport__TargetAssignment_5 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1048:1: ( ( rule__ResultReport__TargetAssignment_5 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1049:1: ( rule__ResultReport__TargetAssignment_5 )
            {
             before(grammarAccess.getResultReportAccess().getTargetAssignment_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1050:1: ( rule__ResultReport__TargetAssignment_5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1050:2: rule__ResultReport__TargetAssignment_5
            {
            pushFollow(FOLLOW_rule__ResultReport__TargetAssignment_5_in_rule__ResultReport__Group__5__Impl2087);
            rule__ResultReport__TargetAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getTargetAssignment_5()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1060:1: rule__ResultReport__Group__6 : rule__ResultReport__Group__6__Impl rule__ResultReport__Group__7 ;
    public final void rule__ResultReport__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1064:1: ( rule__ResultReport__Group__6__Impl rule__ResultReport__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1065:2: rule__ResultReport__Group__6__Impl rule__ResultReport__Group__7
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__6__Impl_in_rule__ResultReport__Group__62117);
            rule__ResultReport__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__7_in_rule__ResultReport__Group__62120);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1072:1: rule__ResultReport__Group__6__Impl : ( ( rule__ResultReport__Group_6__0 )? ) ;
    public final void rule__ResultReport__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1076:1: ( ( ( rule__ResultReport__Group_6__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1077:1: ( ( rule__ResultReport__Group_6__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1077:1: ( ( rule__ResultReport__Group_6__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1078:1: ( rule__ResultReport__Group_6__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1079:1: ( rule__ResultReport__Group_6__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1079:2: rule__ResultReport__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_6__0_in_rule__ResultReport__Group__6__Impl2147);
                    rule__ResultReport__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportAccess().getGroup_6()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1089:1: rule__ResultReport__Group__7 : rule__ResultReport__Group__7__Impl rule__ResultReport__Group__8 ;
    public final void rule__ResultReport__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1093:1: ( rule__ResultReport__Group__7__Impl rule__ResultReport__Group__8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1094:2: rule__ResultReport__Group__7__Impl rule__ResultReport__Group__8
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__7__Impl_in_rule__ResultReport__Group__72178);
            rule__ResultReport__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__8_in_rule__ResultReport__Group__72181);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1101:1: rule__ResultReport__Group__7__Impl : ( ( rule__ResultReport__Group_7__0 )? ) ;
    public final void rule__ResultReport__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1105:1: ( ( ( rule__ResultReport__Group_7__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1106:1: ( ( rule__ResultReport__Group_7__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1106:1: ( ( rule__ResultReport__Group_7__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1107:1: ( rule__ResultReport__Group_7__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_7()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1108:1: ( rule__ResultReport__Group_7__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1108:2: rule__ResultReport__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_7__0_in_rule__ResultReport__Group__7__Impl2208);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1118:1: rule__ResultReport__Group__8 : rule__ResultReport__Group__8__Impl rule__ResultReport__Group__9 ;
    public final void rule__ResultReport__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1122:1: ( rule__ResultReport__Group__8__Impl rule__ResultReport__Group__9 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1123:2: rule__ResultReport__Group__8__Impl rule__ResultReport__Group__9
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__8__Impl_in_rule__ResultReport__Group__82239);
            rule__ResultReport__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__9_in_rule__ResultReport__Group__82242);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1130:1: rule__ResultReport__Group__8__Impl : ( ( rule__ResultReport__Group_8__0 )? ) ;
    public final void rule__ResultReport__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1134:1: ( ( ( rule__ResultReport__Group_8__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1135:1: ( ( rule__ResultReport__Group_8__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1135:1: ( ( rule__ResultReport__Group_8__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1136:1: ( rule__ResultReport__Group_8__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_8()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1137:1: ( rule__ResultReport__Group_8__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1137:2: rule__ResultReport__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_8__0_in_rule__ResultReport__Group__8__Impl2269);
                    rule__ResultReport__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultReportAccess().getGroup_8()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1147:1: rule__ResultReport__Group__9 : rule__ResultReport__Group__9__Impl rule__ResultReport__Group__10 ;
    public final void rule__ResultReport__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1151:1: ( rule__ResultReport__Group__9__Impl rule__ResultReport__Group__10 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1152:2: rule__ResultReport__Group__9__Impl rule__ResultReport__Group__10
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__9__Impl_in_rule__ResultReport__Group__92300);
            rule__ResultReport__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__10_in_rule__ResultReport__Group__92303);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1159:1: rule__ResultReport__Group__9__Impl : ( ( rule__ResultReport__Group_9__0 )? ) ;
    public final void rule__ResultReport__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1163:1: ( ( ( rule__ResultReport__Group_9__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1164:1: ( ( rule__ResultReport__Group_9__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1164:1: ( ( rule__ResultReport__Group_9__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1165:1: ( rule__ResultReport__Group_9__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_9()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1166:1: ( rule__ResultReport__Group_9__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==21) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1166:2: rule__ResultReport__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_9__0_in_rule__ResultReport__Group__9__Impl2330);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1176:1: rule__ResultReport__Group__10 : rule__ResultReport__Group__10__Impl ;
    public final void rule__ResultReport__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1180:1: ( rule__ResultReport__Group__10__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1181:2: rule__ResultReport__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__10__Impl_in_rule__ResultReport__Group__102361);
            rule__ResultReport__Group__10__Impl();

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1187:1: rule__ResultReport__Group__10__Impl : ( ']' ) ;
    public final void rule__ResultReport__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1191:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1192:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1192:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1193:1: ']'
            {
             before(grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_10()); 
            match(input,18,FOLLOW_18_in_rule__ResultReport__Group__10__Impl2389); 
             after(grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_10()); 

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


    // $ANTLR start "rule__ResultReport__Group_2__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1228:1: rule__ResultReport__Group_2__0 : rule__ResultReport__Group_2__0__Impl rule__ResultReport__Group_2__1 ;
    public final void rule__ResultReport__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1232:1: ( rule__ResultReport__Group_2__0__Impl rule__ResultReport__Group_2__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1233:2: rule__ResultReport__Group_2__0__Impl rule__ResultReport__Group_2__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_2__0__Impl_in_rule__ResultReport__Group_2__02442);
            rule__ResultReport__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_2__1_in_rule__ResultReport__Group_2__02445);
            rule__ResultReport__Group_2__1();

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
    // $ANTLR end "rule__ResultReport__Group_2__0"


    // $ANTLR start "rule__ResultReport__Group_2__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1240:1: rule__ResultReport__Group_2__0__Impl : ( ':' ) ;
    public final void rule__ResultReport__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1244:1: ( ( ':' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1245:1: ( ':' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1245:1: ( ':' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1246:1: ':'
            {
             before(grammarAccess.getResultReportAccess().getColonKeyword_2_0()); 
            match(input,19,FOLLOW_19_in_rule__ResultReport__Group_2__0__Impl2473); 
             after(grammarAccess.getResultReportAccess().getColonKeyword_2_0()); 

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
    // $ANTLR end "rule__ResultReport__Group_2__0__Impl"


    // $ANTLR start "rule__ResultReport__Group_2__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1259:1: rule__ResultReport__Group_2__1 : rule__ResultReport__Group_2__1__Impl ;
    public final void rule__ResultReport__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1263:1: ( rule__ResultReport__Group_2__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1264:2: rule__ResultReport__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_2__1__Impl_in_rule__ResultReport__Group_2__12504);
            rule__ResultReport__Group_2__1__Impl();

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
    // $ANTLR end "rule__ResultReport__Group_2__1"


    // $ANTLR start "rule__ResultReport__Group_2__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1270:1: rule__ResultReport__Group_2__1__Impl : ( ( rule__ResultReport__TitleAssignment_2_1 ) ) ;
    public final void rule__ResultReport__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1274:1: ( ( ( rule__ResultReport__TitleAssignment_2_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1275:1: ( ( rule__ResultReport__TitleAssignment_2_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1275:1: ( ( rule__ResultReport__TitleAssignment_2_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1276:1: ( rule__ResultReport__TitleAssignment_2_1 )
            {
             before(grammarAccess.getResultReportAccess().getTitleAssignment_2_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1277:1: ( rule__ResultReport__TitleAssignment_2_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1277:2: rule__ResultReport__TitleAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ResultReport__TitleAssignment_2_1_in_rule__ResultReport__Group_2__1__Impl2531);
            rule__ResultReport__TitleAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getTitleAssignment_2_1()); 

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
    // $ANTLR end "rule__ResultReport__Group_2__1__Impl"


    // $ANTLR start "rule__ResultReport__Group_6__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1291:1: rule__ResultReport__Group_6__0 : rule__ResultReport__Group_6__0__Impl rule__ResultReport__Group_6__1 ;
    public final void rule__ResultReport__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1295:1: ( rule__ResultReport__Group_6__0__Impl rule__ResultReport__Group_6__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1296:2: rule__ResultReport__Group_6__0__Impl rule__ResultReport__Group_6__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_6__0__Impl_in_rule__ResultReport__Group_6__02565);
            rule__ResultReport__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_6__1_in_rule__ResultReport__Group_6__02568);
            rule__ResultReport__Group_6__1();

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
    // $ANTLR end "rule__ResultReport__Group_6__0"


    // $ANTLR start "rule__ResultReport__Group_6__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1303:1: rule__ResultReport__Group_6__0__Impl : ( 'description' ) ;
    public final void rule__ResultReport__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1307:1: ( ( 'description' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1308:1: ( 'description' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1308:1: ( 'description' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1309:1: 'description'
            {
             before(grammarAccess.getResultReportAccess().getDescriptionKeyword_6_0()); 
            match(input,20,FOLLOW_20_in_rule__ResultReport__Group_6__0__Impl2596); 
             after(grammarAccess.getResultReportAccess().getDescriptionKeyword_6_0()); 

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
    // $ANTLR end "rule__ResultReport__Group_6__0__Impl"


    // $ANTLR start "rule__ResultReport__Group_6__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1322:1: rule__ResultReport__Group_6__1 : rule__ResultReport__Group_6__1__Impl ;
    public final void rule__ResultReport__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1326:1: ( rule__ResultReport__Group_6__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1327:2: rule__ResultReport__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_6__1__Impl_in_rule__ResultReport__Group_6__12627);
            rule__ResultReport__Group_6__1__Impl();

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
    // $ANTLR end "rule__ResultReport__Group_6__1"


    // $ANTLR start "rule__ResultReport__Group_6__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1333:1: rule__ResultReport__Group_6__1__Impl : ( ( rule__ResultReport__DecriptionAssignment_6_1 ) ) ;
    public final void rule__ResultReport__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1337:1: ( ( ( rule__ResultReport__DecriptionAssignment_6_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1338:1: ( ( rule__ResultReport__DecriptionAssignment_6_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1338:1: ( ( rule__ResultReport__DecriptionAssignment_6_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1339:1: ( rule__ResultReport__DecriptionAssignment_6_1 )
            {
             before(grammarAccess.getResultReportAccess().getDecriptionAssignment_6_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1340:1: ( rule__ResultReport__DecriptionAssignment_6_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1340:2: rule__ResultReport__DecriptionAssignment_6_1
            {
            pushFollow(FOLLOW_rule__ResultReport__DecriptionAssignment_6_1_in_rule__ResultReport__Group_6__1__Impl2654);
            rule__ResultReport__DecriptionAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getDecriptionAssignment_6_1()); 

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
    // $ANTLR end "rule__ResultReport__Group_6__1__Impl"


    // $ANTLR start "rule__ResultReport__Group_7__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1354:1: rule__ResultReport__Group_7__0 : rule__ResultReport__Group_7__0__Impl rule__ResultReport__Group_7__1 ;
    public final void rule__ResultReport__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1358:1: ( rule__ResultReport__Group_7__0__Impl rule__ResultReport__Group_7__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1359:2: rule__ResultReport__Group_7__0__Impl rule__ResultReport__Group_7__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_7__0__Impl_in_rule__ResultReport__Group_7__02688);
            rule__ResultReport__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_7__1_in_rule__ResultReport__Group_7__02691);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1366:1: rule__ResultReport__Group_7__0__Impl : ( 'heading' ) ;
    public final void rule__ResultReport__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1370:1: ( ( 'heading' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1371:1: ( 'heading' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1371:1: ( 'heading' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1372:1: 'heading'
            {
             before(grammarAccess.getResultReportAccess().getHeadingKeyword_7_0()); 
            match(input,23,FOLLOW_23_in_rule__ResultReport__Group_7__0__Impl2719); 
             after(grammarAccess.getResultReportAccess().getHeadingKeyword_7_0()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1385:1: rule__ResultReport__Group_7__1 : rule__ResultReport__Group_7__1__Impl rule__ResultReport__Group_7__2 ;
    public final void rule__ResultReport__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1389:1: ( rule__ResultReport__Group_7__1__Impl rule__ResultReport__Group_7__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1390:2: rule__ResultReport__Group_7__1__Impl rule__ResultReport__Group_7__2
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_7__1__Impl_in_rule__ResultReport__Group_7__12750);
            rule__ResultReport__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_7__2_in_rule__ResultReport__Group_7__12753);
            rule__ResultReport__Group_7__2();

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1397:1: rule__ResultReport__Group_7__1__Impl : ( ( rule__ResultReport__HeadingAssignment_7_1 ) ) ;
    public final void rule__ResultReport__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1401:1: ( ( ( rule__ResultReport__HeadingAssignment_7_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1402:1: ( ( rule__ResultReport__HeadingAssignment_7_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1402:1: ( ( rule__ResultReport__HeadingAssignment_7_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1403:1: ( rule__ResultReport__HeadingAssignment_7_1 )
            {
             before(grammarAccess.getResultReportAccess().getHeadingAssignment_7_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1404:1: ( rule__ResultReport__HeadingAssignment_7_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1404:2: rule__ResultReport__HeadingAssignment_7_1
            {
            pushFollow(FOLLOW_rule__ResultReport__HeadingAssignment_7_1_in_rule__ResultReport__Group_7__1__Impl2780);
            rule__ResultReport__HeadingAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getHeadingAssignment_7_1()); 

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


    // $ANTLR start "rule__ResultReport__Group_7__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1414:1: rule__ResultReport__Group_7__2 : rule__ResultReport__Group_7__2__Impl ;
    public final void rule__ResultReport__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1418:1: ( rule__ResultReport__Group_7__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1419:2: rule__ResultReport__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_7__2__Impl_in_rule__ResultReport__Group_7__22810);
            rule__ResultReport__Group_7__2__Impl();

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
    // $ANTLR end "rule__ResultReport__Group_7__2"


    // $ANTLR start "rule__ResultReport__Group_7__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1425:1: rule__ResultReport__Group_7__2__Impl : ( ( rule__ResultReport__ContentAssignment_7_2 )* ) ;
    public final void rule__ResultReport__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1429:1: ( ( ( rule__ResultReport__ContentAssignment_7_2 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1430:1: ( ( rule__ResultReport__ContentAssignment_7_2 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1430:1: ( ( rule__ResultReport__ContentAssignment_7_2 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1431:1: ( rule__ResultReport__ContentAssignment_7_2 )*
            {
             before(grammarAccess.getResultReportAccess().getContentAssignment_7_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1432:1: ( rule__ResultReport__ContentAssignment_7_2 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==25) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1432:2: rule__ResultReport__ContentAssignment_7_2
            	    {
            	    pushFollow(FOLLOW_rule__ResultReport__ContentAssignment_7_2_in_rule__ResultReport__Group_7__2__Impl2837);
            	    rule__ResultReport__ContentAssignment_7_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getResultReportAccess().getContentAssignment_7_2()); 

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
    // $ANTLR end "rule__ResultReport__Group_7__2__Impl"


    // $ANTLR start "rule__ResultReport__Group_8__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1448:1: rule__ResultReport__Group_8__0 : rule__ResultReport__Group_8__0__Impl rule__ResultReport__Group_8__1 ;
    public final void rule__ResultReport__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1452:1: ( rule__ResultReport__Group_8__0__Impl rule__ResultReport__Group_8__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1453:2: rule__ResultReport__Group_8__0__Impl rule__ResultReport__Group_8__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_8__0__Impl_in_rule__ResultReport__Group_8__02874);
            rule__ResultReport__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_8__1_in_rule__ResultReport__Group_8__02877);
            rule__ResultReport__Group_8__1();

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
    // $ANTLR end "rule__ResultReport__Group_8__0"


    // $ANTLR start "rule__ResultReport__Group_8__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1460:1: rule__ResultReport__Group_8__0__Impl : ( 'results' ) ;
    public final void rule__ResultReport__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1464:1: ( ( 'results' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1465:1: ( 'results' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1465:1: ( 'results' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1466:1: 'results'
            {
             before(grammarAccess.getResultReportAccess().getResultsKeyword_8_0()); 
            match(input,24,FOLLOW_24_in_rule__ResultReport__Group_8__0__Impl2905); 
             after(grammarAccess.getResultReportAccess().getResultsKeyword_8_0()); 

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
    // $ANTLR end "rule__ResultReport__Group_8__0__Impl"


    // $ANTLR start "rule__ResultReport__Group_8__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1479:1: rule__ResultReport__Group_8__1 : rule__ResultReport__Group_8__1__Impl ;
    public final void rule__ResultReport__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1483:1: ( rule__ResultReport__Group_8__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1484:2: rule__ResultReport__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_8__1__Impl_in_rule__ResultReport__Group_8__12936);
            rule__ResultReport__Group_8__1__Impl();

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
    // $ANTLR end "rule__ResultReport__Group_8__1"


    // $ANTLR start "rule__ResultReport__Group_8__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1490:1: rule__ResultReport__Group_8__1__Impl : ( ( ( rule__ResultReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_8_1 )* ) ) ;
    public final void rule__ResultReport__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1494:1: ( ( ( ( rule__ResultReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_8_1 )* ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1495:1: ( ( ( rule__ResultReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_8_1 )* ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1495:1: ( ( ( rule__ResultReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_8_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1496:1: ( ( rule__ResultReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_8_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1496:1: ( ( rule__ResultReport__ResultDataAssignment_8_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1497:1: ( rule__ResultReport__ResultDataAssignment_8_1 )
            {
             before(grammarAccess.getResultReportAccess().getResultDataAssignment_8_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1498:1: ( rule__ResultReport__ResultDataAssignment_8_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1498:2: rule__ResultReport__ResultDataAssignment_8_1
            {
            pushFollow(FOLLOW_rule__ResultReport__ResultDataAssignment_8_1_in_rule__ResultReport__Group_8__1__Impl2965);
            rule__ResultReport__ResultDataAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getResultDataAssignment_8_1()); 

            }

            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1501:1: ( ( rule__ResultReport__ResultDataAssignment_8_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1502:1: ( rule__ResultReport__ResultDataAssignment_8_1 )*
            {
             before(grammarAccess.getResultReportAccess().getResultDataAssignment_8_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1503:1: ( rule__ResultReport__ResultDataAssignment_8_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1503:2: rule__ResultReport__ResultDataAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultReport__ResultDataAssignment_8_1_in_rule__ResultReport__Group_8__1__Impl2977);
            	    rule__ResultReport__ResultDataAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getResultReportAccess().getResultDataAssignment_8_1()); 

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
    // $ANTLR end "rule__ResultReport__Group_8__1__Impl"


    // $ANTLR start "rule__ResultReport__Group_9__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1518:1: rule__ResultReport__Group_9__0 : rule__ResultReport__Group_9__0__Impl rule__ResultReport__Group_9__1 ;
    public final void rule__ResultReport__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1522:1: ( rule__ResultReport__Group_9__0__Impl rule__ResultReport__Group_9__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1523:2: rule__ResultReport__Group_9__0__Impl rule__ResultReport__Group_9__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_9__0__Impl_in_rule__ResultReport__Group_9__03014);
            rule__ResultReport__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_9__1_in_rule__ResultReport__Group_9__03017);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1530:1: rule__ResultReport__Group_9__0__Impl : ( 'issues' ) ;
    public final void rule__ResultReport__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1534:1: ( ( 'issues' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1535:1: ( 'issues' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1535:1: ( 'issues' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1536:1: 'issues'
            {
             before(grammarAccess.getResultReportAccess().getIssuesKeyword_9_0()); 
            match(input,21,FOLLOW_21_in_rule__ResultReport__Group_9__0__Impl3045); 
             after(grammarAccess.getResultReportAccess().getIssuesKeyword_9_0()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1549:1: rule__ResultReport__Group_9__1 : rule__ResultReport__Group_9__1__Impl ;
    public final void rule__ResultReport__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1553:1: ( rule__ResultReport__Group_9__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1554:2: rule__ResultReport__Group_9__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_9__1__Impl_in_rule__ResultReport__Group_9__13076);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1560:1: rule__ResultReport__Group_9__1__Impl : ( ( rule__ResultReport__IssuesAssignment_9_1 )* ) ;
    public final void rule__ResultReport__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1564:1: ( ( ( rule__ResultReport__IssuesAssignment_9_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1565:1: ( ( rule__ResultReport__IssuesAssignment_9_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1565:1: ( ( rule__ResultReport__IssuesAssignment_9_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1566:1: ( rule__ResultReport__IssuesAssignment_9_1 )*
            {
             before(grammarAccess.getResultReportAccess().getIssuesAssignment_9_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1567:1: ( rule__ResultReport__IssuesAssignment_9_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=11 && LA15_0<=14)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1567:2: rule__ResultReport__IssuesAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultReport__IssuesAssignment_9_1_in_rule__ResultReport__Group_9__1__Impl3103);
            	    rule__ResultReport__IssuesAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getResultReportAccess().getIssuesAssignment_9_1()); 

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


    // $ANTLR start "rule__IssuesReport__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1581:1: rule__IssuesReport__Group__0 : rule__IssuesReport__Group__0__Impl rule__IssuesReport__Group__1 ;
    public final void rule__IssuesReport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1585:1: ( rule__IssuesReport__Group__0__Impl rule__IssuesReport__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1586:2: rule__IssuesReport__Group__0__Impl rule__IssuesReport__Group__1
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__0__Impl_in_rule__IssuesReport__Group__03138);
            rule__IssuesReport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__1_in_rule__IssuesReport__Group__03141);
            rule__IssuesReport__Group__1();

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
    // $ANTLR end "rule__IssuesReport__Group__0"


    // $ANTLR start "rule__IssuesReport__Group__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1593:1: rule__IssuesReport__Group__0__Impl : ( 'issues' ) ;
    public final void rule__IssuesReport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1597:1: ( ( 'issues' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1598:1: ( 'issues' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1598:1: ( 'issues' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1599:1: 'issues'
            {
             before(grammarAccess.getIssuesReportAccess().getIssuesKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__IssuesReport__Group__0__Impl3169); 
             after(grammarAccess.getIssuesReportAccess().getIssuesKeyword_0()); 

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
    // $ANTLR end "rule__IssuesReport__Group__0__Impl"


    // $ANTLR start "rule__IssuesReport__Group__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1612:1: rule__IssuesReport__Group__1 : rule__IssuesReport__Group__1__Impl rule__IssuesReport__Group__2 ;
    public final void rule__IssuesReport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1616:1: ( rule__IssuesReport__Group__1__Impl rule__IssuesReport__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1617:2: rule__IssuesReport__Group__1__Impl rule__IssuesReport__Group__2
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__1__Impl_in_rule__IssuesReport__Group__13200);
            rule__IssuesReport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__2_in_rule__IssuesReport__Group__13203);
            rule__IssuesReport__Group__2();

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
    // $ANTLR end "rule__IssuesReport__Group__1"


    // $ANTLR start "rule__IssuesReport__Group__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1624:1: rule__IssuesReport__Group__1__Impl : ( ( rule__IssuesReport__NameAssignment_1 ) ) ;
    public final void rule__IssuesReport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1628:1: ( ( ( rule__IssuesReport__NameAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1629:1: ( ( rule__IssuesReport__NameAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1629:1: ( ( rule__IssuesReport__NameAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1630:1: ( rule__IssuesReport__NameAssignment_1 )
            {
             before(grammarAccess.getIssuesReportAccess().getNameAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1631:1: ( rule__IssuesReport__NameAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1631:2: rule__IssuesReport__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__IssuesReport__NameAssignment_1_in_rule__IssuesReport__Group__1__Impl3230);
            rule__IssuesReport__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIssuesReportAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__IssuesReport__Group__1__Impl"


    // $ANTLR start "rule__IssuesReport__Group__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1641:1: rule__IssuesReport__Group__2 : rule__IssuesReport__Group__2__Impl rule__IssuesReport__Group__3 ;
    public final void rule__IssuesReport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1645:1: ( rule__IssuesReport__Group__2__Impl rule__IssuesReport__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1646:2: rule__IssuesReport__Group__2__Impl rule__IssuesReport__Group__3
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__2__Impl_in_rule__IssuesReport__Group__23260);
            rule__IssuesReport__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__3_in_rule__IssuesReport__Group__23263);
            rule__IssuesReport__Group__3();

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
    // $ANTLR end "rule__IssuesReport__Group__2"


    // $ANTLR start "rule__IssuesReport__Group__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1653:1: rule__IssuesReport__Group__2__Impl : ( ( rule__IssuesReport__Group_2__0 )? ) ;
    public final void rule__IssuesReport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1657:1: ( ( ( rule__IssuesReport__Group_2__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1658:1: ( ( rule__IssuesReport__Group_2__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1658:1: ( ( rule__IssuesReport__Group_2__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1659:1: ( rule__IssuesReport__Group_2__0 )?
            {
             before(grammarAccess.getIssuesReportAccess().getGroup_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1660:1: ( rule__IssuesReport__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==19) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1660:2: rule__IssuesReport__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__IssuesReport__Group_2__0_in_rule__IssuesReport__Group__2__Impl3290);
                    rule__IssuesReport__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIssuesReportAccess().getGroup_2()); 

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
    // $ANTLR end "rule__IssuesReport__Group__2__Impl"


    // $ANTLR start "rule__IssuesReport__Group__3"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1670:1: rule__IssuesReport__Group__3 : rule__IssuesReport__Group__3__Impl rule__IssuesReport__Group__4 ;
    public final void rule__IssuesReport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1674:1: ( rule__IssuesReport__Group__3__Impl rule__IssuesReport__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1675:2: rule__IssuesReport__Group__3__Impl rule__IssuesReport__Group__4
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__3__Impl_in_rule__IssuesReport__Group__33321);
            rule__IssuesReport__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__4_in_rule__IssuesReport__Group__33324);
            rule__IssuesReport__Group__4();

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
    // $ANTLR end "rule__IssuesReport__Group__3"


    // $ANTLR start "rule__IssuesReport__Group__3__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1682:1: rule__IssuesReport__Group__3__Impl : ( '[' ) ;
    public final void rule__IssuesReport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1686:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1687:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1687:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1688:1: '['
            {
             before(grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3()); 
            match(input,16,FOLLOW_16_in_rule__IssuesReport__Group__3__Impl3352); 
             after(grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3()); 

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
    // $ANTLR end "rule__IssuesReport__Group__3__Impl"


    // $ANTLR start "rule__IssuesReport__Group__4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1701:1: rule__IssuesReport__Group__4 : rule__IssuesReport__Group__4__Impl rule__IssuesReport__Group__5 ;
    public final void rule__IssuesReport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1705:1: ( rule__IssuesReport__Group__4__Impl rule__IssuesReport__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1706:2: rule__IssuesReport__Group__4__Impl rule__IssuesReport__Group__5
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__4__Impl_in_rule__IssuesReport__Group__43383);
            rule__IssuesReport__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__5_in_rule__IssuesReport__Group__43386);
            rule__IssuesReport__Group__5();

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
    // $ANTLR end "rule__IssuesReport__Group__4"


    // $ANTLR start "rule__IssuesReport__Group__4__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1713:1: rule__IssuesReport__Group__4__Impl : ( 'target' ) ;
    public final void rule__IssuesReport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1717:1: ( ( 'target' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1718:1: ( 'target' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1718:1: ( 'target' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1719:1: 'target'
            {
             before(grammarAccess.getIssuesReportAccess().getTargetKeyword_4()); 
            match(input,17,FOLLOW_17_in_rule__IssuesReport__Group__4__Impl3414); 
             after(grammarAccess.getIssuesReportAccess().getTargetKeyword_4()); 

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
    // $ANTLR end "rule__IssuesReport__Group__4__Impl"


    // $ANTLR start "rule__IssuesReport__Group__5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1732:1: rule__IssuesReport__Group__5 : rule__IssuesReport__Group__5__Impl rule__IssuesReport__Group__6 ;
    public final void rule__IssuesReport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1736:1: ( rule__IssuesReport__Group__5__Impl rule__IssuesReport__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1737:2: rule__IssuesReport__Group__5__Impl rule__IssuesReport__Group__6
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__5__Impl_in_rule__IssuesReport__Group__53445);
            rule__IssuesReport__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__6_in_rule__IssuesReport__Group__53448);
            rule__IssuesReport__Group__6();

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
    // $ANTLR end "rule__IssuesReport__Group__5"


    // $ANTLR start "rule__IssuesReport__Group__5__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1744:1: rule__IssuesReport__Group__5__Impl : ( ( rule__IssuesReport__TargetAssignment_5 ) ) ;
    public final void rule__IssuesReport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1748:1: ( ( ( rule__IssuesReport__TargetAssignment_5 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1749:1: ( ( rule__IssuesReport__TargetAssignment_5 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1749:1: ( ( rule__IssuesReport__TargetAssignment_5 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1750:1: ( rule__IssuesReport__TargetAssignment_5 )
            {
             before(grammarAccess.getIssuesReportAccess().getTargetAssignment_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1751:1: ( rule__IssuesReport__TargetAssignment_5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1751:2: rule__IssuesReport__TargetAssignment_5
            {
            pushFollow(FOLLOW_rule__IssuesReport__TargetAssignment_5_in_rule__IssuesReport__Group__5__Impl3475);
            rule__IssuesReport__TargetAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getIssuesReportAccess().getTargetAssignment_5()); 

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
    // $ANTLR end "rule__IssuesReport__Group__5__Impl"


    // $ANTLR start "rule__IssuesReport__Group__6"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1761:1: rule__IssuesReport__Group__6 : rule__IssuesReport__Group__6__Impl rule__IssuesReport__Group__7 ;
    public final void rule__IssuesReport__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1765:1: ( rule__IssuesReport__Group__6__Impl rule__IssuesReport__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1766:2: rule__IssuesReport__Group__6__Impl rule__IssuesReport__Group__7
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__6__Impl_in_rule__IssuesReport__Group__63505);
            rule__IssuesReport__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__7_in_rule__IssuesReport__Group__63508);
            rule__IssuesReport__Group__7();

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
    // $ANTLR end "rule__IssuesReport__Group__6"


    // $ANTLR start "rule__IssuesReport__Group__6__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1773:1: rule__IssuesReport__Group__6__Impl : ( ( rule__IssuesReport__Group_6__0 )? ) ;
    public final void rule__IssuesReport__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1777:1: ( ( ( rule__IssuesReport__Group_6__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1778:1: ( ( rule__IssuesReport__Group_6__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1778:1: ( ( rule__IssuesReport__Group_6__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1779:1: ( rule__IssuesReport__Group_6__0 )?
            {
             before(grammarAccess.getIssuesReportAccess().getGroup_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1780:1: ( rule__IssuesReport__Group_6__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==20) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1780:2: rule__IssuesReport__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__IssuesReport__Group_6__0_in_rule__IssuesReport__Group__6__Impl3535);
                    rule__IssuesReport__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIssuesReportAccess().getGroup_6()); 

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
    // $ANTLR end "rule__IssuesReport__Group__6__Impl"


    // $ANTLR start "rule__IssuesReport__Group__7"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1790:1: rule__IssuesReport__Group__7 : rule__IssuesReport__Group__7__Impl rule__IssuesReport__Group__8 ;
    public final void rule__IssuesReport__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1794:1: ( rule__IssuesReport__Group__7__Impl rule__IssuesReport__Group__8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1795:2: rule__IssuesReport__Group__7__Impl rule__IssuesReport__Group__8
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__7__Impl_in_rule__IssuesReport__Group__73566);
            rule__IssuesReport__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__8_in_rule__IssuesReport__Group__73569);
            rule__IssuesReport__Group__8();

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
    // $ANTLR end "rule__IssuesReport__Group__7"


    // $ANTLR start "rule__IssuesReport__Group__7__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1802:1: rule__IssuesReport__Group__7__Impl : ( ( rule__IssuesReport__IssuesAssignment_7 )* ) ;
    public final void rule__IssuesReport__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1806:1: ( ( ( rule__IssuesReport__IssuesAssignment_7 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1807:1: ( ( rule__IssuesReport__IssuesAssignment_7 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1807:1: ( ( rule__IssuesReport__IssuesAssignment_7 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1808:1: ( rule__IssuesReport__IssuesAssignment_7 )*
            {
             before(grammarAccess.getIssuesReportAccess().getIssuesAssignment_7()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1809:1: ( rule__IssuesReport__IssuesAssignment_7 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=11 && LA18_0<=14)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1809:2: rule__IssuesReport__IssuesAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__IssuesReport__IssuesAssignment_7_in_rule__IssuesReport__Group__7__Impl3596);
            	    rule__IssuesReport__IssuesAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getIssuesReportAccess().getIssuesAssignment_7()); 

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
    // $ANTLR end "rule__IssuesReport__Group__7__Impl"


    // $ANTLR start "rule__IssuesReport__Group__8"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1819:1: rule__IssuesReport__Group__8 : rule__IssuesReport__Group__8__Impl ;
    public final void rule__IssuesReport__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1823:1: ( rule__IssuesReport__Group__8__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1824:2: rule__IssuesReport__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__8__Impl_in_rule__IssuesReport__Group__83627);
            rule__IssuesReport__Group__8__Impl();

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
    // $ANTLR end "rule__IssuesReport__Group__8"


    // $ANTLR start "rule__IssuesReport__Group__8__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1830:1: rule__IssuesReport__Group__8__Impl : ( ']' ) ;
    public final void rule__IssuesReport__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1834:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1835:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1835:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1836:1: ']'
            {
             before(grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_8()); 
            match(input,18,FOLLOW_18_in_rule__IssuesReport__Group__8__Impl3655); 
             after(grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_8()); 

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
    // $ANTLR end "rule__IssuesReport__Group__8__Impl"


    // $ANTLR start "rule__IssuesReport__Group_2__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1867:1: rule__IssuesReport__Group_2__0 : rule__IssuesReport__Group_2__0__Impl rule__IssuesReport__Group_2__1 ;
    public final void rule__IssuesReport__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1871:1: ( rule__IssuesReport__Group_2__0__Impl rule__IssuesReport__Group_2__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1872:2: rule__IssuesReport__Group_2__0__Impl rule__IssuesReport__Group_2__1
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_2__0__Impl_in_rule__IssuesReport__Group_2__03704);
            rule__IssuesReport__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group_2__1_in_rule__IssuesReport__Group_2__03707);
            rule__IssuesReport__Group_2__1();

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
    // $ANTLR end "rule__IssuesReport__Group_2__0"


    // $ANTLR start "rule__IssuesReport__Group_2__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1879:1: rule__IssuesReport__Group_2__0__Impl : ( ':' ) ;
    public final void rule__IssuesReport__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1883:1: ( ( ':' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1884:1: ( ':' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1884:1: ( ':' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1885:1: ':'
            {
             before(grammarAccess.getIssuesReportAccess().getColonKeyword_2_0()); 
            match(input,19,FOLLOW_19_in_rule__IssuesReport__Group_2__0__Impl3735); 
             after(grammarAccess.getIssuesReportAccess().getColonKeyword_2_0()); 

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
    // $ANTLR end "rule__IssuesReport__Group_2__0__Impl"


    // $ANTLR start "rule__IssuesReport__Group_2__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1898:1: rule__IssuesReport__Group_2__1 : rule__IssuesReport__Group_2__1__Impl ;
    public final void rule__IssuesReport__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1902:1: ( rule__IssuesReport__Group_2__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1903:2: rule__IssuesReport__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_2__1__Impl_in_rule__IssuesReport__Group_2__13766);
            rule__IssuesReport__Group_2__1__Impl();

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
    // $ANTLR end "rule__IssuesReport__Group_2__1"


    // $ANTLR start "rule__IssuesReport__Group_2__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1909:1: rule__IssuesReport__Group_2__1__Impl : ( ( rule__IssuesReport__TitleAssignment_2_1 ) ) ;
    public final void rule__IssuesReport__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1913:1: ( ( ( rule__IssuesReport__TitleAssignment_2_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1914:1: ( ( rule__IssuesReport__TitleAssignment_2_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1914:1: ( ( rule__IssuesReport__TitleAssignment_2_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1915:1: ( rule__IssuesReport__TitleAssignment_2_1 )
            {
             before(grammarAccess.getIssuesReportAccess().getTitleAssignment_2_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1916:1: ( rule__IssuesReport__TitleAssignment_2_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1916:2: rule__IssuesReport__TitleAssignment_2_1
            {
            pushFollow(FOLLOW_rule__IssuesReport__TitleAssignment_2_1_in_rule__IssuesReport__Group_2__1__Impl3793);
            rule__IssuesReport__TitleAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getIssuesReportAccess().getTitleAssignment_2_1()); 

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
    // $ANTLR end "rule__IssuesReport__Group_2__1__Impl"


    // $ANTLR start "rule__IssuesReport__Group_6__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1930:1: rule__IssuesReport__Group_6__0 : rule__IssuesReport__Group_6__0__Impl rule__IssuesReport__Group_6__1 ;
    public final void rule__IssuesReport__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1934:1: ( rule__IssuesReport__Group_6__0__Impl rule__IssuesReport__Group_6__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1935:2: rule__IssuesReport__Group_6__0__Impl rule__IssuesReport__Group_6__1
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_6__0__Impl_in_rule__IssuesReport__Group_6__03827);
            rule__IssuesReport__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group_6__1_in_rule__IssuesReport__Group_6__03830);
            rule__IssuesReport__Group_6__1();

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
    // $ANTLR end "rule__IssuesReport__Group_6__0"


    // $ANTLR start "rule__IssuesReport__Group_6__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1942:1: rule__IssuesReport__Group_6__0__Impl : ( 'description' ) ;
    public final void rule__IssuesReport__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1946:1: ( ( 'description' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1947:1: ( 'description' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1947:1: ( 'description' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1948:1: 'description'
            {
             before(grammarAccess.getIssuesReportAccess().getDescriptionKeyword_6_0()); 
            match(input,20,FOLLOW_20_in_rule__IssuesReport__Group_6__0__Impl3858); 
             after(grammarAccess.getIssuesReportAccess().getDescriptionKeyword_6_0()); 

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
    // $ANTLR end "rule__IssuesReport__Group_6__0__Impl"


    // $ANTLR start "rule__IssuesReport__Group_6__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1961:1: rule__IssuesReport__Group_6__1 : rule__IssuesReport__Group_6__1__Impl ;
    public final void rule__IssuesReport__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1965:1: ( rule__IssuesReport__Group_6__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1966:2: rule__IssuesReport__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_6__1__Impl_in_rule__IssuesReport__Group_6__13889);
            rule__IssuesReport__Group_6__1__Impl();

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
    // $ANTLR end "rule__IssuesReport__Group_6__1"


    // $ANTLR start "rule__IssuesReport__Group_6__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1972:1: rule__IssuesReport__Group_6__1__Impl : ( ( rule__IssuesReport__DecriptionAssignment_6_1 ) ) ;
    public final void rule__IssuesReport__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1976:1: ( ( ( rule__IssuesReport__DecriptionAssignment_6_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1977:1: ( ( rule__IssuesReport__DecriptionAssignment_6_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1977:1: ( ( rule__IssuesReport__DecriptionAssignment_6_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1978:1: ( rule__IssuesReport__DecriptionAssignment_6_1 )
            {
             before(grammarAccess.getIssuesReportAccess().getDecriptionAssignment_6_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1979:1: ( rule__IssuesReport__DecriptionAssignment_6_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1979:2: rule__IssuesReport__DecriptionAssignment_6_1
            {
            pushFollow(FOLLOW_rule__IssuesReport__DecriptionAssignment_6_1_in_rule__IssuesReport__Group_6__1__Impl3916);
            rule__IssuesReport__DecriptionAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getIssuesReportAccess().getDecriptionAssignment_6_1()); 

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
    // $ANTLR end "rule__IssuesReport__Group_6__1__Impl"


    // $ANTLR start "rule__ResultContributor__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1993:1: rule__ResultContributor__Group__0 : rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1 ;
    public final void rule__ResultContributor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1997:1: ( rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1998:2: rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__0__Impl_in_rule__ResultContributor__Group__03950);
            rule__ResultContributor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__1_in_rule__ResultContributor__Group__03953);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2005:1: rule__ResultContributor__Group__0__Impl : ( 'contributor' ) ;
    public final void rule__ResultContributor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2009:1: ( ( 'contributor' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2010:1: ( 'contributor' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2010:1: ( 'contributor' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2011:1: 'contributor'
            {
             before(grammarAccess.getResultContributorAccess().getContributorKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__ResultContributor__Group__0__Impl3981); 
             after(grammarAccess.getResultContributorAccess().getContributorKeyword_0()); 

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
    // $ANTLR end "rule__ResultContributor__Group__0__Impl"


    // $ANTLR start "rule__ResultContributor__Group__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2024:1: rule__ResultContributor__Group__1 : rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2 ;
    public final void rule__ResultContributor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2028:1: ( rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2029:2: rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__1__Impl_in_rule__ResultContributor__Group__14012);
            rule__ResultContributor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__2_in_rule__ResultContributor__Group__14015);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2036:1: rule__ResultContributor__Group__1__Impl : ( ( rule__ResultContributor__ContributorAssignment_1 ) ) ;
    public final void rule__ResultContributor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2040:1: ( ( ( rule__ResultContributor__ContributorAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2041:1: ( ( rule__ResultContributor__ContributorAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2041:1: ( ( rule__ResultContributor__ContributorAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2042:1: ( rule__ResultContributor__ContributorAssignment_1 )
            {
             before(grammarAccess.getResultContributorAccess().getContributorAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2043:1: ( rule__ResultContributor__ContributorAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2043:2: rule__ResultContributor__ContributorAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultContributor__ContributorAssignment_1_in_rule__ResultContributor__Group__1__Impl4042);
            rule__ResultContributor__ContributorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getResultContributorAccess().getContributorAssignment_1()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2053:1: rule__ResultContributor__Group__2 : rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3 ;
    public final void rule__ResultContributor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2057:1: ( rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2058:2: rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__2__Impl_in_rule__ResultContributor__Group__24072);
            rule__ResultContributor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__3_in_rule__ResultContributor__Group__24075);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2065:1: rule__ResultContributor__Group__2__Impl : ( '[' ) ;
    public final void rule__ResultContributor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2069:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2070:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2070:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2071:1: '['
            {
             before(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2()); 
            match(input,16,FOLLOW_16_in_rule__ResultContributor__Group__2__Impl4103); 
             after(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2084:1: rule__ResultContributor__Group__3 : rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4 ;
    public final void rule__ResultContributor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2088:1: ( rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2089:2: rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__3__Impl_in_rule__ResultContributor__Group__34134);
            rule__ResultContributor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__4_in_rule__ResultContributor__Group__34137);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2096:1: rule__ResultContributor__Group__3__Impl : ( 'data' ) ;
    public final void rule__ResultContributor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2100:1: ( ( 'data' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2101:1: ( 'data' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2101:1: ( 'data' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2102:1: 'data'
            {
             before(grammarAccess.getResultContributorAccess().getDataKeyword_3()); 
            match(input,26,FOLLOW_26_in_rule__ResultContributor__Group__3__Impl4165); 
             after(grammarAccess.getResultContributorAccess().getDataKeyword_3()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2115:1: rule__ResultContributor__Group__4 : rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5 ;
    public final void rule__ResultContributor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2119:1: ( rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2120:2: rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__4__Impl_in_rule__ResultContributor__Group__44196);
            rule__ResultContributor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__5_in_rule__ResultContributor__Group__44199);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2127:1: rule__ResultContributor__Group__4__Impl : ( ( ( rule__ResultContributor__CellAssignment_4 ) ) ( ( rule__ResultContributor__CellAssignment_4 )* ) ) ;
    public final void rule__ResultContributor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2131:1: ( ( ( ( rule__ResultContributor__CellAssignment_4 ) ) ( ( rule__ResultContributor__CellAssignment_4 )* ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2132:1: ( ( ( rule__ResultContributor__CellAssignment_4 ) ) ( ( rule__ResultContributor__CellAssignment_4 )* ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2132:1: ( ( ( rule__ResultContributor__CellAssignment_4 ) ) ( ( rule__ResultContributor__CellAssignment_4 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2133:1: ( ( rule__ResultContributor__CellAssignment_4 ) ) ( ( rule__ResultContributor__CellAssignment_4 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2133:1: ( ( rule__ResultContributor__CellAssignment_4 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2134:1: ( rule__ResultContributor__CellAssignment_4 )
            {
             before(grammarAccess.getResultContributorAccess().getCellAssignment_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2135:1: ( rule__ResultContributor__CellAssignment_4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2135:2: rule__ResultContributor__CellAssignment_4
            {
            pushFollow(FOLLOW_rule__ResultContributor__CellAssignment_4_in_rule__ResultContributor__Group__4__Impl4228);
            rule__ResultContributor__CellAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getResultContributorAccess().getCellAssignment_4()); 

            }

            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2138:1: ( ( rule__ResultContributor__CellAssignment_4 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2139:1: ( rule__ResultContributor__CellAssignment_4 )*
            {
             before(grammarAccess.getResultContributorAccess().getCellAssignment_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2140:1: ( rule__ResultContributor__CellAssignment_4 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_STRING) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2140:2: rule__ResultContributor__CellAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__CellAssignment_4_in_rule__ResultContributor__Group__4__Impl4240);
            	    rule__ResultContributor__CellAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getResultContributorAccess().getCellAssignment_4()); 

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
    // $ANTLR end "rule__ResultContributor__Group__4__Impl"


    // $ANTLR start "rule__ResultContributor__Group__5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2151:1: rule__ResultContributor__Group__5 : rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6 ;
    public final void rule__ResultContributor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2155:1: ( rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2156:2: rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__5__Impl_in_rule__ResultContributor__Group__54273);
            rule__ResultContributor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__6_in_rule__ResultContributor__Group__54276);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2163:1: rule__ResultContributor__Group__5__Impl : ( ( rule__ResultContributor__Group_5__0 )? ) ;
    public final void rule__ResultContributor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2167:1: ( ( ( rule__ResultContributor__Group_5__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2168:1: ( ( rule__ResultContributor__Group_5__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2168:1: ( ( rule__ResultContributor__Group_5__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2169:1: ( rule__ResultContributor__Group_5__0 )?
            {
             before(grammarAccess.getResultContributorAccess().getGroup_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2170:1: ( rule__ResultContributor__Group_5__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==21) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2170:2: rule__ResultContributor__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ResultContributor__Group_5__0_in_rule__ResultContributor__Group__5__Impl4303);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2180:1: rule__ResultContributor__Group__6 : rule__ResultContributor__Group__6__Impl rule__ResultContributor__Group__7 ;
    public final void rule__ResultContributor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2184:1: ( rule__ResultContributor__Group__6__Impl rule__ResultContributor__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2185:2: rule__ResultContributor__Group__6__Impl rule__ResultContributor__Group__7
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__6__Impl_in_rule__ResultContributor__Group__64334);
            rule__ResultContributor__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__7_in_rule__ResultContributor__Group__64337);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2192:1: rule__ResultContributor__Group__6__Impl : ( ( rule__ResultContributor__SubcontributorAssignment_6 )* ) ;
    public final void rule__ResultContributor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2196:1: ( ( ( rule__ResultContributor__SubcontributorAssignment_6 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2197:1: ( ( rule__ResultContributor__SubcontributorAssignment_6 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2197:1: ( ( rule__ResultContributor__SubcontributorAssignment_6 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2198:1: ( rule__ResultContributor__SubcontributorAssignment_6 )*
            {
             before(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2199:1: ( rule__ResultContributor__SubcontributorAssignment_6 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==25) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2199:2: rule__ResultContributor__SubcontributorAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__SubcontributorAssignment_6_in_rule__ResultContributor__Group__6__Impl4364);
            	    rule__ResultContributor__SubcontributorAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_6()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2209:1: rule__ResultContributor__Group__7 : rule__ResultContributor__Group__7__Impl ;
    public final void rule__ResultContributor__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2213:1: ( rule__ResultContributor__Group__7__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2214:2: rule__ResultContributor__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__7__Impl_in_rule__ResultContributor__Group__74395);
            rule__ResultContributor__Group__7__Impl();

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2220:1: rule__ResultContributor__Group__7__Impl : ( ']' ) ;
    public final void rule__ResultContributor__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2224:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2225:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2225:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2226:1: ']'
            {
             before(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_7()); 
            match(input,18,FOLLOW_18_in_rule__ResultContributor__Group__7__Impl4423); 
             after(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_7()); 

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


    // $ANTLR start "rule__ResultContributor__Group_5__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2255:1: rule__ResultContributor__Group_5__0 : rule__ResultContributor__Group_5__0__Impl rule__ResultContributor__Group_5__1 ;
    public final void rule__ResultContributor__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2259:1: ( rule__ResultContributor__Group_5__0__Impl rule__ResultContributor__Group_5__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2260:2: rule__ResultContributor__Group_5__0__Impl rule__ResultContributor__Group_5__1
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group_5__0__Impl_in_rule__ResultContributor__Group_5__04470);
            rule__ResultContributor__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group_5__1_in_rule__ResultContributor__Group_5__04473);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2267:1: rule__ResultContributor__Group_5__0__Impl : ( 'issues' ) ;
    public final void rule__ResultContributor__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2271:1: ( ( 'issues' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2272:1: ( 'issues' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2272:1: ( 'issues' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2273:1: 'issues'
            {
             before(grammarAccess.getResultContributorAccess().getIssuesKeyword_5_0()); 
            match(input,21,FOLLOW_21_in_rule__ResultContributor__Group_5__0__Impl4501); 
             after(grammarAccess.getResultContributorAccess().getIssuesKeyword_5_0()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2286:1: rule__ResultContributor__Group_5__1 : rule__ResultContributor__Group_5__1__Impl ;
    public final void rule__ResultContributor__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2290:1: ( rule__ResultContributor__Group_5__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2291:2: rule__ResultContributor__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group_5__1__Impl_in_rule__ResultContributor__Group_5__14532);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2297:1: rule__ResultContributor__Group_5__1__Impl : ( ( rule__ResultContributor__IssuesAssignment_5_1 )* ) ;
    public final void rule__ResultContributor__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2301:1: ( ( ( rule__ResultContributor__IssuesAssignment_5_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2302:1: ( ( rule__ResultContributor__IssuesAssignment_5_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2302:1: ( ( rule__ResultContributor__IssuesAssignment_5_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2303:1: ( rule__ResultContributor__IssuesAssignment_5_1 )*
            {
             before(grammarAccess.getResultContributorAccess().getIssuesAssignment_5_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2304:1: ( rule__ResultContributor__IssuesAssignment_5_1 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=11 && LA22_0<=14)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2304:2: rule__ResultContributor__IssuesAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__IssuesAssignment_5_1_in_rule__ResultContributor__Group_5__1__Impl4559);
            	    rule__ResultContributor__IssuesAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getResultContributorAccess().getIssuesAssignment_5_1()); 

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


    // $ANTLR start "rule__ReportIssue__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2318:1: rule__ReportIssue__Group__0 : rule__ReportIssue__Group__0__Impl rule__ReportIssue__Group__1 ;
    public final void rule__ReportIssue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2322:1: ( rule__ReportIssue__Group__0__Impl rule__ReportIssue__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2323:2: rule__ReportIssue__Group__0__Impl rule__ReportIssue__Group__1
            {
            pushFollow(FOLLOW_rule__ReportIssue__Group__0__Impl_in_rule__ReportIssue__Group__04594);
            rule__ReportIssue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReportIssue__Group__1_in_rule__ReportIssue__Group__04597);
            rule__ReportIssue__Group__1();

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
    // $ANTLR end "rule__ReportIssue__Group__0"


    // $ANTLR start "rule__ReportIssue__Group__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2330:1: rule__ReportIssue__Group__0__Impl : ( ( rule__ReportIssue__IssueTypeAssignment_0 ) ) ;
    public final void rule__ReportIssue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2334:1: ( ( ( rule__ReportIssue__IssueTypeAssignment_0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2335:1: ( ( rule__ReportIssue__IssueTypeAssignment_0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2335:1: ( ( rule__ReportIssue__IssueTypeAssignment_0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2336:1: ( rule__ReportIssue__IssueTypeAssignment_0 )
            {
             before(grammarAccess.getReportIssueAccess().getIssueTypeAssignment_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2337:1: ( rule__ReportIssue__IssueTypeAssignment_0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2337:2: rule__ReportIssue__IssueTypeAssignment_0
            {
            pushFollow(FOLLOW_rule__ReportIssue__IssueTypeAssignment_0_in_rule__ReportIssue__Group__0__Impl4624);
            rule__ReportIssue__IssueTypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getReportIssueAccess().getIssueTypeAssignment_0()); 

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
    // $ANTLR end "rule__ReportIssue__Group__0__Impl"


    // $ANTLR start "rule__ReportIssue__Group__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2347:1: rule__ReportIssue__Group__1 : rule__ReportIssue__Group__1__Impl rule__ReportIssue__Group__2 ;
    public final void rule__ReportIssue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2351:1: ( rule__ReportIssue__Group__1__Impl rule__ReportIssue__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2352:2: rule__ReportIssue__Group__1__Impl rule__ReportIssue__Group__2
            {
            pushFollow(FOLLOW_rule__ReportIssue__Group__1__Impl_in_rule__ReportIssue__Group__14654);
            rule__ReportIssue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReportIssue__Group__2_in_rule__ReportIssue__Group__14657);
            rule__ReportIssue__Group__2();

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
    // $ANTLR end "rule__ReportIssue__Group__1"


    // $ANTLR start "rule__ReportIssue__Group__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2359:1: rule__ReportIssue__Group__1__Impl : ( ( rule__ReportIssue__TitleAssignment_1 ) ) ;
    public final void rule__ReportIssue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2363:1: ( ( ( rule__ReportIssue__TitleAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2364:1: ( ( rule__ReportIssue__TitleAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2364:1: ( ( rule__ReportIssue__TitleAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2365:1: ( rule__ReportIssue__TitleAssignment_1 )
            {
             before(grammarAccess.getReportIssueAccess().getTitleAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2366:1: ( rule__ReportIssue__TitleAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2366:2: rule__ReportIssue__TitleAssignment_1
            {
            pushFollow(FOLLOW_rule__ReportIssue__TitleAssignment_1_in_rule__ReportIssue__Group__1__Impl4684);
            rule__ReportIssue__TitleAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReportIssueAccess().getTitleAssignment_1()); 

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
    // $ANTLR end "rule__ReportIssue__Group__1__Impl"


    // $ANTLR start "rule__ReportIssue__Group__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2376:1: rule__ReportIssue__Group__2 : rule__ReportIssue__Group__2__Impl ;
    public final void rule__ReportIssue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2380:1: ( rule__ReportIssue__Group__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2381:2: rule__ReportIssue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ReportIssue__Group__2__Impl_in_rule__ReportIssue__Group__24714);
            rule__ReportIssue__Group__2__Impl();

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
    // $ANTLR end "rule__ReportIssue__Group__2"


    // $ANTLR start "rule__ReportIssue__Group__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2387:1: rule__ReportIssue__Group__2__Impl : ( ( rule__ReportIssue__TargetAssignment_2 ) ) ;
    public final void rule__ReportIssue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2391:1: ( ( ( rule__ReportIssue__TargetAssignment_2 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2392:1: ( ( rule__ReportIssue__TargetAssignment_2 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2392:1: ( ( rule__ReportIssue__TargetAssignment_2 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2393:1: ( rule__ReportIssue__TargetAssignment_2 )
            {
             before(grammarAccess.getReportIssueAccess().getTargetAssignment_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2394:1: ( rule__ReportIssue__TargetAssignment_2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2394:2: rule__ReportIssue__TargetAssignment_2
            {
            pushFollow(FOLLOW_rule__ReportIssue__TargetAssignment_2_in_rule__ReportIssue__Group__2__Impl4741);
            rule__ReportIssue__TargetAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getReportIssueAccess().getTargetAssignment_2()); 

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
    // $ANTLR end "rule__ReportIssue__Group__2__Impl"


    // $ANTLR start "rule__ResultData__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2410:1: rule__ResultData__Group__0 : rule__ResultData__Group__0__Impl rule__ResultData__Group__1 ;
    public final void rule__ResultData__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2414:1: ( rule__ResultData__Group__0__Impl rule__ResultData__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2415:2: rule__ResultData__Group__0__Impl rule__ResultData__Group__1
            {
            pushFollow(FOLLOW_rule__ResultData__Group__0__Impl_in_rule__ResultData__Group__04777);
            rule__ResultData__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultData__Group__1_in_rule__ResultData__Group__04780);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2422:1: rule__ResultData__Group__0__Impl : ( ( rule__ResultData__NameAssignment_0 ) ) ;
    public final void rule__ResultData__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2426:1: ( ( ( rule__ResultData__NameAssignment_0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2427:1: ( ( rule__ResultData__NameAssignment_0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2427:1: ( ( rule__ResultData__NameAssignment_0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2428:1: ( rule__ResultData__NameAssignment_0 )
            {
             before(grammarAccess.getResultDataAccess().getNameAssignment_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2429:1: ( rule__ResultData__NameAssignment_0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2429:2: rule__ResultData__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ResultData__NameAssignment_0_in_rule__ResultData__Group__0__Impl4807);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2439:1: rule__ResultData__Group__1 : rule__ResultData__Group__1__Impl rule__ResultData__Group__2 ;
    public final void rule__ResultData__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2443:1: ( rule__ResultData__Group__1__Impl rule__ResultData__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2444:2: rule__ResultData__Group__1__Impl rule__ResultData__Group__2
            {
            pushFollow(FOLLOW_rule__ResultData__Group__1__Impl_in_rule__ResultData__Group__14837);
            rule__ResultData__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultData__Group__2_in_rule__ResultData__Group__14840);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2451:1: rule__ResultData__Group__1__Impl : ( '=' ) ;
    public final void rule__ResultData__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2455:1: ( ( '=' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2456:1: ( '=' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2456:1: ( '=' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2457:1: '='
            {
             before(grammarAccess.getResultDataAccess().getEqualsSignKeyword_1()); 
            match(input,27,FOLLOW_27_in_rule__ResultData__Group__1__Impl4868); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2470:1: rule__ResultData__Group__2 : rule__ResultData__Group__2__Impl ;
    public final void rule__ResultData__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2474:1: ( rule__ResultData__Group__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2475:2: rule__ResultData__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultData__Group__2__Impl_in_rule__ResultData__Group__24899);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2481:1: rule__ResultData__Group__2__Impl : ( ( rule__ResultData__ValueAssignment_2 ) ) ;
    public final void rule__ResultData__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2485:1: ( ( ( rule__ResultData__ValueAssignment_2 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2486:1: ( ( rule__ResultData__ValueAssignment_2 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2486:1: ( ( rule__ResultData__ValueAssignment_2 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2487:1: ( rule__ResultData__ValueAssignment_2 )
            {
             before(grammarAccess.getResultDataAccess().getValueAssignment_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2488:1: ( rule__ResultData__ValueAssignment_2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2488:2: rule__ResultData__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__ResultData__ValueAssignment_2_in_rule__ResultData__Group__2__Impl4926);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2505:1: rule__ResultReportCollection__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ResultReportCollection__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2509:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2510:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2510:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2511:1: RULE_ID
            {
             before(grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultReportCollection__NameAssignment_14967); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2520:1: rule__ResultReportCollection__TitleAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__ResultReportCollection__TitleAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2524:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2525:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2525:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2526:1: RULE_STRING
            {
             before(grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReportCollection__TitleAssignment_2_14998); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2535:1: rule__ResultReportCollection__TargetAssignment_5 : ( ( ruleURIID ) ) ;
    public final void rule__ResultReportCollection__TargetAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2539:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2540:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2540:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2541:1: ( ruleURIID )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_5_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2542:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2543:1: ruleURIID
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultReportCollection__TargetAssignment_55033);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2554:1: rule__ResultReportCollection__DecriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ResultReportCollection__DecriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2558:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2559:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2559:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2560:1: RULE_STRING
            {
             before(grammarAccess.getResultReportCollectionAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReportCollection__DecriptionAssignment_6_15068); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2569:1: rule__ResultReportCollection__ContentAssignment_7 : ( ruleResultReport ) ;
    public final void rule__ResultReportCollection__ContentAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2573:1: ( ( ruleResultReport ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2574:1: ( ruleResultReport )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2574:1: ( ruleResultReport )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2575:1: ruleResultReport
            {
             before(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleResultReport_in_rule__ResultReportCollection__ContentAssignment_75099);
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


    // $ANTLR start "rule__ResultReportCollection__IssuesAssignment_8_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2584:1: rule__ResultReportCollection__IssuesAssignment_8_1 : ( ruleReportIssue ) ;
    public final void rule__ResultReportCollection__IssuesAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2588:1: ( ( ruleReportIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2589:1: ( ruleReportIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2589:1: ( ruleReportIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2590:1: ruleReportIssue
            {
             before(grammarAccess.getResultReportCollectionAccess().getIssuesReportIssueParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_ruleReportIssue_in_rule__ResultReportCollection__IssuesAssignment_8_15130);
            ruleReportIssue();

            state._fsp--;

             after(grammarAccess.getResultReportCollectionAccess().getIssuesReportIssueParserRuleCall_8_1_0()); 

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
    // $ANTLR end "rule__ResultReportCollection__IssuesAssignment_8_1"


    // $ANTLR start "rule__ResultReport__NameAssignment_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2599:1: rule__ResultReport__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ResultReport__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2603:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2604:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2604:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2605:1: RULE_ID
            {
             before(grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultReport__NameAssignment_15161); 
             after(grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__ResultReport__NameAssignment_1"


    // $ANTLR start "rule__ResultReport__TitleAssignment_2_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2614:1: rule__ResultReport__TitleAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__ResultReport__TitleAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2618:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2619:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2619:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2620:1: RULE_STRING
            {
             before(grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReport__TitleAssignment_2_15192); 
             after(grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__ResultReport__TitleAssignment_2_1"


    // $ANTLR start "rule__ResultReport__TargetAssignment_5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2629:1: rule__ResultReport__TargetAssignment_5 : ( ( ruleURIID ) ) ;
    public final void rule__ResultReport__TargetAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2633:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2634:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2634:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2635:1: ( ruleURIID )
            {
             before(grammarAccess.getResultReportAccess().getTargetEObjectCrossReference_5_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2636:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2637:1: ruleURIID
            {
             before(grammarAccess.getResultReportAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultReport__TargetAssignment_55227);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getResultReportAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getResultReportAccess().getTargetEObjectCrossReference_5_0()); 

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
    // $ANTLR end "rule__ResultReport__TargetAssignment_5"


    // $ANTLR start "rule__ResultReport__DecriptionAssignment_6_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2648:1: rule__ResultReport__DecriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ResultReport__DecriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2652:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2653:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2653:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2654:1: RULE_STRING
            {
             before(grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReport__DecriptionAssignment_6_15262); 
             after(grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 

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
    // $ANTLR end "rule__ResultReport__DecriptionAssignment_6_1"


    // $ANTLR start "rule__ResultReport__HeadingAssignment_7_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2663:1: rule__ResultReport__HeadingAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__ResultReport__HeadingAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2667:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2668:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2668:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2669:1: RULE_STRING
            {
             before(grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReport__HeadingAssignment_7_15293); 
             after(grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 

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
    // $ANTLR end "rule__ResultReport__HeadingAssignment_7_1"


    // $ANTLR start "rule__ResultReport__ContentAssignment_7_2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2678:1: rule__ResultReport__ContentAssignment_7_2 : ( ruleResultContributor ) ;
    public final void rule__ResultReport__ContentAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2682:1: ( ( ruleResultContributor ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2683:1: ( ruleResultContributor )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2683:1: ( ruleResultContributor )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2684:1: ruleResultContributor
            {
             before(grammarAccess.getResultReportAccess().getContentResultContributorParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_ruleResultContributor_in_rule__ResultReport__ContentAssignment_7_25324);
            ruleResultContributor();

            state._fsp--;

             after(grammarAccess.getResultReportAccess().getContentResultContributorParserRuleCall_7_2_0()); 

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
    // $ANTLR end "rule__ResultReport__ContentAssignment_7_2"


    // $ANTLR start "rule__ResultReport__ResultDataAssignment_8_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2693:1: rule__ResultReport__ResultDataAssignment_8_1 : ( ruleResultData ) ;
    public final void rule__ResultReport__ResultDataAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2697:1: ( ( ruleResultData ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2698:1: ( ruleResultData )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2698:1: ( ruleResultData )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2699:1: ruleResultData
            {
             before(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_ruleResultData_in_rule__ResultReport__ResultDataAssignment_8_15355);
            ruleResultData();

            state._fsp--;

             after(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); 

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
    // $ANTLR end "rule__ResultReport__ResultDataAssignment_8_1"


    // $ANTLR start "rule__ResultReport__IssuesAssignment_9_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2708:1: rule__ResultReport__IssuesAssignment_9_1 : ( ruleReportIssue ) ;
    public final void rule__ResultReport__IssuesAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2712:1: ( ( ruleReportIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2713:1: ( ruleReportIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2713:1: ( ruleReportIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2714:1: ruleReportIssue
            {
             before(grammarAccess.getResultReportAccess().getIssuesReportIssueParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_ruleReportIssue_in_rule__ResultReport__IssuesAssignment_9_15386);
            ruleReportIssue();

            state._fsp--;

             after(grammarAccess.getResultReportAccess().getIssuesReportIssueParserRuleCall_9_1_0()); 

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
    // $ANTLR end "rule__ResultReport__IssuesAssignment_9_1"


    // $ANTLR start "rule__IssuesReport__NameAssignment_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2723:1: rule__IssuesReport__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__IssuesReport__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2727:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2728:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2728:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2729:1: RULE_ID
            {
             before(grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IssuesReport__NameAssignment_15417); 
             after(grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__IssuesReport__NameAssignment_1"


    // $ANTLR start "rule__IssuesReport__TitleAssignment_2_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2738:1: rule__IssuesReport__TitleAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__IssuesReport__TitleAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2742:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2743:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2743:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2744:1: RULE_STRING
            {
             before(grammarAccess.getIssuesReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IssuesReport__TitleAssignment_2_15448); 
             after(grammarAccess.getIssuesReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__IssuesReport__TitleAssignment_2_1"


    // $ANTLR start "rule__IssuesReport__TargetAssignment_5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2753:1: rule__IssuesReport__TargetAssignment_5 : ( ( ruleURIID ) ) ;
    public final void rule__IssuesReport__TargetAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2757:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2758:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2758:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2759:1: ( ruleURIID )
            {
             before(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_5_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2760:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2761:1: ruleURIID
            {
             before(grammarAccess.getIssuesReportAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__IssuesReport__TargetAssignment_55483);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getIssuesReportAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_5_0()); 

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
    // $ANTLR end "rule__IssuesReport__TargetAssignment_5"


    // $ANTLR start "rule__IssuesReport__DecriptionAssignment_6_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2772:1: rule__IssuesReport__DecriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__IssuesReport__DecriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2776:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2777:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2777:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2778:1: RULE_STRING
            {
             before(grammarAccess.getIssuesReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IssuesReport__DecriptionAssignment_6_15518); 
             after(grammarAccess.getIssuesReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 

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
    // $ANTLR end "rule__IssuesReport__DecriptionAssignment_6_1"


    // $ANTLR start "rule__IssuesReport__IssuesAssignment_7"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2787:1: rule__IssuesReport__IssuesAssignment_7 : ( ruleReportIssue ) ;
    public final void rule__IssuesReport__IssuesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2791:1: ( ( ruleReportIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2792:1: ( ruleReportIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2792:1: ( ruleReportIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2793:1: ruleReportIssue
            {
             before(grammarAccess.getIssuesReportAccess().getIssuesReportIssueParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleReportIssue_in_rule__IssuesReport__IssuesAssignment_75549);
            ruleReportIssue();

            state._fsp--;

             after(grammarAccess.getIssuesReportAccess().getIssuesReportIssueParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__IssuesReport__IssuesAssignment_7"


    // $ANTLR start "rule__ResultContributor__ContributorAssignment_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2802:1: rule__ResultContributor__ContributorAssignment_1 : ( ( ruleURIID ) ) ;
    public final void rule__ResultContributor__ContributorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2806:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2807:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2807:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2808:1: ( ruleURIID )
            {
             before(grammarAccess.getResultContributorAccess().getContributorEObjectCrossReference_1_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2809:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2810:1: ruleURIID
            {
             before(grammarAccess.getResultContributorAccess().getContributorEObjectURIIDParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultContributor__ContributorAssignment_15584);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getResultContributorAccess().getContributorEObjectURIIDParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getResultContributorAccess().getContributorEObjectCrossReference_1_0()); 

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
    // $ANTLR end "rule__ResultContributor__ContributorAssignment_1"


    // $ANTLR start "rule__ResultContributor__CellAssignment_4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2821:1: rule__ResultContributor__CellAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ResultContributor__CellAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2825:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2826:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2826:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2827:1: RULE_STRING
            {
             before(grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultContributor__CellAssignment_45619); 
             after(grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__ResultContributor__CellAssignment_4"


    // $ANTLR start "rule__ResultContributor__IssuesAssignment_5_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2836:1: rule__ResultContributor__IssuesAssignment_5_1 : ( ruleReportIssue ) ;
    public final void rule__ResultContributor__IssuesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2840:1: ( ( ruleReportIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2841:1: ( ruleReportIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2841:1: ( ruleReportIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2842:1: ruleReportIssue
            {
             before(grammarAccess.getResultContributorAccess().getIssuesReportIssueParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleReportIssue_in_rule__ResultContributor__IssuesAssignment_5_15650);
            ruleReportIssue();

            state._fsp--;

             after(grammarAccess.getResultContributorAccess().getIssuesReportIssueParserRuleCall_5_1_0()); 

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
    // $ANTLR end "rule__ResultContributor__IssuesAssignment_5_1"


    // $ANTLR start "rule__ResultContributor__SubcontributorAssignment_6"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2851:1: rule__ResultContributor__SubcontributorAssignment_6 : ( ruleResultContributor ) ;
    public final void rule__ResultContributor__SubcontributorAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2855:1: ( ( ruleResultContributor ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2856:1: ( ruleResultContributor )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2856:1: ( ruleResultContributor )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2857:1: ruleResultContributor
            {
             before(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleResultContributor_in_rule__ResultContributor__SubcontributorAssignment_65681);
            ruleResultContributor();

            state._fsp--;

             after(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_6_0()); 

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
    // $ANTLR end "rule__ResultContributor__SubcontributorAssignment_6"


    // $ANTLR start "rule__ReportIssue__IssueTypeAssignment_0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2866:1: rule__ReportIssue__IssueTypeAssignment_0 : ( ruleReportIssueType ) ;
    public final void rule__ReportIssue__IssueTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2870:1: ( ( ruleReportIssueType ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2871:1: ( ruleReportIssueType )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2871:1: ( ruleReportIssueType )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2872:1: ruleReportIssueType
            {
             before(grammarAccess.getReportIssueAccess().getIssueTypeReportIssueTypeEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleReportIssueType_in_rule__ReportIssue__IssueTypeAssignment_05712);
            ruleReportIssueType();

            state._fsp--;

             after(grammarAccess.getReportIssueAccess().getIssueTypeReportIssueTypeEnumRuleCall_0_0()); 

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
    // $ANTLR end "rule__ReportIssue__IssueTypeAssignment_0"


    // $ANTLR start "rule__ReportIssue__TitleAssignment_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2881:1: rule__ReportIssue__TitleAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ReportIssue__TitleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2885:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2886:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2886:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2887:1: RULE_STRING
            {
             before(grammarAccess.getReportIssueAccess().getTitleSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ReportIssue__TitleAssignment_15743); 
             after(grammarAccess.getReportIssueAccess().getTitleSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__ReportIssue__TitleAssignment_1"


    // $ANTLR start "rule__ReportIssue__TargetAssignment_2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2896:1: rule__ReportIssue__TargetAssignment_2 : ( ( ruleURIID ) ) ;
    public final void rule__ReportIssue__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2900:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2901:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2901:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2902:1: ( ruleURIID )
            {
             before(grammarAccess.getReportIssueAccess().getTargetEObjectCrossReference_2_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2903:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2904:1: ruleURIID
            {
             before(grammarAccess.getReportIssueAccess().getTargetEObjectURIIDParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ReportIssue__TargetAssignment_25778);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getReportIssueAccess().getTargetEObjectURIIDParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getReportIssueAccess().getTargetEObjectCrossReference_2_0()); 

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
    // $ANTLR end "rule__ReportIssue__TargetAssignment_2"


    // $ANTLR start "rule__ResultData__NameAssignment_0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2915:1: rule__ResultData__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ResultData__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2919:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2920:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2920:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2921:1: RULE_ID
            {
             before(grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultData__NameAssignment_05813); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2930:1: rule__ResultData__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ResultData__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2934:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2935:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2935:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2936:1: RULE_STRING
            {
             before(grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultData__ValueAssignment_25844); 
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
    public static final BitSet FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIssuesReport248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__0_in_ruleIssuesReport274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_entryRuleResultContributor303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultContributor310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__0_in_ruleResultContributor336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssue_in_entryRuleReportIssue363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReportIssue370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssue__Group__0_in_ruleReportIssue396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_entryRuleResultData423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultData430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__0_in_ruleResultData456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_entryRuleURIID483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIID490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIID516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssueType__Alternatives_in_ruleReportIssueType552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReport_in_rule__ResultReports__Alternatives587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_rule__ResultReports__Alternatives604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssuesReport_in_rule__ResultReports__Alternatives621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ReportIssueType__Alternatives655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ReportIssueType__Alternatives676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ReportIssueType__Alternatives697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ReportIssueType__Alternatives718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__0__Impl_in_rule__ResultReportCollection__Group__0751 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__1_in_rule__ResultReportCollection__Group__0754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ResultReportCollection__Group__0__Impl782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__1__Impl_in_rule__ResultReportCollection__Group__1813 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__2_in_rule__ResultReportCollection__Group__1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__NameAssignment_1_in_rule__ResultReportCollection__Group__1__Impl843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__2__Impl_in_rule__ResultReportCollection__Group__2873 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__3_in_rule__ResultReportCollection__Group__2876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__0_in_rule__ResultReportCollection__Group__2__Impl903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__3__Impl_in_rule__ResultReportCollection__Group__3934 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__4_in_rule__ResultReportCollection__Group__3937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ResultReportCollection__Group__3__Impl965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__4__Impl_in_rule__ResultReportCollection__Group__4996 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__5_in_rule__ResultReportCollection__Group__4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ResultReportCollection__Group__4__Impl1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__5__Impl_in_rule__ResultReportCollection__Group__51058 = new BitSet(new long[]{0x0000000000740000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__6_in_rule__ResultReportCollection__Group__51061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__TargetAssignment_5_in_rule__ResultReportCollection__Group__5__Impl1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__6__Impl_in_rule__ResultReportCollection__Group__61118 = new BitSet(new long[]{0x0000000000740000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__7_in_rule__ResultReportCollection__Group__61121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__0_in_rule__ResultReportCollection__Group__6__Impl1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__7__Impl_in_rule__ResultReportCollection__Group__71179 = new BitSet(new long[]{0x0000000000740000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__8_in_rule__ResultReportCollection__Group__71182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__ContentAssignment_7_in_rule__ResultReportCollection__Group__7__Impl1209 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__8__Impl_in_rule__ResultReportCollection__Group__81240 = new BitSet(new long[]{0x0000000000740000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__9_in_rule__ResultReportCollection__Group__81243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_8__0_in_rule__ResultReportCollection__Group__8__Impl1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__9__Impl_in_rule__ResultReportCollection__Group__91301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ResultReportCollection__Group__9__Impl1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__0__Impl_in_rule__ResultReportCollection__Group_2__01380 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__1_in_rule__ResultReportCollection__Group_2__01383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ResultReportCollection__Group_2__0__Impl1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__1__Impl_in_rule__ResultReportCollection__Group_2__11442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__TitleAssignment_2_1_in_rule__ResultReportCollection__Group_2__1__Impl1469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__0__Impl_in_rule__ResultReportCollection__Group_6__01503 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__1_in_rule__ResultReportCollection__Group_6__01506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultReportCollection__Group_6__0__Impl1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__1__Impl_in_rule__ResultReportCollection__Group_6__11565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__DecriptionAssignment_6_1_in_rule__ResultReportCollection__Group_6__1__Impl1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_8__0__Impl_in_rule__ResultReportCollection__Group_8__01626 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_8__1_in_rule__ResultReportCollection__Group_8__01629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResultReportCollection__Group_8__0__Impl1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_8__1__Impl_in_rule__ResultReportCollection__Group_8__11688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__IssuesAssignment_8_1_in_rule__ResultReportCollection__Group_8__1__Impl1715 = new BitSet(new long[]{0x0000000000007802L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__0__Impl_in_rule__ResultReport__Group__01750 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__1_in_rule__ResultReport__Group__01753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ResultReport__Group__0__Impl1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__1__Impl_in_rule__ResultReport__Group__11812 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__2_in_rule__ResultReport__Group__11815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__NameAssignment_1_in_rule__ResultReport__Group__1__Impl1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__2__Impl_in_rule__ResultReport__Group__21872 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__3_in_rule__ResultReport__Group__21875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_2__0_in_rule__ResultReport__Group__2__Impl1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__3__Impl_in_rule__ResultReport__Group__31933 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__4_in_rule__ResultReport__Group__31936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ResultReport__Group__3__Impl1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__4__Impl_in_rule__ResultReport__Group__41995 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__5_in_rule__ResultReport__Group__41998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ResultReport__Group__4__Impl2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__5__Impl_in_rule__ResultReport__Group__52057 = new BitSet(new long[]{0x0000000001B40000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__6_in_rule__ResultReport__Group__52060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__TargetAssignment_5_in_rule__ResultReport__Group__5__Impl2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__6__Impl_in_rule__ResultReport__Group__62117 = new BitSet(new long[]{0x0000000001B40000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__7_in_rule__ResultReport__Group__62120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_6__0_in_rule__ResultReport__Group__6__Impl2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__7__Impl_in_rule__ResultReport__Group__72178 = new BitSet(new long[]{0x0000000001B40000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__8_in_rule__ResultReport__Group__72181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__0_in_rule__ResultReport__Group__7__Impl2208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__8__Impl_in_rule__ResultReport__Group__82239 = new BitSet(new long[]{0x0000000001B40000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__9_in_rule__ResultReport__Group__82242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_8__0_in_rule__ResultReport__Group__8__Impl2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__9__Impl_in_rule__ResultReport__Group__92300 = new BitSet(new long[]{0x0000000001B40000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__10_in_rule__ResultReport__Group__92303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__0_in_rule__ResultReport__Group__9__Impl2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__10__Impl_in_rule__ResultReport__Group__102361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ResultReport__Group__10__Impl2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_2__0__Impl_in_rule__ResultReport__Group_2__02442 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_2__1_in_rule__ResultReport__Group_2__02445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ResultReport__Group_2__0__Impl2473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_2__1__Impl_in_rule__ResultReport__Group_2__12504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__TitleAssignment_2_1_in_rule__ResultReport__Group_2__1__Impl2531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_6__0__Impl_in_rule__ResultReport__Group_6__02565 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_6__1_in_rule__ResultReport__Group_6__02568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultReport__Group_6__0__Impl2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_6__1__Impl_in_rule__ResultReport__Group_6__12627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__DecriptionAssignment_6_1_in_rule__ResultReport__Group_6__1__Impl2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__0__Impl_in_rule__ResultReport__Group_7__02688 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__1_in_rule__ResultReport__Group_7__02691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ResultReport__Group_7__0__Impl2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__1__Impl_in_rule__ResultReport__Group_7__12750 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__2_in_rule__ResultReport__Group_7__12753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__HeadingAssignment_7_1_in_rule__ResultReport__Group_7__1__Impl2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__2__Impl_in_rule__ResultReport__Group_7__22810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__ContentAssignment_7_2_in_rule__ResultReport__Group_7__2__Impl2837 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_8__0__Impl_in_rule__ResultReport__Group_8__02874 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_8__1_in_rule__ResultReport__Group_8__02877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ResultReport__Group_8__0__Impl2905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_8__1__Impl_in_rule__ResultReport__Group_8__12936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__ResultDataAssignment_8_1_in_rule__ResultReport__Group_8__1__Impl2965 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__ResultReport__ResultDataAssignment_8_1_in_rule__ResultReport__Group_8__1__Impl2977 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__0__Impl_in_rule__ResultReport__Group_9__03014 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__1_in_rule__ResultReport__Group_9__03017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResultReport__Group_9__0__Impl3045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__1__Impl_in_rule__ResultReport__Group_9__13076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__IssuesAssignment_9_1_in_rule__ResultReport__Group_9__1__Impl3103 = new BitSet(new long[]{0x0000000000007802L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__0__Impl_in_rule__IssuesReport__Group__03138 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__1_in_rule__IssuesReport__Group__03141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__IssuesReport__Group__0__Impl3169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__1__Impl_in_rule__IssuesReport__Group__13200 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__2_in_rule__IssuesReport__Group__13203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__NameAssignment_1_in_rule__IssuesReport__Group__1__Impl3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__2__Impl_in_rule__IssuesReport__Group__23260 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__3_in_rule__IssuesReport__Group__23263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__0_in_rule__IssuesReport__Group__2__Impl3290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__3__Impl_in_rule__IssuesReport__Group__33321 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__4_in_rule__IssuesReport__Group__33324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__IssuesReport__Group__3__Impl3352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__4__Impl_in_rule__IssuesReport__Group__43383 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__5_in_rule__IssuesReport__Group__43386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__IssuesReport__Group__4__Impl3414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__5__Impl_in_rule__IssuesReport__Group__53445 = new BitSet(new long[]{0x0000000000147800L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__6_in_rule__IssuesReport__Group__53448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__TargetAssignment_5_in_rule__IssuesReport__Group__5__Impl3475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__6__Impl_in_rule__IssuesReport__Group__63505 = new BitSet(new long[]{0x0000000000147800L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__7_in_rule__IssuesReport__Group__63508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_6__0_in_rule__IssuesReport__Group__6__Impl3535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__7__Impl_in_rule__IssuesReport__Group__73566 = new BitSet(new long[]{0x0000000000147800L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__8_in_rule__IssuesReport__Group__73569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__IssuesAssignment_7_in_rule__IssuesReport__Group__7__Impl3596 = new BitSet(new long[]{0x0000000000007802L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__8__Impl_in_rule__IssuesReport__Group__83627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__IssuesReport__Group__8__Impl3655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__0__Impl_in_rule__IssuesReport__Group_2__03704 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__1_in_rule__IssuesReport__Group_2__03707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__IssuesReport__Group_2__0__Impl3735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__1__Impl_in_rule__IssuesReport__Group_2__13766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__TitleAssignment_2_1_in_rule__IssuesReport__Group_2__1__Impl3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_6__0__Impl_in_rule__IssuesReport__Group_6__03827 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_6__1_in_rule__IssuesReport__Group_6__03830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__IssuesReport__Group_6__0__Impl3858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_6__1__Impl_in_rule__IssuesReport__Group_6__13889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__DecriptionAssignment_6_1_in_rule__IssuesReport__Group_6__1__Impl3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__0__Impl_in_rule__ResultContributor__Group__03950 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__1_in_rule__ResultContributor__Group__03953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ResultContributor__Group__0__Impl3981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__1__Impl_in_rule__ResultContributor__Group__14012 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__2_in_rule__ResultContributor__Group__14015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__ContributorAssignment_1_in_rule__ResultContributor__Group__1__Impl4042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__2__Impl_in_rule__ResultContributor__Group__24072 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__3_in_rule__ResultContributor__Group__24075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ResultContributor__Group__2__Impl4103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__3__Impl_in_rule__ResultContributor__Group__34134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__4_in_rule__ResultContributor__Group__34137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ResultContributor__Group__3__Impl4165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__4__Impl_in_rule__ResultContributor__Group__44196 = new BitSet(new long[]{0x0000000002240000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__5_in_rule__ResultContributor__Group__44199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__CellAssignment_4_in_rule__ResultContributor__Group__4__Impl4228 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ResultContributor__CellAssignment_4_in_rule__ResultContributor__Group__4__Impl4240 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__5__Impl_in_rule__ResultContributor__Group__54273 = new BitSet(new long[]{0x0000000002240000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__6_in_rule__ResultContributor__Group__54276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__0_in_rule__ResultContributor__Group__5__Impl4303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__6__Impl_in_rule__ResultContributor__Group__64334 = new BitSet(new long[]{0x0000000002240000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__7_in_rule__ResultContributor__Group__64337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__SubcontributorAssignment_6_in_rule__ResultContributor__Group__6__Impl4364 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__7__Impl_in_rule__ResultContributor__Group__74395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ResultContributor__Group__7__Impl4423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__0__Impl_in_rule__ResultContributor__Group_5__04470 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__1_in_rule__ResultContributor__Group_5__04473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResultContributor__Group_5__0__Impl4501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__1__Impl_in_rule__ResultContributor__Group_5__14532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__IssuesAssignment_5_1_in_rule__ResultContributor__Group_5__1__Impl4559 = new BitSet(new long[]{0x0000000000007802L});
    public static final BitSet FOLLOW_rule__ReportIssue__Group__0__Impl_in_rule__ReportIssue__Group__04594 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ReportIssue__Group__1_in_rule__ReportIssue__Group__04597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssue__IssueTypeAssignment_0_in_rule__ReportIssue__Group__0__Impl4624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssue__Group__1__Impl_in_rule__ReportIssue__Group__14654 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ReportIssue__Group__2_in_rule__ReportIssue__Group__14657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssue__TitleAssignment_1_in_rule__ReportIssue__Group__1__Impl4684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssue__Group__2__Impl_in_rule__ReportIssue__Group__24714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssue__TargetAssignment_2_in_rule__ReportIssue__Group__2__Impl4741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__0__Impl_in_rule__ResultData__Group__04777 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ResultData__Group__1_in_rule__ResultData__Group__04780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__NameAssignment_0_in_rule__ResultData__Group__0__Impl4807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__1__Impl_in_rule__ResultData__Group__14837 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultData__Group__2_in_rule__ResultData__Group__14840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ResultData__Group__1__Impl4868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__2__Impl_in_rule__ResultData__Group__24899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__ValueAssignment_2_in_rule__ResultData__Group__2__Impl4926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultReportCollection__NameAssignment_14967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReportCollection__TitleAssignment_2_14998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultReportCollection__TargetAssignment_55033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReportCollection__DecriptionAssignment_6_15068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReport_in_rule__ResultReportCollection__ContentAssignment_75099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssue_in_rule__ResultReportCollection__IssuesAssignment_8_15130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultReport__NameAssignment_15161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReport__TitleAssignment_2_15192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultReport__TargetAssignment_55227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReport__DecriptionAssignment_6_15262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReport__HeadingAssignment_7_15293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_rule__ResultReport__ContentAssignment_7_25324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_rule__ResultReport__ResultDataAssignment_8_15355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssue_in_rule__ResultReport__IssuesAssignment_9_15386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IssuesReport__NameAssignment_15417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IssuesReport__TitleAssignment_2_15448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__IssuesReport__TargetAssignment_55483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IssuesReport__DecriptionAssignment_6_15518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssue_in_rule__IssuesReport__IssuesAssignment_75549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultContributor__ContributorAssignment_15584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultContributor__CellAssignment_45619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssue_in_rule__ResultContributor__IssuesAssignment_5_15650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_rule__ResultContributor__SubcontributorAssignment_65681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssueType_in_rule__ReportIssue__IssueTypeAssignment_05712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ReportIssue__TitleAssignment_15743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ReportIssue__TargetAssignment_25778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultData__NameAssignment_05813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultData__ValueAssignment_25844 = new BitSet(new long[]{0x0000000000000002L});

}
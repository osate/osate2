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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'error'", "'warning'", "'info'", "'success'", "'fail'", "'unknown'", "'reports'", "'['", "'target'", "']'", "':'", "'description'", "'issues'", "'report'", "'heading'", "'results'", "'contributor'", "'data'", "'='"
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
            case 24:
                {
                alt1=1;
                }
                break;
            case 17:
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:334:1: rule__ReportIssueType__Alternatives : ( ( ( 'error' ) ) | ( ( 'warning' ) ) | ( ( 'info' ) ) | ( ( 'success' ) ) | ( ( 'fail' ) ) | ( ( 'unknown' ) ) );
    public final void rule__ReportIssueType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:338:1: ( ( ( 'error' ) ) | ( ( 'warning' ) ) | ( ( 'info' ) ) | ( ( 'success' ) ) | ( ( 'fail' ) ) | ( ( 'unknown' ) ) )
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
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:353:6: ( ( 'info' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:353:6: ( ( 'info' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:354:1: ( 'info' )
                    {
                     before(grammarAccess.getReportIssueTypeAccess().getINFOEnumLiteralDeclaration_2()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:355:1: ( 'info' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:355:3: 'info'
                    {
                    match(input,13,FOLLOW_13_in_rule__ReportIssueType__Alternatives697); 

                    }

                     after(grammarAccess.getReportIssueTypeAccess().getINFOEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:360:6: ( ( 'success' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:360:6: ( ( 'success' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:361:1: ( 'success' )
                    {
                     before(grammarAccess.getReportIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:362:1: ( 'success' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:362:3: 'success'
                    {
                    match(input,14,FOLLOW_14_in_rule__ReportIssueType__Alternatives718); 

                    }

                     after(grammarAccess.getReportIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:367:6: ( ( 'fail' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:367:6: ( ( 'fail' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:368:1: ( 'fail' )
                    {
                     before(grammarAccess.getReportIssueTypeAccess().getFAILEnumLiteralDeclaration_4()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:369:1: ( 'fail' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:369:3: 'fail'
                    {
                    match(input,15,FOLLOW_15_in_rule__ReportIssueType__Alternatives739); 

                    }

                     after(grammarAccess.getReportIssueTypeAccess().getFAILEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:374:6: ( ( 'unknown' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:374:6: ( ( 'unknown' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:375:1: ( 'unknown' )
                    {
                     before(grammarAccess.getReportIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:376:1: ( 'unknown' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:376:3: 'unknown'
                    {
                    match(input,16,FOLLOW_16_in_rule__ReportIssueType__Alternatives760); 

                    }

                     after(grammarAccess.getReportIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_5()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:388:1: rule__ResultReportCollection__Group__0 : rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1 ;
    public final void rule__ResultReportCollection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:392:1: ( rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:393:2: rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__0__Impl_in_rule__ResultReportCollection__Group__0793);
            rule__ResultReportCollection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__1_in_rule__ResultReportCollection__Group__0796);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:400:1: rule__ResultReportCollection__Group__0__Impl : ( 'reports' ) ;
    public final void rule__ResultReportCollection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:404:1: ( ( 'reports' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:405:1: ( 'reports' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:405:1: ( 'reports' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:406:1: 'reports'
            {
             before(grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__ResultReportCollection__Group__0__Impl824); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:419:1: rule__ResultReportCollection__Group__1 : rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2 ;
    public final void rule__ResultReportCollection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:423:1: ( rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:424:2: rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__1__Impl_in_rule__ResultReportCollection__Group__1855);
            rule__ResultReportCollection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__2_in_rule__ResultReportCollection__Group__1858);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:431:1: rule__ResultReportCollection__Group__1__Impl : ( ( rule__ResultReportCollection__NameAssignment_1 ) ) ;
    public final void rule__ResultReportCollection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:435:1: ( ( ( rule__ResultReportCollection__NameAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:436:1: ( ( rule__ResultReportCollection__NameAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:436:1: ( ( rule__ResultReportCollection__NameAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:437:1: ( rule__ResultReportCollection__NameAssignment_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:438:1: ( rule__ResultReportCollection__NameAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:438:2: rule__ResultReportCollection__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__NameAssignment_1_in_rule__ResultReportCollection__Group__1__Impl885);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:448:1: rule__ResultReportCollection__Group__2 : rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3 ;
    public final void rule__ResultReportCollection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:452:1: ( rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:453:2: rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__2__Impl_in_rule__ResultReportCollection__Group__2915);
            rule__ResultReportCollection__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__3_in_rule__ResultReportCollection__Group__2918);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:460:1: rule__ResultReportCollection__Group__2__Impl : ( ( rule__ResultReportCollection__Group_2__0 )? ) ;
    public final void rule__ResultReportCollection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:464:1: ( ( ( rule__ResultReportCollection__Group_2__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:465:1: ( ( rule__ResultReportCollection__Group_2__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:465:1: ( ( rule__ResultReportCollection__Group_2__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:466:1: ( rule__ResultReportCollection__Group_2__0 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:467:1: ( rule__ResultReportCollection__Group_2__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==21) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:467:2: rule__ResultReportCollection__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__0_in_rule__ResultReportCollection__Group__2__Impl945);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:477:1: rule__ResultReportCollection__Group__3 : rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4 ;
    public final void rule__ResultReportCollection__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:481:1: ( rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:482:2: rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__3__Impl_in_rule__ResultReportCollection__Group__3976);
            rule__ResultReportCollection__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__4_in_rule__ResultReportCollection__Group__3979);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:489:1: rule__ResultReportCollection__Group__3__Impl : ( '[' ) ;
    public final void rule__ResultReportCollection__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:493:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:494:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:494:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:495:1: '['
            {
             before(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_3()); 
            match(input,18,FOLLOW_18_in_rule__ResultReportCollection__Group__3__Impl1007); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:508:1: rule__ResultReportCollection__Group__4 : rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5 ;
    public final void rule__ResultReportCollection__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:512:1: ( rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:513:2: rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__4__Impl_in_rule__ResultReportCollection__Group__41038);
            rule__ResultReportCollection__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__5_in_rule__ResultReportCollection__Group__41041);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:520:1: rule__ResultReportCollection__Group__4__Impl : ( 'target' ) ;
    public final void rule__ResultReportCollection__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:524:1: ( ( 'target' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:525:1: ( 'target' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:525:1: ( 'target' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:526:1: 'target'
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetKeyword_4()); 
            match(input,19,FOLLOW_19_in_rule__ResultReportCollection__Group__4__Impl1069); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:539:1: rule__ResultReportCollection__Group__5 : rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6 ;
    public final void rule__ResultReportCollection__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:543:1: ( rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:544:2: rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__5__Impl_in_rule__ResultReportCollection__Group__51100);
            rule__ResultReportCollection__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__6_in_rule__ResultReportCollection__Group__51103);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:551:1: rule__ResultReportCollection__Group__5__Impl : ( ( rule__ResultReportCollection__TargetAssignment_5 ) ) ;
    public final void rule__ResultReportCollection__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:555:1: ( ( ( rule__ResultReportCollection__TargetAssignment_5 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:556:1: ( ( rule__ResultReportCollection__TargetAssignment_5 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:556:1: ( ( rule__ResultReportCollection__TargetAssignment_5 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:557:1: ( rule__ResultReportCollection__TargetAssignment_5 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:558:1: ( rule__ResultReportCollection__TargetAssignment_5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:558:2: rule__ResultReportCollection__TargetAssignment_5
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__TargetAssignment_5_in_rule__ResultReportCollection__Group__5__Impl1130);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:568:1: rule__ResultReportCollection__Group__6 : rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7 ;
    public final void rule__ResultReportCollection__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:572:1: ( rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:573:2: rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__6__Impl_in_rule__ResultReportCollection__Group__61160);
            rule__ResultReportCollection__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__7_in_rule__ResultReportCollection__Group__61163);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:580:1: rule__ResultReportCollection__Group__6__Impl : ( ( rule__ResultReportCollection__Group_6__0 )? ) ;
    public final void rule__ResultReportCollection__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:584:1: ( ( ( rule__ResultReportCollection__Group_6__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:585:1: ( ( rule__ResultReportCollection__Group_6__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:585:1: ( ( rule__ResultReportCollection__Group_6__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:586:1: ( rule__ResultReportCollection__Group_6__0 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:587:1: ( rule__ResultReportCollection__Group_6__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==22) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:587:2: rule__ResultReportCollection__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__0_in_rule__ResultReportCollection__Group__6__Impl1190);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:597:1: rule__ResultReportCollection__Group__7 : rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8 ;
    public final void rule__ResultReportCollection__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:601:1: ( rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:602:2: rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__7__Impl_in_rule__ResultReportCollection__Group__71221);
            rule__ResultReportCollection__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__8_in_rule__ResultReportCollection__Group__71224);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:609:1: rule__ResultReportCollection__Group__7__Impl : ( ( rule__ResultReportCollection__ContentAssignment_7 )* ) ;
    public final void rule__ResultReportCollection__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:613:1: ( ( ( rule__ResultReportCollection__ContentAssignment_7 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:614:1: ( ( rule__ResultReportCollection__ContentAssignment_7 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:614:1: ( ( rule__ResultReportCollection__ContentAssignment_7 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:615:1: ( rule__ResultReportCollection__ContentAssignment_7 )*
            {
             before(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:616:1: ( rule__ResultReportCollection__ContentAssignment_7 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==24) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:616:2: rule__ResultReportCollection__ContentAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__ResultReportCollection__ContentAssignment_7_in_rule__ResultReportCollection__Group__7__Impl1251);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:626:1: rule__ResultReportCollection__Group__8 : rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9 ;
    public final void rule__ResultReportCollection__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:630:1: ( rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:631:2: rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__8__Impl_in_rule__ResultReportCollection__Group__81282);
            rule__ResultReportCollection__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__9_in_rule__ResultReportCollection__Group__81285);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:638:1: rule__ResultReportCollection__Group__8__Impl : ( ( rule__ResultReportCollection__Group_8__0 )? ) ;
    public final void rule__ResultReportCollection__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:642:1: ( ( ( rule__ResultReportCollection__Group_8__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:643:1: ( ( rule__ResultReportCollection__Group_8__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:643:1: ( ( rule__ResultReportCollection__Group_8__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:644:1: ( rule__ResultReportCollection__Group_8__0 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup_8()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:645:1: ( rule__ResultReportCollection__Group_8__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:645:2: rule__ResultReportCollection__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__Group_8__0_in_rule__ResultReportCollection__Group__8__Impl1312);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:655:1: rule__ResultReportCollection__Group__9 : rule__ResultReportCollection__Group__9__Impl ;
    public final void rule__ResultReportCollection__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:659:1: ( rule__ResultReportCollection__Group__9__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:660:2: rule__ResultReportCollection__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__9__Impl_in_rule__ResultReportCollection__Group__91343);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:666:1: rule__ResultReportCollection__Group__9__Impl : ( ']' ) ;
    public final void rule__ResultReportCollection__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:670:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:671:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:671:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:672:1: ']'
            {
             before(grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9()); 
            match(input,20,FOLLOW_20_in_rule__ResultReportCollection__Group__9__Impl1371); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:705:1: rule__ResultReportCollection__Group_2__0 : rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1 ;
    public final void rule__ResultReportCollection__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:709:1: ( rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:710:2: rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__0__Impl_in_rule__ResultReportCollection__Group_2__01422);
            rule__ResultReportCollection__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__1_in_rule__ResultReportCollection__Group_2__01425);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:717:1: rule__ResultReportCollection__Group_2__0__Impl : ( ':' ) ;
    public final void rule__ResultReportCollection__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:721:1: ( ( ':' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:722:1: ( ':' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:722:1: ( ':' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:723:1: ':'
            {
             before(grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0()); 
            match(input,21,FOLLOW_21_in_rule__ResultReportCollection__Group_2__0__Impl1453); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:736:1: rule__ResultReportCollection__Group_2__1 : rule__ResultReportCollection__Group_2__1__Impl ;
    public final void rule__ResultReportCollection__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:740:1: ( rule__ResultReportCollection__Group_2__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:741:2: rule__ResultReportCollection__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__1__Impl_in_rule__ResultReportCollection__Group_2__11484);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:747:1: rule__ResultReportCollection__Group_2__1__Impl : ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) ) ;
    public final void rule__ResultReportCollection__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:751:1: ( ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:752:1: ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:752:1: ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:753:1: ( rule__ResultReportCollection__TitleAssignment_2_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:754:1: ( rule__ResultReportCollection__TitleAssignment_2_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:754:2: rule__ResultReportCollection__TitleAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__TitleAssignment_2_1_in_rule__ResultReportCollection__Group_2__1__Impl1511);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:768:1: rule__ResultReportCollection__Group_6__0 : rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1 ;
    public final void rule__ResultReportCollection__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:772:1: ( rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:773:2: rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__0__Impl_in_rule__ResultReportCollection__Group_6__01545);
            rule__ResultReportCollection__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__1_in_rule__ResultReportCollection__Group_6__01548);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:780:1: rule__ResultReportCollection__Group_6__0__Impl : ( 'description' ) ;
    public final void rule__ResultReportCollection__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:784:1: ( ( 'description' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:785:1: ( 'description' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:785:1: ( 'description' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:786:1: 'description'
            {
             before(grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0()); 
            match(input,22,FOLLOW_22_in_rule__ResultReportCollection__Group_6__0__Impl1576); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:799:1: rule__ResultReportCollection__Group_6__1 : rule__ResultReportCollection__Group_6__1__Impl ;
    public final void rule__ResultReportCollection__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:803:1: ( rule__ResultReportCollection__Group_6__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:804:2: rule__ResultReportCollection__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__1__Impl_in_rule__ResultReportCollection__Group_6__11607);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:810:1: rule__ResultReportCollection__Group_6__1__Impl : ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) ) ;
    public final void rule__ResultReportCollection__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:814:1: ( ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:815:1: ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:815:1: ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:816:1: ( rule__ResultReportCollection__DecriptionAssignment_6_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getDecriptionAssignment_6_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:817:1: ( rule__ResultReportCollection__DecriptionAssignment_6_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:817:2: rule__ResultReportCollection__DecriptionAssignment_6_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__DecriptionAssignment_6_1_in_rule__ResultReportCollection__Group_6__1__Impl1634);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:831:1: rule__ResultReportCollection__Group_8__0 : rule__ResultReportCollection__Group_8__0__Impl rule__ResultReportCollection__Group_8__1 ;
    public final void rule__ResultReportCollection__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:835:1: ( rule__ResultReportCollection__Group_8__0__Impl rule__ResultReportCollection__Group_8__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:836:2: rule__ResultReportCollection__Group_8__0__Impl rule__ResultReportCollection__Group_8__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_8__0__Impl_in_rule__ResultReportCollection__Group_8__01668);
            rule__ResultReportCollection__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group_8__1_in_rule__ResultReportCollection__Group_8__01671);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:843:1: rule__ResultReportCollection__Group_8__0__Impl : ( 'issues' ) ;
    public final void rule__ResultReportCollection__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:847:1: ( ( 'issues' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:848:1: ( 'issues' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:848:1: ( 'issues' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:849:1: 'issues'
            {
             before(grammarAccess.getResultReportCollectionAccess().getIssuesKeyword_8_0()); 
            match(input,23,FOLLOW_23_in_rule__ResultReportCollection__Group_8__0__Impl1699); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:862:1: rule__ResultReportCollection__Group_8__1 : rule__ResultReportCollection__Group_8__1__Impl ;
    public final void rule__ResultReportCollection__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:866:1: ( rule__ResultReportCollection__Group_8__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:867:2: rule__ResultReportCollection__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_8__1__Impl_in_rule__ResultReportCollection__Group_8__11730);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:873:1: rule__ResultReportCollection__Group_8__1__Impl : ( ( rule__ResultReportCollection__IssuesAssignment_8_1 )* ) ;
    public final void rule__ResultReportCollection__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:877:1: ( ( ( rule__ResultReportCollection__IssuesAssignment_8_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:878:1: ( ( rule__ResultReportCollection__IssuesAssignment_8_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:878:1: ( ( rule__ResultReportCollection__IssuesAssignment_8_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:879:1: ( rule__ResultReportCollection__IssuesAssignment_8_1 )*
            {
             before(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:880:1: ( rule__ResultReportCollection__IssuesAssignment_8_1 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=11 && LA7_0<=16)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:880:2: rule__ResultReportCollection__IssuesAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultReportCollection__IssuesAssignment_8_1_in_rule__ResultReportCollection__Group_8__1__Impl1757);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:894:1: rule__ResultReport__Group__0 : rule__ResultReport__Group__0__Impl rule__ResultReport__Group__1 ;
    public final void rule__ResultReport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:898:1: ( rule__ResultReport__Group__0__Impl rule__ResultReport__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:899:2: rule__ResultReport__Group__0__Impl rule__ResultReport__Group__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__0__Impl_in_rule__ResultReport__Group__01792);
            rule__ResultReport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__1_in_rule__ResultReport__Group__01795);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:906:1: rule__ResultReport__Group__0__Impl : ( 'report' ) ;
    public final void rule__ResultReport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:910:1: ( ( 'report' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:911:1: ( 'report' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:911:1: ( 'report' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:912:1: 'report'
            {
             before(grammarAccess.getResultReportAccess().getReportKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__ResultReport__Group__0__Impl1823); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:925:1: rule__ResultReport__Group__1 : rule__ResultReport__Group__1__Impl rule__ResultReport__Group__2 ;
    public final void rule__ResultReport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:929:1: ( rule__ResultReport__Group__1__Impl rule__ResultReport__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:930:2: rule__ResultReport__Group__1__Impl rule__ResultReport__Group__2
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__1__Impl_in_rule__ResultReport__Group__11854);
            rule__ResultReport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__2_in_rule__ResultReport__Group__11857);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:937:1: rule__ResultReport__Group__1__Impl : ( ( rule__ResultReport__NameAssignment_1 ) ) ;
    public final void rule__ResultReport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:941:1: ( ( ( rule__ResultReport__NameAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:942:1: ( ( rule__ResultReport__NameAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:942:1: ( ( rule__ResultReport__NameAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:943:1: ( rule__ResultReport__NameAssignment_1 )
            {
             before(grammarAccess.getResultReportAccess().getNameAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:944:1: ( rule__ResultReport__NameAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:944:2: rule__ResultReport__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultReport__NameAssignment_1_in_rule__ResultReport__Group__1__Impl1884);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:954:1: rule__ResultReport__Group__2 : rule__ResultReport__Group__2__Impl rule__ResultReport__Group__3 ;
    public final void rule__ResultReport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:958:1: ( rule__ResultReport__Group__2__Impl rule__ResultReport__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:959:2: rule__ResultReport__Group__2__Impl rule__ResultReport__Group__3
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__2__Impl_in_rule__ResultReport__Group__21914);
            rule__ResultReport__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__3_in_rule__ResultReport__Group__21917);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:966:1: rule__ResultReport__Group__2__Impl : ( ( rule__ResultReport__Group_2__0 )? ) ;
    public final void rule__ResultReport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:970:1: ( ( ( rule__ResultReport__Group_2__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:971:1: ( ( rule__ResultReport__Group_2__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:971:1: ( ( rule__ResultReport__Group_2__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:972:1: ( rule__ResultReport__Group_2__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:973:1: ( rule__ResultReport__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:973:2: rule__ResultReport__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_2__0_in_rule__ResultReport__Group__2__Impl1944);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:983:1: rule__ResultReport__Group__3 : rule__ResultReport__Group__3__Impl rule__ResultReport__Group__4 ;
    public final void rule__ResultReport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:987:1: ( rule__ResultReport__Group__3__Impl rule__ResultReport__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:988:2: rule__ResultReport__Group__3__Impl rule__ResultReport__Group__4
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__3__Impl_in_rule__ResultReport__Group__31975);
            rule__ResultReport__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__4_in_rule__ResultReport__Group__31978);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:995:1: rule__ResultReport__Group__3__Impl : ( '[' ) ;
    public final void rule__ResultReport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:999:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1000:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1000:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1001:1: '['
            {
             before(grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_3()); 
            match(input,18,FOLLOW_18_in_rule__ResultReport__Group__3__Impl2006); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1014:1: rule__ResultReport__Group__4 : rule__ResultReport__Group__4__Impl rule__ResultReport__Group__5 ;
    public final void rule__ResultReport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1018:1: ( rule__ResultReport__Group__4__Impl rule__ResultReport__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1019:2: rule__ResultReport__Group__4__Impl rule__ResultReport__Group__5
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__4__Impl_in_rule__ResultReport__Group__42037);
            rule__ResultReport__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__5_in_rule__ResultReport__Group__42040);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1026:1: rule__ResultReport__Group__4__Impl : ( 'target' ) ;
    public final void rule__ResultReport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1030:1: ( ( 'target' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1031:1: ( 'target' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1031:1: ( 'target' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1032:1: 'target'
            {
             before(grammarAccess.getResultReportAccess().getTargetKeyword_4()); 
            match(input,19,FOLLOW_19_in_rule__ResultReport__Group__4__Impl2068); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1045:1: rule__ResultReport__Group__5 : rule__ResultReport__Group__5__Impl rule__ResultReport__Group__6 ;
    public final void rule__ResultReport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1049:1: ( rule__ResultReport__Group__5__Impl rule__ResultReport__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1050:2: rule__ResultReport__Group__5__Impl rule__ResultReport__Group__6
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__5__Impl_in_rule__ResultReport__Group__52099);
            rule__ResultReport__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__6_in_rule__ResultReport__Group__52102);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1057:1: rule__ResultReport__Group__5__Impl : ( ( rule__ResultReport__TargetAssignment_5 ) ) ;
    public final void rule__ResultReport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1061:1: ( ( ( rule__ResultReport__TargetAssignment_5 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1062:1: ( ( rule__ResultReport__TargetAssignment_5 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1062:1: ( ( rule__ResultReport__TargetAssignment_5 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1063:1: ( rule__ResultReport__TargetAssignment_5 )
            {
             before(grammarAccess.getResultReportAccess().getTargetAssignment_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1064:1: ( rule__ResultReport__TargetAssignment_5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1064:2: rule__ResultReport__TargetAssignment_5
            {
            pushFollow(FOLLOW_rule__ResultReport__TargetAssignment_5_in_rule__ResultReport__Group__5__Impl2129);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1074:1: rule__ResultReport__Group__6 : rule__ResultReport__Group__6__Impl rule__ResultReport__Group__7 ;
    public final void rule__ResultReport__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1078:1: ( rule__ResultReport__Group__6__Impl rule__ResultReport__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1079:2: rule__ResultReport__Group__6__Impl rule__ResultReport__Group__7
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__6__Impl_in_rule__ResultReport__Group__62159);
            rule__ResultReport__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__7_in_rule__ResultReport__Group__62162);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1086:1: rule__ResultReport__Group__6__Impl : ( ( rule__ResultReport__Group_6__0 )? ) ;
    public final void rule__ResultReport__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1090:1: ( ( ( rule__ResultReport__Group_6__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1091:1: ( ( rule__ResultReport__Group_6__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1091:1: ( ( rule__ResultReport__Group_6__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1092:1: ( rule__ResultReport__Group_6__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1093:1: ( rule__ResultReport__Group_6__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1093:2: rule__ResultReport__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_6__0_in_rule__ResultReport__Group__6__Impl2189);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1103:1: rule__ResultReport__Group__7 : rule__ResultReport__Group__7__Impl rule__ResultReport__Group__8 ;
    public final void rule__ResultReport__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1107:1: ( rule__ResultReport__Group__7__Impl rule__ResultReport__Group__8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1108:2: rule__ResultReport__Group__7__Impl rule__ResultReport__Group__8
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__7__Impl_in_rule__ResultReport__Group__72220);
            rule__ResultReport__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__8_in_rule__ResultReport__Group__72223);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1115:1: rule__ResultReport__Group__7__Impl : ( ( rule__ResultReport__Group_7__0 )? ) ;
    public final void rule__ResultReport__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1119:1: ( ( ( rule__ResultReport__Group_7__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1120:1: ( ( rule__ResultReport__Group_7__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1120:1: ( ( rule__ResultReport__Group_7__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1121:1: ( rule__ResultReport__Group_7__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_7()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1122:1: ( rule__ResultReport__Group_7__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1122:2: rule__ResultReport__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_7__0_in_rule__ResultReport__Group__7__Impl2250);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1132:1: rule__ResultReport__Group__8 : rule__ResultReport__Group__8__Impl rule__ResultReport__Group__9 ;
    public final void rule__ResultReport__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1136:1: ( rule__ResultReport__Group__8__Impl rule__ResultReport__Group__9 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1137:2: rule__ResultReport__Group__8__Impl rule__ResultReport__Group__9
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__8__Impl_in_rule__ResultReport__Group__82281);
            rule__ResultReport__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__9_in_rule__ResultReport__Group__82284);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1144:1: rule__ResultReport__Group__8__Impl : ( ( rule__ResultReport__Group_8__0 )? ) ;
    public final void rule__ResultReport__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1148:1: ( ( ( rule__ResultReport__Group_8__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1149:1: ( ( rule__ResultReport__Group_8__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1149:1: ( ( rule__ResultReport__Group_8__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1150:1: ( rule__ResultReport__Group_8__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_8()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1151:1: ( rule__ResultReport__Group_8__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==26) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1151:2: rule__ResultReport__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_8__0_in_rule__ResultReport__Group__8__Impl2311);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1161:1: rule__ResultReport__Group__9 : rule__ResultReport__Group__9__Impl rule__ResultReport__Group__10 ;
    public final void rule__ResultReport__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1165:1: ( rule__ResultReport__Group__9__Impl rule__ResultReport__Group__10 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1166:2: rule__ResultReport__Group__9__Impl rule__ResultReport__Group__10
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__9__Impl_in_rule__ResultReport__Group__92342);
            rule__ResultReport__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group__10_in_rule__ResultReport__Group__92345);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1173:1: rule__ResultReport__Group__9__Impl : ( ( rule__ResultReport__Group_9__0 )? ) ;
    public final void rule__ResultReport__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1177:1: ( ( ( rule__ResultReport__Group_9__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1178:1: ( ( rule__ResultReport__Group_9__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1178:1: ( ( rule__ResultReport__Group_9__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1179:1: ( rule__ResultReport__Group_9__0 )?
            {
             before(grammarAccess.getResultReportAccess().getGroup_9()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1180:1: ( rule__ResultReport__Group_9__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1180:2: rule__ResultReport__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__ResultReport__Group_9__0_in_rule__ResultReport__Group__9__Impl2372);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1190:1: rule__ResultReport__Group__10 : rule__ResultReport__Group__10__Impl ;
    public final void rule__ResultReport__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1194:1: ( rule__ResultReport__Group__10__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1195:2: rule__ResultReport__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group__10__Impl_in_rule__ResultReport__Group__102403);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1201:1: rule__ResultReport__Group__10__Impl : ( ']' ) ;
    public final void rule__ResultReport__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1205:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1206:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1206:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1207:1: ']'
            {
             before(grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_10()); 
            match(input,20,FOLLOW_20_in_rule__ResultReport__Group__10__Impl2431); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1242:1: rule__ResultReport__Group_2__0 : rule__ResultReport__Group_2__0__Impl rule__ResultReport__Group_2__1 ;
    public final void rule__ResultReport__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1246:1: ( rule__ResultReport__Group_2__0__Impl rule__ResultReport__Group_2__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1247:2: rule__ResultReport__Group_2__0__Impl rule__ResultReport__Group_2__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_2__0__Impl_in_rule__ResultReport__Group_2__02484);
            rule__ResultReport__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_2__1_in_rule__ResultReport__Group_2__02487);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1254:1: rule__ResultReport__Group_2__0__Impl : ( ':' ) ;
    public final void rule__ResultReport__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1258:1: ( ( ':' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1259:1: ( ':' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1259:1: ( ':' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1260:1: ':'
            {
             before(grammarAccess.getResultReportAccess().getColonKeyword_2_0()); 
            match(input,21,FOLLOW_21_in_rule__ResultReport__Group_2__0__Impl2515); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1273:1: rule__ResultReport__Group_2__1 : rule__ResultReport__Group_2__1__Impl ;
    public final void rule__ResultReport__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1277:1: ( rule__ResultReport__Group_2__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1278:2: rule__ResultReport__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_2__1__Impl_in_rule__ResultReport__Group_2__12546);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1284:1: rule__ResultReport__Group_2__1__Impl : ( ( rule__ResultReport__TitleAssignment_2_1 ) ) ;
    public final void rule__ResultReport__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1288:1: ( ( ( rule__ResultReport__TitleAssignment_2_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1289:1: ( ( rule__ResultReport__TitleAssignment_2_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1289:1: ( ( rule__ResultReport__TitleAssignment_2_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1290:1: ( rule__ResultReport__TitleAssignment_2_1 )
            {
             before(grammarAccess.getResultReportAccess().getTitleAssignment_2_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1291:1: ( rule__ResultReport__TitleAssignment_2_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1291:2: rule__ResultReport__TitleAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ResultReport__TitleAssignment_2_1_in_rule__ResultReport__Group_2__1__Impl2573);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1305:1: rule__ResultReport__Group_6__0 : rule__ResultReport__Group_6__0__Impl rule__ResultReport__Group_6__1 ;
    public final void rule__ResultReport__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1309:1: ( rule__ResultReport__Group_6__0__Impl rule__ResultReport__Group_6__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1310:2: rule__ResultReport__Group_6__0__Impl rule__ResultReport__Group_6__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_6__0__Impl_in_rule__ResultReport__Group_6__02607);
            rule__ResultReport__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_6__1_in_rule__ResultReport__Group_6__02610);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1317:1: rule__ResultReport__Group_6__0__Impl : ( 'description' ) ;
    public final void rule__ResultReport__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1321:1: ( ( 'description' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1322:1: ( 'description' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1322:1: ( 'description' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1323:1: 'description'
            {
             before(grammarAccess.getResultReportAccess().getDescriptionKeyword_6_0()); 
            match(input,22,FOLLOW_22_in_rule__ResultReport__Group_6__0__Impl2638); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1336:1: rule__ResultReport__Group_6__1 : rule__ResultReport__Group_6__1__Impl ;
    public final void rule__ResultReport__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1340:1: ( rule__ResultReport__Group_6__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1341:2: rule__ResultReport__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_6__1__Impl_in_rule__ResultReport__Group_6__12669);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1347:1: rule__ResultReport__Group_6__1__Impl : ( ( rule__ResultReport__DecriptionAssignment_6_1 ) ) ;
    public final void rule__ResultReport__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1351:1: ( ( ( rule__ResultReport__DecriptionAssignment_6_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1352:1: ( ( rule__ResultReport__DecriptionAssignment_6_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1352:1: ( ( rule__ResultReport__DecriptionAssignment_6_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1353:1: ( rule__ResultReport__DecriptionAssignment_6_1 )
            {
             before(grammarAccess.getResultReportAccess().getDecriptionAssignment_6_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1354:1: ( rule__ResultReport__DecriptionAssignment_6_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1354:2: rule__ResultReport__DecriptionAssignment_6_1
            {
            pushFollow(FOLLOW_rule__ResultReport__DecriptionAssignment_6_1_in_rule__ResultReport__Group_6__1__Impl2696);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1368:1: rule__ResultReport__Group_7__0 : rule__ResultReport__Group_7__0__Impl rule__ResultReport__Group_7__1 ;
    public final void rule__ResultReport__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1372:1: ( rule__ResultReport__Group_7__0__Impl rule__ResultReport__Group_7__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1373:2: rule__ResultReport__Group_7__0__Impl rule__ResultReport__Group_7__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_7__0__Impl_in_rule__ResultReport__Group_7__02730);
            rule__ResultReport__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_7__1_in_rule__ResultReport__Group_7__02733);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1380:1: rule__ResultReport__Group_7__0__Impl : ( 'heading' ) ;
    public final void rule__ResultReport__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1384:1: ( ( 'heading' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1385:1: ( 'heading' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1385:1: ( 'heading' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1386:1: 'heading'
            {
             before(grammarAccess.getResultReportAccess().getHeadingKeyword_7_0()); 
            match(input,25,FOLLOW_25_in_rule__ResultReport__Group_7__0__Impl2761); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1399:1: rule__ResultReport__Group_7__1 : rule__ResultReport__Group_7__1__Impl rule__ResultReport__Group_7__2 ;
    public final void rule__ResultReport__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1403:1: ( rule__ResultReport__Group_7__1__Impl rule__ResultReport__Group_7__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1404:2: rule__ResultReport__Group_7__1__Impl rule__ResultReport__Group_7__2
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_7__1__Impl_in_rule__ResultReport__Group_7__12792);
            rule__ResultReport__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_7__2_in_rule__ResultReport__Group_7__12795);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1411:1: rule__ResultReport__Group_7__1__Impl : ( ( rule__ResultReport__HeadingAssignment_7_1 ) ) ;
    public final void rule__ResultReport__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1415:1: ( ( ( rule__ResultReport__HeadingAssignment_7_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1416:1: ( ( rule__ResultReport__HeadingAssignment_7_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1416:1: ( ( rule__ResultReport__HeadingAssignment_7_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1417:1: ( rule__ResultReport__HeadingAssignment_7_1 )
            {
             before(grammarAccess.getResultReportAccess().getHeadingAssignment_7_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1418:1: ( rule__ResultReport__HeadingAssignment_7_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1418:2: rule__ResultReport__HeadingAssignment_7_1
            {
            pushFollow(FOLLOW_rule__ResultReport__HeadingAssignment_7_1_in_rule__ResultReport__Group_7__1__Impl2822);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1428:1: rule__ResultReport__Group_7__2 : rule__ResultReport__Group_7__2__Impl ;
    public final void rule__ResultReport__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1432:1: ( rule__ResultReport__Group_7__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1433:2: rule__ResultReport__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_7__2__Impl_in_rule__ResultReport__Group_7__22852);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1439:1: rule__ResultReport__Group_7__2__Impl : ( ( rule__ResultReport__ContentAssignment_7_2 )* ) ;
    public final void rule__ResultReport__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1443:1: ( ( ( rule__ResultReport__ContentAssignment_7_2 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1444:1: ( ( rule__ResultReport__ContentAssignment_7_2 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1444:1: ( ( rule__ResultReport__ContentAssignment_7_2 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1445:1: ( rule__ResultReport__ContentAssignment_7_2 )*
            {
             before(grammarAccess.getResultReportAccess().getContentAssignment_7_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1446:1: ( rule__ResultReport__ContentAssignment_7_2 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==27) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1446:2: rule__ResultReport__ContentAssignment_7_2
            	    {
            	    pushFollow(FOLLOW_rule__ResultReport__ContentAssignment_7_2_in_rule__ResultReport__Group_7__2__Impl2879);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1462:1: rule__ResultReport__Group_8__0 : rule__ResultReport__Group_8__0__Impl rule__ResultReport__Group_8__1 ;
    public final void rule__ResultReport__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1466:1: ( rule__ResultReport__Group_8__0__Impl rule__ResultReport__Group_8__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1467:2: rule__ResultReport__Group_8__0__Impl rule__ResultReport__Group_8__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_8__0__Impl_in_rule__ResultReport__Group_8__02916);
            rule__ResultReport__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_8__1_in_rule__ResultReport__Group_8__02919);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1474:1: rule__ResultReport__Group_8__0__Impl : ( 'results' ) ;
    public final void rule__ResultReport__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1478:1: ( ( 'results' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1479:1: ( 'results' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1479:1: ( 'results' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1480:1: 'results'
            {
             before(grammarAccess.getResultReportAccess().getResultsKeyword_8_0()); 
            match(input,26,FOLLOW_26_in_rule__ResultReport__Group_8__0__Impl2947); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1493:1: rule__ResultReport__Group_8__1 : rule__ResultReport__Group_8__1__Impl ;
    public final void rule__ResultReport__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1497:1: ( rule__ResultReport__Group_8__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1498:2: rule__ResultReport__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_8__1__Impl_in_rule__ResultReport__Group_8__12978);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1504:1: rule__ResultReport__Group_8__1__Impl : ( ( ( rule__ResultReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_8_1 )* ) ) ;
    public final void rule__ResultReport__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1508:1: ( ( ( ( rule__ResultReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_8_1 )* ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1509:1: ( ( ( rule__ResultReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_8_1 )* ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1509:1: ( ( ( rule__ResultReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_8_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1510:1: ( ( rule__ResultReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultReport__ResultDataAssignment_8_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1510:1: ( ( rule__ResultReport__ResultDataAssignment_8_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1511:1: ( rule__ResultReport__ResultDataAssignment_8_1 )
            {
             before(grammarAccess.getResultReportAccess().getResultDataAssignment_8_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1512:1: ( rule__ResultReport__ResultDataAssignment_8_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1512:2: rule__ResultReport__ResultDataAssignment_8_1
            {
            pushFollow(FOLLOW_rule__ResultReport__ResultDataAssignment_8_1_in_rule__ResultReport__Group_8__1__Impl3007);
            rule__ResultReport__ResultDataAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getResultDataAssignment_8_1()); 

            }

            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1515:1: ( ( rule__ResultReport__ResultDataAssignment_8_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1516:1: ( rule__ResultReport__ResultDataAssignment_8_1 )*
            {
             before(grammarAccess.getResultReportAccess().getResultDataAssignment_8_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1517:1: ( rule__ResultReport__ResultDataAssignment_8_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1517:2: rule__ResultReport__ResultDataAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultReport__ResultDataAssignment_8_1_in_rule__ResultReport__Group_8__1__Impl3019);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1532:1: rule__ResultReport__Group_9__0 : rule__ResultReport__Group_9__0__Impl rule__ResultReport__Group_9__1 ;
    public final void rule__ResultReport__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1536:1: ( rule__ResultReport__Group_9__0__Impl rule__ResultReport__Group_9__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1537:2: rule__ResultReport__Group_9__0__Impl rule__ResultReport__Group_9__1
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_9__0__Impl_in_rule__ResultReport__Group_9__03056);
            rule__ResultReport__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReport__Group_9__1_in_rule__ResultReport__Group_9__03059);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1544:1: rule__ResultReport__Group_9__0__Impl : ( 'issues' ) ;
    public final void rule__ResultReport__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1548:1: ( ( 'issues' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1549:1: ( 'issues' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1549:1: ( 'issues' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1550:1: 'issues'
            {
             before(grammarAccess.getResultReportAccess().getIssuesKeyword_9_0()); 
            match(input,23,FOLLOW_23_in_rule__ResultReport__Group_9__0__Impl3087); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1563:1: rule__ResultReport__Group_9__1 : rule__ResultReport__Group_9__1__Impl ;
    public final void rule__ResultReport__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1567:1: ( rule__ResultReport__Group_9__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1568:2: rule__ResultReport__Group_9__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReport__Group_9__1__Impl_in_rule__ResultReport__Group_9__13118);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1574:1: rule__ResultReport__Group_9__1__Impl : ( ( rule__ResultReport__IssuesAssignment_9_1 )* ) ;
    public final void rule__ResultReport__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1578:1: ( ( ( rule__ResultReport__IssuesAssignment_9_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1579:1: ( ( rule__ResultReport__IssuesAssignment_9_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1579:1: ( ( rule__ResultReport__IssuesAssignment_9_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1580:1: ( rule__ResultReport__IssuesAssignment_9_1 )*
            {
             before(grammarAccess.getResultReportAccess().getIssuesAssignment_9_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1581:1: ( rule__ResultReport__IssuesAssignment_9_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=11 && LA15_0<=16)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1581:2: rule__ResultReport__IssuesAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultReport__IssuesAssignment_9_1_in_rule__ResultReport__Group_9__1__Impl3145);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1595:1: rule__IssuesReport__Group__0 : rule__IssuesReport__Group__0__Impl rule__IssuesReport__Group__1 ;
    public final void rule__IssuesReport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1599:1: ( rule__IssuesReport__Group__0__Impl rule__IssuesReport__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1600:2: rule__IssuesReport__Group__0__Impl rule__IssuesReport__Group__1
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__0__Impl_in_rule__IssuesReport__Group__03180);
            rule__IssuesReport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__1_in_rule__IssuesReport__Group__03183);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1607:1: rule__IssuesReport__Group__0__Impl : ( 'issues' ) ;
    public final void rule__IssuesReport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1611:1: ( ( 'issues' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1612:1: ( 'issues' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1612:1: ( 'issues' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1613:1: 'issues'
            {
             before(grammarAccess.getIssuesReportAccess().getIssuesKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__IssuesReport__Group__0__Impl3211); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1626:1: rule__IssuesReport__Group__1 : rule__IssuesReport__Group__1__Impl rule__IssuesReport__Group__2 ;
    public final void rule__IssuesReport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1630:1: ( rule__IssuesReport__Group__1__Impl rule__IssuesReport__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1631:2: rule__IssuesReport__Group__1__Impl rule__IssuesReport__Group__2
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__1__Impl_in_rule__IssuesReport__Group__13242);
            rule__IssuesReport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__2_in_rule__IssuesReport__Group__13245);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1638:1: rule__IssuesReport__Group__1__Impl : ( ( rule__IssuesReport__NameAssignment_1 ) ) ;
    public final void rule__IssuesReport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1642:1: ( ( ( rule__IssuesReport__NameAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1643:1: ( ( rule__IssuesReport__NameAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1643:1: ( ( rule__IssuesReport__NameAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1644:1: ( rule__IssuesReport__NameAssignment_1 )
            {
             before(grammarAccess.getIssuesReportAccess().getNameAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1645:1: ( rule__IssuesReport__NameAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1645:2: rule__IssuesReport__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__IssuesReport__NameAssignment_1_in_rule__IssuesReport__Group__1__Impl3272);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1655:1: rule__IssuesReport__Group__2 : rule__IssuesReport__Group__2__Impl rule__IssuesReport__Group__3 ;
    public final void rule__IssuesReport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1659:1: ( rule__IssuesReport__Group__2__Impl rule__IssuesReport__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1660:2: rule__IssuesReport__Group__2__Impl rule__IssuesReport__Group__3
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__2__Impl_in_rule__IssuesReport__Group__23302);
            rule__IssuesReport__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__3_in_rule__IssuesReport__Group__23305);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1667:1: rule__IssuesReport__Group__2__Impl : ( ( rule__IssuesReport__Group_2__0 )? ) ;
    public final void rule__IssuesReport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1671:1: ( ( ( rule__IssuesReport__Group_2__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1672:1: ( ( rule__IssuesReport__Group_2__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1672:1: ( ( rule__IssuesReport__Group_2__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1673:1: ( rule__IssuesReport__Group_2__0 )?
            {
             before(grammarAccess.getIssuesReportAccess().getGroup_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1674:1: ( rule__IssuesReport__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1674:2: rule__IssuesReport__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__IssuesReport__Group_2__0_in_rule__IssuesReport__Group__2__Impl3332);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1684:1: rule__IssuesReport__Group__3 : rule__IssuesReport__Group__3__Impl rule__IssuesReport__Group__4 ;
    public final void rule__IssuesReport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1688:1: ( rule__IssuesReport__Group__3__Impl rule__IssuesReport__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1689:2: rule__IssuesReport__Group__3__Impl rule__IssuesReport__Group__4
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__3__Impl_in_rule__IssuesReport__Group__33363);
            rule__IssuesReport__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__4_in_rule__IssuesReport__Group__33366);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1696:1: rule__IssuesReport__Group__3__Impl : ( '[' ) ;
    public final void rule__IssuesReport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1700:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1701:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1701:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1702:1: '['
            {
             before(grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3()); 
            match(input,18,FOLLOW_18_in_rule__IssuesReport__Group__3__Impl3394); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1715:1: rule__IssuesReport__Group__4 : rule__IssuesReport__Group__4__Impl rule__IssuesReport__Group__5 ;
    public final void rule__IssuesReport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1719:1: ( rule__IssuesReport__Group__4__Impl rule__IssuesReport__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1720:2: rule__IssuesReport__Group__4__Impl rule__IssuesReport__Group__5
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__4__Impl_in_rule__IssuesReport__Group__43425);
            rule__IssuesReport__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__5_in_rule__IssuesReport__Group__43428);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1727:1: rule__IssuesReport__Group__4__Impl : ( 'target' ) ;
    public final void rule__IssuesReport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1731:1: ( ( 'target' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1732:1: ( 'target' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1732:1: ( 'target' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1733:1: 'target'
            {
             before(grammarAccess.getIssuesReportAccess().getTargetKeyword_4()); 
            match(input,19,FOLLOW_19_in_rule__IssuesReport__Group__4__Impl3456); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1746:1: rule__IssuesReport__Group__5 : rule__IssuesReport__Group__5__Impl rule__IssuesReport__Group__6 ;
    public final void rule__IssuesReport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1750:1: ( rule__IssuesReport__Group__5__Impl rule__IssuesReport__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1751:2: rule__IssuesReport__Group__5__Impl rule__IssuesReport__Group__6
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__5__Impl_in_rule__IssuesReport__Group__53487);
            rule__IssuesReport__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__6_in_rule__IssuesReport__Group__53490);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1758:1: rule__IssuesReport__Group__5__Impl : ( ( rule__IssuesReport__TargetAssignment_5 ) ) ;
    public final void rule__IssuesReport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1762:1: ( ( ( rule__IssuesReport__TargetAssignment_5 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1763:1: ( ( rule__IssuesReport__TargetAssignment_5 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1763:1: ( ( rule__IssuesReport__TargetAssignment_5 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1764:1: ( rule__IssuesReport__TargetAssignment_5 )
            {
             before(grammarAccess.getIssuesReportAccess().getTargetAssignment_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1765:1: ( rule__IssuesReport__TargetAssignment_5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1765:2: rule__IssuesReport__TargetAssignment_5
            {
            pushFollow(FOLLOW_rule__IssuesReport__TargetAssignment_5_in_rule__IssuesReport__Group__5__Impl3517);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1775:1: rule__IssuesReport__Group__6 : rule__IssuesReport__Group__6__Impl rule__IssuesReport__Group__7 ;
    public final void rule__IssuesReport__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1779:1: ( rule__IssuesReport__Group__6__Impl rule__IssuesReport__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1780:2: rule__IssuesReport__Group__6__Impl rule__IssuesReport__Group__7
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__6__Impl_in_rule__IssuesReport__Group__63547);
            rule__IssuesReport__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__7_in_rule__IssuesReport__Group__63550);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1787:1: rule__IssuesReport__Group__6__Impl : ( ( rule__IssuesReport__Group_6__0 )? ) ;
    public final void rule__IssuesReport__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1791:1: ( ( ( rule__IssuesReport__Group_6__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1792:1: ( ( rule__IssuesReport__Group_6__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1792:1: ( ( rule__IssuesReport__Group_6__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1793:1: ( rule__IssuesReport__Group_6__0 )?
            {
             before(grammarAccess.getIssuesReportAccess().getGroup_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1794:1: ( rule__IssuesReport__Group_6__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1794:2: rule__IssuesReport__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__IssuesReport__Group_6__0_in_rule__IssuesReport__Group__6__Impl3577);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1804:1: rule__IssuesReport__Group__7 : rule__IssuesReport__Group__7__Impl rule__IssuesReport__Group__8 ;
    public final void rule__IssuesReport__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1808:1: ( rule__IssuesReport__Group__7__Impl rule__IssuesReport__Group__8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1809:2: rule__IssuesReport__Group__7__Impl rule__IssuesReport__Group__8
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__7__Impl_in_rule__IssuesReport__Group__73608);
            rule__IssuesReport__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__8_in_rule__IssuesReport__Group__73611);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1816:1: rule__IssuesReport__Group__7__Impl : ( ( rule__IssuesReport__IssuesAssignment_7 )* ) ;
    public final void rule__IssuesReport__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1820:1: ( ( ( rule__IssuesReport__IssuesAssignment_7 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1821:1: ( ( rule__IssuesReport__IssuesAssignment_7 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1821:1: ( ( rule__IssuesReport__IssuesAssignment_7 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1822:1: ( rule__IssuesReport__IssuesAssignment_7 )*
            {
             before(grammarAccess.getIssuesReportAccess().getIssuesAssignment_7()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1823:1: ( rule__IssuesReport__IssuesAssignment_7 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=11 && LA18_0<=16)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1823:2: rule__IssuesReport__IssuesAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__IssuesReport__IssuesAssignment_7_in_rule__IssuesReport__Group__7__Impl3638);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1833:1: rule__IssuesReport__Group__8 : rule__IssuesReport__Group__8__Impl ;
    public final void rule__IssuesReport__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1837:1: ( rule__IssuesReport__Group__8__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1838:2: rule__IssuesReport__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__8__Impl_in_rule__IssuesReport__Group__83669);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1844:1: rule__IssuesReport__Group__8__Impl : ( ']' ) ;
    public final void rule__IssuesReport__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1848:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1849:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1849:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1850:1: ']'
            {
             before(grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_8()); 
            match(input,20,FOLLOW_20_in_rule__IssuesReport__Group__8__Impl3697); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1881:1: rule__IssuesReport__Group_2__0 : rule__IssuesReport__Group_2__0__Impl rule__IssuesReport__Group_2__1 ;
    public final void rule__IssuesReport__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1885:1: ( rule__IssuesReport__Group_2__0__Impl rule__IssuesReport__Group_2__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1886:2: rule__IssuesReport__Group_2__0__Impl rule__IssuesReport__Group_2__1
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_2__0__Impl_in_rule__IssuesReport__Group_2__03746);
            rule__IssuesReport__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group_2__1_in_rule__IssuesReport__Group_2__03749);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1893:1: rule__IssuesReport__Group_2__0__Impl : ( ':' ) ;
    public final void rule__IssuesReport__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1897:1: ( ( ':' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1898:1: ( ':' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1898:1: ( ':' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1899:1: ':'
            {
             before(grammarAccess.getIssuesReportAccess().getColonKeyword_2_0()); 
            match(input,21,FOLLOW_21_in_rule__IssuesReport__Group_2__0__Impl3777); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1912:1: rule__IssuesReport__Group_2__1 : rule__IssuesReport__Group_2__1__Impl ;
    public final void rule__IssuesReport__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1916:1: ( rule__IssuesReport__Group_2__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1917:2: rule__IssuesReport__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_2__1__Impl_in_rule__IssuesReport__Group_2__13808);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1923:1: rule__IssuesReport__Group_2__1__Impl : ( ( rule__IssuesReport__TitleAssignment_2_1 ) ) ;
    public final void rule__IssuesReport__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1927:1: ( ( ( rule__IssuesReport__TitleAssignment_2_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1928:1: ( ( rule__IssuesReport__TitleAssignment_2_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1928:1: ( ( rule__IssuesReport__TitleAssignment_2_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1929:1: ( rule__IssuesReport__TitleAssignment_2_1 )
            {
             before(grammarAccess.getIssuesReportAccess().getTitleAssignment_2_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1930:1: ( rule__IssuesReport__TitleAssignment_2_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1930:2: rule__IssuesReport__TitleAssignment_2_1
            {
            pushFollow(FOLLOW_rule__IssuesReport__TitleAssignment_2_1_in_rule__IssuesReport__Group_2__1__Impl3835);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1944:1: rule__IssuesReport__Group_6__0 : rule__IssuesReport__Group_6__0__Impl rule__IssuesReport__Group_6__1 ;
    public final void rule__IssuesReport__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1948:1: ( rule__IssuesReport__Group_6__0__Impl rule__IssuesReport__Group_6__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1949:2: rule__IssuesReport__Group_6__0__Impl rule__IssuesReport__Group_6__1
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_6__0__Impl_in_rule__IssuesReport__Group_6__03869);
            rule__IssuesReport__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group_6__1_in_rule__IssuesReport__Group_6__03872);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1956:1: rule__IssuesReport__Group_6__0__Impl : ( 'description' ) ;
    public final void rule__IssuesReport__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1960:1: ( ( 'description' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1961:1: ( 'description' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1961:1: ( 'description' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1962:1: 'description'
            {
             before(grammarAccess.getIssuesReportAccess().getDescriptionKeyword_6_0()); 
            match(input,22,FOLLOW_22_in_rule__IssuesReport__Group_6__0__Impl3900); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1975:1: rule__IssuesReport__Group_6__1 : rule__IssuesReport__Group_6__1__Impl ;
    public final void rule__IssuesReport__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1979:1: ( rule__IssuesReport__Group_6__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1980:2: rule__IssuesReport__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_6__1__Impl_in_rule__IssuesReport__Group_6__13931);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1986:1: rule__IssuesReport__Group_6__1__Impl : ( ( rule__IssuesReport__DecriptionAssignment_6_1 ) ) ;
    public final void rule__IssuesReport__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1990:1: ( ( ( rule__IssuesReport__DecriptionAssignment_6_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1991:1: ( ( rule__IssuesReport__DecriptionAssignment_6_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1991:1: ( ( rule__IssuesReport__DecriptionAssignment_6_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1992:1: ( rule__IssuesReport__DecriptionAssignment_6_1 )
            {
             before(grammarAccess.getIssuesReportAccess().getDecriptionAssignment_6_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1993:1: ( rule__IssuesReport__DecriptionAssignment_6_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1993:2: rule__IssuesReport__DecriptionAssignment_6_1
            {
            pushFollow(FOLLOW_rule__IssuesReport__DecriptionAssignment_6_1_in_rule__IssuesReport__Group_6__1__Impl3958);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2007:1: rule__ResultContributor__Group__0 : rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1 ;
    public final void rule__ResultContributor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2011:1: ( rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2012:2: rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__0__Impl_in_rule__ResultContributor__Group__03992);
            rule__ResultContributor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__1_in_rule__ResultContributor__Group__03995);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2019:1: rule__ResultContributor__Group__0__Impl : ( 'contributor' ) ;
    public final void rule__ResultContributor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2023:1: ( ( 'contributor' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2024:1: ( 'contributor' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2024:1: ( 'contributor' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2025:1: 'contributor'
            {
             before(grammarAccess.getResultContributorAccess().getContributorKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__ResultContributor__Group__0__Impl4023); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2038:1: rule__ResultContributor__Group__1 : rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2 ;
    public final void rule__ResultContributor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2042:1: ( rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2043:2: rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__1__Impl_in_rule__ResultContributor__Group__14054);
            rule__ResultContributor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__2_in_rule__ResultContributor__Group__14057);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2050:1: rule__ResultContributor__Group__1__Impl : ( ( rule__ResultContributor__ContributorAssignment_1 ) ) ;
    public final void rule__ResultContributor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2054:1: ( ( ( rule__ResultContributor__ContributorAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2055:1: ( ( rule__ResultContributor__ContributorAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2055:1: ( ( rule__ResultContributor__ContributorAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2056:1: ( rule__ResultContributor__ContributorAssignment_1 )
            {
             before(grammarAccess.getResultContributorAccess().getContributorAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2057:1: ( rule__ResultContributor__ContributorAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2057:2: rule__ResultContributor__ContributorAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultContributor__ContributorAssignment_1_in_rule__ResultContributor__Group__1__Impl4084);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2067:1: rule__ResultContributor__Group__2 : rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3 ;
    public final void rule__ResultContributor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2071:1: ( rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2072:2: rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__2__Impl_in_rule__ResultContributor__Group__24114);
            rule__ResultContributor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__3_in_rule__ResultContributor__Group__24117);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2079:1: rule__ResultContributor__Group__2__Impl : ( '[' ) ;
    public final void rule__ResultContributor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2083:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2084:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2084:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2085:1: '['
            {
             before(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__ResultContributor__Group__2__Impl4145); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2098:1: rule__ResultContributor__Group__3 : rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4 ;
    public final void rule__ResultContributor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2102:1: ( rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2103:2: rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__3__Impl_in_rule__ResultContributor__Group__34176);
            rule__ResultContributor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__4_in_rule__ResultContributor__Group__34179);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2110:1: rule__ResultContributor__Group__3__Impl : ( 'data' ) ;
    public final void rule__ResultContributor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2114:1: ( ( 'data' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2115:1: ( 'data' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2115:1: ( 'data' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2116:1: 'data'
            {
             before(grammarAccess.getResultContributorAccess().getDataKeyword_3()); 
            match(input,28,FOLLOW_28_in_rule__ResultContributor__Group__3__Impl4207); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2129:1: rule__ResultContributor__Group__4 : rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5 ;
    public final void rule__ResultContributor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2133:1: ( rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2134:2: rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__4__Impl_in_rule__ResultContributor__Group__44238);
            rule__ResultContributor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__5_in_rule__ResultContributor__Group__44241);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2141:1: rule__ResultContributor__Group__4__Impl : ( ( ( rule__ResultContributor__CellAssignment_4 ) ) ( ( rule__ResultContributor__CellAssignment_4 )* ) ) ;
    public final void rule__ResultContributor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2145:1: ( ( ( ( rule__ResultContributor__CellAssignment_4 ) ) ( ( rule__ResultContributor__CellAssignment_4 )* ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2146:1: ( ( ( rule__ResultContributor__CellAssignment_4 ) ) ( ( rule__ResultContributor__CellAssignment_4 )* ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2146:1: ( ( ( rule__ResultContributor__CellAssignment_4 ) ) ( ( rule__ResultContributor__CellAssignment_4 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2147:1: ( ( rule__ResultContributor__CellAssignment_4 ) ) ( ( rule__ResultContributor__CellAssignment_4 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2147:1: ( ( rule__ResultContributor__CellAssignment_4 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2148:1: ( rule__ResultContributor__CellAssignment_4 )
            {
             before(grammarAccess.getResultContributorAccess().getCellAssignment_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2149:1: ( rule__ResultContributor__CellAssignment_4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2149:2: rule__ResultContributor__CellAssignment_4
            {
            pushFollow(FOLLOW_rule__ResultContributor__CellAssignment_4_in_rule__ResultContributor__Group__4__Impl4270);
            rule__ResultContributor__CellAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getResultContributorAccess().getCellAssignment_4()); 

            }

            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2152:1: ( ( rule__ResultContributor__CellAssignment_4 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2153:1: ( rule__ResultContributor__CellAssignment_4 )*
            {
             before(grammarAccess.getResultContributorAccess().getCellAssignment_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2154:1: ( rule__ResultContributor__CellAssignment_4 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_STRING) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2154:2: rule__ResultContributor__CellAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__CellAssignment_4_in_rule__ResultContributor__Group__4__Impl4282);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2165:1: rule__ResultContributor__Group__5 : rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6 ;
    public final void rule__ResultContributor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2169:1: ( rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2170:2: rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__5__Impl_in_rule__ResultContributor__Group__54315);
            rule__ResultContributor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__6_in_rule__ResultContributor__Group__54318);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2177:1: rule__ResultContributor__Group__5__Impl : ( ( rule__ResultContributor__Group_5__0 )? ) ;
    public final void rule__ResultContributor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2181:1: ( ( ( rule__ResultContributor__Group_5__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2182:1: ( ( rule__ResultContributor__Group_5__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2182:1: ( ( rule__ResultContributor__Group_5__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2183:1: ( rule__ResultContributor__Group_5__0 )?
            {
             before(grammarAccess.getResultContributorAccess().getGroup_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2184:1: ( rule__ResultContributor__Group_5__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==23) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2184:2: rule__ResultContributor__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ResultContributor__Group_5__0_in_rule__ResultContributor__Group__5__Impl4345);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2194:1: rule__ResultContributor__Group__6 : rule__ResultContributor__Group__6__Impl rule__ResultContributor__Group__7 ;
    public final void rule__ResultContributor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2198:1: ( rule__ResultContributor__Group__6__Impl rule__ResultContributor__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2199:2: rule__ResultContributor__Group__6__Impl rule__ResultContributor__Group__7
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__6__Impl_in_rule__ResultContributor__Group__64376);
            rule__ResultContributor__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__7_in_rule__ResultContributor__Group__64379);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2206:1: rule__ResultContributor__Group__6__Impl : ( ( rule__ResultContributor__SubcontributorAssignment_6 )* ) ;
    public final void rule__ResultContributor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2210:1: ( ( ( rule__ResultContributor__SubcontributorAssignment_6 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2211:1: ( ( rule__ResultContributor__SubcontributorAssignment_6 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2211:1: ( ( rule__ResultContributor__SubcontributorAssignment_6 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2212:1: ( rule__ResultContributor__SubcontributorAssignment_6 )*
            {
             before(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2213:1: ( rule__ResultContributor__SubcontributorAssignment_6 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==27) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2213:2: rule__ResultContributor__SubcontributorAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__SubcontributorAssignment_6_in_rule__ResultContributor__Group__6__Impl4406);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2223:1: rule__ResultContributor__Group__7 : rule__ResultContributor__Group__7__Impl ;
    public final void rule__ResultContributor__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2227:1: ( rule__ResultContributor__Group__7__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2228:2: rule__ResultContributor__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__7__Impl_in_rule__ResultContributor__Group__74437);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2234:1: rule__ResultContributor__Group__7__Impl : ( ']' ) ;
    public final void rule__ResultContributor__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2238:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2239:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2239:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2240:1: ']'
            {
             before(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_7()); 
            match(input,20,FOLLOW_20_in_rule__ResultContributor__Group__7__Impl4465); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2269:1: rule__ResultContributor__Group_5__0 : rule__ResultContributor__Group_5__0__Impl rule__ResultContributor__Group_5__1 ;
    public final void rule__ResultContributor__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2273:1: ( rule__ResultContributor__Group_5__0__Impl rule__ResultContributor__Group_5__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2274:2: rule__ResultContributor__Group_5__0__Impl rule__ResultContributor__Group_5__1
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group_5__0__Impl_in_rule__ResultContributor__Group_5__04512);
            rule__ResultContributor__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group_5__1_in_rule__ResultContributor__Group_5__04515);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2281:1: rule__ResultContributor__Group_5__0__Impl : ( 'issues' ) ;
    public final void rule__ResultContributor__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2285:1: ( ( 'issues' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2286:1: ( 'issues' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2286:1: ( 'issues' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2287:1: 'issues'
            {
             before(grammarAccess.getResultContributorAccess().getIssuesKeyword_5_0()); 
            match(input,23,FOLLOW_23_in_rule__ResultContributor__Group_5__0__Impl4543); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2300:1: rule__ResultContributor__Group_5__1 : rule__ResultContributor__Group_5__1__Impl ;
    public final void rule__ResultContributor__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2304:1: ( rule__ResultContributor__Group_5__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2305:2: rule__ResultContributor__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group_5__1__Impl_in_rule__ResultContributor__Group_5__14574);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2311:1: rule__ResultContributor__Group_5__1__Impl : ( ( rule__ResultContributor__IssuesAssignment_5_1 )* ) ;
    public final void rule__ResultContributor__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2315:1: ( ( ( rule__ResultContributor__IssuesAssignment_5_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2316:1: ( ( rule__ResultContributor__IssuesAssignment_5_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2316:1: ( ( rule__ResultContributor__IssuesAssignment_5_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2317:1: ( rule__ResultContributor__IssuesAssignment_5_1 )*
            {
             before(grammarAccess.getResultContributorAccess().getIssuesAssignment_5_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2318:1: ( rule__ResultContributor__IssuesAssignment_5_1 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=11 && LA22_0<=16)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2318:2: rule__ResultContributor__IssuesAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__IssuesAssignment_5_1_in_rule__ResultContributor__Group_5__1__Impl4601);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2332:1: rule__ReportIssue__Group__0 : rule__ReportIssue__Group__0__Impl rule__ReportIssue__Group__1 ;
    public final void rule__ReportIssue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2336:1: ( rule__ReportIssue__Group__0__Impl rule__ReportIssue__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2337:2: rule__ReportIssue__Group__0__Impl rule__ReportIssue__Group__1
            {
            pushFollow(FOLLOW_rule__ReportIssue__Group__0__Impl_in_rule__ReportIssue__Group__04636);
            rule__ReportIssue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReportIssue__Group__1_in_rule__ReportIssue__Group__04639);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2344:1: rule__ReportIssue__Group__0__Impl : ( ( rule__ReportIssue__IssueTypeAssignment_0 ) ) ;
    public final void rule__ReportIssue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2348:1: ( ( ( rule__ReportIssue__IssueTypeAssignment_0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2349:1: ( ( rule__ReportIssue__IssueTypeAssignment_0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2349:1: ( ( rule__ReportIssue__IssueTypeAssignment_0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2350:1: ( rule__ReportIssue__IssueTypeAssignment_0 )
            {
             before(grammarAccess.getReportIssueAccess().getIssueTypeAssignment_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2351:1: ( rule__ReportIssue__IssueTypeAssignment_0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2351:2: rule__ReportIssue__IssueTypeAssignment_0
            {
            pushFollow(FOLLOW_rule__ReportIssue__IssueTypeAssignment_0_in_rule__ReportIssue__Group__0__Impl4666);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2361:1: rule__ReportIssue__Group__1 : rule__ReportIssue__Group__1__Impl rule__ReportIssue__Group__2 ;
    public final void rule__ReportIssue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2365:1: ( rule__ReportIssue__Group__1__Impl rule__ReportIssue__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2366:2: rule__ReportIssue__Group__1__Impl rule__ReportIssue__Group__2
            {
            pushFollow(FOLLOW_rule__ReportIssue__Group__1__Impl_in_rule__ReportIssue__Group__14696);
            rule__ReportIssue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReportIssue__Group__2_in_rule__ReportIssue__Group__14699);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2373:1: rule__ReportIssue__Group__1__Impl : ( ( rule__ReportIssue__TitleAssignment_1 ) ) ;
    public final void rule__ReportIssue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2377:1: ( ( ( rule__ReportIssue__TitleAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2378:1: ( ( rule__ReportIssue__TitleAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2378:1: ( ( rule__ReportIssue__TitleAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2379:1: ( rule__ReportIssue__TitleAssignment_1 )
            {
             before(grammarAccess.getReportIssueAccess().getTitleAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2380:1: ( rule__ReportIssue__TitleAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2380:2: rule__ReportIssue__TitleAssignment_1
            {
            pushFollow(FOLLOW_rule__ReportIssue__TitleAssignment_1_in_rule__ReportIssue__Group__1__Impl4726);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2390:1: rule__ReportIssue__Group__2 : rule__ReportIssue__Group__2__Impl ;
    public final void rule__ReportIssue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2394:1: ( rule__ReportIssue__Group__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2395:2: rule__ReportIssue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ReportIssue__Group__2__Impl_in_rule__ReportIssue__Group__24756);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2401:1: rule__ReportIssue__Group__2__Impl : ( ( rule__ReportIssue__TargetAssignment_2 ) ) ;
    public final void rule__ReportIssue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2405:1: ( ( ( rule__ReportIssue__TargetAssignment_2 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2406:1: ( ( rule__ReportIssue__TargetAssignment_2 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2406:1: ( ( rule__ReportIssue__TargetAssignment_2 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2407:1: ( rule__ReportIssue__TargetAssignment_2 )
            {
             before(grammarAccess.getReportIssueAccess().getTargetAssignment_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2408:1: ( rule__ReportIssue__TargetAssignment_2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2408:2: rule__ReportIssue__TargetAssignment_2
            {
            pushFollow(FOLLOW_rule__ReportIssue__TargetAssignment_2_in_rule__ReportIssue__Group__2__Impl4783);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2424:1: rule__ResultData__Group__0 : rule__ResultData__Group__0__Impl rule__ResultData__Group__1 ;
    public final void rule__ResultData__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2428:1: ( rule__ResultData__Group__0__Impl rule__ResultData__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2429:2: rule__ResultData__Group__0__Impl rule__ResultData__Group__1
            {
            pushFollow(FOLLOW_rule__ResultData__Group__0__Impl_in_rule__ResultData__Group__04819);
            rule__ResultData__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultData__Group__1_in_rule__ResultData__Group__04822);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2436:1: rule__ResultData__Group__0__Impl : ( ( rule__ResultData__NameAssignment_0 ) ) ;
    public final void rule__ResultData__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2440:1: ( ( ( rule__ResultData__NameAssignment_0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2441:1: ( ( rule__ResultData__NameAssignment_0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2441:1: ( ( rule__ResultData__NameAssignment_0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2442:1: ( rule__ResultData__NameAssignment_0 )
            {
             before(grammarAccess.getResultDataAccess().getNameAssignment_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2443:1: ( rule__ResultData__NameAssignment_0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2443:2: rule__ResultData__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ResultData__NameAssignment_0_in_rule__ResultData__Group__0__Impl4849);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2453:1: rule__ResultData__Group__1 : rule__ResultData__Group__1__Impl rule__ResultData__Group__2 ;
    public final void rule__ResultData__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2457:1: ( rule__ResultData__Group__1__Impl rule__ResultData__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2458:2: rule__ResultData__Group__1__Impl rule__ResultData__Group__2
            {
            pushFollow(FOLLOW_rule__ResultData__Group__1__Impl_in_rule__ResultData__Group__14879);
            rule__ResultData__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultData__Group__2_in_rule__ResultData__Group__14882);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2465:1: rule__ResultData__Group__1__Impl : ( '=' ) ;
    public final void rule__ResultData__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2469:1: ( ( '=' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2470:1: ( '=' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2470:1: ( '=' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2471:1: '='
            {
             before(grammarAccess.getResultDataAccess().getEqualsSignKeyword_1()); 
            match(input,29,FOLLOW_29_in_rule__ResultData__Group__1__Impl4910); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2484:1: rule__ResultData__Group__2 : rule__ResultData__Group__2__Impl ;
    public final void rule__ResultData__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2488:1: ( rule__ResultData__Group__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2489:2: rule__ResultData__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultData__Group__2__Impl_in_rule__ResultData__Group__24941);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2495:1: rule__ResultData__Group__2__Impl : ( ( rule__ResultData__ValueAssignment_2 ) ) ;
    public final void rule__ResultData__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2499:1: ( ( ( rule__ResultData__ValueAssignment_2 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2500:1: ( ( rule__ResultData__ValueAssignment_2 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2500:1: ( ( rule__ResultData__ValueAssignment_2 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2501:1: ( rule__ResultData__ValueAssignment_2 )
            {
             before(grammarAccess.getResultDataAccess().getValueAssignment_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2502:1: ( rule__ResultData__ValueAssignment_2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2502:2: rule__ResultData__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__ResultData__ValueAssignment_2_in_rule__ResultData__Group__2__Impl4968);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2519:1: rule__ResultReportCollection__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ResultReportCollection__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2523:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2524:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2524:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2525:1: RULE_ID
            {
             before(grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultReportCollection__NameAssignment_15009); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2534:1: rule__ResultReportCollection__TitleAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__ResultReportCollection__TitleAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2538:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2539:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2539:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2540:1: RULE_STRING
            {
             before(grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReportCollection__TitleAssignment_2_15040); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2549:1: rule__ResultReportCollection__TargetAssignment_5 : ( ( ruleURIID ) ) ;
    public final void rule__ResultReportCollection__TargetAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2553:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2554:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2554:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2555:1: ( ruleURIID )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_5_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2556:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2557:1: ruleURIID
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultReportCollection__TargetAssignment_55075);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2568:1: rule__ResultReportCollection__DecriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ResultReportCollection__DecriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2572:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2573:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2573:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2574:1: RULE_STRING
            {
             before(grammarAccess.getResultReportCollectionAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReportCollection__DecriptionAssignment_6_15110); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2583:1: rule__ResultReportCollection__ContentAssignment_7 : ( ruleResultReport ) ;
    public final void rule__ResultReportCollection__ContentAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2587:1: ( ( ruleResultReport ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2588:1: ( ruleResultReport )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2588:1: ( ruleResultReport )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2589:1: ruleResultReport
            {
             before(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleResultReport_in_rule__ResultReportCollection__ContentAssignment_75141);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2598:1: rule__ResultReportCollection__IssuesAssignment_8_1 : ( ruleReportIssue ) ;
    public final void rule__ResultReportCollection__IssuesAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2602:1: ( ( ruleReportIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2603:1: ( ruleReportIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2603:1: ( ruleReportIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2604:1: ruleReportIssue
            {
             before(grammarAccess.getResultReportCollectionAccess().getIssuesReportIssueParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_ruleReportIssue_in_rule__ResultReportCollection__IssuesAssignment_8_15172);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2613:1: rule__ResultReport__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ResultReport__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2617:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2618:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2618:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2619:1: RULE_ID
            {
             before(grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultReport__NameAssignment_15203); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2628:1: rule__ResultReport__TitleAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__ResultReport__TitleAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2632:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2633:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2633:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2634:1: RULE_STRING
            {
             before(grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReport__TitleAssignment_2_15234); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2643:1: rule__ResultReport__TargetAssignment_5 : ( ( ruleURIID ) ) ;
    public final void rule__ResultReport__TargetAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2647:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2648:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2648:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2649:1: ( ruleURIID )
            {
             before(grammarAccess.getResultReportAccess().getTargetEObjectCrossReference_5_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2650:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2651:1: ruleURIID
            {
             before(grammarAccess.getResultReportAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultReport__TargetAssignment_55269);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2662:1: rule__ResultReport__DecriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ResultReport__DecriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2666:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2667:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2667:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2668:1: RULE_STRING
            {
             before(grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReport__DecriptionAssignment_6_15304); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2677:1: rule__ResultReport__HeadingAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__ResultReport__HeadingAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2681:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2682:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2682:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2683:1: RULE_STRING
            {
             before(grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReport__HeadingAssignment_7_15335); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2692:1: rule__ResultReport__ContentAssignment_7_2 : ( ruleResultContributor ) ;
    public final void rule__ResultReport__ContentAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2696:1: ( ( ruleResultContributor ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2697:1: ( ruleResultContributor )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2697:1: ( ruleResultContributor )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2698:1: ruleResultContributor
            {
             before(grammarAccess.getResultReportAccess().getContentResultContributorParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_ruleResultContributor_in_rule__ResultReport__ContentAssignment_7_25366);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2707:1: rule__ResultReport__ResultDataAssignment_8_1 : ( ruleResultData ) ;
    public final void rule__ResultReport__ResultDataAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2711:1: ( ( ruleResultData ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2712:1: ( ruleResultData )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2712:1: ( ruleResultData )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2713:1: ruleResultData
            {
             before(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_ruleResultData_in_rule__ResultReport__ResultDataAssignment_8_15397);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2722:1: rule__ResultReport__IssuesAssignment_9_1 : ( ruleReportIssue ) ;
    public final void rule__ResultReport__IssuesAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2726:1: ( ( ruleReportIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2727:1: ( ruleReportIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2727:1: ( ruleReportIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2728:1: ruleReportIssue
            {
             before(grammarAccess.getResultReportAccess().getIssuesReportIssueParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_ruleReportIssue_in_rule__ResultReport__IssuesAssignment_9_15428);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2737:1: rule__IssuesReport__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__IssuesReport__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2741:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2742:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2742:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2743:1: RULE_ID
            {
             before(grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IssuesReport__NameAssignment_15459); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2752:1: rule__IssuesReport__TitleAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__IssuesReport__TitleAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2756:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2757:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2757:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2758:1: RULE_STRING
            {
             before(grammarAccess.getIssuesReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IssuesReport__TitleAssignment_2_15490); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2767:1: rule__IssuesReport__TargetAssignment_5 : ( ( ruleURIID ) ) ;
    public final void rule__IssuesReport__TargetAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2771:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2772:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2772:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2773:1: ( ruleURIID )
            {
             before(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_5_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2774:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2775:1: ruleURIID
            {
             before(grammarAccess.getIssuesReportAccess().getTargetEObjectURIIDParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__IssuesReport__TargetAssignment_55525);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2786:1: rule__IssuesReport__DecriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__IssuesReport__DecriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2790:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2791:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2791:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2792:1: RULE_STRING
            {
             before(grammarAccess.getIssuesReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IssuesReport__DecriptionAssignment_6_15560); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2801:1: rule__IssuesReport__IssuesAssignment_7 : ( ruleReportIssue ) ;
    public final void rule__IssuesReport__IssuesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2805:1: ( ( ruleReportIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2806:1: ( ruleReportIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2806:1: ( ruleReportIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2807:1: ruleReportIssue
            {
             before(grammarAccess.getIssuesReportAccess().getIssuesReportIssueParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleReportIssue_in_rule__IssuesReport__IssuesAssignment_75591);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2816:1: rule__ResultContributor__ContributorAssignment_1 : ( ( ruleURIID ) ) ;
    public final void rule__ResultContributor__ContributorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2820:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2821:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2821:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2822:1: ( ruleURIID )
            {
             before(grammarAccess.getResultContributorAccess().getContributorEObjectCrossReference_1_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2823:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2824:1: ruleURIID
            {
             before(grammarAccess.getResultContributorAccess().getContributorEObjectURIIDParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultContributor__ContributorAssignment_15626);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2835:1: rule__ResultContributor__CellAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ResultContributor__CellAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2839:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2840:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2840:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2841:1: RULE_STRING
            {
             before(grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultContributor__CellAssignment_45661); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2850:1: rule__ResultContributor__IssuesAssignment_5_1 : ( ruleReportIssue ) ;
    public final void rule__ResultContributor__IssuesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2854:1: ( ( ruleReportIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2855:1: ( ruleReportIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2855:1: ( ruleReportIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2856:1: ruleReportIssue
            {
             before(grammarAccess.getResultContributorAccess().getIssuesReportIssueParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleReportIssue_in_rule__ResultContributor__IssuesAssignment_5_15692);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2865:1: rule__ResultContributor__SubcontributorAssignment_6 : ( ruleResultContributor ) ;
    public final void rule__ResultContributor__SubcontributorAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2869:1: ( ( ruleResultContributor ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2870:1: ( ruleResultContributor )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2870:1: ( ruleResultContributor )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2871:1: ruleResultContributor
            {
             before(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleResultContributor_in_rule__ResultContributor__SubcontributorAssignment_65723);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2880:1: rule__ReportIssue__IssueTypeAssignment_0 : ( ruleReportIssueType ) ;
    public final void rule__ReportIssue__IssueTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2884:1: ( ( ruleReportIssueType ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2885:1: ( ruleReportIssueType )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2885:1: ( ruleReportIssueType )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2886:1: ruleReportIssueType
            {
             before(grammarAccess.getReportIssueAccess().getIssueTypeReportIssueTypeEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleReportIssueType_in_rule__ReportIssue__IssueTypeAssignment_05754);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2895:1: rule__ReportIssue__TitleAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ReportIssue__TitleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2899:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2900:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2900:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2901:1: RULE_STRING
            {
             before(grammarAccess.getReportIssueAccess().getTitleSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ReportIssue__TitleAssignment_15785); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2910:1: rule__ReportIssue__TargetAssignment_2 : ( ( ruleURIID ) ) ;
    public final void rule__ReportIssue__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2914:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2915:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2915:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2916:1: ( ruleURIID )
            {
             before(grammarAccess.getReportIssueAccess().getTargetEObjectCrossReference_2_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2917:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2918:1: ruleURIID
            {
             before(grammarAccess.getReportIssueAccess().getTargetEObjectURIIDParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ReportIssue__TargetAssignment_25820);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2929:1: rule__ResultData__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ResultData__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2933:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2934:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2934:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2935:1: RULE_ID
            {
             before(grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultData__NameAssignment_05855); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2944:1: rule__ResultData__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ResultData__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2948:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2949:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2949:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2950:1: RULE_STRING
            {
             before(grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultData__ValueAssignment_25886); 
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
    public static final BitSet FOLLOW_15_in_rule__ReportIssueType__Alternatives739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ReportIssueType__Alternatives760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__0__Impl_in_rule__ResultReportCollection__Group__0793 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__1_in_rule__ResultReportCollection__Group__0796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ResultReportCollection__Group__0__Impl824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__1__Impl_in_rule__ResultReportCollection__Group__1855 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__2_in_rule__ResultReportCollection__Group__1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__NameAssignment_1_in_rule__ResultReportCollection__Group__1__Impl885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__2__Impl_in_rule__ResultReportCollection__Group__2915 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__3_in_rule__ResultReportCollection__Group__2918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__0_in_rule__ResultReportCollection__Group__2__Impl945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__3__Impl_in_rule__ResultReportCollection__Group__3976 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__4_in_rule__ResultReportCollection__Group__3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ResultReportCollection__Group__3__Impl1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__4__Impl_in_rule__ResultReportCollection__Group__41038 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__5_in_rule__ResultReportCollection__Group__41041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ResultReportCollection__Group__4__Impl1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__5__Impl_in_rule__ResultReportCollection__Group__51100 = new BitSet(new long[]{0x0000000001D00000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__6_in_rule__ResultReportCollection__Group__51103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__TargetAssignment_5_in_rule__ResultReportCollection__Group__5__Impl1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__6__Impl_in_rule__ResultReportCollection__Group__61160 = new BitSet(new long[]{0x0000000001D00000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__7_in_rule__ResultReportCollection__Group__61163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__0_in_rule__ResultReportCollection__Group__6__Impl1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__7__Impl_in_rule__ResultReportCollection__Group__71221 = new BitSet(new long[]{0x0000000001D00000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__8_in_rule__ResultReportCollection__Group__71224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__ContentAssignment_7_in_rule__ResultReportCollection__Group__7__Impl1251 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__8__Impl_in_rule__ResultReportCollection__Group__81282 = new BitSet(new long[]{0x0000000001D00000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__9_in_rule__ResultReportCollection__Group__81285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_8__0_in_rule__ResultReportCollection__Group__8__Impl1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__9__Impl_in_rule__ResultReportCollection__Group__91343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultReportCollection__Group__9__Impl1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__0__Impl_in_rule__ResultReportCollection__Group_2__01422 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__1_in_rule__ResultReportCollection__Group_2__01425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResultReportCollection__Group_2__0__Impl1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__1__Impl_in_rule__ResultReportCollection__Group_2__11484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__TitleAssignment_2_1_in_rule__ResultReportCollection__Group_2__1__Impl1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__0__Impl_in_rule__ResultReportCollection__Group_6__01545 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__1_in_rule__ResultReportCollection__Group_6__01548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ResultReportCollection__Group_6__0__Impl1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__1__Impl_in_rule__ResultReportCollection__Group_6__11607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__DecriptionAssignment_6_1_in_rule__ResultReportCollection__Group_6__1__Impl1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_8__0__Impl_in_rule__ResultReportCollection__Group_8__01668 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_8__1_in_rule__ResultReportCollection__Group_8__01671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ResultReportCollection__Group_8__0__Impl1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_8__1__Impl_in_rule__ResultReportCollection__Group_8__11730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__IssuesAssignment_8_1_in_rule__ResultReportCollection__Group_8__1__Impl1757 = new BitSet(new long[]{0x000000000001F802L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__0__Impl_in_rule__ResultReport__Group__01792 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__1_in_rule__ResultReport__Group__01795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ResultReport__Group__0__Impl1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__1__Impl_in_rule__ResultReport__Group__11854 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__2_in_rule__ResultReport__Group__11857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__NameAssignment_1_in_rule__ResultReport__Group__1__Impl1884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__2__Impl_in_rule__ResultReport__Group__21914 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__3_in_rule__ResultReport__Group__21917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_2__0_in_rule__ResultReport__Group__2__Impl1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__3__Impl_in_rule__ResultReport__Group__31975 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__4_in_rule__ResultReport__Group__31978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ResultReport__Group__3__Impl2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__4__Impl_in_rule__ResultReport__Group__42037 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__5_in_rule__ResultReport__Group__42040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ResultReport__Group__4__Impl2068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__5__Impl_in_rule__ResultReport__Group__52099 = new BitSet(new long[]{0x0000000006D00000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__6_in_rule__ResultReport__Group__52102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__TargetAssignment_5_in_rule__ResultReport__Group__5__Impl2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__6__Impl_in_rule__ResultReport__Group__62159 = new BitSet(new long[]{0x0000000006D00000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__7_in_rule__ResultReport__Group__62162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_6__0_in_rule__ResultReport__Group__6__Impl2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__7__Impl_in_rule__ResultReport__Group__72220 = new BitSet(new long[]{0x0000000006D00000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__8_in_rule__ResultReport__Group__72223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__0_in_rule__ResultReport__Group__7__Impl2250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__8__Impl_in_rule__ResultReport__Group__82281 = new BitSet(new long[]{0x0000000006D00000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__9_in_rule__ResultReport__Group__82284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_8__0_in_rule__ResultReport__Group__8__Impl2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__9__Impl_in_rule__ResultReport__Group__92342 = new BitSet(new long[]{0x0000000006D00000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__10_in_rule__ResultReport__Group__92345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__0_in_rule__ResultReport__Group__9__Impl2372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group__10__Impl_in_rule__ResultReport__Group__102403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultReport__Group__10__Impl2431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_2__0__Impl_in_rule__ResultReport__Group_2__02484 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_2__1_in_rule__ResultReport__Group_2__02487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResultReport__Group_2__0__Impl2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_2__1__Impl_in_rule__ResultReport__Group_2__12546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__TitleAssignment_2_1_in_rule__ResultReport__Group_2__1__Impl2573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_6__0__Impl_in_rule__ResultReport__Group_6__02607 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_6__1_in_rule__ResultReport__Group_6__02610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ResultReport__Group_6__0__Impl2638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_6__1__Impl_in_rule__ResultReport__Group_6__12669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__DecriptionAssignment_6_1_in_rule__ResultReport__Group_6__1__Impl2696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__0__Impl_in_rule__ResultReport__Group_7__02730 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__1_in_rule__ResultReport__Group_7__02733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ResultReport__Group_7__0__Impl2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__1__Impl_in_rule__ResultReport__Group_7__12792 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__2_in_rule__ResultReport__Group_7__12795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__HeadingAssignment_7_1_in_rule__ResultReport__Group_7__1__Impl2822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_7__2__Impl_in_rule__ResultReport__Group_7__22852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__ContentAssignment_7_2_in_rule__ResultReport__Group_7__2__Impl2879 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_8__0__Impl_in_rule__ResultReport__Group_8__02916 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_8__1_in_rule__ResultReport__Group_8__02919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ResultReport__Group_8__0__Impl2947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_8__1__Impl_in_rule__ResultReport__Group_8__12978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__ResultDataAssignment_8_1_in_rule__ResultReport__Group_8__1__Impl3007 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__ResultReport__ResultDataAssignment_8_1_in_rule__ResultReport__Group_8__1__Impl3019 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__0__Impl_in_rule__ResultReport__Group_9__03056 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__1_in_rule__ResultReport__Group_9__03059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ResultReport__Group_9__0__Impl3087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Group_9__1__Impl_in_rule__ResultReport__Group_9__13118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__IssuesAssignment_9_1_in_rule__ResultReport__Group_9__1__Impl3145 = new BitSet(new long[]{0x000000000001F802L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__0__Impl_in_rule__IssuesReport__Group__03180 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__1_in_rule__IssuesReport__Group__03183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__IssuesReport__Group__0__Impl3211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__1__Impl_in_rule__IssuesReport__Group__13242 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__2_in_rule__IssuesReport__Group__13245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__NameAssignment_1_in_rule__IssuesReport__Group__1__Impl3272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__2__Impl_in_rule__IssuesReport__Group__23302 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__3_in_rule__IssuesReport__Group__23305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__0_in_rule__IssuesReport__Group__2__Impl3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__3__Impl_in_rule__IssuesReport__Group__33363 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__4_in_rule__IssuesReport__Group__33366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__IssuesReport__Group__3__Impl3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__4__Impl_in_rule__IssuesReport__Group__43425 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__5_in_rule__IssuesReport__Group__43428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__IssuesReport__Group__4__Impl3456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__5__Impl_in_rule__IssuesReport__Group__53487 = new BitSet(new long[]{0x000000000051F800L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__6_in_rule__IssuesReport__Group__53490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__TargetAssignment_5_in_rule__IssuesReport__Group__5__Impl3517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__6__Impl_in_rule__IssuesReport__Group__63547 = new BitSet(new long[]{0x000000000051F800L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__7_in_rule__IssuesReport__Group__63550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_6__0_in_rule__IssuesReport__Group__6__Impl3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__7__Impl_in_rule__IssuesReport__Group__73608 = new BitSet(new long[]{0x000000000051F800L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__8_in_rule__IssuesReport__Group__73611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__IssuesAssignment_7_in_rule__IssuesReport__Group__7__Impl3638 = new BitSet(new long[]{0x000000000001F802L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__8__Impl_in_rule__IssuesReport__Group__83669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__IssuesReport__Group__8__Impl3697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__0__Impl_in_rule__IssuesReport__Group_2__03746 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__1_in_rule__IssuesReport__Group_2__03749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__IssuesReport__Group_2__0__Impl3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__1__Impl_in_rule__IssuesReport__Group_2__13808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__TitleAssignment_2_1_in_rule__IssuesReport__Group_2__1__Impl3835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_6__0__Impl_in_rule__IssuesReport__Group_6__03869 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_6__1_in_rule__IssuesReport__Group_6__03872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__IssuesReport__Group_6__0__Impl3900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_6__1__Impl_in_rule__IssuesReport__Group_6__13931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__DecriptionAssignment_6_1_in_rule__IssuesReport__Group_6__1__Impl3958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__0__Impl_in_rule__ResultContributor__Group__03992 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__1_in_rule__ResultContributor__Group__03995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ResultContributor__Group__0__Impl4023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__1__Impl_in_rule__ResultContributor__Group__14054 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__2_in_rule__ResultContributor__Group__14057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__ContributorAssignment_1_in_rule__ResultContributor__Group__1__Impl4084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__2__Impl_in_rule__ResultContributor__Group__24114 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__3_in_rule__ResultContributor__Group__24117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ResultContributor__Group__2__Impl4145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__3__Impl_in_rule__ResultContributor__Group__34176 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__4_in_rule__ResultContributor__Group__34179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ResultContributor__Group__3__Impl4207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__4__Impl_in_rule__ResultContributor__Group__44238 = new BitSet(new long[]{0x0000000008900000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__5_in_rule__ResultContributor__Group__44241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__CellAssignment_4_in_rule__ResultContributor__Group__4__Impl4270 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ResultContributor__CellAssignment_4_in_rule__ResultContributor__Group__4__Impl4282 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__5__Impl_in_rule__ResultContributor__Group__54315 = new BitSet(new long[]{0x0000000008900000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__6_in_rule__ResultContributor__Group__54318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__0_in_rule__ResultContributor__Group__5__Impl4345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__6__Impl_in_rule__ResultContributor__Group__64376 = new BitSet(new long[]{0x0000000008900000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__7_in_rule__ResultContributor__Group__64379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__SubcontributorAssignment_6_in_rule__ResultContributor__Group__6__Impl4406 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__7__Impl_in_rule__ResultContributor__Group__74437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultContributor__Group__7__Impl4465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__0__Impl_in_rule__ResultContributor__Group_5__04512 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__1_in_rule__ResultContributor__Group_5__04515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ResultContributor__Group_5__0__Impl4543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_5__1__Impl_in_rule__ResultContributor__Group_5__14574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__IssuesAssignment_5_1_in_rule__ResultContributor__Group_5__1__Impl4601 = new BitSet(new long[]{0x000000000001F802L});
    public static final BitSet FOLLOW_rule__ReportIssue__Group__0__Impl_in_rule__ReportIssue__Group__04636 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ReportIssue__Group__1_in_rule__ReportIssue__Group__04639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssue__IssueTypeAssignment_0_in_rule__ReportIssue__Group__0__Impl4666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssue__Group__1__Impl_in_rule__ReportIssue__Group__14696 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ReportIssue__Group__2_in_rule__ReportIssue__Group__14699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssue__TitleAssignment_1_in_rule__ReportIssue__Group__1__Impl4726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssue__Group__2__Impl_in_rule__ReportIssue__Group__24756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReportIssue__TargetAssignment_2_in_rule__ReportIssue__Group__2__Impl4783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__0__Impl_in_rule__ResultData__Group__04819 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ResultData__Group__1_in_rule__ResultData__Group__04822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__NameAssignment_0_in_rule__ResultData__Group__0__Impl4849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__1__Impl_in_rule__ResultData__Group__14879 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultData__Group__2_in_rule__ResultData__Group__14882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ResultData__Group__1__Impl4910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__2__Impl_in_rule__ResultData__Group__24941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__ValueAssignment_2_in_rule__ResultData__Group__2__Impl4968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultReportCollection__NameAssignment_15009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReportCollection__TitleAssignment_2_15040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultReportCollection__TargetAssignment_55075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReportCollection__DecriptionAssignment_6_15110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReport_in_rule__ResultReportCollection__ContentAssignment_75141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssue_in_rule__ResultReportCollection__IssuesAssignment_8_15172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultReport__NameAssignment_15203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReport__TitleAssignment_2_15234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultReport__TargetAssignment_55269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReport__DecriptionAssignment_6_15304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReport__HeadingAssignment_7_15335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_rule__ResultReport__ContentAssignment_7_25366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_rule__ResultReport__ResultDataAssignment_8_15397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssue_in_rule__ResultReport__IssuesAssignment_9_15428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IssuesReport__NameAssignment_15459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IssuesReport__TitleAssignment_2_15490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__IssuesReport__TargetAssignment_55525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IssuesReport__DecriptionAssignment_6_15560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssue_in_rule__IssuesReport__IssuesAssignment_75591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultContributor__ContributorAssignment_15626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultContributor__CellAssignment_45661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssue_in_rule__ResultContributor__IssuesAssignment_5_15692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_rule__ResultContributor__SubcontributorAssignment_65723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssueType_in_rule__ReportIssue__IssueTypeAssignment_05754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ReportIssue__TitleAssignment_15785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ReportIssue__TargetAssignment_25820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultData__NameAssignment_05855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultData__ValueAssignment_25886 = new BitSet(new long[]{0x0000000000000002L});

}
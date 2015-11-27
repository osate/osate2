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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'tbd'", "'unknown'", "'error'", "'warning'", "'info'", "'success'", "'fail'", "'reports'", "'for'", "'['", "']'", "':'", "'description'", "'report'", "'heading'", "'results'", "'contributor'", "'issues'", "'issue'", "'target'", "'exception'", "'='"
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
    public static final int T__32=32;
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




    // $ANTLR start "entryRuleResultReport"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:72:1: entryRuleResultReport : ruleResultReport EOF ;
    public final void entryRuleResultReport() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:73:1: ( ruleResultReport EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:74:1: ruleResultReport EOF
            {
             before(grammarAccess.getResultReportRule()); 
            pushFollow(FOLLOW_ruleResultReport_in_entryRuleResultReport61);
            ruleResultReport();

            state._fsp--;

             after(grammarAccess.getResultReportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReport68); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:81:1: ruleResultReport : ( ( rule__ResultReport__Alternatives ) ) ;
    public final void ruleResultReport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:85:2: ( ( ( rule__ResultReport__Alternatives ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:86:1: ( ( rule__ResultReport__Alternatives ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:86:1: ( ( rule__ResultReport__Alternatives ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:87:1: ( rule__ResultReport__Alternatives )
            {
             before(grammarAccess.getResultReportAccess().getAlternatives()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:88:1: ( rule__ResultReport__Alternatives )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:88:2: rule__ResultReport__Alternatives
            {
            pushFollow(FOLLOW_rule__ResultReport__Alternatives_in_ruleResultReport94);
            rule__ResultReport__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getResultReportAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleResultDataReport"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:128:1: entryRuleResultDataReport : ruleResultDataReport EOF ;
    public final void entryRuleResultDataReport() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:129:1: ( ruleResultDataReport EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:130:1: ruleResultDataReport EOF
            {
             before(grammarAccess.getResultDataReportRule()); 
            pushFollow(FOLLOW_ruleResultDataReport_in_entryRuleResultDataReport181);
            ruleResultDataReport();

            state._fsp--;

             after(grammarAccess.getResultDataReportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultDataReport188); 

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
    // $ANTLR end "entryRuleResultDataReport"


    // $ANTLR start "ruleResultDataReport"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:137:1: ruleResultDataReport : ( ( rule__ResultDataReport__Group__0 ) ) ;
    public final void ruleResultDataReport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:141:2: ( ( ( rule__ResultDataReport__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:142:1: ( ( rule__ResultDataReport__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:142:1: ( ( rule__ResultDataReport__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:143:1: ( rule__ResultDataReport__Group__0 )
            {
             before(grammarAccess.getResultDataReportAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:144:1: ( rule__ResultDataReport__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:144:2: rule__ResultDataReport__Group__0
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__0_in_ruleResultDataReport214);
            rule__ResultDataReport__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResultDataReportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResultDataReport"


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


    // $ANTLR start "entryRuleIssuesReport"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:184:1: entryRuleIssuesReport : ruleIssuesReport EOF ;
    public final void entryRuleIssuesReport() throws RecognitionException {
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:185:1: ( ruleIssuesReport EOF )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:186:1: ruleIssuesReport EOF
            {
             before(grammarAccess.getIssuesReportRule()); 
            pushFollow(FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport301);
            ruleIssuesReport();

            state._fsp--;

             after(grammarAccess.getIssuesReportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIssuesReport308); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:193:1: ruleIssuesReport : ( ( rule__IssuesReport__Group__0 ) ) ;
    public final void ruleIssuesReport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:197:2: ( ( ( rule__IssuesReport__Group__0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:198:1: ( ( rule__IssuesReport__Group__0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:198:1: ( ( rule__IssuesReport__Group__0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:199:1: ( rule__IssuesReport__Group__0 )
            {
             before(grammarAccess.getIssuesReportAccess().getGroup()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:200:1: ( rule__IssuesReport__Group__0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:200:2: rule__IssuesReport__Group__0
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__0_in_ruleIssuesReport334);
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


    // $ANTLR start "rule__ResultReport__Alternatives"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:315:1: rule__ResultReport__Alternatives : ( ( ruleResultDataReport ) | ( ruleResultReportCollection ) | ( ruleIssuesReport ) );
    public final void rule__ResultReport__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:319:1: ( ( ruleResultDataReport ) | ( ruleResultReportCollection ) | ( ruleIssuesReport ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt1=1;
                }
                break;
            case 18:
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
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:320:1: ( ruleResultDataReport )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:320:1: ( ruleResultDataReport )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:321:1: ruleResultDataReport
                    {
                     before(grammarAccess.getResultReportAccess().getResultDataReportParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleResultDataReport_in_rule__ResultReport__Alternatives585);
                    ruleResultDataReport();

                    state._fsp--;

                     after(grammarAccess.getResultReportAccess().getResultDataReportParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:326:6: ( ruleResultReportCollection )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:326:6: ( ruleResultReportCollection )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:327:1: ruleResultReportCollection
                    {
                     before(grammarAccess.getResultReportAccess().getResultReportCollectionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleResultReportCollection_in_rule__ResultReport__Alternatives602);
                    ruleResultReportCollection();

                    state._fsp--;

                     after(grammarAccess.getResultReportAccess().getResultReportCollectionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:332:6: ( ruleIssuesReport )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:332:6: ( ruleIssuesReport )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:333:1: ruleIssuesReport
                    {
                     before(grammarAccess.getResultReportAccess().getIssuesReportParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleIssuesReport_in_rule__ResultReport__Alternatives619);
                    ruleIssuesReport();

                    state._fsp--;

                     after(grammarAccess.getResultReportAccess().getIssuesReportParserRuleCall_2()); 

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
    // $ANTLR end "rule__ResultReport__Alternatives"


    // $ANTLR start "rule__ResultIssueType__Alternatives"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:343:1: rule__ResultIssueType__Alternatives : ( ( ( 'tbd' ) ) | ( ( 'unknown' ) ) | ( ( 'error' ) ) | ( ( 'warning' ) ) | ( ( 'info' ) ) | ( ( 'success' ) ) | ( ( 'fail' ) ) );
    public final void rule__ResultIssueType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:347:1: ( ( ( 'tbd' ) ) | ( ( 'unknown' ) ) | ( ( 'error' ) ) | ( ( 'warning' ) ) | ( ( 'info' ) ) | ( ( 'success' ) ) | ( ( 'fail' ) ) )
            int alt2=7;
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
            case 17:
                {
                alt2=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:348:1: ( ( 'tbd' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:348:1: ( ( 'tbd' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:349:1: ( 'tbd' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:350:1: ( 'tbd' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:350:3: 'tbd'
                    {
                    match(input,11,FOLLOW_11_in_rule__ResultIssueType__Alternatives652); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:355:6: ( ( 'unknown' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:355:6: ( ( 'unknown' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:356:1: ( 'unknown' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_1()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:357:1: ( 'unknown' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:357:3: 'unknown'
                    {
                    match(input,12,FOLLOW_12_in_rule__ResultIssueType__Alternatives673); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getUNKNOWNEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:362:6: ( ( 'error' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:362:6: ( ( 'error' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:363:1: ( 'error' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_2()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:364:1: ( 'error' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:364:3: 'error'
                    {
                    match(input,13,FOLLOW_13_in_rule__ResultIssueType__Alternatives694); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:369:6: ( ( 'warning' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:369:6: ( ( 'warning' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:370:1: ( 'warning' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_3()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:371:1: ( 'warning' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:371:3: 'warning'
                    {
                    match(input,14,FOLLOW_14_in_rule__ResultIssueType__Alternatives715); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:376:6: ( ( 'info' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:376:6: ( ( 'info' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:377:1: ( 'info' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_4()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:378:1: ( 'info' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:378:3: 'info'
                    {
                    match(input,15,FOLLOW_15_in_rule__ResultIssueType__Alternatives736); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:383:6: ( ( 'success' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:383:6: ( ( 'success' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:384:1: ( 'success' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_5()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:385:1: ( 'success' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:385:3: 'success'
                    {
                    match(input,16,FOLLOW_16_in_rule__ResultIssueType__Alternatives757); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:390:6: ( ( 'fail' ) )
                    {
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:390:6: ( ( 'fail' ) )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:391:1: ( 'fail' )
                    {
                     before(grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_6()); 
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:392:1: ( 'fail' )
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:392:3: 'fail'
                    {
                    match(input,17,FOLLOW_17_in_rule__ResultIssueType__Alternatives778); 

                    }

                     after(grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_6()); 

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:404:1: rule__ResultReportCollection__Group__0 : rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1 ;
    public final void rule__ResultReportCollection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:408:1: ( rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:409:2: rule__ResultReportCollection__Group__0__Impl rule__ResultReportCollection__Group__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__0__Impl_in_rule__ResultReportCollection__Group__0811);
            rule__ResultReportCollection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__1_in_rule__ResultReportCollection__Group__0814);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:416:1: rule__ResultReportCollection__Group__0__Impl : ( 'reports' ) ;
    public final void rule__ResultReportCollection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:420:1: ( ( 'reports' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:421:1: ( 'reports' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:421:1: ( 'reports' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:422:1: 'reports'
            {
             before(grammarAccess.getResultReportCollectionAccess().getReportsKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__ResultReportCollection__Group__0__Impl842); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:435:1: rule__ResultReportCollection__Group__1 : rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2 ;
    public final void rule__ResultReportCollection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:439:1: ( rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:440:2: rule__ResultReportCollection__Group__1__Impl rule__ResultReportCollection__Group__2
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__1__Impl_in_rule__ResultReportCollection__Group__1873);
            rule__ResultReportCollection__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__2_in_rule__ResultReportCollection__Group__1876);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:447:1: rule__ResultReportCollection__Group__1__Impl : ( ( rule__ResultReportCollection__NameAssignment_1 ) ) ;
    public final void rule__ResultReportCollection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:451:1: ( ( ( rule__ResultReportCollection__NameAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:452:1: ( ( rule__ResultReportCollection__NameAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:452:1: ( ( rule__ResultReportCollection__NameAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:453:1: ( rule__ResultReportCollection__NameAssignment_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getNameAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:454:1: ( rule__ResultReportCollection__NameAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:454:2: rule__ResultReportCollection__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__NameAssignment_1_in_rule__ResultReportCollection__Group__1__Impl903);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:464:1: rule__ResultReportCollection__Group__2 : rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3 ;
    public final void rule__ResultReportCollection__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:468:1: ( rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:469:2: rule__ResultReportCollection__Group__2__Impl rule__ResultReportCollection__Group__3
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__2__Impl_in_rule__ResultReportCollection__Group__2933);
            rule__ResultReportCollection__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__3_in_rule__ResultReportCollection__Group__2936);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:476:1: rule__ResultReportCollection__Group__2__Impl : ( ( rule__ResultReportCollection__Group_2__0 )? ) ;
    public final void rule__ResultReportCollection__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:480:1: ( ( ( rule__ResultReportCollection__Group_2__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:481:1: ( ( rule__ResultReportCollection__Group_2__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:481:1: ( ( rule__ResultReportCollection__Group_2__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:482:1: ( rule__ResultReportCollection__Group_2__0 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:483:1: ( rule__ResultReportCollection__Group_2__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==22) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:483:2: rule__ResultReportCollection__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__0_in_rule__ResultReportCollection__Group__2__Impl963);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:493:1: rule__ResultReportCollection__Group__3 : rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4 ;
    public final void rule__ResultReportCollection__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:497:1: ( rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:498:2: rule__ResultReportCollection__Group__3__Impl rule__ResultReportCollection__Group__4
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__3__Impl_in_rule__ResultReportCollection__Group__3994);
            rule__ResultReportCollection__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__4_in_rule__ResultReportCollection__Group__3997);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:505:1: rule__ResultReportCollection__Group__3__Impl : ( 'for' ) ;
    public final void rule__ResultReportCollection__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:509:1: ( ( 'for' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:510:1: ( 'for' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:510:1: ( 'for' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:511:1: 'for'
            {
             before(grammarAccess.getResultReportCollectionAccess().getForKeyword_3()); 
            match(input,19,FOLLOW_19_in_rule__ResultReportCollection__Group__3__Impl1025); 
             after(grammarAccess.getResultReportCollectionAccess().getForKeyword_3()); 

            }


            }

        }
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:524:1: rule__ResultReportCollection__Group__4 : rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5 ;
    public final void rule__ResultReportCollection__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:528:1: ( rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:529:2: rule__ResultReportCollection__Group__4__Impl rule__ResultReportCollection__Group__5
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__4__Impl_in_rule__ResultReportCollection__Group__41056);
            rule__ResultReportCollection__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__5_in_rule__ResultReportCollection__Group__41059);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:536:1: rule__ResultReportCollection__Group__4__Impl : ( ( rule__ResultReportCollection__TargetAssignment_4 ) ) ;
    public final void rule__ResultReportCollection__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:540:1: ( ( ( rule__ResultReportCollection__TargetAssignment_4 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:541:1: ( ( rule__ResultReportCollection__TargetAssignment_4 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:541:1: ( ( rule__ResultReportCollection__TargetAssignment_4 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:542:1: ( rule__ResultReportCollection__TargetAssignment_4 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:543:1: ( rule__ResultReportCollection__TargetAssignment_4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:543:2: rule__ResultReportCollection__TargetAssignment_4
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__TargetAssignment_4_in_rule__ResultReportCollection__Group__4__Impl1086);
            rule__ResultReportCollection__TargetAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getResultReportCollectionAccess().getTargetAssignment_4()); 

            }


            }

        }
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:553:1: rule__ResultReportCollection__Group__5 : rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6 ;
    public final void rule__ResultReportCollection__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:557:1: ( rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:558:2: rule__ResultReportCollection__Group__5__Impl rule__ResultReportCollection__Group__6
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__5__Impl_in_rule__ResultReportCollection__Group__51116);
            rule__ResultReportCollection__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__6_in_rule__ResultReportCollection__Group__51119);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:565:1: rule__ResultReportCollection__Group__5__Impl : ( '[' ) ;
    public final void rule__ResultReportCollection__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:569:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:570:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:570:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:571:1: '['
            {
             before(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_5()); 
            match(input,20,FOLLOW_20_in_rule__ResultReportCollection__Group__5__Impl1147); 
             after(grammarAccess.getResultReportCollectionAccess().getLeftSquareBracketKeyword_5()); 

            }


            }

        }
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:584:1: rule__ResultReportCollection__Group__6 : rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7 ;
    public final void rule__ResultReportCollection__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:588:1: ( rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:589:2: rule__ResultReportCollection__Group__6__Impl rule__ResultReportCollection__Group__7
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__6__Impl_in_rule__ResultReportCollection__Group__61178);
            rule__ResultReportCollection__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__7_in_rule__ResultReportCollection__Group__61181);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:596:1: rule__ResultReportCollection__Group__6__Impl : ( ( rule__ResultReportCollection__Group_6__0 )? ) ;
    public final void rule__ResultReportCollection__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:600:1: ( ( ( rule__ResultReportCollection__Group_6__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:601:1: ( ( rule__ResultReportCollection__Group_6__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:601:1: ( ( rule__ResultReportCollection__Group_6__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:602:1: ( rule__ResultReportCollection__Group_6__0 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getGroup_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:603:1: ( rule__ResultReportCollection__Group_6__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==23) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:603:2: rule__ResultReportCollection__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__0_in_rule__ResultReportCollection__Group__6__Impl1208);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:613:1: rule__ResultReportCollection__Group__7 : rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8 ;
    public final void rule__ResultReportCollection__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:617:1: ( rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:618:2: rule__ResultReportCollection__Group__7__Impl rule__ResultReportCollection__Group__8
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__7__Impl_in_rule__ResultReportCollection__Group__71239);
            rule__ResultReportCollection__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__8_in_rule__ResultReportCollection__Group__71242);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:625:1: rule__ResultReportCollection__Group__7__Impl : ( ( rule__ResultReportCollection__ContentAssignment_7 )* ) ;
    public final void rule__ResultReportCollection__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:629:1: ( ( ( rule__ResultReportCollection__ContentAssignment_7 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:630:1: ( ( rule__ResultReportCollection__ContentAssignment_7 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:630:1: ( ( rule__ResultReportCollection__ContentAssignment_7 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:631:1: ( rule__ResultReportCollection__ContentAssignment_7 )*
            {
             before(grammarAccess.getResultReportCollectionAccess().getContentAssignment_7()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:632:1: ( rule__ResultReportCollection__ContentAssignment_7 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18||LA5_0==24||LA5_0==28) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:632:2: rule__ResultReportCollection__ContentAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__ResultReportCollection__ContentAssignment_7_in_rule__ResultReportCollection__Group__7__Impl1269);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:642:1: rule__ResultReportCollection__Group__8 : rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9 ;
    public final void rule__ResultReportCollection__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:646:1: ( rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:647:2: rule__ResultReportCollection__Group__8__Impl rule__ResultReportCollection__Group__9
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__8__Impl_in_rule__ResultReportCollection__Group__81300);
            rule__ResultReportCollection__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group__9_in_rule__ResultReportCollection__Group__81303);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:654:1: rule__ResultReportCollection__Group__8__Impl : ( ( rule__ResultReportCollection__IssuesAssignment_8 )? ) ;
    public final void rule__ResultReportCollection__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:658:1: ( ( ( rule__ResultReportCollection__IssuesAssignment_8 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:659:1: ( ( rule__ResultReportCollection__IssuesAssignment_8 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:659:1: ( ( rule__ResultReportCollection__IssuesAssignment_8 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:660:1: ( rule__ResultReportCollection__IssuesAssignment_8 )?
            {
             before(grammarAccess.getResultReportCollectionAccess().getIssuesAssignment_8()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:661:1: ( rule__ResultReportCollection__IssuesAssignment_8 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==29) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:661:2: rule__ResultReportCollection__IssuesAssignment_8
                    {
                    pushFollow(FOLLOW_rule__ResultReportCollection__IssuesAssignment_8_in_rule__ResultReportCollection__Group__8__Impl1330);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:671:1: rule__ResultReportCollection__Group__9 : rule__ResultReportCollection__Group__9__Impl ;
    public final void rule__ResultReportCollection__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:675:1: ( rule__ResultReportCollection__Group__9__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:676:2: rule__ResultReportCollection__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group__9__Impl_in_rule__ResultReportCollection__Group__91361);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:682:1: rule__ResultReportCollection__Group__9__Impl : ( ']' ) ;
    public final void rule__ResultReportCollection__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:686:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:687:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:687:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:688:1: ']'
            {
             before(grammarAccess.getResultReportCollectionAccess().getRightSquareBracketKeyword_9()); 
            match(input,21,FOLLOW_21_in_rule__ResultReportCollection__Group__9__Impl1389); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:721:1: rule__ResultReportCollection__Group_2__0 : rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1 ;
    public final void rule__ResultReportCollection__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:725:1: ( rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:726:2: rule__ResultReportCollection__Group_2__0__Impl rule__ResultReportCollection__Group_2__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__0__Impl_in_rule__ResultReportCollection__Group_2__01440);
            rule__ResultReportCollection__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__1_in_rule__ResultReportCollection__Group_2__01443);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:733:1: rule__ResultReportCollection__Group_2__0__Impl : ( ':' ) ;
    public final void rule__ResultReportCollection__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:737:1: ( ( ':' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:738:1: ( ':' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:738:1: ( ':' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:739:1: ':'
            {
             before(grammarAccess.getResultReportCollectionAccess().getColonKeyword_2_0()); 
            match(input,22,FOLLOW_22_in_rule__ResultReportCollection__Group_2__0__Impl1471); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:752:1: rule__ResultReportCollection__Group_2__1 : rule__ResultReportCollection__Group_2__1__Impl ;
    public final void rule__ResultReportCollection__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:756:1: ( rule__ResultReportCollection__Group_2__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:757:2: rule__ResultReportCollection__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_2__1__Impl_in_rule__ResultReportCollection__Group_2__11502);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:763:1: rule__ResultReportCollection__Group_2__1__Impl : ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) ) ;
    public final void rule__ResultReportCollection__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:767:1: ( ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:768:1: ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:768:1: ( ( rule__ResultReportCollection__TitleAssignment_2_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:769:1: ( rule__ResultReportCollection__TitleAssignment_2_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTitleAssignment_2_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:770:1: ( rule__ResultReportCollection__TitleAssignment_2_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:770:2: rule__ResultReportCollection__TitleAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__TitleAssignment_2_1_in_rule__ResultReportCollection__Group_2__1__Impl1529);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:784:1: rule__ResultReportCollection__Group_6__0 : rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1 ;
    public final void rule__ResultReportCollection__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:788:1: ( rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:789:2: rule__ResultReportCollection__Group_6__0__Impl rule__ResultReportCollection__Group_6__1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__0__Impl_in_rule__ResultReportCollection__Group_6__01563);
            rule__ResultReportCollection__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__1_in_rule__ResultReportCollection__Group_6__01566);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:796:1: rule__ResultReportCollection__Group_6__0__Impl : ( 'description' ) ;
    public final void rule__ResultReportCollection__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:800:1: ( ( 'description' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:801:1: ( 'description' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:801:1: ( 'description' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:802:1: 'description'
            {
             before(grammarAccess.getResultReportCollectionAccess().getDescriptionKeyword_6_0()); 
            match(input,23,FOLLOW_23_in_rule__ResultReportCollection__Group_6__0__Impl1594); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:815:1: rule__ResultReportCollection__Group_6__1 : rule__ResultReportCollection__Group_6__1__Impl ;
    public final void rule__ResultReportCollection__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:819:1: ( rule__ResultReportCollection__Group_6__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:820:2: rule__ResultReportCollection__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__Group_6__1__Impl_in_rule__ResultReportCollection__Group_6__11625);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:826:1: rule__ResultReportCollection__Group_6__1__Impl : ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) ) ;
    public final void rule__ResultReportCollection__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:830:1: ( ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:831:1: ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:831:1: ( ( rule__ResultReportCollection__DecriptionAssignment_6_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:832:1: ( rule__ResultReportCollection__DecriptionAssignment_6_1 )
            {
             before(grammarAccess.getResultReportCollectionAccess().getDecriptionAssignment_6_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:833:1: ( rule__ResultReportCollection__DecriptionAssignment_6_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:833:2: rule__ResultReportCollection__DecriptionAssignment_6_1
            {
            pushFollow(FOLLOW_rule__ResultReportCollection__DecriptionAssignment_6_1_in_rule__ResultReportCollection__Group_6__1__Impl1652);
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


    // $ANTLR start "rule__ResultDataReport__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:847:1: rule__ResultDataReport__Group__0 : rule__ResultDataReport__Group__0__Impl rule__ResultDataReport__Group__1 ;
    public final void rule__ResultDataReport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:851:1: ( rule__ResultDataReport__Group__0__Impl rule__ResultDataReport__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:852:2: rule__ResultDataReport__Group__0__Impl rule__ResultDataReport__Group__1
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__0__Impl_in_rule__ResultDataReport__Group__01686);
            rule__ResultDataReport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group__1_in_rule__ResultDataReport__Group__01689);
            rule__ResultDataReport__Group__1();

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
    // $ANTLR end "rule__ResultDataReport__Group__0"


    // $ANTLR start "rule__ResultDataReport__Group__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:859:1: rule__ResultDataReport__Group__0__Impl : ( 'report' ) ;
    public final void rule__ResultDataReport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:863:1: ( ( 'report' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:864:1: ( 'report' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:864:1: ( 'report' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:865:1: 'report'
            {
             before(grammarAccess.getResultDataReportAccess().getReportKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__ResultDataReport__Group__0__Impl1717); 
             after(grammarAccess.getResultDataReportAccess().getReportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group__0__Impl"


    // $ANTLR start "rule__ResultDataReport__Group__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:878:1: rule__ResultDataReport__Group__1 : rule__ResultDataReport__Group__1__Impl rule__ResultDataReport__Group__2 ;
    public final void rule__ResultDataReport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:882:1: ( rule__ResultDataReport__Group__1__Impl rule__ResultDataReport__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:883:2: rule__ResultDataReport__Group__1__Impl rule__ResultDataReport__Group__2
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__1__Impl_in_rule__ResultDataReport__Group__11748);
            rule__ResultDataReport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group__2_in_rule__ResultDataReport__Group__11751);
            rule__ResultDataReport__Group__2();

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
    // $ANTLR end "rule__ResultDataReport__Group__1"


    // $ANTLR start "rule__ResultDataReport__Group__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:890:1: rule__ResultDataReport__Group__1__Impl : ( ( rule__ResultDataReport__NameAssignment_1 ) ) ;
    public final void rule__ResultDataReport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:894:1: ( ( ( rule__ResultDataReport__NameAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:895:1: ( ( rule__ResultDataReport__NameAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:895:1: ( ( rule__ResultDataReport__NameAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:896:1: ( rule__ResultDataReport__NameAssignment_1 )
            {
             before(grammarAccess.getResultDataReportAccess().getNameAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:897:1: ( rule__ResultDataReport__NameAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:897:2: rule__ResultDataReport__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultDataReport__NameAssignment_1_in_rule__ResultDataReport__Group__1__Impl1778);
            rule__ResultDataReport__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getResultDataReportAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group__1__Impl"


    // $ANTLR start "rule__ResultDataReport__Group__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:907:1: rule__ResultDataReport__Group__2 : rule__ResultDataReport__Group__2__Impl rule__ResultDataReport__Group__3 ;
    public final void rule__ResultDataReport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:911:1: ( rule__ResultDataReport__Group__2__Impl rule__ResultDataReport__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:912:2: rule__ResultDataReport__Group__2__Impl rule__ResultDataReport__Group__3
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__2__Impl_in_rule__ResultDataReport__Group__21808);
            rule__ResultDataReport__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group__3_in_rule__ResultDataReport__Group__21811);
            rule__ResultDataReport__Group__3();

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
    // $ANTLR end "rule__ResultDataReport__Group__2"


    // $ANTLR start "rule__ResultDataReport__Group__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:919:1: rule__ResultDataReport__Group__2__Impl : ( ( rule__ResultDataReport__Group_2__0 )? ) ;
    public final void rule__ResultDataReport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:923:1: ( ( ( rule__ResultDataReport__Group_2__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:924:1: ( ( rule__ResultDataReport__Group_2__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:924:1: ( ( rule__ResultDataReport__Group_2__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:925:1: ( rule__ResultDataReport__Group_2__0 )?
            {
             before(grammarAccess.getResultDataReportAccess().getGroup_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:926:1: ( rule__ResultDataReport__Group_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:926:2: rule__ResultDataReport__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ResultDataReport__Group_2__0_in_rule__ResultDataReport__Group__2__Impl1838);
                    rule__ResultDataReport__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultDataReportAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group__2__Impl"


    // $ANTLR start "rule__ResultDataReport__Group__3"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:936:1: rule__ResultDataReport__Group__3 : rule__ResultDataReport__Group__3__Impl rule__ResultDataReport__Group__4 ;
    public final void rule__ResultDataReport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:940:1: ( rule__ResultDataReport__Group__3__Impl rule__ResultDataReport__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:941:2: rule__ResultDataReport__Group__3__Impl rule__ResultDataReport__Group__4
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__3__Impl_in_rule__ResultDataReport__Group__31869);
            rule__ResultDataReport__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group__4_in_rule__ResultDataReport__Group__31872);
            rule__ResultDataReport__Group__4();

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
    // $ANTLR end "rule__ResultDataReport__Group__3"


    // $ANTLR start "rule__ResultDataReport__Group__3__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:948:1: rule__ResultDataReport__Group__3__Impl : ( 'for' ) ;
    public final void rule__ResultDataReport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:952:1: ( ( 'for' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:953:1: ( 'for' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:953:1: ( 'for' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:954:1: 'for'
            {
             before(grammarAccess.getResultDataReportAccess().getForKeyword_3()); 
            match(input,19,FOLLOW_19_in_rule__ResultDataReport__Group__3__Impl1900); 
             after(grammarAccess.getResultDataReportAccess().getForKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group__3__Impl"


    // $ANTLR start "rule__ResultDataReport__Group__4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:967:1: rule__ResultDataReport__Group__4 : rule__ResultDataReport__Group__4__Impl rule__ResultDataReport__Group__5 ;
    public final void rule__ResultDataReport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:971:1: ( rule__ResultDataReport__Group__4__Impl rule__ResultDataReport__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:972:2: rule__ResultDataReport__Group__4__Impl rule__ResultDataReport__Group__5
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__4__Impl_in_rule__ResultDataReport__Group__41931);
            rule__ResultDataReport__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group__5_in_rule__ResultDataReport__Group__41934);
            rule__ResultDataReport__Group__5();

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
    // $ANTLR end "rule__ResultDataReport__Group__4"


    // $ANTLR start "rule__ResultDataReport__Group__4__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:979:1: rule__ResultDataReport__Group__4__Impl : ( ( rule__ResultDataReport__TargetAssignment_4 ) ) ;
    public final void rule__ResultDataReport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:983:1: ( ( ( rule__ResultDataReport__TargetAssignment_4 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:984:1: ( ( rule__ResultDataReport__TargetAssignment_4 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:984:1: ( ( rule__ResultDataReport__TargetAssignment_4 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:985:1: ( rule__ResultDataReport__TargetAssignment_4 )
            {
             before(grammarAccess.getResultDataReportAccess().getTargetAssignment_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:986:1: ( rule__ResultDataReport__TargetAssignment_4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:986:2: rule__ResultDataReport__TargetAssignment_4
            {
            pushFollow(FOLLOW_rule__ResultDataReport__TargetAssignment_4_in_rule__ResultDataReport__Group__4__Impl1961);
            rule__ResultDataReport__TargetAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getResultDataReportAccess().getTargetAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group__4__Impl"


    // $ANTLR start "rule__ResultDataReport__Group__5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:996:1: rule__ResultDataReport__Group__5 : rule__ResultDataReport__Group__5__Impl rule__ResultDataReport__Group__6 ;
    public final void rule__ResultDataReport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1000:1: ( rule__ResultDataReport__Group__5__Impl rule__ResultDataReport__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1001:2: rule__ResultDataReport__Group__5__Impl rule__ResultDataReport__Group__6
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__5__Impl_in_rule__ResultDataReport__Group__51991);
            rule__ResultDataReport__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group__6_in_rule__ResultDataReport__Group__51994);
            rule__ResultDataReport__Group__6();

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
    // $ANTLR end "rule__ResultDataReport__Group__5"


    // $ANTLR start "rule__ResultDataReport__Group__5__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1008:1: rule__ResultDataReport__Group__5__Impl : ( '[' ) ;
    public final void rule__ResultDataReport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1012:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1013:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1013:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1014:1: '['
            {
             before(grammarAccess.getResultDataReportAccess().getLeftSquareBracketKeyword_5()); 
            match(input,20,FOLLOW_20_in_rule__ResultDataReport__Group__5__Impl2022); 
             after(grammarAccess.getResultDataReportAccess().getLeftSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group__5__Impl"


    // $ANTLR start "rule__ResultDataReport__Group__6"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1027:1: rule__ResultDataReport__Group__6 : rule__ResultDataReport__Group__6__Impl rule__ResultDataReport__Group__7 ;
    public final void rule__ResultDataReport__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1031:1: ( rule__ResultDataReport__Group__6__Impl rule__ResultDataReport__Group__7 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1032:2: rule__ResultDataReport__Group__6__Impl rule__ResultDataReport__Group__7
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__6__Impl_in_rule__ResultDataReport__Group__62053);
            rule__ResultDataReport__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group__7_in_rule__ResultDataReport__Group__62056);
            rule__ResultDataReport__Group__7();

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
    // $ANTLR end "rule__ResultDataReport__Group__6"


    // $ANTLR start "rule__ResultDataReport__Group__6__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1039:1: rule__ResultDataReport__Group__6__Impl : ( ( rule__ResultDataReport__Group_6__0 )? ) ;
    public final void rule__ResultDataReport__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1043:1: ( ( ( rule__ResultDataReport__Group_6__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1044:1: ( ( rule__ResultDataReport__Group_6__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1044:1: ( ( rule__ResultDataReport__Group_6__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1045:1: ( rule__ResultDataReport__Group_6__0 )?
            {
             before(grammarAccess.getResultDataReportAccess().getGroup_6()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1046:1: ( rule__ResultDataReport__Group_6__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1046:2: rule__ResultDataReport__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__ResultDataReport__Group_6__0_in_rule__ResultDataReport__Group__6__Impl2083);
                    rule__ResultDataReport__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultDataReportAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group__6__Impl"


    // $ANTLR start "rule__ResultDataReport__Group__7"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1056:1: rule__ResultDataReport__Group__7 : rule__ResultDataReport__Group__7__Impl rule__ResultDataReport__Group__8 ;
    public final void rule__ResultDataReport__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1060:1: ( rule__ResultDataReport__Group__7__Impl rule__ResultDataReport__Group__8 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1061:2: rule__ResultDataReport__Group__7__Impl rule__ResultDataReport__Group__8
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__7__Impl_in_rule__ResultDataReport__Group__72114);
            rule__ResultDataReport__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group__8_in_rule__ResultDataReport__Group__72117);
            rule__ResultDataReport__Group__8();

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
    // $ANTLR end "rule__ResultDataReport__Group__7"


    // $ANTLR start "rule__ResultDataReport__Group__7__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1068:1: rule__ResultDataReport__Group__7__Impl : ( ( rule__ResultDataReport__Group_7__0 )? ) ;
    public final void rule__ResultDataReport__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1072:1: ( ( ( rule__ResultDataReport__Group_7__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1073:1: ( ( rule__ResultDataReport__Group_7__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1073:1: ( ( rule__ResultDataReport__Group_7__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1074:1: ( rule__ResultDataReport__Group_7__0 )?
            {
             before(grammarAccess.getResultDataReportAccess().getGroup_7()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1075:1: ( rule__ResultDataReport__Group_7__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1075:2: rule__ResultDataReport__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__ResultDataReport__Group_7__0_in_rule__ResultDataReport__Group__7__Impl2144);
                    rule__ResultDataReport__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultDataReportAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group__7__Impl"


    // $ANTLR start "rule__ResultDataReport__Group__8"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1085:1: rule__ResultDataReport__Group__8 : rule__ResultDataReport__Group__8__Impl rule__ResultDataReport__Group__9 ;
    public final void rule__ResultDataReport__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1089:1: ( rule__ResultDataReport__Group__8__Impl rule__ResultDataReport__Group__9 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1090:2: rule__ResultDataReport__Group__8__Impl rule__ResultDataReport__Group__9
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__8__Impl_in_rule__ResultDataReport__Group__82175);
            rule__ResultDataReport__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group__9_in_rule__ResultDataReport__Group__82178);
            rule__ResultDataReport__Group__9();

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
    // $ANTLR end "rule__ResultDataReport__Group__8"


    // $ANTLR start "rule__ResultDataReport__Group__8__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1097:1: rule__ResultDataReport__Group__8__Impl : ( ( rule__ResultDataReport__Group_8__0 )? ) ;
    public final void rule__ResultDataReport__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1101:1: ( ( ( rule__ResultDataReport__Group_8__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1102:1: ( ( rule__ResultDataReport__Group_8__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1102:1: ( ( rule__ResultDataReport__Group_8__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1103:1: ( rule__ResultDataReport__Group_8__0 )?
            {
             before(grammarAccess.getResultDataReportAccess().getGroup_8()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1104:1: ( rule__ResultDataReport__Group_8__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==26) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1104:2: rule__ResultDataReport__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__ResultDataReport__Group_8__0_in_rule__ResultDataReport__Group__8__Impl2205);
                    rule__ResultDataReport__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultDataReportAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group__8__Impl"


    // $ANTLR start "rule__ResultDataReport__Group__9"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1114:1: rule__ResultDataReport__Group__9 : rule__ResultDataReport__Group__9__Impl rule__ResultDataReport__Group__10 ;
    public final void rule__ResultDataReport__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1118:1: ( rule__ResultDataReport__Group__9__Impl rule__ResultDataReport__Group__10 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1119:2: rule__ResultDataReport__Group__9__Impl rule__ResultDataReport__Group__10
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__9__Impl_in_rule__ResultDataReport__Group__92236);
            rule__ResultDataReport__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group__10_in_rule__ResultDataReport__Group__92239);
            rule__ResultDataReport__Group__10();

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
    // $ANTLR end "rule__ResultDataReport__Group__9"


    // $ANTLR start "rule__ResultDataReport__Group__9__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1126:1: rule__ResultDataReport__Group__9__Impl : ( ( rule__ResultDataReport__IssuesAssignment_9 )* ) ;
    public final void rule__ResultDataReport__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1130:1: ( ( ( rule__ResultDataReport__IssuesAssignment_9 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1131:1: ( ( rule__ResultDataReport__IssuesAssignment_9 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1131:1: ( ( rule__ResultDataReport__IssuesAssignment_9 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1132:1: ( rule__ResultDataReport__IssuesAssignment_9 )*
            {
             before(grammarAccess.getResultDataReportAccess().getIssuesAssignment_9()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1133:1: ( rule__ResultDataReport__IssuesAssignment_9 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==29) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1133:2: rule__ResultDataReport__IssuesAssignment_9
            	    {
            	    pushFollow(FOLLOW_rule__ResultDataReport__IssuesAssignment_9_in_rule__ResultDataReport__Group__9__Impl2266);
            	    rule__ResultDataReport__IssuesAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getResultDataReportAccess().getIssuesAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group__9__Impl"


    // $ANTLR start "rule__ResultDataReport__Group__10"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1143:1: rule__ResultDataReport__Group__10 : rule__ResultDataReport__Group__10__Impl ;
    public final void rule__ResultDataReport__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1147:1: ( rule__ResultDataReport__Group__10__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1148:2: rule__ResultDataReport__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group__10__Impl_in_rule__ResultDataReport__Group__102297);
            rule__ResultDataReport__Group__10__Impl();

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
    // $ANTLR end "rule__ResultDataReport__Group__10"


    // $ANTLR start "rule__ResultDataReport__Group__10__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1154:1: rule__ResultDataReport__Group__10__Impl : ( ']' ) ;
    public final void rule__ResultDataReport__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1158:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1159:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1159:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1160:1: ']'
            {
             before(grammarAccess.getResultDataReportAccess().getRightSquareBracketKeyword_10()); 
            match(input,21,FOLLOW_21_in_rule__ResultDataReport__Group__10__Impl2325); 
             after(grammarAccess.getResultDataReportAccess().getRightSquareBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group__10__Impl"


    // $ANTLR start "rule__ResultDataReport__Group_2__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1195:1: rule__ResultDataReport__Group_2__0 : rule__ResultDataReport__Group_2__0__Impl rule__ResultDataReport__Group_2__1 ;
    public final void rule__ResultDataReport__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1199:1: ( rule__ResultDataReport__Group_2__0__Impl rule__ResultDataReport__Group_2__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1200:2: rule__ResultDataReport__Group_2__0__Impl rule__ResultDataReport__Group_2__1
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group_2__0__Impl_in_rule__ResultDataReport__Group_2__02378);
            rule__ResultDataReport__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group_2__1_in_rule__ResultDataReport__Group_2__02381);
            rule__ResultDataReport__Group_2__1();

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
    // $ANTLR end "rule__ResultDataReport__Group_2__0"


    // $ANTLR start "rule__ResultDataReport__Group_2__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1207:1: rule__ResultDataReport__Group_2__0__Impl : ( ':' ) ;
    public final void rule__ResultDataReport__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1211:1: ( ( ':' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1212:1: ( ':' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1212:1: ( ':' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1213:1: ':'
            {
             before(grammarAccess.getResultDataReportAccess().getColonKeyword_2_0()); 
            match(input,22,FOLLOW_22_in_rule__ResultDataReport__Group_2__0__Impl2409); 
             after(grammarAccess.getResultDataReportAccess().getColonKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group_2__0__Impl"


    // $ANTLR start "rule__ResultDataReport__Group_2__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1226:1: rule__ResultDataReport__Group_2__1 : rule__ResultDataReport__Group_2__1__Impl ;
    public final void rule__ResultDataReport__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1230:1: ( rule__ResultDataReport__Group_2__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1231:2: rule__ResultDataReport__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group_2__1__Impl_in_rule__ResultDataReport__Group_2__12440);
            rule__ResultDataReport__Group_2__1__Impl();

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
    // $ANTLR end "rule__ResultDataReport__Group_2__1"


    // $ANTLR start "rule__ResultDataReport__Group_2__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1237:1: rule__ResultDataReport__Group_2__1__Impl : ( ( rule__ResultDataReport__TitleAssignment_2_1 ) ) ;
    public final void rule__ResultDataReport__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1241:1: ( ( ( rule__ResultDataReport__TitleAssignment_2_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1242:1: ( ( rule__ResultDataReport__TitleAssignment_2_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1242:1: ( ( rule__ResultDataReport__TitleAssignment_2_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1243:1: ( rule__ResultDataReport__TitleAssignment_2_1 )
            {
             before(grammarAccess.getResultDataReportAccess().getTitleAssignment_2_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1244:1: ( rule__ResultDataReport__TitleAssignment_2_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1244:2: rule__ResultDataReport__TitleAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ResultDataReport__TitleAssignment_2_1_in_rule__ResultDataReport__Group_2__1__Impl2467);
            rule__ResultDataReport__TitleAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getResultDataReportAccess().getTitleAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group_2__1__Impl"


    // $ANTLR start "rule__ResultDataReport__Group_6__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1258:1: rule__ResultDataReport__Group_6__0 : rule__ResultDataReport__Group_6__0__Impl rule__ResultDataReport__Group_6__1 ;
    public final void rule__ResultDataReport__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1262:1: ( rule__ResultDataReport__Group_6__0__Impl rule__ResultDataReport__Group_6__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1263:2: rule__ResultDataReport__Group_6__0__Impl rule__ResultDataReport__Group_6__1
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group_6__0__Impl_in_rule__ResultDataReport__Group_6__02501);
            rule__ResultDataReport__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group_6__1_in_rule__ResultDataReport__Group_6__02504);
            rule__ResultDataReport__Group_6__1();

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
    // $ANTLR end "rule__ResultDataReport__Group_6__0"


    // $ANTLR start "rule__ResultDataReport__Group_6__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1270:1: rule__ResultDataReport__Group_6__0__Impl : ( 'description' ) ;
    public final void rule__ResultDataReport__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1274:1: ( ( 'description' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1275:1: ( 'description' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1275:1: ( 'description' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1276:1: 'description'
            {
             before(grammarAccess.getResultDataReportAccess().getDescriptionKeyword_6_0()); 
            match(input,23,FOLLOW_23_in_rule__ResultDataReport__Group_6__0__Impl2532); 
             after(grammarAccess.getResultDataReportAccess().getDescriptionKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group_6__0__Impl"


    // $ANTLR start "rule__ResultDataReport__Group_6__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1289:1: rule__ResultDataReport__Group_6__1 : rule__ResultDataReport__Group_6__1__Impl ;
    public final void rule__ResultDataReport__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1293:1: ( rule__ResultDataReport__Group_6__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1294:2: rule__ResultDataReport__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group_6__1__Impl_in_rule__ResultDataReport__Group_6__12563);
            rule__ResultDataReport__Group_6__1__Impl();

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
    // $ANTLR end "rule__ResultDataReport__Group_6__1"


    // $ANTLR start "rule__ResultDataReport__Group_6__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1300:1: rule__ResultDataReport__Group_6__1__Impl : ( ( rule__ResultDataReport__DecriptionAssignment_6_1 ) ) ;
    public final void rule__ResultDataReport__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1304:1: ( ( ( rule__ResultDataReport__DecriptionAssignment_6_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1305:1: ( ( rule__ResultDataReport__DecriptionAssignment_6_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1305:1: ( ( rule__ResultDataReport__DecriptionAssignment_6_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1306:1: ( rule__ResultDataReport__DecriptionAssignment_6_1 )
            {
             before(grammarAccess.getResultDataReportAccess().getDecriptionAssignment_6_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1307:1: ( rule__ResultDataReport__DecriptionAssignment_6_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1307:2: rule__ResultDataReport__DecriptionAssignment_6_1
            {
            pushFollow(FOLLOW_rule__ResultDataReport__DecriptionAssignment_6_1_in_rule__ResultDataReport__Group_6__1__Impl2590);
            rule__ResultDataReport__DecriptionAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getResultDataReportAccess().getDecriptionAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group_6__1__Impl"


    // $ANTLR start "rule__ResultDataReport__Group_7__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1321:1: rule__ResultDataReport__Group_7__0 : rule__ResultDataReport__Group_7__0__Impl rule__ResultDataReport__Group_7__1 ;
    public final void rule__ResultDataReport__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1325:1: ( rule__ResultDataReport__Group_7__0__Impl rule__ResultDataReport__Group_7__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1326:2: rule__ResultDataReport__Group_7__0__Impl rule__ResultDataReport__Group_7__1
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group_7__0__Impl_in_rule__ResultDataReport__Group_7__02624);
            rule__ResultDataReport__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group_7__1_in_rule__ResultDataReport__Group_7__02627);
            rule__ResultDataReport__Group_7__1();

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
    // $ANTLR end "rule__ResultDataReport__Group_7__0"


    // $ANTLR start "rule__ResultDataReport__Group_7__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1333:1: rule__ResultDataReport__Group_7__0__Impl : ( 'heading' ) ;
    public final void rule__ResultDataReport__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1337:1: ( ( 'heading' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1338:1: ( 'heading' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1338:1: ( 'heading' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1339:1: 'heading'
            {
             before(grammarAccess.getResultDataReportAccess().getHeadingKeyword_7_0()); 
            match(input,25,FOLLOW_25_in_rule__ResultDataReport__Group_7__0__Impl2655); 
             after(grammarAccess.getResultDataReportAccess().getHeadingKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group_7__0__Impl"


    // $ANTLR start "rule__ResultDataReport__Group_7__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1352:1: rule__ResultDataReport__Group_7__1 : rule__ResultDataReport__Group_7__1__Impl rule__ResultDataReport__Group_7__2 ;
    public final void rule__ResultDataReport__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1356:1: ( rule__ResultDataReport__Group_7__1__Impl rule__ResultDataReport__Group_7__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1357:2: rule__ResultDataReport__Group_7__1__Impl rule__ResultDataReport__Group_7__2
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group_7__1__Impl_in_rule__ResultDataReport__Group_7__12686);
            rule__ResultDataReport__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group_7__2_in_rule__ResultDataReport__Group_7__12689);
            rule__ResultDataReport__Group_7__2();

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
    // $ANTLR end "rule__ResultDataReport__Group_7__1"


    // $ANTLR start "rule__ResultDataReport__Group_7__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1364:1: rule__ResultDataReport__Group_7__1__Impl : ( ( rule__ResultDataReport__HeadingAssignment_7_1 ) ) ;
    public final void rule__ResultDataReport__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1368:1: ( ( ( rule__ResultDataReport__HeadingAssignment_7_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1369:1: ( ( rule__ResultDataReport__HeadingAssignment_7_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1369:1: ( ( rule__ResultDataReport__HeadingAssignment_7_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1370:1: ( rule__ResultDataReport__HeadingAssignment_7_1 )
            {
             before(grammarAccess.getResultDataReportAccess().getHeadingAssignment_7_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1371:1: ( rule__ResultDataReport__HeadingAssignment_7_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1371:2: rule__ResultDataReport__HeadingAssignment_7_1
            {
            pushFollow(FOLLOW_rule__ResultDataReport__HeadingAssignment_7_1_in_rule__ResultDataReport__Group_7__1__Impl2716);
            rule__ResultDataReport__HeadingAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getResultDataReportAccess().getHeadingAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group_7__1__Impl"


    // $ANTLR start "rule__ResultDataReport__Group_7__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1381:1: rule__ResultDataReport__Group_7__2 : rule__ResultDataReport__Group_7__2__Impl ;
    public final void rule__ResultDataReport__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1385:1: ( rule__ResultDataReport__Group_7__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1386:2: rule__ResultDataReport__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group_7__2__Impl_in_rule__ResultDataReport__Group_7__22746);
            rule__ResultDataReport__Group_7__2__Impl();

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
    // $ANTLR end "rule__ResultDataReport__Group_7__2"


    // $ANTLR start "rule__ResultDataReport__Group_7__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1392:1: rule__ResultDataReport__Group_7__2__Impl : ( ( rule__ResultDataReport__ContentAssignment_7_2 )* ) ;
    public final void rule__ResultDataReport__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1396:1: ( ( ( rule__ResultDataReport__ContentAssignment_7_2 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1397:1: ( ( rule__ResultDataReport__ContentAssignment_7_2 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1397:1: ( ( rule__ResultDataReport__ContentAssignment_7_2 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1398:1: ( rule__ResultDataReport__ContentAssignment_7_2 )*
            {
             before(grammarAccess.getResultDataReportAccess().getContentAssignment_7_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1399:1: ( rule__ResultDataReport__ContentAssignment_7_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==27) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1399:2: rule__ResultDataReport__ContentAssignment_7_2
            	    {
            	    pushFollow(FOLLOW_rule__ResultDataReport__ContentAssignment_7_2_in_rule__ResultDataReport__Group_7__2__Impl2773);
            	    rule__ResultDataReport__ContentAssignment_7_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getResultDataReportAccess().getContentAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group_7__2__Impl"


    // $ANTLR start "rule__ResultDataReport__Group_8__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1415:1: rule__ResultDataReport__Group_8__0 : rule__ResultDataReport__Group_8__0__Impl rule__ResultDataReport__Group_8__1 ;
    public final void rule__ResultDataReport__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1419:1: ( rule__ResultDataReport__Group_8__0__Impl rule__ResultDataReport__Group_8__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1420:2: rule__ResultDataReport__Group_8__0__Impl rule__ResultDataReport__Group_8__1
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group_8__0__Impl_in_rule__ResultDataReport__Group_8__02810);
            rule__ResultDataReport__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultDataReport__Group_8__1_in_rule__ResultDataReport__Group_8__02813);
            rule__ResultDataReport__Group_8__1();

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
    // $ANTLR end "rule__ResultDataReport__Group_8__0"


    // $ANTLR start "rule__ResultDataReport__Group_8__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1427:1: rule__ResultDataReport__Group_8__0__Impl : ( 'results' ) ;
    public final void rule__ResultDataReport__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1431:1: ( ( 'results' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1432:1: ( 'results' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1432:1: ( 'results' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1433:1: 'results'
            {
             before(grammarAccess.getResultDataReportAccess().getResultsKeyword_8_0()); 
            match(input,26,FOLLOW_26_in_rule__ResultDataReport__Group_8__0__Impl2841); 
             after(grammarAccess.getResultDataReportAccess().getResultsKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__Group_8__0__Impl"


    // $ANTLR start "rule__ResultDataReport__Group_8__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1446:1: rule__ResultDataReport__Group_8__1 : rule__ResultDataReport__Group_8__1__Impl ;
    public final void rule__ResultDataReport__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1450:1: ( rule__ResultDataReport__Group_8__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1451:2: rule__ResultDataReport__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultDataReport__Group_8__1__Impl_in_rule__ResultDataReport__Group_8__12872);
            rule__ResultDataReport__Group_8__1__Impl();

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
    // $ANTLR end "rule__ResultDataReport__Group_8__1"


    // $ANTLR start "rule__ResultDataReport__Group_8__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1457:1: rule__ResultDataReport__Group_8__1__Impl : ( ( ( rule__ResultDataReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultDataReport__ResultDataAssignment_8_1 )* ) ) ;
    public final void rule__ResultDataReport__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1461:1: ( ( ( ( rule__ResultDataReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultDataReport__ResultDataAssignment_8_1 )* ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1462:1: ( ( ( rule__ResultDataReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultDataReport__ResultDataAssignment_8_1 )* ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1462:1: ( ( ( rule__ResultDataReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultDataReport__ResultDataAssignment_8_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1463:1: ( ( rule__ResultDataReport__ResultDataAssignment_8_1 ) ) ( ( rule__ResultDataReport__ResultDataAssignment_8_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1463:1: ( ( rule__ResultDataReport__ResultDataAssignment_8_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1464:1: ( rule__ResultDataReport__ResultDataAssignment_8_1 )
            {
             before(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1465:1: ( rule__ResultDataReport__ResultDataAssignment_8_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1465:2: rule__ResultDataReport__ResultDataAssignment_8_1
            {
            pushFollow(FOLLOW_rule__ResultDataReport__ResultDataAssignment_8_1_in_rule__ResultDataReport__Group_8__1__Impl2901);
            rule__ResultDataReport__ResultDataAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); 

            }

            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1468:1: ( ( rule__ResultDataReport__ResultDataAssignment_8_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1469:1: ( rule__ResultDataReport__ResultDataAssignment_8_1 )*
            {
             before(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1470:1: ( rule__ResultDataReport__ResultDataAssignment_8_1 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1470:2: rule__ResultDataReport__ResultDataAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultDataReport__ResultDataAssignment_8_1_in_rule__ResultDataReport__Group_8__1__Impl2913);
            	    rule__ResultDataReport__ResultDataAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getResultDataReportAccess().getResultDataAssignment_8_1()); 

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
    // $ANTLR end "rule__ResultDataReport__Group_8__1__Impl"


    // $ANTLR start "rule__ResultContributor__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1485:1: rule__ResultContributor__Group__0 : rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1 ;
    public final void rule__ResultContributor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1489:1: ( rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1490:2: rule__ResultContributor__Group__0__Impl rule__ResultContributor__Group__1
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__0__Impl_in_rule__ResultContributor__Group__02950);
            rule__ResultContributor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__1_in_rule__ResultContributor__Group__02953);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1497:1: rule__ResultContributor__Group__0__Impl : ( 'contributor' ) ;
    public final void rule__ResultContributor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1501:1: ( ( 'contributor' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1502:1: ( 'contributor' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1502:1: ( 'contributor' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1503:1: 'contributor'
            {
             before(grammarAccess.getResultContributorAccess().getContributorKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__ResultContributor__Group__0__Impl2981); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1516:1: rule__ResultContributor__Group__1 : rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2 ;
    public final void rule__ResultContributor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1520:1: ( rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1521:2: rule__ResultContributor__Group__1__Impl rule__ResultContributor__Group__2
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__1__Impl_in_rule__ResultContributor__Group__13012);
            rule__ResultContributor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__2_in_rule__ResultContributor__Group__13015);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1528:1: rule__ResultContributor__Group__1__Impl : ( ( rule__ResultContributor__TargetAssignment_1 ) ) ;
    public final void rule__ResultContributor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1532:1: ( ( ( rule__ResultContributor__TargetAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1533:1: ( ( rule__ResultContributor__TargetAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1533:1: ( ( rule__ResultContributor__TargetAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1534:1: ( rule__ResultContributor__TargetAssignment_1 )
            {
             before(grammarAccess.getResultContributorAccess().getTargetAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1535:1: ( rule__ResultContributor__TargetAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1535:2: rule__ResultContributor__TargetAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultContributor__TargetAssignment_1_in_rule__ResultContributor__Group__1__Impl3042);
            rule__ResultContributor__TargetAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getResultContributorAccess().getTargetAssignment_1()); 

            }


            }

        }
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1545:1: rule__ResultContributor__Group__2 : rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3 ;
    public final void rule__ResultContributor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1549:1: ( rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1550:2: rule__ResultContributor__Group__2__Impl rule__ResultContributor__Group__3
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__2__Impl_in_rule__ResultContributor__Group__23072);
            rule__ResultContributor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__3_in_rule__ResultContributor__Group__23075);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1557:1: rule__ResultContributor__Group__2__Impl : ( '[' ) ;
    public final void rule__ResultContributor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1561:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1562:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1562:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1563:1: '['
            {
             before(grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_2()); 
            match(input,20,FOLLOW_20_in_rule__ResultContributor__Group__2__Impl3103); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1576:1: rule__ResultContributor__Group__3 : rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4 ;
    public final void rule__ResultContributor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1580:1: ( rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1581:2: rule__ResultContributor__Group__3__Impl rule__ResultContributor__Group__4
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__3__Impl_in_rule__ResultContributor__Group__33134);
            rule__ResultContributor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__4_in_rule__ResultContributor__Group__33137);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1588:1: rule__ResultContributor__Group__3__Impl : ( ( rule__ResultContributor__Group_3__0 )? ) ;
    public final void rule__ResultContributor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1592:1: ( ( ( rule__ResultContributor__Group_3__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1593:1: ( ( rule__ResultContributor__Group_3__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1593:1: ( ( rule__ResultContributor__Group_3__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1594:1: ( rule__ResultContributor__Group_3__0 )?
            {
             before(grammarAccess.getResultContributorAccess().getGroup_3()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1595:1: ( rule__ResultContributor__Group_3__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1595:2: rule__ResultContributor__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ResultContributor__Group_3__0_in_rule__ResultContributor__Group__3__Impl3164);
                    rule__ResultContributor__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResultContributorAccess().getGroup_3()); 

            }


            }

        }
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1605:1: rule__ResultContributor__Group__4 : rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5 ;
    public final void rule__ResultContributor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1609:1: ( rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1610:2: rule__ResultContributor__Group__4__Impl rule__ResultContributor__Group__5
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__4__Impl_in_rule__ResultContributor__Group__43195);
            rule__ResultContributor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__5_in_rule__ResultContributor__Group__43198);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1617:1: rule__ResultContributor__Group__4__Impl : ( ( rule__ResultContributor__IssuesAssignment_4 )* ) ;
    public final void rule__ResultContributor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1621:1: ( ( ( rule__ResultContributor__IssuesAssignment_4 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1622:1: ( ( rule__ResultContributor__IssuesAssignment_4 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1622:1: ( ( rule__ResultContributor__IssuesAssignment_4 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1623:1: ( rule__ResultContributor__IssuesAssignment_4 )*
            {
             before(grammarAccess.getResultContributorAccess().getIssuesAssignment_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1624:1: ( rule__ResultContributor__IssuesAssignment_4 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==29) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1624:2: rule__ResultContributor__IssuesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__IssuesAssignment_4_in_rule__ResultContributor__Group__4__Impl3225);
            	    rule__ResultContributor__IssuesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getResultContributorAccess().getIssuesAssignment_4()); 

            }


            }

        }
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1634:1: rule__ResultContributor__Group__5 : rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6 ;
    public final void rule__ResultContributor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1638:1: ( rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1639:2: rule__ResultContributor__Group__5__Impl rule__ResultContributor__Group__6
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__5__Impl_in_rule__ResultContributor__Group__53256);
            rule__ResultContributor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group__6_in_rule__ResultContributor__Group__53259);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1646:1: rule__ResultContributor__Group__5__Impl : ( ( rule__ResultContributor__SubcontributorAssignment_5 )* ) ;
    public final void rule__ResultContributor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1650:1: ( ( ( rule__ResultContributor__SubcontributorAssignment_5 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1651:1: ( ( rule__ResultContributor__SubcontributorAssignment_5 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1651:1: ( ( rule__ResultContributor__SubcontributorAssignment_5 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1652:1: ( rule__ResultContributor__SubcontributorAssignment_5 )*
            {
             before(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1653:1: ( rule__ResultContributor__SubcontributorAssignment_5 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==27) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1653:2: rule__ResultContributor__SubcontributorAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__SubcontributorAssignment_5_in_rule__ResultContributor__Group__5__Impl3286);
            	    rule__ResultContributor__SubcontributorAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getResultContributorAccess().getSubcontributorAssignment_5()); 

            }


            }

        }
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1663:1: rule__ResultContributor__Group__6 : rule__ResultContributor__Group__6__Impl ;
    public final void rule__ResultContributor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1667:1: ( rule__ResultContributor__Group__6__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1668:2: rule__ResultContributor__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group__6__Impl_in_rule__ResultContributor__Group__63317);
            rule__ResultContributor__Group__6__Impl();

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1674:1: rule__ResultContributor__Group__6__Impl : ( ']' ) ;
    public final void rule__ResultContributor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1678:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1679:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1679:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1680:1: ']'
            {
             before(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_6()); 
            match(input,21,FOLLOW_21_in_rule__ResultContributor__Group__6__Impl3345); 
             after(grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_6()); 

            }


            }

        }
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


    // $ANTLR start "rule__ResultContributor__Group_3__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1707:1: rule__ResultContributor__Group_3__0 : rule__ResultContributor__Group_3__0__Impl rule__ResultContributor__Group_3__1 ;
    public final void rule__ResultContributor__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1711:1: ( rule__ResultContributor__Group_3__0__Impl rule__ResultContributor__Group_3__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1712:2: rule__ResultContributor__Group_3__0__Impl rule__ResultContributor__Group_3__1
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group_3__0__Impl_in_rule__ResultContributor__Group_3__03390);
            rule__ResultContributor__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultContributor__Group_3__1_in_rule__ResultContributor__Group_3__03393);
            rule__ResultContributor__Group_3__1();

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
    // $ANTLR end "rule__ResultContributor__Group_3__0"


    // $ANTLR start "rule__ResultContributor__Group_3__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1719:1: rule__ResultContributor__Group_3__0__Impl : ( 'results' ) ;
    public final void rule__ResultContributor__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1723:1: ( ( 'results' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1724:1: ( 'results' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1724:1: ( 'results' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1725:1: 'results'
            {
             before(grammarAccess.getResultContributorAccess().getResultsKeyword_3_0()); 
            match(input,26,FOLLOW_26_in_rule__ResultContributor__Group_3__0__Impl3421); 
             after(grammarAccess.getResultContributorAccess().getResultsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__Group_3__0__Impl"


    // $ANTLR start "rule__ResultContributor__Group_3__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1738:1: rule__ResultContributor__Group_3__1 : rule__ResultContributor__Group_3__1__Impl ;
    public final void rule__ResultContributor__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1742:1: ( rule__ResultContributor__Group_3__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1743:2: rule__ResultContributor__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultContributor__Group_3__1__Impl_in_rule__ResultContributor__Group_3__13452);
            rule__ResultContributor__Group_3__1__Impl();

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
    // $ANTLR end "rule__ResultContributor__Group_3__1"


    // $ANTLR start "rule__ResultContributor__Group_3__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1749:1: rule__ResultContributor__Group_3__1__Impl : ( ( ( rule__ResultContributor__ResultDataAssignment_3_1 ) ) ( ( rule__ResultContributor__ResultDataAssignment_3_1 )* ) ) ;
    public final void rule__ResultContributor__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1753:1: ( ( ( ( rule__ResultContributor__ResultDataAssignment_3_1 ) ) ( ( rule__ResultContributor__ResultDataAssignment_3_1 )* ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1754:1: ( ( ( rule__ResultContributor__ResultDataAssignment_3_1 ) ) ( ( rule__ResultContributor__ResultDataAssignment_3_1 )* ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1754:1: ( ( ( rule__ResultContributor__ResultDataAssignment_3_1 ) ) ( ( rule__ResultContributor__ResultDataAssignment_3_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1755:1: ( ( rule__ResultContributor__ResultDataAssignment_3_1 ) ) ( ( rule__ResultContributor__ResultDataAssignment_3_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1755:1: ( ( rule__ResultContributor__ResultDataAssignment_3_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1756:1: ( rule__ResultContributor__ResultDataAssignment_3_1 )
            {
             before(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1757:1: ( rule__ResultContributor__ResultDataAssignment_3_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1757:2: rule__ResultContributor__ResultDataAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ResultContributor__ResultDataAssignment_3_1_in_rule__ResultContributor__Group_3__1__Impl3481);
            rule__ResultContributor__ResultDataAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); 

            }

            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1760:1: ( ( rule__ResultContributor__ResultDataAssignment_3_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1761:1: ( rule__ResultContributor__ResultDataAssignment_3_1 )*
            {
             before(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1762:1: ( rule__ResultContributor__ResultDataAssignment_3_1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1762:2: rule__ResultContributor__ResultDataAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultContributor__ResultDataAssignment_3_1_in_rule__ResultContributor__Group_3__1__Impl3493);
            	    rule__ResultContributor__ResultDataAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getResultContributorAccess().getResultDataAssignment_3_1()); 

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
    // $ANTLR end "rule__ResultContributor__Group_3__1__Impl"


    // $ANTLR start "rule__IssuesReport__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1777:1: rule__IssuesReport__Group__0 : rule__IssuesReport__Group__0__Impl rule__IssuesReport__Group__1 ;
    public final void rule__IssuesReport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1781:1: ( rule__IssuesReport__Group__0__Impl rule__IssuesReport__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1782:2: rule__IssuesReport__Group__0__Impl rule__IssuesReport__Group__1
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__0__Impl_in_rule__IssuesReport__Group__03530);
            rule__IssuesReport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__1_in_rule__IssuesReport__Group__03533);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1789:1: rule__IssuesReport__Group__0__Impl : ( 'issues' ) ;
    public final void rule__IssuesReport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1793:1: ( ( 'issues' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1794:1: ( 'issues' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1794:1: ( 'issues' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1795:1: 'issues'
            {
             before(grammarAccess.getIssuesReportAccess().getIssuesKeyword_0()); 
            match(input,28,FOLLOW_28_in_rule__IssuesReport__Group__0__Impl3561); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1808:1: rule__IssuesReport__Group__1 : rule__IssuesReport__Group__1__Impl rule__IssuesReport__Group__2 ;
    public final void rule__IssuesReport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1812:1: ( rule__IssuesReport__Group__1__Impl rule__IssuesReport__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1813:2: rule__IssuesReport__Group__1__Impl rule__IssuesReport__Group__2
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__1__Impl_in_rule__IssuesReport__Group__13592);
            rule__IssuesReport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__2_in_rule__IssuesReport__Group__13595);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1820:1: rule__IssuesReport__Group__1__Impl : ( ( rule__IssuesReport__NameAssignment_1 ) ) ;
    public final void rule__IssuesReport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1824:1: ( ( ( rule__IssuesReport__NameAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1825:1: ( ( rule__IssuesReport__NameAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1825:1: ( ( rule__IssuesReport__NameAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1826:1: ( rule__IssuesReport__NameAssignment_1 )
            {
             before(grammarAccess.getIssuesReportAccess().getNameAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1827:1: ( rule__IssuesReport__NameAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1827:2: rule__IssuesReport__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__IssuesReport__NameAssignment_1_in_rule__IssuesReport__Group__1__Impl3622);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1837:1: rule__IssuesReport__Group__2 : rule__IssuesReport__Group__2__Impl rule__IssuesReport__Group__3 ;
    public final void rule__IssuesReport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1841:1: ( rule__IssuesReport__Group__2__Impl rule__IssuesReport__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1842:2: rule__IssuesReport__Group__2__Impl rule__IssuesReport__Group__3
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__2__Impl_in_rule__IssuesReport__Group__23652);
            rule__IssuesReport__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group__3_in_rule__IssuesReport__Group__23655);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1849:1: rule__IssuesReport__Group__2__Impl : ( ( rule__IssuesReport__Group_2__0 )? ) ;
    public final void rule__IssuesReport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1853:1: ( ( ( rule__IssuesReport__Group_2__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1854:1: ( ( rule__IssuesReport__Group_2__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1854:1: ( ( rule__IssuesReport__Group_2__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1855:1: ( rule__IssuesReport__Group_2__0 )?
            {
             before(grammarAccess.getIssuesReportAccess().getGroup_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1856:1: ( rule__IssuesReport__Group_2__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==19) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1856:2: rule__IssuesReport__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__IssuesReport__Group_2__0_in_rule__IssuesReport__Group__2__Impl3682);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1866:1: rule__IssuesReport__Group__3 : rule__IssuesReport__Group__3__Impl ;
    public final void rule__IssuesReport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1870:1: ( rule__IssuesReport__Group__3__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1871:2: rule__IssuesReport__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group__3__Impl_in_rule__IssuesReport__Group__33713);
            rule__IssuesReport__Group__3__Impl();

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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1877:1: rule__IssuesReport__Group__3__Impl : ( ( rule__IssuesReport__Group_3__0 )? ) ;
    public final void rule__IssuesReport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1881:1: ( ( ( rule__IssuesReport__Group_3__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1882:1: ( ( rule__IssuesReport__Group_3__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1882:1: ( ( rule__IssuesReport__Group_3__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1883:1: ( rule__IssuesReport__Group_3__0 )?
            {
             before(grammarAccess.getIssuesReportAccess().getGroup_3()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1884:1: ( rule__IssuesReport__Group_3__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==20) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1884:2: rule__IssuesReport__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__IssuesReport__Group_3__0_in_rule__IssuesReport__Group__3__Impl3740);
                    rule__IssuesReport__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIssuesReportAccess().getGroup_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__IssuesReport__Group_2__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1902:1: rule__IssuesReport__Group_2__0 : rule__IssuesReport__Group_2__0__Impl rule__IssuesReport__Group_2__1 ;
    public final void rule__IssuesReport__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1906:1: ( rule__IssuesReport__Group_2__0__Impl rule__IssuesReport__Group_2__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1907:2: rule__IssuesReport__Group_2__0__Impl rule__IssuesReport__Group_2__1
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_2__0__Impl_in_rule__IssuesReport__Group_2__03779);
            rule__IssuesReport__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group_2__1_in_rule__IssuesReport__Group_2__03782);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1914:1: rule__IssuesReport__Group_2__0__Impl : ( 'for' ) ;
    public final void rule__IssuesReport__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1918:1: ( ( 'for' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1919:1: ( 'for' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1919:1: ( 'for' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1920:1: 'for'
            {
             before(grammarAccess.getIssuesReportAccess().getForKeyword_2_0()); 
            match(input,19,FOLLOW_19_in_rule__IssuesReport__Group_2__0__Impl3810); 
             after(grammarAccess.getIssuesReportAccess().getForKeyword_2_0()); 

            }


            }

        }
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1933:1: rule__IssuesReport__Group_2__1 : rule__IssuesReport__Group_2__1__Impl ;
    public final void rule__IssuesReport__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1937:1: ( rule__IssuesReport__Group_2__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1938:2: rule__IssuesReport__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_2__1__Impl_in_rule__IssuesReport__Group_2__13841);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1944:1: rule__IssuesReport__Group_2__1__Impl : ( ( rule__IssuesReport__TargetAssignment_2_1 ) ) ;
    public final void rule__IssuesReport__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1948:1: ( ( ( rule__IssuesReport__TargetAssignment_2_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1949:1: ( ( rule__IssuesReport__TargetAssignment_2_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1949:1: ( ( rule__IssuesReport__TargetAssignment_2_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1950:1: ( rule__IssuesReport__TargetAssignment_2_1 )
            {
             before(grammarAccess.getIssuesReportAccess().getTargetAssignment_2_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1951:1: ( rule__IssuesReport__TargetAssignment_2_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1951:2: rule__IssuesReport__TargetAssignment_2_1
            {
            pushFollow(FOLLOW_rule__IssuesReport__TargetAssignment_2_1_in_rule__IssuesReport__Group_2__1__Impl3868);
            rule__IssuesReport__TargetAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getIssuesReportAccess().getTargetAssignment_2_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__IssuesReport__Group_3__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1965:1: rule__IssuesReport__Group_3__0 : rule__IssuesReport__Group_3__0__Impl rule__IssuesReport__Group_3__1 ;
    public final void rule__IssuesReport__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1969:1: ( rule__IssuesReport__Group_3__0__Impl rule__IssuesReport__Group_3__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1970:2: rule__IssuesReport__Group_3__0__Impl rule__IssuesReport__Group_3__1
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_3__0__Impl_in_rule__IssuesReport__Group_3__03902);
            rule__IssuesReport__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group_3__1_in_rule__IssuesReport__Group_3__03905);
            rule__IssuesReport__Group_3__1();

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
    // $ANTLR end "rule__IssuesReport__Group_3__0"


    // $ANTLR start "rule__IssuesReport__Group_3__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1977:1: rule__IssuesReport__Group_3__0__Impl : ( '[' ) ;
    public final void rule__IssuesReport__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1981:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1982:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1982:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1983:1: '['
            {
             before(grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3_0()); 
            match(input,20,FOLLOW_20_in_rule__IssuesReport__Group_3__0__Impl3933); 
             after(grammarAccess.getIssuesReportAccess().getLeftSquareBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssuesReport__Group_3__0__Impl"


    // $ANTLR start "rule__IssuesReport__Group_3__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:1996:1: rule__IssuesReport__Group_3__1 : rule__IssuesReport__Group_3__1__Impl rule__IssuesReport__Group_3__2 ;
    public final void rule__IssuesReport__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2000:1: ( rule__IssuesReport__Group_3__1__Impl rule__IssuesReport__Group_3__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2001:2: rule__IssuesReport__Group_3__1__Impl rule__IssuesReport__Group_3__2
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_3__1__Impl_in_rule__IssuesReport__Group_3__13964);
            rule__IssuesReport__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group_3__2_in_rule__IssuesReport__Group_3__13967);
            rule__IssuesReport__Group_3__2();

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
    // $ANTLR end "rule__IssuesReport__Group_3__1"


    // $ANTLR start "rule__IssuesReport__Group_3__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2008:1: rule__IssuesReport__Group_3__1__Impl : ( ( rule__IssuesReport__Group_3_1__0 )? ) ;
    public final void rule__IssuesReport__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2012:1: ( ( ( rule__IssuesReport__Group_3_1__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2013:1: ( ( rule__IssuesReport__Group_3_1__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2013:1: ( ( rule__IssuesReport__Group_3_1__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2014:1: ( rule__IssuesReport__Group_3_1__0 )?
            {
             before(grammarAccess.getIssuesReportAccess().getGroup_3_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2015:1: ( rule__IssuesReport__Group_3_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==23) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2015:2: rule__IssuesReport__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__IssuesReport__Group_3_1__0_in_rule__IssuesReport__Group_3__1__Impl3994);
                    rule__IssuesReport__Group_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIssuesReportAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssuesReport__Group_3__1__Impl"


    // $ANTLR start "rule__IssuesReport__Group_3__2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2025:1: rule__IssuesReport__Group_3__2 : rule__IssuesReport__Group_3__2__Impl rule__IssuesReport__Group_3__3 ;
    public final void rule__IssuesReport__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2029:1: ( rule__IssuesReport__Group_3__2__Impl rule__IssuesReport__Group_3__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2030:2: rule__IssuesReport__Group_3__2__Impl rule__IssuesReport__Group_3__3
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_3__2__Impl_in_rule__IssuesReport__Group_3__24025);
            rule__IssuesReport__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group_3__3_in_rule__IssuesReport__Group_3__24028);
            rule__IssuesReport__Group_3__3();

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
    // $ANTLR end "rule__IssuesReport__Group_3__2"


    // $ANTLR start "rule__IssuesReport__Group_3__2__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2037:1: rule__IssuesReport__Group_3__2__Impl : ( ( rule__IssuesReport__IssuesAssignment_3_2 )* ) ;
    public final void rule__IssuesReport__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2041:1: ( ( ( rule__IssuesReport__IssuesAssignment_3_2 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2042:1: ( ( rule__IssuesReport__IssuesAssignment_3_2 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2042:1: ( ( rule__IssuesReport__IssuesAssignment_3_2 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2043:1: ( rule__IssuesReport__IssuesAssignment_3_2 )*
            {
             before(grammarAccess.getIssuesReportAccess().getIssuesAssignment_3_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2044:1: ( rule__IssuesReport__IssuesAssignment_3_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==29) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2044:2: rule__IssuesReport__IssuesAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_rule__IssuesReport__IssuesAssignment_3_2_in_rule__IssuesReport__Group_3__2__Impl4055);
            	    rule__IssuesReport__IssuesAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getIssuesReportAccess().getIssuesAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssuesReport__Group_3__2__Impl"


    // $ANTLR start "rule__IssuesReport__Group_3__3"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2054:1: rule__IssuesReport__Group_3__3 : rule__IssuesReport__Group_3__3__Impl ;
    public final void rule__IssuesReport__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2058:1: ( rule__IssuesReport__Group_3__3__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2059:2: rule__IssuesReport__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_3__3__Impl_in_rule__IssuesReport__Group_3__34086);
            rule__IssuesReport__Group_3__3__Impl();

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
    // $ANTLR end "rule__IssuesReport__Group_3__3"


    // $ANTLR start "rule__IssuesReport__Group_3__3__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2065:1: rule__IssuesReport__Group_3__3__Impl : ( ']' ) ;
    public final void rule__IssuesReport__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2069:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2070:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2070:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2071:1: ']'
            {
             before(grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_3_3()); 
            match(input,21,FOLLOW_21_in_rule__IssuesReport__Group_3__3__Impl4114); 
             after(grammarAccess.getIssuesReportAccess().getRightSquareBracketKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssuesReport__Group_3__3__Impl"


    // $ANTLR start "rule__IssuesReport__Group_3_1__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2092:1: rule__IssuesReport__Group_3_1__0 : rule__IssuesReport__Group_3_1__0__Impl rule__IssuesReport__Group_3_1__1 ;
    public final void rule__IssuesReport__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2096:1: ( rule__IssuesReport__Group_3_1__0__Impl rule__IssuesReport__Group_3_1__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2097:2: rule__IssuesReport__Group_3_1__0__Impl rule__IssuesReport__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_3_1__0__Impl_in_rule__IssuesReport__Group_3_1__04153);
            rule__IssuesReport__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IssuesReport__Group_3_1__1_in_rule__IssuesReport__Group_3_1__04156);
            rule__IssuesReport__Group_3_1__1();

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
    // $ANTLR end "rule__IssuesReport__Group_3_1__0"


    // $ANTLR start "rule__IssuesReport__Group_3_1__0__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2104:1: rule__IssuesReport__Group_3_1__0__Impl : ( 'description' ) ;
    public final void rule__IssuesReport__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2108:1: ( ( 'description' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2109:1: ( 'description' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2109:1: ( 'description' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2110:1: 'description'
            {
             before(grammarAccess.getIssuesReportAccess().getDescriptionKeyword_3_1_0()); 
            match(input,23,FOLLOW_23_in_rule__IssuesReport__Group_3_1__0__Impl4184); 
             after(grammarAccess.getIssuesReportAccess().getDescriptionKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssuesReport__Group_3_1__0__Impl"


    // $ANTLR start "rule__IssuesReport__Group_3_1__1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2123:1: rule__IssuesReport__Group_3_1__1 : rule__IssuesReport__Group_3_1__1__Impl ;
    public final void rule__IssuesReport__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2127:1: ( rule__IssuesReport__Group_3_1__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2128:2: rule__IssuesReport__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__IssuesReport__Group_3_1__1__Impl_in_rule__IssuesReport__Group_3_1__14215);
            rule__IssuesReport__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__IssuesReport__Group_3_1__1"


    // $ANTLR start "rule__IssuesReport__Group_3_1__1__Impl"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2134:1: rule__IssuesReport__Group_3_1__1__Impl : ( ( rule__IssuesReport__DescriptionAssignment_3_1_1 ) ) ;
    public final void rule__IssuesReport__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2138:1: ( ( ( rule__IssuesReport__DescriptionAssignment_3_1_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2139:1: ( ( rule__IssuesReport__DescriptionAssignment_3_1_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2139:1: ( ( rule__IssuesReport__DescriptionAssignment_3_1_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2140:1: ( rule__IssuesReport__DescriptionAssignment_3_1_1 )
            {
             before(grammarAccess.getIssuesReportAccess().getDescriptionAssignment_3_1_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2141:1: ( rule__IssuesReport__DescriptionAssignment_3_1_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2141:2: rule__IssuesReport__DescriptionAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__IssuesReport__DescriptionAssignment_3_1_1_in_rule__IssuesReport__Group_3_1__1__Impl4242);
            rule__IssuesReport__DescriptionAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getIssuesReportAccess().getDescriptionAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssuesReport__Group_3_1__1__Impl"


    // $ANTLR start "rule__ResultIssue__Group__0"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2155:1: rule__ResultIssue__Group__0 : rule__ResultIssue__Group__0__Impl rule__ResultIssue__Group__1 ;
    public final void rule__ResultIssue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2159:1: ( rule__ResultIssue__Group__0__Impl rule__ResultIssue__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2160:2: rule__ResultIssue__Group__0__Impl rule__ResultIssue__Group__1
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__0__Impl_in_rule__ResultIssue__Group__04276);
            rule__ResultIssue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group__1_in_rule__ResultIssue__Group__04279);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2167:1: rule__ResultIssue__Group__0__Impl : ( 'issue' ) ;
    public final void rule__ResultIssue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2171:1: ( ( 'issue' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2172:1: ( 'issue' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2172:1: ( 'issue' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2173:1: 'issue'
            {
             before(grammarAccess.getResultIssueAccess().getIssueKeyword_0()); 
            match(input,29,FOLLOW_29_in_rule__ResultIssue__Group__0__Impl4307); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2186:1: rule__ResultIssue__Group__1 : rule__ResultIssue__Group__1__Impl rule__ResultIssue__Group__2 ;
    public final void rule__ResultIssue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2190:1: ( rule__ResultIssue__Group__1__Impl rule__ResultIssue__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2191:2: rule__ResultIssue__Group__1__Impl rule__ResultIssue__Group__2
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__1__Impl_in_rule__ResultIssue__Group__14338);
            rule__ResultIssue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group__2_in_rule__ResultIssue__Group__14341);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2198:1: rule__ResultIssue__Group__1__Impl : ( ( rule__ResultIssue__IssueTypeAssignment_1 ) ) ;
    public final void rule__ResultIssue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2202:1: ( ( ( rule__ResultIssue__IssueTypeAssignment_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2203:1: ( ( rule__ResultIssue__IssueTypeAssignment_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2203:1: ( ( rule__ResultIssue__IssueTypeAssignment_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2204:1: ( rule__ResultIssue__IssueTypeAssignment_1 )
            {
             before(grammarAccess.getResultIssueAccess().getIssueTypeAssignment_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2205:1: ( rule__ResultIssue__IssueTypeAssignment_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2205:2: rule__ResultIssue__IssueTypeAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultIssue__IssueTypeAssignment_1_in_rule__ResultIssue__Group__1__Impl4368);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2215:1: rule__ResultIssue__Group__2 : rule__ResultIssue__Group__2__Impl rule__ResultIssue__Group__3 ;
    public final void rule__ResultIssue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2219:1: ( rule__ResultIssue__Group__2__Impl rule__ResultIssue__Group__3 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2220:2: rule__ResultIssue__Group__2__Impl rule__ResultIssue__Group__3
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__2__Impl_in_rule__ResultIssue__Group__24398);
            rule__ResultIssue__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group__3_in_rule__ResultIssue__Group__24401);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2227:1: rule__ResultIssue__Group__2__Impl : ( ( rule__ResultIssue__MessageAssignment_2 ) ) ;
    public final void rule__ResultIssue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2231:1: ( ( ( rule__ResultIssue__MessageAssignment_2 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2232:1: ( ( rule__ResultIssue__MessageAssignment_2 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2232:1: ( ( rule__ResultIssue__MessageAssignment_2 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2233:1: ( rule__ResultIssue__MessageAssignment_2 )
            {
             before(grammarAccess.getResultIssueAccess().getMessageAssignment_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2234:1: ( rule__ResultIssue__MessageAssignment_2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2234:2: rule__ResultIssue__MessageAssignment_2
            {
            pushFollow(FOLLOW_rule__ResultIssue__MessageAssignment_2_in_rule__ResultIssue__Group__2__Impl4428);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2244:1: rule__ResultIssue__Group__3 : rule__ResultIssue__Group__3__Impl rule__ResultIssue__Group__4 ;
    public final void rule__ResultIssue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2248:1: ( rule__ResultIssue__Group__3__Impl rule__ResultIssue__Group__4 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2249:2: rule__ResultIssue__Group__3__Impl rule__ResultIssue__Group__4
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__3__Impl_in_rule__ResultIssue__Group__34458);
            rule__ResultIssue__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group__4_in_rule__ResultIssue__Group__34461);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2256:1: rule__ResultIssue__Group__3__Impl : ( ( rule__ResultIssue__Group_3__0 )? ) ;
    public final void rule__ResultIssue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2260:1: ( ( ( rule__ResultIssue__Group_3__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2261:1: ( ( rule__ResultIssue__Group_3__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2261:1: ( ( rule__ResultIssue__Group_3__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2262:1: ( rule__ResultIssue__Group_3__0 )?
            {
             before(grammarAccess.getResultIssueAccess().getGroup_3()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2263:1: ( rule__ResultIssue__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2263:2: rule__ResultIssue__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ResultIssue__Group_3__0_in_rule__ResultIssue__Group__3__Impl4488);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2273:1: rule__ResultIssue__Group__4 : rule__ResultIssue__Group__4__Impl rule__ResultIssue__Group__5 ;
    public final void rule__ResultIssue__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2277:1: ( rule__ResultIssue__Group__4__Impl rule__ResultIssue__Group__5 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2278:2: rule__ResultIssue__Group__4__Impl rule__ResultIssue__Group__5
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__4__Impl_in_rule__ResultIssue__Group__44519);
            rule__ResultIssue__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group__5_in_rule__ResultIssue__Group__44522);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2285:1: rule__ResultIssue__Group__4__Impl : ( ( rule__ResultIssue__Group_4__0 )? ) ;
    public final void rule__ResultIssue__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2289:1: ( ( ( rule__ResultIssue__Group_4__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2290:1: ( ( rule__ResultIssue__Group_4__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2290:1: ( ( rule__ResultIssue__Group_4__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2291:1: ( rule__ResultIssue__Group_4__0 )?
            {
             before(grammarAccess.getResultIssueAccess().getGroup_4()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2292:1: ( rule__ResultIssue__Group_4__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2292:2: rule__ResultIssue__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__ResultIssue__Group_4__0_in_rule__ResultIssue__Group__4__Impl4549);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2302:1: rule__ResultIssue__Group__5 : rule__ResultIssue__Group__5__Impl ;
    public final void rule__ResultIssue__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2306:1: ( rule__ResultIssue__Group__5__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2307:2: rule__ResultIssue__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group__5__Impl_in_rule__ResultIssue__Group__54580);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2313:1: rule__ResultIssue__Group__5__Impl : ( ( rule__ResultIssue__Group_5__0 )? ) ;
    public final void rule__ResultIssue__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2317:1: ( ( ( rule__ResultIssue__Group_5__0 )? ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2318:1: ( ( rule__ResultIssue__Group_5__0 )? )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2318:1: ( ( rule__ResultIssue__Group_5__0 )? )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2319:1: ( rule__ResultIssue__Group_5__0 )?
            {
             before(grammarAccess.getResultIssueAccess().getGroup_5()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2320:1: ( rule__ResultIssue__Group_5__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==20) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2320:2: rule__ResultIssue__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__ResultIssue__Group_5__0_in_rule__ResultIssue__Group__5__Impl4607);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2342:1: rule__ResultIssue__Group_3__0 : rule__ResultIssue__Group_3__0__Impl rule__ResultIssue__Group_3__1 ;
    public final void rule__ResultIssue__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2346:1: ( rule__ResultIssue__Group_3__0__Impl rule__ResultIssue__Group_3__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2347:2: rule__ResultIssue__Group_3__0__Impl rule__ResultIssue__Group_3__1
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_3__0__Impl_in_rule__ResultIssue__Group_3__04650);
            rule__ResultIssue__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group_3__1_in_rule__ResultIssue__Group_3__04653);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2354:1: rule__ResultIssue__Group_3__0__Impl : ( 'target' ) ;
    public final void rule__ResultIssue__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2358:1: ( ( 'target' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2359:1: ( 'target' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2359:1: ( 'target' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2360:1: 'target'
            {
             before(grammarAccess.getResultIssueAccess().getTargetKeyword_3_0()); 
            match(input,30,FOLLOW_30_in_rule__ResultIssue__Group_3__0__Impl4681); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2373:1: rule__ResultIssue__Group_3__1 : rule__ResultIssue__Group_3__1__Impl ;
    public final void rule__ResultIssue__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2377:1: ( rule__ResultIssue__Group_3__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2378:2: rule__ResultIssue__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_3__1__Impl_in_rule__ResultIssue__Group_3__14712);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2384:1: rule__ResultIssue__Group_3__1__Impl : ( ( rule__ResultIssue__TargetAssignment_3_1 ) ) ;
    public final void rule__ResultIssue__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2388:1: ( ( ( rule__ResultIssue__TargetAssignment_3_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2389:1: ( ( rule__ResultIssue__TargetAssignment_3_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2389:1: ( ( rule__ResultIssue__TargetAssignment_3_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2390:1: ( rule__ResultIssue__TargetAssignment_3_1 )
            {
             before(grammarAccess.getResultIssueAccess().getTargetAssignment_3_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2391:1: ( rule__ResultIssue__TargetAssignment_3_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2391:2: rule__ResultIssue__TargetAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ResultIssue__TargetAssignment_3_1_in_rule__ResultIssue__Group_3__1__Impl4739);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2405:1: rule__ResultIssue__Group_4__0 : rule__ResultIssue__Group_4__0__Impl rule__ResultIssue__Group_4__1 ;
    public final void rule__ResultIssue__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2409:1: ( rule__ResultIssue__Group_4__0__Impl rule__ResultIssue__Group_4__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2410:2: rule__ResultIssue__Group_4__0__Impl rule__ResultIssue__Group_4__1
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_4__0__Impl_in_rule__ResultIssue__Group_4__04773);
            rule__ResultIssue__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group_4__1_in_rule__ResultIssue__Group_4__04776);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2417:1: rule__ResultIssue__Group_4__0__Impl : ( 'exception' ) ;
    public final void rule__ResultIssue__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2421:1: ( ( 'exception' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2422:1: ( 'exception' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2422:1: ( 'exception' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2423:1: 'exception'
            {
             before(grammarAccess.getResultIssueAccess().getExceptionKeyword_4_0()); 
            match(input,31,FOLLOW_31_in_rule__ResultIssue__Group_4__0__Impl4804); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2436:1: rule__ResultIssue__Group_4__1 : rule__ResultIssue__Group_4__1__Impl ;
    public final void rule__ResultIssue__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2440:1: ( rule__ResultIssue__Group_4__1__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2441:2: rule__ResultIssue__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_4__1__Impl_in_rule__ResultIssue__Group_4__14835);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2447:1: rule__ResultIssue__Group_4__1__Impl : ( ( rule__ResultIssue__ExceptionTypeAssignment_4_1 ) ) ;
    public final void rule__ResultIssue__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2451:1: ( ( ( rule__ResultIssue__ExceptionTypeAssignment_4_1 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2452:1: ( ( rule__ResultIssue__ExceptionTypeAssignment_4_1 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2452:1: ( ( rule__ResultIssue__ExceptionTypeAssignment_4_1 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2453:1: ( rule__ResultIssue__ExceptionTypeAssignment_4_1 )
            {
             before(grammarAccess.getResultIssueAccess().getExceptionTypeAssignment_4_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2454:1: ( rule__ResultIssue__ExceptionTypeAssignment_4_1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2454:2: rule__ResultIssue__ExceptionTypeAssignment_4_1
            {
            pushFollow(FOLLOW_rule__ResultIssue__ExceptionTypeAssignment_4_1_in_rule__ResultIssue__Group_4__1__Impl4862);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2468:1: rule__ResultIssue__Group_5__0 : rule__ResultIssue__Group_5__0__Impl rule__ResultIssue__Group_5__1 ;
    public final void rule__ResultIssue__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2472:1: ( rule__ResultIssue__Group_5__0__Impl rule__ResultIssue__Group_5__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2473:2: rule__ResultIssue__Group_5__0__Impl rule__ResultIssue__Group_5__1
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_5__0__Impl_in_rule__ResultIssue__Group_5__04896);
            rule__ResultIssue__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group_5__1_in_rule__ResultIssue__Group_5__04899);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2480:1: rule__ResultIssue__Group_5__0__Impl : ( '[' ) ;
    public final void rule__ResultIssue__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2484:1: ( ( '[' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2485:1: ( '[' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2485:1: ( '[' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2486:1: '['
            {
             before(grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0()); 
            match(input,20,FOLLOW_20_in_rule__ResultIssue__Group_5__0__Impl4927); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2499:1: rule__ResultIssue__Group_5__1 : rule__ResultIssue__Group_5__1__Impl rule__ResultIssue__Group_5__2 ;
    public final void rule__ResultIssue__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2503:1: ( rule__ResultIssue__Group_5__1__Impl rule__ResultIssue__Group_5__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2504:2: rule__ResultIssue__Group_5__1__Impl rule__ResultIssue__Group_5__2
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_5__1__Impl_in_rule__ResultIssue__Group_5__14958);
            rule__ResultIssue__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultIssue__Group_5__2_in_rule__ResultIssue__Group_5__14961);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2511:1: rule__ResultIssue__Group_5__1__Impl : ( ( rule__ResultIssue__IssuesAssignment_5_1 )* ) ;
    public final void rule__ResultIssue__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2515:1: ( ( ( rule__ResultIssue__IssuesAssignment_5_1 )* ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2516:1: ( ( rule__ResultIssue__IssuesAssignment_5_1 )* )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2516:1: ( ( rule__ResultIssue__IssuesAssignment_5_1 )* )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2517:1: ( rule__ResultIssue__IssuesAssignment_5_1 )*
            {
             before(grammarAccess.getResultIssueAccess().getIssuesAssignment_5_1()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2518:1: ( rule__ResultIssue__IssuesAssignment_5_1 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==29) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2518:2: rule__ResultIssue__IssuesAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_rule__ResultIssue__IssuesAssignment_5_1_in_rule__ResultIssue__Group_5__1__Impl4988);
            	    rule__ResultIssue__IssuesAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2528:1: rule__ResultIssue__Group_5__2 : rule__ResultIssue__Group_5__2__Impl ;
    public final void rule__ResultIssue__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2532:1: ( rule__ResultIssue__Group_5__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2533:2: rule__ResultIssue__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultIssue__Group_5__2__Impl_in_rule__ResultIssue__Group_5__25019);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2539:1: rule__ResultIssue__Group_5__2__Impl : ( ']' ) ;
    public final void rule__ResultIssue__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2543:1: ( ( ']' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2544:1: ( ']' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2544:1: ( ']' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2545:1: ']'
            {
             before(grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2()); 
            match(input,21,FOLLOW_21_in_rule__ResultIssue__Group_5__2__Impl5047); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2564:1: rule__ResultData__Group__0 : rule__ResultData__Group__0__Impl rule__ResultData__Group__1 ;
    public final void rule__ResultData__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2568:1: ( rule__ResultData__Group__0__Impl rule__ResultData__Group__1 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2569:2: rule__ResultData__Group__0__Impl rule__ResultData__Group__1
            {
            pushFollow(FOLLOW_rule__ResultData__Group__0__Impl_in_rule__ResultData__Group__05084);
            rule__ResultData__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultData__Group__1_in_rule__ResultData__Group__05087);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2576:1: rule__ResultData__Group__0__Impl : ( ( rule__ResultData__NameAssignment_0 ) ) ;
    public final void rule__ResultData__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2580:1: ( ( ( rule__ResultData__NameAssignment_0 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2581:1: ( ( rule__ResultData__NameAssignment_0 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2581:1: ( ( rule__ResultData__NameAssignment_0 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2582:1: ( rule__ResultData__NameAssignment_0 )
            {
             before(grammarAccess.getResultDataAccess().getNameAssignment_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2583:1: ( rule__ResultData__NameAssignment_0 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2583:2: rule__ResultData__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ResultData__NameAssignment_0_in_rule__ResultData__Group__0__Impl5114);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2593:1: rule__ResultData__Group__1 : rule__ResultData__Group__1__Impl rule__ResultData__Group__2 ;
    public final void rule__ResultData__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2597:1: ( rule__ResultData__Group__1__Impl rule__ResultData__Group__2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2598:2: rule__ResultData__Group__1__Impl rule__ResultData__Group__2
            {
            pushFollow(FOLLOW_rule__ResultData__Group__1__Impl_in_rule__ResultData__Group__15144);
            rule__ResultData__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultData__Group__2_in_rule__ResultData__Group__15147);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2605:1: rule__ResultData__Group__1__Impl : ( '=' ) ;
    public final void rule__ResultData__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2609:1: ( ( '=' ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2610:1: ( '=' )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2610:1: ( '=' )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2611:1: '='
            {
             before(grammarAccess.getResultDataAccess().getEqualsSignKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__ResultData__Group__1__Impl5175); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2624:1: rule__ResultData__Group__2 : rule__ResultData__Group__2__Impl ;
    public final void rule__ResultData__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2628:1: ( rule__ResultData__Group__2__Impl )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2629:2: rule__ResultData__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultData__Group__2__Impl_in_rule__ResultData__Group__25206);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2635:1: rule__ResultData__Group__2__Impl : ( ( rule__ResultData__ValueAssignment_2 ) ) ;
    public final void rule__ResultData__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2639:1: ( ( ( rule__ResultData__ValueAssignment_2 ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2640:1: ( ( rule__ResultData__ValueAssignment_2 ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2640:1: ( ( rule__ResultData__ValueAssignment_2 ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2641:1: ( rule__ResultData__ValueAssignment_2 )
            {
             before(grammarAccess.getResultDataAccess().getValueAssignment_2()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2642:1: ( rule__ResultData__ValueAssignment_2 )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2642:2: rule__ResultData__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__ResultData__ValueAssignment_2_in_rule__ResultData__Group__2__Impl5233);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2659:1: rule__ResultReportCollection__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ResultReportCollection__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2663:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2664:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2664:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2665:1: RULE_ID
            {
             before(grammarAccess.getResultReportCollectionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultReportCollection__NameAssignment_15274); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2674:1: rule__ResultReportCollection__TitleAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__ResultReportCollection__TitleAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2678:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2679:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2679:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2680:1: RULE_STRING
            {
             before(grammarAccess.getResultReportCollectionAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReportCollection__TitleAssignment_2_15305); 
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


    // $ANTLR start "rule__ResultReportCollection__TargetAssignment_4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2689:1: rule__ResultReportCollection__TargetAssignment_4 : ( ( ruleURIID ) ) ;
    public final void rule__ResultReportCollection__TargetAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2693:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2694:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2694:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2695:1: ( ruleURIID )
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_4_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2696:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2697:1: ruleURIID
            {
             before(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultReportCollection__TargetAssignment_45340);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getResultReportCollectionAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getResultReportCollectionAccess().getTargetEObjectCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultReportCollection__TargetAssignment_4"


    // $ANTLR start "rule__ResultReportCollection__DecriptionAssignment_6_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2708:1: rule__ResultReportCollection__DecriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ResultReportCollection__DecriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2712:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2713:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2713:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2714:1: RULE_STRING
            {
             before(grammarAccess.getResultReportCollectionAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultReportCollection__DecriptionAssignment_6_15375); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2723:1: rule__ResultReportCollection__ContentAssignment_7 : ( ruleResultReport ) ;
    public final void rule__ResultReportCollection__ContentAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2727:1: ( ( ruleResultReport ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2728:1: ( ruleResultReport )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2728:1: ( ruleResultReport )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2729:1: ruleResultReport
            {
             before(grammarAccess.getResultReportCollectionAccess().getContentResultReportParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleResultReport_in_rule__ResultReportCollection__ContentAssignment_75406);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2738:1: rule__ResultReportCollection__IssuesAssignment_8 : ( ruleResultIssue ) ;
    public final void rule__ResultReportCollection__IssuesAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2742:1: ( ( ruleResultIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2743:1: ( ruleResultIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2743:1: ( ruleResultIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2744:1: ruleResultIssue
            {
             before(grammarAccess.getResultReportCollectionAccess().getIssuesResultIssueParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleResultIssue_in_rule__ResultReportCollection__IssuesAssignment_85437);
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


    // $ANTLR start "rule__ResultDataReport__NameAssignment_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2753:1: rule__ResultDataReport__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ResultDataReport__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2757:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2758:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2758:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2759:1: RULE_ID
            {
             before(grammarAccess.getResultDataReportAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultDataReport__NameAssignment_15468); 
             after(grammarAccess.getResultDataReportAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__NameAssignment_1"


    // $ANTLR start "rule__ResultDataReport__TitleAssignment_2_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2768:1: rule__ResultDataReport__TitleAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__ResultDataReport__TitleAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2772:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2773:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2773:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2774:1: RULE_STRING
            {
             before(grammarAccess.getResultDataReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultDataReport__TitleAssignment_2_15499); 
             after(grammarAccess.getResultDataReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__TitleAssignment_2_1"


    // $ANTLR start "rule__ResultDataReport__TargetAssignment_4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2783:1: rule__ResultDataReport__TargetAssignment_4 : ( ( ruleURIID ) ) ;
    public final void rule__ResultDataReport__TargetAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2787:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2788:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2788:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2789:1: ( ruleURIID )
            {
             before(grammarAccess.getResultDataReportAccess().getTargetEObjectCrossReference_4_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2790:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2791:1: ruleURIID
            {
             before(grammarAccess.getResultDataReportAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultDataReport__TargetAssignment_45534);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getResultDataReportAccess().getTargetEObjectURIIDParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getResultDataReportAccess().getTargetEObjectCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__TargetAssignment_4"


    // $ANTLR start "rule__ResultDataReport__DecriptionAssignment_6_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2802:1: rule__ResultDataReport__DecriptionAssignment_6_1 : ( RULE_STRING ) ;
    public final void rule__ResultDataReport__DecriptionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2806:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2807:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2807:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2808:1: RULE_STRING
            {
             before(grammarAccess.getResultDataReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultDataReport__DecriptionAssignment_6_15569); 
             after(grammarAccess.getResultDataReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__DecriptionAssignment_6_1"


    // $ANTLR start "rule__ResultDataReport__HeadingAssignment_7_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2817:1: rule__ResultDataReport__HeadingAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__ResultDataReport__HeadingAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2821:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2822:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2822:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2823:1: RULE_STRING
            {
             before(grammarAccess.getResultDataReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultDataReport__HeadingAssignment_7_15600); 
             after(grammarAccess.getResultDataReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__HeadingAssignment_7_1"


    // $ANTLR start "rule__ResultDataReport__ContentAssignment_7_2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2832:1: rule__ResultDataReport__ContentAssignment_7_2 : ( ruleResultContributor ) ;
    public final void rule__ResultDataReport__ContentAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2836:1: ( ( ruleResultContributor ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2837:1: ( ruleResultContributor )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2837:1: ( ruleResultContributor )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2838:1: ruleResultContributor
            {
             before(grammarAccess.getResultDataReportAccess().getContentResultContributorParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_ruleResultContributor_in_rule__ResultDataReport__ContentAssignment_7_25631);
            ruleResultContributor();

            state._fsp--;

             after(grammarAccess.getResultDataReportAccess().getContentResultContributorParserRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__ContentAssignment_7_2"


    // $ANTLR start "rule__ResultDataReport__ResultDataAssignment_8_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2847:1: rule__ResultDataReport__ResultDataAssignment_8_1 : ( ruleResultData ) ;
    public final void rule__ResultDataReport__ResultDataAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2851:1: ( ( ruleResultData ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2852:1: ( ruleResultData )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2852:1: ( ruleResultData )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2853:1: ruleResultData
            {
             before(grammarAccess.getResultDataReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_ruleResultData_in_rule__ResultDataReport__ResultDataAssignment_8_15662);
            ruleResultData();

            state._fsp--;

             after(grammarAccess.getResultDataReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__ResultDataAssignment_8_1"


    // $ANTLR start "rule__ResultDataReport__IssuesAssignment_9"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2862:1: rule__ResultDataReport__IssuesAssignment_9 : ( ruleResultIssue ) ;
    public final void rule__ResultDataReport__IssuesAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2866:1: ( ( ruleResultIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2867:1: ( ruleResultIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2867:1: ( ruleResultIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2868:1: ruleResultIssue
            {
             before(grammarAccess.getResultDataReportAccess().getIssuesResultIssueParserRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleResultIssue_in_rule__ResultDataReport__IssuesAssignment_95693);
            ruleResultIssue();

            state._fsp--;

             after(grammarAccess.getResultDataReportAccess().getIssuesResultIssueParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultDataReport__IssuesAssignment_9"


    // $ANTLR start "rule__ResultContributor__TargetAssignment_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2877:1: rule__ResultContributor__TargetAssignment_1 : ( ( ruleURIID ) ) ;
    public final void rule__ResultContributor__TargetAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2881:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2882:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2882:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2883:1: ( ruleURIID )
            {
             before(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_1_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2884:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2885:1: ruleURIID
            {
             before(grammarAccess.getResultContributorAccess().getTargetEObjectURIIDParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultContributor__TargetAssignment_15728);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getResultContributorAccess().getTargetEObjectURIIDParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getResultContributorAccess().getTargetEObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__TargetAssignment_1"


    // $ANTLR start "rule__ResultContributor__ResultDataAssignment_3_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2896:1: rule__ResultContributor__ResultDataAssignment_3_1 : ( ruleResultData ) ;
    public final void rule__ResultContributor__ResultDataAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2900:1: ( ( ruleResultData ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2901:1: ( ruleResultData )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2901:1: ( ruleResultData )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2902:1: ruleResultData
            {
             before(grammarAccess.getResultContributorAccess().getResultDataResultDataParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleResultData_in_rule__ResultContributor__ResultDataAssignment_3_15763);
            ruleResultData();

            state._fsp--;

             after(grammarAccess.getResultContributorAccess().getResultDataResultDataParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__ResultDataAssignment_3_1"


    // $ANTLR start "rule__ResultContributor__IssuesAssignment_4"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2911:1: rule__ResultContributor__IssuesAssignment_4 : ( ruleResultIssue ) ;
    public final void rule__ResultContributor__IssuesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2915:1: ( ( ruleResultIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2916:1: ( ruleResultIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2916:1: ( ruleResultIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2917:1: ruleResultIssue
            {
             before(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleResultIssue_in_rule__ResultContributor__IssuesAssignment_45794);
            ruleResultIssue();

            state._fsp--;

             after(grammarAccess.getResultContributorAccess().getIssuesResultIssueParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__IssuesAssignment_4"


    // $ANTLR start "rule__ResultContributor__SubcontributorAssignment_5"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2926:1: rule__ResultContributor__SubcontributorAssignment_5 : ( ruleResultContributor ) ;
    public final void rule__ResultContributor__SubcontributorAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2930:1: ( ( ruleResultContributor ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2931:1: ( ruleResultContributor )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2931:1: ( ruleResultContributor )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2932:1: ruleResultContributor
            {
             before(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleResultContributor_in_rule__ResultContributor__SubcontributorAssignment_55825);
            ruleResultContributor();

            state._fsp--;

             after(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultContributor__SubcontributorAssignment_5"


    // $ANTLR start "rule__IssuesReport__NameAssignment_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2941:1: rule__IssuesReport__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__IssuesReport__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2945:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2946:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2946:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2947:1: RULE_ID
            {
             before(grammarAccess.getIssuesReportAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IssuesReport__NameAssignment_15856); 
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


    // $ANTLR start "rule__IssuesReport__TargetAssignment_2_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2956:1: rule__IssuesReport__TargetAssignment_2_1 : ( ( ruleURIID ) ) ;
    public final void rule__IssuesReport__TargetAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2960:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2961:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2961:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2962:1: ( ruleURIID )
            {
             before(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_2_1_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2963:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2964:1: ruleURIID
            {
             before(grammarAccess.getIssuesReportAccess().getTargetEObjectURIIDParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__IssuesReport__TargetAssignment_2_15891);
            ruleURIID();

            state._fsp--;

             after(grammarAccess.getIssuesReportAccess().getTargetEObjectURIIDParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getIssuesReportAccess().getTargetEObjectCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssuesReport__TargetAssignment_2_1"


    // $ANTLR start "rule__IssuesReport__DescriptionAssignment_3_1_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2975:1: rule__IssuesReport__DescriptionAssignment_3_1_1 : ( RULE_STRING ) ;
    public final void rule__IssuesReport__DescriptionAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2979:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2980:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2980:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2981:1: RULE_STRING
            {
             before(grammarAccess.getIssuesReportAccess().getDescriptionSTRINGTerminalRuleCall_3_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IssuesReport__DescriptionAssignment_3_1_15926); 
             after(grammarAccess.getIssuesReportAccess().getDescriptionSTRINGTerminalRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssuesReport__DescriptionAssignment_3_1_1"


    // $ANTLR start "rule__IssuesReport__IssuesAssignment_3_2"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2990:1: rule__IssuesReport__IssuesAssignment_3_2 : ( ruleResultIssue ) ;
    public final void rule__IssuesReport__IssuesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2994:1: ( ( ruleResultIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2995:1: ( ruleResultIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2995:1: ( ruleResultIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:2996:1: ruleResultIssue
            {
             before(grammarAccess.getIssuesReportAccess().getIssuesResultIssueParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_ruleResultIssue_in_rule__IssuesReport__IssuesAssignment_3_25957);
            ruleResultIssue();

            state._fsp--;

             after(grammarAccess.getIssuesReportAccess().getIssuesResultIssueParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IssuesReport__IssuesAssignment_3_2"


    // $ANTLR start "rule__ResultIssue__IssueTypeAssignment_1"
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3005:1: rule__ResultIssue__IssueTypeAssignment_1 : ( ruleResultIssueType ) ;
    public final void rule__ResultIssue__IssueTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3009:1: ( ( ruleResultIssueType ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3010:1: ( ruleResultIssueType )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3010:1: ( ruleResultIssueType )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3011:1: ruleResultIssueType
            {
             before(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleResultIssueType_in_rule__ResultIssue__IssueTypeAssignment_15988);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3020:1: rule__ResultIssue__MessageAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ResultIssue__MessageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3024:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3025:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3025:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3026:1: RULE_STRING
            {
             before(grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultIssue__MessageAssignment_26019); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3035:1: rule__ResultIssue__TargetAssignment_3_1 : ( ( ruleURIID ) ) ;
    public final void rule__ResultIssue__TargetAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3039:1: ( ( ( ruleURIID ) ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3040:1: ( ( ruleURIID ) )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3040:1: ( ( ruleURIID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3041:1: ( ruleURIID )
            {
             before(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_3_1_0()); 
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3042:1: ( ruleURIID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3043:1: ruleURIID
            {
             before(grammarAccess.getResultIssueAccess().getTargetEObjectURIIDParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_ruleURIID_in_rule__ResultIssue__TargetAssignment_3_16054);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3054:1: rule__ResultIssue__ExceptionTypeAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__ResultIssue__ExceptionTypeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3058:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3059:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3059:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3060:1: RULE_STRING
            {
             before(grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultIssue__ExceptionTypeAssignment_4_16089); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3069:1: rule__ResultIssue__IssuesAssignment_5_1 : ( ruleResultIssue ) ;
    public final void rule__ResultIssue__IssuesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3073:1: ( ( ruleResultIssue ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3074:1: ( ruleResultIssue )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3074:1: ( ruleResultIssue )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3075:1: ruleResultIssue
            {
             before(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleResultIssue_in_rule__ResultIssue__IssuesAssignment_5_16120);
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3084:1: rule__ResultData__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ResultData__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3088:1: ( ( RULE_ID ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3089:1: ( RULE_ID )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3089:1: ( RULE_ID )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3090:1: RULE_ID
            {
             before(grammarAccess.getResultDataAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResultData__NameAssignment_06151); 
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
    // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3099:1: rule__ResultData__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ResultData__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3103:1: ( ( RULE_STRING ) )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3104:1: ( RULE_STRING )
            {
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3104:1: ( RULE_STRING )
            // ../org.osate.results.ui/src-gen/org/osate/results/ui/contentassist/antlr/internal/InternalResults.g:3105:1: RULE_STRING
            {
             before(grammarAccess.getResultDataAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResultData__ValueAssignment_26182); 
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


 

    public static final BitSet FOLLOW_ruleResultReport_in_entryRuleResultReport61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReport68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReport__Alternatives_in_ruleResultReport94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_entryRuleResultReportCollection121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReportCollection128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__0_in_ruleResultReportCollection154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultDataReport_in_entryRuleResultDataReport181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultDataReport188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__0_in_ruleResultDataReport214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_entryRuleResultContributor241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultContributor248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__0_in_ruleResultContributor274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssuesReport_in_entryRuleIssuesReport301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIssuesReport308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__0_in_ruleIssuesReport334 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_ruleResultDataReport_in_rule__ResultReport__Alternatives585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportCollection_in_rule__ResultReport__Alternatives602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssuesReport_in_rule__ResultReport__Alternatives619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ResultIssueType__Alternatives652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ResultIssueType__Alternatives673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ResultIssueType__Alternatives694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ResultIssueType__Alternatives715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ResultIssueType__Alternatives736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ResultIssueType__Alternatives757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ResultIssueType__Alternatives778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__0__Impl_in_rule__ResultReportCollection__Group__0811 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__1_in_rule__ResultReportCollection__Group__0814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ResultReportCollection__Group__0__Impl842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__1__Impl_in_rule__ResultReportCollection__Group__1873 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__2_in_rule__ResultReportCollection__Group__1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__NameAssignment_1_in_rule__ResultReportCollection__Group__1__Impl903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__2__Impl_in_rule__ResultReportCollection__Group__2933 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__3_in_rule__ResultReportCollection__Group__2936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__0_in_rule__ResultReportCollection__Group__2__Impl963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__3__Impl_in_rule__ResultReportCollection__Group__3994 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__4_in_rule__ResultReportCollection__Group__3997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ResultReportCollection__Group__3__Impl1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__4__Impl_in_rule__ResultReportCollection__Group__41056 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__5_in_rule__ResultReportCollection__Group__41059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__TargetAssignment_4_in_rule__ResultReportCollection__Group__4__Impl1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__5__Impl_in_rule__ResultReportCollection__Group__51116 = new BitSet(new long[]{0x0000000031A40000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__6_in_rule__ResultReportCollection__Group__51119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultReportCollection__Group__5__Impl1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__6__Impl_in_rule__ResultReportCollection__Group__61178 = new BitSet(new long[]{0x0000000031A40000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__7_in_rule__ResultReportCollection__Group__61181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__0_in_rule__ResultReportCollection__Group__6__Impl1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__7__Impl_in_rule__ResultReportCollection__Group__71239 = new BitSet(new long[]{0x0000000031A40000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__8_in_rule__ResultReportCollection__Group__71242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__ContentAssignment_7_in_rule__ResultReportCollection__Group__7__Impl1269 = new BitSet(new long[]{0x0000000011040002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__8__Impl_in_rule__ResultReportCollection__Group__81300 = new BitSet(new long[]{0x0000000031A40000L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__9_in_rule__ResultReportCollection__Group__81303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__IssuesAssignment_8_in_rule__ResultReportCollection__Group__8__Impl1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group__9__Impl_in_rule__ResultReportCollection__Group__91361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResultReportCollection__Group__9__Impl1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__0__Impl_in_rule__ResultReportCollection__Group_2__01440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__1_in_rule__ResultReportCollection__Group_2__01443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ResultReportCollection__Group_2__0__Impl1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_2__1__Impl_in_rule__ResultReportCollection__Group_2__11502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__TitleAssignment_2_1_in_rule__ResultReportCollection__Group_2__1__Impl1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__0__Impl_in_rule__ResultReportCollection__Group_6__01563 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__1_in_rule__ResultReportCollection__Group_6__01566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ResultReportCollection__Group_6__0__Impl1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__Group_6__1__Impl_in_rule__ResultReportCollection__Group_6__11625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultReportCollection__DecriptionAssignment_6_1_in_rule__ResultReportCollection__Group_6__1__Impl1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__0__Impl_in_rule__ResultDataReport__Group__01686 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__1_in_rule__ResultDataReport__Group__01689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ResultDataReport__Group__0__Impl1717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__1__Impl_in_rule__ResultDataReport__Group__11748 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__2_in_rule__ResultDataReport__Group__11751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__NameAssignment_1_in_rule__ResultDataReport__Group__1__Impl1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__2__Impl_in_rule__ResultDataReport__Group__21808 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__3_in_rule__ResultDataReport__Group__21811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_2__0_in_rule__ResultDataReport__Group__2__Impl1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__3__Impl_in_rule__ResultDataReport__Group__31869 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__4_in_rule__ResultDataReport__Group__31872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ResultDataReport__Group__3__Impl1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__4__Impl_in_rule__ResultDataReport__Group__41931 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__5_in_rule__ResultDataReport__Group__41934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__TargetAssignment_4_in_rule__ResultDataReport__Group__4__Impl1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__5__Impl_in_rule__ResultDataReport__Group__51991 = new BitSet(new long[]{0x0000000026A00000L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__6_in_rule__ResultDataReport__Group__51994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultDataReport__Group__5__Impl2022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__6__Impl_in_rule__ResultDataReport__Group__62053 = new BitSet(new long[]{0x0000000026A00000L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__7_in_rule__ResultDataReport__Group__62056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_6__0_in_rule__ResultDataReport__Group__6__Impl2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__7__Impl_in_rule__ResultDataReport__Group__72114 = new BitSet(new long[]{0x0000000026A00000L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__8_in_rule__ResultDataReport__Group__72117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_7__0_in_rule__ResultDataReport__Group__7__Impl2144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__8__Impl_in_rule__ResultDataReport__Group__82175 = new BitSet(new long[]{0x0000000026A00000L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__9_in_rule__ResultDataReport__Group__82178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_8__0_in_rule__ResultDataReport__Group__8__Impl2205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__9__Impl_in_rule__ResultDataReport__Group__92236 = new BitSet(new long[]{0x0000000026A00000L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__10_in_rule__ResultDataReport__Group__92239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__IssuesAssignment_9_in_rule__ResultDataReport__Group__9__Impl2266 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group__10__Impl_in_rule__ResultDataReport__Group__102297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResultDataReport__Group__10__Impl2325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_2__0__Impl_in_rule__ResultDataReport__Group_2__02378 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_2__1_in_rule__ResultDataReport__Group_2__02381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ResultDataReport__Group_2__0__Impl2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_2__1__Impl_in_rule__ResultDataReport__Group_2__12440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__TitleAssignment_2_1_in_rule__ResultDataReport__Group_2__1__Impl2467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_6__0__Impl_in_rule__ResultDataReport__Group_6__02501 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_6__1_in_rule__ResultDataReport__Group_6__02504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ResultDataReport__Group_6__0__Impl2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_6__1__Impl_in_rule__ResultDataReport__Group_6__12563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__DecriptionAssignment_6_1_in_rule__ResultDataReport__Group_6__1__Impl2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_7__0__Impl_in_rule__ResultDataReport__Group_7__02624 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_7__1_in_rule__ResultDataReport__Group_7__02627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ResultDataReport__Group_7__0__Impl2655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_7__1__Impl_in_rule__ResultDataReport__Group_7__12686 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_7__2_in_rule__ResultDataReport__Group_7__12689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__HeadingAssignment_7_1_in_rule__ResultDataReport__Group_7__1__Impl2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_7__2__Impl_in_rule__ResultDataReport__Group_7__22746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__ContentAssignment_7_2_in_rule__ResultDataReport__Group_7__2__Impl2773 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_8__0__Impl_in_rule__ResultDataReport__Group_8__02810 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_8__1_in_rule__ResultDataReport__Group_8__02813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ResultDataReport__Group_8__0__Impl2841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__Group_8__1__Impl_in_rule__ResultDataReport__Group_8__12872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultDataReport__ResultDataAssignment_8_1_in_rule__ResultDataReport__Group_8__1__Impl2901 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__ResultDataReport__ResultDataAssignment_8_1_in_rule__ResultDataReport__Group_8__1__Impl2913 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__0__Impl_in_rule__ResultContributor__Group__02950 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__1_in_rule__ResultContributor__Group__02953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ResultContributor__Group__0__Impl2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__1__Impl_in_rule__ResultContributor__Group__13012 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__2_in_rule__ResultContributor__Group__13015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__TargetAssignment_1_in_rule__ResultContributor__Group__1__Impl3042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__2__Impl_in_rule__ResultContributor__Group__23072 = new BitSet(new long[]{0x000000002C200000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__3_in_rule__ResultContributor__Group__23075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultContributor__Group__2__Impl3103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__3__Impl_in_rule__ResultContributor__Group__33134 = new BitSet(new long[]{0x000000002C200000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__4_in_rule__ResultContributor__Group__33137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_3__0_in_rule__ResultContributor__Group__3__Impl3164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__4__Impl_in_rule__ResultContributor__Group__43195 = new BitSet(new long[]{0x000000002C200000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__5_in_rule__ResultContributor__Group__43198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__IssuesAssignment_4_in_rule__ResultContributor__Group__4__Impl3225 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__5__Impl_in_rule__ResultContributor__Group__53256 = new BitSet(new long[]{0x000000002C200000L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__6_in_rule__ResultContributor__Group__53259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__SubcontributorAssignment_5_in_rule__ResultContributor__Group__5__Impl3286 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group__6__Impl_in_rule__ResultContributor__Group__63317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResultContributor__Group__6__Impl3345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_3__0__Impl_in_rule__ResultContributor__Group_3__03390 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_3__1_in_rule__ResultContributor__Group_3__03393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ResultContributor__Group_3__0__Impl3421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__Group_3__1__Impl_in_rule__ResultContributor__Group_3__13452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultContributor__ResultDataAssignment_3_1_in_rule__ResultContributor__Group_3__1__Impl3481 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__ResultContributor__ResultDataAssignment_3_1_in_rule__ResultContributor__Group_3__1__Impl3493 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__0__Impl_in_rule__IssuesReport__Group__03530 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__1_in_rule__IssuesReport__Group__03533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__IssuesReport__Group__0__Impl3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__1__Impl_in_rule__IssuesReport__Group__13592 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__2_in_rule__IssuesReport__Group__13595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__NameAssignment_1_in_rule__IssuesReport__Group__1__Impl3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__2__Impl_in_rule__IssuesReport__Group__23652 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__3_in_rule__IssuesReport__Group__23655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__0_in_rule__IssuesReport__Group__2__Impl3682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group__3__Impl_in_rule__IssuesReport__Group__33713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3__0_in_rule__IssuesReport__Group__3__Impl3740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__0__Impl_in_rule__IssuesReport__Group_2__03779 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__1_in_rule__IssuesReport__Group_2__03782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__IssuesReport__Group_2__0__Impl3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_2__1__Impl_in_rule__IssuesReport__Group_2__13841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__TargetAssignment_2_1_in_rule__IssuesReport__Group_2__1__Impl3868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3__0__Impl_in_rule__IssuesReport__Group_3__03902 = new BitSet(new long[]{0x0000000020A00000L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3__1_in_rule__IssuesReport__Group_3__03905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__IssuesReport__Group_3__0__Impl3933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3__1__Impl_in_rule__IssuesReport__Group_3__13964 = new BitSet(new long[]{0x0000000020A00000L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3__2_in_rule__IssuesReport__Group_3__13967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3_1__0_in_rule__IssuesReport__Group_3__1__Impl3994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3__2__Impl_in_rule__IssuesReport__Group_3__24025 = new BitSet(new long[]{0x0000000020A00000L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3__3_in_rule__IssuesReport__Group_3__24028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__IssuesAssignment_3_2_in_rule__IssuesReport__Group_3__2__Impl4055 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3__3__Impl_in_rule__IssuesReport__Group_3__34086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__IssuesReport__Group_3__3__Impl4114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3_1__0__Impl_in_rule__IssuesReport__Group_3_1__04153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3_1__1_in_rule__IssuesReport__Group_3_1__04156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__IssuesReport__Group_3_1__0__Impl4184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__Group_3_1__1__Impl_in_rule__IssuesReport__Group_3_1__14215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IssuesReport__DescriptionAssignment_3_1_1_in_rule__IssuesReport__Group_3_1__1__Impl4242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__0__Impl_in_rule__ResultIssue__Group__04276 = new BitSet(new long[]{0x000000000003F800L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__1_in_rule__ResultIssue__Group__04279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ResultIssue__Group__0__Impl4307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__1__Impl_in_rule__ResultIssue__Group__14338 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__2_in_rule__ResultIssue__Group__14341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__IssueTypeAssignment_1_in_rule__ResultIssue__Group__1__Impl4368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__2__Impl_in_rule__ResultIssue__Group__24398 = new BitSet(new long[]{0x00000000C0100000L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__3_in_rule__ResultIssue__Group__24401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__MessageAssignment_2_in_rule__ResultIssue__Group__2__Impl4428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__3__Impl_in_rule__ResultIssue__Group__34458 = new BitSet(new long[]{0x00000000C0100000L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__4_in_rule__ResultIssue__Group__34461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_3__0_in_rule__ResultIssue__Group__3__Impl4488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__4__Impl_in_rule__ResultIssue__Group__44519 = new BitSet(new long[]{0x00000000C0100000L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__5_in_rule__ResultIssue__Group__44522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_4__0_in_rule__ResultIssue__Group__4__Impl4549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group__5__Impl_in_rule__ResultIssue__Group__54580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__0_in_rule__ResultIssue__Group__5__Impl4607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_3__0__Impl_in_rule__ResultIssue__Group_3__04650 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_3__1_in_rule__ResultIssue__Group_3__04653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ResultIssue__Group_3__0__Impl4681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_3__1__Impl_in_rule__ResultIssue__Group_3__14712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__TargetAssignment_3_1_in_rule__ResultIssue__Group_3__1__Impl4739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_4__0__Impl_in_rule__ResultIssue__Group_4__04773 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_4__1_in_rule__ResultIssue__Group_4__04776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ResultIssue__Group_4__0__Impl4804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_4__1__Impl_in_rule__ResultIssue__Group_4__14835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__ExceptionTypeAssignment_4_1_in_rule__ResultIssue__Group_4__1__Impl4862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__0__Impl_in_rule__ResultIssue__Group_5__04896 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__1_in_rule__ResultIssue__Group_5__04899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ResultIssue__Group_5__0__Impl4927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__1__Impl_in_rule__ResultIssue__Group_5__14958 = new BitSet(new long[]{0x0000000020200000L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__2_in_rule__ResultIssue__Group_5__14961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__IssuesAssignment_5_1_in_rule__ResultIssue__Group_5__1__Impl4988 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__ResultIssue__Group_5__2__Impl_in_rule__ResultIssue__Group_5__25019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResultIssue__Group_5__2__Impl5047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__0__Impl_in_rule__ResultData__Group__05084 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ResultData__Group__1_in_rule__ResultData__Group__05087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__NameAssignment_0_in_rule__ResultData__Group__0__Impl5114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__1__Impl_in_rule__ResultData__Group__15144 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResultData__Group__2_in_rule__ResultData__Group__15147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ResultData__Group__1__Impl5175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__Group__2__Impl_in_rule__ResultData__Group__25206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultData__ValueAssignment_2_in_rule__ResultData__Group__2__Impl5233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultReportCollection__NameAssignment_15274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReportCollection__TitleAssignment_2_15305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultReportCollection__TargetAssignment_45340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultReportCollection__DecriptionAssignment_6_15375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReport_in_rule__ResultReportCollection__ContentAssignment_75406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_rule__ResultReportCollection__IssuesAssignment_85437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultDataReport__NameAssignment_15468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultDataReport__TitleAssignment_2_15499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultDataReport__TargetAssignment_45534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultDataReport__DecriptionAssignment_6_15569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultDataReport__HeadingAssignment_7_15600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_rule__ResultDataReport__ContentAssignment_7_25631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_rule__ResultDataReport__ResultDataAssignment_8_15662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_rule__ResultDataReport__IssuesAssignment_95693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultContributor__TargetAssignment_15728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_rule__ResultContributor__ResultDataAssignment_3_15763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_rule__ResultContributor__IssuesAssignment_45794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_rule__ResultContributor__SubcontributorAssignment_55825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IssuesReport__NameAssignment_15856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__IssuesReport__TargetAssignment_2_15891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IssuesReport__DescriptionAssignment_3_1_15926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_rule__IssuesReport__IssuesAssignment_3_25957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_rule__ResultIssue__IssueTypeAssignment_15988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultIssue__MessageAssignment_26019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_rule__ResultIssue__TargetAssignment_3_16054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultIssue__ExceptionTypeAssignment_4_16089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_rule__ResultIssue__IssuesAssignment_5_16120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResultData__NameAssignment_06151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResultData__ValueAssignment_26182 = new BitSet(new long[]{0x0000000000000002L});

}
package org.osate.categories.ui.contentassist.antlr.internal; 

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
import org.osate.categories.services.CategoriesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCategoriesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requirement'", "'categories'", "'['", "']'", "'hazard'", "'verification'", "'selection'", "'assertfail'", "'executionfail'", "'extends'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalCategoriesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCategoriesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCategoriesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g"; }


     
     	private CategoriesGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(CategoriesGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:60:1: entryRuleCategories : ruleCategories EOF ;
    public final void entryRuleCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:61:1: ( ruleCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:62:1: ruleCategories EOF
            {
             before(grammarAccess.getCategoriesRule()); 
            pushFollow(FOLLOW_ruleCategories_in_entryRuleCategories61);
            ruleCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategories68); 

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
    // $ANTLR end "entryRuleCategories"


    // $ANTLR start "ruleCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:69:1: ruleCategories : ( ( rule__Categories__Alternatives ) ) ;
    public final void ruleCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:73:2: ( ( ( rule__Categories__Alternatives ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:74:1: ( ( rule__Categories__Alternatives ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:74:1: ( ( rule__Categories__Alternatives ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:75:1: ( rule__Categories__Alternatives )
            {
             before(grammarAccess.getCategoriesAccess().getAlternatives()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:76:1: ( rule__Categories__Alternatives )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:76:2: rule__Categories__Alternatives
            {
            pushFollow(FOLLOW_rule__Categories__Alternatives_in_ruleCategories94);
            rule__Categories__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCategoriesAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCategories"


    // $ANTLR start "entryRuleRequirementCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:88:1: entryRuleRequirementCategories : ruleRequirementCategories EOF ;
    public final void entryRuleRequirementCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:89:1: ( ruleRequirementCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:90:1: ruleRequirementCategories EOF
            {
             before(grammarAccess.getRequirementCategoriesRule()); 
            pushFollow(FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories121);
            ruleRequirementCategories();

            state._fsp--;

             after(grammarAccess.getRequirementCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategories128); 

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
    // $ANTLR end "entryRuleRequirementCategories"


    // $ANTLR start "ruleRequirementCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:97:1: ruleRequirementCategories : ( ( rule__RequirementCategories__Group__0 ) ) ;
    public final void ruleRequirementCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:101:2: ( ( ( rule__RequirementCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:102:1: ( ( rule__RequirementCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:102:1: ( ( rule__RequirementCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:103:1: ( rule__RequirementCategories__Group__0 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:104:1: ( rule__RequirementCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:104:2: rule__RequirementCategories__Group__0
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__0_in_ruleRequirementCategories154);
            rule__RequirementCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRequirementCategories"


    // $ANTLR start "entryRuleHazardCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:116:1: entryRuleHazardCategories : ruleHazardCategories EOF ;
    public final void entryRuleHazardCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:117:1: ( ruleHazardCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:118:1: ruleHazardCategories EOF
            {
             before(grammarAccess.getHazardCategoriesRule()); 
            pushFollow(FOLLOW_ruleHazardCategories_in_entryRuleHazardCategories181);
            ruleHazardCategories();

            state._fsp--;

             after(grammarAccess.getHazardCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategories188); 

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
    // $ANTLR end "entryRuleHazardCategories"


    // $ANTLR start "ruleHazardCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:125:1: ruleHazardCategories : ( ( rule__HazardCategories__Group__0 ) ) ;
    public final void ruleHazardCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:129:2: ( ( ( rule__HazardCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:130:1: ( ( rule__HazardCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:130:1: ( ( rule__HazardCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:131:1: ( rule__HazardCategories__Group__0 )
            {
             before(grammarAccess.getHazardCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:132:1: ( rule__HazardCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:132:2: rule__HazardCategories__Group__0
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__0_in_ruleHazardCategories214);
            rule__HazardCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHazardCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHazardCategories"


    // $ANTLR start "entryRuleVerificationCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:144:1: entryRuleVerificationCategories : ruleVerificationCategories EOF ;
    public final void entryRuleVerificationCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:145:1: ( ruleVerificationCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:146:1: ruleVerificationCategories EOF
            {
             before(grammarAccess.getVerificationCategoriesRule()); 
            pushFollow(FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories241);
            ruleVerificationCategories();

            state._fsp--;

             after(grammarAccess.getVerificationCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategories248); 

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
    // $ANTLR end "entryRuleVerificationCategories"


    // $ANTLR start "ruleVerificationCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:153:1: ruleVerificationCategories : ( ( rule__VerificationCategories__Group__0 ) ) ;
    public final void ruleVerificationCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:157:2: ( ( ( rule__VerificationCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:158:1: ( ( rule__VerificationCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:158:1: ( ( rule__VerificationCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:159:1: ( rule__VerificationCategories__Group__0 )
            {
             before(grammarAccess.getVerificationCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:160:1: ( rule__VerificationCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:160:2: rule__VerificationCategories__Group__0
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__0_in_ruleVerificationCategories274);
            rule__VerificationCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVerificationCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVerificationCategories"


    // $ANTLR start "entryRuleSelectionCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:172:1: entryRuleSelectionCategories : ruleSelectionCategories EOF ;
    public final void entryRuleSelectionCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:173:1: ( ruleSelectionCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:174:1: ruleSelectionCategories EOF
            {
             before(grammarAccess.getSelectionCategoriesRule()); 
            pushFollow(FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories301);
            ruleSelectionCategories();

            state._fsp--;

             after(grammarAccess.getSelectionCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategories308); 

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
    // $ANTLR end "entryRuleSelectionCategories"


    // $ANTLR start "ruleSelectionCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:181:1: ruleSelectionCategories : ( ( rule__SelectionCategories__Group__0 ) ) ;
    public final void ruleSelectionCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:185:2: ( ( ( rule__SelectionCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:186:1: ( ( rule__SelectionCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:186:1: ( ( rule__SelectionCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:187:1: ( rule__SelectionCategories__Group__0 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:188:1: ( rule__SelectionCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:188:2: rule__SelectionCategories__Group__0
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__0_in_ruleSelectionCategories334);
            rule__SelectionCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelectionCategories"


    // $ANTLR start "entryRuleAssertFailCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:200:1: entryRuleAssertFailCategories : ruleAssertFailCategories EOF ;
    public final void entryRuleAssertFailCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:201:1: ( ruleAssertFailCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:202:1: ruleAssertFailCategories EOF
            {
             before(grammarAccess.getAssertFailCategoriesRule()); 
            pushFollow(FOLLOW_ruleAssertFailCategories_in_entryRuleAssertFailCategories361);
            ruleAssertFailCategories();

            state._fsp--;

             after(grammarAccess.getAssertFailCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssertFailCategories368); 

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
    // $ANTLR end "entryRuleAssertFailCategories"


    // $ANTLR start "ruleAssertFailCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:209:1: ruleAssertFailCategories : ( ( rule__AssertFailCategories__Group__0 ) ) ;
    public final void ruleAssertFailCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:213:2: ( ( ( rule__AssertFailCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:214:1: ( ( rule__AssertFailCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:214:1: ( ( rule__AssertFailCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:215:1: ( rule__AssertFailCategories__Group__0 )
            {
             before(grammarAccess.getAssertFailCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:216:1: ( rule__AssertFailCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:216:2: rule__AssertFailCategories__Group__0
            {
            pushFollow(FOLLOW_rule__AssertFailCategories__Group__0_in_ruleAssertFailCategories394);
            rule__AssertFailCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssertFailCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssertFailCategories"


    // $ANTLR start "entryRuleExecutionFailCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:228:1: entryRuleExecutionFailCategories : ruleExecutionFailCategories EOF ;
    public final void entryRuleExecutionFailCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:229:1: ( ruleExecutionFailCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:230:1: ruleExecutionFailCategories EOF
            {
             before(grammarAccess.getExecutionFailCategoriesRule()); 
            pushFollow(FOLLOW_ruleExecutionFailCategories_in_entryRuleExecutionFailCategories421);
            ruleExecutionFailCategories();

            state._fsp--;

             after(grammarAccess.getExecutionFailCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutionFailCategories428); 

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
    // $ANTLR end "entryRuleExecutionFailCategories"


    // $ANTLR start "ruleExecutionFailCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:237:1: ruleExecutionFailCategories : ( ( rule__ExecutionFailCategories__Group__0 ) ) ;
    public final void ruleExecutionFailCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:241:2: ( ( ( rule__ExecutionFailCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:242:1: ( ( rule__ExecutionFailCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:242:1: ( ( rule__ExecutionFailCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:243:1: ( rule__ExecutionFailCategories__Group__0 )
            {
             before(grammarAccess.getExecutionFailCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:244:1: ( rule__ExecutionFailCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:244:2: rule__ExecutionFailCategories__Group__0
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategories__Group__0_in_ruleExecutionFailCategories454);
            rule__ExecutionFailCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExecutionFailCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExecutionFailCategories"


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:258:1: entryRuleRequirementCategory : ruleRequirementCategory EOF ;
    public final void entryRuleRequirementCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:259:1: ( ruleRequirementCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:260:1: ruleRequirementCategory EOF
            {
             before(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory483);
            ruleRequirementCategory();

            state._fsp--;

             after(grammarAccess.getRequirementCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory490); 

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
    // $ANTLR end "entryRuleRequirementCategory"


    // $ANTLR start "ruleRequirementCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:267:1: ruleRequirementCategory : ( ( rule__RequirementCategory__Group__0 ) ) ;
    public final void ruleRequirementCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:271:2: ( ( ( rule__RequirementCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:272:1: ( ( rule__RequirementCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:272:1: ( ( rule__RequirementCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:273:1: ( rule__RequirementCategory__Group__0 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:274:1: ( rule__RequirementCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:274:2: rule__RequirementCategory__Group__0
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory516);
            rule__RequirementCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRequirementCategory"


    // $ANTLR start "entryRuleHazardCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:286:1: entryRuleHazardCategory : ruleHazardCategory EOF ;
    public final void entryRuleHazardCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:287:1: ( ruleHazardCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:288:1: ruleHazardCategory EOF
            {
             before(grammarAccess.getHazardCategoryRule()); 
            pushFollow(FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory543);
            ruleHazardCategory();

            state._fsp--;

             after(grammarAccess.getHazardCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategory550); 

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
    // $ANTLR end "entryRuleHazardCategory"


    // $ANTLR start "ruleHazardCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:295:1: ruleHazardCategory : ( ( rule__HazardCategory__Group__0 ) ) ;
    public final void ruleHazardCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:299:2: ( ( ( rule__HazardCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:300:1: ( ( rule__HazardCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:300:1: ( ( rule__HazardCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:301:1: ( rule__HazardCategory__Group__0 )
            {
             before(grammarAccess.getHazardCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:302:1: ( rule__HazardCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:302:2: rule__HazardCategory__Group__0
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group__0_in_ruleHazardCategory576);
            rule__HazardCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHazardCategoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHazardCategory"


    // $ANTLR start "entryRuleVerificationCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:314:1: entryRuleVerificationCategory : ruleVerificationCategory EOF ;
    public final void entryRuleVerificationCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:315:1: ( ruleVerificationCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:316:1: ruleVerificationCategory EOF
            {
             before(grammarAccess.getVerificationCategoryRule()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory603);
            ruleVerificationCategory();

            state._fsp--;

             after(grammarAccess.getVerificationCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategory610); 

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
    // $ANTLR end "entryRuleVerificationCategory"


    // $ANTLR start "ruleVerificationCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:323:1: ruleVerificationCategory : ( ( rule__VerificationCategory__Group__0 ) ) ;
    public final void ruleVerificationCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:327:2: ( ( ( rule__VerificationCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:328:1: ( ( rule__VerificationCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:328:1: ( ( rule__VerificationCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:329:1: ( rule__VerificationCategory__Group__0 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:330:1: ( rule__VerificationCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:330:2: rule__VerificationCategory__Group__0
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__0_in_ruleVerificationCategory636);
            rule__VerificationCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVerificationCategoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVerificationCategory"


    // $ANTLR start "entryRuleSelectionCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:342:1: entryRuleSelectionCategory : ruleSelectionCategory EOF ;
    public final void entryRuleSelectionCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:343:1: ( ruleSelectionCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:344:1: ruleSelectionCategory EOF
            {
             before(grammarAccess.getSelectionCategoryRule()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory663);
            ruleSelectionCategory();

            state._fsp--;

             after(grammarAccess.getSelectionCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategory670); 

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
    // $ANTLR end "entryRuleSelectionCategory"


    // $ANTLR start "ruleSelectionCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:351:1: ruleSelectionCategory : ( ( rule__SelectionCategory__Group__0 ) ) ;
    public final void ruleSelectionCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:355:2: ( ( ( rule__SelectionCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:356:1: ( ( rule__SelectionCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:356:1: ( ( rule__SelectionCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:357:1: ( rule__SelectionCategory__Group__0 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:358:1: ( rule__SelectionCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:358:2: rule__SelectionCategory__Group__0
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__0_in_ruleSelectionCategory696);
            rule__SelectionCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelectionCategory"


    // $ANTLR start "entryRuleAssertFailCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:370:1: entryRuleAssertFailCategory : ruleAssertFailCategory EOF ;
    public final void entryRuleAssertFailCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:371:1: ( ruleAssertFailCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:372:1: ruleAssertFailCategory EOF
            {
             before(grammarAccess.getAssertFailCategoryRule()); 
            pushFollow(FOLLOW_ruleAssertFailCategory_in_entryRuleAssertFailCategory723);
            ruleAssertFailCategory();

            state._fsp--;

             after(grammarAccess.getAssertFailCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssertFailCategory730); 

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
    // $ANTLR end "entryRuleAssertFailCategory"


    // $ANTLR start "ruleAssertFailCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:379:1: ruleAssertFailCategory : ( ( rule__AssertFailCategory__Group__0 ) ) ;
    public final void ruleAssertFailCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:383:2: ( ( ( rule__AssertFailCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:384:1: ( ( rule__AssertFailCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:384:1: ( ( rule__AssertFailCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:385:1: ( rule__AssertFailCategory__Group__0 )
            {
             before(grammarAccess.getAssertFailCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:386:1: ( rule__AssertFailCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:386:2: rule__AssertFailCategory__Group__0
            {
            pushFollow(FOLLOW_rule__AssertFailCategory__Group__0_in_ruleAssertFailCategory756);
            rule__AssertFailCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssertFailCategoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssertFailCategory"


    // $ANTLR start "entryRuleExecutionFailCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:398:1: entryRuleExecutionFailCategory : ruleExecutionFailCategory EOF ;
    public final void entryRuleExecutionFailCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:399:1: ( ruleExecutionFailCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:400:1: ruleExecutionFailCategory EOF
            {
             before(grammarAccess.getExecutionFailCategoryRule()); 
            pushFollow(FOLLOW_ruleExecutionFailCategory_in_entryRuleExecutionFailCategory783);
            ruleExecutionFailCategory();

            state._fsp--;

             after(grammarAccess.getExecutionFailCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutionFailCategory790); 

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
    // $ANTLR end "entryRuleExecutionFailCategory"


    // $ANTLR start "ruleExecutionFailCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:407:1: ruleExecutionFailCategory : ( ( rule__ExecutionFailCategory__Group__0 ) ) ;
    public final void ruleExecutionFailCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:411:2: ( ( ( rule__ExecutionFailCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:412:1: ( ( rule__ExecutionFailCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:412:1: ( ( rule__ExecutionFailCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:413:1: ( rule__ExecutionFailCategory__Group__0 )
            {
             before(grammarAccess.getExecutionFailCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:414:1: ( rule__ExecutionFailCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:414:2: rule__ExecutionFailCategory__Group__0
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategory__Group__0_in_ruleExecutionFailCategory816);
            rule__ExecutionFailCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExecutionFailCategoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExecutionFailCategory"


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:426:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:427:1: ( ruleCatRef EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:428:1: ruleCatRef EOF
            {
             before(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef843);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getCatRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef850); 

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
    // $ANTLR end "entryRuleCatRef"


    // $ANTLR start "ruleCatRef"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:435:1: ruleCatRef : ( RULE_ID ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:439:2: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:440:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:440:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:441:1: RULE_ID
            {
             before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef876); 
             after(grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCatRef"


    // $ANTLR start "rule__Categories__Alternatives"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:454:1: rule__Categories__Alternatives : ( ( ruleRequirementCategories ) | ( ruleHazardCategories ) | ( ruleVerificationCategories ) | ( ruleSelectionCategories ) | ( ruleAssertFailCategories ) | ( ruleExecutionFailCategories ) );
    public final void rule__Categories__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:458:1: ( ( ruleRequirementCategories ) | ( ruleHazardCategories ) | ( ruleVerificationCategories ) | ( ruleSelectionCategories ) | ( ruleAssertFailCategories ) | ( ruleExecutionFailCategories ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 16:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            case 18:
                {
                alt1=5;
                }
                break;
            case 19:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:459:1: ( ruleRequirementCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:459:1: ( ruleRequirementCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:460:1: ruleRequirementCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRequirementCategories_in_rule__Categories__Alternatives911);
                    ruleRequirementCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:465:6: ( ruleHazardCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:465:6: ( ruleHazardCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:466:1: ruleHazardCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getHazardCategoriesParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHazardCategories_in_rule__Categories__Alternatives928);
                    ruleHazardCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getHazardCategoriesParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:471:6: ( ruleVerificationCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:471:6: ( ruleVerificationCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:472:1: ruleVerificationCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getVerificationCategoriesParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleVerificationCategories_in_rule__Categories__Alternatives945);
                    ruleVerificationCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getVerificationCategoriesParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:477:6: ( ruleSelectionCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:477:6: ( ruleSelectionCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:478:1: ruleSelectionCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getSelectionCategoriesParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleSelectionCategories_in_rule__Categories__Alternatives962);
                    ruleSelectionCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getSelectionCategoriesParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:483:6: ( ruleAssertFailCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:483:6: ( ruleAssertFailCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:484:1: ruleAssertFailCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getAssertFailCategoriesParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleAssertFailCategories_in_rule__Categories__Alternatives979);
                    ruleAssertFailCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getAssertFailCategoriesParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:489:6: ( ruleExecutionFailCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:489:6: ( ruleExecutionFailCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:490:1: ruleExecutionFailCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getExecutionFailCategoriesParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleExecutionFailCategories_in_rule__Categories__Alternatives996);
                    ruleExecutionFailCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getExecutionFailCategoriesParserRuleCall_5()); 

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
    // $ANTLR end "rule__Categories__Alternatives"


    // $ANTLR start "rule__RequirementCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:503:1: rule__RequirementCategories__Group__0 : rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 ;
    public final void rule__RequirementCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:507:1: ( rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:508:2: rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__01027);
            rule__RequirementCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__01030);
            rule__RequirementCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__0"


    // $ANTLR start "rule__RequirementCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:515:1: rule__RequirementCategories__Group__0__Impl : ( 'requirement' ) ;
    public final void rule__RequirementCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:519:1: ( ( 'requirement' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:520:1: ( 'requirement' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:520:1: ( 'requirement' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:521:1: 'requirement'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__RequirementCategories__Group__0__Impl1058); 
             after(grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__0__Impl"


    // $ANTLR start "rule__RequirementCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:534:1: rule__RequirementCategories__Group__1 : rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 ;
    public final void rule__RequirementCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:538:1: ( rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:539:2: rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__11089);
            rule__RequirementCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__11092);
            rule__RequirementCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__1"


    // $ANTLR start "rule__RequirementCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:546:1: rule__RequirementCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__RequirementCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:550:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:551:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:551:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:552:1: 'categories'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__RequirementCategories__Group__1__Impl1120); 
             after(grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__1__Impl"


    // $ANTLR start "rule__RequirementCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:565:1: rule__RequirementCategories__Group__2 : rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 ;
    public final void rule__RequirementCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:569:1: ( rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:570:2: rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__21151);
            rule__RequirementCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__21154);
            rule__RequirementCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__2"


    // $ANTLR start "rule__RequirementCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:577:1: rule__RequirementCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__RequirementCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:581:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:582:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:582:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:583:1: '['
            {
             before(grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__RequirementCategories__Group__2__Impl1182); 
             after(grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__2__Impl"


    // $ANTLR start "rule__RequirementCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:596:1: rule__RequirementCategories__Group__3 : rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 ;
    public final void rule__RequirementCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:600:1: ( rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:601:2: rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__31213);
            rule__RequirementCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__31216);
            rule__RequirementCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__3"


    // $ANTLR start "rule__RequirementCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:608:1: rule__RequirementCategories__Group__3__Impl : ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__RequirementCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:612:1: ( ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:613:1: ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:613:1: ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:614:1: ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:614:1: ( ( rule__RequirementCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:615:1: ( rule__RequirementCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:616:1: ( rule__RequirementCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:616:2: rule__RequirementCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl1245);
            rule__RequirementCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:619:1: ( ( rule__RequirementCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:620:1: ( rule__RequirementCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:621:1: ( rule__RequirementCategories__CategoryAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:621:2: rule__RequirementCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl1257);
            	    rule__RequirementCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 

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
    // $ANTLR end "rule__RequirementCategories__Group__3__Impl"


    // $ANTLR start "rule__RequirementCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:632:1: rule__RequirementCategories__Group__4 : rule__RequirementCategories__Group__4__Impl ;
    public final void rule__RequirementCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:636:1: ( rule__RequirementCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:637:2: rule__RequirementCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__41290);
            rule__RequirementCategories__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__4"


    // $ANTLR start "rule__RequirementCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:643:1: rule__RequirementCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__RequirementCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:647:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:648:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:648:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:649:1: ']'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__RequirementCategories__Group__4__Impl1318); 
             after(grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__4__Impl"


    // $ANTLR start "rule__HazardCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:672:1: rule__HazardCategories__Group__0 : rule__HazardCategories__Group__0__Impl rule__HazardCategories__Group__1 ;
    public final void rule__HazardCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:676:1: ( rule__HazardCategories__Group__0__Impl rule__HazardCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:677:2: rule__HazardCategories__Group__0__Impl rule__HazardCategories__Group__1
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__0__Impl_in_rule__HazardCategories__Group__01359);
            rule__HazardCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__1_in_rule__HazardCategories__Group__01362);
            rule__HazardCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__Group__0"


    // $ANTLR start "rule__HazardCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:684:1: rule__HazardCategories__Group__0__Impl : ( 'hazard' ) ;
    public final void rule__HazardCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:688:1: ( ( 'hazard' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:689:1: ( 'hazard' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:689:1: ( 'hazard' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:690:1: 'hazard'
            {
             before(grammarAccess.getHazardCategoriesAccess().getHazardKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__HazardCategories__Group__0__Impl1390); 
             after(grammarAccess.getHazardCategoriesAccess().getHazardKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__Group__0__Impl"


    // $ANTLR start "rule__HazardCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:703:1: rule__HazardCategories__Group__1 : rule__HazardCategories__Group__1__Impl rule__HazardCategories__Group__2 ;
    public final void rule__HazardCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:707:1: ( rule__HazardCategories__Group__1__Impl rule__HazardCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:708:2: rule__HazardCategories__Group__1__Impl rule__HazardCategories__Group__2
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__1__Impl_in_rule__HazardCategories__Group__11421);
            rule__HazardCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__2_in_rule__HazardCategories__Group__11424);
            rule__HazardCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__Group__1"


    // $ANTLR start "rule__HazardCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:715:1: rule__HazardCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__HazardCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:719:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:720:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:720:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:721:1: 'categories'
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__HazardCategories__Group__1__Impl1452); 
             after(grammarAccess.getHazardCategoriesAccess().getCategoriesKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__Group__1__Impl"


    // $ANTLR start "rule__HazardCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:734:1: rule__HazardCategories__Group__2 : rule__HazardCategories__Group__2__Impl rule__HazardCategories__Group__3 ;
    public final void rule__HazardCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:738:1: ( rule__HazardCategories__Group__2__Impl rule__HazardCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:739:2: rule__HazardCategories__Group__2__Impl rule__HazardCategories__Group__3
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__2__Impl_in_rule__HazardCategories__Group__21483);
            rule__HazardCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__3_in_rule__HazardCategories__Group__21486);
            rule__HazardCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__Group__2"


    // $ANTLR start "rule__HazardCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:746:1: rule__HazardCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__HazardCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:750:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:751:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:751:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:752:1: '['
            {
             before(grammarAccess.getHazardCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__HazardCategories__Group__2__Impl1514); 
             after(grammarAccess.getHazardCategoriesAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__Group__2__Impl"


    // $ANTLR start "rule__HazardCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:765:1: rule__HazardCategories__Group__3 : rule__HazardCategories__Group__3__Impl rule__HazardCategories__Group__4 ;
    public final void rule__HazardCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:769:1: ( rule__HazardCategories__Group__3__Impl rule__HazardCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:770:2: rule__HazardCategories__Group__3__Impl rule__HazardCategories__Group__4
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__3__Impl_in_rule__HazardCategories__Group__31545);
            rule__HazardCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__4_in_rule__HazardCategories__Group__31548);
            rule__HazardCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__Group__3"


    // $ANTLR start "rule__HazardCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:777:1: rule__HazardCategories__Group__3__Impl : ( ( ( rule__HazardCategories__CategoryAssignment_3 ) ) ( ( rule__HazardCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__HazardCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:781:1: ( ( ( ( rule__HazardCategories__CategoryAssignment_3 ) ) ( ( rule__HazardCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:782:1: ( ( ( rule__HazardCategories__CategoryAssignment_3 ) ) ( ( rule__HazardCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:782:1: ( ( ( rule__HazardCategories__CategoryAssignment_3 ) ) ( ( rule__HazardCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:783:1: ( ( rule__HazardCategories__CategoryAssignment_3 ) ) ( ( rule__HazardCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:783:1: ( ( rule__HazardCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:784:1: ( rule__HazardCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:785:1: ( rule__HazardCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:785:2: rule__HazardCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__HazardCategories__CategoryAssignment_3_in_rule__HazardCategories__Group__3__Impl1577);
            rule__HazardCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getHazardCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:788:1: ( ( rule__HazardCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:789:1: ( rule__HazardCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:790:1: ( rule__HazardCategories__CategoryAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:790:2: rule__HazardCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__HazardCategories__CategoryAssignment_3_in_rule__HazardCategories__Group__3__Impl1589);
            	    rule__HazardCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getHazardCategoriesAccess().getCategoryAssignment_3()); 

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
    // $ANTLR end "rule__HazardCategories__Group__3__Impl"


    // $ANTLR start "rule__HazardCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:801:1: rule__HazardCategories__Group__4 : rule__HazardCategories__Group__4__Impl ;
    public final void rule__HazardCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:805:1: ( rule__HazardCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:806:2: rule__HazardCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__4__Impl_in_rule__HazardCategories__Group__41622);
            rule__HazardCategories__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__Group__4"


    // $ANTLR start "rule__HazardCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:812:1: rule__HazardCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__HazardCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:816:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:817:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:817:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:818:1: ']'
            {
             before(grammarAccess.getHazardCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__HazardCategories__Group__4__Impl1650); 
             after(grammarAccess.getHazardCategoriesAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__Group__4__Impl"


    // $ANTLR start "rule__VerificationCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:841:1: rule__VerificationCategories__Group__0 : rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1 ;
    public final void rule__VerificationCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:845:1: ( rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:846:2: rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__0__Impl_in_rule__VerificationCategories__Group__01691);
            rule__VerificationCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__1_in_rule__VerificationCategories__Group__01694);
            rule__VerificationCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__Group__0"


    // $ANTLR start "rule__VerificationCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:853:1: rule__VerificationCategories__Group__0__Impl : ( 'verification' ) ;
    public final void rule__VerificationCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:857:1: ( ( 'verification' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:858:1: ( 'verification' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:858:1: ( 'verification' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:859:1: 'verification'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getVerificationKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__VerificationCategories__Group__0__Impl1722); 
             after(grammarAccess.getVerificationCategoriesAccess().getVerificationKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__Group__0__Impl"


    // $ANTLR start "rule__VerificationCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:872:1: rule__VerificationCategories__Group__1 : rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2 ;
    public final void rule__VerificationCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:876:1: ( rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:877:2: rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__1__Impl_in_rule__VerificationCategories__Group__11753);
            rule__VerificationCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__2_in_rule__VerificationCategories__Group__11756);
            rule__VerificationCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__Group__1"


    // $ANTLR start "rule__VerificationCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:884:1: rule__VerificationCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__VerificationCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:888:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:889:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:889:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:890:1: 'categories'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__VerificationCategories__Group__1__Impl1784); 
             after(grammarAccess.getVerificationCategoriesAccess().getCategoriesKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__Group__1__Impl"


    // $ANTLR start "rule__VerificationCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:903:1: rule__VerificationCategories__Group__2 : rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3 ;
    public final void rule__VerificationCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:907:1: ( rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:908:2: rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__2__Impl_in_rule__VerificationCategories__Group__21815);
            rule__VerificationCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__3_in_rule__VerificationCategories__Group__21818);
            rule__VerificationCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__Group__2"


    // $ANTLR start "rule__VerificationCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:915:1: rule__VerificationCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__VerificationCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:919:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:920:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:920:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:921:1: '['
            {
             before(grammarAccess.getVerificationCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__VerificationCategories__Group__2__Impl1846); 
             after(grammarAccess.getVerificationCategoriesAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__Group__2__Impl"


    // $ANTLR start "rule__VerificationCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:934:1: rule__VerificationCategories__Group__3 : rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4 ;
    public final void rule__VerificationCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:938:1: ( rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:939:2: rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__3__Impl_in_rule__VerificationCategories__Group__31877);
            rule__VerificationCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__4_in_rule__VerificationCategories__Group__31880);
            rule__VerificationCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__Group__3"


    // $ANTLR start "rule__VerificationCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:946:1: rule__VerificationCategories__Group__3__Impl : ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__VerificationCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:950:1: ( ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:951:1: ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:951:1: ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:952:1: ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:952:1: ( ( rule__VerificationCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:953:1: ( rule__VerificationCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:954:1: ( rule__VerificationCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:954:2: rule__VerificationCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1909);
            rule__VerificationCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:957:1: ( ( rule__VerificationCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:958:1: ( rule__VerificationCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:959:1: ( rule__VerificationCategories__CategoryAssignment_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:959:2: rule__VerificationCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1921);
            	    rule__VerificationCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_3()); 

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
    // $ANTLR end "rule__VerificationCategories__Group__3__Impl"


    // $ANTLR start "rule__VerificationCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:970:1: rule__VerificationCategories__Group__4 : rule__VerificationCategories__Group__4__Impl ;
    public final void rule__VerificationCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:974:1: ( rule__VerificationCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:975:2: rule__VerificationCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__4__Impl_in_rule__VerificationCategories__Group__41954);
            rule__VerificationCategories__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__Group__4"


    // $ANTLR start "rule__VerificationCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:981:1: rule__VerificationCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__VerificationCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:985:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:986:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:986:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:987:1: ']'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__VerificationCategories__Group__4__Impl1982); 
             after(grammarAccess.getVerificationCategoriesAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__Group__4__Impl"


    // $ANTLR start "rule__SelectionCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1010:1: rule__SelectionCategories__Group__0 : rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 ;
    public final void rule__SelectionCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1014:1: ( rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1015:2: rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__0__Impl_in_rule__SelectionCategories__Group__02023);
            rule__SelectionCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__1_in_rule__SelectionCategories__Group__02026);
            rule__SelectionCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__0"


    // $ANTLR start "rule__SelectionCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1022:1: rule__SelectionCategories__Group__0__Impl : ( 'selection' ) ;
    public final void rule__SelectionCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1026:1: ( ( 'selection' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1027:1: ( 'selection' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1027:1: ( 'selection' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1028:1: 'selection'
            {
             before(grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__SelectionCategories__Group__0__Impl2054); 
             after(grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__0__Impl"


    // $ANTLR start "rule__SelectionCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1041:1: rule__SelectionCategories__Group__1 : rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 ;
    public final void rule__SelectionCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1045:1: ( rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1046:2: rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__1__Impl_in_rule__SelectionCategories__Group__12085);
            rule__SelectionCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__2_in_rule__SelectionCategories__Group__12088);
            rule__SelectionCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__1"


    // $ANTLR start "rule__SelectionCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1053:1: rule__SelectionCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__SelectionCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1057:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1058:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1058:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1059:1: 'categories'
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__SelectionCategories__Group__1__Impl2116); 
             after(grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__1__Impl"


    // $ANTLR start "rule__SelectionCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1072:1: rule__SelectionCategories__Group__2 : rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 ;
    public final void rule__SelectionCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1076:1: ( rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1077:2: rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__2__Impl_in_rule__SelectionCategories__Group__22147);
            rule__SelectionCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__3_in_rule__SelectionCategories__Group__22150);
            rule__SelectionCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__2"


    // $ANTLR start "rule__SelectionCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1084:1: rule__SelectionCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__SelectionCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1088:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1089:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1089:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1090:1: '['
            {
             before(grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__SelectionCategories__Group__2__Impl2178); 
             after(grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__2__Impl"


    // $ANTLR start "rule__SelectionCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1103:1: rule__SelectionCategories__Group__3 : rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 ;
    public final void rule__SelectionCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1107:1: ( rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1108:2: rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__3__Impl_in_rule__SelectionCategories__Group__32209);
            rule__SelectionCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__4_in_rule__SelectionCategories__Group__32212);
            rule__SelectionCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__3"


    // $ANTLR start "rule__SelectionCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1115:1: rule__SelectionCategories__Group__3__Impl : ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__SelectionCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1119:1: ( ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1120:1: ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1120:1: ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1121:1: ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1121:1: ( ( rule__SelectionCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1122:1: ( rule__SelectionCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1123:1: ( rule__SelectionCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1123:2: rule__SelectionCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl2241);
            rule__SelectionCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1126:1: ( ( rule__SelectionCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1127:1: ( rule__SelectionCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1128:1: ( rule__SelectionCategories__CategoryAssignment_3 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1128:2: rule__SelectionCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl2253);
            	    rule__SelectionCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_3()); 

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
    // $ANTLR end "rule__SelectionCategories__Group__3__Impl"


    // $ANTLR start "rule__SelectionCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1139:1: rule__SelectionCategories__Group__4 : rule__SelectionCategories__Group__4__Impl ;
    public final void rule__SelectionCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1143:1: ( rule__SelectionCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1144:2: rule__SelectionCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__4__Impl_in_rule__SelectionCategories__Group__42286);
            rule__SelectionCategories__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__4"


    // $ANTLR start "rule__SelectionCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1150:1: rule__SelectionCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__SelectionCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1154:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1155:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1155:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1156:1: ']'
            {
             before(grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__SelectionCategories__Group__4__Impl2314); 
             after(grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__4__Impl"


    // $ANTLR start "rule__AssertFailCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1179:1: rule__AssertFailCategories__Group__0 : rule__AssertFailCategories__Group__0__Impl rule__AssertFailCategories__Group__1 ;
    public final void rule__AssertFailCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1183:1: ( rule__AssertFailCategories__Group__0__Impl rule__AssertFailCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1184:2: rule__AssertFailCategories__Group__0__Impl rule__AssertFailCategories__Group__1
            {
            pushFollow(FOLLOW_rule__AssertFailCategories__Group__0__Impl_in_rule__AssertFailCategories__Group__02355);
            rule__AssertFailCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssertFailCategories__Group__1_in_rule__AssertFailCategories__Group__02358);
            rule__AssertFailCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategories__Group__0"


    // $ANTLR start "rule__AssertFailCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1191:1: rule__AssertFailCategories__Group__0__Impl : ( 'assertfail' ) ;
    public final void rule__AssertFailCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1195:1: ( ( 'assertfail' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1196:1: ( 'assertfail' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1196:1: ( 'assertfail' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1197:1: 'assertfail'
            {
             before(grammarAccess.getAssertFailCategoriesAccess().getAssertfailKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__AssertFailCategories__Group__0__Impl2386); 
             after(grammarAccess.getAssertFailCategoriesAccess().getAssertfailKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategories__Group__0__Impl"


    // $ANTLR start "rule__AssertFailCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1210:1: rule__AssertFailCategories__Group__1 : rule__AssertFailCategories__Group__1__Impl rule__AssertFailCategories__Group__2 ;
    public final void rule__AssertFailCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1214:1: ( rule__AssertFailCategories__Group__1__Impl rule__AssertFailCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1215:2: rule__AssertFailCategories__Group__1__Impl rule__AssertFailCategories__Group__2
            {
            pushFollow(FOLLOW_rule__AssertFailCategories__Group__1__Impl_in_rule__AssertFailCategories__Group__12417);
            rule__AssertFailCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssertFailCategories__Group__2_in_rule__AssertFailCategories__Group__12420);
            rule__AssertFailCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategories__Group__1"


    // $ANTLR start "rule__AssertFailCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1222:1: rule__AssertFailCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__AssertFailCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1226:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1227:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1227:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1228:1: 'categories'
            {
             before(grammarAccess.getAssertFailCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__AssertFailCategories__Group__1__Impl2448); 
             after(grammarAccess.getAssertFailCategoriesAccess().getCategoriesKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategories__Group__1__Impl"


    // $ANTLR start "rule__AssertFailCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1241:1: rule__AssertFailCategories__Group__2 : rule__AssertFailCategories__Group__2__Impl rule__AssertFailCategories__Group__3 ;
    public final void rule__AssertFailCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1245:1: ( rule__AssertFailCategories__Group__2__Impl rule__AssertFailCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1246:2: rule__AssertFailCategories__Group__2__Impl rule__AssertFailCategories__Group__3
            {
            pushFollow(FOLLOW_rule__AssertFailCategories__Group__2__Impl_in_rule__AssertFailCategories__Group__22479);
            rule__AssertFailCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssertFailCategories__Group__3_in_rule__AssertFailCategories__Group__22482);
            rule__AssertFailCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategories__Group__2"


    // $ANTLR start "rule__AssertFailCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1253:1: rule__AssertFailCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__AssertFailCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1257:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1258:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1258:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1259:1: '['
            {
             before(grammarAccess.getAssertFailCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__AssertFailCategories__Group__2__Impl2510); 
             after(grammarAccess.getAssertFailCategoriesAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategories__Group__2__Impl"


    // $ANTLR start "rule__AssertFailCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1272:1: rule__AssertFailCategories__Group__3 : rule__AssertFailCategories__Group__3__Impl rule__AssertFailCategories__Group__4 ;
    public final void rule__AssertFailCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1276:1: ( rule__AssertFailCategories__Group__3__Impl rule__AssertFailCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1277:2: rule__AssertFailCategories__Group__3__Impl rule__AssertFailCategories__Group__4
            {
            pushFollow(FOLLOW_rule__AssertFailCategories__Group__3__Impl_in_rule__AssertFailCategories__Group__32541);
            rule__AssertFailCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssertFailCategories__Group__4_in_rule__AssertFailCategories__Group__32544);
            rule__AssertFailCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategories__Group__3"


    // $ANTLR start "rule__AssertFailCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1284:1: rule__AssertFailCategories__Group__3__Impl : ( ( ( rule__AssertFailCategories__CategoryAssignment_3 ) ) ( ( rule__AssertFailCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__AssertFailCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1288:1: ( ( ( ( rule__AssertFailCategories__CategoryAssignment_3 ) ) ( ( rule__AssertFailCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1289:1: ( ( ( rule__AssertFailCategories__CategoryAssignment_3 ) ) ( ( rule__AssertFailCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1289:1: ( ( ( rule__AssertFailCategories__CategoryAssignment_3 ) ) ( ( rule__AssertFailCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1290:1: ( ( rule__AssertFailCategories__CategoryAssignment_3 ) ) ( ( rule__AssertFailCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1290:1: ( ( rule__AssertFailCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1291:1: ( rule__AssertFailCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getAssertFailCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1292:1: ( rule__AssertFailCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1292:2: rule__AssertFailCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__AssertFailCategories__CategoryAssignment_3_in_rule__AssertFailCategories__Group__3__Impl2573);
            rule__AssertFailCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAssertFailCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1295:1: ( ( rule__AssertFailCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1296:1: ( rule__AssertFailCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getAssertFailCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1297:1: ( rule__AssertFailCategories__CategoryAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1297:2: rule__AssertFailCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__AssertFailCategories__CategoryAssignment_3_in_rule__AssertFailCategories__Group__3__Impl2585);
            	    rule__AssertFailCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getAssertFailCategoriesAccess().getCategoryAssignment_3()); 

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
    // $ANTLR end "rule__AssertFailCategories__Group__3__Impl"


    // $ANTLR start "rule__AssertFailCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1308:1: rule__AssertFailCategories__Group__4 : rule__AssertFailCategories__Group__4__Impl ;
    public final void rule__AssertFailCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1312:1: ( rule__AssertFailCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1313:2: rule__AssertFailCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__AssertFailCategories__Group__4__Impl_in_rule__AssertFailCategories__Group__42618);
            rule__AssertFailCategories__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategories__Group__4"


    // $ANTLR start "rule__AssertFailCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1319:1: rule__AssertFailCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__AssertFailCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1323:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1324:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1324:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1325:1: ']'
            {
             before(grammarAccess.getAssertFailCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__AssertFailCategories__Group__4__Impl2646); 
             after(grammarAccess.getAssertFailCategoriesAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategories__Group__4__Impl"


    // $ANTLR start "rule__ExecutionFailCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1348:1: rule__ExecutionFailCategories__Group__0 : rule__ExecutionFailCategories__Group__0__Impl rule__ExecutionFailCategories__Group__1 ;
    public final void rule__ExecutionFailCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1352:1: ( rule__ExecutionFailCategories__Group__0__Impl rule__ExecutionFailCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1353:2: rule__ExecutionFailCategories__Group__0__Impl rule__ExecutionFailCategories__Group__1
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategories__Group__0__Impl_in_rule__ExecutionFailCategories__Group__02687);
            rule__ExecutionFailCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionFailCategories__Group__1_in_rule__ExecutionFailCategories__Group__02690);
            rule__ExecutionFailCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategories__Group__0"


    // $ANTLR start "rule__ExecutionFailCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1360:1: rule__ExecutionFailCategories__Group__0__Impl : ( 'executionfail' ) ;
    public final void rule__ExecutionFailCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1364:1: ( ( 'executionfail' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1365:1: ( 'executionfail' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1365:1: ( 'executionfail' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1366:1: 'executionfail'
            {
             before(grammarAccess.getExecutionFailCategoriesAccess().getExecutionfailKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__ExecutionFailCategories__Group__0__Impl2718); 
             after(grammarAccess.getExecutionFailCategoriesAccess().getExecutionfailKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategories__Group__0__Impl"


    // $ANTLR start "rule__ExecutionFailCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1379:1: rule__ExecutionFailCategories__Group__1 : rule__ExecutionFailCategories__Group__1__Impl rule__ExecutionFailCategories__Group__2 ;
    public final void rule__ExecutionFailCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1383:1: ( rule__ExecutionFailCategories__Group__1__Impl rule__ExecutionFailCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1384:2: rule__ExecutionFailCategories__Group__1__Impl rule__ExecutionFailCategories__Group__2
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategories__Group__1__Impl_in_rule__ExecutionFailCategories__Group__12749);
            rule__ExecutionFailCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionFailCategories__Group__2_in_rule__ExecutionFailCategories__Group__12752);
            rule__ExecutionFailCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategories__Group__1"


    // $ANTLR start "rule__ExecutionFailCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1391:1: rule__ExecutionFailCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__ExecutionFailCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1395:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1396:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1396:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1397:1: 'categories'
            {
             before(grammarAccess.getExecutionFailCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__ExecutionFailCategories__Group__1__Impl2780); 
             after(grammarAccess.getExecutionFailCategoriesAccess().getCategoriesKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategories__Group__1__Impl"


    // $ANTLR start "rule__ExecutionFailCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1410:1: rule__ExecutionFailCategories__Group__2 : rule__ExecutionFailCategories__Group__2__Impl rule__ExecutionFailCategories__Group__3 ;
    public final void rule__ExecutionFailCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1414:1: ( rule__ExecutionFailCategories__Group__2__Impl rule__ExecutionFailCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1415:2: rule__ExecutionFailCategories__Group__2__Impl rule__ExecutionFailCategories__Group__3
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategories__Group__2__Impl_in_rule__ExecutionFailCategories__Group__22811);
            rule__ExecutionFailCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionFailCategories__Group__3_in_rule__ExecutionFailCategories__Group__22814);
            rule__ExecutionFailCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategories__Group__2"


    // $ANTLR start "rule__ExecutionFailCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1422:1: rule__ExecutionFailCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__ExecutionFailCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1426:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1427:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1427:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1428:1: '['
            {
             before(grammarAccess.getExecutionFailCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__ExecutionFailCategories__Group__2__Impl2842); 
             after(grammarAccess.getExecutionFailCategoriesAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategories__Group__2__Impl"


    // $ANTLR start "rule__ExecutionFailCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1441:1: rule__ExecutionFailCategories__Group__3 : rule__ExecutionFailCategories__Group__3__Impl rule__ExecutionFailCategories__Group__4 ;
    public final void rule__ExecutionFailCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1445:1: ( rule__ExecutionFailCategories__Group__3__Impl rule__ExecutionFailCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1446:2: rule__ExecutionFailCategories__Group__3__Impl rule__ExecutionFailCategories__Group__4
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategories__Group__3__Impl_in_rule__ExecutionFailCategories__Group__32873);
            rule__ExecutionFailCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionFailCategories__Group__4_in_rule__ExecutionFailCategories__Group__32876);
            rule__ExecutionFailCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategories__Group__3"


    // $ANTLR start "rule__ExecutionFailCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1453:1: rule__ExecutionFailCategories__Group__3__Impl : ( ( ( rule__ExecutionFailCategories__CategoryAssignment_3 ) ) ( ( rule__ExecutionFailCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__ExecutionFailCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1457:1: ( ( ( ( rule__ExecutionFailCategories__CategoryAssignment_3 ) ) ( ( rule__ExecutionFailCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1458:1: ( ( ( rule__ExecutionFailCategories__CategoryAssignment_3 ) ) ( ( rule__ExecutionFailCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1458:1: ( ( ( rule__ExecutionFailCategories__CategoryAssignment_3 ) ) ( ( rule__ExecutionFailCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1459:1: ( ( rule__ExecutionFailCategories__CategoryAssignment_3 ) ) ( ( rule__ExecutionFailCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1459:1: ( ( rule__ExecutionFailCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1460:1: ( rule__ExecutionFailCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getExecutionFailCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1461:1: ( rule__ExecutionFailCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1461:2: rule__ExecutionFailCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategories__CategoryAssignment_3_in_rule__ExecutionFailCategories__Group__3__Impl2905);
            rule__ExecutionFailCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getExecutionFailCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1464:1: ( ( rule__ExecutionFailCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1465:1: ( rule__ExecutionFailCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getExecutionFailCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1466:1: ( rule__ExecutionFailCategories__CategoryAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1466:2: rule__ExecutionFailCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__ExecutionFailCategories__CategoryAssignment_3_in_rule__ExecutionFailCategories__Group__3__Impl2917);
            	    rule__ExecutionFailCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getExecutionFailCategoriesAccess().getCategoryAssignment_3()); 

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
    // $ANTLR end "rule__ExecutionFailCategories__Group__3__Impl"


    // $ANTLR start "rule__ExecutionFailCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1477:1: rule__ExecutionFailCategories__Group__4 : rule__ExecutionFailCategories__Group__4__Impl ;
    public final void rule__ExecutionFailCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1481:1: ( rule__ExecutionFailCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1482:2: rule__ExecutionFailCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategories__Group__4__Impl_in_rule__ExecutionFailCategories__Group__42950);
            rule__ExecutionFailCategories__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategories__Group__4"


    // $ANTLR start "rule__ExecutionFailCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1488:1: rule__ExecutionFailCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__ExecutionFailCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1492:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1493:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1493:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1494:1: ']'
            {
             before(grammarAccess.getExecutionFailCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__ExecutionFailCategories__Group__4__Impl2978); 
             after(grammarAccess.getExecutionFailCategoriesAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategories__Group__4__Impl"


    // $ANTLR start "rule__RequirementCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1517:1: rule__RequirementCategory__Group__0 : rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 ;
    public final void rule__RequirementCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1521:1: ( rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1522:2: rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__03019);
            rule__RequirementCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__03022);
            rule__RequirementCategory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group__0"


    // $ANTLR start "rule__RequirementCategory__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1529:1: rule__RequirementCategory__Group__0__Impl : ( ( rule__RequirementCategory__NameAssignment_0 ) ) ;
    public final void rule__RequirementCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1533:1: ( ( ( rule__RequirementCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1534:1: ( ( rule__RequirementCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1534:1: ( ( rule__RequirementCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1535:1: ( rule__RequirementCategory__NameAssignment_0 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1536:1: ( rule__RequirementCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1536:2: rule__RequirementCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__RequirementCategory__NameAssignment_0_in_rule__RequirementCategory__Group__0__Impl3049);
            rule__RequirementCategory__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoryAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group__0__Impl"


    // $ANTLR start "rule__RequirementCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1546:1: rule__RequirementCategory__Group__1 : rule__RequirementCategory__Group__1__Impl ;
    public final void rule__RequirementCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1550:1: ( rule__RequirementCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1551:2: rule__RequirementCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__13079);
            rule__RequirementCategory__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group__1"


    // $ANTLR start "rule__RequirementCategory__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1557:1: rule__RequirementCategory__Group__1__Impl : ( ( rule__RequirementCategory__Group_1__0 )? ) ;
    public final void rule__RequirementCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1561:1: ( ( ( rule__RequirementCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1562:1: ( ( rule__RequirementCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1562:1: ( ( rule__RequirementCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1563:1: ( rule__RequirementCategory__Group_1__0 )?
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1564:1: ( rule__RequirementCategory__Group_1__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1564:2: rule__RequirementCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__RequirementCategory__Group_1__0_in_rule__RequirementCategory__Group__1__Impl3106);
                    rule__RequirementCategory__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRequirementCategoryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group__1__Impl"


    // $ANTLR start "rule__RequirementCategory__Group_1__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1578:1: rule__RequirementCategory__Group_1__0 : rule__RequirementCategory__Group_1__0__Impl rule__RequirementCategory__Group_1__1 ;
    public final void rule__RequirementCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1582:1: ( rule__RequirementCategory__Group_1__0__Impl rule__RequirementCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1583:2: rule__RequirementCategory__Group_1__0__Impl rule__RequirementCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group_1__0__Impl_in_rule__RequirementCategory__Group_1__03141);
            rule__RequirementCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group_1__1_in_rule__RequirementCategory__Group_1__03144);
            rule__RequirementCategory__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group_1__0"


    // $ANTLR start "rule__RequirementCategory__Group_1__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1590:1: rule__RequirementCategory__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__RequirementCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1594:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1595:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1595:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1596:1: 'extends'
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__RequirementCategory__Group_1__0__Impl3172); 
             after(grammarAccess.getRequirementCategoryAccess().getExtendsKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group_1__0__Impl"


    // $ANTLR start "rule__RequirementCategory__Group_1__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1609:1: rule__RequirementCategory__Group_1__1 : rule__RequirementCategory__Group_1__1__Impl ;
    public final void rule__RequirementCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1613:1: ( rule__RequirementCategory__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1614:2: rule__RequirementCategory__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group_1__1__Impl_in_rule__RequirementCategory__Group_1__13203);
            rule__RequirementCategory__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group_1__1"


    // $ANTLR start "rule__RequirementCategory__Group_1__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1620:1: rule__RequirementCategory__Group_1__1__Impl : ( ( rule__RequirementCategory__ExtendsAssignment_1_1 ) ) ;
    public final void rule__RequirementCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1624:1: ( ( ( rule__RequirementCategory__ExtendsAssignment_1_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1625:1: ( ( rule__RequirementCategory__ExtendsAssignment_1_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1625:1: ( ( rule__RequirementCategory__ExtendsAssignment_1_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1626:1: ( rule__RequirementCategory__ExtendsAssignment_1_1 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1627:1: ( rule__RequirementCategory__ExtendsAssignment_1_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1627:2: rule__RequirementCategory__ExtendsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__ExtendsAssignment_1_1_in_rule__RequirementCategory__Group_1__1__Impl3230);
            rule__RequirementCategory__ExtendsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoryAccess().getExtendsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group_1__1__Impl"


    // $ANTLR start "rule__HazardCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1641:1: rule__HazardCategory__Group__0 : rule__HazardCategory__Group__0__Impl rule__HazardCategory__Group__1 ;
    public final void rule__HazardCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1645:1: ( rule__HazardCategory__Group__0__Impl rule__HazardCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1646:2: rule__HazardCategory__Group__0__Impl rule__HazardCategory__Group__1
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group__0__Impl_in_rule__HazardCategory__Group__03264);
            rule__HazardCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategory__Group__1_in_rule__HazardCategory__Group__03267);
            rule__HazardCategory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group__0"


    // $ANTLR start "rule__HazardCategory__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1653:1: rule__HazardCategory__Group__0__Impl : ( ( rule__HazardCategory__NameAssignment_0 ) ) ;
    public final void rule__HazardCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1657:1: ( ( ( rule__HazardCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1658:1: ( ( rule__HazardCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1658:1: ( ( rule__HazardCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1659:1: ( rule__HazardCategory__NameAssignment_0 )
            {
             before(grammarAccess.getHazardCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1660:1: ( rule__HazardCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1660:2: rule__HazardCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__HazardCategory__NameAssignment_0_in_rule__HazardCategory__Group__0__Impl3294);
            rule__HazardCategory__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getHazardCategoryAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group__0__Impl"


    // $ANTLR start "rule__HazardCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1670:1: rule__HazardCategory__Group__1 : rule__HazardCategory__Group__1__Impl ;
    public final void rule__HazardCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1674:1: ( rule__HazardCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1675:2: rule__HazardCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group__1__Impl_in_rule__HazardCategory__Group__13324);
            rule__HazardCategory__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group__1"


    // $ANTLR start "rule__HazardCategory__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1681:1: rule__HazardCategory__Group__1__Impl : ( ( rule__HazardCategory__Group_1__0 )? ) ;
    public final void rule__HazardCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1685:1: ( ( ( rule__HazardCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1686:1: ( ( rule__HazardCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1686:1: ( ( rule__HazardCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1687:1: ( rule__HazardCategory__Group_1__0 )?
            {
             before(grammarAccess.getHazardCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1688:1: ( rule__HazardCategory__Group_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1688:2: rule__HazardCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__HazardCategory__Group_1__0_in_rule__HazardCategory__Group__1__Impl3351);
                    rule__HazardCategory__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHazardCategoryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group__1__Impl"


    // $ANTLR start "rule__HazardCategory__Group_1__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1702:1: rule__HazardCategory__Group_1__0 : rule__HazardCategory__Group_1__0__Impl rule__HazardCategory__Group_1__1 ;
    public final void rule__HazardCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1706:1: ( rule__HazardCategory__Group_1__0__Impl rule__HazardCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1707:2: rule__HazardCategory__Group_1__0__Impl rule__HazardCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group_1__0__Impl_in_rule__HazardCategory__Group_1__03386);
            rule__HazardCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategory__Group_1__1_in_rule__HazardCategory__Group_1__03389);
            rule__HazardCategory__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group_1__0"


    // $ANTLR start "rule__HazardCategory__Group_1__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1714:1: rule__HazardCategory__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__HazardCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1718:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1719:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1719:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1720:1: 'extends'
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__HazardCategory__Group_1__0__Impl3417); 
             after(grammarAccess.getHazardCategoryAccess().getExtendsKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group_1__0__Impl"


    // $ANTLR start "rule__HazardCategory__Group_1__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1733:1: rule__HazardCategory__Group_1__1 : rule__HazardCategory__Group_1__1__Impl ;
    public final void rule__HazardCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1737:1: ( rule__HazardCategory__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1738:2: rule__HazardCategory__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group_1__1__Impl_in_rule__HazardCategory__Group_1__13448);
            rule__HazardCategory__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group_1__1"


    // $ANTLR start "rule__HazardCategory__Group_1__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1744:1: rule__HazardCategory__Group_1__1__Impl : ( ( rule__HazardCategory__ExtendsAssignment_1_1 ) ) ;
    public final void rule__HazardCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1748:1: ( ( ( rule__HazardCategory__ExtendsAssignment_1_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1749:1: ( ( rule__HazardCategory__ExtendsAssignment_1_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1749:1: ( ( rule__HazardCategory__ExtendsAssignment_1_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1750:1: ( rule__HazardCategory__ExtendsAssignment_1_1 )
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1751:1: ( rule__HazardCategory__ExtendsAssignment_1_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1751:2: rule__HazardCategory__ExtendsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__HazardCategory__ExtendsAssignment_1_1_in_rule__HazardCategory__Group_1__1__Impl3475);
            rule__HazardCategory__ExtendsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getHazardCategoryAccess().getExtendsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group_1__1__Impl"


    // $ANTLR start "rule__VerificationCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1765:1: rule__VerificationCategory__Group__0 : rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1 ;
    public final void rule__VerificationCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1769:1: ( rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1770:2: rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__0__Impl_in_rule__VerificationCategory__Group__03509);
            rule__VerificationCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategory__Group__1_in_rule__VerificationCategory__Group__03512);
            rule__VerificationCategory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group__0"


    // $ANTLR start "rule__VerificationCategory__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1777:1: rule__VerificationCategory__Group__0__Impl : ( ( rule__VerificationCategory__NameAssignment_0 ) ) ;
    public final void rule__VerificationCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1781:1: ( ( ( rule__VerificationCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1782:1: ( ( rule__VerificationCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1782:1: ( ( rule__VerificationCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1783:1: ( rule__VerificationCategory__NameAssignment_0 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1784:1: ( rule__VerificationCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1784:2: rule__VerificationCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__VerificationCategory__NameAssignment_0_in_rule__VerificationCategory__Group__0__Impl3539);
            rule__VerificationCategory__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getVerificationCategoryAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group__0__Impl"


    // $ANTLR start "rule__VerificationCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1794:1: rule__VerificationCategory__Group__1 : rule__VerificationCategory__Group__1__Impl ;
    public final void rule__VerificationCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1798:1: ( rule__VerificationCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1799:2: rule__VerificationCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__1__Impl_in_rule__VerificationCategory__Group__13569);
            rule__VerificationCategory__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group__1"


    // $ANTLR start "rule__VerificationCategory__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1805:1: rule__VerificationCategory__Group__1__Impl : ( ( rule__VerificationCategory__Group_1__0 )? ) ;
    public final void rule__VerificationCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1809:1: ( ( ( rule__VerificationCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1810:1: ( ( rule__VerificationCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1810:1: ( ( rule__VerificationCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1811:1: ( rule__VerificationCategory__Group_1__0 )?
            {
             before(grammarAccess.getVerificationCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1812:1: ( rule__VerificationCategory__Group_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1812:2: rule__VerificationCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__VerificationCategory__Group_1__0_in_rule__VerificationCategory__Group__1__Impl3596);
                    rule__VerificationCategory__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVerificationCategoryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group__1__Impl"


    // $ANTLR start "rule__VerificationCategory__Group_1__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1826:1: rule__VerificationCategory__Group_1__0 : rule__VerificationCategory__Group_1__0__Impl rule__VerificationCategory__Group_1__1 ;
    public final void rule__VerificationCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1830:1: ( rule__VerificationCategory__Group_1__0__Impl rule__VerificationCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1831:2: rule__VerificationCategory__Group_1__0__Impl rule__VerificationCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group_1__0__Impl_in_rule__VerificationCategory__Group_1__03631);
            rule__VerificationCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategory__Group_1__1_in_rule__VerificationCategory__Group_1__03634);
            rule__VerificationCategory__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group_1__0"


    // $ANTLR start "rule__VerificationCategory__Group_1__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1838:1: rule__VerificationCategory__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__VerificationCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1842:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1843:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1843:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1844:1: 'extends'
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__VerificationCategory__Group_1__0__Impl3662); 
             after(grammarAccess.getVerificationCategoryAccess().getExtendsKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group_1__0__Impl"


    // $ANTLR start "rule__VerificationCategory__Group_1__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1857:1: rule__VerificationCategory__Group_1__1 : rule__VerificationCategory__Group_1__1__Impl ;
    public final void rule__VerificationCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1861:1: ( rule__VerificationCategory__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1862:2: rule__VerificationCategory__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group_1__1__Impl_in_rule__VerificationCategory__Group_1__13693);
            rule__VerificationCategory__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group_1__1"


    // $ANTLR start "rule__VerificationCategory__Group_1__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1868:1: rule__VerificationCategory__Group_1__1__Impl : ( ( rule__VerificationCategory__ExtendsAssignment_1_1 ) ) ;
    public final void rule__VerificationCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1872:1: ( ( ( rule__VerificationCategory__ExtendsAssignment_1_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1873:1: ( ( rule__VerificationCategory__ExtendsAssignment_1_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1873:1: ( ( rule__VerificationCategory__ExtendsAssignment_1_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1874:1: ( rule__VerificationCategory__ExtendsAssignment_1_1 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1875:1: ( rule__VerificationCategory__ExtendsAssignment_1_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1875:2: rule__VerificationCategory__ExtendsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__ExtendsAssignment_1_1_in_rule__VerificationCategory__Group_1__1__Impl3720);
            rule__VerificationCategory__ExtendsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getVerificationCategoryAccess().getExtendsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group_1__1__Impl"


    // $ANTLR start "rule__SelectionCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1889:1: rule__SelectionCategory__Group__0 : rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 ;
    public final void rule__SelectionCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1893:1: ( rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1894:2: rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__0__Impl_in_rule__SelectionCategory__Group__03754);
            rule__SelectionCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategory__Group__1_in_rule__SelectionCategory__Group__03757);
            rule__SelectionCategory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__Group__0"


    // $ANTLR start "rule__SelectionCategory__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1901:1: rule__SelectionCategory__Group__0__Impl : ( ( rule__SelectionCategory__NameAssignment_0 ) ) ;
    public final void rule__SelectionCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1905:1: ( ( ( rule__SelectionCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1906:1: ( ( rule__SelectionCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1906:1: ( ( rule__SelectionCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1907:1: ( rule__SelectionCategory__NameAssignment_0 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1908:1: ( rule__SelectionCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1908:2: rule__SelectionCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__SelectionCategory__NameAssignment_0_in_rule__SelectionCategory__Group__0__Impl3784);
            rule__SelectionCategory__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoryAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__Group__0__Impl"


    // $ANTLR start "rule__SelectionCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1918:1: rule__SelectionCategory__Group__1 : rule__SelectionCategory__Group__1__Impl ;
    public final void rule__SelectionCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1922:1: ( rule__SelectionCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1923:2: rule__SelectionCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__1__Impl_in_rule__SelectionCategory__Group__13814);
            rule__SelectionCategory__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__Group__1"


    // $ANTLR start "rule__SelectionCategory__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1929:1: rule__SelectionCategory__Group__1__Impl : ( ( rule__SelectionCategory__Group_1__0 )? ) ;
    public final void rule__SelectionCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1933:1: ( ( ( rule__SelectionCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1934:1: ( ( rule__SelectionCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1934:1: ( ( rule__SelectionCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1935:1: ( rule__SelectionCategory__Group_1__0 )?
            {
             before(grammarAccess.getSelectionCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1936:1: ( rule__SelectionCategory__Group_1__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1936:2: rule__SelectionCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__SelectionCategory__Group_1__0_in_rule__SelectionCategory__Group__1__Impl3841);
                    rule__SelectionCategory__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSelectionCategoryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__Group__1__Impl"


    // $ANTLR start "rule__SelectionCategory__Group_1__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1950:1: rule__SelectionCategory__Group_1__0 : rule__SelectionCategory__Group_1__0__Impl rule__SelectionCategory__Group_1__1 ;
    public final void rule__SelectionCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1954:1: ( rule__SelectionCategory__Group_1__0__Impl rule__SelectionCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1955:2: rule__SelectionCategory__Group_1__0__Impl rule__SelectionCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group_1__0__Impl_in_rule__SelectionCategory__Group_1__03876);
            rule__SelectionCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategory__Group_1__1_in_rule__SelectionCategory__Group_1__03879);
            rule__SelectionCategory__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__Group_1__0"


    // $ANTLR start "rule__SelectionCategory__Group_1__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1962:1: rule__SelectionCategory__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__SelectionCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1966:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1967:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1967:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1968:1: 'extends'
            {
             before(grammarAccess.getSelectionCategoryAccess().getExtendsKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__SelectionCategory__Group_1__0__Impl3907); 
             after(grammarAccess.getSelectionCategoryAccess().getExtendsKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__Group_1__0__Impl"


    // $ANTLR start "rule__SelectionCategory__Group_1__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1981:1: rule__SelectionCategory__Group_1__1 : rule__SelectionCategory__Group_1__1__Impl ;
    public final void rule__SelectionCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1985:1: ( rule__SelectionCategory__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1986:2: rule__SelectionCategory__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group_1__1__Impl_in_rule__SelectionCategory__Group_1__13938);
            rule__SelectionCategory__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__Group_1__1"


    // $ANTLR start "rule__SelectionCategory__Group_1__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1992:1: rule__SelectionCategory__Group_1__1__Impl : ( ( rule__SelectionCategory__ExtendsAssignment_1_1 ) ) ;
    public final void rule__SelectionCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1996:1: ( ( ( rule__SelectionCategory__ExtendsAssignment_1_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1997:1: ( ( rule__SelectionCategory__ExtendsAssignment_1_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1997:1: ( ( rule__SelectionCategory__ExtendsAssignment_1_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1998:1: ( rule__SelectionCategory__ExtendsAssignment_1_1 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getExtendsAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1999:1: ( rule__SelectionCategory__ExtendsAssignment_1_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1999:2: rule__SelectionCategory__ExtendsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__ExtendsAssignment_1_1_in_rule__SelectionCategory__Group_1__1__Impl3965);
            rule__SelectionCategory__ExtendsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoryAccess().getExtendsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__Group_1__1__Impl"


    // $ANTLR start "rule__AssertFailCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2013:1: rule__AssertFailCategory__Group__0 : rule__AssertFailCategory__Group__0__Impl rule__AssertFailCategory__Group__1 ;
    public final void rule__AssertFailCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2017:1: ( rule__AssertFailCategory__Group__0__Impl rule__AssertFailCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2018:2: rule__AssertFailCategory__Group__0__Impl rule__AssertFailCategory__Group__1
            {
            pushFollow(FOLLOW_rule__AssertFailCategory__Group__0__Impl_in_rule__AssertFailCategory__Group__03999);
            rule__AssertFailCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssertFailCategory__Group__1_in_rule__AssertFailCategory__Group__04002);
            rule__AssertFailCategory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategory__Group__0"


    // $ANTLR start "rule__AssertFailCategory__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2025:1: rule__AssertFailCategory__Group__0__Impl : ( ( rule__AssertFailCategory__NameAssignment_0 ) ) ;
    public final void rule__AssertFailCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2029:1: ( ( ( rule__AssertFailCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2030:1: ( ( rule__AssertFailCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2030:1: ( ( rule__AssertFailCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2031:1: ( rule__AssertFailCategory__NameAssignment_0 )
            {
             before(grammarAccess.getAssertFailCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2032:1: ( rule__AssertFailCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2032:2: rule__AssertFailCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__AssertFailCategory__NameAssignment_0_in_rule__AssertFailCategory__Group__0__Impl4029);
            rule__AssertFailCategory__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAssertFailCategoryAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategory__Group__0__Impl"


    // $ANTLR start "rule__AssertFailCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2042:1: rule__AssertFailCategory__Group__1 : rule__AssertFailCategory__Group__1__Impl ;
    public final void rule__AssertFailCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2046:1: ( rule__AssertFailCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2047:2: rule__AssertFailCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AssertFailCategory__Group__1__Impl_in_rule__AssertFailCategory__Group__14059);
            rule__AssertFailCategory__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategory__Group__1"


    // $ANTLR start "rule__AssertFailCategory__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2053:1: rule__AssertFailCategory__Group__1__Impl : ( ( rule__AssertFailCategory__Group_1__0 )? ) ;
    public final void rule__AssertFailCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2057:1: ( ( ( rule__AssertFailCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2058:1: ( ( rule__AssertFailCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2058:1: ( ( rule__AssertFailCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2059:1: ( rule__AssertFailCategory__Group_1__0 )?
            {
             before(grammarAccess.getAssertFailCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2060:1: ( rule__AssertFailCategory__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2060:2: rule__AssertFailCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AssertFailCategory__Group_1__0_in_rule__AssertFailCategory__Group__1__Impl4086);
                    rule__AssertFailCategory__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssertFailCategoryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategory__Group__1__Impl"


    // $ANTLR start "rule__AssertFailCategory__Group_1__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2074:1: rule__AssertFailCategory__Group_1__0 : rule__AssertFailCategory__Group_1__0__Impl rule__AssertFailCategory__Group_1__1 ;
    public final void rule__AssertFailCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2078:1: ( rule__AssertFailCategory__Group_1__0__Impl rule__AssertFailCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2079:2: rule__AssertFailCategory__Group_1__0__Impl rule__AssertFailCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__AssertFailCategory__Group_1__0__Impl_in_rule__AssertFailCategory__Group_1__04121);
            rule__AssertFailCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssertFailCategory__Group_1__1_in_rule__AssertFailCategory__Group_1__04124);
            rule__AssertFailCategory__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategory__Group_1__0"


    // $ANTLR start "rule__AssertFailCategory__Group_1__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2086:1: rule__AssertFailCategory__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__AssertFailCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2090:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2091:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2091:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2092:1: 'extends'
            {
             before(grammarAccess.getAssertFailCategoryAccess().getExtendsKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__AssertFailCategory__Group_1__0__Impl4152); 
             after(grammarAccess.getAssertFailCategoryAccess().getExtendsKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategory__Group_1__0__Impl"


    // $ANTLR start "rule__AssertFailCategory__Group_1__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2105:1: rule__AssertFailCategory__Group_1__1 : rule__AssertFailCategory__Group_1__1__Impl ;
    public final void rule__AssertFailCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2109:1: ( rule__AssertFailCategory__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2110:2: rule__AssertFailCategory__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AssertFailCategory__Group_1__1__Impl_in_rule__AssertFailCategory__Group_1__14183);
            rule__AssertFailCategory__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategory__Group_1__1"


    // $ANTLR start "rule__AssertFailCategory__Group_1__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2116:1: rule__AssertFailCategory__Group_1__1__Impl : ( ( rule__AssertFailCategory__ExtendsAssignment_1_1 ) ) ;
    public final void rule__AssertFailCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2120:1: ( ( ( rule__AssertFailCategory__ExtendsAssignment_1_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2121:1: ( ( rule__AssertFailCategory__ExtendsAssignment_1_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2121:1: ( ( rule__AssertFailCategory__ExtendsAssignment_1_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2122:1: ( rule__AssertFailCategory__ExtendsAssignment_1_1 )
            {
             before(grammarAccess.getAssertFailCategoryAccess().getExtendsAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2123:1: ( rule__AssertFailCategory__ExtendsAssignment_1_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2123:2: rule__AssertFailCategory__ExtendsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AssertFailCategory__ExtendsAssignment_1_1_in_rule__AssertFailCategory__Group_1__1__Impl4210);
            rule__AssertFailCategory__ExtendsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAssertFailCategoryAccess().getExtendsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategory__Group_1__1__Impl"


    // $ANTLR start "rule__ExecutionFailCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2137:1: rule__ExecutionFailCategory__Group__0 : rule__ExecutionFailCategory__Group__0__Impl rule__ExecutionFailCategory__Group__1 ;
    public final void rule__ExecutionFailCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2141:1: ( rule__ExecutionFailCategory__Group__0__Impl rule__ExecutionFailCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2142:2: rule__ExecutionFailCategory__Group__0__Impl rule__ExecutionFailCategory__Group__1
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategory__Group__0__Impl_in_rule__ExecutionFailCategory__Group__04244);
            rule__ExecutionFailCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionFailCategory__Group__1_in_rule__ExecutionFailCategory__Group__04247);
            rule__ExecutionFailCategory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategory__Group__0"


    // $ANTLR start "rule__ExecutionFailCategory__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2149:1: rule__ExecutionFailCategory__Group__0__Impl : ( ( rule__ExecutionFailCategory__NameAssignment_0 ) ) ;
    public final void rule__ExecutionFailCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2153:1: ( ( ( rule__ExecutionFailCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2154:1: ( ( rule__ExecutionFailCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2154:1: ( ( rule__ExecutionFailCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2155:1: ( rule__ExecutionFailCategory__NameAssignment_0 )
            {
             before(grammarAccess.getExecutionFailCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2156:1: ( rule__ExecutionFailCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2156:2: rule__ExecutionFailCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategory__NameAssignment_0_in_rule__ExecutionFailCategory__Group__0__Impl4274);
            rule__ExecutionFailCategory__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getExecutionFailCategoryAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategory__Group__0__Impl"


    // $ANTLR start "rule__ExecutionFailCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2166:1: rule__ExecutionFailCategory__Group__1 : rule__ExecutionFailCategory__Group__1__Impl ;
    public final void rule__ExecutionFailCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2170:1: ( rule__ExecutionFailCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2171:2: rule__ExecutionFailCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategory__Group__1__Impl_in_rule__ExecutionFailCategory__Group__14304);
            rule__ExecutionFailCategory__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategory__Group__1"


    // $ANTLR start "rule__ExecutionFailCategory__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2177:1: rule__ExecutionFailCategory__Group__1__Impl : ( ( rule__ExecutionFailCategory__Group_1__0 )? ) ;
    public final void rule__ExecutionFailCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2181:1: ( ( ( rule__ExecutionFailCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2182:1: ( ( rule__ExecutionFailCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2182:1: ( ( rule__ExecutionFailCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2183:1: ( rule__ExecutionFailCategory__Group_1__0 )?
            {
             before(grammarAccess.getExecutionFailCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2184:1: ( rule__ExecutionFailCategory__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2184:2: rule__ExecutionFailCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ExecutionFailCategory__Group_1__0_in_rule__ExecutionFailCategory__Group__1__Impl4331);
                    rule__ExecutionFailCategory__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExecutionFailCategoryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategory__Group__1__Impl"


    // $ANTLR start "rule__ExecutionFailCategory__Group_1__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2198:1: rule__ExecutionFailCategory__Group_1__0 : rule__ExecutionFailCategory__Group_1__0__Impl rule__ExecutionFailCategory__Group_1__1 ;
    public final void rule__ExecutionFailCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2202:1: ( rule__ExecutionFailCategory__Group_1__0__Impl rule__ExecutionFailCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2203:2: rule__ExecutionFailCategory__Group_1__0__Impl rule__ExecutionFailCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategory__Group_1__0__Impl_in_rule__ExecutionFailCategory__Group_1__04366);
            rule__ExecutionFailCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionFailCategory__Group_1__1_in_rule__ExecutionFailCategory__Group_1__04369);
            rule__ExecutionFailCategory__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategory__Group_1__0"


    // $ANTLR start "rule__ExecutionFailCategory__Group_1__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2210:1: rule__ExecutionFailCategory__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__ExecutionFailCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2214:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2215:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2215:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2216:1: 'extends'
            {
             before(grammarAccess.getExecutionFailCategoryAccess().getExtendsKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__ExecutionFailCategory__Group_1__0__Impl4397); 
             after(grammarAccess.getExecutionFailCategoryAccess().getExtendsKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategory__Group_1__0__Impl"


    // $ANTLR start "rule__ExecutionFailCategory__Group_1__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2229:1: rule__ExecutionFailCategory__Group_1__1 : rule__ExecutionFailCategory__Group_1__1__Impl ;
    public final void rule__ExecutionFailCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2233:1: ( rule__ExecutionFailCategory__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2234:2: rule__ExecutionFailCategory__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategory__Group_1__1__Impl_in_rule__ExecutionFailCategory__Group_1__14428);
            rule__ExecutionFailCategory__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategory__Group_1__1"


    // $ANTLR start "rule__ExecutionFailCategory__Group_1__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2240:1: rule__ExecutionFailCategory__Group_1__1__Impl : ( ( rule__ExecutionFailCategory__ExtendsAssignment_1_1 ) ) ;
    public final void rule__ExecutionFailCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2244:1: ( ( ( rule__ExecutionFailCategory__ExtendsAssignment_1_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2245:1: ( ( rule__ExecutionFailCategory__ExtendsAssignment_1_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2245:1: ( ( rule__ExecutionFailCategory__ExtendsAssignment_1_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2246:1: ( rule__ExecutionFailCategory__ExtendsAssignment_1_1 )
            {
             before(grammarAccess.getExecutionFailCategoryAccess().getExtendsAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2247:1: ( rule__ExecutionFailCategory__ExtendsAssignment_1_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2247:2: rule__ExecutionFailCategory__ExtendsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ExecutionFailCategory__ExtendsAssignment_1_1_in_rule__ExecutionFailCategory__Group_1__1__Impl4455);
            rule__ExecutionFailCategory__ExtendsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExecutionFailCategoryAccess().getExtendsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategory__Group_1__1__Impl"


    // $ANTLR start "rule__RequirementCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2262:1: rule__RequirementCategories__CategoryAssignment_3 : ( ruleRequirementCategory ) ;
    public final void rule__RequirementCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2266:1: ( ( ruleRequirementCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2267:1: ( ruleRequirementCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2267:1: ( ruleRequirementCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2268:1: ruleRequirementCategory
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_34494);
            ruleRequirementCategory();

            state._fsp--;

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__CategoryAssignment_3"


    // $ANTLR start "rule__HazardCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2277:1: rule__HazardCategories__CategoryAssignment_3 : ( ruleHazardCategory ) ;
    public final void rule__HazardCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2281:1: ( ( ruleHazardCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2282:1: ( ruleHazardCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2282:1: ( ruleHazardCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2283:1: ruleHazardCategory
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoryHazardCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleHazardCategory_in_rule__HazardCategories__CategoryAssignment_34525);
            ruleHazardCategory();

            state._fsp--;

             after(grammarAccess.getHazardCategoriesAccess().getCategoryHazardCategoryParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__CategoryAssignment_3"


    // $ANTLR start "rule__VerificationCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2292:1: rule__VerificationCategories__CategoryAssignment_3 : ( ruleVerificationCategory ) ;
    public final void rule__VerificationCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2296:1: ( ( ruleVerificationCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2297:1: ( ruleVerificationCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2297:1: ( ruleVerificationCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2298:1: ruleVerificationCategory
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryVerificationCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_rule__VerificationCategories__CategoryAssignment_34556);
            ruleVerificationCategory();

            state._fsp--;

             after(grammarAccess.getVerificationCategoriesAccess().getCategoryVerificationCategoryParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__CategoryAssignment_3"


    // $ANTLR start "rule__SelectionCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2307:1: rule__SelectionCategories__CategoryAssignment_3 : ( ruleSelectionCategory ) ;
    public final void rule__SelectionCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2311:1: ( ( ruleSelectionCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2312:1: ( ruleSelectionCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2312:1: ( ruleSelectionCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2313:1: ruleSelectionCategory
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_rule__SelectionCategories__CategoryAssignment_34587);
            ruleSelectionCategory();

            state._fsp--;

             after(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__CategoryAssignment_3"


    // $ANTLR start "rule__AssertFailCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2322:1: rule__AssertFailCategories__CategoryAssignment_3 : ( ruleAssertFailCategory ) ;
    public final void rule__AssertFailCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2326:1: ( ( ruleAssertFailCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2327:1: ( ruleAssertFailCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2327:1: ( ruleAssertFailCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2328:1: ruleAssertFailCategory
            {
             before(grammarAccess.getAssertFailCategoriesAccess().getCategoryAssertFailCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleAssertFailCategory_in_rule__AssertFailCategories__CategoryAssignment_34618);
            ruleAssertFailCategory();

            state._fsp--;

             after(grammarAccess.getAssertFailCategoriesAccess().getCategoryAssertFailCategoryParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategories__CategoryAssignment_3"


    // $ANTLR start "rule__ExecutionFailCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2337:1: rule__ExecutionFailCategories__CategoryAssignment_3 : ( ruleExecutionFailCategory ) ;
    public final void rule__ExecutionFailCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2341:1: ( ( ruleExecutionFailCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2342:1: ( ruleExecutionFailCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2342:1: ( ruleExecutionFailCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2343:1: ruleExecutionFailCategory
            {
             before(grammarAccess.getExecutionFailCategoriesAccess().getCategoryExecutionFailCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleExecutionFailCategory_in_rule__ExecutionFailCategories__CategoryAssignment_34649);
            ruleExecutionFailCategory();

            state._fsp--;

             after(grammarAccess.getExecutionFailCategoriesAccess().getCategoryExecutionFailCategoryParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategories__CategoryAssignment_3"


    // $ANTLR start "rule__RequirementCategory__NameAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2352:1: rule__RequirementCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__RequirementCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2356:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2357:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2357:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2358:1: RULE_ID
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_04680); 
             after(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__NameAssignment_0"


    // $ANTLR start "rule__RequirementCategory__ExtendsAssignment_1_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2367:1: rule__RequirementCategory__ExtendsAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__RequirementCategory__ExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2371:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2372:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2372:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2373:1: ( ruleCatRef )
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2374:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2375:1: ruleCatRef
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__RequirementCategory__ExtendsAssignment_1_14715);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCatRefParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__ExtendsAssignment_1_1"


    // $ANTLR start "rule__HazardCategory__NameAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2386:1: rule__HazardCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HazardCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2390:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2391:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2391:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2392:1: RULE_ID
            {
             before(grammarAccess.getHazardCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__HazardCategory__NameAssignment_04750); 
             after(grammarAccess.getHazardCategoryAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__NameAssignment_0"


    // $ANTLR start "rule__HazardCategory__ExtendsAssignment_1_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2401:1: rule__HazardCategory__ExtendsAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__HazardCategory__ExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2405:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2406:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2406:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2407:1: ( ruleCatRef )
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2408:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2409:1: ruleCatRef
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__HazardCategory__ExtendsAssignment_1_14785);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCatRefParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__ExtendsAssignment_1_1"


    // $ANTLR start "rule__VerificationCategory__NameAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2420:1: rule__VerificationCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__VerificationCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2424:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2425:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2425:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2426:1: RULE_ID
            {
             before(grammarAccess.getVerificationCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VerificationCategory__NameAssignment_04820); 
             after(grammarAccess.getVerificationCategoryAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__NameAssignment_0"


    // $ANTLR start "rule__VerificationCategory__ExtendsAssignment_1_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2435:1: rule__VerificationCategory__ExtendsAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__VerificationCategory__ExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2439:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2440:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2440:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2441:1: ( ruleCatRef )
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2442:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2443:1: ruleCatRef
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__VerificationCategory__ExtendsAssignment_1_14855);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCatRefParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__ExtendsAssignment_1_1"


    // $ANTLR start "rule__SelectionCategory__NameAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2454:1: rule__SelectionCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__SelectionCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2458:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2459:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2459:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2460:1: RULE_ID
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectionCategory__NameAssignment_04890); 
             after(grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__NameAssignment_0"


    // $ANTLR start "rule__SelectionCategory__ExtendsAssignment_1_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2469:1: rule__SelectionCategory__ExtendsAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__SelectionCategory__ExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2473:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2474:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2474:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2475:1: ( ruleCatRef )
            {
             before(grammarAccess.getSelectionCategoryAccess().getExtendsSelectionCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2476:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2477:1: ruleCatRef
            {
             before(grammarAccess.getSelectionCategoryAccess().getExtendsSelectionCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__SelectionCategory__ExtendsAssignment_1_14925);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getSelectionCategoryAccess().getExtendsSelectionCategoryCatRefParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getSelectionCategoryAccess().getExtendsSelectionCategoryCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__ExtendsAssignment_1_1"


    // $ANTLR start "rule__AssertFailCategory__NameAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2488:1: rule__AssertFailCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__AssertFailCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2492:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2493:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2493:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2494:1: RULE_ID
            {
             before(grammarAccess.getAssertFailCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AssertFailCategory__NameAssignment_04960); 
             after(grammarAccess.getAssertFailCategoryAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategory__NameAssignment_0"


    // $ANTLR start "rule__AssertFailCategory__ExtendsAssignment_1_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2503:1: rule__AssertFailCategory__ExtendsAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__AssertFailCategory__ExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2507:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2508:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2508:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2509:1: ( ruleCatRef )
            {
             before(grammarAccess.getAssertFailCategoryAccess().getExtendsAssertFailCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2510:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2511:1: ruleCatRef
            {
             before(grammarAccess.getAssertFailCategoryAccess().getExtendsAssertFailCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__AssertFailCategory__ExtendsAssignment_1_14995);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getAssertFailCategoryAccess().getExtendsAssertFailCategoryCatRefParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getAssertFailCategoryAccess().getExtendsAssertFailCategoryCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssertFailCategory__ExtendsAssignment_1_1"


    // $ANTLR start "rule__ExecutionFailCategory__NameAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2522:1: rule__ExecutionFailCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ExecutionFailCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2526:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2527:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2527:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2528:1: RULE_ID
            {
             before(grammarAccess.getExecutionFailCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ExecutionFailCategory__NameAssignment_05030); 
             after(grammarAccess.getExecutionFailCategoryAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategory__NameAssignment_0"


    // $ANTLR start "rule__ExecutionFailCategory__ExtendsAssignment_1_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2537:1: rule__ExecutionFailCategory__ExtendsAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__ExecutionFailCategory__ExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2541:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2542:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2542:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2543:1: ( ruleCatRef )
            {
             before(grammarAccess.getExecutionFailCategoryAccess().getExtendsExecutionFailCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2544:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2545:1: ruleCatRef
            {
             before(grammarAccess.getExecutionFailCategoryAccess().getExtendsExecutionFailCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__ExecutionFailCategory__ExtendsAssignment_1_15065);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getExecutionFailCategoryAccess().getExtendsExecutionFailCategoryCatRefParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getExecutionFailCategoryAccess().getExtendsExecutionFailCategoryCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionFailCategory__ExtendsAssignment_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategories_in_entryRuleCategories61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategories68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Categories__Alternatives_in_ruleCategories94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategories128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__0_in_ruleRequirementCategories154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategories_in_entryRuleHazardCategories181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategories188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__0_in_ruleHazardCategories214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategories248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__0_in_ruleVerificationCategories274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategories308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__0_in_ruleSelectionCategories334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssertFailCategories_in_entryRuleAssertFailCategories361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssertFailCategories368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__Group__0_in_ruleAssertFailCategories394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionFailCategories_in_entryRuleExecutionFailCategories421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutionFailCategories428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__Group__0_in_ruleExecutionFailCategories454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategory550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__0_in_ruleHazardCategory576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategory610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__0_in_ruleVerificationCategory636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory663 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategory670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__0_in_ruleSelectionCategory696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssertFailCategory_in_entryRuleAssertFailCategory723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssertFailCategory730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategory__Group__0_in_ruleAssertFailCategory756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionFailCategory_in_entryRuleExecutionFailCategory783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutionFailCategory790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategory__Group__0_in_ruleExecutionFailCategory816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_rule__Categories__Alternatives911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategories_in_rule__Categories__Alternatives928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_rule__Categories__Alternatives945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_rule__Categories__Alternatives962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssertFailCategories_in_rule__Categories__Alternatives979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionFailCategories_in_rule__Categories__Alternatives996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__01027 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__01030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__RequirementCategories__Group__0__Impl1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__11089 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__11092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__RequirementCategories__Group__1__Impl1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__21151 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__21154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__RequirementCategories__Group__2__Impl1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__31213 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__31216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl1245 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl1257 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__41290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__RequirementCategories__Group__4__Impl1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__0__Impl_in_rule__HazardCategories__Group__01359 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__1_in_rule__HazardCategories__Group__01362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__HazardCategories__Group__0__Impl1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__1__Impl_in_rule__HazardCategories__Group__11421 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__2_in_rule__HazardCategories__Group__11424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__HazardCategories__Group__1__Impl1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__2__Impl_in_rule__HazardCategories__Group__21483 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__3_in_rule__HazardCategories__Group__21486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__HazardCategories__Group__2__Impl1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__3__Impl_in_rule__HazardCategories__Group__31545 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__4_in_rule__HazardCategories__Group__31548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__CategoryAssignment_3_in_rule__HazardCategories__Group__3__Impl1577 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__HazardCategories__CategoryAssignment_3_in_rule__HazardCategories__Group__3__Impl1589 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__4__Impl_in_rule__HazardCategories__Group__41622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__HazardCategories__Group__4__Impl1650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__0__Impl_in_rule__VerificationCategories__Group__01691 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__1_in_rule__VerificationCategories__Group__01694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VerificationCategories__Group__0__Impl1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__1__Impl_in_rule__VerificationCategories__Group__11753 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__2_in_rule__VerificationCategories__Group__11756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__VerificationCategories__Group__1__Impl1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__2__Impl_in_rule__VerificationCategories__Group__21815 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__3_in_rule__VerificationCategories__Group__21818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VerificationCategories__Group__2__Impl1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__3__Impl_in_rule__VerificationCategories__Group__31877 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__4_in_rule__VerificationCategories__Group__31880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1909 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1921 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__4__Impl_in_rule__VerificationCategories__Group__41954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VerificationCategories__Group__4__Impl1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__0__Impl_in_rule__SelectionCategories__Group__02023 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__1_in_rule__SelectionCategories__Group__02026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SelectionCategories__Group__0__Impl2054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__1__Impl_in_rule__SelectionCategories__Group__12085 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__2_in_rule__SelectionCategories__Group__12088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__SelectionCategories__Group__1__Impl2116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__2__Impl_in_rule__SelectionCategories__Group__22147 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__3_in_rule__SelectionCategories__Group__22150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__SelectionCategories__Group__2__Impl2178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__3__Impl_in_rule__SelectionCategories__Group__32209 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__4_in_rule__SelectionCategories__Group__32212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl2241 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl2253 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__4__Impl_in_rule__SelectionCategories__Group__42286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__SelectionCategories__Group__4__Impl2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__Group__0__Impl_in_rule__AssertFailCategories__Group__02355 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__Group__1_in_rule__AssertFailCategories__Group__02358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__AssertFailCategories__Group__0__Impl2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__Group__1__Impl_in_rule__AssertFailCategories__Group__12417 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__Group__2_in_rule__AssertFailCategories__Group__12420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__AssertFailCategories__Group__1__Impl2448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__Group__2__Impl_in_rule__AssertFailCategories__Group__22479 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__Group__3_in_rule__AssertFailCategories__Group__22482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__AssertFailCategories__Group__2__Impl2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__Group__3__Impl_in_rule__AssertFailCategories__Group__32541 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__Group__4_in_rule__AssertFailCategories__Group__32544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__CategoryAssignment_3_in_rule__AssertFailCategories__Group__3__Impl2573 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__CategoryAssignment_3_in_rule__AssertFailCategories__Group__3__Impl2585 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__AssertFailCategories__Group__4__Impl_in_rule__AssertFailCategories__Group__42618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__AssertFailCategories__Group__4__Impl2646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__Group__0__Impl_in_rule__ExecutionFailCategories__Group__02687 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__Group__1_in_rule__ExecutionFailCategories__Group__02690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ExecutionFailCategories__Group__0__Impl2718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__Group__1__Impl_in_rule__ExecutionFailCategories__Group__12749 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__Group__2_in_rule__ExecutionFailCategories__Group__12752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ExecutionFailCategories__Group__1__Impl2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__Group__2__Impl_in_rule__ExecutionFailCategories__Group__22811 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__Group__3_in_rule__ExecutionFailCategories__Group__22814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ExecutionFailCategories__Group__2__Impl2842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__Group__3__Impl_in_rule__ExecutionFailCategories__Group__32873 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__Group__4_in_rule__ExecutionFailCategories__Group__32876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__CategoryAssignment_3_in_rule__ExecutionFailCategories__Group__3__Impl2905 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__CategoryAssignment_3_in_rule__ExecutionFailCategories__Group__3__Impl2917 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategories__Group__4__Impl_in_rule__ExecutionFailCategories__Group__42950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ExecutionFailCategories__Group__4__Impl2978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__03019 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__03022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__NameAssignment_0_in_rule__RequirementCategory__Group__0__Impl3049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__13079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__0_in_rule__RequirementCategory__Group__1__Impl3106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__0__Impl_in_rule__RequirementCategory__Group_1__03141 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__1_in_rule__RequirementCategory__Group_1__03144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__RequirementCategory__Group_1__0__Impl3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__1__Impl_in_rule__RequirementCategory__Group_1__13203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__ExtendsAssignment_1_1_in_rule__RequirementCategory__Group_1__1__Impl3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__0__Impl_in_rule__HazardCategory__Group__03264 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__1_in_rule__HazardCategory__Group__03267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__NameAssignment_0_in_rule__HazardCategory__Group__0__Impl3294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__1__Impl_in_rule__HazardCategory__Group__13324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_1__0_in_rule__HazardCategory__Group__1__Impl3351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_1__0__Impl_in_rule__HazardCategory__Group_1__03386 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_1__1_in_rule__HazardCategory__Group_1__03389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__HazardCategory__Group_1__0__Impl3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_1__1__Impl_in_rule__HazardCategory__Group_1__13448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__ExtendsAssignment_1_1_in_rule__HazardCategory__Group_1__1__Impl3475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__0__Impl_in_rule__VerificationCategory__Group__03509 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__1_in_rule__VerificationCategory__Group__03512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__NameAssignment_0_in_rule__VerificationCategory__Group__0__Impl3539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__1__Impl_in_rule__VerificationCategory__Group__13569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_1__0_in_rule__VerificationCategory__Group__1__Impl3596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_1__0__Impl_in_rule__VerificationCategory__Group_1__03631 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_1__1_in_rule__VerificationCategory__Group_1__03634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__VerificationCategory__Group_1__0__Impl3662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_1__1__Impl_in_rule__VerificationCategory__Group_1__13693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__ExtendsAssignment_1_1_in_rule__VerificationCategory__Group_1__1__Impl3720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__0__Impl_in_rule__SelectionCategory__Group__03754 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__1_in_rule__SelectionCategory__Group__03757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__NameAssignment_0_in_rule__SelectionCategory__Group__0__Impl3784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__1__Impl_in_rule__SelectionCategory__Group__13814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__0_in_rule__SelectionCategory__Group__1__Impl3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__0__Impl_in_rule__SelectionCategory__Group_1__03876 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__1_in_rule__SelectionCategory__Group_1__03879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SelectionCategory__Group_1__0__Impl3907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__1__Impl_in_rule__SelectionCategory__Group_1__13938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__ExtendsAssignment_1_1_in_rule__SelectionCategory__Group_1__1__Impl3965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategory__Group__0__Impl_in_rule__AssertFailCategory__Group__03999 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__AssertFailCategory__Group__1_in_rule__AssertFailCategory__Group__04002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategory__NameAssignment_0_in_rule__AssertFailCategory__Group__0__Impl4029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategory__Group__1__Impl_in_rule__AssertFailCategory__Group__14059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategory__Group_1__0_in_rule__AssertFailCategory__Group__1__Impl4086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategory__Group_1__0__Impl_in_rule__AssertFailCategory__Group_1__04121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__AssertFailCategory__Group_1__1_in_rule__AssertFailCategory__Group_1__04124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__AssertFailCategory__Group_1__0__Impl4152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategory__Group_1__1__Impl_in_rule__AssertFailCategory__Group_1__14183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssertFailCategory__ExtendsAssignment_1_1_in_rule__AssertFailCategory__Group_1__1__Impl4210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategory__Group__0__Impl_in_rule__ExecutionFailCategory__Group__04244 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategory__Group__1_in_rule__ExecutionFailCategory__Group__04247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategory__NameAssignment_0_in_rule__ExecutionFailCategory__Group__0__Impl4274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategory__Group__1__Impl_in_rule__ExecutionFailCategory__Group__14304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategory__Group_1__0_in_rule__ExecutionFailCategory__Group__1__Impl4331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategory__Group_1__0__Impl_in_rule__ExecutionFailCategory__Group_1__04366 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategory__Group_1__1_in_rule__ExecutionFailCategory__Group_1__04369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ExecutionFailCategory__Group_1__0__Impl4397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategory__Group_1__1__Impl_in_rule__ExecutionFailCategory__Group_1__14428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionFailCategory__ExtendsAssignment_1_1_in_rule__ExecutionFailCategory__Group_1__1__Impl4455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_34494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_rule__HazardCategories__CategoryAssignment_34525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_rule__VerificationCategories__CategoryAssignment_34556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_rule__SelectionCategories__CategoryAssignment_34587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssertFailCategory_in_rule__AssertFailCategories__CategoryAssignment_34618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionFailCategory_in_rule__ExecutionFailCategories__CategoryAssignment_34649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_04680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__RequirementCategory__ExtendsAssignment_1_14715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__HazardCategory__NameAssignment_04750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__HazardCategory__ExtendsAssignment_1_14785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VerificationCategory__NameAssignment_04820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__VerificationCategory__ExtendsAssignment_1_14855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectionCategory__NameAssignment_04890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__SelectionCategory__ExtendsAssignment_1_14925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AssertFailCategory__NameAssignment_04960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__AssertFailCategory__ExtendsAssignment_1_14995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ExecutionFailCategory__NameAssignment_05030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__ExecutionFailCategory__ExtendsAssignment_1_15065 = new BitSet(new long[]{0x0000000000000002L});

}
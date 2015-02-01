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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requirement'", "'categories'", "'['", "']'", "'verification'", "'selection'", "'extends'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
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


    // $ANTLR start "entryRuleVerificationCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:116:1: entryRuleVerificationCategories : ruleVerificationCategories EOF ;
    public final void entryRuleVerificationCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:117:1: ( ruleVerificationCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:118:1: ruleVerificationCategories EOF
            {
             before(grammarAccess.getVerificationCategoriesRule()); 
            pushFollow(FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories181);
            ruleVerificationCategories();

            state._fsp--;

             after(grammarAccess.getVerificationCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategories188); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:125:1: ruleVerificationCategories : ( ( rule__VerificationCategories__Group__0 ) ) ;
    public final void ruleVerificationCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:129:2: ( ( ( rule__VerificationCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:130:1: ( ( rule__VerificationCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:130:1: ( ( rule__VerificationCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:131:1: ( rule__VerificationCategories__Group__0 )
            {
             before(grammarAccess.getVerificationCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:132:1: ( rule__VerificationCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:132:2: rule__VerificationCategories__Group__0
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__0_in_ruleVerificationCategories214);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:144:1: entryRuleSelectionCategories : ruleSelectionCategories EOF ;
    public final void entryRuleSelectionCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:145:1: ( ruleSelectionCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:146:1: ruleSelectionCategories EOF
            {
             before(grammarAccess.getSelectionCategoriesRule()); 
            pushFollow(FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories241);
            ruleSelectionCategories();

            state._fsp--;

             after(grammarAccess.getSelectionCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategories248); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:153:1: ruleSelectionCategories : ( ( rule__SelectionCategories__Group__0 ) ) ;
    public final void ruleSelectionCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:157:2: ( ( ( rule__SelectionCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:158:1: ( ( rule__SelectionCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:158:1: ( ( rule__SelectionCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:159:1: ( rule__SelectionCategories__Group__0 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:160:1: ( rule__SelectionCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:160:2: rule__SelectionCategories__Group__0
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__0_in_ruleSelectionCategories274);
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


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:174:1: entryRuleRequirementCategory : ruleRequirementCategory EOF ;
    public final void entryRuleRequirementCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:175:1: ( ruleRequirementCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:176:1: ruleRequirementCategory EOF
            {
             before(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory303);
            ruleRequirementCategory();

            state._fsp--;

             after(grammarAccess.getRequirementCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory310); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:183:1: ruleRequirementCategory : ( ( rule__RequirementCategory__Group__0 ) ) ;
    public final void ruleRequirementCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:187:2: ( ( ( rule__RequirementCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:188:1: ( ( rule__RequirementCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:188:1: ( ( rule__RequirementCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:189:1: ( rule__RequirementCategory__Group__0 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:190:1: ( rule__RequirementCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:190:2: rule__RequirementCategory__Group__0
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory336);
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


    // $ANTLR start "entryRuleVerificationCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:202:1: entryRuleVerificationCategory : ruleVerificationCategory EOF ;
    public final void entryRuleVerificationCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:203:1: ( ruleVerificationCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:204:1: ruleVerificationCategory EOF
            {
             before(grammarAccess.getVerificationCategoryRule()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory363);
            ruleVerificationCategory();

            state._fsp--;

             after(grammarAccess.getVerificationCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategory370); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:211:1: ruleVerificationCategory : ( ( rule__VerificationCategory__Group__0 ) ) ;
    public final void ruleVerificationCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:215:2: ( ( ( rule__VerificationCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:216:1: ( ( rule__VerificationCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:216:1: ( ( rule__VerificationCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:217:1: ( rule__VerificationCategory__Group__0 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:218:1: ( rule__VerificationCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:218:2: rule__VerificationCategory__Group__0
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__0_in_ruleVerificationCategory396);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:230:1: entryRuleSelectionCategory : ruleSelectionCategory EOF ;
    public final void entryRuleSelectionCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:231:1: ( ruleSelectionCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:232:1: ruleSelectionCategory EOF
            {
             before(grammarAccess.getSelectionCategoryRule()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory423);
            ruleSelectionCategory();

            state._fsp--;

             after(grammarAccess.getSelectionCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategory430); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:239:1: ruleSelectionCategory : ( ( rule__SelectionCategory__Group__0 ) ) ;
    public final void ruleSelectionCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:243:2: ( ( ( rule__SelectionCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:244:1: ( ( rule__SelectionCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:244:1: ( ( rule__SelectionCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:245:1: ( rule__SelectionCategory__Group__0 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:246:1: ( rule__SelectionCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:246:2: rule__SelectionCategory__Group__0
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__0_in_ruleSelectionCategory456);
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


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:258:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:259:1: ( ruleCatRef EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:260:1: ruleCatRef EOF
            {
             before(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef483);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getCatRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef490); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:267:1: ruleCatRef : ( RULE_ID ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:271:2: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:272:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:272:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:273:1: RULE_ID
            {
             before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef516); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:286:1: rule__Categories__Alternatives : ( ( ruleRequirementCategories ) | ( ruleVerificationCategories ) | ( ruleSelectionCategories ) );
    public final void rule__Categories__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:290:1: ( ( ruleRequirementCategories ) | ( ruleVerificationCategories ) | ( ruleSelectionCategories ) )
            int alt1=3;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:291:1: ( ruleRequirementCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:291:1: ( ruleRequirementCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:292:1: ruleRequirementCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRequirementCategories_in_rule__Categories__Alternatives551);
                    ruleRequirementCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:297:6: ( ruleVerificationCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:297:6: ( ruleVerificationCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:298:1: ruleVerificationCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getVerificationCategoriesParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleVerificationCategories_in_rule__Categories__Alternatives568);
                    ruleVerificationCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getVerificationCategoriesParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:303:6: ( ruleSelectionCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:303:6: ( ruleSelectionCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:304:1: ruleSelectionCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getSelectionCategoriesParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleSelectionCategories_in_rule__Categories__Alternatives585);
                    ruleSelectionCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getSelectionCategoriesParserRuleCall_2()); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:317:1: rule__RequirementCategories__Group__0 : rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 ;
    public final void rule__RequirementCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:321:1: ( rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:322:2: rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__0616);
            rule__RequirementCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__0619);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:329:1: rule__RequirementCategories__Group__0__Impl : ( 'requirement' ) ;
    public final void rule__RequirementCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:333:1: ( ( 'requirement' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:334:1: ( 'requirement' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:334:1: ( 'requirement' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:335:1: 'requirement'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__RequirementCategories__Group__0__Impl647); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:348:1: rule__RequirementCategories__Group__1 : rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 ;
    public final void rule__RequirementCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:352:1: ( rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:353:2: rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__1678);
            rule__RequirementCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__1681);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:360:1: rule__RequirementCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__RequirementCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:364:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:365:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:365:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:366:1: 'categories'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__RequirementCategories__Group__1__Impl709); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:379:1: rule__RequirementCategories__Group__2 : rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 ;
    public final void rule__RequirementCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:383:1: ( rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:384:2: rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__2740);
            rule__RequirementCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__2743);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:391:1: rule__RequirementCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__RequirementCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:395:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:396:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:396:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:397:1: '['
            {
             before(grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__RequirementCategories__Group__2__Impl771); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:410:1: rule__RequirementCategories__Group__3 : rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 ;
    public final void rule__RequirementCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:414:1: ( rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:415:2: rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__3802);
            rule__RequirementCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__3805);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:422:1: rule__RequirementCategories__Group__3__Impl : ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__RequirementCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:426:1: ( ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:427:1: ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:427:1: ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:428:1: ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:428:1: ( ( rule__RequirementCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:429:1: ( rule__RequirementCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:430:1: ( rule__RequirementCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:430:2: rule__RequirementCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl834);
            rule__RequirementCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:433:1: ( ( rule__RequirementCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:434:1: ( rule__RequirementCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:435:1: ( rule__RequirementCategories__CategoryAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:435:2: rule__RequirementCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl846);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:446:1: rule__RequirementCategories__Group__4 : rule__RequirementCategories__Group__4__Impl ;
    public final void rule__RequirementCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:450:1: ( rule__RequirementCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:451:2: rule__RequirementCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__4879);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:457:1: rule__RequirementCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__RequirementCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:461:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:462:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:462:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:463:1: ']'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__RequirementCategories__Group__4__Impl907); 
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


    // $ANTLR start "rule__VerificationCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:486:1: rule__VerificationCategories__Group__0 : rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1 ;
    public final void rule__VerificationCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:490:1: ( rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:491:2: rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__0__Impl_in_rule__VerificationCategories__Group__0948);
            rule__VerificationCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__1_in_rule__VerificationCategories__Group__0951);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:498:1: rule__VerificationCategories__Group__0__Impl : ( 'verification' ) ;
    public final void rule__VerificationCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:502:1: ( ( 'verification' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:503:1: ( 'verification' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:503:1: ( 'verification' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:504:1: 'verification'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getVerificationKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__VerificationCategories__Group__0__Impl979); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:517:1: rule__VerificationCategories__Group__1 : rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2 ;
    public final void rule__VerificationCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:521:1: ( rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:522:2: rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__1__Impl_in_rule__VerificationCategories__Group__11010);
            rule__VerificationCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__2_in_rule__VerificationCategories__Group__11013);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:529:1: rule__VerificationCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__VerificationCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:533:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:534:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:534:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:535:1: 'categories'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__VerificationCategories__Group__1__Impl1041); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:548:1: rule__VerificationCategories__Group__2 : rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3 ;
    public final void rule__VerificationCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:552:1: ( rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:553:2: rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__2__Impl_in_rule__VerificationCategories__Group__21072);
            rule__VerificationCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__3_in_rule__VerificationCategories__Group__21075);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:560:1: rule__VerificationCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__VerificationCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:564:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:565:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:565:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:566:1: '['
            {
             before(grammarAccess.getVerificationCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__VerificationCategories__Group__2__Impl1103); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:579:1: rule__VerificationCategories__Group__3 : rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4 ;
    public final void rule__VerificationCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:583:1: ( rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:584:2: rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__3__Impl_in_rule__VerificationCategories__Group__31134);
            rule__VerificationCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__4_in_rule__VerificationCategories__Group__31137);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:591:1: rule__VerificationCategories__Group__3__Impl : ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__VerificationCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:595:1: ( ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:596:1: ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:596:1: ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:597:1: ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:597:1: ( ( rule__VerificationCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:598:1: ( rule__VerificationCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:599:1: ( rule__VerificationCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:599:2: rule__VerificationCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1166);
            rule__VerificationCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:602:1: ( ( rule__VerificationCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:603:1: ( rule__VerificationCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:604:1: ( rule__VerificationCategories__CategoryAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:604:2: rule__VerificationCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1178);
            	    rule__VerificationCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:615:1: rule__VerificationCategories__Group__4 : rule__VerificationCategories__Group__4__Impl ;
    public final void rule__VerificationCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:619:1: ( rule__VerificationCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:620:2: rule__VerificationCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__4__Impl_in_rule__VerificationCategories__Group__41211);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:626:1: rule__VerificationCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__VerificationCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:630:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:631:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:631:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:632:1: ']'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__VerificationCategories__Group__4__Impl1239); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:655:1: rule__SelectionCategories__Group__0 : rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 ;
    public final void rule__SelectionCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:659:1: ( rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:660:2: rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__0__Impl_in_rule__SelectionCategories__Group__01280);
            rule__SelectionCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__1_in_rule__SelectionCategories__Group__01283);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:667:1: rule__SelectionCategories__Group__0__Impl : ( 'selection' ) ;
    public final void rule__SelectionCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:671:1: ( ( 'selection' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:672:1: ( 'selection' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:672:1: ( 'selection' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:673:1: 'selection'
            {
             before(grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__SelectionCategories__Group__0__Impl1311); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:686:1: rule__SelectionCategories__Group__1 : rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 ;
    public final void rule__SelectionCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:690:1: ( rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:691:2: rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__1__Impl_in_rule__SelectionCategories__Group__11342);
            rule__SelectionCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__2_in_rule__SelectionCategories__Group__11345);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:698:1: rule__SelectionCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__SelectionCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:702:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:703:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:703:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:704:1: 'categories'
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__SelectionCategories__Group__1__Impl1373); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:717:1: rule__SelectionCategories__Group__2 : rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 ;
    public final void rule__SelectionCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:721:1: ( rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:722:2: rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__2__Impl_in_rule__SelectionCategories__Group__21404);
            rule__SelectionCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__3_in_rule__SelectionCategories__Group__21407);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:729:1: rule__SelectionCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__SelectionCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:733:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:734:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:734:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:735:1: '['
            {
             before(grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__SelectionCategories__Group__2__Impl1435); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:748:1: rule__SelectionCategories__Group__3 : rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 ;
    public final void rule__SelectionCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:752:1: ( rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:753:2: rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__3__Impl_in_rule__SelectionCategories__Group__31466);
            rule__SelectionCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__4_in_rule__SelectionCategories__Group__31469);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:760:1: rule__SelectionCategories__Group__3__Impl : ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__SelectionCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:764:1: ( ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:765:1: ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:765:1: ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:766:1: ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:766:1: ( ( rule__SelectionCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:767:1: ( rule__SelectionCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:768:1: ( rule__SelectionCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:768:2: rule__SelectionCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl1498);
            rule__SelectionCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:771:1: ( ( rule__SelectionCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:772:1: ( rule__SelectionCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:773:1: ( rule__SelectionCategories__CategoryAssignment_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:773:2: rule__SelectionCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl1510);
            	    rule__SelectionCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:784:1: rule__SelectionCategories__Group__4 : rule__SelectionCategories__Group__4__Impl ;
    public final void rule__SelectionCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:788:1: ( rule__SelectionCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:789:2: rule__SelectionCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__4__Impl_in_rule__SelectionCategories__Group__41543);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:795:1: rule__SelectionCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__SelectionCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:799:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:800:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:800:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:801:1: ']'
            {
             before(grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__SelectionCategories__Group__4__Impl1571); 
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


    // $ANTLR start "rule__RequirementCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:824:1: rule__RequirementCategory__Group__0 : rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 ;
    public final void rule__RequirementCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:828:1: ( rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:829:2: rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__01612);
            rule__RequirementCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__01615);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:836:1: rule__RequirementCategory__Group__0__Impl : ( ( rule__RequirementCategory__NameAssignment_0 ) ) ;
    public final void rule__RequirementCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:840:1: ( ( ( rule__RequirementCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:841:1: ( ( rule__RequirementCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:841:1: ( ( rule__RequirementCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:842:1: ( rule__RequirementCategory__NameAssignment_0 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:843:1: ( rule__RequirementCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:843:2: rule__RequirementCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__RequirementCategory__NameAssignment_0_in_rule__RequirementCategory__Group__0__Impl1642);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:853:1: rule__RequirementCategory__Group__1 : rule__RequirementCategory__Group__1__Impl ;
    public final void rule__RequirementCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:857:1: ( rule__RequirementCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:858:2: rule__RequirementCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__11672);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:864:1: rule__RequirementCategory__Group__1__Impl : ( ( rule__RequirementCategory__Group_1__0 )? ) ;
    public final void rule__RequirementCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:868:1: ( ( ( rule__RequirementCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:869:1: ( ( rule__RequirementCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:869:1: ( ( rule__RequirementCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:870:1: ( rule__RequirementCategory__Group_1__0 )?
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:871:1: ( rule__RequirementCategory__Group_1__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:871:2: rule__RequirementCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__RequirementCategory__Group_1__0_in_rule__RequirementCategory__Group__1__Impl1699);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:885:1: rule__RequirementCategory__Group_1__0 : rule__RequirementCategory__Group_1__0__Impl rule__RequirementCategory__Group_1__1 ;
    public final void rule__RequirementCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:889:1: ( rule__RequirementCategory__Group_1__0__Impl rule__RequirementCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:890:2: rule__RequirementCategory__Group_1__0__Impl rule__RequirementCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group_1__0__Impl_in_rule__RequirementCategory__Group_1__01734);
            rule__RequirementCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group_1__1_in_rule__RequirementCategory__Group_1__01737);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:897:1: rule__RequirementCategory__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__RequirementCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:901:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:902:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:902:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:903:1: 'extends'
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsKeyword_1_0()); 
            match(input,17,FOLLOW_17_in_rule__RequirementCategory__Group_1__0__Impl1765); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:916:1: rule__RequirementCategory__Group_1__1 : rule__RequirementCategory__Group_1__1__Impl ;
    public final void rule__RequirementCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:920:1: ( rule__RequirementCategory__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:921:2: rule__RequirementCategory__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group_1__1__Impl_in_rule__RequirementCategory__Group_1__11796);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:927:1: rule__RequirementCategory__Group_1__1__Impl : ( ( rule__RequirementCategory__ExtendsAssignment_1_1 ) ) ;
    public final void rule__RequirementCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:931:1: ( ( ( rule__RequirementCategory__ExtendsAssignment_1_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:932:1: ( ( rule__RequirementCategory__ExtendsAssignment_1_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:932:1: ( ( rule__RequirementCategory__ExtendsAssignment_1_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:933:1: ( rule__RequirementCategory__ExtendsAssignment_1_1 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:934:1: ( rule__RequirementCategory__ExtendsAssignment_1_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:934:2: rule__RequirementCategory__ExtendsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__ExtendsAssignment_1_1_in_rule__RequirementCategory__Group_1__1__Impl1823);
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


    // $ANTLR start "rule__VerificationCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:948:1: rule__VerificationCategory__Group__0 : rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1 ;
    public final void rule__VerificationCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:952:1: ( rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:953:2: rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__0__Impl_in_rule__VerificationCategory__Group__01857);
            rule__VerificationCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategory__Group__1_in_rule__VerificationCategory__Group__01860);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:960:1: rule__VerificationCategory__Group__0__Impl : ( ( rule__VerificationCategory__NameAssignment_0 ) ) ;
    public final void rule__VerificationCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:964:1: ( ( ( rule__VerificationCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:965:1: ( ( rule__VerificationCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:965:1: ( ( rule__VerificationCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:966:1: ( rule__VerificationCategory__NameAssignment_0 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:967:1: ( rule__VerificationCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:967:2: rule__VerificationCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__VerificationCategory__NameAssignment_0_in_rule__VerificationCategory__Group__0__Impl1887);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:977:1: rule__VerificationCategory__Group__1 : rule__VerificationCategory__Group__1__Impl ;
    public final void rule__VerificationCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:981:1: ( rule__VerificationCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:982:2: rule__VerificationCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__1__Impl_in_rule__VerificationCategory__Group__11917);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:988:1: rule__VerificationCategory__Group__1__Impl : ( ( rule__VerificationCategory__Group_1__0 )? ) ;
    public final void rule__VerificationCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:992:1: ( ( ( rule__VerificationCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:993:1: ( ( rule__VerificationCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:993:1: ( ( rule__VerificationCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:994:1: ( rule__VerificationCategory__Group_1__0 )?
            {
             before(grammarAccess.getVerificationCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:995:1: ( rule__VerificationCategory__Group_1__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:995:2: rule__VerificationCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__VerificationCategory__Group_1__0_in_rule__VerificationCategory__Group__1__Impl1944);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1009:1: rule__VerificationCategory__Group_1__0 : rule__VerificationCategory__Group_1__0__Impl rule__VerificationCategory__Group_1__1 ;
    public final void rule__VerificationCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1013:1: ( rule__VerificationCategory__Group_1__0__Impl rule__VerificationCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1014:2: rule__VerificationCategory__Group_1__0__Impl rule__VerificationCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group_1__0__Impl_in_rule__VerificationCategory__Group_1__01979);
            rule__VerificationCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategory__Group_1__1_in_rule__VerificationCategory__Group_1__01982);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1021:1: rule__VerificationCategory__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__VerificationCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1025:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1026:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1026:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1027:1: 'extends'
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsKeyword_1_0()); 
            match(input,17,FOLLOW_17_in_rule__VerificationCategory__Group_1__0__Impl2010); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1040:1: rule__VerificationCategory__Group_1__1 : rule__VerificationCategory__Group_1__1__Impl ;
    public final void rule__VerificationCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1044:1: ( rule__VerificationCategory__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1045:2: rule__VerificationCategory__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group_1__1__Impl_in_rule__VerificationCategory__Group_1__12041);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1051:1: rule__VerificationCategory__Group_1__1__Impl : ( ( rule__VerificationCategory__ExtendsAssignment_1_1 ) ) ;
    public final void rule__VerificationCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1055:1: ( ( ( rule__VerificationCategory__ExtendsAssignment_1_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1056:1: ( ( rule__VerificationCategory__ExtendsAssignment_1_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1056:1: ( ( rule__VerificationCategory__ExtendsAssignment_1_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1057:1: ( rule__VerificationCategory__ExtendsAssignment_1_1 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1058:1: ( rule__VerificationCategory__ExtendsAssignment_1_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1058:2: rule__VerificationCategory__ExtendsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__ExtendsAssignment_1_1_in_rule__VerificationCategory__Group_1__1__Impl2068);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1072:1: rule__SelectionCategory__Group__0 : rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 ;
    public final void rule__SelectionCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1076:1: ( rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1077:2: rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__0__Impl_in_rule__SelectionCategory__Group__02102);
            rule__SelectionCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategory__Group__1_in_rule__SelectionCategory__Group__02105);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1084:1: rule__SelectionCategory__Group__0__Impl : ( ( rule__SelectionCategory__NameAssignment_0 ) ) ;
    public final void rule__SelectionCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1088:1: ( ( ( rule__SelectionCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1089:1: ( ( rule__SelectionCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1089:1: ( ( rule__SelectionCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1090:1: ( rule__SelectionCategory__NameAssignment_0 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1091:1: ( rule__SelectionCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1091:2: rule__SelectionCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__SelectionCategory__NameAssignment_0_in_rule__SelectionCategory__Group__0__Impl2132);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1101:1: rule__SelectionCategory__Group__1 : rule__SelectionCategory__Group__1__Impl ;
    public final void rule__SelectionCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1105:1: ( rule__SelectionCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1106:2: rule__SelectionCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__1__Impl_in_rule__SelectionCategory__Group__12162);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1112:1: rule__SelectionCategory__Group__1__Impl : ( ( rule__SelectionCategory__Group_1__0 )? ) ;
    public final void rule__SelectionCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1116:1: ( ( ( rule__SelectionCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1117:1: ( ( rule__SelectionCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1117:1: ( ( rule__SelectionCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1118:1: ( rule__SelectionCategory__Group_1__0 )?
            {
             before(grammarAccess.getSelectionCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1119:1: ( rule__SelectionCategory__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1119:2: rule__SelectionCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__SelectionCategory__Group_1__0_in_rule__SelectionCategory__Group__1__Impl2189);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1133:1: rule__SelectionCategory__Group_1__0 : rule__SelectionCategory__Group_1__0__Impl rule__SelectionCategory__Group_1__1 ;
    public final void rule__SelectionCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1137:1: ( rule__SelectionCategory__Group_1__0__Impl rule__SelectionCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1138:2: rule__SelectionCategory__Group_1__0__Impl rule__SelectionCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group_1__0__Impl_in_rule__SelectionCategory__Group_1__02224);
            rule__SelectionCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategory__Group_1__1_in_rule__SelectionCategory__Group_1__02227);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1145:1: rule__SelectionCategory__Group_1__0__Impl : ( 'extends' ) ;
    public final void rule__SelectionCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1149:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1150:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1150:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1151:1: 'extends'
            {
             before(grammarAccess.getSelectionCategoryAccess().getExtendsKeyword_1_0()); 
            match(input,17,FOLLOW_17_in_rule__SelectionCategory__Group_1__0__Impl2255); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1164:1: rule__SelectionCategory__Group_1__1 : rule__SelectionCategory__Group_1__1__Impl ;
    public final void rule__SelectionCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1168:1: ( rule__SelectionCategory__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1169:2: rule__SelectionCategory__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group_1__1__Impl_in_rule__SelectionCategory__Group_1__12286);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1175:1: rule__SelectionCategory__Group_1__1__Impl : ( ( rule__SelectionCategory__ExtendsAssignment_1_1 ) ) ;
    public final void rule__SelectionCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1179:1: ( ( ( rule__SelectionCategory__ExtendsAssignment_1_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1180:1: ( ( rule__SelectionCategory__ExtendsAssignment_1_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1180:1: ( ( rule__SelectionCategory__ExtendsAssignment_1_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1181:1: ( rule__SelectionCategory__ExtendsAssignment_1_1 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getExtendsAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1182:1: ( rule__SelectionCategory__ExtendsAssignment_1_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1182:2: rule__SelectionCategory__ExtendsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__ExtendsAssignment_1_1_in_rule__SelectionCategory__Group_1__1__Impl2313);
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


    // $ANTLR start "rule__RequirementCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1197:1: rule__RequirementCategories__CategoryAssignment_3 : ( ruleRequirementCategory ) ;
    public final void rule__RequirementCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1201:1: ( ( ruleRequirementCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1202:1: ( ruleRequirementCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1202:1: ( ruleRequirementCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1203:1: ruleRequirementCategory
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_32352);
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


    // $ANTLR start "rule__VerificationCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1212:1: rule__VerificationCategories__CategoryAssignment_3 : ( ruleVerificationCategory ) ;
    public final void rule__VerificationCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1216:1: ( ( ruleVerificationCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1217:1: ( ruleVerificationCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1217:1: ( ruleVerificationCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1218:1: ruleVerificationCategory
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryVerificationCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_rule__VerificationCategories__CategoryAssignment_32383);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1227:1: rule__SelectionCategories__CategoryAssignment_3 : ( ruleSelectionCategory ) ;
    public final void rule__SelectionCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1231:1: ( ( ruleSelectionCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1232:1: ( ruleSelectionCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1232:1: ( ruleSelectionCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1233:1: ruleSelectionCategory
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_rule__SelectionCategories__CategoryAssignment_32414);
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


    // $ANTLR start "rule__RequirementCategory__NameAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1242:1: rule__RequirementCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__RequirementCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1246:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1247:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1247:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1248:1: RULE_ID
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_02445); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1257:1: rule__RequirementCategory__ExtendsAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__RequirementCategory__ExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1261:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1262:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1262:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1263:1: ( ruleCatRef )
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1264:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1265:1: ruleCatRef
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__RequirementCategory__ExtendsAssignment_1_12480);
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


    // $ANTLR start "rule__VerificationCategory__NameAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1276:1: rule__VerificationCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__VerificationCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1280:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1281:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1281:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1282:1: RULE_ID
            {
             before(grammarAccess.getVerificationCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VerificationCategory__NameAssignment_02515); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1291:1: rule__VerificationCategory__ExtendsAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__VerificationCategory__ExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1295:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1296:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1296:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1297:1: ( ruleCatRef )
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1298:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1299:1: ruleCatRef
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__VerificationCategory__ExtendsAssignment_1_12550);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1310:1: rule__SelectionCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__SelectionCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1314:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1315:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1315:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1316:1: RULE_ID
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectionCategory__NameAssignment_02585); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1325:1: rule__SelectionCategory__ExtendsAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__SelectionCategory__ExtendsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1329:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1330:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1330:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1331:1: ( ruleCatRef )
            {
             before(grammarAccess.getSelectionCategoryAccess().getExtendsSelectionCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1332:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1333:1: ruleCatRef
            {
             before(grammarAccess.getSelectionCategoryAccess().getExtendsSelectionCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__SelectionCategory__ExtendsAssignment_1_12620);
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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategories_in_entryRuleCategories61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategories68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Categories__Alternatives_in_ruleCategories94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategories128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__0_in_ruleRequirementCategories154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategories188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__0_in_ruleVerificationCategories214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategories248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__0_in_ruleSelectionCategories274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategory370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__0_in_ruleVerificationCategory396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategory430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__0_in_ruleSelectionCategory456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_rule__Categories__Alternatives551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_rule__Categories__Alternatives568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_rule__Categories__Alternatives585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__0616 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__0619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__RequirementCategories__Group__0__Impl647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__1678 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__1681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__RequirementCategories__Group__1__Impl709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__2740 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__RequirementCategories__Group__2__Impl771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__3802 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__3805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl834 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl846 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__4879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__RequirementCategories__Group__4__Impl907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__0__Impl_in_rule__VerificationCategories__Group__0948 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__1_in_rule__VerificationCategories__Group__0951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VerificationCategories__Group__0__Impl979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__1__Impl_in_rule__VerificationCategories__Group__11010 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__2_in_rule__VerificationCategories__Group__11013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__VerificationCategories__Group__1__Impl1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__2__Impl_in_rule__VerificationCategories__Group__21072 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__3_in_rule__VerificationCategories__Group__21075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VerificationCategories__Group__2__Impl1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__3__Impl_in_rule__VerificationCategories__Group__31134 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__4_in_rule__VerificationCategories__Group__31137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1166 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1178 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__4__Impl_in_rule__VerificationCategories__Group__41211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VerificationCategories__Group__4__Impl1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__0__Impl_in_rule__SelectionCategories__Group__01280 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__1_in_rule__SelectionCategories__Group__01283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SelectionCategories__Group__0__Impl1311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__1__Impl_in_rule__SelectionCategories__Group__11342 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__2_in_rule__SelectionCategories__Group__11345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__SelectionCategories__Group__1__Impl1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__2__Impl_in_rule__SelectionCategories__Group__21404 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__3_in_rule__SelectionCategories__Group__21407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__SelectionCategories__Group__2__Impl1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__3__Impl_in_rule__SelectionCategories__Group__31466 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__4_in_rule__SelectionCategories__Group__31469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl1498 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl1510 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__4__Impl_in_rule__SelectionCategories__Group__41543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__SelectionCategories__Group__4__Impl1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__01612 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__01615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__NameAssignment_0_in_rule__RequirementCategory__Group__0__Impl1642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__11672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__0_in_rule__RequirementCategory__Group__1__Impl1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__0__Impl_in_rule__RequirementCategory__Group_1__01734 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__1_in_rule__RequirementCategory__Group_1__01737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__RequirementCategory__Group_1__0__Impl1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__1__Impl_in_rule__RequirementCategory__Group_1__11796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__ExtendsAssignment_1_1_in_rule__RequirementCategory__Group_1__1__Impl1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__0__Impl_in_rule__VerificationCategory__Group__01857 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__1_in_rule__VerificationCategory__Group__01860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__NameAssignment_0_in_rule__VerificationCategory__Group__0__Impl1887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__1__Impl_in_rule__VerificationCategory__Group__11917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_1__0_in_rule__VerificationCategory__Group__1__Impl1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_1__0__Impl_in_rule__VerificationCategory__Group_1__01979 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_1__1_in_rule__VerificationCategory__Group_1__01982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__VerificationCategory__Group_1__0__Impl2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_1__1__Impl_in_rule__VerificationCategory__Group_1__12041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__ExtendsAssignment_1_1_in_rule__VerificationCategory__Group_1__1__Impl2068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__0__Impl_in_rule__SelectionCategory__Group__02102 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__1_in_rule__SelectionCategory__Group__02105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__NameAssignment_0_in_rule__SelectionCategory__Group__0__Impl2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__1__Impl_in_rule__SelectionCategory__Group__12162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__0_in_rule__SelectionCategory__Group__1__Impl2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__0__Impl_in_rule__SelectionCategory__Group_1__02224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__1_in_rule__SelectionCategory__Group_1__02227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SelectionCategory__Group_1__0__Impl2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__1__Impl_in_rule__SelectionCategory__Group_1__12286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__ExtendsAssignment_1_1_in_rule__SelectionCategory__Group_1__1__Impl2313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_32352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_rule__VerificationCategories__CategoryAssignment_32383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_rule__SelectionCategories__CategoryAssignment_32414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_02445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__RequirementCategory__ExtendsAssignment_1_12480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VerificationCategory__NameAssignment_02515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__VerificationCategory__ExtendsAssignment_1_12550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectionCategory__NameAssignment_02585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__SelectionCategory__ExtendsAssignment_1_12620 = new BitSet(new long[]{0x0000000000000002L});

}
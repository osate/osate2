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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requirement'", "'categories'", "'['", "']'", "'hazard'", "'Verification'", "'category'", "'extends'", "'.'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
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


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:172:1: entryRuleRequirementCategory : ruleRequirementCategory EOF ;
    public final void entryRuleRequirementCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:173:1: ( ruleRequirementCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:174:1: ruleRequirementCategory EOF
            {
             before(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory301);
            ruleRequirementCategory();

            state._fsp--;

             after(grammarAccess.getRequirementCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory308); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:181:1: ruleRequirementCategory : ( ( rule__RequirementCategory__Group__0 ) ) ;
    public final void ruleRequirementCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:185:2: ( ( ( rule__RequirementCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:186:1: ( ( rule__RequirementCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:186:1: ( ( rule__RequirementCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:187:1: ( rule__RequirementCategory__Group__0 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:188:1: ( rule__RequirementCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:188:2: rule__RequirementCategory__Group__0
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory334);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:200:1: entryRuleHazardCategory : ruleHazardCategory EOF ;
    public final void entryRuleHazardCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:201:1: ( ruleHazardCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:202:1: ruleHazardCategory EOF
            {
             before(grammarAccess.getHazardCategoryRule()); 
            pushFollow(FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory361);
            ruleHazardCategory();

            state._fsp--;

             after(grammarAccess.getHazardCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategory368); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:209:1: ruleHazardCategory : ( ( rule__HazardCategory__Group__0 ) ) ;
    public final void ruleHazardCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:213:2: ( ( ( rule__HazardCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:214:1: ( ( rule__HazardCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:214:1: ( ( rule__HazardCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:215:1: ( rule__HazardCategory__Group__0 )
            {
             before(grammarAccess.getHazardCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:216:1: ( rule__HazardCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:216:2: rule__HazardCategory__Group__0
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group__0_in_ruleHazardCategory394);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:228:1: entryRuleVerificationCategory : ruleVerificationCategory EOF ;
    public final void entryRuleVerificationCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:229:1: ( ruleVerificationCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:230:1: ruleVerificationCategory EOF
            {
             before(grammarAccess.getVerificationCategoryRule()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory421);
            ruleVerificationCategory();

            state._fsp--;

             after(grammarAccess.getVerificationCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategory428); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:237:1: ruleVerificationCategory : ( ( rule__VerificationCategory__Group__0 ) ) ;
    public final void ruleVerificationCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:241:2: ( ( ( rule__VerificationCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:242:1: ( ( rule__VerificationCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:242:1: ( ( rule__VerificationCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:243:1: ( rule__VerificationCategory__Group__0 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:244:1: ( rule__VerificationCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:244:2: rule__VerificationCategory__Group__0
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__0_in_ruleVerificationCategory454);
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


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:258:1: entryRuleDescription : ruleDescription EOF ;
    public final void entryRuleDescription() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:259:1: ( ruleDescription EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:260:1: ruleDescription EOF
            {
             before(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription483);
            ruleDescription();

            state._fsp--;

             after(grammarAccess.getDescriptionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription490); 

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
    // $ANTLR end "entryRuleDescription"


    // $ANTLR start "ruleDescription"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:267:1: ruleDescription : ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) ) ;
    public final void ruleDescription() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:271:2: ( ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:272:1: ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:272:1: ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:273:1: ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:273:1: ( ( rule__Description__DescriptionAssignment ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:274:1: ( rule__Description__DescriptionAssignment )
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:275:1: ( rule__Description__DescriptionAssignment )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:275:2: rule__Description__DescriptionAssignment
            {
            pushFollow(FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription518);
            rule__Description__DescriptionAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:278:1: ( ( rule__Description__DescriptionAssignment )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:279:1: ( rule__Description__DescriptionAssignment )*
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:280:1: ( rule__Description__DescriptionAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:280:2: rule__Description__DescriptionAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription530);
            	    rule__Description__DescriptionAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 

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
    // $ANTLR end "ruleDescription"


    // $ANTLR start "entryRuleDescriptionElement"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:293:1: entryRuleDescriptionElement : ruleDescriptionElement EOF ;
    public final void entryRuleDescriptionElement() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:294:1: ( ruleDescriptionElement EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:295:1: ruleDescriptionElement EOF
            {
             before(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement560);
            ruleDescriptionElement();

            state._fsp--;

             after(grammarAccess.getDescriptionElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement567); 

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
    // $ANTLR end "entryRuleDescriptionElement"


    // $ANTLR start "ruleDescriptionElement"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:302:1: ruleDescriptionElement : ( ( rule__DescriptionElement__Alternatives ) ) ;
    public final void ruleDescriptionElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:306:2: ( ( ( rule__DescriptionElement__Alternatives ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:307:1: ( ( rule__DescriptionElement__Alternatives ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:307:1: ( ( rule__DescriptionElement__Alternatives ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:308:1: ( rule__DescriptionElement__Alternatives )
            {
             before(grammarAccess.getDescriptionElementAccess().getAlternatives()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:309:1: ( rule__DescriptionElement__Alternatives )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:309:2: rule__DescriptionElement__Alternatives
            {
            pushFollow(FOLLOW_rule__DescriptionElement__Alternatives_in_ruleDescriptionElement593);
            rule__DescriptionElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDescriptionElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDescriptionElement"


    // $ANTLR start "entryRuleReferencePath"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:321:1: entryRuleReferencePath : ruleReferencePath EOF ;
    public final void entryRuleReferencePath() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:322:1: ( ruleReferencePath EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:323:1: ruleReferencePath EOF
            {
             before(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath620);
            ruleReferencePath();

            state._fsp--;

             after(grammarAccess.getReferencePathRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath627); 

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
    // $ANTLR end "entryRuleReferencePath"


    // $ANTLR start "ruleReferencePath"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:330:1: ruleReferencePath : ( ( rule__ReferencePath__Group__0 ) ) ;
    public final void ruleReferencePath() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:334:2: ( ( ( rule__ReferencePath__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:335:1: ( ( rule__ReferencePath__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:335:1: ( ( rule__ReferencePath__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:336:1: ( rule__ReferencePath__Group__0 )
            {
             before(grammarAccess.getReferencePathAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:337:1: ( rule__ReferencePath__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:337:2: rule__ReferencePath__Group__0
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__0_in_ruleReferencePath653);
            rule__ReferencePath__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferencePathAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReferencePath"


    // $ANTLR start "entryRuleCATREF"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:355:1: entryRuleCATREF : ruleCATREF EOF ;
    public final void entryRuleCATREF() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:356:1: ( ruleCATREF EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:357:1: ruleCATREF EOF
            {
             before(grammarAccess.getCATREFRule()); 
            pushFollow(FOLLOW_ruleCATREF_in_entryRuleCATREF686);
            ruleCATREF();

            state._fsp--;

             after(grammarAccess.getCATREFRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCATREF693); 

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
    // $ANTLR end "entryRuleCATREF"


    // $ANTLR start "ruleCATREF"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:364:1: ruleCATREF : ( ( rule__CATREF__Group__0 ) ) ;
    public final void ruleCATREF() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:368:2: ( ( ( rule__CATREF__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:369:1: ( ( rule__CATREF__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:369:1: ( ( rule__CATREF__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:370:1: ( rule__CATREF__Group__0 )
            {
             before(grammarAccess.getCATREFAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:371:1: ( rule__CATREF__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:371:2: rule__CATREF__Group__0
            {
            pushFollow(FOLLOW_rule__CATREF__Group__0_in_ruleCATREF719);
            rule__CATREF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCATREFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCATREF"


    // $ANTLR start "rule__Categories__Alternatives"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:383:1: rule__Categories__Alternatives : ( ( ruleRequirementCategories ) | ( ruleHazardCategories ) | ( ruleVerificationCategories ) );
    public final void rule__Categories__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:387:1: ( ( ruleRequirementCategories ) | ( ruleHazardCategories ) | ( ruleVerificationCategories ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 15:
                {
                alt2=2;
                }
                break;
            case 16:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:388:1: ( ruleRequirementCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:388:1: ( ruleRequirementCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:389:1: ruleRequirementCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRequirementCategories_in_rule__Categories__Alternatives755);
                    ruleRequirementCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:394:6: ( ruleHazardCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:394:6: ( ruleHazardCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:395:1: ruleHazardCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getHazardCategoriesParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHazardCategories_in_rule__Categories__Alternatives772);
                    ruleHazardCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getHazardCategoriesParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:400:6: ( ruleVerificationCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:400:6: ( ruleVerificationCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:401:1: ruleVerificationCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getVerificationCategoriesParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleVerificationCategories_in_rule__Categories__Alternatives789);
                    ruleVerificationCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getVerificationCategoriesParserRuleCall_2()); 

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


    // $ANTLR start "rule__DescriptionElement__Alternatives"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:411:1: rule__DescriptionElement__Alternatives : ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__RefAssignment_1 ) ) );
    public final void rule__DescriptionElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:415:1: ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__RefAssignment_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:416:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:416:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:417:1: ( rule__DescriptionElement__TextAssignment_0 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:418:1: ( rule__DescriptionElement__TextAssignment_0 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:418:2: rule__DescriptionElement__TextAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives821);
                    rule__DescriptionElement__TextAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:422:6: ( ( rule__DescriptionElement__RefAssignment_1 ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:422:6: ( ( rule__DescriptionElement__RefAssignment_1 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:423:1: ( rule__DescriptionElement__RefAssignment_1 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getRefAssignment_1()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:424:1: ( rule__DescriptionElement__RefAssignment_1 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:424:2: rule__DescriptionElement__RefAssignment_1
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__RefAssignment_1_in_rule__DescriptionElement__Alternatives839);
                    rule__DescriptionElement__RefAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getDescriptionElementAccess().getRefAssignment_1()); 

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
    // $ANTLR end "rule__DescriptionElement__Alternatives"


    // $ANTLR start "rule__RequirementCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:435:1: rule__RequirementCategories__Group__0 : rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 ;
    public final void rule__RequirementCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:439:1: ( rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:440:2: rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__0870);
            rule__RequirementCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__0873);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:447:1: rule__RequirementCategories__Group__0__Impl : ( 'requirement' ) ;
    public final void rule__RequirementCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:451:1: ( ( 'requirement' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:452:1: ( 'requirement' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:452:1: ( 'requirement' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:453:1: 'requirement'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__RequirementCategories__Group__0__Impl901); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:466:1: rule__RequirementCategories__Group__1 : rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 ;
    public final void rule__RequirementCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:470:1: ( rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:471:2: rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__1932);
            rule__RequirementCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__1935);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:478:1: rule__RequirementCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__RequirementCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:482:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:483:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:483:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:484:1: 'categories'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__RequirementCategories__Group__1__Impl963); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:497:1: rule__RequirementCategories__Group__2 : rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 ;
    public final void rule__RequirementCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:501:1: ( rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:502:2: rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__2994);
            rule__RequirementCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__2997);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:509:1: rule__RequirementCategories__Group__2__Impl : ( ( rule__RequirementCategories__NameAssignment_2 ) ) ;
    public final void rule__RequirementCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:513:1: ( ( ( rule__RequirementCategories__NameAssignment_2 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:514:1: ( ( rule__RequirementCategories__NameAssignment_2 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:514:1: ( ( rule__RequirementCategories__NameAssignment_2 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:515:1: ( rule__RequirementCategories__NameAssignment_2 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getNameAssignment_2()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:516:1: ( rule__RequirementCategories__NameAssignment_2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:516:2: rule__RequirementCategories__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__RequirementCategories__NameAssignment_2_in_rule__RequirementCategories__Group__2__Impl1024);
            rule__RequirementCategories__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoriesAccess().getNameAssignment_2()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:526:1: rule__RequirementCategories__Group__3 : rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 ;
    public final void rule__RequirementCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:530:1: ( rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:531:2: rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__31054);
            rule__RequirementCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__31057);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:538:1: rule__RequirementCategories__Group__3__Impl : ( '[' ) ;
    public final void rule__RequirementCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:542:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:543:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:543:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:544:1: '['
            {
             before(grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,13,FOLLOW_13_in_rule__RequirementCategories__Group__3__Impl1085); 
             after(grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:557:1: rule__RequirementCategories__Group__4 : rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5 ;
    public final void rule__RequirementCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:561:1: ( rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:562:2: rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__41116);
            rule__RequirementCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__5_in_rule__RequirementCategories__Group__41119);
            rule__RequirementCategories__Group__5();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:569:1: rule__RequirementCategories__Group__4__Impl : ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__RequirementCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:573:1: ( ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:574:1: ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:574:1: ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:575:1: ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:575:1: ( ( rule__RequirementCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:576:1: ( rule__RequirementCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:577:1: ( rule__RequirementCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:577:2: rule__RequirementCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1148);
            rule__RequirementCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:580:1: ( ( rule__RequirementCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:581:1: ( rule__RequirementCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:582:1: ( rule__RequirementCategories__CategoryAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:582:2: rule__RequirementCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1160);
            	    rule__RequirementCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__RequirementCategories__Group__4__Impl"


    // $ANTLR start "rule__RequirementCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:593:1: rule__RequirementCategories__Group__5 : rule__RequirementCategories__Group__5__Impl ;
    public final void rule__RequirementCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:597:1: ( rule__RequirementCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:598:2: rule__RequirementCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__5__Impl_in_rule__RequirementCategories__Group__51193);
            rule__RequirementCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__5"


    // $ANTLR start "rule__RequirementCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:604:1: rule__RequirementCategories__Group__5__Impl : ( ']' ) ;
    public final void rule__RequirementCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:608:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:609:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:609:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:610:1: ']'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,14,FOLLOW_14_in_rule__RequirementCategories__Group__5__Impl1221); 
             after(grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__5__Impl"


    // $ANTLR start "rule__HazardCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:635:1: rule__HazardCategories__Group__0 : rule__HazardCategories__Group__0__Impl rule__HazardCategories__Group__1 ;
    public final void rule__HazardCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:639:1: ( rule__HazardCategories__Group__0__Impl rule__HazardCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:640:2: rule__HazardCategories__Group__0__Impl rule__HazardCategories__Group__1
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__0__Impl_in_rule__HazardCategories__Group__01264);
            rule__HazardCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__1_in_rule__HazardCategories__Group__01267);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:647:1: rule__HazardCategories__Group__0__Impl : ( 'hazard' ) ;
    public final void rule__HazardCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:651:1: ( ( 'hazard' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:652:1: ( 'hazard' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:652:1: ( 'hazard' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:653:1: 'hazard'
            {
             before(grammarAccess.getHazardCategoriesAccess().getHazardKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__HazardCategories__Group__0__Impl1295); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:666:1: rule__HazardCategories__Group__1 : rule__HazardCategories__Group__1__Impl rule__HazardCategories__Group__2 ;
    public final void rule__HazardCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:670:1: ( rule__HazardCategories__Group__1__Impl rule__HazardCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:671:2: rule__HazardCategories__Group__1__Impl rule__HazardCategories__Group__2
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__1__Impl_in_rule__HazardCategories__Group__11326);
            rule__HazardCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__2_in_rule__HazardCategories__Group__11329);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:678:1: rule__HazardCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__HazardCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:682:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:683:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:683:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:684:1: 'categories'
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__HazardCategories__Group__1__Impl1357); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:697:1: rule__HazardCategories__Group__2 : rule__HazardCategories__Group__2__Impl rule__HazardCategories__Group__3 ;
    public final void rule__HazardCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:701:1: ( rule__HazardCategories__Group__2__Impl rule__HazardCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:702:2: rule__HazardCategories__Group__2__Impl rule__HazardCategories__Group__3
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__2__Impl_in_rule__HazardCategories__Group__21388);
            rule__HazardCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__3_in_rule__HazardCategories__Group__21391);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:709:1: rule__HazardCategories__Group__2__Impl : ( ( rule__HazardCategories__NameAssignment_2 ) ) ;
    public final void rule__HazardCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:713:1: ( ( ( rule__HazardCategories__NameAssignment_2 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:714:1: ( ( rule__HazardCategories__NameAssignment_2 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:714:1: ( ( rule__HazardCategories__NameAssignment_2 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:715:1: ( rule__HazardCategories__NameAssignment_2 )
            {
             before(grammarAccess.getHazardCategoriesAccess().getNameAssignment_2()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:716:1: ( rule__HazardCategories__NameAssignment_2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:716:2: rule__HazardCategories__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__HazardCategories__NameAssignment_2_in_rule__HazardCategories__Group__2__Impl1418);
            rule__HazardCategories__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getHazardCategoriesAccess().getNameAssignment_2()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:726:1: rule__HazardCategories__Group__3 : rule__HazardCategories__Group__3__Impl rule__HazardCategories__Group__4 ;
    public final void rule__HazardCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:730:1: ( rule__HazardCategories__Group__3__Impl rule__HazardCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:731:2: rule__HazardCategories__Group__3__Impl rule__HazardCategories__Group__4
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__3__Impl_in_rule__HazardCategories__Group__31448);
            rule__HazardCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__4_in_rule__HazardCategories__Group__31451);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:738:1: rule__HazardCategories__Group__3__Impl : ( '[' ) ;
    public final void rule__HazardCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:742:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:743:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:743:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:744:1: '['
            {
             before(grammarAccess.getHazardCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,13,FOLLOW_13_in_rule__HazardCategories__Group__3__Impl1479); 
             after(grammarAccess.getHazardCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:757:1: rule__HazardCategories__Group__4 : rule__HazardCategories__Group__4__Impl rule__HazardCategories__Group__5 ;
    public final void rule__HazardCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:761:1: ( rule__HazardCategories__Group__4__Impl rule__HazardCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:762:2: rule__HazardCategories__Group__4__Impl rule__HazardCategories__Group__5
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__4__Impl_in_rule__HazardCategories__Group__41510);
            rule__HazardCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__5_in_rule__HazardCategories__Group__41513);
            rule__HazardCategories__Group__5();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:769:1: rule__HazardCategories__Group__4__Impl : ( ( ( rule__HazardCategories__CategoryAssignment_4 ) ) ( ( rule__HazardCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__HazardCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:773:1: ( ( ( ( rule__HazardCategories__CategoryAssignment_4 ) ) ( ( rule__HazardCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:774:1: ( ( ( rule__HazardCategories__CategoryAssignment_4 ) ) ( ( rule__HazardCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:774:1: ( ( ( rule__HazardCategories__CategoryAssignment_4 ) ) ( ( rule__HazardCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:775:1: ( ( rule__HazardCategories__CategoryAssignment_4 ) ) ( ( rule__HazardCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:775:1: ( ( rule__HazardCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:776:1: ( rule__HazardCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:777:1: ( rule__HazardCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:777:2: rule__HazardCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__HazardCategories__CategoryAssignment_4_in_rule__HazardCategories__Group__4__Impl1542);
            rule__HazardCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getHazardCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:780:1: ( ( rule__HazardCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:781:1: ( rule__HazardCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:782:1: ( rule__HazardCategories__CategoryAssignment_4 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:782:2: rule__HazardCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__HazardCategories__CategoryAssignment_4_in_rule__HazardCategories__Group__4__Impl1554);
            	    rule__HazardCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getHazardCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__HazardCategories__Group__4__Impl"


    // $ANTLR start "rule__HazardCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:793:1: rule__HazardCategories__Group__5 : rule__HazardCategories__Group__5__Impl ;
    public final void rule__HazardCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:797:1: ( rule__HazardCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:798:2: rule__HazardCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__5__Impl_in_rule__HazardCategories__Group__51587);
            rule__HazardCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__Group__5"


    // $ANTLR start "rule__HazardCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:804:1: rule__HazardCategories__Group__5__Impl : ( ']' ) ;
    public final void rule__HazardCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:808:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:809:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:809:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:810:1: ']'
            {
             before(grammarAccess.getHazardCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,14,FOLLOW_14_in_rule__HazardCategories__Group__5__Impl1615); 
             after(grammarAccess.getHazardCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__Group__5__Impl"


    // $ANTLR start "rule__VerificationCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:835:1: rule__VerificationCategories__Group__0 : rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1 ;
    public final void rule__VerificationCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:839:1: ( rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:840:2: rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__0__Impl_in_rule__VerificationCategories__Group__01658);
            rule__VerificationCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__1_in_rule__VerificationCategories__Group__01661);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:847:1: rule__VerificationCategories__Group__0__Impl : ( 'Verification' ) ;
    public final void rule__VerificationCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:851:1: ( ( 'Verification' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:852:1: ( 'Verification' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:852:1: ( 'Verification' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:853:1: 'Verification'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getVerificationKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__VerificationCategories__Group__0__Impl1689); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:866:1: rule__VerificationCategories__Group__1 : rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2 ;
    public final void rule__VerificationCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:870:1: ( rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:871:2: rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__1__Impl_in_rule__VerificationCategories__Group__11720);
            rule__VerificationCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__2_in_rule__VerificationCategories__Group__11723);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:878:1: rule__VerificationCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__VerificationCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:882:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:883:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:883:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:884:1: 'categories'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__VerificationCategories__Group__1__Impl1751); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:897:1: rule__VerificationCategories__Group__2 : rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3 ;
    public final void rule__VerificationCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:901:1: ( rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:902:2: rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__2__Impl_in_rule__VerificationCategories__Group__21782);
            rule__VerificationCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__3_in_rule__VerificationCategories__Group__21785);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:909:1: rule__VerificationCategories__Group__2__Impl : ( ( rule__VerificationCategories__NameAssignment_2 ) ) ;
    public final void rule__VerificationCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:913:1: ( ( ( rule__VerificationCategories__NameAssignment_2 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:914:1: ( ( rule__VerificationCategories__NameAssignment_2 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:914:1: ( ( rule__VerificationCategories__NameAssignment_2 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:915:1: ( rule__VerificationCategories__NameAssignment_2 )
            {
             before(grammarAccess.getVerificationCategoriesAccess().getNameAssignment_2()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:916:1: ( rule__VerificationCategories__NameAssignment_2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:916:2: rule__VerificationCategories__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__VerificationCategories__NameAssignment_2_in_rule__VerificationCategories__Group__2__Impl1812);
            rule__VerificationCategories__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getVerificationCategoriesAccess().getNameAssignment_2()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:926:1: rule__VerificationCategories__Group__3 : rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4 ;
    public final void rule__VerificationCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:930:1: ( rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:931:2: rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__3__Impl_in_rule__VerificationCategories__Group__31842);
            rule__VerificationCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__4_in_rule__VerificationCategories__Group__31845);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:938:1: rule__VerificationCategories__Group__3__Impl : ( '[' ) ;
    public final void rule__VerificationCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:942:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:943:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:943:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:944:1: '['
            {
             before(grammarAccess.getVerificationCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,13,FOLLOW_13_in_rule__VerificationCategories__Group__3__Impl1873); 
             after(grammarAccess.getVerificationCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:957:1: rule__VerificationCategories__Group__4 : rule__VerificationCategories__Group__4__Impl rule__VerificationCategories__Group__5 ;
    public final void rule__VerificationCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:961:1: ( rule__VerificationCategories__Group__4__Impl rule__VerificationCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:962:2: rule__VerificationCategories__Group__4__Impl rule__VerificationCategories__Group__5
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__4__Impl_in_rule__VerificationCategories__Group__41904);
            rule__VerificationCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__5_in_rule__VerificationCategories__Group__41907);
            rule__VerificationCategories__Group__5();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:969:1: rule__VerificationCategories__Group__4__Impl : ( ( ( rule__VerificationCategories__CategoryAssignment_4 ) ) ( ( rule__VerificationCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__VerificationCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:973:1: ( ( ( ( rule__VerificationCategories__CategoryAssignment_4 ) ) ( ( rule__VerificationCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:974:1: ( ( ( rule__VerificationCategories__CategoryAssignment_4 ) ) ( ( rule__VerificationCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:974:1: ( ( ( rule__VerificationCategories__CategoryAssignment_4 ) ) ( ( rule__VerificationCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:975:1: ( ( rule__VerificationCategories__CategoryAssignment_4 ) ) ( ( rule__VerificationCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:975:1: ( ( rule__VerificationCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:976:1: ( rule__VerificationCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:977:1: ( rule__VerificationCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:977:2: rule__VerificationCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__VerificationCategories__CategoryAssignment_4_in_rule__VerificationCategories__Group__4__Impl1936);
            rule__VerificationCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:980:1: ( ( rule__VerificationCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:981:1: ( rule__VerificationCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:982:1: ( rule__VerificationCategories__CategoryAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:982:2: rule__VerificationCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__VerificationCategories__CategoryAssignment_4_in_rule__VerificationCategories__Group__4__Impl1948);
            	    rule__VerificationCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__VerificationCategories__Group__4__Impl"


    // $ANTLR start "rule__VerificationCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:993:1: rule__VerificationCategories__Group__5 : rule__VerificationCategories__Group__5__Impl ;
    public final void rule__VerificationCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:997:1: ( rule__VerificationCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:998:2: rule__VerificationCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__5__Impl_in_rule__VerificationCategories__Group__51981);
            rule__VerificationCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__Group__5"


    // $ANTLR start "rule__VerificationCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1004:1: rule__VerificationCategories__Group__5__Impl : ( ']' ) ;
    public final void rule__VerificationCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1008:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1009:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1009:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1010:1: ']'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,14,FOLLOW_14_in_rule__VerificationCategories__Group__5__Impl2009); 
             after(grammarAccess.getVerificationCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__Group__5__Impl"


    // $ANTLR start "rule__RequirementCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1035:1: rule__RequirementCategory__Group__0 : rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 ;
    public final void rule__RequirementCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1039:1: ( rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1040:2: rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__02052);
            rule__RequirementCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__02055);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1047:1: rule__RequirementCategory__Group__0__Impl : ( 'category' ) ;
    public final void rule__RequirementCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1051:1: ( ( 'category' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1052:1: ( 'category' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1052:1: ( 'category' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1053:1: 'category'
            {
             before(grammarAccess.getRequirementCategoryAccess().getCategoryKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__RequirementCategory__Group__0__Impl2083); 
             after(grammarAccess.getRequirementCategoryAccess().getCategoryKeyword_0()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1066:1: rule__RequirementCategory__Group__1 : rule__RequirementCategory__Group__1__Impl rule__RequirementCategory__Group__2 ;
    public final void rule__RequirementCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1070:1: ( rule__RequirementCategory__Group__1__Impl rule__RequirementCategory__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1071:2: rule__RequirementCategory__Group__1__Impl rule__RequirementCategory__Group__2
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__12114);
            rule__RequirementCategory__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group__2_in_rule__RequirementCategory__Group__12117);
            rule__RequirementCategory__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1078:1: rule__RequirementCategory__Group__1__Impl : ( ( rule__RequirementCategory__NameAssignment_1 ) ) ;
    public final void rule__RequirementCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1082:1: ( ( ( rule__RequirementCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1083:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1083:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1084:1: ( rule__RequirementCategory__NameAssignment_1 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1085:1: ( rule__RequirementCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1085:2: rule__RequirementCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__NameAssignment_1_in_rule__RequirementCategory__Group__1__Impl2144);
            rule__RequirementCategory__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoryAccess().getNameAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__RequirementCategory__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1095:1: rule__RequirementCategory__Group__2 : rule__RequirementCategory__Group__2__Impl ;
    public final void rule__RequirementCategory__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1099:1: ( rule__RequirementCategory__Group__2__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1100:2: rule__RequirementCategory__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__2__Impl_in_rule__RequirementCategory__Group__22174);
            rule__RequirementCategory__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group__2"


    // $ANTLR start "rule__RequirementCategory__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1106:1: rule__RequirementCategory__Group__2__Impl : ( ( rule__RequirementCategory__Group_2__0 )? ) ;
    public final void rule__RequirementCategory__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1110:1: ( ( ( rule__RequirementCategory__Group_2__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1111:1: ( ( rule__RequirementCategory__Group_2__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1111:1: ( ( rule__RequirementCategory__Group_2__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1112:1: ( rule__RequirementCategory__Group_2__0 )?
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup_2()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1113:1: ( rule__RequirementCategory__Group_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1113:2: rule__RequirementCategory__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__RequirementCategory__Group_2__0_in_rule__RequirementCategory__Group__2__Impl2201);
                    rule__RequirementCategory__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRequirementCategoryAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group__2__Impl"


    // $ANTLR start "rule__RequirementCategory__Group_2__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1129:1: rule__RequirementCategory__Group_2__0 : rule__RequirementCategory__Group_2__0__Impl rule__RequirementCategory__Group_2__1 ;
    public final void rule__RequirementCategory__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1133:1: ( rule__RequirementCategory__Group_2__0__Impl rule__RequirementCategory__Group_2__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1134:2: rule__RequirementCategory__Group_2__0__Impl rule__RequirementCategory__Group_2__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group_2__0__Impl_in_rule__RequirementCategory__Group_2__02238);
            rule__RequirementCategory__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group_2__1_in_rule__RequirementCategory__Group_2__02241);
            rule__RequirementCategory__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group_2__0"


    // $ANTLR start "rule__RequirementCategory__Group_2__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1141:1: rule__RequirementCategory__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__RequirementCategory__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1145:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1146:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1146:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1147:1: 'extends'
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__RequirementCategory__Group_2__0__Impl2269); 
             after(grammarAccess.getRequirementCategoryAccess().getExtendsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group_2__0__Impl"


    // $ANTLR start "rule__RequirementCategory__Group_2__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1160:1: rule__RequirementCategory__Group_2__1 : rule__RequirementCategory__Group_2__1__Impl ;
    public final void rule__RequirementCategory__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1164:1: ( rule__RequirementCategory__Group_2__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1165:2: rule__RequirementCategory__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group_2__1__Impl_in_rule__RequirementCategory__Group_2__12300);
            rule__RequirementCategory__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group_2__1"


    // $ANTLR start "rule__RequirementCategory__Group_2__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1171:1: rule__RequirementCategory__Group_2__1__Impl : ( ( rule__RequirementCategory__ExtendsAssignment_2_1 ) ) ;
    public final void rule__RequirementCategory__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1175:1: ( ( ( rule__RequirementCategory__ExtendsAssignment_2_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1176:1: ( ( rule__RequirementCategory__ExtendsAssignment_2_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1176:1: ( ( rule__RequirementCategory__ExtendsAssignment_2_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1177:1: ( rule__RequirementCategory__ExtendsAssignment_2_1 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsAssignment_2_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1178:1: ( rule__RequirementCategory__ExtendsAssignment_2_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1178:2: rule__RequirementCategory__ExtendsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__ExtendsAssignment_2_1_in_rule__RequirementCategory__Group_2__1__Impl2327);
            rule__RequirementCategory__ExtendsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoryAccess().getExtendsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group_2__1__Impl"


    // $ANTLR start "rule__HazardCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1192:1: rule__HazardCategory__Group__0 : rule__HazardCategory__Group__0__Impl rule__HazardCategory__Group__1 ;
    public final void rule__HazardCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1196:1: ( rule__HazardCategory__Group__0__Impl rule__HazardCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1197:2: rule__HazardCategory__Group__0__Impl rule__HazardCategory__Group__1
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group__0__Impl_in_rule__HazardCategory__Group__02361);
            rule__HazardCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategory__Group__1_in_rule__HazardCategory__Group__02364);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1204:1: rule__HazardCategory__Group__0__Impl : ( 'category' ) ;
    public final void rule__HazardCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1208:1: ( ( 'category' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1209:1: ( 'category' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1209:1: ( 'category' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1210:1: 'category'
            {
             before(grammarAccess.getHazardCategoryAccess().getCategoryKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__HazardCategory__Group__0__Impl2392); 
             after(grammarAccess.getHazardCategoryAccess().getCategoryKeyword_0()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1223:1: rule__HazardCategory__Group__1 : rule__HazardCategory__Group__1__Impl rule__HazardCategory__Group__2 ;
    public final void rule__HazardCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1227:1: ( rule__HazardCategory__Group__1__Impl rule__HazardCategory__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1228:2: rule__HazardCategory__Group__1__Impl rule__HazardCategory__Group__2
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group__1__Impl_in_rule__HazardCategory__Group__12423);
            rule__HazardCategory__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategory__Group__2_in_rule__HazardCategory__Group__12426);
            rule__HazardCategory__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1235:1: rule__HazardCategory__Group__1__Impl : ( ( rule__HazardCategory__NameAssignment_1 ) ) ;
    public final void rule__HazardCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1239:1: ( ( ( rule__HazardCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1240:1: ( ( rule__HazardCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1240:1: ( ( rule__HazardCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1241:1: ( rule__HazardCategory__NameAssignment_1 )
            {
             before(grammarAccess.getHazardCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1242:1: ( rule__HazardCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1242:2: rule__HazardCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__HazardCategory__NameAssignment_1_in_rule__HazardCategory__Group__1__Impl2453);
            rule__HazardCategory__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHazardCategoryAccess().getNameAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__HazardCategory__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1252:1: rule__HazardCategory__Group__2 : rule__HazardCategory__Group__2__Impl ;
    public final void rule__HazardCategory__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1256:1: ( rule__HazardCategory__Group__2__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1257:2: rule__HazardCategory__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group__2__Impl_in_rule__HazardCategory__Group__22483);
            rule__HazardCategory__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group__2"


    // $ANTLR start "rule__HazardCategory__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1263:1: rule__HazardCategory__Group__2__Impl : ( ( rule__HazardCategory__Group_2__0 )? ) ;
    public final void rule__HazardCategory__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1267:1: ( ( ( rule__HazardCategory__Group_2__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1268:1: ( ( rule__HazardCategory__Group_2__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1268:1: ( ( rule__HazardCategory__Group_2__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1269:1: ( rule__HazardCategory__Group_2__0 )?
            {
             before(grammarAccess.getHazardCategoryAccess().getGroup_2()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1270:1: ( rule__HazardCategory__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1270:2: rule__HazardCategory__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__HazardCategory__Group_2__0_in_rule__HazardCategory__Group__2__Impl2510);
                    rule__HazardCategory__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHazardCategoryAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group__2__Impl"


    // $ANTLR start "rule__HazardCategory__Group_2__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1286:1: rule__HazardCategory__Group_2__0 : rule__HazardCategory__Group_2__0__Impl rule__HazardCategory__Group_2__1 ;
    public final void rule__HazardCategory__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1290:1: ( rule__HazardCategory__Group_2__0__Impl rule__HazardCategory__Group_2__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1291:2: rule__HazardCategory__Group_2__0__Impl rule__HazardCategory__Group_2__1
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group_2__0__Impl_in_rule__HazardCategory__Group_2__02547);
            rule__HazardCategory__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategory__Group_2__1_in_rule__HazardCategory__Group_2__02550);
            rule__HazardCategory__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group_2__0"


    // $ANTLR start "rule__HazardCategory__Group_2__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1298:1: rule__HazardCategory__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__HazardCategory__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1302:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1303:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1303:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1304:1: 'extends'
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__HazardCategory__Group_2__0__Impl2578); 
             after(grammarAccess.getHazardCategoryAccess().getExtendsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group_2__0__Impl"


    // $ANTLR start "rule__HazardCategory__Group_2__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1317:1: rule__HazardCategory__Group_2__1 : rule__HazardCategory__Group_2__1__Impl ;
    public final void rule__HazardCategory__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1321:1: ( rule__HazardCategory__Group_2__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1322:2: rule__HazardCategory__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group_2__1__Impl_in_rule__HazardCategory__Group_2__12609);
            rule__HazardCategory__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group_2__1"


    // $ANTLR start "rule__HazardCategory__Group_2__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1328:1: rule__HazardCategory__Group_2__1__Impl : ( ( rule__HazardCategory__ExtendsAssignment_2_1 ) ) ;
    public final void rule__HazardCategory__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1332:1: ( ( ( rule__HazardCategory__ExtendsAssignment_2_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1333:1: ( ( rule__HazardCategory__ExtendsAssignment_2_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1333:1: ( ( rule__HazardCategory__ExtendsAssignment_2_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1334:1: ( rule__HazardCategory__ExtendsAssignment_2_1 )
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsAssignment_2_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1335:1: ( rule__HazardCategory__ExtendsAssignment_2_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1335:2: rule__HazardCategory__ExtendsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__HazardCategory__ExtendsAssignment_2_1_in_rule__HazardCategory__Group_2__1__Impl2636);
            rule__HazardCategory__ExtendsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getHazardCategoryAccess().getExtendsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__Group_2__1__Impl"


    // $ANTLR start "rule__VerificationCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1349:1: rule__VerificationCategory__Group__0 : rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1 ;
    public final void rule__VerificationCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1353:1: ( rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1354:2: rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__0__Impl_in_rule__VerificationCategory__Group__02670);
            rule__VerificationCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategory__Group__1_in_rule__VerificationCategory__Group__02673);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1361:1: rule__VerificationCategory__Group__0__Impl : ( 'category' ) ;
    public final void rule__VerificationCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1365:1: ( ( 'category' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1366:1: ( 'category' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1366:1: ( 'category' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1367:1: 'category'
            {
             before(grammarAccess.getVerificationCategoryAccess().getCategoryKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__VerificationCategory__Group__0__Impl2701); 
             after(grammarAccess.getVerificationCategoryAccess().getCategoryKeyword_0()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1380:1: rule__VerificationCategory__Group__1 : rule__VerificationCategory__Group__1__Impl rule__VerificationCategory__Group__2 ;
    public final void rule__VerificationCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1384:1: ( rule__VerificationCategory__Group__1__Impl rule__VerificationCategory__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1385:2: rule__VerificationCategory__Group__1__Impl rule__VerificationCategory__Group__2
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__1__Impl_in_rule__VerificationCategory__Group__12732);
            rule__VerificationCategory__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategory__Group__2_in_rule__VerificationCategory__Group__12735);
            rule__VerificationCategory__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1392:1: rule__VerificationCategory__Group__1__Impl : ( ( rule__VerificationCategory__NameAssignment_1 ) ) ;
    public final void rule__VerificationCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1396:1: ( ( ( rule__VerificationCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1397:1: ( ( rule__VerificationCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1397:1: ( ( rule__VerificationCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1398:1: ( rule__VerificationCategory__NameAssignment_1 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1399:1: ( rule__VerificationCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1399:2: rule__VerificationCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__NameAssignment_1_in_rule__VerificationCategory__Group__1__Impl2762);
            rule__VerificationCategory__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVerificationCategoryAccess().getNameAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__VerificationCategory__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1409:1: rule__VerificationCategory__Group__2 : rule__VerificationCategory__Group__2__Impl ;
    public final void rule__VerificationCategory__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1413:1: ( rule__VerificationCategory__Group__2__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1414:2: rule__VerificationCategory__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__2__Impl_in_rule__VerificationCategory__Group__22792);
            rule__VerificationCategory__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group__2"


    // $ANTLR start "rule__VerificationCategory__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1420:1: rule__VerificationCategory__Group__2__Impl : ( ( rule__VerificationCategory__Group_2__0 )? ) ;
    public final void rule__VerificationCategory__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1424:1: ( ( ( rule__VerificationCategory__Group_2__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1425:1: ( ( rule__VerificationCategory__Group_2__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1425:1: ( ( rule__VerificationCategory__Group_2__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1426:1: ( rule__VerificationCategory__Group_2__0 )?
            {
             before(grammarAccess.getVerificationCategoryAccess().getGroup_2()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1427:1: ( rule__VerificationCategory__Group_2__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1427:2: rule__VerificationCategory__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__VerificationCategory__Group_2__0_in_rule__VerificationCategory__Group__2__Impl2819);
                    rule__VerificationCategory__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVerificationCategoryAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group__2__Impl"


    // $ANTLR start "rule__VerificationCategory__Group_2__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1443:1: rule__VerificationCategory__Group_2__0 : rule__VerificationCategory__Group_2__0__Impl rule__VerificationCategory__Group_2__1 ;
    public final void rule__VerificationCategory__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1447:1: ( rule__VerificationCategory__Group_2__0__Impl rule__VerificationCategory__Group_2__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1448:2: rule__VerificationCategory__Group_2__0__Impl rule__VerificationCategory__Group_2__1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group_2__0__Impl_in_rule__VerificationCategory__Group_2__02856);
            rule__VerificationCategory__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategory__Group_2__1_in_rule__VerificationCategory__Group_2__02859);
            rule__VerificationCategory__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group_2__0"


    // $ANTLR start "rule__VerificationCategory__Group_2__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1455:1: rule__VerificationCategory__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__VerificationCategory__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1459:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1460:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1460:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1461:1: 'extends'
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__VerificationCategory__Group_2__0__Impl2887); 
             after(grammarAccess.getVerificationCategoryAccess().getExtendsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group_2__0__Impl"


    // $ANTLR start "rule__VerificationCategory__Group_2__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1474:1: rule__VerificationCategory__Group_2__1 : rule__VerificationCategory__Group_2__1__Impl ;
    public final void rule__VerificationCategory__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1478:1: ( rule__VerificationCategory__Group_2__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1479:2: rule__VerificationCategory__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group_2__1__Impl_in_rule__VerificationCategory__Group_2__12918);
            rule__VerificationCategory__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group_2__1"


    // $ANTLR start "rule__VerificationCategory__Group_2__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1485:1: rule__VerificationCategory__Group_2__1__Impl : ( ( rule__VerificationCategory__ExtendsAssignment_2_1 ) ) ;
    public final void rule__VerificationCategory__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1489:1: ( ( ( rule__VerificationCategory__ExtendsAssignment_2_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1490:1: ( ( rule__VerificationCategory__ExtendsAssignment_2_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1490:1: ( ( rule__VerificationCategory__ExtendsAssignment_2_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1491:1: ( rule__VerificationCategory__ExtendsAssignment_2_1 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsAssignment_2_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1492:1: ( rule__VerificationCategory__ExtendsAssignment_2_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1492:2: rule__VerificationCategory__ExtendsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__ExtendsAssignment_2_1_in_rule__VerificationCategory__Group_2__1__Impl2945);
            rule__VerificationCategory__ExtendsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getVerificationCategoryAccess().getExtendsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__Group_2__1__Impl"


    // $ANTLR start "rule__ReferencePath__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1506:1: rule__ReferencePath__Group__0 : rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 ;
    public final void rule__ReferencePath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1510:1: ( rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1511:2: rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__02979);
            rule__ReferencePath__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__02982);
            rule__ReferencePath__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group__0"


    // $ANTLR start "rule__ReferencePath__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1518:1: rule__ReferencePath__Group__0__Impl : ( ( rule__ReferencePath__RefAssignment_0 ) ) ;
    public final void rule__ReferencePath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1522:1: ( ( ( rule__ReferencePath__RefAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1523:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1523:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1524:1: ( rule__ReferencePath__RefAssignment_0 )
            {
             before(grammarAccess.getReferencePathAccess().getRefAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1525:1: ( rule__ReferencePath__RefAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1525:2: rule__ReferencePath__RefAssignment_0
            {
            pushFollow(FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl3009);
            rule__ReferencePath__RefAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getReferencePathAccess().getRefAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group__0__Impl"


    // $ANTLR start "rule__ReferencePath__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1535:1: rule__ReferencePath__Group__1 : rule__ReferencePath__Group__1__Impl ;
    public final void rule__ReferencePath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1539:1: ( rule__ReferencePath__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1540:2: rule__ReferencePath__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__13039);
            rule__ReferencePath__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group__1"


    // $ANTLR start "rule__ReferencePath__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1546:1: rule__ReferencePath__Group__1__Impl : ( ( rule__ReferencePath__Group_1__0 ) ) ;
    public final void rule__ReferencePath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1550:1: ( ( ( rule__ReferencePath__Group_1__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1551:1: ( ( rule__ReferencePath__Group_1__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1551:1: ( ( rule__ReferencePath__Group_1__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1552:1: ( rule__ReferencePath__Group_1__0 )
            {
             before(grammarAccess.getReferencePathAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1553:1: ( rule__ReferencePath__Group_1__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1553:2: rule__ReferencePath__Group_1__0
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl3066);
            rule__ReferencePath__Group_1__0();

            state._fsp--;


            }

             after(grammarAccess.getReferencePathAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group__1__Impl"


    // $ANTLR start "rule__ReferencePath__Group_1__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1567:1: rule__ReferencePath__Group_1__0 : rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 ;
    public final void rule__ReferencePath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1571:1: ( rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1572:2: rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__03100);
            rule__ReferencePath__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__03103);
            rule__ReferencePath__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group_1__0"


    // $ANTLR start "rule__ReferencePath__Group_1__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1579:1: rule__ReferencePath__Group_1__0__Impl : ( '.' ) ;
    public final void rule__ReferencePath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1583:1: ( ( '.' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1584:1: ( '.' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1584:1: ( '.' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1585:1: '.'
            {
             before(grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0()); 
            match(input,19,FOLLOW_19_in_rule__ReferencePath__Group_1__0__Impl3131); 
             after(grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group_1__0__Impl"


    // $ANTLR start "rule__ReferencePath__Group_1__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1598:1: rule__ReferencePath__Group_1__1 : rule__ReferencePath__Group_1__1__Impl ;
    public final void rule__ReferencePath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1602:1: ( rule__ReferencePath__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1603:2: rule__ReferencePath__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__13162);
            rule__ReferencePath__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group_1__1"


    // $ANTLR start "rule__ReferencePath__Group_1__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1609:1: rule__ReferencePath__Group_1__1__Impl : ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) ;
    public final void rule__ReferencePath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1613:1: ( ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1614:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1614:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1615:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            {
             before(grammarAccess.getReferencePathAccess().getSubpathAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1616:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1616:2: rule__ReferencePath__SubpathAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl3189);
            rule__ReferencePath__SubpathAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getReferencePathAccess().getSubpathAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__Group_1__1__Impl"


    // $ANTLR start "rule__CATREF__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1635:1: rule__CATREF__Group__0 : rule__CATREF__Group__0__Impl rule__CATREF__Group__1 ;
    public final void rule__CATREF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1639:1: ( rule__CATREF__Group__0__Impl rule__CATREF__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1640:2: rule__CATREF__Group__0__Impl rule__CATREF__Group__1
            {
            pushFollow(FOLLOW_rule__CATREF__Group__0__Impl_in_rule__CATREF__Group__03228);
            rule__CATREF__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CATREF__Group__1_in_rule__CATREF__Group__03231);
            rule__CATREF__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CATREF__Group__0"


    // $ANTLR start "rule__CATREF__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1647:1: rule__CATREF__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__CATREF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1651:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1652:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1652:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1653:1: RULE_ID
            {
             before(grammarAccess.getCATREFAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CATREF__Group__0__Impl3258); 
             after(grammarAccess.getCATREFAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CATREF__Group__0__Impl"


    // $ANTLR start "rule__CATREF__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1664:1: rule__CATREF__Group__1 : rule__CATREF__Group__1__Impl ;
    public final void rule__CATREF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1668:1: ( rule__CATREF__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1669:2: rule__CATREF__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__CATREF__Group__1__Impl_in_rule__CATREF__Group__13287);
            rule__CATREF__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CATREF__Group__1"


    // $ANTLR start "rule__CATREF__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1675:1: rule__CATREF__Group__1__Impl : ( ( rule__CATREF__Group_1__0 )? ) ;
    public final void rule__CATREF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1679:1: ( ( ( rule__CATREF__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1680:1: ( ( rule__CATREF__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1680:1: ( ( rule__CATREF__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1681:1: ( rule__CATREF__Group_1__0 )?
            {
             before(grammarAccess.getCATREFAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1682:1: ( rule__CATREF__Group_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1682:2: rule__CATREF__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__CATREF__Group_1__0_in_rule__CATREF__Group__1__Impl3314);
                    rule__CATREF__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCATREFAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CATREF__Group__1__Impl"


    // $ANTLR start "rule__CATREF__Group_1__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1696:1: rule__CATREF__Group_1__0 : rule__CATREF__Group_1__0__Impl rule__CATREF__Group_1__1 ;
    public final void rule__CATREF__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1700:1: ( rule__CATREF__Group_1__0__Impl rule__CATREF__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1701:2: rule__CATREF__Group_1__0__Impl rule__CATREF__Group_1__1
            {
            pushFollow(FOLLOW_rule__CATREF__Group_1__0__Impl_in_rule__CATREF__Group_1__03349);
            rule__CATREF__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CATREF__Group_1__1_in_rule__CATREF__Group_1__03352);
            rule__CATREF__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CATREF__Group_1__0"


    // $ANTLR start "rule__CATREF__Group_1__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1708:1: rule__CATREF__Group_1__0__Impl : ( '.' ) ;
    public final void rule__CATREF__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1712:1: ( ( '.' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1713:1: ( '.' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1713:1: ( '.' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1714:1: '.'
            {
             before(grammarAccess.getCATREFAccess().getFullStopKeyword_1_0()); 
            match(input,19,FOLLOW_19_in_rule__CATREF__Group_1__0__Impl3380); 
             after(grammarAccess.getCATREFAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CATREF__Group_1__0__Impl"


    // $ANTLR start "rule__CATREF__Group_1__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1727:1: rule__CATREF__Group_1__1 : rule__CATREF__Group_1__1__Impl ;
    public final void rule__CATREF__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1731:1: ( rule__CATREF__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1732:2: rule__CATREF__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__CATREF__Group_1__1__Impl_in_rule__CATREF__Group_1__13411);
            rule__CATREF__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CATREF__Group_1__1"


    // $ANTLR start "rule__CATREF__Group_1__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1738:1: rule__CATREF__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__CATREF__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1742:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1743:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1743:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1744:1: RULE_ID
            {
             before(grammarAccess.getCATREFAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CATREF__Group_1__1__Impl3438); 
             after(grammarAccess.getCATREFAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CATREF__Group_1__1__Impl"


    // $ANTLR start "rule__RequirementCategories__NameAssignment_2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1760:1: rule__RequirementCategories__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__RequirementCategories__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1764:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1765:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1765:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1766:1: RULE_ID
            {
             before(grammarAccess.getRequirementCategoriesAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RequirementCategories__NameAssignment_23476); 
             after(grammarAccess.getRequirementCategoriesAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__NameAssignment_2"


    // $ANTLR start "rule__RequirementCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1775:1: rule__RequirementCategories__CategoryAssignment_4 : ( ruleRequirementCategory ) ;
    public final void rule__RequirementCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1779:1: ( ( ruleRequirementCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1780:1: ( ruleRequirementCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1780:1: ( ruleRequirementCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1781:1: ruleRequirementCategory
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_43507);
            ruleRequirementCategory();

            state._fsp--;

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__CategoryAssignment_4"


    // $ANTLR start "rule__HazardCategories__NameAssignment_2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1790:1: rule__HazardCategories__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__HazardCategories__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1794:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1795:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1795:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1796:1: RULE_ID
            {
             before(grammarAccess.getHazardCategoriesAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__HazardCategories__NameAssignment_23538); 
             after(grammarAccess.getHazardCategoriesAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__NameAssignment_2"


    // $ANTLR start "rule__HazardCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1805:1: rule__HazardCategories__CategoryAssignment_4 : ( ruleHazardCategory ) ;
    public final void rule__HazardCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1809:1: ( ( ruleHazardCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1810:1: ( ruleHazardCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1810:1: ( ruleHazardCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1811:1: ruleHazardCategory
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoryHazardCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleHazardCategory_in_rule__HazardCategories__CategoryAssignment_43569);
            ruleHazardCategory();

            state._fsp--;

             after(grammarAccess.getHazardCategoriesAccess().getCategoryHazardCategoryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategories__CategoryAssignment_4"


    // $ANTLR start "rule__VerificationCategories__NameAssignment_2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1820:1: rule__VerificationCategories__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__VerificationCategories__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1824:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1825:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1825:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1826:1: RULE_ID
            {
             before(grammarAccess.getVerificationCategoriesAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VerificationCategories__NameAssignment_23600); 
             after(grammarAccess.getVerificationCategoriesAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__NameAssignment_2"


    // $ANTLR start "rule__VerificationCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1835:1: rule__VerificationCategories__CategoryAssignment_4 : ( ruleVerificationCategory ) ;
    public final void rule__VerificationCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1839:1: ( ( ruleVerificationCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1840:1: ( ruleVerificationCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1840:1: ( ruleVerificationCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1841:1: ruleVerificationCategory
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryVerificationCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_rule__VerificationCategories__CategoryAssignment_43631);
            ruleVerificationCategory();

            state._fsp--;

             after(grammarAccess.getVerificationCategoriesAccess().getCategoryVerificationCategoryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategories__CategoryAssignment_4"


    // $ANTLR start "rule__RequirementCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1850:1: rule__RequirementCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RequirementCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1854:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1855:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1855:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1856:1: RULE_ID
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_13662); 
             after(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__NameAssignment_1"


    // $ANTLR start "rule__RequirementCategory__ExtendsAssignment_2_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1865:1: rule__RequirementCategory__ExtendsAssignment_2_1 : ( ( ruleCATREF ) ) ;
    public final void rule__RequirementCategory__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1869:1: ( ( ( ruleCATREF ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1870:1: ( ( ruleCATREF ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1870:1: ( ( ruleCATREF ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1871:1: ( ruleCATREF )
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCrossReference_2_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1872:1: ( ruleCATREF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1873:1: ruleCATREF
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCATREFParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_ruleCATREF_in_rule__RequirementCategory__ExtendsAssignment_2_13697);
            ruleCATREF();

            state._fsp--;

             after(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCATREFParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__ExtendsAssignment_2_1"


    // $ANTLR start "rule__HazardCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1884:1: rule__HazardCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HazardCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1888:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1889:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1889:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1890:1: RULE_ID
            {
             before(grammarAccess.getHazardCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__HazardCategory__NameAssignment_13732); 
             after(grammarAccess.getHazardCategoryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__NameAssignment_1"


    // $ANTLR start "rule__HazardCategory__ExtendsAssignment_2_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1899:1: rule__HazardCategory__ExtendsAssignment_2_1 : ( ( ruleCATREF ) ) ;
    public final void rule__HazardCategory__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1903:1: ( ( ( ruleCATREF ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1904:1: ( ( ruleCATREF ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1904:1: ( ( ruleCATREF ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1905:1: ( ruleCATREF )
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCrossReference_2_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1906:1: ( ruleCATREF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1907:1: ruleCATREF
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCATREFParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_ruleCATREF_in_rule__HazardCategory__ExtendsAssignment_2_13767);
            ruleCATREF();

            state._fsp--;

             after(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCATREFParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HazardCategory__ExtendsAssignment_2_1"


    // $ANTLR start "rule__VerificationCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1918:1: rule__VerificationCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__VerificationCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1922:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1923:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1923:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1924:1: RULE_ID
            {
             before(grammarAccess.getVerificationCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VerificationCategory__NameAssignment_13802); 
             after(grammarAccess.getVerificationCategoryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__NameAssignment_1"


    // $ANTLR start "rule__VerificationCategory__ExtendsAssignment_2_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1933:1: rule__VerificationCategory__ExtendsAssignment_2_1 : ( ( ruleCATREF ) ) ;
    public final void rule__VerificationCategory__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1937:1: ( ( ( ruleCATREF ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1938:1: ( ( ruleCATREF ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1938:1: ( ( ruleCATREF ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1939:1: ( ruleCATREF )
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCrossReference_2_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1940:1: ( ruleCATREF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1941:1: ruleCATREF
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCATREFParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_ruleCATREF_in_rule__VerificationCategory__ExtendsAssignment_2_13837);
            ruleCATREF();

            state._fsp--;

             after(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCATREFParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VerificationCategory__ExtendsAssignment_2_1"


    // $ANTLR start "rule__Description__DescriptionAssignment"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1953:1: rule__Description__DescriptionAssignment : ( ruleDescriptionElement ) ;
    public final void rule__Description__DescriptionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1957:1: ( ( ruleDescriptionElement ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1958:1: ( ruleDescriptionElement )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1958:1: ( ruleDescriptionElement )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1959:1: ruleDescriptionElement
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment3873);
            ruleDescriptionElement();

            state._fsp--;

             after(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Description__DescriptionAssignment"


    // $ANTLR start "rule__DescriptionElement__TextAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1968:1: rule__DescriptionElement__TextAssignment_0 : ( RULE_STRING ) ;
    public final void rule__DescriptionElement__TextAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1972:1: ( ( RULE_STRING ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1973:1: ( RULE_STRING )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1973:1: ( RULE_STRING )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1974:1: RULE_STRING
            {
             before(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_03904); 
             after(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptionElement__TextAssignment_0"


    // $ANTLR start "rule__DescriptionElement__RefAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1983:1: rule__DescriptionElement__RefAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DescriptionElement__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1987:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1988:1: ( ( RULE_ID ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1988:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1989:1: ( RULE_ID )
            {
             before(grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1990:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1991:1: RULE_ID
            {
             before(grammarAccess.getDescriptionElementAccess().getRefEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DescriptionElement__RefAssignment_13939); 
             after(grammarAccess.getDescriptionElementAccess().getRefEObjectIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DescriptionElement__RefAssignment_1"


    // $ANTLR start "rule__ReferencePath__RefAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2002:1: rule__ReferencePath__RefAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ReferencePath__RefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2006:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2007:1: ( ( RULE_ID ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2007:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2008:1: ( RULE_ID )
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2009:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2010:1: RULE_ID
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_03978); 
             after(grammarAccess.getReferencePathAccess().getRefEObjectIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__RefAssignment_0"


    // $ANTLR start "rule__ReferencePath__SubpathAssignment_1_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2021:1: rule__ReferencePath__SubpathAssignment_1_1 : ( ruleReferencePath ) ;
    public final void rule__ReferencePath__SubpathAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2025:1: ( ( ruleReferencePath ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2026:1: ( ruleReferencePath )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2026:1: ( ruleReferencePath )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2027:1: ruleReferencePath
            {
             before(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_14013);
            ruleReferencePath();

            state._fsp--;

             after(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencePath__SubpathAssignment_1_1"

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
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategory368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__0_in_ruleHazardCategory394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategory428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__0_in_ruleVerificationCategory454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription518 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription530 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement560 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__Alternatives_in_ruleDescriptionElement593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__0_in_ruleReferencePath653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCATREF_in_entryRuleCATREF686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCATREF693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CATREF__Group__0_in_ruleCATREF719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_rule__Categories__Alternatives755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategories_in_rule__Categories__Alternatives772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_rule__Categories__Alternatives789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__RefAssignment_1_in_rule__DescriptionElement__Alternatives839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__0870 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__0873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__RequirementCategories__Group__0__Impl901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__1932 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__RequirementCategories__Group__1__Impl963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__2994 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__NameAssignment_2_in_rule__RequirementCategories__Group__2__Impl1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__31054 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__31057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__RequirementCategories__Group__3__Impl1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__41116 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__5_in_rule__RequirementCategories__Group__41119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1148 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1160 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__5__Impl_in_rule__RequirementCategories__Group__51193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__RequirementCategories__Group__5__Impl1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__0__Impl_in_rule__HazardCategories__Group__01264 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__1_in_rule__HazardCategories__Group__01267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__HazardCategories__Group__0__Impl1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__1__Impl_in_rule__HazardCategories__Group__11326 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__2_in_rule__HazardCategories__Group__11329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__HazardCategories__Group__1__Impl1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__2__Impl_in_rule__HazardCategories__Group__21388 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__3_in_rule__HazardCategories__Group__21391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__NameAssignment_2_in_rule__HazardCategories__Group__2__Impl1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__3__Impl_in_rule__HazardCategories__Group__31448 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__4_in_rule__HazardCategories__Group__31451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__HazardCategories__Group__3__Impl1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__4__Impl_in_rule__HazardCategories__Group__41510 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__5_in_rule__HazardCategories__Group__41513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__CategoryAssignment_4_in_rule__HazardCategories__Group__4__Impl1542 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__HazardCategories__CategoryAssignment_4_in_rule__HazardCategories__Group__4__Impl1554 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__5__Impl_in_rule__HazardCategories__Group__51587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__HazardCategories__Group__5__Impl1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__0__Impl_in_rule__VerificationCategories__Group__01658 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__1_in_rule__VerificationCategories__Group__01661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VerificationCategories__Group__0__Impl1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__1__Impl_in_rule__VerificationCategories__Group__11720 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__2_in_rule__VerificationCategories__Group__11723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__VerificationCategories__Group__1__Impl1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__2__Impl_in_rule__VerificationCategories__Group__21782 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__3_in_rule__VerificationCategories__Group__21785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__NameAssignment_2_in_rule__VerificationCategories__Group__2__Impl1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__3__Impl_in_rule__VerificationCategories__Group__31842 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__4_in_rule__VerificationCategories__Group__31845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VerificationCategories__Group__3__Impl1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__4__Impl_in_rule__VerificationCategories__Group__41904 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__5_in_rule__VerificationCategories__Group__41907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__CategoryAssignment_4_in_rule__VerificationCategories__Group__4__Impl1936 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__CategoryAssignment_4_in_rule__VerificationCategories__Group__4__Impl1948 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__5__Impl_in_rule__VerificationCategories__Group__51981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VerificationCategories__Group__5__Impl2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__02052 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__02055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__RequirementCategory__Group__0__Impl2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__12114 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__2_in_rule__RequirementCategory__Group__12117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__NameAssignment_1_in_rule__RequirementCategory__Group__1__Impl2144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__2__Impl_in_rule__RequirementCategory__Group__22174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_2__0_in_rule__RequirementCategory__Group__2__Impl2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_2__0__Impl_in_rule__RequirementCategory__Group_2__02238 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_2__1_in_rule__RequirementCategory__Group_2__02241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__RequirementCategory__Group_2__0__Impl2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_2__1__Impl_in_rule__RequirementCategory__Group_2__12300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__ExtendsAssignment_2_1_in_rule__RequirementCategory__Group_2__1__Impl2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__0__Impl_in_rule__HazardCategory__Group__02361 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__1_in_rule__HazardCategory__Group__02364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__HazardCategory__Group__0__Impl2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__1__Impl_in_rule__HazardCategory__Group__12423 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__2_in_rule__HazardCategory__Group__12426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__NameAssignment_1_in_rule__HazardCategory__Group__1__Impl2453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__2__Impl_in_rule__HazardCategory__Group__22483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_2__0_in_rule__HazardCategory__Group__2__Impl2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_2__0__Impl_in_rule__HazardCategory__Group_2__02547 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_2__1_in_rule__HazardCategory__Group_2__02550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__HazardCategory__Group_2__0__Impl2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_2__1__Impl_in_rule__HazardCategory__Group_2__12609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__ExtendsAssignment_2_1_in_rule__HazardCategory__Group_2__1__Impl2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__0__Impl_in_rule__VerificationCategory__Group__02670 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__1_in_rule__VerificationCategory__Group__02673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__VerificationCategory__Group__0__Impl2701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__1__Impl_in_rule__VerificationCategory__Group__12732 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__2_in_rule__VerificationCategory__Group__12735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__NameAssignment_1_in_rule__VerificationCategory__Group__1__Impl2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__2__Impl_in_rule__VerificationCategory__Group__22792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_2__0_in_rule__VerificationCategory__Group__2__Impl2819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_2__0__Impl_in_rule__VerificationCategory__Group_2__02856 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_2__1_in_rule__VerificationCategory__Group_2__02859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__VerificationCategory__Group_2__0__Impl2887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_2__1__Impl_in_rule__VerificationCategory__Group_2__12918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__ExtendsAssignment_2_1_in_rule__VerificationCategory__Group_2__1__Impl2945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__02979 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__02982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl3009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__13039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl3066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__03100 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__03103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ReferencePath__Group_1__0__Impl3131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__13162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl3189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CATREF__Group__0__Impl_in_rule__CATREF__Group__03228 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__CATREF__Group__1_in_rule__CATREF__Group__03231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CATREF__Group__0__Impl3258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CATREF__Group__1__Impl_in_rule__CATREF__Group__13287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CATREF__Group_1__0_in_rule__CATREF__Group__1__Impl3314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CATREF__Group_1__0__Impl_in_rule__CATREF__Group_1__03349 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CATREF__Group_1__1_in_rule__CATREF__Group_1__03352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CATREF__Group_1__0__Impl3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CATREF__Group_1__1__Impl_in_rule__CATREF__Group_1__13411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CATREF__Group_1__1__Impl3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RequirementCategories__NameAssignment_23476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_43507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__HazardCategories__NameAssignment_23538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_rule__HazardCategories__CategoryAssignment_43569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VerificationCategories__NameAssignment_23600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_rule__VerificationCategories__CategoryAssignment_43631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_13662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCATREF_in_rule__RequirementCategory__ExtendsAssignment_2_13697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__HazardCategory__NameAssignment_13732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCATREF_in_rule__HazardCategory__ExtendsAssignment_2_13767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VerificationCategory__NameAssignment_13802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCATREF_in_rule__VerificationCategory__ExtendsAssignment_2_13837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment3873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_03904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DescriptionElement__RefAssignment_13939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_03978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_14013 = new BitSet(new long[]{0x0000000000000002L});

}
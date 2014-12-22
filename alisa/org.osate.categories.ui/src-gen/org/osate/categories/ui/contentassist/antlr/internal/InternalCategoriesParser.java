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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requirement'", "'categories'", "'['", "']'", "'hazard'", "'verification'", "'category'", "'extends'", "'.'", "'.*'"
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
    public static final int T__20=20;
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


    // $ANTLR start "entryRuleHazardCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:202:1: entryRuleHazardCategory : ruleHazardCategory EOF ;
    public final void entryRuleHazardCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:203:1: ( ruleHazardCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:204:1: ruleHazardCategory EOF
            {
             before(grammarAccess.getHazardCategoryRule()); 
            pushFollow(FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory363);
            ruleHazardCategory();

            state._fsp--;

             after(grammarAccess.getHazardCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategory370); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:211:1: ruleHazardCategory : ( ( rule__HazardCategory__Group__0 ) ) ;
    public final void ruleHazardCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:215:2: ( ( ( rule__HazardCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:216:1: ( ( rule__HazardCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:216:1: ( ( rule__HazardCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:217:1: ( rule__HazardCategory__Group__0 )
            {
             before(grammarAccess.getHazardCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:218:1: ( rule__HazardCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:218:2: rule__HazardCategory__Group__0
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group__0_in_ruleHazardCategory396);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:230:1: entryRuleVerificationCategory : ruleVerificationCategory EOF ;
    public final void entryRuleVerificationCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:231:1: ( ruleVerificationCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:232:1: ruleVerificationCategory EOF
            {
             before(grammarAccess.getVerificationCategoryRule()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory423);
            ruleVerificationCategory();

            state._fsp--;

             after(grammarAccess.getVerificationCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategory430); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:239:1: ruleVerificationCategory : ( ( rule__VerificationCategory__Group__0 ) ) ;
    public final void ruleVerificationCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:243:2: ( ( ( rule__VerificationCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:244:1: ( ( rule__VerificationCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:244:1: ( ( rule__VerificationCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:245:1: ( rule__VerificationCategory__Group__0 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:246:1: ( rule__VerificationCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:246:2: rule__VerificationCategory__Group__0
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__0_in_ruleVerificationCategory456);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:260:1: entryRuleDescription : ruleDescription EOF ;
    public final void entryRuleDescription() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:261:1: ( ruleDescription EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:262:1: ruleDescription EOF
            {
             before(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription485);
            ruleDescription();

            state._fsp--;

             after(grammarAccess.getDescriptionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription492); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:269:1: ruleDescription : ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) ) ;
    public final void ruleDescription() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:273:2: ( ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:274:1: ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:274:1: ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:275:1: ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:275:1: ( ( rule__Description__DescriptionAssignment ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:276:1: ( rule__Description__DescriptionAssignment )
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:277:1: ( rule__Description__DescriptionAssignment )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:277:2: rule__Description__DescriptionAssignment
            {
            pushFollow(FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription520);
            rule__Description__DescriptionAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:280:1: ( ( rule__Description__DescriptionAssignment )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:281:1: ( rule__Description__DescriptionAssignment )*
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:282:1: ( rule__Description__DescriptionAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:282:2: rule__Description__DescriptionAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription532);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:295:1: entryRuleDescriptionElement : ruleDescriptionElement EOF ;
    public final void entryRuleDescriptionElement() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:296:1: ( ruleDescriptionElement EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:297:1: ruleDescriptionElement EOF
            {
             before(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement562);
            ruleDescriptionElement();

            state._fsp--;

             after(grammarAccess.getDescriptionElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement569); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:304:1: ruleDescriptionElement : ( ( rule__DescriptionElement__Alternatives ) ) ;
    public final void ruleDescriptionElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:308:2: ( ( ( rule__DescriptionElement__Alternatives ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:309:1: ( ( rule__DescriptionElement__Alternatives ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:309:1: ( ( rule__DescriptionElement__Alternatives ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:310:1: ( rule__DescriptionElement__Alternatives )
            {
             before(grammarAccess.getDescriptionElementAccess().getAlternatives()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:311:1: ( rule__DescriptionElement__Alternatives )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:311:2: rule__DescriptionElement__Alternatives
            {
            pushFollow(FOLLOW_rule__DescriptionElement__Alternatives_in_ruleDescriptionElement595);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:323:1: entryRuleReferencePath : ruleReferencePath EOF ;
    public final void entryRuleReferencePath() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:324:1: ( ruleReferencePath EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:325:1: ruleReferencePath EOF
            {
             before(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath622);
            ruleReferencePath();

            state._fsp--;

             after(grammarAccess.getReferencePathRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath629); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:332:1: ruleReferencePath : ( ( rule__ReferencePath__Group__0 ) ) ;
    public final void ruleReferencePath() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:336:2: ( ( ( rule__ReferencePath__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:337:1: ( ( rule__ReferencePath__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:337:1: ( ( rule__ReferencePath__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:338:1: ( rule__ReferencePath__Group__0 )
            {
             before(grammarAccess.getReferencePathAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:339:1: ( rule__ReferencePath__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:339:2: rule__ReferencePath__Group__0
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__0_in_ruleReferencePath655);
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


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:355:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:356:1: ( ruleQualifiedName EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:357:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName686);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName693); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:364:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:368:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:369:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:369:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:370:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:371:1: ( rule__QualifiedName__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:371:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName719);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:383:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:384:1: ( ruleQualifiedNameWithWildcard EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:385:1: ruleQualifiedNameWithWildcard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard746);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard753); 

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
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:392:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:396:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:397:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:397:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:398:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:399:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:399:2: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard779);
            rule__QualifiedNameWithWildcard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:413:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:414:1: ( ruleCatRef EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:415:1: ruleCatRef EOF
            {
             before(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef808);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getCatRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef815); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:422:1: ruleCatRef : ( RULE_ID ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:426:2: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:427:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:427:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:428:1: RULE_ID
            {
             before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef841); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:441:1: rule__Categories__Alternatives : ( ( ruleRequirementCategories ) | ( ruleHazardCategories ) | ( ruleVerificationCategories ) );
    public final void rule__Categories__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:445:1: ( ( ruleRequirementCategories ) | ( ruleHazardCategories ) | ( ruleVerificationCategories ) )
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:446:1: ( ruleRequirementCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:446:1: ( ruleRequirementCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:447:1: ruleRequirementCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRequirementCategories_in_rule__Categories__Alternatives876);
                    ruleRequirementCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:452:6: ( ruleHazardCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:452:6: ( ruleHazardCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:453:1: ruleHazardCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getHazardCategoriesParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHazardCategories_in_rule__Categories__Alternatives893);
                    ruleHazardCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getHazardCategoriesParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:458:6: ( ruleVerificationCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:458:6: ( ruleVerificationCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:459:1: ruleVerificationCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getVerificationCategoriesParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleVerificationCategories_in_rule__Categories__Alternatives910);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:470:1: rule__DescriptionElement__Alternatives : ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__RefAssignment_1 ) ) );
    public final void rule__DescriptionElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:474:1: ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__RefAssignment_1 ) ) )
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:475:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:475:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:476:1: ( rule__DescriptionElement__TextAssignment_0 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:477:1: ( rule__DescriptionElement__TextAssignment_0 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:477:2: rule__DescriptionElement__TextAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives943);
                    rule__DescriptionElement__TextAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:481:6: ( ( rule__DescriptionElement__RefAssignment_1 ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:481:6: ( ( rule__DescriptionElement__RefAssignment_1 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:482:1: ( rule__DescriptionElement__RefAssignment_1 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getRefAssignment_1()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:483:1: ( rule__DescriptionElement__RefAssignment_1 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:483:2: rule__DescriptionElement__RefAssignment_1
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__RefAssignment_1_in_rule__DescriptionElement__Alternatives961);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:494:1: rule__RequirementCategories__Group__0 : rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 ;
    public final void rule__RequirementCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:498:1: ( rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:499:2: rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__0992);
            rule__RequirementCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__0995);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:506:1: rule__RequirementCategories__Group__0__Impl : ( 'requirement' ) ;
    public final void rule__RequirementCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:510:1: ( ( 'requirement' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:511:1: ( 'requirement' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:511:1: ( 'requirement' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:512:1: 'requirement'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__RequirementCategories__Group__0__Impl1023); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:525:1: rule__RequirementCategories__Group__1 : rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 ;
    public final void rule__RequirementCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:529:1: ( rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:530:2: rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__11054);
            rule__RequirementCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__11057);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:537:1: rule__RequirementCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__RequirementCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:541:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:542:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:542:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:543:1: 'categories'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__RequirementCategories__Group__1__Impl1085); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:556:1: rule__RequirementCategories__Group__2 : rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 ;
    public final void rule__RequirementCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:560:1: ( rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:561:2: rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__21116);
            rule__RequirementCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__21119);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:568:1: rule__RequirementCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__RequirementCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:572:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:573:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:573:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:574:1: '['
            {
             before(grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__RequirementCategories__Group__2__Impl1147); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:587:1: rule__RequirementCategories__Group__3 : rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 ;
    public final void rule__RequirementCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:591:1: ( rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:592:2: rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__31178);
            rule__RequirementCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__31181);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:599:1: rule__RequirementCategories__Group__3__Impl : ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__RequirementCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:603:1: ( ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:604:1: ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:604:1: ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:605:1: ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:605:1: ( ( rule__RequirementCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:606:1: ( rule__RequirementCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:607:1: ( rule__RequirementCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:607:2: rule__RequirementCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl1210);
            rule__RequirementCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:610:1: ( ( rule__RequirementCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:611:1: ( rule__RequirementCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:612:1: ( rule__RequirementCategories__CategoryAssignment_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:612:2: rule__RequirementCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl1222);
            	    rule__RequirementCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:623:1: rule__RequirementCategories__Group__4 : rule__RequirementCategories__Group__4__Impl ;
    public final void rule__RequirementCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:627:1: ( rule__RequirementCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:628:2: rule__RequirementCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__41255);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:634:1: rule__RequirementCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__RequirementCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:638:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:639:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:639:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:640:1: ']'
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__RequirementCategories__Group__4__Impl1283); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:663:1: rule__HazardCategories__Group__0 : rule__HazardCategories__Group__0__Impl rule__HazardCategories__Group__1 ;
    public final void rule__HazardCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:667:1: ( rule__HazardCategories__Group__0__Impl rule__HazardCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:668:2: rule__HazardCategories__Group__0__Impl rule__HazardCategories__Group__1
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__0__Impl_in_rule__HazardCategories__Group__01324);
            rule__HazardCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__1_in_rule__HazardCategories__Group__01327);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:675:1: rule__HazardCategories__Group__0__Impl : ( 'hazard' ) ;
    public final void rule__HazardCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:679:1: ( ( 'hazard' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:680:1: ( 'hazard' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:680:1: ( 'hazard' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:681:1: 'hazard'
            {
             before(grammarAccess.getHazardCategoriesAccess().getHazardKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__HazardCategories__Group__0__Impl1355); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:694:1: rule__HazardCategories__Group__1 : rule__HazardCategories__Group__1__Impl rule__HazardCategories__Group__2 ;
    public final void rule__HazardCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:698:1: ( rule__HazardCategories__Group__1__Impl rule__HazardCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:699:2: rule__HazardCategories__Group__1__Impl rule__HazardCategories__Group__2
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__1__Impl_in_rule__HazardCategories__Group__11386);
            rule__HazardCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__2_in_rule__HazardCategories__Group__11389);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:706:1: rule__HazardCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__HazardCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:710:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:711:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:711:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:712:1: 'categories'
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__HazardCategories__Group__1__Impl1417); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:725:1: rule__HazardCategories__Group__2 : rule__HazardCategories__Group__2__Impl rule__HazardCategories__Group__3 ;
    public final void rule__HazardCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:729:1: ( rule__HazardCategories__Group__2__Impl rule__HazardCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:730:2: rule__HazardCategories__Group__2__Impl rule__HazardCategories__Group__3
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__2__Impl_in_rule__HazardCategories__Group__21448);
            rule__HazardCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__3_in_rule__HazardCategories__Group__21451);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:737:1: rule__HazardCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__HazardCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:741:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:742:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:742:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:743:1: '['
            {
             before(grammarAccess.getHazardCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__HazardCategories__Group__2__Impl1479); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:756:1: rule__HazardCategories__Group__3 : rule__HazardCategories__Group__3__Impl rule__HazardCategories__Group__4 ;
    public final void rule__HazardCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:760:1: ( rule__HazardCategories__Group__3__Impl rule__HazardCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:761:2: rule__HazardCategories__Group__3__Impl rule__HazardCategories__Group__4
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__3__Impl_in_rule__HazardCategories__Group__31510);
            rule__HazardCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategories__Group__4_in_rule__HazardCategories__Group__31513);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:768:1: rule__HazardCategories__Group__3__Impl : ( ( ( rule__HazardCategories__CategoryAssignment_3 ) ) ( ( rule__HazardCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__HazardCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:772:1: ( ( ( ( rule__HazardCategories__CategoryAssignment_3 ) ) ( ( rule__HazardCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:773:1: ( ( ( rule__HazardCategories__CategoryAssignment_3 ) ) ( ( rule__HazardCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:773:1: ( ( ( rule__HazardCategories__CategoryAssignment_3 ) ) ( ( rule__HazardCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:774:1: ( ( rule__HazardCategories__CategoryAssignment_3 ) ) ( ( rule__HazardCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:774:1: ( ( rule__HazardCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:775:1: ( rule__HazardCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:776:1: ( rule__HazardCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:776:2: rule__HazardCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__HazardCategories__CategoryAssignment_3_in_rule__HazardCategories__Group__3__Impl1542);
            rule__HazardCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getHazardCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:779:1: ( ( rule__HazardCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:780:1: ( rule__HazardCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:781:1: ( rule__HazardCategories__CategoryAssignment_3 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:781:2: rule__HazardCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__HazardCategories__CategoryAssignment_3_in_rule__HazardCategories__Group__3__Impl1554);
            	    rule__HazardCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:792:1: rule__HazardCategories__Group__4 : rule__HazardCategories__Group__4__Impl ;
    public final void rule__HazardCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:796:1: ( rule__HazardCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:797:2: rule__HazardCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__HazardCategories__Group__4__Impl_in_rule__HazardCategories__Group__41587);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:803:1: rule__HazardCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__HazardCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:807:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:808:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:808:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:809:1: ']'
            {
             before(grammarAccess.getHazardCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__HazardCategories__Group__4__Impl1615); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:832:1: rule__VerificationCategories__Group__0 : rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1 ;
    public final void rule__VerificationCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:836:1: ( rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:837:2: rule__VerificationCategories__Group__0__Impl rule__VerificationCategories__Group__1
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__0__Impl_in_rule__VerificationCategories__Group__01656);
            rule__VerificationCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__1_in_rule__VerificationCategories__Group__01659);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:844:1: rule__VerificationCategories__Group__0__Impl : ( 'verification' ) ;
    public final void rule__VerificationCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:848:1: ( ( 'verification' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:849:1: ( 'verification' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:849:1: ( 'verification' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:850:1: 'verification'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getVerificationKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__VerificationCategories__Group__0__Impl1687); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:863:1: rule__VerificationCategories__Group__1 : rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2 ;
    public final void rule__VerificationCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:867:1: ( rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:868:2: rule__VerificationCategories__Group__1__Impl rule__VerificationCategories__Group__2
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__1__Impl_in_rule__VerificationCategories__Group__11718);
            rule__VerificationCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__2_in_rule__VerificationCategories__Group__11721);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:875:1: rule__VerificationCategories__Group__1__Impl : ( 'categories' ) ;
    public final void rule__VerificationCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:879:1: ( ( 'categories' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:880:1: ( 'categories' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:880:1: ( 'categories' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:881:1: 'categories'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__VerificationCategories__Group__1__Impl1749); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:894:1: rule__VerificationCategories__Group__2 : rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3 ;
    public final void rule__VerificationCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:898:1: ( rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:899:2: rule__VerificationCategories__Group__2__Impl rule__VerificationCategories__Group__3
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__2__Impl_in_rule__VerificationCategories__Group__21780);
            rule__VerificationCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategories__Group__3_in_rule__VerificationCategories__Group__21783);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:906:1: rule__VerificationCategories__Group__2__Impl : ( '[' ) ;
    public final void rule__VerificationCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:910:1: ( ( '[' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:911:1: ( '[' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:911:1: ( '[' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:912:1: '['
            {
             before(grammarAccess.getVerificationCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__VerificationCategories__Group__2__Impl1811); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:925:1: rule__VerificationCategories__Group__3 : rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4 ;
    public final void rule__VerificationCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:929:1: ( rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:930:2: rule__VerificationCategories__Group__3__Impl rule__VerificationCategories__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:937:1: rule__VerificationCategories__Group__3__Impl : ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__VerificationCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:941:1: ( ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:942:1: ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:942:1: ( ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:943:1: ( ( rule__VerificationCategories__CategoryAssignment_3 ) ) ( ( rule__VerificationCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:943:1: ( ( rule__VerificationCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:944:1: ( rule__VerificationCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:945:1: ( rule__VerificationCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:945:2: rule__VerificationCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1874);
            rule__VerificationCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:948:1: ( ( rule__VerificationCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:949:1: ( rule__VerificationCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:950:1: ( rule__VerificationCategories__CategoryAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:950:2: rule__VerificationCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1886);
            	    rule__VerificationCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:961:1: rule__VerificationCategories__Group__4 : rule__VerificationCategories__Group__4__Impl ;
    public final void rule__VerificationCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:965:1: ( rule__VerificationCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:966:2: rule__VerificationCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategories__Group__4__Impl_in_rule__VerificationCategories__Group__41919);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:972:1: rule__VerificationCategories__Group__4__Impl : ( ']' ) ;
    public final void rule__VerificationCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:976:1: ( ( ']' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:977:1: ( ']' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:977:1: ( ']' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:978:1: ']'
            {
             before(grammarAccess.getVerificationCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__VerificationCategories__Group__4__Impl1947); 
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


    // $ANTLR start "rule__RequirementCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1001:1: rule__RequirementCategory__Group__0 : rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 ;
    public final void rule__RequirementCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1005:1: ( rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1006:2: rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__01988);
            rule__RequirementCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__01991);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1013:1: rule__RequirementCategory__Group__0__Impl : ( 'category' ) ;
    public final void rule__RequirementCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1017:1: ( ( 'category' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1018:1: ( 'category' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1018:1: ( 'category' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1019:1: 'category'
            {
             before(grammarAccess.getRequirementCategoryAccess().getCategoryKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__RequirementCategory__Group__0__Impl2019); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1032:1: rule__RequirementCategory__Group__1 : rule__RequirementCategory__Group__1__Impl rule__RequirementCategory__Group__2 ;
    public final void rule__RequirementCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1036:1: ( rule__RequirementCategory__Group__1__Impl rule__RequirementCategory__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1037:2: rule__RequirementCategory__Group__1__Impl rule__RequirementCategory__Group__2
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__12050);
            rule__RequirementCategory__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group__2_in_rule__RequirementCategory__Group__12053);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1044:1: rule__RequirementCategory__Group__1__Impl : ( ( rule__RequirementCategory__NameAssignment_1 ) ) ;
    public final void rule__RequirementCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1048:1: ( ( ( rule__RequirementCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1049:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1049:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1050:1: ( rule__RequirementCategory__NameAssignment_1 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1051:1: ( rule__RequirementCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1051:2: rule__RequirementCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__NameAssignment_1_in_rule__RequirementCategory__Group__1__Impl2080);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1061:1: rule__RequirementCategory__Group__2 : rule__RequirementCategory__Group__2__Impl ;
    public final void rule__RequirementCategory__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1065:1: ( rule__RequirementCategory__Group__2__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1066:2: rule__RequirementCategory__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__2__Impl_in_rule__RequirementCategory__Group__22110);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1072:1: rule__RequirementCategory__Group__2__Impl : ( ( rule__RequirementCategory__Group_2__0 )? ) ;
    public final void rule__RequirementCategory__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1076:1: ( ( ( rule__RequirementCategory__Group_2__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1077:1: ( ( rule__RequirementCategory__Group_2__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1077:1: ( ( rule__RequirementCategory__Group_2__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1078:1: ( rule__RequirementCategory__Group_2__0 )?
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup_2()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1079:1: ( rule__RequirementCategory__Group_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1079:2: rule__RequirementCategory__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__RequirementCategory__Group_2__0_in_rule__RequirementCategory__Group__2__Impl2137);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1095:1: rule__RequirementCategory__Group_2__0 : rule__RequirementCategory__Group_2__0__Impl rule__RequirementCategory__Group_2__1 ;
    public final void rule__RequirementCategory__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1099:1: ( rule__RequirementCategory__Group_2__0__Impl rule__RequirementCategory__Group_2__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1100:2: rule__RequirementCategory__Group_2__0__Impl rule__RequirementCategory__Group_2__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group_2__0__Impl_in_rule__RequirementCategory__Group_2__02174);
            rule__RequirementCategory__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group_2__1_in_rule__RequirementCategory__Group_2__02177);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1107:1: rule__RequirementCategory__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__RequirementCategory__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1111:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1112:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1112:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1113:1: 'extends'
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__RequirementCategory__Group_2__0__Impl2205); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1126:1: rule__RequirementCategory__Group_2__1 : rule__RequirementCategory__Group_2__1__Impl ;
    public final void rule__RequirementCategory__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1130:1: ( rule__RequirementCategory__Group_2__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1131:2: rule__RequirementCategory__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group_2__1__Impl_in_rule__RequirementCategory__Group_2__12236);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1137:1: rule__RequirementCategory__Group_2__1__Impl : ( ( rule__RequirementCategory__ExtendsAssignment_2_1 ) ) ;
    public final void rule__RequirementCategory__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1141:1: ( ( ( rule__RequirementCategory__ExtendsAssignment_2_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1142:1: ( ( rule__RequirementCategory__ExtendsAssignment_2_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1142:1: ( ( rule__RequirementCategory__ExtendsAssignment_2_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1143:1: ( rule__RequirementCategory__ExtendsAssignment_2_1 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsAssignment_2_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1144:1: ( rule__RequirementCategory__ExtendsAssignment_2_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1144:2: rule__RequirementCategory__ExtendsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__ExtendsAssignment_2_1_in_rule__RequirementCategory__Group_2__1__Impl2263);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1158:1: rule__HazardCategory__Group__0 : rule__HazardCategory__Group__0__Impl rule__HazardCategory__Group__1 ;
    public final void rule__HazardCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1162:1: ( rule__HazardCategory__Group__0__Impl rule__HazardCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1163:2: rule__HazardCategory__Group__0__Impl rule__HazardCategory__Group__1
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group__0__Impl_in_rule__HazardCategory__Group__02297);
            rule__HazardCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategory__Group__1_in_rule__HazardCategory__Group__02300);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1170:1: rule__HazardCategory__Group__0__Impl : ( 'category' ) ;
    public final void rule__HazardCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1174:1: ( ( 'category' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1175:1: ( 'category' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1175:1: ( 'category' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1176:1: 'category'
            {
             before(grammarAccess.getHazardCategoryAccess().getCategoryKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__HazardCategory__Group__0__Impl2328); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1189:1: rule__HazardCategory__Group__1 : rule__HazardCategory__Group__1__Impl rule__HazardCategory__Group__2 ;
    public final void rule__HazardCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1193:1: ( rule__HazardCategory__Group__1__Impl rule__HazardCategory__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1194:2: rule__HazardCategory__Group__1__Impl rule__HazardCategory__Group__2
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group__1__Impl_in_rule__HazardCategory__Group__12359);
            rule__HazardCategory__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategory__Group__2_in_rule__HazardCategory__Group__12362);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1201:1: rule__HazardCategory__Group__1__Impl : ( ( rule__HazardCategory__NameAssignment_1 ) ) ;
    public final void rule__HazardCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1205:1: ( ( ( rule__HazardCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1206:1: ( ( rule__HazardCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1206:1: ( ( rule__HazardCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1207:1: ( rule__HazardCategory__NameAssignment_1 )
            {
             before(grammarAccess.getHazardCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1208:1: ( rule__HazardCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1208:2: rule__HazardCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__HazardCategory__NameAssignment_1_in_rule__HazardCategory__Group__1__Impl2389);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1218:1: rule__HazardCategory__Group__2 : rule__HazardCategory__Group__2__Impl ;
    public final void rule__HazardCategory__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1222:1: ( rule__HazardCategory__Group__2__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1223:2: rule__HazardCategory__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group__2__Impl_in_rule__HazardCategory__Group__22419);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1229:1: rule__HazardCategory__Group__2__Impl : ( ( rule__HazardCategory__Group_2__0 )? ) ;
    public final void rule__HazardCategory__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1233:1: ( ( ( rule__HazardCategory__Group_2__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1234:1: ( ( rule__HazardCategory__Group_2__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1234:1: ( ( rule__HazardCategory__Group_2__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1235:1: ( rule__HazardCategory__Group_2__0 )?
            {
             before(grammarAccess.getHazardCategoryAccess().getGroup_2()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1236:1: ( rule__HazardCategory__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1236:2: rule__HazardCategory__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__HazardCategory__Group_2__0_in_rule__HazardCategory__Group__2__Impl2446);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1252:1: rule__HazardCategory__Group_2__0 : rule__HazardCategory__Group_2__0__Impl rule__HazardCategory__Group_2__1 ;
    public final void rule__HazardCategory__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1256:1: ( rule__HazardCategory__Group_2__0__Impl rule__HazardCategory__Group_2__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1257:2: rule__HazardCategory__Group_2__0__Impl rule__HazardCategory__Group_2__1
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group_2__0__Impl_in_rule__HazardCategory__Group_2__02483);
            rule__HazardCategory__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HazardCategory__Group_2__1_in_rule__HazardCategory__Group_2__02486);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1264:1: rule__HazardCategory__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__HazardCategory__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1268:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1269:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1269:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1270:1: 'extends'
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__HazardCategory__Group_2__0__Impl2514); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1283:1: rule__HazardCategory__Group_2__1 : rule__HazardCategory__Group_2__1__Impl ;
    public final void rule__HazardCategory__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1287:1: ( rule__HazardCategory__Group_2__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1288:2: rule__HazardCategory__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__HazardCategory__Group_2__1__Impl_in_rule__HazardCategory__Group_2__12545);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1294:1: rule__HazardCategory__Group_2__1__Impl : ( ( rule__HazardCategory__ExtendsAssignment_2_1 ) ) ;
    public final void rule__HazardCategory__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1298:1: ( ( ( rule__HazardCategory__ExtendsAssignment_2_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1299:1: ( ( rule__HazardCategory__ExtendsAssignment_2_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1299:1: ( ( rule__HazardCategory__ExtendsAssignment_2_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1300:1: ( rule__HazardCategory__ExtendsAssignment_2_1 )
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsAssignment_2_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1301:1: ( rule__HazardCategory__ExtendsAssignment_2_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1301:2: rule__HazardCategory__ExtendsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__HazardCategory__ExtendsAssignment_2_1_in_rule__HazardCategory__Group_2__1__Impl2572);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1315:1: rule__VerificationCategory__Group__0 : rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1 ;
    public final void rule__VerificationCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1319:1: ( rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1320:2: rule__VerificationCategory__Group__0__Impl rule__VerificationCategory__Group__1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__0__Impl_in_rule__VerificationCategory__Group__02606);
            rule__VerificationCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategory__Group__1_in_rule__VerificationCategory__Group__02609);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1327:1: rule__VerificationCategory__Group__0__Impl : ( 'category' ) ;
    public final void rule__VerificationCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1331:1: ( ( 'category' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1332:1: ( 'category' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1332:1: ( 'category' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1333:1: 'category'
            {
             before(grammarAccess.getVerificationCategoryAccess().getCategoryKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__VerificationCategory__Group__0__Impl2637); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1346:1: rule__VerificationCategory__Group__1 : rule__VerificationCategory__Group__1__Impl rule__VerificationCategory__Group__2 ;
    public final void rule__VerificationCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1350:1: ( rule__VerificationCategory__Group__1__Impl rule__VerificationCategory__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1351:2: rule__VerificationCategory__Group__1__Impl rule__VerificationCategory__Group__2
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__1__Impl_in_rule__VerificationCategory__Group__12668);
            rule__VerificationCategory__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategory__Group__2_in_rule__VerificationCategory__Group__12671);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1358:1: rule__VerificationCategory__Group__1__Impl : ( ( rule__VerificationCategory__NameAssignment_1 ) ) ;
    public final void rule__VerificationCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1362:1: ( ( ( rule__VerificationCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1363:1: ( ( rule__VerificationCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1363:1: ( ( rule__VerificationCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1364:1: ( rule__VerificationCategory__NameAssignment_1 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1365:1: ( rule__VerificationCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1365:2: rule__VerificationCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__NameAssignment_1_in_rule__VerificationCategory__Group__1__Impl2698);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1375:1: rule__VerificationCategory__Group__2 : rule__VerificationCategory__Group__2__Impl ;
    public final void rule__VerificationCategory__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1379:1: ( rule__VerificationCategory__Group__2__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1380:2: rule__VerificationCategory__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group__2__Impl_in_rule__VerificationCategory__Group__22728);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1386:1: rule__VerificationCategory__Group__2__Impl : ( ( rule__VerificationCategory__Group_2__0 )? ) ;
    public final void rule__VerificationCategory__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1390:1: ( ( ( rule__VerificationCategory__Group_2__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1391:1: ( ( rule__VerificationCategory__Group_2__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1391:1: ( ( rule__VerificationCategory__Group_2__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1392:1: ( rule__VerificationCategory__Group_2__0 )?
            {
             before(grammarAccess.getVerificationCategoryAccess().getGroup_2()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1393:1: ( rule__VerificationCategory__Group_2__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1393:2: rule__VerificationCategory__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__VerificationCategory__Group_2__0_in_rule__VerificationCategory__Group__2__Impl2755);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1409:1: rule__VerificationCategory__Group_2__0 : rule__VerificationCategory__Group_2__0__Impl rule__VerificationCategory__Group_2__1 ;
    public final void rule__VerificationCategory__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1413:1: ( rule__VerificationCategory__Group_2__0__Impl rule__VerificationCategory__Group_2__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1414:2: rule__VerificationCategory__Group_2__0__Impl rule__VerificationCategory__Group_2__1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group_2__0__Impl_in_rule__VerificationCategory__Group_2__02792);
            rule__VerificationCategory__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VerificationCategory__Group_2__1_in_rule__VerificationCategory__Group_2__02795);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1421:1: rule__VerificationCategory__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__VerificationCategory__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1425:1: ( ( 'extends' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1426:1: ( 'extends' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1426:1: ( 'extends' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1427:1: 'extends'
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__VerificationCategory__Group_2__0__Impl2823); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1440:1: rule__VerificationCategory__Group_2__1 : rule__VerificationCategory__Group_2__1__Impl ;
    public final void rule__VerificationCategory__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1444:1: ( rule__VerificationCategory__Group_2__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1445:2: rule__VerificationCategory__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__VerificationCategory__Group_2__1__Impl_in_rule__VerificationCategory__Group_2__12854);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1451:1: rule__VerificationCategory__Group_2__1__Impl : ( ( rule__VerificationCategory__ExtendsAssignment_2_1 ) ) ;
    public final void rule__VerificationCategory__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1455:1: ( ( ( rule__VerificationCategory__ExtendsAssignment_2_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1456:1: ( ( rule__VerificationCategory__ExtendsAssignment_2_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1456:1: ( ( rule__VerificationCategory__ExtendsAssignment_2_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1457:1: ( rule__VerificationCategory__ExtendsAssignment_2_1 )
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsAssignment_2_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1458:1: ( rule__VerificationCategory__ExtendsAssignment_2_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1458:2: rule__VerificationCategory__ExtendsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__VerificationCategory__ExtendsAssignment_2_1_in_rule__VerificationCategory__Group_2__1__Impl2881);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1472:1: rule__ReferencePath__Group__0 : rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 ;
    public final void rule__ReferencePath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1476:1: ( rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1477:2: rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__02915);
            rule__ReferencePath__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__02918);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1484:1: rule__ReferencePath__Group__0__Impl : ( ( rule__ReferencePath__RefAssignment_0 ) ) ;
    public final void rule__ReferencePath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1488:1: ( ( ( rule__ReferencePath__RefAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1489:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1489:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1490:1: ( rule__ReferencePath__RefAssignment_0 )
            {
             before(grammarAccess.getReferencePathAccess().getRefAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1491:1: ( rule__ReferencePath__RefAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1491:2: rule__ReferencePath__RefAssignment_0
            {
            pushFollow(FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl2945);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1501:1: rule__ReferencePath__Group__1 : rule__ReferencePath__Group__1__Impl ;
    public final void rule__ReferencePath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1505:1: ( rule__ReferencePath__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1506:2: rule__ReferencePath__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__12975);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1512:1: rule__ReferencePath__Group__1__Impl : ( ( rule__ReferencePath__Group_1__0 ) ) ;
    public final void rule__ReferencePath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1516:1: ( ( ( rule__ReferencePath__Group_1__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1517:1: ( ( rule__ReferencePath__Group_1__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1517:1: ( ( rule__ReferencePath__Group_1__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1518:1: ( rule__ReferencePath__Group_1__0 )
            {
             before(grammarAccess.getReferencePathAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1519:1: ( rule__ReferencePath__Group_1__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1519:2: rule__ReferencePath__Group_1__0
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl3002);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1533:1: rule__ReferencePath__Group_1__0 : rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 ;
    public final void rule__ReferencePath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1537:1: ( rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1538:2: rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__03036);
            rule__ReferencePath__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__03039);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1545:1: rule__ReferencePath__Group_1__0__Impl : ( '.' ) ;
    public final void rule__ReferencePath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1549:1: ( ( '.' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1550:1: ( '.' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1550:1: ( '.' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1551:1: '.'
            {
             before(grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0()); 
            match(input,19,FOLLOW_19_in_rule__ReferencePath__Group_1__0__Impl3067); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1564:1: rule__ReferencePath__Group_1__1 : rule__ReferencePath__Group_1__1__Impl ;
    public final void rule__ReferencePath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1568:1: ( rule__ReferencePath__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1569:2: rule__ReferencePath__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__13098);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1575:1: rule__ReferencePath__Group_1__1__Impl : ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) ;
    public final void rule__ReferencePath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1579:1: ( ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1580:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1580:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1581:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            {
             before(grammarAccess.getReferencePathAccess().getSubpathAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1582:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1582:2: rule__ReferencePath__SubpathAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl3125);
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


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1597:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1601:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1602:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03160);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03163);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1609:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1613:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1614:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1614:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1615:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3190); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1626:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1630:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1631:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13219);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1637:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1641:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1642:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1642:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1643:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1644:1: ( rule__QualifiedName__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==19) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1644:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3246);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1658:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1662:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1663:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03281);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03284);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1670:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1674:1: ( ( '.' ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1675:1: ( '.' )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1675:1: ( '.' )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1676:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,19,FOLLOW_19_in_rule__QualifiedName__Group_1__0__Impl3312); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1689:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1693:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1694:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13343);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1700:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1704:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1705:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1705:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1706:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl3370); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1721:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1725:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1726:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__03403);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__03406);
            rule__QualifiedNameWithWildcard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1733:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1737:1: ( ( ruleQualifiedName ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1738:1: ( ruleQualifiedName )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1738:1: ( ruleQualifiedName )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1739:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl3433);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1750:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1754:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1755:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__13462);
            rule__QualifiedNameWithWildcard__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1761:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1765:1: ( ( ( '.*' )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1766:1: ( ( '.*' )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1766:1: ( ( '.*' )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1767:1: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1768:1: ( '.*' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1769:2: '.*'
                    {
                    match(input,20,FOLLOW_20_in_rule__QualifiedNameWithWildcard__Group__1__Impl3491); 

                    }
                    break;

            }

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1__Impl"


    // $ANTLR start "rule__RequirementCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1788:1: rule__RequirementCategories__CategoryAssignment_3 : ( ruleRequirementCategory ) ;
    public final void rule__RequirementCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1792:1: ( ( ruleRequirementCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1793:1: ( ruleRequirementCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1793:1: ( ruleRequirementCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1794:1: ruleRequirementCategory
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_33536);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1803:1: rule__HazardCategories__CategoryAssignment_3 : ( ruleHazardCategory ) ;
    public final void rule__HazardCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1807:1: ( ( ruleHazardCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1808:1: ( ruleHazardCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1808:1: ( ruleHazardCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1809:1: ruleHazardCategory
            {
             before(grammarAccess.getHazardCategoriesAccess().getCategoryHazardCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleHazardCategory_in_rule__HazardCategories__CategoryAssignment_33567);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1818:1: rule__VerificationCategories__CategoryAssignment_3 : ( ruleVerificationCategory ) ;
    public final void rule__VerificationCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1822:1: ( ( ruleVerificationCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1823:1: ( ruleVerificationCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1823:1: ( ruleVerificationCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1824:1: ruleVerificationCategory
            {
             before(grammarAccess.getVerificationCategoriesAccess().getCategoryVerificationCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_rule__VerificationCategories__CategoryAssignment_33598);
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


    // $ANTLR start "rule__RequirementCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1833:1: rule__RequirementCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RequirementCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1837:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1838:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1838:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1839:1: RULE_ID
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_13629); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1848:1: rule__RequirementCategory__ExtendsAssignment_2_1 : ( ( ruleCatRef ) ) ;
    public final void rule__RequirementCategory__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1852:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1853:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1853:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1854:1: ( ruleCatRef )
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCrossReference_2_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1855:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1856:1: ruleCatRef
            {
             before(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCatRefParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__RequirementCategory__ExtendsAssignment_2_13664);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCatRefParserRuleCall_2_1_0_1()); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1867:1: rule__HazardCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HazardCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1871:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1872:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1872:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1873:1: RULE_ID
            {
             before(grammarAccess.getHazardCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__HazardCategory__NameAssignment_13699); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1882:1: rule__HazardCategory__ExtendsAssignment_2_1 : ( ( ruleCatRef ) ) ;
    public final void rule__HazardCategory__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1886:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1887:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1887:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1888:1: ( ruleCatRef )
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCrossReference_2_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1889:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1890:1: ruleCatRef
            {
             before(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCatRefParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__HazardCategory__ExtendsAssignment_2_13734);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCatRefParserRuleCall_2_1_0_1()); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1901:1: rule__VerificationCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__VerificationCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1905:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1906:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1906:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1907:1: RULE_ID
            {
             before(grammarAccess.getVerificationCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VerificationCategory__NameAssignment_13769); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1916:1: rule__VerificationCategory__ExtendsAssignment_2_1 : ( ( ruleCatRef ) ) ;
    public final void rule__VerificationCategory__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1920:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1921:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1921:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1922:1: ( ruleCatRef )
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCrossReference_2_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1923:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1924:1: ruleCatRef
            {
             before(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCatRefParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__VerificationCategory__ExtendsAssignment_2_13804);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCatRefParserRuleCall_2_1_0_1()); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1936:1: rule__Description__DescriptionAssignment : ( ruleDescriptionElement ) ;
    public final void rule__Description__DescriptionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1940:1: ( ( ruleDescriptionElement ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1941:1: ( ruleDescriptionElement )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1941:1: ( ruleDescriptionElement )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1942:1: ruleDescriptionElement
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment3840);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1951:1: rule__DescriptionElement__TextAssignment_0 : ( RULE_STRING ) ;
    public final void rule__DescriptionElement__TextAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1955:1: ( ( RULE_STRING ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1956:1: ( RULE_STRING )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1956:1: ( RULE_STRING )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1957:1: RULE_STRING
            {
             before(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_03871); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1966:1: rule__DescriptionElement__RefAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DescriptionElement__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1970:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1971:1: ( ( RULE_ID ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1971:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1972:1: ( RULE_ID )
            {
             before(grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1973:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1974:1: RULE_ID
            {
             before(grammarAccess.getDescriptionElementAccess().getRefEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DescriptionElement__RefAssignment_13906); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1985:1: rule__ReferencePath__RefAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ReferencePath__RefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1989:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1990:1: ( ( RULE_ID ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1990:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1991:1: ( RULE_ID )
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1992:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:1993:1: RULE_ID
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_03945); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2004:1: rule__ReferencePath__SubpathAssignment_1_1 : ( ruleReferencePath ) ;
    public final void rule__ReferencePath__SubpathAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2008:1: ( ( ruleReferencePath ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2009:1: ( ruleReferencePath )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2009:1: ( ruleReferencePath )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategories.g:2010:1: ruleReferencePath
            {
             before(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_13980);
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
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategory370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__0_in_ruleHazardCategory396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategory430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__0_in_ruleVerificationCategory456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription520 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription532 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__Alternatives_in_ruleDescriptionElement595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__0_in_ruleReferencePath655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_rule__Categories__Alternatives876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategories_in_rule__Categories__Alternatives893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_rule__Categories__Alternatives910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__RefAssignment_1_in_rule__DescriptionElement__Alternatives961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__0992 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__0995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__RequirementCategories__Group__0__Impl1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__11054 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__11057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__RequirementCategories__Group__1__Impl1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__21116 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__21119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__RequirementCategories__Group__2__Impl1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__31178 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__31181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl1210 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl1222 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__41255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__RequirementCategories__Group__4__Impl1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__0__Impl_in_rule__HazardCategories__Group__01324 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__1_in_rule__HazardCategories__Group__01327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__HazardCategories__Group__0__Impl1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__1__Impl_in_rule__HazardCategories__Group__11386 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__2_in_rule__HazardCategories__Group__11389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__HazardCategories__Group__1__Impl1417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__2__Impl_in_rule__HazardCategories__Group__21448 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__3_in_rule__HazardCategories__Group__21451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__HazardCategories__Group__2__Impl1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__3__Impl_in_rule__HazardCategories__Group__31510 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__4_in_rule__HazardCategories__Group__31513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategories__CategoryAssignment_3_in_rule__HazardCategories__Group__3__Impl1542 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__HazardCategories__CategoryAssignment_3_in_rule__HazardCategories__Group__3__Impl1554 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__HazardCategories__Group__4__Impl_in_rule__HazardCategories__Group__41587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__HazardCategories__Group__4__Impl1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__0__Impl_in_rule__VerificationCategories__Group__01656 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__1_in_rule__VerificationCategories__Group__01659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VerificationCategories__Group__0__Impl1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__1__Impl_in_rule__VerificationCategories__Group__11718 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__2_in_rule__VerificationCategories__Group__11721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__VerificationCategories__Group__1__Impl1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__2__Impl_in_rule__VerificationCategories__Group__21780 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__3_in_rule__VerificationCategories__Group__21783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VerificationCategories__Group__2__Impl1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__3__Impl_in_rule__VerificationCategories__Group__31842 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__4_in_rule__VerificationCategories__Group__31845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1874 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__CategoryAssignment_3_in_rule__VerificationCategories__Group__3__Impl1886 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__VerificationCategories__Group__4__Impl_in_rule__VerificationCategories__Group__41919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VerificationCategories__Group__4__Impl1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__01988 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__01991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__RequirementCategory__Group__0__Impl2019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__12050 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__2_in_rule__RequirementCategory__Group__12053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__NameAssignment_1_in_rule__RequirementCategory__Group__1__Impl2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__2__Impl_in_rule__RequirementCategory__Group__22110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_2__0_in_rule__RequirementCategory__Group__2__Impl2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_2__0__Impl_in_rule__RequirementCategory__Group_2__02174 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_2__1_in_rule__RequirementCategory__Group_2__02177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__RequirementCategory__Group_2__0__Impl2205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_2__1__Impl_in_rule__RequirementCategory__Group_2__12236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__ExtendsAssignment_2_1_in_rule__RequirementCategory__Group_2__1__Impl2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__0__Impl_in_rule__HazardCategory__Group__02297 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__1_in_rule__HazardCategory__Group__02300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__HazardCategory__Group__0__Impl2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__1__Impl_in_rule__HazardCategory__Group__12359 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__2_in_rule__HazardCategory__Group__12362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__NameAssignment_1_in_rule__HazardCategory__Group__1__Impl2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group__2__Impl_in_rule__HazardCategory__Group__22419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_2__0_in_rule__HazardCategory__Group__2__Impl2446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_2__0__Impl_in_rule__HazardCategory__Group_2__02483 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_2__1_in_rule__HazardCategory__Group_2__02486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__HazardCategory__Group_2__0__Impl2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__Group_2__1__Impl_in_rule__HazardCategory__Group_2__12545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HazardCategory__ExtendsAssignment_2_1_in_rule__HazardCategory__Group_2__1__Impl2572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__0__Impl_in_rule__VerificationCategory__Group__02606 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__1_in_rule__VerificationCategory__Group__02609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__VerificationCategory__Group__0__Impl2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__1__Impl_in_rule__VerificationCategory__Group__12668 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__2_in_rule__VerificationCategory__Group__12671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__NameAssignment_1_in_rule__VerificationCategory__Group__1__Impl2698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group__2__Impl_in_rule__VerificationCategory__Group__22728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_2__0_in_rule__VerificationCategory__Group__2__Impl2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_2__0__Impl_in_rule__VerificationCategory__Group_2__02792 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_2__1_in_rule__VerificationCategory__Group_2__02795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__VerificationCategory__Group_2__0__Impl2823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__Group_2__1__Impl_in_rule__VerificationCategory__Group_2__12854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VerificationCategory__ExtendsAssignment_2_1_in_rule__VerificationCategory__Group_2__1__Impl2881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__02915 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__02918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl2945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__12975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl3002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__03036 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__03039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ReferencePath__Group_1__0__Impl3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__13098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl3125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03160 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3246 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03281 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__QualifiedName__Group_1__0__Impl3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__03403 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__03406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__13462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__QualifiedNameWithWildcard__Group__1__Impl3491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_33536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_rule__HazardCategories__CategoryAssignment_33567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_rule__VerificationCategories__CategoryAssignment_33598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_13629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__RequirementCategory__ExtendsAssignment_2_13664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__HazardCategory__NameAssignment_13699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__HazardCategory__ExtendsAssignment_2_13734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VerificationCategory__NameAssignment_13769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__VerificationCategory__ExtendsAssignment_2_13804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment3840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_03871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DescriptionElement__RefAssignment_13906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_03945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_13980 = new BitSet(new long[]{0x0000000000000002L});

}
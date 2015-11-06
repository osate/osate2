package org.osate.categories.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Requirement", "Categories", "Component", "Selection", "Category", "Filters", "Quality", "Method", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Category=8;
    public static final int Selection=7;
    public static final int RULE_STRING=18;
    public static final int RULE_SL_COMMENT=20;
    public static final int Filters=9;
    public static final int Quality=10;
    public static final int RightCurlyBracket=15;
    public static final int Component=6;
    public static final int EOF=-1;
    public static final int RightSquareBracket=13;
    public static final int RULE_ID=16;
    public static final int Categories=5;
    public static final int RULE_WS=21;
    public static final int LeftCurlyBracket=14;
    public static final int Method=11;
    public static final int RULE_ANY_OTHER=22;
    public static final int Requirement=4;
    public static final int RULE_INT=17;
    public static final int RULE_ML_COMMENT=19;
    public static final int LeftSquareBracket=12;

    // delegates
    // delegators


        public InternalCategoriesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCategoriesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCategoriesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g"; }


     
     	private CategoriesGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("LeftSquareBracket", "'['");
    		tokenNameToValue.put("RightSquareBracket", "']'");
    		tokenNameToValue.put("LeftCurlyBracket", "'{'");
    		tokenNameToValue.put("RightCurlyBracket", "'}'");
    		tokenNameToValue.put("Method", "'method'");
    		tokenNameToValue.put("Filters", "'filters'");
    		tokenNameToValue.put("Quality", "'quality'");
    		tokenNameToValue.put("Category", "'category'");
    		tokenNameToValue.put("Component", "'component'");
    		tokenNameToValue.put("Selection", "'selection'");
    		tokenNameToValue.put("Categories", "'categories'");
    		tokenNameToValue.put("Requirement", "'requirement'");
     	}
     	
        public void setGrammarAccess(CategoriesGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }

    	@Override
        protected String getValueForTokenName(String tokenName) {
        	String result = tokenNameToValue.get(tokenName);
        	if (result == null)
        		result = tokenName;
        	return result;
        }



    // $ANTLR start "entryRuleCategoriesDefinitions"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:75:1: entryRuleCategoriesDefinitions : ruleCategoriesDefinitions EOF ;
    public final void entryRuleCategoriesDefinitions() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:76:1: ( ruleCategoriesDefinitions EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:77:1: ruleCategoriesDefinitions EOF
            {
             before(grammarAccess.getCategoriesDefinitionsRule()); 
            pushFollow(FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions54);
            ruleCategoriesDefinitions();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategoriesDefinitions61); 

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
    // $ANTLR end "entryRuleCategoriesDefinitions"


    // $ANTLR start "ruleCategoriesDefinitions"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:84:1: ruleCategoriesDefinitions : ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) ;
    public final void ruleCategoriesDefinitions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:88:5: ( ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:89:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:89:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:90:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:91:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:91:2: rule__CategoriesDefinitions__UnorderedGroup
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup_in_ruleCategoriesDefinitions91);
            rule__CategoriesDefinitions__UnorderedGroup();

            state._fsp--;


            }

             after(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCategoriesDefinitions"


    // $ANTLR start "entryRuleRequirementCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:103:1: entryRuleRequirementCategories : ruleRequirementCategories EOF ;
    public final void entryRuleRequirementCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:104:1: ( ruleRequirementCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:105:1: ruleRequirementCategories EOF
            {
             before(grammarAccess.getRequirementCategoriesRule()); 
            pushFollow(FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories118);
            ruleRequirementCategories();

            state._fsp--;

             after(grammarAccess.getRequirementCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategories125); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:112:1: ruleRequirementCategories : ( ( rule__RequirementCategories__Group__0 ) ) ;
    public final void ruleRequirementCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:116:5: ( ( ( rule__RequirementCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:117:1: ( ( rule__RequirementCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:117:1: ( ( rule__RequirementCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:118:1: ( rule__RequirementCategories__Group__0 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:119:1: ( rule__RequirementCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:119:2: rule__RequirementCategories__Group__0
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__0_in_ruleRequirementCategories155);
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


    // $ANTLR start "entryRuleMethodCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:131:1: entryRuleMethodCategories : ruleMethodCategories EOF ;
    public final void entryRuleMethodCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:132:1: ( ruleMethodCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:133:1: ruleMethodCategories EOF
            {
             before(grammarAccess.getMethodCategoriesRule()); 
            pushFollow(FOLLOW_ruleMethodCategories_in_entryRuleMethodCategories182);
            ruleMethodCategories();

            state._fsp--;

             after(grammarAccess.getMethodCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodCategories189); 

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
    // $ANTLR end "entryRuleMethodCategories"


    // $ANTLR start "ruleMethodCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:140:1: ruleMethodCategories : ( ( rule__MethodCategories__Group__0 ) ) ;
    public final void ruleMethodCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:144:5: ( ( ( rule__MethodCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:145:1: ( ( rule__MethodCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:145:1: ( ( rule__MethodCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:146:1: ( rule__MethodCategories__Group__0 )
            {
             before(grammarAccess.getMethodCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:147:1: ( rule__MethodCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:147:2: rule__MethodCategories__Group__0
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__0_in_ruleMethodCategories219);
            rule__MethodCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMethodCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMethodCategories"


    // $ANTLR start "entryRuleSelectionCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:159:1: entryRuleSelectionCategories : ruleSelectionCategories EOF ;
    public final void entryRuleSelectionCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:160:1: ( ruleSelectionCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:161:1: ruleSelectionCategories EOF
            {
             before(grammarAccess.getSelectionCategoriesRule()); 
            pushFollow(FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories246);
            ruleSelectionCategories();

            state._fsp--;

             after(grammarAccess.getSelectionCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategories253); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:168:1: ruleSelectionCategories : ( ( rule__SelectionCategories__Group__0 ) ) ;
    public final void ruleSelectionCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:172:5: ( ( ( rule__SelectionCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:173:1: ( ( rule__SelectionCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:173:1: ( ( rule__SelectionCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:174:1: ( rule__SelectionCategories__Group__0 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:175:1: ( rule__SelectionCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:175:2: rule__SelectionCategories__Group__0
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__0_in_ruleSelectionCategories283);
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


    // $ANTLR start "entryRuleQualityCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:187:1: entryRuleQualityCategories : ruleQualityCategories EOF ;
    public final void entryRuleQualityCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:188:1: ( ruleQualityCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:189:1: ruleQualityCategories EOF
            {
             before(grammarAccess.getQualityCategoriesRule()); 
            pushFollow(FOLLOW_ruleQualityCategories_in_entryRuleQualityCategories310);
            ruleQualityCategories();

            state._fsp--;

             after(grammarAccess.getQualityCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityCategories317); 

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
    // $ANTLR end "entryRuleQualityCategories"


    // $ANTLR start "ruleQualityCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:196:1: ruleQualityCategories : ( ( rule__QualityCategories__Group__0 ) ) ;
    public final void ruleQualityCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:200:5: ( ( ( rule__QualityCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:201:1: ( ( rule__QualityCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:201:1: ( ( rule__QualityCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:202:1: ( rule__QualityCategories__Group__0 )
            {
             before(grammarAccess.getQualityCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:203:1: ( rule__QualityCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:203:2: rule__QualityCategories__Group__0
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__0_in_ruleQualityCategories347);
            rule__QualityCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualityCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualityCategories"


    // $ANTLR start "entryRuleComponentCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:215:1: entryRuleComponentCategories : ruleComponentCategories EOF ;
    public final void entryRuleComponentCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:216:1: ( ruleComponentCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:217:1: ruleComponentCategories EOF
            {
             before(grammarAccess.getComponentCategoriesRule()); 
            pushFollow(FOLLOW_ruleComponentCategories_in_entryRuleComponentCategories374);
            ruleComponentCategories();

            state._fsp--;

             after(grammarAccess.getComponentCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategories381); 

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
    // $ANTLR end "entryRuleComponentCategories"


    // $ANTLR start "ruleComponentCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:224:1: ruleComponentCategories : ( ( rule__ComponentCategories__Group__0 ) ) ;
    public final void ruleComponentCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:228:5: ( ( ( rule__ComponentCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:229:1: ( ( rule__ComponentCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:229:1: ( ( rule__ComponentCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:230:1: ( rule__ComponentCategories__Group__0 )
            {
             before(grammarAccess.getComponentCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:231:1: ( rule__ComponentCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:231:2: rule__ComponentCategories__Group__0
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__0_in_ruleComponentCategories411);
            rule__ComponentCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComponentCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComponentCategories"


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:243:1: entryRuleRequirementCategory : ruleRequirementCategory EOF ;
    public final void entryRuleRequirementCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:244:1: ( ruleRequirementCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:245:1: ruleRequirementCategory EOF
            {
             before(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory438);
            ruleRequirementCategory();

            state._fsp--;

             after(grammarAccess.getRequirementCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory445); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:252:1: ruleRequirementCategory : ( ( rule__RequirementCategory__Group__0 ) ) ;
    public final void ruleRequirementCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:256:5: ( ( ( rule__RequirementCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:257:1: ( ( rule__RequirementCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:257:1: ( ( rule__RequirementCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:258:1: ( rule__RequirementCategory__Group__0 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:259:1: ( rule__RequirementCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:259:2: rule__RequirementCategory__Group__0
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory475);
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


    // $ANTLR start "entryRuleMethodCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:271:1: entryRuleMethodCategory : ruleMethodCategory EOF ;
    public final void entryRuleMethodCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:272:1: ( ruleMethodCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:273:1: ruleMethodCategory EOF
            {
             before(grammarAccess.getMethodCategoryRule()); 
            pushFollow(FOLLOW_ruleMethodCategory_in_entryRuleMethodCategory502);
            ruleMethodCategory();

            state._fsp--;

             after(grammarAccess.getMethodCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodCategory509); 

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
    // $ANTLR end "entryRuleMethodCategory"


    // $ANTLR start "ruleMethodCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:280:1: ruleMethodCategory : ( ( rule__MethodCategory__Group__0 ) ) ;
    public final void ruleMethodCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:284:5: ( ( ( rule__MethodCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:285:1: ( ( rule__MethodCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:285:1: ( ( rule__MethodCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:286:1: ( rule__MethodCategory__Group__0 )
            {
             before(grammarAccess.getMethodCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:287:1: ( rule__MethodCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:287:2: rule__MethodCategory__Group__0
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group__0_in_ruleMethodCategory539);
            rule__MethodCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMethodCategoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMethodCategory"


    // $ANTLR start "entryRuleSelectionCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:299:1: entryRuleSelectionCategory : ruleSelectionCategory EOF ;
    public final void entryRuleSelectionCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:300:1: ( ruleSelectionCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:301:1: ruleSelectionCategory EOF
            {
             before(grammarAccess.getSelectionCategoryRule()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory566);
            ruleSelectionCategory();

            state._fsp--;

             after(grammarAccess.getSelectionCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategory573); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:308:1: ruleSelectionCategory : ( ( rule__SelectionCategory__Group__0 ) ) ;
    public final void ruleSelectionCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:312:5: ( ( ( rule__SelectionCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:313:1: ( ( rule__SelectionCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:313:1: ( ( rule__SelectionCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:314:1: ( rule__SelectionCategory__Group__0 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:315:1: ( rule__SelectionCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:315:2: rule__SelectionCategory__Group__0
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__0_in_ruleSelectionCategory603);
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


    // $ANTLR start "entryRuleQualityCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:327:1: entryRuleQualityCategory : ruleQualityCategory EOF ;
    public final void entryRuleQualityCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:328:1: ( ruleQualityCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:329:1: ruleQualityCategory EOF
            {
             before(grammarAccess.getQualityCategoryRule()); 
            pushFollow(FOLLOW_ruleQualityCategory_in_entryRuleQualityCategory630);
            ruleQualityCategory();

            state._fsp--;

             after(grammarAccess.getQualityCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityCategory637); 

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
    // $ANTLR end "entryRuleQualityCategory"


    // $ANTLR start "ruleQualityCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:336:1: ruleQualityCategory : ( ( rule__QualityCategory__Group__0 ) ) ;
    public final void ruleQualityCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:340:5: ( ( ( rule__QualityCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:341:1: ( ( rule__QualityCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:341:1: ( ( rule__QualityCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:342:1: ( rule__QualityCategory__Group__0 )
            {
             before(grammarAccess.getQualityCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:343:1: ( rule__QualityCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:343:2: rule__QualityCategory__Group__0
            {
            pushFollow(FOLLOW_rule__QualityCategory__Group__0_in_ruleQualityCategory667);
            rule__QualityCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualityCategoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualityCategory"


    // $ANTLR start "entryRuleComponentCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:355:1: entryRuleComponentCategory : ruleComponentCategory EOF ;
    public final void entryRuleComponentCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:356:1: ( ruleComponentCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:357:1: ruleComponentCategory EOF
            {
             before(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory694);
            ruleComponentCategory();

            state._fsp--;

             after(grammarAccess.getComponentCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory701); 

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
    // $ANTLR end "entryRuleComponentCategory"


    // $ANTLR start "ruleComponentCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:364:1: ruleComponentCategory : ( ( rule__ComponentCategory__Group__0 ) ) ;
    public final void ruleComponentCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:368:5: ( ( ( rule__ComponentCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:369:1: ( ( rule__ComponentCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:369:1: ( ( rule__ComponentCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:370:1: ( rule__ComponentCategory__Group__0 )
            {
             before(grammarAccess.getComponentCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:371:1: ( rule__ComponentCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:371:2: rule__ComponentCategory__Group__0
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group__0_in_ruleComponentCategory731);
            rule__ComponentCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComponentCategoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComponentCategory"


    // $ANTLR start "entryRuleCategoryFilters"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:383:1: entryRuleCategoryFilters : ruleCategoryFilters EOF ;
    public final void entryRuleCategoryFilters() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:384:1: ( ruleCategoryFilters EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:385:1: ruleCategoryFilters EOF
            {
             before(grammarAccess.getCategoryFiltersRule()); 
            pushFollow(FOLLOW_ruleCategoryFilters_in_entryRuleCategoryFilters758);
            ruleCategoryFilters();

            state._fsp--;

             after(grammarAccess.getCategoryFiltersRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategoryFilters765); 

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
    // $ANTLR end "entryRuleCategoryFilters"


    // $ANTLR start "ruleCategoryFilters"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:392:1: ruleCategoryFilters : ( ( rule__CategoryFilters__Group__0 ) ) ;
    public final void ruleCategoryFilters() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:396:5: ( ( ( rule__CategoryFilters__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:397:1: ( ( rule__CategoryFilters__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:397:1: ( ( rule__CategoryFilters__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:398:1: ( rule__CategoryFilters__Group__0 )
            {
             before(grammarAccess.getCategoryFiltersAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:399:1: ( rule__CategoryFilters__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:399:2: rule__CategoryFilters__Group__0
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__0_in_ruleCategoryFilters795);
            rule__CategoryFilters__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCategoryFiltersAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCategoryFilters"


    // $ANTLR start "entryRuleCategorySet"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:411:1: entryRuleCategorySet : ruleCategorySet EOF ;
    public final void entryRuleCategorySet() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:412:1: ( ruleCategorySet EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:413:1: ruleCategorySet EOF
            {
             before(grammarAccess.getCategorySetRule()); 
            pushFollow(FOLLOW_ruleCategorySet_in_entryRuleCategorySet822);
            ruleCategorySet();

            state._fsp--;

             after(grammarAccess.getCategorySetRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategorySet829); 

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
    // $ANTLR end "entryRuleCategorySet"


    // $ANTLR start "ruleCategorySet"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:420:1: ruleCategorySet : ( ( rule__CategorySet__Group__0 ) ) ;
    public final void ruleCategorySet() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:424:5: ( ( ( rule__CategorySet__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:425:1: ( ( rule__CategorySet__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:425:1: ( ( rule__CategorySet__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:426:1: ( rule__CategorySet__Group__0 )
            {
             before(grammarAccess.getCategorySetAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:427:1: ( rule__CategorySet__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:427:2: rule__CategorySet__Group__0
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__0_in_ruleCategorySet859);
            rule__CategorySet__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCategorySetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCategorySet"


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:439:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:440:1: ( ruleCatRef EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:441:1: ruleCatRef EOF
            {
             before(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef886);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getCatRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef893); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:448:1: ruleCatRef : ( RULE_ID ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:452:5: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:453:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:453:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:454:1: RULE_ID
            {
             before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef923); 
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


    // $ANTLR start "rule__RequirementCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:469:1: rule__RequirementCategories__Group__0 : rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 ;
    public final void rule__RequirementCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:473:1: ( rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:474:2: rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__0956);
            rule__RequirementCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__0959);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:481:1: rule__RequirementCategories__Group__0__Impl : ( () ) ;
    public final void rule__RequirementCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:485:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:486:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:486:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:487:1: ()
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRequirementCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:488:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:490:1: 
            {
            }

             after(grammarAccess.getRequirementCategoriesAccess().getRequirementCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategories__Group__0__Impl"


    // $ANTLR start "rule__RequirementCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:500:1: rule__RequirementCategories__Group__1 : rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 ;
    public final void rule__RequirementCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:504:1: ( rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:505:2: rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__11017);
            rule__RequirementCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__11020);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:512:1: rule__RequirementCategories__Group__1__Impl : ( Requirement ) ;
    public final void rule__RequirementCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:516:1: ( ( Requirement ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:517:1: ( Requirement )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:517:1: ( Requirement )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:518:1: Requirement
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_1()); 
            match(input,Requirement,FOLLOW_Requirement_in_rule__RequirementCategories__Group__1__Impl1048); 
             after(grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_1()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:531:1: rule__RequirementCategories__Group__2 : rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 ;
    public final void rule__RequirementCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:535:1: ( rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:536:2: rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__21079);
            rule__RequirementCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__21082);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:543:1: rule__RequirementCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__RequirementCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:547:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:548:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:548:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:549:1: Categories
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__RequirementCategories__Group__2__Impl1110); 
             after(grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_2()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:562:1: rule__RequirementCategories__Group__3 : rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 ;
    public final void rule__RequirementCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:566:1: ( rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:567:2: rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__31141);
            rule__RequirementCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__31144);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:574:1: rule__RequirementCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__RequirementCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:578:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:579:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:579:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:580:1: LeftSquareBracket
            {
             before(grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__RequirementCategories__Group__3__Impl1172); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:593:1: rule__RequirementCategories__Group__4 : rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5 ;
    public final void rule__RequirementCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:597:1: ( rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:598:2: rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__41203);
            rule__RequirementCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__5_in_rule__RequirementCategories__Group__41206);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:605:1: rule__RequirementCategories__Group__4__Impl : ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__RequirementCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:609:1: ( ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:610:1: ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:610:1: ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:611:1: ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:611:1: ( ( rule__RequirementCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:612:1: ( rule__RequirementCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:613:1: ( rule__RequirementCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:613:2: rule__RequirementCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1235);
            rule__RequirementCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:616:1: ( ( rule__RequirementCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:617:1: ( rule__RequirementCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:618:1: ( rule__RequirementCategories__CategoryAssignment_4 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:618:2: rule__RequirementCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1247);
            	    rule__RequirementCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:629:1: rule__RequirementCategories__Group__5 : rule__RequirementCategories__Group__5__Impl ;
    public final void rule__RequirementCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:633:1: ( rule__RequirementCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:634:2: rule__RequirementCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__5__Impl_in_rule__RequirementCategories__Group__51280);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:640:1: rule__RequirementCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__RequirementCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:644:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:645:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:645:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:646:1: RightSquareBracket
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__RequirementCategories__Group__5__Impl1308); 
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


    // $ANTLR start "rule__MethodCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:671:1: rule__MethodCategories__Group__0 : rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1 ;
    public final void rule__MethodCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:675:1: ( rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:676:2: rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__0__Impl_in_rule__MethodCategories__Group__01351);
            rule__MethodCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__1_in_rule__MethodCategories__Group__01354);
            rule__MethodCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__0"


    // $ANTLR start "rule__MethodCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:683:1: rule__MethodCategories__Group__0__Impl : ( () ) ;
    public final void rule__MethodCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:687:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:688:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:688:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:689:1: ()
            {
             before(grammarAccess.getMethodCategoriesAccess().getMethodCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:690:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:692:1: 
            {
            }

             after(grammarAccess.getMethodCategoriesAccess().getMethodCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__0__Impl"


    // $ANTLR start "rule__MethodCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:702:1: rule__MethodCategories__Group__1 : rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2 ;
    public final void rule__MethodCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:706:1: ( rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:707:2: rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__1__Impl_in_rule__MethodCategories__Group__11412);
            rule__MethodCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__2_in_rule__MethodCategories__Group__11415);
            rule__MethodCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__1"


    // $ANTLR start "rule__MethodCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:714:1: rule__MethodCategories__Group__1__Impl : ( Method ) ;
    public final void rule__MethodCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:718:1: ( ( Method ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:719:1: ( Method )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:719:1: ( Method )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:720:1: Method
            {
             before(grammarAccess.getMethodCategoriesAccess().getMethodKeyword_1()); 
            match(input,Method,FOLLOW_Method_in_rule__MethodCategories__Group__1__Impl1443); 
             after(grammarAccess.getMethodCategoriesAccess().getMethodKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__1__Impl"


    // $ANTLR start "rule__MethodCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:733:1: rule__MethodCategories__Group__2 : rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3 ;
    public final void rule__MethodCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:737:1: ( rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:738:2: rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__2__Impl_in_rule__MethodCategories__Group__21474);
            rule__MethodCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__3_in_rule__MethodCategories__Group__21477);
            rule__MethodCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__2"


    // $ANTLR start "rule__MethodCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:745:1: rule__MethodCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__MethodCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:749:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:750:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:750:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:751:1: Categories
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__MethodCategories__Group__2__Impl1505); 
             after(grammarAccess.getMethodCategoriesAccess().getCategoriesKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__2__Impl"


    // $ANTLR start "rule__MethodCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:764:1: rule__MethodCategories__Group__3 : rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4 ;
    public final void rule__MethodCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:768:1: ( rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:769:2: rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__3__Impl_in_rule__MethodCategories__Group__31536);
            rule__MethodCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__4_in_rule__MethodCategories__Group__31539);
            rule__MethodCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__3"


    // $ANTLR start "rule__MethodCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:776:1: rule__MethodCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__MethodCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:780:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:781:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:781:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:782:1: LeftSquareBracket
            {
             before(grammarAccess.getMethodCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__MethodCategories__Group__3__Impl1567); 
             after(grammarAccess.getMethodCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__3__Impl"


    // $ANTLR start "rule__MethodCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:795:1: rule__MethodCategories__Group__4 : rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5 ;
    public final void rule__MethodCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:799:1: ( rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:800:2: rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__4__Impl_in_rule__MethodCategories__Group__41598);
            rule__MethodCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__5_in_rule__MethodCategories__Group__41601);
            rule__MethodCategories__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__4"


    // $ANTLR start "rule__MethodCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:807:1: rule__MethodCategories__Group__4__Impl : ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__MethodCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:811:1: ( ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:812:1: ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:812:1: ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:813:1: ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:813:1: ( ( rule__MethodCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:814:1: ( rule__MethodCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:815:1: ( rule__MethodCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:815:2: rule__MethodCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__MethodCategories__CategoryAssignment_4_in_rule__MethodCategories__Group__4__Impl1630);
            rule__MethodCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:818:1: ( ( rule__MethodCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:819:1: ( rule__MethodCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:820:1: ( rule__MethodCategories__CategoryAssignment_4 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:820:2: rule__MethodCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__MethodCategories__CategoryAssignment_4_in_rule__MethodCategories__Group__4__Impl1642);
            	    rule__MethodCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__MethodCategories__Group__4__Impl"


    // $ANTLR start "rule__MethodCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:831:1: rule__MethodCategories__Group__5 : rule__MethodCategories__Group__5__Impl ;
    public final void rule__MethodCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:835:1: ( rule__MethodCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:836:2: rule__MethodCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__5__Impl_in_rule__MethodCategories__Group__51675);
            rule__MethodCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__5"


    // $ANTLR start "rule__MethodCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:842:1: rule__MethodCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__MethodCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:846:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:847:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:847:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:848:1: RightSquareBracket
            {
             before(grammarAccess.getMethodCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__MethodCategories__Group__5__Impl1703); 
             after(grammarAccess.getMethodCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__5__Impl"


    // $ANTLR start "rule__SelectionCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:873:1: rule__SelectionCategories__Group__0 : rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 ;
    public final void rule__SelectionCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:877:1: ( rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:878:2: rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__0__Impl_in_rule__SelectionCategories__Group__01746);
            rule__SelectionCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__1_in_rule__SelectionCategories__Group__01749);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:885:1: rule__SelectionCategories__Group__0__Impl : ( () ) ;
    public final void rule__SelectionCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:889:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:890:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:890:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:891:1: ()
            {
             before(grammarAccess.getSelectionCategoriesAccess().getSelectionCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:892:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:894:1: 
            {
            }

             after(grammarAccess.getSelectionCategoriesAccess().getSelectionCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__0__Impl"


    // $ANTLR start "rule__SelectionCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:904:1: rule__SelectionCategories__Group__1 : rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 ;
    public final void rule__SelectionCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:908:1: ( rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:909:2: rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__1__Impl_in_rule__SelectionCategories__Group__11807);
            rule__SelectionCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__2_in_rule__SelectionCategories__Group__11810);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:916:1: rule__SelectionCategories__Group__1__Impl : ( Selection ) ;
    public final void rule__SelectionCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:920:1: ( ( Selection ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:921:1: ( Selection )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:921:1: ( Selection )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:922:1: Selection
            {
             before(grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_1()); 
            match(input,Selection,FOLLOW_Selection_in_rule__SelectionCategories__Group__1__Impl1838); 
             after(grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_1()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:935:1: rule__SelectionCategories__Group__2 : rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 ;
    public final void rule__SelectionCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:939:1: ( rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:940:2: rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__2__Impl_in_rule__SelectionCategories__Group__21869);
            rule__SelectionCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__3_in_rule__SelectionCategories__Group__21872);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:947:1: rule__SelectionCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__SelectionCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:951:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:952:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:952:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:953:1: Categories
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__SelectionCategories__Group__2__Impl1900); 
             after(grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_2()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:966:1: rule__SelectionCategories__Group__3 : rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 ;
    public final void rule__SelectionCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:970:1: ( rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:971:2: rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__3__Impl_in_rule__SelectionCategories__Group__31931);
            rule__SelectionCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__4_in_rule__SelectionCategories__Group__31934);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:978:1: rule__SelectionCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__SelectionCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:982:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:983:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:983:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:984:1: LeftSquareBracket
            {
             before(grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__SelectionCategories__Group__3__Impl1962); 
             after(grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:997:1: rule__SelectionCategories__Group__4 : rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5 ;
    public final void rule__SelectionCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1001:1: ( rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1002:2: rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__4__Impl_in_rule__SelectionCategories__Group__41993);
            rule__SelectionCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__5_in_rule__SelectionCategories__Group__41996);
            rule__SelectionCategories__Group__5();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1009:1: rule__SelectionCategories__Group__4__Impl : ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__SelectionCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1013:1: ( ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1014:1: ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1014:1: ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1015:1: ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1015:1: ( ( rule__SelectionCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1016:1: ( rule__SelectionCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1017:1: ( rule__SelectionCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1017:2: rule__SelectionCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_4_in_rule__SelectionCategories__Group__4__Impl2025);
            rule__SelectionCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1020:1: ( ( rule__SelectionCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1021:1: ( rule__SelectionCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1022:1: ( rule__SelectionCategories__CategoryAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1022:2: rule__SelectionCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_4_in_rule__SelectionCategories__Group__4__Impl2037);
            	    rule__SelectionCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__SelectionCategories__Group__4__Impl"


    // $ANTLR start "rule__SelectionCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1033:1: rule__SelectionCategories__Group__5 : rule__SelectionCategories__Group__5__Impl ;
    public final void rule__SelectionCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1037:1: ( rule__SelectionCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1038:2: rule__SelectionCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__5__Impl_in_rule__SelectionCategories__Group__52070);
            rule__SelectionCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__5"


    // $ANTLR start "rule__SelectionCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1044:1: rule__SelectionCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__SelectionCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1048:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1049:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1049:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1050:1: RightSquareBracket
            {
             before(grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__SelectionCategories__Group__5__Impl2098); 
             after(grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__Group__5__Impl"


    // $ANTLR start "rule__QualityCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1075:1: rule__QualityCategories__Group__0 : rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1 ;
    public final void rule__QualityCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1079:1: ( rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1080:2: rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__0__Impl_in_rule__QualityCategories__Group__02141);
            rule__QualityCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__1_in_rule__QualityCategories__Group__02144);
            rule__QualityCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__Group__0"


    // $ANTLR start "rule__QualityCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1087:1: rule__QualityCategories__Group__0__Impl : ( () ) ;
    public final void rule__QualityCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1091:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1092:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1092:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1093:1: ()
            {
             before(grammarAccess.getQualityCategoriesAccess().getQualityCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1094:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1096:1: 
            {
            }

             after(grammarAccess.getQualityCategoriesAccess().getQualityCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__Group__0__Impl"


    // $ANTLR start "rule__QualityCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1106:1: rule__QualityCategories__Group__1 : rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2 ;
    public final void rule__QualityCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1110:1: ( rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1111:2: rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__1__Impl_in_rule__QualityCategories__Group__12202);
            rule__QualityCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__2_in_rule__QualityCategories__Group__12205);
            rule__QualityCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__Group__1"


    // $ANTLR start "rule__QualityCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1118:1: rule__QualityCategories__Group__1__Impl : ( Quality ) ;
    public final void rule__QualityCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1122:1: ( ( Quality ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1123:1: ( Quality )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1123:1: ( Quality )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1124:1: Quality
            {
             before(grammarAccess.getQualityCategoriesAccess().getQualityKeyword_1()); 
            match(input,Quality,FOLLOW_Quality_in_rule__QualityCategories__Group__1__Impl2233); 
             after(grammarAccess.getQualityCategoriesAccess().getQualityKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__Group__1__Impl"


    // $ANTLR start "rule__QualityCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1137:1: rule__QualityCategories__Group__2 : rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3 ;
    public final void rule__QualityCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1141:1: ( rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1142:2: rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__2__Impl_in_rule__QualityCategories__Group__22264);
            rule__QualityCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__3_in_rule__QualityCategories__Group__22267);
            rule__QualityCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__Group__2"


    // $ANTLR start "rule__QualityCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1149:1: rule__QualityCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__QualityCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1153:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1154:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1154:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1155:1: Categories
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__QualityCategories__Group__2__Impl2295); 
             after(grammarAccess.getQualityCategoriesAccess().getCategoriesKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__Group__2__Impl"


    // $ANTLR start "rule__QualityCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1168:1: rule__QualityCategories__Group__3 : rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4 ;
    public final void rule__QualityCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1172:1: ( rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1173:2: rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__3__Impl_in_rule__QualityCategories__Group__32326);
            rule__QualityCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__4_in_rule__QualityCategories__Group__32329);
            rule__QualityCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__Group__3"


    // $ANTLR start "rule__QualityCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1180:1: rule__QualityCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__QualityCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1184:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1185:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1185:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1186:1: LeftSquareBracket
            {
             before(grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__QualityCategories__Group__3__Impl2357); 
             after(grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__Group__3__Impl"


    // $ANTLR start "rule__QualityCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1199:1: rule__QualityCategories__Group__4 : rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5 ;
    public final void rule__QualityCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1203:1: ( rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1204:2: rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__4__Impl_in_rule__QualityCategories__Group__42388);
            rule__QualityCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__5_in_rule__QualityCategories__Group__42391);
            rule__QualityCategories__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__Group__4"


    // $ANTLR start "rule__QualityCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1211:1: rule__QualityCategories__Group__4__Impl : ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__QualityCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1215:1: ( ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1216:1: ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1216:1: ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1217:1: ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1217:1: ( ( rule__QualityCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1218:1: ( rule__QualityCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1219:1: ( rule__QualityCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1219:2: rule__QualityCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__QualityCategories__CategoryAssignment_4_in_rule__QualityCategories__Group__4__Impl2420);
            rule__QualityCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1222:1: ( ( rule__QualityCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1223:1: ( rule__QualityCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1224:1: ( rule__QualityCategories__CategoryAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1224:2: rule__QualityCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__QualityCategories__CategoryAssignment_4_in_rule__QualityCategories__Group__4__Impl2432);
            	    rule__QualityCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__QualityCategories__Group__4__Impl"


    // $ANTLR start "rule__QualityCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1235:1: rule__QualityCategories__Group__5 : rule__QualityCategories__Group__5__Impl ;
    public final void rule__QualityCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1239:1: ( rule__QualityCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1240:2: rule__QualityCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__5__Impl_in_rule__QualityCategories__Group__52465);
            rule__QualityCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__Group__5"


    // $ANTLR start "rule__QualityCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1246:1: rule__QualityCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__QualityCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1250:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1251:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1251:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1252:1: RightSquareBracket
            {
             before(grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__QualityCategories__Group__5__Impl2493); 
             after(grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__Group__5__Impl"


    // $ANTLR start "rule__ComponentCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1277:1: rule__ComponentCategories__Group__0 : rule__ComponentCategories__Group__0__Impl rule__ComponentCategories__Group__1 ;
    public final void rule__ComponentCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1281:1: ( rule__ComponentCategories__Group__0__Impl rule__ComponentCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1282:2: rule__ComponentCategories__Group__0__Impl rule__ComponentCategories__Group__1
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__0__Impl_in_rule__ComponentCategories__Group__02536);
            rule__ComponentCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategories__Group__1_in_rule__ComponentCategories__Group__02539);
            rule__ComponentCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__Group__0"


    // $ANTLR start "rule__ComponentCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1289:1: rule__ComponentCategories__Group__0__Impl : ( () ) ;
    public final void rule__ComponentCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1293:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1294:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1294:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1295:1: ()
            {
             before(grammarAccess.getComponentCategoriesAccess().getComponentCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1296:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1298:1: 
            {
            }

             after(grammarAccess.getComponentCategoriesAccess().getComponentCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__Group__0__Impl"


    // $ANTLR start "rule__ComponentCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1308:1: rule__ComponentCategories__Group__1 : rule__ComponentCategories__Group__1__Impl rule__ComponentCategories__Group__2 ;
    public final void rule__ComponentCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1312:1: ( rule__ComponentCategories__Group__1__Impl rule__ComponentCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1313:2: rule__ComponentCategories__Group__1__Impl rule__ComponentCategories__Group__2
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__1__Impl_in_rule__ComponentCategories__Group__12597);
            rule__ComponentCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategories__Group__2_in_rule__ComponentCategories__Group__12600);
            rule__ComponentCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__Group__1"


    // $ANTLR start "rule__ComponentCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1320:1: rule__ComponentCategories__Group__1__Impl : ( Component ) ;
    public final void rule__ComponentCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1324:1: ( ( Component ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1325:1: ( Component )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1325:1: ( Component )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1326:1: Component
            {
             before(grammarAccess.getComponentCategoriesAccess().getComponentKeyword_1()); 
            match(input,Component,FOLLOW_Component_in_rule__ComponentCategories__Group__1__Impl2628); 
             after(grammarAccess.getComponentCategoriesAccess().getComponentKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__Group__1__Impl"


    // $ANTLR start "rule__ComponentCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1339:1: rule__ComponentCategories__Group__2 : rule__ComponentCategories__Group__2__Impl rule__ComponentCategories__Group__3 ;
    public final void rule__ComponentCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1343:1: ( rule__ComponentCategories__Group__2__Impl rule__ComponentCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1344:2: rule__ComponentCategories__Group__2__Impl rule__ComponentCategories__Group__3
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__2__Impl_in_rule__ComponentCategories__Group__22659);
            rule__ComponentCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategories__Group__3_in_rule__ComponentCategories__Group__22662);
            rule__ComponentCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__Group__2"


    // $ANTLR start "rule__ComponentCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1351:1: rule__ComponentCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__ComponentCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1355:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1356:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1356:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1357:1: Categories
            {
             before(grammarAccess.getComponentCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__ComponentCategories__Group__2__Impl2690); 
             after(grammarAccess.getComponentCategoriesAccess().getCategoriesKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__Group__2__Impl"


    // $ANTLR start "rule__ComponentCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1370:1: rule__ComponentCategories__Group__3 : rule__ComponentCategories__Group__3__Impl rule__ComponentCategories__Group__4 ;
    public final void rule__ComponentCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1374:1: ( rule__ComponentCategories__Group__3__Impl rule__ComponentCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1375:2: rule__ComponentCategories__Group__3__Impl rule__ComponentCategories__Group__4
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__3__Impl_in_rule__ComponentCategories__Group__32721);
            rule__ComponentCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategories__Group__4_in_rule__ComponentCategories__Group__32724);
            rule__ComponentCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__Group__3"


    // $ANTLR start "rule__ComponentCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1382:1: rule__ComponentCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__ComponentCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1386:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1387:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1387:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1388:1: LeftSquareBracket
            {
             before(grammarAccess.getComponentCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__ComponentCategories__Group__3__Impl2752); 
             after(grammarAccess.getComponentCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__Group__3__Impl"


    // $ANTLR start "rule__ComponentCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1401:1: rule__ComponentCategories__Group__4 : rule__ComponentCategories__Group__4__Impl rule__ComponentCategories__Group__5 ;
    public final void rule__ComponentCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1405:1: ( rule__ComponentCategories__Group__4__Impl rule__ComponentCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1406:2: rule__ComponentCategories__Group__4__Impl rule__ComponentCategories__Group__5
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__4__Impl_in_rule__ComponentCategories__Group__42783);
            rule__ComponentCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategories__Group__5_in_rule__ComponentCategories__Group__42786);
            rule__ComponentCategories__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__Group__4"


    // $ANTLR start "rule__ComponentCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1413:1: rule__ComponentCategories__Group__4__Impl : ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__ComponentCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1417:1: ( ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1418:1: ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1418:1: ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1419:1: ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1419:1: ( ( rule__ComponentCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1420:1: ( rule__ComponentCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getComponentCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1421:1: ( rule__ComponentCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1421:2: rule__ComponentCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__ComponentCategories__CategoryAssignment_4_in_rule__ComponentCategories__Group__4__Impl2815);
            rule__ComponentCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getComponentCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1424:1: ( ( rule__ComponentCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1425:1: ( rule__ComponentCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getComponentCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1426:1: ( rule__ComponentCategories__CategoryAssignment_4 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1426:2: rule__ComponentCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__ComponentCategories__CategoryAssignment_4_in_rule__ComponentCategories__Group__4__Impl2827);
            	    rule__ComponentCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getComponentCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__ComponentCategories__Group__4__Impl"


    // $ANTLR start "rule__ComponentCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1437:1: rule__ComponentCategories__Group__5 : rule__ComponentCategories__Group__5__Impl ;
    public final void rule__ComponentCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1441:1: ( rule__ComponentCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1442:2: rule__ComponentCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__5__Impl_in_rule__ComponentCategories__Group__52860);
            rule__ComponentCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__Group__5"


    // $ANTLR start "rule__ComponentCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1448:1: rule__ComponentCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__ComponentCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1452:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1453:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1453:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1454:1: RightSquareBracket
            {
             before(grammarAccess.getComponentCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__ComponentCategories__Group__5__Impl2888); 
             after(grammarAccess.getComponentCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__Group__5__Impl"


    // $ANTLR start "rule__RequirementCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1479:1: rule__RequirementCategory__Group__0 : rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 ;
    public final void rule__RequirementCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1483:1: ( rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1484:2: rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__02931);
            rule__RequirementCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__02934);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1491:1: rule__RequirementCategory__Group__0__Impl : ( () ) ;
    public final void rule__RequirementCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1495:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1496:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1496:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1497:1: ()
            {
             before(grammarAccess.getRequirementCategoryAccess().getRequirementCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1498:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1500:1: 
            {
            }

             after(grammarAccess.getRequirementCategoryAccess().getRequirementCategoryAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group__0__Impl"


    // $ANTLR start "rule__RequirementCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1510:1: rule__RequirementCategory__Group__1 : rule__RequirementCategory__Group__1__Impl ;
    public final void rule__RequirementCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1514:1: ( rule__RequirementCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1515:2: rule__RequirementCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__12992);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1521:1: rule__RequirementCategory__Group__1__Impl : ( ( rule__RequirementCategory__NameAssignment_1 ) ) ;
    public final void rule__RequirementCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1525:1: ( ( ( rule__RequirementCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1526:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1526:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1527:1: ( rule__RequirementCategory__NameAssignment_1 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1528:1: ( rule__RequirementCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1528:2: rule__RequirementCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__NameAssignment_1_in_rule__RequirementCategory__Group__1__Impl3019);
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


    // $ANTLR start "rule__MethodCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1542:1: rule__MethodCategory__Group__0 : rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1 ;
    public final void rule__MethodCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1546:1: ( rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1547:2: rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group__0__Impl_in_rule__MethodCategory__Group__03053);
            rule__MethodCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategory__Group__1_in_rule__MethodCategory__Group__03056);
            rule__MethodCategory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__Group__0"


    // $ANTLR start "rule__MethodCategory__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1554:1: rule__MethodCategory__Group__0__Impl : ( () ) ;
    public final void rule__MethodCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1558:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1559:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1559:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1560:1: ()
            {
             before(grammarAccess.getMethodCategoryAccess().getMethodCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1561:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1563:1: 
            {
            }

             after(grammarAccess.getMethodCategoryAccess().getMethodCategoryAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__Group__0__Impl"


    // $ANTLR start "rule__MethodCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1573:1: rule__MethodCategory__Group__1 : rule__MethodCategory__Group__1__Impl ;
    public final void rule__MethodCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1577:1: ( rule__MethodCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1578:2: rule__MethodCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group__1__Impl_in_rule__MethodCategory__Group__13114);
            rule__MethodCategory__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__Group__1"


    // $ANTLR start "rule__MethodCategory__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1584:1: rule__MethodCategory__Group__1__Impl : ( ( rule__MethodCategory__NameAssignment_1 ) ) ;
    public final void rule__MethodCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1588:1: ( ( ( rule__MethodCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1589:1: ( ( rule__MethodCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1589:1: ( ( rule__MethodCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1590:1: ( rule__MethodCategory__NameAssignment_1 )
            {
             before(grammarAccess.getMethodCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1591:1: ( rule__MethodCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1591:2: rule__MethodCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__MethodCategory__NameAssignment_1_in_rule__MethodCategory__Group__1__Impl3141);
            rule__MethodCategory__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMethodCategoryAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__Group__1__Impl"


    // $ANTLR start "rule__SelectionCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1605:1: rule__SelectionCategory__Group__0 : rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 ;
    public final void rule__SelectionCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1609:1: ( rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1610:2: rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__0__Impl_in_rule__SelectionCategory__Group__03175);
            rule__SelectionCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategory__Group__1_in_rule__SelectionCategory__Group__03178);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1617:1: rule__SelectionCategory__Group__0__Impl : ( () ) ;
    public final void rule__SelectionCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1621:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1622:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1622:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1623:1: ()
            {
             before(grammarAccess.getSelectionCategoryAccess().getSelectionCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1624:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1626:1: 
            {
            }

             after(grammarAccess.getSelectionCategoryAccess().getSelectionCategoryAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__Group__0__Impl"


    // $ANTLR start "rule__SelectionCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1636:1: rule__SelectionCategory__Group__1 : rule__SelectionCategory__Group__1__Impl ;
    public final void rule__SelectionCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1640:1: ( rule__SelectionCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1641:2: rule__SelectionCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__1__Impl_in_rule__SelectionCategory__Group__13236);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1647:1: rule__SelectionCategory__Group__1__Impl : ( ( rule__SelectionCategory__NameAssignment_1 ) ) ;
    public final void rule__SelectionCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1651:1: ( ( ( rule__SelectionCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1652:1: ( ( rule__SelectionCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1652:1: ( ( rule__SelectionCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1653:1: ( rule__SelectionCategory__NameAssignment_1 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1654:1: ( rule__SelectionCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1654:2: rule__SelectionCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__NameAssignment_1_in_rule__SelectionCategory__Group__1__Impl3263);
            rule__SelectionCategory__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoryAccess().getNameAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__QualityCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1668:1: rule__QualityCategory__Group__0 : rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1 ;
    public final void rule__QualityCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1672:1: ( rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1673:2: rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1
            {
            pushFollow(FOLLOW_rule__QualityCategory__Group__0__Impl_in_rule__QualityCategory__Group__03297);
            rule__QualityCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategory__Group__1_in_rule__QualityCategory__Group__03300);
            rule__QualityCategory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategory__Group__0"


    // $ANTLR start "rule__QualityCategory__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1680:1: rule__QualityCategory__Group__0__Impl : ( () ) ;
    public final void rule__QualityCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1684:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1685:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1685:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1686:1: ()
            {
             before(grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1687:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1689:1: 
            {
            }

             after(grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategory__Group__0__Impl"


    // $ANTLR start "rule__QualityCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1699:1: rule__QualityCategory__Group__1 : rule__QualityCategory__Group__1__Impl ;
    public final void rule__QualityCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1703:1: ( rule__QualityCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1704:2: rule__QualityCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualityCategory__Group__1__Impl_in_rule__QualityCategory__Group__13358);
            rule__QualityCategory__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategory__Group__1"


    // $ANTLR start "rule__QualityCategory__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1710:1: rule__QualityCategory__Group__1__Impl : ( ( rule__QualityCategory__NameAssignment_1 ) ) ;
    public final void rule__QualityCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1714:1: ( ( ( rule__QualityCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1715:1: ( ( rule__QualityCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1715:1: ( ( rule__QualityCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1716:1: ( rule__QualityCategory__NameAssignment_1 )
            {
             before(grammarAccess.getQualityCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1717:1: ( rule__QualityCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1717:2: rule__QualityCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__QualityCategory__NameAssignment_1_in_rule__QualityCategory__Group__1__Impl3385);
            rule__QualityCategory__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getQualityCategoryAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategory__Group__1__Impl"


    // $ANTLR start "rule__ComponentCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1731:1: rule__ComponentCategory__Group__0 : rule__ComponentCategory__Group__0__Impl rule__ComponentCategory__Group__1 ;
    public final void rule__ComponentCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1735:1: ( rule__ComponentCategory__Group__0__Impl rule__ComponentCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1736:2: rule__ComponentCategory__Group__0__Impl rule__ComponentCategory__Group__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group__0__Impl_in_rule__ComponentCategory__Group__03419);
            rule__ComponentCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group__1_in_rule__ComponentCategory__Group__03422);
            rule__ComponentCategory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group__0"


    // $ANTLR start "rule__ComponentCategory__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1743:1: rule__ComponentCategory__Group__0__Impl : ( () ) ;
    public final void rule__ComponentCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1747:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1748:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1748:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1749:1: ()
            {
             before(grammarAccess.getComponentCategoryAccess().getComponentCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1750:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1752:1: 
            {
            }

             after(grammarAccess.getComponentCategoryAccess().getComponentCategoryAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group__0__Impl"


    // $ANTLR start "rule__ComponentCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1762:1: rule__ComponentCategory__Group__1 : rule__ComponentCategory__Group__1__Impl ;
    public final void rule__ComponentCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1766:1: ( rule__ComponentCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1767:2: rule__ComponentCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group__1__Impl_in_rule__ComponentCategory__Group__13480);
            rule__ComponentCategory__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group__1"


    // $ANTLR start "rule__ComponentCategory__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1773:1: rule__ComponentCategory__Group__1__Impl : ( ( rule__ComponentCategory__NameAssignment_1 ) ) ;
    public final void rule__ComponentCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1777:1: ( ( ( rule__ComponentCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1778:1: ( ( rule__ComponentCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1778:1: ( ( rule__ComponentCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1779:1: ( rule__ComponentCategory__NameAssignment_1 )
            {
             before(grammarAccess.getComponentCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1780:1: ( rule__ComponentCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1780:2: rule__ComponentCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__NameAssignment_1_in_rule__ComponentCategory__Group__1__Impl3507);
            rule__ComponentCategory__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getComponentCategoryAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__Group__1__Impl"


    // $ANTLR start "rule__CategoryFilters__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1794:1: rule__CategoryFilters__Group__0 : rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1 ;
    public final void rule__CategoryFilters__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1798:1: ( rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1799:2: rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__0__Impl_in_rule__CategoryFilters__Group__03541);
            rule__CategoryFilters__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategoryFilters__Group__1_in_rule__CategoryFilters__Group__03544);
            rule__CategoryFilters__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilters__Group__0"


    // $ANTLR start "rule__CategoryFilters__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1806:1: rule__CategoryFilters__Group__0__Impl : ( Category ) ;
    public final void rule__CategoryFilters__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1810:1: ( ( Category ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1811:1: ( Category )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1811:1: ( Category )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1812:1: Category
            {
             before(grammarAccess.getCategoryFiltersAccess().getCategoryKeyword_0()); 
            match(input,Category,FOLLOW_Category_in_rule__CategoryFilters__Group__0__Impl3572); 
             after(grammarAccess.getCategoryFiltersAccess().getCategoryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilters__Group__0__Impl"


    // $ANTLR start "rule__CategoryFilters__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1825:1: rule__CategoryFilters__Group__1 : rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2 ;
    public final void rule__CategoryFilters__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1829:1: ( rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1830:2: rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__1__Impl_in_rule__CategoryFilters__Group__13603);
            rule__CategoryFilters__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategoryFilters__Group__2_in_rule__CategoryFilters__Group__13606);
            rule__CategoryFilters__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilters__Group__1"


    // $ANTLR start "rule__CategoryFilters__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1837:1: rule__CategoryFilters__Group__1__Impl : ( Filters ) ;
    public final void rule__CategoryFilters__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1841:1: ( ( Filters ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1842:1: ( Filters )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1842:1: ( Filters )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1843:1: Filters
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersKeyword_1()); 
            match(input,Filters,FOLLOW_Filters_in_rule__CategoryFilters__Group__1__Impl3634); 
             after(grammarAccess.getCategoryFiltersAccess().getFiltersKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilters__Group__1__Impl"


    // $ANTLR start "rule__CategoryFilters__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1856:1: rule__CategoryFilters__Group__2 : rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3 ;
    public final void rule__CategoryFilters__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1860:1: ( rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1861:2: rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__2__Impl_in_rule__CategoryFilters__Group__23665);
            rule__CategoryFilters__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategoryFilters__Group__3_in_rule__CategoryFilters__Group__23668);
            rule__CategoryFilters__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilters__Group__2"


    // $ANTLR start "rule__CategoryFilters__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1868:1: rule__CategoryFilters__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__CategoryFilters__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1872:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1873:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1873:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1874:1: LeftSquareBracket
            {
             before(grammarAccess.getCategoryFiltersAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__CategoryFilters__Group__2__Impl3696); 
             after(grammarAccess.getCategoryFiltersAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilters__Group__2__Impl"


    // $ANTLR start "rule__CategoryFilters__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1887:1: rule__CategoryFilters__Group__3 : rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4 ;
    public final void rule__CategoryFilters__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1891:1: ( rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1892:2: rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__3__Impl_in_rule__CategoryFilters__Group__33727);
            rule__CategoryFilters__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategoryFilters__Group__4_in_rule__CategoryFilters__Group__33730);
            rule__CategoryFilters__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilters__Group__3"


    // $ANTLR start "rule__CategoryFilters__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1899:1: rule__CategoryFilters__Group__3__Impl : ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) ) ;
    public final void rule__CategoryFilters__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1903:1: ( ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1904:1: ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1904:1: ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1905:1: ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1905:1: ( ( rule__CategoryFilters__FiltersAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1906:1: ( rule__CategoryFilters__FiltersAssignment_3 )
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1907:1: ( rule__CategoryFilters__FiltersAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1907:2: rule__CategoryFilters__FiltersAssignment_3
            {
            pushFollow(FOLLOW_rule__CategoryFilters__FiltersAssignment_3_in_rule__CategoryFilters__Group__3__Impl3759);
            rule__CategoryFilters__FiltersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1910:1: ( ( rule__CategoryFilters__FiltersAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1911:1: ( rule__CategoryFilters__FiltersAssignment_3 )*
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1912:1: ( rule__CategoryFilters__FiltersAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1912:2: rule__CategoryFilters__FiltersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__CategoryFilters__FiltersAssignment_3_in_rule__CategoryFilters__Group__3__Impl3771);
            	    rule__CategoryFilters__FiltersAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 

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
    // $ANTLR end "rule__CategoryFilters__Group__3__Impl"


    // $ANTLR start "rule__CategoryFilters__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1923:1: rule__CategoryFilters__Group__4 : rule__CategoryFilters__Group__4__Impl ;
    public final void rule__CategoryFilters__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1927:1: ( rule__CategoryFilters__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1928:2: rule__CategoryFilters__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__4__Impl_in_rule__CategoryFilters__Group__43804);
            rule__CategoryFilters__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilters__Group__4"


    // $ANTLR start "rule__CategoryFilters__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1934:1: rule__CategoryFilters__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__CategoryFilters__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1938:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1939:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1939:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1940:1: RightSquareBracket
            {
             before(grammarAccess.getCategoryFiltersAccess().getRightSquareBracketKeyword_4()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__CategoryFilters__Group__4__Impl3832); 
             after(grammarAccess.getCategoryFiltersAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilters__Group__4__Impl"


    // $ANTLR start "rule__CategorySet__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1963:1: rule__CategorySet__Group__0 : rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1 ;
    public final void rule__CategorySet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1967:1: ( rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1968:2: rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__0__Impl_in_rule__CategorySet__Group__03873);
            rule__CategorySet__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategorySet__Group__1_in_rule__CategorySet__Group__03876);
            rule__CategorySet__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__Group__0"


    // $ANTLR start "rule__CategorySet__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1975:1: rule__CategorySet__Group__0__Impl : ( () ) ;
    public final void rule__CategorySet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1979:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1980:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1980:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1981:1: ()
            {
             before(grammarAccess.getCategorySetAccess().getCategorySetAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1982:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1984:1: 
            {
            }

             after(grammarAccess.getCategorySetAccess().getCategorySetAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__Group__0__Impl"


    // $ANTLR start "rule__CategorySet__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1994:1: rule__CategorySet__Group__1 : rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2 ;
    public final void rule__CategorySet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1998:1: ( rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1999:2: rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__1__Impl_in_rule__CategorySet__Group__13934);
            rule__CategorySet__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategorySet__Group__2_in_rule__CategorySet__Group__13937);
            rule__CategorySet__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__Group__1"


    // $ANTLR start "rule__CategorySet__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2006:1: rule__CategorySet__Group__1__Impl : ( ( rule__CategorySet__NameAssignment_1 ) ) ;
    public final void rule__CategorySet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2010:1: ( ( ( rule__CategorySet__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2011:1: ( ( rule__CategorySet__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2011:1: ( ( rule__CategorySet__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2012:1: ( rule__CategorySet__NameAssignment_1 )
            {
             before(grammarAccess.getCategorySetAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2013:1: ( rule__CategorySet__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2013:2: rule__CategorySet__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__CategorySet__NameAssignment_1_in_rule__CategorySet__Group__1__Impl3964);
            rule__CategorySet__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCategorySetAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__Group__1__Impl"


    // $ANTLR start "rule__CategorySet__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2023:1: rule__CategorySet__Group__2 : rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3 ;
    public final void rule__CategorySet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2027:1: ( rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2028:2: rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__2__Impl_in_rule__CategorySet__Group__23994);
            rule__CategorySet__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategorySet__Group__3_in_rule__CategorySet__Group__23997);
            rule__CategorySet__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__Group__2"


    // $ANTLR start "rule__CategorySet__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2035:1: rule__CategorySet__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__CategorySet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2039:1: ( ( LeftCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2040:1: ( LeftCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2040:1: ( LeftCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2041:1: LeftCurlyBracket
            {
             before(grammarAccess.getCategorySetAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,LeftCurlyBracket,FOLLOW_LeftCurlyBracket_in_rule__CategorySet__Group__2__Impl4025); 
             after(grammarAccess.getCategorySetAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__Group__2__Impl"


    // $ANTLR start "rule__CategorySet__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2054:1: rule__CategorySet__Group__3 : rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4 ;
    public final void rule__CategorySet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2058:1: ( rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2059:2: rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__3__Impl_in_rule__CategorySet__Group__34056);
            rule__CategorySet__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategorySet__Group__4_in_rule__CategorySet__Group__34059);
            rule__CategorySet__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__Group__3"


    // $ANTLR start "rule__CategorySet__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2066:1: rule__CategorySet__Group__3__Impl : ( ( rule__CategorySet__ElementsAssignment_3 )* ) ;
    public final void rule__CategorySet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2070:1: ( ( ( rule__CategorySet__ElementsAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2071:1: ( ( rule__CategorySet__ElementsAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2071:1: ( ( rule__CategorySet__ElementsAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2072:1: ( rule__CategorySet__ElementsAssignment_3 )*
            {
             before(grammarAccess.getCategorySetAccess().getElementsAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2073:1: ( rule__CategorySet__ElementsAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2073:2: rule__CategorySet__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__CategorySet__ElementsAssignment_3_in_rule__CategorySet__Group__3__Impl4086);
            	    rule__CategorySet__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getCategorySetAccess().getElementsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__Group__3__Impl"


    // $ANTLR start "rule__CategorySet__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2083:1: rule__CategorySet__Group__4 : rule__CategorySet__Group__4__Impl ;
    public final void rule__CategorySet__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2087:1: ( rule__CategorySet__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2088:2: rule__CategorySet__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__4__Impl_in_rule__CategorySet__Group__44117);
            rule__CategorySet__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__Group__4"


    // $ANTLR start "rule__CategorySet__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2094:1: rule__CategorySet__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__CategorySet__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2098:1: ( ( RightCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2099:1: ( RightCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2099:1: ( RightCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2100:1: RightCurlyBracket
            {
             before(grammarAccess.getCategorySetAccess().getRightCurlyBracketKeyword_4()); 
            match(input,RightCurlyBracket,FOLLOW_RightCurlyBracket_in_rule__CategorySet__Group__4__Impl4145); 
             after(grammarAccess.getCategorySetAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__Group__4__Impl"


    // $ANTLR start "rule__CategoriesDefinitions__UnorderedGroup"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2124:1: rule__CategoriesDefinitions__UnorderedGroup : ( rule__CategoriesDefinitions__UnorderedGroup__0 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2129:1: ( ( rule__CategoriesDefinitions__UnorderedGroup__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2130:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2130:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2130:2: rule__CategoriesDefinitions__UnorderedGroup__0
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__0_in_rule__CategoriesDefinitions__UnorderedGroup4187);
                    rule__CategoriesDefinitions__UnorderedGroup__0();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup"


    // $ANTLR start "rule__CategoriesDefinitions__UnorderedGroup__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2140:1: rule__CategoriesDefinitions__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) ) ) ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2145:1: ( ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2146:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2146:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) ) )
            int alt9=6;
            int LA9_0 = input.LA(1);

            if ( LA9_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt9=2;
            }
            else if ( LA9_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt9=3;
            }
            else if ( LA9_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt9=4;
            }
            else if ( LA9_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt9=5;
            }
            else if ( LA9_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt9=6;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2148:4: ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2148:4: ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2149:5: {...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2149:116: ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2150:6: ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2156:6: ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2158:7: ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesAssignment_0()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2159:7: ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2159:8: rule__CategoriesDefinitions__RequirementcategoriesAssignment_0
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__RequirementcategoriesAssignment_0_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4274);
                    rule__CategoriesDefinitions__RequirementcategoriesAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesAssignment_0()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2168:4: ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2168:4: ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2169:5: {...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2169:116: ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2170:6: ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2176:6: ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2178:7: ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getComponentcategoriesAssignment_1()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2179:7: ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2179:8: rule__CategoriesDefinitions__ComponentcategoriesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__ComponentcategoriesAssignment_1_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4372);
                    rule__CategoriesDefinitions__ComponentcategoriesAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getComponentcategoriesAssignment_1()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2188:4: ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2188:4: ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2189:5: {...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2189:116: ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2190:6: ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2196:6: ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2198:7: ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesAssignment_2()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2199:7: ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2199:8: rule__CategoriesDefinitions__MethodcategoriesAssignment_2
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__MethodcategoriesAssignment_2_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4470);
                    rule__CategoriesDefinitions__MethodcategoriesAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesAssignment_2()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2208:4: ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2208:4: ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2209:5: {...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2209:116: ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2210:6: ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2216:6: ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2218:7: ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesAssignment_3()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2219:7: ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2219:8: rule__CategoriesDefinitions__SelectioncategoriesAssignment_3
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__SelectioncategoriesAssignment_3_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4568);
                    rule__CategoriesDefinitions__SelectioncategoriesAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesAssignment_3()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2228:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2228:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2229:5: {...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2229:116: ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2230:6: ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2236:6: ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2238:7: ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesAssignment_4()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2239:7: ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2239:8: rule__CategoriesDefinitions__QualitycategoriesAssignment_4
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__QualitycategoriesAssignment_4_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4666);
                    rule__CategoriesDefinitions__QualitycategoriesAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesAssignment_4()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2248:4: ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2248:4: ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2249:5: {...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2249:116: ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2250:6: ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2256:6: ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2258:7: ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterAssignment_5()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2259:7: ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2259:8: rule__CategoriesDefinitions__CategoryfilterAssignment_5
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__CategoryfilterAssignment_5_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4764);
                    rule__CategoriesDefinitions__CategoryfilterAssignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterAssignment_5()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup__Impl"


    // $ANTLR start "rule__CategoriesDefinitions__UnorderedGroup__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2277:1: rule__CategoriesDefinitions__UnorderedGroup__0 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2281:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2282:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__04830);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2283:2: ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( LA10_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2283:2: rule__CategoriesDefinitions__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__1_in_rule__CategoriesDefinitions__UnorderedGroup__04833);
                    rule__CategoriesDefinitions__UnorderedGroup__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup__0"


    // $ANTLR start "rule__CategoriesDefinitions__UnorderedGroup__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2290:1: rule__CategoriesDefinitions__UnorderedGroup__1 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2294:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2295:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__14858);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2296:2: ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( LA11_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2296:2: rule__CategoriesDefinitions__UnorderedGroup__2
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__2_in_rule__CategoriesDefinitions__UnorderedGroup__14861);
                    rule__CategoriesDefinitions__UnorderedGroup__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup__1"


    // $ANTLR start "rule__CategoriesDefinitions__UnorderedGroup__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2303:1: rule__CategoriesDefinitions__UnorderedGroup__2 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2307:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2308:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__24886);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2309:2: ( rule__CategoriesDefinitions__UnorderedGroup__3 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( LA12_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2309:2: rule__CategoriesDefinitions__UnorderedGroup__3
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__3_in_rule__CategoriesDefinitions__UnorderedGroup__24889);
                    rule__CategoriesDefinitions__UnorderedGroup__3();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup__2"


    // $ANTLR start "rule__CategoriesDefinitions__UnorderedGroup__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2316:1: rule__CategoriesDefinitions__UnorderedGroup__3 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2320:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2321:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__34914);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2322:2: ( rule__CategoriesDefinitions__UnorderedGroup__4 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( LA13_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt13=1;
            }
            else if ( LA13_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt13=1;
            }
            else if ( LA13_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt13=1;
            }
            else if ( LA13_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt13=1;
            }
            else if ( LA13_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt13=1;
            }
            else if ( LA13_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2322:2: rule__CategoriesDefinitions__UnorderedGroup__4
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__4_in_rule__CategoriesDefinitions__UnorderedGroup__34917);
                    rule__CategoriesDefinitions__UnorderedGroup__4();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup__3"


    // $ANTLR start "rule__CategoriesDefinitions__UnorderedGroup__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2329:1: rule__CategoriesDefinitions__UnorderedGroup__4 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2333:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2334:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__44942);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2335:2: ( rule__CategoriesDefinitions__UnorderedGroup__5 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( LA14_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt14=1;
            }
            else if ( LA14_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt14=1;
            }
            else if ( LA14_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt14=1;
            }
            else if ( LA14_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt14=1;
            }
            else if ( LA14_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt14=1;
            }
            else if ( LA14_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2335:2: rule__CategoriesDefinitions__UnorderedGroup__5
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__5_in_rule__CategoriesDefinitions__UnorderedGroup__44945);
                    rule__CategoriesDefinitions__UnorderedGroup__5();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup__4"


    // $ANTLR start "rule__CategoriesDefinitions__UnorderedGroup__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2342:1: rule__CategoriesDefinitions__UnorderedGroup__5 : rule__CategoriesDefinitions__UnorderedGroup__Impl ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2346:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2347:2: rule__CategoriesDefinitions__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__54970);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup__5"


    // $ANTLR start "rule__CategoriesDefinitions__RequirementcategoriesAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2366:1: rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 : ( ruleRequirementCategories ) ;
    public final void rule__CategoriesDefinitions__RequirementcategoriesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2370:1: ( ( ruleRequirementCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2371:1: ( ruleRequirementCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2371:1: ( ruleRequirementCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2372:1: ruleRequirementCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesRequirementCategoriesParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRequirementCategories_in_rule__CategoriesDefinitions__RequirementcategoriesAssignment_05010);
            ruleRequirementCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesRequirementCategoriesParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__RequirementcategoriesAssignment_0"


    // $ANTLR start "rule__CategoriesDefinitions__ComponentcategoriesAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2381:1: rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 : ( ruleComponentCategories ) ;
    public final void rule__CategoriesDefinitions__ComponentcategoriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2385:1: ( ( ruleComponentCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2386:1: ( ruleComponentCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2386:1: ( ruleComponentCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2387:1: ruleComponentCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getComponentcategoriesComponentCategoriesParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleComponentCategories_in_rule__CategoriesDefinitions__ComponentcategoriesAssignment_15041);
            ruleComponentCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getComponentcategoriesComponentCategoriesParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__ComponentcategoriesAssignment_1"


    // $ANTLR start "rule__CategoriesDefinitions__MethodcategoriesAssignment_2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2396:1: rule__CategoriesDefinitions__MethodcategoriesAssignment_2 : ( ruleMethodCategories ) ;
    public final void rule__CategoriesDefinitions__MethodcategoriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2400:1: ( ( ruleMethodCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2401:1: ( ruleMethodCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2401:1: ( ruleMethodCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2402:1: ruleMethodCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesMethodCategoriesParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleMethodCategories_in_rule__CategoriesDefinitions__MethodcategoriesAssignment_25072);
            ruleMethodCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesMethodCategoriesParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__MethodcategoriesAssignment_2"


    // $ANTLR start "rule__CategoriesDefinitions__SelectioncategoriesAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2411:1: rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 : ( ruleSelectionCategories ) ;
    public final void rule__CategoriesDefinitions__SelectioncategoriesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2415:1: ( ( ruleSelectionCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2416:1: ( ruleSelectionCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2416:1: ( ruleSelectionCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2417:1: ruleSelectionCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesSelectionCategoriesParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleSelectionCategories_in_rule__CategoriesDefinitions__SelectioncategoriesAssignment_35103);
            ruleSelectionCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesSelectionCategoriesParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__SelectioncategoriesAssignment_3"


    // $ANTLR start "rule__CategoriesDefinitions__QualitycategoriesAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2426:1: rule__CategoriesDefinitions__QualitycategoriesAssignment_4 : ( ruleQualityCategories ) ;
    public final void rule__CategoriesDefinitions__QualitycategoriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2430:1: ( ( ruleQualityCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2431:1: ( ruleQualityCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2431:1: ( ruleQualityCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2432:1: ruleQualityCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesQualityCategoriesParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleQualityCategories_in_rule__CategoriesDefinitions__QualitycategoriesAssignment_45134);
            ruleQualityCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesQualityCategoriesParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__QualitycategoriesAssignment_4"


    // $ANTLR start "rule__CategoriesDefinitions__CategoryfilterAssignment_5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2441:1: rule__CategoriesDefinitions__CategoryfilterAssignment_5 : ( ruleCategoryFilters ) ;
    public final void rule__CategoriesDefinitions__CategoryfilterAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2445:1: ( ( ruleCategoryFilters ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2446:1: ( ruleCategoryFilters )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2446:1: ( ruleCategoryFilters )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2447:1: ruleCategoryFilters
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterCategoryFiltersParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleCategoryFilters_in_rule__CategoriesDefinitions__CategoryfilterAssignment_55165);
            ruleCategoryFilters();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterCategoryFiltersParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__CategoryfilterAssignment_5"


    // $ANTLR start "rule__RequirementCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2456:1: rule__RequirementCategories__CategoryAssignment_4 : ( ruleRequirementCategory ) ;
    public final void rule__RequirementCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2460:1: ( ( ruleRequirementCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2461:1: ( ruleRequirementCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2461:1: ( ruleRequirementCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2462:1: ruleRequirementCategory
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_45196);
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


    // $ANTLR start "rule__MethodCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2471:1: rule__MethodCategories__CategoryAssignment_4 : ( ruleMethodCategory ) ;
    public final void rule__MethodCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2475:1: ( ( ruleMethodCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2476:1: ( ruleMethodCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2476:1: ( ruleMethodCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2477:1: ruleMethodCategory
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryMethodCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleMethodCategory_in_rule__MethodCategories__CategoryAssignment_45227);
            ruleMethodCategory();

            state._fsp--;

             after(grammarAccess.getMethodCategoriesAccess().getCategoryMethodCategoryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__CategoryAssignment_4"


    // $ANTLR start "rule__SelectionCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2486:1: rule__SelectionCategories__CategoryAssignment_4 : ( ruleSelectionCategory ) ;
    public final void rule__SelectionCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2490:1: ( ( ruleSelectionCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2491:1: ( ruleSelectionCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2491:1: ( ruleSelectionCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2492:1: ruleSelectionCategory
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_rule__SelectionCategories__CategoryAssignment_45258);
            ruleSelectionCategory();

            state._fsp--;

             after(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategories__CategoryAssignment_4"


    // $ANTLR start "rule__QualityCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2501:1: rule__QualityCategories__CategoryAssignment_4 : ( ruleQualityCategory ) ;
    public final void rule__QualityCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2505:1: ( ( ruleQualityCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2506:1: ( ruleQualityCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2506:1: ( ruleQualityCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2507:1: ruleQualityCategory
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleQualityCategory_in_rule__QualityCategories__CategoryAssignment_45289);
            ruleQualityCategory();

            state._fsp--;

             after(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategories__CategoryAssignment_4"


    // $ANTLR start "rule__ComponentCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2516:1: rule__ComponentCategories__CategoryAssignment_4 : ( ruleComponentCategory ) ;
    public final void rule__ComponentCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2520:1: ( ( ruleComponentCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2521:1: ( ruleComponentCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2521:1: ( ruleComponentCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2522:1: ruleComponentCategory
            {
             before(grammarAccess.getComponentCategoriesAccess().getCategoryComponentCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__ComponentCategories__CategoryAssignment_45320);
            ruleComponentCategory();

            state._fsp--;

             after(grammarAccess.getComponentCategoriesAccess().getCategoryComponentCategoryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategories__CategoryAssignment_4"


    // $ANTLR start "rule__RequirementCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2531:1: rule__RequirementCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RequirementCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2535:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2536:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2536:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2537:1: RULE_ID
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_15351); 
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


    // $ANTLR start "rule__MethodCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2546:1: rule__MethodCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__MethodCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2550:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2551:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2551:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2552:1: RULE_ID
            {
             before(grammarAccess.getMethodCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MethodCategory__NameAssignment_15382); 
             after(grammarAccess.getMethodCategoryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__NameAssignment_1"


    // $ANTLR start "rule__SelectionCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2561:1: rule__SelectionCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SelectionCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2565:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2566:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2566:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2567:1: RULE_ID
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectionCategory__NameAssignment_15413); 
             after(grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__NameAssignment_1"


    // $ANTLR start "rule__QualityCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2576:1: rule__QualityCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__QualityCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2580:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2581:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2581:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2582:1: RULE_ID
            {
             before(grammarAccess.getQualityCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualityCategory__NameAssignment_15444); 
             after(grammarAccess.getQualityCategoryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualityCategory__NameAssignment_1"


    // $ANTLR start "rule__ComponentCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2591:1: rule__ComponentCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ComponentCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2595:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2596:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2596:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2597:1: RULE_ID
            {
             before(grammarAccess.getComponentCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentCategory__NameAssignment_15475); 
             after(grammarAccess.getComponentCategoryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComponentCategory__NameAssignment_1"


    // $ANTLR start "rule__CategoryFilters__FiltersAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2606:1: rule__CategoryFilters__FiltersAssignment_3 : ( ruleCategorySet ) ;
    public final void rule__CategoryFilters__FiltersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2610:1: ( ( ruleCategorySet ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2611:1: ( ruleCategorySet )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2611:1: ( ruleCategorySet )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2612:1: ruleCategorySet
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersCategorySetParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCategorySet_in_rule__CategoryFilters__FiltersAssignment_35506);
            ruleCategorySet();

            state._fsp--;

             after(grammarAccess.getCategoryFiltersAccess().getFiltersCategorySetParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilters__FiltersAssignment_3"


    // $ANTLR start "rule__CategorySet__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2621:1: rule__CategorySet__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CategorySet__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2625:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2626:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2626:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2627:1: RULE_ID
            {
             before(grammarAccess.getCategorySetAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CategorySet__NameAssignment_15537); 
             after(grammarAccess.getCategorySetAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__NameAssignment_1"


    // $ANTLR start "rule__CategorySet__ElementsAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2636:1: rule__CategorySet__ElementsAssignment_3 : ( ( ruleCatRef ) ) ;
    public final void rule__CategorySet__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2640:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2641:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2641:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2642:1: ( ruleCatRef )
            {
             before(grammarAccess.getCategorySetAccess().getElementsCategoryCrossReference_3_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2643:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2644:1: ruleCatRef
            {
             before(grammarAccess.getCategorySetAccess().getElementsCategoryCatRefParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__CategorySet__ElementsAssignment_35572);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getCategorySetAccess().getElementsCategoryCatRefParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getCategorySetAccess().getElementsCategoryCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategorySet__ElementsAssignment_3"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoriesDefinitions61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup_in_ruleCategoriesDefinitions91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategories125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__0_in_ruleRequirementCategories155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategories_in_entryRuleMethodCategories182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodCategories189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__0_in_ruleMethodCategories219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategories253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__0_in_ruleSelectionCategories283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategories_in_entryRuleQualityCategories310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityCategories317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__0_in_ruleQualityCategories347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategories_in_entryRuleComponentCategories374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategories381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__0_in_ruleComponentCategories411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategory_in_entryRuleMethodCategory502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodCategory509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__0_in_ruleMethodCategory539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategory573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__0_in_ruleSelectionCategory603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategory_in_entryRuleQualityCategory630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityCategory637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__0_in_ruleQualityCategory667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group__0_in_ruleComponentCategory731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategoryFilters_in_entryRuleCategoryFilters758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoryFilters765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__0_in_ruleCategoryFilters795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategorySet_in_entryRuleCategorySet822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategorySet829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__0_in_ruleCategorySet859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__0956 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__0959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__11017 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__11020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_rule__RequirementCategories__Group__1__Impl1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__21079 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__21082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__RequirementCategories__Group__2__Impl1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__31141 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__31144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__RequirementCategories__Group__3__Impl1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__41203 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__5_in_rule__RequirementCategories__Group__41206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1235 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1247 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__5__Impl_in_rule__RequirementCategories__Group__51280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__RequirementCategories__Group__5__Impl1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__0__Impl_in_rule__MethodCategories__Group__01351 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__1_in_rule__MethodCategories__Group__01354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__1__Impl_in_rule__MethodCategories__Group__11412 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__2_in_rule__MethodCategories__Group__11415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Method_in_rule__MethodCategories__Group__1__Impl1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__2__Impl_in_rule__MethodCategories__Group__21474 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__3_in_rule__MethodCategories__Group__21477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__MethodCategories__Group__2__Impl1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__3__Impl_in_rule__MethodCategories__Group__31536 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__4_in_rule__MethodCategories__Group__31539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__MethodCategories__Group__3__Impl1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__4__Impl_in_rule__MethodCategories__Group__41598 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__5_in_rule__MethodCategories__Group__41601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__CategoryAssignment_4_in_rule__MethodCategories__Group__4__Impl1630 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__MethodCategories__CategoryAssignment_4_in_rule__MethodCategories__Group__4__Impl1642 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__5__Impl_in_rule__MethodCategories__Group__51675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__MethodCategories__Group__5__Impl1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__0__Impl_in_rule__SelectionCategories__Group__01746 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__1_in_rule__SelectionCategories__Group__01749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__1__Impl_in_rule__SelectionCategories__Group__11807 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__2_in_rule__SelectionCategories__Group__11810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Selection_in_rule__SelectionCategories__Group__1__Impl1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__2__Impl_in_rule__SelectionCategories__Group__21869 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__3_in_rule__SelectionCategories__Group__21872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__SelectionCategories__Group__2__Impl1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__3__Impl_in_rule__SelectionCategories__Group__31931 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__4_in_rule__SelectionCategories__Group__31934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__SelectionCategories__Group__3__Impl1962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__4__Impl_in_rule__SelectionCategories__Group__41993 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__5_in_rule__SelectionCategories__Group__41996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__CategoryAssignment_4_in_rule__SelectionCategories__Group__4__Impl2025 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__CategoryAssignment_4_in_rule__SelectionCategories__Group__4__Impl2037 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__5__Impl_in_rule__SelectionCategories__Group__52070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__SelectionCategories__Group__5__Impl2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__0__Impl_in_rule__QualityCategories__Group__02141 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__1_in_rule__QualityCategories__Group__02144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__1__Impl_in_rule__QualityCategories__Group__12202 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__2_in_rule__QualityCategories__Group__12205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Quality_in_rule__QualityCategories__Group__1__Impl2233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__2__Impl_in_rule__QualityCategories__Group__22264 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__3_in_rule__QualityCategories__Group__22267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__QualityCategories__Group__2__Impl2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__3__Impl_in_rule__QualityCategories__Group__32326 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__4_in_rule__QualityCategories__Group__32329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__QualityCategories__Group__3__Impl2357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__4__Impl_in_rule__QualityCategories__Group__42388 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__5_in_rule__QualityCategories__Group__42391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__CategoryAssignment_4_in_rule__QualityCategories__Group__4__Impl2420 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__QualityCategories__CategoryAssignment_4_in_rule__QualityCategories__Group__4__Impl2432 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__5__Impl_in_rule__QualityCategories__Group__52465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__QualityCategories__Group__5__Impl2493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__0__Impl_in_rule__ComponentCategories__Group__02536 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__1_in_rule__ComponentCategories__Group__02539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__1__Impl_in_rule__ComponentCategories__Group__12597 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__2_in_rule__ComponentCategories__Group__12600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Component_in_rule__ComponentCategories__Group__1__Impl2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__2__Impl_in_rule__ComponentCategories__Group__22659 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__3_in_rule__ComponentCategories__Group__22662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__ComponentCategories__Group__2__Impl2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__3__Impl_in_rule__ComponentCategories__Group__32721 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__4_in_rule__ComponentCategories__Group__32724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__ComponentCategories__Group__3__Impl2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__4__Impl_in_rule__ComponentCategories__Group__42783 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__5_in_rule__ComponentCategories__Group__42786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__CategoryAssignment_4_in_rule__ComponentCategories__Group__4__Impl2815 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__CategoryAssignment_4_in_rule__ComponentCategories__Group__4__Impl2827 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__5__Impl_in_rule__ComponentCategories__Group__52860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__ComponentCategories__Group__5__Impl2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__02931 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__02934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__12992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__NameAssignment_1_in_rule__RequirementCategory__Group__1__Impl3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__0__Impl_in_rule__MethodCategory__Group__03053 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__1_in_rule__MethodCategory__Group__03056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__1__Impl_in_rule__MethodCategory__Group__13114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__NameAssignment_1_in_rule__MethodCategory__Group__1__Impl3141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__0__Impl_in_rule__SelectionCategory__Group__03175 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__1_in_rule__SelectionCategory__Group__03178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__1__Impl_in_rule__SelectionCategory__Group__13236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__NameAssignment_1_in_rule__SelectionCategory__Group__1__Impl3263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__0__Impl_in_rule__QualityCategory__Group__03297 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__1_in_rule__QualityCategory__Group__03300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__1__Impl_in_rule__QualityCategory__Group__13358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__NameAssignment_1_in_rule__QualityCategory__Group__1__Impl3385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group__0__Impl_in_rule__ComponentCategory__Group__03419 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group__1_in_rule__ComponentCategory__Group__03422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group__1__Impl_in_rule__ComponentCategory__Group__13480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__NameAssignment_1_in_rule__ComponentCategory__Group__1__Impl3507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__0__Impl_in_rule__CategoryFilters__Group__03541 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__1_in_rule__CategoryFilters__Group__03544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Category_in_rule__CategoryFilters__Group__0__Impl3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__1__Impl_in_rule__CategoryFilters__Group__13603 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__2_in_rule__CategoryFilters__Group__13606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Filters_in_rule__CategoryFilters__Group__1__Impl3634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__2__Impl_in_rule__CategoryFilters__Group__23665 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__3_in_rule__CategoryFilters__Group__23668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__CategoryFilters__Group__2__Impl3696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__3__Impl_in_rule__CategoryFilters__Group__33727 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__4_in_rule__CategoryFilters__Group__33730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__FiltersAssignment_3_in_rule__CategoryFilters__Group__3__Impl3759 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__FiltersAssignment_3_in_rule__CategoryFilters__Group__3__Impl3771 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__4__Impl_in_rule__CategoryFilters__Group__43804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__CategoryFilters__Group__4__Impl3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__0__Impl_in_rule__CategorySet__Group__03873 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__1_in_rule__CategorySet__Group__03876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__1__Impl_in_rule__CategorySet__Group__13934 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__2_in_rule__CategorySet__Group__13937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__NameAssignment_1_in_rule__CategorySet__Group__1__Impl3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__2__Impl_in_rule__CategorySet__Group__23994 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__3_in_rule__CategorySet__Group__23997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftCurlyBracket_in_rule__CategorySet__Group__2__Impl4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__3__Impl_in_rule__CategorySet__Group__34056 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__4_in_rule__CategorySet__Group__34059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__ElementsAssignment_3_in_rule__CategorySet__Group__3__Impl4086 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__4__Impl_in_rule__CategorySet__Group__44117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightCurlyBracket_in_rule__CategorySet__Group__4__Impl4145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__0_in_rule__CategoriesDefinitions__UnorderedGroup4187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__RequirementcategoriesAssignment_0_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__ComponentcategoriesAssignment_1_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__MethodcategoriesAssignment_2_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__SelectioncategoriesAssignment_3_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__QualitycategoriesAssignment_4_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__CategoryfilterAssignment_5_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__04830 = new BitSet(new long[]{0x0000000000000DD2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__1_in_rule__CategoriesDefinitions__UnorderedGroup__04833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__14858 = new BitSet(new long[]{0x0000000000000DD2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__2_in_rule__CategoriesDefinitions__UnorderedGroup__14861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__24886 = new BitSet(new long[]{0x0000000000000DD2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__3_in_rule__CategoriesDefinitions__UnorderedGroup__24889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__34914 = new BitSet(new long[]{0x0000000000000DD2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__4_in_rule__CategoriesDefinitions__UnorderedGroup__34917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__44942 = new BitSet(new long[]{0x0000000000000DD2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__5_in_rule__CategoriesDefinitions__UnorderedGroup__44945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__54970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_rule__CategoriesDefinitions__RequirementcategoriesAssignment_05010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategories_in_rule__CategoriesDefinitions__ComponentcategoriesAssignment_15041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategories_in_rule__CategoriesDefinitions__MethodcategoriesAssignment_25072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_rule__CategoriesDefinitions__SelectioncategoriesAssignment_35103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategories_in_rule__CategoriesDefinitions__QualitycategoriesAssignment_45134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategoryFilters_in_rule__CategoriesDefinitions__CategoryfilterAssignment_55165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_45196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategory_in_rule__MethodCategories__CategoryAssignment_45227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_rule__SelectionCategories__CategoryAssignment_45258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategory_in_rule__QualityCategories__CategoryAssignment_45289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__ComponentCategories__CategoryAssignment_45320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_15351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MethodCategory__NameAssignment_15382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectionCategory__NameAssignment_15413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualityCategory__NameAssignment_15444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentCategory__NameAssignment_15475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategorySet_in_rule__CategoryFilters__FiltersAssignment_35506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CategorySet__NameAssignment_15537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__CategorySet__ElementsAssignment_35572 = new BitSet(new long[]{0x0000000000000002L});

}

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Requirement", "Categories", "Component", "Selection", "Category", "Filters", "Quality", "Method", "Phase", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Category=8;
    public static final int Phase=12;
    public static final int Selection=7;
    public static final int RULE_STRING=19;
    public static final int RULE_SL_COMMENT=21;
    public static final int Filters=9;
    public static final int Quality=10;
    public static final int RightCurlyBracket=16;
    public static final int Component=6;
    public static final int EOF=-1;
    public static final int RightSquareBracket=14;
    public static final int RULE_ID=17;
    public static final int Categories=5;
    public static final int RULE_WS=22;
    public static final int LeftCurlyBracket=15;
    public static final int Method=11;
    public static final int RULE_ANY_OTHER=23;
    public static final int Requirement=4;
    public static final int RULE_INT=18;
    public static final int RULE_ML_COMMENT=20;
    public static final int LeftSquareBracket=13;

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
    		tokenNameToValue.put("Phase", "'phase'");
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:76:1: entryRuleCategoriesDefinitions : ruleCategoriesDefinitions EOF ;
    public final void entryRuleCategoriesDefinitions() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:77:1: ( ruleCategoriesDefinitions EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:78:1: ruleCategoriesDefinitions EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:85:1: ruleCategoriesDefinitions : ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) ;
    public final void ruleCategoriesDefinitions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:89:5: ( ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:90:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:90:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:91:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:92:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:92:2: rule__CategoriesDefinitions__UnorderedGroup
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:104:1: entryRuleRequirementCategories : ruleRequirementCategories EOF ;
    public final void entryRuleRequirementCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:105:1: ( ruleRequirementCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:106:1: ruleRequirementCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:113:1: ruleRequirementCategories : ( ( rule__RequirementCategories__Group__0 ) ) ;
    public final void ruleRequirementCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:117:5: ( ( ( rule__RequirementCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:118:1: ( ( rule__RequirementCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:118:1: ( ( rule__RequirementCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:119:1: ( rule__RequirementCategories__Group__0 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:120:1: ( rule__RequirementCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:120:2: rule__RequirementCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:132:1: entryRuleMethodCategories : ruleMethodCategories EOF ;
    public final void entryRuleMethodCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:133:1: ( ruleMethodCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:134:1: ruleMethodCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:141:1: ruleMethodCategories : ( ( rule__MethodCategories__Group__0 ) ) ;
    public final void ruleMethodCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:145:5: ( ( ( rule__MethodCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:146:1: ( ( rule__MethodCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:146:1: ( ( rule__MethodCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:147:1: ( rule__MethodCategories__Group__0 )
            {
             before(grammarAccess.getMethodCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:148:1: ( rule__MethodCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:148:2: rule__MethodCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:160:1: entryRuleSelectionCategories : ruleSelectionCategories EOF ;
    public final void entryRuleSelectionCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:161:1: ( ruleSelectionCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:162:1: ruleSelectionCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:169:1: ruleSelectionCategories : ( ( rule__SelectionCategories__Group__0 ) ) ;
    public final void ruleSelectionCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:173:5: ( ( ( rule__SelectionCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:174:1: ( ( rule__SelectionCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:174:1: ( ( rule__SelectionCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:175:1: ( rule__SelectionCategories__Group__0 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:176:1: ( rule__SelectionCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:176:2: rule__SelectionCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:188:1: entryRuleQualityCategories : ruleQualityCategories EOF ;
    public final void entryRuleQualityCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:189:1: ( ruleQualityCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:190:1: ruleQualityCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:197:1: ruleQualityCategories : ( ( rule__QualityCategories__Group__0 ) ) ;
    public final void ruleQualityCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:201:5: ( ( ( rule__QualityCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:202:1: ( ( rule__QualityCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:202:1: ( ( rule__QualityCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:203:1: ( rule__QualityCategories__Group__0 )
            {
             before(grammarAccess.getQualityCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:204:1: ( rule__QualityCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:204:2: rule__QualityCategories__Group__0
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


    // $ANTLR start "entryRulePhaseCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:216:1: entryRulePhaseCategories : rulePhaseCategories EOF ;
    public final void entryRulePhaseCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:217:1: ( rulePhaseCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:218:1: rulePhaseCategories EOF
            {
             before(grammarAccess.getPhaseCategoriesRule()); 
            pushFollow(FOLLOW_rulePhaseCategories_in_entryRulePhaseCategories374);
            rulePhaseCategories();

            state._fsp--;

             after(grammarAccess.getPhaseCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhaseCategories381); 

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
    // $ANTLR end "entryRulePhaseCategories"


    // $ANTLR start "rulePhaseCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:225:1: rulePhaseCategories : ( ( rule__PhaseCategories__Group__0 ) ) ;
    public final void rulePhaseCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:229:5: ( ( ( rule__PhaseCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:230:1: ( ( rule__PhaseCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:230:1: ( ( rule__PhaseCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:231:1: ( rule__PhaseCategories__Group__0 )
            {
             before(grammarAccess.getPhaseCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:232:1: ( rule__PhaseCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:232:2: rule__PhaseCategories__Group__0
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__0_in_rulePhaseCategories411);
            rule__PhaseCategories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhaseCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhaseCategories"


    // $ANTLR start "entryRuleComponentCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:244:1: entryRuleComponentCategories : ruleComponentCategories EOF ;
    public final void entryRuleComponentCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:245:1: ( ruleComponentCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:246:1: ruleComponentCategories EOF
            {
             before(grammarAccess.getComponentCategoriesRule()); 
            pushFollow(FOLLOW_ruleComponentCategories_in_entryRuleComponentCategories438);
            ruleComponentCategories();

            state._fsp--;

             after(grammarAccess.getComponentCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategories445); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:253:1: ruleComponentCategories : ( ( rule__ComponentCategories__Group__0 ) ) ;
    public final void ruleComponentCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:257:5: ( ( ( rule__ComponentCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:258:1: ( ( rule__ComponentCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:258:1: ( ( rule__ComponentCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:259:1: ( rule__ComponentCategories__Group__0 )
            {
             before(grammarAccess.getComponentCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:260:1: ( rule__ComponentCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:260:2: rule__ComponentCategories__Group__0
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__0_in_ruleComponentCategories475);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:272:1: entryRuleRequirementCategory : ruleRequirementCategory EOF ;
    public final void entryRuleRequirementCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:273:1: ( ruleRequirementCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:274:1: ruleRequirementCategory EOF
            {
             before(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory502);
            ruleRequirementCategory();

            state._fsp--;

             after(grammarAccess.getRequirementCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory509); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:281:1: ruleRequirementCategory : ( ( rule__RequirementCategory__Group__0 ) ) ;
    public final void ruleRequirementCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:285:5: ( ( ( rule__RequirementCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:286:1: ( ( rule__RequirementCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:286:1: ( ( rule__RequirementCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:287:1: ( rule__RequirementCategory__Group__0 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:288:1: ( rule__RequirementCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:288:2: rule__RequirementCategory__Group__0
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory539);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:300:1: entryRuleMethodCategory : ruleMethodCategory EOF ;
    public final void entryRuleMethodCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:301:1: ( ruleMethodCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:302:1: ruleMethodCategory EOF
            {
             before(grammarAccess.getMethodCategoryRule()); 
            pushFollow(FOLLOW_ruleMethodCategory_in_entryRuleMethodCategory566);
            ruleMethodCategory();

            state._fsp--;

             after(grammarAccess.getMethodCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodCategory573); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:309:1: ruleMethodCategory : ( ( rule__MethodCategory__Group__0 ) ) ;
    public final void ruleMethodCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:313:5: ( ( ( rule__MethodCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:314:1: ( ( rule__MethodCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:314:1: ( ( rule__MethodCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:315:1: ( rule__MethodCategory__Group__0 )
            {
             before(grammarAccess.getMethodCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:316:1: ( rule__MethodCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:316:2: rule__MethodCategory__Group__0
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group__0_in_ruleMethodCategory603);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:328:1: entryRuleSelectionCategory : ruleSelectionCategory EOF ;
    public final void entryRuleSelectionCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:329:1: ( ruleSelectionCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:330:1: ruleSelectionCategory EOF
            {
             before(grammarAccess.getSelectionCategoryRule()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory630);
            ruleSelectionCategory();

            state._fsp--;

             after(grammarAccess.getSelectionCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategory637); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:337:1: ruleSelectionCategory : ( ( rule__SelectionCategory__Group__0 ) ) ;
    public final void ruleSelectionCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:341:5: ( ( ( rule__SelectionCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:342:1: ( ( rule__SelectionCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:342:1: ( ( rule__SelectionCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:343:1: ( rule__SelectionCategory__Group__0 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:344:1: ( rule__SelectionCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:344:2: rule__SelectionCategory__Group__0
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__0_in_ruleSelectionCategory667);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:356:1: entryRuleQualityCategory : ruleQualityCategory EOF ;
    public final void entryRuleQualityCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:357:1: ( ruleQualityCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:358:1: ruleQualityCategory EOF
            {
             before(grammarAccess.getQualityCategoryRule()); 
            pushFollow(FOLLOW_ruleQualityCategory_in_entryRuleQualityCategory694);
            ruleQualityCategory();

            state._fsp--;

             after(grammarAccess.getQualityCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityCategory701); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:365:1: ruleQualityCategory : ( ( rule__QualityCategory__Group__0 ) ) ;
    public final void ruleQualityCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:369:5: ( ( ( rule__QualityCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:370:1: ( ( rule__QualityCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:370:1: ( ( rule__QualityCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:371:1: ( rule__QualityCategory__Group__0 )
            {
             before(grammarAccess.getQualityCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:372:1: ( rule__QualityCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:372:2: rule__QualityCategory__Group__0
            {
            pushFollow(FOLLOW_rule__QualityCategory__Group__0_in_ruleQualityCategory731);
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


    // $ANTLR start "entryRulePhaseCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:384:1: entryRulePhaseCategory : rulePhaseCategory EOF ;
    public final void entryRulePhaseCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:385:1: ( rulePhaseCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:386:1: rulePhaseCategory EOF
            {
             before(grammarAccess.getPhaseCategoryRule()); 
            pushFollow(FOLLOW_rulePhaseCategory_in_entryRulePhaseCategory758);
            rulePhaseCategory();

            state._fsp--;

             after(grammarAccess.getPhaseCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhaseCategory765); 

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
    // $ANTLR end "entryRulePhaseCategory"


    // $ANTLR start "rulePhaseCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:393:1: rulePhaseCategory : ( ( rule__PhaseCategory__Group__0 ) ) ;
    public final void rulePhaseCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:397:5: ( ( ( rule__PhaseCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:398:1: ( ( rule__PhaseCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:398:1: ( ( rule__PhaseCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:399:1: ( rule__PhaseCategory__Group__0 )
            {
             before(grammarAccess.getPhaseCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:400:1: ( rule__PhaseCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:400:2: rule__PhaseCategory__Group__0
            {
            pushFollow(FOLLOW_rule__PhaseCategory__Group__0_in_rulePhaseCategory795);
            rule__PhaseCategory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPhaseCategoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePhaseCategory"


    // $ANTLR start "entryRuleComponentCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:412:1: entryRuleComponentCategory : ruleComponentCategory EOF ;
    public final void entryRuleComponentCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:413:1: ( ruleComponentCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:414:1: ruleComponentCategory EOF
            {
             before(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory822);
            ruleComponentCategory();

            state._fsp--;

             after(grammarAccess.getComponentCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory829); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:421:1: ruleComponentCategory : ( ( rule__ComponentCategory__Group__0 ) ) ;
    public final void ruleComponentCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:425:5: ( ( ( rule__ComponentCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:426:1: ( ( rule__ComponentCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:426:1: ( ( rule__ComponentCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:427:1: ( rule__ComponentCategory__Group__0 )
            {
             before(grammarAccess.getComponentCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:428:1: ( rule__ComponentCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:428:2: rule__ComponentCategory__Group__0
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group__0_in_ruleComponentCategory859);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:440:1: entryRuleCategoryFilters : ruleCategoryFilters EOF ;
    public final void entryRuleCategoryFilters() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:441:1: ( ruleCategoryFilters EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:442:1: ruleCategoryFilters EOF
            {
             before(grammarAccess.getCategoryFiltersRule()); 
            pushFollow(FOLLOW_ruleCategoryFilters_in_entryRuleCategoryFilters886);
            ruleCategoryFilters();

            state._fsp--;

             after(grammarAccess.getCategoryFiltersRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategoryFilters893); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:449:1: ruleCategoryFilters : ( ( rule__CategoryFilters__Group__0 ) ) ;
    public final void ruleCategoryFilters() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:453:5: ( ( ( rule__CategoryFilters__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:454:1: ( ( rule__CategoryFilters__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:454:1: ( ( rule__CategoryFilters__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:455:1: ( rule__CategoryFilters__Group__0 )
            {
             before(grammarAccess.getCategoryFiltersAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:456:1: ( rule__CategoryFilters__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:456:2: rule__CategoryFilters__Group__0
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__0_in_ruleCategoryFilters923);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:468:1: entryRuleCategorySet : ruleCategorySet EOF ;
    public final void entryRuleCategorySet() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:469:1: ( ruleCategorySet EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:470:1: ruleCategorySet EOF
            {
             before(grammarAccess.getCategorySetRule()); 
            pushFollow(FOLLOW_ruleCategorySet_in_entryRuleCategorySet950);
            ruleCategorySet();

            state._fsp--;

             after(grammarAccess.getCategorySetRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategorySet957); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:477:1: ruleCategorySet : ( ( rule__CategorySet__Group__0 ) ) ;
    public final void ruleCategorySet() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:481:5: ( ( ( rule__CategorySet__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:482:1: ( ( rule__CategorySet__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:482:1: ( ( rule__CategorySet__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:483:1: ( rule__CategorySet__Group__0 )
            {
             before(grammarAccess.getCategorySetAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:484:1: ( rule__CategorySet__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:484:2: rule__CategorySet__Group__0
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__0_in_ruleCategorySet987);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:496:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:497:1: ( ruleCatRef EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:498:1: ruleCatRef EOF
            {
             before(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef1014);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getCatRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef1021); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:505:1: ruleCatRef : ( RULE_ID ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:509:5: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:510:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:510:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:511:1: RULE_ID
            {
             before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef1051); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:526:1: rule__RequirementCategories__Group__0 : rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 ;
    public final void rule__RequirementCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:530:1: ( rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:531:2: rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__01084);
            rule__RequirementCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__01087);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:538:1: rule__RequirementCategories__Group__0__Impl : ( () ) ;
    public final void rule__RequirementCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:542:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:543:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:543:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:544:1: ()
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRequirementCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:545:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:547:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:557:1: rule__RequirementCategories__Group__1 : rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 ;
    public final void rule__RequirementCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:561:1: ( rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:562:2: rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__11145);
            rule__RequirementCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__11148);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:569:1: rule__RequirementCategories__Group__1__Impl : ( Requirement ) ;
    public final void rule__RequirementCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:573:1: ( ( Requirement ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:574:1: ( Requirement )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:574:1: ( Requirement )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:575:1: Requirement
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_1()); 
            match(input,Requirement,FOLLOW_Requirement_in_rule__RequirementCategories__Group__1__Impl1176); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:588:1: rule__RequirementCategories__Group__2 : rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 ;
    public final void rule__RequirementCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:592:1: ( rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:593:2: rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__21207);
            rule__RequirementCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__21210);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:600:1: rule__RequirementCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__RequirementCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:604:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:605:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:605:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:606:1: Categories
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__RequirementCategories__Group__2__Impl1238); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:619:1: rule__RequirementCategories__Group__3 : rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 ;
    public final void rule__RequirementCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:623:1: ( rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:624:2: rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__31269);
            rule__RequirementCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__31272);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:631:1: rule__RequirementCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__RequirementCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:635:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:636:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:636:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:637:1: LeftSquareBracket
            {
             before(grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__RequirementCategories__Group__3__Impl1300); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:650:1: rule__RequirementCategories__Group__4 : rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5 ;
    public final void rule__RequirementCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:654:1: ( rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:655:2: rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__41331);
            rule__RequirementCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__5_in_rule__RequirementCategories__Group__41334);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:662:1: rule__RequirementCategories__Group__4__Impl : ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__RequirementCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:666:1: ( ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:667:1: ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:667:1: ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:668:1: ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:668:1: ( ( rule__RequirementCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:669:1: ( rule__RequirementCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:670:1: ( rule__RequirementCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:670:2: rule__RequirementCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1363);
            rule__RequirementCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:673:1: ( ( rule__RequirementCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:674:1: ( rule__RequirementCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:675:1: ( rule__RequirementCategories__CategoryAssignment_4 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:675:2: rule__RequirementCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1375);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:686:1: rule__RequirementCategories__Group__5 : rule__RequirementCategories__Group__5__Impl ;
    public final void rule__RequirementCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:690:1: ( rule__RequirementCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:691:2: rule__RequirementCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__5__Impl_in_rule__RequirementCategories__Group__51408);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:697:1: rule__RequirementCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__RequirementCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:701:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:702:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:702:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:703:1: RightSquareBracket
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__RequirementCategories__Group__5__Impl1436); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:728:1: rule__MethodCategories__Group__0 : rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1 ;
    public final void rule__MethodCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:732:1: ( rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:733:2: rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__0__Impl_in_rule__MethodCategories__Group__01479);
            rule__MethodCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__1_in_rule__MethodCategories__Group__01482);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:740:1: rule__MethodCategories__Group__0__Impl : ( () ) ;
    public final void rule__MethodCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:744:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:745:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:745:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:746:1: ()
            {
             before(grammarAccess.getMethodCategoriesAccess().getMethodCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:747:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:749:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:759:1: rule__MethodCategories__Group__1 : rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2 ;
    public final void rule__MethodCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:763:1: ( rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:764:2: rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__1__Impl_in_rule__MethodCategories__Group__11540);
            rule__MethodCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__2_in_rule__MethodCategories__Group__11543);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:771:1: rule__MethodCategories__Group__1__Impl : ( Method ) ;
    public final void rule__MethodCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:775:1: ( ( Method ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:776:1: ( Method )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:776:1: ( Method )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:777:1: Method
            {
             before(grammarAccess.getMethodCategoriesAccess().getMethodKeyword_1()); 
            match(input,Method,FOLLOW_Method_in_rule__MethodCategories__Group__1__Impl1571); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:790:1: rule__MethodCategories__Group__2 : rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3 ;
    public final void rule__MethodCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:794:1: ( rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:795:2: rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__2__Impl_in_rule__MethodCategories__Group__21602);
            rule__MethodCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__3_in_rule__MethodCategories__Group__21605);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:802:1: rule__MethodCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__MethodCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:806:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:807:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:807:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:808:1: Categories
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__MethodCategories__Group__2__Impl1633); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:821:1: rule__MethodCategories__Group__3 : rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4 ;
    public final void rule__MethodCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:825:1: ( rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:826:2: rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__3__Impl_in_rule__MethodCategories__Group__31664);
            rule__MethodCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__4_in_rule__MethodCategories__Group__31667);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:833:1: rule__MethodCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__MethodCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:837:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:838:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:838:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:839:1: LeftSquareBracket
            {
             before(grammarAccess.getMethodCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__MethodCategories__Group__3__Impl1695); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:852:1: rule__MethodCategories__Group__4 : rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5 ;
    public final void rule__MethodCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:856:1: ( rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:857:2: rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__4__Impl_in_rule__MethodCategories__Group__41726);
            rule__MethodCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__5_in_rule__MethodCategories__Group__41729);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:864:1: rule__MethodCategories__Group__4__Impl : ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__MethodCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:868:1: ( ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:869:1: ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:869:1: ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:870:1: ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:870:1: ( ( rule__MethodCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:871:1: ( rule__MethodCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:872:1: ( rule__MethodCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:872:2: rule__MethodCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__MethodCategories__CategoryAssignment_4_in_rule__MethodCategories__Group__4__Impl1758);
            rule__MethodCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:875:1: ( ( rule__MethodCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:876:1: ( rule__MethodCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:877:1: ( rule__MethodCategories__CategoryAssignment_4 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:877:2: rule__MethodCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__MethodCategories__CategoryAssignment_4_in_rule__MethodCategories__Group__4__Impl1770);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:888:1: rule__MethodCategories__Group__5 : rule__MethodCategories__Group__5__Impl ;
    public final void rule__MethodCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:892:1: ( rule__MethodCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:893:2: rule__MethodCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__5__Impl_in_rule__MethodCategories__Group__51803);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:899:1: rule__MethodCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__MethodCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:903:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:904:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:904:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:905:1: RightSquareBracket
            {
             before(grammarAccess.getMethodCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__MethodCategories__Group__5__Impl1831); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:930:1: rule__SelectionCategories__Group__0 : rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 ;
    public final void rule__SelectionCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:934:1: ( rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:935:2: rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__0__Impl_in_rule__SelectionCategories__Group__01874);
            rule__SelectionCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__1_in_rule__SelectionCategories__Group__01877);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:942:1: rule__SelectionCategories__Group__0__Impl : ( () ) ;
    public final void rule__SelectionCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:946:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:947:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:947:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:948:1: ()
            {
             before(grammarAccess.getSelectionCategoriesAccess().getSelectionCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:949:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:951:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:961:1: rule__SelectionCategories__Group__1 : rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 ;
    public final void rule__SelectionCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:965:1: ( rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:966:2: rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__1__Impl_in_rule__SelectionCategories__Group__11935);
            rule__SelectionCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__2_in_rule__SelectionCategories__Group__11938);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:973:1: rule__SelectionCategories__Group__1__Impl : ( Selection ) ;
    public final void rule__SelectionCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:977:1: ( ( Selection ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:978:1: ( Selection )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:978:1: ( Selection )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:979:1: Selection
            {
             before(grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_1()); 
            match(input,Selection,FOLLOW_Selection_in_rule__SelectionCategories__Group__1__Impl1966); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:992:1: rule__SelectionCategories__Group__2 : rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 ;
    public final void rule__SelectionCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:996:1: ( rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:997:2: rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__2__Impl_in_rule__SelectionCategories__Group__21997);
            rule__SelectionCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__3_in_rule__SelectionCategories__Group__22000);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1004:1: rule__SelectionCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__SelectionCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1008:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1009:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1009:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1010:1: Categories
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__SelectionCategories__Group__2__Impl2028); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1023:1: rule__SelectionCategories__Group__3 : rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 ;
    public final void rule__SelectionCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1027:1: ( rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1028:2: rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__3__Impl_in_rule__SelectionCategories__Group__32059);
            rule__SelectionCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__4_in_rule__SelectionCategories__Group__32062);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1035:1: rule__SelectionCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__SelectionCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1039:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1040:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1040:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1041:1: LeftSquareBracket
            {
             before(grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__SelectionCategories__Group__3__Impl2090); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1054:1: rule__SelectionCategories__Group__4 : rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5 ;
    public final void rule__SelectionCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1058:1: ( rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1059:2: rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__4__Impl_in_rule__SelectionCategories__Group__42121);
            rule__SelectionCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__5_in_rule__SelectionCategories__Group__42124);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1066:1: rule__SelectionCategories__Group__4__Impl : ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__SelectionCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1070:1: ( ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1071:1: ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1071:1: ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1072:1: ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1072:1: ( ( rule__SelectionCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1073:1: ( rule__SelectionCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1074:1: ( rule__SelectionCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1074:2: rule__SelectionCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_4_in_rule__SelectionCategories__Group__4__Impl2153);
            rule__SelectionCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1077:1: ( ( rule__SelectionCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1078:1: ( rule__SelectionCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1079:1: ( rule__SelectionCategories__CategoryAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1079:2: rule__SelectionCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_4_in_rule__SelectionCategories__Group__4__Impl2165);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1090:1: rule__SelectionCategories__Group__5 : rule__SelectionCategories__Group__5__Impl ;
    public final void rule__SelectionCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1094:1: ( rule__SelectionCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1095:2: rule__SelectionCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__5__Impl_in_rule__SelectionCategories__Group__52198);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1101:1: rule__SelectionCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__SelectionCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1105:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1106:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1106:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1107:1: RightSquareBracket
            {
             before(grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__SelectionCategories__Group__5__Impl2226); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1132:1: rule__QualityCategories__Group__0 : rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1 ;
    public final void rule__QualityCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1136:1: ( rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1137:2: rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__0__Impl_in_rule__QualityCategories__Group__02269);
            rule__QualityCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__1_in_rule__QualityCategories__Group__02272);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1144:1: rule__QualityCategories__Group__0__Impl : ( () ) ;
    public final void rule__QualityCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1148:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1149:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1149:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1150:1: ()
            {
             before(grammarAccess.getQualityCategoriesAccess().getQualityCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1151:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1153:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1163:1: rule__QualityCategories__Group__1 : rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2 ;
    public final void rule__QualityCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1167:1: ( rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1168:2: rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__1__Impl_in_rule__QualityCategories__Group__12330);
            rule__QualityCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__2_in_rule__QualityCategories__Group__12333);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1175:1: rule__QualityCategories__Group__1__Impl : ( Quality ) ;
    public final void rule__QualityCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1179:1: ( ( Quality ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1180:1: ( Quality )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1180:1: ( Quality )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1181:1: Quality
            {
             before(grammarAccess.getQualityCategoriesAccess().getQualityKeyword_1()); 
            match(input,Quality,FOLLOW_Quality_in_rule__QualityCategories__Group__1__Impl2361); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1194:1: rule__QualityCategories__Group__2 : rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3 ;
    public final void rule__QualityCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1198:1: ( rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1199:2: rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__2__Impl_in_rule__QualityCategories__Group__22392);
            rule__QualityCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__3_in_rule__QualityCategories__Group__22395);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1206:1: rule__QualityCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__QualityCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1210:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1211:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1211:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1212:1: Categories
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__QualityCategories__Group__2__Impl2423); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1225:1: rule__QualityCategories__Group__3 : rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4 ;
    public final void rule__QualityCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1229:1: ( rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1230:2: rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__3__Impl_in_rule__QualityCategories__Group__32454);
            rule__QualityCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__4_in_rule__QualityCategories__Group__32457);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1237:1: rule__QualityCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__QualityCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1241:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1242:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1242:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1243:1: LeftSquareBracket
            {
             before(grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__QualityCategories__Group__3__Impl2485); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1256:1: rule__QualityCategories__Group__4 : rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5 ;
    public final void rule__QualityCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1260:1: ( rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1261:2: rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__4__Impl_in_rule__QualityCategories__Group__42516);
            rule__QualityCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategories__Group__5_in_rule__QualityCategories__Group__42519);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1268:1: rule__QualityCategories__Group__4__Impl : ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__QualityCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1272:1: ( ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1273:1: ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1273:1: ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1274:1: ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1274:1: ( ( rule__QualityCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1275:1: ( rule__QualityCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1276:1: ( rule__QualityCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1276:2: rule__QualityCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__QualityCategories__CategoryAssignment_4_in_rule__QualityCategories__Group__4__Impl2548);
            rule__QualityCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1279:1: ( ( rule__QualityCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1280:1: ( rule__QualityCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1281:1: ( rule__QualityCategories__CategoryAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1281:2: rule__QualityCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__QualityCategories__CategoryAssignment_4_in_rule__QualityCategories__Group__4__Impl2560);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1292:1: rule__QualityCategories__Group__5 : rule__QualityCategories__Group__5__Impl ;
    public final void rule__QualityCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1296:1: ( rule__QualityCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1297:2: rule__QualityCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__QualityCategories__Group__5__Impl_in_rule__QualityCategories__Group__52593);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1303:1: rule__QualityCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__QualityCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1307:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1308:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1308:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1309:1: RightSquareBracket
            {
             before(grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__QualityCategories__Group__5__Impl2621); 
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


    // $ANTLR start "rule__PhaseCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1334:1: rule__PhaseCategories__Group__0 : rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1 ;
    public final void rule__PhaseCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1338:1: ( rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1339:2: rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__0__Impl_in_rule__PhaseCategories__Group__02664);
            rule__PhaseCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__1_in_rule__PhaseCategories__Group__02667);
            rule__PhaseCategories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__Group__0"


    // $ANTLR start "rule__PhaseCategories__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1346:1: rule__PhaseCategories__Group__0__Impl : ( () ) ;
    public final void rule__PhaseCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1350:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1351:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1351:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1352:1: ()
            {
             before(grammarAccess.getPhaseCategoriesAccess().getQualityCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1353:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1355:1: 
            {
            }

             after(grammarAccess.getPhaseCategoriesAccess().getQualityCategoriesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__Group__0__Impl"


    // $ANTLR start "rule__PhaseCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1365:1: rule__PhaseCategories__Group__1 : rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2 ;
    public final void rule__PhaseCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1369:1: ( rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1370:2: rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__1__Impl_in_rule__PhaseCategories__Group__12725);
            rule__PhaseCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__2_in_rule__PhaseCategories__Group__12728);
            rule__PhaseCategories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__Group__1"


    // $ANTLR start "rule__PhaseCategories__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1377:1: rule__PhaseCategories__Group__1__Impl : ( Phase ) ;
    public final void rule__PhaseCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1381:1: ( ( Phase ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1382:1: ( Phase )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1382:1: ( Phase )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1383:1: Phase
            {
             before(grammarAccess.getPhaseCategoriesAccess().getPhaseKeyword_1()); 
            match(input,Phase,FOLLOW_Phase_in_rule__PhaseCategories__Group__1__Impl2756); 
             after(grammarAccess.getPhaseCategoriesAccess().getPhaseKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__Group__1__Impl"


    // $ANTLR start "rule__PhaseCategories__Group__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1396:1: rule__PhaseCategories__Group__2 : rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3 ;
    public final void rule__PhaseCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1400:1: ( rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1401:2: rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__2__Impl_in_rule__PhaseCategories__Group__22787);
            rule__PhaseCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__3_in_rule__PhaseCategories__Group__22790);
            rule__PhaseCategories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__Group__2"


    // $ANTLR start "rule__PhaseCategories__Group__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1408:1: rule__PhaseCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__PhaseCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1412:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1413:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1413:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1414:1: Categories
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__PhaseCategories__Group__2__Impl2818); 
             after(grammarAccess.getPhaseCategoriesAccess().getCategoriesKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__Group__2__Impl"


    // $ANTLR start "rule__PhaseCategories__Group__3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1427:1: rule__PhaseCategories__Group__3 : rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4 ;
    public final void rule__PhaseCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1431:1: ( rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1432:2: rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__3__Impl_in_rule__PhaseCategories__Group__32849);
            rule__PhaseCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__4_in_rule__PhaseCategories__Group__32852);
            rule__PhaseCategories__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__Group__3"


    // $ANTLR start "rule__PhaseCategories__Group__3__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1439:1: rule__PhaseCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__PhaseCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1443:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1444:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1444:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1445:1: LeftSquareBracket
            {
             before(grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__PhaseCategories__Group__3__Impl2880); 
             after(grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__Group__3__Impl"


    // $ANTLR start "rule__PhaseCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1458:1: rule__PhaseCategories__Group__4 : rule__PhaseCategories__Group__4__Impl rule__PhaseCategories__Group__5 ;
    public final void rule__PhaseCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1462:1: ( rule__PhaseCategories__Group__4__Impl rule__PhaseCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1463:2: rule__PhaseCategories__Group__4__Impl rule__PhaseCategories__Group__5
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__4__Impl_in_rule__PhaseCategories__Group__42911);
            rule__PhaseCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__5_in_rule__PhaseCategories__Group__42914);
            rule__PhaseCategories__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__Group__4"


    // $ANTLR start "rule__PhaseCategories__Group__4__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1470:1: rule__PhaseCategories__Group__4__Impl : ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__PhaseCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1474:1: ( ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1475:1: ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1475:1: ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1476:1: ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1476:1: ( ( rule__PhaseCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1477:1: ( rule__PhaseCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1478:1: ( rule__PhaseCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1478:2: rule__PhaseCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__PhaseCategories__CategoryAssignment_4_in_rule__PhaseCategories__Group__4__Impl2943);
            rule__PhaseCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1481:1: ( ( rule__PhaseCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1482:1: ( rule__PhaseCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1483:1: ( rule__PhaseCategories__CategoryAssignment_4 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1483:2: rule__PhaseCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__PhaseCategories__CategoryAssignment_4_in_rule__PhaseCategories__Group__4__Impl2955);
            	    rule__PhaseCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); 

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
    // $ANTLR end "rule__PhaseCategories__Group__4__Impl"


    // $ANTLR start "rule__PhaseCategories__Group__5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1494:1: rule__PhaseCategories__Group__5 : rule__PhaseCategories__Group__5__Impl ;
    public final void rule__PhaseCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1498:1: ( rule__PhaseCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1499:2: rule__PhaseCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__5__Impl_in_rule__PhaseCategories__Group__52988);
            rule__PhaseCategories__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__Group__5"


    // $ANTLR start "rule__PhaseCategories__Group__5__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1505:1: rule__PhaseCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__PhaseCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1509:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1510:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1510:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1511:1: RightSquareBracket
            {
             before(grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__PhaseCategories__Group__5__Impl3016); 
             after(grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__Group__5__Impl"


    // $ANTLR start "rule__ComponentCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1536:1: rule__ComponentCategories__Group__0 : rule__ComponentCategories__Group__0__Impl rule__ComponentCategories__Group__1 ;
    public final void rule__ComponentCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1540:1: ( rule__ComponentCategories__Group__0__Impl rule__ComponentCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1541:2: rule__ComponentCategories__Group__0__Impl rule__ComponentCategories__Group__1
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__0__Impl_in_rule__ComponentCategories__Group__03059);
            rule__ComponentCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategories__Group__1_in_rule__ComponentCategories__Group__03062);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1548:1: rule__ComponentCategories__Group__0__Impl : ( () ) ;
    public final void rule__ComponentCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1552:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1553:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1553:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1554:1: ()
            {
             before(grammarAccess.getComponentCategoriesAccess().getComponentCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1555:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1557:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1567:1: rule__ComponentCategories__Group__1 : rule__ComponentCategories__Group__1__Impl rule__ComponentCategories__Group__2 ;
    public final void rule__ComponentCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1571:1: ( rule__ComponentCategories__Group__1__Impl rule__ComponentCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1572:2: rule__ComponentCategories__Group__1__Impl rule__ComponentCategories__Group__2
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__1__Impl_in_rule__ComponentCategories__Group__13120);
            rule__ComponentCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategories__Group__2_in_rule__ComponentCategories__Group__13123);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1579:1: rule__ComponentCategories__Group__1__Impl : ( Component ) ;
    public final void rule__ComponentCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1583:1: ( ( Component ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1584:1: ( Component )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1584:1: ( Component )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1585:1: Component
            {
             before(grammarAccess.getComponentCategoriesAccess().getComponentKeyword_1()); 
            match(input,Component,FOLLOW_Component_in_rule__ComponentCategories__Group__1__Impl3151); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1598:1: rule__ComponentCategories__Group__2 : rule__ComponentCategories__Group__2__Impl rule__ComponentCategories__Group__3 ;
    public final void rule__ComponentCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1602:1: ( rule__ComponentCategories__Group__2__Impl rule__ComponentCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1603:2: rule__ComponentCategories__Group__2__Impl rule__ComponentCategories__Group__3
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__2__Impl_in_rule__ComponentCategories__Group__23182);
            rule__ComponentCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategories__Group__3_in_rule__ComponentCategories__Group__23185);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1610:1: rule__ComponentCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__ComponentCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1614:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1615:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1615:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1616:1: Categories
            {
             before(grammarAccess.getComponentCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__ComponentCategories__Group__2__Impl3213); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1629:1: rule__ComponentCategories__Group__3 : rule__ComponentCategories__Group__3__Impl rule__ComponentCategories__Group__4 ;
    public final void rule__ComponentCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1633:1: ( rule__ComponentCategories__Group__3__Impl rule__ComponentCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1634:2: rule__ComponentCategories__Group__3__Impl rule__ComponentCategories__Group__4
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__3__Impl_in_rule__ComponentCategories__Group__33244);
            rule__ComponentCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategories__Group__4_in_rule__ComponentCategories__Group__33247);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1641:1: rule__ComponentCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__ComponentCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1645:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1646:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1646:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1647:1: LeftSquareBracket
            {
             before(grammarAccess.getComponentCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__ComponentCategories__Group__3__Impl3275); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1660:1: rule__ComponentCategories__Group__4 : rule__ComponentCategories__Group__4__Impl rule__ComponentCategories__Group__5 ;
    public final void rule__ComponentCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1664:1: ( rule__ComponentCategories__Group__4__Impl rule__ComponentCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1665:2: rule__ComponentCategories__Group__4__Impl rule__ComponentCategories__Group__5
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__4__Impl_in_rule__ComponentCategories__Group__43306);
            rule__ComponentCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategories__Group__5_in_rule__ComponentCategories__Group__43309);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1672:1: rule__ComponentCategories__Group__4__Impl : ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__ComponentCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1676:1: ( ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1677:1: ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1677:1: ( ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1678:1: ( ( rule__ComponentCategories__CategoryAssignment_4 ) ) ( ( rule__ComponentCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1678:1: ( ( rule__ComponentCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1679:1: ( rule__ComponentCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getComponentCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1680:1: ( rule__ComponentCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1680:2: rule__ComponentCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__ComponentCategories__CategoryAssignment_4_in_rule__ComponentCategories__Group__4__Impl3338);
            rule__ComponentCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getComponentCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1683:1: ( ( rule__ComponentCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1684:1: ( rule__ComponentCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getComponentCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1685:1: ( rule__ComponentCategories__CategoryAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1685:2: rule__ComponentCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__ComponentCategories__CategoryAssignment_4_in_rule__ComponentCategories__Group__4__Impl3350);
            	    rule__ComponentCategories__CategoryAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1696:1: rule__ComponentCategories__Group__5 : rule__ComponentCategories__Group__5__Impl ;
    public final void rule__ComponentCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1700:1: ( rule__ComponentCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1701:2: rule__ComponentCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategories__Group__5__Impl_in_rule__ComponentCategories__Group__53383);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1707:1: rule__ComponentCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__ComponentCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1711:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1712:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1712:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1713:1: RightSquareBracket
            {
             before(grammarAccess.getComponentCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__ComponentCategories__Group__5__Impl3411); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1738:1: rule__RequirementCategory__Group__0 : rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 ;
    public final void rule__RequirementCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1742:1: ( rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1743:2: rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__03454);
            rule__RequirementCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__03457);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1750:1: rule__RequirementCategory__Group__0__Impl : ( () ) ;
    public final void rule__RequirementCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1754:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1755:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1755:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1756:1: ()
            {
             before(grammarAccess.getRequirementCategoryAccess().getRequirementCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1757:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1759:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1769:1: rule__RequirementCategory__Group__1 : rule__RequirementCategory__Group__1__Impl ;
    public final void rule__RequirementCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1773:1: ( rule__RequirementCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1774:2: rule__RequirementCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__13515);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1780:1: rule__RequirementCategory__Group__1__Impl : ( ( rule__RequirementCategory__NameAssignment_1 ) ) ;
    public final void rule__RequirementCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1784:1: ( ( ( rule__RequirementCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1785:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1785:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1786:1: ( rule__RequirementCategory__NameAssignment_1 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1787:1: ( rule__RequirementCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1787:2: rule__RequirementCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__NameAssignment_1_in_rule__RequirementCategory__Group__1__Impl3542);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1801:1: rule__MethodCategory__Group__0 : rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1 ;
    public final void rule__MethodCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1805:1: ( rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1806:2: rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group__0__Impl_in_rule__MethodCategory__Group__03576);
            rule__MethodCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategory__Group__1_in_rule__MethodCategory__Group__03579);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1813:1: rule__MethodCategory__Group__0__Impl : ( () ) ;
    public final void rule__MethodCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1817:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1818:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1818:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1819:1: ()
            {
             before(grammarAccess.getMethodCategoryAccess().getMethodCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1820:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1822:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1832:1: rule__MethodCategory__Group__1 : rule__MethodCategory__Group__1__Impl ;
    public final void rule__MethodCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1836:1: ( rule__MethodCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1837:2: rule__MethodCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group__1__Impl_in_rule__MethodCategory__Group__13637);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1843:1: rule__MethodCategory__Group__1__Impl : ( ( rule__MethodCategory__NameAssignment_1 ) ) ;
    public final void rule__MethodCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1847:1: ( ( ( rule__MethodCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1848:1: ( ( rule__MethodCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1848:1: ( ( rule__MethodCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1849:1: ( rule__MethodCategory__NameAssignment_1 )
            {
             before(grammarAccess.getMethodCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1850:1: ( rule__MethodCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1850:2: rule__MethodCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__MethodCategory__NameAssignment_1_in_rule__MethodCategory__Group__1__Impl3664);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1864:1: rule__SelectionCategory__Group__0 : rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 ;
    public final void rule__SelectionCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1868:1: ( rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1869:2: rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__0__Impl_in_rule__SelectionCategory__Group__03698);
            rule__SelectionCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategory__Group__1_in_rule__SelectionCategory__Group__03701);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1876:1: rule__SelectionCategory__Group__0__Impl : ( () ) ;
    public final void rule__SelectionCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1880:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1881:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1881:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1882:1: ()
            {
             before(grammarAccess.getSelectionCategoryAccess().getSelectionCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1883:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1885:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1895:1: rule__SelectionCategory__Group__1 : rule__SelectionCategory__Group__1__Impl ;
    public final void rule__SelectionCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1899:1: ( rule__SelectionCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1900:2: rule__SelectionCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__1__Impl_in_rule__SelectionCategory__Group__13759);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1906:1: rule__SelectionCategory__Group__1__Impl : ( ( rule__SelectionCategory__NameAssignment_1 ) ) ;
    public final void rule__SelectionCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1910:1: ( ( ( rule__SelectionCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1911:1: ( ( rule__SelectionCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1911:1: ( ( rule__SelectionCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1912:1: ( rule__SelectionCategory__NameAssignment_1 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1913:1: ( rule__SelectionCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1913:2: rule__SelectionCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__NameAssignment_1_in_rule__SelectionCategory__Group__1__Impl3786);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1927:1: rule__QualityCategory__Group__0 : rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1 ;
    public final void rule__QualityCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1931:1: ( rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1932:2: rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1
            {
            pushFollow(FOLLOW_rule__QualityCategory__Group__0__Impl_in_rule__QualityCategory__Group__03820);
            rule__QualityCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualityCategory__Group__1_in_rule__QualityCategory__Group__03823);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1939:1: rule__QualityCategory__Group__0__Impl : ( () ) ;
    public final void rule__QualityCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1943:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1944:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1944:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1945:1: ()
            {
             before(grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1946:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1948:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1958:1: rule__QualityCategory__Group__1 : rule__QualityCategory__Group__1__Impl ;
    public final void rule__QualityCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1962:1: ( rule__QualityCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1963:2: rule__QualityCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualityCategory__Group__1__Impl_in_rule__QualityCategory__Group__13881);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1969:1: rule__QualityCategory__Group__1__Impl : ( ( rule__QualityCategory__NameAssignment_1 ) ) ;
    public final void rule__QualityCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1973:1: ( ( ( rule__QualityCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1974:1: ( ( rule__QualityCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1974:1: ( ( rule__QualityCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1975:1: ( rule__QualityCategory__NameAssignment_1 )
            {
             before(grammarAccess.getQualityCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1976:1: ( rule__QualityCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1976:2: rule__QualityCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__QualityCategory__NameAssignment_1_in_rule__QualityCategory__Group__1__Impl3908);
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


    // $ANTLR start "rule__PhaseCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1990:1: rule__PhaseCategory__Group__0 : rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1 ;
    public final void rule__PhaseCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1994:1: ( rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1995:2: rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1
            {
            pushFollow(FOLLOW_rule__PhaseCategory__Group__0__Impl_in_rule__PhaseCategory__Group__03942);
            rule__PhaseCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategory__Group__1_in_rule__PhaseCategory__Group__03945);
            rule__PhaseCategory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategory__Group__0"


    // $ANTLR start "rule__PhaseCategory__Group__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2002:1: rule__PhaseCategory__Group__0__Impl : ( () ) ;
    public final void rule__PhaseCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2006:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2007:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2007:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2008:1: ()
            {
             before(grammarAccess.getPhaseCategoryAccess().getPhaseCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2009:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2011:1: 
            {
            }

             after(grammarAccess.getPhaseCategoryAccess().getPhaseCategoryAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategory__Group__0__Impl"


    // $ANTLR start "rule__PhaseCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2021:1: rule__PhaseCategory__Group__1 : rule__PhaseCategory__Group__1__Impl ;
    public final void rule__PhaseCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2025:1: ( rule__PhaseCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2026:2: rule__PhaseCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PhaseCategory__Group__1__Impl_in_rule__PhaseCategory__Group__14003);
            rule__PhaseCategory__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategory__Group__1"


    // $ANTLR start "rule__PhaseCategory__Group__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2032:1: rule__PhaseCategory__Group__1__Impl : ( ( rule__PhaseCategory__NameAssignment_1 ) ) ;
    public final void rule__PhaseCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2036:1: ( ( ( rule__PhaseCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2037:1: ( ( rule__PhaseCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2037:1: ( ( rule__PhaseCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2038:1: ( rule__PhaseCategory__NameAssignment_1 )
            {
             before(grammarAccess.getPhaseCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2039:1: ( rule__PhaseCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2039:2: rule__PhaseCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhaseCategory__NameAssignment_1_in_rule__PhaseCategory__Group__1__Impl4030);
            rule__PhaseCategory__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPhaseCategoryAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategory__Group__1__Impl"


    // $ANTLR start "rule__ComponentCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2053:1: rule__ComponentCategory__Group__0 : rule__ComponentCategory__Group__0__Impl rule__ComponentCategory__Group__1 ;
    public final void rule__ComponentCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2057:1: ( rule__ComponentCategory__Group__0__Impl rule__ComponentCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2058:2: rule__ComponentCategory__Group__0__Impl rule__ComponentCategory__Group__1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group__0__Impl_in_rule__ComponentCategory__Group__04064);
            rule__ComponentCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComponentCategory__Group__1_in_rule__ComponentCategory__Group__04067);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2065:1: rule__ComponentCategory__Group__0__Impl : ( () ) ;
    public final void rule__ComponentCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2069:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2070:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2070:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2071:1: ()
            {
             before(grammarAccess.getComponentCategoryAccess().getComponentCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2072:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2074:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2084:1: rule__ComponentCategory__Group__1 : rule__ComponentCategory__Group__1__Impl ;
    public final void rule__ComponentCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2088:1: ( rule__ComponentCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2089:2: rule__ComponentCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ComponentCategory__Group__1__Impl_in_rule__ComponentCategory__Group__14125);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2095:1: rule__ComponentCategory__Group__1__Impl : ( ( rule__ComponentCategory__NameAssignment_1 ) ) ;
    public final void rule__ComponentCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2099:1: ( ( ( rule__ComponentCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2100:1: ( ( rule__ComponentCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2100:1: ( ( rule__ComponentCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2101:1: ( rule__ComponentCategory__NameAssignment_1 )
            {
             before(grammarAccess.getComponentCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2102:1: ( rule__ComponentCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2102:2: rule__ComponentCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ComponentCategory__NameAssignment_1_in_rule__ComponentCategory__Group__1__Impl4152);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2116:1: rule__CategoryFilters__Group__0 : rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1 ;
    public final void rule__CategoryFilters__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2120:1: ( rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2121:2: rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__0__Impl_in_rule__CategoryFilters__Group__04186);
            rule__CategoryFilters__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategoryFilters__Group__1_in_rule__CategoryFilters__Group__04189);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2128:1: rule__CategoryFilters__Group__0__Impl : ( Category ) ;
    public final void rule__CategoryFilters__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2132:1: ( ( Category ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2133:1: ( Category )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2133:1: ( Category )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2134:1: Category
            {
             before(grammarAccess.getCategoryFiltersAccess().getCategoryKeyword_0()); 
            match(input,Category,FOLLOW_Category_in_rule__CategoryFilters__Group__0__Impl4217); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2147:1: rule__CategoryFilters__Group__1 : rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2 ;
    public final void rule__CategoryFilters__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2151:1: ( rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2152:2: rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__1__Impl_in_rule__CategoryFilters__Group__14248);
            rule__CategoryFilters__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategoryFilters__Group__2_in_rule__CategoryFilters__Group__14251);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2159:1: rule__CategoryFilters__Group__1__Impl : ( Filters ) ;
    public final void rule__CategoryFilters__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2163:1: ( ( Filters ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2164:1: ( Filters )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2164:1: ( Filters )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2165:1: Filters
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersKeyword_1()); 
            match(input,Filters,FOLLOW_Filters_in_rule__CategoryFilters__Group__1__Impl4279); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2178:1: rule__CategoryFilters__Group__2 : rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3 ;
    public final void rule__CategoryFilters__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2182:1: ( rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2183:2: rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__2__Impl_in_rule__CategoryFilters__Group__24310);
            rule__CategoryFilters__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategoryFilters__Group__3_in_rule__CategoryFilters__Group__24313);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2190:1: rule__CategoryFilters__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__CategoryFilters__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2194:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2195:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2195:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2196:1: LeftSquareBracket
            {
             before(grammarAccess.getCategoryFiltersAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__CategoryFilters__Group__2__Impl4341); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2209:1: rule__CategoryFilters__Group__3 : rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4 ;
    public final void rule__CategoryFilters__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2213:1: ( rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2214:2: rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__3__Impl_in_rule__CategoryFilters__Group__34372);
            rule__CategoryFilters__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategoryFilters__Group__4_in_rule__CategoryFilters__Group__34375);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2221:1: rule__CategoryFilters__Group__3__Impl : ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) ) ;
    public final void rule__CategoryFilters__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2225:1: ( ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2226:1: ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2226:1: ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2227:1: ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2227:1: ( ( rule__CategoryFilters__FiltersAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2228:1: ( rule__CategoryFilters__FiltersAssignment_3 )
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2229:1: ( rule__CategoryFilters__FiltersAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2229:2: rule__CategoryFilters__FiltersAssignment_3
            {
            pushFollow(FOLLOW_rule__CategoryFilters__FiltersAssignment_3_in_rule__CategoryFilters__Group__3__Impl4404);
            rule__CategoryFilters__FiltersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2232:1: ( ( rule__CategoryFilters__FiltersAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2233:1: ( rule__CategoryFilters__FiltersAssignment_3 )*
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2234:1: ( rule__CategoryFilters__FiltersAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2234:2: rule__CategoryFilters__FiltersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__CategoryFilters__FiltersAssignment_3_in_rule__CategoryFilters__Group__3__Impl4416);
            	    rule__CategoryFilters__FiltersAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2245:1: rule__CategoryFilters__Group__4 : rule__CategoryFilters__Group__4__Impl ;
    public final void rule__CategoryFilters__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2249:1: ( rule__CategoryFilters__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2250:2: rule__CategoryFilters__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__CategoryFilters__Group__4__Impl_in_rule__CategoryFilters__Group__44449);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2256:1: rule__CategoryFilters__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__CategoryFilters__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2260:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2261:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2261:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2262:1: RightSquareBracket
            {
             before(grammarAccess.getCategoryFiltersAccess().getRightSquareBracketKeyword_4()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__CategoryFilters__Group__4__Impl4477); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2285:1: rule__CategorySet__Group__0 : rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1 ;
    public final void rule__CategorySet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2289:1: ( rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2290:2: rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__0__Impl_in_rule__CategorySet__Group__04518);
            rule__CategorySet__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategorySet__Group__1_in_rule__CategorySet__Group__04521);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2297:1: rule__CategorySet__Group__0__Impl : ( () ) ;
    public final void rule__CategorySet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2301:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2302:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2302:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2303:1: ()
            {
             before(grammarAccess.getCategorySetAccess().getCategorySetAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2304:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2306:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2316:1: rule__CategorySet__Group__1 : rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2 ;
    public final void rule__CategorySet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2320:1: ( rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2321:2: rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__1__Impl_in_rule__CategorySet__Group__14579);
            rule__CategorySet__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategorySet__Group__2_in_rule__CategorySet__Group__14582);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2328:1: rule__CategorySet__Group__1__Impl : ( ( rule__CategorySet__NameAssignment_1 ) ) ;
    public final void rule__CategorySet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2332:1: ( ( ( rule__CategorySet__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2333:1: ( ( rule__CategorySet__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2333:1: ( ( rule__CategorySet__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2334:1: ( rule__CategorySet__NameAssignment_1 )
            {
             before(grammarAccess.getCategorySetAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2335:1: ( rule__CategorySet__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2335:2: rule__CategorySet__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__CategorySet__NameAssignment_1_in_rule__CategorySet__Group__1__Impl4609);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2345:1: rule__CategorySet__Group__2 : rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3 ;
    public final void rule__CategorySet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2349:1: ( rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2350:2: rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__2__Impl_in_rule__CategorySet__Group__24639);
            rule__CategorySet__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategorySet__Group__3_in_rule__CategorySet__Group__24642);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2357:1: rule__CategorySet__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__CategorySet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2361:1: ( ( LeftCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2362:1: ( LeftCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2362:1: ( LeftCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2363:1: LeftCurlyBracket
            {
             before(grammarAccess.getCategorySetAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,LeftCurlyBracket,FOLLOW_LeftCurlyBracket_in_rule__CategorySet__Group__2__Impl4670); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2376:1: rule__CategorySet__Group__3 : rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4 ;
    public final void rule__CategorySet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2380:1: ( rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2381:2: rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__3__Impl_in_rule__CategorySet__Group__34701);
            rule__CategorySet__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CategorySet__Group__4_in_rule__CategorySet__Group__34704);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2388:1: rule__CategorySet__Group__3__Impl : ( ( rule__CategorySet__ElementsAssignment_3 )* ) ;
    public final void rule__CategorySet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2392:1: ( ( ( rule__CategorySet__ElementsAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2393:1: ( ( rule__CategorySet__ElementsAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2393:1: ( ( rule__CategorySet__ElementsAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2394:1: ( rule__CategorySet__ElementsAssignment_3 )*
            {
             before(grammarAccess.getCategorySetAccess().getElementsAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2395:1: ( rule__CategorySet__ElementsAssignment_3 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2395:2: rule__CategorySet__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__CategorySet__ElementsAssignment_3_in_rule__CategorySet__Group__3__Impl4731);
            	    rule__CategorySet__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2405:1: rule__CategorySet__Group__4 : rule__CategorySet__Group__4__Impl ;
    public final void rule__CategorySet__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2409:1: ( rule__CategorySet__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2410:2: rule__CategorySet__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__CategorySet__Group__4__Impl_in_rule__CategorySet__Group__44762);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2416:1: rule__CategorySet__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__CategorySet__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2420:1: ( ( RightCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2421:1: ( RightCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2421:1: ( RightCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2422:1: RightCurlyBracket
            {
             before(grammarAccess.getCategorySetAccess().getRightCurlyBracketKeyword_4()); 
            match(input,RightCurlyBracket,FOLLOW_RightCurlyBracket_in_rule__CategorySet__Group__4__Impl4790); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2446:1: rule__CategoriesDefinitions__UnorderedGroup : ( rule__CategoriesDefinitions__UnorderedGroup__0 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2451:1: ( ( rule__CategoriesDefinitions__UnorderedGroup__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2452:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2452:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( LA9_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2452:2: rule__CategoriesDefinitions__UnorderedGroup__0
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__0_in_rule__CategoriesDefinitions__UnorderedGroup4832);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2462:1: rule__CategoriesDefinitions__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) ) ) ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2467:1: ( ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2468:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2468:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) ) )
            int alt10=7;
            int LA10_0 = input.LA(1);

            if ( LA10_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt10=2;
            }
            else if ( LA10_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt10=3;
            }
            else if ( LA10_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt10=4;
            }
            else if ( LA10_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt10=5;
            }
            else if ( LA10_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt10=6;
            }
            else if ( LA10_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6) ) {
                alt10=7;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2470:4: ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2470:4: ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2471:5: {...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2471:116: ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2472:6: ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2478:6: ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2480:7: ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesAssignment_0()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2481:7: ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2481:8: rule__CategoriesDefinitions__RequirementcategoriesAssignment_0
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__RequirementcategoriesAssignment_0_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4919);
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2490:4: ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2490:4: ({...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2491:5: {...}? => ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2491:116: ( ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2492:6: ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2498:6: ( ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2500:7: ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getComponentcategoriesAssignment_1()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2501:7: ( rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2501:8: rule__CategoriesDefinitions__ComponentcategoriesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__ComponentcategoriesAssignment_1_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5017);
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2510:4: ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2510:4: ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2511:5: {...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2511:116: ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2512:6: ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2518:6: ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2520:7: ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesAssignment_2()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2521:7: ( rule__CategoriesDefinitions__MethodcategoriesAssignment_2 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2521:8: rule__CategoriesDefinitions__MethodcategoriesAssignment_2
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__MethodcategoriesAssignment_2_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5115);
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2530:4: ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2530:4: ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2531:5: {...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2531:116: ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2532:6: ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2538:6: ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2540:7: ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesAssignment_3()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2541:7: ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2541:8: rule__CategoriesDefinitions__SelectioncategoriesAssignment_3
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__SelectioncategoriesAssignment_3_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5213);
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2550:4: ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2550:4: ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2551:5: {...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2551:116: ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2552:6: ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2558:6: ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2560:7: ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesAssignment_4()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2561:7: ( rule__CategoriesDefinitions__PhasecategoriesAssignment_4 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2561:8: rule__CategoriesDefinitions__PhasecategoriesAssignment_4
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__PhasecategoriesAssignment_4_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5311);
                    rule__CategoriesDefinitions__PhasecategoriesAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesAssignment_4()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2570:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2570:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2571:5: {...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2571:116: ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2572:6: ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2578:6: ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2580:7: ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesAssignment_5()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2581:7: ( rule__CategoriesDefinitions__QualitycategoriesAssignment_5 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2581:8: rule__CategoriesDefinitions__QualitycategoriesAssignment_5
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__QualitycategoriesAssignment_5_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5409);
                    rule__CategoriesDefinitions__QualitycategoriesAssignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesAssignment_5()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2590:4: ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2590:4: ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2591:5: {...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2591:116: ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2592:6: ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2598:6: ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2600:7: ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterAssignment_6()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2601:7: ( rule__CategoriesDefinitions__CategoryfilterAssignment_6 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2601:8: rule__CategoriesDefinitions__CategoryfilterAssignment_6
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__CategoryfilterAssignment_6_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5507);
                    rule__CategoriesDefinitions__CategoryfilterAssignment_6();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterAssignment_6()); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2619:1: rule__CategoriesDefinitions__UnorderedGroup__0 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2623:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2624:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__05573);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2625:2: ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
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
            else if ( LA11_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2625:2: rule__CategoriesDefinitions__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__1_in_rule__CategoriesDefinitions__UnorderedGroup__05576);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2632:1: rule__CategoriesDefinitions__UnorderedGroup__1 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2636:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2637:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__15601);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2638:2: ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
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
            else if ( LA12_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2638:2: rule__CategoriesDefinitions__UnorderedGroup__2
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__2_in_rule__CategoriesDefinitions__UnorderedGroup__15604);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2645:1: rule__CategoriesDefinitions__UnorderedGroup__2 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2649:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2650:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__25629);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2651:2: ( rule__CategoriesDefinitions__UnorderedGroup__3 )?
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
            else if ( LA13_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt13=1;
            }
            else if ( LA13_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt13=1;
            }
            else if ( LA13_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2651:2: rule__CategoriesDefinitions__UnorderedGroup__3
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__3_in_rule__CategoriesDefinitions__UnorderedGroup__25632);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2658:1: rule__CategoriesDefinitions__UnorderedGroup__3 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2662:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2663:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__35657);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2664:2: ( rule__CategoriesDefinitions__UnorderedGroup__4 )?
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
            else if ( LA14_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt14=1;
            }
            else if ( LA14_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt14=1;
            }
            else if ( LA14_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2664:2: rule__CategoriesDefinitions__UnorderedGroup__4
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__4_in_rule__CategoriesDefinitions__UnorderedGroup__35660);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2671:1: rule__CategoriesDefinitions__UnorderedGroup__4 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2675:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2676:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__45685);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2677:2: ( rule__CategoriesDefinitions__UnorderedGroup__5 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( LA15_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt15=1;
            }
            else if ( LA15_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt15=1;
            }
            else if ( LA15_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt15=1;
            }
            else if ( LA15_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt15=1;
            }
            else if ( LA15_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt15=1;
            }
            else if ( LA15_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt15=1;
            }
            else if ( LA15_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2677:2: rule__CategoriesDefinitions__UnorderedGroup__5
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__5_in_rule__CategoriesDefinitions__UnorderedGroup__45688);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2684:1: rule__CategoriesDefinitions__UnorderedGroup__5 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__6 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2688:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__6 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2689:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__6 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__55713);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2690:2: ( rule__CategoriesDefinitions__UnorderedGroup__6 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( LA16_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt16=1;
            }
            else if ( LA16_0 ==Component && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt16=1;
            }
            else if ( LA16_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt16=1;
            }
            else if ( LA16_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                alt16=1;
            }
            else if ( LA16_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                alt16=1;
            }
            else if ( LA16_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                alt16=1;
            }
            else if ( LA16_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 6) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2690:2: rule__CategoriesDefinitions__UnorderedGroup__6
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__6_in_rule__CategoriesDefinitions__UnorderedGroup__55716);
                    rule__CategoriesDefinitions__UnorderedGroup__6();

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
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup__5"


    // $ANTLR start "rule__CategoriesDefinitions__UnorderedGroup__6"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2697:1: rule__CategoriesDefinitions__UnorderedGroup__6 : rule__CategoriesDefinitions__UnorderedGroup__Impl ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2701:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2702:2: rule__CategoriesDefinitions__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__65741);
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
    // $ANTLR end "rule__CategoriesDefinitions__UnorderedGroup__6"


    // $ANTLR start "rule__CategoriesDefinitions__RequirementcategoriesAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2723:1: rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 : ( ruleRequirementCategories ) ;
    public final void rule__CategoriesDefinitions__RequirementcategoriesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2727:1: ( ( ruleRequirementCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2728:1: ( ruleRequirementCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2728:1: ( ruleRequirementCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2729:1: ruleRequirementCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesRequirementCategoriesParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRequirementCategories_in_rule__CategoriesDefinitions__RequirementcategoriesAssignment_05783);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2738:1: rule__CategoriesDefinitions__ComponentcategoriesAssignment_1 : ( ruleComponentCategories ) ;
    public final void rule__CategoriesDefinitions__ComponentcategoriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2742:1: ( ( ruleComponentCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2743:1: ( ruleComponentCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2743:1: ( ruleComponentCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2744:1: ruleComponentCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getComponentcategoriesComponentCategoriesParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleComponentCategories_in_rule__CategoriesDefinitions__ComponentcategoriesAssignment_15814);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2753:1: rule__CategoriesDefinitions__MethodcategoriesAssignment_2 : ( ruleMethodCategories ) ;
    public final void rule__CategoriesDefinitions__MethodcategoriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2757:1: ( ( ruleMethodCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2758:1: ( ruleMethodCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2758:1: ( ruleMethodCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2759:1: ruleMethodCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesMethodCategoriesParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleMethodCategories_in_rule__CategoriesDefinitions__MethodcategoriesAssignment_25845);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2768:1: rule__CategoriesDefinitions__SelectioncategoriesAssignment_3 : ( ruleSelectionCategories ) ;
    public final void rule__CategoriesDefinitions__SelectioncategoriesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2772:1: ( ( ruleSelectionCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2773:1: ( ruleSelectionCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2773:1: ( ruleSelectionCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2774:1: ruleSelectionCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesSelectionCategoriesParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleSelectionCategories_in_rule__CategoriesDefinitions__SelectioncategoriesAssignment_35876);
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


    // $ANTLR start "rule__CategoriesDefinitions__PhasecategoriesAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2783:1: rule__CategoriesDefinitions__PhasecategoriesAssignment_4 : ( rulePhaseCategories ) ;
    public final void rule__CategoriesDefinitions__PhasecategoriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2787:1: ( ( rulePhaseCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2788:1: ( rulePhaseCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2788:1: ( rulePhaseCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2789:1: rulePhaseCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesPhaseCategoriesParserRuleCall_4_0()); 
            pushFollow(FOLLOW_rulePhaseCategories_in_rule__CategoriesDefinitions__PhasecategoriesAssignment_45907);
            rulePhaseCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesPhaseCategoriesParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__PhasecategoriesAssignment_4"


    // $ANTLR start "rule__CategoriesDefinitions__QualitycategoriesAssignment_5"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2798:1: rule__CategoriesDefinitions__QualitycategoriesAssignment_5 : ( ruleQualityCategories ) ;
    public final void rule__CategoriesDefinitions__QualitycategoriesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2802:1: ( ( ruleQualityCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2803:1: ( ruleQualityCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2803:1: ( ruleQualityCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2804:1: ruleQualityCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesQualityCategoriesParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleQualityCategories_in_rule__CategoriesDefinitions__QualitycategoriesAssignment_55938);
            ruleQualityCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesQualityCategoriesParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__QualitycategoriesAssignment_5"


    // $ANTLR start "rule__CategoriesDefinitions__CategoryfilterAssignment_6"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2813:1: rule__CategoriesDefinitions__CategoryfilterAssignment_6 : ( ruleCategoryFilters ) ;
    public final void rule__CategoriesDefinitions__CategoryfilterAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2817:1: ( ( ruleCategoryFilters ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2818:1: ( ruleCategoryFilters )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2818:1: ( ruleCategoryFilters )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2819:1: ruleCategoryFilters
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterCategoryFiltersParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleCategoryFilters_in_rule__CategoriesDefinitions__CategoryfilterAssignment_65969);
            ruleCategoryFilters();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterCategoryFiltersParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__CategoryfilterAssignment_6"


    // $ANTLR start "rule__RequirementCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2828:1: rule__RequirementCategories__CategoryAssignment_4 : ( ruleRequirementCategory ) ;
    public final void rule__RequirementCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2832:1: ( ( ruleRequirementCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2833:1: ( ruleRequirementCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2833:1: ( ruleRequirementCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2834:1: ruleRequirementCategory
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_46000);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2843:1: rule__MethodCategories__CategoryAssignment_4 : ( ruleMethodCategory ) ;
    public final void rule__MethodCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2847:1: ( ( ruleMethodCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2848:1: ( ruleMethodCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2848:1: ( ruleMethodCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2849:1: ruleMethodCategory
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryMethodCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleMethodCategory_in_rule__MethodCategories__CategoryAssignment_46031);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2858:1: rule__SelectionCategories__CategoryAssignment_4 : ( ruleSelectionCategory ) ;
    public final void rule__SelectionCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2862:1: ( ( ruleSelectionCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2863:1: ( ruleSelectionCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2863:1: ( ruleSelectionCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2864:1: ruleSelectionCategory
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_rule__SelectionCategories__CategoryAssignment_46062);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2873:1: rule__QualityCategories__CategoryAssignment_4 : ( ruleQualityCategory ) ;
    public final void rule__QualityCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2877:1: ( ( ruleQualityCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2878:1: ( ruleQualityCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2878:1: ( ruleQualityCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2879:1: ruleQualityCategory
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleQualityCategory_in_rule__QualityCategories__CategoryAssignment_46093);
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


    // $ANTLR start "rule__PhaseCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2888:1: rule__PhaseCategories__CategoryAssignment_4 : ( rulePhaseCategory ) ;
    public final void rule__PhaseCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2892:1: ( ( rulePhaseCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2893:1: ( rulePhaseCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2893:1: ( rulePhaseCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2894:1: rulePhaseCategory
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_rulePhaseCategory_in_rule__PhaseCategories__CategoryAssignment_46124);
            rulePhaseCategory();

            state._fsp--;

             after(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategories__CategoryAssignment_4"


    // $ANTLR start "rule__ComponentCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2903:1: rule__ComponentCategories__CategoryAssignment_4 : ( ruleComponentCategory ) ;
    public final void rule__ComponentCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2907:1: ( ( ruleComponentCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2908:1: ( ruleComponentCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2908:1: ( ruleComponentCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2909:1: ruleComponentCategory
            {
             before(grammarAccess.getComponentCategoriesAccess().getCategoryComponentCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_rule__ComponentCategories__CategoryAssignment_46155);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2918:1: rule__RequirementCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RequirementCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2922:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2923:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2923:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2924:1: RULE_ID
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_16186); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2933:1: rule__MethodCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__MethodCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2937:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2938:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2938:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2939:1: RULE_ID
            {
             before(grammarAccess.getMethodCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MethodCategory__NameAssignment_16217); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2948:1: rule__SelectionCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SelectionCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2952:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2953:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2953:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2954:1: RULE_ID
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectionCategory__NameAssignment_16248); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2963:1: rule__QualityCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__QualityCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2967:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2968:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2968:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2969:1: RULE_ID
            {
             before(grammarAccess.getQualityCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualityCategory__NameAssignment_16279); 
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


    // $ANTLR start "rule__PhaseCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2978:1: rule__PhaseCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhaseCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2982:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2983:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2983:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2984:1: RULE_ID
            {
             before(grammarAccess.getPhaseCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PhaseCategory__NameAssignment_16310); 
             after(grammarAccess.getPhaseCategoryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PhaseCategory__NameAssignment_1"


    // $ANTLR start "rule__ComponentCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2993:1: rule__ComponentCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ComponentCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2997:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2998:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2998:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2999:1: RULE_ID
            {
             before(grammarAccess.getComponentCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComponentCategory__NameAssignment_16341); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3008:1: rule__CategoryFilters__FiltersAssignment_3 : ( ruleCategorySet ) ;
    public final void rule__CategoryFilters__FiltersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3012:1: ( ( ruleCategorySet ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3013:1: ( ruleCategorySet )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3013:1: ( ruleCategorySet )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3014:1: ruleCategorySet
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersCategorySetParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCategorySet_in_rule__CategoryFilters__FiltersAssignment_36372);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3023:1: rule__CategorySet__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CategorySet__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3027:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3028:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3028:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3029:1: RULE_ID
            {
             before(grammarAccess.getCategorySetAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CategorySet__NameAssignment_16403); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3038:1: rule__CategorySet__ElementsAssignment_3 : ( ( ruleCatRef ) ) ;
    public final void rule__CategorySet__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3042:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3043:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3043:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3044:1: ( ruleCatRef )
            {
             before(grammarAccess.getCategorySetAccess().getElementsCategoryCrossReference_3_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3045:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:3046:1: ruleCatRef
            {
             before(grammarAccess.getCategorySetAccess().getElementsCategoryCatRefParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__CategorySet__ElementsAssignment_36438);
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
    public static final BitSet FOLLOW_rulePhaseCategories_in_entryRulePhaseCategories374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhaseCategories381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__0_in_rulePhaseCategories411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategories_in_entryRuleComponentCategories438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategories445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__0_in_ruleComponentCategories475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategory_in_entryRuleMethodCategory566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodCategory573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__0_in_ruleMethodCategory603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategory637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__0_in_ruleSelectionCategory667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategory_in_entryRuleQualityCategory694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityCategory701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__0_in_ruleQualityCategory731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategory_in_entryRulePhaseCategory758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhaseCategory765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__0_in_rulePhaseCategory795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group__0_in_ruleComponentCategory859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategoryFilters_in_entryRuleCategoryFilters886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoryFilters893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__0_in_ruleCategoryFilters923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategorySet_in_entryRuleCategorySet950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategorySet957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__0_in_ruleCategorySet987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef1014 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__01084 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__01087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__11145 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__11148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_rule__RequirementCategories__Group__1__Impl1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__21207 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__21210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__RequirementCategories__Group__2__Impl1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__31269 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__31272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__RequirementCategories__Group__3__Impl1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__41331 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__5_in_rule__RequirementCategories__Group__41334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1363 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1375 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__5__Impl_in_rule__RequirementCategories__Group__51408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__RequirementCategories__Group__5__Impl1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__0__Impl_in_rule__MethodCategories__Group__01479 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__1_in_rule__MethodCategories__Group__01482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__1__Impl_in_rule__MethodCategories__Group__11540 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__2_in_rule__MethodCategories__Group__11543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Method_in_rule__MethodCategories__Group__1__Impl1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__2__Impl_in_rule__MethodCategories__Group__21602 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__3_in_rule__MethodCategories__Group__21605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__MethodCategories__Group__2__Impl1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__3__Impl_in_rule__MethodCategories__Group__31664 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__4_in_rule__MethodCategories__Group__31667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__MethodCategories__Group__3__Impl1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__4__Impl_in_rule__MethodCategories__Group__41726 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__5_in_rule__MethodCategories__Group__41729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__CategoryAssignment_4_in_rule__MethodCategories__Group__4__Impl1758 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__MethodCategories__CategoryAssignment_4_in_rule__MethodCategories__Group__4__Impl1770 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__5__Impl_in_rule__MethodCategories__Group__51803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__MethodCategories__Group__5__Impl1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__0__Impl_in_rule__SelectionCategories__Group__01874 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__1_in_rule__SelectionCategories__Group__01877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__1__Impl_in_rule__SelectionCategories__Group__11935 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__2_in_rule__SelectionCategories__Group__11938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Selection_in_rule__SelectionCategories__Group__1__Impl1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__2__Impl_in_rule__SelectionCategories__Group__21997 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__3_in_rule__SelectionCategories__Group__22000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__SelectionCategories__Group__2__Impl2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__3__Impl_in_rule__SelectionCategories__Group__32059 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__4_in_rule__SelectionCategories__Group__32062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__SelectionCategories__Group__3__Impl2090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__4__Impl_in_rule__SelectionCategories__Group__42121 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__5_in_rule__SelectionCategories__Group__42124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__CategoryAssignment_4_in_rule__SelectionCategories__Group__4__Impl2153 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__CategoryAssignment_4_in_rule__SelectionCategories__Group__4__Impl2165 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__5__Impl_in_rule__SelectionCategories__Group__52198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__SelectionCategories__Group__5__Impl2226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__0__Impl_in_rule__QualityCategories__Group__02269 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__1_in_rule__QualityCategories__Group__02272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__1__Impl_in_rule__QualityCategories__Group__12330 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__2_in_rule__QualityCategories__Group__12333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Quality_in_rule__QualityCategories__Group__1__Impl2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__2__Impl_in_rule__QualityCategories__Group__22392 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__3_in_rule__QualityCategories__Group__22395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__QualityCategories__Group__2__Impl2423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__3__Impl_in_rule__QualityCategories__Group__32454 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__4_in_rule__QualityCategories__Group__32457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__QualityCategories__Group__3__Impl2485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__4__Impl_in_rule__QualityCategories__Group__42516 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__5_in_rule__QualityCategories__Group__42519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategories__CategoryAssignment_4_in_rule__QualityCategories__Group__4__Impl2548 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__QualityCategories__CategoryAssignment_4_in_rule__QualityCategories__Group__4__Impl2560 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__QualityCategories__Group__5__Impl_in_rule__QualityCategories__Group__52593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__QualityCategories__Group__5__Impl2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__0__Impl_in_rule__PhaseCategories__Group__02664 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__1_in_rule__PhaseCategories__Group__02667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__1__Impl_in_rule__PhaseCategories__Group__12725 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__2_in_rule__PhaseCategories__Group__12728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Phase_in_rule__PhaseCategories__Group__1__Impl2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__2__Impl_in_rule__PhaseCategories__Group__22787 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__3_in_rule__PhaseCategories__Group__22790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__PhaseCategories__Group__2__Impl2818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__3__Impl_in_rule__PhaseCategories__Group__32849 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__4_in_rule__PhaseCategories__Group__32852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__PhaseCategories__Group__3__Impl2880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__4__Impl_in_rule__PhaseCategories__Group__42911 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__5_in_rule__PhaseCategories__Group__42914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__CategoryAssignment_4_in_rule__PhaseCategories__Group__4__Impl2943 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__CategoryAssignment_4_in_rule__PhaseCategories__Group__4__Impl2955 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__5__Impl_in_rule__PhaseCategories__Group__52988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__PhaseCategories__Group__5__Impl3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__0__Impl_in_rule__ComponentCategories__Group__03059 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__1_in_rule__ComponentCategories__Group__03062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__1__Impl_in_rule__ComponentCategories__Group__13120 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__2_in_rule__ComponentCategories__Group__13123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Component_in_rule__ComponentCategories__Group__1__Impl3151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__2__Impl_in_rule__ComponentCategories__Group__23182 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__3_in_rule__ComponentCategories__Group__23185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__ComponentCategories__Group__2__Impl3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__3__Impl_in_rule__ComponentCategories__Group__33244 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__4_in_rule__ComponentCategories__Group__33247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__ComponentCategories__Group__3__Impl3275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__4__Impl_in_rule__ComponentCategories__Group__43306 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__5_in_rule__ComponentCategories__Group__43309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__CategoryAssignment_4_in_rule__ComponentCategories__Group__4__Impl3338 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__CategoryAssignment_4_in_rule__ComponentCategories__Group__4__Impl3350 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__ComponentCategories__Group__5__Impl_in_rule__ComponentCategories__Group__53383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__ComponentCategories__Group__5__Impl3411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__03454 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__03457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__13515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__NameAssignment_1_in_rule__RequirementCategory__Group__1__Impl3542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__0__Impl_in_rule__MethodCategory__Group__03576 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__1_in_rule__MethodCategory__Group__03579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__1__Impl_in_rule__MethodCategory__Group__13637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__NameAssignment_1_in_rule__MethodCategory__Group__1__Impl3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__0__Impl_in_rule__SelectionCategory__Group__03698 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__1_in_rule__SelectionCategory__Group__03701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__1__Impl_in_rule__SelectionCategory__Group__13759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__NameAssignment_1_in_rule__SelectionCategory__Group__1__Impl3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__0__Impl_in_rule__QualityCategory__Group__03820 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__1_in_rule__QualityCategory__Group__03823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__Group__1__Impl_in_rule__QualityCategory__Group__13881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualityCategory__NameAssignment_1_in_rule__QualityCategory__Group__1__Impl3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__0__Impl_in_rule__PhaseCategory__Group__03942 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__1_in_rule__PhaseCategory__Group__03945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__1__Impl_in_rule__PhaseCategory__Group__14003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategory__NameAssignment_1_in_rule__PhaseCategory__Group__1__Impl4030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group__0__Impl_in_rule__ComponentCategory__Group__04064 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group__1_in_rule__ComponentCategory__Group__04067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__Group__1__Impl_in_rule__ComponentCategory__Group__14125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComponentCategory__NameAssignment_1_in_rule__ComponentCategory__Group__1__Impl4152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__0__Impl_in_rule__CategoryFilters__Group__04186 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__1_in_rule__CategoryFilters__Group__04189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Category_in_rule__CategoryFilters__Group__0__Impl4217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__1__Impl_in_rule__CategoryFilters__Group__14248 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__2_in_rule__CategoryFilters__Group__14251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Filters_in_rule__CategoryFilters__Group__1__Impl4279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__2__Impl_in_rule__CategoryFilters__Group__24310 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__3_in_rule__CategoryFilters__Group__24313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__CategoryFilters__Group__2__Impl4341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__3__Impl_in_rule__CategoryFilters__Group__34372 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__4_in_rule__CategoryFilters__Group__34375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__FiltersAssignment_3_in_rule__CategoryFilters__Group__3__Impl4404 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__FiltersAssignment_3_in_rule__CategoryFilters__Group__3__Impl4416 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__4__Impl_in_rule__CategoryFilters__Group__44449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__CategoryFilters__Group__4__Impl4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__0__Impl_in_rule__CategorySet__Group__04518 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__1_in_rule__CategorySet__Group__04521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__1__Impl_in_rule__CategorySet__Group__14579 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__2_in_rule__CategorySet__Group__14582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__NameAssignment_1_in_rule__CategorySet__Group__1__Impl4609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__2__Impl_in_rule__CategorySet__Group__24639 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__3_in_rule__CategorySet__Group__24642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftCurlyBracket_in_rule__CategorySet__Group__2__Impl4670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__3__Impl_in_rule__CategorySet__Group__34701 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__4_in_rule__CategorySet__Group__34704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategorySet__ElementsAssignment_3_in_rule__CategorySet__Group__3__Impl4731 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__CategorySet__Group__4__Impl_in_rule__CategorySet__Group__44762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightCurlyBracket_in_rule__CategorySet__Group__4__Impl4790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__0_in_rule__CategoriesDefinitions__UnorderedGroup4832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__RequirementcategoriesAssignment_0_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__ComponentcategoriesAssignment_1_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__MethodcategoriesAssignment_2_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__SelectioncategoriesAssignment_3_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__PhasecategoriesAssignment_4_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__QualitycategoriesAssignment_5_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__CategoryfilterAssignment_6_in_rule__CategoriesDefinitions__UnorderedGroup__Impl5507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__05573 = new BitSet(new long[]{0x0000000000001DD2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__1_in_rule__CategoriesDefinitions__UnorderedGroup__05576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__15601 = new BitSet(new long[]{0x0000000000001DD2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__2_in_rule__CategoriesDefinitions__UnorderedGroup__15604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__25629 = new BitSet(new long[]{0x0000000000001DD2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__3_in_rule__CategoriesDefinitions__UnorderedGroup__25632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__35657 = new BitSet(new long[]{0x0000000000001DD2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__4_in_rule__CategoriesDefinitions__UnorderedGroup__35660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__45685 = new BitSet(new long[]{0x0000000000001DD2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__5_in_rule__CategoriesDefinitions__UnorderedGroup__45688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__55713 = new BitSet(new long[]{0x0000000000001DD2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__6_in_rule__CategoriesDefinitions__UnorderedGroup__55716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__65741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_rule__CategoriesDefinitions__RequirementcategoriesAssignment_05783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategories_in_rule__CategoriesDefinitions__ComponentcategoriesAssignment_15814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategories_in_rule__CategoriesDefinitions__MethodcategoriesAssignment_25845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_rule__CategoriesDefinitions__SelectioncategoriesAssignment_35876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategories_in_rule__CategoriesDefinitions__PhasecategoriesAssignment_45907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategories_in_rule__CategoriesDefinitions__QualitycategoriesAssignment_55938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategoryFilters_in_rule__CategoriesDefinitions__CategoryfilterAssignment_65969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_46000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategory_in_rule__MethodCategories__CategoryAssignment_46031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_rule__SelectionCategories__CategoryAssignment_46062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategory_in_rule__QualityCategories__CategoryAssignment_46093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategory_in_rule__PhaseCategories__CategoryAssignment_46124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_rule__ComponentCategories__CategoryAssignment_46155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_16186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MethodCategory__NameAssignment_16217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectionCategory__NameAssignment_16248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualityCategory__NameAssignment_16279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PhaseCategory__NameAssignment_16310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComponentCategory__NameAssignment_16341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategorySet_in_rule__CategoryFilters__FiltersAssignment_36372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CategorySet__NameAssignment_16403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__CategorySet__ElementsAssignment_36438 = new BitSet(new long[]{0x0000000000000002L});

}

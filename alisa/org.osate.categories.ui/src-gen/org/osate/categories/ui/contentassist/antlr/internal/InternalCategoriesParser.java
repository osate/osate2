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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Requirement", "Categories", "Selection", "Method", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=12;
    public static final int Categories=5;
    public static final int RULE_WS=17;
    public static final int Selection=6;
    public static final int LeftCurlyBracket=10;
    public static final int RULE_STRING=14;
    public static final int Method=7;
    public static final int RULE_ANY_OTHER=18;
    public static final int RULE_SL_COMMENT=16;
    public static final int Requirement=4;
    public static final int RULE_INT=13;
    public static final int RULE_ML_COMMENT=15;
    public static final int LeftSquareBracket=8;
    public static final int RightCurlyBracket=11;
    public static final int EOF=-1;
    public static final int RightSquareBracket=9;

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



    // $ANTLR start "entryRuleCategories"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:71:1: entryRuleCategories : ruleCategories EOF ;
    public final void entryRuleCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:72:1: ( ruleCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:73:1: ruleCategories EOF
            {
             before(grammarAccess.getCategoriesRule()); 
            pushFollow(FOLLOW_ruleCategories_in_entryRuleCategories54);
            ruleCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategories61); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:80:1: ruleCategories : ( ( rule__Categories__Alternatives ) ) ;
    public final void ruleCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:84:5: ( ( ( rule__Categories__Alternatives ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:85:1: ( ( rule__Categories__Alternatives ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:85:1: ( ( rule__Categories__Alternatives ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:86:1: ( rule__Categories__Alternatives )
            {
             before(grammarAccess.getCategoriesAccess().getAlternatives()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:87:1: ( rule__Categories__Alternatives )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:87:2: rule__Categories__Alternatives
            {
            pushFollow(FOLLOW_rule__Categories__Alternatives_in_ruleCategories91);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:99:1: entryRuleRequirementCategories : ruleRequirementCategories EOF ;
    public final void entryRuleRequirementCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:100:1: ( ruleRequirementCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:101:1: ruleRequirementCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:108:1: ruleRequirementCategories : ( ( rule__RequirementCategories__Group__0 ) ) ;
    public final void ruleRequirementCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:112:5: ( ( ( rule__RequirementCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:113:1: ( ( rule__RequirementCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:113:1: ( ( rule__RequirementCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:114:1: ( rule__RequirementCategories__Group__0 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:115:1: ( rule__RequirementCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:115:2: rule__RequirementCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:127:1: entryRuleMethodCategories : ruleMethodCategories EOF ;
    public final void entryRuleMethodCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:128:1: ( ruleMethodCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:129:1: ruleMethodCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:136:1: ruleMethodCategories : ( ( rule__MethodCategories__Group__0 ) ) ;
    public final void ruleMethodCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:140:5: ( ( ( rule__MethodCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:141:1: ( ( rule__MethodCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:141:1: ( ( rule__MethodCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:142:1: ( rule__MethodCategories__Group__0 )
            {
             before(grammarAccess.getMethodCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:143:1: ( rule__MethodCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:143:2: rule__MethodCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:155:1: entryRuleSelectionCategories : ruleSelectionCategories EOF ;
    public final void entryRuleSelectionCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:156:1: ( ruleSelectionCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:157:1: ruleSelectionCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:164:1: ruleSelectionCategories : ( ( rule__SelectionCategories__Group__0 ) ) ;
    public final void ruleSelectionCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:168:5: ( ( ( rule__SelectionCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:169:1: ( ( rule__SelectionCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:169:1: ( ( rule__SelectionCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:170:1: ( rule__SelectionCategories__Group__0 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:171:1: ( rule__SelectionCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:171:2: rule__SelectionCategories__Group__0
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


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:185:1: entryRuleRequirementCategory : ruleRequirementCategory EOF ;
    public final void entryRuleRequirementCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:186:1: ( ruleRequirementCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:187:1: ruleRequirementCategory EOF
            {
             before(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory312);
            ruleRequirementCategory();

            state._fsp--;

             after(grammarAccess.getRequirementCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory319); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:194:1: ruleRequirementCategory : ( ( rule__RequirementCategory__Group__0 ) ) ;
    public final void ruleRequirementCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:198:5: ( ( ( rule__RequirementCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:199:1: ( ( rule__RequirementCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:199:1: ( ( rule__RequirementCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:200:1: ( rule__RequirementCategory__Group__0 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:201:1: ( rule__RequirementCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:201:2: rule__RequirementCategory__Group__0
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory349);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:213:1: entryRuleMethodCategory : ruleMethodCategory EOF ;
    public final void entryRuleMethodCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:214:1: ( ruleMethodCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:215:1: ruleMethodCategory EOF
            {
             before(grammarAccess.getMethodCategoryRule()); 
            pushFollow(FOLLOW_ruleMethodCategory_in_entryRuleMethodCategory376);
            ruleMethodCategory();

            state._fsp--;

             after(grammarAccess.getMethodCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodCategory383); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:222:1: ruleMethodCategory : ( ( rule__MethodCategory__Group__0 ) ) ;
    public final void ruleMethodCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:226:5: ( ( ( rule__MethodCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:227:1: ( ( rule__MethodCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:227:1: ( ( rule__MethodCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:228:1: ( rule__MethodCategory__Group__0 )
            {
             before(grammarAccess.getMethodCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:229:1: ( rule__MethodCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:229:2: rule__MethodCategory__Group__0
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group__0_in_ruleMethodCategory413);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:241:1: entryRuleSelectionCategory : ruleSelectionCategory EOF ;
    public final void entryRuleSelectionCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:242:1: ( ruleSelectionCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:243:1: ruleSelectionCategory EOF
            {
             before(grammarAccess.getSelectionCategoryRule()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory440);
            ruleSelectionCategory();

            state._fsp--;

             after(grammarAccess.getSelectionCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategory447); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:250:1: ruleSelectionCategory : ( ( rule__SelectionCategory__Group__0 ) ) ;
    public final void ruleSelectionCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:254:5: ( ( ( rule__SelectionCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:255:1: ( ( rule__SelectionCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:255:1: ( ( rule__SelectionCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:256:1: ( rule__SelectionCategory__Group__0 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:257:1: ( rule__SelectionCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:257:2: rule__SelectionCategory__Group__0
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__0_in_ruleSelectionCategory477);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:269:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:270:1: ( ruleCatRef EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:271:1: ruleCatRef EOF
            {
             before(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef504);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getCatRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef511); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:278:1: ruleCatRef : ( RULE_ID ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:282:5: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:283:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:283:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:284:1: RULE_ID
            {
             before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef541); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:297:1: rule__Categories__Alternatives : ( ( ruleRequirementCategories ) | ( ruleMethodCategories ) | ( ruleSelectionCategories ) );
    public final void rule__Categories__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:301:1: ( ( ruleRequirementCategories ) | ( ruleMethodCategories ) | ( ruleSelectionCategories ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case Requirement:
                {
                alt1=1;
                }
                break;
            case Method:
                {
                alt1=2;
                }
                break;
            case Selection:
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:302:1: ( ruleRequirementCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:302:1: ( ruleRequirementCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:303:1: ruleRequirementCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRequirementCategories_in_rule__Categories__Alternatives576);
                    ruleRequirementCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:308:6: ( ruleMethodCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:308:6: ( ruleMethodCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:309:1: ruleMethodCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getMethodCategoriesParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleMethodCategories_in_rule__Categories__Alternatives593);
                    ruleMethodCategories();

                    state._fsp--;

                     after(grammarAccess.getCategoriesAccess().getMethodCategoriesParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:314:6: ( ruleSelectionCategories )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:314:6: ( ruleSelectionCategories )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:315:1: ruleSelectionCategories
                    {
                     before(grammarAccess.getCategoriesAccess().getSelectionCategoriesParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleSelectionCategories_in_rule__Categories__Alternatives610);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:328:1: rule__RequirementCategories__Group__0 : rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 ;
    public final void rule__RequirementCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:332:1: ( rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:333:2: rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__0641);
            rule__RequirementCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__0644);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:340:1: rule__RequirementCategories__Group__0__Impl : ( Requirement ) ;
    public final void rule__RequirementCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:344:1: ( ( Requirement ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:345:1: ( Requirement )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:345:1: ( Requirement )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:346:1: Requirement
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_0()); 
            match(input,Requirement,FOLLOW_Requirement_in_rule__RequirementCategories__Group__0__Impl672); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:359:1: rule__RequirementCategories__Group__1 : rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 ;
    public final void rule__RequirementCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:363:1: ( rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:364:2: rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__1703);
            rule__RequirementCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__1706);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:371:1: rule__RequirementCategories__Group__1__Impl : ( Categories ) ;
    public final void rule__RequirementCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:375:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:376:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:376:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:377:1: Categories
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,Categories,FOLLOW_Categories_in_rule__RequirementCategories__Group__1__Impl734); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:390:1: rule__RequirementCategories__Group__2 : rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 ;
    public final void rule__RequirementCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:394:1: ( rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:395:2: rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__2765);
            rule__RequirementCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__2768);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:402:1: rule__RequirementCategories__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__RequirementCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:406:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:407:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:407:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:408:1: LeftSquareBracket
            {
             before(grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__RequirementCategories__Group__2__Impl796); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:421:1: rule__RequirementCategories__Group__3 : rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 ;
    public final void rule__RequirementCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:425:1: ( rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:426:2: rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__3827);
            rule__RequirementCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__3830);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:433:1: rule__RequirementCategories__Group__3__Impl : ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__RequirementCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:437:1: ( ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:438:1: ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:438:1: ( ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:439:1: ( ( rule__RequirementCategories__CategoryAssignment_3 ) ) ( ( rule__RequirementCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:439:1: ( ( rule__RequirementCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:440:1: ( rule__RequirementCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:441:1: ( rule__RequirementCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:441:2: rule__RequirementCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl859);
            rule__RequirementCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:444:1: ( ( rule__RequirementCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:445:1: ( rule__RequirementCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:446:1: ( rule__RequirementCategories__CategoryAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:446:2: rule__RequirementCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl871);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:457:1: rule__RequirementCategories__Group__4 : rule__RequirementCategories__Group__4__Impl ;
    public final void rule__RequirementCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:461:1: ( rule__RequirementCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:462:2: rule__RequirementCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__4904);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:468:1: rule__RequirementCategories__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__RequirementCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:472:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:473:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:473:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:474:1: RightSquareBracket
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__RequirementCategories__Group__4__Impl932); 
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


    // $ANTLR start "rule__MethodCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:497:1: rule__MethodCategories__Group__0 : rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1 ;
    public final void rule__MethodCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:501:1: ( rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:502:2: rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__0__Impl_in_rule__MethodCategories__Group__0973);
            rule__MethodCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__1_in_rule__MethodCategories__Group__0976);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:509:1: rule__MethodCategories__Group__0__Impl : ( Method ) ;
    public final void rule__MethodCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:513:1: ( ( Method ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:514:1: ( Method )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:514:1: ( Method )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:515:1: Method
            {
             before(grammarAccess.getMethodCategoriesAccess().getMethodKeyword_0()); 
            match(input,Method,FOLLOW_Method_in_rule__MethodCategories__Group__0__Impl1004); 
             after(grammarAccess.getMethodCategoriesAccess().getMethodKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__Group__0__Impl"


    // $ANTLR start "rule__MethodCategories__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:528:1: rule__MethodCategories__Group__1 : rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2 ;
    public final void rule__MethodCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:532:1: ( rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:533:2: rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__1__Impl_in_rule__MethodCategories__Group__11035);
            rule__MethodCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__2_in_rule__MethodCategories__Group__11038);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:540:1: rule__MethodCategories__Group__1__Impl : ( Categories ) ;
    public final void rule__MethodCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:544:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:545:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:545:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:546:1: Categories
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,Categories,FOLLOW_Categories_in_rule__MethodCategories__Group__1__Impl1066); 
             after(grammarAccess.getMethodCategoriesAccess().getCategoriesKeyword_1()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:559:1: rule__MethodCategories__Group__2 : rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3 ;
    public final void rule__MethodCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:563:1: ( rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:564:2: rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__2__Impl_in_rule__MethodCategories__Group__21097);
            rule__MethodCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__3_in_rule__MethodCategories__Group__21100);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:571:1: rule__MethodCategories__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__MethodCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:575:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:576:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:576:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:577:1: LeftSquareBracket
            {
             before(grammarAccess.getMethodCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__MethodCategories__Group__2__Impl1128); 
             after(grammarAccess.getMethodCategoriesAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:590:1: rule__MethodCategories__Group__3 : rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4 ;
    public final void rule__MethodCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:594:1: ( rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:595:2: rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__3__Impl_in_rule__MethodCategories__Group__31159);
            rule__MethodCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategories__Group__4_in_rule__MethodCategories__Group__31162);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:602:1: rule__MethodCategories__Group__3__Impl : ( ( ( rule__MethodCategories__CategoryAssignment_3 ) ) ( ( rule__MethodCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__MethodCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:606:1: ( ( ( ( rule__MethodCategories__CategoryAssignment_3 ) ) ( ( rule__MethodCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:607:1: ( ( ( rule__MethodCategories__CategoryAssignment_3 ) ) ( ( rule__MethodCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:607:1: ( ( ( rule__MethodCategories__CategoryAssignment_3 ) ) ( ( rule__MethodCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:608:1: ( ( rule__MethodCategories__CategoryAssignment_3 ) ) ( ( rule__MethodCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:608:1: ( ( rule__MethodCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:609:1: ( rule__MethodCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:610:1: ( rule__MethodCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:610:2: rule__MethodCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__MethodCategories__CategoryAssignment_3_in_rule__MethodCategories__Group__3__Impl1191);
            rule__MethodCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:613:1: ( ( rule__MethodCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:614:1: ( rule__MethodCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:615:1: ( rule__MethodCategories__CategoryAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:615:2: rule__MethodCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__MethodCategories__CategoryAssignment_3_in_rule__MethodCategories__Group__3__Impl1203);
            	    rule__MethodCategories__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_3()); 

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
    // $ANTLR end "rule__MethodCategories__Group__3__Impl"


    // $ANTLR start "rule__MethodCategories__Group__4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:626:1: rule__MethodCategories__Group__4 : rule__MethodCategories__Group__4__Impl ;
    public final void rule__MethodCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:630:1: ( rule__MethodCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:631:2: rule__MethodCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__MethodCategories__Group__4__Impl_in_rule__MethodCategories__Group__41236);
            rule__MethodCategories__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:637:1: rule__MethodCategories__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__MethodCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:641:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:642:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:642:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:643:1: RightSquareBracket
            {
             before(grammarAccess.getMethodCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__MethodCategories__Group__4__Impl1264); 
             after(grammarAccess.getMethodCategoriesAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__SelectionCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:666:1: rule__SelectionCategories__Group__0 : rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 ;
    public final void rule__SelectionCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:670:1: ( rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:671:2: rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__0__Impl_in_rule__SelectionCategories__Group__01305);
            rule__SelectionCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__1_in_rule__SelectionCategories__Group__01308);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:678:1: rule__SelectionCategories__Group__0__Impl : ( Selection ) ;
    public final void rule__SelectionCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:682:1: ( ( Selection ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:683:1: ( Selection )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:683:1: ( Selection )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:684:1: Selection
            {
             before(grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_0()); 
            match(input,Selection,FOLLOW_Selection_in_rule__SelectionCategories__Group__0__Impl1336); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:697:1: rule__SelectionCategories__Group__1 : rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 ;
    public final void rule__SelectionCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:701:1: ( rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:702:2: rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__1__Impl_in_rule__SelectionCategories__Group__11367);
            rule__SelectionCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__2_in_rule__SelectionCategories__Group__11370);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:709:1: rule__SelectionCategories__Group__1__Impl : ( Categories ) ;
    public final void rule__SelectionCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:713:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:714:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:714:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:715:1: Categories
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_1()); 
            match(input,Categories,FOLLOW_Categories_in_rule__SelectionCategories__Group__1__Impl1398); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:728:1: rule__SelectionCategories__Group__2 : rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 ;
    public final void rule__SelectionCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:732:1: ( rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:733:2: rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__2__Impl_in_rule__SelectionCategories__Group__21429);
            rule__SelectionCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__3_in_rule__SelectionCategories__Group__21432);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:740:1: rule__SelectionCategories__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__SelectionCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:744:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:745:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:745:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:746:1: LeftSquareBracket
            {
             before(grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__SelectionCategories__Group__2__Impl1460); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:759:1: rule__SelectionCategories__Group__3 : rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 ;
    public final void rule__SelectionCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:763:1: ( rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:764:2: rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__3__Impl_in_rule__SelectionCategories__Group__31491);
            rule__SelectionCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategories__Group__4_in_rule__SelectionCategories__Group__31494);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:771:1: rule__SelectionCategories__Group__3__Impl : ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) ) ;
    public final void rule__SelectionCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:775:1: ( ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:776:1: ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:776:1: ( ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:777:1: ( ( rule__SelectionCategories__CategoryAssignment_3 ) ) ( ( rule__SelectionCategories__CategoryAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:777:1: ( ( rule__SelectionCategories__CategoryAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:778:1: ( rule__SelectionCategories__CategoryAssignment_3 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:779:1: ( rule__SelectionCategories__CategoryAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:779:2: rule__SelectionCategories__CategoryAssignment_3
            {
            pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl1523);
            rule__SelectionCategories__CategoryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:782:1: ( ( rule__SelectionCategories__CategoryAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:783:1: ( rule__SelectionCategories__CategoryAssignment_3 )*
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:784:1: ( rule__SelectionCategories__CategoryAssignment_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:784:2: rule__SelectionCategories__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl1535);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:795:1: rule__SelectionCategories__Group__4 : rule__SelectionCategories__Group__4__Impl ;
    public final void rule__SelectionCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:799:1: ( rule__SelectionCategories__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:800:2: rule__SelectionCategories__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategories__Group__4__Impl_in_rule__SelectionCategories__Group__41568);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:806:1: rule__SelectionCategories__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__SelectionCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:810:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:811:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:811:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:812:1: RightSquareBracket
            {
             before(grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_4()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__SelectionCategories__Group__4__Impl1596); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:835:1: rule__RequirementCategory__Group__0 : rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 ;
    public final void rule__RequirementCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:839:1: ( rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:840:2: rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__01637);
            rule__RequirementCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__01640);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:847:1: rule__RequirementCategory__Group__0__Impl : ( ( rule__RequirementCategory__NameAssignment_0 ) ) ;
    public final void rule__RequirementCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:851:1: ( ( ( rule__RequirementCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:852:1: ( ( rule__RequirementCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:852:1: ( ( rule__RequirementCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:853:1: ( rule__RequirementCategory__NameAssignment_0 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:854:1: ( rule__RequirementCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:854:2: rule__RequirementCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__RequirementCategory__NameAssignment_0_in_rule__RequirementCategory__Group__0__Impl1667);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:864:1: rule__RequirementCategory__Group__1 : rule__RequirementCategory__Group__1__Impl ;
    public final void rule__RequirementCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:868:1: ( rule__RequirementCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:869:2: rule__RequirementCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__11697);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:875:1: rule__RequirementCategory__Group__1__Impl : ( ( rule__RequirementCategory__Group_1__0 )? ) ;
    public final void rule__RequirementCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:879:1: ( ( ( rule__RequirementCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:880:1: ( ( rule__RequirementCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:880:1: ( ( rule__RequirementCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:881:1: ( rule__RequirementCategory__Group_1__0 )?
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:882:1: ( rule__RequirementCategory__Group_1__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LeftCurlyBracket) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:882:2: rule__RequirementCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__RequirementCategory__Group_1__0_in_rule__RequirementCategory__Group__1__Impl1724);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:896:1: rule__RequirementCategory__Group_1__0 : rule__RequirementCategory__Group_1__0__Impl rule__RequirementCategory__Group_1__1 ;
    public final void rule__RequirementCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:900:1: ( rule__RequirementCategory__Group_1__0__Impl rule__RequirementCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:901:2: rule__RequirementCategory__Group_1__0__Impl rule__RequirementCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group_1__0__Impl_in_rule__RequirementCategory__Group_1__01759);
            rule__RequirementCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group_1__1_in_rule__RequirementCategory__Group_1__01762);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:908:1: rule__RequirementCategory__Group_1__0__Impl : ( LeftCurlyBracket ) ;
    public final void rule__RequirementCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:912:1: ( ( LeftCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:913:1: ( LeftCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:913:1: ( LeftCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:914:1: LeftCurlyBracket
            {
             before(grammarAccess.getRequirementCategoryAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,LeftCurlyBracket,FOLLOW_LeftCurlyBracket_in_rule__RequirementCategory__Group_1__0__Impl1790); 
             after(grammarAccess.getRequirementCategoryAccess().getLeftCurlyBracketKeyword_1_0()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:927:1: rule__RequirementCategory__Group_1__1 : rule__RequirementCategory__Group_1__1__Impl rule__RequirementCategory__Group_1__2 ;
    public final void rule__RequirementCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:931:1: ( rule__RequirementCategory__Group_1__1__Impl rule__RequirementCategory__Group_1__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:932:2: rule__RequirementCategory__Group_1__1__Impl rule__RequirementCategory__Group_1__2
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group_1__1__Impl_in_rule__RequirementCategory__Group_1__11821);
            rule__RequirementCategory__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequirementCategory__Group_1__2_in_rule__RequirementCategory__Group_1__11824);
            rule__RequirementCategory__Group_1__2();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:939:1: rule__RequirementCategory__Group_1__1__Impl : ( ( rule__RequirementCategory__SubCategoriesAssignment_1_1 )* ) ;
    public final void rule__RequirementCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:943:1: ( ( ( rule__RequirementCategory__SubCategoriesAssignment_1_1 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:944:1: ( ( rule__RequirementCategory__SubCategoriesAssignment_1_1 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:944:1: ( ( rule__RequirementCategory__SubCategoriesAssignment_1_1 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:945:1: ( rule__RequirementCategory__SubCategoriesAssignment_1_1 )*
            {
             before(grammarAccess.getRequirementCategoryAccess().getSubCategoriesAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:946:1: ( rule__RequirementCategory__SubCategoriesAssignment_1_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:946:2: rule__RequirementCategory__SubCategoriesAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_rule__RequirementCategory__SubCategoriesAssignment_1_1_in_rule__RequirementCategory__Group_1__1__Impl1851);
            	    rule__RequirementCategory__SubCategoriesAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRequirementCategoryAccess().getSubCategoriesAssignment_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__RequirementCategory__Group_1__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:956:1: rule__RequirementCategory__Group_1__2 : rule__RequirementCategory__Group_1__2__Impl ;
    public final void rule__RequirementCategory__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:960:1: ( rule__RequirementCategory__Group_1__2__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:961:2: rule__RequirementCategory__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__RequirementCategory__Group_1__2__Impl_in_rule__RequirementCategory__Group_1__21882);
            rule__RequirementCategory__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group_1__2"


    // $ANTLR start "rule__RequirementCategory__Group_1__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:967:1: rule__RequirementCategory__Group_1__2__Impl : ( RightCurlyBracket ) ;
    public final void rule__RequirementCategory__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:971:1: ( ( RightCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:972:1: ( RightCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:972:1: ( RightCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:973:1: RightCurlyBracket
            {
             before(grammarAccess.getRequirementCategoryAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,RightCurlyBracket,FOLLOW_RightCurlyBracket_in_rule__RequirementCategory__Group_1__2__Impl1910); 
             after(grammarAccess.getRequirementCategoryAccess().getRightCurlyBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__Group_1__2__Impl"


    // $ANTLR start "rule__MethodCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:992:1: rule__MethodCategory__Group__0 : rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1 ;
    public final void rule__MethodCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:996:1: ( rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:997:2: rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group__0__Impl_in_rule__MethodCategory__Group__01947);
            rule__MethodCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategory__Group__1_in_rule__MethodCategory__Group__01950);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1004:1: rule__MethodCategory__Group__0__Impl : ( ( rule__MethodCategory__NameAssignment_0 ) ) ;
    public final void rule__MethodCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1008:1: ( ( ( rule__MethodCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1009:1: ( ( rule__MethodCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1009:1: ( ( rule__MethodCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1010:1: ( rule__MethodCategory__NameAssignment_0 )
            {
             before(grammarAccess.getMethodCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1011:1: ( rule__MethodCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1011:2: rule__MethodCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__MethodCategory__NameAssignment_0_in_rule__MethodCategory__Group__0__Impl1977);
            rule__MethodCategory__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMethodCategoryAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__Group__0__Impl"


    // $ANTLR start "rule__MethodCategory__Group__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1021:1: rule__MethodCategory__Group__1 : rule__MethodCategory__Group__1__Impl ;
    public final void rule__MethodCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1025:1: ( rule__MethodCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1026:2: rule__MethodCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group__1__Impl_in_rule__MethodCategory__Group__12007);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1032:1: rule__MethodCategory__Group__1__Impl : ( ( rule__MethodCategory__Group_1__0 )? ) ;
    public final void rule__MethodCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1036:1: ( ( ( rule__MethodCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1037:1: ( ( rule__MethodCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1037:1: ( ( rule__MethodCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1038:1: ( rule__MethodCategory__Group_1__0 )?
            {
             before(grammarAccess.getMethodCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1039:1: ( rule__MethodCategory__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LeftCurlyBracket) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1039:2: rule__MethodCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__MethodCategory__Group_1__0_in_rule__MethodCategory__Group__1__Impl2034);
                    rule__MethodCategory__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMethodCategoryAccess().getGroup_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__MethodCategory__Group_1__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1053:1: rule__MethodCategory__Group_1__0 : rule__MethodCategory__Group_1__0__Impl rule__MethodCategory__Group_1__1 ;
    public final void rule__MethodCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1057:1: ( rule__MethodCategory__Group_1__0__Impl rule__MethodCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1058:2: rule__MethodCategory__Group_1__0__Impl rule__MethodCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group_1__0__Impl_in_rule__MethodCategory__Group_1__02069);
            rule__MethodCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategory__Group_1__1_in_rule__MethodCategory__Group_1__02072);
            rule__MethodCategory__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__Group_1__0"


    // $ANTLR start "rule__MethodCategory__Group_1__0__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1065:1: rule__MethodCategory__Group_1__0__Impl : ( LeftCurlyBracket ) ;
    public final void rule__MethodCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1069:1: ( ( LeftCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1070:1: ( LeftCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1070:1: ( LeftCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1071:1: LeftCurlyBracket
            {
             before(grammarAccess.getMethodCategoryAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,LeftCurlyBracket,FOLLOW_LeftCurlyBracket_in_rule__MethodCategory__Group_1__0__Impl2100); 
             after(grammarAccess.getMethodCategoryAccess().getLeftCurlyBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__Group_1__0__Impl"


    // $ANTLR start "rule__MethodCategory__Group_1__1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1084:1: rule__MethodCategory__Group_1__1 : rule__MethodCategory__Group_1__1__Impl rule__MethodCategory__Group_1__2 ;
    public final void rule__MethodCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1088:1: ( rule__MethodCategory__Group_1__1__Impl rule__MethodCategory__Group_1__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1089:2: rule__MethodCategory__Group_1__1__Impl rule__MethodCategory__Group_1__2
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group_1__1__Impl_in_rule__MethodCategory__Group_1__12131);
            rule__MethodCategory__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodCategory__Group_1__2_in_rule__MethodCategory__Group_1__12134);
            rule__MethodCategory__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__Group_1__1"


    // $ANTLR start "rule__MethodCategory__Group_1__1__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1096:1: rule__MethodCategory__Group_1__1__Impl : ( ( rule__MethodCategory__SubCategoriesAssignment_1_1 )* ) ;
    public final void rule__MethodCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1100:1: ( ( ( rule__MethodCategory__SubCategoriesAssignment_1_1 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1101:1: ( ( rule__MethodCategory__SubCategoriesAssignment_1_1 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1101:1: ( ( rule__MethodCategory__SubCategoriesAssignment_1_1 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1102:1: ( rule__MethodCategory__SubCategoriesAssignment_1_1 )*
            {
             before(grammarAccess.getMethodCategoryAccess().getSubCategoriesAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1103:1: ( rule__MethodCategory__SubCategoriesAssignment_1_1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1103:2: rule__MethodCategory__SubCategoriesAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_rule__MethodCategory__SubCategoriesAssignment_1_1_in_rule__MethodCategory__Group_1__1__Impl2161);
            	    rule__MethodCategory__SubCategoriesAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getMethodCategoryAccess().getSubCategoriesAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__Group_1__1__Impl"


    // $ANTLR start "rule__MethodCategory__Group_1__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1113:1: rule__MethodCategory__Group_1__2 : rule__MethodCategory__Group_1__2__Impl ;
    public final void rule__MethodCategory__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1117:1: ( rule__MethodCategory__Group_1__2__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1118:2: rule__MethodCategory__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__MethodCategory__Group_1__2__Impl_in_rule__MethodCategory__Group_1__22192);
            rule__MethodCategory__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__Group_1__2"


    // $ANTLR start "rule__MethodCategory__Group_1__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1124:1: rule__MethodCategory__Group_1__2__Impl : ( RightCurlyBracket ) ;
    public final void rule__MethodCategory__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1128:1: ( ( RightCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1129:1: ( RightCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1129:1: ( RightCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1130:1: RightCurlyBracket
            {
             before(grammarAccess.getMethodCategoryAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,RightCurlyBracket,FOLLOW_RightCurlyBracket_in_rule__MethodCategory__Group_1__2__Impl2220); 
             after(grammarAccess.getMethodCategoryAccess().getRightCurlyBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__Group_1__2__Impl"


    // $ANTLR start "rule__SelectionCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1149:1: rule__SelectionCategory__Group__0 : rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 ;
    public final void rule__SelectionCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1153:1: ( rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1154:2: rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__0__Impl_in_rule__SelectionCategory__Group__02257);
            rule__SelectionCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategory__Group__1_in_rule__SelectionCategory__Group__02260);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1161:1: rule__SelectionCategory__Group__0__Impl : ( ( rule__SelectionCategory__NameAssignment_0 ) ) ;
    public final void rule__SelectionCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1165:1: ( ( ( rule__SelectionCategory__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1166:1: ( ( rule__SelectionCategory__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1166:1: ( ( rule__SelectionCategory__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1167:1: ( rule__SelectionCategory__NameAssignment_0 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1168:1: ( rule__SelectionCategory__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1168:2: rule__SelectionCategory__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__SelectionCategory__NameAssignment_0_in_rule__SelectionCategory__Group__0__Impl2287);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1178:1: rule__SelectionCategory__Group__1 : rule__SelectionCategory__Group__1__Impl ;
    public final void rule__SelectionCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1182:1: ( rule__SelectionCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1183:2: rule__SelectionCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group__1__Impl_in_rule__SelectionCategory__Group__12317);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1189:1: rule__SelectionCategory__Group__1__Impl : ( ( rule__SelectionCategory__Group_1__0 )? ) ;
    public final void rule__SelectionCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1193:1: ( ( ( rule__SelectionCategory__Group_1__0 )? ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1194:1: ( ( rule__SelectionCategory__Group_1__0 )? )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1194:1: ( ( rule__SelectionCategory__Group_1__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1195:1: ( rule__SelectionCategory__Group_1__0 )?
            {
             before(grammarAccess.getSelectionCategoryAccess().getGroup_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1196:1: ( rule__SelectionCategory__Group_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LeftCurlyBracket) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1196:2: rule__SelectionCategory__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__SelectionCategory__Group_1__0_in_rule__SelectionCategory__Group__1__Impl2344);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1210:1: rule__SelectionCategory__Group_1__0 : rule__SelectionCategory__Group_1__0__Impl rule__SelectionCategory__Group_1__1 ;
    public final void rule__SelectionCategory__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1214:1: ( rule__SelectionCategory__Group_1__0__Impl rule__SelectionCategory__Group_1__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1215:2: rule__SelectionCategory__Group_1__0__Impl rule__SelectionCategory__Group_1__1
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group_1__0__Impl_in_rule__SelectionCategory__Group_1__02379);
            rule__SelectionCategory__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategory__Group_1__1_in_rule__SelectionCategory__Group_1__02382);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1222:1: rule__SelectionCategory__Group_1__0__Impl : ( LeftCurlyBracket ) ;
    public final void rule__SelectionCategory__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1226:1: ( ( LeftCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1227:1: ( LeftCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1227:1: ( LeftCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1228:1: LeftCurlyBracket
            {
             before(grammarAccess.getSelectionCategoryAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,LeftCurlyBracket,FOLLOW_LeftCurlyBracket_in_rule__SelectionCategory__Group_1__0__Impl2410); 
             after(grammarAccess.getSelectionCategoryAccess().getLeftCurlyBracketKeyword_1_0()); 

            }


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1241:1: rule__SelectionCategory__Group_1__1 : rule__SelectionCategory__Group_1__1__Impl rule__SelectionCategory__Group_1__2 ;
    public final void rule__SelectionCategory__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1245:1: ( rule__SelectionCategory__Group_1__1__Impl rule__SelectionCategory__Group_1__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1246:2: rule__SelectionCategory__Group_1__1__Impl rule__SelectionCategory__Group_1__2
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group_1__1__Impl_in_rule__SelectionCategory__Group_1__12441);
            rule__SelectionCategory__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SelectionCategory__Group_1__2_in_rule__SelectionCategory__Group_1__12444);
            rule__SelectionCategory__Group_1__2();

            state._fsp--;


            }

        }
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1253:1: rule__SelectionCategory__Group_1__1__Impl : ( ( rule__SelectionCategory__SubCategoriesAssignment_1_1 )* ) ;
    public final void rule__SelectionCategory__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1257:1: ( ( ( rule__SelectionCategory__SubCategoriesAssignment_1_1 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1258:1: ( ( rule__SelectionCategory__SubCategoriesAssignment_1_1 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1258:1: ( ( rule__SelectionCategory__SubCategoriesAssignment_1_1 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1259:1: ( rule__SelectionCategory__SubCategoriesAssignment_1_1 )*
            {
             before(grammarAccess.getSelectionCategoryAccess().getSubCategoriesAssignment_1_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1260:1: ( rule__SelectionCategory__SubCategoriesAssignment_1_1 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1260:2: rule__SelectionCategory__SubCategoriesAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_rule__SelectionCategory__SubCategoriesAssignment_1_1_in_rule__SelectionCategory__Group_1__1__Impl2471);
            	    rule__SelectionCategory__SubCategoriesAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getSelectionCategoryAccess().getSubCategoriesAssignment_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__SelectionCategory__Group_1__2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1270:1: rule__SelectionCategory__Group_1__2 : rule__SelectionCategory__Group_1__2__Impl ;
    public final void rule__SelectionCategory__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1274:1: ( rule__SelectionCategory__Group_1__2__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1275:2: rule__SelectionCategory__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__SelectionCategory__Group_1__2__Impl_in_rule__SelectionCategory__Group_1__22502);
            rule__SelectionCategory__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__Group_1__2"


    // $ANTLR start "rule__SelectionCategory__Group_1__2__Impl"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1281:1: rule__SelectionCategory__Group_1__2__Impl : ( RightCurlyBracket ) ;
    public final void rule__SelectionCategory__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1285:1: ( ( RightCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1286:1: ( RightCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1286:1: ( RightCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1287:1: RightCurlyBracket
            {
             before(grammarAccess.getSelectionCategoryAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,RightCurlyBracket,FOLLOW_RightCurlyBracket_in_rule__SelectionCategory__Group_1__2__Impl2530); 
             after(grammarAccess.getSelectionCategoryAccess().getRightCurlyBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__Group_1__2__Impl"


    // $ANTLR start "rule__RequirementCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1307:1: rule__RequirementCategories__CategoryAssignment_3 : ( ruleRequirementCategory ) ;
    public final void rule__RequirementCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1311:1: ( ( ruleRequirementCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1312:1: ( ruleRequirementCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1312:1: ( ruleRequirementCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1313:1: ruleRequirementCategory
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_32572);
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


    // $ANTLR start "rule__MethodCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1322:1: rule__MethodCategories__CategoryAssignment_3 : ( ruleMethodCategory ) ;
    public final void rule__MethodCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1326:1: ( ( ruleMethodCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1327:1: ( ruleMethodCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1327:1: ( ruleMethodCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1328:1: ruleMethodCategory
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryMethodCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodCategory_in_rule__MethodCategories__CategoryAssignment_32603);
            ruleMethodCategory();

            state._fsp--;

             after(grammarAccess.getMethodCategoriesAccess().getCategoryMethodCategoryParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategories__CategoryAssignment_3"


    // $ANTLR start "rule__SelectionCategories__CategoryAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1337:1: rule__SelectionCategories__CategoryAssignment_3 : ( ruleSelectionCategory ) ;
    public final void rule__SelectionCategories__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1341:1: ( ( ruleSelectionCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1342:1: ( ruleSelectionCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1342:1: ( ruleSelectionCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1343:1: ruleSelectionCategory
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_rule__SelectionCategories__CategoryAssignment_32634);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1352:1: rule__RequirementCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__RequirementCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1356:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1357:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1357:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1358:1: RULE_ID
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_02665); 
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


    // $ANTLR start "rule__RequirementCategory__SubCategoriesAssignment_1_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1367:1: rule__RequirementCategory__SubCategoriesAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__RequirementCategory__SubCategoriesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1371:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1372:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1372:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1373:1: ( ruleCatRef )
            {
             before(grammarAccess.getRequirementCategoryAccess().getSubCategoriesRequirementCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1374:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1375:1: ruleCatRef
            {
             before(grammarAccess.getRequirementCategoryAccess().getSubCategoriesRequirementCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__RequirementCategory__SubCategoriesAssignment_1_12700);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getRequirementCategoryAccess().getSubCategoriesRequirementCategoryCatRefParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getRequirementCategoryAccess().getSubCategoriesRequirementCategoryCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequirementCategory__SubCategoriesAssignment_1_1"


    // $ANTLR start "rule__MethodCategory__NameAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1386:1: rule__MethodCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__MethodCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1390:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1391:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1391:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1392:1: RULE_ID
            {
             before(grammarAccess.getMethodCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MethodCategory__NameAssignment_02735); 
             after(grammarAccess.getMethodCategoryAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__NameAssignment_0"


    // $ANTLR start "rule__MethodCategory__SubCategoriesAssignment_1_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1401:1: rule__MethodCategory__SubCategoriesAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__MethodCategory__SubCategoriesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1405:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1406:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1406:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1407:1: ( ruleCatRef )
            {
             before(grammarAccess.getMethodCategoryAccess().getSubCategoriesMethodCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1408:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1409:1: ruleCatRef
            {
             before(grammarAccess.getMethodCategoryAccess().getSubCategoriesMethodCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__MethodCategory__SubCategoriesAssignment_1_12770);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getMethodCategoryAccess().getSubCategoriesMethodCategoryCatRefParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getMethodCategoryAccess().getSubCategoriesMethodCategoryCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCategory__SubCategoriesAssignment_1_1"


    // $ANTLR start "rule__SelectionCategory__NameAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1420:1: rule__SelectionCategory__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__SelectionCategory__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1424:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1425:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1425:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1426:1: RULE_ID
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectionCategory__NameAssignment_02805); 
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


    // $ANTLR start "rule__SelectionCategory__SubCategoriesAssignment_1_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1435:1: rule__SelectionCategory__SubCategoriesAssignment_1_1 : ( ( ruleCatRef ) ) ;
    public final void rule__SelectionCategory__SubCategoriesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1439:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1440:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1440:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1441:1: ( ruleCatRef )
            {
             before(grammarAccess.getSelectionCategoryAccess().getSubCategoriesSelectionCategoryCrossReference_1_1_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1442:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1443:1: ruleCatRef
            {
             before(grammarAccess.getSelectionCategoryAccess().getSubCategoriesSelectionCategoryCatRefParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_ruleCatRef_in_rule__SelectionCategory__SubCategoriesAssignment_1_12840);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getSelectionCategoryAccess().getSubCategoriesSelectionCategoryCatRefParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getSelectionCategoryAccess().getSubCategoriesSelectionCategoryCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelectionCategory__SubCategoriesAssignment_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategories_in_entryRuleCategories54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategories61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Categories__Alternatives_in_ruleCategories91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategories125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__0_in_ruleRequirementCategories155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategories_in_entryRuleMethodCategories182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodCategories189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__0_in_ruleMethodCategories219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategories253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__0_in_ruleSelectionCategories283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0_in_ruleRequirementCategory349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategory_in_entryRuleMethodCategory376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodCategory383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__0_in_ruleMethodCategory413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategory447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__0_in_ruleSelectionCategory477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_rule__Categories__Alternatives576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategories_in_rule__Categories__Alternatives593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_rule__Categories__Alternatives610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__0__Impl_in_rule__RequirementCategories__Group__0641 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1_in_rule__RequirementCategories__Group__0644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_rule__RequirementCategories__Group__0__Impl672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__1__Impl_in_rule__RequirementCategories__Group__1703 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2_in_rule__RequirementCategories__Group__1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__RequirementCategories__Group__1__Impl734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__2__Impl_in_rule__RequirementCategories__Group__2765 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3_in_rule__RequirementCategories__Group__2768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__RequirementCategories__Group__2__Impl796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__3__Impl_in_rule__RequirementCategories__Group__3827 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4_in_rule__RequirementCategories__Group__3830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl859 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__CategoryAssignment_3_in_rule__RequirementCategories__Group__3__Impl871 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__RequirementCategories__Group__4__Impl_in_rule__RequirementCategories__Group__4904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__RequirementCategories__Group__4__Impl932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__0__Impl_in_rule__MethodCategories__Group__0973 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__1_in_rule__MethodCategories__Group__0976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Method_in_rule__MethodCategories__Group__0__Impl1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__1__Impl_in_rule__MethodCategories__Group__11035 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__2_in_rule__MethodCategories__Group__11038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__MethodCategories__Group__1__Impl1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__2__Impl_in_rule__MethodCategories__Group__21097 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__3_in_rule__MethodCategories__Group__21100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__MethodCategories__Group__2__Impl1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__3__Impl_in_rule__MethodCategories__Group__31159 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__4_in_rule__MethodCategories__Group__31162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategories__CategoryAssignment_3_in_rule__MethodCategories__Group__3__Impl1191 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__MethodCategories__CategoryAssignment_3_in_rule__MethodCategories__Group__3__Impl1203 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__MethodCategories__Group__4__Impl_in_rule__MethodCategories__Group__41236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__MethodCategories__Group__4__Impl1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__0__Impl_in_rule__SelectionCategories__Group__01305 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__1_in_rule__SelectionCategories__Group__01308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Selection_in_rule__SelectionCategories__Group__0__Impl1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__1__Impl_in_rule__SelectionCategories__Group__11367 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__2_in_rule__SelectionCategories__Group__11370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__SelectionCategories__Group__1__Impl1398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__2__Impl_in_rule__SelectionCategories__Group__21429 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__3_in_rule__SelectionCategories__Group__21432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__SelectionCategories__Group__2__Impl1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__3__Impl_in_rule__SelectionCategories__Group__31491 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__4_in_rule__SelectionCategories__Group__31494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl1523 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__CategoryAssignment_3_in_rule__SelectionCategories__Group__3__Impl1535 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__4__Impl_in_rule__SelectionCategories__Group__41568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__SelectionCategories__Group__4__Impl1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__0__Impl_in_rule__RequirementCategory__Group__01637 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1_in_rule__RequirementCategory__Group__01640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__NameAssignment_0_in_rule__RequirementCategory__Group__0__Impl1667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group__1__Impl_in_rule__RequirementCategory__Group__11697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__0_in_rule__RequirementCategory__Group__1__Impl1724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__0__Impl_in_rule__RequirementCategory__Group_1__01759 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__1_in_rule__RequirementCategory__Group_1__01762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftCurlyBracket_in_rule__RequirementCategory__Group_1__0__Impl1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__1__Impl_in_rule__RequirementCategory__Group_1__11821 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__2_in_rule__RequirementCategory__Group_1__11824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__SubCategoriesAssignment_1_1_in_rule__RequirementCategory__Group_1__1__Impl1851 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__RequirementCategory__Group_1__2__Impl_in_rule__RequirementCategory__Group_1__21882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightCurlyBracket_in_rule__RequirementCategory__Group_1__2__Impl1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__0__Impl_in_rule__MethodCategory__Group__01947 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__1_in_rule__MethodCategory__Group__01950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__NameAssignment_0_in_rule__MethodCategory__Group__0__Impl1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group__1__Impl_in_rule__MethodCategory__Group__12007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group_1__0_in_rule__MethodCategory__Group__1__Impl2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group_1__0__Impl_in_rule__MethodCategory__Group_1__02069 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group_1__1_in_rule__MethodCategory__Group_1__02072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftCurlyBracket_in_rule__MethodCategory__Group_1__0__Impl2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group_1__1__Impl_in_rule__MethodCategory__Group_1__12131 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group_1__2_in_rule__MethodCategory__Group_1__12134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodCategory__SubCategoriesAssignment_1_1_in_rule__MethodCategory__Group_1__1__Impl2161 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__MethodCategory__Group_1__2__Impl_in_rule__MethodCategory__Group_1__22192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightCurlyBracket_in_rule__MethodCategory__Group_1__2__Impl2220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__0__Impl_in_rule__SelectionCategory__Group__02257 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__1_in_rule__SelectionCategory__Group__02260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__NameAssignment_0_in_rule__SelectionCategory__Group__0__Impl2287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group__1__Impl_in_rule__SelectionCategory__Group__12317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__0_in_rule__SelectionCategory__Group__1__Impl2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__0__Impl_in_rule__SelectionCategory__Group_1__02379 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__1_in_rule__SelectionCategory__Group_1__02382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftCurlyBracket_in_rule__SelectionCategory__Group_1__0__Impl2410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__1__Impl_in_rule__SelectionCategory__Group_1__12441 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__2_in_rule__SelectionCategory__Group_1__12444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__SubCategoriesAssignment_1_1_in_rule__SelectionCategory__Group_1__1__Impl2471 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__SelectionCategory__Group_1__2__Impl_in_rule__SelectionCategory__Group_1__22502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightCurlyBracket_in_rule__SelectionCategory__Group_1__2__Impl2530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_32572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategory_in_rule__MethodCategories__CategoryAssignment_32603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_rule__SelectionCategories__CategoryAssignment_32634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_02665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__RequirementCategory__SubCategoriesAssignment_1_12700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MethodCategory__NameAssignment_02735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__MethodCategory__SubCategoriesAssignment_1_12770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectionCategory__NameAssignment_02805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__SelectionCategory__SubCategoriesAssignment_1_12840 = new BitSet(new long[]{0x0000000000000002L});

}
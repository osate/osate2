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
public class InternalCategoriesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Requirement", "Categories", "Selection", "Category", "Filters", "Quality", "Method", "Phase", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Category=7;
    public static final int Phase=11;
    public static final int Selection=6;
    public static final int RULE_STRING=18;
    public static final int RULE_SL_COMMENT=20;
    public static final int Filters=8;
    public static final int Quality=9;
    public static final int RightCurlyBracket=15;
    public static final int EOF=-1;
    public static final int RightSquareBracket=13;
    public static final int RULE_ID=16;
    public static final int Categories=5;
    public static final int RULE_WS=21;
    public static final int LeftCurlyBracket=14;
    public static final int Method=10;
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
    		tokenNameToValue.put("Phase", "'phase'");
    		tokenNameToValue.put("Method", "'method'");
    		tokenNameToValue.put("Filters", "'filters'");
    		tokenNameToValue.put("Quality", "'quality'");
    		tokenNameToValue.put("Category", "'category'");
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:87:1: entryRuleCategoriesDefinitions : ruleCategoriesDefinitions EOF ;
    public final void entryRuleCategoriesDefinitions() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:88:1: ( ruleCategoriesDefinitions EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:89:1: ruleCategoriesDefinitions EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:96:1: ruleCategoriesDefinitions : ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) ;
    public final void ruleCategoriesDefinitions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:100:5: ( ( ( rule__CategoriesDefinitions__UnorderedGroup ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:101:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:101:1: ( ( rule__CategoriesDefinitions__UnorderedGroup ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:102:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:103:1: ( rule__CategoriesDefinitions__UnorderedGroup )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:103:2: rule__CategoriesDefinitions__UnorderedGroup
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:115:1: entryRuleRequirementCategories : ruleRequirementCategories EOF ;
    public final void entryRuleRequirementCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:116:1: ( ruleRequirementCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:117:1: ruleRequirementCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:124:1: ruleRequirementCategories : ( ( rule__RequirementCategories__Group__0 ) ) ;
    public final void ruleRequirementCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:128:5: ( ( ( rule__RequirementCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:129:1: ( ( rule__RequirementCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:129:1: ( ( rule__RequirementCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:130:1: ( rule__RequirementCategories__Group__0 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:131:1: ( rule__RequirementCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:131:2: rule__RequirementCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:143:1: entryRuleMethodCategories : ruleMethodCategories EOF ;
    public final void entryRuleMethodCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:144:1: ( ruleMethodCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:145:1: ruleMethodCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:152:1: ruleMethodCategories : ( ( rule__MethodCategories__Group__0 ) ) ;
    public final void ruleMethodCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:156:5: ( ( ( rule__MethodCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:157:1: ( ( rule__MethodCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:157:1: ( ( rule__MethodCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:158:1: ( rule__MethodCategories__Group__0 )
            {
             before(grammarAccess.getMethodCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:159:1: ( rule__MethodCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:159:2: rule__MethodCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:171:1: entryRuleSelectionCategories : ruleSelectionCategories EOF ;
    public final void entryRuleSelectionCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:172:1: ( ruleSelectionCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:173:1: ruleSelectionCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:180:1: ruleSelectionCategories : ( ( rule__SelectionCategories__Group__0 ) ) ;
    public final void ruleSelectionCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:184:5: ( ( ( rule__SelectionCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:185:1: ( ( rule__SelectionCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:185:1: ( ( rule__SelectionCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:186:1: ( rule__SelectionCategories__Group__0 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:187:1: ( rule__SelectionCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:187:2: rule__SelectionCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:199:1: entryRuleQualityCategories : ruleQualityCategories EOF ;
    public final void entryRuleQualityCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:200:1: ( ruleQualityCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:201:1: ruleQualityCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:208:1: ruleQualityCategories : ( ( rule__QualityCategories__Group__0 ) ) ;
    public final void ruleQualityCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:212:5: ( ( ( rule__QualityCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:213:1: ( ( rule__QualityCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:213:1: ( ( rule__QualityCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:214:1: ( rule__QualityCategories__Group__0 )
            {
             before(grammarAccess.getQualityCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:215:1: ( rule__QualityCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:215:2: rule__QualityCategories__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:227:1: entryRulePhaseCategories : rulePhaseCategories EOF ;
    public final void entryRulePhaseCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:228:1: ( rulePhaseCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:229:1: rulePhaseCategories EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:236:1: rulePhaseCategories : ( ( rule__PhaseCategories__Group__0 ) ) ;
    public final void rulePhaseCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:240:5: ( ( ( rule__PhaseCategories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:241:1: ( ( rule__PhaseCategories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:241:1: ( ( rule__PhaseCategories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:242:1: ( rule__PhaseCategories__Group__0 )
            {
             before(grammarAccess.getPhaseCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:243:1: ( rule__PhaseCategories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:243:2: rule__PhaseCategories__Group__0
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


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:255:1: entryRuleRequirementCategory : ruleRequirementCategory EOF ;
    public final void entryRuleRequirementCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:256:1: ( ruleRequirementCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:257:1: ruleRequirementCategory EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:264:1: ruleRequirementCategory : ( ( rule__RequirementCategory__Group__0 ) ) ;
    public final void ruleRequirementCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:268:5: ( ( ( rule__RequirementCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:269:1: ( ( rule__RequirementCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:269:1: ( ( rule__RequirementCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:270:1: ( rule__RequirementCategory__Group__0 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:271:1: ( rule__RequirementCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:271:2: rule__RequirementCategory__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:283:1: entryRuleMethodCategory : ruleMethodCategory EOF ;
    public final void entryRuleMethodCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:284:1: ( ruleMethodCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:285:1: ruleMethodCategory EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:292:1: ruleMethodCategory : ( ( rule__MethodCategory__Group__0 ) ) ;
    public final void ruleMethodCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:296:5: ( ( ( rule__MethodCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:297:1: ( ( rule__MethodCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:297:1: ( ( rule__MethodCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:298:1: ( rule__MethodCategory__Group__0 )
            {
             before(grammarAccess.getMethodCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:299:1: ( rule__MethodCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:299:2: rule__MethodCategory__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:311:1: entryRuleSelectionCategory : ruleSelectionCategory EOF ;
    public final void entryRuleSelectionCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:312:1: ( ruleSelectionCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:313:1: ruleSelectionCategory EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:320:1: ruleSelectionCategory : ( ( rule__SelectionCategory__Group__0 ) ) ;
    public final void ruleSelectionCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:324:5: ( ( ( rule__SelectionCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:325:1: ( ( rule__SelectionCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:325:1: ( ( rule__SelectionCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:326:1: ( rule__SelectionCategory__Group__0 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:327:1: ( rule__SelectionCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:327:2: rule__SelectionCategory__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:339:1: entryRuleQualityCategory : ruleQualityCategory EOF ;
    public final void entryRuleQualityCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:340:1: ( ruleQualityCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:341:1: ruleQualityCategory EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:348:1: ruleQualityCategory : ( ( rule__QualityCategory__Group__0 ) ) ;
    public final void ruleQualityCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:352:5: ( ( ( rule__QualityCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:353:1: ( ( rule__QualityCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:353:1: ( ( rule__QualityCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:354:1: ( rule__QualityCategory__Group__0 )
            {
             before(grammarAccess.getQualityCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:355:1: ( rule__QualityCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:355:2: rule__QualityCategory__Group__0
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


    // $ANTLR start "entryRulePhaseCategory"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:367:1: entryRulePhaseCategory : rulePhaseCategory EOF ;
    public final void entryRulePhaseCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:368:1: ( rulePhaseCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:369:1: rulePhaseCategory EOF
            {
             before(grammarAccess.getPhaseCategoryRule()); 
            pushFollow(FOLLOW_rulePhaseCategory_in_entryRulePhaseCategory694);
            rulePhaseCategory();

            state._fsp--;

             after(grammarAccess.getPhaseCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhaseCategory701); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:376:1: rulePhaseCategory : ( ( rule__PhaseCategory__Group__0 ) ) ;
    public final void rulePhaseCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:380:5: ( ( ( rule__PhaseCategory__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:381:1: ( ( rule__PhaseCategory__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:381:1: ( ( rule__PhaseCategory__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:382:1: ( rule__PhaseCategory__Group__0 )
            {
             before(grammarAccess.getPhaseCategoryAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:383:1: ( rule__PhaseCategory__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:383:2: rule__PhaseCategory__Group__0
            {
            pushFollow(FOLLOW_rule__PhaseCategory__Group__0_in_rulePhaseCategory731);
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


    // $ANTLR start "entryRuleCategoryFilters"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:395:1: entryRuleCategoryFilters : ruleCategoryFilters EOF ;
    public final void entryRuleCategoryFilters() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:396:1: ( ruleCategoryFilters EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:397:1: ruleCategoryFilters EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:404:1: ruleCategoryFilters : ( ( rule__CategoryFilters__Group__0 ) ) ;
    public final void ruleCategoryFilters() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:408:5: ( ( ( rule__CategoryFilters__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:409:1: ( ( rule__CategoryFilters__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:409:1: ( ( rule__CategoryFilters__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:410:1: ( rule__CategoryFilters__Group__0 )
            {
             before(grammarAccess.getCategoryFiltersAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:411:1: ( rule__CategoryFilters__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:411:2: rule__CategoryFilters__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:423:1: entryRuleCategorySet : ruleCategorySet EOF ;
    public final void entryRuleCategorySet() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:424:1: ( ruleCategorySet EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:425:1: ruleCategorySet EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:432:1: ruleCategorySet : ( ( rule__CategorySet__Group__0 ) ) ;
    public final void ruleCategorySet() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:436:5: ( ( ( rule__CategorySet__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:437:1: ( ( rule__CategorySet__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:437:1: ( ( rule__CategorySet__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:438:1: ( rule__CategorySet__Group__0 )
            {
             before(grammarAccess.getCategorySetAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:439:1: ( rule__CategorySet__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:439:2: rule__CategorySet__Group__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:451:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:452:1: ( ruleCatRef EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:453:1: ruleCatRef EOF
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:460:1: ruleCatRef : ( RULE_ID ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:464:5: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:465:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:465:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:466:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:481:1: rule__RequirementCategories__Group__0 : rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 ;
    public final void rule__RequirementCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:485:1: ( rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:486:2: rule__RequirementCategories__Group__0__Impl rule__RequirementCategories__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:493:1: rule__RequirementCategories__Group__0__Impl : ( () ) ;
    public final void rule__RequirementCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:497:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:498:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:498:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:499:1: ()
            {
             before(grammarAccess.getRequirementCategoriesAccess().getRequirementCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:500:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:502:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:512:1: rule__RequirementCategories__Group__1 : rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 ;
    public final void rule__RequirementCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:516:1: ( rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:517:2: rule__RequirementCategories__Group__1__Impl rule__RequirementCategories__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:524:1: rule__RequirementCategories__Group__1__Impl : ( Requirement ) ;
    public final void rule__RequirementCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:528:1: ( ( Requirement ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:529:1: ( Requirement )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:529:1: ( Requirement )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:530:1: Requirement
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:543:1: rule__RequirementCategories__Group__2 : rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 ;
    public final void rule__RequirementCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:547:1: ( rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:548:2: rule__RequirementCategories__Group__2__Impl rule__RequirementCategories__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:555:1: rule__RequirementCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__RequirementCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:559:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:560:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:560:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:561:1: Categories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:574:1: rule__RequirementCategories__Group__3 : rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 ;
    public final void rule__RequirementCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:578:1: ( rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:579:2: rule__RequirementCategories__Group__3__Impl rule__RequirementCategories__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:586:1: rule__RequirementCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__RequirementCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:590:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:591:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:591:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:592:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:605:1: rule__RequirementCategories__Group__4 : rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5 ;
    public final void rule__RequirementCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:609:1: ( rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:610:2: rule__RequirementCategories__Group__4__Impl rule__RequirementCategories__Group__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:617:1: rule__RequirementCategories__Group__4__Impl : ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__RequirementCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:621:1: ( ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:622:1: ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:622:1: ( ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:623:1: ( ( rule__RequirementCategories__CategoryAssignment_4 ) ) ( ( rule__RequirementCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:623:1: ( ( rule__RequirementCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:624:1: ( rule__RequirementCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:625:1: ( rule__RequirementCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:625:2: rule__RequirementCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__RequirementCategories__CategoryAssignment_4_in_rule__RequirementCategories__Group__4__Impl1235);
            rule__RequirementCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:628:1: ( ( rule__RequirementCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:629:1: ( rule__RequirementCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getRequirementCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:630:1: ( rule__RequirementCategories__CategoryAssignment_4 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:630:2: rule__RequirementCategories__CategoryAssignment_4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:641:1: rule__RequirementCategories__Group__5 : rule__RequirementCategories__Group__5__Impl ;
    public final void rule__RequirementCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:645:1: ( rule__RequirementCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:646:2: rule__RequirementCategories__Group__5__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:652:1: rule__RequirementCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__RequirementCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:656:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:657:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:657:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:658:1: RightSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:683:1: rule__MethodCategories__Group__0 : rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1 ;
    public final void rule__MethodCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:687:1: ( rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:688:2: rule__MethodCategories__Group__0__Impl rule__MethodCategories__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:695:1: rule__MethodCategories__Group__0__Impl : ( () ) ;
    public final void rule__MethodCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:699:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:700:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:700:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:701:1: ()
            {
             before(grammarAccess.getMethodCategoriesAccess().getMethodCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:702:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:704:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:714:1: rule__MethodCategories__Group__1 : rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2 ;
    public final void rule__MethodCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:718:1: ( rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:719:2: rule__MethodCategories__Group__1__Impl rule__MethodCategories__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:726:1: rule__MethodCategories__Group__1__Impl : ( Method ) ;
    public final void rule__MethodCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:730:1: ( ( Method ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:731:1: ( Method )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:731:1: ( Method )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:732:1: Method
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:745:1: rule__MethodCategories__Group__2 : rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3 ;
    public final void rule__MethodCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:749:1: ( rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:750:2: rule__MethodCategories__Group__2__Impl rule__MethodCategories__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:757:1: rule__MethodCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__MethodCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:761:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:762:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:762:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:763:1: Categories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:776:1: rule__MethodCategories__Group__3 : rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4 ;
    public final void rule__MethodCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:780:1: ( rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:781:2: rule__MethodCategories__Group__3__Impl rule__MethodCategories__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:788:1: rule__MethodCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__MethodCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:792:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:793:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:793:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:794:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:807:1: rule__MethodCategories__Group__4 : rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5 ;
    public final void rule__MethodCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:811:1: ( rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:812:2: rule__MethodCategories__Group__4__Impl rule__MethodCategories__Group__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:819:1: rule__MethodCategories__Group__4__Impl : ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__MethodCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:823:1: ( ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:824:1: ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:824:1: ( ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:825:1: ( ( rule__MethodCategories__CategoryAssignment_4 ) ) ( ( rule__MethodCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:825:1: ( ( rule__MethodCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:826:1: ( rule__MethodCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:827:1: ( rule__MethodCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:827:2: rule__MethodCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__MethodCategories__CategoryAssignment_4_in_rule__MethodCategories__Group__4__Impl1630);
            rule__MethodCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:830:1: ( ( rule__MethodCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:831:1: ( rule__MethodCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getMethodCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:832:1: ( rule__MethodCategories__CategoryAssignment_4 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:832:2: rule__MethodCategories__CategoryAssignment_4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:843:1: rule__MethodCategories__Group__5 : rule__MethodCategories__Group__5__Impl ;
    public final void rule__MethodCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:847:1: ( rule__MethodCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:848:2: rule__MethodCategories__Group__5__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:854:1: rule__MethodCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__MethodCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:858:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:859:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:859:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:860:1: RightSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:885:1: rule__SelectionCategories__Group__0 : rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 ;
    public final void rule__SelectionCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:889:1: ( rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:890:2: rule__SelectionCategories__Group__0__Impl rule__SelectionCategories__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:897:1: rule__SelectionCategories__Group__0__Impl : ( () ) ;
    public final void rule__SelectionCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:901:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:902:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:902:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:903:1: ()
            {
             before(grammarAccess.getSelectionCategoriesAccess().getSelectionCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:904:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:906:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:916:1: rule__SelectionCategories__Group__1 : rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 ;
    public final void rule__SelectionCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:920:1: ( rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:921:2: rule__SelectionCategories__Group__1__Impl rule__SelectionCategories__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:928:1: rule__SelectionCategories__Group__1__Impl : ( Selection ) ;
    public final void rule__SelectionCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:932:1: ( ( Selection ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:933:1: ( Selection )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:933:1: ( Selection )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:934:1: Selection
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:947:1: rule__SelectionCategories__Group__2 : rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 ;
    public final void rule__SelectionCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:951:1: ( rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:952:2: rule__SelectionCategories__Group__2__Impl rule__SelectionCategories__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:959:1: rule__SelectionCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__SelectionCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:963:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:964:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:964:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:965:1: Categories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:978:1: rule__SelectionCategories__Group__3 : rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 ;
    public final void rule__SelectionCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:982:1: ( rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:983:2: rule__SelectionCategories__Group__3__Impl rule__SelectionCategories__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:990:1: rule__SelectionCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__SelectionCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:994:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:995:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:995:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:996:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1009:1: rule__SelectionCategories__Group__4 : rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5 ;
    public final void rule__SelectionCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1013:1: ( rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1014:2: rule__SelectionCategories__Group__4__Impl rule__SelectionCategories__Group__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1021:1: rule__SelectionCategories__Group__4__Impl : ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__SelectionCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1025:1: ( ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1026:1: ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1026:1: ( ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1027:1: ( ( rule__SelectionCategories__CategoryAssignment_4 ) ) ( ( rule__SelectionCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1027:1: ( ( rule__SelectionCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1028:1: ( rule__SelectionCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1029:1: ( rule__SelectionCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1029:2: rule__SelectionCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__SelectionCategories__CategoryAssignment_4_in_rule__SelectionCategories__Group__4__Impl2025);
            rule__SelectionCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1032:1: ( ( rule__SelectionCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1033:1: ( rule__SelectionCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getSelectionCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1034:1: ( rule__SelectionCategories__CategoryAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1034:2: rule__SelectionCategories__CategoryAssignment_4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1045:1: rule__SelectionCategories__Group__5 : rule__SelectionCategories__Group__5__Impl ;
    public final void rule__SelectionCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1049:1: ( rule__SelectionCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1050:2: rule__SelectionCategories__Group__5__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1056:1: rule__SelectionCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__SelectionCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1060:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1061:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1061:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1062:1: RightSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1087:1: rule__QualityCategories__Group__0 : rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1 ;
    public final void rule__QualityCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1091:1: ( rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1092:2: rule__QualityCategories__Group__0__Impl rule__QualityCategories__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1099:1: rule__QualityCategories__Group__0__Impl : ( () ) ;
    public final void rule__QualityCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1103:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1104:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1104:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1105:1: ()
            {
             before(grammarAccess.getQualityCategoriesAccess().getQualityCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1106:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1108:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1118:1: rule__QualityCategories__Group__1 : rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2 ;
    public final void rule__QualityCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1122:1: ( rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1123:2: rule__QualityCategories__Group__1__Impl rule__QualityCategories__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1130:1: rule__QualityCategories__Group__1__Impl : ( Quality ) ;
    public final void rule__QualityCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1134:1: ( ( Quality ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1135:1: ( Quality )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1135:1: ( Quality )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1136:1: Quality
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1149:1: rule__QualityCategories__Group__2 : rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3 ;
    public final void rule__QualityCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1153:1: ( rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1154:2: rule__QualityCategories__Group__2__Impl rule__QualityCategories__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1161:1: rule__QualityCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__QualityCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1165:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1166:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1166:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1167:1: Categories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1180:1: rule__QualityCategories__Group__3 : rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4 ;
    public final void rule__QualityCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1184:1: ( rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1185:2: rule__QualityCategories__Group__3__Impl rule__QualityCategories__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1192:1: rule__QualityCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__QualityCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1196:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1197:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1197:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1198:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1211:1: rule__QualityCategories__Group__4 : rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5 ;
    public final void rule__QualityCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1215:1: ( rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1216:2: rule__QualityCategories__Group__4__Impl rule__QualityCategories__Group__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1223:1: rule__QualityCategories__Group__4__Impl : ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__QualityCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1227:1: ( ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1228:1: ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1228:1: ( ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1229:1: ( ( rule__QualityCategories__CategoryAssignment_4 ) ) ( ( rule__QualityCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1229:1: ( ( rule__QualityCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1230:1: ( rule__QualityCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1231:1: ( rule__QualityCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1231:2: rule__QualityCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__QualityCategories__CategoryAssignment_4_in_rule__QualityCategories__Group__4__Impl2420);
            rule__QualityCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1234:1: ( ( rule__QualityCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1235:1: ( rule__QualityCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1236:1: ( rule__QualityCategories__CategoryAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1236:2: rule__QualityCategories__CategoryAssignment_4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1247:1: rule__QualityCategories__Group__5 : rule__QualityCategories__Group__5__Impl ;
    public final void rule__QualityCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1251:1: ( rule__QualityCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1252:2: rule__QualityCategories__Group__5__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1258:1: rule__QualityCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__QualityCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1262:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1263:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1263:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1264:1: RightSquareBracket
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


    // $ANTLR start "rule__PhaseCategories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1289:1: rule__PhaseCategories__Group__0 : rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1 ;
    public final void rule__PhaseCategories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1293:1: ( rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1294:2: rule__PhaseCategories__Group__0__Impl rule__PhaseCategories__Group__1
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__0__Impl_in_rule__PhaseCategories__Group__02536);
            rule__PhaseCategories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__1_in_rule__PhaseCategories__Group__02539);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1301:1: rule__PhaseCategories__Group__0__Impl : ( () ) ;
    public final void rule__PhaseCategories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1305:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1306:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1306:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1307:1: ()
            {
             before(grammarAccess.getPhaseCategoriesAccess().getQualityCategoriesAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1308:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1310:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1320:1: rule__PhaseCategories__Group__1 : rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2 ;
    public final void rule__PhaseCategories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1324:1: ( rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1325:2: rule__PhaseCategories__Group__1__Impl rule__PhaseCategories__Group__2
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__1__Impl_in_rule__PhaseCategories__Group__12597);
            rule__PhaseCategories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__2_in_rule__PhaseCategories__Group__12600);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1332:1: rule__PhaseCategories__Group__1__Impl : ( Phase ) ;
    public final void rule__PhaseCategories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1336:1: ( ( Phase ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1337:1: ( Phase )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1337:1: ( Phase )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1338:1: Phase
            {
             before(grammarAccess.getPhaseCategoriesAccess().getPhaseKeyword_1()); 
            match(input,Phase,FOLLOW_Phase_in_rule__PhaseCategories__Group__1__Impl2628); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1351:1: rule__PhaseCategories__Group__2 : rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3 ;
    public final void rule__PhaseCategories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1355:1: ( rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1356:2: rule__PhaseCategories__Group__2__Impl rule__PhaseCategories__Group__3
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__2__Impl_in_rule__PhaseCategories__Group__22659);
            rule__PhaseCategories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__3_in_rule__PhaseCategories__Group__22662);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1363:1: rule__PhaseCategories__Group__2__Impl : ( Categories ) ;
    public final void rule__PhaseCategories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1367:1: ( ( Categories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1368:1: ( Categories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1368:1: ( Categories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1369:1: Categories
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoriesKeyword_2()); 
            match(input,Categories,FOLLOW_Categories_in_rule__PhaseCategories__Group__2__Impl2690); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1382:1: rule__PhaseCategories__Group__3 : rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4 ;
    public final void rule__PhaseCategories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1386:1: ( rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1387:2: rule__PhaseCategories__Group__3__Impl rule__PhaseCategories__Group__4
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__3__Impl_in_rule__PhaseCategories__Group__32721);
            rule__PhaseCategories__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__4_in_rule__PhaseCategories__Group__32724);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1394:1: rule__PhaseCategories__Group__3__Impl : ( LeftSquareBracket ) ;
    public final void rule__PhaseCategories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1398:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1399:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1399:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1400:1: LeftSquareBracket
            {
             before(grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_3()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__PhaseCategories__Group__3__Impl2752); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1413:1: rule__PhaseCategories__Group__4 : rule__PhaseCategories__Group__4__Impl rule__PhaseCategories__Group__5 ;
    public final void rule__PhaseCategories__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1417:1: ( rule__PhaseCategories__Group__4__Impl rule__PhaseCategories__Group__5 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1418:2: rule__PhaseCategories__Group__4__Impl rule__PhaseCategories__Group__5
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__4__Impl_in_rule__PhaseCategories__Group__42783);
            rule__PhaseCategories__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategories__Group__5_in_rule__PhaseCategories__Group__42786);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1425:1: rule__PhaseCategories__Group__4__Impl : ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) ) ;
    public final void rule__PhaseCategories__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1429:1: ( ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1430:1: ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1430:1: ( ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1431:1: ( ( rule__PhaseCategories__CategoryAssignment_4 ) ) ( ( rule__PhaseCategories__CategoryAssignment_4 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1431:1: ( ( rule__PhaseCategories__CategoryAssignment_4 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1432:1: ( rule__PhaseCategories__CategoryAssignment_4 )
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1433:1: ( rule__PhaseCategories__CategoryAssignment_4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1433:2: rule__PhaseCategories__CategoryAssignment_4
            {
            pushFollow(FOLLOW_rule__PhaseCategories__CategoryAssignment_4_in_rule__PhaseCategories__Group__4__Impl2815);
            rule__PhaseCategories__CategoryAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1436:1: ( ( rule__PhaseCategories__CategoryAssignment_4 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1437:1: ( rule__PhaseCategories__CategoryAssignment_4 )*
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_4()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1438:1: ( rule__PhaseCategories__CategoryAssignment_4 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1438:2: rule__PhaseCategories__CategoryAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__PhaseCategories__CategoryAssignment_4_in_rule__PhaseCategories__Group__4__Impl2827);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1449:1: rule__PhaseCategories__Group__5 : rule__PhaseCategories__Group__5__Impl ;
    public final void rule__PhaseCategories__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1453:1: ( rule__PhaseCategories__Group__5__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1454:2: rule__PhaseCategories__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PhaseCategories__Group__5__Impl_in_rule__PhaseCategories__Group__52860);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1460:1: rule__PhaseCategories__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__PhaseCategories__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1464:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1465:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1465:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1466:1: RightSquareBracket
            {
             before(grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__PhaseCategories__Group__5__Impl2888); 
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


    // $ANTLR start "rule__RequirementCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1491:1: rule__RequirementCategory__Group__0 : rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 ;
    public final void rule__RequirementCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1495:1: ( rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1496:2: rule__RequirementCategory__Group__0__Impl rule__RequirementCategory__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1503:1: rule__RequirementCategory__Group__0__Impl : ( () ) ;
    public final void rule__RequirementCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1507:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1508:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1508:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1509:1: ()
            {
             before(grammarAccess.getRequirementCategoryAccess().getRequirementCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1510:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1512:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1522:1: rule__RequirementCategory__Group__1 : rule__RequirementCategory__Group__1__Impl ;
    public final void rule__RequirementCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1526:1: ( rule__RequirementCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1527:2: rule__RequirementCategory__Group__1__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1533:1: rule__RequirementCategory__Group__1__Impl : ( ( rule__RequirementCategory__NameAssignment_1 ) ) ;
    public final void rule__RequirementCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1537:1: ( ( ( rule__RequirementCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1538:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1538:1: ( ( rule__RequirementCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1539:1: ( rule__RequirementCategory__NameAssignment_1 )
            {
             before(grammarAccess.getRequirementCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1540:1: ( rule__RequirementCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1540:2: rule__RequirementCategory__NameAssignment_1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1554:1: rule__MethodCategory__Group__0 : rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1 ;
    public final void rule__MethodCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1558:1: ( rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1559:2: rule__MethodCategory__Group__0__Impl rule__MethodCategory__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1566:1: rule__MethodCategory__Group__0__Impl : ( () ) ;
    public final void rule__MethodCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1570:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1571:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1571:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1572:1: ()
            {
             before(grammarAccess.getMethodCategoryAccess().getMethodCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1573:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1575:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1585:1: rule__MethodCategory__Group__1 : rule__MethodCategory__Group__1__Impl ;
    public final void rule__MethodCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1589:1: ( rule__MethodCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1590:2: rule__MethodCategory__Group__1__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1596:1: rule__MethodCategory__Group__1__Impl : ( ( rule__MethodCategory__NameAssignment_1 ) ) ;
    public final void rule__MethodCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1600:1: ( ( ( rule__MethodCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1601:1: ( ( rule__MethodCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1601:1: ( ( rule__MethodCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1602:1: ( rule__MethodCategory__NameAssignment_1 )
            {
             before(grammarAccess.getMethodCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1603:1: ( rule__MethodCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1603:2: rule__MethodCategory__NameAssignment_1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1617:1: rule__SelectionCategory__Group__0 : rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 ;
    public final void rule__SelectionCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1621:1: ( rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1622:2: rule__SelectionCategory__Group__0__Impl rule__SelectionCategory__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1629:1: rule__SelectionCategory__Group__0__Impl : ( () ) ;
    public final void rule__SelectionCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1633:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1634:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1634:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1635:1: ()
            {
             before(grammarAccess.getSelectionCategoryAccess().getSelectionCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1636:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1638:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1648:1: rule__SelectionCategory__Group__1 : rule__SelectionCategory__Group__1__Impl ;
    public final void rule__SelectionCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1652:1: ( rule__SelectionCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1653:2: rule__SelectionCategory__Group__1__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1659:1: rule__SelectionCategory__Group__1__Impl : ( ( rule__SelectionCategory__NameAssignment_1 ) ) ;
    public final void rule__SelectionCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1663:1: ( ( ( rule__SelectionCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1664:1: ( ( rule__SelectionCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1664:1: ( ( rule__SelectionCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1665:1: ( rule__SelectionCategory__NameAssignment_1 )
            {
             before(grammarAccess.getSelectionCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1666:1: ( rule__SelectionCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1666:2: rule__SelectionCategory__NameAssignment_1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1680:1: rule__QualityCategory__Group__0 : rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1 ;
    public final void rule__QualityCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1684:1: ( rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1685:2: rule__QualityCategory__Group__0__Impl rule__QualityCategory__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1692:1: rule__QualityCategory__Group__0__Impl : ( () ) ;
    public final void rule__QualityCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1696:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1697:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1697:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1698:1: ()
            {
             before(grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1699:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1701:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1711:1: rule__QualityCategory__Group__1 : rule__QualityCategory__Group__1__Impl ;
    public final void rule__QualityCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1715:1: ( rule__QualityCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1716:2: rule__QualityCategory__Group__1__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1722:1: rule__QualityCategory__Group__1__Impl : ( ( rule__QualityCategory__NameAssignment_1 ) ) ;
    public final void rule__QualityCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1726:1: ( ( ( rule__QualityCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1727:1: ( ( rule__QualityCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1727:1: ( ( rule__QualityCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1728:1: ( rule__QualityCategory__NameAssignment_1 )
            {
             before(grammarAccess.getQualityCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1729:1: ( rule__QualityCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1729:2: rule__QualityCategory__NameAssignment_1
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


    // $ANTLR start "rule__PhaseCategory__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1743:1: rule__PhaseCategory__Group__0 : rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1 ;
    public final void rule__PhaseCategory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1747:1: ( rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1748:2: rule__PhaseCategory__Group__0__Impl rule__PhaseCategory__Group__1
            {
            pushFollow(FOLLOW_rule__PhaseCategory__Group__0__Impl_in_rule__PhaseCategory__Group__03419);
            rule__PhaseCategory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PhaseCategory__Group__1_in_rule__PhaseCategory__Group__03422);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1755:1: rule__PhaseCategory__Group__0__Impl : ( () ) ;
    public final void rule__PhaseCategory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1759:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1760:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1760:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1761:1: ()
            {
             before(grammarAccess.getPhaseCategoryAccess().getPhaseCategoryAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1762:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1764:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1774:1: rule__PhaseCategory__Group__1 : rule__PhaseCategory__Group__1__Impl ;
    public final void rule__PhaseCategory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1778:1: ( rule__PhaseCategory__Group__1__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1779:2: rule__PhaseCategory__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PhaseCategory__Group__1__Impl_in_rule__PhaseCategory__Group__13480);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1785:1: rule__PhaseCategory__Group__1__Impl : ( ( rule__PhaseCategory__NameAssignment_1 ) ) ;
    public final void rule__PhaseCategory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1789:1: ( ( ( rule__PhaseCategory__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1790:1: ( ( rule__PhaseCategory__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1790:1: ( ( rule__PhaseCategory__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1791:1: ( rule__PhaseCategory__NameAssignment_1 )
            {
             before(grammarAccess.getPhaseCategoryAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1792:1: ( rule__PhaseCategory__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1792:2: rule__PhaseCategory__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PhaseCategory__NameAssignment_1_in_rule__PhaseCategory__Group__1__Impl3507);
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


    // $ANTLR start "rule__CategoryFilters__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1806:1: rule__CategoryFilters__Group__0 : rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1 ;
    public final void rule__CategoryFilters__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1810:1: ( rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1811:2: rule__CategoryFilters__Group__0__Impl rule__CategoryFilters__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1818:1: rule__CategoryFilters__Group__0__Impl : ( Category ) ;
    public final void rule__CategoryFilters__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1822:1: ( ( Category ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1823:1: ( Category )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1823:1: ( Category )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1824:1: Category
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1837:1: rule__CategoryFilters__Group__1 : rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2 ;
    public final void rule__CategoryFilters__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1841:1: ( rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1842:2: rule__CategoryFilters__Group__1__Impl rule__CategoryFilters__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1849:1: rule__CategoryFilters__Group__1__Impl : ( Filters ) ;
    public final void rule__CategoryFilters__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1853:1: ( ( Filters ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1854:1: ( Filters )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1854:1: ( Filters )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1855:1: Filters
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1868:1: rule__CategoryFilters__Group__2 : rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3 ;
    public final void rule__CategoryFilters__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1872:1: ( rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1873:2: rule__CategoryFilters__Group__2__Impl rule__CategoryFilters__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1880:1: rule__CategoryFilters__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__CategoryFilters__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1884:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1885:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1885:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1886:1: LeftSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1899:1: rule__CategoryFilters__Group__3 : rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4 ;
    public final void rule__CategoryFilters__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1903:1: ( rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1904:2: rule__CategoryFilters__Group__3__Impl rule__CategoryFilters__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1911:1: rule__CategoryFilters__Group__3__Impl : ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) ) ;
    public final void rule__CategoryFilters__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1915:1: ( ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1916:1: ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1916:1: ( ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1917:1: ( ( rule__CategoryFilters__FiltersAssignment_3 ) ) ( ( rule__CategoryFilters__FiltersAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1917:1: ( ( rule__CategoryFilters__FiltersAssignment_3 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1918:1: ( rule__CategoryFilters__FiltersAssignment_3 )
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1919:1: ( rule__CategoryFilters__FiltersAssignment_3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1919:2: rule__CategoryFilters__FiltersAssignment_3
            {
            pushFollow(FOLLOW_rule__CategoryFilters__FiltersAssignment_3_in_rule__CategoryFilters__Group__3__Impl3759);
            rule__CategoryFilters__FiltersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1922:1: ( ( rule__CategoryFilters__FiltersAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1923:1: ( rule__CategoryFilters__FiltersAssignment_3 )*
            {
             before(grammarAccess.getCategoryFiltersAccess().getFiltersAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1924:1: ( rule__CategoryFilters__FiltersAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1924:2: rule__CategoryFilters__FiltersAssignment_3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1935:1: rule__CategoryFilters__Group__4 : rule__CategoryFilters__Group__4__Impl ;
    public final void rule__CategoryFilters__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1939:1: ( rule__CategoryFilters__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1940:2: rule__CategoryFilters__Group__4__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1946:1: rule__CategoryFilters__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__CategoryFilters__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1950:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1951:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1951:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1952:1: RightSquareBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1975:1: rule__CategorySet__Group__0 : rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1 ;
    public final void rule__CategorySet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1979:1: ( rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1980:2: rule__CategorySet__Group__0__Impl rule__CategorySet__Group__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1987:1: rule__CategorySet__Group__0__Impl : ( () ) ;
    public final void rule__CategorySet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1991:1: ( ( () ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1992:1: ( () )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1992:1: ( () )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1993:1: ()
            {
             before(grammarAccess.getCategorySetAccess().getCategorySetAction_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1994:1: ()
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:1996:1: 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2006:1: rule__CategorySet__Group__1 : rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2 ;
    public final void rule__CategorySet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2010:1: ( rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2011:2: rule__CategorySet__Group__1__Impl rule__CategorySet__Group__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2018:1: rule__CategorySet__Group__1__Impl : ( ( rule__CategorySet__NameAssignment_1 ) ) ;
    public final void rule__CategorySet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2022:1: ( ( ( rule__CategorySet__NameAssignment_1 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2023:1: ( ( rule__CategorySet__NameAssignment_1 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2023:1: ( ( rule__CategorySet__NameAssignment_1 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2024:1: ( rule__CategorySet__NameAssignment_1 )
            {
             before(grammarAccess.getCategorySetAccess().getNameAssignment_1()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2025:1: ( rule__CategorySet__NameAssignment_1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2025:2: rule__CategorySet__NameAssignment_1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2035:1: rule__CategorySet__Group__2 : rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3 ;
    public final void rule__CategorySet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2039:1: ( rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2040:2: rule__CategorySet__Group__2__Impl rule__CategorySet__Group__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2047:1: rule__CategorySet__Group__2__Impl : ( LeftCurlyBracket ) ;
    public final void rule__CategorySet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2051:1: ( ( LeftCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2052:1: ( LeftCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2052:1: ( LeftCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2053:1: LeftCurlyBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2066:1: rule__CategorySet__Group__3 : rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4 ;
    public final void rule__CategorySet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2070:1: ( rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2071:2: rule__CategorySet__Group__3__Impl rule__CategorySet__Group__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2078:1: rule__CategorySet__Group__3__Impl : ( ( rule__CategorySet__ElementsAssignment_3 )* ) ;
    public final void rule__CategorySet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2082:1: ( ( ( rule__CategorySet__ElementsAssignment_3 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2083:1: ( ( rule__CategorySet__ElementsAssignment_3 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2083:1: ( ( rule__CategorySet__ElementsAssignment_3 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2084:1: ( rule__CategorySet__ElementsAssignment_3 )*
            {
             before(grammarAccess.getCategorySetAccess().getElementsAssignment_3()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2085:1: ( rule__CategorySet__ElementsAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2085:2: rule__CategorySet__ElementsAssignment_3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2095:1: rule__CategorySet__Group__4 : rule__CategorySet__Group__4__Impl ;
    public final void rule__CategorySet__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2099:1: ( rule__CategorySet__Group__4__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2100:2: rule__CategorySet__Group__4__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2106:1: rule__CategorySet__Group__4__Impl : ( RightCurlyBracket ) ;
    public final void rule__CategorySet__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2110:1: ( ( RightCurlyBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2111:1: ( RightCurlyBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2111:1: ( RightCurlyBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2112:1: RightCurlyBracket
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2136:1: rule__CategoriesDefinitions__UnorderedGroup : ( rule__CategoriesDefinitions__UnorderedGroup__0 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2141:1: ( ( rule__CategoriesDefinitions__UnorderedGroup__0 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2142:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2142:2: ( rule__CategoriesDefinitions__UnorderedGroup__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2142:2: rule__CategoriesDefinitions__UnorderedGroup__0
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2152:1: rule__CategoriesDefinitions__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) ) ) ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2157:1: ( ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2158:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2158:3: ( ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) ) | ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) ) )
            int alt9=6;
            int LA9_0 = input.LA(1);

            if ( LA9_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt9=2;
            }
            else if ( LA9_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt9=3;
            }
            else if ( LA9_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2160:4: ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2160:4: ({...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2161:5: {...}? => ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2161:116: ( ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2162:6: ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2168:6: ( ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2170:7: ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getRequirementcategoriesAssignment_0()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2171:7: ( rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2171:8: rule__CategoriesDefinitions__RequirementcategoriesAssignment_0
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2180:4: ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2180:4: ({...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2181:5: {...}? => ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2181:116: ( ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2182:6: ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2188:6: ( ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2190:7: ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesAssignment_1()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2191:7: ( rule__CategoriesDefinitions__MethodcategoriesAssignment_1 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2191:8: rule__CategoriesDefinitions__MethodcategoriesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__MethodcategoriesAssignment_1_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4372);
                    rule__CategoriesDefinitions__MethodcategoriesAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesAssignment_1()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2200:4: ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2200:4: ({...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2201:5: {...}? => ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2201:116: ( ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2202:6: ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2208:6: ( ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2210:7: ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesAssignment_2()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2211:7: ( rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2211:8: rule__CategoriesDefinitions__SelectioncategoriesAssignment_2
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__SelectioncategoriesAssignment_2_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4470);
                    rule__CategoriesDefinitions__SelectioncategoriesAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesAssignment_2()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2220:4: ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2220:4: ({...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2221:5: {...}? => ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2221:116: ( ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2222:6: ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2228:6: ( ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2230:7: ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesAssignment_3()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2231:7: ( rule__CategoriesDefinitions__PhasecategoriesAssignment_3 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2231:8: rule__CategoriesDefinitions__PhasecategoriesAssignment_3
                    {
                    pushFollow(FOLLOW_rule__CategoriesDefinitions__PhasecategoriesAssignment_3_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4568);
                    rule__CategoriesDefinitions__PhasecategoriesAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesAssignment_3()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2240:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2240:4: ({...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2241:5: {...}? => ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2241:116: ( ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2242:6: ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2248:6: ( ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2250:7: ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getQualitycategoriesAssignment_4()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2251:7: ( rule__CategoriesDefinitions__QualitycategoriesAssignment_4 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2251:8: rule__CategoriesDefinitions__QualitycategoriesAssignment_4
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2260:4: ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) )
                    {
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2260:4: ({...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2261:5: {...}? => ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5) ) {
                        throw new FailedPredicateException(input, "rule__CategoriesDefinitions__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5)");
                    }
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2261:116: ( ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2262:6: ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 5);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2268:6: ( ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 ) )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2270:7: ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 )
                    {
                     before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryfilterAssignment_5()); 
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2271:7: ( rule__CategoriesDefinitions__CategoryfilterAssignment_5 )
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2271:8: rule__CategoriesDefinitions__CategoryfilterAssignment_5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2289:1: rule__CategoriesDefinitions__UnorderedGroup__0 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2293:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2294:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__04830);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2295:2: ( rule__CategoriesDefinitions__UnorderedGroup__1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( LA10_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2295:2: rule__CategoriesDefinitions__UnorderedGroup__1
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2302:1: rule__CategoriesDefinitions__UnorderedGroup__1 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2306:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2307:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__14858);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2308:2: ( rule__CategoriesDefinitions__UnorderedGroup__2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( LA11_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2308:2: rule__CategoriesDefinitions__UnorderedGroup__2
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2315:1: rule__CategoriesDefinitions__UnorderedGroup__2 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2319:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2320:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__3 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__24886);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2321:2: ( rule__CategoriesDefinitions__UnorderedGroup__3 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( LA12_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2321:2: rule__CategoriesDefinitions__UnorderedGroup__3
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2328:1: rule__CategoriesDefinitions__UnorderedGroup__3 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2332:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2333:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__4 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__34914);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2334:2: ( rule__CategoriesDefinitions__UnorderedGroup__4 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( LA13_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt13=1;
            }
            else if ( LA13_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt13=1;
            }
            else if ( LA13_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt13=1;
            }
            else if ( LA13_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2334:2: rule__CategoriesDefinitions__UnorderedGroup__4
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2341:1: rule__CategoriesDefinitions__UnorderedGroup__4 : rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )? ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2345:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )? )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2346:2: rule__CategoriesDefinitions__UnorderedGroup__Impl ( rule__CategoriesDefinitions__UnorderedGroup__5 )?
            {
            pushFollow(FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__44942);
            rule__CategoriesDefinitions__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2347:2: ( rule__CategoriesDefinitions__UnorderedGroup__5 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( LA14_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                alt14=1;
            }
            else if ( LA14_0 ==Method && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                alt14=1;
            }
            else if ( LA14_0 ==Selection && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                alt14=1;
            }
            else if ( LA14_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 3) ) {
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
                    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2347:2: rule__CategoriesDefinitions__UnorderedGroup__5
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2354:1: rule__CategoriesDefinitions__UnorderedGroup__5 : rule__CategoriesDefinitions__UnorderedGroup__Impl ;
    public final void rule__CategoriesDefinitions__UnorderedGroup__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2358:1: ( rule__CategoriesDefinitions__UnorderedGroup__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2359:2: rule__CategoriesDefinitions__UnorderedGroup__Impl
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2378:1: rule__CategoriesDefinitions__RequirementcategoriesAssignment_0 : ( ruleRequirementCategories ) ;
    public final void rule__CategoriesDefinitions__RequirementcategoriesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2382:1: ( ( ruleRequirementCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2383:1: ( ruleRequirementCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2383:1: ( ruleRequirementCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2384:1: ruleRequirementCategories
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


    // $ANTLR start "rule__CategoriesDefinitions__MethodcategoriesAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2393:1: rule__CategoriesDefinitions__MethodcategoriesAssignment_1 : ( ruleMethodCategories ) ;
    public final void rule__CategoriesDefinitions__MethodcategoriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2397:1: ( ( ruleMethodCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2398:1: ( ruleMethodCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2398:1: ( ruleMethodCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2399:1: ruleMethodCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesMethodCategoriesParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMethodCategories_in_rule__CategoriesDefinitions__MethodcategoriesAssignment_15041);
            ruleMethodCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getMethodcategoriesMethodCategoriesParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__MethodcategoriesAssignment_1"


    // $ANTLR start "rule__CategoriesDefinitions__SelectioncategoriesAssignment_2"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2408:1: rule__CategoriesDefinitions__SelectioncategoriesAssignment_2 : ( ruleSelectionCategories ) ;
    public final void rule__CategoriesDefinitions__SelectioncategoriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2412:1: ( ( ruleSelectionCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2413:1: ( ruleSelectionCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2413:1: ( ruleSelectionCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2414:1: ruleSelectionCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesSelectionCategoriesParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSelectionCategories_in_rule__CategoriesDefinitions__SelectioncategoriesAssignment_25072);
            ruleSelectionCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesSelectionCategoriesParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__SelectioncategoriesAssignment_2"


    // $ANTLR start "rule__CategoriesDefinitions__PhasecategoriesAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2423:1: rule__CategoriesDefinitions__PhasecategoriesAssignment_3 : ( rulePhaseCategories ) ;
    public final void rule__CategoriesDefinitions__PhasecategoriesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2427:1: ( ( rulePhaseCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2428:1: ( rulePhaseCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2428:1: ( rulePhaseCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2429:1: rulePhaseCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesPhaseCategoriesParserRuleCall_3_0()); 
            pushFollow(FOLLOW_rulePhaseCategories_in_rule__CategoriesDefinitions__PhasecategoriesAssignment_35103);
            rulePhaseCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getPhasecategoriesPhaseCategoriesParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__PhasecategoriesAssignment_3"


    // $ANTLR start "rule__CategoriesDefinitions__QualitycategoriesAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2438:1: rule__CategoriesDefinitions__QualitycategoriesAssignment_4 : ( ruleQualityCategories ) ;
    public final void rule__CategoriesDefinitions__QualitycategoriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2442:1: ( ( ruleQualityCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2443:1: ( ruleQualityCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2443:1: ( ruleQualityCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2444:1: ruleQualityCategories
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2453:1: rule__CategoriesDefinitions__CategoryfilterAssignment_5 : ( ruleCategoryFilters ) ;
    public final void rule__CategoriesDefinitions__CategoryfilterAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2457:1: ( ( ruleCategoryFilters ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2458:1: ( ruleCategoryFilters )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2458:1: ( ruleCategoryFilters )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2459:1: ruleCategoryFilters
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2468:1: rule__RequirementCategories__CategoryAssignment_4 : ( ruleRequirementCategory ) ;
    public final void rule__RequirementCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2472:1: ( ( ruleRequirementCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2473:1: ( ruleRequirementCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2473:1: ( ruleRequirementCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2474:1: ruleRequirementCategory
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2483:1: rule__MethodCategories__CategoryAssignment_4 : ( ruleMethodCategory ) ;
    public final void rule__MethodCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2487:1: ( ( ruleMethodCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2488:1: ( ruleMethodCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2488:1: ( ruleMethodCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2489:1: ruleMethodCategory
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2498:1: rule__SelectionCategories__CategoryAssignment_4 : ( ruleSelectionCategory ) ;
    public final void rule__SelectionCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2502:1: ( ( ruleSelectionCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2503:1: ( ruleSelectionCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2503:1: ( ruleSelectionCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2504:1: ruleSelectionCategory
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2513:1: rule__QualityCategories__CategoryAssignment_4 : ( ruleQualityCategory ) ;
    public final void rule__QualityCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2517:1: ( ( ruleQualityCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2518:1: ( ruleQualityCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2518:1: ( ruleQualityCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2519:1: ruleQualityCategory
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


    // $ANTLR start "rule__PhaseCategories__CategoryAssignment_4"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2528:1: rule__PhaseCategories__CategoryAssignment_4 : ( rulePhaseCategory ) ;
    public final void rule__PhaseCategories__CategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2532:1: ( ( rulePhaseCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2533:1: ( rulePhaseCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2533:1: ( rulePhaseCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2534:1: rulePhaseCategory
            {
             before(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_rulePhaseCategory_in_rule__PhaseCategories__CategoryAssignment_45320);
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


    // $ANTLR start "rule__RequirementCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2543:1: rule__RequirementCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RequirementCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2547:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2548:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2548:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2549:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2558:1: rule__MethodCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__MethodCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2562:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2563:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2563:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2564:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2573:1: rule__SelectionCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SelectionCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2577:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2578:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2578:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2579:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2588:1: rule__QualityCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__QualityCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2592:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2593:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2593:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2594:1: RULE_ID
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


    // $ANTLR start "rule__PhaseCategory__NameAssignment_1"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2603:1: rule__PhaseCategory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PhaseCategory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2607:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2608:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2608:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2609:1: RULE_ID
            {
             before(grammarAccess.getPhaseCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PhaseCategory__NameAssignment_15475); 
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


    // $ANTLR start "rule__CategoryFilters__FiltersAssignment_3"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2618:1: rule__CategoryFilters__FiltersAssignment_3 : ( ruleCategorySet ) ;
    public final void rule__CategoryFilters__FiltersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2622:1: ( ( ruleCategorySet ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2623:1: ( ruleCategorySet )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2623:1: ( ruleCategorySet )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2624:1: ruleCategorySet
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2633:1: rule__CategorySet__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CategorySet__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2637:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2638:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2638:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2639:1: RULE_ID
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2648:1: rule__CategorySet__ElementsAssignment_3 : ( ( ruleCatRef ) ) ;
    public final void rule__CategorySet__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2652:1: ( ( ( ruleCatRef ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2653:1: ( ( ruleCatRef ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2653:1: ( ( ruleCatRef ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2654:1: ( ruleCatRef )
            {
             before(grammarAccess.getCategorySetAccess().getElementsCategoryCrossReference_3_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2655:1: ( ruleCatRef )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:2656:1: ruleCatRef
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
    public static final BitSet FOLLOW_rulePhaseCategories_in_entryRulePhaseCategories374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhaseCategories381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__0_in_rulePhaseCategories411 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rulePhaseCategory_in_entryRulePhaseCategory694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhaseCategory701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__0_in_rulePhaseCategory731 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__MethodCategories__Group__0__Impl_in_rule__MethodCategories__Group__01351 = new BitSet(new long[]{0x0000000000000400L});
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
    public static final BitSet FOLLOW_rule__SelectionCategories__Group__0__Impl_in_rule__SelectionCategories__Group__01746 = new BitSet(new long[]{0x0000000000000040L});
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
    public static final BitSet FOLLOW_rule__QualityCategories__Group__0__Impl_in_rule__QualityCategories__Group__02141 = new BitSet(new long[]{0x0000000000000200L});
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
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__0__Impl_in_rule__PhaseCategories__Group__02536 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__1_in_rule__PhaseCategories__Group__02539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__1__Impl_in_rule__PhaseCategories__Group__12597 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__2_in_rule__PhaseCategories__Group__12600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Phase_in_rule__PhaseCategories__Group__1__Impl2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__2__Impl_in_rule__PhaseCategories__Group__22659 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__3_in_rule__PhaseCategories__Group__22662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Categories_in_rule__PhaseCategories__Group__2__Impl2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__3__Impl_in_rule__PhaseCategories__Group__32721 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__4_in_rule__PhaseCategories__Group__32724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__PhaseCategories__Group__3__Impl2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__4__Impl_in_rule__PhaseCategories__Group__42783 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__5_in_rule__PhaseCategories__Group__42786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__CategoryAssignment_4_in_rule__PhaseCategories__Group__4__Impl2815 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__CategoryAssignment_4_in_rule__PhaseCategories__Group__4__Impl2827 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__PhaseCategories__Group__5__Impl_in_rule__PhaseCategories__Group__52860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__PhaseCategories__Group__5__Impl2888 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__0__Impl_in_rule__PhaseCategory__Group__03419 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__1_in_rule__PhaseCategory__Group__03422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategory__Group__1__Impl_in_rule__PhaseCategory__Group__13480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PhaseCategory__NameAssignment_1_in_rule__PhaseCategory__Group__1__Impl3507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoryFilters__Group__0__Impl_in_rule__CategoryFilters__Group__03541 = new BitSet(new long[]{0x0000000000000100L});
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
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__MethodcategoriesAssignment_1_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__SelectioncategoriesAssignment_2_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__PhasecategoriesAssignment_3_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__QualitycategoriesAssignment_4_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__CategoryfilterAssignment_5_in_rule__CategoriesDefinitions__UnorderedGroup__Impl4764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__04830 = new BitSet(new long[]{0x0000000000000ED2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__1_in_rule__CategoriesDefinitions__UnorderedGroup__04833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__14858 = new BitSet(new long[]{0x0000000000000ED2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__2_in_rule__CategoriesDefinitions__UnorderedGroup__14861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__24886 = new BitSet(new long[]{0x0000000000000ED2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__3_in_rule__CategoriesDefinitions__UnorderedGroup__24889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__34914 = new BitSet(new long[]{0x0000000000000ED2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__4_in_rule__CategoriesDefinitions__UnorderedGroup__34917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__44942 = new BitSet(new long[]{0x0000000000000ED2L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__5_in_rule__CategoriesDefinitions__UnorderedGroup__44945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__UnorderedGroup__Impl_in_rule__CategoriesDefinitions__UnorderedGroup__54970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_rule__CategoriesDefinitions__RequirementcategoriesAssignment_05010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategories_in_rule__CategoriesDefinitions__MethodcategoriesAssignment_15041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_rule__CategoriesDefinitions__SelectioncategoriesAssignment_25072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategories_in_rule__CategoriesDefinitions__PhasecategoriesAssignment_35103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategories_in_rule__CategoriesDefinitions__QualitycategoriesAssignment_45134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategoryFilters_in_rule__CategoriesDefinitions__CategoryfilterAssignment_55165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_rule__RequirementCategories__CategoryAssignment_45196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodCategory_in_rule__MethodCategories__CategoryAssignment_45227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_rule__SelectionCategories__CategoryAssignment_45258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategory_in_rule__QualityCategories__CategoryAssignment_45289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategory_in_rule__PhaseCategories__CategoryAssignment_45320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RequirementCategory__NameAssignment_15351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MethodCategory__NameAssignment_15382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectionCategory__NameAssignment_15413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualityCategory__NameAssignment_15444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PhaseCategory__NameAssignment_15475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategorySet_in_rule__CategoryFilters__FiltersAssignment_35506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CategorySet__NameAssignment_15537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_rule__CategorySet__ElementsAssignment_35572 = new BitSet(new long[]{0x0000000000000002L});

}
